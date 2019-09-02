package com.qiyukf.nimlib.sdk;

import android.content.Context;
import com.qiyukf.nimlib.b;
import com.qiyukf.nimlib.d;
import com.qiyukf.nimlib.sdk.auth.LoginInfo;
import com.qiyukf.unicorn.api.StatusBarNotificationConfig;

public class NIMClient {
    public static <T> T getService(Class<T> cls) {
        return b.a((Class) cls);
    }

    public static StatusCode getStatus() {
        return d.e();
    }

    public static void init(Context context, LoginInfo loginInfo, SDKOptions sDKOptions, boolean z) {
        b.a(context, loginInfo, sDKOptions, z);
    }

    public static void updateStatusBarNotificationConfig(StatusBarNotificationConfig statusBarNotificationConfig) {
        b.a(statusBarNotificationConfig);
    }
}
