package cn.jiguang.service;

import android.content.Intent;
import cn.jpush.android.service.PushService;

public final class a implements Runnable {
    private final PushService a;
    private final int b;
    private final Intent c;

    public a(PushService pushService, int i, Intent intent) {
        this.a = pushService;
        this.b = i;
        this.c = intent;
    }

    public final void run() {
        switch (this.b) {
            case 1:
                this.a.runCreate();
                return;
            case 2:
                this.a.runStart(this.c);
                return;
            case 3:
                this.a.runDestroy();
                return;
            default:
                return;
        }
    }
}
