package cn.jpush.android.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.a;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.l;

public class AlarmReceiver extends BroadcastReceiver implements Runnable {
    private static final String TAG = "AlarmReceiver";
    private Context appContext;

    public void onReceive(Context context, Intent intent) {
        this.appContext = context.getApplicationContext();
        JCoreInterface.execute("SDK_MAIN", this, new int[0]);
    }

    public void run() {
        if (!a.d(this.appContext)) {
            return;
        }
        if (d.i(this.appContext)) {
            cn.jiguang.d.b.a.a(this.appContext, false);
        } else {
            l.a(this.appContext, false);
        }
    }
}
