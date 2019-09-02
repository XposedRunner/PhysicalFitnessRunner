package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class SMSMMSResultParser extends ResultParser {
    private static void addNumberVia(Collection<String> collection, Collection<String> collection2, String str) {
        int indexOf = str.indexOf(59);
        Object obj = null;
        if (indexOf < 0) {
            collection.add(str);
            collection2.add(null);
            return;
        }
        collection.add(str.substring(0, indexOf));
        String substring = str.substring(indexOf + 1);
        if (substring.startsWith("via=")) {
            obj = substring.substring(4);
        }
        collection2.add(obj);
    }

    public SMSParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        String str = null;
        if (!massagedText.startsWith("sms:") && !massagedText.startsWith("SMS:") && !massagedText.startsWith("mms:") && !massagedText.startsWith("MMS:")) {
            return null;
        }
        String str2;
        Map parseNameValuePairs = ResultParser.parseNameValuePairs(massagedText);
        int i = 0;
        if (parseNameValuePairs == null || parseNameValuePairs.isEmpty()) {
            str2 = null;
        } else {
            str = (String) parseNameValuePairs.get("subject");
            str2 = (String) parseNameValuePairs.get("body");
            i = 1;
        }
        int indexOf = massagedText.indexOf(63, 4);
        massagedText = (indexOf < 0 || i == 0) ? massagedText.substring(4) : massagedText.substring(4, indexOf);
        i = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i2 = i + 1;
            int indexOf2 = massagedText.indexOf(44, i2);
            if (indexOf2 > i) {
                addNumberVia(arrayList, arrayList2, massagedText.substring(i2, indexOf2));
                i = indexOf2;
            } else {
                addNumberVia(arrayList, arrayList2, massagedText.substring(i2));
                return new SMSParsedResult((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str, str2);
            }
        }
    }
}
