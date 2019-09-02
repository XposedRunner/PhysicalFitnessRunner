package com.qiyukf.nim.uikit.session.activity;

import android.view.ViewGroup.LayoutParams;
import com.qiyukf.basesdk.c.a.b;
import com.qiyukf.unicorn.R;

class WatchVideoActivity$12 implements Runnable {
    final /* synthetic */ float a;
    final /* synthetic */ String b;
    final /* synthetic */ long c;
    final /* synthetic */ long d;
    final /* synthetic */ WatchVideoActivity e;

    WatchVideoActivity$12(WatchVideoActivity watchVideoActivity, float f, String str, long j, long j2) {
        this.e = watchVideoActivity;
        this.a = f;
        this.b = str;
        this.c = j;
        this.d = j2;
    }

    public final void run() {
        LayoutParams layoutParams = WatchVideoActivity.m(this.e).getLayoutParams();
        layoutParams.width = (int) (((float) WatchVideoActivity.n(this.e).getWidth()) * this.a);
        WatchVideoActivity.m(this.e).setLayoutParams(layoutParams);
        WatchVideoActivity.o(this.e).setText(String.format(this.e.getString(R.string.ysf_download_progress_description), new Object[]{this.b, b.a(this.c), b.a(this.d)}));
    }
}
