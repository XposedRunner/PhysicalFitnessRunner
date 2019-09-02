package com.tencent.stat.common;

import java.io.File;

class o {
    private static int a = -1;

    public static boolean a() {
        if (a == 1) {
            return true;
        }
        if (a == 0) {
            return false;
        }
        String[] strArr = new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        int i = 0;
        while (i < strArr.length) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(strArr[i]);
                stringBuilder.append("su");
                File file = new File(stringBuilder.toString());
                if (file == null || !file.exists()) {
                    i++;
                } else {
                    a = 1;
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        a = 0;
        return false;
    }
}
