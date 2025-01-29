package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Region.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a0\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\b\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¨\u0006\u0017"}, d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", "p", "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "iterator", "", "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RegionKt {
    public static final boolean contains(Region $this$contains, Point p) {
        return $this$contains.contains(p.x, p.y);
    }

    public static final Region plus(Region $this$plus, Rect r) {
        Region $this$plus_u24lambda_u240 = new Region($this$plus);
        $this$plus_u24lambda_u240.union(r);
        return $this$plus_u24lambda_u240;
    }

    public static final Region plus(Region $this$plus, Region r) {
        Region $this$plus_u24lambda_u241 = new Region($this$plus);
        $this$plus_u24lambda_u241.op(r, Region.Op.UNION);
        return $this$plus_u24lambda_u241;
    }

    public static final Region minus(Region $this$minus, Rect r) {
        Region $this$minus_u24lambda_u242 = new Region($this$minus);
        $this$minus_u24lambda_u242.op(r, Region.Op.DIFFERENCE);
        return $this$minus_u24lambda_u242;
    }

    public static final Region minus(Region $this$minus, Region r) {
        Region $this$minus_u24lambda_u243 = new Region($this$minus);
        $this$minus_u24lambda_u243.op(r, Region.Op.DIFFERENCE);
        return $this$minus_u24lambda_u243;
    }

    public static final Region unaryMinus(Region $this$unaryMinus) {
        Region $this$unaryMinus_u24lambda_u244 = new Region($this$unaryMinus.getBounds());
        $this$unaryMinus_u24lambda_u244.op($this$unaryMinus, Region.Op.DIFFERENCE);
        return $this$unaryMinus_u24lambda_u244;
    }

    public static final Region not(Region $this$not) {
        Region $this$unaryMinus_u24lambda_u244$iv = new Region($this$not.getBounds());
        $this$unaryMinus_u24lambda_u244$iv.op($this$not, Region.Op.DIFFERENCE);
        return $this$unaryMinus_u24lambda_u244$iv;
    }

    public static final Region or(Region $this$or, Rect r) {
        Region $this$plus_u24lambda_u240$iv = new Region($this$or);
        $this$plus_u24lambda_u240$iv.union(r);
        return $this$plus_u24lambda_u240$iv;
    }

    public static final Region or(Region $this$or, Region r) {
        Region $this$plus_u24lambda_u241$iv = new Region($this$or);
        $this$plus_u24lambda_u241$iv.op(r, Region.Op.UNION);
        return $this$plus_u24lambda_u241$iv;
    }

    public static final Region and(Region $this$and, Rect r) {
        Region $this$and_u24lambda_u245 = new Region($this$and);
        $this$and_u24lambda_u245.op(r, Region.Op.INTERSECT);
        return $this$and_u24lambda_u245;
    }

    public static final Region and(Region $this$and, Region r) {
        Region $this$and_u24lambda_u246 = new Region($this$and);
        $this$and_u24lambda_u246.op(r, Region.Op.INTERSECT);
        return $this$and_u24lambda_u246;
    }

    public static final Region xor(Region $this$xor, Rect r) {
        Region $this$xor_u24lambda_u247 = new Region($this$xor);
        $this$xor_u24lambda_u247.op(r, Region.Op.XOR);
        return $this$xor_u24lambda_u247;
    }

    public static final Region xor(Region $this$xor, Region r) {
        Region $this$xor_u24lambda_u248 = new Region($this$xor);
        $this$xor_u24lambda_u248.op(r, Region.Op.XOR);
        return $this$xor_u24lambda_u248;
    }

    public static final void forEach(Region $this$forEach, Function1<? super Rect, Unit> function1) {
        RegionIterator iterator = new RegionIterator($this$forEach);
        while (true) {
            Rect r = new Rect();
            if (iterator.next(r)) {
                function1.invoke(r);
            } else {
                return;
            }
        }
    }

    public static final Iterator<Rect> iterator(Region $this$iterator) {
        return new RegionKt$iterator$1($this$iterator);
    }
}
