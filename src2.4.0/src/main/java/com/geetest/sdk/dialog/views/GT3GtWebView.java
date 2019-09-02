package com.geetest.sdk.dialog.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.jiguang.net.HttpUtils;
import com.geetest.sdk.O00O00Oo;
import com.geetest.sdk.O00OO0O;
import com.geetest.sdk.O0OOO00;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;
import s.h.e.l.l.C;

public class GT3GtWebView extends WebView {
    private static final String O00000Oo = "GT3GtWebView";
    private static final String[] O00000o0 = new String[]{"getClass", "hashCode", "notify", "notifyAll", "equals", "toString", "wait"};
    public boolean O000000o;
    private Context O00000o;
    private String O00000oO = null;
    private HashMap<String, Object> O00000oo = new HashMap();
    private O00OO0O O0000O0o;
    private int O0000OOo = 15000;
    private String O0000Oo;
    private boolean O0000Oo0 = false;
    private O00O00Oo O0000OoO;
    private Runnable O0000Ooo;
    private Handler O0000o00 = null;

    private class O000000o extends WebChromeClient {
        private O000000o() {
        }

        /* synthetic */ O000000o(GT3GtWebView gT3GtWebView, byte b) {
            this();
        }

        public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            return ((webView instanceof GT3GtWebView) && GT3GtWebView.this.O000000o(str2, jsPromptResult)) ? true : super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        }

        public final void onProgressChanged(WebView webView, int i) {
            GT3GtWebView.O000000o(GT3GtWebView.this, webView);
            GT3GtWebView.O00000Oo;
            O0OOO00.O000000o();
            super.onProgressChanged(webView, i);
        }

        public final void onReceivedTitle(WebView webView, String str) {
            GT3GtWebView.O000000o(GT3GtWebView.this, webView);
        }
    }

    private class O00000Oo extends WebViewClient {
        private GT3GtWebView O00000Oo;

        public O00000Oo(GT3GtWebView gT3GtWebView) {
            this.O00000Oo = gT3GtWebView;
        }

        public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            GT3GtWebView.O000000o(GT3GtWebView.this, webView);
            super.doUpdateVisitedHistory(webView, str, z);
        }

        public final void onLoadResource(WebView webView, String str) {
            GT3GtWebView.O000000o(GT3GtWebView.this, webView);
            GT3GtWebView.O00000Oo;
            O0OOO00.O000000o("onLoadResource-->url: ".concat(String.valueOf(str)));
            super.onLoadResource(webView, str);
        }

        public final void onPageCommitVisible(WebView webView, String str) {
            super.onPageCommitVisible(webView, str);
        }

        public final void onPageFinished(WebView webView, String str) {
            GT3GtWebView.O00000Oo;
            O0OOO00.O000000o("Webview-->onPageFinished-->url: ".concat(String.valueOf(str)));
            GT3GtWebView.O000000o(GT3GtWebView.this, webView);
            super.onPageFinished(webView, str);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            GT3GtWebView.O00000Oo;
            O0OOO00.O000000o("Webview-->onPageStarted-->url: ".concat(String.valueOf(str)));
            GT3GtWebView.O000000o(GT3GtWebView.this, webView);
            super.onPageStarted(webView, str, bitmap);
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x00b0  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00bd A:{SYNTHETIC, Splitter:B:27:0x00bd} */
        public final void onReceivedError(android.webkit.WebView r6, android.webkit.WebResourceRequest r7, android.webkit.WebResourceError r8) {
            /*
            r5 = this;
            r0 = com.geetest.sdk.dialog.views.GT3GtWebView.this;
            r0 = r0.O0000O0o;
            if (r0 == 0) goto L_0x00b5;
        L_0x0008:
            r0 = 0;
            r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0092 }
            r2 = 21;
            if (r1 < r2) goto L_0x003d;
        L_0x000f:
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0092 }
            r2 = "onReceivedError-->url: ";
            r1.<init>(r2);	 Catch:{ Exception -> 0x0092 }
            r2 = r7.getUrl();	 Catch:{ Exception -> 0x0092 }
            r1.append(r2);	 Catch:{ Exception -> 0x0092 }
            r1 = r1.toString();	 Catch:{ Exception -> 0x0092 }
            com.geetest.sdk.dialog.views.GT3GtWebView.O00000Oo;	 Catch:{ Exception -> 0x003b }
            r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003b }
            r2 = "onReceivedError-->url: ";
            r0.<init>(r2);	 Catch:{ Exception -> 0x003b }
            r2 = r7.getUrl();	 Catch:{ Exception -> 0x003b }
            r0.append(r2);	 Catch:{ Exception -> 0x003b }
            r0 = r0.toString();	 Catch:{ Exception -> 0x003b }
            com.geetest.sdk.O0OOO00.O000000o(r0);	 Catch:{ Exception -> 0x003b }
            r0 = r1;
            goto L_0x003d;
        L_0x003b:
            r0 = move-exception;
            goto L_0x0096;
        L_0x003d:
            r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0092 }
            r2 = 23;
            if (r1 < r2) goto L_0x009a;
        L_0x0043:
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0092 }
            r2 = "onReceivedError-->Description: ";
            r1.<init>(r2);	 Catch:{ Exception -> 0x0092 }
            r2 = r8.getDescription();	 Catch:{ Exception -> 0x0092 }
            r1.append(r2);	 Catch:{ Exception -> 0x0092 }
            r2 = "-->onReceivedError-->ErrorCode: ";
            r1.append(r2);	 Catch:{ Exception -> 0x0092 }
            r2 = r8.getErrorCode();	 Catch:{ Exception -> 0x0092 }
            r1.append(r2);	 Catch:{ Exception -> 0x0092 }
            r1 = r1.toString();	 Catch:{ Exception -> 0x0092 }
            com.geetest.sdk.dialog.views.GT3GtWebView.O00000Oo;	 Catch:{ Exception -> 0x003b }
            r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003b }
            r2 = "onReceivedError-->Description: ";
            r0.<init>(r2);	 Catch:{ Exception -> 0x003b }
            r2 = r8.getDescription();	 Catch:{ Exception -> 0x003b }
            r0.append(r2);	 Catch:{ Exception -> 0x003b }
            r0 = r0.toString();	 Catch:{ Exception -> 0x003b }
            com.geetest.sdk.O0OOO00.O000000o(r0);	 Catch:{ Exception -> 0x003b }
            com.geetest.sdk.dialog.views.GT3GtWebView.O00000Oo;	 Catch:{ Exception -> 0x003b }
            r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003b }
            r2 = "onReceivedError-->ErrorCode: ";
            r0.<init>(r2);	 Catch:{ Exception -> 0x003b }
            r2 = r8.getErrorCode();	 Catch:{ Exception -> 0x003b }
            r0.append(r2);	 Catch:{ Exception -> 0x003b }
            r0 = r0.toString();	 Catch:{ Exception -> 0x003b }
            com.geetest.sdk.O0OOO00.O000000o(r0);	 Catch:{ Exception -> 0x003b }
            goto L_0x0099;
        L_0x0092:
            r1 = move-exception;
            r4 = r1;
            r1 = r0;
            r0 = r4;
        L_0x0096:
            r0.printStackTrace();
        L_0x0099:
            r0 = r1;
        L_0x009a:
            com.geetest.sdk.dialog.views.GT3GtWebView.O00000Oo;
            r1 = "webview加载出错 错误码：204_1 中间页地址有误或加载失败";
            com.geetest.sdk.O0OOO00.O000000o(r1);
            r1 = com.geetest.sdk.dialog.views.GT3GtWebView.this;
            r1 = r1.O0000O0o;
            r2 = "204_1";
            r3 = android.text.TextUtils.isEmpty(r0);
            if (r3 == 0) goto L_0x00b2;
        L_0x00b0:
            r0 = "Webview-->onReceivedError: webview load error !";
        L_0x00b2:
            r1.O000000o(r2, r0);
        L_0x00b5:
            r0 = com.geetest.sdk.dialog.views.GT3GtWebView.this;
            r0 = r0.O0000o00;
            if (r0 == 0) goto L_0x00d6;
        L_0x00bd:
            r0 = com.geetest.sdk.dialog.views.GT3GtWebView.this;	 Catch:{ Exception -> 0x00d6 }
            r0 = r0.O0000o00;	 Catch:{ Exception -> 0x00d6 }
            r1 = com.geetest.sdk.dialog.views.GT3GtWebView.this;	 Catch:{ Exception -> 0x00d6 }
            r1 = r1.O0000Ooo;	 Catch:{ Exception -> 0x00d6 }
            r0.removeCallbacks(r1);	 Catch:{ Exception -> 0x00d6 }
            r0 = com.geetest.sdk.dialog.views.GT3GtWebView.this;	 Catch:{ Exception -> 0x00d6 }
            r0 = r0.O0000o00;	 Catch:{ Exception -> 0x00d6 }
            r1 = 1;
            r0.removeMessages(r1);	 Catch:{ Exception -> 0x00d6 }
        L_0x00d6:
            super.onReceivedError(r6, r7, r8);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.dialog.views.GT3GtWebView$O00000Oo.onReceivedError(android.webkit.WebView, android.webkit.WebResourceRequest, android.webkit.WebResourceError):void");
        }

        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (VERSION.SDK_INT >= 21) {
                try {
                    String uri = webResourceRequest.getUrl().toString();
                    String substring = uri.substring(0, uri.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR));
                    GT3GtWebView.O00000Oo;
                    StringBuilder stringBuilder = new StringBuilder("onReceivedHttpError-->getStatusCode: ");
                    stringBuilder.append(webResourceResponse.getStatusCode());
                    O0OOO00.O000000o(stringBuilder.toString());
                    GT3GtWebView.O00000Oo;
                    O0OOO00.O000000o("onReceivedHttpError-->url: ".concat(String.valueOf(uri)));
                    if (!TextUtils.isEmpty(GT3GtWebView.this.O0000Oo) && TextUtils.equals(substring, GT3GtWebView.this.O0000Oo.substring(0, GT3GtWebView.this.O0000Oo.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR)))) {
                        List O000000o = GT3GtWebView.this.O0000OoO.O0000o0O().O000000o();
                        if (O000000o != null && O000000o.size() > 1) {
                            GT3GtWebView gT3GtWebView = this.O00000Oo;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(String.format("https://%s/static/appweb/app3-index.html", new Object[]{O000000o.get(1)}));
                            stringBuilder2.append(uri.substring(uri.indexOf(HttpUtils.URL_AND_PARA_SEPARATOR)));
                            gT3GtWebView.loadUrl(stringBuilder2.toString());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (GT3GtWebView.this.O0000O0o != null) {
                GT3GtWebView.O00000Oo;
                StringBuilder stringBuilder = new StringBuilder("onReceivedSslError-->webview加载出错 错误码：204_2 网络证书有误, ");
                stringBuilder.append(sslError.toString());
                O0OOO00.O000000o(stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder("Webview-->onReceivedSslError: ");
                stringBuilder2.append(sslError.toString());
                GT3GtWebView.this.O0000O0o.O000000o("204_2", stringBuilder2.toString());
            }
            if (GT3GtWebView.this.O0000o00 != null) {
                try {
                    GT3GtWebView.this.O0000o00.removeCallbacks(GT3GtWebView.this.O0000Ooo);
                    GT3GtWebView.this.O0000o00.removeMessages(1);
                } catch (Exception unused) {
                }
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!(webView == null || str == null || GT3GtWebView.this.O00000o == null)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    GT3GtWebView.this.O00000o.startActivity(intent);
                } catch (Exception unused) {
                }
            }
            GT3GtWebView.O00000Oo;
            O0OOO00.O000000o();
            return true;
        }
    }

    static {
        C.i(19);
    }

    protected GT3GtWebView(Context context) {
        super(context);
        this.O00000o = context;
    }

    private static native void O000000o(String str, Object obj, StringBuilder stringBuilder);

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055 A:{Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x005e }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052 A:{Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x005e }} */
    private boolean O000000o(android.webkit.JsPromptResult r7, java.lang.String r8, java.lang.String r9, java.lang.Object[] r10) {
        /*
        r6 = this;
        r0 = r6.O00000oo;
        r8 = r0.get(r8);
        r0 = 0;
        if (r8 != 0) goto L_0x000d;
    L_0x0009:
        r7.cancel();
        return r0;
    L_0x000d:
        r1 = 0;
        if (r10 == 0) goto L_0x0012;
    L_0x0010:
        r2 = r10.length;
        goto L_0x0013;
    L_0x0012:
        r2 = r0;
    L_0x0013:
        if (r2 <= 0) goto L_0x0035;
    L_0x0015:
        r1 = new java.lang.Class[r2];
        r3 = r0;
    L_0x0018:
        if (r3 >= r2) goto L_0x0035;
    L_0x001a:
        r4 = r10[r3];
        r4 = r4.getClass();
        r5 = java.lang.Integer.class;
        if (r4 != r5) goto L_0x0027;
    L_0x0024:
        r4 = java.lang.Integer.TYPE;
        goto L_0x0030;
    L_0x0027:
        r5 = java.lang.Boolean.class;
        if (r4 != r5) goto L_0x002e;
    L_0x002b:
        r4 = java.lang.Boolean.TYPE;
        goto L_0x0030;
    L_0x002e:
        r4 = java.lang.String.class;
    L_0x0030:
        r1[r3] = r4;
        r3 = r3 + 1;
        goto L_0x0018;
    L_0x0035:
        r2 = 1;
        r3 = r8.getClass();	 Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x005e }
        r9 = r3.getMethod(r9, r1);	 Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x005e }
        r8 = r9.invoke(r8, r10);	 Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x005e }
        if (r8 == 0) goto L_0x004f;
    L_0x0044:
        r9 = r8.getClass();	 Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x005e }
        r10 = java.lang.Void.TYPE;	 Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x005e }
        if (r9 != r10) goto L_0x004d;
    L_0x004c:
        goto L_0x004f;
    L_0x004d:
        r9 = r0;
        goto L_0x0050;
    L_0x004f:
        r9 = r2;
    L_0x0050:
        if (r9 == 0) goto L_0x0055;
    L_0x0052:
        r8 = "";
        goto L_0x0059;
    L_0x0055:
        r8 = r8.toString();	 Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x005e }
    L_0x0059:
        r7.confirm(r8);	 Catch:{ NoSuchMethodException -> 0x0063, Exception -> 0x005e }
        r0 = r2;
        goto L_0x0067;
    L_0x005e:
        r8 = move-exception;
        r8.printStackTrace();
        goto L_0x0067;
    L_0x0063:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0067:
        r7.cancel();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.sdk.dialog.views.GT3GtWebView.O000000o(android.webkit.JsPromptResult, java.lang.String, java.lang.String, java.lang.Object[]):boolean");
    }

    private static native boolean O000000o(String str);

    private boolean O000000o(String str, JsPromptResult jsPromptResult) {
        String str2 = "GtApp:";
        if (!str.startsWith(str2)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str.substring(str2.length()));
            str = jSONObject.getString("obj");
            String string = jSONObject.getString("func");
            JSONArray jSONArray = jSONObject.getJSONArray("args");
            Object[] objArr = null;
            if (jSONArray != null) {
                int length = jSONArray.length();
                if (length > 0) {
                    objArr = new Object[length];
                    for (int i = 0; i < length; i++) {
                        objArr[i] = jSONArray.get(i);
                    }
                }
            }
            if (O000000o(jsPromptResult, str, string, objArr)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        jsPromptResult.cancel();
        return false;
    }

    private native void O00000o();

    private native void O00000oO();

    private String O00000oo() {
        if (this.O00000oo.size() == 0) {
            this.O00000oO = null;
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:(function JsAddJavascriptInterface_(){");
        for (Entry entry : this.O00000oo.entrySet()) {
            try {
                O000000o((String) entry.getKey(), entry.getValue(), stringBuilder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        stringBuilder.append("})()");
        return stringBuilder.toString();
    }

    private static native boolean O0000O0o();

    public final native boolean O000000o();

    public final native void O00000Oo();

    @SuppressLint({"JavascriptInterface"})
    public void addJavascriptInterface(Object obj, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (O0000O0o()) {
                super.addJavascriptInterface(obj, str);
            } else {
                this.O00000oo.put(str, obj);
            }
        }
    }

    public native void destroy();

    public native Handler getMyHandler();

    public native Runnable getRunnable();

    public void loadUrl(String str, Map<String, String> map) {
        if (!this.O000000o) {
            super.loadUrl(str, map);
        }
    }

    public native void onDetachedFromWindow();

    public native void onPause();

    public native void onResume();

    public native void removeJavascriptInterface(String str);

    public native void setDataBean(O00O00Oo o00O00Oo);

    public native void setMyHandler(Handler handler);

    public native void setObservable(O00OO0O o00oo0o);

    public native void setRunnable(Runnable runnable);

    public native void setStaticUrl(String str);

    public native void setTimeout(int i);

    public native void setVoice(boolean z);
}
