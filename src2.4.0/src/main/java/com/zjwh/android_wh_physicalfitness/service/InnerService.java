package com.zjwh.android_wh_physicalfitness.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.zjwh.android_wh_physicalfitness.R;

public class InnerService extends Service {
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        startForeground(R.string.version_name, new Notification());
        stopForeground(true);
        stopSelf();
        return super.onStartCommand(intent, i, i2);
    }
}
