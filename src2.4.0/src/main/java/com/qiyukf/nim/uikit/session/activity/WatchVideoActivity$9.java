package com.qiyukf.nim.uikit.session.activity;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class WatchVideoActivity$9 implements OnPreparedListener {
    final /* synthetic */ WatchVideoActivity a;

    WatchVideoActivity$9(WatchVideoActivity watchVideoActivity) {
        this.a = watchVideoActivity;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        WatchVideoActivity.c(this.a).start();
        WatchVideoActivity.h(this.a);
        WatchVideoActivity.d(this.a).postDelayed(WatchVideoActivity.g(this.a), 100);
        if (WatchVideoActivity.i(this.a)) {
            WatchVideoActivity.c(this.a).setVolume(0.0f, 0.0f);
        }
    }
}
