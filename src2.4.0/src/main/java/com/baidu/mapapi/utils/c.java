package com.baidu.mapapi.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.baidu.mapframework.open.aidl.IComOpenClient;
import com.baidu.mapframework.open.aidl.b.a;

final class c extends a {
    final /* synthetic */ int a;

    c(int i) {
        this.a = i;
    }

    public void a(IBinder iBinder) throws RemoteException {
        Log.d(b.c, "onClientReady");
        if (b.e != null) {
            b.e = null;
        }
        b.e = IComOpenClient.a.a(iBinder);
        b.a(this.a);
        b.t = true;
    }
}
