package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class SMTPResultParser extends ResultParser {
    public EmailAddressParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        if (!massagedText.startsWith("smtp:") && !massagedText.startsWith("SMTP:")) {
            return null;
        }
        String substring;
        String str;
        massagedText = massagedText.substring(5);
        int indexOf = massagedText.indexOf(58);
        if (indexOf >= 0) {
            String substring2 = massagedText.substring(indexOf + 1);
            massagedText = massagedText.substring(0, indexOf);
            int indexOf2 = substring2.indexOf(58);
            if (indexOf2 >= 0) {
                String substring3 = substring2.substring(indexOf2 + 1);
                substring = substring2.substring(0, indexOf2);
                str = substring3;
            } else {
                str = null;
                substring = substring2;
            }
        } else {
            substring = null;
            str = substring;
        }
        return new EmailAddressParsedResult(new String[]{massagedText}, null, null, substring, str);
    }
}
