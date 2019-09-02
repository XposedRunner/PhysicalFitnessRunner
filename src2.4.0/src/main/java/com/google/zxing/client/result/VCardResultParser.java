package com.google.zxing.client.result;

import cn.jiguang.net.HttpUtils;
import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VCardResultParser extends ResultParser {
    private static final Pattern BEGIN_VCARD = Pattern.compile("BEGIN:VCARD", 2);
    private static final Pattern COMMA = Pattern.compile(",");
    private static final Pattern CR_LF_SPACE_TAB = Pattern.compile("\r\n[ \t]");
    private static final Pattern EQUALS = Pattern.compile(HttpUtils.EQUAL_SIGN);
    private static final Pattern NEWLINE_ESCAPE = Pattern.compile("\\\\[nN]");
    private static final Pattern SEMICOLON = Pattern.compile(";");
    private static final Pattern SEMICOLON_OR_COMMA = Pattern.compile("[;,]");
    private static final Pattern UNESCAPED_SEMICOLONS = Pattern.compile("(?<!\\\\);+");
    private static final Pattern VCARD_ESCAPES = Pattern.compile("\\\\([,;\\\\])");
    private static final Pattern VCARD_LIKE_DATE = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    private static String decodeQuotedPrintable(CharSequence charSequence, String str) {
        int length = charSequence.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (!(charAt == 10 || charAt == 13)) {
                if (charAt != '=') {
                    maybeAppendFragment(byteArrayOutputStream, str, stringBuilder);
                    stringBuilder.append(charAt);
                } else if (i < length - 2) {
                    charAt = charSequence.charAt(i + 1);
                    if (!(charAt == 13 || charAt == 10)) {
                        i += 2;
                        char charAt2 = charSequence.charAt(i);
                        int parseHexDigit = ResultParser.parseHexDigit(charAt);
                        int parseHexDigit2 = ResultParser.parseHexDigit(charAt2);
                        if (parseHexDigit >= 0 && parseHexDigit2 >= 0) {
                            byteArrayOutputStream.write((parseHexDigit << 4) + parseHexDigit2);
                        }
                    }
                }
            }
            i++;
        }
        maybeAppendFragment(byteArrayOutputStream, str, stringBuilder);
        return stringBuilder.toString();
    }

    private static void formatNames(Iterable<List<String>> iterable) {
        if (iterable != null) {
            for (List list : iterable) {
                String str = (String) list.get(0);
                String[] strArr = new String[5];
                int i = 0;
                int i2 = i;
                while (i < strArr.length - 1) {
                    int indexOf = str.indexOf(59, i2);
                    if (indexOf < 0) {
                        break;
                    }
                    strArr[i] = str.substring(i2, indexOf);
                    i++;
                    i2 = indexOf + 1;
                }
                strArr[i] = str.substring(i2);
                StringBuilder stringBuilder = new StringBuilder(100);
                maybeAppendComponent(strArr, 3, stringBuilder);
                maybeAppendComponent(strArr, 1, stringBuilder);
                maybeAppendComponent(strArr, 2, stringBuilder);
                maybeAppendComponent(strArr, 0, stringBuilder);
                maybeAppendComponent(strArr, 4, stringBuilder);
                list.set(0, stringBuilder.toString().trim());
            }
        }
    }

    private static boolean isLikeVCardDate(CharSequence charSequence) {
        return charSequence == null || VCARD_LIKE_DATE.matcher(charSequence).matches();
    }

    static List<String> matchSingleVCardPrefixedField(CharSequence charSequence, String str, boolean z, boolean z2) {
        List matchVCardPrefixedField = matchVCardPrefixedField(charSequence, str, z, z2);
        return (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) ? null : (List) matchVCardPrefixedField.get(0);
    }

    static List<List<String>> matchVCardPrefixedField(CharSequence charSequence, String str, boolean z, boolean z2) {
        String str2 = str;
        int length = str.length();
        int i = 0;
        int i2 = 0;
        List<List<String>> list = null;
        while (i2 < length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(?:^|\n)");
            stringBuilder.append(charSequence);
            stringBuilder.append("(?:;([^:]*))?:");
            int i3 = 2;
            Matcher matcher = Pattern.compile(stringBuilder.toString(), 2).matcher(str2);
            if (i2 > 0) {
                i2--;
            }
            if (!matcher.find(i2)) {
                break;
            }
            int i4;
            List list2;
            String str3;
            int i5;
            i2 = matcher.end(i);
            String group = matcher.group(1);
            if (group != null) {
                String[] split = SEMICOLON.split(group);
                int length2 = split.length;
                int i6 = i;
                i4 = i6;
                list2 = null;
                str3 = null;
                while (i6 < length2) {
                    Object obj = split[i6];
                    if (list2 == null) {
                        list2 = new ArrayList(1);
                    }
                    list2.add(obj);
                    String[] split2 = EQUALS.split(obj, i3);
                    if (split2.length > 1) {
                        String str4 = split2[0];
                        String str5 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str4) && "QUOTED-PRINTABLE".equalsIgnoreCase(str5)) {
                            i4 = 1;
                        } else if ("CHARSET".equalsIgnoreCase(str4)) {
                            str3 = str5;
                        }
                    }
                    i6++;
                    i3 = 2;
                }
            } else {
                list2 = null;
                i4 = 0;
                str3 = null;
            }
            int i7 = i2;
            while (true) {
                i7 = str2.indexOf(10, i7);
                if (i7 < 0) {
                    break;
                }
                if (i7 < str.length() - 1) {
                    i = i7 + 1;
                    if (str2.charAt(i) == ' ' || str2.charAt(i) == 9) {
                        i7 += 2;
                    }
                }
                if (i4 == 0) {
                    break;
                }
                if (i7 < 1 || str2.charAt(i7 - 1) != '=') {
                    if (i7 >= 2) {
                        if (str2.charAt(i7 - 2) != '=') {
                            break;
                        }
                    }
                    break;
                }
                i7++;
            }
            if (i7 < 0) {
                i7 = length;
                i5 = 0;
            } else if (i7 > i2) {
                Object decodeQuotedPrintable;
                if (list == null) {
                    list = new ArrayList(1);
                }
                if (i7 >= 1 && str2.charAt(i7 - 1) == 13) {
                    i7--;
                }
                CharSequence substring = str2.substring(i2, i7);
                if (z) {
                    substring = substring.trim();
                }
                if (i4 != 0) {
                    decodeQuotedPrintable = decodeQuotedPrintable(substring, str3);
                    if (z2) {
                        decodeQuotedPrintable = UNESCAPED_SEMICOLONS.matcher(decodeQuotedPrintable).replaceAll("\n").trim();
                    }
                } else {
                    if (z2) {
                        substring = UNESCAPED_SEMICOLONS.matcher(substring).replaceAll("\n").trim();
                    }
                    decodeQuotedPrintable = VCARD_ESCAPES.matcher(NEWLINE_ESCAPE.matcher(CR_LF_SPACE_TAB.matcher(substring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                }
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(decodeQuotedPrintable);
                    list.add(arrayList);
                    i5 = 0;
                } else {
                    i5 = 0;
                    list2.add(0, decodeQuotedPrintable);
                    list.add(list2);
                }
                i7++;
            } else {
                i5 = 0;
                i7++;
            }
            i2 = i7;
            i = i5;
        }
        return list;
    }

    private static void maybeAppendComponent(String[] strArr, int i, StringBuilder stringBuilder) {
        if (strArr[i] != null && !strArr[i].isEmpty()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(strArr[i]);
        }
    }

    private static void maybeAppendFragment(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder stringBuilder) {
        if (byteArrayOutputStream.size() > 0) {
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str = new String(toByteArray, Charset.forName(HttpUtils.ENCODING_UTF_8));
            } else {
                try {
                    str = new String(toByteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str = new String(toByteArray, Charset.forName(HttpUtils.ENCODING_UTF_8));
                }
            }
            byteArrayOutputStream.reset();
            stringBuilder.append(str);
        }
    }

    private static String toPrimaryValue(List<String> list) {
        return (list == null || list.isEmpty()) ? null : (String) list.get(0);
    }

    private static String[] toPrimaryValues(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List list : collection) {
            String str = (String) list.get(0);
            if (!(str == null || str.isEmpty())) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    private static String[] toTypes(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List list : collection) {
            Object obj;
            int i = 1;
            while (i < list.size()) {
                String str = (String) list.get(i);
                int indexOf = str.indexOf(61);
                if (indexOf < 0) {
                    obj = str;
                    break;
                } else if ("TYPE".equalsIgnoreCase(str.substring(0, indexOf))) {
                    obj = str.substring(indexOf + 1);
                    break;
                } else {
                    i++;
                }
            }
            obj = null;
            arrayList.add(obj);
        }
        return (String[]) arrayList.toArray(new String[collection.size()]);
    }

    public AddressBookParsedResult parse(Result result) {
        String massagedText = ResultParser.getMassagedText(result);
        Matcher matcher = BEGIN_VCARD.matcher(massagedText);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        Collection matchVCardPrefixedField = matchVCardPrefixedField("FN", massagedText, true, false);
        if (matchVCardPrefixedField == null) {
            matchVCardPrefixedField = matchVCardPrefixedField("N", massagedText, true, false);
            formatNames(matchVCardPrefixedField);
        }
        List matchSingleVCardPrefixedField = matchSingleVCardPrefixedField("NICKNAME", massagedText, true, false);
        String[] split = matchSingleVCardPrefixedField == null ? null : COMMA.split((CharSequence) matchSingleVCardPrefixedField.get(0));
        matchSingleVCardPrefixedField = matchVCardPrefixedField("TEL", massagedText, true, false);
        List matchVCardPrefixedField2 = matchVCardPrefixedField("EMAIL", massagedText, true, false);
        List matchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("NOTE", massagedText, false, false);
        List matchVCardPrefixedField3 = matchVCardPrefixedField("ADR", massagedText, true, true);
        List matchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("ORG", massagedText, true, true);
        List matchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("BDAY", massagedText, true, false);
        if (!(matchSingleVCardPrefixedField4 == null || isLikeVCardDate((CharSequence) matchSingleVCardPrefixedField4.get(0)))) {
            matchSingleVCardPrefixedField4 = null;
        }
        List matchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("TITLE", massagedText, true, false);
        List matchVCardPrefixedField4 = matchVCardPrefixedField("URL", massagedText, true, false);
        List matchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("IMPP", massagedText, true, false);
        List matchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField("GEO", massagedText, true, false);
        String[] split2 = matchSingleVCardPrefixedField7 == null ? null : SEMICOLON_OR_COMMA.split((CharSequence) matchSingleVCardPrefixedField7.get(0));
        String[] strArr = (split2 == null || split2.length == 2) ? split2 : null;
        return new AddressBookParsedResult(toPrimaryValues(matchVCardPrefixedField), split, null, toPrimaryValues(matchSingleVCardPrefixedField), toTypes(matchSingleVCardPrefixedField), toPrimaryValues(matchVCardPrefixedField2), toTypes(matchVCardPrefixedField2), toPrimaryValue(matchSingleVCardPrefixedField6), toPrimaryValue(matchSingleVCardPrefixedField2), toPrimaryValues(matchVCardPrefixedField3), toTypes(matchVCardPrefixedField3), toPrimaryValue(matchSingleVCardPrefixedField3), toPrimaryValue(matchSingleVCardPrefixedField4), toPrimaryValue(matchSingleVCardPrefixedField5), toPrimaryValues(matchVCardPrefixedField4), strArr);
    }
}
