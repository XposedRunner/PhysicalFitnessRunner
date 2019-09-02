package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import defpackage.O00Oo;
import defpackage.OO00o00.O000000o;
import java.io.File;
import java.math.BigDecimal;

/* compiled from: GlideCacheUtil */
public class O000OOo0 {
    private static O000OOo0 O000000o;

    private long O000000o(File file) throws Exception {
        long j = 0;
        try {
            for (File file2 : file.listFiles()) {
                j = file2.isDirectory() ? j + O000000o(file2) : j + file2.length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return j;
    }

    public static O000OOo0 O000000o() {
        if (O000000o == null) {
            O000000o = new O000OOo0();
        }
        return O000000o;
    }

    private static String O000000o(double d) {
        d /= 1024.0d;
        if (d < 1.0d) {
            return "0.0M";
        }
        d /= 1024.0d;
        if (d < 1.0d) {
            return "0.0M";
        }
        double d2 = d / 1024.0d;
        BigDecimal bigDecimal;
        StringBuilder stringBuilder;
        if (d2 < 1.0d) {
            bigDecimal = new BigDecimal(Double.toString(d));
            stringBuilder = new StringBuilder();
            stringBuilder.append(bigDecimal.setScale(1, 4).toPlainString());
            stringBuilder.append("M");
            return stringBuilder.toString();
        }
        d = d2 / 1024.0d;
        if (d < 1.0d) {
            BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d2));
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(bigDecimal2.setScale(2, 4).toPlainString());
            stringBuilder2.append("G");
            return stringBuilder2.toString();
        }
        bigDecimal = new BigDecimal(d);
        stringBuilder = new StringBuilder();
        stringBuilder.append(bigDecimal.setScale(2, 4).toPlainString());
        stringBuilder.append("T");
        return stringBuilder.toString();
    }

    private void O000000o(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                File file = new File(str);
                if (file.isDirectory()) {
                    for (File absolutePath : file.listFiles()) {
                        O000000o(absolutePath.getAbsolutePath(), true);
                    }
                }
                if (!z) {
                    return;
                }
                if (!file.isDirectory()) {
                    file.delete();
                } else if (file.listFiles().length == 0) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void O000000o(final Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                new Thread(new Runnable() {
                    public void run() {
                        O00Oo.O00000Oo(context).O0000Ooo();
                    }
                }).start();
            } else {
                O00Oo.O00000Oo(context).O0000Ooo();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void O00000Oo(Context context) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                O00Oo.O00000Oo(context).O0000OoO();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String O00000o(Context context) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getCacheDir());
            stringBuilder.append("/");
            stringBuilder.append(O000000o.O00000o);
            return O000000o((double) O000000o(new File(stringBuilder.toString())));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void O00000o0(Context context) {
        O000000o(context);
        O00000Oo(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getExternalCacheDir());
        stringBuilder.append(O000000o.O00000o);
        O000000o(stringBuilder.toString(), true);
    }

    public long O00000oO(Context context) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getCacheDir());
            stringBuilder.append("/");
            stringBuilder.append(O000000o.O00000o);
            return O000000o(new File(stringBuilder.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
