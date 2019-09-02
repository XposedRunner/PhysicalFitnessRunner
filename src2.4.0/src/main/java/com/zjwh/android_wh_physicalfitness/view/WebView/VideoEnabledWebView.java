package com.zjwh.android_wh_physicalfitness.view.WebView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.Map;

public class VideoEnabledWebView extends WebView {
    private O000000o O000000o;
    private boolean O00000Oo = false;

    public class O000000o {
        @JavascriptInterface
        public void notifyVideoEnd() {
            Log.d("___", "GOT IT");
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (VideoEnabledWebView.this.O000000o != null) {
                        VideoEnabledWebView.this.O000000o.onHideCustomView();
                    }
                }
            });
        }
    }

    public VideoEnabledWebView(Context context) {
        super(context);
    }

    public VideoEnabledWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoEnabledWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void O00000Oo() {
        if (!this.O00000Oo) {
            addJavascriptInterface(new O000000o(), "_VideoEnabledWebView");
            this.O00000Oo = true;
        }
    }

    public boolean O000000o() {
        return this.O000000o != null && this.O000000o.O000000o();
    }

    public void loadData(String str, String str2, String str3) {
        O00000Oo();
        super.loadData(str, str2, str3);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        O00000Oo();
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void loadUrl(String str) {
        O00000Oo();
        super.loadUrl(str);
    }

    public void loadUrl(String str, Map<String, String> map) {
        O00000Oo();
        super.loadUrl(str, map);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        getSettings().setJavaScriptEnabled(true);
        if (webChromeClient instanceof O000000o) {
            this.O000000o = (O000000o) webChromeClient;
        }
        super.setWebChromeClient(webChromeClient);
    }
}
