package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class TelResultParser extends ResultParser {
    public TelParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("tel:") && !massagedText.startsWith("TEL:")) {
            return null;
        }
        String stringBuilder;
        if (massagedText.startsWith("TEL:")) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("tel:");
            stringBuilder2.append(massagedText.substring(4));
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = massagedText;
        }
        int indexOf = massagedText.indexOf(63, 4);
        return new TelParsedResult(indexOf < 0 ? massagedText.substring(4) : massagedText.substring(4, indexOf), stringBuilder, null);
    }
}
