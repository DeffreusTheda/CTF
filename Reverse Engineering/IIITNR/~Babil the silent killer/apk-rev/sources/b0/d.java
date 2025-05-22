package b0;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends c {
    public static <T> List<T> a(T[] tArr) {
        kotlin.jvm.internal.i.e(tArr, "<this>");
        List<T> a2 = f.a(tArr);
        kotlin.jvm.internal.i.d(a2, "asList(this)");
        return a2;
    }

    public static final <T> T[] b(T[] tArr, T[] destination, int i2, int i3, int i4) {
        kotlin.jvm.internal.i.e(tArr, "<this>");
        kotlin.jvm.internal.i.e(destination, "destination");
        System.arraycopy(tArr, i3, destination, i2, i4 - i3);
        return destination;
    }

    public static /* synthetic */ Object[] c(Object[] objArr, Object[] objArr2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i2 = 0;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = objArr.length;
        }
        return b(objArr, objArr2, i2, i3, i4);
    }

    public static <T> void d(T[] tArr, T t2, int i2, int i3) {
        kotlin.jvm.internal.i.e(tArr, "<this>");
        Arrays.fill(tArr, i2, i3, t2);
    }

    public static /* synthetic */ void e(Object[] objArr, Object obj, int i2, int i3, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = objArr.length;
        }
        d(objArr, obj, i2, i3);
    }
}
