package com.qiyukf.nim.uikit.session.activity;

import android.widget.TextView;
import com.qiyukf.basesdk.c.d.f;

class WatchVideoActivity$6 implements Runnable {
    final /* synthetic */ WatchVideoActivity a;

    WatchVideoActivity$6(WatchVideoActivity watchVideoActivity) {
        this.a = watchVideoActivity;
    }

    public final void run() {
        if (WatchVideoActivity.c(this.a) != null && WatchVideoActivity.c(this.a).isPlaying()) {
            WatchVideoActivity.a(this.a, 1);
            if (this.a.j <= 0) {
                this.a.d.setVisibility(4);
                return;
            }
            Object stringBuilder;
            int currentPosition = WatchVideoActivity.c(this.a).getCurrentPosition();
            if (currentPosition < 0) {
                currentPosition = 0;
            }
            long a = f.a((long) currentPosition);
            TextView textView = this.a.d;
            StringBuilder stringBuilder2 = new StringBuilder("00:");
            if (a < 10) {
                StringBuilder stringBuilder3 = new StringBuilder("0");
                stringBuilder3.append(a);
                stringBuilder = stringBuilder3.toString();
            } else {
                stringBuilder = Long.valueOf(a);
            }
            stringBuilder2.append(stringBuilder);
            textView.setText(stringBuilder2.toString());
            this.a.b.setProgress((int) a);
            WatchVideoActivity.d(this.a).postDelayed(this, 1000);
        }
    }
}
