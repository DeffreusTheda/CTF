package io.flutter.plugin.editing;

import android.view.textservice.SentenceSuggestionsInfo;
import android.view.textservice.SpellCheckerSession;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import android.view.textservice.TextServicesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import v.n;
import w.i;

/* loaded from: classes.dex */
public class d implements n.b, SpellCheckerSession.SpellCheckerSessionListener {

    /* renamed from: a, reason: collision with root package name */
    private final n f428a;

    /* renamed from: b, reason: collision with root package name */
    private final TextServicesManager f429b;

    /* renamed from: c, reason: collision with root package name */
    private SpellCheckerSession f430c;

    /* renamed from: d, reason: collision with root package name */
    i.d f431d;

    public d(TextServicesManager textServicesManager, n nVar) {
        this.f429b = textServicesManager;
        this.f428a = nVar;
        nVar.b(this);
    }

    @Override // v.n.b
    public void a(String str, String str2, i.d dVar) {
        if (this.f431d != null) {
            dVar.a("error", "Previous spell check request still pending.", null);
        } else {
            this.f431d = dVar;
            c(str, str2);
        }
    }

    public void b() {
        this.f428a.b(null);
        SpellCheckerSession spellCheckerSession = this.f430c;
        if (spellCheckerSession != null) {
            spellCheckerSession.close();
        }
    }

    public void c(String str, String str2) {
        Locale b2 = x.a.b(str);
        if (this.f430c == null) {
            this.f430c = this.f429b.newSpellCheckerSession(null, b2, this, true);
        }
        this.f430c.getSentenceSuggestions(new TextInfo[]{new TextInfo(str2)}, 5);
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSentenceSuggestions(SentenceSuggestionsInfo[] sentenceSuggestionsInfoArr) {
        ArrayList arrayList;
        i.d dVar;
        if (sentenceSuggestionsInfoArr.length == 0) {
            dVar = this.f431d;
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList();
            SentenceSuggestionsInfo sentenceSuggestionsInfo = sentenceSuggestionsInfoArr[0];
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
                    for (int i3 = 0; i3 < suggestionsCount; i3++) {
                        arrayList2.add(suggestionsInfoAt.getSuggestionAt(i3));
                    }
                    hashMap.put("suggestions", arrayList2);
                    arrayList.add(hashMap);
                }
            }
            dVar = this.f431d;
        }
        dVar.b(arrayList);
        this.f431d = null;
    }

    @Override // android.view.textservice.SpellCheckerSession.SpellCheckerSessionListener
    public void onGetSuggestions(SuggestionsInfo[] suggestionsInfoArr) {
    }
}
