package v;

import android.view.KeyEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import v.d;
import w.a;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final w.a<Object> f1211a;

    public interface a {
        void a(boolean z2);
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final KeyEvent f1212a;

        /* renamed from: b, reason: collision with root package name */
        public final Character f1213b;

        public b(KeyEvent keyEvent, Character ch) {
            this.f1212a = keyEvent;
            this.f1213b = ch;
        }
    }

    public d(w.b bVar) {
        this.f1211a = new w.a<>(bVar, "flutter/keyevent", w.d.f1396a);
    }

    private static a.e<Object> b(final a aVar) {
        return new a.e() { // from class: v.c
            @Override // w.a.e
            public final void a(Object obj) {
                d.d(d.a.this, obj);
            }
        };
    }

    private Map<String, Object> c(b bVar, boolean z2) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", z2 ? "keyup" : "keydown");
        hashMap.put("keymap", "android");
        hashMap.put("flags", Integer.valueOf(bVar.f1212a.getFlags()));
        hashMap.put("plainCodePoint", Integer.valueOf(bVar.f1212a.getUnicodeChar(0)));
        hashMap.put("codePoint", Integer.valueOf(bVar.f1212a.getUnicodeChar()));
        hashMap.put("keyCode", Integer.valueOf(bVar.f1212a.getKeyCode()));
        hashMap.put("scanCode", Integer.valueOf(bVar.f1212a.getScanCode()));
        hashMap.put("metaState", Integer.valueOf(bVar.f1212a.getMetaState()));
        Character ch = bVar.f1213b;
        if (ch != null) {
            hashMap.put("character", ch.toString());
        }
        hashMap.put("source", Integer.valueOf(bVar.f1212a.getSource()));
        hashMap.put("deviceId", Integer.valueOf(bVar.f1212a.getDeviceId()));
        hashMap.put("repeatCount", Integer.valueOf(bVar.f1212a.getRepeatCount()));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(a aVar, Object obj) {
        boolean z2 = false;
        if (obj != null) {
            try {
                z2 = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e2) {
                j.b.b("KeyEventChannel", "Unable to unpack JSON message: " + e2);
            }
        }
        aVar.a(z2);
    }

    public void e(b bVar, boolean z2, a aVar) {
        this.f1211a.d(c(bVar, z2), b(aVar));
    }
}
