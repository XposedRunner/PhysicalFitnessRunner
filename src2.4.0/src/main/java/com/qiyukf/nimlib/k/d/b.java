package com.qiyukf.nimlib.k.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.qiyukf.basesdk.c.d.c;
import java.util.UUID;

public final class b {
    public static String a() {
        try {
            return System.getString(com.qiyukf.nimlib.b.a().getContentResolver(), "android_id");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b() {
        try {
            return ((TelephonyManager) com.qiyukf.nimlib.b.a().getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c() {
        String b = b();
        if (b != null && !b.equals("")) {
            return b;
        }
        b = a();
        if (b != null && !b.toLowerCase().equals("9774d56d682e549c") && !b.equals("")) {
            return b;
        }
        b = Build.SERIAL;
        if (b != null) {
            return b;
        }
        b = c.g(com.qiyukf.nimlib.b.a());
        return (b == null || b.equals("")) ? d() : b;
    }

    private static String d() {
        String string;
        try {
            SharedPreferences sharedPreferences = com.qiyukf.nimlib.b.a().getSharedPreferences("OpenUdid", 0);
            string = sharedPreferences.getString("OpenUdid", "");
            try {
                if (string.equals("")) {
                    String uuid = UUID.randomUUID().toString();
                    Editor edit = sharedPreferences.edit();
                    edit.putString("OpenUdid", uuid);
                    edit.commit();
                    return uuid;
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            string = null;
        }
        return string;
    }
}
