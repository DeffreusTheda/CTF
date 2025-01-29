package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class ViewModel {
    private final Map<String, Object> mBagOfTags;
    private volatile boolean mCleared;
    private final Set<Closeable> mCloseables;

    public ViewModel() {
        this.mBagOfTags = new HashMap();
        this.mCloseables = new LinkedHashSet();
        this.mCleared = false;
    }

    public ViewModel(Closeable... closeables) {
        this.mBagOfTags = new HashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.mCloseables = linkedHashSet;
        this.mCleared = false;
        linkedHashSet.addAll(Arrays.asList(closeables));
    }

    public void addCloseable(Closeable closeable) {
        Set<Closeable> set = this.mCloseables;
        if (set != null) {
            synchronized (set) {
                this.mCloseables.add(closeable);
            }
        }
    }

    protected void onCleared() {
    }

    final void clear() {
        this.mCleared = true;
        Map<String, Object> map = this.mBagOfTags;
        if (map != null) {
            synchronized (map) {
                for (Object value : this.mBagOfTags.values()) {
                    closeWithRuntimeException(value);
                }
            }
        }
        Set<Closeable> set = this.mCloseables;
        if (set != null) {
            synchronized (set) {
                for (Closeable closeable : this.mCloseables) {
                    closeWithRuntimeException(closeable);
                }
            }
        }
        onCleared();
    }

    /* JADX WARN: Multi-variable type inference failed */
    <T> T setTagIfAbsent(String key, T newValue) {
        Object obj;
        synchronized (this.mBagOfTags) {
            obj = this.mBagOfTags.get(key);
            if (obj == 0) {
                this.mBagOfTags.put(key, newValue);
            }
        }
        T result = obj == 0 ? newValue : obj;
        if (this.mCleared) {
            closeWithRuntimeException(result);
        }
        return result;
    }

    <T> T getTag(String str) {
        T t;
        Map<String, Object> map = this.mBagOfTags;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.mBagOfTags.get(str);
        }
        return t;
    }

    private static void closeWithRuntimeException(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
