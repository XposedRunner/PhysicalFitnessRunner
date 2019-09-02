package com.qiyukf.nim.uikit.session.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.unicorn.R;

class WatchVideoActivity$8 implements OnErrorListener {
    final /* synthetic */ WatchVideoActivity a;

    WatchVideoActivity$8(WatchVideoActivity watchVideoActivity) {
        this.a = watchVideoActivity;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            StringBuilder stringBuilder = new StringBuilder("file://");
            stringBuilder.append(this.a.i);
            intent.setDataAndType(Uri.parse(stringBuilder.toString()), "video/3gp");
            this.a.startActivity(intent);
            this.a.finish();
        } catch (Exception unused) {
            g.b(R.string.ysf_look_video_fail);
        }
        return true;
    }
}
