package cn.jiguang.d.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class m extends Handler {
    final /* synthetic */ Context a;
    final /* synthetic */ l b;

    m(l lVar, Looper looper, Context context) {
        this.b = lVar;
        this.a = context;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what == 8000) {
            this.b.d(this.a);
        }
    }
}
