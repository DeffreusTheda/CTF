package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    VelocityTrackerFallback() {
    }

    void addMovement(MotionEvent event) {
        long eventTime = event.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i;
        int i2 = this.mDataPointsBufferSize;
        if (i2 != 20) {
            this.mDataPointsBufferSize = i2 + 1;
        }
        this.mMovements[i] = event.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    void computeCurrentVelocity(int units) {
        computeCurrentVelocity(units, Float.MAX_VALUE);
    }

    void computeCurrentVelocity(int units, float maxVelocity) {
        float currentVelocity = getCurrentVelocity() * units;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(maxVelocity))) {
            this.mLastComputedVelocity = -Math.abs(maxVelocity);
        } else if (this.mLastComputedVelocity > Math.abs(maxVelocity)) {
            this.mLastComputedVelocity = Math.abs(maxVelocity);
        }
    }

    float getAxisVelocity(int axis) {
        if (axis != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j;
        int i = this.mDataPointsBufferSize;
        if (i < 2) {
            return 0.0f;
        }
        int i2 = this.mDataPointsBufferLastUsedIndex;
        int firstValidIndex = ((i2 + 20) - (i - 1)) % 20;
        long lastEventTime = this.mEventTimes[i2];
        while (true) {
            jArr = this.mEventTimes;
            j = jArr[firstValidIndex];
            if (lastEventTime - j <= RANGE_MS) {
                break;
            }
            this.mDataPointsBufferSize--;
            firstValidIndex = (firstValidIndex + 1) % 20;
        }
        int i3 = this.mDataPointsBufferSize;
        if (i3 < 2) {
            return 0.0f;
        }
        if (i3 == 2) {
            int lastIndex = (firstValidIndex + 1) % 20;
            long j2 = jArr[lastIndex];
            if (j == j2) {
                return 0.0f;
            }
            return this.mMovements[lastIndex] / ((float) (j2 - j));
        }
        float work = 0.0f;
        int numDataPointsProcessed = 0;
        for (int i4 = 0; i4 < this.mDataPointsBufferSize - 1; i4++) {
            int currentIndex = i4 + firstValidIndex;
            long[] jArr2 = this.mEventTimes;
            long eventTime = jArr2[currentIndex % 20];
            int nextIndex = (currentIndex + 1) % 20;
            if (jArr2[nextIndex] != eventTime) {
                numDataPointsProcessed++;
                float vPrev = kineticEnergyToVelocity(work);
                float delta = this.mMovements[nextIndex];
                float vCurr = delta / ((float) (this.mEventTimes[nextIndex] - eventTime));
                work += (vCurr - vPrev) * Math.abs(vCurr);
                if (numDataPointsProcessed == 1) {
                    work *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(work);
    }

    private static float kineticEnergyToVelocity(float work) {
        return (work < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(work) * 2.0f));
    }
}
