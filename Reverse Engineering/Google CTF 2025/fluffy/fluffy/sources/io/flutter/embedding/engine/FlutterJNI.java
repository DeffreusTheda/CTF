package io.flutter.embedding.engine;

import B.c;
import D.AbstractC0010k;
import D.C0012m;
import D.x;
import D.y;
import E.b;
import E.k;
import E.l;
import F.g;
import F.h;
import G.a;
import L.d;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.util.SparseArray;
import android.view.AttachedSurfaceControl;
import android.view.Choreographer;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.platform.j;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.TextureRegistry$ImageConsumer;
import io.flutter.view.e;
import io.flutter.view.f;
import io.flutter.view.t;
import io.flutter.view.u;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes.dex */
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static l asyncWaitForVsyncDelegate = null;
    private static float displayDensity = -1.0f;
    private static float displayHeight = -1.0f;
    private static float displayWidth = -1.0f;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    private static String vmServiceUri;
    private k accessibilityDelegate;
    private a deferredComponentManager;
    private M.a localizationPlugin;
    private Long nativeShellHolderId;
    private h platformMessageHandler;
    private io.flutter.plugin.platform.k platformViewsController;
    private j platformViewsController2;
    private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();
    private final Set<b> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<io.flutter.embedding.engine.renderer.k> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private final Looper mainLooper = Looper.getMainLooper();

    private static void asyncWaitForVsync(long j2) {
        l lVar = asyncWaitForVsyncDelegate;
        if (lVar == null) {
            throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
        }
        io.flutter.view.b bVar = (io.flutter.view.b) lVar;
        bVar.getClass();
        Choreographer choreographer = Choreographer.getInstance();
        u uVar = (u) bVar.f747a;
        t tVar = uVar.f868c;
        if (tVar != null) {
            tVar.f862a = j2;
            uVar.f868c = null;
        } else {
            tVar = new t(uVar, j2);
        }
        choreographer.postFrameCallback(tVar);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [E.j] */
    public static Bitmap decodeImage(ByteBuffer byteBuffer, final long j2) {
        ImageDecoder.Source createSource;
        Bitmap decodeBitmap;
        if (Build.VERSION.SDK_INT >= 28) {
            createSource = ImageDecoder.createSource(byteBuffer);
            try {
                decodeBitmap = ImageDecoder.decodeBitmap(createSource, new ImageDecoder.OnHeaderDecodedListener() { // from class: E.j
                    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                        FlutterJNI.lambda$decodeImage$0(j2, imageDecoder, imageInfo, source);
                    }
                });
                return decodeBitmap;
            } catch (IOException e2) {
                Log.e(TAG, "Failed to decode image", e2);
            }
        }
        return null;
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    @Deprecated
    public static String getObservatoryUri() {
        return vmServiceUri;
    }

    public static String getVMServiceUri() {
        return vmServiceUri;
    }

    private void handlePlatformMessageResponse(int i2, ByteBuffer byteBuffer) {
        d dVar;
        h hVar = this.platformMessageHandler;
        if (hVar == null || (dVar = (d) ((g) hVar).f198g.remove(Integer.valueOf(i2))) == null) {
            return;
        }
        try {
            dVar.a(byteBuffer);
            if (byteBuffer == null || !byteBuffer.isDirect()) {
                return;
            }
            byteBuffer.limit(0);
        } catch (Error e2) {
            Thread currentThread = Thread.currentThread();
            if (currentThread.getUncaughtExceptionHandler() == null) {
                throw e2;
            }
            currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, e2);
        } catch (Exception e3) {
            Log.e("DartMessenger", "Uncaught exception in binary message reply handler", e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$decodeImage$0(long j2, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        ColorSpace.Named named;
        ColorSpace colorSpace;
        Size size;
        named = ColorSpace.Named.SRGB;
        colorSpace = ColorSpace.get(named);
        imageDecoder.setTargetColorSpace(colorSpace);
        imageDecoder.setAllocator(1);
        size = imageInfo.getSize();
        nativeImageHeaderCallback(j2, size.getWidth(), size.getHeight());
    }

    private native long nativeAttach(FlutterJNI flutterJNI);

    private native void nativeCleanupMessageData(long j2);

    private native void nativeDeferredComponentInstallFailure(int i2, String str, boolean z2);

    private native void nativeDestroy(long j2);

    private native void nativeDispatchEmptyPlatformMessage(long j2, String str, int i2);

    private native void nativeDispatchPlatformMessage(long j2, String str, ByteBuffer byteBuffer, int i2, int i3);

    private native void nativeDispatchPointerDataPacket(long j2, ByteBuffer byteBuffer, int i2);

    private native void nativeDispatchSemanticsAction(long j2, int i2, int i3, ByteBuffer byteBuffer, int i4);

    private native boolean nativeFlutterTextUtilsIsEmoji(int i2);

    private native boolean nativeFlutterTextUtilsIsEmojiModifier(int i2);

    private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i2);

    private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i2);

    private native boolean nativeFlutterTextUtilsIsVariationSelector(int i2);

    private native Bitmap nativeGetBitmap(long j2);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j2, int i2, int i3);

    private static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j2, int i2);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j2, int i2);

    private native void nativeInvokePlatformMessageResponseCallback(long j2, int i2, ByteBuffer byteBuffer, int i3);

    private native boolean nativeIsSurfaceControlEnabled(long j2);

    private native void nativeLoadDartDeferredLibrary(long j2, int i2, String[] strArr);

    @Deprecated
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j2);

    private native void nativeMarkTextureFrameAvailable(long j2, long j3);

    private native void nativeNotifyLowMemoryWarning(long j2);

    private native void nativeOnVsync(long j2, long j3, long j4);

    private static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterImageTexture(long j2, long j3, WeakReference<TextureRegistry$ImageConsumer> weakReference, boolean z2);

    private native void nativeRegisterTexture(long j2, long j3, WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j2, String str, String str2, String str3, AssetManager assetManager, List<String> list, long j3);

    private native void nativeScheduleFrame(long j2);

    private native void nativeSetAccessibilityFeatures(long j2, int i2);

    private native void nativeSetSemanticsEnabled(long j2, boolean z2);

    private native void nativeSetViewportMetrics(long j2, float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int[] iArr, int[] iArr2, int[] iArr3);

    private native FlutterJNI nativeSpawn(long j2, String str, String str2, String str3, List<String> list, long j3);

    private native void nativeSurfaceChanged(long j2, int i2, int i3);

    private native void nativeSurfaceCreated(long j2, Surface surface);

    private native void nativeSurfaceDestroyed(long j2);

    private native void nativeSurfaceWindowChanged(long j2, Surface surface);

    private native void nativeUnregisterTexture(long j2, long j3);

    private native void nativeUpdateDisplayMetrics(long j2);

    private native void nativeUpdateJavaAssetManager(long j2, AssetManager assetManager, String str);

    private native void nativeUpdateRefreshRate(float f2);

    private void onPreEngineRestart() {
        Iterator<b> it = this.engineLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    private void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        ensureRunningOnMainThread();
        k kVar = this.accessibilityDelegate;
        if (kVar != null) {
            io.flutter.view.b bVar = (io.flutter.view.b) kVar;
            bVar.getClass();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            io.flutter.view.l lVar = (io.flutter.view.l) bVar.f747a;
            lVar.getClass();
            while (byteBuffer.hasRemaining()) {
                f a2 = lVar.a(byteBuffer.getInt());
                a2.f775c = byteBuffer.getInt();
                int i2 = byteBuffer.getInt();
                String str = null;
                a2.f776d = i2 == -1 ? null : strArr[i2];
                int i3 = byteBuffer.getInt();
                if (i3 != -1) {
                    str = strArr[i3];
                }
                a2.f777e = str;
            }
        }
    }

    private void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        k kVar = this.accessibilityDelegate;
        if (kVar != null) {
            ((io.flutter.view.b) kVar).a(byteBuffer, strArr, byteBufferArr);
        }
    }

    public boolean IsSurfaceControlEnabled() {
        return nativeIsSurfaceControlEnabled(this.nativeShellHolderId.longValue());
    }

    public void addEngineLifecycleListener(b bVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(bVar);
    }

    public void addIsDisplayingFlutterUiListener(io.flutter.embedding.engine.renderer.k kVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(kVar);
    }

    public void applyTransactions() {
        j jVar = this.platformViewsController2;
        if (jVar == null) {
            throw new RuntimeException("");
        }
        SurfaceControl.Transaction h2 = AbstractC0010k.h();
        int i2 = 0;
        while (true) {
            ArrayList arrayList = jVar.f714i;
            if (i2 >= arrayList.size()) {
                h2.apply();
                arrayList.clear();
                return;
            } else {
                h2 = h2.merge(AbstractC0010k.j(arrayList.get(i2)));
                i2++;
            }
        }
    }

    public void attachToNative() {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this));
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void cleanupMessageData(long j2) {
        nativeCleanupMessageData(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0139, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0141, code lost:
    
        if (r4.hasNext() == false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0143, code lost:
    
        r5 = (java.util.Locale) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0155, code lost:
    
        if (r3.getLanguage().equals(r5.toLanguageTag()) == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0158, code lost:
    
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0160, code lost:
    
        if (r4.hasNext() == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0162, code lost:
    
        r5 = (java.util.Locale) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0174, code lost:
    
        if (r3.getLanguage().equals(r5.getLanguage()) == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0177, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a3, code lost:
    
        r10 = r3;
     */
    /* JADX WARN: Incorrect condition in loop: B:51:0x011a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String[] computePlatformResolvedLocale(java.lang.String[] r10) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.FlutterJNI.computePlatformResolvedLocale(java.lang.String[]):java.lang.String[]");
    }

    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        io.flutter.plugin.platform.k kVar = this.platformViewsController;
        if (kVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        io.flutter.plugin.platform.b bVar = new io.flutter.plugin.platform.b(kVar.f720c.getContext(), kVar.f720c.getWidth(), kVar.f720c.getHeight(), 2);
        bVar.f694g = kVar.f724g;
        int i2 = kVar.f730n;
        kVar.f730n = i2 + 1;
        kVar.f729l.put(i2, bVar);
        return new FlutterOverlaySurface(i2, bVar.getSurface());
    }

    public FlutterOverlaySurface createOverlaySurface2() {
        SurfaceControl build;
        AttachedSurfaceControl rootSurfaceControl;
        SurfaceControl.Transaction buildReparentTransaction;
        j jVar = this.platformViewsController2;
        if (jVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        if (jVar.f716k == null) {
            SurfaceControl.Builder g2 = AbstractC0010k.g();
            g2.setBufferSize(jVar.f708c.getWidth(), jVar.f708c.getHeight());
            g2.setFormat(1);
            g2.setName("Flutter Overlay Surface");
            g2.setOpaque(false);
            g2.setHidden(false);
            build = g2.build();
            rootSurfaceControl = jVar.f708c.getRootSurfaceControl();
            buildReparentTransaction = rootSurfaceControl.buildReparentTransaction(build);
            buildReparentTransaction.setLayer(build, 1000);
            buildReparentTransaction.apply();
            jVar.f716k = AbstractC0010k.f(build);
            jVar.f717l = build;
        }
        return new FlutterOverlaySurface(0, jVar.f716k);
    }

    public SurfaceControl.Transaction createTransaction() {
        j jVar = this.platformViewsController2;
        if (jVar == null) {
            throw new RuntimeException("");
        }
        SurfaceControl.Transaction h2 = AbstractC0010k.h();
        jVar.f714i.add(h2);
        return h2;
    }

    public void deferredComponentInstallFailure(int i2, String str, boolean z2) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i2, str, z2);
    }

    public void destroyOverlaySurface2() {
        ensureRunningOnMainThread();
        j jVar = this.platformViewsController2;
        if (jVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        Surface surface = jVar.f716k;
        if (surface != null) {
            surface.release();
            jVar.f716k = null;
            jVar.f717l = null;
        }
    }

    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        io.flutter.plugin.platform.k kVar = this.platformViewsController;
        if (kVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        kVar.e();
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void dispatchEmptyPlatformMessage(String str, int i2) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i2);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i2);
    }

    public void dispatchPlatformMessage(String str, ByteBuffer byteBuffer, int i2, int i3) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i2, i3);
            return;
        }
        Log.w(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i3);
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i2);
    }

    public void dispatchSemanticsAction(int i2, e eVar) {
        dispatchSemanticsAction(i2, eVar, null);
    }

    public void endFrame2() {
        AttachedSurfaceControl rootSurfaceControl;
        j jVar = this.platformViewsController2;
        if (jVar == null) {
            throw new RuntimeException("");
        }
        SurfaceControl.Transaction h2 = AbstractC0010k.h();
        int i2 = 0;
        while (true) {
            ArrayList arrayList = jVar.f715j;
            if (i2 >= arrayList.size()) {
                arrayList.clear();
                jVar.f708c.invalidate();
                rootSurfaceControl = jVar.f708c.getRootSurfaceControl();
                rootSurfaceControl.applyTransactionOnDraw(h2);
                return;
            }
            h2 = h2.merge(AbstractC0010k.j(arrayList.get(i2)));
            i2++;
        }
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public float getScaledFontSize(float r7, int r8) {
        /*
            r6 = this;
            B.e r0 = K.n.f275b
            java.lang.Object r1 = r0.f9b
            K.m r1 = (K.m) r1
            java.lang.Object r2 = r0.f8a
            java.util.concurrent.ConcurrentLinkedQueue r2 = (java.util.concurrent.ConcurrentLinkedQueue) r2
            if (r1 != 0) goto L14
            java.lang.Object r1 = r2.poll()
            K.m r1 = (K.m) r1
            r0.f9b = r1
        L14:
            java.lang.Object r1 = r0.f9b
            K.m r1 = (K.m) r1
            if (r1 == 0) goto L27
            int r3 = r1.f273a
            if (r3 >= r8) goto L27
            java.lang.Object r1 = r2.poll()
            K.m r1 = (K.m) r1
            r0.f9b = r1
            goto L14
        L27:
            r2 = 0
            java.lang.String r3 = "Cannot find config with generation: "
            java.lang.String r4 = "SettingsChannel"
            if (r1 != 0) goto L48
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r3)
            java.lang.String r1 = java.lang.String.valueOf(r8)
            r0.append(r1)
            java.lang.String r1 = ", after exhausting the queue."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r4, r0)
        L46:
            r1 = r2
            goto L72
        L48:
            int r5 = r1.f273a
            if (r5 == r8) goto L72
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r3 = java.lang.String.valueOf(r8)
            r1.append(r3)
            java.lang.String r3 = ", the oldest config is now: "
            r1.append(r3)
            java.lang.Object r0 = r0.f9b
            K.m r0 = (K.m) r0
            int r0 = r0.f273a
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.e(r4, r0)
            goto L46
        L72:
            if (r1 != 0) goto L75
            goto L77
        L75:
            android.util.DisplayMetrics r2 = r1.f274b
        L77:
            if (r2 != 0) goto L98
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "getScaledFontSize called with configurationId "
            r7.<init>(r0)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r7.append(r8)
            java.lang.String r8 = ", which can't be found."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "FlutterJNI"
            android.util.Log.e(r8, r7)
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            return r7
        L98:
            r8 = 2
            float r7 = android.util.TypedValue.applyDimension(r8, r7, r2)
            float r8 = r2.density
            float r7 = r7 / r8
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.FlutterJNI.getScaledFontSize(float, int):float");
    }

    public void handlePlatformMessage(String str, ByteBuffer byteBuffer, int i2, long j2) {
        F.e eVar;
        boolean z2;
        h hVar = this.platformMessageHandler;
        if (hVar == null) {
            nativeCleanupMessageData(j2);
            return;
        }
        g gVar = (g) hVar;
        synchronized (gVar.f196e) {
            try {
                eVar = (F.e) gVar.f194c.get(str);
                z2 = gVar.f197f.get() && eVar == null;
                if (z2) {
                    if (!gVar.f195d.containsKey(str)) {
                        gVar.f195d.put(str, new LinkedList());
                    }
                    ((List) gVar.f195d.get(str)).add(new F.d(j2, byteBuffer, i2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z2) {
            return;
        }
        gVar.b(str, eVar, byteBuffer, i2, j2);
    }

    public void hideOverlaySurface2() {
        j jVar = this.platformViewsController2;
        if (jVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        if (jVar.f717l == null) {
            return;
        }
        SurfaceControl.Transaction h2 = AbstractC0010k.h();
        h2.setVisibility(jVar.f717l, false);
        h2.apply();
    }

    public void init(Context context, String[] strArr, String str, String str2, String str3, long j2, int i2) {
        if (initCalled) {
            Log.w(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, strArr, str, str2, str3, j2, i2);
        initCalled = true;
    }

    public void invokePlatformMessageEmptyResponseCallback(int i2) {
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i2);
            } else {
                Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i2);
            }
            this.shellHolderLock.readLock().unlock();
        } catch (Throwable th) {
            this.shellHolderLock.readLock().unlock();
            throw th;
        }
    }

    public void invokePlatformMessageResponseCallback(int i2, ByteBuffer byteBuffer, int i3) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i2, byteBuffer, i3);
            } else {
                Log.w(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i2);
            }
            this.shellHolderLock.readLock().unlock();
        } catch (Throwable th) {
            this.shellHolderLock.readLock().unlock();
            throw th;
        }
    }

    public boolean isAttached() {
        return this.nativeShellHolderId != null;
    }

    public boolean isCodePointEmoji(int i2) {
        return nativeFlutterTextUtilsIsEmoji(i2);
    }

    public boolean isCodePointEmojiModifier(int i2) {
        return nativeFlutterTextUtilsIsEmojiModifier(i2);
    }

    public boolean isCodePointEmojiModifierBase(int i2) {
        return nativeFlutterTextUtilsIsEmojiModifierBase(i2);
    }

    public boolean isCodePointRegionalIndicator(int i2) {
        return nativeFlutterTextUtilsIsRegionalIndicator(i2);
    }

    public boolean isCodePointVariantSelector(int i2) {
        return nativeFlutterTextUtilsIsVariationSelector(i2);
    }

    public void loadDartDeferredLibrary(int i2, String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i2, strArr);
    }

    public void loadLibrary(Context context) {
        B.a aVar;
        String[] strArr;
        ZipFile zipFile;
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        char c2 = 0;
        if (loadLibraryCalled) {
            Log.w(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        B.e eVar = new B.e(0);
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        B.e.g("Beginning load of %s...", "flutter");
        B.b bVar = (B.b) eVar.f9b;
        HashSet hashSet = (HashSet) eVar.f8a;
        if (hashSet.contains("flutter")) {
            B.e.g("%s already loaded previously!", "flutter");
        } else {
            try {
                bVar.getClass();
                System.loadLibrary("flutter");
                hashSet.add("flutter");
                B.e.g("%s (%s) was loaded normally!", "flutter", null);
            } catch (UnsatisfiedLinkError e2) {
                B.e.g("Loading the library normally failed: %s", Log.getStackTraceString(e2));
                B.e.g("%s (%s) was not loaded normally, re-linking...", "flutter", null);
                File d2 = eVar.d(context);
                if (!d2.exists()) {
                    File dir = context.getDir("lib", 0);
                    File d3 = eVar.d(context);
                    bVar.getClass();
                    File[] listFiles = dir.listFiles(new B.d(System.mapLibraryName("flutter")));
                    if (listFiles != null) {
                        for (File file : listFiles) {
                            if (!file.getAbsolutePath().equals(d3.getAbsolutePath())) {
                                file.delete();
                            }
                        }
                    }
                    String[] strArr2 = Build.SUPPORTED_ABIS;
                    if (strArr2.length <= 0) {
                        String str = Build.CPU_ABI2;
                        strArr2 = (str == null || str.length() == 0) ? new String[]{Build.CPU_ABI} : new String[]{Build.CPU_ABI, str};
                    }
                    String mapLibraryName = System.mapLibraryName("flutter");
                    ((B.b) eVar.f10c).getClass();
                    try {
                        B.a e3 = B.b.e(context, strArr2, mapLibraryName, eVar);
                        try {
                            if (e3 == null) {
                                try {
                                    strArr = B.b.f(context, mapLibraryName);
                                } catch (Exception e4) {
                                    strArr = new String[]{e4.toString()};
                                }
                                throw new c(mapLibraryName, strArr2, strArr);
                            }
                            int i2 = 0;
                            while (true) {
                                int i3 = i2 + 1;
                                zipFile = (ZipFile) e3.f4c;
                                if (i2 < 5) {
                                    Object[] objArr = new Object[1];
                                    objArr[c2] = mapLibraryName;
                                    B.e.g("Found %s! Extracting...", objArr);
                                    try {
                                        if (d2.exists() || d2.createNewFile()) {
                                            try {
                                                inputStream2 = zipFile.getInputStream((ZipEntry) e3.f5d);
                                            } catch (FileNotFoundException unused) {
                                                inputStream2 = null;
                                            } catch (IOException unused2) {
                                                inputStream2 = null;
                                            } catch (Throwable th) {
                                                th = th;
                                                inputStream = null;
                                            }
                                            try {
                                                fileOutputStream2 = new FileOutputStream(d2);
                                                try {
                                                    byte[] bArr = new byte[4096];
                                                    long j2 = 0;
                                                    while (true) {
                                                        int read = inputStream2.read(bArr);
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        fileOutputStream2.write(bArr, 0, read);
                                                        j2 += read;
                                                    }
                                                    fileOutputStream2.flush();
                                                    fileOutputStream2.getFD().sync();
                                                    if (j2 == d2.length()) {
                                                        B.b.b(inputStream2);
                                                        B.b.b(fileOutputStream2);
                                                        d2.setReadable(true, false);
                                                        d2.setExecutable(true, false);
                                                        d2.setWritable(true);
                                                        break;
                                                    }
                                                    B.b.b(inputStream2);
                                                    B.b.b(fileOutputStream2);
                                                } catch (FileNotFoundException unused3) {
                                                    B.b.b(inputStream2);
                                                    B.b.b(fileOutputStream2);
                                                    i2 = i3;
                                                    c2 = 0;
                                                } catch (IOException unused4) {
                                                    B.b.b(inputStream2);
                                                    B.b.b(fileOutputStream2);
                                                    i2 = i3;
                                                    c2 = 0;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    inputStream = inputStream2;
                                                    fileOutputStream = fileOutputStream2;
                                                    B.b.b(inputStream);
                                                    B.b.b(fileOutputStream);
                                                    throw th;
                                                }
                                            } catch (FileNotFoundException unused5) {
                                                fileOutputStream2 = null;
                                                B.b.b(inputStream2);
                                                B.b.b(fileOutputStream2);
                                                i2 = i3;
                                                c2 = 0;
                                            } catch (IOException unused6) {
                                                fileOutputStream2 = null;
                                                B.b.b(inputStream2);
                                                B.b.b(fileOutputStream2);
                                                i2 = i3;
                                                c2 = 0;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                inputStream = inputStream2;
                                                fileOutputStream = null;
                                                B.b.b(inputStream);
                                                B.b.b(fileOutputStream);
                                                throw th;
                                            }
                                        }
                                    } catch (IOException unused7) {
                                    }
                                    i2 = i3;
                                    c2 = 0;
                                }
                            }
                            try {
                                zipFile.close();
                                break;
                            } catch (IOException unused8) {
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            aVar = e3;
                            if (aVar != null) {
                                try {
                                    ((ZipFile) aVar.f4c).close();
                                } catch (IOException unused9) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        aVar = null;
                    }
                }
                String absolutePath = d2.getAbsolutePath();
                bVar.getClass();
                System.load(absolutePath);
                hashSet.add("flutter");
                B.e.g("%s (%s) was re-linked!", "flutter", null);
            }
        }
        loadLibraryCalled = true;
    }

    public void markTextureFrameAvailable(long j2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j2);
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onBeginFrame() {
        ensureRunningOnMainThread();
        io.flutter.plugin.platform.k kVar = this.platformViewsController;
        if (kVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
        }
        kVar.f733q.clear();
        kVar.f734r.clear();
    }

    public void onDisplayOverlaySurface(int i2, int i3, int i4, int i5, int i6) {
        ensureRunningOnMainThread();
        io.flutter.plugin.platform.k kVar = this.platformViewsController;
        if (kVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        SparseArray sparseArray = kVar.f729l;
        if (sparseArray.get(i2) == null) {
            throw new IllegalStateException("The overlay surface (id:" + i2 + ") doesn't exist");
        }
        kVar.g();
        View view = (io.flutter.plugin.platform.b) sparseArray.get(i2);
        if (view.getParent() == null) {
            kVar.f720c.addView(view);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i5, i6);
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i4;
        view.setLayoutParams(layoutParams);
        view.setVisibility(0);
        view.bringToFront();
        kVar.f733q.add(Integer.valueOf(i2));
    }

    public void onDisplayPlatformView(int i2, int i3, int i4, int i5, int i6, int i7, int i8, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        io.flutter.plugin.platform.k kVar = this.platformViewsController;
        if (kVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
        kVar.g();
        if (kVar.f727j.get(i2) != null) {
            throw new ClassCastException();
        }
    }

    public void onDisplayPlatformView2(int i2, int i3, int i4, int i5, int i6, int i7, int i8, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        j jVar = this.platformViewsController2;
        if (jVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
        if (jVar.f712g.get(i2) != null) {
            throw new ClassCastException();
        }
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, io.flutter.embedding.engine.renderer.l] */
    public void onEndFrame() {
        ?? r3;
        ensureRunningOnMainThread();
        io.flutter.plugin.platform.k kVar = this.platformViewsController;
        if (kVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
        }
        boolean z2 = false;
        if (!kVar.f731o || !kVar.f734r.isEmpty()) {
            if (kVar.f731o) {
                C0012m c0012m = kVar.f720c.f102c;
                if (c0012m != null ? c0012m.e() : false) {
                    z2 = true;
                }
            }
            kVar.f(z2);
            return;
        }
        kVar.f731o = false;
        y yVar = kVar.f720c;
        H.c cVar = new H.c(2, kVar);
        C0012m c0012m2 = yVar.f102c;
        if (c0012m2 == null || (r3 = yVar.f104e) == 0) {
            return;
        }
        yVar.f103d = r3;
        yVar.f104e = null;
        io.flutter.embedding.engine.renderer.j jVar = yVar.f107h.f126b;
        if (jVar != null) {
            r3.b();
            x xVar = new x(yVar, jVar, cVar);
            jVar.f627a.addIsDisplayingFlutterUiListener(xVar);
            if (jVar.f629c) {
                xVar.a();
                return;
            }
            return;
        }
        c0012m2.d();
        C0012m c0012m3 = yVar.f102c;
        if (c0012m3 != null) {
            c0012m3.f75a.close();
            yVar.removeView(yVar.f102c);
            yVar.f102c = null;
        }
        cVar.run();
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        Iterator<io.flutter.embedding.engine.renderer.k> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void onRenderingStopped() {
        ensureRunningOnMainThread();
        Iterator<io.flutter.embedding.engine.renderer.k> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void onSurfaceChanged(int i2, int i3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i2, i3);
    }

    public void onSurfaceCreated(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onSurfaceWindowChanged(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    public void onVsync(long j2, long j3, long j4) {
        nativeOnVsync(j2, j3, j4);
    }

    public long performNativeAttach(FlutterJNI flutterJNI) {
        return nativeAttach(flutterJNI);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            Log.w(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    public void registerImageTexture(long j2, TextureRegistry$ImageConsumer textureRegistry$ImageConsumer, boolean z2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterImageTexture(this.nativeShellHolderId.longValue(), j2, new WeakReference<>(textureRegistry$ImageConsumer), z2);
    }

    public void registerTexture(long j2, SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j2, new WeakReference<>(surfaceTextureWrapper));
    }

    public void removeEngineLifecycleListener(b bVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(bVar);
    }

    public void removeIsDisplayingFlutterUiListener(io.flutter.embedding.engine.renderer.k kVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(kVar);
    }

    public void requestDartDeferredLibrary(int i2) {
        Log.e(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
    }

    public void runBundleAndSnapshotFromLibrary(String str, String str2, String str3, AssetManager assetManager, List<String> list, long j2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager, list, j2);
    }

    public void scheduleFrame() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeScheduleFrame(this.nativeShellHolderId.longValue());
    }

    public void setAccessibilityDelegate(k kVar) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = kVar;
    }

    public void setAccessibilityFeatures(int i2) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            setAccessibilityFeaturesInNative(i2);
        }
    }

    public void setAccessibilityFeaturesInNative(int i2) {
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i2);
    }

    public void setAsyncWaitForVsyncDelegate(l lVar) {
        asyncWaitForVsyncDelegate = lVar;
    }

    public void setDeferredComponentManager(a aVar) {
        ensureRunningOnMainThread();
        if (aVar != null) {
            aVar.a();
        }
    }

    public void setLocalizationPlugin(M.a aVar) {
        ensureRunningOnMainThread();
        this.localizationPlugin = aVar;
    }

    public void setPlatformMessageHandler(h hVar) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = hVar;
    }

    public void setPlatformViewsController(io.flutter.plugin.platform.k kVar) {
        ensureRunningOnMainThread();
        this.platformViewsController = kVar;
    }

    public void setPlatformViewsController2(j jVar) {
        ensureRunningOnMainThread();
        this.platformViewsController2 = jVar;
    }

    public void setRefreshRateFPS(float f2) {
        refreshRateFPS = f2;
        updateRefreshRate();
    }

    public void setSemanticsEnabled(boolean z2) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            setSemanticsEnabledInNative(z2);
        }
    }

    public void setSemanticsEnabledInNative(boolean z2) {
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z2);
    }

    public void setViewportMetrics(float f2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int[] iArr, int[] iArr2, int[] iArr3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f2, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, iArr, iArr2, iArr3);
    }

    public void showOverlaySurface2() {
        j jVar = this.platformViewsController2;
        if (jVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        if (jVar.f717l == null) {
            return;
        }
        SurfaceControl.Transaction h2 = AbstractC0010k.h();
        h2.setVisibility(jVar.f717l, true);
        h2.apply();
    }

    public FlutterJNI spawn(String str, String str2, String str3, List<String> list, long j2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI nativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2, str3, list, j2);
        Long l2 = nativeSpawn.nativeShellHolderId;
        if ((l2 == null || l2.longValue() == 0) ? false : true) {
            return nativeSpawn;
        }
        throw new IllegalStateException("Failed to spawn new JNI connected shell from existing shell.");
    }

    public void swapTransactions() {
        j jVar = this.platformViewsController2;
        if (jVar == null) {
            throw new RuntimeException("");
        }
        synchronized (jVar) {
            try {
                jVar.f715j.clear();
                for (int i2 = 0; i2 < jVar.f714i.size(); i2++) {
                    jVar.f715j.add(AbstractC0010k.j(jVar.f714i.get(i2)));
                }
                jVar.f714i.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unregisterTexture(long j2) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j2);
    }

    public void updateDisplayMetrics(int i2, float f2, float f3, float f4) {
        displayWidth = f2;
        displayHeight = f3;
        displayDensity = f4;
        if (loadLibraryCalled) {
            nativeUpdateDisplayMetrics(this.nativeShellHolderId.longValue());
        }
    }

    public void updateJavaAssetManager(AssetManager assetManager, String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled) {
            nativeUpdateRefreshRate(refreshRateFPS);
        }
    }

    public void dispatchSemanticsAction(int i2, e eVar, Object obj) {
        ByteBuffer byteBuffer;
        int i3;
        ensureAttachedToNative();
        if (obj != null) {
            byteBuffer = L.l.f308a.c(obj);
            i3 = byteBuffer.position();
        } else {
            byteBuffer = null;
            i3 = 0;
        }
        dispatchSemanticsAction(i2, eVar.f772b, byteBuffer, i3);
    }

    public void dispatchSemanticsAction(int i2, int i3, ByteBuffer byteBuffer, int i4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i2, i3, byteBuffer, i4);
    }
}
