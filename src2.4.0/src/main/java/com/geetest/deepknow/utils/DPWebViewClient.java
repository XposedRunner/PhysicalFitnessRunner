package com.geetest.deepknow.utils;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.g.b;

public class DPWebViewClient extends WebViewClient {
    private String appid = null;

    @SuppressLint({"SetJavaScriptEnabled"})
    public DPWebViewClient(WebView webView) {
        if (webView != null) {
            webView.getSettings().setJavaScriptEnabled(true);
            if (!TextUtils.isEmpty(f.a(webView.getContext(), b.l, ""))) {
                this.appid = f.a(webView.getContext(), b.l, "");
            }
        }
    }

    public void onLoadResource(WebView webView, String str) {
        JniLib1557756502.cV(this, webView, str, Integer.valueOf(65));
    }
}
