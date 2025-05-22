package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.s;
import v.d;

/* loaded from: classes.dex */
public class m implements s.d {

    /* renamed from: a, reason: collision with root package name */
    private final v.d f281a;

    /* renamed from: b, reason: collision with root package name */
    private final s.b f282b = new s.b();

    public m(v.d dVar) {
        this.f281a = dVar;
    }

    @Override // io.flutter.embedding.android.s.d
    public void a(KeyEvent keyEvent, final s.d.a aVar) {
        int action = keyEvent.getAction();
        if (action == 0 || action == 1) {
            this.f281a.e(new d.b(keyEvent, this.f282b.a(keyEvent.getUnicodeChar())), action != 0, new d.a() { // from class: io.flutter.embedding.android.l
                @Override // v.d.a
                public final void a(boolean z2) {
                    s.d.a.this.a(z2);
                }
            });
        } else {
            aVar.a(false);
        }
    }
}
