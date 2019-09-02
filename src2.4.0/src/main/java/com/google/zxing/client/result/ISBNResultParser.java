package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;

public final class ISBNResultParser extends ResultParser {
    public ISBNParsedResult parse(Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.EAN_13) {
            return null;
        }
        String massagedText = ResultParser.getMassagedText(result);
        return massagedText.length() != 13 ? null : (massagedText.startsWith("978") || massagedText.startsWith("979")) ? new ISBNParsedResult(massagedText) : null;
    }
}
