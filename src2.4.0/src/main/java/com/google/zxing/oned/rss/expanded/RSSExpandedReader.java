package com.google.zxing.oned.rss.expanded;

import android.support.v4.media.TransportMediator;
import com.alibaba.wireless.security.SecExceptionCode;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.baidu.location.BDLocation;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int[] EVEN_TOTAL_SUBSET = new int[]{4, 20, 52, 104, SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE};
    private static final int[][] FINDER_PATTERNS = new int[][]{new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = new int[][]{new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int[] GSUM = new int[]{0, 348, 1388, 2948, 3988};
    private static final int MAX_PAIRS = 11;
    private static final int[] SYMBOL_WIDEST = new int[]{7, 5, 4, 3, 1};
    private static final int[][] WEIGHTS = new int[][]{new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, SecExceptionCode.SEC_ERROR_INIT_INVALID_PARAM, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET, 140, 209, SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE_DATA}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{SecExceptionCode.SEC_ERROR_INIT_NO_ANNOTATION, 28, 84, 41, SecExceptionCode.SEC_ERROR_INIT_INCORRECT_DATA_FILE, 158, 52, 156}, new int[]{46, 138, SecExceptionCode.SEC_ERROR_STA_STORE_NO_DATA_FILE, 187, 139, SecExceptionCode.SEC_ERROR_STA_STORE_KEY_NOT_EXSITED, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE, 155}, new int[]{43, 129, 176, 106, 107, 110, SecExceptionCode.SEC_ERROR_SET_GLOBAL_USER_DATA, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT, 137, 200, 178, 112, SecExceptionCode.SEC_ERROR_INIT_PARSE_USER_CONFIG_ERROR, 164}, new int[]{70, 210, SecExceptionCode.SEC_ERROR_STA_STORE_NO_MEMORY, SecExceptionCode.SEC_ERROR_STA_STORE_DATA_FILE_MISMATCH, 184, TransportMediator.KEYCODE_MEDIA_RECORD, 179, SecExceptionCode.SEC_ERROR_INIT_SOURCE_DIR_NOT_EXISTED}, new int[]{134, 191, 151, 31, 93, 68, SecExceptionCode.SEC_ERROR_STA_STORE_INCORRECT_DATA_FILE, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, BDLocation.TypeServerDecryptError, 64, 192, 154, 40}, new int[]{GlMapUtil.DEVICE_DISPLAY_DPI_LOW, 149, 25, 75, 14, 42, TransportMediator.KEYCODE_MEDIA_PLAY, BDLocation.TypeServerError}, new int[]{79, 26, 78, 23, 69, SecExceptionCode.SEC_ERROR_STA_STORE_ILLEGEL_KEY, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, SecExceptionCode.SEC_ERROR_INIT_LOW_VERSION_DATA}, new int[]{BDLocation.TypeNetWorkLocation, 61, 183, TransportMediator.KEYCODE_MEDIA_PAUSE, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 58, 174, 100, 89}};
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;

    private void adjustOddEvenCounts(int i) throws NotFoundException {
        Object obj;
        Object obj2;
        Object obj3;
        int count = AbstractRSSReader.count(getOddCounts());
        int count2 = AbstractRSSReader.count(getEvenCounts());
        int i2 = (count + count2) - i;
        Object obj4 = null;
        Object obj5 = (count & 1) == 1 ? 1 : null;
        Object obj6 = (count2 & 1) == 0 ? 1 : null;
        if (count > 13) {
            obj = null;
            obj2 = 1;
        } else if (count < 4) {
            obj2 = null;
            obj = 1;
        } else {
            obj = null;
            obj2 = obj;
        }
        if (count2 > 13) {
            obj3 = 1;
        } else if (count2 < 4) {
            obj3 = null;
            obj4 = 1;
        } else {
            obj3 = null;
        }
        if (i2 == 1) {
            if (obj5 != null) {
                if (obj6 != null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                obj2 = 1;
            } else if (obj6 == null) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                obj3 = 1;
            }
        } else if (i2 == -1) {
            if (obj5 != null) {
                if (obj6 != null) {
                    throw NotFoundException.getNotFoundInstance();
                }
                obj = 1;
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
                obj = obj3;
            } else {
                obj4 = 1;
                obj2 = obj4;
            }
        } else if (obj6 != null) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (obj != null) {
            if (obj2 != null) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (obj2 != null) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (obj4 != null) {
            if (obj3 != null) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (obj3 != null) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private boolean checkChecksum() {
        boolean z = false;
        ExpandedPair expandedPair = (ExpandedPair) this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int i = 2;
        int checksumPortion = rightChar.getChecksumPortion();
        for (int i2 = 1; i2 < this.pairs.size(); i2++) {
            ExpandedPair expandedPair2 = (ExpandedPair) this.pairs.get(i2);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            i++;
            DataCharacter rightChar2 = expandedPair2.getRightChar();
            if (rightChar2 != null) {
                checksumPortion += rightChar2.getChecksumPortion();
                i++;
            }
        }
        if ((211 * (i - 4)) + (checksumPortion % 211) == leftChar.getValue()) {
            z = true;
        }
        return z;
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i) throws NotFoundException {
        while (i < this.rows.size()) {
            ExpandedRow expandedRow = (ExpandedRow) this.rows.get(i);
            this.pairs.clear();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.pairs.addAll(((ExpandedRow) list.get(i2)).getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(expandedRow);
                try {
                    return checkRows(arrayList, i + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private List<ExpandedPair> checkRows(boolean z) {
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        List<ExpandedPair> checkRows;
        this.pairs.clear();
        if (z) {
            Collections.reverse(this.rows);
        }
        try {
            checkRows = checkRows(new ArrayList(), 0);
        } catch (NotFoundException unused) {
            checkRows = null;
        }
        if (z) {
            Collections.reverse(this.rows);
        }
        return checkRows;
    }

    static Result constructResult(List<ExpandedPair> list) throws NotFoundException, FormatException {
        String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = ((ExpandedPair) list.get(0)).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = ((ExpandedPair) list.get(list.size() - 1)).getFinderPattern().getResultPoints();
        return new Result(parseInformation, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i < 0) {
            i = list.isEmpty() ? 0 : ((ExpandedPair) list.get(list.size() - 1)).getFinderPattern().getStartEnd()[1];
        }
        int i2 = list.size() % 2 != 0 ? 1 : 0;
        if (this.startFromEven) {
            i2 ^= 1;
        }
        int i3 = 0;
        while (i < size) {
            i3 = bitArray.get(i) ^ 1;
            if (i3 == 0) {
                break;
            }
            i++;
        }
        int i4 = i;
        int i5 = 0;
        while (i < size) {
            if ((bitArray.get(i) ^ i3) != 0) {
                decodeFinderCounters[i5] = decodeFinderCounters[i5] + 1;
            } else {
                if (i5 == 3) {
                    if (i2 != 0) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        this.startEnd[0] = i4;
                        this.startEnd[1] = i;
                        return;
                    }
                    if (i2 != 0) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i4 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i5--;
                } else {
                    i5++;
                }
                decodeFinderCounters[i5] = 1;
                i3 = i3 == 0 ? 1 : 0;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getNextSecondBar(BitArray bitArray, int i) {
        return bitArray.get(i) ? bitArray.getNextSet(bitArray.getNextUnset(i)) : bitArray.getNextUnset(bitArray.getNextSet(i));
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z, boolean z2) {
        return (finderPattern.getValue() == 0 && z && z2) ? false : true;
    }

    private static boolean isPartialRow(Iterable<ExpandedPair> iterable, Iterable<ExpandedRow> iterable2) {
        Iterator it = iterable2.iterator();
        boolean z;
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            ExpandedRow expandedRow = (ExpandedRow) it.next();
            for (ExpandedPair expandedPair : iterable) {
                boolean z2;
                for (ExpandedPair equals : expandedRow.getPairs()) {
                    if (expandedPair.equals(equals)) {
                        z2 = true;
                        continue;
                        break;
                    }
                }
                z2 = false;
                continue;
                if (!z2) {
                    continue;
                    break;
                }
            }
            z = true;
            continue;
        } while (!z);
        return true;
    }

    private static boolean isValidSequence(List<ExpandedPair> list) {
        for (int[] iArr : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr.length) {
                boolean z;
                for (int i = 0; i < list.size(); i++) {
                    if (((ExpandedPair) list.get(i)).getFinderPattern().getValue() != iArr[i]) {
                        z = false;
                        break;
                    }
                }
                z = true;
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            i2 = this.startEnd[0] - 1;
            while (i2 >= 0 && !bitArray.get(i2)) {
                i2--;
            }
            i2++;
            i3 = this.startEnd[0] - i2;
            i4 = this.startEnd[1];
        } else {
            i2 = this.startEnd[0];
            i4 = bitArray.getNextUnset(this.startEnd[1] + 1);
            i3 = i4 - this.startEnd[1];
        }
        int i5 = i2;
        int i6 = i4;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i3;
        try {
            return new FinderPattern(AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i5, i6}, i5, i6, i);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private static void removePartialRows(List<ExpandedPair> list, List<ExpandedRow> list2) {
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            ExpandedRow expandedRow = (ExpandedRow) it.next();
            if (expandedRow.getPairs().size() != list.size()) {
                Object obj;
                Iterator it2 = expandedRow.getPairs().iterator();
                Object obj2;
                do {
                    obj = null;
                    obj2 = 1;
                    if (!it2.hasNext()) {
                        obj = 1;
                        break;
                    }
                    ExpandedPair expandedPair = (ExpandedPair) it2.next();
                    for (ExpandedPair equals : list) {
                        if (expandedPair.equals(equals)) {
                            continue;
                            break;
                        }
                    }
                    obj2 = null;
                    continue;
                } while (obj2 != null);
                if (obj != null) {
                    it.remove();
                }
            }
        }
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    /* JADX WARNING: Missing block: B:14:0x004d, code skipped:
            return;
     */
    private void storeRow(int r6, boolean r7) {
        /*
        r5 = this;
        r0 = 0;
        r1 = r0;
        r2 = r1;
    L_0x0003:
        r3 = r5.rows;
        r3 = r3.size();
        if (r1 >= r3) goto L_0x0029;
    L_0x000b:
        r3 = r5.rows;
        r3 = r3.get(r1);
        r3 = (com.google.zxing.oned.rss.expanded.ExpandedRow) r3;
        r4 = r3.getRowNumber();
        if (r4 <= r6) goto L_0x0020;
    L_0x0019:
        r0 = r5.pairs;
        r0 = r3.isEquivalent(r0);
        goto L_0x0029;
    L_0x0020:
        r2 = r5.pairs;
        r2 = r3.isEquivalent(r2);
        r1 = r1 + 1;
        goto L_0x0003;
    L_0x0029:
        if (r0 != 0) goto L_0x004d;
    L_0x002b:
        if (r2 == 0) goto L_0x002e;
    L_0x002d:
        goto L_0x004d;
    L_0x002e:
        r0 = r5.pairs;
        r2 = r5.rows;
        r0 = isPartialRow(r0, r2);
        if (r0 == 0) goto L_0x0039;
    L_0x0038:
        return;
    L_0x0039:
        r0 = r5.rows;
        r2 = new com.google.zxing.oned.rss.expanded.ExpandedRow;
        r3 = r5.pairs;
        r2.<init>(r3, r6, r7);
        r0.add(r1, r2);
        r6 = r5.pairs;
        r7 = r5.rows;
        removePartialRows(r6, r7);
        return;
    L_0x004d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.expanded.RSSExpandedReader.storeRow(int, boolean):void");
    }

    /* Access modifiers changed, original: 0000 */
    public DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z, boolean z2) throws NotFoundException {
        int i;
        int length;
        int i2;
        BitArray bitArray2 = bitArray;
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
            OneDReader.recordPattern(bitArray2, finderPattern.getStartEnd()[1], dataCharacterCounters);
            i = 0;
            for (length = dataCharacterCounters.length - 1; i < length; length--) {
                i2 = dataCharacterCounters[i];
                dataCharacterCounters[i] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i2;
                i++;
            }
        }
        float count = ((float) AbstractRSSReader.count(dataCharacterCounters)) / ((float) 17);
        float f = ((float) (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0])) / 15.0f;
        if (Math.abs(count - f) / f > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i3 = 0; i3 < dataCharacterCounters.length; i3++) {
            float f2 = (1.0f * ((float) dataCharacterCounters[i3])) / count;
            int i4 = (int) (0.5f + f2);
            if (i4 < 1) {
                if (f2 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = 1;
            } else if (i4 > 8) {
                if (f2 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = 8;
            }
            int i5 = i3 / 2;
            if ((i3 & 1) == 0) {
                oddCounts[i5] = i4;
                oddRoundingErrors[i5] = f2 - ((float) i4);
            } else {
                evenCounts[i5] = i4;
                evenRoundingErrors[i5] = f2 - ((float) i4);
            }
        }
        adjustOddEvenCounts(17);
        i = (((finderPattern.getValue() * 4) + (z ? 0 : 2)) + (z2 ^ 1)) - 1;
        i2 = 0;
        int i6 = 0;
        for (length = oddCounts.length - 1; length >= 0; length--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i2 += oddCounts[length] * WEIGHTS[i][2 * length];
            }
            i6 += oddCounts[length];
        }
        int i7 = 0;
        for (length = evenCounts.length - 1; length >= 0; length--) {
            if (isNotA1left(finderPattern, z, z2)) {
                i7 += evenCounts[length] * WEIGHTS[i][(2 * length) + 1];
            }
        }
        i2 += i7;
        if ((i6 & 1) != 0 || i6 > 13 || i6 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        i = (13 - i6) / 2;
        int i8 = SYMBOL_WIDEST[i];
        int i9 = 9 - i8;
        return new DataCharacter(((RSSUtils.getRSSvalue(oddCounts, i8, true) * EVEN_TOTAL_SUBSET[i]) + RSSUtils.getRSSvalue(evenCounts, i9, false)) + GSUM[i], i2);
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i, bitArray));
        } catch (NotFoundException unused) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i, bitArray));
        }
    }

    /* Access modifiers changed, original: 0000 */
    public List<ExpandedPair> decodeRow2pairs(int i, BitArray bitArray) throws NotFoundException {
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i));
            } catch (NotFoundException e) {
                if (this.pairs.isEmpty()) {
                    throw e;
                } else if (checkChecksum()) {
                    return this.pairs;
                } else {
                    int isEmpty = this.rows.isEmpty() ^ 1;
                    storeRow(i, false);
                    if (isEmpty != 0) {
                        List checkRows = checkRows(false);
                        if (checkRows != null) {
                            return checkRows;
                        }
                        checkRows = checkRows(true);
                        if (checkRows != null) {
                            return checkRows;
                        }
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public List<ExpandedRow> getRows() {
        return this.rows;
    }

    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    /* Access modifiers changed, original: 0000 */
    public ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i) throws NotFoundException {
        FinderPattern parseFoundFinderPattern;
        boolean z = list.size() % 2 == 0;
        if (this.startFromEven) {
            z ^= 1;
        }
        int i2 = -1;
        boolean z2 = true;
        do {
            findNextPair(bitArray, list, i2);
            parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i, z);
            if (parseFoundFinderPattern == null) {
                i2 = getNextSecondBar(bitArray, this.startEnd[0]);
                continue;
            } else {
                z2 = false;
                continue;
            }
        } while (z2);
        DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, true);
        if (list.isEmpty() || !((ExpandedPair) list.get(list.size() - 1)).mustBeLast()) {
            DataCharacter decodeDataCharacter2;
            try {
                decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, z, false);
            } catch (NotFoundException unused) {
                decodeDataCharacter2 = null;
            }
            return new ExpandedPair(decodeDataCharacter, decodeDataCharacter2, parseFoundFinderPattern, true);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
