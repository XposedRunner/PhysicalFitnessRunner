package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser {
    public URIParsedResult parse(Result result) {
        String text = result.getText();
        URIParsedResult uRIParsedResult = null;
        if (!text.startsWith("MEBKM:")) {
            return null;
        }
        String matchSingleDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("TITLE:", text, true);
        String[] matchDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("URL:", text, true);
        if (matchDoCoMoPrefixedField == null) {
            return null;
        }
        text = matchDoCoMoPrefixedField[0];
        if (URIResultParser.isBasicallyValidURI(text)) {
            uRIParsedResult = new URIParsedResult(text, matchSingleDoCoMoPrefixedField);
        }
        return uRIParsedResult;
    }
}
