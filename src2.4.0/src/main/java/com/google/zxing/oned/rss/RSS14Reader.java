package com.google.zxing.oned.rss;

import android.support.v4.media.TransportMediator;
import com.baidu.location.BDLocation;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.OneDReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public final class RSS14Reader extends AbstractRSSReader {
    private static final int[][] FINDER_PATTERNS = new int[][]{new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private static final int[] INSIDE_GSUM = new int[]{0, 336, 1036, 1516};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = new int[]{4, 20, 48, 81};
    private static final int[] INSIDE_ODD_WIDEST = new int[]{2, 4, 6, 8};
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = new int[]{1, 10, 34, 70, TransportMediator.KEYCODE_MEDIA_PLAY};
    private static final int[] OUTSIDE_GSUM = new int[]{0, BDLocation.TypeNetWorkLocation, 961, 2015, 2715};
    private static final int[] OUTSIDE_ODD_WIDEST = new int[]{8, 6, 4, 3, 1};
    private final List<Pair> possibleLeftPairs = new ArrayList();
    private final List<Pair> possibleRightPairs = new ArrayList();

    private static void addOrTally(Collection<Pair> collection, Pair pair) {
        if (pair != null) {
            Object obj = null;
            for (Pair pair2 : collection) {
                if (pair2.getValue() == pair.getValue()) {
                    pair2.incrementCount();
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                collection.add(pair);
            }
        }
    }

    private void adjustOddEvenCounts(boolean z, int i) throws NotFoundException {
        Object obj;
        Object obj2;
        Object obj3;
        int count = AbstractRSSReader.count(getOddCounts());
        int count2 = AbstractRSSReader.count(getEvenCounts());
        int i2 = (count + count2) - i;
        Object obj4 = null;
        Object obj5 = (count & 1) == z ? 1 : null;
        Object obj6 = (count2 & 1) == 1 ? 1 : null;
        if (z) {
            Object obj7;
            if (count > 12) {
                obj = null;
                obj7 = 1;
            } else if (count < 4) {
                obj7 = null;
                obj = 1;
            } else {
                obj = null;
                obj7 = obj;
            }
            if (count2 > 12) {
                obj2 = 1;
            } else if (count2 < 4) {
                obj2 = null;
                int i3 = 1;
            } else {
                obj2 = null;
            }
            obj3 = obj;
            obj = obj7;
        } else {
            if (count > 11) {
                obj3 = null;
                obj = 1;
            } else if (count < 5) {
                obj = null;
                obj3 = 1;
            } else {
                obj3 = null;
                obj = obj3;
            }
            if (count2 > 10) {
                obj2 = 1;
            } else if (count2 < 4) {
                obj2 = null;
                obj4 = 1;
            } else {
                obj2 = null;
            }
        }
        if (i2 == 1) {
            if (obj5 != null) {
                if (obj6 != null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                obj = 1;
            } else if (obj6 == null) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                obj2 = 1;
            }
        } else if (i2 == -1) {
            if (obj5 != null) {
                if (obj6 != null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                obj3 = 1;
            } else if (obj6 == null) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                obj4 = 1;
            }
        } else if (i2 != 0) {
            throw NotFoundException.getNotFoundInstance();
        } else if (obj5 != null) {
            if (obj6 == null) {
                throw NotFoundException.getNotFoundInstance();
            } else if (count < count2) {
                obj3 = 1;
                obj2 = obj3;
            } else {
                obj4 = 1;
                obj = obj4;
            }
        } else if (obj6 != null) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (obj3 != null) {
            if (obj != null) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (obj != null) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (obj4 != null) {
            if (obj2 != null) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (obj2 != null) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private static boolean checkChecksum(Pair pair, Pair pair2) {
        int checksumPortion = (pair.getChecksumPortion() + (16 * pair2.getChecksumPortion())) % 79;
        int value = (9 * pair.getFinderPattern().getValue()) + pair2.getFinderPattern().getValue();
        if (value > 72) {
            value--;
        }
        if (value > 8) {
            value--;
        }
        return checksumPortion == value;
    }

    private static Result constructResult(Pair pair, Pair pair2) {
        int length;
        String valueOf = String.valueOf((4537077 * ((long) pair.getValue())) + ((long) pair2.getValue()));
        StringBuilder stringBuilder = new StringBuilder(14);
        for (length = 13 - valueOf.length(); length > 0; length--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(valueOf);
        length = 0;
        int i = length;
        while (length < 13) {
            int charAt = stringBuilder.charAt(length) - 48;
            if ((length & 1) == 0) {
                charAt *= 3;
            }
            i += charAt;
            length++;
        }
        int i2 = 10 - (i % 10);
        if (i2 == 10) {
            i2 = 0;
        }
        stringBuilder.append(i2);
        ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new Result(String.valueOf(stringBuilder.toString()), null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_14);
    }

    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z) throws NotFoundException {
        int i;
        int length;
        BitArray bitArray2 = bitArray;
        boolean z2 = z;
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z2) {
            OneDReader.recordPatternInReverse(bitArray2, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray2, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            i = 0;
            for (length = dataCharacterCounters.length - 1; i < length; length--) {
                int i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
            }
        }
        i = z2 ? 16 : 15;
        float count = ((float) AbstractRSSReader.count(dataCharacterCounters)) / ((float) i);
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i3 = 0; i3 < dataCharacterCounters.length; i3++) {
            float f = ((float) dataCharacterCounters[i3]) / count;
            int i4 = (int) (0.5f + f);
            if (i4 < 1) {
                i4 = 1;
            } else if (i4 > 8) {
                i4 = 8;
            }
            int i5 = i3 / 2;
            if ((i3 & 1) == 0) {
                oddCounts[i5] = i4;
                oddRoundingErrors[i5] = f - ((float) i4);
            } else {
                evenCounts[i5] = i4;
                evenRoundingErrors[i5] = f - ((float) i4);
            }
        }
        adjustOddEvenCounts(z2, i);
        int i6 = 0;
        length = 0;
        for (i = oddCounts.length - 1; i >= 0; i--) {
            i6 = (i6 * 9) + oddCounts[i];
            length += oddCounts[i];
        }
        int i7 = 0;
        int i8 = 0;
        for (i = evenCounts.length - 1; i >= 0; i--) {
            i7 = (i7 * 9) + evenCounts[i];
            i8 += evenCounts[i];
        }
        i6 += 3 * i7;
        int i9;
        if (z2) {
            if ((length & 1) != 0 || length > 12 || length < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            i = (12 - length) / 2;
            i9 = OUTSIDE_ODD_WIDEST[i];
            int i10 = 9 - i9;
            return new DataCharacter(((RSSUtils.getRSSvalue(oddCounts, i9, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i]) + RSSUtils.getRSSvalue(evenCounts, i10, true)) + OUTSIDE_GSUM[i], i6);
        } else if ((i8 & 1) != 0 || i8 > 10 || i8 < 4) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            i = (10 - i8) / 2;
            i9 = INSIDE_ODD_WIDEST[i];
            return new DataCharacter(((RSSUtils.getRSSvalue(evenCounts, 9 - i9, false) * INSIDE_ODD_TOTAL_SUBSET[i]) + RSSUtils.getRSSvalue(oddCounts, i9, true)) + INSIDE_GSUM[i], i6);
        }
    }

    private Pair decodePair(BitArray bitArray, boolean z, int i, Map<DecodeHintType, ?> map) {
        try {
            int[] findFinderPattern = findFinderPattern(bitArray, 0, z);
            FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z, findFinderPattern);
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float f = ((float) (findFinderPattern[0] + findFinderPattern[1])) / 2.0f;
                if (z) {
                    f = ((float) (bitArray.getSize() - 1)) - f;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(f, (float) i));
            }
            DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, true);
            DataCharacter decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, false);
            return new Pair((1597 * decodeDataCharacter.getValue()) + decodeDataCharacter2.getValue(), decodeDataCharacter.getChecksumPortion() + (4 * decodeDataCharacter2.getChecksumPortion()), parseFoundFinderPattern);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] findFinderPattern(BitArray bitArray, int i, boolean z) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        int i2 = 0;
        while (i < size) {
            i2 = bitArray.get(i) ^ 1;
            if (z == i2) {
                break;
            }
            i++;
        }
        int i3 = i;
        int i4 = 0;
        while (i < size) {
            if ((bitArray.get(i) ^ i2) != 0) {
                decodeFinderCounters[i4] = decodeFinderCounters[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                    return new int[]{i3, i};
                } else {
                    i3 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i4--;
                }
                decodeFinderCounters[i4] = 1;
                i2 = i2 == 0 ? 1 : 0;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z, int[] iArr) throws NotFoundException {
        int size;
        int size2;
        boolean z2 = bitArray.get(iArr[0]);
        int i2 = iArr[0] - 1;
        while (i2 >= 0 && (bitArray.get(i2) ^ z2) != 0) {
            i2--;
        }
        i2++;
        int i3 = iArr[0] - i2;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i3;
        int parseFinderValue = AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        i3 = iArr[1];
        if (z) {
            size = (bitArray.getSize() - 1) - i3;
            size2 = (bitArray.getSize() - 1) - i2;
        } else {
            size = i3;
            size2 = i2;
        }
        return new FinderPattern(parseFinderValue, new int[]{i2, iArr[1]}, size2, size, i);
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i, map));
        bitArray.reverse();
        i = this.possibleLeftPairs.size();
        for (int i2 = 0; i2 < i; i2++) {
            Pair pair = (Pair) this.possibleLeftPairs.get(i2);
            if (pair.getCount() > 1) {
                int size = this.possibleRightPairs.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Pair pair2 = (Pair) this.possibleRightPairs.get(i3);
                    if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                        return constructResult(pair, pair2);
                    }
                }
                continue;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }
}
