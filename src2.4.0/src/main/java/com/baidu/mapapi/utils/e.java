package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b.a;

class e extends a {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public void a(IBinder iBinder) throws RemoteException {
        Log.d(b.c, "onClientReady");
        if (b.e != null) {
            b.e = null;
        }
        b.e = IComOpenClient.a.a(iBinder);
        if (!b.t) {
            b.a(b.a);
        }
        b.t = true;
    }
}
