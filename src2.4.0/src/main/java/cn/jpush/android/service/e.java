package cn.jpush.android.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.a;

public final class e {
    private static e b;
    private Context a;

    private e(Context context) {
        this.a = context;
    }

    public static e a(Context context) {
        if (b == null) {
            b = new e(context);
        }
        return b;
    }

    public static void a(Context context, Bundle bundle, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b(context));
        stringBuilder.append(".");
        stringBuilder.append(str);
        bundle.putString("action", stringBuilder.toString());
    }

    private static String b(Context context) {
        String str = a.c;
        if (TextUtils.isEmpty(str) && context != null) {
            str = context.getPackageName();
        }
        return str == null ? "" : str;
    }

    public final void a() {
        a.a(this.a).d(this.a);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:35:0x00ec in {2, 3, 6, 11, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 39, 43, 47, 51, 58, 61, 63, 67, 70, 71} preds:[]
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:242)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:51)
        	at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:51)
        	at jadx.core.ProcessClass.process(ProcessClass.java:37)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    public final void a(android.os.Bundle r10, android.os.Handler r11) {
        /*
        r9 = this;
        r11 = "PushServiceCore";
        r0 = new java.lang.StringBuilder;
        r1 = "bundle:";
        r0.<init>(r1);
        if (r10 == 0) goto L_0x0010;
        r1 = r10.toString();
        goto L_0x0012;
        r1 = "";
        r0.append(r1);
        r0 = r0.toString();
        cn.jpush.android.d.f.a(r11, r0);
        if (r10 != 0) goto L_0x001f;
        return;
        r11 = "action";
        r11 = r10.getString(r11);
        if (r11 == 0) goto L_0x01c6;
        r0 = "PushServiceCore";
        r1 = new java.lang.StringBuilder;
        r2 = "Action - handleServiceAction - action:";
        r1.<init>(r2);
        r1.append(r11);
        r1 = r1.toString();
        cn.jpush.android.d.f.a(r0, r1);
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r9.a;
        r1 = b(r1);
        r0.append(r1);
        r1 = ".";
        r0.append(r1);
        r0 = r0.toString();
        r1 = r11.startsWith(r0);
        if (r1 == 0) goto L_0x005f;
        r0 = r0.length();
        r11 = r11.substring(r0);
        r0 = "intent.MULTI_PROCESS";
        r0 = r0.equals(r11);
        r1 = 1;
        if (r0 == 0) goto L_0x00ed;
        r11 = "multi_type";
        r11 = r10.getInt(r11);
        switch(r11) {
            case 1: goto L_0x00da;
            case 2: goto L_0x00ce;
            case 3: goto L_0x00c2;
            case 4: goto L_0x00b6;
            case 5: goto L_0x0071;
            case 6: goto L_0x00a2;
            case 7: goto L_0x0090;
            case 8: goto L_0x0084;
            case 9: goto L_0x0078;
            case 10: goto L_0x0072;
            default: goto L_0x0071;
        };
        return;
        r10 = r9.a;
        cn.jpush.android.api.c.a(r10, r1);
        return;
        r11 = "notification_id";
        r10 = r10.getInt(r11);
        r11 = r9.a;
        cn.jpush.android.api.c.a(r11, r10, r1);
        return;
        r10 = r9.a;
        r10 = cn.jpush.android.service.a.a(r10);
        r11 = r9.a;
        r10.b(r11);
        return;
        r11 = "local_notification_id";
        r10 = r10.getLong(r11);
        r0 = r9.a;
        r0 = cn.jpush.android.service.a.a(r0);
        r1 = r9.a;
        r0.a(r1, r10);
        return;
        r11 = "local_notification";
        r10 = r10.getSerializable(r11);
        r10 = (cn.jpush.android.data.JPushLocalNotification) r10;
        r11 = r9.a;
        r11 = cn.jpush.android.service.a.a(r11);
        r0 = r9.a;
        r11.a(r0, r10, r1);
        return;
        r11 = "silence_push_time";
        r10 = r10.getString(r11);
        r11 = r9.a;
        cn.jpush.android.b.a(r11, r10, r1);
        return;
        r11 = "enable_push_time";
        r10 = r10.getString(r11);
        r11 = r9.a;
        cn.jpush.android.b.b(r11, r10, r1);
        return;
        r11 = "notification_maxnum";
        r10 = r10.getInt(r11);
        r11 = r9.a;
        cn.jpush.android.b.a(r11, r10, r1);
        return;
        r11 = "notification_buidler_id";
        r11 = r10.getString(r11);
        r0 = "notification_buidler";
        r10 = r10.getString(r0);
        r0 = r9.a;
        cn.jpush.android.b.a(r0, r11, r10, r1);
        return;
        return;
        r0 = "intent.STOPPUSH";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x00fd;
        r10 = r9.a;
        r11 = "service_stoped";
        cn.jiguang.api.MultiSpHelper.commitInt(r10, r11, r1);
        return;
        r0 = "intent.RESTOREPUSH";
        r0 = r11.equals(r0);
        if (r0 == 0) goto L_0x010e;
        r10 = r9.a;
        r11 = 0;
        r0 = "service_stoped";
        cn.jiguang.api.MultiSpHelper.commitInt(r10, r0, r11);
        return;
        r0 = "intent.ALIAS_TAGS";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x011c;
        r11 = r9.a;
        cn.jpush.android.a.n.a(r11, r10);
        return;
        r0 = "intent.plugin.platform.REQUEST_REGID";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x012e;
        r11 = cn.jpush.android.c.a.a();
        r0 = r9.a;
        r11.a(r0, r10);
        return;
        r0 = "intent.plugin.platform.ON_MESSAGING";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x01a3;
        r11 = "appId";
        r11 = r10.getString(r11);
        r0 = "senderId";
        r0 = r10.getString(r0);
        r1 = "JMessageExtra";
        r5 = r10.getString(r1);
        r1 = "platform";
        r8 = r10.getByte(r1);
        r10 = "PushServiceCore";
        r1 = new java.lang.StringBuilder;
        r2 = "appId:";
        r1.<init>(r2);
        r2 = java.lang.String.valueOf(r11);
        r1.append(r2);
        r2 = ",senderId:";
        r1.append(r2);
        r2 = java.lang.String.valueOf(r0);
        r1.append(r2);
        r2 = ",JMessageExtra:";
        r1.append(r2);
        r2 = java.lang.String.valueOf(r5);
        r1.append(r2);
        r1 = r1.toString();
        android.util.Log.d(r10, r1);
        r10 = android.text.TextUtils.isEmpty(r5);
        if (r10 != 0) goto L_0x01c6;
        r10 = android.text.TextUtils.isEmpty(r11);
        if (r10 == 0) goto L_0x018f;
        r10 = r9.a;
        r11 = r10.getPackageName();
        r3 = r11;
        r10 = android.text.TextUtils.isEmpty(r0);
        if (r10 == 0) goto L_0x019a;
        r0 = cn.jiguang.api.JCoreInterface.getAppKey();
        r4 = r0;
        r2 = r9.a;
        r6 = 0;
        cn.jpush.android.a.k.a(r2, r3, r4, r5, r6, r8);
        return;
        r0 = "action_notification_show";
        r0 = r0.equals(r11);
        if (r0 == 0) goto L_0x01b5;
        r11 = cn.jpush.android.c.d.a();
        r0 = r9.a;
        r11.a(r0, r10);
        return;
        r0 = "intent.MOBILE_NUMBER";
        r11 = r0.equals(r11);
        if (r11 == 0) goto L_0x01c6;
        r11 = cn.jpush.android.a.g.a();
        r0 = r9.a;
        r11.a(r0, r10);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.service.e.a(android.os.Bundle, android.os.Handler):void");
    }
}
