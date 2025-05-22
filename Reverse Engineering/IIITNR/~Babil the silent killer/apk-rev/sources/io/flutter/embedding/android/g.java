package io.flutter.embedding.android;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import java.nio.ByteBuffer;
import java.util.Locale;

@TargetApi(19)
/* loaded from: classes.dex */
public class g extends View implements u.c {

    /* renamed from: a, reason: collision with root package name */
    private ImageReader f218a;

    /* renamed from: b, reason: collision with root package name */
    private Image f219b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f220c;

    /* renamed from: d, reason: collision with root package name */
    private u.a f221d;

    /* renamed from: e, reason: collision with root package name */
    private b f222e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f223f;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f224a;

        static {
            int[] iArr = new int[b.values().length];
            f224a = iArr;
            try {
                iArr[b.background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f224a[b.overlay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        background,
        overlay
    }

    public g(Context context, int i2, int i3, b bVar) {
        this(context, g(i2, i3), bVar);
    }

    g(Context context, ImageReader imageReader, b bVar) {
        super(context, null);
        this.f223f = false;
        this.f218a = imageReader;
        this.f222e = bVar;
        h();
    }

    private void e() {
        Image image = this.f219b;
        if (image != null) {
            image.close();
            this.f219b = null;
        }
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(19)
    private static ImageReader g(int i2, int i3) {
        int i4;
        int i5;
        if (i2 <= 0) {
            i("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i2));
            i4 = 1;
        } else {
            i4 = i2;
        }
        if (i3 <= 0) {
            i("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i3));
            i5 = 1;
        } else {
            i5 = i3;
        }
        return Build.VERSION.SDK_INT >= 29 ? ImageReader.newInstance(i4, i5, 1, 3, 768L) : ImageReader.newInstance(i4, i5, 1, 3);
    }

    private void h() {
        setAlpha(0.0f);
    }

    private static void i(String str, Object... objArr) {
        j.b.g("FlutterImageView", String.format(Locale.US, str, objArr));
    }

    @TargetApi(29)
    private void k() {
        if (Build.VERSION.SDK_INT >= 29) {
            HardwareBuffer hardwareBuffer = this.f219b.getHardwareBuffer();
            this.f220c = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f219b.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.f219b.getHeight();
        Bitmap bitmap = this.f220c;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.f220c.getHeight() != height) {
            this.f220c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.f220c.copyPixelsFromBuffer(buffer);
    }

    @Override // u.c
    public void a(u.a aVar) {
        if (a.f224a[this.f222e.ordinal()] == 1) {
            aVar.v(this.f218a.getSurface());
        }
        setAlpha(1.0f);
        this.f221d = aVar;
        this.f223f = true;
    }

    @Override // u.c
    public void b() {
    }

    @Override // u.c
    public void c() {
        if (this.f223f) {
            setAlpha(0.0f);
            d();
            this.f220c = null;
            e();
            invalidate();
            this.f223f = false;
        }
    }

    @TargetApi(19)
    public boolean d() {
        if (!this.f223f) {
            return false;
        }
        Image acquireLatestImage = this.f218a.acquireLatestImage();
        if (acquireLatestImage != null) {
            e();
            this.f219b = acquireLatestImage;
            invalidate();
        }
        return acquireLatestImage != null;
    }

    public void f() {
        this.f218a.close();
    }

    @Override // u.c
    public u.a getAttachedRenderer() {
        return this.f221d;
    }

    public ImageReader getImageReader() {
        return this.f218a;
    }

    public Surface getSurface() {
        return this.f218a.getSurface();
    }

    public void j(int i2, int i3) {
        if (this.f221d == null) {
            return;
        }
        if (i2 == this.f218a.getWidth() && i3 == this.f218a.getHeight()) {
            return;
        }
        e();
        f();
        this.f218a = g(i2, i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f219b != null) {
            k();
        }
        Bitmap bitmap = this.f220c;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (!(i2 == this.f218a.getWidth() && i3 == this.f218a.getHeight()) && this.f222e == b.background && this.f223f) {
            j(i2, i3);
            this.f221d.v(this.f218a.getSurface());
        }
    }
}
