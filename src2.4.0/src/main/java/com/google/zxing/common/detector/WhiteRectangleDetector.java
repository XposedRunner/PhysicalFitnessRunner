package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 10;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this(bitMatrix, 10, bitMatrix.getWidth() / 2, bitMatrix.getHeight() / 2);
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i, int i2, int i3) throws NotFoundException {
        this.image = bitMatrix;
        this.height = bitMatrix.getHeight();
        this.width = bitMatrix.getWidth();
        i /= 2;
        this.leftInit = i2 - i;
        this.rightInit = i2 + i;
        this.upInit = i3 - i;
        this.downInit = i3 + i;
        if (this.upInit < 0 || this.leftInit < 0 || this.downInit >= this.height || this.rightInit >= this.width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        if (x < ((float) this.width) / 2.0f) {
            return new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)};
        }
        return new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.image.get(i, i3)) {
                    return true;
                }
                i++;
            }
        } else {
            while (i <= i2) {
                if (this.image.get(i3, i)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private ResultPoint getBlackPointOnSegment(float f, float f2, float f3, float f4) {
        int round = MathUtils.round(MathUtils.distance(f, f2, f3, f4));
        float f5 = (float) round;
        f3 = (f3 - f) / f5;
        f4 = (f4 - f2) / f5;
        for (int i = 0; i < round; i++) {
            float f6 = (float) i;
            int round2 = MathUtils.round((f6 * f3) + f);
            int round3 = MathUtils.round((f6 * f4) + f2);
            if (this.image.get(round2, round3)) {
                return new ResultPoint((float) round2, (float) round3);
            }
        }
        return null;
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i = this.leftInit;
        int i2 = this.rightInit;
        int i3 = this.upInit;
        int i4 = this.downInit;
        boolean z = false;
        int i5 = 1;
        int i6 = i;
        boolean z2 = false;
        boolean z3 = z2;
        boolean z4 = z3;
        boolean z5 = z4;
        boolean z6 = z5;
        i = 1;
        while (i != 0) {
            boolean z7 = false;
            boolean z8 = true;
            while (true) {
                if ((z8 || !z2) && i2 < this.width) {
                    z8 = containsBlackPoint(i3, i4, i2, false);
                    if (z8) {
                        i2++;
                        z2 = true;
                        z7 = z2;
                    } else if (!z2) {
                        i2++;
                    }
                }
            }
            if (i2 < this.width) {
                z8 = true;
                while (true) {
                    if ((z8 || !z3) && i4 < this.height) {
                        z8 = containsBlackPoint(i6, i2, i4, true);
                        if (z8) {
                            i4++;
                            z3 = true;
                            z7 = z3;
                        } else if (!z3) {
                            i4++;
                        }
                    }
                }
                if (i4 < this.height) {
                    z8 = true;
                    while (true) {
                        if ((z8 || !z4) && i6 >= 0) {
                            z8 = containsBlackPoint(i3, i4, i6, false);
                            if (z8) {
                                i6--;
                                z4 = true;
                                z7 = z4;
                            } else if (!z4) {
                                i6--;
                            }
                        }
                    }
                    if (i6 >= 0) {
                        z8 = true;
                        while (true) {
                            if ((z8 || !z6) && i3 >= 0) {
                                z8 = containsBlackPoint(i6, i2, i3, true);
                                if (z8) {
                                    i3--;
                                    z6 = true;
                                    z7 = z6;
                                } else if (!z6) {
                                    i3--;
                                }
                            }
                        }
                        if (i3 >= 0) {
                            if (z7) {
                                z5 = true;
                            }
                            z8 = z7;
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z || !z5) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i7;
        i = i2 - i6;
        ResultPoint resultPoint = null;
        ResultPoint resultPoint2 = null;
        for (i7 = 1; i7 < i; i7++) {
            resultPoint2 = getBlackPointOnSegment((float) i6, (float) (i4 - i7), (float) (i6 + i7), (float) i4);
            if (resultPoint2 != null) {
                break;
            }
        }
        if (resultPoint2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultPoint3 = null;
        for (i7 = 1; i7 < i; i7++) {
            resultPoint3 = getBlackPointOnSegment((float) i6, (float) (i3 + i7), (float) (i6 + i7), (float) i3);
            if (resultPoint3 != null) {
                break;
            }
        }
        if (resultPoint3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultPoint4 = null;
        for (i7 = 1; i7 < i; i7++) {
            resultPoint4 = getBlackPointOnSegment((float) i2, (float) (i3 + i7), (float) (i2 - i7), (float) i3);
            if (resultPoint4 != null) {
                break;
            }
        }
        if (resultPoint4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        while (i5 < i) {
            resultPoint = getBlackPointOnSegment((float) i2, (float) (i4 - i5), (float) (i2 - i5), (float) i4);
            if (resultPoint != null) {
                break;
            }
            i5++;
        }
        if (resultPoint != null) {
            return centerEdges(resultPoint, resultPoint2, resultPoint4, resultPoint3);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
