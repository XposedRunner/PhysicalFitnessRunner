package com.google.zxing.oned.rss.expanded.decoders;

import com.alibaba.wireless.security.SecExceptionCode;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class GeneralAppIdDecoder {
    private final StringBuilder buffer = new StringBuilder();
    private final CurrentParsingState current = new CurrentParsingState();
    private final BitArray information;

    GeneralAppIdDecoder(BitArray bitArray) {
        this.information = bitArray;
    }

    private DecodedChar decodeAlphanumeric(int i) {
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, '$');
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i + 5, (char) ((48 + extractNumericValueFromBitArray) - 5));
        }
        extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 6);
        if (extractNumericValueFromBitArray >= 32 && extractNumericValueFromBitArray < 58) {
            return new DecodedChar(i + 6, (char) (extractNumericValueFromBitArray + 33));
        }
        char c;
        switch (extractNumericValueFromBitArray) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Decoding invalid alphanumeric value: ");
                stringBuilder.append(extractNumericValueFromBitArray);
                throw new IllegalStateException(stringBuilder.toString());
        }
        return new DecodedChar(i + 6, c);
    }

    private DecodedChar decodeIsoIec646(int i) throws FormatException {
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i + 5, '$');
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i + 5, (char) ((48 + extractNumericValueFromBitArray) - 5));
        }
        extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 7);
        if (extractNumericValueFromBitArray >= 64 && extractNumericValueFromBitArray < 90) {
            return new DecodedChar(i + 7, (char) (extractNumericValueFromBitArray + 1));
        }
        if (extractNumericValueFromBitArray >= 90 && extractNumericValueFromBitArray < SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT) {
            return new DecodedChar(i + 7, (char) (extractNumericValueFromBitArray + 7));
        }
        char c;
        switch (extractNumericValueFromBitArray(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = '&';
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = '(';
                break;
            case 238:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN /*240*/:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = '/';
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = '<';
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = '>';
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new DecodedChar(i + 8, c);
    }

    private DecodedNumeric decodeNumeric(int i) throws FormatException {
        int i2 = i + 7;
        if (i2 > this.information.getSize()) {
            i = extractNumericValueFromBitArray(i, 4);
            return i == 0 ? new DecodedNumeric(this.information.getSize(), 10, 10) : new DecodedNumeric(this.information.getSize(), i - 1, 10);
        } else {
            i = extractNumericValueFromBitArray(i, 7) - 8;
            return new DecodedNumeric(i2, i / 11, i % 11);
        }
    }

    static int extractNumericValueFromBitArray(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            if (bitArray.get(i + i3)) {
                i4 |= 1 << ((i2 - i3) - 1);
            }
            i3++;
        }
        return i4;
    }

    private boolean isAlphaOr646ToNumericLatch(int i) {
        int i2 = i + 3;
        if (i2 > this.information.getSize()) {
            return false;
        }
        while (i < i2) {
            if (this.information.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private boolean isAlphaTo646ToAlphaLatch(int i) {
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = i2 + i;
            if (i3 >= this.information.getSize()) {
                break;
            }
            if (i2 == 2) {
                if (!this.information.get(i + 2)) {
                    return false;
                }
            } else if (this.information.get(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean isNumericToAlphaNumericLatch(int i) {
        if (i + 1 > this.information.getSize()) {
            return false;
        }
        int i2 = 0;
        while (i2 < 4) {
            int i3 = i2 + i;
            if (i3 >= this.information.getSize()) {
                break;
            } else if (this.information.get(i3)) {
                return false;
            } else {
                i2++;
            }
        }
        return true;
    }

    private boolean isStillAlpha(int i) {
        boolean z = false;
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 16) {
            return true;
        }
        if (i + 6 > this.information.getSize()) {
            return false;
        }
        i = extractNumericValueFromBitArray(i, 6);
        if (i >= 16 && i < 63) {
            z = true;
        }
        return z;
    }

    private boolean isStillIsoIec646(int i) {
        boolean z = false;
        if (i + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i, 5);
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 16) {
            return true;
        }
        if (i + 7 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i, 7);
        if (extractNumericValueFromBitArray2 >= 64 && extractNumericValueFromBitArray2 < SecExceptionCode.SEC_ERROR_INIT_NULL_APPLICTION_CONTEXT) {
            return true;
        }
        if (i + 8 > this.information.getSize()) {
            return false;
        }
        i = extractNumericValueFromBitArray(i, 8);
        if (i >= 232 && i < 253) {
            z = true;
        }
        return z;
    }

    private boolean isStillNumeric(int i) {
        boolean z = true;
        if (i + 7 > this.information.getSize()) {
            if (i + 4 > this.information.getSize()) {
                z = false;
            }
            return z;
        }
        int i2 = i;
        while (true) {
            int i3 = i + 3;
            if (i2 >= i3) {
                return this.information.get(i3);
            }
            if (this.information.get(i2)) {
                return true;
            }
            i2++;
        }
    }

    private BlockParsedResult parseAlphaBlock() {
        while (isStillAlpha(this.current.getPosition())) {
            DecodedChar decodeAlphanumeric = decodeAlphanumeric(this.current.getPosition());
            this.current.setPosition(decodeAlphanumeric.getNewPosition());
            if (decodeAlphanumeric.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeAlphanumeric.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setIsoIec646();
        }
        return new BlockParsedResult(false);
    }

    private DecodedInformation parseBlocks() throws FormatException {
        BlockParsedResult parseAlphaBlock;
        boolean isFinished;
        do {
            int position = this.current.getPosition();
            if (this.current.isAlpha()) {
                parseAlphaBlock = parseAlphaBlock();
                isFinished = parseAlphaBlock.isFinished();
            } else if (this.current.isIsoIec646()) {
                parseAlphaBlock = parseIsoIec646Block();
                isFinished = parseAlphaBlock.isFinished();
            } else {
                parseAlphaBlock = parseNumericBlock();
                isFinished = parseAlphaBlock.isFinished();
            }
            if ((position != this.current.getPosition() ? 1 : null) == null && !isFinished) {
                break;
            }
        } while (!isFinished);
        return parseAlphaBlock.getDecodedInformation();
    }

    private BlockParsedResult parseIsoIec646Block() throws FormatException {
        while (isStillIsoIec646(this.current.getPosition())) {
            DecodedChar decodeIsoIec646 = decodeIsoIec646(this.current.getPosition());
            this.current.setPosition(decodeIsoIec646.getNewPosition());
            if (decodeIsoIec646.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeIsoIec646.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setAlpha();
        }
        return new BlockParsedResult(false);
    }

    private BlockParsedResult parseNumericBlock() throws FormatException {
        while (isStillNumeric(this.current.getPosition())) {
            DecodedNumeric decodeNumeric = decodeNumeric(this.current.getPosition());
            this.current.setPosition(decodeNumeric.getNewPosition());
            if (decodeNumeric.isFirstDigitFNC1()) {
                return new BlockParsedResult(decodeNumeric.isSecondDigitFNC1() ? new DecodedInformation(this.current.getPosition(), this.buffer.toString()) : new DecodedInformation(this.current.getPosition(), this.buffer.toString(), decodeNumeric.getSecondDigit()), true);
            }
            this.buffer.append(decodeNumeric.getFirstDigit());
            if (decodeNumeric.isSecondDigitFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeNumeric.getSecondDigit());
        }
        if (isNumericToAlphaNumericLatch(this.current.getPosition())) {
            this.current.setAlpha();
            this.current.incrementPosition(4);
        }
        return new BlockParsedResult(false);
    }

    /* Access modifiers changed, original: 0000 */
    public String decodeAllCodes(StringBuilder stringBuilder, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            DecodedInformation decodeGeneralPurposeField = decodeGeneralPurposeField(i, str);
            String parseFieldsInGeneralPurpose = FieldParser.parseFieldsInGeneralPurpose(decodeGeneralPurposeField.getNewString());
            if (parseFieldsInGeneralPurpose != null) {
                stringBuilder.append(parseFieldsInGeneralPurpose);
            }
            parseFieldsInGeneralPurpose = decodeGeneralPurposeField.isRemaining() ? String.valueOf(decodeGeneralPurposeField.getRemainingValue()) : null;
            if (i == decodeGeneralPurposeField.getNewPosition()) {
                return stringBuilder.toString();
            }
            i = decodeGeneralPurposeField.getNewPosition();
            str = parseFieldsInGeneralPurpose;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public DecodedInformation decodeGeneralPurposeField(int i, String str) throws FormatException {
        this.buffer.setLength(0);
        if (str != null) {
            this.buffer.append(str);
        }
        this.current.setPosition(i);
        DecodedInformation parseBlocks = parseBlocks();
        return (parseBlocks == null || !parseBlocks.isRemaining()) ? new DecodedInformation(this.current.getPosition(), this.buffer.toString()) : new DecodedInformation(this.current.getPosition(), this.buffer.toString(), parseBlocks.getRemainingValue());
    }

    /* Access modifiers changed, original: 0000 */
    public int extractNumericValueFromBitArray(int i, int i2) {
        return extractNumericValueFromBitArray(this.information, i, i2);
    }
}
