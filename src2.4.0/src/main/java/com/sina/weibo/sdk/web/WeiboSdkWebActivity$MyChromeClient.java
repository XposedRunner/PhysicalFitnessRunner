package com.sina.weibo.sdk.web;

import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class WeiboSdkWebActivity$MyChromeClient extends WebChromeClient {
    final /* synthetic */ WeiboSdkWebActivity this$0;

    private WeiboSdkWebActivity$MyChromeClient(WeiboSdkWebActivity weiboSdkWebActivity) {
        this.this$0 = weiboSdkWebActivity;
    }

    /* synthetic */ WeiboSdkWebActivity$MyChromeClient(WeiboSdkWebActivity weiboSdkWebActivity, WeiboSdkWebActivity$1 weiboSdkWebActivity$1) {
        this(weiboSdkWebActivity);
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        WeiboSdkWebActivity.access$700(this.this$0).drawProgress(i);
        if (i == 100) {
            WeiboSdkWebActivity.access$700(this.this$0).setVisibility(4);
        } else {
            WeiboSdkWebActivity.access$700(this.this$0).setVisibility(0);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (TextUtils.isEmpty(WeiboSdkWebActivity.access$000(this.this$0).getBaseData().getSpecifyTitle())) {
            WeiboSdkWebActivity.access$800(this.this$0).setText(str);
        }
    }
}
