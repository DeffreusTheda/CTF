package io.flutter.embedding.engine.mutatorsstack;

import B.b;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FlutterMutatorsStack {
    private List<b> mutators = new ArrayList();
    private Matrix finalMatrix = new Matrix();
    private List<Path> finalClippingPaths = new ArrayList();
    private float finalOpacity = 1.0f;

    public List<Path> getFinalClippingPaths() {
        return this.finalClippingPaths;
    }

    public Matrix getFinalMatrix() {
        return this.finalMatrix;
    }

    public float getFinalOpacity() {
        return this.finalOpacity;
    }

    public List<b> getMutators() {
        return this.mutators;
    }

    public void pushClipPath(Path path) {
        this.mutators.add(new b(4));
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRRect(int i2, int i3, int i4, int i5, float[] fArr) {
        Rect rect = new Rect(i2, i3, i4, i5);
        this.mutators.add(new b(4));
        Path path = new Path();
        path.addRoundRect(new RectF(rect), fArr, Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushClipRect(int i2, int i3, int i4, int i5) {
        Rect rect = new Rect(i2, i3, i4, i5);
        this.mutators.add(new b(4));
        Path path = new Path();
        path.addRect(new RectF(rect), Path.Direction.CCW);
        path.transform(this.finalMatrix);
        this.finalClippingPaths.add(path);
    }

    public void pushOpacity(float f2) {
        this.mutators.add(new b(4));
        this.finalOpacity *= f2;
    }

    public void pushTransform(float[] fArr) {
        Matrix matrix = new Matrix();
        matrix.setValues(fArr);
        this.mutators.add(new b(4));
        this.finalMatrix.preConcat(matrix);
    }
}
