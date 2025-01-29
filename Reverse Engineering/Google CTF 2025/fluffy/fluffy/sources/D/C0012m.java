package D;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.Locale;

/* renamed from: D.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0012m extends View implements io.flutter.embedding.engine.renderer.l {

    /* renamed from: a, reason: collision with root package name */
    public ImageReader f75a;

    /* renamed from: b, reason: collision with root package name */
    public Image f76b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f77c;

    /* renamed from: d, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.j f78d;

    /* renamed from: e, reason: collision with root package name */
    public final int f79e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f80f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0012m(Context context, int i2, int i3, int i4) {
        super(context, null);
        ImageReader f2 = f(i2, i3);
        this.f80f = false;
        this.f75a = f2;
        this.f79e = i4;
        setAlpha(0.0f);
    }

    public static ImageReader f(int i2, int i3) {
        ImageReader newInstance;
        if (i2 <= 0) {
            Locale locale = Locale.US;
            Log.w("FlutterImageView", "ImageReader width must be greater than 0, but given width=" + i2 + ", set width=1");
            i2 = 1;
        }
        if (i3 <= 0) {
            Locale locale2 = Locale.US;
            Log.w("FlutterImageView", "ImageReader height must be greater than 0, but given height=" + i3 + ", set height=1");
            i3 = 1;
        }
        if (Build.VERSION.SDK_INT < 29) {
            return ImageReader.newInstance(i2, i3, 1, 3);
        }
        newInstance = ImageReader.newInstance(i2, i3, 1, 3, 768L);
        return newInstance;
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void a(io.flutter.embedding.engine.renderer.j jVar) {
        if (n.e.a(this.f79e) == 0) {
            Surface surface = this.f75a.getSurface();
            jVar.f628b = surface;
            jVar.f627a.onSurfaceWindowChanged(surface);
        }
        setAlpha(1.0f);
        this.f78d = jVar;
        this.f80f = true;
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void d() {
        if (this.f80f) {
            setAlpha(0.0f);
            e();
            this.f77c = null;
            Image image = this.f76b;
            if (image != null) {
                image.close();
                this.f76b = null;
            }
            invalidate();
            this.f80f = false;
        }
    }

    public final boolean e() {
        if (!this.f80f) {
            return false;
        }
        Image acquireLatestImage = this.f75a.acquireLatestImage();
        if (acquireLatestImage != null) {
            Image image = this.f76b;
            if (image != null) {
                image.close();
                this.f76b = null;
            }
            this.f76b = acquireLatestImage;
            invalidate();
        }
        return acquireLatestImage != null;
    }

    public final void g(int i2, int i3) {
        if (this.f78d == null) {
            return;
        }
        if (i2 == this.f75a.getWidth() && i3 == this.f75a.getHeight()) {
            return;
        }
        Image image = this.f76b;
        if (image != null) {
            image.close();
            this.f76b = null;
        }
        this.f75a.close();
        this.f75a = f(i2, i3);
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public io.flutter.embedding.engine.renderer.j getAttachedRenderer() {
        return this.f78d;
    }

    public ImageReader getImageReader() {
        return this.f75a;
    }

    public Surface getSurface() {
        return this.f75a.getSurface();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        HardwareBuffer hardwareBuffer;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        Bitmap wrapHardwareBuffer;
        super.onDraw(canvas);
        Image image = this.f76b;
        if (image != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                hardwareBuffer = image.getHardwareBuffer();
                named = ColorSpace.Named.SRGB;
                colorSpace = ColorSpace.get(named);
                wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, colorSpace);
                this.f77c = wrapHardwareBuffer;
                hardwareBuffer.close();
            } else {
                Image.Plane[] planes = image.getPlanes();
                if (planes.length == 1) {
                    Image.Plane plane = planes[0];
                    int rowStride = plane.getRowStride() / plane.getPixelStride();
                    int height = this.f76b.getHeight();
                    Bitmap bitmap = this.f77c;
                    if (bitmap == null || bitmap.getWidth() != rowStride || this.f77c.getHeight() != height) {
                        this.f77c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
                    }
                    ByteBuffer buffer = plane.getBuffer();
                    buffer.rewind();
                    this.f77c.copyPixelsFromBuffer(buffer);
                }
            }
        }
        Bitmap bitmap2 = this.f77c;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (!(i2 == this.f75a.getWidth() && i3 == this.f75a.getHeight()) && this.f79e == 1 && this.f80f) {
            g(i2, i3);
            io.flutter.embedding.engine.renderer.j jVar = this.f78d;
            Surface surface = this.f75a.getSurface();
            jVar.f628b = surface;
            jVar.f627a.onSurfaceWindowChanged(surface);
        }
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void b() {
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void c() {
    }
}
