package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O000000o;

/* compiled from: SPUtils */
public class O00O0Oo0 {
    private static final String O000000o = "share_date";

    public static Object O000000o(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences(O000000o, 0);
        return "String".equals(simpleName) ? sharedPreferences.getString(str, (String) obj) : "Integer".equals(simpleName) ? Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue())) : "Boolean".equals(simpleName) ? Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue())) : "Float".equals(simpleName) ? Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue())) : "Long".equals(simpleName) ? Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue())) : null;
    }

    public static void O000000o() {
        O000000o(O000000o.O0000O0o);
        O000000o(O000000o.O0000OOo);
        O000000o(O000000o.O0000Oo0);
        O000000o(O000000o.O0000Oo);
        O000000o(O000000o.O0000OoO);
        O000000o(O000000o.O0000Ooo);
        O000000o(O000000o.O0000o00);
        O000000o(O000000o.O0000o0);
        O000000o(O000000o.O0000o0O);
        O000000o(O000000o.O0000o0o);
        O000000o(O000000o.O0000o);
        O000000o(O000000o.O0000oO0);
        O000000o(O000000o.O0000oO);
        O000000o(O000000o.O0000oOO);
        O000000o(O000000o.O0000oOo);
        O000000o(O000000o.O0000oo0);
    }

    public static void O000000o(Context context, String str) {
        O000000o(str);
    }

    public static void O000000o(String str) {
        Editor edit = MyApplication.O000000o().getSharedPreferences(O000000o, 0).edit();
        edit.remove(str);
        edit.commit();
    }

    public static void O000000o(String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        Editor edit = MyApplication.O000000o().getSharedPreferences(O000000o, 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.commit();
    }

    public static void O00000Oo(String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        Editor edit = MyApplication.O000000o().getSharedPreferences(O000000o, 0).edit();
        if ("String".equals(simpleName)) {
            edit.putString(str, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.apply();
    }

    /* JADX WARNING: Missing block: B:12:0x003f, code skipped:
            if (r0.equals("Integer") != false) goto L_0x004d;
     */
    public static java.lang.Object O00000o0(java.lang.String r4, java.lang.Object r5) {
        /*
        r0 = r5.getClass();
        r0 = r0.getSimpleName();
        r1 = com.zjwh.android_wh_physicalfitness.application.MyApplication.O000000o();
        r2 = "share_date";
        r3 = 0;
        r1 = r1.getSharedPreferences(r2, r3);
        r2 = r0.hashCode();
        switch(r2) {
            case -1808118735: goto L_0x0042;
            case -672261858: goto L_0x0039;
            case 2374300: goto L_0x002f;
            case 67973692: goto L_0x0025;
            case 1729365000: goto L_0x001b;
            default: goto L_0x001a;
        };
    L_0x001a:
        goto L_0x004c;
    L_0x001b:
        r2 = "Boolean";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x004c;
    L_0x0023:
        r3 = 1;
        goto L_0x004d;
    L_0x0025:
        r2 = "Float";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x004c;
    L_0x002d:
        r3 = 2;
        goto L_0x004d;
    L_0x002f:
        r2 = "Long";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x004c;
    L_0x0037:
        r3 = 3;
        goto L_0x004d;
    L_0x0039:
        r2 = "Integer";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x004c;
    L_0x0041:
        goto L_0x004d;
    L_0x0042:
        r2 = "String";
        r0 = r0.equals(r2);
        if (r0 == 0) goto L_0x004c;
    L_0x004a:
        r3 = 4;
        goto L_0x004d;
    L_0x004c:
        r3 = -1;
    L_0x004d:
        switch(r3) {
            case 0: goto L_0x0084;
            case 1: goto L_0x0075;
            case 2: goto L_0x0066;
            case 3: goto L_0x0057;
            default: goto L_0x0050;
        };
    L_0x0050:
        r5 = (java.lang.String) r5;
        r4 = r1.getString(r4, r5);
        return r4;
    L_0x0057:
        r5 = (java.lang.Long) r5;
        r2 = r5.longValue();
        r4 = r1.getLong(r4, r2);
        r4 = java.lang.Long.valueOf(r4);
        return r4;
    L_0x0066:
        r5 = (java.lang.Float) r5;
        r5 = r5.floatValue();
        r4 = r1.getFloat(r4, r5);
        r4 = java.lang.Float.valueOf(r4);
        return r4;
    L_0x0075:
        r5 = (java.lang.Boolean) r5;
        r5 = r5.booleanValue();
        r4 = r1.getBoolean(r4, r5);
        r4 = java.lang.Boolean.valueOf(r4);
        return r4;
    L_0x0084:
        r5 = (java.lang.Integer) r5;
        r5 = r5.intValue();
        r4 = r1.getInt(r4, r5);
        r4 = java.lang.Integer.valueOf(r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O00000o0(java.lang.String, java.lang.Object):java.lang.Object");
    }
}
