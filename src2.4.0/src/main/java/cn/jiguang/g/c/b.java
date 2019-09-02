package cn.jiguang.g.c;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class b {
    private static int a;

    private static int a(int i) {
        try {
            Method declaredMethod = Class.forName("android.telephony.SubscriptionManager").getDeclaredMethod("getSubId", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            int[] iArr = (int[]) declaredMethod.invoke(null, new Object[]{Integer.valueOf(i)});
            if (iArr.length > 0) {
                return iArr[0];
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    private static a a(TelephonyManager telephonyManager) {
        if (telephonyManager == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.a = telephonyManager.getDeviceId();
            aVar.b = telephonyManager.getSubscriberId();
            aVar.c = telephonyManager.getSimSerialNumber();
        } catch (Throwable unused) {
        }
        return aVar;
    }

    public static ArrayList<a> a(Context context) {
        if ((a == 0 || a == 1) && a()) {
            a = 1;
            return b(context);
        } else if ((a == 0 || a == 2) && c(context)) {
            a = 2;
            return d(context);
        } else if ((a == 0 || a == 3) && e(context)) {
            a = 3;
            return f(context);
        } else if ((a == 0 || a == 4) && g(context)) {
            a = 4;
            return h(context);
        } else {
            a = 1;
            return b(context);
        }
    }

    private static boolean a() {
        try {
            return TelephonyManager.class.getMethod("getSimCount", new Class[0]) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static int b(TelephonyManager telephonyManager) {
        try {
            return ((Integer) telephonyManager.getClass().getMethod("getSimCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0090 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x008a */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:13|14) */
    /* JADX WARNING: Missing block: B:14:?, code skipped:
            r0.clear();
     */
    private static java.util.ArrayList<cn.jiguang.g.c.a> b(android.content.Context r12) {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = "phone";
        r12 = r12.getSystemService(r1);	 Catch:{ Throwable -> 0x009b }
        r12 = (android.telephony.TelephonyManager) r12;	 Catch:{ Throwable -> 0x009b }
        r1 = b(r12);	 Catch:{ Throwable -> 0x009b }
        if (r1 <= 0) goto L_0x0093;
    L_0x0013:
        r2 = r12.getClass();	 Catch:{ Throwable -> 0x0090 }
        r3 = "getImei";
        r4 = 1;
        r5 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x0090 }
        r6 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x0090 }
        r7 = 0;
        r5[r7] = r6;	 Catch:{ Throwable -> 0x0090 }
        r2 = r2.getDeclaredMethod(r3, r5);	 Catch:{ Throwable -> 0x0090 }
        r2.setAccessible(r4);	 Catch:{ Throwable -> 0x0090 }
        r3 = r12.getClass();	 Catch:{ Throwable -> 0x0090 }
        r5 = "getSimSerialNumber";
        r6 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x0090 }
        r8 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x0090 }
        r6[r7] = r8;	 Catch:{ Throwable -> 0x0090 }
        r3 = r3.getDeclaredMethod(r5, r6);	 Catch:{ Throwable -> 0x0090 }
        r3.setAccessible(r4);	 Catch:{ Throwable -> 0x0090 }
        r5 = r12.getClass();	 Catch:{ Throwable -> 0x0090 }
        r6 = "getSubscriberId";
        r8 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x0090 }
        r9 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x0090 }
        r8[r7] = r9;	 Catch:{ Throwable -> 0x0090 }
        r5 = r5.getDeclaredMethod(r6, r8);	 Catch:{ Throwable -> 0x0090 }
        r5.setAccessible(r4);	 Catch:{ Throwable -> 0x0090 }
        r6 = r7;
    L_0x004f:
        if (r6 >= r1) goto L_0x009e;
    L_0x0051:
        r8 = a(r6);	 Catch:{ Throwable -> 0x0090 }
        r9 = new cn.jiguang.g.c.a;	 Catch:{ Throwable -> 0x0090 }
        r9.<init>();	 Catch:{ Throwable -> 0x0090 }
        r10 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x008a }
        r11 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x008a }
        r10[r7] = r11;	 Catch:{ Throwable -> 0x008a }
        r10 = r2.invoke(r12, r10);	 Catch:{ Throwable -> 0x008a }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x008a }
        r9.a = r10;	 Catch:{ Throwable -> 0x008a }
        r10 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x008a }
        r11 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x008a }
        r10[r7] = r11;	 Catch:{ Throwable -> 0x008a }
        r10 = r3.invoke(r12, r10);	 Catch:{ Throwable -> 0x008a }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x008a }
        r9.c = r10;	 Catch:{ Throwable -> 0x008a }
        r10 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x008a }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Throwable -> 0x008a }
        r10[r7] = r8;	 Catch:{ Throwable -> 0x008a }
        r8 = r5.invoke(r12, r10);	 Catch:{ Throwable -> 0x008a }
        r8 = (java.lang.String) r8;	 Catch:{ Throwable -> 0x008a }
        r9.b = r8;	 Catch:{ Throwable -> 0x008a }
    L_0x008a:
        r0.add(r9);	 Catch:{ Throwable -> 0x0090 }
        r6 = r6 + 1;
        goto L_0x004f;
    L_0x0090:
        r0.clear();	 Catch:{ Throwable -> 0x009b }
    L_0x0093:
        r12 = a(r12);	 Catch:{ Throwable -> 0x009b }
        r0.add(r12);	 Catch:{ Throwable -> 0x009b }
        return r0;
    L_0x009b:
        r0.clear();
    L_0x009e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.c.b.b(android.content.Context):java.util.ArrayList");
    }

    private static ArrayList<Integer> c(TelephonyManager telephonyManager) {
        ArrayList arrayList = new ArrayList();
        try {
            Field[] declaredFields = TelephonyManager.class.getDeclaredFields();
            int length = declaredFields.length;
            int i = 0;
            int i2 = i;
            while (i < length) {
                Field field = declaredFields[i];
                field.setAccessible(true);
                if (TextUtils.equals(field.getType().getName(), "com.android.internal.telephony.ITelephonyRegistry") && field.get(telephonyManager) != null) {
                    arrayList.add(Integer.valueOf(i2));
                    i2++;
                }
                i++;
            }
        } catch (Throwable unused) {
            arrayList.clear();
            arrayList.add(Integer.valueOf(0));
            arrayList.add(Integer.valueOf(1));
        }
        return arrayList;
    }

    private static boolean c(Context context) {
        try {
            c((TelephonyManager) context.getSystemService("phone"));
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubscriberIdGemini", new Class[]{Integer.TYPE});
            Method declaredMethod2 = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", new Class[]{Integer.TYPE});
            Method declaredMethod3 = TelephonyManager.class.getDeclaredMethod("getPhoneTypeGemini", new Class[]{Integer.TYPE});
            Field declaredField = TelephonyManager.class.getDeclaredField("mtkGeminiSupport");
            if (!(declaredMethod == null || declaredMethod2 == null || declaredMethod3 == null || declaredField == null)) {
                declaredField.setAccessible(true);
                if (((Boolean) declaredField.get(null)).booleanValue()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0083 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:5|6|7|8|9|10|3) */
    private static java.util.ArrayList<cn.jiguang.g.c.a> d(android.content.Context r12) {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = "phone";
        r12 = r12.getSystemService(r1);	 Catch:{ Throwable -> 0x008a }
        r12 = (android.telephony.TelephonyManager) r12;	 Catch:{ Throwable -> 0x008a }
        r1 = android.telephony.TelephonyManager.class;
        r2 = "getSubscriberIdGemini";
        r3 = 1;
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x008a }
        r5 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008a }
        r6 = 0;
        r4[r6] = r5;	 Catch:{ Throwable -> 0x008a }
        r1 = r1.getDeclaredMethod(r2, r4);	 Catch:{ Throwable -> 0x008a }
        r2 = android.telephony.TelephonyManager.class;
        r4 = "getDeviceIdGemini";
        r5 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x008a }
        r7 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008a }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x008a }
        r2 = r2.getDeclaredMethod(r4, r5);	 Catch:{ Throwable -> 0x008a }
        r4 = android.telephony.TelephonyManager.class;
        r5 = "getSimSerialNumberGemini";
        r7 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x008a }
        r8 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x008a }
        r7[r6] = r8;	 Catch:{ Throwable -> 0x008a }
        r4 = r4.getDeclaredMethod(r5, r7);	 Catch:{ Throwable -> 0x008a }
        r5 = c(r12);	 Catch:{ Throwable -> 0x008a }
        r7 = r6;
    L_0x003e:
        r8 = r5.size();	 Catch:{ Throwable -> 0x008a }
        if (r7 >= r8) goto L_0x0089;
    L_0x0044:
        r8 = new cn.jiguang.g.c.a;	 Catch:{ Throwable -> 0x008a }
        r8.<init>();	 Catch:{ Throwable -> 0x008a }
        r9 = r5.get(r7);	 Catch:{ Throwable -> 0x0083 }
        r9 = (java.lang.Integer) r9;	 Catch:{ Throwable -> 0x0083 }
        r9 = r9.intValue();	 Catch:{ Throwable -> 0x0083 }
        r10 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0083 }
        r11 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x0083 }
        r10[r6] = r11;	 Catch:{ Throwable -> 0x0083 }
        r10 = r1.invoke(r12, r10);	 Catch:{ Throwable -> 0x0083 }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x0083 }
        r8.b = r10;	 Catch:{ Throwable -> 0x0083 }
        r10 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0083 }
        r11 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x0083 }
        r10[r6] = r11;	 Catch:{ Throwable -> 0x0083 }
        r10 = r2.invoke(r12, r10);	 Catch:{ Throwable -> 0x0083 }
        r10 = (java.lang.String) r10;	 Catch:{ Throwable -> 0x0083 }
        r8.a = r10;	 Catch:{ Throwable -> 0x0083 }
        r10 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0083 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Throwable -> 0x0083 }
        r10[r6] = r9;	 Catch:{ Throwable -> 0x0083 }
        r9 = r4.invoke(r12, r10);	 Catch:{ Throwable -> 0x0083 }
        r9 = (java.lang.String) r9;	 Catch:{ Throwable -> 0x0083 }
        r8.c = r9;	 Catch:{ Throwable -> 0x0083 }
    L_0x0083:
        r0.add(r8);	 Catch:{ Throwable -> 0x008a }
        r7 = r7 + 1;
        goto L_0x003e;
    L_0x0089:
        return r0;
    L_0x008a:
        r12 = 0;
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.c.b.d(android.content.Context):java.util.ArrayList");
    }

    private static boolean e(Context context) {
        try {
            Class cls = Class.forName("android.telephony.MSimTelephonyManager");
            return (context.getSystemService("phone_msim") == null || cls.getMethod("getDeviceId", new Class[]{Integer.TYPE}) == null || cls.getMethod("getSubscriberId", new Class[]{Integer.TYPE}) == null) ? false : true;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0050 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0078 */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|11) */
    /* JADX WARNING: Missing block: B:14:0x007d, code skipped:
            return null;
     */
    private static java.util.ArrayList<cn.jiguang.g.c.a> f(android.content.Context r8) {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = "android.telephony.MSimTelephonyManager";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x007c }
        r2 = "phone_msim";
        r8 = r8.getSystemService(r2);	 Catch:{ Throwable -> 0x007c }
        r2 = "getDeviceId";
        r3 = 1;
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x007c }
        r5 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x007c }
        r6 = 0;
        r4[r6] = r5;	 Catch:{ Throwable -> 0x007c }
        r2 = r1.getMethod(r2, r4);	 Catch:{ Throwable -> 0x007c }
        r4 = "getSubscriberId";
        r5 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x007c }
        r7 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x007c }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x007c }
        r1 = r1.getMethod(r4, r5);	 Catch:{ Throwable -> 0x007c }
        r4 = new cn.jiguang.g.c.a;	 Catch:{ Throwable -> 0x007c }
        r4.<init>();	 Catch:{ Throwable -> 0x007c }
        r5 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0050 }
        r7 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0050 }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x0050 }
        r5 = r2.invoke(r8, r5);	 Catch:{ Throwable -> 0x0050 }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x0050 }
        r4.a = r5;	 Catch:{ Throwable -> 0x0050 }
        r5 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0050 }
        r7 = java.lang.Integer.valueOf(r6);	 Catch:{ Throwable -> 0x0050 }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x0050 }
        r5 = r1.invoke(r8, r5);	 Catch:{ Throwable -> 0x0050 }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x0050 }
        r4.b = r5;	 Catch:{ Throwable -> 0x0050 }
    L_0x0050:
        r0.add(r4);	 Catch:{ Throwable -> 0x007c }
        r4 = new cn.jiguang.g.c.a;	 Catch:{ Throwable -> 0x007c }
        r4.<init>();	 Catch:{ Throwable -> 0x007c }
        r5 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0078 }
        r7 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x0078 }
        r5[r6] = r7;	 Catch:{ Throwable -> 0x0078 }
        r2 = r2.invoke(r8, r5);	 Catch:{ Throwable -> 0x0078 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x0078 }
        r4.a = r2;	 Catch:{ Throwable -> 0x0078 }
        r2 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0078 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x0078 }
        r2[r6] = r3;	 Catch:{ Throwable -> 0x0078 }
        r8 = r1.invoke(r8, r2);	 Catch:{ Throwable -> 0x0078 }
        r8 = (java.lang.String) r8;	 Catch:{ Throwable -> 0x0078 }
        r4.b = r8;	 Catch:{ Throwable -> 0x0078 }
    L_0x0078:
        r0.add(r4);	 Catch:{ Throwable -> 0x007c }
        return r0;
    L_0x007c:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.c.b.f(android.content.Context):java.util.ArrayList");
    }

    private static boolean g(Context context) {
        try {
            Class cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            Method method = cls.getMethod("getServiceName", new Class[]{String.class, Integer.TYPE});
            String str = (String) method.invoke(cls, new Object[]{"phone", Integer.valueOf(1)});
            return (method == null || str == null || ((TelephonyManager) context.getSystemService(str)) == null) ? false : true;
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x006f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0055 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|11) */
    /* JADX WARNING: Missing block: B:14:0x0074, code skipped:
            return null;
     */
    private static java.util.ArrayList<cn.jiguang.g.c.a> h(android.content.Context r8) {
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = "com.android.internal.telephony.PhoneFactory";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0073 }
        r2 = "getServiceName";
        r3 = 2;
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x0073 }
        r5 = java.lang.String.class;
        r6 = 0;
        r4[r6] = r5;	 Catch:{ Throwable -> 0x0073 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ Throwable -> 0x0073 }
        r7 = 1;
        r4[r7] = r5;	 Catch:{ Throwable -> 0x0073 }
        r2 = r1.getMethod(r2, r4);	 Catch:{ Throwable -> 0x0073 }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0073 }
        r4 = "phone";
        r3[r6] = r4;	 Catch:{ Throwable -> 0x0073 }
        r4 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x0073 }
        r3[r7] = r4;	 Catch:{ Throwable -> 0x0073 }
        r1 = r2.invoke(r1, r3);	 Catch:{ Throwable -> 0x0073 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0073 }
        r1 = r8.getSystemService(r1);	 Catch:{ Throwable -> 0x0073 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Throwable -> 0x0073 }
        r2 = "phone";
        r8 = r8.getSystemService(r2);	 Catch:{ Throwable -> 0x0073 }
        r8 = (android.telephony.TelephonyManager) r8;	 Catch:{ Throwable -> 0x0073 }
        r2 = new cn.jiguang.g.c.a;	 Catch:{ Throwable -> 0x0073 }
        r2.<init>();	 Catch:{ Throwable -> 0x0073 }
        r3 = r8.getSubscriberId();	 Catch:{ Throwable -> 0x0055 }
        r2.b = r3;	 Catch:{ Throwable -> 0x0055 }
        r3 = r8.getDeviceId();	 Catch:{ Throwable -> 0x0055 }
        r2.a = r3;	 Catch:{ Throwable -> 0x0055 }
        r8 = r8.getSimSerialNumber();	 Catch:{ Throwable -> 0x0055 }
        r2.c = r8;	 Catch:{ Throwable -> 0x0055 }
    L_0x0055:
        r0.add(r2);	 Catch:{ Throwable -> 0x0073 }
        r8 = new cn.jiguang.g.c.a;	 Catch:{ Throwable -> 0x0073 }
        r8.<init>();	 Catch:{ Throwable -> 0x0073 }
        r2 = r1.getSubscriberId();	 Catch:{ Throwable -> 0x006f }
        r8.b = r2;	 Catch:{ Throwable -> 0x006f }
        r2 = r1.getDeviceId();	 Catch:{ Throwable -> 0x006f }
        r8.a = r2;	 Catch:{ Throwable -> 0x006f }
        r1 = r1.getSimSerialNumber();	 Catch:{ Throwable -> 0x006f }
        r8.c = r1;	 Catch:{ Throwable -> 0x006f }
    L_0x006f:
        r0.add(r8);	 Catch:{ Throwable -> 0x0073 }
        return r0;
    L_0x0073:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.g.c.b.h(android.content.Context):java.util.ArrayList");
    }
}
