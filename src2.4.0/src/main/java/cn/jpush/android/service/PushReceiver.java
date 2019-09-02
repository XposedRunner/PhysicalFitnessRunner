package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PushReceiver extends BroadcastReceiver implements Runnable {
    private static final String TAG = "PushReceiver";
    private Context appContext;
    private Intent theIntent;

    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007a */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:17|18|19|(2:21|(3:23|(1:25)|26))|27|28|29) */
    public void onReceive(android.content.Context r5, android.content.Intent r6) {
        /*
        r4 = this;
        if (r6 != 0) goto L_0x000a;
    L_0x0002:
        r5 = "PushReceiver";
        r6 = "Received null intent broadcast. Give up processing.";
        cn.jiguang.e.c.c(r5, r6);
        return;
    L_0x000a:
        r0 = r6.getAction();	 Catch:{ NullPointerException -> 0x009b }
        r1 = "PushReceiver";
        r2 = new java.lang.StringBuilder;	 Catch:{ NullPointerException -> 0x009b }
        r3 = "onReceive - ";
        r2.<init>(r3);	 Catch:{ NullPointerException -> 0x009b }
        r2.append(r0);	 Catch:{ NullPointerException -> 0x009b }
        r2 = r2.toString();	 Catch:{ NullPointerException -> 0x009b }
        cn.jiguang.e.c.a(r1, r2);	 Catch:{ NullPointerException -> 0x009b }
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x002f;
    L_0x0027:
        r5 = "PushReceiver";
        r6 = "Received action is null";
        cn.jiguang.e.c.c(r5, r6);
        return;
    L_0x002f:
        r1 = r5.getApplicationContext();
        r4.appContext = r1;
        r4.theIntent = r6;
        r1 = "cn.jpush.android.intent.NOTIFICATION_OPENED_PROXY";
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x0086 }
        r1 = 0;
        if (r0 == 0) goto L_0x007e;
    L_0x0040:
        r0 = "debug_notification";
        r0 = r6.getBooleanExtra(r0, r1);	 Catch:{ Throwable -> 0x0086 }
        if (r0 == 0) goto L_0x007e;
    L_0x0048:
        r0 = "toastText";
        r6 = r6.getStringExtra(r0);	 Catch:{ Throwable -> 0x0086 }
        r0 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x0086 }
        if (r0 != 0) goto L_0x007e;
    L_0x0054:
        r5 = android.widget.Toast.makeText(r5, r6, r1);	 Catch:{ Throwable -> 0x0086 }
        r0 = r5.getView();	 Catch:{ Exception -> 0x007a }
        r2 = r0 instanceof android.widget.LinearLayout;	 Catch:{ Exception -> 0x007a }
        if (r2 == 0) goto L_0x007a;
    L_0x0060:
        r0 = (android.widget.LinearLayout) r0;	 Catch:{ Exception -> 0x007a }
        r0 = r0.getChildAt(r1);	 Catch:{ Exception -> 0x007a }
        r1 = r0 instanceof android.widget.TextView;	 Catch:{ Exception -> 0x007a }
        if (r1 == 0) goto L_0x007a;
    L_0x006a:
        r0 = (android.widget.TextView) r0;	 Catch:{ Exception -> 0x007a }
        r1 = cn.jiguang.g.i.a(r6);	 Catch:{ Exception -> 0x007a }
        if (r1 != 0) goto L_0x0075;
    L_0x0072:
        r0.setText(r6);	 Catch:{ Exception -> 0x007a }
    L_0x0075:
        r6 = 1095761920; // 0x41500000 float:13.0 double:5.413783207E-315;
        r0.setTextSize(r6);	 Catch:{ Exception -> 0x007a }
    L_0x007a:
        r5.show();	 Catch:{ Throwable -> 0x0086 }
        return;
    L_0x007e:
        r5 = "SDK_MAIN";
        r6 = new int[r1];	 Catch:{ Throwable -> 0x0086 }
        cn.jiguang.api.JCoreInterface.execute(r5, r4, r6);	 Catch:{ Throwable -> 0x0086 }
        return;
    L_0x0086:
        r5 = move-exception;
        r6 = "PushReceiver";
        r0 = new java.lang.StringBuilder;
        r1 = "onReceiver error:";
        r0.<init>(r1);
        r0.append(r5);
        r5 = r0.toString();
        cn.jiguang.e.c.c(r6, r5);
        return;
    L_0x009b:
        r5 = "PushReceiver";
        r6 = "Received no action intent broadcast. Give up processing.";
        cn.jiguang.e.c.c(r5, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.PushReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x013b A:{Catch:{ Throwable -> 0x018b }} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x013b A:{Catch:{ Throwable -> 0x018b }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00b6 */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing block: B:45:?, code skipped:
            r2 = cn.jiguang.g.a.d(r0);
            r5.putBoolean("connection-state", r2);
     */
    /* JADX WARNING: Missing block: B:46:0x00bf, code skipped:
            if (r2 != false) goto L_0x00c1;
     */
    /* JADX WARNING: Missing block: B:47:0x00c1, code skipped:
            cn.jiguang.d.d.x.a(r0);
     */
    public void run() {
        /*
        r10 = this;
        r0 = r10.appContext;	 Catch:{ Throwable -> 0x01c3 }
        r1 = r10.theIntent;	 Catch:{ Throwable -> 0x01c3 }
        r2 = r10.theIntent;	 Catch:{ Throwable -> 0x01c3 }
        if (r2 == 0) goto L_0x01c2;
    L_0x0008:
        r2 = r10.theIntent;	 Catch:{ Throwable -> 0x01c3 }
        r2 = r2.getAction();	 Catch:{ Throwable -> 0x01c3 }
        if (r2 == 0) goto L_0x01c2;
    L_0x0010:
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        return;
    L_0x0013:
        r2 = cn.jiguang.d.a.d(r0);	 Catch:{ Throwable -> 0x01c3 }
        if (r2 != 0) goto L_0x0021;
    L_0x0019:
        r0 = "PushReceiver";
        r1 = "onReceive :JCoreInterface init failed";
        cn.jiguang.e.c.c(r0, r1);	 Catch:{ Throwable -> 0x01c3 }
        return;
    L_0x0021:
        r2 = r10.theIntent;	 Catch:{ Throwable -> 0x01c3 }
        r2 = r2.getAction();	 Catch:{ Throwable -> 0x01c3 }
        r3 = "android.intent.action.BOOT_COMPLETED";
        r3 = r2.equals(r3);	 Catch:{ Throwable -> 0x01c3 }
        r4 = 1;
        if (r3 == 0) goto L_0x0037;
    L_0x0030:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        cn.jiguang.d.a.a(r0, r4, r2);	 Catch:{ Throwable -> 0x01c3 }
        goto L_0x018b;
    L_0x0037:
        r3 = "android.intent.action.USER_PRESENT";
        r3 = r2.equals(r3);	 Catch:{ Throwable -> 0x01c3 }
        r5 = 0;
        r7 = 0;
        if (r3 == 0) goto L_0x004a;
    L_0x0042:
        cn.jiguang.d.d.l.a(r0, r7);	 Catch:{ Throwable -> 0x01c3 }
        cn.jiguang.d.a.a(r0, r4, r5);	 Catch:{ Throwable -> 0x01c3 }
        goto L_0x018b;
    L_0x004a:
        r3 = "android.intent.action.PACKAGE_ADDED";
        r3 = r2.equals(r3);	 Catch:{ Throwable -> 0x01c3 }
        if (r3 != 0) goto L_0x0142;
    L_0x0052:
        r3 = "android.intent.action.PACKAGE_REMOVED";
        r3 = r2.equals(r3);	 Catch:{ Throwable -> 0x01c3 }
        if (r3 == 0) goto L_0x005c;
    L_0x005a:
        goto L_0x0142;
    L_0x005c:
        r3 = "android.net.conn.CONNECTIVITY_CHANGE";
        r3 = r2.equalsIgnoreCase(r3);	 Catch:{ Throwable -> 0x01c3 }
        if (r3 == 0) goto L_0x00d0;
    L_0x0064:
        r2 = "networkInfo";
        r2 = r1.getParcelableExtra(r2);	 Catch:{ Throwable -> 0x01c3 }
        r2 = (android.net.NetworkInfo) r2;	 Catch:{ Throwable -> 0x01c3 }
        if (r2 != 0) goto L_0x006f;
    L_0x006e:
        return;
    L_0x006f:
        r3 = 2;
        r5 = r2.getType();	 Catch:{ Throwable -> 0x01c3 }
        if (r3 == r5) goto L_0x00cf;
    L_0x0076:
        r3 = 3;
        r5 = r2.getType();	 Catch:{ Throwable -> 0x01c3 }
        if (r3 != r5) goto L_0x007e;
    L_0x007d:
        return;
    L_0x007e:
        r3 = "noConnectivity";
        r3 = r1.getBooleanExtra(r3, r7);	 Catch:{ Throwable -> 0x01c3 }
        r5 = r1.getExtras();	 Catch:{ Throwable -> 0x01c3 }
        if (r5 != 0) goto L_0x008f;
    L_0x008a:
        r5 = new android.os.Bundle;	 Catch:{ Throwable -> 0x01c3 }
        r5.<init>();	 Catch:{ Throwable -> 0x01c3 }
    L_0x008f:
        if (r3 == 0) goto L_0x0097;
    L_0x0091:
        r2 = "connection-state";
        r5.putBoolean(r2, r7);	 Catch:{ Throwable -> 0x01c3 }
        goto L_0x00c4;
    L_0x0097:
        r3 = android.net.NetworkInfo.State.CONNECTED;	 Catch:{ Throwable -> 0x00b6 }
        r6 = r2.getState();	 Catch:{ Throwable -> 0x00b6 }
        if (r3 != r6) goto L_0x00a8;
    L_0x009f:
        r2 = "connection-state";
        r5.putBoolean(r2, r4);	 Catch:{ Throwable -> 0x00b6 }
        cn.jiguang.d.d.x.a(r0);	 Catch:{ Throwable -> 0x00b6 }
        goto L_0x00c4;
    L_0x00a8:
        r3 = android.net.NetworkInfo.State.DISCONNECTED;	 Catch:{ Throwable -> 0x00b6 }
        r2 = r2.getState();	 Catch:{ Throwable -> 0x00b6 }
        if (r3 != r2) goto L_0x00c4;
    L_0x00b0:
        r2 = "connection-state";
        r5.putBoolean(r2, r7);	 Catch:{ Throwable -> 0x00b6 }
        goto L_0x00c4;
    L_0x00b6:
        r2 = cn.jiguang.g.a.d(r0);	 Catch:{ Throwable -> 0x01c3 }
        r3 = "connection-state";
        r5.putBoolean(r3, r2);	 Catch:{ Throwable -> 0x01c3 }
        if (r2 == 0) goto L_0x00c4;
    L_0x00c1:
        cn.jiguang.d.d.x.a(r0);	 Catch:{ Throwable -> 0x01c3 }
    L_0x00c4:
        r2 = cn.jiguang.d.d.i.a();	 Catch:{ Throwable -> 0x01c3 }
        r3 = "intent.CONNECTIVITY_CHANGE";
        r2.b(r0, r3, r5);	 Catch:{ Throwable -> 0x01c3 }
        goto L_0x018b;
    L_0x00cf:
        return;
    L_0x00d0:
        r3 = "android.os.action.DEVICE_IDLE_MODE_CHANGED";
        r3 = r2.equals(r3);	 Catch:{ Throwable -> 0x01c3 }
        if (r3 != 0) goto L_0x00ee;
    L_0x00d8:
        r3 = "android.os.action.POWER_SAVE_MODE_CHANGED";
        r3 = r2.equals(r3);	 Catch:{ Throwable -> 0x01c3 }
        if (r3 == 0) goto L_0x00e1;
    L_0x00e0:
        goto L_0x00ee;
    L_0x00e1:
        r3 = "cn.jpush.android.intent.ACTION_REPORT_HISTORY";
        r2 = r2.equals(r3);	 Catch:{ Throwable -> 0x01c3 }
        if (r2 == 0) goto L_0x018b;
    L_0x00e9:
        cn.jiguang.d.d.x.a(r0);	 Catch:{ Throwable -> 0x01c3 }
        goto L_0x018b;
    L_0x00ee:
        r3 = "power";
        r3 = r0.getSystemService(r3);	 Catch:{ Throwable -> 0x01c3 }
        r3 = (android.os.PowerManager) r3;	 Catch:{ Throwable -> 0x01c3 }
        if (r3 == 0) goto L_0x018b;
    L_0x00f8:
        r8 = "android.os.PowerManager";
        r8 = java.lang.Class.forName(r8);	 Catch:{ Throwable -> 0x018b }
        if (r8 == 0) goto L_0x018b;
    L_0x0100:
        r9 = "android.os.action.DEVICE_IDLE_MODE_CHANGED";
        r9 = r2.equals(r9);	 Catch:{ Throwable -> 0x018b }
        if (r9 == 0) goto L_0x011f;
    L_0x0108:
        r2 = "isDeviceIdleMode";
        r9 = new java.lang.Class[r7];	 Catch:{ Throwable -> 0x018b }
        r2 = r8.getDeclaredMethod(r2, r9);	 Catch:{ Throwable -> 0x018b }
        if (r2 == 0) goto L_0x0138;
    L_0x0112:
        r8 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x018b }
        r2 = r2.invoke(r3, r8);	 Catch:{ Throwable -> 0x018b }
    L_0x0118:
        r2 = (java.lang.Boolean) r2;	 Catch:{ Throwable -> 0x018b }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x018b }
        goto L_0x0139;
    L_0x011f:
        r9 = "android.os.action.POWER_SAVE_MODE_CHANGED";
        r2 = r2.equals(r9);	 Catch:{ Throwable -> 0x018b }
        if (r2 == 0) goto L_0x0138;
    L_0x0127:
        r2 = "isPowerSaveMode";
        r9 = new java.lang.Class[r7];	 Catch:{ Throwable -> 0x018b }
        r2 = r8.getDeclaredMethod(r2, r9);	 Catch:{ Throwable -> 0x018b }
        if (r2 == 0) goto L_0x0138;
    L_0x0131:
        r8 = new java.lang.Object[r7];	 Catch:{ Throwable -> 0x018b }
        r2 = r2.invoke(r3, r8);	 Catch:{ Throwable -> 0x018b }
        goto L_0x0118;
    L_0x0138:
        r2 = r4;
    L_0x0139:
        if (r2 != 0) goto L_0x018b;
    L_0x013b:
        cn.jiguang.d.d.l.a(r0, r7);	 Catch:{ Throwable -> 0x018b }
        cn.jiguang.d.a.a(r0, r4, r5);	 Catch:{ Throwable -> 0x018b }
        goto L_0x018b;
    L_0x0142:
        r3 = r1.getDataString();	 Catch:{ Throwable -> 0x01c3 }
        if (r3 == 0) goto L_0x01ac;
    L_0x0148:
        r4 = r3.trim();	 Catch:{ Throwable -> 0x01c3 }
        r4 = r4.length();	 Catch:{ Throwable -> 0x01c3 }
        r5 = 8;
        if (r4 <= r5) goto L_0x0198;
    L_0x0154:
        r4 = "package:";
        r4 = r3.startsWith(r4);	 Catch:{ Throwable -> 0x01c3 }
        if (r4 == 0) goto L_0x0198;
    L_0x015c:
        r3 = r3.substring(r5);	 Catch:{ Throwable -> 0x01c3 }
        r4 = "android.intent.action.PACKAGE_ADDED";
        r2 = r2.equals(r4);	 Catch:{ Throwable -> 0x01c3 }
        if (r2 == 0) goto L_0x0178;
    L_0x0168:
        r2 = cn.jiguang.g.d.a(r0, r3);	 Catch:{ Throwable -> 0x01c3 }
        r2 = cn.jiguang.g.d.a(r2);	 Catch:{ Throwable -> 0x01c3 }
        r2 = cn.jiguang.g.h.a(r3, r2);	 Catch:{ Throwable -> 0x01c3 }
        cn.jiguang.a.c.c.a(r0, r2);	 Catch:{ Throwable -> 0x01c3 }
        goto L_0x0188;
    L_0x0178:
        r2 = cn.jiguang.g.a.i(r0, r3);	 Catch:{ Throwable -> 0x01c3 }
        if (r2 != 0) goto L_0x0188;
    L_0x017e:
        r2 = cn.jiguang.g.h.a(r3);	 Catch:{ Throwable -> 0x01c3 }
        cn.jiguang.a.c.c.a(r0, r2);	 Catch:{ Throwable -> 0x01c3 }
        cn.jiguang.d.f.a.a(r0, r3);	 Catch:{ Throwable -> 0x01c3 }
    L_0x0188:
        cn.jiguang.a.c.c.a(r0, r3);	 Catch:{ Throwable -> 0x01c3 }
    L_0x018b:
        cn.jiguang.d.d.b.a();	 Catch:{ Throwable -> 0x01c3 }
        r2 = "sdktype";
        r2 = r1.getStringExtra(r2);	 Catch:{ Throwable -> 0x01c3 }
        cn.jiguang.d.d.b.a(r0, r2, r1);	 Catch:{ Throwable -> 0x01c3 }
        return;
    L_0x0198:
        r0 = "PushReceiver";
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01c3 }
        r2 = "Get wrong data string from intent: ";
        r1.<init>(r2);	 Catch:{ Throwable -> 0x01c3 }
        r1.append(r3);	 Catch:{ Throwable -> 0x01c3 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x01c3 }
        cn.jiguang.e.c.c(r0, r1);	 Catch:{ Throwable -> 0x01c3 }
        return;
    L_0x01ac:
        r0 = "PushReceiver";
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x01c3 }
        r1.<init>();	 Catch:{ Throwable -> 0x01c3 }
        r1.append(r2);	 Catch:{ Throwable -> 0x01c3 }
        r2 = ": Get no data from intent.";
        r1.append(r2);	 Catch:{ Throwable -> 0x01c3 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x01c3 }
        cn.jiguang.e.c.c(r0, r1);	 Catch:{ Throwable -> 0x01c3 }
    L_0x01c2:
        return;
    L_0x01c3:
        r0 = move-exception;
        r1 = "PushReceiver";
        r2 = new java.lang.StringBuilder;
        r3 = "onReceiver error:";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r2.append(r0);
        r0 = r2.toString();
        cn.jiguang.e.c.c(r1, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.PushReceiver.run():void");
    }
}
