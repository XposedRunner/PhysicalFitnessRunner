package com.qiyukf.unicorn.ui.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.qiyukf.unicorn.d;

class ServiceMessageActivity$1 implements OnClickListener {
    final /* synthetic */ ServiceMessageActivity a;

    ServiceMessageActivity$1(ServiceMessageActivity serviceMessageActivity) {
        this.a = serviceMessageActivity;
    }

    public final void onClick(View view) {
        d.e().titleBarConfig.onTitleBarRightBtnClickListener.onClick(this.a);
    }
}
