package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public abstract class UPCEANReader extends OneDReader {
    static final int[][] L_AND_G_PATTERNS = new int[20][];
    static final int[][] L_PATTERNS = new int[][]{new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
    private static final float MAX_AVG_VARIANCE = 0.48f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;
    static final int[] MIDDLE_PATTERN = new int[]{1, 1, 1, 1, 1};
    static final int[] START_END_PATTERN = new int[]{1, 1, 1};
    private final StringBuilder decodeRowStringBuffer = new StringBuilder(20);
    private final EANManufacturerOrgSupport eanManSupport = new EANManufacturerOrgSupport();
    private final UPCEANExtensionSupport extensionReader = new UPCEANExtensionSupport();

    static {
        int i = 10;
        System.arraycopy(L_PATTERNS, 0, L_AND_G_PATTERNS, 0, 10);
        while (i < 20) {
            int[] iArr = L_PATTERNS[i - 10];
            int[] iArr2 = new int[iArr.length];
            for (int i2 = 0; i2 < iArr.length; i2++) {
                iArr2[i2] = iArr[(iArr.length - i2) - 1];
            }
            L_AND_G_PATTERNS[i] = iArr2;
            i++;
        }
    }

    protected UPCEANReader() {
    }

    static boolean checkStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        boolean z = false;
        if (length == 0) {
            return false;
        }
        int charAt;
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            charAt = charSequence.charAt(i2) - 48;
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i += charAt;
        }
        i *= 3;
        for (length--; length >= 0; length -= 2) {
            charAt = charSequence.charAt(length) - 48;
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i += charAt;
        }
        if (i % 10 == 0) {
            z = true;
        }
        return z;
    }

    static int decodeDigit(BitArray bitArray, int[] iArr, int i, int[][] iArr2) throws NotFoundException {
        OneDReader.recordPattern(bitArray, i, iArr);
        float f = MAX_AVG_VARIANCE;
        i = -1;
        int length = iArr2.length;
        for (int i2 = 0; i2 < length; i2++) {
            float patternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i2], 0.7f);
            if (patternMatchVariance < f) {
                i = i2;
                f = patternMatchVariance;
            }
        }
        if (i >= 0) {
            return i;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static int[] findGuardPattern(BitArray bitArray, int i, boolean z, int[] iArr) throws NotFoundException {
        return findGuardPattern(bitArray, i, z, iArr, new int[iArr.length]);
    }

    private static int[] findGuardPattern(BitArray bitArray, int i, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int length = iArr.length;
        int size = bitArray.getSize();
        i = z ? bitArray.getNextUnset(i) : bitArray.getNextSet(i);
        int i2 = i;
        int i3 = 0;
        while (i < size) {
            int i4 = 1;
            int z2;
            if ((bitArray.get(i) ^ z2) != 0) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                int i5 = length - 1;
                if (i3 != i5) {
                    i3++;
                } else if (OneDReader.patternMatchVariance(iArr2, iArr, 0.7f) < MAX_AVG_VARIANCE) {
                    return new int[]{i2, i};
                } else {
                    i2 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                if (z2 != 0) {
                    i4 = 0;
                }
                z2 = i4;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    static int[] findStartGuardPattern(BitArray bitArray) throws NotFoundException {
        int[] iArr = new int[START_END_PATTERN.length];
        int i = 0;
        int[] iArr2 = null;
        boolean z = i;
        while (!z) {
            Arrays.fill(iArr, 0, START_END_PATTERN.length, 0);
            iArr2 = findGuardPattern(bitArray, i, false, START_END_PATTERN, iArr);
            i = iArr2[0];
            int i2 = iArr2[1];
            int i3 = i - (i2 - i);
            if (i3 >= 0) {
                z = bitArray.isRange(i3, i, false);
            }
            i = i2;
        }
        return iArr2;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean checkChecksum(String str) throws FormatException {
        return checkStandardUPCEANChecksum(str);
    }

    /* Access modifiers changed, original: 0000 */
    public int[] decodeEnd(BitArray bitArray, int i) throws NotFoundException {
        return findGuardPattern(bitArray, i, false, START_END_PATTERN);
    }

    public abstract int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder stringBuilder) throws NotFoundException;

    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return decodeRow(i, bitArray, findStartGuardPattern(bitArray), map);
    }

    public Result decodeRow(int i, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        byte[] bArr = null;
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        int i2 = 1;
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(((float) (iArr[0] + iArr[1])) / 2.0f, (float) i));
        }
        StringBuilder stringBuilder = this.decodeRowStringBuffer;
        stringBuilder.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, stringBuilder);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((float) decodeMiddle, (float) i));
        }
        int[] decodeEnd = decodeEnd(bitArray, decodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(((float) (decodeEnd[0] + decodeEnd[1])) / 2.0f, (float) i));
        }
        int i3 = decodeEnd[1];
        int i4 = (i3 - decodeEnd[0]) + i3;
        if (i4 >= bitArray.getSize() || !bitArray.isRange(i3, i4, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.length() < 8) {
            throw FormatException.getFormatInstance();
        } else if (checkChecksum(stringBuilder2)) {
            byte length;
            float f = ((float) (iArr[1] + iArr[0])) / 2.0f;
            float f2 = ((float) (decodeEnd[1] + decodeEnd[0])) / 2.0f;
            BarcodeFormat barcodeFormat = getBarcodeFormat();
            r8 = new ResultPoint[2];
            float f3 = (float) i;
            r8[0] = new ResultPoint(f, f3);
            r8[1] = new ResultPoint(f2, f3);
            Result result = new Result(stringBuilder2, null, r8, barcodeFormat);
            try {
                Result decodeRow = this.extensionReader.decodeRow(i, bitArray, decodeEnd[1]);
                result.putMetadata(ResultMetadataType.UPC_EAN_EXTENSION, decodeRow.getText());
                result.putAllMetadata(decodeRow.getResultMetadata());
                result.addResultPoints(decodeRow.getResultPoints());
                length = decodeRow.getText().length();
            } catch (ReaderException unused) {
                length = (byte) 0;
            }
            if (map != null) {
                bArr = (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
            }
            if (bArr != null) {
                for (byte b : bArr) {
                    if (length == b) {
                        break;
                    }
                }
                i2 = 0;
                if (i2 == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            if (barcodeFormat == BarcodeFormat.EAN_13 || barcodeFormat == BarcodeFormat.UPC_A) {
                String lookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(stringBuilder2);
                if (lookupCountryIdentifier != null) {
                    result.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, lookupCountryIdentifier);
                }
            }
            return result;
        } else {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public abstract BarcodeFormat getBarcodeFormat();
}
