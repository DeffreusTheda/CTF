package io.flutter.plugin.editing;

import D.v;
import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public final class g implements SpellCheckerSession.SpellCheckerSessionListener {

    /* renamed from: a, reason: collision with root package name */
    public final v f661a;

    /* renamed from: b, reason: collision with root package name */
    public final TextServicesManager f662b;

    /* renamed from: c, reason: collision with root package name */
    public SpellCheckerSession f663c;

    /* renamed from: d, reason: collision with root package name */
    public K.k f664d;

    public g(TextServicesManager textServicesManager, v vVar) {
        this.f662b = textServicesManager;
        this.f661a = vVar;
        vVar.f94c = this;
    }

    public final void a(String str, String str2, K.k kVar) {
        if (this.f664d != null) {
            kVar.a("error", "Previous spell check request still pending.", null);
            return;
        }
        this.f664d = kVar;
        Locale a2 = M.a.a(str);
        if (this.f663c == null) {
            this.f663c = this.f662b.newSpellCheckerSession(null, a2, this, true);
        }
        this.f663c.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public final void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        if (sentenceSuggestionsInfoArr.length == 0) {
            this.f664d.c(new ArrayList());
            this.f664d = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
        if (sentenceSuggestionsInfo == null) {
            this.f664d.c(new ArrayList());
            this.f664d = null;
            return;
        }
        for (int i2 = 0; i2 < sentenceSuggestionsInfo.getSuggestionsCount(); i2++) {
            SuggestionsInfo suggestionsInfoAt = sentenceSuggestionsInfo.getSuggestionsInfoAt(i2);
            int suggestionsCount = suggestionsInfoAt.getSuggestionsCount();
            if (suggestionsCount > 0) {
                HashMap hashMap = new HashMap();
                int offsetAt = sentenceSuggestionsInfo.getOffsetAt(i2);
                int lengthAt = sentenceSuggestionsInfo.getLengthAt(i2) + offsetAt;
                hashMap.put("startIndex", Integer.valueOf(offsetAt));
                hashMap.put("endIndex", Integer.valueOf(lengthAt));
                ArrayList arrayList2 = new ArrayList();
                boolean z2 = false;
                for (int i3 = 0; i3 < suggestionsCount; i3++) {
                    String suggestionAt = suggestionsInfoAt.getSuggestionAt(i3);
                    if (!suggestionAt.equals("")) {
                        arrayList2.add(suggestionAt);
                        z2 = true;
                    }
                }
                if (z2) {
                    hashMap.put("suggestions", arrayList2);
                    arrayList.add(hashMap);
                }
            }
        }
        this.f664d.c(arrayList);
        this.f664d = null;
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public final void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }
}
