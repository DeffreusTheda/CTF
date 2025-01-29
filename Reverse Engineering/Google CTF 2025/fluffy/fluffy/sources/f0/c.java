package f0;

import R.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class c extends d {
    public static List B(b bVar) {
        Iterator it = bVar.iterator();
        if (!it.hasNext()) {
            return m.f335b;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return a.a.n(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
