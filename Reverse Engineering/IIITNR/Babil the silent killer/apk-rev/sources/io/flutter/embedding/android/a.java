package io.flutter.embedding.android;

import android.graphics.Matrix;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final Matrix f185e = new Matrix();

    /* renamed from: a, reason: collision with root package name */
    private final u.a f186a;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f188c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Integer, float[]> f189d = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final u f187b = u.a();

    public a(u.a aVar, boolean z2) {
        this.f186a = aVar;
        this.f188c = z2;
    }

    private void a(MotionEvent motionEvent, int i2, int i3, int i4, Matrix matrix, ByteBuffer byteBuffer) {
        long j2;
        long j3;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        InputDevice.MotionRange motionRange;
        if (i3 == -1) {
            return;
        }
        long d7 = this.f188c ? this.f187b.c(motionEvent).d() : 0L;
        int d8 = d(motionEvent.getToolType(i2));
        float[] fArr = {motionEvent.getX(i2), motionEvent.getY(i2)};
        matrix.mapPoints(fArr);
        if (d8 == 1) {
            j2 = motionEvent.getButtonState() & 31;
            if (j2 == 0 && motionEvent.getSource() == 8194 && i3 == 4) {
                this.f189d.put(Integer.valueOf(motionEvent.getPointerId(i2)), fArr);
            }
        } else {
            j2 = d8 == 2 ? (motionEvent.getButtonState() >> 4) & 15 : 0L;
        }
        boolean containsKey = this.f189d.containsKey(Integer.valueOf(motionEvent.getPointerId(i2)));
        int i5 = motionEvent.getActionMasked() == 8 ? 1 : 0;
        long eventTime = motionEvent.getEventTime() * 1000;
        byteBuffer.putLong(d7);
        byteBuffer.putLong(eventTime);
        if (containsKey) {
            byteBuffer.putLong(c(i3));
            j3 = 4;
        } else {
            byteBuffer.putLong(i3);
            j3 = d8;
        }
        byteBuffer.putLong(j3);
        byteBuffer.putLong(i5);
        byteBuffer.putLong(motionEvent.getPointerId(i2));
        byteBuffer.putLong(0L);
        if (containsKey) {
            float[] fArr2 = this.f189d.get(Integer.valueOf(motionEvent.getPointerId(i2)));
            byteBuffer.putDouble(fArr2[0]);
            byteBuffer.putDouble(fArr2[1]);
        } else {
            byteBuffer.putDouble(fArr[0]);
            byteBuffer.putDouble(fArr[1]);
        }
        byteBuffer.putDouble(0.0d);
        byteBuffer.putDouble(0.0d);
        byteBuffer.putLong(j2);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putDouble(motionEvent.getPressure(i2));
        if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
            d2 = 1.0d;
            d3 = 0.0d;
        } else {
            d3 = motionRange.getMin();
            d2 = motionRange.getMax();
        }
        byteBuffer.putDouble(d3);
        byteBuffer.putDouble(d2);
        if (d8 == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(24, i2));
            d4 = 0.0d;
        } else {
            d4 = 0.0d;
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d4);
        byteBuffer.putDouble(motionEvent.getSize(i2));
        byteBuffer.putDouble(motionEvent.getToolMajor(i2));
        byteBuffer.putDouble(motionEvent.getToolMinor(i2));
        byteBuffer.putDouble(d4);
        byteBuffer.putDouble(d4);
        byteBuffer.putDouble(motionEvent.getAxisValue(8, i2));
        if (d8 == 2) {
            byteBuffer.putDouble(motionEvent.getAxisValue(25, i2));
        } else {
            byteBuffer.putDouble(d4);
        }
        byteBuffer.putLong(i4);
        if (i5 == 1) {
            byteBuffer.putDouble(-motionEvent.getAxisValue(10));
            d5 = -motionEvent.getAxisValue(9);
        } else {
            d5 = 0.0d;
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d5);
        if (containsKey) {
            float[] fArr3 = this.f189d.get(Integer.valueOf(motionEvent.getPointerId(i2)));
            byteBuffer.putDouble(fArr[0] - fArr3[0]);
            byteBuffer.putDouble(fArr[1] - fArr3[1]);
            d6 = 0.0d;
        } else {
            d6 = 0.0d;
            byteBuffer.putDouble(0.0d);
            byteBuffer.putDouble(0.0d);
        }
        byteBuffer.putDouble(d6);
        byteBuffer.putDouble(d6);
        byteBuffer.putDouble(1.0d);
        byteBuffer.putDouble(d6);
        if (containsKey && c(i3) == 9) {
            this.f189d.remove(Integer.valueOf(motionEvent.getPointerId(i2)));
        }
    }

    private int b(int i2) {
        if (i2 == 0) {
            return 4;
        }
        if (i2 == 1) {
            return 6;
        }
        if (i2 == 5) {
            return 4;
        }
        if (i2 == 6) {
            return 6;
        }
        if (i2 == 2) {
            return 5;
        }
        if (i2 == 7) {
            return 3;
        }
        if (i2 == 3) {
            return 0;
        }
        return i2 == 8 ? 3 : -1;
    }

    private int c(int i2) {
        if (i2 == 4) {
            return 7;
        }
        if (i2 == 5) {
            return 8;
        }
        if (i2 == 6 || i2 == 0) {
            return 9;
        }
        throw new AssertionError("Unexpected pointer change");
    }

    private int d(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 != 3) {
            return i2 != 4 ? 5 : 3;
        }
        return 1;
    }

    public boolean e(MotionEvent motionEvent) {
        boolean z2 = Build.VERSION.SDK_INT >= 18 && motionEvent.isFromSource(2);
        boolean z3 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!z2 || !z3) {
            return false;
        }
        int b2 = b(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 35 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        a(motionEvent, motionEvent.getActionIndex(), b2, 0, f185e, allocateDirect);
        if (allocateDirect.position() % 280 != 0) {
            throw new AssertionError("Packet position is not on field boundary.");
        }
        this.f186a.i(allocateDirect, allocateDirect.position());
        return true;
    }

    public boolean f(MotionEvent motionEvent) {
        return g(motionEvent, f185e);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(android.view.MotionEvent r13, android.graphics.Matrix r14) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r0 * 35
            int r1 = r1 * 8
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocateDirect(r1)
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN
            r1.order(r2)
            int r2 = r13.getActionMasked()
            int r3 = r13.getActionMasked()
            int r9 = r12.b(r3)
            r3 = 0
            r10 = 1
            if (r2 == 0) goto L27
            r4 = 5
            if (r2 != r4) goto L25
            goto L27
        L25:
            r4 = 0
            goto L28
        L27:
            r4 = 1
        L28:
            if (r4 != 0) goto L31
            if (r2 == r10) goto L2f
            r5 = 6
            if (r2 != r5) goto L31
        L2f:
            r2 = 1
            goto L32
        L31:
            r2 = 0
        L32:
            if (r4 == 0) goto L42
        L34:
            int r4 = r13.getActionIndex()
            r6 = 0
            r2 = r12
            r3 = r13
            r5 = r9
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
            goto L6f
        L42:
            r11 = 0
            if (r2 == 0) goto L60
        L45:
            if (r11 >= r0) goto L34
            int r2 = r13.getActionIndex()
            if (r11 == r2) goto L5d
            int r2 = r13.getToolType(r11)
            if (r2 != r10) goto L5d
            r5 = 5
            r6 = 1
            r2 = r12
            r3 = r13
            r4 = r11
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
        L5d:
            int r11 = r11 + 1
            goto L45
        L60:
            if (r11 >= r0) goto L6f
            r6 = 0
            r2 = r12
            r3 = r13
            r4 = r11
            r5 = r9
            r7 = r14
            r8 = r1
            r2.a(r3, r4, r5, r6, r7, r8)
            int r11 = r11 + 1
            goto L60
        L6f:
            int r13 = r1.position()
            int r13 = r13 % 280
            if (r13 != 0) goto L81
            u.a r13 = r12.f186a
            int r14 = r1.position()
            r13.i(r1, r14)
            return r10
        L81:
            java.lang.AssertionError r13 = new java.lang.AssertionError
            java.lang.String r14 = "Packet position is not on field boundary"
            r13.<init>(r14)
            goto L8a
        L89:
            throw r13
        L8a:
            goto L89
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.a.g(android.view.MotionEvent, android.graphics.Matrix):boolean");
    }
}
