package b0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends p {
    public static final <T, A extends Appendable> A i(Iterable<? extends T> iterable, A buffer, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, j0.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.i.e(iterable, "<this>");
        kotlin.jvm.internal.i.e(buffer, "buffer");
        kotlin.jvm.internal.i.e(separator, "separator");
        kotlin.jvm.internal.i.e(prefix, "prefix");
        kotlin.jvm.internal.i.e(postfix, "postfix");
        kotlin.jvm.internal.i.e(truncated, "truncated");
        buffer.append(prefix);
        int i3 = 0;
        for (T t2 : iterable) {
            i3++;
            if (i3 > 1) {
                buffer.append(separator);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            p0.e.a(buffer, t2, lVar);
        }
        if (i2 >= 0 && i3 > i2) {
            buffer.append(truncated);
        }
        buffer.append(postfix);
        return buffer;
    }

    public static final <T> String k(Iterable<? extends T> iterable, CharSequence separator, CharSequence prefix, CharSequence postfix, int i2, CharSequence truncated, j0.l<? super T, ? extends CharSequence> lVar) {
        kotlin.jvm.internal.i.e(iterable, "<this>");
        kotlin.jvm.internal.i.e(separator, "separator");
        kotlin.jvm.internal.i.e(prefix, "prefix");
        kotlin.jvm.internal.i.e(postfix, "postfix");
        kotlin.jvm.internal.i.e(truncated, "truncated");
        String sb = ((StringBuilder) i(iterable, new StringBuilder(), separator, prefix, postfix, i2, truncated, lVar)).toString();
        kotlin.jvm.internal.i.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String l(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, j0.l lVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i3 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i3 & 4) == 0 ? charSequence3 : "";
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            lVar = null;
        }
        return k(iterable, charSequence, charSequence5, charSequence6, i4, charSequence7, lVar);
    }

    public static <T extends Comparable<? super T>> T m(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.e(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (next.compareTo(next2) > 0) {
                next = next2;
            }
        }
        return next;
    }

    public static <T> T n(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) o((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        T next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final <T> T o(List<? extends T> list) {
        kotlin.jvm.internal.i.e(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static final <T, C extends Collection<? super T>> C p(Iterable<? extends T> iterable, C destination) {
        kotlin.jvm.internal.i.e(iterable, "<this>");
        kotlin.jvm.internal.i.e(destination, "destination");
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> q(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return i.e(r(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return i.b();
        }
        if (size != 1) {
            return s(collection);
        }
        return h.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> r(Iterable<? extends T> iterable) {
        kotlin.jvm.internal.i.e(iterable, "<this>");
        return iterable instanceof Collection ? s((Collection) iterable) : (List) p(iterable, new ArrayList());
    }

    public static final <T> List<T> s(Collection<? extends T> collection) {
        kotlin.jvm.internal.i.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> t(Iterable<? extends T> iterable) {
        Set<T> b2;
        int a2;
        kotlin.jvm.internal.i.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e0.c((Set) p(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            b2 = e0.b();
            return b2;
        }
        if (size == 1) {
            return d0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
        }
        a2 = y.a(collection.size());
        return (Set) p(iterable, new LinkedHashSet(a2));
    }
}
