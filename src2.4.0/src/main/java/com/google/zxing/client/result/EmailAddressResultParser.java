package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;

public final class EmailAddressResultParser extends ResultParser {
    private static final Pattern COMMA = Pattern.compile(",");

    public EmailAddressParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        EmailAddressParsedResult emailAddressParsedResult = null;
        if (!massagedText.startsWith("mailto:") && !massagedText.startsWith("MAILTO:")) {
            return !EmailDoCoMoResultParser.isBasicallyValidEmailAddress(massagedText) ? null : new EmailAddressParsedResult(massagedText);
        } else {
            String str;
            String[] strArr;
            String[] strArr2;
            String[] strArr3;
            String str2;
            String substring = massagedText.substring(7);
            int indexOf = substring.indexOf(63);
            if (indexOf >= 0) {
                substring = substring.substring(0, indexOf);
            }
            substring = ResultParser.urlDecode(substring);
            String[] split = !substring.isEmpty() ? COMMA.split(substring) : null;
            Map parseNameValuePairs = ResultParser.parseNameValuePairs(massagedText);
            if (parseNameValuePairs != null) {
                String str3;
                if (split == null) {
                    str3 = (String) parseNameValuePairs.get("to");
                    if (str3 != null) {
                        split = COMMA.split(str3);
                    }
                }
                str3 = (String) parseNameValuePairs.get("cc");
                String[] split2 = str3 != null ? COMMA.split(str3) : null;
                String str4 = (String) parseNameValuePairs.get("bcc");
                if (str4 != null) {
                    emailAddressParsedResult = COMMA.split(str4);
                }
                str = (String) parseNameValuePairs.get("body");
                strArr = split;
                strArr2 = emailAddressParsedResult;
                strArr3 = split2;
                str2 = (String) parseNameValuePairs.get("subject");
            } else {
                strArr = split;
                strArr3 = null;
                strArr2 = strArr3;
                str2 = strArr2;
                str = str2;
            }
            return new EmailAddressParsedResult(strArr, strArr3, strArr2, str2, str);
        }
    }
}
