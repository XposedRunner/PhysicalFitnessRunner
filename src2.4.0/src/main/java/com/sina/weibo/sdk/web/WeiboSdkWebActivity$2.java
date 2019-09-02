package com.sina.weibo.sdk.web;

import android.view.View;
import android.view.View.OnClickListener;

class WeiboSdkWebActivity$2 implements OnClickListener {
    final /* synthetic */ WeiboSdkWebActivity this$0;

    WeiboSdkWebActivity$2(WeiboSdkWebActivity weiboSdkWebActivity) {
        this.this$0 = weiboSdkWebActivity;
    }

    public void onClick(View view) {
        WeiboSdkWebActivity.access$200(this.this$0).closeWeb();
        WeiboSdkWebActivity.access$300(this.this$0);
    }
}
