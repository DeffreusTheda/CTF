package io.flutter.embedding.engine.renderer;

import D.AbstractC0002c;
import android.hardware.SyncFence;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import io.flutter.view.TextureRegistry$ImageConsumer;
import io.flutter.view.TextureRegistry$SurfaceProducer;
import io.flutter.view.p;
import io.flutter.view.q;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
final class FlutterRenderer$ImageReaderSurfaceProducer implements TextureRegistry$SurfaceProducer, TextureRegistry$ImageConsumer, p {
    private static final boolean CLEANUP_ON_MEMORY_PRESSURE = true;
    private static final int MAX_DEQUEUED_IMAGES = 2;
    private static final int MAX_IMAGES = 6;
    private static final String TAG = "ImageReaderSurfaceProducer";
    private static final boolean VERBOSE_LOGS = false;
    private static final boolean trimOnMemoryPressure = true;
    private q callback;
    private final long id;
    private boolean released;
    final /* synthetic */ j this$0;
    private boolean ignoringFence = VERBOSE_LOGS;
    private int requestedWidth = 1;
    private int requestedHeight = 1;
    private boolean createNewReader = true;
    private boolean notifiedDestroy = VERBOSE_LOGS;
    private long lastDequeueTime = 0;
    private long lastQueueTime = 0;
    private long lastScheduleTime = 0;
    private int numTrims = 0;
    private final Object lock = new Object();
    private final ArrayDeque<g> imageReaderQueue = new ArrayDeque<>();
    private final HashMap<ImageReader, g> perImageReaders = new HashMap<>();
    private ArrayList<e> lastDequeuedImage = new ArrayList<>();
    private g lastReaderDequeuedFrom = null;

    public FlutterRenderer$ImageReaderSurfaceProducer(j jVar, long j2) {
        this.this$0 = jVar;
        this.id = j2;
    }

    public static /* synthetic */ q access$200(FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer) {
        flutterRenderer$ImageReaderSurfaceProducer.getClass();
        return null;
    }

    private void cleanup() {
        synchronized (this.lock) {
            try {
                for (g gVar : this.perImageReaders.values()) {
                    if (this.lastReaderDequeuedFrom == gVar) {
                        this.lastReaderDequeuedFrom = null;
                    }
                    gVar.f606c = true;
                    gVar.f604a.close();
                    gVar.f605b.clear();
                }
                this.perImageReaders.clear();
                if (this.lastDequeuedImage.size() > 0) {
                    Iterator<e> it = this.lastDequeuedImage.iterator();
                    while (it.hasNext()) {
                        it.next().f601a.close();
                    }
                    this.lastDequeuedImage.clear();
                }
                g gVar2 = this.lastReaderDequeuedFrom;
                if (gVar2 != null) {
                    gVar2.f606c = true;
                    gVar2.f604a.close();
                    gVar2.f605b.clear();
                    this.lastReaderDequeuedFrom = null;
                }
                this.imageReaderQueue.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private ImageReader createImageReader() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            return createImageReader33();
        }
        if (i2 >= 29) {
            return createImageReader29();
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    private ImageReader createImageReader29() {
        ImageReader newInstance;
        newInstance = ImageReader.newInstance(this.requestedWidth, this.requestedHeight, 34, 6, 256L);
        return newInstance;
    }

    private ImageReader createImageReader33() {
        ImageReader build;
        AbstractC0002c.g();
        ImageReader.Builder c2 = AbstractC0002c.c(this.requestedWidth, this.requestedHeight);
        c2.setMaxImages(6);
        c2.setImageFormat(34);
        c2.setUsage(256L);
        build = c2.build();
        return build;
    }

    private g getActiveReader() {
        synchronized (this.lock) {
            try {
                if (!this.createNewReader) {
                    return this.imageReaderQueue.peekLast();
                }
                this.createNewReader = VERBOSE_LOGS;
                return getOrCreatePerImageReader(createImageReader());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$dequeueImage$0() {
        if (this.released) {
            return;
        }
        this.this$0.f627a.scheduleFrame();
    }

    private void maybeWaitOnFence(Image image) {
        if (image == null || this.ignoringFence) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            waitOnFence(image);
        } else {
            this.ignoringFence = true;
        }
    }

    private void releaseInternal() {
        cleanup();
        this.released = true;
        HashSet hashSet = this.this$0.f631e;
        Iterator it = hashSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference.get() == this) {
                hashSet.remove(weakReference);
                break;
            }
        }
        this.this$0.f632f.remove(this);
    }

    private void waitOnFence(Image image) {
        SyncFence fence;
        try {
            fence = image.getFence();
            fence.awaitForever();
        } catch (IOException unused) {
        }
    }

    @Override // io.flutter.view.TextureRegistry$ImageConsumer
    public Image acquireLatestImage() {
        e dequeueImage = dequeueImage();
        if (dequeueImage == null) {
            return null;
        }
        Image image = dequeueImage.f601a;
        maybeWaitOnFence(image);
        return image;
    }

    public double deltaMillis(long j2) {
        return j2 / 1000000.0d;
    }

    public e dequeueImage() {
        e eVar;
        boolean z2;
        synchronized (this.lock) {
            try {
                Iterator<g> it = this.imageReaderQueue.iterator();
                eVar = null;
                while (true) {
                    boolean hasNext = it.hasNext();
                    z2 = VERBOSE_LOGS;
                    if (!hasNext) {
                        break;
                    }
                    g next = it.next();
                    ArrayDeque arrayDeque = next.f605b;
                    e eVar2 = arrayDeque.isEmpty() ? null : (e) arrayDeque.removeFirst();
                    if (eVar2 == null) {
                        eVar = eVar2;
                    } else {
                        while (this.lastDequeuedImage.size() > MAX_DEQUEUED_IMAGES) {
                            this.lastDequeuedImage.remove(0).f601a.close();
                        }
                        this.lastDequeuedImage.add(eVar2);
                        this.lastReaderDequeuedFrom = next;
                        eVar = eVar2;
                    }
                }
                pruneImageReaderQueue();
                Iterator<g> it2 = this.imageReaderQueue.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!it2.next().f605b.isEmpty()) {
                        z2 = true;
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            this.this$0.f630d.post(new Runnable() { // from class: io.flutter.embedding.engine.renderer.d
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterRenderer$ImageReaderSurfaceProducer.this.lambda$dequeueImage$0();
                }
            });
        }
        return eVar;
    }

    public void disableFenceForTest() {
        this.ignoringFence = true;
    }

    public void finalize() {
        try {
            if (this.released) {
                return;
            }
            releaseInternal();
            j jVar = this.this$0;
            jVar.f630d.post(new h(this.id, jVar.f627a));
        } finally {
            super.finalize();
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public int getHeight() {
        return this.requestedHeight;
    }

    public g getOrCreatePerImageReader(ImageReader imageReader) {
        g gVar = this.perImageReaders.get(imageReader);
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, imageReader);
        this.perImageReaders.put(imageReader, gVar2);
        this.imageReaderQueue.add(gVar2);
        return gVar2;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public Surface getSurface() {
        return getActiveReader().f604a.getSurface();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public int getWidth() {
        return this.requestedWidth;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public boolean handlesCropAndRotation() {
        return VERBOSE_LOGS;
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public long id() {
        return this.id;
    }

    public int numImageReaders() {
        int size;
        synchronized (this.lock) {
            size = this.imageReaderQueue.size();
        }
        return size;
    }

    public int numImages() {
        int i2;
        synchronized (this.lock) {
            try {
                Iterator<g> it = this.imageReaderQueue.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    i2 += it.next().f605b.size();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return i2;
    }

    public int numTrims() {
        int i2;
        synchronized (this.lock) {
            i2 = this.numTrims;
        }
        return i2;
    }

    public void onImage(ImageReader imageReader, Image image) {
        e eVar;
        synchronized (this.lock) {
            g orCreatePerImageReader = getOrCreatePerImageReader(imageReader);
            if (orCreatePerImageReader.f606c) {
                eVar = null;
            } else {
                FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer = orCreatePerImageReader.f607d;
                System.nanoTime();
                e eVar2 = new e(flutterRenderer$ImageReaderSurfaceProducer, image);
                ArrayDeque arrayDeque = orCreatePerImageReader.f605b;
                arrayDeque.add(eVar2);
                while (arrayDeque.size() > MAX_DEQUEUED_IMAGES) {
                    ((e) arrayDeque.removeFirst()).f601a.close();
                }
                eVar = eVar2;
            }
        }
        if (eVar == null) {
            return;
        }
        this.this$0.f627a.scheduleFrame();
    }

    @Override // io.flutter.view.p
    public void onTrimMemory(int i2) {
        if (i2 < 40) {
            return;
        }
        synchronized (this.lock) {
            this.numTrims++;
        }
        cleanup();
        this.createNewReader = true;
    }

    public int pendingDequeuedImages() {
        return this.lastDequeuedImage.size();
    }

    public void pruneImageReaderQueue() {
        g peekFirst;
        while (this.imageReaderQueue.size() > 1 && (peekFirst = this.imageReaderQueue.peekFirst()) != null) {
            ArrayDeque arrayDeque = peekFirst.f605b;
            if (!arrayDeque.isEmpty() || peekFirst.f607d.lastReaderDequeuedFrom == peekFirst) {
                return;
            }
            this.imageReaderQueue.removeFirst();
            HashMap<ImageReader, g> hashMap = this.perImageReaders;
            ImageReader imageReader = peekFirst.f604a;
            hashMap.remove(imageReader);
            peekFirst.f606c = true;
            imageReader.close();
            arrayDeque.clear();
        }
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void release() {
        if (this.released) {
            return;
        }
        releaseInternal();
        j jVar = this.this$0;
        jVar.f627a.unregisterTexture(this.id);
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void scheduleFrame() {
        this.this$0.f627a.scheduleFrame();
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void setCallback(q qVar) {
    }

    @Override // io.flutter.view.TextureRegistry$SurfaceProducer
    public void setSize(int i2, int i3) {
        int max = Math.max(1, i2);
        int max2 = Math.max(1, i3);
        if (this.requestedWidth == max && this.requestedHeight == max2) {
            return;
        }
        this.createNewReader = true;
        this.requestedHeight = max2;
        this.requestedWidth = max;
    }
}
