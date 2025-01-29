package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: SpannableStringBuilder.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\u0007\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a0\u0010\b\u001a\u00020\u0004*\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\t2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a?\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\r2\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¢\u0006\u0002\u0010\u0010\u001a&\u0010\u0011\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a.\u0010\u0012\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0015\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0016\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0017\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b\u001a&\u0010\u0018\u001a\u00020\u0004*\u00020\u00042\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\b¨\u0006\u0019"}, d2 = {"buildSpannedString", "Landroid/text/SpannedString;", "builderAction", "Lkotlin/Function1;", "Landroid/text/SpannableStringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "backgroundColor", TypedValues.Custom.S_COLOR, "", "bold", "inSpans", "span", "", "spans", "", "(Landroid/text/SpannableStringBuilder;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Landroid/text/SpannableStringBuilder;", "italic", "scale", "proportion", "", "strikeThrough", "subscript", "superscript", "underline", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SpannableStringBuilderKt {
    public static final SpannedString buildSpannedString(Function1<? super SpannableStringBuilder, Unit> function1) {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        function1.invoke(builder);
        return new SpannedString(builder);
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder $this$inSpans, Object[] spans, Function1<? super SpannableStringBuilder, Unit> function1) {
        int start = $this$inSpans.length();
        function1.invoke($this$inSpans);
        for (Object span : spans) {
            $this$inSpans.setSpan(span, start, $this$inSpans.length(), 17);
        }
        return $this$inSpans;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder $this$inSpans, Object span, Function1<? super SpannableStringBuilder, Unit> function1) {
        int start = $this$inSpans.length();
        function1.invoke($this$inSpans);
        $this$inSpans.setSpan(span, start, $this$inSpans.length(), 17);
        return $this$inSpans;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder $this$bold, Function1<? super SpannableStringBuilder, Unit> function1) {
        Object span$iv = new StyleSpan(1);
        int start$iv = $this$bold.length();
        function1.invoke($this$bold);
        $this$bold.setSpan(span$iv, start$iv, $this$bold.length(), 17);
        return $this$bold;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder $this$italic, Function1<? super SpannableStringBuilder, Unit> function1) {
        Object span$iv = new StyleSpan(2);
        int start$iv = $this$italic.length();
        function1.invoke($this$italic);
        $this$italic.setSpan(span$iv, start$iv, $this$italic.length(), 17);
        return $this$italic;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder $this$underline, Function1<? super SpannableStringBuilder, Unit> function1) {
        Object span$iv = new UnderlineSpan();
        int start$iv = $this$underline.length();
        function1.invoke($this$underline);
        $this$underline.setSpan(span$iv, start$iv, $this$underline.length(), 17);
        return $this$underline;
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder $this$color, int color, Function1<? super SpannableStringBuilder, Unit> function1) {
        Object span$iv = new ForegroundColorSpan(color);
        int start$iv = $this$color.length();
        function1.invoke($this$color);
        $this$color.setSpan(span$iv, start$iv, $this$color.length(), 17);
        return $this$color;
    }

    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder $this$backgroundColor, int color, Function1<? super SpannableStringBuilder, Unit> function1) {
        Object span$iv = new BackgroundColorSpan(color);
        int start$iv = $this$backgroundColor.length();
        function1.invoke($this$backgroundColor);
        $this$backgroundColor.setSpan(span$iv, start$iv, $this$backgroundColor.length(), 17);
        return $this$backgroundColor;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder $this$strikeThrough, Function1<? super SpannableStringBuilder, Unit> function1) {
        Object span$iv = new StrikethroughSpan();
        int start$iv = $this$strikeThrough.length();
        function1.invoke($this$strikeThrough);
        $this$strikeThrough.setSpan(span$iv, start$iv, $this$strikeThrough.length(), 17);
        return $this$strikeThrough;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder $this$scale, float proportion, Function1<? super SpannableStringBuilder, Unit> function1) {
        Object span$iv = new RelativeSizeSpan(proportion);
        int start$iv = $this$scale.length();
        function1.invoke($this$scale);
        $this$scale.setSpan(span$iv, start$iv, $this$scale.length(), 17);
        return $this$scale;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder $this$superscript, Function1<? super SpannableStringBuilder, Unit> function1) {
        Object span$iv = new SuperscriptSpan();
        int start$iv = $this$superscript.length();
        function1.invoke($this$superscript);
        $this$superscript.setSpan(span$iv, start$iv, $this$superscript.length(), 17);
        return $this$superscript;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder $this$subscript, Function1<? super SpannableStringBuilder, Unit> function1) {
        Object span$iv = new SubscriptSpan();
        int start$iv = $this$subscript.length();
        function1.invoke($this$subscript);
        $this$subscript.setSpan(span$iv, start$iv, $this$subscript.length(), 17);
        return $this$subscript;
    }
}
