package com.ximalaya.ting.android.opensdk.auth.component;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ximalaya.ting.android.opensdk.auth.call.IXmSimpleLoginCallBack;
import com.ximalaya.ting.android.opensdk.auth.call.IXmlyAuthListener;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.ximalaya.ting.android.opensdk.auth.exception.XmlyAuthException;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyAuth2AccessToken;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyAuthInfo;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyErrorInfo;
import com.ximalaya.ting.android.opensdk.auth.utils.AccessTokenKeeper;
import com.ximalaya.ting.android.opensdk.auth.utils.Logger;
import com.ximalaya.ting.android.opensdk.auth.utils.h;
import com.ximalaya.ting.android.opensdk.auth.view.LoadingBar;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import s.h.e.l.l.C;

public class XmlyBrowserComponent extends Activity implements b {
    public static final String BROWSER_CLOSE_SCHEME = "ximalaya://browser/close";
    public static final int COLOR_BROWSER_LOAD_ERROR_BACKGROUND = -657931;
    public static final int COLOR_BROWSER_LOAD_ERROR_RETRY = -6710887;
    public static final int COLOR_BROWSER_TITLE_BAR_DIVIDER = -1513240;
    public static final int COLOR_BROWSER_TITLE_BAR_LEFT_BUTTON_NORMAL = -498622;
    public static final int COLOR_BROWSER_TITLE_BAR_LEFT_BUTTON_PRESSED = -6710887;
    public static final int COLOR_BROWSER_TITLE_BAR_TITLE = -13421773;
    private static final int CONNECT_TIME_OUT_SECOND = 15;
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String OAUTH2_BASE_URL = "https://api.ximalaya.com/oauth2/v2/authorize?";
    public static final String OBTAIN_AUTH_TYPE_CODE = "code";
    public static final String OBTAIN_AUTH_TYPE_TOKEN = "token";
    private static final String TAG = "XmlyBrowserComponent";
    public static IXmSimpleLoginCallBack mSimpleLogin;
    private boolean isErrorPage;
    private boolean isLoading;
    private XmlyAuthInfo mAuthInfo;
    private IXmlyAuthListener mAuthListener;
    private String mAuthListenerKey;
    private ImageView mBtnClose;
    private ImageView mBtnLeft;
    private Button mBtnRetry;
    private String mHtmlTitle;
    private LinearLayout mLoadingErrorView;
    private String mObtainAuthType = "";
    private LoadingBar mProgressBar;
    private d mRequestParam;
    private String mSpecifyTitle = "";
    private TextView mTvTitle;
    private String mUrl = "";
    private WebView mWebView;
    private f mWebViewClient;

    final class a {
        a() {
        }

        @JavascriptInterface
        public final void authorize(String str) {
            JSONException e;
            if (XmlyBrowserComponent.this.mProgressBar.getVisibility() != 0) {
                XmlyBrowserComponent.this.runOnUiThread(new Runnable() {
                    public final void run() {
                        XmlyBrowserComponent.this.setViewLoading();
                        XmlyBrowserComponent.this.mProgressBar.a(99);
                    }
                });
                String str2 = "";
                String str3 = "";
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        str = jSONObject.optString(XmlyConstants.AUTH_PARAMS_SSO_CODE);
                        try {
                            str3 = jSONObject.optString("scope");
                            str2 = str;
                        } catch (JSONException e2) {
                            JSONException jSONException = e2;
                            str2 = str;
                            e = jSONException;
                            e.printStackTrace();
                            XmlyBrowserComponent.this.startAuth(str2, str3);
                        }
                    } catch (JSONException e3) {
                        e = e3;
                        e.printStackTrace();
                        XmlyBrowserComponent.this.startAuth(str2, str3);
                    }
                }
                XmlyBrowserComponent.this.startAuth(str2, str3);
            }
        }

        @JavascriptInterface
        public final void handleErrorInfo(String str) {
            if (!TextUtils.isEmpty(str)) {
                XmlyErrorInfo parseErrorInfo = XmlyErrorInfo.parseErrorInfo(str.trim());
                if (parseErrorInfo != null) {
                    if (XmlyBrowserComponent.this.mAuthListener != null) {
                        XmlyBrowserComponent.this.mAuthListener.onXmlyException(new XmlyAuthException(parseErrorInfo.getErrorNo(), parseErrorInfo.getErrorCode(), parseErrorInfo.getErrorDesc()));
                    }
                    Logger.d(XmlyBrowserComponent.TAG, "Failed to receive access token by Web");
                    XmlyBrowserComponent.closeBrowser(XmlyBrowserComponent.this, XmlyBrowserComponent.this.mAuthListenerKey);
                }
            }
        }
    }

    private class b extends WebChromeClient {
        private b() {
        }

        /* synthetic */ b(XmlyBrowserComponent xmlyBrowserComponent, byte b) {
            this();
        }

        public final void onProgressChanged(WebView webView, int i) {
            XmlyBrowserComponent.this.mProgressBar.setVisibility(0);
            XmlyBrowserComponent.this.mProgressBar.a(i * 100);
            if (i == 100) {
                XmlyBrowserComponent.this.isLoading = false;
                XmlyBrowserComponent.this.refreshAllViews();
                return;
            }
            if (!XmlyBrowserComponent.this.isLoading) {
                XmlyBrowserComponent.this.isLoading = true;
                XmlyBrowserComponent.this.refreshAllViews();
            }
        }

        public final void onReceivedTitle(WebView webView, String str) {
            if (!XmlyBrowserComponent.this.isXmlyCustomScheme(XmlyBrowserComponent.this.mUrl)) {
                XmlyBrowserComponent.this.mHtmlTitle = str;
                XmlyBrowserComponent.this.updateTitleName();
            }
        }
    }

    static {
        C.i(16777269);
    }

    private native void authorizeCodeSuccessfully(Bundle bundle);

    public static native void closeBrowser(Activity activity, String str);

    private native d createBrowserRequestParam(Bundle bundle);

    private native int generateViewId();

    private native void handleErrorInfo(String str, String str2);

    private native void handleReceivedError(WebView webView, int i, String str, String str2);

    private native void hiddenErrorPrompt();

    private boolean initDataFromIntent(Intent intent) {
        String string;
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.mAuthInfo = XmlyAuthInfo.parseBundleData(this, extras.getBundle(c.a));
        }
        if (this.mAuthInfo == null) {
            this.mAuthInfo = new XmlyAuthInfo(this, "", "", "");
        } else {
            this.mObtainAuthType = this.mAuthInfo.getObtainAuthType();
        }
        this.mRequestParam = createBrowserRequestParam(extras);
        if (this.mRequestParam != null) {
            this.mUrl = this.mRequestParam.e();
            this.mSpecifyTitle = this.mRequestParam.f();
        } else {
            String string2 = extras.getString(d.f);
            string = extras.getString(d.g);
            if (!TextUtils.isEmpty(string2) && string2.startsWith("http")) {
                this.mUrl = string2;
                this.mSpecifyTitle = string;
            }
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            return false;
        }
        string = TAG;
        StringBuilder stringBuilder = new StringBuilder("LOAD URL : ");
        stringBuilder.append(this.mUrl);
        Logger.d(string, stringBuilder.toString());
        return true;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void initWebView() {
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        this.mWebView.addJavascriptInterface(new a(), "jscall");
        this.mWebView.getSettings().setSavePassword(false);
        this.mWebView.setWebViewClient(this.mWebViewClient);
        this.mWebView.setWebChromeClient(new b(this, (byte) 0));
        this.mWebView.requestFocus();
        this.mWebView.setScrollBarStyle(0);
        if (VERSION.SDK_INT >= 21) {
            this.mWebView.getSettings().setMixedContentMode(0);
        }
        if (VERSION.SDK_INT >= 11) {
            this.mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        } else {
            removeJavascriptInterface(this.mWebView);
        }
    }

    private native void installAuthWeiboWebViewClient(c cVar);

    private native boolean isXmlyCustomScheme(String str);

    private native void openUrl(String str);

    private native void promptError();

    private void redirectRequestAccessTokenInfo(final String str) {
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("redirectRequestAccessTokenInfo, request: method = get, url = ");
        stringBuilder.append(str);
        Logger.d(str2, stringBuilder.toString());
        new OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS).followRedirects(false).followSslRedirects(false).build().newCall(new Builder().url(str).build()).enqueue(new Callback() {
            public final void onFailure(Call call, IOException iOException) {
                XmlyBrowserComponent.this.handleErrorInfo(iOException.getMessage(), null);
                iOException.printStackTrace();
                String access$1200 = XmlyBrowserComponent.TAG;
                StringBuilder stringBuilder = new StringBuilder("redirectRequestAccessTokenInfo, request failed, error message = ");
                stringBuilder.append(iOException.getMessage());
                Logger.d(access$1200, stringBuilder.toString());
            }

            public final void onResponse(Call call, Response response) throws IOException {
                int code = response.code();
                String string = response.body().string();
                if (!response.isSuccessful()) {
                    XmlyBrowserComponent.this.handleErrorInfo(String.valueOf(code), string);
                } else if (!TextUtils.isEmpty(string)) {
                    try {
                        int optInt = new JSONObject(string).optInt("expires_in", 0);
                        XmlyAuth2AccessToken parseAccessToken = XmlyAuth2AccessToken.parseAccessToken(string);
                        if (parseAccessToken == null || !parseAccessToken.isSessionValid()) {
                            XmlyBrowserComponent.this.handleErrorInfo(String.valueOf(code), string);
                        } else {
                            String access$1200 = XmlyBrowserComponent.TAG;
                            StringBuilder stringBuilder = new StringBuilder("Login Success! ");
                            stringBuilder.append(parseAccessToken.toString());
                            Logger.d(access$1200, stringBuilder.toString());
                            AccessTokenKeeper.clear(XmlyBrowserComponent.this);
                            AccessTokenKeeper.writeAccessToken(XmlyBrowserComponent.this, parseAccessToken);
                            parseAccessToken.setExpiresAt((long) optInt);
                            if (XmlyBrowserComponent.this.mAuthListener != null) {
                                XmlyBrowserComponent.this.mAuthListener.onComplete(parseAccessToken.toBundle());
                            }
                            XmlyBrowserComponent.closeBrowser(XmlyBrowserComponent.this, XmlyBrowserComponent.this.mAuthListenerKey);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        XmlyBrowserComponent.this.handleErrorInfo(e.getMessage(), null);
                    }
                }
                String access$12002 = XmlyBrowserComponent.TAG;
                StringBuilder stringBuilder2 = new StringBuilder("redirectRequestAccessTokenInfo, request success, status code = ");
                stringBuilder2.append(code);
                stringBuilder2.append(", body = ");
                stringBuilder2.append(string);
                stringBuilder2.append(", redirectUrl");
                stringBuilder2.append(str);
                Logger.d(access$12002, stringBuilder2.toString());
            }
        });
    }

    private void removeJavascriptInterface(WebView webView) {
        if (VERSION.SDK_INT < 11) {
            try {
                webView.getClass().getDeclaredMethod("removeJavascriptInterface", new Class[0]).invoke("searchBoxJavaBridge_", new Object[0]);
            } catch (Exception e) {
                Logger.e(TAG, e.toString());
            }
        }
    }

    private native void setContentView();

    private native void setTopNavTitle();

    private native void setViewLoading();

    private native void setViewNormal();

    private void startAuth(final String str, String str2) {
        if (mSimpleLogin != null) {
            mSimpleLogin.request(new HashMap<String, String>() {
            }, new IDataCallBack<String>() {
                private void a(String str) {
                    XmlyBrowserComponent.this.authorizeCodeSuccessfully(h.a(str));
                }

                public final void onError(int i, String str) {
                    PrintStream printStream = System.out;
                    StringBuilder stringBuilder = new StringBuilder("XmlyBrowserComponent.onError  ");
                    stringBuilder.append(i);
                    stringBuilder.append("   ");
                    stringBuilder.append(str);
                    printStream.println(stringBuilder.toString());
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    XmlyBrowserComponent.this.authorizeCodeSuccessfully(h.a((String) obj));
                }
            });
            return;
        }
        OkHttpClient build = new OkHttpClient().newBuilder().connectTimeout(15, TimeUnit.SECONDS).followRedirects(false).followSslRedirects(false).build();
        RequestBody requestBody = null;
        try {
            FormBody.Builder builder = new FormBody.Builder();
            if (!TextUtils.isEmpty(this.mAuthInfo.getAppKey())) {
                builder.add(XmlyConstants.AUTH_PARAMS_CLIENT_ID, this.mAuthInfo.getAppKey());
            }
            builder.add(XmlyConstants.AUTH_PARAMS_RESPONSE_TYPE, "code");
            if (!TextUtils.isEmpty(this.mAuthInfo.getRedirectUrl())) {
                builder.addEncoded("redirect_uri", URLEncoder.encode(this.mAuthInfo.getRedirectUrl(), "UTF-8"));
            }
            if (!TextUtils.isEmpty(str)) {
                builder.add("sso_code", str);
            }
            if (!TextUtils.isEmpty(this.mAuthInfo.getDeviceId())) {
                builder.add("device_id", this.mAuthInfo.getDeviceId());
            }
            builder.add("client_os_type", ClientOSType.ANDROID);
            if (!TextUtils.isEmpty(this.mAuthInfo.getPackId())) {
                builder.add("pack_id", this.mAuthInfo.getPackId());
            }
            if (!TextUtils.isEmpty(this.mAuthInfo.getState())) {
                builder.add("state", this.mAuthInfo.getState());
            }
            if (!TextUtils.isEmpty(str2)) {
                builder.add("scope", str2);
            }
            requestBody = builder.build();
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
            str2 = "";
        }
        if (requestBody != null) {
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder("authorize, request: method = post, url = https://api.ximalaya.com/oauth2/v2/authorize?, body:client_id = ");
            stringBuilder.append(this.mAuthInfo.getAppKey());
            stringBuilder.append(", response_type = code, redirect_uri = ");
            stringBuilder.append(this.mAuthInfo.getRedirectUrl());
            stringBuilder.append(", sso_code = ");
            stringBuilder.append(str);
            stringBuilder.append(", device_id = ");
            stringBuilder.append(this.mAuthInfo.getDeviceId());
            stringBuilder.append(", client_os_type = ");
            stringBuilder.append(this.mAuthInfo.getClientOsType());
            stringBuilder.append(", pack_id = ");
            stringBuilder.append(this.mAuthInfo.getPackId());
            stringBuilder.append(", state = ");
            stringBuilder.append(this.mAuthInfo.getState());
            stringBuilder.append(", scope = ");
            stringBuilder.append(str2);
            Logger.d(str3, stringBuilder.toString());
            build.newCall(new Builder().url(OAUTH2_BASE_URL).post(requestBody).build()).enqueue(new Callback() {
                public final void onFailure(Call call, IOException iOException) {
                    XmlyBrowserComponent.this.handleErrorInfo(iOException.getMessage(), null);
                    iOException.printStackTrace();
                    String access$1200 = XmlyBrowserComponent.TAG;
                    StringBuilder stringBuilder = new StringBuilder("authorize, request failed, error message = ");
                    stringBuilder.append(iOException.getMessage());
                    Logger.d(access$1200, stringBuilder.toString());
                }

                public final void onResponse(Call call, Response response) throws IOException {
                    int code = response.code();
                    String string = response.body().string();
                    String str = "";
                    if (code == 302) {
                        str = response.headers().get("Location");
                        if (!TextUtils.isEmpty(str)) {
                            if (TextUtils.isEmpty(XmlyBrowserComponent.this.mObtainAuthType) || !XmlyBrowserComponent.this.mObtainAuthType.equalsIgnoreCase("code")) {
                                XmlyBrowserComponent.this.redirectRequestAccessTokenInfo(str);
                            } else {
                                XmlyBrowserComponent.this.authorizeCodeSuccessfully(h.a(str));
                            }
                        }
                    } else {
                        XmlyBrowserComponent.this.handleErrorInfo(String.valueOf(code), string);
                    }
                    String access$1200 = XmlyBrowserComponent.TAG;
                    StringBuilder stringBuilder = new StringBuilder("authorize, request success, status code = ");
                    stringBuilder.append(code);
                    stringBuilder.append(", body = ");
                    stringBuilder.append(string);
                    stringBuilder.append(", redirectUrl");
                    stringBuilder.append(str);
                    Logger.d(access$1200, stringBuilder.toString());
                }
            });
        }
    }

    private native void updateTitleName();

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native boolean onKeyUp(int i, KeyEvent keyEvent);

    public native void onPageFinishedCallBack(WebView webView, String str);

    public native void onPageStartedCallBack(WebView webView, String str, Bitmap bitmap);

    public native void onReceivedErrorCallBack(WebView webView, int i, String str, String str2);

    public native void onReceivedSslErrorCallBack(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    public native void onResume();

    public native void refreshAllViews();

    public native boolean shouldOverrideUrlLoadingCallBack(WebView webView, String str);
}
