package com.google.zxing.client.result;

import cn.jiguang.net.HttpUtils;
import com.google.zxing.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class ResultParser {
    private static final Pattern AMPERSAND = Pattern.compile(HttpUtils.PARAMETERS_SEPARATOR);
    private static final String BYTE_ORDER_MARK = "﻿";
    private static final Pattern DIGITS = Pattern.compile("\\d+");
    private static final Pattern EQUALS = Pattern.compile(HttpUtils.EQUAL_SIGN);
    private static final ResultParser[] PARSERS = new ResultParser[]{new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser(), new VINResultParser()};

    private static void appendKeyValue(CharSequence charSequence, Map<String, String> map) {
        String[] split = EQUALS.split(charSequence, 2);
        if (split.length == 2) {
            try {
                map.put(split[0], urlDecode(split[1]));
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    private static int countPrecedingBackslashes(CharSequence charSequence, int i) {
        i--;
        int i2 = 0;
        while (i >= 0 && charSequence.charAt(i) == '\\') {
            i2++;
            i--;
        }
        return i2;
    }

    protected static String getMassagedText(Result result) {
        String text = result.getText();
        return text.startsWith(BYTE_ORDER_MARK) ? text.substring(1) : text;
    }

    protected static boolean isStringOfDigits(CharSequence charSequence, int i) {
        return charSequence != null && i > 0 && i == charSequence.length() && DIGITS.matcher(charSequence).matches();
    }

    protected static boolean isSubstringOfDigits(CharSequence charSequence, int i, int i2) {
        boolean z = false;
        if (charSequence == null || i2 <= 0) {
            return false;
        }
        i2 += i;
        if (charSequence.length() >= i2 && DIGITS.matcher(charSequence.subSequence(i, i2)).matches()) {
            z = true;
        }
        return z;
    }

    static String[] matchPrefixedField(String str, String str2, char c, boolean z) {
        int length = str2.length();
        List list = null;
        int i = 0;
        while (i < length) {
            i = str2.indexOf(str, i);
            if (i < 0) {
                break;
            }
            i += str.length();
            Object obj = 1;
            List list2 = list;
            int i2 = i;
            while (obj != null) {
                i2 = str2.indexOf(c, i2);
                if (i2 < 0) {
                    i2 = str2.length();
                } else if (countPrecedingBackslashes(str2, i2) % 2 != 0) {
                    i2++;
                } else {
                    if (list2 == null) {
                        list2 = new ArrayList(3);
                    }
                    String unescapeBackslash = unescapeBackslash(str2.substring(i, i2));
                    if (z) {
                        unescapeBackslash = unescapeBackslash.trim();
                    }
                    if (!unescapeBackslash.isEmpty()) {
                        list2.add(unescapeBackslash);
                    }
                    i2++;
                }
                obj = null;
            }
            i = i2;
            list = list2;
        }
        return (list == null || list.isEmpty()) ? null : (String[]) list.toArray(new String[list.size()]);
    }

    static String matchSinglePrefixedField(String str, String str2, char c, boolean z) {
        String[] matchPrefixedField = matchPrefixedField(str, str2, c, z);
        return matchPrefixedField == null ? null : matchPrefixedField[0];
    }

    protected static void maybeAppend(String str, StringBuilder stringBuilder) {
        if (str != null) {
            stringBuilder.append(10);
            stringBuilder.append(str);
        }
    }

    protected static void maybeAppend(String[] strArr, StringBuilder stringBuilder) {
        if (strArr != null) {
            for (String str : strArr) {
                stringBuilder.append(10);
                stringBuilder.append(str);
            }
        }
    }

    protected static String[] maybeWrap(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    protected static int parseHexDigit(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c < 'A' || c > 'F') ? -1 : 10 + (c - 65) : 10 + (c - 97) : c - 48;
    }

    static Map<String, String> parseNameValuePairs(String str) {
        int indexOf = str.indexOf(63);
        if (indexOf < 0) {
            return null;
        }
        HashMap hashMap = new HashMap(3);
        for (CharSequence appendKeyValue : AMPERSAND.split(str.substring(indexOf + 1))) {
            appendKeyValue(appendKeyValue, hashMap);
        }
        return hashMap;
    }

    public static ParsedResult parseResult(Result result) {
        for (ResultParser parse : PARSERS) {
            ParsedResult parse2 = parse.parse(result);
            if (parse2 != null) {
                return parse2;
            }
        }
        return new TextParsedResult(result.getText(), null);
    }

    protected static String unescapeBackslash(String str) {
        int indexOf = str.indexOf(92);
        if (indexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length - 1);
        stringBuilder.append(str.toCharArray(), 0, indexOf);
        int i = 0;
        while (indexOf < length) {
            char charAt = str.charAt(indexOf);
            if (i == 0 && charAt == '\\') {
                i = 1;
            } else {
                stringBuilder.append(charAt);
                i = 0;
            }
            indexOf++;
        }
        return stringBuilder.toString();
    }

    static String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, HttpUtils.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public abstract ParsedResult parse(Result result);
}
