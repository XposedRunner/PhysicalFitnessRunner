package com.qiyukf.nim.uikit.common.media.picker.b;

import android.text.TextUtils;
import android.util.SparseArray;
import java.io.File;

public final class c {
    private static SparseArray<String> a = new SparseArray();

    public static String a(int i, String str) {
        if (a == null || a.indexOfKey(i) < 0) {
            return str;
        }
        try {
            String str2 = (String) a.get(i);
            return (!TextUtils.isEmpty(str2) && new File(str2.substring(7)).exists()) ? str2 : str;
        } catch (Exception unused) {
        }
    }

    public static void a() {
        a.clear();
    }

    public static void a(Integer num, String str) {
        a.put(num.intValue(), str);
    }
}
