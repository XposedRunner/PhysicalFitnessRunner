package com.google.zxing.common;

import com.google.zxing.NotFoundException;

public abstract class GridSampler {
    private static GridSampler gridSampler = new DefaultGridSampler();

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073  */
    protected static void checkAndNudgePoints(com.google.zxing.common.BitMatrix r9, float[] r10) throws com.google.zxing.NotFoundException {
        /*
        r0 = r9.getWidth();
        r9 = r9.getHeight();
        r1 = 0;
        r2 = 1;
        r3 = r1;
        r4 = r2;
    L_0x000c:
        r5 = 0;
        r6 = -1;
        r7 = r10.length;
        if (r3 >= r7) goto L_0x0049;
    L_0x0011:
        if (r4 == 0) goto L_0x0049;
    L_0x0013:
        r4 = r10[r3];
        r4 = (int) r4;
        r7 = r3 + 1;
        r8 = r10[r7];
        r8 = (int) r8;
        if (r4 < r6) goto L_0x0044;
    L_0x001d:
        if (r4 > r0) goto L_0x0044;
    L_0x001f:
        if (r8 < r6) goto L_0x0044;
    L_0x0021:
        if (r8 <= r9) goto L_0x0024;
    L_0x0023:
        goto L_0x0044;
    L_0x0024:
        if (r4 != r6) goto L_0x002a;
    L_0x0026:
        r10[r3] = r5;
    L_0x0028:
        r4 = r2;
        goto L_0x0033;
    L_0x002a:
        if (r4 != r0) goto L_0x0032;
    L_0x002c:
        r4 = r0 + -1;
        r4 = (float) r4;
        r10[r3] = r4;
        goto L_0x0028;
    L_0x0032:
        r4 = r1;
    L_0x0033:
        if (r8 != r6) goto L_0x0039;
    L_0x0035:
        r10[r7] = r5;
    L_0x0037:
        r4 = r2;
        goto L_0x0041;
    L_0x0039:
        if (r8 != r9) goto L_0x0041;
    L_0x003b:
        r4 = r9 + -1;
        r4 = (float) r4;
        r10[r7] = r4;
        goto L_0x0037;
    L_0x0041:
        r3 = r3 + 2;
        goto L_0x000c;
    L_0x0044:
        r9 = com.google.zxing.NotFoundException.getNotFoundInstance();
        throw r9;
    L_0x0049:
        r3 = r10.length;
        r3 = r3 + -2;
        r4 = r2;
    L_0x004d:
        if (r3 < 0) goto L_0x0087;
    L_0x004f:
        if (r4 == 0) goto L_0x0087;
    L_0x0051:
        r4 = r10[r3];
        r4 = (int) r4;
        r7 = r3 + 1;
        r8 = r10[r7];
        r8 = (int) r8;
        if (r4 < r6) goto L_0x0082;
    L_0x005b:
        if (r4 > r0) goto L_0x0082;
    L_0x005d:
        if (r8 < r6) goto L_0x0082;
    L_0x005f:
        if (r8 <= r9) goto L_0x0062;
    L_0x0061:
        goto L_0x0082;
    L_0x0062:
        if (r4 != r6) goto L_0x0068;
    L_0x0064:
        r10[r3] = r5;
    L_0x0066:
        r4 = r2;
        goto L_0x0071;
    L_0x0068:
        if (r4 != r0) goto L_0x0070;
    L_0x006a:
        r4 = r0 + -1;
        r4 = (float) r4;
        r10[r3] = r4;
        goto L_0x0066;
    L_0x0070:
        r4 = r1;
    L_0x0071:
        if (r8 != r6) goto L_0x0077;
    L_0x0073:
        r10[r7] = r5;
    L_0x0075:
        r4 = r2;
        goto L_0x007f;
    L_0x0077:
        if (r8 != r9) goto L_0x007f;
    L_0x0079:
        r4 = r9 + -1;
        r4 = (float) r4;
        r10[r7] = r4;
        goto L_0x0075;
    L_0x007f:
        r3 = r3 + -2;
        goto L_0x004d;
    L_0x0082:
        r9 = com.google.zxing.NotFoundException.getNotFoundInstance();
        throw r9;
    L_0x0087:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.GridSampler.checkAndNudgePoints(com.google.zxing.common.BitMatrix, float[]):void");
    }

    public static GridSampler getInstance() {
        return gridSampler;
    }

    public static void setGridSampler(GridSampler gridSampler) {
        gridSampler = gridSampler;
    }

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException;

    public abstract BitMatrix sampleGrid(BitMatrix bitMatrix, int i, int i2, PerspectiveTransform perspectiveTransform) throws NotFoundException;
}
