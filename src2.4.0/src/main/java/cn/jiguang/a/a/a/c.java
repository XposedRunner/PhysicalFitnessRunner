package cn.jiguang.a.a.a;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import cn.jiguang.d.a.d;
import cn.jiguang.g.a;
import cn.jiguang.g.i;
import com.alibaba.wireless.security.SecExceptionCode;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public final class c {
    private static AtomicInteger a = new AtomicInteger(2);

    public static void a(Context context) {
        if (a.get() == 2) {
            c(1);
            if (context == null) {
                c(2);
            } else if (!a.e(context).toUpperCase().startsWith("WIFI")) {
                c(2);
            } else if (!((Boolean) d.b(context, "arpinfo_report_enable", Boolean.valueOf(false))).booleanValue()) {
                c(2);
            } else if (d.d(context)) {
                WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                if (wifiManager == null) {
                    c(2);
                } else if (a.a(context, "android.permission.ACCESS_WIFI_STATE")) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    CharSequence charSequence = "";
                    CharSequence charSequence2 = "";
                    if (connectionInfo != null) {
                        charSequence2 = i.c(connectionInfo.getSSID());
                        charSequence = connectionInfo.getBSSID();
                    }
                    CharSequence charSequence3 = TextUtils.isEmpty(charSequence) ? "" : charSequence;
                    String str = TextUtils.isEmpty(charSequence2) ? "" : charSequence2;
                    String str2 = TextUtils.isEmpty(charSequence3) ? str : charSequence3;
                    boolean b = a.a().b(context, str2);
                    a.a();
                    a.a(context);
                    if (b) {
                        new h(wifiManager, str2, charSequence3, str, context, SecExceptionCode.SEC_ERROR_STA_ENC, 2, (byte) 0).start();
                    } else {
                        c(2);
                    }
                } else {
                    c(2);
                }
            } else {
                c(2);
            }
        }
    }

    private static Process b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Process exec;
        try {
            exec = Runtime.getRuntime().exec(str);
            try {
                exec.waitFor();
                return exec;
            } catch (IOException | InterruptedException unused) {
                return exec;
            }
        } catch (IOException unused2) {
            exec = null;
            return exec;
        }
    }

    private static void c(int i) {
        a.getAndSet(i);
    }
}
