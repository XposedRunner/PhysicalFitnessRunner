package cn.jiguang.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class g extends Handler {
    final /* synthetic */ f a;

    public g(f fVar, Looper looper) {
        this.a = fVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                if (!this.a.k) {
                    this.a.k = true;
                    f.b(this.a);
                    f.c(this.a);
                    break;
                }
                break;
            case 1001:
            case 1003:
            case 1004:
            case 1005:
                if (this.a.m != null) {
                    this.a.m.a(message);
                    return;
                }
                break;
            default:
                return;
        }
    }
}
