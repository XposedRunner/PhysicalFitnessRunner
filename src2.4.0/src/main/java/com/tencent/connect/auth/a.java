package com.tencent.connect.auth;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.jiguang.net.HttpUtils;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.mapapi.UIMsg.m_AppUI;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.utils.j;
import com.tencent.open.web.security.JniInterface;
import com.tencent.open.web.security.SecureJsInterface;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class a extends Dialog {
    private String a;
    private b b;
    private IUiListener c;
    private Handler d;
    private FrameLayout e;
    private LinearLayout f;
    private FrameLayout g;
    private ProgressBar h;
    private String i;
    private com.tencent.open.c.c j;
    private Context k;
    private com.tencent.open.web.security.b l;
    private boolean m = false;
    private int n;
    private String o;
    private String p;
    private long q = 0;
    private long r = StatisticConfig.MIN_UPLOAD_INTERVAL;
    private HashMap<String, Runnable> s;

    /* compiled from: ProGuard */
    private class a extends WebViewClient {
        private a() {
        }

        /* synthetic */ a(a aVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-->onPageFinished, url: ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
            a.this.g.setVisibility(8);
            if (a.this.j != null) {
                a.this.j.setVisibility(0);
            }
            if (!TextUtils.isEmpty(str)) {
                a.this.d.removeCallbacks((Runnable) a.this.s.remove(str));
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-->onPageStarted, url: ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
            super.onPageStarted(webView, str, bitmap);
            a.this.g.setVisibility(0);
            a.this.q = SystemClock.elapsedRealtime();
            if (!TextUtils.isEmpty(a.this.o)) {
                a.this.d.removeCallbacks((Runnable) a.this.s.remove(a.this.o));
            }
            a.this.o = str;
            d dVar = new d(a.this.o);
            a.this.s.put(str, dVar);
            a.this.d.postDelayed(dVar, 120000);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-->onReceivedError, errorCode: ");
            stringBuilder.append(i);
            stringBuilder.append(" | description: ");
            stringBuilder.append(str);
            f.c("openSDK_LOG.AuthDialog", stringBuilder.toString());
            if (!j.b(a.this.k)) {
                a.this.b.onError(new UiError(m_AppUI.MSG_CLICK_ITEM, "当前网络不可用，请稍后重试！", str2));
                a.this.dismiss();
            } else if (a.this.o.startsWith("http://qzs.qq.com/open/mobile/login/qzsjump.html?")) {
                a.this.b.onError(new UiError(i, str, str2));
                a.this.dismiss();
            } else {
                long elapsedRealtime = SystemClock.elapsedRealtime() - a.this.q;
                if (a.this.n >= 1 || elapsedRealtime >= a.this.r) {
                    a.this.j.loadUrl(a.this.a());
                } else {
                    a.this.n = a.this.n + 1;
                    a.this.d.postDelayed(new Runnable() {
                        public void run() {
                            a.this.j.loadUrl(a.this.o);
                        }
                    }, 500);
                }
            }
        }

        @TargetApi(8)
        public void onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-->onReceivedSslError ");
            stringBuilder.append(sslError.getPrimaryError());
            stringBuilder.append("请求不合法，请检查手机安全设置，如系统时间、代理等");
            f.e("openSDK_LOG.AuthDialog", stringBuilder.toString());
            CharSequence charSequence = "The SSL certificate is invalid,do you countinue?";
            CharSequence charSequence2 = "yes";
            CharSequence charSequence3 = "no";
            if (Locale.getDefault().getLanguage().equals("zh")) {
                charSequence = "ssl证书无效，是否继续访问？";
                charSequence2 = "是";
                charSequence3 = "否";
            }
            Builder builder = new Builder(a.this.k);
            builder.setMessage(charSequence);
            builder.setPositiveButton(charSequence2, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.proceed();
                }
            });
            builder.setNegativeButton(charSequence3, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    sslErrorHandler.cancel();
                    a.this.dismiss();
                }
            });
            builder.create().show();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-->Redirect URL: ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
            List pathSegments;
            if (str.startsWith("auth://browser")) {
                JSONObject c = j.c(str);
                a.this.m = a.this.e();
                if (!a.this.m) {
                    if (c.optString("fail_cb", null) != null) {
                        a.this.a(c.optString("fail_cb"), "");
                    } else if (c.optInt("fall_to_wv") == 1) {
                        a.a(a.this, a.this.a.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) > -1 ? HttpUtils.PARAMETERS_SEPARATOR : HttpUtils.URL_AND_PARA_SEPARATOR);
                        a.a(a.this, (Object) "browser_error=1");
                        a.this.j.loadUrl(a.this.a);
                    } else {
                        String optString = c.optString("redir", null);
                        if (optString != null) {
                            a.this.j.loadUrl(optString);
                        }
                    }
                }
                return true;
            } else if (str.startsWith("auth://tauth.qq.com/")) {
                a.this.b.onComplete(j.c(str));
                a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI)) {
                a.this.b.onCancel();
                a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI)) {
                a.this.dismiss();
                return true;
            } else if (str.startsWith(Constants.DOWNLOAD_URI) || str.endsWith(".apk")) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", str.startsWith(Constants.DOWNLOAD_URI) ? Uri.parse(Uri.decode(str.substring(Constants.DOWNLOAD_URI.length()))) : Uri.parse(Uri.decode(str)));
                    intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                    a.this.k.startActivity(intent);
                } catch (Exception e) {
                    f.b("openSDK_LOG.AuthDialog", "-->start download activity exception, e: ", e);
                }
                return true;
            } else if (str.startsWith("auth://progress")) {
                try {
                    pathSegments = Uri.parse(str).getPathSegments();
                    if (pathSegments.isEmpty()) {
                        return true;
                    }
                    int intValue = Integer.valueOf((String) pathSegments.get(0)).intValue();
                    if (intValue == 0) {
                        a.this.g.setVisibility(8);
                        a.this.j.setVisibility(0);
                    } else if (intValue == 1) {
                        a.this.g.setVisibility(0);
                    }
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            } else if (str.startsWith("auth://onLoginSubmit")) {
                try {
                    pathSegments = Uri.parse(str).getPathSegments();
                    if (!pathSegments.isEmpty()) {
                        a.this.p = (String) pathSegments.get(0);
                    }
                } catch (Exception unused2) {
                }
                return true;
            } else if (a.this.l.a(a.this.j, str)) {
                return true;
            } else {
                f.c("openSDK_LOG.AuthDialog", "-->Redirect URL: return false");
                return false;
            }
        }
    }

    /* compiled from: ProGuard */
    private class b implements IUiListener {
        String a;
        String b;
        private String d;
        private IUiListener e;

        public b(String str, String str2, String str3, IUiListener iUiListener) {
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
            g a = g.a();
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
            String stringBuilder;
            if (uiError.errorMessage != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(uiError.errorMessage);
                stringBuilder2.append(this.a);
                stringBuilder = stringBuilder2.toString();
            } else {
                stringBuilder = this.a;
            }
            g a = g.a();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.d);
            stringBuilder3.append("_H5");
            a.a(stringBuilder3.toString(), SystemClock.elapsedRealtime(), 0, 0, uiError.errorCode, stringBuilder, false);
            a.this.a(stringBuilder);
            if (this.e != null) {
                this.e.onError(uiError);
                this.e = null;
            }
        }
    }

    /* compiled from: ProGuard */
    private class c extends Handler {
        private b b;

        public c(b bVar, Looper looper) {
            super(looper);
            this.b = bVar;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.b.a((String) message.obj);
                    return;
                case 2:
                    this.b.onCancel();
                    return;
                case 3:
                    a.b(a.this.k, (String) message.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: ProGuard */
    class d implements Runnable {
        String a = "";

        public d(String str) {
            this.a = str;
        }

        public void run() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-->timeoutUrl: ");
            stringBuilder.append(this.a);
            stringBuilder.append(" | mRetryUrl: ");
            stringBuilder.append(a.this.o);
            f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
            if (this.a.equals(a.this.o)) {
                a.this.b.onError(new UiError(9002, "请求页面超时，请稍后重试！", a.this.o));
                a.this.dismiss();
            }
        }
    }

    public a(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.k = context;
        this.a = str2;
        this.b = new b(str, str2, qQToken.getAppId(), iUiListener);
        this.d = new c(this.b, context.getMainLooper());
        this.c = iUiListener;
        this.i = str;
        this.l = new com.tencent.open.web.security.b();
        getWindow().setSoftInputMode(32);
    }

    private String a() {
        String substring = this.a.substring(this.a.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR) + 1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        stringBuilder.append(substring);
        substring = stringBuilder.toString();
        f.c("openSDK_LOG.AuthDialog", "-->generateDownloadUrl, url: http://qzs.qq.com/open/mobile/login/qzsjump.html?");
        return substring;
    }

    private String a(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        if (!TextUtils.isEmpty(this.p) && this.p.length() >= 4) {
            str = this.p.substring(this.p.length() - 4);
            stringBuilder.append("_u_");
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private void b() {
        c();
        LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.j = new com.tencent.open.c.c(this.k);
        if (VERSION.SDK_INT >= 11) {
            this.j.setLayerType(1, null);
        }
        this.j.setLayoutParams(layoutParams);
        this.e = new FrameLayout(this.k);
        layoutParams.gravity = 17;
        this.e.setLayoutParams(layoutParams);
        this.e.addView(this.j);
        this.e.addView(this.g);
        setContentView(this.e);
    }

    private static void b(Context context, String str) {
        try {
            JSONObject d = j.d(str);
            int i = d.getInt("type");
            Toast.makeText(context.getApplicationContext(), d.getString("msg"), i).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void c() {
        View textView;
        this.h = new ProgressBar(this.k);
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f = new LinearLayout(this.k);
        if (this.i.equals("action_login")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            layoutParams.leftMargin = 5;
            textView = new TextView(this.k);
            if (Locale.getDefault().getLanguage().equals("zh")) {
                textView.setText("登录中...");
            } else {
                textView.setText("Logging in...");
            }
            textView.setTextColor(Color.rgb(255, 255, 255));
            textView.setTextSize(18.0f);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = null;
        }
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f.setLayoutParams(layoutParams2);
        this.f.addView(this.h);
        if (textView != null) {
            this.f.addView(textView);
        }
        this.g = new FrameLayout(this.k);
        layoutParams2 = new LayoutParams(-1, -2);
        layoutParams2.leftMargin = 80;
        layoutParams2.rightMargin = 80;
        layoutParams2.topMargin = 40;
        layoutParams2.bottomMargin = 40;
        layoutParams2.gravity = 17;
        this.g.setLayoutParams(layoutParams2);
        this.g.setBackgroundResource(17301504);
        this.g.addView(this.f);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void d() {
        this.j.setVerticalScrollBarEnabled(false);
        this.j.setHorizontalScrollBarEnabled(false);
        this.j.setWebViewClient(new a(this, null));
        this.j.setWebChromeClient(new WebChromeClient());
        this.j.clearFormData();
        this.j.clearSslPreferences();
        this.j.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.j.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                    case 1:
                        if (!view.hasFocus()) {
                            view.requestFocus();
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        WebSettings settings = this.j.getSettings();
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setCacheMode(-1);
        settings.setNeedInitialFocus(false);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);
        settings.setRenderPriority(RenderPriority.HIGH);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(this.k.getDir("databases", 0).getPath());
        settings.setDomStorageEnabled(true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->mUrl : ");
        stringBuilder.append(this.a);
        f.a("openSDK_LOG.AuthDialog", stringBuilder.toString());
        this.o = this.a;
        this.j.loadUrl(this.a);
        this.j.setVisibility(4);
        this.j.getSettings().setSavePassword(false);
        this.l.a((com.tencent.open.a.b) new SecureJsInterface(), "SecureJsInterface");
        SecureJsInterface.isPWDEdit = false;
        super.setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                try {
                    JniInterface.clearAllPWD();
                } catch (Exception unused) {
                }
            }
        });
    }

    private boolean e() {
        b a = b.a();
        String c = a.c();
        com.tencent.connect.auth.b.a aVar = new com.tencent.connect.auth.b.a();
        aVar.a = this.c;
        aVar.b = this;
        aVar.c = c;
        String a2 = a.a(aVar);
        String substring = this.a.substring(0, this.a.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR));
        Bundle b = j.b(this.a);
        b.putString("token_key", c);
        b.putString("serial", a2);
        b.putString("browser", "1");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(substring);
        stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR);
        stringBuilder.append(com.tencent.open.utils.HttpUtils.encodeUrl(b));
        this.a = stringBuilder.toString();
        return j.a(this.k, this.a);
    }

    public void a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(str);
        stringBuilder.append("(");
        stringBuilder.append(str2);
        stringBuilder.append(");void(");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(");");
        this.j.loadUrl(stringBuilder.toString());
    }

    public void dismiss() {
        this.s.clear();
        this.d.removeCallbacksAndMessages(null);
        if (isShowing()) {
            super.dismiss();
        }
        if (this.j != null) {
            this.j.destroy();
            this.j = null;
        }
    }

    public void onBackPressed() {
        if (!this.m) {
            this.b.onCancel();
        }
        super.onBackPressed();
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        b();
        d();
        this.s = new HashMap();
    }

    /* Access modifiers changed, original: protected */
    public void onStop() {
        super.onStop();
    }
}
