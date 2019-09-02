package com.geetest.deepknow.utils;

import android.os.Environment;
import com.bangcle.andJni.JniLib1557756502;

/* compiled from: SdUtils */
public class j {
    public static boolean a() {
        return JniLib1557756502.cZ(Integer.valueOf(100));
    }

    public static String b() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }
}
