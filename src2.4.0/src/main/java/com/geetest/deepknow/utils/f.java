package com.geetest.deepknow.utils;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.bangcle.andJni.JniLib1557756502;
import java.lang.reflect.Method;

/* compiled from: DPSPUtils */
public class f {

    /* compiled from: DPSPUtils */
    private static class a {
        private static final Method a = a();

        private static Method a() {
            return (Method) JniLib1557756502.cL(Integer.valueOf(78));
        }

        public static void a(Editor editor) {
            JniLib1557756502.cV(editor, Integer.valueOf(79));
        }
    }

    public static String a(Context context, String str, String str2) {
        return (String) JniLib1557756502.cL(context, str, str2, Integer.valueOf(80));
    }

    public static void a(Context context, String str) {
        JniLib1557756502.cV(context, str, Integer.valueOf(81));
    }

    public static void a(Context context, String str, Object obj) {
        JniLib1557756502.cV(context, str, obj, Integer.valueOf(82));
    }
}
