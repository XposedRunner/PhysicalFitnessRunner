package com.google.zxing.datamatrix.detector;

import cn.jiguang.net.HttpUtils;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class Detector {
    private final BitMatrix image;
    private final WhiteRectangleDetector rectangleDetector;

    private static final class ResultPointsAndTransitions {
        private final ResultPoint from;
        private final ResultPoint to;
        private final int transitions;

        private ResultPointsAndTransitions(ResultPoint resultPoint, ResultPoint resultPoint2, int i) {
            this.from = resultPoint;
            this.to = resultPoint2;
            this.transitions = i;
        }

        /* Access modifiers changed, original: 0000 */
        public ResultPoint getFrom() {
            return this.from;
        }

        /* Access modifiers changed, original: 0000 */
        public ResultPoint getTo() {
            return this.to;
        }

        public int getTransitions() {
            return this.transitions;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.from);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(this.to);
            stringBuilder.append('/');
            stringBuilder.append(this.transitions);
            return stringBuilder.toString();
        }
    }

    private static final class ResultPointsAndTransitionsComparator implements Serializable, Comparator<ResultPointsAndTransitions> {
        private ResultPointsAndTransitionsComparator() {
        }

        public int compare(ResultPointsAndTransitions resultPointsAndTransitions, ResultPointsAndTransitions resultPointsAndTransitions2) {
            return resultPointsAndTransitions.getTransitions() - resultPointsAndTransitions2.getTransitions();
        }
    }

    public Detector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        this.rectangleDetector = new WhiteRectangleDetector(bitMatrix);
    }

    private ResultPoint correctTopRight(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i) {
        float f = (float) i;
        float distance = ((float) distance(resultPoint, resultPoint2)) / f;
        float distance2 = (float) distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = ((float) distance(resultPoint, resultPoint3)) / f;
        f = (float) distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / f) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / f)));
        if (!isValid(resultPoint5)) {
            return isValid(resultPoint6) ? resultPoint6 : null;
        } else {
            if (!isValid(resultPoint6)) {
                return resultPoint5;
            }
            if (Math.abs(transitionsBetween(resultPoint3, resultPoint5).getTransitions() - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) <= Math.abs(transitionsBetween(resultPoint3, resultPoint6).getTransitions() - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) {
                resultPoint6 = resultPoint5;
            }
            return resultPoint6;
        }
    }

    private ResultPoint correctTopRightRectangular(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) {
        float distance = ((float) distance(resultPoint, resultPoint2)) / ((float) i);
        float distance2 = (float) distance(resultPoint3, resultPoint4);
        ResultPoint resultPoint5 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint3.getX()) / distance2) * distance), resultPoint4.getY() + (distance * ((resultPoint4.getY() - resultPoint3.getY()) / distance2)));
        float distance3 = ((float) distance(resultPoint, resultPoint3)) / ((float) i2);
        distance = (float) distance(resultPoint2, resultPoint4);
        ResultPoint resultPoint6 = new ResultPoint(resultPoint4.getX() + (((resultPoint4.getX() - resultPoint2.getX()) / distance) * distance3), resultPoint4.getY() + (distance3 * ((resultPoint4.getY() - resultPoint2.getY()) / distance)));
        return !isValid(resultPoint5) ? isValid(resultPoint6) ? resultPoint6 : null : (isValid(resultPoint6) && Math.abs(i - transitionsBetween(resultPoint3, resultPoint5).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint5).getTransitions()) > Math.abs(i - transitionsBetween(resultPoint3, resultPoint6).getTransitions()) + Math.abs(i2 - transitionsBetween(resultPoint2, resultPoint6).getTransitions())) ? resultPoint6 : resultPoint5;
    }

    private static int distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.round(ResultPoint.distance(resultPoint, resultPoint2));
    }

    private static void increment(Map<ResultPoint, Integer> map, ResultPoint resultPoint) {
        Integer num = (Integer) map.get(resultPoint);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(resultPoint, Integer.valueOf(i));
    }

    private boolean isValid(ResultPoint resultPoint) {
        return resultPoint.getX() >= 0.0f && resultPoint.getX() < ((float) this.image.getWidth()) && resultPoint.getY() > 0.0f && resultPoint.getY() < ((float) this.image.getHeight());
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i, int i2) throws NotFoundException {
        int i3 = i;
        float f = ((float) i3) - 0.5f;
        int i4 = i2;
        float f2 = ((float) i4) - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i3, i4, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private ResultPointsAndTransitions transitionsBetween(ResultPoint resultPoint, ResultPoint resultPoint2) {
        int x = (int) resultPoint.getX();
        int y = (int) resultPoint.getY();
        int x2 = (int) resultPoint2.getX();
        int y2 = (int) resultPoint2.getY();
        int i = 0;
        int i2 = Math.abs(y2 - y) > Math.abs(x2 - x) ? 1 : 0;
        if (i2 != 0) {
            int i3 = y;
            y = x;
            x = i3;
            int i4 = y2;
            y2 = x2;
            x2 = i4;
        }
        int abs = Math.abs(x2 - x);
        int abs2 = Math.abs(y2 - y);
        int i5 = (-abs) / 2;
        int i6 = -1;
        int i7 = y < y2 ? 1 : -1;
        if (x < x2) {
            i6 = 1;
        }
        boolean z = this.image.get(i2 != 0 ? y : x, i2 != 0 ? x : y);
        while (x != x2) {
            boolean z2 = this.image.get(i2 != 0 ? y : x, i2 != 0 ? x : y);
            if (z2 != z) {
                i++;
                z = z2;
            }
            i5 += abs2;
            if (i5 > 0) {
                if (y == y2) {
                    break;
                }
                y += i7;
                i5 -= abs;
            }
            x += i6;
        }
        return new ResultPointsAndTransitions(resultPoint, resultPoint2, i);
    }

    public DetectorResult detect() throws NotFoundException {
        ResultPoint[] detect = this.rectangleDetector.detect();
        ResultPoint resultPoint = detect[0];
        ResultPoint resultPoint2 = detect[1];
        ResultPoint resultPoint3 = detect[2];
        ResultPoint resultPoint4 = detect[3];
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(transitionsBetween(resultPoint, resultPoint2));
        arrayList.add(transitionsBetween(resultPoint, resultPoint3));
        arrayList.add(transitionsBetween(resultPoint2, resultPoint4));
        arrayList.add(transitionsBetween(resultPoint3, resultPoint4));
        AnonymousClass1 anonymousClass1 = null;
        Collections.sort(arrayList, new ResultPointsAndTransitionsComparator());
        ResultPointsAndTransitions resultPointsAndTransitions = (ResultPointsAndTransitions) arrayList.get(0);
        ResultPointsAndTransitions resultPointsAndTransitions2 = (ResultPointsAndTransitions) arrayList.get(1);
        HashMap hashMap = new HashMap();
        increment(hashMap, resultPointsAndTransitions.getFrom());
        increment(hashMap, resultPointsAndTransitions.getTo());
        increment(hashMap, resultPointsAndTransitions2.getFrom());
        increment(hashMap, resultPointsAndTransitions2.getTo());
        ResultPoint resultPoint5 = null;
        ResultPoint resultPoint6 = resultPoint5;
        for (Entry entry : hashMap.entrySet()) {
            ResultPoint resultPoint7 = (ResultPoint) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                resultPoint5 = resultPoint7;
            } else if (anonymousClass1 == null) {
                anonymousClass1 = resultPoint7;
            } else {
                resultPoint6 = resultPoint7;
            }
        }
        if (anonymousClass1 == null || resultPoint5 == null || resultPoint6 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint resultPoint8;
        BitMatrix sampleGrid;
        ResultPoint[] resultPointArr = new ResultPoint[]{anonymousClass1, resultPoint5, resultPoint6};
        ResultPoint.orderBestPatterns(resultPointArr);
        resultPoint6 = resultPointArr[0];
        ResultPoint resultPoint9 = resultPointArr[1];
        ResultPoint resultPoint10 = resultPointArr[2];
        ResultPoint resultPoint11 = !hashMap.containsKey(resultPoint) ? resultPoint : !hashMap.containsKey(resultPoint2) ? resultPoint2 : !hashMap.containsKey(resultPoint3) ? resultPoint3 : resultPoint4;
        int transitions = transitionsBetween(resultPoint10, resultPoint11).getTransitions();
        int transitions2 = transitionsBetween(resultPoint6, resultPoint11).getTransitions();
        if ((transitions & 1) == 1) {
            transitions++;
        }
        int i = transitions + 2;
        if ((transitions2 & 1) == 1) {
            transitions2++;
        }
        int i2 = transitions2 + 2;
        if (4 * i >= 7 * i2 || 4 * i2 >= 7 * i) {
            resultPoint8 = resultPoint10;
            resultPoint4 = correctTopRightRectangular(resultPoint9, resultPoint6, resultPoint10, resultPoint11, i, i2);
            if (resultPoint4 != null) {
                resultPoint11 = resultPoint4;
            }
            transitions = transitionsBetween(resultPoint8, resultPoint11).getTransitions();
            transitions2 = transitionsBetween(resultPoint6, resultPoint11).getTransitions();
            if ((transitions & 1) == 1) {
                transitions++;
            }
            int i3 = transitions;
            if ((transitions2 & 1) == 1) {
                transitions2++;
            }
            sampleGrid = sampleGrid(this.image, resultPoint8, resultPoint9, resultPoint6, resultPoint11, i3, transitions2);
        } else {
            resultPoint4 = correctTopRight(resultPoint9, resultPoint6, resultPoint10, resultPoint11, Math.min(i2, i));
            if (resultPoint4 != null) {
                resultPoint11 = resultPoint4;
            }
            transitions = Math.max(transitionsBetween(resultPoint10, resultPoint11).getTransitions(), transitionsBetween(resultPoint6, resultPoint11).getTransitions()) + 1;
            if ((transitions & 1) == 1) {
                transitions++;
            }
            int i4 = transitions;
            sampleGrid = sampleGrid(this.image, resultPoint10, resultPoint9, resultPoint6, resultPoint11, i4, i4);
            resultPoint8 = resultPoint10;
        }
        return new DetectorResult(sampleGrid, new ResultPoint[]{resultPoint8, resultPoint9, resultPoint6, resultPoint11});
    }
}
