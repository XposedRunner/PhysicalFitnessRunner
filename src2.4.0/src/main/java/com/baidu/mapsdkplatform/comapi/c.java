package com.baidu.mapsdkplatform.comapi;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.baidu.mapapi.JNIInitializer;
import com.baidu.mapapi.common.EnvironmentUtilities;
import com.baidu.mapsdkplatform.comapi.b.a.a;
import java.io.File;
import java.io.IOException;

public class c {
    private static boolean a;

    public static void a(Context context, boolean z, String str, String str2) {
        if (!a) {
            if (context == null) {
                throw new IllegalArgumentException("context can not be null");
            } else if (context instanceof Application) {
                NativeLoader.setContext(context);
                NativeLoader.a(z, str);
                a.a().a(context);
                a.a().c();
                JNIInitializer.setContext((Application) context);
                if (a(str2)) {
                    EnvironmentUtilities.setSDCardPath(str2);
                }
                EnvironmentUtilities.initAppDirectory(context);
                a.a().a(context);
                a = true;
            } else {
                throw new RuntimeException("context must be an ApplicationContext");
            }
        }
    }

    private static boolean a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("/check.0");
            File file = new File(stringBuilder.toString());
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            if (file.exists()) {
                file.delete();
            }
            return true;
        } catch (IOException e) {
            Log.e("SDKInitializer", "SDCard cache path invalid", e);
            throw new IllegalArgumentException("Provided sdcard cache path invalid can not used.");
        }
    }
}
