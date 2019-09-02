package com.qiyukf.basesdk.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public final class d {
    public static void a(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public static void a(SharedPreferences sharedPreferences, String str, int i) {
        a(sharedPreferences.edit().putInt(str, i));
    }

    public static void a(SharedPreferences sharedPreferences, String str, long j) {
        a(sharedPreferences.edit().putLong(str, j));
    }

    public static void a(SharedPreferences sharedPreferences, String str, String str2) {
        a(sharedPreferences.edit().putString(str, str2));
    }

    public static void a(SharedPreferences sharedPreferences, String str, boolean z) {
        a(sharedPreferences.edit().putBoolean(str, z));
    }
}
