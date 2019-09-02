package cn.jpush.android.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.a.e;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.d.a;
import cn.jpush.android.d.f;

public final class d {
    private static d a;

    private d() {
    }

    public static d a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    public static void a(Context context, Intent intent) {
        String stringExtra;
        Throwable th;
        StringBuilder stringBuilder;
        String stringExtra2 = intent.getStringExtra(JPushInterface.EXTRA_MSG_ID);
        if (!TextUtils.isEmpty(stringExtra2)) {
            stringExtra = intent.getStringExtra(JPushInterface.EXTRA_NOTI_TYPE);
            byte b = (byte) 0;
            byte byteExtra = intent.getByteExtra("platform", (byte) 0);
            if (stringExtra != null && "1".equals(stringExtra)) {
                b = (byte) 1;
            }
            if ((byte) 1 != b) {
                if (byteExtra == (byte) 0) {
                    e.a(stringExtra2, 1000, null, context);
                } else {
                    JPushInterface.reportNotificationOpened(context, stringExtra2, byteExtra);
                }
            }
        }
        int b2 = b(context, intent);
        if (b2 != 2) {
            boolean a = a.a(context, JPushInterface.ACTION_NOTIFICATION_OPENED, true);
            if (b2 == 1 && !a) {
                f.a("PushReceiverCore", "No ACTION_NOTIFICATION_OPENED defined in manifest");
            } else if (a) {
                Intent intent2 = new Intent(JPushInterface.ACTION_NOTIFICATION_OPENED);
                stringExtra = "";
                StringBuilder stringBuilder2;
                try {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        intent2.putExtras(extras);
                    }
                    String stringExtra3 = intent.getStringExtra("app");
                    try {
                        stringExtra = TextUtils.isEmpty(stringExtra3) ? context.getPackageName() : stringExtra3;
                        intent2.addCategory(stringExtra);
                        intent2.setPackage(context.getPackageName());
                        StringBuilder stringBuilder3 = new StringBuilder("Send broadcast to app: ");
                        stringBuilder3.append(stringExtra);
                        stringBuilder3.append(" action=");
                        stringBuilder3.append(intent2.getAction());
                        f.a("PushReceiverCore", stringBuilder3.toString());
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(stringExtra);
                        stringBuilder2.append(".permission.JPUSH_MESSAGE");
                        context.sendBroadcast(intent2, stringBuilder2.toString());
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        stringExtra = stringExtra3;
                        th = th3;
                        stringBuilder = new StringBuilder("onNotificationOpen sendBrocat error:");
                        stringBuilder.append(th.getMessage());
                        f.c("PushReceiverCore", stringBuilder.toString());
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(stringExtra);
                        stringBuilder2.append(".permission.JPUSH_MESSAGE");
                        a.b(context, intent2, stringBuilder2.toString());
                    }
                } catch (Throwable th4) {
                    th = th4;
                    stringBuilder = new StringBuilder("onNotificationOpen sendBrocat error:");
                    stringBuilder.append(th.getMessage());
                    f.c("PushReceiverCore", stringBuilder.toString());
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(stringExtra);
                    stringBuilder2.append(".permission.JPUSH_MESSAGE");
                    a.b(context, intent2, stringBuilder2.toString());
                }
            } else {
                f.a("PushReceiverCore", "No ACTION_NOTIFICATION_OPENED defined in manifest, open the default main activity");
                a.d(context, null);
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:44:0x0070=Splitter:B:44:0x0070, B:29:0x0048=Splitter:B:29:0x0048} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x0070 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0048 */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x007d A:{SYNTHETIC, Splitter:B:53:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0090  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:38|39|40|41|44|45|46) */
    private static int b(android.content.Context r5, android.content.Intent r6) {
        /*
        r0 = 0;
        r1 = "key_show_entity";
        r6 = r6.getSerializableExtra(r1);	 Catch:{ Throwable -> 0x0010 }
        if (r6 == 0) goto L_0x0010;
    L_0x0009:
        r1 = r6 instanceof cn.jpush.android.data.g;	 Catch:{ Throwable -> 0x0010 }
        if (r1 == 0) goto L_0x0010;
    L_0x000d:
        r6 = (cn.jpush.android.data.g) r6;	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r6 = r0;
    L_0x0011:
        r1 = 0;
        if (r6 == 0) goto L_0x0094;
    L_0x0014:
        r2 = r6.M;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x001d;
    L_0x001c:
        return r1;
    L_0x001d:
        r2 = r6.J;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0033;
    L_0x0025:
        r2 = r6.P;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 == 0) goto L_0x0033;
    L_0x002d:
        r2 = r5.getPackageName();
        r6.P = r2;
    L_0x0033:
        r2 = r6.P;	 Catch:{ Throwable -> 0x007a }
        r2 = cn.jpush.android.d.a.e(r5, r2);	 Catch:{ Throwable -> 0x007a }
        r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        if (r2 == 0) goto L_0x0050;
    L_0x003d:
        r2 = r6.M;	 Catch:{ Throwable -> 0x0047 }
        r1 = android.content.Intent.parseUri(r2, r1);	 Catch:{ Throwable -> 0x0047 }
        r1.setFlags(r3);	 Catch:{ Throwable -> 0x0048 }
        goto L_0x007b;
    L_0x0047:
        r1 = r0;
    L_0x0048:
        r2 = r6.c;	 Catch:{ Throwable -> 0x007b }
        r3 = 992; // 0x3e0 float:1.39E-42 double:4.9E-321;
    L_0x004c:
        cn.jpush.android.a.e.a(r2, r3, r0, r5);	 Catch:{ Throwable -> 0x007b }
        goto L_0x007b;
    L_0x0050:
        r2 = r6.c;	 Catch:{ Throwable -> 0x007a }
        r4 = 988; // 0x3dc float:1.384E-42 double:4.88E-321;
        cn.jpush.android.a.e.a(r2, r4, r0, r5);	 Catch:{ Throwable -> 0x007a }
        r2 = r6.N;	 Catch:{ Throwable -> 0x007a }
        switch(r2) {
            case 0: goto L_0x0075;
            case 1: goto L_0x005d;
            default: goto L_0x005c;
        };	 Catch:{ Throwable -> 0x007a }
    L_0x005c:
        goto L_0x007a;
    L_0x005d:
        r2 = r6.O;	 Catch:{ Throwable -> 0x007a }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x007a }
        if (r2 != 0) goto L_0x007a;
    L_0x0065:
        r2 = r6.O;	 Catch:{ Throwable -> 0x006f }
        r1 = android.content.Intent.parseUri(r2, r1);	 Catch:{ Throwable -> 0x006f }
        r1.setFlags(r3);	 Catch:{ Throwable -> 0x0070 }
        goto L_0x007b;
    L_0x006f:
        r1 = r0;
    L_0x0070:
        r2 = r6.c;	 Catch:{ Throwable -> 0x007b }
        r3 = 991; // 0x3df float:1.389E-42 double:4.896E-321;
        goto L_0x004c;
    L_0x0075:
        r1 = cn.jpush.android.d.a.b(r5);	 Catch:{ Throwable -> 0x007a }
        goto L_0x007b;
    L_0x007a:
        r1 = r0;
    L_0x007b:
        if (r1 == 0) goto L_0x0088;
    L_0x007d:
        r5.startActivity(r1);	 Catch:{ Throwable -> 0x0081 }
        goto L_0x0088;
    L_0x0081:
        r1 = r6.c;
        r2 = 987; // 0x3db float:1.383E-42 double:4.876E-321;
        cn.jpush.android.a.e.a(r1, r2, r0, r5);
    L_0x0088:
        r5 = r6.J;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 == 0) goto L_0x0092;
    L_0x0090:
        r5 = 1;
        return r5;
    L_0x0092:
        r5 = 2;
        return r5;
    L_0x0094:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.d.b(android.content.Context, android.content.Intent):int");
    }
}
