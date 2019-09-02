package org.jsoup.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class StringUtil {
    private static final String[] O000000o = new String[]{"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          "};

    public static String O000000o(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("width must be > 0");
        } else if (i < O000000o.length) {
            return O000000o[i];
        } else {
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = ' ';
            }
            return String.valueOf(cArr);
        }
    }

    public static String O000000o(String str, String str2) {
        try {
            try {
                return O000000o(new URL(str), str2).toExternalForm();
            } catch (MalformedURLException unused) {
                return "";
            }
        } catch (MalformedURLException unused2) {
            return new URL(str2).toExternalForm();
        }
    }

    public static String O000000o(Collection collection, String str) {
        return O000000o(collection.iterator(), str);
    }

    public static String O000000o(Iterator it, String str) {
        if (!it.hasNext()) {
            return "";
        }
        String obj = it.next().toString();
        if (!it.hasNext()) {
            return obj;
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(obj);
        while (it.hasNext()) {
            stringBuilder.append(str);
            stringBuilder.append(it.next());
        }
        return stringBuilder.toString();
    }

    public static URL O000000o(URL url, String str) throws MalformedURLException {
        if (str.startsWith("?")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(url.getPath());
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        if (str.indexOf(46) == 0 && url.getFile().indexOf(47) != 0) {
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("/");
            stringBuilder2.append(url.getFile());
            url = new URL(protocol, host, port, stringBuilder2.toString());
        }
        return new URL(url, str);
    }

    public static void O000000o(StringBuilder stringBuilder, String str, boolean z) {
        int length = str.length();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (!O00000Oo(codePointAt)) {
                stringBuilder.appendCodePoint(codePointAt);
                i3 = 0;
                i2 = 1;
            } else if (!(z && i2 == 0) && i3 == 0) {
                stringBuilder.append(' ');
                i3 = 1;
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static boolean O000000o(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!O00000Oo(str.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean O000000o(String str, String... strArr) {
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean O00000Oo(int i) {
        return i == 32 || i == 9 || i == 10 || i == 12 || i == 13;
    }

    public static boolean O00000Oo(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isDigit(str.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean O00000Oo(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static String O00000o0(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.length());
        O000000o(stringBuilder, str, false);
        return stringBuilder.toString();
    }
}
