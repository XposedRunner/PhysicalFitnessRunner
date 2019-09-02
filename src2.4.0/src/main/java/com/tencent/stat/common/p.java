package com.tencent.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class p {
    private static SharedPreferences a;

    public static int a(Context context, String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(str);
        return a(context).getInt(k.b(context, stringBuilder.toString()), i);
    }

    public static long a(Context context, String str, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(str);
        return a(context).getLong(k.b(context, stringBuilder.toString()), j);
    }

    static synchronized SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (p.class) {
            if (a == null) {
                a = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = a;
        }
        return sharedPreferences;
    }

    public static String a(Context context, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(str);
        return a(context).getString(k.b(context, stringBuilder.toString()), str2);
    }

    public static void b(Context context, String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(str);
        str = k.b(context, stringBuilder.toString());
        Editor edit = a(context).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public static void b(Context context, String str, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(str);
        str = k.b(context, stringBuilder.toString());
        Editor edit = a(context).edit();
        edit.putLong(str, j);
        edit.commit();
    }

    public static void b(Context context, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(str);
        str = k.b(context, stringBuilder.toString());
        Editor edit = a(context).edit();
        edit.putString(str, str2);
        edit.commit();
    }
}
