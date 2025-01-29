package io.flutter.plugin.editing;

import android.text.Editable;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;

/* loaded from: classes.dex */
public final class d extends BaseInputConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f648a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(View view, f fVar) {
        super(view, true);
        this.f648a = fVar;
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public final Editable getEditable() {
        return this.f648a;
    }
}
