package d;

import androidx.lifecycle.m;
import java.util.Map;

/* renamed from: d.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0022c implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.b f452a;

    /* renamed from: b, reason: collision with root package name */
    public final m f453b;

    /* renamed from: c, reason: collision with root package name */
    public C0022c f454c;

    /* renamed from: d, reason: collision with root package name */
    public C0022c f455d;

    public C0022c(io.flutter.embedding.engine.renderer.b bVar, m mVar) {
        this.f452a = bVar;
        this.f453b = mVar;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0022c)) {
            return false;
        }
        C0022c c0022c = (C0022c) obj;
        return this.f452a.equals(c0022c.f452a) && this.f453b.equals(c0022c.f453b);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f452a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f453b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f452a.hashCode() ^ this.f453b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.f452a + "=" + this.f453b;
    }
}
