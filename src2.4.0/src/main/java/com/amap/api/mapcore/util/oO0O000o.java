package com.amap.api.mapcore.util;

import android.content.Context;
import java.lang.reflect.Constructor;

/* compiled from: DexSoManager */
public class oO0O000o {
    private volatile int O000000o = -1;

    /* compiled from: DexSoManager */
    static class O000000o {
        public static oO0O000o O000000o = new oO0O000o();
    }

    public static oO0O000o O000000o() {
        return O000000o.O000000o;
    }

    public static boolean O000000o(o0OO0o00 o0oo0o00) {
        return aa.O000000o(o0oo0o00);
    }

    private static void O00000o(Context context, o0OO0o00 o0oo0o00) {
        new aj().O000000o(context, o0oo0o00);
    }

    public <T> T O000000o(Context context, o0OO0o00 o0oo0o00, String str, Class cls, Class[] clsArr, Object[] objArr) throws o0O0oo0o {
        try {
            Class loadClass = context.getClassLoader().loadClass(str);
            if (loadClass != null) {
                Constructor declaredConstructor = loadClass.getDeclaredConstructor(clsArr);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(objArr);
            }
        } catch (Throwable th) {
            t.O000000o(th, "tt");
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a5  */
    /* JADX WARNING: Missing block: B:51:0x013a, code skipped:
            return;
     */
    public void O000000o(android.content.Context r13, com.amap.api.mapcore.util.o0OO0o00 r14, com.amap.api.mapcore.util.oO0O00Oo r15) {
        /*
        r12 = this;
        if (r15 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r15.O00000oO();
        r1 = r15.O00000oo();
        r2 = com.amap.api.mapcore.util.oO0O00o0.O000000o(r13);
        r3 = new com.amap.api.mapcore.util.oO00OO0O;
        r4 = r15.O00000Oo();
        r5 = r15.O00000o0();
        r6 = "";
        r3.<init>(r4, r5, r6);
        r4 = 1;
        r5 = 0;
        if (r2 == 0) goto L_0x00a6;
    L_0x0022:
        r6 = r2.O0000O0o();
        if (r0 == r6) goto L_0x002d;
    L_0x0028:
        r2.O00000Oo(r0);
        r0 = r4;
        goto L_0x002e;
    L_0x002d:
        r0 = r5;
    L_0x002e:
        r6 = r2.O0000OOo();
        if (r1 == r6) goto L_0x0038;
    L_0x0034:
        r2.O00000o0(r1);
        r0 = r4;
    L_0x0038:
        if (r0 == 0) goto L_0x003d;
    L_0x003a:
        r2.O00000Oo(r13);
    L_0x003d:
        if (r14 != 0) goto L_0x0041;
    L_0x003f:
        r0 = r5;
        goto L_0x00a3;
    L_0x0041:
        r0 = r2.O0000O0o();
        if (r0 != 0) goto L_0x004b;
    L_0x0047:
        O00000o(r13, r14);
        goto L_0x003f;
    L_0x004b:
        r0 = r2.O0000OOo();
        if (r0 != 0) goto L_0x0052;
    L_0x0051:
        goto L_0x003f;
    L_0x0052:
        r0 = r14.O00000Oo();
        r1 = r14.O00000o0();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0061;
    L_0x0060:
        goto L_0x003f;
    L_0x0061:
        if (r3 == 0) goto L_0x003f;
    L_0x0063:
        r0 = r3.O0000O0o();
        if (r0 != 0) goto L_0x006a;
    L_0x0069:
        goto L_0x003f;
    L_0x006a:
        r0 = r3.O0000Oo0();
        r1 = r14.O00000Oo();
        r0 = com.amap.api.mapcore.util.ar.O00000Oo(r0, r1);
        if (r0 == 0) goto L_0x003f;
    L_0x0078:
        r0 = r3.O0000Oo();
        r1 = r14.O00000Oo();
        r0 = com.amap.api.mapcore.util.ar.O000000o(r0, r1);
        if (r0 > 0) goto L_0x0087;
    L_0x0086:
        goto L_0x003f;
    L_0x0087:
        if (r2 == 0) goto L_0x00a2;
    L_0x0089:
        r0 = r2.O00000o(r13);
        if (r0 == 0) goto L_0x00a2;
    L_0x008f:
        r0 = r3.O0000Oo();
        r1 = r2.O00000o0();
        r1 = r1.O0000Oo();
        r0 = com.amap.api.mapcore.util.ar.O000000o(r0, r1);
        if (r0 > 0) goto L_0x00a2;
    L_0x00a1:
        goto L_0x003f;
    L_0x00a2:
        r0 = r4;
    L_0x00a3:
        if (r0 != 0) goto L_0x00a6;
    L_0x00a5:
        r4 = r5;
    L_0x00a6:
        if (r4 != 0) goto L_0x00a9;
    L_0x00a8:
        return;
    L_0x00a9:
        r0 = r15.O00000Oo();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x013a;
    L_0x00b3:
        r0 = r15.O00000o();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x00bf;
    L_0x00bd:
        goto L_0x013a;
    L_0x00bf:
        r0 = com.amap.api.mapcore.util.aa.O000000o(r14);
        if (r0 == 0) goto L_0x00c6;
    L_0x00c5:
        return;
    L_0x00c6:
        r0 = com.amap.api.mapcore.util.oO0O0O00.O000000o();
        r0.O000000o(r13);
        r0 = com.amap.api.mapcore.util.oO0O0O00.O000000o();
        r0.O000000o(r14);
        r14 = com.amap.api.mapcore.util.oO0O0O00.O000000o();
        r0 = r3.O0000OOo();
        r1 = r3.O0000Oo0();
        r4 = r3.O0000Oo();
        r14 = r14.O000000o(r0, r1, r4);
        if (r14 == 0) goto L_0x00eb;
    L_0x00ea:
        return;
    L_0x00eb:
        r5 = new com.amap.api.mapcore.util.ab;
        r14 = r15.O00000Oo();
        r0 = r15.O000000o(r13);
        r1 = "";
        r5.<init>(r14, r0, r1);
        r6 = new com.amap.api.mapcore.util.kr;
        r14 = r3.O0000OOo();
        r0 = r3.O0000Oo0();
        r1 = r3.O0000Oo();
        r4 = r15.O00000Oo(r13);
        r6.<init>(r14, r0, r1, r4);
        r14 = new com.amap.api.mapcore.util.oO0O00o0;
        r7 = r15.O000000o(r13);
        r8 = 0;
        r9 = r15.O00000oO();
        r10 = r15.O00000oo();
        r11 = r15.O0000O0o();
        r4 = r14;
        r4.<init>(r5, r6, r7, r8, r9, r10, r11);
        r0 = r2.O00000oO();
        r14.O000000o(r0);
        r0 = new com.amap.api.mapcore.util.aa;
        r15 = r15.O000000o();
        r0.<init>(r13, r3, r14, r15);
        r0.O000000o();
        return;
    L_0x013a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO0O000o.O000000o(android.content.Context, com.amap.api.mapcore.util.o0OO0o00, com.amap.api.mapcore.util.oO0O00Oo):void");
    }

    public void O000000o(Context context, o0OO0o00 o0oo0o00, boolean z) {
        oO0O00o0 O000000o = oO0O00o0.O000000o(context);
        O000000o.O000000o(z);
        O000000o.O00000Oo(context);
    }

    public boolean O000000o(Context context, o0OO0o00 o0oo0o00) {
        return (context != null && O000000o(o0oo0o00)) ? oO0O00o0.O000000o(context).O00000oO() : false;
    }

    public boolean O00000Oo(Context context, o0OO0o00 o0oo0o00) {
        if (this.O000000o == 1) {
            return false;
        }
        boolean O00000o0 = O00000o0(context, o0oo0o00);
        if (!O00000o0) {
            this.O000000o = 1;
        }
        return O00000o0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c A:{RETURN} */
    public boolean O00000o0(android.content.Context r5, com.amap.api.mapcore.util.o0OO0o00 r6) {
        /*
        r4 = this;
        r0 = com.amap.api.mapcore.util.oO0O00o0.O000000o(r5);
        r1 = 0;
        if (r0 == 0) goto L_0x00b4;
    L_0x0007:
        r2 = r0.O00000o0();
        if (r2 != 0) goto L_0x000f;
    L_0x000d:
        goto L_0x00b4;
    L_0x000f:
        if (r6 == 0) goto L_0x0099;
    L_0x0011:
        if (r0 != 0) goto L_0x0015;
    L_0x0013:
        goto L_0x0099;
    L_0x0015:
        r2 = r6.O00000o0();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x0099;
    L_0x001f:
        r2 = r6.O00000Oo();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x002b;
    L_0x0029:
        goto L_0x0099;
    L_0x002b:
        r2 = r6.O00000Oo();
        r3 = r6.O00000o0();
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x003a;
    L_0x0039:
        goto L_0x0099;
    L_0x003a:
        if (r0 == 0) goto L_0x0099;
    L_0x003c:
        r2 = r0.O00000o(r5);
        if (r2 != 0) goto L_0x0043;
    L_0x0042:
        goto L_0x0099;
    L_0x0043:
        r2 = r0.O0000O0o();
        if (r2 != 0) goto L_0x004d;
    L_0x0049:
        O00000o(r5, r6);
        goto L_0x0099;
    L_0x004d:
        r2 = r0.O0000OOo();
        if (r2 != 0) goto L_0x0054;
    L_0x0053:
        goto L_0x0099;
    L_0x0054:
        r2 = r0.O00000o0();
        r2 = r2.O0000Oo0();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x0099;
    L_0x0062:
        r2 = r0.O00000o0();
        r2 = r2.O0000Oo();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0071;
    L_0x0070:
        goto L_0x0099;
    L_0x0071:
        r2 = r6.O00000Oo();
        r3 = r0.O00000o0();
        r3 = r3.O0000Oo0();
        r2 = com.amap.api.mapcore.util.ar.O000000o(r2, r3);
        if (r2 == 0) goto L_0x0084;
    L_0x0083:
        goto L_0x0099;
    L_0x0084:
        r2 = r6.O00000Oo();
        r3 = r0.O00000o0();
        r3 = r3.O0000Oo();
        r2 = com.amap.api.mapcore.util.ar.O000000o(r2, r3);
        if (r2 < 0) goto L_0x0097;
    L_0x0096:
        goto L_0x0099;
    L_0x0097:
        r2 = 1;
        goto L_0x009a;
    L_0x0099:
        r2 = r1;
    L_0x009a:
        if (r2 != 0) goto L_0x009d;
    L_0x009c:
        return r1;
    L_0x009d:
        r1 = new com.amap.api.mapcore.util.v;
        r1.<init>(r5, r6);
        r2 = new com.amap.api.mapcore.util.ai$O000000o;
        r3 = r1.O0000Oo();
        r1 = r1.O0000OoO();
        r2.<init>(r0, r3, r1);
        r5 = r2.O000000o(r5, r6);
        return r5;
    L_0x00b4:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.oO0O000o.O00000o0(android.content.Context, com.amap.api.mapcore.util.o0OO0o00):boolean");
    }
}
