package androidx.compose.ui.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.style.IndentationFixSpan;
import androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;

/* compiled from: AndroidParagraph.android.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a\u001d\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\t\u001a\u001d\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\r\u001a\u001d\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0011\u001a\u001d\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0019\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u001bH\u0002\u001a\u0014\u0010\u001c\u001a\u00020\u0006*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0002\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"shouldAttachIndentationFixSpan", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "ellipsis", "toLayoutAlign", "", "align", "Landroidx/compose/ui/text/style/TextAlign;", "toLayoutAlign-AMY3VfE", "toLayoutBreakStrategy", "breakStrategy", "Landroidx/compose/ui/text/style/LineBreak$Strategy;", "toLayoutBreakStrategy-u6PBz3U", "toLayoutHyphenationFrequency", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "toLayoutHyphenationFrequency-0_XeFpE", "toLayoutLineBreakStyle", "lineBreakStrictness", "Landroidx/compose/ui/text/style/LineBreak$Strictness;", "toLayoutLineBreakStyle-4a2g8L8", "toLayoutLineBreakWordStyle", "lineBreakWordStyle", "Landroidx/compose/ui/text/style/LineBreak$WordBreak;", "toLayoutLineBreakWordStyle-gvcdTPQ", "attachIndentationFixSpan", "", "numberOfLinesThatFitMaxHeight", "Landroidx/compose/ui/text/android/TextLayout;", "maxHeight", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidParagraph_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutAlign-AMY3VfE, reason: not valid java name */
    public static final int m4402toLayoutAlignAMY3VfE(TextAlign textAlign) {
        int m4902getLefte0LSkKk = TextAlign.INSTANCE.m4902getLefte0LSkKk();
        if (textAlign != null && TextAlign.m4895equalsimpl0(textAlign.getValue(), m4902getLefte0LSkKk)) {
            return 3;
        }
        int m4903getRighte0LSkKk = TextAlign.INSTANCE.m4903getRighte0LSkKk();
        if (textAlign != null && TextAlign.m4895equalsimpl0(textAlign.getValue(), m4903getRighte0LSkKk)) {
            return 4;
        }
        int m4899getCentere0LSkKk = TextAlign.INSTANCE.m4899getCentere0LSkKk();
        if (textAlign != null && TextAlign.m4895equalsimpl0(textAlign.getValue(), m4899getCentere0LSkKk)) {
            return 2;
        }
        int m4904getStarte0LSkKk = TextAlign.INSTANCE.m4904getStarte0LSkKk();
        if (textAlign == null || !TextAlign.m4895equalsimpl0(textAlign.getValue(), m4904getStarte0LSkKk)) {
            int m4900getEnde0LSkKk = TextAlign.INSTANCE.m4900getEnde0LSkKk();
            if (textAlign != null && TextAlign.m4895equalsimpl0(textAlign.getValue(), m4900getEnde0LSkKk)) {
                return 1;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutHyphenationFrequency-0_XeFpE, reason: not valid java name */
    public static final int m4404toLayoutHyphenationFrequency0_XeFpE(Hyphens hyphens) {
        int m4818getAutovmbZdU8 = Hyphens.INSTANCE.m4818getAutovmbZdU8();
        if (hyphens != null && Hyphens.m4814equalsimpl0(hyphens.getValue(), m4818getAutovmbZdU8)) {
            return Build.VERSION.SDK_INT <= 32 ? 2 : 4;
        }
        int m4819getNonevmbZdU8 = Hyphens.INSTANCE.m4819getNonevmbZdU8();
        if (hyphens != null) {
            Hyphens.m4814equalsimpl0(hyphens.getValue(), m4819getNonevmbZdU8);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutBreakStrategy-u6PBz3U, reason: not valid java name */
    public static final int m4403toLayoutBreakStrategyu6PBz3U(LineBreak.Strategy strategy) {
        int m4845getSimplefcGXIks = LineBreak.Strategy.INSTANCE.m4845getSimplefcGXIks();
        if (strategy != null && LineBreak.Strategy.m4839equalsimpl0(strategy.getValue(), m4845getSimplefcGXIks)) {
            return 0;
        }
        int m4844getHighQualityfcGXIks = LineBreak.Strategy.INSTANCE.m4844getHighQualityfcGXIks();
        if (strategy != null && LineBreak.Strategy.m4839equalsimpl0(strategy.getValue(), m4844getHighQualityfcGXIks)) {
            return 1;
        }
        return (strategy != null && LineBreak.Strategy.m4839equalsimpl0(strategy.getValue(), LineBreak.Strategy.INSTANCE.m4843getBalancedfcGXIks())) ? 2 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakStyle-4a2g8L8, reason: not valid java name */
    public static final int m4405toLayoutLineBreakStyle4a2g8L8(LineBreak.Strictness strictness) {
        int m4853getDefaultusljTpc = LineBreak.Strictness.INSTANCE.m4853getDefaultusljTpc();
        if (strictness != null && LineBreak.Strictness.m4849equalsimpl0(strictness.getValue(), m4853getDefaultusljTpc)) {
            return 0;
        }
        int m4854getLooseusljTpc = LineBreak.Strictness.INSTANCE.m4854getLooseusljTpc();
        if (strictness != null && LineBreak.Strictness.m4849equalsimpl0(strictness.getValue(), m4854getLooseusljTpc)) {
            return 1;
        }
        int m4855getNormalusljTpc = LineBreak.Strictness.INSTANCE.m4855getNormalusljTpc();
        if (strictness != null && LineBreak.Strictness.m4849equalsimpl0(strictness.getValue(), m4855getNormalusljTpc)) {
            return 2;
        }
        return (strictness != null && LineBreak.Strictness.m4849equalsimpl0(strictness.getValue(), LineBreak.Strictness.INSTANCE.m4856getStrictusljTpc())) ? 3 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toLayoutLineBreakWordStyle-gvcdTPQ, reason: not valid java name */
    public static final int m4406toLayoutLineBreakWordStylegvcdTPQ(LineBreak.WordBreak wordBreak) {
        int m4864getDefaultjp8hJ3c = LineBreak.WordBreak.INSTANCE.m4864getDefaultjp8hJ3c();
        if (wordBreak != null && LineBreak.WordBreak.m4860equalsimpl0(wordBreak.getValue(), m4864getDefaultjp8hJ3c)) {
            return 0;
        }
        return (wordBreak != null && LineBreak.WordBreak.m4860equalsimpl0(wordBreak.getValue(), LineBreak.WordBreak.INSTANCE.m4865getPhrasejp8hJ3c())) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int numberOfLinesThatFitMaxHeight(TextLayout textLayout, int i) {
        int lineCount = textLayout.getLineCount();
        for (int i2 = 0; i2 < lineCount; i2++) {
            if (textLayout.getLineBottom(i2) > i) {
                return i2;
            }
        }
        return textLayout.getLineCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean shouldAttachIndentationFixSpan(TextStyle textStyle, boolean z) {
        if (!z || TextUnit.m5195equalsimpl0(textStyle.m4558getLetterSpacingXSAIIZE(), TextUnitKt.getSp(0)) || TextUnit.m5195equalsimpl0(textStyle.m4558getLetterSpacingXSAIIZE(), TextUnit.INSTANCE.m5209getUnspecifiedXSAIIZE()) || textStyle.m4561getTextAlignbuA522U() == null) {
            return false;
        }
        TextAlign m4561getTextAlignbuA522U = textStyle.m4561getTextAlignbuA522U();
        int m4904getStarte0LSkKk = TextAlign.INSTANCE.m4904getStarte0LSkKk();
        if (m4561getTextAlignbuA522U != null && TextAlign.m4895equalsimpl0(m4561getTextAlignbuA522U.getValue(), m4904getStarte0LSkKk)) {
            return false;
        }
        TextAlign m4561getTextAlignbuA522U2 = textStyle.m4561getTextAlignbuA522U();
        return m4561getTextAlignbuA522U2 == null || !TextAlign.m4895equalsimpl0(m4561getTextAlignbuA522U2.getValue(), TextAlign.INSTANCE.m4901getJustifye0LSkKk());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence attachIndentationFixSpan(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return charSequence;
        }
        SpannableString spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
        SpannableExtensions_androidKt.setSpan(spannableString, new IndentationFixSpan(), spannableString.length() - 1, spannableString.length() - 1);
        return spannableString;
    }
}
