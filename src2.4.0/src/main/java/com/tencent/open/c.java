package com.tencent.open;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.j;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class c extends b implements com.tencent.open.c.a.a {
    static Toast c;
    private String d;
    private IUiListener e;
    private c f;
    private Handler g;
    private com.tencent.open.c.a h;
    private com.tencent.open.c.b i;
    private WeakReference<Context> j;
    private int k;

    /* compiled from: ProGuard */
    private class a extends WebViewClient {
        private a() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            c.this.i.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Webview loading URL: ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.PKDialog", stringBuilder.toString());
            super.onPageStarted(webView, str, bitmap);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            c.this.f.onError(new UiError(i, str, str2));
            if (!(c.this.j == null || c.this.j.get() == null)) {
                Toast.makeText((Context) c.this.j.get(), "网络连接异常或系统错误", 0).show();
            }
            c.this.dismiss();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Redirect URL: ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.PKDialog", stringBuilder.toString());
            if (str.startsWith(g.a().a((Context) c.this.j.get(), "auth://tauth.qq.com/"))) {
                c.this.f.onComplete(j.c(str));
                c.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                c.this.f.onCancel();
                c.this.dismiss();
                return true;
            } else if (!str.startsWith(Constants.CLOSE_URI)) {
                return false;
            } else {
                c.this.dismiss();
                return true;
            }
        }
    }

    /* compiled from: ProGuard */
    private class b extends com.tencent.open.a.b {
        private b() {
        }
    }

    /* compiled from: ProGuard */
    private static class c implements IUiListener {
        String a;
        String b;
        private WeakReference<Context> c;
        private String d;
        private IUiListener e;

        public c(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.c = new WeakReference(context);
            this.d = str;
            this.a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        private void a(String str) {
            try {
                onComplete(j.d(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }

        public void onCancel() {
            if (this.e != null) {
                this.e.onCancel();
                this.e = null;
            }
        }

        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            com.tencent.open.b.g a = com.tencent.open.b.g.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.d);
            stringBuilder.append("_H5");
            a.a(stringBuilder.toString(), SystemClock.elapsedRealtime(), 0, 0, jSONObject.optInt("ret", -6), this.a, false);
            if (this.e != null) {
                this.e.onComplete(jSONObject);
                this.e = null;
            }
        }

        public void onError(UiError uiError) {
            StringBuilder stringBuilder;
            String stringBuilder2;
            if (uiError.errorMessage != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(uiError.errorMessage);
                stringBuilder.append(this.a);
                stringBuilder2 = stringBuilder.toString();
            } else {
                stringBuilder2 = this.a;
            }
            String str = stringBuilder2;
            com.tencent.open.b.g a = com.tencent.open.b.g.a();
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.d);
            stringBuilder.append("_H5");
            a.a(stringBuilder.toString(), SystemClock.elapsedRealtime(), 0, 0, uiError.errorCode, str, false);
            if (this.e != null) {
                this.e.onError(uiError);
                this.e = null;
            }
        }
    }

    /* compiled from: ProGuard */
    private class d extends Handler {
        private c b;

        public d(c cVar, Looper looper) {
            super(looper);
            this.b = cVar;
        }

        public void handleMessage(Message message) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("msg = ");
            stringBuilder.append(message.what);
            f.b("openSDK_LOG.PKDialog", stringBuilder.toString());
            switch (message.what) {
                case 1:
                    this.b.a((String) message.obj);
                    return;
                case 2:
                    this.b.onCancel();
                    return;
                case 3:
                    if (c.this.j != null && c.this.j.get() != null) {
                        c.c((Context) c.this.j.get(), (String) message.obj);
                        return;
                    }
                    return;
                case 5:
                    if (c.this.j != null && c.this.j.get() != null) {
                        c.d((Context) c.this.j.get(), (String) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public c(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.j = new WeakReference(context);
        this.d = str2;
        this.f = new c(context, str, str2, qQToken.getAppId(), iUiListener);
        this.g = new d(this.f, context.getMainLooper());
        this.e = iUiListener;
        this.k = Math.round(185.0f * context.getResources().getDisplayMetrics().density);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("density=");
        stringBuilder.append(context.getResources().getDisplayMetrics().density);
        stringBuilder.append("; webviewHeight=");
        stringBuilder.append(this.k);
        f.e("openSDK_LOG.PKDialog", stringBuilder.toString());
    }

    private void b() {
        this.h = new com.tencent.open.c.a((Context) this.j.get());
        this.h.setBackgroundColor(1711276032);
        this.h.setLayoutParams(new LayoutParams(-1, -1));
        this.i = new com.tencent.open.c.b((Context) this.j.get());
        this.i.setBackgroundColor(0);
        this.i.setBackgroundDrawable(null);
        if (VERSION.SDK_INT >= 11) {
            try {
                View.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(this.i, new Object[]{Integer.valueOf(1), new Paint()});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LayoutParams layoutParams = new LayoutParams(-1, this.k);
        layoutParams.addRule(13, -1);
        this.i.setLayoutParams(layoutParams);
        this.h.addView(this.i);
        this.h.a(this);
        setContentView(this.h);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void c() {
        this.i.setVerticalScrollBarEnabled(false);
        this.i.setHorizontalScrollBarEnabled(false);
        this.i.setWebViewClient(new a());
        this.i.setWebChromeClient(this.b);
        this.i.clearFormData();
        WebSettings settings = this.i.getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            settings.setCacheMode(-1);
            settings.setNeedInitialFocus(false);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setRenderPriority(RenderPriority.HIGH);
            settings.setJavaScriptEnabled(true);
            if (!(this.j == null || this.j.get() == null)) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(((Context) this.j.get()).getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.a.a(new b(), "sdk_js_if");
            this.i.clearView();
            this.i.loadUrl(this.d);
            this.i.getSettings().setSavePassword(false);
        }
    }

    private static void c(Context context, String str) {
        try {
            JSONObject d = j.d(str);
            int i = d.getInt("type");
            str = d.getString("msg");
            if (i == 0) {
                if (c == null) {
                    c = Toast.makeText(context, str, 0);
                } else {
                    c.setView(c.getView());
                    c.setText(str);
                    c.setDuration(0);
                }
                c.show();
            } else if (i == 1) {
                if (c == null) {
                    c = Toast.makeText(context, str, 1);
                } else {
                    c.setView(c.getView());
                    c.setText(str);
                    c.setDuration(1);
                }
                c.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void d(Context context, String str) {
        if (context != null && str != null) {
            try {
                JSONObject d = j.d(str);
                d.getInt("action");
                d.getString("msg");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void a() {
        this.i.getLayoutParams().height = this.k;
        f.e("openSDK_LOG.PKDialog", "onKeyboardHidden keyboard hide");
    }

    public void a(int i) {
        if (!(this.j == null || this.j.get() == null)) {
            if (i >= this.k || 2 != ((Context) this.j.get()).getResources().getConfiguration().orientation) {
                this.i.getLayoutParams().height = this.k;
            } else {
                this.i.getLayoutParams().height = i;
            }
        }
        f.e("openSDK_LOG.PKDialog", "onKeyboardShown keyboard show");
    }

    /* Access modifiers changed, original: protected */
    public void a(String str) {
        f.b("openSDK_LOG.PKDialog", "--onConsoleMessage--");
        try {
            this.a.a(this.i, str);
        } catch (Exception unused) {
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setSoftInputMode(16);
        getWindow().setSoftInputMode(1);
        b();
        c();
    }
}
