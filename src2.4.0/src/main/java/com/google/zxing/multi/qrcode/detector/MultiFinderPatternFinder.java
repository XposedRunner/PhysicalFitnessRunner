package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

final class MultiFinderPatternFinder extends FinderPatternFinder {
    private static final float DIFF_MODSIZE_CUTOFF = 0.5f;
    private static final float DIFF_MODSIZE_CUTOFF_PERCENT = 0.05f;
    private static final FinderPatternInfo[] EMPTY_RESULT_ARRAY = new FinderPatternInfo[0];
    private static final float MAX_MODULE_COUNT_PER_EDGE = 180.0f;
    private static final float MIN_MODULE_COUNT_PER_EDGE = 9.0f;

    private static final class ModuleSizeComparator implements Serializable, Comparator<FinderPattern> {
        private ModuleSizeComparator() {
        }

        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            double estimatedModuleSize = (double) (finderPattern2.getEstimatedModuleSize() - finderPattern.getEstimatedModuleSize());
            return estimatedModuleSize < 0.0d ? -1 : estimatedModuleSize > 0.0d ? 1 : 0;
        }
    }

    MultiFinderPatternFinder(BitMatrix bitMatrix) {
        super(bitMatrix);
    }

    MultiFinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        super(bitMatrix, resultPointCallback);
    }

    private FinderPattern[][] selectMutipleBestPatterns() throws NotFoundException {
        List possibleCenters = getPossibleCenters();
        int size = possibleCenters.size();
        int i = 3;
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i2 = 2;
        int i3 = 0;
        if (size == 3) {
            FinderPattern[][] finderPatternArr = new FinderPattern[1][];
            finderPatternArr[0] = new FinderPattern[]{(FinderPattern) possibleCenters.get(0), (FinderPattern) possibleCenters.get(1), (FinderPattern) possibleCenters.get(2)};
            return finderPatternArr;
        }
        Collections.sort(possibleCenters, new ModuleSizeComparator());
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (i4 < size - 2) {
            FinderPattern finderPattern = (FinderPattern) possibleCenters.get(i4);
            if (finderPattern != null) {
                int i5 = i4 + 1;
                while (i5 < size - 1) {
                    int i6;
                    FinderPattern finderPattern2 = (FinderPattern) possibleCenters.get(i5);
                    if (finderPattern2 != null) {
                        float estimatedModuleSize = (finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) / Math.min(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
                        float f = 0.5f;
                        int i7 = (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) > 0.5f ? 1 : (Math.abs(finderPattern.getEstimatedModuleSize() - finderPattern2.getEstimatedModuleSize()) == 0.5f ? 0 : -1));
                        float f2 = DIFF_MODSIZE_CUTOFF_PERCENT;
                        if (i7 > 0 && estimatedModuleSize >= DIFF_MODSIZE_CUTOFF_PERCENT) {
                            break;
                        }
                        int i8 = i5 + 1;
                        while (i8 < size) {
                            FinderPattern finderPattern3 = (FinderPattern) possibleCenters.get(i8);
                            if (finderPattern3 != null) {
                                float estimatedModuleSize2 = (finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) / Math.min(finderPattern2.getEstimatedModuleSize(), finderPattern3.getEstimatedModuleSize());
                                if (Math.abs(finderPattern2.getEstimatedModuleSize() - finderPattern3.getEstimatedModuleSize()) > f && estimatedModuleSize2 >= f2) {
                                    i6 = 2;
                                    break;
                                }
                                FinderPattern[] finderPatternArr2 = new FinderPattern[i];
                                finderPatternArr2[i3] = finderPattern;
                                finderPatternArr2[1] = finderPattern2;
                                i6 = 2;
                                finderPatternArr2[2] = finderPattern3;
                                ResultPoint.orderBestPatterns(finderPatternArr2);
                                FinderPatternInfo finderPatternInfo = new FinderPatternInfo(finderPatternArr2);
                                float distance = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getBottomLeft());
                                float distance2 = ResultPoint.distance(finderPatternInfo.getTopRight(), finderPatternInfo.getBottomLeft());
                                float distance3 = ResultPoint.distance(finderPatternInfo.getTopLeft(), finderPatternInfo.getTopRight());
                                float estimatedModuleSize3 = (distance + distance3) / (finderPattern.getEstimatedModuleSize() * 2.0f);
                                if (estimatedModuleSize3 <= 180.0f && estimatedModuleSize3 >= MIN_MODULE_COUNT_PER_EDGE && Math.abs((distance - distance3) / Math.min(distance, distance3)) < 0.1f) {
                                    distance = (float) Math.sqrt((double) ((distance * distance) + (distance3 * distance3)));
                                    if (Math.abs((distance2 - distance) / Math.min(distance2, distance)) < 0.1f) {
                                        arrayList.add(finderPatternArr2);
                                    }
                                }
                            } else {
                                i6 = i2;
                            }
                            i8++;
                            i2 = i6;
                            i = 3;
                            i3 = 0;
                            f = 0.5f;
                            f2 = DIFF_MODSIZE_CUTOFF_PERCENT;
                        }
                    }
                    i6 = i2;
                    i5++;
                    i2 = i6;
                    i = 3;
                    i3 = 0;
                }
            }
            i4++;
            i2 = i2;
            i = 3;
            i3 = 0;
        }
        if (!arrayList.isEmpty()) {
            return (FinderPattern[][]) arrayList.toArray(new FinderPattern[arrayList.size()][]);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public FinderPatternInfo[] findMulti(Map<DecodeHintType, ?> map) throws NotFoundException {
        int i = 0;
        int i2 = (map == null || !map.containsKey(DecodeHintType.TRY_HARDER)) ? 0 : 1;
        boolean z = map != null && map.containsKey(DecodeHintType.PURE_BARCODE);
        BitMatrix image = getImage();
        int height = image.getHeight();
        int width = image.getWidth();
        int i3 = (int) ((((float) height) / 228.0f) * 3.0f);
        if (i3 < 3 || i2 != 0) {
            i3 = 3;
        }
        int[] iArr = new int[5];
        int i4 = i3 - 1;
        while (i4 < height) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i5 = 0;
            int i6 = i5;
            while (i5 < width) {
                if (image.get(i5, i4)) {
                    if ((i6 & 1) == 1) {
                        i6++;
                    }
                    iArr[i6] = iArr[i6] + 1;
                } else if ((i6 & 1) != 0) {
                    iArr[i6] = iArr[i6] + 1;
                } else if (i6 != 4) {
                    i6++;
                    iArr[i6] = iArr[i6] + 1;
                } else if (FinderPatternFinder.foundPatternCross(iArr) && handlePossibleCenter(iArr, i4, i5, z)) {
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i6 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i6 = 3;
                }
                i5++;
            }
            if (FinderPatternFinder.foundPatternCross(iArr)) {
                handlePossibleCenter(iArr, i4, width, z);
            }
            i4 += i3;
        }
        FinderPattern[][] selectMutipleBestPatterns = selectMutipleBestPatterns();
        ArrayList arrayList = new ArrayList();
        i2 = selectMutipleBestPatterns.length;
        while (i < i2) {
            ResultPoint[] resultPointArr = selectMutipleBestPatterns[i];
            ResultPoint.orderBestPatterns(resultPointArr);
            arrayList.add(new FinderPatternInfo(resultPointArr));
            i++;
        }
        return arrayList.isEmpty() ? EMPTY_RESULT_ARRAY : (FinderPatternInfo[]) arrayList.toArray(new FinderPatternInfo[arrayList.size()]);
    }
}
