package com.zjwh.android_wh_physicalfitness.receiver;

import android.content.BroadcastReceiver;

public class ChatReceiver extends BroadcastReceiver {
    public static final String O000000o = "com.zjwh.android_wh_physicalfitness.receiver.action_chat_receiver";
    private static final String O00000Oo = "ChatReceiver";

    /* JADX WARNING: Missing block: B:20:0x007e, code skipped:
            return;
     */
    public void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
        r3 = this;
        if (r5 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r5.getExtras();
        r5 = r5.getAction();
        if (r5 == 0) goto L_0x007e;
    L_0x000d:
        if (r0 != 0) goto L_0x0010;
    L_0x000f:
        goto L_0x007e;
    L_0x0010:
        r1 = "com.zjwh.android_wh_physicalfitness.receiver.action_chat_receiver";
        r5 = r5.equals(r1);
        if (r5 == 0) goto L_0x007d;
    L_0x0018:
        r5 = "extra_info";
        r5 = r0.containsKey(r5);
        if (r5 == 0) goto L_0x007d;
    L_0x0020:
        r5 = "extra_info";
        r5 = r0.getParcelable(r5);
        r5 = (com.zjwh.android_wh_physicalfitness.entity.database.ChatFriendBean) r5;
        r0 = com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O00000Oo();	 Catch:{ Exception -> 0x0079 }
        if (r0 == 0) goto L_0x0050;
    L_0x002e:
        r1 = O00000Oo;	 Catch:{ Exception -> 0x0079 }
        r2 = "将压入后台的app唤起到前台";
        defpackage.kz.O00000Oo(r1, r2);	 Catch:{ Exception -> 0x0079 }
        r1 = "activity";
        r4 = r4.getSystemService(r1);	 Catch:{ Exception -> 0x0079 }
        r4 = (android.app.ActivityManager) r4;	 Catch:{ Exception -> 0x0079 }
        r1 = r0.getTaskId();	 Catch:{ Exception -> 0x0079 }
        r2 = 1;
        r4.moveTaskToFront(r1, r2);	 Catch:{ Exception -> 0x0079 }
        r4 = com.zjwh.android_wh_physicalfitness.ui.chat.ChatActivity.class;
        com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O00000Oo(r4);	 Catch:{ Exception -> 0x0079 }
        if (r5 == 0) goto L_0x007d;
    L_0x004c:
        com.zjwh.android_wh_physicalfitness.ui.chat.ChatActivity.O000000o(r0, r5);	 Catch:{ Exception -> 0x0079 }
        goto L_0x007d;
    L_0x0050:
        r0 = O00000Oo;	 Catch:{ Exception -> 0x0079 }
        r1 = "启动 App";
        defpackage.kz.O00000Oo(r0, r1);	 Catch:{ Exception -> 0x0079 }
        r0 = r4.getPackageManager();	 Catch:{ Exception -> 0x0079 }
        r1 = r4.getPackageName();	 Catch:{ Exception -> 0x0079 }
        r0 = r0.getLaunchIntentForPackage(r1);	 Catch:{ Exception -> 0x0079 }
        r1 = 270532608; // 0x10200000 float:3.1554436E-29 double:1.336608677E-315;
        r0.setFlags(r1);	 Catch:{ Exception -> 0x0079 }
        r1 = new android.os.Bundle;	 Catch:{ Exception -> 0x0079 }
        r1.<init>();	 Catch:{ Exception -> 0x0079 }
        r2 = "extra_info";
        r1.putParcelable(r2, r5);	 Catch:{ Exception -> 0x0079 }
        r0.putExtras(r1);	 Catch:{ Exception -> 0x0079 }
        r4.startActivity(r0);	 Catch:{ Exception -> 0x0079 }
        goto L_0x007d;
    L_0x0079:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x007d:
        return;
    L_0x007e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.receiver.ChatReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
