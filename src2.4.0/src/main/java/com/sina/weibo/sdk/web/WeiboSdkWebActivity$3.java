package com.sina.weibo.sdk.web;

import android.view.View;
import android.view.View.OnClickListener;

class WeiboSdkWebActivity$3 implements OnClickListener {
    final /* synthetic */ WeiboSdkWebActivity this$0;

    WeiboSdkWebActivity$3(WeiboSdkWebActivity weiboSdkWebActivity) {
        this.this$0 = weiboSdkWebActivity;
    }

    public void onClick(View view) {
        WeiboSdkWebActivity.access$502(this.this$0, 0);
        WeiboSdkWebActivity.access$600(this.this$0);
        WeiboSdkWebActivity.access$100(this.this$0).reload();
    }
}
