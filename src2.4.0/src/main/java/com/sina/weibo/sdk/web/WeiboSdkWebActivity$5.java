package com.sina.weibo.sdk.web;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.webkit.SslErrorHandler;

class WeiboSdkWebActivity$5 implements OnClickListener {
    final /* synthetic */ WeiboSdkWebActivity this$0;
    final /* synthetic */ SslErrorHandler val$handler;

    WeiboSdkWebActivity$5(WeiboSdkWebActivity weiboSdkWebActivity, SslErrorHandler sslErrorHandler) {
        this.this$0 = weiboSdkWebActivity;
        this.val$handler = sslErrorHandler;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.val$handler.cancel();
    }
}
