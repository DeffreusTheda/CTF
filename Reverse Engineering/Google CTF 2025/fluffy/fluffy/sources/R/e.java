package R;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class e extends k {
    public static String B(Collection collection, String str, String str2, a aVar, int i2) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        a0.h.e(str, "prefix");
        a0.h.e(str2, "postfix");
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) str);
        Iterator it = collection.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i3++;
            if (i3 > 1) {
                sb.append((CharSequence) ", ");
            }
            if (next != null ? next instanceof CharSequence : true) {
                sb.append((CharSequence) next);
            } else if (next instanceof Character) {
                sb.append(((Character) next).charValue());
            } else {
                sb.append((CharSequence) next.toString());
            }
        }
        sb.append((CharSequence) str2);
        return sb.toString();
    }
}
