package com.ximalaya.ting.android.xmpayordersdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ximalaya.ting.android.opensdk.auth.view.LoadingBar;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.util.SharedPreferencesUtil;
import java.util.ArrayList;
import s.h.e.l.l.C;

public class XmPayOrderActivity extends Activity {
    public static final String O000000o = "XmPayOrderActivity";
    public static final int O00000Oo = -498622;
    public static final int O00000o = -13421773;
    public static final int O00000o0 = -6710887;
    public static final int O00000oO = -1513240;
    public static final int O00000oo = -6710887;
    public static final int O0000O0o = -657931;
    public static final String O0000OOo = "params_error_code";
    public static final String O0000Oo = "ORDER_URL";
    public static final String O0000Oo0 = "params_error_desc";
    public static final String O0000OoO = "ORDER_NUM";
    public static final String O0000Ooo = "PAY_ORDER_NO";
    public static final String O0000o00 = "openPaySdkCode";
    private WebView O0000o;
    private TextView O0000o0;
    private Button O0000o0O;
    private TextView O0000o0o;
    private LinearLayout O0000oO;
    private LoadingBar O0000oO0;
    private boolean O0000oOO;
    private boolean O0000oOo;
    private String O0000oo = "";
    private String O0000oo0;
    private String O0000ooO;
    private String O0000ooo;
    private String O00oOooO;
    private O000000o O00oOooo;

    private class O000000o extends WebViewClient {
        private O000000o() {
        }

        /* synthetic */ O000000o(XmPayOrderActivity xmPayOrderActivity, byte b) {
            this();
        }

        public final void onPageFinished(WebView webView, String str) {
            if (XmPayOrderActivity.this.O0000oOO) {
                XmPayOrderActivity.this.O0000O0o();
            } else {
                XmPayOrderActivity.this.O0000oOO = false;
                XmPayOrderActivity.this.O0000OOo();
            }
            super.onPageFinished(webView, str);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            XmPayOrderActivity.this.O0000oo = str;
            if (!XmPayOrderActivity.this.O00000Oo(str)) {
                XmPayOrderActivity.this.O0000oo0 = "";
            }
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            XmPayOrderActivity.this.O000000o(webView, i, str, str2);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!TextUtils.isEmpty(str)) {
                Uri parse = Uri.parse(str);
                if (parse.getQueryParameterNames().contains(XmPayOrderActivity.O0000o00)) {
                    int intValue;
                    try {
                        intValue = Integer.valueOf(parse.getQueryParameter(XmPayOrderActivity.O0000o00)).intValue();
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        intValue = 500;
                    }
                    if (intValue == 200) {
                        O00000o0.O000000o(XmPayOrderActivity.this, XmPayOrderActivity.this.O00oOooO);
                    }
                    XmPayOrderActivity.this.O00oOooo.O000000o(O00000Oo.O00000Oo(intValue));
                    XmPayOrderActivity.this.finish();
                    return false;
                }
                try {
                    if (str.startsWith("alipays://platformapi")) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        XmPayOrderActivity.this.startActivity(intent);
                        return true;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }

    private class O00000Oo extends WebChromeClient {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(XmPayOrderActivity xmPayOrderActivity, byte b) {
            this();
        }

        public final void onProgressChanged(WebView webView, int i) {
            XmPayOrderActivity.this.O0000oO0.setVisibility(0);
            XmPayOrderActivity.this.O0000oO0.a(i * 100);
            if (i == 100) {
                XmPayOrderActivity.this.O0000oOo = false;
                XmPayOrderActivity.this.O000000o();
                return;
            }
            if (!XmPayOrderActivity.this.O0000oOo) {
                XmPayOrderActivity.this.O0000oOo = true;
                XmPayOrderActivity.this.O000000o();
            }
        }

        public final void onReceivedTitle(WebView webView, String str) {
            if (!XmPayOrderActivity.this.O00000Oo(XmPayOrderActivity.this.O0000oo)) {
                XmPayOrderActivity.this.O0000oo0 = str;
                XmPayOrderActivity.this.O0000OoO();
            }
        }
    }

    static {
        C.i(16777271);
    }

    private native void O000000o(WebView webView, int i, String str, String str2);

    private native void O000000o(String str);

    private native void O00000Oo();

    private native boolean O00000Oo(String str);

    private native void O00000o();

    private native void O00000o0();

    private native int O00000oO();

    @SuppressLint({"SetJavaScriptEnabled"})
    private void O00000oo() {
        this.O0000o.getSettings().setJavaScriptEnabled(true);
        this.O0000o.getSettings().setSavePassword(false);
        this.O0000o.setWebViewClient(new O000000o(this, (byte) 0));
        this.O0000o.setWebChromeClient(new O00000Oo(this, (byte) 0));
        this.O0000o.requestFocus();
        this.O0000o.setScrollBarStyle(0);
    }

    private native void O0000O0o();

    private native void O0000OOo();

    private native void O0000Oo();

    private native void O0000Oo0();

    private native void O0000OoO();

    public native void O000000o();

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O00000o0.O00000Oo = this;
        if (O00000o0.O00000o0 != null) {
            com.ximalaya.ting.android.xmpayordersdk.O00000o0.O000000o o000000o = O00000o0.O00000o0;
        }
        requestWindowFeature(1);
        this.O0000oo = getIntent().getStringExtra(O0000Oo);
        this.O0000ooo = getIntent().getStringExtra(O0000OoO);
        this.O00oOooO = getIntent().getStringExtra(O0000Ooo);
        ArrayList arrayList = SharedPreferencesUtil.getInstance(this).getArrayList(O0000Ooo);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.add(this.O00oOooO);
        SharedPreferencesUtil.getInstance(this).saveArrayList(DTransferConstants.SHARE_PAY_ORDER_NO, arrayList);
        this.O00oOooo = O00000o.O000000o().O000000o(this.O0000ooo);
        if (TextUtils.isEmpty(this.O0000oo) || TextUtils.isEmpty(this.O0000ooo) || this.O00oOooo == null) {
            finish();
            return;
        }
        this.O0000ooO = "确认订单";
        O00000Oo();
        O00000oo();
        O000000o(this.O0000oo);
    }

    public native void onDestroy();

    public native boolean onKeyUp(int i, KeyEvent keyEvent);

    public native void onPause();

    public native void onRestart();

    public native void onResume();

    public native void onStart();

    public native void onStop();
}
