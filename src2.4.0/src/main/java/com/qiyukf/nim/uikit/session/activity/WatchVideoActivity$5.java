package com.qiyukf.nim.uikit.session.activity;

import android.os.CountDownTimer;

class WatchVideoActivity$5 extends CountDownTimer {
    final /* synthetic */ WatchVideoActivity a;

    WatchVideoActivity$5(WatchVideoActivity watchVideoActivity, long j) {
        this.a = watchVideoActivity;
        super(j, 1000);
    }

    public final void onFinish() {
        if (WatchVideoActivity.r(this.a) == 1) {
            WatchVideoActivity.b(this.a, 8);
        }
    }

    public final void onTick(long j) {
    }
}
