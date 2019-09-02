package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.mm.opensdk.utils.Log;

public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(" should not be instantiated");
        throw new RuntimeException(stringBuilder.toString());
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        return createWXAPI(context, str, false);
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("createWXAPI, appId = ");
        stringBuilder.append(str);
        stringBuilder.append(", checkSignature = ");
        stringBuilder.append(z);
        Log.d(str2, stringBuilder.toString());
        return new WXApiImplV10(context, str, z);
    }
}
