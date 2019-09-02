package com.baidu.mapsdkplatform.comapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mapapi.NetworkUtil;
import com.baidu.mapsdkplatform.comapi.util.h;

public class e extends BroadcastReceiver {
    public static final String a = "e";

    public void a(Context context) {
        String currentNetMode = NetworkUtil.getCurrentNetMode(context);
        String e = h.e();
        if (e != null && !e.equals(currentNetMode)) {
            h.a(currentNetMode);
        }
    }

    public void onReceive(Context context, Intent intent) {
        a(context);
        NetworkUtil.updateNetworkProxy(context);
    }
}
