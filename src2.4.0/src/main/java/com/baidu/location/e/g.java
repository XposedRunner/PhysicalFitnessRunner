package com.baidu.location.e;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.f;

class g extends Handler {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public void handleMessage(Message message) {
        if (f.isServing) {
            int i = message.what;
            if (i != 1) {
                e eVar;
                String str;
                switch (i) {
                    case 3:
                        eVar = this.a;
                        str = "&og=1";
                        break;
                    case 4:
                        eVar = this.a;
                        str = "&og=2";
                        break;
                    default:
                        return;
                }
                eVar.a(str, (Location) message.obj);
                return;
            }
            this.a.e((Location) message.obj);
        }
    }
}
