package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class FinderPattern extends ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    FinderPattern(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    private FinderPattern(float f, float f2, float f3, int i) {
        super(f, f2);
        this.estimatedModuleSize = f3;
        this.count = i;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean aboutEquals(float f, float f2, float f3) {
        boolean z = false;
        if (Math.abs(f2 - getY()) > f || Math.abs(f3 - getX()) > f) {
            return false;
        }
        f = Math.abs(f - this.estimatedModuleSize);
        if (f <= 1.0f || f <= this.estimatedModuleSize) {
            z = true;
        }
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public FinderPattern combineEstimate(float f, float f2, float f3) {
        int i = this.count + 1;
        float x = (((float) this.count) * getX()) + f2;
        f2 = (float) i;
        return new FinderPattern(x / f2, ((((float) this.count) * getY()) + f) / f2, ((((float) this.count) * this.estimatedModuleSize) + f3) / f2, i);
    }

    /* Access modifiers changed, original: 0000 */
    public int getCount() {
        return this.count;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }
}
