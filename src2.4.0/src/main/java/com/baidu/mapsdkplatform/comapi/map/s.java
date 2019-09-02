package com.baidu.mapsdkplatform.comapi.map;

import android.os.Handler;
import android.os.Message;

class s extends Handler {
    final /* synthetic */ r a;

    s(r rVar) {
        this.a = rVar;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (r.c != null) {
            this.a.d.a(message);
        }
    }
}
