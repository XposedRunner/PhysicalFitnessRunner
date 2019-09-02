package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* compiled from: ResourcesUtil */
public class OOOO0OO {
    private static boolean O000000o = new File("/system/framework/amap.jar").exists();

    public static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static AssetManager O000000o(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (O000000o) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(assets, new Object[]{"/system/framework/amap.jar"});
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "ResourcesUtil", "getSelfAssets");
            }
        }
        return assets;
    }
}
