package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0035 A:{SYNTHETIC, EDGE_INSN: B:51:0x0035->B:16:0x0035 ?: BREAK  , EDGE_INSN: B:51:0x0035->B:16:0x0035 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x006f A:{SYNTHETIC, EDGE_INSN: B:64:0x006f->B:36:0x006f ?: BREAK  , EDGE_INSN: B:64:0x006f->B:36:0x006f ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c  */
    private int[] blackWhiteRange(int r6, int r7, int r8, int r9, boolean r10) {
        /*
        r5 = this;
        r0 = r8 + r9;
        r1 = 2;
        r0 = r0 / r1;
        r2 = r0;
    L_0x0005:
        if (r2 < r8) goto L_0x003e;
    L_0x0007:
        if (r10 == 0) goto L_0x0012;
    L_0x0009:
        r3 = r5.image;
        r3 = r3.get(r2, r6);
        if (r3 == 0) goto L_0x001d;
    L_0x0011:
        goto L_0x001a;
    L_0x0012:
        r3 = r5.image;
        r3 = r3.get(r6, r2);
        if (r3 == 0) goto L_0x001d;
    L_0x001a:
        r2 = r2 + -1;
        goto L_0x0005;
    L_0x001d:
        r3 = r2;
    L_0x001e:
        r3 = r3 + -1;
        if (r3 < r8) goto L_0x0035;
    L_0x0022:
        if (r10 == 0) goto L_0x002d;
    L_0x0024:
        r4 = r5.image;
        r4 = r4.get(r3, r6);
        if (r4 == 0) goto L_0x001e;
    L_0x002c:
        goto L_0x0035;
    L_0x002d:
        r4 = r5.image;
        r4 = r4.get(r6, r3);
        if (r4 == 0) goto L_0x001e;
    L_0x0035:
        r4 = r2 - r3;
        if (r3 < r8) goto L_0x003e;
    L_0x0039:
        if (r4 <= r7) goto L_0x003c;
    L_0x003b:
        goto L_0x003e;
    L_0x003c:
        r2 = r3;
        goto L_0x0005;
    L_0x003e:
        r8 = 1;
        r2 = r2 + r8;
    L_0x0040:
        if (r0 >= r9) goto L_0x0078;
    L_0x0042:
        if (r10 == 0) goto L_0x004d;
    L_0x0044:
        r3 = r5.image;
        r3 = r3.get(r0, r6);
        if (r3 == 0) goto L_0x0058;
    L_0x004c:
        goto L_0x0055;
    L_0x004d:
        r3 = r5.image;
        r3 = r3.get(r6, r0);
        if (r3 == 0) goto L_0x0058;
    L_0x0055:
        r0 = r0 + 1;
        goto L_0x0040;
    L_0x0058:
        r3 = r0;
    L_0x0059:
        r3 = r3 + r8;
        if (r3 >= r9) goto L_0x006f;
    L_0x005c:
        if (r10 == 0) goto L_0x0067;
    L_0x005e:
        r4 = r5.image;
        r4 = r4.get(r3, r6);
        if (r4 == 0) goto L_0x0059;
    L_0x0066:
        goto L_0x006f;
    L_0x0067:
        r4 = r5.image;
        r4 = r4.get(r6, r3);
        if (r4 == 0) goto L_0x0059;
    L_0x006f:
        r4 = r3 - r0;
        if (r3 >= r9) goto L_0x0078;
    L_0x0073:
        if (r4 <= r7) goto L_0x0076;
    L_0x0075:
        goto L_0x0078;
    L_0x0076:
        r0 = r3;
        goto L_0x0040;
    L_0x0078:
        r0 = r0 + -1;
        if (r0 <= r2) goto L_0x0084;
    L_0x007c:
        r6 = new int[r1];
        r7 = 0;
        r6[r7] = r2;
        r6[r8] = r0;
        goto L_0x0085;
    L_0x0084:
        r6 = 0;
    L_0x0085:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.detector.MonochromeRectangleDetector.blackWhiteRange(int, int, int, int, boolean):int[]");
    }

    private ResultPoint findCornerFromCenter(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws NotFoundException {
        int i10 = i;
        int i11 = i5;
        int i12 = i10;
        int i13 = i11;
        int[] iArr = null;
        int i14 = i8;
        while (i13 < i14) {
            int i15 = i7;
            if (i13 < i15) {
                break;
            }
            int i16 = i4;
            if (i12 >= i16) {
                break;
            }
            int i17 = i3;
            if (i12 < i17) {
                break;
            }
            int[] blackWhiteRange = i2 == 0 ? blackWhiteRange(i13, i9, i17, i16, true) : blackWhiteRange(i12, i9, i15, i14, false);
            if (blackWhiteRange != null) {
                i13 += i6;
                i12 += i2;
                iArr = blackWhiteRange;
            } else if (iArr == null) {
                throw NotFoundException.getNotFoundInstance();
            } else if (i2 == 0) {
                i13 -= i6;
                if (iArr[0] >= i10) {
                    return new ResultPoint((float) iArr[1], (float) i13);
                }
                if (iArr[1] <= i10) {
                    return new ResultPoint((float) iArr[0], (float) i13);
                }
                return new ResultPoint((float) (i6 > 0 ? iArr[0] : iArr[1]), (float) i13);
            } else {
                i12 -= i2;
                if (iArr[0] >= i11) {
                    return new ResultPoint((float) i12, (float) iArr[1]);
                }
                if (iArr[1] <= i11) {
                    return new ResultPoint((float) i12, (float) iArr[0]);
                }
                return new ResultPoint((float) i12, (float) (i2 < 0 ? iArr[0] : iArr[1]));
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public ResultPoint[] detect() throws NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = height / 2;
        int i2 = width / 2;
        int max = Math.max(1, height / 256);
        int i3 = -max;
        int i4 = i2 / 2;
        int i5 = i2;
        int i6 = width;
        int i7 = i;
        int i8 = i3;
        int max2 = Math.max(1, width / 256);
        int i9 = height;
        int i10 = max;
        max = max2;
        max2 = i / 2;
        i3 = ((int) findCornerFromCenter(i5, 0, 0, i6, i7, i3, 0, i9, i4).getY()) - 1;
        int i11 = max;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i5, -max, 0, i6, i7, 0, i3, i9, max2);
        int x = ((int) findCornerFromCenter.getX()) - 1;
        ResultPoint resultPoint = findCornerFromCenter;
        findCornerFromCenter = findCornerFromCenter(i5, i11, x, i6, i7, 0, i3, i9, max2);
        i6 = ((int) findCornerFromCenter.getX()) + 1;
        ResultPoint resultPoint2 = findCornerFromCenter;
        findCornerFromCenter = findCornerFromCenter(i5, 0, x, i6, i7, i10, i3, i9, i4);
        ResultPoint resultPoint3 = findCornerFromCenter;
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i5, 0, x, i6, i7, i8, i3, ((int) findCornerFromCenter.getY()) + 1, i2 / 4);
        return new ResultPoint[]{findCornerFromCenter2, resultPoint, resultPoint2, resultPoint3};
    }
}
