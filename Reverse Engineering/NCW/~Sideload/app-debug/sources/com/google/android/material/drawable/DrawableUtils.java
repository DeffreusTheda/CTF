package com.google.android.material.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class DrawableUtils {
    public static final int INTRINSIC_SIZE = -1;
    private static final int UNSPECIFIED_HEIGHT = -1;
    private static final int UNSPECIFIED_WIDTH = -1;

    private DrawableUtils() {
    }

    public static void setTint(Drawable drawable, int color) {
        boolean hasTint = color != 0;
        if (hasTint) {
            DrawableCompat.setTint(drawable, color);
        } else {
            DrawableCompat.setTintList(drawable, null);
        }
    }

    public static PorterDuffColorFilter updateTintFilter(Drawable drawable, ColorStateList tint, PorterDuff.Mode tintMode) {
        if (tint == null || tintMode == null) {
            return null;
        }
        int color = tint.getColorForState(drawable.getState(), 0);
        return new PorterDuffColorFilter(color, tintMode);
    }

    public static AttributeSet parseDrawableXml(Context context, int id, CharSequence startTag) {
        int type;
        try {
            XmlPullParser parser = context.getResources().getXml(id);
            do {
                type = parser.next();
                if (type == 2) {
                    break;
                }
            } while (type != 1);
            if (type != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (!TextUtils.equals(parser.getName(), startTag)) {
                throw new XmlPullParserException("Must have a <" + ((Object) startTag) + "> start tag");
            }
            AttributeSet attrs = Xml.asAttributeSet(parser);
            return attrs;
        } catch (IOException | XmlPullParserException e) {
            Resources.NotFoundException exception = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(id));
            exception.initCause(e);
            throw exception;
        }
    }

    public static void setRippleDrawableRadius(RippleDrawable drawable, int radius) {
        drawable.setRadius(radius);
    }

    public static Drawable createTintableDrawableIfNeeded(Drawable drawable, ColorStateList tintList, PorterDuff.Mode tintMode) {
        return createTintableMutatedDrawableIfNeeded(drawable, tintList, tintMode, false);
    }

    public static Drawable createTintableMutatedDrawableIfNeeded(Drawable drawable, ColorStateList tintList, PorterDuff.Mode tintMode) {
        return createTintableMutatedDrawableIfNeeded(drawable, tintList, tintMode, false);
    }

    private static Drawable createTintableMutatedDrawableIfNeeded(Drawable drawable, ColorStateList tintList, PorterDuff.Mode tintMode, boolean forceMutate) {
        if (drawable == null) {
            return null;
        }
        if (tintList != null) {
            drawable = DrawableCompat.wrap(drawable).mutate();
            if (tintMode != null) {
                DrawableCompat.setTintMode(drawable, tintMode);
            }
        } else if (forceMutate) {
            drawable.mutate();
        }
        return drawable;
    }

    public static Drawable compositeTwoLayeredDrawable(Drawable bottomLayerDrawable, Drawable topLayerDrawable) {
        return compositeTwoLayeredDrawable(bottomLayerDrawable, topLayerDrawable, -1, -1);
    }

    public static Drawable compositeTwoLayeredDrawable(Drawable bottomLayerDrawable, Drawable topLayerDrawable, int topLayerDesiredWidth, int topLayerDesiredHeight) {
        int topLayerNewHeight;
        int topLayerNewWidth;
        if (bottomLayerDrawable == null) {
            return topLayerDrawable;
        }
        if (topLayerDrawable == null) {
            return bottomLayerDrawable;
        }
        if (topLayerDesiredWidth == -1 || topLayerDesiredHeight == -1) {
        }
        if (topLayerDesiredWidth == -1) {
            topLayerDesiredWidth = getTopLayerIntrinsicWidth(bottomLayerDrawable, topLayerDrawable);
        }
        if (topLayerDesiredHeight == -1) {
            topLayerDesiredHeight = getTopLayerIntrinsicHeight(bottomLayerDrawable, topLayerDrawable);
        }
        if (topLayerDesiredWidth <= bottomLayerDrawable.getIntrinsicWidth() && topLayerDesiredHeight <= bottomLayerDrawable.getIntrinsicHeight()) {
            topLayerNewWidth = topLayerDesiredWidth;
            topLayerNewHeight = topLayerDesiredHeight;
        } else {
            float topLayerRatio = topLayerDesiredWidth / topLayerDesiredHeight;
            float bottomLayerRatio = bottomLayerDrawable.getIntrinsicWidth() / bottomLayerDrawable.getIntrinsicHeight();
            if (topLayerRatio >= bottomLayerRatio) {
                int topLayerNewWidth2 = bottomLayerDrawable.getIntrinsicWidth();
                int i = (int) (topLayerNewWidth2 / topLayerRatio);
                topLayerNewWidth = topLayerNewWidth2;
                topLayerNewHeight = i;
            } else {
                int topLayerNewHeight2 = bottomLayerDrawable.getIntrinsicHeight();
                topLayerNewHeight = topLayerNewHeight2;
                topLayerNewWidth = (int) (topLayerNewHeight2 * topLayerRatio);
            }
        }
        LayerDrawable drawable = new LayerDrawable(new Drawable[]{bottomLayerDrawable, topLayerDrawable});
        drawable.setLayerSize(1, topLayerNewWidth, topLayerNewHeight);
        drawable.setLayerGravity(1, 17);
        return drawable;
    }

    private static int getTopLayerIntrinsicWidth(Drawable bottomLayerDrawable, Drawable topLayerDrawable) {
        int topLayerIntrinsicWidth = topLayerDrawable.getIntrinsicWidth();
        return topLayerIntrinsicWidth != -1 ? topLayerIntrinsicWidth : bottomLayerDrawable.getIntrinsicWidth();
    }

    private static int getTopLayerIntrinsicHeight(Drawable bottomLayerDrawable, Drawable topLayerDrawable) {
        int topLayerIntrinsicHeight = topLayerDrawable.getIntrinsicHeight();
        return topLayerIntrinsicHeight != -1 ? topLayerIntrinsicHeight : bottomLayerDrawable.getIntrinsicHeight();
    }

    public static int[] getCheckedState(int[] state) {
        for (int i = 0; i < state.length; i++) {
            if (state[i] == 16842912) {
                return state;
            }
            if (state[i] == 0) {
                int[] newState = (int[]) state.clone();
                newState[i] = 16842912;
                return newState;
            }
        }
        int i2 = state.length;
        int[] newState2 = Arrays.copyOf(state, i2 + 1);
        newState2[state.length] = 16842912;
        return newState2;
    }

    public static int[] getUncheckedState(int[] state) {
        int[] newState = new int[state.length];
        int i = 0;
        for (int subState : state) {
            if (subState != 16842912) {
                newState[i] = subState;
                i++;
            }
        }
        return newState;
    }

    public static void setOutlineToPath(Outline outline, Path path) {
        if (Build.VERSION.SDK_INT >= 30) {
            OutlineCompatR.setPath(outline, path);
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                OutlineCompatL.setConvexPath(outline, path);
            } catch (IllegalArgumentException e) {
            }
        } else if (path.isConvex()) {
            OutlineCompatL.setConvexPath(outline, path);
        }
    }

    public static ColorStateList getColorStateListOrNull(Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT >= 29 && (drawable instanceof ColorStateListDrawable)) {
            return ((ColorStateListDrawable) drawable).getColorStateList();
        }
        return null;
    }

    private static class OutlineCompatR {
        private OutlineCompatR() {
        }

        static void setPath(Outline outline, Path path) {
            outline.setPath(path);
        }
    }

    private static class OutlineCompatL {
        private OutlineCompatL() {
        }

        static void setConvexPath(Outline outline, Path path) {
            outline.setConvexPath(path);
        }
    }
}
