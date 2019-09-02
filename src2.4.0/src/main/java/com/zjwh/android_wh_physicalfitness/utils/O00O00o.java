package com.zjwh.android_wh_physicalfitness.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import kr.co.namee.permissiongen.PermissionGen;

/* compiled from: PermissionUtils */
public class O00O00o {
    public static final int O000000o = 100;
    public static final int O00000Oo = 101;
    public static final int O00000o = 103;
    public static final int O00000o0 = 102;
    public static final int O00000oO = 104;

    public static void O000000o(Activity activity) {
        PermissionGen.needPermission(activity, 104, new String[]{"android.permission.READ_PHONE_STATE"});
    }

    public static void O000000o(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("package:");
        stringBuilder.append(context.getPackageName());
        context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse(stringBuilder.toString())));
    }

    public static void O000000o(final Context context, int i) {
        int i2 = R.string.open_default_permission_title;
        if (i != 104) {
            switch (i) {
                case 100:
                    i2 = R.string.open_camera_permission_title;
                    i = R.string.open_camera_permission;
                    break;
                case 101:
                    i2 = R.string.open_gps_permission_title;
                    i = R.string.open_gps_permission;
                    break;
                default:
                    i = R.string.open_default_permission;
                    break;
            }
        }
        i = R.string.open_read_phone_permission;
        new O0000Oo(context).O000000o().O00000Oo(i).O000000o(i2).O00000Oo((int) R.string.open_setting, new OnClickListener() {
            public void onClick(View view) {
                O00O00o.O000000o(context);
            }
        }).O000000o((int) R.string.cancel, null).O00000Oo();
    }

    public static void O000000o(Fragment fragment) {
        PermissionGen.needPermission(fragment, 101, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public static O0000Oo O00000Oo(final Context context) {
        return new O0000Oo(context).O000000o().O00000Oo((int) R.string.open_read_phone_permission).O000000o((int) R.string.open_default_permission_title).O00000Oo((int) R.string.open_setting, new OnClickListener() {
            public void onClick(View view) {
                O00O00o.O000000o(context);
            }
        }).O000000o((int) R.string.cancel, null);
    }

    public static void O00000Oo(Activity activity) {
        PermissionGen.needPermission(activity, 103, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE"});
    }

    public static void O00000Oo(Fragment fragment) {
        PermissionGen.needPermission(fragment, 100, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public static void O00000o(Activity activity) {
        PermissionGen.needPermission(activity, 100, new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public static void O00000o0(Activity activity) {
        PermissionGen.needPermission(activity, 101, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public static void O00000o0(Fragment fragment) {
        PermissionGen.needPermission(fragment, 102, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public static void O00000oO(Activity activity) {
        PermissionGen.needPermission(activity, 102, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
    }
}
