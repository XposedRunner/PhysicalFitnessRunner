package com.geetest.mobinfo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import org.json.JSONObject;

public class GtMobHelper implements GtMobInterface {
    public static final String GT_MOB_HELPER_VERSION = "0.0.5";

    static {
        System.loadLibrary("deepknow-lib");
    }

    public static native byte[] getPostParamForDeepknow(@NonNull ConfigInterface configInterface, @NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2, @NonNull Context context);

    public static native String getPostParamForDeepknowTest(@NonNull ConfigInterface configInterface, @NonNull JSONObject jSONObject, @Nullable JSONObject jSONObject2, @NonNull Context context);
}
