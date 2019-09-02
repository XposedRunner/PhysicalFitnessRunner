package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceWrapper {
    private static final String DEFAULT_PREFERENCE = "umeng_general_config";

    private PreferenceWrapper() {
    }

    public static SharedPreferences getDefault(Context context) {
        return context != null ? context.getSharedPreferences(DEFAULT_PREFERENCE, 0) : null;
    }

    public static SharedPreferences getInstance(Context context, String str) {
        return context != null ? context.getSharedPreferences(str, 0) : null;
    }
}
