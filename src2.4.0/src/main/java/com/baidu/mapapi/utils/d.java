package com.baidu.mapapi.utils;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.a.a;

final class d implements ServiceConnection {
    d() {
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (b.v != null) {
            b.v.interrupt();
        }
        String b = b.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onServiceConnected ");
        stringBuilder.append(componentName);
        Log.d(b, stringBuilder.toString());
        try {
            if (b.d != null) {
                b.d = null;
            }
            b.d = a.a(iBinder);
            b.d.a(new e(this));
        } catch (RemoteException e) {
            Log.d(b.c, "getComOpenClient ", e);
            if (b.d != null) {
                b.d = null;
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        String b = b.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onServiceDisconnected ");
        stringBuilder.append(componentName);
        Log.d(b, stringBuilder.toString());
        if (b.d != null) {
            b.d = null;
            b.u = false;
        }
    }
}
