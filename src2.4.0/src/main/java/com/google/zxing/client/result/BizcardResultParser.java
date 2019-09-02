package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;

public final class BizcardResultParser extends AbstractDoCoMoResultParser {
    private static String buildName(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(' ');
            stringBuilder.append(str2);
            str = stringBuilder.toString();
        }
        return str;
    }

    private static String[] buildPhoneNumbers(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        return size == 0 ? null : (String[]) arrayList.toArray(new String[size]);
    }

    public AddressBookParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("BIZCARD:")) {
            return null;
        }
        String buildName = buildName(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("N:", massagedText, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("X:", massagedText, true));
        String matchSingleDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("T:", massagedText, true);
        String matchSingleDoCoMoPrefixedField2 = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("C:", massagedText, true);
        String[] matchDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("A:", massagedText, true);
        String matchSingleDoCoMoPrefixedField3 = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("B:", massagedText, true);
        String matchSingleDoCoMoPrefixedField4 = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("M:", massagedText, true);
        String matchSingleDoCoMoPrefixedField5 = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("F:", massagedText, true);
        massagedText = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("E:", massagedText, true);
        return new AddressBookParsedResult(ResultParser.maybeWrap(buildName), null, null, buildPhoneNumbers(matchSingleDoCoMoPrefixedField3, matchSingleDoCoMoPrefixedField4, matchSingleDoCoMoPrefixedField5), null, ResultParser.maybeWrap(massagedText), null, null, null, matchDoCoMoPrefixedField, null, matchSingleDoCoMoPrefixedField2, null, matchSingleDoCoMoPrefixedField, null, null);
    }
}
