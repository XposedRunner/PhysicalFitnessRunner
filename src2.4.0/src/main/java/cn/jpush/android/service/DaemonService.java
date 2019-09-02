package cn.jpush.android.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.d.a;
import cn.jiguang.d.i.c;
import cn.jiguang.d.i.f;
import java.util.Iterator;

public class DaemonService extends Service implements Runnable {
    private static final String TAG = "DaemonService";

    public class MyBinder extends Binder {
        public DaemonService getService() {
            return DaemonService.this;
        }
    }

    private void init() {
        JCoreInterface.execute("SDK_MAIN", this, new int[0]);
    }

    private void report(int i, boolean z, Bundle bundle) {
        if (c.a((Context) this)) {
            if (bundle != null) {
                try {
                    Iterator it = bundle.keySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } catch (Throwable unused) {
                }
            }
            String str = "";
            String str2 = "";
            String str3 = "";
            if (bundle != null) {
                str = bundle.getString("from_package");
                str2 = bundle.getString("from_uid");
                str3 = bundle.getString("awake_sequence");
            }
            f.a().b().a(this, i, z, str, str2, str3);
        }
    }

    public IBinder onBind(Intent intent) {
        report(2, a.i, intent != null ? intent.getExtras() : null);
        init();
        return new MyBinder();
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        report(1, a.i, intent != null ? intent.getExtras() : null);
        init();
        return super.onStartCommand(intent, i, i2);
    }

    public void run() {
        try {
            Context applicationContext = getApplicationContext();
            if (a.d(applicationContext)) {
                JCoreInterface.register(applicationContext);
            } else {
                stopSelf();
            }
        } catch (Throwable th) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("DaemonService onCreate failed:");
            stringBuilder.append(th.getMessage());
            cn.jiguang.e.c.c(str, stringBuilder.toString());
        }
    }
}
