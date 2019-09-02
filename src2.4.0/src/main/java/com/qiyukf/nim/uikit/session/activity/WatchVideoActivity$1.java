package com.qiyukf.nim.uikit.session.activity;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class WatchVideoActivity$1 implements Callback {
    final /* synthetic */ WatchVideoActivity a;

    WatchVideoActivity$1(WatchVideoActivity watchVideoActivity) {
        this.a = watchVideoActivity;
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (!WatchVideoActivity.a(this.a)) {
            WatchVideoActivity.a(this.a, true);
            WatchVideoActivity.b(this.a);
        }
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WatchVideoActivity.a(this.a, false);
    }
}
