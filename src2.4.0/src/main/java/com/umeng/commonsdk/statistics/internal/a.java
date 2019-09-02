package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: HeaderHelper */
public class a {
    private static Context a;
    private String b;
    private String c;

    /* compiled from: HeaderHelper */
    private static class a {
        private static final a a = new a();

        private a() {
        }
    }

    private a() {
        this.b = null;
        this.c = null;
    }

    public static a a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return a.a;
    }

    private void d(String str) {
        try {
            str = str.replaceAll("&=", " ").replaceAll("&&", " ").replaceAll("==", "/");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("/");
            stringBuilder.append("Android");
            stringBuilder.append("/");
            stringBuilder.append(Build.DISPLAY);
            stringBuilder.append("/");
            stringBuilder.append(Build.MODEL);
            stringBuilder.append("/");
            stringBuilder.append(VERSION.RELEASE);
            stringBuilder.append(" ");
            stringBuilder.append(HelperUtils.getUmengMD5(UMUtils.getAppkey(a)));
            this.b = stringBuilder.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    private void e(String str) {
        try {
            CharSequence charSequence = str.split("&&")[0];
            if (!TextUtils.isEmpty(charSequence)) {
                String[] split = charSequence.split("&=");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(e.ax);
                for (CharSequence charSequence2 : split) {
                    if (!TextUtils.isEmpty(charSequence2)) {
                        String substring = charSequence2.substring(0, 2);
                        if (substring.endsWith("=")) {
                            substring = substring.replace("=", "");
                        }
                        stringBuilder.append(substring);
                    }
                }
                this.c = stringBuilder.toString();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    public String a() {
        return this.c;
    }

    public boolean a(String str) {
        return !TextUtils.isEmpty(str) ? str.startsWith(e.al) : false;
    }

    public String b() {
        return this.b;
    }

    public boolean b(String str) {
        return !TextUtils.isEmpty(str) ? str.startsWith(e.ar) : false;
    }

    public void c(String str) {
        str = str.substring(0, str.indexOf(95));
        e(str);
        d(str);
    }
}
