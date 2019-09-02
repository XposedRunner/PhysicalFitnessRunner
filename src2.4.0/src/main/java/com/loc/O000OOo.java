package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.lang.reflect.Constructor;

/* compiled from: InstanceFactory */
public final class O000OOo {
    public static Class O000000o(Context context, OO0Oo0 oO0Oo0, String str) {
        O000Oo0 O00000o0 = O00000o0(context, oO0Oo0);
        try {
            return O000000o(O00000o0) ? O00000o0.loadClass(str) : null;
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "InstanceFactory", "loadpn");
            return null;
        }
    }

    public static <T> T O000000o(Context context, OO0Oo0 oO0Oo0, String str, Class cls, Class[] clsArr, Object[] objArr) throws OO00Oo0 {
        Object O000000o = O000000o(O00000o0(context, oO0Oo0), str, clsArr, objArr);
        if (O000000o != null) {
            return O000000o;
        }
        O000000o = O000000o(cls, clsArr, objArr);
        if (O000000o != null) {
            return O000000o;
        }
        throw new OO00Oo0("获取对象错误");
    }

    private static <T> T O000000o(O000Oo0 o000Oo0, String str, Class[] clsArr, Object[] objArr) {
        try {
            if (O000000o(o000Oo0)) {
                Class loadClass = o000Oo0.loadClass(str);
                if (loadClass != null) {
                    Constructor declaredConstructor = loadClass.getDeclaredConstructor(clsArr);
                    declaredConstructor.setAccessible(true);
                    return declaredConstructor.newInstance(objArr);
                }
            }
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "IFactory", "getWrap");
        }
        return null;
    }

    private static <T> T O000000o(Class cls, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "IFactory", "gIns2()");
            return null;
        }
    }

    public static String O000000o(Context context, OO0Oo0 oO0Oo0) {
        try {
            if (!new File(O000o000.O000000o(context)).exists()) {
                return null;
            }
            File file = new File(O000o000.O00000Oo(context, oO0Oo0.O000000o(), oO0Oo0.O00000Oo()));
            if (file.exists()) {
                return file.getAbsolutePath();
            }
            O000o000.O000000o(context, file, oO0Oo0);
            return null;
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "IFactory", "isdowned");
            return null;
        }
    }

    public static void O000000o(final Context context, final String str) {
        try {
            O00O00Oo.O00000Oo().O000000o().submit(new Runnable() {
                public final void run() {
                    try {
                        O000o000.O000000o(new O000O0o(context, O000o.O00000Oo()), context, str);
                    } catch (Throwable th) {
                        O0000Oo.O000000o(th, "InstanceFactory", "rollBack");
                    }
                }
            });
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "InstanceFactory", "rollBack");
        }
    }

    public static boolean O000000o(Context context, O000OOo0 o000OOo0, OO0Oo0 oO0Oo0) {
        boolean z = o000OOo0 != null && o000OOo0.O00000o0();
        try {
            if (!O00O00o0.O000000o(oO0Oo0, o000OOo0) || !O00O00o0.O000000o(o000OOo0) || !O00O00o0.O000000o(context, z) || O00O00o0.O000000o(context, o000OOo0, oO0Oo0)) {
                return false;
            }
            O000o000.O00000Oo(context, oO0Oo0.O000000o());
            return true;
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "dDownLoad", "isNeedDownload()");
            return false;
        }
    }

    private static boolean O000000o(O000Oo0 o000Oo0) {
        return o000Oo0 != null && o000Oo0.O000000o() && o000Oo0.O00000o;
    }

    public static void O00000Oo(Context context, O000OOo0 o000OOo0, OO0Oo0 oO0Oo0) {
        if (o000OOo0 != null) {
            try {
                if (!TextUtils.isEmpty(o000OOo0.O000000o()) && !TextUtils.isEmpty(o000OOo0.O00000Oo()) && !TextUtils.isEmpty(o000OOo0.O00000o0)) {
                    new O000OOOo(context, o000OOo0, oO0Oo0).O000000o();
                }
            } catch (Throwable th) {
                O0000Oo.O000000o(th, "IFactory", "dDownload()");
            }
        }
    }

    public static boolean O00000Oo(Context context, OO0Oo0 oO0Oo0) {
        try {
            if (!new File(O000o000.O000000o(context)).exists()) {
                return false;
            }
            File file = new File(O000o000.O00000Oo(context, oO0Oo0.O000000o(), oO0Oo0.O00000Oo()));
            if (file.exists()) {
                return true;
            }
            O000o000.O000000o(context, file, oO0Oo0);
            return false;
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "IFactory", "isdowned");
            return false;
        }
    }

    private static O000Oo0 O00000o0(Context context, OO0Oo0 oO0Oo0) {
        if (context == null) {
            return null;
        }
        try {
            if (O00000Oo(context, oO0Oo0)) {
                return O00O00Oo.O00000Oo().O000000o(context, oO0Oo0);
            }
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "IFactory", "gIns1");
        }
        return null;
    }
}
