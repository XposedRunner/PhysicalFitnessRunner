package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 57;
    protected static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    private static final class CenterComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private CenterComparator(float f) {
            this.average = f;
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            if (finderPattern2.getCount() != finderPattern.getCount()) {
                return finderPattern2.getCount() - finderPattern.getCount();
            }
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            int i = abs < abs2 ? 1 : abs == abs2 ? 0 : -1;
            return i;
        }
    }

    private static final class FurthestFromAverageComparator implements Serializable, Comparator<FinderPattern> {
        private final float average;

        private FurthestFromAverageComparator(float f) {
            this.average = f;
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float abs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float abs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            return abs < abs2 ? -1 : abs == abs2 ? 0 : 1;
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((float) ((i - iArr[4]) - iArr[3])) - (((float) iArr[2]) / 2.0f);
    }

    private boolean crossCheckDiagonal(int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i8 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= i8 && i6 >= i8 && this.image.get(i6 - i8, i5 - i8)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i8++;
            } else if (i5 >= i8 || i6 < i8) {
                return false;
            } else {
                while (i5 >= i8 && i6 >= i8 && !this.image.get(i6 - i8, i5 - i8) && crossCheckStateCount[1] <= i7) {
                    crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
                    i8++;
                }
                if (i5 < i8 || i6 < i8 || crossCheckStateCount[1] > i7) {
                    return false;
                }
                while (i5 >= i8 && i6 >= i8 && this.image.get(i6 - i8, i5 - i8) && crossCheckStateCount[0] <= i7) {
                    crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
                    i8++;
                }
                if (crossCheckStateCount[0] > i7) {
                    return false;
                }
                int i9;
                i8 = this.image.getHeight();
                int width = this.image.getWidth();
                int i10 = 1;
                while (true) {
                    i9 = i5 + i10;
                    if (i9 >= i8) {
                        break;
                    }
                    int i11 = i6 + i10;
                    if (i11 >= width || !this.image.get(i11, i9)) {
                        break;
                    }
                    crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                    i10++;
                }
                if (i9 >= i8 || i6 + i10 >= width) {
                    return false;
                }
                while (true) {
                    i9 = i5 + i10;
                    if (i9 >= i8) {
                        break;
                    }
                    int i12 = i6 + i10;
                    if (i12 >= width || this.image.get(i12, i9) || crossCheckStateCount[3] >= i7) {
                        break;
                    }
                    crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
                    i10++;
                }
                if (i9 >= i8 || i6 + i10 >= width || crossCheckStateCount[3] >= i7) {
                    return false;
                }
                while (true) {
                    i9 = i5 + i10;
                    if (i9 >= i8) {
                        break;
                    }
                    int i13 = i6 + i10;
                    if (i13 >= width || !this.image.get(i13, i9) || crossCheckStateCount[4] >= i7) {
                        break;
                    }
                    crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
                    i10++;
                }
                if (crossCheckStateCount[4] >= i7) {
                    return false;
                }
                if (Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) >= 2 * i4 || !foundPatternCross(crossCheckStateCount)) {
                    z = false;
                }
                return z;
            }
        }
        if (i5 >= i8) {
        }
        return false;
    }

    private float crossCheckHorizontal(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i5, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        float f = Float.NaN;
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i5, i2) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        if (i5 < 0 || crossCheckStateCount[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.get(i5, i2) && crossCheckStateCount[0] <= i3) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i5--;
        }
        if (crossCheckStateCount[0] > i3) {
            return Float.NaN;
        }
        i++;
        while (i < width && bitMatrix.get(i, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i++;
        }
        if (i == width) {
            return Float.NaN;
        }
        while (i < width && !bitMatrix.get(i, i2) && crossCheckStateCount[3] < i3) {
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i++;
        }
        if (i == width || crossCheckStateCount[3] >= i3) {
            return Float.NaN;
        }
        while (i < width && bitMatrix.get(i, i2) && crossCheckStateCount[4] < i3) {
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i++;
        }
        if (crossCheckStateCount[4] >= i3 || 5 * Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) >= i4) {
            return Float.NaN;
        }
        if (foundPatternCross(crossCheckStateCount)) {
            f = centerFromEnd(crossCheckStateCount, i);
        }
        return f;
    }

    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i5 = i;
        while (i5 >= 0 && bitMatrix.get(i2, i5)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i5--;
        }
        float f = Float.NaN;
        if (i5 < 0) {
            return Float.NaN;
        }
        while (i5 >= 0 && !bitMatrix.get(i2, i5) && crossCheckStateCount[1] <= i3) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i5--;
        }
        if (i5 < 0 || crossCheckStateCount[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && bitMatrix.get(i2, i5) && crossCheckStateCount[0] <= i3) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i5--;
        }
        if (crossCheckStateCount[0] > i3) {
            return Float.NaN;
        }
        i++;
        while (i < height && bitMatrix.get(i2, i)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i++;
        }
        if (i == height) {
            return Float.NaN;
        }
        while (i < height && !bitMatrix.get(i2, i) && crossCheckStateCount[3] < i3) {
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i++;
        }
        if (i == height || crossCheckStateCount[3] >= i3) {
            return Float.NaN;
        }
        while (i < height && bitMatrix.get(i2, i) && crossCheckStateCount[4] < i3) {
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i++;
        }
        if (crossCheckStateCount[4] >= i3 || 5 * Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i4) >= 2 * i4) {
            return Float.NaN;
        }
        if (foundPatternCross(crossCheckStateCount)) {
            f = centerFromEnd(crossCheckStateCount, i);
        }
        return f;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        ResultPoint resultPoint = null;
        for (ResultPoint resultPoint2 : this.possibleCenters) {
            if (resultPoint2.getCount() >= 2) {
                if (resultPoint == null) {
                    resultPoint = resultPoint2;
                } else {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(resultPoint.getX() - resultPoint2.getX()) - Math.abs(resultPoint.getY() - resultPoint2.getY()))) / 2;
                }
            }
        }
        return 0;
    }

    protected static boolean foundPatternCross(int[] iArr) {
        boolean z = false;
        int i = 0;
        int i2 = i;
        while (i < 5) {
            int i3 = iArr[i];
            if (i3 == 0) {
                return false;
            }
            i2 += i3;
            i++;
        }
        if (i2 < 7) {
            return false;
        }
        float f = ((float) i2) / 7.0f;
        float f2 = f / 2.0f;
        if (Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((3.0f * f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2) {
            z = true;
        }
        return z;
    }

    private int[] getCrossCheckStateCount() {
        this.crossCheckStateCount[0] = 0;
        this.crossCheckStateCount[1] = 0;
        this.crossCheckStateCount[2] = 0;
        this.crossCheckStateCount[3] = 0;
        this.crossCheckStateCount[4] = 0;
        return this.crossCheckStateCount;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float f = 0.0f;
        boolean z = false;
        float f2 = 0.0f;
        int i = 0;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i++;
                f2 += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f3 = f2 / ((float) size);
        for (FinderPattern estimatedModuleSize : this.possibleCenters) {
            f += Math.abs(estimatedModuleSize.getEstimatedModuleSize() - f3);
        }
        if (f <= 0.05f * f2) {
            z = true;
        }
        return z;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        float f = 0.0f;
        if (size > 3) {
            float f2 = 0.0f;
            float f3 = f2;
            for (FinderPattern estimatedModuleSize : this.possibleCenters) {
                float estimatedModuleSize2 = estimatedModuleSize.getEstimatedModuleSize();
                f2 += estimatedModuleSize2;
                f3 += estimatedModuleSize2 * estimatedModuleSize2;
            }
            float f4 = (float) size;
            f2 /= f4;
            f4 = (float) Math.sqrt((double) ((f3 / f4) - (f2 * f2)));
            Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f2));
            f4 = Math.max(0.2f * f2, f4);
            int i = 0;
            while (i < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                if (Math.abs(((FinderPattern) this.possibleCenters.get(i)).getEstimatedModuleSize() - f2) > f4) {
                    this.possibleCenters.remove(i);
                    i--;
                }
                i++;
            }
        }
        if (this.possibleCenters.size() > 3) {
            for (FinderPattern estimatedModuleSize3 : this.possibleCenters) {
                f += estimatedModuleSize3.getEstimatedModuleSize();
            }
            Collections.sort(this.possibleCenters, new CenterComparator(f / ((float) this.possibleCenters.size())));
            this.possibleCenters.subList(3, this.possibleCenters.size()).clear();
        }
        return new FinderPattern[]{(FinderPattern) this.possibleCenters.get(0), (FinderPattern) this.possibleCenters.get(1), (FinderPattern) this.possibleCenters.get(2)};
    }

    /* Access modifiers changed, original: final */
    public final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        Map<DecodeHintType, ?> map2 = map;
        int i = (map2 == null || !map2.containsKey(DecodeHintType.TRY_HARDER)) ? 0 : 1;
        boolean z = map2 != null && map2.containsKey(DecodeHintType.PURE_BARCODE);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i2 = (3 * height) / 228;
        if (i2 < 3 || i != 0) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        int i4 = i2;
        boolean z2 = false;
        while (i3 < height && !z2) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            boolean z3 = z2;
            int i5 = i4;
            i2 = 0;
            i4 = i2;
            while (i2 < width) {
                if (this.image.get(i2, i3)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 == 4) {
                    if (!foundPatternCross(iArr)) {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    } else if (handlePossibleCenter(iArr, i3, i2, z)) {
                        if (this.hasSkipped) {
                            z3 = haveMultiplyConfirmedCenters();
                        } else {
                            i4 = findRowSkip();
                            if (i4 > iArr[2]) {
                                i3 += (i4 - iArr[2]) - 2;
                                i2 = width - 1;
                            }
                        }
                        iArr[0] = 0;
                        iArr[1] = 0;
                        iArr[2] = 0;
                        iArr[3] = 0;
                        iArr[4] = 0;
                        i4 = 0;
                        i5 = 2;
                    } else {
                        iArr[0] = iArr[2];
                        iArr[1] = iArr[3];
                        iArr[2] = iArr[4];
                        iArr[3] = 1;
                        iArr[4] = 0;
                    }
                    i4 = 3;
                } else {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                }
                i2++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i3, width, z)) {
                i2 = iArr[0];
                if (this.hasSkipped) {
                    i4 = i2;
                    z2 = haveMultiplyConfirmedCenters();
                    i3 += i4;
                } else {
                    i4 = i2;
                }
            } else {
                i4 = i5;
            }
            z2 = z3;
            i3 += i4;
        }
        FinderPattern[] selectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(selectBestPatterns);
        return new FinderPatternInfo(selectBestPatterns);
    }

    /* Access modifiers changed, original: protected|final */
    public final BitMatrix getImage() {
        return this.image;
    }

    /* Access modifiers changed, original: protected|final */
    public final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        int i3 = 0;
        int i4 = (((iArr[0] + iArr[1]) + iArr[2]) + iArr[3]) + iArr[4];
        i2 = (int) centerFromEnd(iArr, i2);
        float crossCheckVertical = crossCheckVertical(i, i2, iArr[2], i4);
        if (!Float.isNaN(crossCheckVertical)) {
            int i5 = (int) crossCheckVertical;
            float crossCheckHorizontal = crossCheckHorizontal(i2, i5, iArr[2], i4);
            if (!Float.isNaN(crossCheckHorizontal) && (!z || crossCheckDiagonal(i5, (int) crossCheckHorizontal, iArr[2], i4))) {
                float f = ((float) i4) / 7.0f;
                for (int i6 = 0; i6 < this.possibleCenters.size(); i6++) {
                    FinderPattern finderPattern = (FinderPattern) this.possibleCenters.get(i6);
                    if (finderPattern.aboutEquals(f, crossCheckVertical, crossCheckHorizontal)) {
                        this.possibleCenters.set(i6, finderPattern.combineEstimate(crossCheckVertical, crossCheckHorizontal, f));
                        i3 = 1;
                        break;
                    }
                }
                if (i3 == 0) {
                    FinderPattern finderPattern2 = new FinderPattern(crossCheckHorizontal, crossCheckVertical, f);
                    this.possibleCenters.add(finderPattern2);
                    if (this.resultPointCallback != null) {
                        this.resultPointCallback.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }
}
