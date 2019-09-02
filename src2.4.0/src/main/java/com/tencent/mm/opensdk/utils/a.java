package com.tencent.mm.opensdk.utils;

import android.os.Bundle;

public final class a {
    public static int a(Bundle bundle, String str) {
        if (bundle == null) {
            return -1;
        }
        try {
            return bundle.getInt(str, -1);
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("getIntExtra exception:");
            stringBuilder.append(e.getMessage());
            Log.e("MicroMsg.IntentUtil", stringBuilder.toString());
            return -1;
        }
    }

    public static String b(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("getStringExtra exception:");
            stringBuilder.append(e.getMessage());
            Log.e("MicroMsg.IntentUtil", stringBuilder.toString());
            return null;
        }
    }
}
