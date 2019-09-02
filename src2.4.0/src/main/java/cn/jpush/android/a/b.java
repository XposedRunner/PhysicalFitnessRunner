package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.service.JPushMessageReceiver;
import cn.jpush.android.service.f;

final class b implements Runnable {
    final /* synthetic */ a a;
    private Context b;
    private JPushMessageReceiver c;
    private Intent d;

    public b(a aVar, Context context, JPushMessageReceiver jPushMessageReceiver, Intent intent) {
        this.a = aVar;
        this.b = context;
        this.c = jPushMessageReceiver;
        this.d = intent;
    }

    public final void run() {
        if (this.d != null) {
            if ("cn.jpush.android.intent.RECEIVE_MESSAGE".equals(this.d.getAction())) {
                int intExtra = this.d.getIntExtra("message_type", -1);
                JPushMessage jPushMessage = null;
                if (1 == intExtra || 2 == intExtra) {
                    jPushMessage = f.a().a(this.d);
                } else if (3 == intExtra) {
                    g.a();
                    jPushMessage = g.a(this.d);
                }
                if (jPushMessage != null) {
                    if (intExtra == 1) {
                        if (jPushMessage.isTagCheckOperator()) {
                            this.c.onCheckTagOperatorResult(this.b, jPushMessage);
                        } else {
                            this.c.onTagOperatorResult(this.b, jPushMessage);
                        }
                    } else if (intExtra == 2) {
                        this.c.onAliasOperatorResult(this.b, jPushMessage);
                    } else if (intExtra == 3) {
                        this.c.onMobileNumberOperatorResult(this.b, jPushMessage);
                    }
                }
            }
        }
    }
}
