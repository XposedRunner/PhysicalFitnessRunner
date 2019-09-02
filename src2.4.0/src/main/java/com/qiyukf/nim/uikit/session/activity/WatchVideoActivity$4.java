package com.qiyukf.nim.uikit.session.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;

class WatchVideoActivity$4 implements OnClickListener {
    final /* synthetic */ PopupWindow a;
    final /* synthetic */ WatchVideoActivity b;

    WatchVideoActivity$4(WatchVideoActivity watchVideoActivity, PopupWindow popupWindow) {
        this.b = watchVideoActivity;
        this.a = popupWindow;
    }

    public final void onClick(View view) {
        this.a.dismiss();
    }
}
