package cn.jpush.android.ui;

import android.os.Handler;
import android.os.Message;
import cn.jpush.android.data.b;
import java.lang.ref.WeakReference;

final class g extends Handler {
    private final WeakReference<PushActivity> a;

    public g(PushActivity pushActivity) {
        this.a = new WeakReference(pushActivity);
    }

    public final void handleMessage(Message message) {
        b bVar = (b) message.obj;
        PushActivity pushActivity = (PushActivity) this.a.get();
        if (pushActivity != null) {
            switch (message.what) {
                case 1:
                    pushActivity.setRequestedOrientation(1);
                    PushActivity.a(pushActivity, bVar);
                    return;
                case 2:
                    pushActivity.b();
                    return;
                default:
                    return;
            }
        }
    }
}
