package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CheckedTextView;
import java.lang.reflect.Field;

/* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
public final class CheckedTextViewCompat {
    private static final String TAG = "CheckedTextViewCompat";

    private CheckedTextViewCompat() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCheckMarkTintList(CheckedTextView checkedTextView, ColorStateList tint) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.setCheckMarkTintList(checkedTextView, tint);
        } else if (checkedTextView instanceof TintableCheckedTextView) {
            ((TintableCheckedTextView) checkedTextView).setSupportCheckMarkTintList(tint);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList getCheckMarkTintList(CheckedTextView checkedTextView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getCheckMarkTintList(checkedTextView);
        }
        if (checkedTextView instanceof TintableCheckedTextView) {
            return ((TintableCheckedTextView) checkedTextView).getSupportCheckMarkTintList();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCheckMarkTintMode(CheckedTextView checkedTextView, PorterDuff.Mode tintMode) {
        if (Build.VERSION.SDK_INT >= 21) {
            Api21Impl.setCheckMarkTintMode(checkedTextView, tintMode);
        } else if (checkedTextView instanceof TintableCheckedTextView) {
            ((TintableCheckedTextView) checkedTextView).setSupportCheckMarkTintMode(tintMode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView checkedTextView) {
        if (Build.VERSION.SDK_INT >= 21) {
            return Api21Impl.getCheckMarkTintMode(checkedTextView);
        }
        if (checkedTextView instanceof TintableCheckedTextView) {
            return ((TintableCheckedTextView) checkedTextView).getSupportCheckMarkTintMode();
        }
        return null;
    }

    public static Drawable getCheckMarkDrawable(CheckedTextView textView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return Api16Impl.getCheckMarkDrawable(textView);
        }
        return Api14Impl.getCheckMarkDrawable(textView);
    }

    /* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
    private static class Api21Impl {
        private Api21Impl() {
        }

        static void setCheckMarkTintList(CheckedTextView textView, ColorStateList tint) {
            textView.setCheckMarkTintList(tint);
        }

        static ColorStateList getCheckMarkTintList(CheckedTextView textView) {
            return textView.getCheckMarkTintList();
        }

        static void setCheckMarkTintMode(CheckedTextView textView, PorterDuff.Mode tintMode) {
            textView.setCheckMarkTintMode(tintMode);
        }

        static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView textView) {
            return textView.getCheckMarkTintMode();
        }
    }

    /* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
    private static class Api16Impl {
        private Api16Impl() {
        }

        static Drawable getCheckMarkDrawable(CheckedTextView textView) {
            return textView.getCheckMarkDrawable();
        }
    }

    /* loaded from: /home/vinnie/CTF/Reverse Engineering/PicoCTF/timer/timer.d/classes.dex */
    private static class Api14Impl {
        private static Field sCheckMarkDrawableField;
        private static boolean sResolved;

        private Api14Impl() {
        }

        static Drawable getCheckMarkDrawable(CheckedTextView textView) {
            if (!sResolved) {
                try {
                    Field declaredField = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                    sCheckMarkDrawableField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i(CheckedTextViewCompat.TAG, "Failed to retrieve mCheckMarkDrawable field", e);
                }
                sResolved = true;
            }
            Field field = sCheckMarkDrawableField;
            if (field != null) {
                try {
                    return (Drawable) field.get(textView);
                } catch (IllegalAccessException e2) {
                    Log.i(CheckedTextViewCompat.TAG, "Failed to get check mark drawable via reflection", e2);
                    sCheckMarkDrawableField = null;
                }
            }
            return null;
        }
    }
}
