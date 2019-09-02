package com.google.zxing.datamatrix.encoder;

import com.alibaba.wireless.security.SecExceptionCode;

class C40Encoder implements Encoder {
    C40Encoder() {
    }

    private int backtrackOneCharacter(EncoderContext encoderContext, StringBuilder stringBuilder, StringBuilder stringBuilder2, int i) {
        int length = stringBuilder.length();
        stringBuilder.delete(length - i, length);
        encoderContext.pos--;
        int encodeChar = encodeChar(encoderContext.getCurrentChar(), stringBuilder2);
        encoderContext.resetSymbolInfo();
        return encodeChar;
    }

    private static String encodeToCodewords(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        char charAt2 = charSequence.charAt(i + 1);
        char charAt3 = (char) (((((SecExceptionCode.SEC_ERROR_SAFETOKEN * charAt) + (40 * charAt2)) + charSequence.charAt(i + 2)) + 1) % 256);
        return new String(new char[]{(char) (((((SecExceptionCode.SEC_ERROR_SAFETOKEN * charAt) + (40 * charAt2)) + charSequence.charAt(i + 2)) + 1) / 256), charAt3});
    }

    static void writeNextTriplet(EncoderContext encoderContext, StringBuilder stringBuilder) {
        encoderContext.writeCodewords(encodeToCodewords(stringBuilder, 0));
        stringBuilder.delete(0, 3);
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder stringBuilder = new StringBuilder();
        while (encoderContext.hasMoreCharacters()) {
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int encodeChar = encodeChar(currentChar, stringBuilder);
            int codewordCount = encoderContext.getCodewordCount() + ((stringBuilder.length() / 3) * 2);
            encoderContext.updateSymbolInfo(codewordCount);
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
            if (!encoderContext.hasMoreCharacters()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                if (stringBuilder.length() % 3 == 2 && (dataCapacity < 2 || dataCapacity > 2)) {
                    encodeChar = backtrackOneCharacter(encoderContext, stringBuilder, stringBuilder2, encodeChar);
                }
                while (stringBuilder.length() % 3 == 1 && ((encodeChar <= 3 && dataCapacity != 1) || encodeChar > 3)) {
                    encodeChar = backtrackOneCharacter(encoderContext, stringBuilder, stringBuilder2, encodeChar);
                }
            } else if (stringBuilder.length() % 3 == 0) {
                encodeChar = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
                if (encodeChar != getEncodingMode()) {
                    encoderContext.signalEncoderChange(encodeChar);
                    break;
                }
            }
        }
        handleEOD(encoderContext, stringBuilder);
    }

    /* Access modifiers changed, original: 0000 */
    public int encodeChar(char c, StringBuilder stringBuilder) {
        if (c == ' ') {
            stringBuilder.append(3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            stringBuilder.append((char) ((c - 65) + 14));
            return 1;
        } else if (c >= 0 && c <= 31) {
            stringBuilder.append(0);
            stringBuilder.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            stringBuilder.append(1);
            stringBuilder.append((char) (c - 33));
            return 2;
        } else if (c >= ':' && c <= '@') {
            stringBuilder.append(1);
            stringBuilder.append((char) ((c - 58) + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            stringBuilder.append(1);
            stringBuilder.append((char) ((c - 91) + 22));
            return 2;
        } else if (c >= '`' && c <= 127) {
            stringBuilder.append(2);
            stringBuilder.append((char) (c - 96));
            return 2;
        } else if (c >= 128) {
            stringBuilder.append("\u0001\u001e");
            return 2 + encodeChar((char) (c - 128), stringBuilder);
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Illegal character: ");
            stringBuilder2.append(c);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
    }

    public int getEncodingMode() {
        return 1;
    }

    /* Access modifiers changed, original: 0000 */
    public void handleEOD(EncoderContext encoderContext, StringBuilder stringBuilder) {
        int length = stringBuilder.length() % 3;
        int codewordCount = encoderContext.getCodewordCount() + ((stringBuilder.length() / 3) * 2);
        encoderContext.updateSymbolInfo(codewordCount);
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
        if (length == 2) {
            stringBuilder.append(0);
            while (stringBuilder.length() >= 3) {
                writeNextTriplet(encoderContext, stringBuilder);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword(254);
            }
        } else if (dataCapacity == 1 && length == 1) {
            while (stringBuilder.length() >= 3) {
                writeNextTriplet(encoderContext, stringBuilder);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword(254);
            }
            encoderContext.pos--;
        } else if (length == 0) {
            while (stringBuilder.length() >= 3) {
                writeNextTriplet(encoderContext, stringBuilder);
            }
            if (dataCapacity > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        encoderContext.signalEncoderChange(0);
    }
}
