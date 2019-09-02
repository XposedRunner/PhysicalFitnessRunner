package com.qiyukf.nim.uikit.session.activity;

class WatchMessagePictureActivity$5 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ WatchMessagePictureActivity b;

    WatchMessagePictureActivity$5(WatchMessagePictureActivity watchMessagePictureActivity, int i) {
        this.b = watchMessagePictureActivity;
        this.a = i;
    }

    public final void run() {
        WatchMessagePictureActivity.a(this.b, this.a);
    }
}
