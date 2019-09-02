package com.google.zxing.datamatrix.encoder;

final class X12Encoder extends C40Encoder {
    X12Encoder() {
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder stringBuilder = new StringBuilder();
        while (encoderContext.hasMoreCharacters()) {
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            encodeChar(currentChar, stringBuilder);
            if (stringBuilder.length() % 3 == 0) {
                C40Encoder.writeNextTriplet(encoderContext, stringBuilder);
                int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
                if (lookAheadTest != getEncodingMode()) {
                    encoderContext.signalEncoderChange(lookAheadTest);
                    break;
                }
            }
        }
        handleEOD(encoderContext, stringBuilder);
    }

    /* Access modifiers changed, original: 0000 */
    public int encodeChar(char c, StringBuilder stringBuilder) {
        if (c == 13) {
            stringBuilder.append(0);
        } else if (c == '*') {
            stringBuilder.append(1);
        } else if (c == '>') {
            stringBuilder.append(2);
        } else if (c == ' ') {
            stringBuilder.append(3);
        } else if (c >= '0' && c <= '9') {
            stringBuilder.append((char) ((c - 48) + 4));
        } else if (c < 'A' || c > 'Z') {
            HighLevelEncoder.illegalCharacter(c);
        } else {
            stringBuilder.append((char) ((c - 65) + 14));
        }
        return 1;
    }

    public int getEncodingMode() {
        return 3;
    }

    /* Access modifiers changed, original: 0000 */
    public void handleEOD(EncoderContext encoderContext, StringBuilder stringBuilder) {
        encoderContext.updateSymbolInfo();
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
        encoderContext.pos -= stringBuilder.length();
        if (encoderContext.getRemainingCharacters() > 1 || dataCapacity > 1 || encoderContext.getRemainingCharacters() != dataCapacity) {
            encoderContext.writeCodeword(254);
        }
        if (encoderContext.getNewEncoding() < 0) {
            encoderContext.signalEncoderChange(0);
        }
    }
}
