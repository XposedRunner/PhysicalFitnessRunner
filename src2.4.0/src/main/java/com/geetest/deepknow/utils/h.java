package com.geetest.deepknow.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.a.a.a.a;
import com.geetest.deepknow.c.b;

/* compiled from: DPUtils */
public class h {
    public static void a(Context context, a aVar, b bVar) {
        JniLib1557756502.cV(context, aVar, bVar, Integer.valueOf(85));
    }

    public static void a(Context context, a aVar, String str, b bVar, com.geetest.deepknow.c.a aVar2) {
        JniLib1557756502.cV(context, aVar, str, bVar, aVar2, Integer.valueOf(86));
    }

    public static void a(Context context, String str, String str2, boolean z) {
        JniLib1557756502.cV(context, str, str2, Boolean.valueOf(z), Integer.valueOf(87));
    }

    public static boolean a(Object obj) {
        return JniLib1557756502.cZ(obj, Integer.valueOf(88));
    }

    public static boolean a(String str) {
        return TextUtils.isEmpty(str);
    }
}
