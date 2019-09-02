package com.zjwh.android_wh_physicalfitness.utils;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.math.BigDecimal;

/* compiled from: CacheFileUtils */
public class O00oOooO {
    public static final String O000000o = "zjwh";
    public static final String O00000Oo = "apks";
    private static final String O00000o0 = Environment.getExternalStorageDirectory().getPath();

    public static String O000000o() {
        File externalStorageDirectory = O00000Oo() ? Environment.getExternalStorageDirectory() : Environment.getRootDirectory();
        return (externalStorageDirectory == null || TextUtils.isEmpty(externalStorageDirectory.getPath())) ? O00000o0 : externalStorageDirectory.getPath();
    }

    public static String O000000o(double d) {
        d /= 1024.0d;
        if (d < 1.0d) {
            return "0K";
        }
        double d2 = d / 1024.0d;
        BigDecimal bigDecimal;
        StringBuilder stringBuilder;
        if (d2 < 1.0d) {
            bigDecimal = new BigDecimal(Double.toString(d));
            stringBuilder = new StringBuilder();
            stringBuilder.append(bigDecimal.setScale(2, 4).toPlainString());
            stringBuilder.append("KB");
            return stringBuilder.toString();
        }
        d = d2 / 1024.0d;
        BigDecimal bigDecimal2;
        StringBuilder stringBuilder2;
        if (d < 1.0d) {
            bigDecimal2 = new BigDecimal(Double.toString(d2));
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(bigDecimal2.setScale(2, 4).toPlainString());
            stringBuilder2.append("MB");
            return stringBuilder2.toString();
        }
        double d3 = d / 1024.0d;
        if (d3 < 1.0d) {
            bigDecimal = new BigDecimal(Double.toString(d));
            stringBuilder = new StringBuilder();
            stringBuilder.append(bigDecimal.setScale(2, 4).toPlainString());
            stringBuilder.append("GB");
            return stringBuilder.toString();
        }
        bigDecimal2 = new BigDecimal(d3);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(bigDecimal2.setScale(2, 4).toPlainString());
        stringBuilder2.append("TB");
        return stringBuilder2.toString();
    }

    public static String O000000o(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(O00000o());
        stringBuffer.append(File.separator);
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    private static boolean O000000o(File file) {
        if (file != null && file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!O000000o(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static void O00000Oo(String str) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public static boolean O00000Oo() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String O00000o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O00000o0());
        stringBuilder.append(File.separator);
        stringBuilder.append(O00000Oo);
        String stringBuilder2 = stringBuilder.toString();
        File file = new File(stringBuilder2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringBuilder2;
    }

    public static boolean O00000o(String str) {
        return new File(str).exists();
    }

    public static String O00000o0() {
        String O000000o = O000000o();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(O000000o);
        stringBuffer.append(File.separator);
        stringBuffer.append(O000000o);
        O000000o = stringBuffer.toString();
        File file = new File(O000000o);
        if (!file.exists()) {
            file.mkdirs();
        }
        return O000000o;
    }

    public static boolean O00000o0(String str) {
        return new File(O000000o(str)).exists();
    }

    public static String O00000oO() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O00000o0());
        stringBuilder.append(File.separator);
        stringBuilder.append("res");
        String stringBuilder2 = stringBuilder.toString();
        File file = new File(stringBuilder2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringBuilder2;
    }
}
