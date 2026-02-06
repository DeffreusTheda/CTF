package io.flutter.embedding.android;

import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import io.flutter.plugin.editing.b;
import java.util.HashSet;

/* loaded from: classes.dex */
public class s implements b.a {

    /* renamed from: a, reason: collision with root package name */
    protected final d[] f307a;

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<KeyEvent> f308b = new HashSet<>();

    /* renamed from: c, reason: collision with root package name */
    private final e f309c;

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private int f310a = 0;

        Character a(int i2) {
            char c2 = (char) i2;
            if ((Integer.MIN_VALUE & i2) != 0) {
                int i3 = i2 & Integer.MAX_VALUE;
                int i4 = this.f310a;
                if (i4 != 0) {
                    i3 = KeyCharacterMap.getDeadChar(i4, i3);
                }
                this.f310a = i3;
            } else {
                int i5 = this.f310a;
                if (i5 != 0) {
                    int deadChar = KeyCharacterMap.getDeadChar(i5, i2);
                    if (deadChar > 0) {
                        c2 = (char) deadChar;
                    }
                    this.f310a = 0;
                }
            }
            return Character.valueOf(c2);
        }
    }

    private class c {

        /* renamed from: a, reason: collision with root package name */
        final KeyEvent f311a;

        /* renamed from: b, reason: collision with root package name */
        int f312b;

        /* renamed from: c, reason: collision with root package name */
        boolean f313c = false;

        private class a implements d.a {

            /* renamed from: a, reason: collision with root package name */
            boolean f315a;

            private a() {
                this.f315a = false;
            }

            @Override // io.flutter.embedding.android.s.d.a
            public void a(boolean z2) {
                if (this.f315a) {
                    throw new IllegalStateException("The onKeyEventHandledCallback should be called exactly once.");
                }
                this.f315a = true;
                c cVar = c.this;
                int i2 = cVar.f312b - 1;
                cVar.f312b = i2;
                boolean z3 = z2 | cVar.f313c;
                cVar.f313c = z3;
                if (i2 != 0 || z3) {
                    return;
                }
                s.this.d(cVar.f311a);
            }
        }

        c(KeyEvent keyEvent) {
            this.f312b = s.this.f307a.length;
            this.f311a = keyEvent;
        }

        public d.a a() {
            return new a();
        }
    }

    public interface d {

        public interface a {
            void a(boolean z2);
        }

        void a(KeyEvent keyEvent, a aVar);
    }

    public interface e {
        boolean a(KeyEvent keyEvent);

        void c(KeyEvent keyEvent);

        w.b getBinaryMessenger();
    }

    public s(e eVar) {
        this.f309c = eVar;
        this.f307a = new d[]{new r(eVar.getBinaryMessenger()), new m(new v.d(eVar.getBinaryMessenger()))};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(KeyEvent keyEvent) {
        e eVar = this.f309c;
        if (eVar == null || eVar.a(keyEvent)) {
            return;
        }
        this.f308b.add(keyEvent);
        this.f309c.c(keyEvent);
        if (this.f308b.remove(keyEvent)) {
            j.b.g("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
        }
    }

    @Override // io.flutter.plugin.editing.b.a
    public boolean a(KeyEvent keyEvent) {
        if (this.f308b.remove(keyEvent)) {
            return false;
        }
        if (this.f307a.length <= 0) {
            d(keyEvent);
            return true;
        }
        c cVar = new c(keyEvent);
        for (d dVar : this.f307a) {
            dVar.a(keyEvent, cVar.a());
        }
        return true;
    }

    public void c() {
        int size = this.f308b.size();
        if (size > 0) {
            j.b.g("KeyboardManager", "A KeyboardManager was destroyed with " + String.valueOf(size) + " unhandled redispatch event(s).");
        }
    }
}
