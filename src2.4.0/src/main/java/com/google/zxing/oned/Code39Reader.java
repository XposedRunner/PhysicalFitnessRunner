package com.google.zxing.oned;

import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.location.BDLocation;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public final class Code39Reader extends OneDReader {
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[39];
    static final int[] CHARACTER_ENCODINGS = new int[]{52, 289, 97, 352, 49, SecExceptionCode.SEC_ERROR_STA_INCORRECT_DATA_FILE, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, SecExceptionCode.SEC_ERROR_DYN_ENC, SecExceptionCode.SEC_ERROR_STA_STORE_NO_MEMORY, 133, 388, 196, 148, 168, BDLocation.TypeServerDecryptError, 138, 42};
    private final int[] counters;
    private final StringBuilder decodeRowResult;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;

    public Code39Reader() {
        this(false);
    }

    public Code39Reader(boolean z) {
        this(z, false);
    }

    public Code39Reader(boolean z, boolean z2) {
        this.usingCheckDigit = z;
        this.extendedMode = z2;
        this.decodeRowResult = new StringBuilder(20);
        this.counters = new int[9];
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                i++;
                char charAt2 = charSequence.charAt(i);
                if (charAt != '+') {
                    if (charAt != '/') {
                        switch (charAt) {
                            case '$':
                                if (charAt2 >= 'A' && charAt2 <= 'Z') {
                                    charAt = (char) (charAt2 - 64);
                                    break;
                                }
                                throw FormatException.getFormatInstance();
                                break;
                            case '%':
                                if (charAt2 < 'A' || charAt2 > 'E') {
                                    if (charAt2 >= 'F' && charAt2 <= 'W') {
                                        charAt = (char) (charAt2 - 11);
                                        break;
                                    }
                                    throw FormatException.getFormatInstance();
                                }
                                charAt = (char) (charAt2 - 38);
                                break;
                                break;
                            default:
                                charAt = 0;
                                break;
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'O') {
                        charAt = (char) (charAt2 - 32);
                    } else if (charAt2 == 'Z') {
                        charAt = ':';
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                } else if (charAt2 < 'A' || charAt2 > 'Z') {
                    throw FormatException.getFormatInstance();
                } else {
                    charAt = (char) (charAt2 + 32);
                }
                stringBuilder.append(charAt);
            } else {
                stringBuilder.append(charAt);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    private static int[] findAsteriskPattern(BitArray bitArray, int[] iArr) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int length = iArr.length;
        int i = 0;
        int i2 = i;
        int i3 = nextSet;
        while (nextSet < size) {
            if ((bitArray.get(nextSet) ^ i) != 0) {
                iArr[i2] = iArr[i2] + 1;
            } else {
                int i4 = length - 1;
                if (i2 != i4) {
                    i2++;
                } else if (toNarrowWidePattern(iArr) == ASTERISK_ENCODING && bitArray.isRange(Math.max(0, i3 - ((nextSet - i3) / 2)), i3, false)) {
                    return new int[]{i3, nextSet};
                } else {
                    i3 += iArr[0] + iArr[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i4] = 0;
                    i2--;
                }
                iArr[i2] = 1;
                i ^= 1;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char patternToChar(int i) throws NotFoundException {
        for (int i2 = 0; i2 < CHARACTER_ENCODINGS.length; i2++) {
            if (CHARACTER_ENCODINGS[i2] == i) {
                return ALPHABET[i2];
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int toNarrowWidePattern(int[] iArr) {
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            i2 = 0;
            int i5 = i2;
            int i6 = i5;
            int i42 = i6;
            while (i2 < length) {
                int i7 = iArr[i2];
                if (i7 > i3) {
                    i6 |= 1 << ((length - 1) - i2);
                    i5++;
                    i42 += i7;
                }
                i2++;
            }
            if (i5 == 3) {
                while (i < length && i5 > 0) {
                    i2 = iArr[i];
                    if (i2 > i3) {
                        i5--;
                        if (i2 * 2 >= i42) {
                            return -1;
                        }
                    }
                    i++;
                }
                return i6;
            } else if (i5 <= 3) {
                return -1;
            } else {
                i2 = i3;
            }
        }
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder stringBuilder = this.decodeRowResult;
        stringBuilder.setLength(0);
        int[] findAsteriskPattern = findAsteriskPattern(bitArray, iArr);
        int nextSet = bitArray.getNextSet(findAsteriskPattern[1]);
        int size = bitArray.getSize();
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int toNarrowWidePattern = toNarrowWidePattern(iArr);
            if (toNarrowWidePattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i2;
            char patternToChar = patternToChar(toNarrowWidePattern);
            stringBuilder.append(patternToChar);
            int i3 = nextSet;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int nextSet2 = bitArray.getNextSet(i3);
            if (patternToChar == '*') {
                stringBuilder.setLength(stringBuilder.length() - 1);
                toNarrowWidePattern = 0;
                i2 = toNarrowWidePattern;
                while (toNarrowWidePattern < iArr.length) {
                    i2 += iArr[toNarrowWidePattern];
                    toNarrowWidePattern++;
                }
                int i5 = (nextSet2 - nextSet) - i2;
                if (nextSet2 == size || i5 * 2 >= i2) {
                    if (this.usingCheckDigit) {
                        i5 = stringBuilder.length() - 1;
                        size = 0;
                        toNarrowWidePattern = size;
                        while (size < i5) {
                            toNarrowWidePattern += ALPHABET_STRING.indexOf(this.decodeRowResult.charAt(size));
                            size++;
                        }
                        if (stringBuilder.charAt(i5) != ALPHABET[toNarrowWidePattern % 43]) {
                            throw ChecksumException.getChecksumInstance();
                        }
                        stringBuilder.setLength(i5);
                    }
                    if (stringBuilder.length() == 0) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    String decodeExtended = this.extendedMode ? decodeExtended(stringBuilder) : stringBuilder.toString();
                    float f = ((float) nextSet) + (((float) i2) / 2.0f);
                    r14 = new ResultPoint[2];
                    float f2 = (float) i;
                    r14[0] = new ResultPoint(((float) (findAsteriskPattern[1] + findAsteriskPattern[0])) / 2.0f, f2);
                    r14[1] = new ResultPoint(f, f2);
                    return new Result(decodeExtended, null, r14, BarcodeFormat.CODE_39);
                }
                throw NotFoundException.getNotFoundInstance();
            }
            nextSet = nextSet2;
        }
    }
}
