package cn.jpush.android.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import cn.jpush.android.a;
import cn.jpush.android.a.l;
import cn.jpush.android.d.f;
import cn.jpush.android.d.j;
import cn.jpush.android.data.b;
import cn.jpush.android.data.g;
import cn.jpush.android.ui.PopWinActivity;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.Adler32;

public final class c {
    private static boolean a;

    public static int a() {
        int identifier = a.e.getResources().getIdentifier("jpush_notification_icon", "drawable", a.e.getPackageName());
        if (identifier == 0) {
            if (a.b != 0) {
                return a.b;
            }
            try {
                return a.e.getPackageManager().getApplicationInfo(a.e.getPackageName(), 0).icon;
            } catch (Throwable th) {
                f.d("NotificationHelper", "failed to get application info and icon.", th);
            }
        }
        return identifier;
    }

    public static int a(int i) {
        int i2 = 17301618;
        switch (i) {
            case -1:
                try {
                    i = ((Integer) a("R$drawable", new String[]{"jpush_notification_icon"}).get("jpush_notification_icon")).intValue();
                } catch (Exception unused) {
                    i = 0;
                }
                if (i > 0) {
                    i2 = i;
                    break;
                }
                break;
            case 0:
                return 17301647;
            case 2:
                break;
            case 3:
                return 17301567;
            default:
                return 17301586;
        }
        return i2;
    }

    private static int a(b bVar, int i) {
        String str = bVar.c;
        if (!TextUtils.isEmpty(bVar.d)) {
            str = bVar.d;
        }
        return a(str, i);
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            Adler32 adler32 = new Adler32();
            adler32.update(str.getBytes());
            int value = (int) adler32.getValue();
            if (value < 0) {
                value = Math.abs(value);
            }
            value += 13889152 * i;
            if (value < 0) {
                value = Math.abs(value);
            }
            return value;
        }
    }

    @TargetApi(23)
    private static Icon a(String str) {
        try {
            if (new File(str).exists()) {
                return Icon.createWithFilePath(str);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a5 A:{RETURN} */
    /* JADX WARNING: Missing block: B:26:0x009d, code skipped:
            if (cn.jpush.android.d.c.a((java.lang.String) r3, r4) != false) goto L_0x009f;
     */
    private static java.lang.String a(android.content.Context r3, java.lang.String r4) {
        /*
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 != 0) goto L_0x00b2;
    L_0x0006:
        r0 = "http://";
        r0 = r4.startsWith(r0);
        if (r0 != 0) goto L_0x0016;
    L_0x000e:
        r0 = "https://";
        r0 = r4.startsWith(r0);
        if (r0 == 0) goto L_0x00b2;
    L_0x0016:
        r0 = "android.permission.WRITE_EXTERNAL_STORAGE";
        r0 = cn.jpush.android.d.a.b(r3, r0);
        if (r0 == 0) goto L_0x00ab;
    L_0x001e:
        r0 = cn.jpush.android.d.a.a();
        if (r0 != 0) goto L_0x002a;
    L_0x0024:
        r3 = "NotificationHelper";
        r4 = "SDCard is not mounted,need not download pic";
        goto L_0x00af;
    L_0x002a:
        r0 = ".jpg";
        r0 = r4.endsWith(r0);
        if (r0 != 0) goto L_0x0046;
    L_0x0032:
        r0 = ".png";
        r0 = r4.endsWith(r0);
        if (r0 != 0) goto L_0x0046;
    L_0x003a:
        r0 = ".jpeg";
        r0 = r4.endsWith(r0);
        if (r0 == 0) goto L_0x0043;
    L_0x0042:
        goto L_0x0046;
    L_0x0043:
        r3 = "";
        goto L_0x009f;
    L_0x0046:
        r0 = cn.jpush.android.d.a.a(r4);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0050:
        r0 = java.util.UUID.randomUUID();
        r0 = r0.toString();
    L_0x0058:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1.append(r0);
        r0 = ".";
        r0 = r4.lastIndexOf(r0);
        r0 = r4.substring(r0);
        r1.append(r0);
        r0 = r1.toString();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "noti_res";
        r3 = cn.jpush.android.d.c.b(r3, r2);
        r1.append(r3);
        r1.append(r0);
        r3 = r1.toString();
        r0 = new java.io.File;
        r0.<init>(r3);
        r0 = r0.exists();
        if (r0 == 0) goto L_0x0092;
    L_0x0091:
        goto L_0x009f;
    L_0x0092:
        r0 = 2;
        r4 = cn.jpush.android.b.a.a(r4, r0);
        if (r4 == 0) goto L_0x0043;
    L_0x0099:
        r4 = cn.jpush.android.d.c.a(r3, r4);
        if (r4 == 0) goto L_0x0043;
    L_0x009f:
        r4 = android.text.TextUtils.isEmpty(r3);
        if (r4 != 0) goto L_0x00a6;
    L_0x00a5:
        return r3;
    L_0x00a6:
        r3 = "NotificationHelper";
        r4 = "Get network picture failed.";
        goto L_0x00af;
    L_0x00ab:
        r3 = "NotificationHelper";
        r4 = "No permission to write resource to storage";
    L_0x00af:
        cn.jpush.android.d.f.c(r3, r4);
    L_0x00b2:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.c.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private static HashMap<String, Integer> a(String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("parameter resType or fieldNames error.");
        }
        HashMap hashMap = new HashMap();
        try {
            String packageName = a.e.getPackageName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(packageName);
            stringBuilder.append(".R");
            for (Class cls : Class.forName(stringBuilder.toString()).getDeclaredClasses()) {
                if (cls.getName().contains(str)) {
                    for (int i = 0; i <= 0; i++) {
                        packageName = strArr[0];
                        hashMap.put(packageName, Integer.valueOf(cls.getDeclaredField(packageName).getInt(packageName)));
                    }
                    return hashMap;
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e9  */
    public static java.util.Map<java.lang.String, java.lang.String> a(cn.jpush.android.data.b r4) {
        /*
        r0 = new java.util.HashMap;
        r0.<init>();
        if (r4 == 0) goto L_0x00f0;
    L_0x0007:
        r1 = "cn.jpush.android.MSG_ID";
        r2 = r4.c;
        r0.put(r1, r2);
        r1 = "cn.jpush.android.ALERT";
        r2 = r4.v;
        r0.put(r1, r2);
        r1 = "cn.jpush.android.ALERT_TYPE";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r4.l;
        r2.append(r3);
        r2 = r2.toString();
        r0.put(r1, r2);
        r1 = r4.u;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0037;
    L_0x0030:
        r1 = "cn.jpush.android.NOTIFICATION_CONTENT_TITLE";
        r2 = r4.u;
        r0.put(r1, r2);
    L_0x0037:
        r1 = r4.M;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0046;
    L_0x003f:
        r1 = "cn.jpush.android.NOTIFICATION_URL";
        r2 = r4.M;
        r0.put(r1, r2);
    L_0x0046:
        r1 = r4.n;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x0055;
    L_0x004e:
        r1 = "cn.jpush.android.EXTRA";
        r2 = r4.n;
        r0.put(r1, r2);
    L_0x0055:
        r1 = r4.w;
        r2 = 1;
        if (r1 != r2) goto L_0x006a;
    L_0x005a:
        r1 = r4.x;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x006a;
    L_0x0062:
        r1 = "cn.jpush.android.BIG_TEXT";
        r2 = r4.x;
    L_0x0066:
        r0.put(r1, r2);
        goto L_0x008e;
    L_0x006a:
        r1 = r4.w;
        r2 = 2;
        if (r1 != r2) goto L_0x007c;
    L_0x006f:
        r1 = r4.z;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x007c;
    L_0x0077:
        r1 = "cn.jpush.android.INBOX";
        r2 = r4.z;
        goto L_0x0066;
    L_0x007c:
        r1 = r4.w;
        r2 = 3;
        if (r1 != r2) goto L_0x008e;
    L_0x0081:
        r1 = r4.y;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x008e;
    L_0x0089:
        r1 = "cn.jpush.android.BIG_PIC_PATH";
        r2 = r4.y;
        goto L_0x0066;
    L_0x008e:
        r1 = r4.A;
        if (r1 == 0) goto L_0x00a5;
    L_0x0092:
        r1 = "cn.jpush.android.NOTI_PRIORITY";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r4.A;
        r2.append(r3);
        r2 = r2.toString();
        r0.put(r1, r2);
    L_0x00a5:
        r1 = r4.B;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00b4;
    L_0x00ad:
        r1 = "cn.jpush.android.NOTI_CATEGORY";
        r2 = r4.B;
        r0.put(r1, r2);
    L_0x00b4:
        r1 = r4.K;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00c3;
    L_0x00bc:
        r1 = "cn.jpush.android.NOTIFICATION_SMALL_ICON";
        r2 = r4.K;
        r0.put(r1, r2);
    L_0x00c3:
        r1 = r4.L;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00d2;
    L_0x00cb:
        r1 = "cn.jpush.android.NOTIFICATION_LARGE_ICON";
        r2 = r4.L;
        r0.put(r1, r2);
    L_0x00d2:
        r1 = r4.J;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00e1;
    L_0x00da:
        r1 = "cn.jpush.android.NOTIFICATION_SOURCE";
        r2 = r4.J;
        r0.put(r1, r2);
    L_0x00e1:
        r1 = r4.P;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00f0;
    L_0x00e9:
        r1 = "cn.jpush.android.NOTIFICATION_TARGET_PKGNAME";
        r4 = r4.P;
        r0.put(r1, r4);
    L_0x00f0:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.c.a(cn.jpush.android.data.b):java.util.Map");
    }

    public static void a(Builder builder, String str, CharSequence charSequence, int i, int i2) {
        if (a(str, charSequence, i, i2)) {
            try {
                j.a(builder, "setChannelId", new Class[]{String.class}, new String[]{str});
            } catch (Throwable th) {
                StringBuilder stringBuilder = new StringBuilder("setChannelId error");
                stringBuilder.append(th);
                f.c("NotificationHelper", stringBuilder.toString());
            }
        }
    }

    public static void a(Notification notification, Context context, String str, String str2, PendingIntent pendingIntent) {
        try {
            Class.forName("android.app.Notification").getDeclaredMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class}).invoke(notification, new Object[]{context, str, str2, null});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(Context context, int i) {
        if (i > 0) {
            for (int i2 = 0; i2 < i; i2++) {
                Integer valueOf = Integer.valueOf(l.a());
                if (valueOf.intValue() != 0) {
                    b(context, valueOf.intValue());
                }
            }
        }
    }

    public static void a(Context context, int i, boolean z) {
        if (!l.b(i)) {
            l.a(i);
        }
        if (l.b() > cn.jpush.android.b.a(context)) {
            i = l.a();
            if (i != 0) {
                b(context, i);
            }
        }
    }

    public static void a(Context context, b bVar) {
        JCoreInterface.asyncExecute(new d(context, bVar), new int[0]);
    }

    public static void a(Context context, b bVar, int i) {
        if (context == null) {
            context = a.e;
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(a(bVar, 0));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004f A:{Catch:{ Throwable -> 0x0074 }} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A:{Catch:{ Throwable -> 0x0074 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0031 */
    /* JADX WARNING: Failed to process nested try/catch */
    @android.annotation.TargetApi(11)
    public static void a(android.content.Context r5, java.lang.String r6, android.app.Notification.Builder r7) {
        /*
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = "";
        r1 = 0;
        r2 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x0031 }
        if (r2 != 0) goto L_0x0031;
    L_0x0010:
        r2 = cn.jpush.android.a.i.a(r6);	 Catch:{ Throwable -> 0x0031 }
        if (r2 == 0) goto L_0x001e;
    L_0x0016:
        r2 = cn.jpush.android.a.e;	 Catch:{ Throwable -> 0x0031 }
        r6 = a(r2, r6);	 Catch:{ Throwable -> 0x0031 }
        r0 = r6;
        goto L_0x0031;
    L_0x001e:
        r2 = cn.jpush.android.a.e;	 Catch:{ Throwable -> 0x0031 }
        r2 = r2.getResources();	 Catch:{ Throwable -> 0x0031 }
        r3 = "drawable";
        r4 = cn.jpush.android.a.e;	 Catch:{ Throwable -> 0x0031 }
        r4 = r4.getPackageName();	 Catch:{ Throwable -> 0x0031 }
        r6 = r2.getIdentifier(r6, r3, r4);	 Catch:{ Throwable -> 0x0031 }
        r1 = r6;
    L_0x0031:
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0074 }
        r2 = 23;
        r3 = 0;
        if (r6 < r2) goto L_0x004f;
    L_0x0038:
        if (r1 == 0) goto L_0x003f;
    L_0x003a:
        r3 = android.graphics.drawable.Icon.createWithResource(r5, r1);	 Catch:{ Throwable -> 0x0074 }
        goto L_0x0049;
    L_0x003f:
        r5 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0074 }
        if (r5 != 0) goto L_0x0049;
    L_0x0045:
        r3 = a(r0);	 Catch:{ Throwable -> 0x0074 }
    L_0x0049:
        if (r3 == 0) goto L_0x0074;
    L_0x004b:
        r7.setLargeIcon(r3);	 Catch:{ Throwable -> 0x0074 }
        return;
    L_0x004f:
        if (r1 == 0) goto L_0x005a;
    L_0x0051:
        r5 = r5.getResources();	 Catch:{ Throwable -> 0x0074 }
        r3 = android.graphics.BitmapFactory.decodeResource(r5, r1);	 Catch:{ Throwable -> 0x0074 }
        goto L_0x006f;
    L_0x005a:
        r5 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0074 }
        if (r5 != 0) goto L_0x006f;
    L_0x0060:
        r5 = new java.io.File;	 Catch:{ Throwable -> 0x0074 }
        r5.<init>(r0);	 Catch:{ Throwable -> 0x0074 }
        r5 = r5.exists();	 Catch:{ Throwable -> 0x0074 }
        if (r5 == 0) goto L_0x006f;
    L_0x006b:
        r3 = android.graphics.BitmapFactory.decodeFile(r0);	 Catch:{ Throwable -> 0x0074 }
    L_0x006f:
        if (r3 == 0) goto L_0x0074;
    L_0x0071:
        r7.setLargeIcon(r3);	 Catch:{ Throwable -> 0x0074 }
    L_0x0074:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.c.a(android.content.Context, java.lang.String, android.app.Notification$Builder):void");
    }

    public static void a(Context context, Map<String, String> map, int i, String str, String str2, b bVar) {
        Intent intent = new Intent(JPushInterface.ACTION_NOTIFICATION_RECEIVED);
        StringBuilder stringBuilder;
        try {
            f.a("NotificationHelper", "Send push received broadcast to developer defined receiver");
            a(intent, (Map) map, i);
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra(JPushInterface.EXTRA_NOTIFICATION_DEVELOPER_ARG0, str);
            }
            if (bVar.a() && (bVar instanceof g)) {
                g gVar = (g) bVar;
                if (!(gVar.S == 0 || gVar.S == 4)) {
                    if (gVar.X != null && gVar.X.startsWith("file://")) {
                        gVar.X = gVar.X.replaceFirst("file://", "");
                        intent.putExtra(JPushInterface.EXTRA_RICHPUSH_HTML_PATH, gVar.X);
                    }
                    if (gVar.U != null && gVar.U.size() > 0) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        str = cn.jpush.android.d.c.b(context, bVar.c);
                        Iterator it = gVar.U.iterator();
                        while (it.hasNext()) {
                            String str3 = (String) it.next();
                            if (str3.startsWith("http://")) {
                                str3 = cn.jpush.android.d.c.a(str3);
                            }
                            if (TextUtils.isEmpty(stringBuilder2.toString())) {
                                stringBuilder2.append(str);
                            } else {
                                stringBuilder2.append(",");
                                stringBuilder2.append(str);
                            }
                            stringBuilder2.append(str3);
                        }
                        intent.putExtra(JPushInterface.EXTRA_RICHPUSH_HTML_RES, stringBuilder2.toString());
                    }
                }
            }
            intent.addCategory(str2);
            intent.setPackage(context.getPackageName());
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(".permission.JPUSH_MESSAGE");
            context.sendBroadcast(intent, stringBuilder.toString());
        } catch (Throwable th) {
            StringBuilder stringBuilder3 = new StringBuilder("sendNotificationReceivedBroadcast error:");
            stringBuilder3.append(th.getMessage());
            f.c("NotificationHelper", stringBuilder3.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append(".permission.JPUSH_MESSAGE");
            cn.jpush.android.d.a.b(context, intent, stringBuilder.toString());
        }
    }

    public static void a(Context context, boolean z) {
        if (z) {
            while (true) {
                Integer valueOf = Integer.valueOf(l.a());
                if (valueOf.intValue() != 0) {
                    b(context, valueOf.intValue());
                } else {
                    return;
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("action", "intent.MULTI_PROCESS");
        bundle.putInt("multi_type", 10);
        JCoreInterface.sendAction(context, a.a, bundle);
    }

    public static void a(Intent intent, Map<String, String> map, int i) {
        for (String str : map.keySet()) {
            if (!("cn.jpush.android.NOTIFICATION_SOURCE".equals(str) || "cn.jpush.android.NOTIFICATION_SMALL_ICON".equals(str) || "cn.jpush.android.NOTIFICATION_TARGET_PKGNAME".equals(str))) {
                intent.putExtra(str, (String) map.get(str));
            }
        }
        if (i != 0) {
            intent.putExtra(JPushInterface.EXTRA_NOTIFICATION_ID, i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e A:{SYNTHETIC, Splitter:B:16:0x003e} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004e  */
    @android.annotation.TargetApi(11)
    public static boolean a(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, android.app.Notification.Builder r9) {
        /*
        r0 = "";
        r1 = 23;
        r2 = 0;
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x0036 }
        if (r6 != 0) goto L_0x0036;
    L_0x000b:
        r6 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x0036 }
        if (r6 != 0) goto L_0x0036;
    L_0x0011:
        r6 = cn.jpush.android.a.i.a(r8);	 Catch:{ Throwable -> 0x0036 }
        if (r6 == 0) goto L_0x0023;
    L_0x0017:
        r6 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0036 }
        if (r6 < r1) goto L_0x0036;
    L_0x001b:
        r6 = cn.jpush.android.a.e;	 Catch:{ Throwable -> 0x0036 }
        r6 = a(r6, r8);	 Catch:{ Throwable -> 0x0036 }
        r0 = r6;
        goto L_0x0036;
    L_0x0023:
        r6 = cn.jpush.android.a.e;	 Catch:{ Throwable -> 0x0036 }
        r6 = r6.getResources();	 Catch:{ Throwable -> 0x0036 }
        r3 = "drawable";
        r4 = cn.jpush.android.a.e;	 Catch:{ Throwable -> 0x0036 }
        r4 = r4.getPackageName();	 Catch:{ Throwable -> 0x0036 }
        r6 = r6.getIdentifier(r8, r3, r4);	 Catch:{ Throwable -> 0x0036 }
        goto L_0x0037;
    L_0x0036:
        r6 = r2;
    L_0x0037:
        r8 = android.text.TextUtils.isEmpty(r0);
        r3 = 1;
        if (r8 != 0) goto L_0x004c;
    L_0x003e:
        r8 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x004c }
        if (r8 < r1) goto L_0x004c;
    L_0x0042:
        r8 = a(r0);	 Catch:{ Throwable -> 0x004c }
        if (r8 == 0) goto L_0x004c;
    L_0x0048:
        r9.setSmallIcon(r8);	 Catch:{ Throwable -> 0x004c }
        return r3;
    L_0x004c:
        if (r6 == 0) goto L_0x0052;
    L_0x004e:
        r9.setSmallIcon(r6);
        return r3;
    L_0x0052:
        if (r6 != 0) goto L_0x0086;
    L_0x0054:
        r6 = android.text.TextUtils.isEmpty(r7);
        if (r6 != 0) goto L_0x0082;
    L_0x005a:
        r6 = r5.getPackageName();
        r6 = r7.equals(r6);
        if (r6 != 0) goto L_0x0082;
    L_0x0064:
        r6 = android.os.Build.VERSION.SDK_INT;
        if (r6 < r1) goto L_0x0081;
    L_0x0068:
        r6 = cn.jpush.android.d.a.e(r5, r7);
        if (r6 != 0) goto L_0x006f;
    L_0x006e:
        return r2;
    L_0x006f:
        r5 = b(r5, r7);
        if (r5 != 0) goto L_0x0076;
    L_0x0075:
        return r2;
    L_0x0076:
        r5 = android.graphics.drawable.Icon.createWithBitmap(r5);	 Catch:{ Throwable -> 0x0081 }
        if (r5 != 0) goto L_0x007d;
    L_0x007c:
        return r2;
    L_0x007d:
        r9.setSmallIcon(r5);	 Catch:{ Throwable -> 0x0081 }
        return r3;
    L_0x0081:
        return r2;
    L_0x0082:
        r6 = a();
    L_0x0086:
        if (r6 == 0) goto L_0x008c;
    L_0x0088:
        r9.setSmallIcon(r6);
        return r3;
    L_0x008c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.c.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, android.app.Notification$Builder):boolean");
    }

    private static boolean a(String str, CharSequence charSequence, int i, int i2) {
        StringBuilder stringBuilder;
        if (a) {
            return true;
        }
        if (VERSION.SDK_INT < 26) {
            return false;
        }
        String str2;
        if (a.e == null) {
            str = "NotificationHelper";
            str2 = "ApplicationContext is null!";
        } else if (a.e.getApplicationInfo().targetSdkVersion < 26) {
            return false;
        } else {
            NotificationManager notificationManager = (NotificationManager) a.e.getSystemService("notification");
            if (notificationManager == null) {
                str = "NotificationHelper";
                str2 = "NotificationManager is null!";
            } else {
                switch (i) {
                    case -2:
                        i = 1;
                        break;
                    case -1:
                        i = 2;
                        break;
                    case 1:
                        i = 4;
                        break;
                    case 2:
                        i = 5;
                        break;
                    default:
                        i = 3;
                        break;
                }
                try {
                    try {
                        Constructor constructor = Class.forName("android.app.NotificationChannel").getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE});
                        constructor.setAccessible(true);
                        try {
                            Object newInstance = constructor.newInstance(new Object[]{str, charSequence, Integer.valueOf(i)});
                            if (newInstance == null) {
                                f.d("NotificationHelper", "new NotificationChannel fail, return");
                                return false;
                            }
                            Boolean[] boolArr = new Boolean[]{Boolean.valueOf(true)};
                            Class[] clsArr = new Class[]{Boolean.TYPE};
                            if ((i2 & 4) != 0) {
                                try {
                                    j.a(newInstance, "enableLights", clsArr, boolArr);
                                } catch (Exception e) {
                                    StringBuilder stringBuilder2 = new StringBuilder("enableLights fail:");
                                    stringBuilder2.append(e.toString());
                                    f.c("NotificationHelper", stringBuilder2.toString());
                                }
                            }
                            if ((i2 & 2) != 0) {
                                try {
                                    j.a(newInstance, "enableVibration", clsArr, boolArr);
                                } catch (Exception e2) {
                                    StringBuilder stringBuilder3 = new StringBuilder("enableLights fail:");
                                    stringBuilder3.append(e2.toString());
                                    f.c("NotificationHelper", stringBuilder3.toString());
                                }
                            }
                            try {
                                j.a(notificationManager, "createNotificationChannel", new Class[]{r5}, new Object[]{newInstance});
                            } catch (Exception e3) {
                                stringBuilder = new StringBuilder("createNotificationChannel fail:");
                                stringBuilder.append(e3.toString());
                                f.d("NotificationHelper", stringBuilder.toString());
                            }
                            a = true;
                            return true;
                        } catch (InstantiationException e4) {
                            e4.printStackTrace();
                            return false;
                        } catch (IllegalAccessException e5) {
                            e5.printStackTrace();
                            return false;
                        }
                    } catch (InvocationTargetException e6) {
                        stringBuilder = new StringBuilder("new NotificationChannel fail:");
                        stringBuilder.append(e6.toString());
                        f.d("NotificationHelper", stringBuilder.toString());
                        return false;
                    }
                } catch (NoSuchMethodException e7) {
                    stringBuilder = new StringBuilder("new NotificationChannel fail:");
                    stringBuilder.append(e7.toString());
                    f.d("NotificationHelper", stringBuilder.toString());
                    return false;
                } catch (Throwable th) {
                    stringBuilder = new StringBuilder("new NotificationChannel fail:");
                    stringBuilder.append(th.toString());
                    f.d("NotificationHelper", stringBuilder.toString());
                    return false;
                }
            }
        }
        f.d(str, str2);
        return false;
    }

    private static synchronized Bitmap b(Context context, String str) {
        Bitmap bitmap;
        synchronized (c.class) {
            try {
                PackageManager packageManager = context.getApplicationContext().getPackageManager();
                bitmap = ((BitmapDrawable) packageManager.getApplicationIcon(packageManager.getApplicationInfo(str, 0))).getBitmap();
            } catch (Throwable unused) {
                return null;
            }
        }
        return bitmap;
    }

    private static void b(Context context, int i) {
        if (context == null) {
            context = a.e;
        }
        ((NotificationManager) context.getSystemService("notification")).cancel(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a4  */
    public static void b(android.content.Context r14, cn.jpush.android.data.b r15) {
        /*
        r0 = 0;
        r3 = a(r15, r0);
        r1 = r15.i;
        if (r1 == 0) goto L_0x0223;
    L_0x0009:
        r1 = r15.f;
        if (r1 == 0) goto L_0x0223;
    L_0x000d:
        r1 = "notification";
        r1 = r14.getSystemService(r1);
        r1 = (android.app.NotificationManager) r1;
        r2 = r15 instanceof cn.jpush.android.data.g;
        if (r2 == 0) goto L_0x0223;
    L_0x0019:
        r5 = a(r15);
        r2 = r15.o;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x002b;
    L_0x0025:
        r2 = r14.getPackageName();
    L_0x0029:
        r8 = r2;
        goto L_0x002e;
    L_0x002b:
        r2 = r15.o;
        goto L_0x0029;
    L_0x002e:
        r2 = r15.v;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x003f;
    L_0x0036:
        r6 = 0;
        r7 = "";
        r4 = r14;
        r9 = r15;
        a(r4, r5, r6, r7, r8, r9);
        return;
    L_0x003f:
        r2 = r15.g;
        r2 = cn.jpush.android.api.JPushInterface.b(r2);
        r4 = r15.J;
        r4 = android.text.TextUtils.isEmpty(r4);
        r6 = 0;
        if (r4 != 0) goto L_0x0063;
    L_0x004e:
        r2 = r15.P;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x005e;
    L_0x0056:
        r15 = r15.c;
        r0 = 985; // 0x3d9 float:1.38E-42 double:4.867E-321;
        cn.jpush.android.a.e.a(r15, r0, r6, r14);
        return;
    L_0x005e:
        r2 = new cn.jpush.android.api.DefaultPushNotificationBuilder;
        r2.<init>();
    L_0x0063:
        r4 = r2.getDeveloperArg0();
        r2 = r2.buildNotification(r5);
        if (r2 == 0) goto L_0x021c;
    L_0x006d:
        r7 = r15.v;
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 != 0) goto L_0x021c;
    L_0x0075:
        r7 = r15.a();
        r9 = 1;
        if (r7 != 0) goto L_0x01b1;
    L_0x007c:
        r7 = cn.jpush.android.service.PushReceiver.class;
        r7 = cn.jpush.android.d.a.a(r14, r7);
        if (r7 == 0) goto L_0x00e4;
    L_0x0084:
        r7 = new android.content.Intent;
        r10 = new java.lang.StringBuilder;
        r11 = "cn.jpush.android.intent.NOTIFICATION_OPENED_PROXY.";
        r10.<init>(r11);
        r11 = java.util.UUID.randomUUID();
        r11 = r11.toString();
        r10.append(r11);
        r10 = r10.toString();
        r7.<init>(r10);
        r10 = "cn.jpush.android.NOTIFICATION_TYPE";
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = r15.h;
        r11.append(r12);
        r11 = r11.toString();
        r7.putExtra(r10, r11);
        r10 = "NotificationHelper";
        r11 = new java.lang.StringBuilder;
        r12 = "running flag:";
        r11.<init>(r12);
        r12 = cn.jiguang.api.JCoreInterface.getRuningFlag();
        r11.append(r12);
        r11 = r11.toString();
        cn.jpush.android.d.f.a(r10, r11);
        r10 = cn.jiguang.api.JCoreInterface.getRuningFlag();
        if (r10 == 0) goto L_0x00dc;
    L_0x00cf:
        r10 = cn.jpush.android.ui.PopWinActivity.class;
        r7.setClass(r14, r10);
        r10 = "isNotification";
        r7.putExtra(r10, r9);
        r10 = r9;
        goto L_0x015e;
    L_0x00dc:
        r10 = cn.jpush.android.service.PushReceiver.class;
        r7.setClass(r14, r10);
    L_0x00e1:
        r10 = r0;
        goto L_0x015e;
    L_0x00e4:
        r7 = cn.jpush.android.ui.PopWinActivity.class;
        r7 = cn.jpush.android.d.a.b(r14, r7);
        if (r7 == 0) goto L_0x011b;
    L_0x00ec:
        r7 = new android.content.Intent;
        r10 = new java.lang.StringBuilder;
        r11 = "cn.jpush.android.intent.NOTIFICATION_OPENED_PROXY.";
        r10.<init>(r11);
        r11 = java.util.UUID.randomUUID();
        r11 = r11.toString();
        r10.append(r11);
        r10 = r10.toString();
        r7.<init>(r10);
        r10 = "cn.jpush.android.NOTIFICATION_TYPE";
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = r15.h;
        r11.append(r12);
        r11 = r11.toString();
        r7.putExtra(r10, r11);
        goto L_0x00cf;
    L_0x011b:
        r7 = r15.J;
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 == 0) goto L_0x01a9;
    L_0x0123:
        r7 = new android.content.Intent;
        r10 = "cn.jpush.android.intent.NOTIFICATION_OPENED";
        r7.<init>(r10);
        r7.addCategory(r8);
        r10 = android.os.Build.VERSION.SDK_INT;
        r11 = 25;
        if (r10 >= r11) goto L_0x0139;
    L_0x0133:
        r10 = android.os.Build.VERSION.SDK_INT;
        r11 = 21;
        if (r10 >= r11) goto L_0x00e1;
    L_0x0139:
        r10 = "cn.jpush.android.intent.NOTIFICATION_OPENED";
        r11 = r7.getAction();
        r10 = r10.equals(r11);
        if (r10 == 0) goto L_0x00e1;
    L_0x0145:
        r10 = cn.jpush.android.d.a.a(r14, r7, r6);
        r11 = r10.isEmpty();
        if (r11 != 0) goto L_0x00e1;
    L_0x014f:
        r11 = new android.content.ComponentName;
        r10 = r10.get(r0);
        r10 = (java.lang.String) r10;
        r11.<init>(r14, r10);
        r7.setComponent(r11);
        goto L_0x00e1;
    L_0x015e:
        r11 = "sdktype";
        r12 = cn.jpush.android.a.a;
        r7.putExtra(r11, r12);
        r11 = "platform";
        r12 = r15.e;
        r7.putExtra(r11, r12);
        a(r7, r5, r3);
        r11 = "key_show_entity";
        r7.putExtra(r11, r15);
        r11 = "app";
        r7.putExtra(r11, r8);
        r11 = android.text.TextUtils.isEmpty(r4);
        if (r11 != 0) goto L_0x0184;
    L_0x017f:
        r11 = "cn.jpush.android.NOTIFICATION_DEVELOPER_ARG0";
        r7.putExtra(r11, r4);
    L_0x0184:
        r11 = "NotificationHelper";
        r12 = new java.lang.StringBuilder;
        r13 = "notification intent component=";
        r12.<init>(r13);
        r13 = r7.getComponent();
        r12.append(r13);
        r12 = r12.toString();
        cn.jpush.android.d.f.a(r11, r12);
        r11 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r10 == 0) goto L_0x01a4;
    L_0x019f:
        r7 = android.app.PendingIntent.getActivity(r14, r0, r7, r11);
        goto L_0x01bd;
    L_0x01a4:
        r7 = android.app.PendingIntent.getBroadcast(r14, r0, r7, r11);
        goto L_0x01bd;
    L_0x01a9:
        r15 = r15.c;
        r0 = 984; // 0x3d8 float:1.379E-42 double:4.86E-321;
        cn.jpush.android.a.e.a(r15, r0, r6, r14);
        return;
    L_0x01b1:
        r7 = c(r14, r15);
        if (r7 == 0) goto L_0x0223;
    L_0x01b7:
        r10 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
        r7 = android.app.PendingIntent.getActivity(r14, r3, r7, r10);
    L_0x01bd:
        r2.contentIntent = r7;
        r7 = r15.g;
        r7 = cn.jpush.android.api.JPushInterface.a(r7);
        if (r7 != 0) goto L_0x01dc;
    L_0x01c7:
        r7 = r15.h;
        if (r9 != r7) goto L_0x01cd;
    L_0x01cb:
        r15.t = r9;
    L_0x01cd:
        r7 = r15.t;
        switch(r7) {
            case 0: goto L_0x01d2;
            case 1: goto L_0x01d7;
            case 2: goto L_0x01d4;
            default: goto L_0x01d2;
        };
    L_0x01d2:
        r7 = r9;
        goto L_0x01d9;
    L_0x01d4:
        r7 = 32;
        goto L_0x01d9;
    L_0x01d7:
        r7 = 16;
    L_0x01d9:
        r7 = r7 | r9;
        r2.flags = r7;
    L_0x01dc:
        r7 = cn.jpush.android.d.a.d(r14);
        if (r7 == 0) goto L_0x01e4;
    L_0x01e2:
        r2.defaults = r0;
    L_0x01e4:
        if (r2 == 0) goto L_0x01fc;
    L_0x01e6:
        r0 = "NotificationHelper";
        r7 = new java.lang.StringBuilder;
        r10 = "notification notify:";
        r7.<init>(r10);
        r7.append(r3);
        r7 = r7.toString();
        cn.jpush.android.d.f.a(r0, r7);
        r1.notify(r3, r2);
    L_0x01fc:
        r0 = r15.h;
        if (r9 == r0) goto L_0x020e;
    L_0x0200:
        r0 = r15.e;
        if (r0 != 0) goto L_0x020e;
    L_0x0204:
        a(r14, r3, r9);
        r0 = r15.c;
        r1 = 1018; // 0x3fa float:1.427E-42 double:5.03E-321;
        cn.jpush.android.a.e.a(r0, r1, r6, r14);
    L_0x020e:
        if (r15 == 0) goto L_0x0223;
    L_0x0210:
        r0 = r15.e;
        if (r0 != 0) goto L_0x0223;
    L_0x0214:
        r1 = r14;
        r2 = r5;
        r5 = r8;
        r6 = r15;
        a(r1, r2, r3, r4, r5, r6);
        return;
    L_0x021c:
        r14 = "NotificationHelper";
        r15 = "Got NULL notification. Give up to show.";
        cn.jpush.android.d.f.c(r14, r15);
    L_0x0223:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.api.c.b(android.content.Context, cn.jpush.android.data.b):void");
    }

    public static Intent c(Context context, b bVar) {
        if (context == null) {
            f.c("NotificationHelper", "context was null");
            return null;
        }
        if (bVar != null) {
            g gVar = (g) bVar;
            if (!(3 == gVar.S || 4 == gVar.S || gVar.S == 0 || 2 != gVar.S)) {
                Intent intent = new Intent(context, PopWinActivity.class);
                intent.putExtra("body", bVar);
                intent.addFlags(335544320);
                return intent;
            }
        }
        return cn.jpush.android.d.a.a(context, bVar, false);
    }
}
