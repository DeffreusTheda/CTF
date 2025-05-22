package io.flutter.plugin.editing;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private CharSequence f432a;

    /* renamed from: b, reason: collision with root package name */
    private CharSequence f433b;

    /* renamed from: c, reason: collision with root package name */
    private int f434c;

    /* renamed from: d, reason: collision with root package name */
    private int f435d;

    /* renamed from: e, reason: collision with root package name */
    private int f436e;

    /* renamed from: f, reason: collision with root package name */
    private int f437f;

    /* renamed from: g, reason: collision with root package name */
    private int f438g;

    /* renamed from: h, reason: collision with root package name */
    private int f439h;

    public e(CharSequence charSequence, int i2, int i3, int i4, int i5) {
        this.f436e = i2;
        this.f437f = i3;
        this.f438g = i4;
        this.f439h = i5;
        a(charSequence, "", -1, -1);
    }

    public e(CharSequence charSequence, int i2, int i3, CharSequence charSequence2, int i4, int i5, int i6, int i7) {
        this.f436e = i4;
        this.f437f = i5;
        this.f438g = i6;
        this.f439h = i7;
        a(charSequence, charSequence2.toString(), i2, i3);
    }

    private void a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3) {
        this.f432a = charSequence;
        this.f433b = charSequence2;
        this.f434c = i2;
        this.f435d = i3;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.f432a.toString());
            jSONObject.put("deltaText", this.f433b.toString());
            jSONObject.put("deltaStart", this.f434c);
            jSONObject.put("deltaEnd", this.f435d);
            jSONObject.put("selectionBase", this.f436e);
            jSONObject.put("selectionExtent", this.f437f);
            jSONObject.put("composingBase", this.f438g);
            jSONObject.put("composingExtent", this.f439h);
        } catch (JSONException e2) {
            j.b.b("TextEditingDelta", "unable to create JSONObject: " + e2);
        }
        return jSONObject;
    }
}
