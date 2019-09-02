package cn.jiguang.g;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public final class k {
    public static int a(Context context) {
        String c = c(context);
        if (!TextUtils.isEmpty(c)) {
            if ("wifi".equals(c)) {
                return 1;
            }
            if ("2g".equals(c)) {
                return 2;
            }
            if ("3g".equals(c)) {
                return 3;
            }
            if ("4g".equals(c)) {
                return 4;
            }
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    public static java.lang.String a(android.content.Context r4, int r5) {
        /*
        r4 = c(r4);
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x0053;
    L_0x000a:
        r0 = 1;
        r1 = new java.lang.Class[r0];	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r2 = java.lang.Integer.TYPE;	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r3 = 0;
        r1[r3] = r2;	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r2 = new java.lang.Object[r0];	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r2[r3] = r5;	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r5 = android.telephony.TelephonyManager.class;
        r3 = "getNetworkClass";
        r5 = cn.jiguang.f.a.a(r5, r3, r2, r1);	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r1 = r5;
        r1 = (java.lang.Integer) r1;	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r1 = r1.intValue();	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        if (r1 != 0) goto L_0x002e;
    L_0x002b:
        r5 = "unknown";
        goto L_0x0054;
    L_0x002e:
        r1 = r5;
        r1 = (java.lang.Integer) r1;	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r1 = r1.intValue();	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        if (r1 != r0) goto L_0x003a;
    L_0x0037:
        r5 = "2g";
        goto L_0x0054;
    L_0x003a:
        r0 = r5;
        r0 = (java.lang.Integer) r0;	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r0 = r0.intValue();	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r1 = 2;
        if (r0 != r1) goto L_0x0047;
    L_0x0044:
        r5 = "3g";
        goto L_0x0054;
    L_0x0047:
        r5 = (java.lang.Integer) r5;	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r5 = r5.intValue();	 Catch:{ Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053, Exception | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0053 }
        r0 = 3;
        if (r5 != r0) goto L_0x0053;
    L_0x0050:
        r5 = "4g";
        r4 = r5;
    L_0x0053:
        r5 = r4;
    L_0x0054:
        r4 = android.text.TextUtils.isEmpty(r5);
        if (r4 == 0) goto L_0x005c;
    L_0x005a:
        r5 = "unknown";
    L_0x005c:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.k.a(android.content.Context, int):java.lang.String");
    }

    public static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Missing block: B:17:0x002f, code skipped:
            r3 = "4g";
     */
    /* JADX WARNING: Missing block: B:18:0x0032, code skipped:
            r3 = "3g";
     */
    /* JADX WARNING: Missing block: B:19:0x0035, code skipped:
            r3 = "2g";
     */
    /* JADX WARNING: Missing block: B:20:0x0037, code skipped:
            r0 = r3;
     */
    public static java.lang.String c(android.content.Context r3) {
        /*
        r0 = "";
        r1 = "connectivity";
        r3 = r3.getSystemService(r1);	 Catch:{ Exception -> 0x0046 }
        r3 = (android.net.ConnectivityManager) r3;	 Catch:{ Exception -> 0x0046 }
        r3 = r3.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0046 }
        if (r3 != 0) goto L_0x0013;
    L_0x0010:
        r3 = "unknown";
        return r3;
    L_0x0013:
        r1 = r3.getType();	 Catch:{ Exception -> 0x0046 }
        r2 = 1;
        if (r1 != r2) goto L_0x001d;
    L_0x001a:
        r3 = "wifi";
        return r3;
    L_0x001d:
        r1 = r3.getType();	 Catch:{ Exception -> 0x0046 }
        if (r1 != 0) goto L_0x004a;
    L_0x0023:
        r3 = r3.getSubtype();	 Catch:{ Exception -> 0x0046 }
        switch(r3) {
            case 1: goto L_0x0035;
            case 2: goto L_0x0035;
            case 3: goto L_0x0032;
            case 4: goto L_0x0035;
            case 5: goto L_0x0032;
            case 6: goto L_0x0032;
            case 7: goto L_0x0035;
            case 8: goto L_0x0032;
            case 9: goto L_0x0032;
            case 10: goto L_0x0032;
            case 11: goto L_0x0035;
            case 12: goto L_0x0032;
            case 13: goto L_0x002f;
            case 14: goto L_0x0032;
            case 15: goto L_0x0032;
            default: goto L_0x002a;
        };	 Catch:{ Exception -> 0x0046 }
    L_0x002a:
        r1 = 16;
        if (r3 != r1) goto L_0x0039;
    L_0x002e:
        goto L_0x0035;
    L_0x002f:
        r3 = "4g";
        goto L_0x0037;
    L_0x0032:
        r3 = "3g";
        goto L_0x0037;
    L_0x0035:
        r3 = "2g";
    L_0x0037:
        r0 = r3;
        goto L_0x004a;
    L_0x0039:
        r1 = 17;
        if (r3 != r1) goto L_0x003e;
    L_0x003d:
        goto L_0x0032;
    L_0x003e:
        r1 = 18;
        if (r3 != r1) goto L_0x0043;
    L_0x0042:
        goto L_0x002f;
    L_0x0043:
        r3 = "unknown";
        goto L_0x0037;
    L_0x0046:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x004a:
        r3 = r0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.k.c(android.content.Context):java.lang.String");
    }
}
