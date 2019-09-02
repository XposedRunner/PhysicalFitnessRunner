package com.qiyukf.unicorn.ui.activity;

import com.qiyukf.basesdk.c.d.b;
import com.qiyukf.unicorn.api.lifecycle.SessionLifeCycleListener;

class ServiceMessageActivity$2 implements SessionLifeCycleListener {
    final /* synthetic */ ServiceMessageActivity a;

    ServiceMessageActivity$2(ServiceMessageActivity serviceMessageActivity) {
        this.a = serviceMessageActivity;
    }

    public final void onLeaveSession() {
        b.a(this.a);
        this.a.finish();
    }
}
