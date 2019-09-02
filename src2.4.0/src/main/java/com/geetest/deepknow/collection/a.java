package com.geetest.deepknow.collection;

import android.content.Context;
import android.view.View;
import com.bangcle.andJni.JniLib1557756502;

/* compiled from: DPCollectionParam */
public class a {
    public static String a(Context context, String str, String str2) {
        return (String) JniLib1557756502.cL(context, str, str2, Integer.valueOf(35));
    }

    public static String a(View view, int i, View view2, String str, String str2) {
        return (String) JniLib1557756502.cL(view, Integer.valueOf(i), view2, str, str2, Integer.valueOf(36));
    }

    public static String a(String str, String str2) {
        return (String) JniLib1557756502.cL(str, str2, Integer.valueOf(37));
    }

    public static String a(String str, String str2, String str3) {
        return (String) JniLib1557756502.cL(str, str2, str3, Integer.valueOf(38));
    }

    public static String a(boolean z, boolean z2, String str, String str2) {
        return (String) JniLib1557756502.cL(Boolean.valueOf(z), Boolean.valueOf(z2), str, str2, Integer.valueOf(39));
    }
}
