package io.flutter.view;

import D.v;
import D.w;
import android.R;
import android.content.ContentResolver;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class l extends AccessibilityNodeProvider {

    /* renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f829y = 0;

    /* renamed from: a, reason: collision with root package name */
    public final View f830a;

    /* renamed from: b, reason: collision with root package name */
    public final B.e f831b;

    /* renamed from: c, reason: collision with root package name */
    public final AccessibilityManager f832c;

    /* renamed from: d, reason: collision with root package name */
    public final AccessibilityViewEmbedder f833d;

    /* renamed from: e, reason: collision with root package name */
    public final io.flutter.plugin.platform.h f834e;

    /* renamed from: f, reason: collision with root package name */
    public final ContentResolver f835f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f836g;

    /* renamed from: h, reason: collision with root package name */
    public final HashMap f837h;

    /* renamed from: i, reason: collision with root package name */
    public h f838i;

    /* renamed from: j, reason: collision with root package name */
    public Integer f839j;

    /* renamed from: k, reason: collision with root package name */
    public int f840k;

    /* renamed from: l, reason: collision with root package name */
    public h f841l;
    public h m;

    /* renamed from: n, reason: collision with root package name */
    public h f842n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f843o;

    /* renamed from: p, reason: collision with root package name */
    public int f844p;

    /* renamed from: q, reason: collision with root package name */
    public Integer f845q;

    /* renamed from: r, reason: collision with root package name */
    public v f846r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f847s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f848t;
    public final b u;

    /* renamed from: v, reason: collision with root package name */
    public final c f849v;

    /* renamed from: w, reason: collision with root package name */
    public final d f850w;

    /* renamed from: x, reason: collision with root package name */
    public final w f851x;

    public l(View view, B.e eVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, io.flutter.plugin.platform.h hVar) {
        int i2;
        AccessibilityViewEmbedder accessibilityViewEmbedder = new AccessibilityViewEmbedder(view, 65536);
        this.f836g = new HashMap();
        this.f837h = new HashMap();
        this.f840k = 0;
        this.f843o = new ArrayList();
        this.f844p = 0;
        this.f845q = 0;
        this.f847s = false;
        this.f848t = false;
        this.u = new b(this);
        c cVar = new c(this);
        this.f849v = cVar;
        w wVar = new w(this, new Handler(), 1);
        this.f851x = wVar;
        this.f830a = view;
        this.f831b = eVar;
        this.f832c = accessibilityManager;
        this.f835f = contentResolver;
        this.f833d = accessibilityViewEmbedder;
        this.f834e = hVar;
        cVar.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(cVar);
        d dVar = new d(this, accessibilityManager);
        this.f850w = dVar;
        dVar.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(dVar);
        wVar.onChange(false, null);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, wVar);
        if (Build.VERSION.SDK_INT >= 31 && view != null && view.getResources() != null) {
            i2 = view.getResources().getConfiguration().fontWeightAdjustment;
            if (i2 == Integer.MAX_VALUE || i2 < 300) {
                this.f840k &= -9;
            } else {
                this.f840k |= 8;
            }
            ((FlutterJNI) eVar.f9b).setAccessibilityFeatures(this.f840k);
        }
        hVar.b(this);
    }

    public final f a(int i2) {
        HashMap hashMap = this.f837h;
        f fVar = (f) hashMap.get(Integer.valueOf(i2));
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f();
        fVar2.f775c = -1;
        fVar2.f774b = i2;
        fVar2.f773a = 267386881 + i2;
        hashMap.put(Integer.valueOf(i2), fVar2);
        return fVar2;
    }

    public final h b(int i2) {
        HashMap hashMap = this.f836g;
        h hVar = (h) hashMap.get(Integer.valueOf(i2));
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this);
        hVar2.f802b = i2;
        hashMap.put(Integer.valueOf(i2), hVar2);
        return hVar2;
    }

    public final AccessibilityEvent c(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        View view = this.f830a;
        obtain.setPackageName(view.getContext().getPackageName());
        obtain.setSource(view, i2);
        return obtain;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
        String str;
        int i3;
        int i4;
        int i5;
        h(true);
        if (i2 >= 65536) {
            return this.f833d.createAccessibilityNodeInfo(i2);
        }
        HashMap hashMap = this.f836g;
        View view = this.f830a;
        if (i2 == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(view);
            view.onInitializeAccessibilityNodeInfo(obtain);
            if (hashMap.containsKey(0)) {
                obtain.addChild(view, 0);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                obtain.setImportantForAccessibility(false);
            }
            return obtain;
        }
        h hVar = (h) hashMap.get(Integer.valueOf(i2));
        if (hVar == null) {
            return null;
        }
        int i6 = hVar.f809i;
        io.flutter.plugin.platform.h hVar2 = this.f834e;
        if (i6 != -1 && hVar2.d(i6)) {
            hVar2.c(hVar.f809i);
            return null;
        }
        AccessibilityNodeInfo obtain2 = AccessibilityNodeInfo.obtain(view, i2);
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 24) {
            obtain2.setImportantForAccessibility((hVar.i(12) || (h.b(hVar) == null && hVar.f804d == 0)) ? false : true);
        }
        obtain2.setViewIdResourceName("");
        String str2 = hVar.f814o;
        if (str2 != null) {
            obtain2.setViewIdResourceName(str2);
        }
        obtain2.setPackageName(view.getContext().getPackageName());
        obtain2.setClassName("android.view.View");
        obtain2.setSource(view, i2);
        obtain2.setFocusable(hVar.k());
        h hVar3 = this.f841l;
        if (hVar3 != null) {
            obtain2.setFocused(hVar3.f802b == i2);
        }
        h hVar4 = this.f838i;
        if (hVar4 != null) {
            obtain2.setAccessibilityFocused(hVar4.f802b == i2);
        }
        if (hVar.i(5)) {
            obtain2.setPassword(hVar.i(11));
            if (!hVar.i(21)) {
                obtain2.setClassName("android.widget.EditText");
            }
            obtain2.setEditable(!hVar.i(21));
            int i8 = hVar.f807g;
            if (i8 != -1 && (i5 = hVar.f808h) != -1) {
                obtain2.setTextSelection(i8, i5);
            }
            h hVar5 = this.f838i;
            if (hVar5 != null && hVar5.f802b == i2) {
                obtain2.setLiveRegion(1);
            }
            if (h.a(hVar, e.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                obtain2.addAction(256);
                i4 = 1;
            } else {
                i4 = 0;
            }
            if (h.a(hVar, e.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                obtain2.addAction(512);
                i4 = 1;
            }
            if (h.a(hVar, e.MOVE_CURSOR_FORWARD_BY_WORD)) {
                obtain2.addAction(256);
                i4 |= 2;
            }
            if (h.a(hVar, e.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                obtain2.addAction(512);
                i4 |= 2;
            }
            obtain2.setMovementGranularities(i4);
            if (hVar.f805e >= 0) {
                String str3 = hVar.f817r;
                obtain2.setMaxTextLength(((str3 == null ? 0 : str3.length()) - hVar.f806f) + hVar.f805e);
            }
        }
        if (h.a(hVar, e.SET_SELECTION)) {
            obtain2.addAction(131072);
        }
        if (h.a(hVar, e.COPY)) {
            obtain2.addAction(16384);
        }
        if (h.a(hVar, e.CUT)) {
            obtain2.addAction(65536);
        }
        if (h.a(hVar, e.PASTE)) {
            obtain2.addAction(32768);
        }
        if (h.a(hVar, e.SET_TEXT)) {
            obtain2.addAction(2097152);
        }
        if (hVar.i(4)) {
            obtain2.setClassName("android.widget.Button");
        }
        if (hVar.i(15)) {
            obtain2.setClassName("android.widget.ImageView");
        }
        if (h.a(hVar, e.DISMISS)) {
            obtain2.setDismissable(true);
            obtain2.addAction(1048576);
        }
        h hVar6 = hVar.f791P;
        if (hVar6 != null) {
            obtain2.setParent(view, hVar6.f802b);
        } else {
            obtain2.setParent(view);
        }
        int i9 = hVar.f779B;
        if (i9 != -1 && i7 >= 22) {
            obtain2.setTraversalAfter(view, i9);
        }
        Rect rect = hVar.f800Z;
        h hVar7 = hVar.f791P;
        if (hVar7 != null) {
            Rect rect2 = hVar7.f800Z;
            Rect rect3 = new Rect(rect);
            rect3.offset(-rect2.left, -rect2.top);
            obtain2.setBoundsInParent(rect3);
        } else {
            obtain2.setBoundsInParent(rect);
        }
        Rect rect4 = new Rect(rect);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect4.offset(iArr[0], iArr[1]);
        obtain2.setBoundsInScreen(rect4);
        obtain2.setVisibleToUser(true);
        obtain2.setEnabled(!hVar.i(7) || hVar.i(8));
        if (h.a(hVar, e.TAP)) {
            if (hVar.f795T != null) {
                obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, hVar.f795T.f777e));
                obtain2.setClickable(true);
            } else {
                obtain2.addAction(16);
                obtain2.setClickable(true);
            }
        } else if (hVar.i(24)) {
            obtain2.addAction(16);
            obtain2.setClickable(true);
        }
        if (h.a(hVar, e.LONG_PRESS)) {
            if (hVar.f796U != null) {
                obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, hVar.f796U.f777e));
                obtain2.setLongClickable(true);
            } else {
                obtain2.addAction(32);
                obtain2.setLongClickable(true);
            }
        }
        e eVar = e.SCROLL_LEFT;
        boolean a2 = h.a(hVar, eVar);
        e eVar2 = e.SCROLL_DOWN;
        e eVar3 = e.SCROLL_UP;
        e eVar4 = e.SCROLL_RIGHT;
        if (a2 || h.a(hVar, eVar3) || h.a(hVar, eVar4) || h.a(hVar, eVar2)) {
            obtain2.setScrollable(true);
            if (hVar.i(19)) {
                if (h.a(hVar, eVar) || h.a(hVar, eVar4)) {
                    if (i(hVar)) {
                        obtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, hVar.f810j, false));
                    } else {
                        obtain2.setClassName("android.widget.HorizontalScrollView");
                    }
                } else if (i(hVar)) {
                    obtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(hVar.f810j, 0, false));
                } else {
                    obtain2.setClassName("android.widget.ScrollView");
                }
            }
            if (h.a(hVar, eVar) || h.a(hVar, eVar3)) {
                obtain2.addAction(4096);
            }
            if (h.a(hVar, eVar4) || h.a(hVar, eVar2)) {
                obtain2.addAction(8192);
            }
        }
        e eVar5 = e.INCREASE;
        boolean a3 = h.a(hVar, eVar5);
        e eVar6 = e.DECREASE;
        if (a3 || h.a(hVar, eVar6)) {
            obtain2.setClassName("android.widget.SeekBar");
            if (h.a(hVar, eVar5)) {
                obtain2.addAction(4096);
            }
            if (h.a(hVar, eVar6)) {
                obtain2.addAction(8192);
            }
        }
        if (hVar.i(16)) {
            obtain2.setLiveRegion(1);
        }
        if (hVar.i(5)) {
            obtain2.setText(h.e(hVar.f817r, hVar.f818s));
            if (i7 >= 28) {
                CharSequence[] charSequenceArr = {hVar.f(), h.e(hVar.f822x, hVar.f823y)};
                int i10 = 0;
                CharSequence charSequence = null;
                for (int i11 = 2; i10 < i11; i11 = 2) {
                    CharSequence charSequence2 = charSequenceArr[i10];
                    if (charSequence2 == null || charSequence2.length() <= 0) {
                        i3 = 1;
                    } else if (charSequence == null || charSequence.length() == 0) {
                        i3 = 1;
                        charSequence = charSequence2;
                    } else {
                        i3 = 1;
                        charSequence = TextUtils.concat(charSequence, ", ", charSequence2);
                    }
                    i10 += i3;
                }
                obtain2.setHintText(charSequence);
            }
        } else if (!hVar.i(12)) {
            CharSequence b2 = h.b(hVar);
            if (i7 < 28 && hVar.f824z != null) {
                b2 = ((Object) (b2 != null ? b2 : "")) + "\n" + hVar.f824z;
            }
            if (b2 != null) {
                obtain2.setContentDescription(b2);
            }
        }
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 28 && (str = hVar.f824z) != null) {
            obtain2.setTooltipText(str);
        }
        boolean z2 = true;
        boolean i13 = hVar.i(1);
        boolean i14 = hVar.i(17);
        if (!i13 && !i14) {
            z2 = false;
        }
        obtain2.setCheckable(z2);
        if (i13) {
            obtain2.setChecked(hVar.i(2));
            if (hVar.i(9)) {
                obtain2.setClassName("android.widget.RadioButton");
            } else {
                obtain2.setClassName("android.widget.CheckBox");
            }
        } else if (i14) {
            obtain2.setChecked(hVar.i(18));
            obtain2.setClassName("android.widget.Switch");
        }
        obtain2.setSelected(hVar.i(3));
        if (i12 >= 28) {
            obtain2.setHeading(hVar.i(10));
        }
        h hVar8 = this.f838i;
        if (hVar8 == null || hVar8.f802b != i2) {
            obtain2.addAction(64);
        } else {
            obtain2.addAction(128);
        }
        ArrayList arrayList = hVar.f794S;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                obtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(fVar.f773a, fVar.f776d));
            }
        }
        Iterator it2 = hVar.f792Q.iterator();
        while (it2.hasNext()) {
            h hVar9 = (h) it2.next();
            if (!hVar9.i(14)) {
                int i15 = hVar9.f809i;
                if (i15 != -1) {
                    hVar2.c(i15);
                    if (!hVar2.d(hVar9.f809i)) {
                        obtain2.addChild(null);
                    }
                }
                obtain2.addChild(view, hVar9.f802b);
            }
        }
        return obtain2;
    }

    public final boolean d(MotionEvent motionEvent, boolean z2) {
        h j2;
        if (!this.f832c.isTouchExplorationEnabled()) {
            return false;
        }
        HashMap hashMap = this.f836g;
        if (hashMap.isEmpty()) {
            return false;
        }
        h j3 = ((h) hashMap.get(0)).j(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z2);
        if (j3 != null && j3.f809i != -1) {
            if (z2) {
                return false;
            }
            return this.f833d.onAccessibilityHoverEvent(j3.f802b, motionEvent);
        }
        if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (!hashMap.isEmpty() && (j2 = ((h) hashMap.get(0)).j(new float[]{x2, y2, 0.0f, 1.0f}, z2)) != this.f842n) {
                if (j2 != null) {
                    f(j2.f802b, 128);
                }
                h hVar = this.f842n;
                if (hVar != null) {
                    f(hVar.f802b, 256);
                }
                this.f842n = j2;
            }
        } else {
            if (motionEvent.getAction() != 10) {
                motionEvent.toString();
                return false;
            }
            h hVar2 = this.f842n;
            if (hVar2 != null) {
                f(hVar2.f802b, 256);
                this.f842n = null;
            }
        }
        return true;
    }

    public final boolean e(h hVar, int i2, Bundle bundle, boolean z2) {
        int i3;
        int i4 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z3 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i5 = hVar.f807g;
        int i6 = hVar.f808h;
        if (i6 >= 0 && i5 >= 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 4) {
                        if (i4 == 8 || i4 == 16) {
                            if (z2) {
                                hVar.f808h = hVar.f817r.length();
                            } else {
                                hVar.f808h = 0;
                            }
                        }
                    } else if (z2 && i6 < hVar.f817r.length()) {
                        Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(hVar.f817r.substring(hVar.f808h));
                        if (matcher.find()) {
                            hVar.f808h += matcher.start(1);
                        } else {
                            hVar.f808h = hVar.f817r.length();
                        }
                    } else if (!z2 && hVar.f808h > 0) {
                        Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(hVar.f817r.substring(0, hVar.f808h));
                        if (matcher2.find()) {
                            hVar.f808h = matcher2.start(1);
                        } else {
                            hVar.f808h = 0;
                        }
                    }
                } else if (z2 && i6 < hVar.f817r.length()) {
                    Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(hVar.f817r.substring(hVar.f808h));
                    matcher3.find();
                    if (matcher3.find()) {
                        hVar.f808h += matcher3.start(1);
                    } else {
                        hVar.f808h = hVar.f817r.length();
                    }
                } else if (!z2 && hVar.f808h > 0) {
                    Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(hVar.f817r.substring(0, hVar.f808h));
                    if (matcher4.find()) {
                        hVar.f808h = matcher4.start(1);
                    }
                }
            } else if (z2 && i6 < hVar.f817r.length()) {
                hVar.f808h++;
            } else if (!z2 && (i3 = hVar.f808h) > 0) {
                hVar.f808h = i3 - 1;
            }
            if (!z3) {
                hVar.f807g = hVar.f808h;
            }
        }
        if (i5 != hVar.f807g || i6 != hVar.f808h) {
            String str = hVar.f817r;
            if (str == null) {
                str = "";
            }
            AccessibilityEvent c2 = c(hVar.f802b, 8192);
            c2.getText().add(str);
            c2.setFromIndex(hVar.f807g);
            c2.setToIndex(hVar.f808h);
            c2.setItemCount(str.length());
            g(c2);
        }
        B.e eVar = this.f831b;
        if (i4 == 1) {
            if (z2) {
                e eVar2 = e.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (h.a(hVar, eVar2)) {
                    eVar.c(i2, eVar2, Boolean.valueOf(z3));
                    return true;
                }
            }
            if (!z2) {
                e eVar3 = e.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
                if (h.a(hVar, eVar3)) {
                    eVar.c(i2, eVar3, Boolean.valueOf(z3));
                    return true;
                }
            }
        } else if (i4 == 2) {
            if (z2) {
                e eVar4 = e.MOVE_CURSOR_FORWARD_BY_WORD;
                if (h.a(hVar, eVar4)) {
                    eVar.c(i2, eVar4, Boolean.valueOf(z3));
                    return true;
                }
            }
            if (!z2) {
                e eVar5 = e.MOVE_CURSOR_BACKWARD_BY_WORD;
                if (h.a(hVar, eVar5)) {
                    eVar.c(i2, eVar5, Boolean.valueOf(z3));
                    return true;
                }
            }
        } else if (i4 == 4 || i4 == 8 || i4 == 16) {
            return true;
        }
        return false;
    }

    public final void f(int i2, int i3) {
        if (this.f832c.isEnabled()) {
            g(c(i2, i3));
        }
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i2) {
        if (i2 == 1) {
            h hVar = this.f841l;
            if (hVar != null) {
                return createAccessibilityNodeInfo(hVar.f802b);
            }
        } else if (i2 != 2) {
            return null;
        }
        h hVar2 = this.f838i;
        if (hVar2 != null) {
            return createAccessibilityNodeInfo(hVar2.f802b);
        }
        Integer num = this.f839j;
        if (num != null) {
            return createAccessibilityNodeInfo(num.intValue());
        }
        return null;
    }

    public final void g(AccessibilityEvent accessibilityEvent) {
        if (this.f832c.isEnabled()) {
            View view = this.f830a;
            view.getParent().requestSendAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public final void h(boolean z2) {
        if (this.f847s == z2) {
            return;
        }
        this.f847s = z2;
        if (z2) {
            this.f840k |= 1;
        } else {
            this.f840k &= -2;
        }
        ((FlutterJNI) this.f831b.f9b).setAccessibilityFeatures(this.f840k);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        if (r0 != null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(io.flutter.view.h r3) {
        /*
            r2 = this;
            int r0 = r3.f810j
            if (r0 <= 0) goto L31
            io.flutter.view.h r0 = r2.f838i
            r1 = 0
            if (r0 == 0) goto L17
            io.flutter.view.h r0 = r0.f791P
        Lb:
            if (r0 == 0) goto L13
            if (r0 != r3) goto L10
            goto L14
        L10:
            io.flutter.view.h r0 = r0.f791P
            goto Lb
        L13:
            r0 = r1
        L14:
            if (r0 == 0) goto L17
            goto L2f
        L17:
            io.flutter.view.h r3 = r2.f838i
            if (r3 == 0) goto L2f
            io.flutter.view.h r3 = r3.f791P
        L1d:
            if (r3 == 0) goto L2c
            r0 = 19
            boolean r0 = r3.i(r0)
            if (r0 == 0) goto L29
            r1 = r3
            goto L2c
        L29:
            io.flutter.view.h r3 = r3.f791P
            goto L1d
        L2c:
            if (r1 == 0) goto L2f
            goto L31
        L2f:
            r3 = 1
            goto L32
        L31:
            r3 = 0
        L32:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.l.i(io.flutter.view.h):boolean");
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i2, int i3, Bundle bundle) {
        if (i2 >= 65536) {
            boolean performAction = this.f833d.performAction(i2, i3, bundle);
            if (performAction && i3 == 128) {
                this.f839j = null;
            }
            return performAction;
        }
        HashMap hashMap = this.f836g;
        h hVar = (h) hashMap.get(Integer.valueOf(i2));
        if (hVar == null) {
            return false;
        }
        e eVar = e.INCREASE;
        e eVar2 = e.DECREASE;
        B.e eVar3 = this.f831b;
        switch (i3) {
            case 16:
                eVar3.b(i2, e.TAP);
                return true;
            case 32:
                eVar3.b(i2, e.LONG_PRESS);
                return true;
            case 64:
                if (this.f838i == null) {
                    this.f830a.invalidate();
                }
                this.f838i = hVar;
                eVar3.b(i2, e.DID_GAIN_ACCESSIBILITY_FOCUS);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("type", "didGainFocus");
                hashMap2.put("nodeId", Integer.valueOf(hVar.f802b));
                ((B.e) eVar3.f8a).j(hashMap2, null);
                f(i2, 32768);
                if (h.a(hVar, eVar) || h.a(hVar, eVar2)) {
                    f(i2, 4);
                }
                return true;
            case 128:
                h hVar2 = this.f838i;
                if (hVar2 != null && hVar2.f802b == i2) {
                    this.f838i = null;
                }
                Integer num = this.f839j;
                if (num != null && num.intValue() == i2) {
                    this.f839j = null;
                }
                eVar3.b(i2, e.DID_LOSE_ACCESSIBILITY_FOCUS);
                f(i2, 65536);
                return true;
            case 256:
                return e(hVar, i2, bundle, true);
            case 512:
                return e(hVar, i2, bundle, false);
            case 4096:
                e eVar4 = e.SCROLL_UP;
                if (h.a(hVar, eVar4)) {
                    eVar3.b(i2, eVar4);
                } else {
                    e eVar5 = e.SCROLL_LEFT;
                    if (h.a(hVar, eVar5)) {
                        eVar3.b(i2, eVar5);
                    } else {
                        if (!h.a(hVar, eVar)) {
                            return false;
                        }
                        hVar.f817r = hVar.f819t;
                        hVar.f818s = hVar.u;
                        f(i2, 4);
                        eVar3.b(i2, eVar);
                    }
                }
                return true;
            case 8192:
                e eVar6 = e.SCROLL_DOWN;
                if (h.a(hVar, eVar6)) {
                    eVar3.b(i2, eVar6);
                } else {
                    e eVar7 = e.SCROLL_RIGHT;
                    if (h.a(hVar, eVar7)) {
                        eVar3.b(i2, eVar7);
                    } else {
                        if (!h.a(hVar, eVar2)) {
                            return false;
                        }
                        hVar.f817r = hVar.f820v;
                        hVar.f818s = hVar.f821w;
                        f(i2, 4);
                        eVar3.b(i2, eVar2);
                    }
                }
                return true;
            case 16384:
                eVar3.b(i2, e.COPY);
                return true;
            case 32768:
                eVar3.b(i2, e.PASTE);
                return true;
            case 65536:
                eVar3.b(i2, e.CUT);
                return true;
            case 131072:
                HashMap hashMap3 = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    hashMap3.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    hashMap3.put("extent", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
                } else {
                    hashMap3.put("base", Integer.valueOf(hVar.f808h));
                    hashMap3.put("extent", Integer.valueOf(hVar.f808h));
                }
                eVar3.c(i2, e.SET_SELECTION, hashMap3);
                h hVar3 = (h) hashMap.get(Integer.valueOf(i2));
                hVar3.f807g = ((Integer) hashMap3.get("base")).intValue();
                hVar3.f808h = ((Integer) hashMap3.get("extent")).intValue();
                return true;
            case 1048576:
                eVar3.b(i2, e.DISMISS);
                return true;
            case 2097152:
                String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
                eVar3.c(i2, e.SET_TEXT, string);
                hVar.f817r = string;
                hVar.f818s = null;
                return true;
            case R.id.accessibilityActionShowOnScreen:
                eVar3.b(i2, e.SHOW_ON_SCREEN);
                return true;
            default:
                f fVar = (f) this.f837h.get(Integer.valueOf(i3 - 267386881));
                if (fVar == null) {
                    return false;
                }
                eVar3.c(i2, e.CUSTOM_ACTION, Integer.valueOf(fVar.f774b));
                return true;
        }
    }
}
