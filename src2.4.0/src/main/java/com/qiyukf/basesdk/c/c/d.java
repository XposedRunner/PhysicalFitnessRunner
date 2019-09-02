package com.qiyukf.basesdk.c.c;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d {
    private static Map<String, Character> a;
    private static Pattern b;

    public static String a() {
        return UUID.randomUUID().toString();
    }

    public static String a(float f) {
        return String.format(Locale.US, "%d%%", new Object[]{Integer.valueOf((int) (f * 100.0f))});
    }

    public static String a(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "";
        }
        lastIndexOf++;
        for (int i = lastIndexOf; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < 'a' || charAt > 'z') && ((charAt < 'A' || charAt > 'Z') && (charAt < '0' || charAt > '9'))) {
                return "";
            }
        }
        return str.substring(lastIndexOf, str.length());
    }

    public static boolean a(CharSequence charSequence) {
        if (charSequence == null) {
            return true;
        }
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt != ' ' && charAt != 10 && charAt != 9 && charAt != 13) {
                return false;
            }
        }
        return true;
    }

    public static String b() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String b(String str) {
        int lastIndexOf = str.lastIndexOf(47);
        return lastIndexOf != -1 ? str.substring(lastIndexOf + 1, str.length()) : str;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "";
        str = a(str.toLowerCase());
        if (!TextUtils.isEmpty(str)) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        return str2;
    }

    public static String d(String str) {
        if (a == null || b == null) {
            synchronized (d.class) {
                if (a == null || b == null) {
                    HashMap hashMap = new HashMap(8);
                    a = hashMap;
                    hashMap.put("&quot;", Character.valueOf('\"'));
                    a.put("&amp;", Character.valueOf('&'));
                    a.put("&lt;", Character.valueOf('<'));
                    a.put("&gt;", Character.valueOf('>'));
                    a.put("&#39;", Character.valueOf('\''));
                    a.put("&nbsp;", Character.valueOf(' '));
                    b = Pattern.compile("&quot;|&amp;|&lt;|&gt;|&#39;|&nbsp;");
                }
            }
        }
        Matcher matcher = b.matcher(str);
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            stringBuilder.append(str, i, start);
            Character ch = (Character) a.get(str.substring(start, end));
            if (ch != null) {
                stringBuilder.append(ch);
            } else {
                stringBuilder.append(str, start, end);
            }
            i = end;
        }
        if (i == 0) {
            return str;
        }
        if (i < str.length()) {
            stringBuilder.append(str, i, str.length());
        }
        return stringBuilder.toString();
    }
}
