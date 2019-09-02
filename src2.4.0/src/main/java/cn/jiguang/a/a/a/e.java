package cn.jiguang.a.a.a;

import android.os.Handler.Callback;
import android.os.Message;

final class e implements Callback {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final boolean handleMessage(Message message) {
        if (message != null && message.what == 1) {
            Thread thread = (Thread) message.obj;
            if (thread != null) {
                thread.interrupt();
            }
            if (message.getData() != null) {
                message.getData().getString("ip");
            }
        }
        return false;
    }
}
