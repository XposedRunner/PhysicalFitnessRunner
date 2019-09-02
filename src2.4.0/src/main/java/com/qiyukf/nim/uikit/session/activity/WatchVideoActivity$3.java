package com.qiyukf.nim.uikit.session.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

class WatchVideoActivity$3 implements OnClickListener {
    final /* synthetic */ PopupWindow a;
    final /* synthetic */ WatchVideoActivity b;

    WatchVideoActivity$3(WatchVideoActivity watchVideoActivity, PopupWindow popupWindow) {
        this.b = watchVideoActivity;
        this.a = popupWindow;
    }

    public final void onClick(View view) {
        WatchVideoActivity.q(this.b);
        this.a.dismiss();
    }
}
