package com.google.zxing.datamatrix.encoder;

import android.support.v4.view.InputDeviceCompat;

final class Base256Encoder implements Encoder {
    Base256Encoder() {
    }

    private static char randomize255State(char c, int i) {
        int i2 = c + (((149 * i) % 255) + 1);
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }

    public void encode(EncoderContext encoderContext) {
        int lookAheadTest;
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        stringBuilder.append(0);
        while (encoderContext.hasMoreCharacters()) {
            stringBuilder.append(encoderContext.getCurrentChar());
            encoderContext.pos++;
            lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
            if (lookAheadTest != getEncodingMode()) {
                encoderContext.signalEncoderChange(lookAheadTest);
                break;
            }
        }
        lookAheadTest = stringBuilder.length() - 1;
        int codewordCount = (encoderContext.getCodewordCount() + lookAheadTest) + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        codewordCount = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount > 0 ? 1 : 0;
        if (encoderContext.hasMoreCharacters() || codewordCount != 0) {
            if (lookAheadTest <= 249) {
                stringBuilder.setCharAt(0, (char) lookAheadTest);
            } else if (lookAheadTest <= 249 || lookAheadTest > 1555) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Message length not in valid ranges: ");
                stringBuilder.append(lookAheadTest);
                throw new IllegalStateException(stringBuilder.toString());
            } else {
                stringBuilder.setCharAt(0, (char) ((lookAheadTest / 250) + 249));
                stringBuilder.insert(1, (char) (lookAheadTest % 250));
            }
        }
        lookAheadTest = stringBuilder.length();
        while (i < lookAheadTest) {
            encoderContext.writeCodeword(randomize255State(stringBuilder.charAt(i), encoderContext.getCodewordCount() + 1));
            i++;
        }
    }

    public int getEncodingMode() {
        return 5;
    }
}
