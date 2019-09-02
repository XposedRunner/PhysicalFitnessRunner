package com.ximalaya.ting.android.opensdk.auth.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Pattern;

/* compiled from: StringUtil */
public final class f {
    @SuppressLint({"SimpleDateFormat"})
    private static long a(String str, String str2) {
        try {
            return new SimpleDateFormat(str).parse(str2).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    private static String a() {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            stringBuffer.append(str.charAt(random.nextInt(str.length())));
        }
        return stringBuffer.toString();
    }

    private static String a(int i) {
        StringBuilder stringBuilder;
        StringBuffer stringBuffer = new StringBuffer("");
        int i2 = i / 3600;
        i %= 3600;
        if (i2 > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(i2);
            stringBuilder.append(":");
            stringBuffer.append(stringBuilder.toString());
        }
        i2 = i / 60;
        i %= 60;
        if (i2 / 10 > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(i2);
            stringBuilder.append(":");
            stringBuffer.append(stringBuilder.toString());
        } else {
            stringBuffer.append("0");
            stringBuffer.append(i2);
            stringBuffer.append(":");
        }
        i %= 60;
        if (i / 10 > 0) {
            stringBuffer.append(i);
        } else {
            stringBuffer.append("0");
            stringBuffer.append(i);
        }
        return stringBuffer.toString();
    }

    private static String a(long j) {
        return new SimpleDateFormat(O000O0o0.O0000o0).format(new Date(j * 1000));
    }

    private static boolean a(String str) {
        return (str == null || str.trim().equals("") || str.equals("\\s")) ? false : true;
    }

    private static double b(int i) {
        return new BigDecimal(((double) (i / XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE)) / 1024.0d).setScale(1, 4).doubleValue();
    }

    private static long b(String str) {
        return a(O000O0o0.O0000o0, str);
    }

    private static String b() {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            stringBuffer.append(str.charAt(random.nextInt(str.length())));
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String b(long j) {
        return new SimpleDateFormat(O000O0o0.O0000o0).format(new Date(j));
    }

    private static boolean b(String str, String str2) {
        return Pattern.compile(str).matcher(str2).matches();
    }

    private static String c(int i) {
        int i2 = i % 100;
        i /= 100;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(".");
        StringBuffer stringBuffer = new StringBuffer(stringBuilder.toString());
        if (i2 >= 10 || i2 < 0) {
            stringBuffer.append(i2);
        } else {
            stringBuffer.append("0");
            stringBuffer.append(i2);
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String c(long j) {
        return new SimpleDateFormat(O000O0o0.O0000Ooo).format(Long.valueOf(j));
    }

    private static String c(String str) {
        try {
            String path = new URI(str).getPath();
            String[] split = path.split("/");
            Pattern compile = Pattern.compile("([一-龥]+)");
            StringBuffer stringBuffer = new StringBuffer(47);
            for (String str2 : split) {
                String str22;
                if (compile.matcher(str22).find()) {
                    str22 = URLEncoder.encode(str22, "UTF-8");
                }
                stringBuffer.append(str22);
                stringBuffer.append('/');
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            return str.replace(path, stringBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static String d(int i) {
        if (i < 10000) {
            return String.valueOf(i);
        }
        if (i < 100000000) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(i / 10000));
            stringBuilder.append("万");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.valueOf(i / 100000000));
        stringBuilder2.append("亿");
        return stringBuilder2.toString();
    }

    private static String d(long j) {
        j >>= 10;
        if (j < 1024) {
            return String.format("%d Kb", new Object[]{Long.valueOf(j)});
        } else if ((j >> 10) < 1024) {
            return String.format("%.2f M", new Object[]{Double.valueOf(((double) j) / 1024.0d)});
        } else {
            return String.format("%.2f GB", new Object[]{Double.valueOf(((double) j) / 2048.0d)});
        }
    }

    private static boolean d(String str) {
        return !TextUtils.isEmpty(str) ? str.matches("^1[3|4|5|7|8][0-9]\\d{8}$") : false;
    }

    private static boolean e(String str) {
        return b("133|153|180|181|189", str.substring(0, 3));
    }

    private static boolean f(String str) {
        return b("135|136|137|138|139|147|150|151|152|157|158|159|178|182|183|184|187|188", str.substring(0, 3)) || b("134[0-8]", str.substring(0, 4));
    }

    private static boolean g(String str) {
        return b("130|131|132|145|155|156|176|185|186|189", str.substring(0, 3));
    }

    private static boolean h(String str) {
        return b("170[0|5|9]", str.substring(0, 4));
    }

    private static boolean i(String str) {
        return !TextUtils.isEmpty(str) ? str.matches("^(?=\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$).{6,30}$") : false;
    }

    private static boolean j(String str) {
        return !TextUtils.isEmpty(str) ? str.matches("^(?=\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$).{6,64}$") : false;
    }

    private static String k(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt == '\"') {
                    stringBuilder.append("&quot;");
                } else if (charAt == '<') {
                    stringBuilder.append("&lt;");
                } else if (charAt != '>') {
                    switch (charAt) {
                        case '&':
                            stringBuilder.append("&amp;");
                            break;
                        case '\'':
                            stringBuilder.append("&#39;");
                            break;
                        default:
                            stringBuilder.append(charAt);
                            break;
                    }
                } else {
                    stringBuilder.append("&gt;");
                }
            }
        }
        return stringBuilder.toString();
    }

    private static String l(String str) {
        try {
            return str.replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&").replace("&#39;", "'").replace("&quot;", "\"");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static int[] m(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\.");
        int length = split.length;
        if (length != 4) {
            return null;
        }
        int[] iArr = new int[4];
        int i = 0;
        while (i < length) {
            try {
                iArr[i] = Integer.parseInt(split[i]);
                if (iArr[i] < 0 || iArr[i] > 255) {
                    return null;
                }
                i++;
            } catch (Exception unused) {
                return null;
            }
        }
        return iArr;
    }

    private static boolean n(String str) {
        if (str == null || str.startsWith(".") || str.endsWith(".")) {
            return false;
        }
        if (r1 != 4) {
            return false;
        }
        String str2 = "\\d|[1-9][0-9]|1[0-9][0-9]|2(([0-4][0-9])|(5[0-5]))";
        for (String b : str.split("\\.")) {
            if (!b(str2, b)) {
                return false;
            }
        }
        return true;
    }

    private static boolean o(String str) {
        int[] m = m(str);
        return (m != null && m[0] == 255) ? m[1] != 255 ? m[2] == 0 && m[3] == 0 && (m[1] == 128 || m[1] == 0 || m[1] == 192 || m[1] == 224 || m[1] == 240 || m[1] == 248 || m[1] == 252 || m[1] == 254) : m[2] != 255 ? m[3] == 0 && (m[2] == 128 || m[2] == 0 || m[2] == 192 || m[2] == 224 || m[2] == 240 || m[2] == 248 || m[2] == 252 || m[2] == 254) : m[3] == 128 || m[3] == 0 || m[3] == 192 || m[3] == 224 || m[3] == 240 || m[3] == 248 || m[3] == 252 || m[3] == 254 : false;
    }

    private static boolean p(String str) {
        return Pattern.compile("[\\x41-\\x5a]").matcher(str).find();
    }

    private static boolean q(String str) {
        return Pattern.compile("[\\x61-\\x7a]").matcher(str).find();
    }

    private static boolean r(String str) {
        return Pattern.compile("[\\x30-\\x39]").matcher(str).find();
    }

    private static boolean s(String str) {
        return Pattern.compile("[\\x11-\\x2f]|[\\x3b-\\x40]|[\\x5b-\\x60]|[\\x7a-\\x7e]").matcher(str).find();
    }

    private static boolean t(String str) {
        return Pattern.compile("[^\\x11-\\x7e]|[\\s]").matcher(str).find();
    }

    private static boolean u(String str) {
        return Pattern.compile("[\\s]").matcher(str).find();
    }

    private static String v(String str) {
        StringBuffer stringBuffer = new StringBuffer("");
        String str2 = "[一-龥]";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            String valueOf = String.valueOf(str.charAt(i));
            if (!valueOf.matches(str2)) {
                stringBuffer.append(valueOf);
            }
        }
        return stringBuffer.toString();
    }

    private static int w(String str) {
        String str2 = "[一-龥]";
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            if (String.valueOf(str.charAt(i)).matches(str2)) {
                i2++;
            }
            i++;
        }
        return i2;
    }

    private static boolean x(String str) {
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    private static boolean y(String str) {
        return Pattern.compile("[\\\\\"'_~&<()>%{}]").matcher(str).find();
    }
}
