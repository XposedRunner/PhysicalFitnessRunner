package com.baidu.lbsapi.auth;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class i extends Handler {
    final /* synthetic */ LBSAuthManager a;

    i(LBSAuthManager lBSAuthManager, Looper looper) {
        this.a = lBSAuthManager;
        super(looper);
    }

    public void handleMessage(Message message) {
        if (a.a) {
            a.a("handleMessage !!");
        }
        LBSAuthManagerListener lBSAuthManagerListener = (LBSAuthManagerListener) LBSAuthManager.f.get(message.getData().getString("listenerKey"));
        if (a.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("handleMessage listener = ");
            stringBuilder.append(lBSAuthManagerListener);
            a.a(stringBuilder.toString());
        }
        if (lBSAuthManagerListener != null) {
            lBSAuthManagerListener.onAuthResult(message.what, message.obj.toString());
        }
    }
}
