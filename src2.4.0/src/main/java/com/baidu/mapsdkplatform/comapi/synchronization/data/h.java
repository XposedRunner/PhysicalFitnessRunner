package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Message;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c.a;
import com.baidu.mapsdkplatform.comapi.synchronization.c.e;

class h extends e {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void a(a aVar) {
        Message obtainMessage = this.a.j.obtainMessage();
        obtainMessage.what = 100001;
        obtainMessage.obj = aVar;
        if (this.a.j != null) {
            this.a.j.sendMessage(obtainMessage);
        }
        if (a.SERVER_ERROR == aVar || a.NETWORK_ERROR == aVar || a.INNER_ERROR == aVar) {
            this.a.k = this.a.k + 1;
        }
    }

    public void a(String str) {
        Message obtainMessage = this.a.j.obtainMessage();
        obtainMessage.what = 100000;
        obtainMessage.obj = str;
        if (this.a.j != null) {
            this.a.j.sendMessage(obtainMessage);
        }
        this.a.k = 0;
    }
}
