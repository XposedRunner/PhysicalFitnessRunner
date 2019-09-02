package com.google.zxing.oned;

import com.alibaba.wireless.security.SecExceptionCode;
import com.amap.api.maps.utils.SpatialRelationUtil;
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

public final class Code93Reader extends OneDReader {
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    private static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final int ASTERISK_ENCODING = CHARACTER_ENCODINGS[47];
    private static final int[] CHARACTER_ENCODINGS = new int[]{276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY, 394, SpatialRelationUtil.A_CIRCLE_DEGREE, 356, 354, SecExceptionCode.SEC_ERROR_STA_NO_MEMORY, 282, 344, 332, 326, SecExceptionCode.SEC_ERROR_STA_ENC, 278, 436, 434, 428, SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED, SecExceptionCode.SEC_ERROR_DYN_ENC_INVALID_ENCRYPTED_DATA, 410, 364, 358, SecExceptionCode.SEC_ERROR_STA_INVALID_ENCRYPTED_DATA, 314, SecExceptionCode.SEC_ERROR_STA_DATA_FILE_MISMATCH, 468, 466, 458, 366, 374, 430, 294, 474, 470, SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED, 350};
    private final int[] counters = new int[6];
    private final StringBuilder decodeRowResult = new StringBuilder(20);

    private static void checkChecksums(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }

    private static void checkOneChecksum(CharSequence charSequence, int i, int i2) throws ChecksumException {
        int i3 = 0;
        int i4 = 1;
        for (int i5 = i - 1; i5 >= 0; i5--) {
            i3 += ALPHABET_STRING.indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i) != ALPHABET[i3 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 'a' || charAt > 'd') {
                stringBuilder.append(charAt);
            } else if (i >= length - 1) {
                throw FormatException.getFormatInstance();
            } else {
                i++;
                char charAt2 = charSequence.charAt(i);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 - 64);
                            break;
                        }
                        throw FormatException.getFormatInstance();
                    case 'b':
                        if (charAt2 < 'A' || charAt2 > 'E') {
                            if (charAt2 < 'F' || charAt2 > 'J') {
                                if (charAt2 < 'K' || charAt2 > 'O') {
                                    if (charAt2 < 'P' || charAt2 > 'S') {
                                        if (charAt2 >= 'T' && charAt2 <= 'Z') {
                                            charAt = 127;
                                            break;
                                        }
                                        throw FormatException.getFormatInstance();
                                    }
                                    charAt = (char) (charAt2 + 43);
                                    break;
                                }
                                charAt = (char) (charAt2 + 16);
                                break;
                            }
                            charAt = (char) (charAt2 - 11);
                            break;
                        }
                        charAt = (char) (charAt2 - 38);
                        break;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            charAt = (char) (charAt2 - 32);
                            break;
                        } else if (charAt2 == 'Z') {
                            charAt = ':';
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            charAt = (char) (charAt2 + 32);
                            break;
                        }
                        throw FormatException.getFormatInstance();
                        break;
                    default:
                        charAt = 0;
                        break;
                }
                stringBuilder.append(charAt);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    private int[] findAsteriskPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        Arrays.fill(this.counters, 0);
        int[] iArr = this.counters;
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
                } else if (toPattern(iArr) == ASTERISK_ENCODING) {
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

    private static int toPattern(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        int i2 = i;
        while (i < iArr.length) {
            i2 += iArr[i];
            i++;
        }
        int i3 = 0;
        i = i3;
        while (i3 < length) {
            int round = Math.round((((float) iArr[i3]) * 9.0f) / ((float) i2));
            if (round < 1 || round > 4) {
                return -1;
            }
            if ((i3 & 1) == 0) {
                int i4 = i;
                for (i = 0; i < round; i++) {
                    i4 = (i4 << 1) | 1;
                }
                i = i4;
            } else {
                i <<= round;
            }
            i3++;
        }
        return i;
    }

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] findAsteriskPattern = findAsteriskPattern(bitArray);
        int nextSet = bitArray.getNextSet(findAsteriskPattern[1]);
        int size = bitArray.getSize();
        int[] iArr = this.counters;
        Arrays.fill(iArr, 0);
        StringBuilder stringBuilder = this.decodeRowResult;
        stringBuilder.setLength(0);
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int toPattern = toPattern(iArr);
            if (toPattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i2;
            char patternToChar = patternToChar(toPattern);
            stringBuilder.append(patternToChar);
            int i3 = nextSet;
            for (int i4 : iArr) {
                i3 += i4;
            }
            int nextSet2 = bitArray.getNextSet(i3);
            if (patternToChar == '*') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                i2 = 0;
                i3 = i2;
                while (i2 < iArr.length) {
                    i3 += iArr[i2];
                    i2++;
                }
                if (nextSet2 == size || !bitArray.get(nextSet2)) {
                    throw NotFoundException.getNotFoundInstance();
                } else if (stringBuilder.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                } else {
                    checkChecksums(stringBuilder);
                    stringBuilder.setLength(stringBuilder.length() - 2);
                    String decodeExtended = decodeExtended(stringBuilder);
                    float f = ((float) nextSet) + (((float) i3) / 2.0f);
                    r2 = new ResultPoint[2];
                    float f2 = (float) i;
                    r2[0] = new ResultPoint(((float) (findAsteriskPattern[1] + findAsteriskPattern[0])) / 2.0f, f2);
                    r2[1] = new ResultPoint(f, f2);
                    return new Result(decodeExtended, null, r2, BarcodeFormat.CODE_93);
                }
            }
            nextSet = nextSet2;
        }
    }
}
