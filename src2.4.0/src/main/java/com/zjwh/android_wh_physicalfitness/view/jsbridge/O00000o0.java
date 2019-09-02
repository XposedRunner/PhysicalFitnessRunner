package com.zjwh.android_wh_physicalfitness.view.jsbridge;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslError;
import android.support.v7.app.AlertDialog.Builder;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: BridgeWebViewClient */
public class O00000o0 extends WebViewClient {
    private BridgeWebView O000000o;

    public O00000o0(BridgeWebView bridgeWebView) {
        this.O000000o = bridgeWebView;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        O00000Oo.O00000Oo(webView, BridgeWebView.O000000o);
        if (this.O000000o.getStartupMessage() != null) {
            for (O0000OOo O000000o : this.O000000o.getStartupMessage()) {
                this.O000000o.O000000o(O000000o);
            }
            this.O000000o.setStartupMessage(null);
        }
    }

    public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
        Builder builder = new Builder(webView.getContext());
        builder.setMessage("您的连接不是信任的连接，是否信任此链接？");
        builder.setPositiveButton("信任", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.proceed();
            }
        });
        builder.setNegativeButton("取消", new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                sslErrorHandler.cancel();
            }
        });
        builder.create().show();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (str.startsWith(O00000Oo.O00000Oo)) {
            this.O000000o.O000000o(str);
            return true;
        } else if (!str.startsWith(O00000Oo.O000000o)) {
            return super.shouldOverrideUrlLoading(webView, str);
        } else {
            this.O000000o.O00000o0();
            return true;
        }
    }
}
