package com.qiyukf.nim.uikit.session.activity;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.qiyukf.basesdk.c.d.f;
import com.qiyukf.nimlib.sdk.msg.attachment.VideoAttachment;
import com.qiyukf.unicorn.R;

class WatchVideoActivity$7 implements OnCompletionListener {
    final /* synthetic */ WatchVideoActivity a;

    WatchVideoActivity$7(WatchVideoActivity watchVideoActivity) {
        this.a = watchVideoActivity;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        Object stringBuilder;
        WatchVideoActivity.e(this.a).setVisibility(0);
        this.a.c.setBackgroundResource(R.drawable.ysf_ic_video_start_btn_back);
        WatchVideoActivity.a(this.a, 2);
        this.a.b.setProgress(100);
        int a = (int) f.a(((VideoAttachment) WatchVideoActivity.f(this.a).getAttachment()).getDuration());
        StringBuilder stringBuilder2 = new StringBuilder("00:");
        if (a < 10) {
            StringBuilder stringBuilder3 = new StringBuilder("0");
            stringBuilder3.append(a);
            stringBuilder = stringBuilder3.toString();
        } else {
            stringBuilder = Integer.valueOf(a);
        }
        stringBuilder2.append(stringBuilder);
        this.a.d.setText(stringBuilder2.toString());
        WatchVideoActivity.b(this.a, 0);
        WatchVideoActivity.d(this.a).removeCallbacks(WatchVideoActivity.g(this.a));
    }
}
