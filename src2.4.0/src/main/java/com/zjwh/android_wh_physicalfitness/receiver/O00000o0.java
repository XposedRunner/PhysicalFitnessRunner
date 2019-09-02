package com.zjwh.android_wh_physicalfitness.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.zjwh.android_wh_physicalfitness.service.DaemonService;

/* compiled from: WakeUpReceiver */
public class O00000o0 extends BroadcastReceiver {
    public static final String O000000o = "com.zjwh.android_wh_physicalfitness.CANCEL_JOB_ALARM_SUB";

    public void onReceive(Context context, Intent intent) {
        if (intent != null && O000000o.equals(intent.getAction())) {
            DaemonService.O000000o();
            context.stopService(new Intent(context, DaemonService.class));
        }
    }
}
