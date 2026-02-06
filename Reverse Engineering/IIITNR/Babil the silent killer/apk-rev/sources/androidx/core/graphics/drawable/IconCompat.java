package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Parcelable;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import androidx.window.R;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f38k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    Object f40b;

    /* renamed from: j, reason: collision with root package name */
    public String f48j;

    /* renamed from: a, reason: collision with root package name */
    public int f39a = -1;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f41c = null;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f42d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f43e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f44f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f45g = null;

    /* renamed from: h, reason: collision with root package name */
    PorterDuff.Mode f46h = f38k;

    /* renamed from: i, reason: collision with root package name */
    public String f47i = null;

    private static int b(Icon icon) {
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e("IconCompat", "Unable to get icon resource", e4);
            return 0;
        }
    }

    private static String e(int i2) {
        switch (i2) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                return "BITMAP_MASKABLE";
            case R.styleable.SplitPairRule_splitRatio /* 6 */:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public int a() {
        int i2 = this.f39a;
        if (i2 == -1 && Build.VERSION.SDK_INT >= 23) {
            return b((Icon) this.f40b);
        }
        if (i2 == 2) {
            return this.f43e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public void c() {
        Parcelable parcelable;
        this.f46h = PorterDuff.Mode.valueOf(this.f47i);
        switch (this.f39a) {
            case -1:
                parcelable = this.f42d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                parcelable = this.f42d;
                if (parcelable == null) {
                    byte[] bArr = this.f41c;
                    this.f40b = bArr;
                    this.f39a = 3;
                    this.f43e = 0;
                    this.f44f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case R.styleable.SplitPairRule_splitRatio /* 6 */:
                String str = new String(this.f41c, Charset.forName("UTF-16"));
                this.f40b = str;
                if (this.f39a == 2 && this.f48j == null) {
                    this.f48j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f40b = this.f41c;
                return;
        }
        this.f40b = parcelable;
    }

    public void d(boolean z2) {
        this.f47i = this.f46h.name();
        switch (this.f39a) {
            case -1:
                if (z2) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                if (z2) {
                    Bitmap bitmap = (Bitmap) this.f40b;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f41c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f41c = ((String) this.f40b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f41c = (byte[]) this.f40b;
                return;
            case 4:
            case R.styleable.SplitPairRule_splitRatio /* 6 */:
                this.f41c = this.f40b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f42d = (Parcelable) this.f40b;
    }

    public String toString() {
        int height;
        if (this.f39a == -1) {
            return String.valueOf(this.f40b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(e(this.f39a));
        switch (this.f39a) {
            case 1:
            case R.styleable.SplitPairRule_splitMinWidth /* 5 */:
                sb.append(" size=");
                sb.append(((Bitmap) this.f40b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f40b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f48j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(a())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f43e);
                if (this.f44f != 0) {
                    sb.append(" off=");
                    height = this.f44f;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
            case R.styleable.SplitPairRule_splitRatio /* 6 */:
                sb.append(" uri=");
                sb.append(this.f40b);
                break;
        }
        if (this.f45g != null) {
            sb.append(" tint=");
            sb.append(this.f45g);
        }
        if (this.f46h != f38k) {
            sb.append(" mode=");
            sb.append(this.f46h);
        }
        sb.append(")");
        return sb.toString();
    }
}
