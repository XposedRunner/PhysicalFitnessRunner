package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class UPCEANExtension2Support {
    private final int[] decodeMiddleCounters = new int[4];
    private final StringBuilder decodeRowStringBuffer = new StringBuilder();

    UPCEANExtension2Support() {
    }

    private static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(str));
        return enumMap;
    }

    /* Access modifiers changed, original: 0000 */
    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder stringBuilder) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        int i3 = i2;
        while (i2 < 2 && i < size) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i, UPCEANReader.L_AND_G_PATTERNS);
            stringBuilder.append((char) (48 + (decodeDigit % 10)));
            int i4 = i;
            for (int i5 : iArr2) {
                i4 += i5;
            }
            if (decodeDigit >= 10) {
                i3 = (1 << (1 - i2)) | i3;
            }
            i = i2 != 1 ? bitArray.getNextUnset(bitArray.getNextSet(i4)) : i4;
            i2++;
        }
        if (stringBuilder.length() != 2) {
            throw NotFoundException.getNotFoundInstance();
        } else if (Integer.parseInt(stringBuilder.toString()) % 4 == i3) {
            return i;
        } else {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Result decodeRow(int i, BitArray bitArray, int[] iArr) throws NotFoundException {
        StringBuilder stringBuilder = this.decodeRowStringBuffer;
        stringBuilder.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, stringBuilder);
        String stringBuilder2 = stringBuilder.toString();
        Map parseExtensionString = parseExtensionString(stringBuilder2);
        r4 = new ResultPoint[2];
        float f = (float) i;
        r4[0] = new ResultPoint(((float) (iArr[0] + iArr[1])) / 2.0f, f);
        r4[1] = new ResultPoint((float) decodeMiddle, f);
        Result result = new Result(stringBuilder2, null, r4, BarcodeFormat.UPC_EAN_EXTENSION);
        if (parseExtensionString != null) {
            result.putAllMetadata(parseExtensionString);
        }
        return result;
    }
}
