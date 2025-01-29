package B;

import D.G;
import D.I;
import D.J;
import D.K;
import D.L;
import D.v;
import D.y;
import K.k;
import L.j;
import L.l;
import a0.h;
import android.app.Activity;
import android.content.Context;
import android.text.Selection;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.editing.f;
import io.flutter.plugin.platform.i;
import java.io.File;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9b;

    /* renamed from: c, reason: collision with root package name */
    public Object f10c;

    public /* synthetic */ e(Object obj, Object obj2, Object obj3) {
        this.f8a = obj;
        this.f9b = obj2;
        this.f10c = obj3;
    }

    public static void g(String str, Object... objArr) {
        String.format(Locale.US, str, objArr);
    }

    public void a(Activity activity) {
        ReentrantLock reentrantLock = (ReentrantLock) this.f9b;
        reentrantLock.lock();
        try {
            ((WeakHashMap) this.f10c).put(activity, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public void b(int i2, io.flutter.view.e eVar) {
        ((FlutterJNI) this.f9b).dispatchSemanticsAction(i2, eVar);
    }

    public void c(int i2, io.flutter.view.e eVar, Serializable serializable) {
        ((FlutterJNI) this.f9b).dispatchSemanticsAction(i2, eVar, serializable);
    }

    public File d(Context context) {
        ((b) this.f9b).getClass();
        return new File(context.getDir("lib", 0), System.mapLibraryName("flutter"));
    }

    public boolean e(KeyEvent keyEvent) {
        if (((HashSet) this.f8a).remove(keyEvent)) {
            return false;
        }
        K[] kArr = (K[]) this.f9b;
        if (kArr.length <= 0) {
            h(keyEvent);
            return true;
        }
        J j2 = new J(this, keyEvent);
        for (K k2 : kArr) {
            k2.a(keyEvent, new I(j2));
        }
        return true;
    }

    public void f(String str, Object obj, k kVar) {
        ((L.e) this.f8a).a((String) this.f9b, ((j) this.f10c).f(new a(obj, str)), kVar == null ? null : new L.a(1, this, kVar));
    }

    public void h(KeyEvent keyEvent) {
        io.flutter.plugin.editing.c cVar;
        L l2 = (L) this.f10c;
        if (l2 != null) {
            y yVar = (y) l2;
            io.flutter.plugin.editing.k kVar = yVar.f110k;
            boolean z2 = false;
            if (kVar.f679b.isAcceptingText() && (cVar = kVar.f687j) != null && keyEvent.getAction() == 0) {
                if (keyEvent.getKeyCode() == 21) {
                    z2 = cVar.d(true, keyEvent.isShiftPressed());
                } else if (keyEvent.getKeyCode() == 22) {
                    z2 = cVar.d(false, keyEvent.isShiftPressed());
                } else if (keyEvent.getKeyCode() == 19) {
                    z2 = cVar.e(true, keyEvent.isShiftPressed());
                } else if (keyEvent.getKeyCode() == 20) {
                    z2 = cVar.e(false, keyEvent.isShiftPressed());
                } else {
                    if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                        EditorInfo editorInfo = cVar.f639e;
                        if ((editorInfo.inputType & 131072) == 0) {
                            cVar.performEditorAction(editorInfo.imeOptions & 255);
                            z2 = true;
                        }
                    }
                    f fVar = cVar.f638d;
                    int selectionStart = Selection.getSelectionStart(fVar);
                    int selectionEnd = Selection.getSelectionEnd(fVar);
                    int unicodeChar = keyEvent.getUnicodeChar();
                    if (selectionStart >= 0 && selectionEnd >= 0 && unicodeChar != 0) {
                        int min = Math.min(selectionStart, selectionEnd);
                        int max = Math.max(selectionStart, selectionEnd);
                        cVar.beginBatchEdit();
                        if (min != max) {
                            fVar.delete(min, max);
                        }
                        fVar.insert(min, (CharSequence) String.valueOf((char) unicodeChar));
                        int i2 = min + 1;
                        cVar.setSelection(i2, i2);
                        cVar.endBatchEdit();
                        z2 = true;
                    }
                }
            }
            if (z2) {
                return;
            }
            HashSet hashSet = (HashSet) this.f8a;
            hashSet.add(keyEvent);
            yVar.getRootView().dispatchKeyEvent(keyEvent);
            if (hashSet.remove(keyEvent)) {
                Log.w("KeyboardManager", "A redispatched key event was consumed before reaching KeyboardManager");
            }
        }
    }

    public void i(Activity activity, v.k kVar) {
        h.e(activity, "activity");
        h.e(kVar, "newLayout");
        ReentrantLock reentrantLock = (ReentrantLock) this.f9b;
        reentrantLock.lock();
        WeakHashMap weakHashMap = (WeakHashMap) this.f10c;
        try {
            if (kVar.equals((v.k) weakHashMap.get(activity))) {
                return;
            }
            reentrantLock.unlock();
            Iterator it = ((y.k) ((i) this.f8a).f705c).f1242b.iterator();
            while (it.hasNext()) {
                y.j jVar = (y.j) it.next();
                if (jVar.f1236a.equals(activity)) {
                    jVar.f1238c = kVar;
                    jVar.f1237b.accept(kVar);
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void j(Serializable serializable, L.b bVar) {
        ((L.e) this.f8a).a((String) this.f9b, ((L.h) this.f10c).c(serializable), bVar == null ? null : new L.a(0, this, bVar));
    }

    public void k(L.i iVar) {
        a aVar = new a(13, this, iVar);
        ((L.e) this.f8a).d((String) this.f9b, aVar);
    }

    public e(int i2) {
        switch (i2) {
            case 3:
                this.f8a = new ConcurrentLinkedQueue();
                break;
            default:
                b bVar = new b(1);
                b bVar2 = new b(0);
                this.f8a = new HashSet();
                this.f9b = bVar;
                this.f10c = bVar2;
                break;
        }
    }

    public e(F.b bVar, FlutterJNI flutterJNI) {
        v vVar = new v(5, this);
        e eVar = new e(bVar, "flutter/accessibility", l.f308a);
        this.f8a = eVar;
        bVar.d("flutter/accessibility", new a(11, eVar, vVar));
        this.f9b = flutterJNI;
    }

    public e(L l2) {
        this.f8a = new HashSet();
        this.f10c = l2;
        y yVar = (y) l2;
        this.f9b = new K[]{new G(yVar.getBinaryMessenger()), new a(new K.c(yVar.getBinaryMessenger()))};
        new v(yVar.getBinaryMessenger()).f94c = this;
    }

    public e(i iVar) {
        this.f8a = iVar;
        this.f9b = new ReentrantLock();
        this.f10c = new WeakHashMap();
    }
}
