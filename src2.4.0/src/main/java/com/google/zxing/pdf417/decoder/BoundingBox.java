package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

final class BoundingBox {
    private ResultPoint bottomLeft;
    private ResultPoint bottomRight;
    private BitMatrix image;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private ResultPoint topLeft;
    private ResultPoint topRight;

    BoundingBox(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        if (!(resultPoint == null && resultPoint3 == null) && (!(resultPoint2 == null && resultPoint4 == null) && ((resultPoint == null || resultPoint2 != null) && (resultPoint3 == null || resultPoint4 != null)))) {
            init(bitMatrix, resultPoint, resultPoint2, resultPoint3, resultPoint4);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    BoundingBox(BoundingBox boundingBox) {
        init(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox.topRight, boundingBox.bottomRight);
    }

    private void calculateMinMaxValues() {
        if (this.topLeft == null) {
            this.topLeft = new ResultPoint(0.0f, this.topRight.getY());
            this.bottomLeft = new ResultPoint(0.0f, this.bottomRight.getY());
        } else if (this.topRight == null) {
            this.topRight = new ResultPoint((float) (this.image.getWidth() - 1), this.topLeft.getY());
            this.bottomRight = new ResultPoint((float) (this.image.getWidth() - 1), this.bottomLeft.getY());
        }
        this.minX = (int) Math.min(this.topLeft.getX(), this.bottomLeft.getX());
        this.maxX = (int) Math.max(this.topRight.getX(), this.bottomRight.getX());
        this.minY = (int) Math.min(this.topLeft.getY(), this.topRight.getY());
        this.maxY = (int) Math.max(this.bottomLeft.getY(), this.bottomRight.getY());
    }

    private void init(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        this.image = bitMatrix;
        this.topLeft = resultPoint;
        this.bottomLeft = resultPoint2;
        this.topRight = resultPoint3;
        this.bottomRight = resultPoint4;
        calculateMinMaxValues();
    }

    static BoundingBox merge(BoundingBox boundingBox, BoundingBox boundingBox2) throws NotFoundException {
        return boundingBox == null ? boundingBox2 : boundingBox2 == null ? boundingBox : new BoundingBox(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox2.topRight, boundingBox2.bottomRight);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    public com.google.zxing.pdf417.decoder.BoundingBox addMissingRows(int r13, int r14, boolean r15) throws com.google.zxing.NotFoundException {
        /*
        r12 = this;
        r0 = r12.topLeft;
        r1 = r12.bottomLeft;
        r2 = r12.topRight;
        r3 = r12.bottomRight;
        if (r13 <= 0) goto L_0x002b;
    L_0x000a:
        if (r15 == 0) goto L_0x000f;
    L_0x000c:
        r4 = r12.topLeft;
        goto L_0x0011;
    L_0x000f:
        r4 = r12.topRight;
    L_0x0011:
        r5 = r4.getY();
        r5 = (int) r5;
        r5 = r5 - r13;
        if (r5 >= 0) goto L_0x001a;
    L_0x0019:
        r5 = 0;
    L_0x001a:
        r13 = new com.google.zxing.ResultPoint;
        r4 = r4.getX();
        r5 = (float) r5;
        r13.<init>(r4, r5);
        if (r15 == 0) goto L_0x0028;
    L_0x0026:
        r8 = r13;
        goto L_0x002c;
    L_0x0028:
        r10 = r13;
        r8 = r0;
        goto L_0x002d;
    L_0x002b:
        r8 = r0;
    L_0x002c:
        r10 = r2;
    L_0x002d:
        if (r14 <= 0) goto L_0x005d;
    L_0x002f:
        if (r15 == 0) goto L_0x0034;
    L_0x0031:
        r13 = r12.bottomLeft;
        goto L_0x0036;
    L_0x0034:
        r13 = r12.bottomRight;
    L_0x0036:
        r0 = r13.getY();
        r0 = (int) r0;
        r0 = r0 + r14;
        r14 = r12.image;
        r14 = r14.getHeight();
        if (r0 < r14) goto L_0x004c;
    L_0x0044:
        r14 = r12.image;
        r14 = r14.getHeight();
        r0 = r14 + -1;
    L_0x004c:
        r14 = new com.google.zxing.ResultPoint;
        r13 = r13.getX();
        r0 = (float) r0;
        r14.<init>(r13, r0);
        if (r15 == 0) goto L_0x005a;
    L_0x0058:
        r9 = r14;
        goto L_0x005e;
    L_0x005a:
        r11 = r14;
        r9 = r1;
        goto L_0x005f;
    L_0x005d:
        r9 = r1;
    L_0x005e:
        r11 = r3;
    L_0x005f:
        r12.calculateMinMaxValues();
        r13 = new com.google.zxing.pdf417.decoder.BoundingBox;
        r7 = r12.image;
        r6 = r13;
        r6.<init>(r7, r8, r9, r10, r11);
        return r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.BoundingBox.addMissingRows(int, int, boolean):com.google.zxing.pdf417.decoder.BoundingBox");
    }

    /* Access modifiers changed, original: 0000 */
    public ResultPoint getBottomLeft() {
        return this.bottomLeft;
    }

    /* Access modifiers changed, original: 0000 */
    public ResultPoint getBottomRight() {
        return this.bottomRight;
    }

    /* Access modifiers changed, original: 0000 */
    public int getMaxX() {
        return this.maxX;
    }

    /* Access modifiers changed, original: 0000 */
    public int getMaxY() {
        return this.maxY;
    }

    /* Access modifiers changed, original: 0000 */
    public int getMinX() {
        return this.minX;
    }

    /* Access modifiers changed, original: 0000 */
    public int getMinY() {
        return this.minY;
    }

    /* Access modifiers changed, original: 0000 */
    public ResultPoint getTopLeft() {
        return this.topLeft;
    }

    /* Access modifiers changed, original: 0000 */
    public ResultPoint getTopRight() {
        return this.topRight;
    }
}
