package v;

import java.util.ArrayList;
import w.i;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final w.i f1332a;

    /* renamed from: b, reason: collision with root package name */
    private b f1333b;

    /* renamed from: c, reason: collision with root package name */
    public final i.c f1334c;

    class a implements i.c {
        a() {
        }

        @Override // w.i.c
        public void a(w.h hVar, i.d dVar) {
            if (n.this.f1333b == null) {
                j.b.f("SpellCheckChannel", "No SpellCheckeMethodHandler registered, call not forwarded to spell check API.");
                return;
            }
            String str = hVar.f1398a;
            Object obj = hVar.f1399b;
            j.b.f("SpellCheckChannel", "Received '" + str + "' message.");
            str.hashCode();
            if (!str.equals("SpellCheck.initiateSpellCheck")) {
                dVar.c();
                return;
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                n.this.f1333b.a((String) arrayList.get(0), (String) arrayList.get(1), dVar);
            } catch (IllegalStateException e2) {
                dVar.a("error", e2.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str, String str2, i.d dVar);
    }

    public n(k.a aVar) {
        a aVar2 = new a();
        this.f1334c = aVar2;
        w.i iVar = new w.i(aVar, "flutter/spellcheck", w.p.f1413b);
        this.f1332a = iVar;
        iVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f1333b = bVar;
    }
}
