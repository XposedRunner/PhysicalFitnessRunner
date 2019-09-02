package com.sina.weibo.sdk.web;

import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam.ExtraTaskCallback;

class WeiboSdkWebActivity$1 implements ExtraTaskCallback {
    final /* synthetic */ WeiboSdkWebActivity this$0;

    WeiboSdkWebActivity$1(WeiboSdkWebActivity weiboSdkWebActivity) {
        this.this$0 = weiboSdkWebActivity;
    }

    public void onComplete(String str) {
        WeiboSdkWebActivity.access$100(this.this$0).loadUrl(WeiboSdkWebActivity.access$000(this.this$0).getRequestUrl());
    }

    public void onException(String str) {
        WeiboSdkWebActivity.access$200(this.this$0).errorBack(this.this$0, "pic upload error");
    }
}
