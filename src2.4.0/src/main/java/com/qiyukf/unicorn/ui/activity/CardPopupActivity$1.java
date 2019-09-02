package com.qiyukf.unicorn.ui.activity;

import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.unicorn.R;

class CardPopupActivity$1 extends RequestCallbackWrapper<Void> {
    final /* synthetic */ CardPopupActivity a;

    CardPopupActivity$1(CardPopupActivity cardPopupActivity) {
        this.a = cardPopupActivity;
    }

    public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
        if (i != 200) {
            g.a(R.string.ysf_network_broken);
            this.a.finish();
        }
    }
}
