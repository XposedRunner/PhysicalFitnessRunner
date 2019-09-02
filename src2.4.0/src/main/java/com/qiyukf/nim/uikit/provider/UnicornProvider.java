package com.qiyukf.nim.uikit.provider;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import java.io.File;

public class UnicornProvider extends FileProvider {
    public static Uri a(Context context, File file) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getPackageName());
        stringBuilder.append(".unicorn.fileprovider");
        return FileProvider.getUriForFile(context, stringBuilder.toString(), file);
    }

    public static boolean a(Context context) {
        if (VERSION.SDK_INT >= 24) {
            try {
                if (context.getPackageManager().getProviderInfo(new ComponentName(context, UnicornProvider.class), 128) != null) {
                    return true;
                }
            } catch (NameNotFoundException unused) {
            }
        }
        return false;
    }
}
