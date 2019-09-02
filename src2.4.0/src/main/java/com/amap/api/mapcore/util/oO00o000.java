package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.File;
import java.lang.reflect.Constructor;

/* compiled from: InstanceFactory */
public class oO00o000 {
    public static Class O000000o(Context context, o0OO0o00 o0oo0o00, String str) {
        oOo000Oo O00000Oo = O00000Oo(context, o0oo0o00);
        try {
            return O000000o(O00000Oo) ? O00000Oo.loadClass(str) : null;
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "InstanceFactory", "loadpn");
            return null;
        }
    }

    public static <T> T O000000o(Context context, o0OO0o00 o0oo0o00, String str, Class cls, Class[] clsArr, Object[] objArr) throws o0O0oo0o {
        Object O000000o = O000000o(O00000Oo(context, o0oo0o00), str, clsArr, objArr);
        if (O000000o != null) {
            return O000000o;
        }
        O000000o = O000000o(cls, clsArr, objArr);
        if (O000000o != null) {
            return O000000o;
        }
        throw new o0O0oo0o("获取对象错误");
    }

    private static <T> T O000000o(oOo000Oo ooo000oo, String str, Class[] clsArr, Object[] objArr) {
        try {
            if (O000000o(ooo000oo)) {
                Class loadClass = ooo000oo.loadClass(str);
                if (loadClass != null) {
                    Constructor declaredConstructor = loadClass.getDeclaredConstructor(clsArr);
                    declaredConstructor.setAccessible(true);
                    return declaredConstructor.newInstance(objArr);
                }
            }
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "IFactory", "getWrap");
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
            oOo00ooO.O000000o(th, "IFactory", "gIns2()");
            return null;
        }
    }

    public static void O000000o(final Context context, final String str) {
        try {
            oO0OO000.O00000Oo().O000000o().submit(new Runnable() {
                public void run() {
                    try {
                        oO00OOOo.O000000o(new oO0O0o0o(context, oO00Oo00.O000000o()), context, str);
                    } catch (Throwable th) {
                        oOo00ooO.O000000o(th, "InstanceFactory", "rollBack");
                    }
                }
            });
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "InstanceFactory", "rollBack");
        }
    }

    public static boolean O000000o(Context context, o0OO0o00 o0oo0o00) {
        try {
            if (!new File(oO00OOOo.O000000o(context)).exists()) {
                return false;
            }
            File file = new File(oO00OOOo.O00000Oo(context, o0oo0o00.O000000o(), o0oo0o00.O00000Oo()));
            if (file.exists()) {
                return true;
            }
            oO00OOOo.O000000o(context, file, o0oo0o00);
            return false;
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "IFactory", "isdowned");
            return false;
        }
    }

    private static boolean O000000o(oOo000Oo ooo000oo) {
        return ooo000oo != null && ooo000oo.O000000o() && ooo000oo.O00000o;
    }

    private static oOo000Oo O00000Oo(Context context, o0OO0o00 o0oo0o00) {
        oOo000Oo ooo000oo = null;
        if (context == null) {
            return null;
        }
        try {
            if (O000000o(context, o0oo0o00)) {
                ooo000oo = oO0OO000.O00000Oo().O000000o(context, o0oo0o00);
            }
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "IFactory", "gIns1");
        }
        return ooo000oo;
    }
}
