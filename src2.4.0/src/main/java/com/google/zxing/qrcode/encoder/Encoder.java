package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    private Encoder() {
    }

    static void append8BitBytes(String str, BitArray bitArray, String str2) throws WriterException {
        try {
            for (byte appendBits : str.getBytes(str2)) {
                bitArray.appendBits(appendBits, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                i2 = getAlphanumericCode(charSequence.charAt(i2));
                if (i2 == -1) {
                    throw new WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + i2, 11);
                i += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i = i2;
            }
        }
    }

    static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) throws WriterException {
        switch (mode) {
            case NUMERIC:
                appendNumericBytes(str, bitArray);
                return;
            case ALPHANUMERIC:
                appendAlphanumericBytes(str, bitArray);
                return;
            case BYTE:
                append8BitBytes(str, bitArray, str2);
                return;
            case KANJI:
                appendKanjiBytes(str, bitArray);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid mode: ");
                stringBuilder.append(mode);
                throw new WriterException(stringBuilder.toString());
        }
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    static void appendKanjiBytes(String str, BitArray bitArray) throws WriterException {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & 255) << 8) | (bytes[i + 1] & 255);
                i2 = (i2 < 33088 || i2 > 40956) ? (i2 < 57408 || i2 > 60351) ? -1 : i2 - 49472 : i2 - 33088;
                if (i2 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitArray.appendBits(((i2 >> 8) * 192) + (i2 & 255), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    static void appendLengthInfo(int i, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i2 = 1 << characterCountBits;
        if (i >= i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append(" is bigger than ");
            stringBuilder.append(i2 - 1);
            throw new WriterException(stringBuilder.toString());
        }
        bitArray.appendBits(i, characterCountBits);
    }

    static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - 48;
            int i2 = i + 2;
            if (i2 < length) {
                bitArray.appendBits(((charAt * 100) + ((charSequence.charAt(i + 1) - 48) * 10)) + (charSequence.charAt(i2) - 48), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    bitArray.appendBits((charAt * 10) + (charSequence.charAt(i) - 48), 7);
                    i = i2;
                } else {
                    bitArray.appendBits(charAt, 4);
                }
            }
        }
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return ((MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix)) + MaskUtil.applyMaskPenaltyRule3(byteMatrix)) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i3, byteMatrix);
            int calculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (calculateMaskPenalty < i) {
                i2 = i3;
                i = calculateMaskPenalty;
            }
        }
        return i2;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, null);
    }

    private static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return isOnlyDoubleByteKanji(str) ? Mode.KANJI : Mode.BYTE;
        }
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                i3 = 1;
            } else if (getAlphanumericCode(charAt) == -1) {
                return Mode.BYTE;
            } else {
                i2 = 1;
            }
            i++;
        }
        return i2 != 0 ? Mode.ALPHANUMERIC : i3 != 0 ? Mode.NUMERIC : Mode.BYTE;
    }

    private static Version chooseVersion(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            Version versionForNumber = Version.getVersionForNumber(i2);
            if (versionForNumber.getTotalCodewords() - versionForNumber.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i + 7) / 8) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return encode(str, errorCorrectionLevel, null);
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        String str2 = map == null ? null : (String) map.get(EncodeHintType.CHARACTER_SET);
        if (str2 == null) {
            str2 = DEFAULT_BYTE_MODE_ENCODING;
        }
        Mode chooseMode = chooseMode(str, str2);
        BitArray bitArray = new BitArray();
        if (chooseMode == Mode.BYTE && !DEFAULT_BYTE_MODE_ENCODING.equals(str2)) {
            CharacterSetECI characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(str2);
            if (characterSetECIByName != null) {
                appendECI(characterSetECIByName, bitArray);
            }
        }
        appendModeInfo(chooseMode, bitArray);
        BitArray bitArray2 = new BitArray();
        appendBytes(str, chooseMode, bitArray2, str2);
        Version chooseVersion = chooseVersion((bitArray.getSize() + chooseMode.getCharacterCountBits(chooseVersion((bitArray.getSize() + chooseMode.getCharacterCountBits(Version.getVersionForNumber(1))) + bitArray2.getSize(), errorCorrectionLevel))) + bitArray2.getSize(), errorCorrectionLevel);
        BitArray bitArray3 = new BitArray();
        bitArray3.appendBitArray(bitArray);
        appendLengthInfo(chooseMode == Mode.BYTE ? bitArray2.getSizeInBytes() : str.length(), chooseVersion, chooseMode, bitArray3);
        bitArray3.appendBitArray(bitArray2);
        ECBlocks eCBlocksForLevel = chooseVersion.getECBlocksForLevel(errorCorrectionLevel);
        int totalCodewords = chooseVersion.getTotalCodewords() - eCBlocksForLevel.getTotalECCodewords();
        terminateBits(totalCodewords, bitArray3);
        BitArray interleaveWithECBytes = interleaveWithECBytes(bitArray3, chooseVersion.getTotalCodewords(), totalCodewords, eCBlocksForLevel.getNumBlocks());
        QRCode qRCode = new QRCode();
        qRCode.setECLevel(errorCorrectionLevel);
        qRCode.setMode(chooseMode);
        qRCode.setVersion(chooseVersion);
        int dimensionForVersion = chooseVersion.getDimensionForVersion();
        ByteMatrix byteMatrix = new ByteMatrix(dimensionForVersion, dimensionForVersion);
        dimensionForVersion = chooseMaskPattern(interleaveWithECBytes, errorCorrectionLevel, chooseVersion, byteMatrix);
        qRCode.setMaskPattern(dimensionForVersion);
        MatrixUtil.buildMatrix(interleaveWithECBytes, errorCorrectionLevel, chooseVersion, dimensionForVersion, byteMatrix);
        qRCode.setMatrix(byteMatrix);
        return qRCode;
    }

    static byte[] generateECBytes(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i);
        bArr = new byte[i];
        while (i2 < i) {
            bArr[i2] = (byte) iArr[length + i2];
            i2++;
        }
        return bArr;
    }

    static int getAlphanumericCode(int i) {
        return i < ALPHANUMERIC_TABLE.length ? ALPHANUMERIC_TABLE[i] : -1;
    }

    static void getNumDataBytesAndNumECBytesForBlockID(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        i2 /= i3;
        int i9 = i2 + 1;
        i7 -= i2;
        i8 -= i9;
        if (i7 != i8) {
            throw new WriterException("EC bytes mismatch");
        } else if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        } else if (i != ((i2 + i7) * i6) + ((i9 + i8) * i5)) {
            throw new WriterException("Total bytes mismatch");
        } else if (i4 < i6) {
            iArr[0] = i2;
            iArr2[0] = i7;
        } else {
            iArr[0] = i9;
            iArr2[0] = i8;
        }
    }

    static BitArray interleaveWithECBytes(BitArray bitArray, int i, int i2, int i3) throws WriterException {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (bitArray.getSizeInBytes() != i5) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        byte[] generateECBytes;
        ArrayList<BlockPair> arrayList = new ArrayList(i6);
        int i7 = 0;
        int i8 = 0;
        int i9 = i8;
        int i10 = i9;
        int i11 = i10;
        while (i8 < i6) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int[] iArr3 = iArr;
            getNumDataBytesAndNumECBytesForBlockID(i4, i5, i6, i8, iArr, iArr2);
            int i12 = iArr3[0];
            byte[] bArr = new byte[i12];
            bitArray.toBytes(8 * i9, bArr, 0, i12);
            generateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, generateECBytes));
            i10 = Math.max(i10, i12);
            i11 = Math.max(i11, generateECBytes.length);
            i9 += iArr3[0];
            i8++;
        }
        if (i5 != i9) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (int i13 = 0; i13 < i10; i13++) {
            for (BlockPair dataBytes : arrayList) {
                generateECBytes = dataBytes.getDataBytes();
                if (i13 < generateECBytes.length) {
                    bitArray2.appendBits(generateECBytes[i13], 8);
                }
            }
        }
        while (i7 < i11) {
            for (BlockPair errorCorrectionBytes : arrayList) {
                byte[] errorCorrectionBytes2 = errorCorrectionBytes.getErrorCorrectionBytes();
                if (i7 < errorCorrectionBytes2.length) {
                    bitArray2.appendBits(errorCorrectionBytes2[i7], 8);
                }
            }
            i7++;
        }
        if (i4 == bitArray2.getSizeInBytes()) {
            return bitArray2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Interleaving error: ");
        stringBuilder.append(i4);
        stringBuilder.append(" and ");
        stringBuilder.append(bitArray2.getSizeInBytes());
        stringBuilder.append(" differ.");
        throw new WriterException(stringBuilder.toString());
    }

    private static boolean isOnlyDoubleByteKanji(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    static void terminateBits(int i, BitArray bitArray) throws WriterException {
        int i2 = i * 8;
        if (bitArray.getSize() > i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("data bits cannot fit in the QR Code");
            stringBuilder.append(bitArray.getSize());
            stringBuilder.append(" > ");
            stringBuilder.append(i2);
            throw new WriterException(stringBuilder.toString());
        }
        int i3;
        int i4 = 0;
        for (i3 = 0; i3 < 4 && bitArray.getSize() < i2; i3++) {
            bitArray.appendBit(false);
        }
        i3 = bitArray.getSize() & 7;
        if (i3 > 0) {
            while (i3 < 8) {
                bitArray.appendBit(false);
                i3++;
            }
        }
        i -= bitArray.getSizeInBytes();
        while (i4 < i) {
            bitArray.appendBits((i4 & 1) == 0 ? 236 : 17, 8);
            i4++;
        }
        if (bitArray.getSize() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }
}
