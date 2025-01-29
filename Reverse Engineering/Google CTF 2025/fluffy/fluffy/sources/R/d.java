package R;

/* loaded from: classes.dex */
public abstract class d extends a.a {
    public static final void B(Object[] objArr, Object[] objArr2, int i2, int i3, int i4) {
        a0.h.e(objArr, "<this>");
        a0.h.e(objArr2, "destination");
        System.arraycopy(objArr, i3, objArr2, i2, i4 - i3);
    }
}
