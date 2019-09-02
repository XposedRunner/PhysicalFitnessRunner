package com.tencent.open.web.security;

import android.content.Context;
import cn.jiguang.net.HttpUtils;
import com.tencent.connect.auth.AuthAgent;
import com.tencent.open.a.f;
import com.tencent.open.utils.e;
import java.io.File;

/* compiled from: ProGuard */
public class JniInterface {
    public static boolean isJniOk;

    public static native boolean BackSpaceChar(boolean z, int i);

    public static native boolean clearAllPWD();

    public static native String getPWDKeyToMD5(String str);

    public static native boolean insetTextToArray(int i, String str, int i2);

    public static void loadSo() {
        if (!isJniOk) {
            StringBuilder stringBuilder;
            try {
                Context a = e.a();
                StringBuilder stringBuilder2;
                if (a != null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(a.getFilesDir().toString());
                    stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
                    stringBuilder.append(AuthAgent.SECURE_LIB_NAME);
                    if (new File(stringBuilder.toString()).exists()) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(a.getFilesDir().toString());
                        stringBuilder2.append(HttpUtils.PATHS_SEPARATOR);
                        stringBuilder2.append(AuthAgent.SECURE_LIB_NAME);
                        System.load(stringBuilder2.toString());
                        isJniOk = true;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("-->load lib success:");
                        stringBuilder2.append(AuthAgent.SECURE_LIB_NAME);
                        f.c("openSDK_LOG.JniInterface", stringBuilder2.toString());
                    } else {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("-->fail, because so is not exists:");
                        stringBuilder2.append(AuthAgent.SECURE_LIB_NAME);
                        f.c("openSDK_LOG.JniInterface", stringBuilder2.toString());
                    }
                } else {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("-->load lib fail, because context is null:");
                    stringBuilder2.append(AuthAgent.SECURE_LIB_NAME);
                    f.c("openSDK_LOG.JniInterface", stringBuilder2.toString());
                }
            } catch (Throwable th) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("-->load lib error:");
                stringBuilder.append(AuthAgent.SECURE_LIB_NAME);
                f.b("openSDK_LOG.JniInterface", stringBuilder.toString(), th);
            }
        }
    }
}
