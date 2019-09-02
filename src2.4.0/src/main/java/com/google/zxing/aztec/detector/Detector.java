package com.google.zxing.aztec.detector;

import android.support.v4.media.TransportMediator;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Detector {
    private static final int[] EXPECTED_CORNER_BITS = new int[]{3808, 476, 2107, 1799};
    private boolean compact;
    private final BitMatrix image;
    private int nbCenterLayers;
    private int nbDataBlocks;
    private int nbLayers;
    private int shift;

    static final class Point {
        private final int x;
        private final int y;

        Point(int i, int i2) {
            this.x = i;
            this.y = i2;
        }

        /* Access modifiers changed, original: 0000 */
        public int getX() {
            return this.x;
        }

        /* Access modifiers changed, original: 0000 */
        public int getY() {
            return this.y;
        }

        /* Access modifiers changed, original: 0000 */
        public ResultPoint toResultPoint() {
            return new ResultPoint((float) getX(), (float) getY());
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<");
            stringBuilder.append(this.x);
            stringBuilder.append(' ');
            stringBuilder.append(this.y);
            stringBuilder.append('>');
            return stringBuilder.toString();
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private static float distance(Point point, Point point2) {
        return MathUtils.distance(point.getX(), point.getY(), point2.getX(), point2.getY());
    }

    private static ResultPoint[] expandSquare(ResultPoint[] resultPointArr, float f, float f2) {
        f2 /= f * 2.0f;
        float x = (resultPointArr[0].getX() + resultPointArr[2].getX()) / 2.0f;
        float y = (resultPointArr[0].getY() + resultPointArr[2].getY()) / 2.0f;
        float x2 = (resultPointArr[0].getX() - resultPointArr[2].getX()) * f2;
        float y2 = (resultPointArr[0].getY() - resultPointArr[2].getY()) * f2;
        ResultPoint resultPoint = new ResultPoint(x + x2, y + y2);
        ResultPoint resultPoint2 = new ResultPoint(x - x2, y - y2);
        float x3 = (resultPointArr[1].getX() + resultPointArr[3].getX()) / 2.0f;
        float y3 = (resultPointArr[1].getY() + resultPointArr[3].getY()) / 2.0f;
        y2 = (resultPointArr[1].getX() - resultPointArr[3].getX()) * f2;
        f2 *= resultPointArr[1].getY() - resultPointArr[3].getY();
        ResultPoint resultPoint3 = new ResultPoint(x3 + y2, y3 + f2);
        ResultPoint resultPoint4 = new ResultPoint(x3 - y2, y3 - f2);
        return new ResultPoint[]{resultPoint, resultPoint3, resultPoint2, resultPoint4};
    }

    private void extractParameters(ResultPoint[] resultPointArr) throws NotFoundException {
        int i = 0;
        if (isValid(resultPointArr[0]) && isValid(resultPointArr[1]) && isValid(resultPointArr[2]) && isValid(resultPointArr[3])) {
            int i2;
            int[] iArr = new int[]{sampleLine(resultPointArr[0], resultPointArr[1], this.nbCenterLayers * 2), sampleLine(resultPointArr[1], resultPointArr[2], this.nbCenterLayers * 2), sampleLine(resultPointArr[2], resultPointArr[3], this.nbCenterLayers * 2), sampleLine(resultPointArr[3], resultPointArr[0], this.nbCenterLayers * 2)};
            this.shift = getRotation(iArr, this.nbCenterLayers * 2);
            long j = 0;
            while (i < 4) {
                i2 = iArr[(this.shift + i) % 4];
                j = this.compact ? (j << 7) + ((long) ((i2 >> 1) & TransportMediator.KEYCODE_MEDIA_PAUSE)) : (j << 10) + ((long) (((i2 >> 2) & 992) + ((i2 >> 1) & 31)));
                i++;
            }
            i2 = getCorrectedParameterData(j, this.compact);
            if (this.compact) {
                this.nbLayers = (i2 >> 6) + 1;
                this.nbDataBlocks = (i2 & 63) + 1;
                return;
            }
            this.nbLayers = (i2 >> 11) + 1;
            this.nbDataBlocks = (i2 & 2047) + 1;
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private ResultPoint[] getBullsEyeCorners(Point point) throws NotFoundException {
        this.nbCenterLayers = 1;
        Point point2 = point;
        Point point3 = point2;
        Point point4 = point3;
        Point point5 = point4;
        boolean z = true;
        while (this.nbCenterLayers < 9) {
            Point firstDifferent = getFirstDifferent(point2, z, 1, -1);
            Point firstDifferent2 = getFirstDifferent(point3, z, 1, 1);
            Point firstDifferent3 = getFirstDifferent(point4, z, -1, 1);
            Point firstDifferent4 = getFirstDifferent(point5, z, -1, -1);
            if (this.nbCenterLayers > 2) {
                double distance = (double) ((distance(firstDifferent4, firstDifferent) * ((float) this.nbCenterLayers)) / (distance(point5, point2) * ((float) (this.nbCenterLayers + 2))));
                if (distance < 0.75d || distance > 1.25d || !isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, firstDifferent4)) {
                    break;
                }
            }
            z ^= 1;
            this.nbCenterLayers++;
            point5 = firstDifferent4;
            point2 = firstDifferent;
            point3 = firstDifferent2;
            point4 = firstDifferent3;
        }
        if (this.nbCenterLayers == 5 || this.nbCenterLayers == 7) {
            this.compact = this.nbCenterLayers == 5;
            ResultPoint resultPoint = new ResultPoint(((float) point2.getX()) + 0.5f, ((float) point2.getY()) - 0.5f);
            ResultPoint resultPoint2 = new ResultPoint(((float) point3.getX()) + 0.5f, ((float) point3.getY()) + 0.5f);
            ResultPoint resultPoint3 = new ResultPoint(((float) point4.getX()) - 0.5f, ((float) point4.getY()) + 0.5f);
            ResultPoint resultPoint4 = new ResultPoint(((float) point5.getX()) - 0.5f, ((float) point5.getY()) - 0.5f);
            return expandSquare(new ResultPoint[]{resultPoint, resultPoint2, resultPoint3, resultPoint4}, (float) ((this.nbCenterLayers * 2) - 3), (float) (2 * this.nbCenterLayers));
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int getColor(Point point, Point point2) {
        float distance = distance(point, point2);
        float x = ((float) (point2.getX() - point.getX())) / distance;
        float y = ((float) (point2.getY() - point.getY())) / distance;
        float x2 = (float) point.getX();
        float y2 = (float) point.getY();
        boolean z = this.image.get(point.getX(), point.getY());
        boolean z2 = false;
        float f = y2;
        int i = 0;
        y2 = x2;
        for (int i2 = i; ((float) i2) < distance; i2++) {
            y2 += x;
            f += y;
            if (this.image.get(MathUtils.round(y2), MathUtils.round(f)) != z) {
                i++;
            }
        }
        y = ((float) i) / distance;
        if (y > 0.1f && y < 0.9f) {
            return 0;
        }
        int i3 = 1;
        if (y <= 0.1f) {
            z2 = true;
        }
        if (z2 != z) {
            i3 = -1;
        }
        return i3;
    }

    private static int getCorrectedParameterData(long j, boolean z) throws NotFoundException {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (i--; i >= 0; i--) {
            iArr[i] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(iArr, i3);
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                i5 = (i5 << 4) + iArr[i4];
                i4++;
            }
            return i5;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private int getDimension() {
        return this.compact ? (4 * this.nbLayers) + 11 : this.nbLayers <= 4 ? (4 * this.nbLayers) + 15 : ((this.nbLayers * 4) + (2 * (((this.nbLayers - 4) / 8) + 1))) + 15;
    }

    private Point getFirstDifferent(Point point, boolean z, int i, int i2) {
        int x = point.getX() + i;
        int y = point.getY();
        while (true) {
            y += i2;
            if (isValid(x, y) && this.image.get(x, y) == z) {
                x += i;
            } else {
                x -= i;
                y -= i2;
            }
        }
        x -= i;
        y -= i2;
        while (isValid(x, y) && this.image.get(x, y) == z) {
            x += i;
        }
        x -= i;
        while (isValid(x, y) && this.image.get(x, y) == z) {
            y += i2;
        }
        return new Point(x, y - i2);
    }

    private Point getMatrixCenter() {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        int width;
        int height;
        int i;
        ResultPoint resultPoint5;
        ResultPoint resultPoint6;
        try {
            ResultPoint[] detect = new WhiteRectangleDetector(this.image).detect();
            resultPoint = detect[0];
            resultPoint2 = detect[1];
            resultPoint3 = detect[2];
            resultPoint4 = detect[3];
        } catch (NotFoundException unused) {
            width = this.image.getWidth() / 2;
            height = this.image.getHeight() / 2;
            int i2 = width + 7;
            i = height - 7;
            resultPoint2 = getFirstDifferent(new Point(i2, i), false, 1, -1).toResultPoint();
            height += 7;
            resultPoint3 = getFirstDifferent(new Point(i2, height), false, 1, 1).toResultPoint();
            width -= 7;
            resultPoint = getFirstDifferent(new Point(width, height), false, -1, 1).toResultPoint();
            resultPoint4 = getFirstDifferent(new Point(width, i), false, -1, -1).toResultPoint();
            ResultPoint resultPoint7 = resultPoint3;
            resultPoint3 = resultPoint;
            resultPoint = resultPoint2;
            resultPoint2 = resultPoint7;
        }
        i = MathUtils.round((((resultPoint.getX() + resultPoint4.getX()) + resultPoint2.getX()) + resultPoint3.getX()) / 4.0f);
        width = MathUtils.round((((resultPoint.getY() + resultPoint4.getY()) + resultPoint2.getY()) + resultPoint3.getY()) / 4.0f);
        try {
            ResultPoint[] detect2 = new WhiteRectangleDetector(this.image, 15, i, width).detect();
            resultPoint2 = detect2[0];
            resultPoint3 = detect2[1];
            resultPoint5 = detect2[2];
            resultPoint6 = detect2[3];
        } catch (NotFoundException unused2) {
            int i3 = i + 7;
            height = width - 7;
            resultPoint2 = getFirstDifferent(new Point(i3, height), false, 1, -1).toResultPoint();
            width += 7;
            resultPoint3 = getFirstDifferent(new Point(i3, width), false, 1, 1).toResultPoint();
            i -= 7;
            resultPoint5 = getFirstDifferent(new Point(i, width), false, -1, 1).toResultPoint();
            resultPoint6 = getFirstDifferent(new Point(i, height), false, -1, -1).toResultPoint();
        }
        return new Point(MathUtils.round((((resultPoint2.getX() + resultPoint6.getX()) + resultPoint3.getX()) + resultPoint5.getX()) / 4.0f), MathUtils.round((((resultPoint2.getY() + resultPoint6.getY()) + resultPoint3.getY()) + resultPoint5.getY()) / 4.0f));
    }

    private ResultPoint[] getMatrixCornerPoints(ResultPoint[] resultPointArr) {
        return expandSquare(resultPointArr, (float) (2 * this.nbCenterLayers), (float) getDimension());
    }

    private static int getRotation(int[] iArr, int i) throws NotFoundException {
        int i2 = 0;
        int length = iArr.length;
        int i3 = 0;
        int i4 = i3;
        while (i3 < length) {
            int i5 = iArr[i3];
            i4 = (i4 << 3) + (((i5 >> (i - 2)) << 1) + (i5 & 1));
            i3++;
        }
        int i6 = ((i4 & 1) << 11) + (i4 >> 1);
        while (i2 < 4) {
            if (Integer.bitCount(EXPECTED_CORNER_BITS[i2] ^ i6) <= 2) {
                return i2;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private boolean isValid(int i, int i2) {
        return i >= 0 && i < this.image.getWidth() && i2 > 0 && i2 < this.image.getHeight();
    }

    private boolean isValid(ResultPoint resultPoint) {
        return isValid(MathUtils.round(resultPoint.getX()), MathUtils.round(resultPoint.getY()));
    }

    private boolean isWhiteOrBlackRectangle(Point point, Point point2, Point point3, Point point4) {
        Point point5 = new Point(point.getX() - 3, point.getY() + 3);
        point = new Point(point2.getX() - 3, point2.getY() - 3);
        point2 = new Point(point3.getX() + 3, point3.getY() - 3);
        point3 = new Point(point4.getX() + 3, point4.getY() + 3);
        int color = getColor(point3, point5);
        boolean z = false;
        if (color == 0 || getColor(point5, point) != color || getColor(point, point2) != color) {
            return false;
        }
        if (getColor(point2, point3) == color) {
            z = true;
        }
        return z;
    }

    private BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        GridSampler instance = GridSampler.getInstance();
        int dimension = getDimension();
        float f = ((float) dimension) / 2.0f;
        float f2 = f - ((float) this.nbCenterLayers);
        float f3 = f + ((float) this.nbCenterLayers);
        return instance.sampleGrid(bitMatrix, dimension, dimension, f2, f2, f3, f2, f3, f3, f2, f3, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY());
    }

    private int sampleLine(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
        float distance = distance(resultPoint, resultPoint2);
        float f = distance / ((float) i);
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = ((resultPoint2.getX() - resultPoint.getX()) * f) / distance;
        f = (f * (resultPoint2.getY() - resultPoint.getY())) / distance;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            float f2 = (float) i2;
            if (this.image.get(MathUtils.round((f2 * x2) + x), MathUtils.round((f2 * f) + y))) {
                i3 |= 1 << ((i - i2) - 1);
            }
            i2++;
        }
        return i3;
    }

    public AztecDetectorResult detect() throws NotFoundException {
        return detect(false);
    }

    public AztecDetectorResult detect(boolean z) throws NotFoundException {
        ResultPoint[] bullsEyeCorners = getBullsEyeCorners(getMatrixCenter());
        if (z) {
            ResultPoint resultPoint = bullsEyeCorners[0];
            bullsEyeCorners[0] = bullsEyeCorners[2];
            bullsEyeCorners[2] = resultPoint;
        }
        extractParameters(bullsEyeCorners);
        return new AztecDetectorResult(sampleGrid(this.image, bullsEyeCorners[this.shift % 4], bullsEyeCorners[(this.shift + 1) % 4], bullsEyeCorners[(this.shift + 2) % 4], bullsEyeCorners[(this.shift + 3) % 4]), getMatrixCornerPoints(bullsEyeCorners), this.compact, this.nbDataBlocks, this.nbLayers);
    }
}
