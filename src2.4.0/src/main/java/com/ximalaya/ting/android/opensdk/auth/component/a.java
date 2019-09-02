package com.ximalaya.ting.android.opensdk.auth.component;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.ximalaya.ting.android.opensdk.auth.call.IXmlyAuthListener;
import com.ximalaya.ting.android.opensdk.auth.exception.XmlyAuthException;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyAuth2AccessToken;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyErrorInfo;
import com.ximalaya.ting.android.opensdk.auth.utils.AccessTokenKeeper;
import com.ximalaya.ting.android.opensdk.auth.utils.Logger;
import com.ximalaya.ting.android.opensdk.auth.utils.h;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthXmlyWebViewClient */
public final class a extends f {
    private Activity b;
    private c c;
    private IXmlyAuthListener d;
    private boolean e = false;

    public a(Activity activity, c cVar) {
        this.b = activity;
        this.c = cVar;
        this.d = cVar.b();
    }

    private void a(final String str) {
        Bundle a = h.a(str);
        String string = a.getString("error_no");
        String string2 = a.getString("error_code");
        String string3 = a.getString("error_desc");
        if (string == null && string2 == null) {
            StringBuilder stringBuilder = new StringBuilder("requestAccessTokenInfo, request: method = get, url = ");
            stringBuilder.append(str);
            Logger.d("ContentValues", stringBuilder.toString());
            new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).followRedirects(false).build().newCall(new Builder().url(str).build()).enqueue(new Callback() {
                public final void onFailure(Call call, IOException iOException) {
                    if (a.this.d != null) {
                        a.this.d.onXmlyException(new XmlyAuthException(iOException.getMessage(), null, null));
                    }
                    iOException.printStackTrace();
                    StringBuilder stringBuilder = new StringBuilder("requestAccessTokenInfo, request failed, error message = ");
                    stringBuilder.append(iOException.getMessage());
                    Logger.d("ContentValues", stringBuilder.toString());
                }

                public final void onResponse(Call call, Response response) throws IOException {
                    StringBuilder stringBuilder;
                    int code = response.code();
                    String string = response.body().string();
                    if (response.isSuccessful()) {
                        if (TextUtils.isEmpty(string)) {
                            a.this.d.onXmlyException(new XmlyAuthException(String.valueOf(code), null, null));
                        } else {
                            XmlyAuth2AccessToken parseAccessToken = XmlyAuth2AccessToken.parseAccessToken(string);
                            try {
                                int optInt = new JSONObject(string).optInt("expires_in", 0);
                                if (a.this.d != null) {
                                    if (parseAccessToken == null || !parseAccessToken.isSessionValid()) {
                                        a.this.d.onXmlyException(new XmlyAuthException(String.valueOf(code), null, null));
                                        Logger.d("ContentValues", "Failed to receive access token by Web");
                                    } else {
                                        StringBuilder stringBuilder2 = new StringBuilder("Login Success! ");
                                        stringBuilder2.append(parseAccessToken.toString());
                                        Logger.d("ContentValues", stringBuilder2.toString());
                                        AccessTokenKeeper.clear(a.this.b);
                                        AccessTokenKeeper.writeAccessToken(a.this.b, parseAccessToken);
                                        parseAccessToken.setExpiresAt((long) optInt);
                                        a.this.d.onComplete(parseAccessToken.toBundle());
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            stringBuilder = new StringBuilder("redirectRequestAccessTokenInfo, request success, status code = ");
                            stringBuilder.append(code);
                            stringBuilder.append(", body = ");
                            stringBuilder.append(string);
                            stringBuilder.append(", redirectUrl");
                            stringBuilder.append(r5);
                            Logger.d("ContentValues", stringBuilder.toString());
                        }
                    } else if (TextUtils.isEmpty(string)) {
                        a.this.d.onXmlyException(new XmlyAuthException(String.valueOf(code), null, null));
                    } else {
                        XmlyErrorInfo parseErrorInfo = XmlyErrorInfo.parseErrorInfo(string);
                        if (parseErrorInfo != null) {
                            a.this.d.onXmlyException(new XmlyAuthException(parseErrorInfo.getErrorNo(), parseErrorInfo.getErrorCode(), parseErrorInfo.getErrorDesc()));
                        } else {
                            a.this.d.onXmlyException(new XmlyAuthException(String.valueOf(code), null, null));
                        }
                    }
                    Logger.d("ContentValues", "Failed to receive access token by Web");
                    stringBuilder = new StringBuilder("redirectRequestAccessTokenInfo, request success, status code = ");
                    stringBuilder.append(code);
                    stringBuilder.append(", body = ");
                    stringBuilder.append(string);
                    stringBuilder.append(", redirectUrl");
                    stringBuilder.append(r5);
                    Logger.d("ContentValues", stringBuilder.toString());
                }
            });
            return;
        }
        if (this.d != null) {
            this.d.onXmlyException(new XmlyAuthException(string2, string, string3));
        }
    }

    private void b(final String str) {
        StringBuilder stringBuilder = new StringBuilder("requestAccessTokenInfo, request: method = get, url = ");
        stringBuilder.append(str);
        Logger.d("ContentValues", stringBuilder.toString());
        new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).followRedirects(false).build().newCall(new Builder().url(str).build()).enqueue(/* anonymous class already generated */);
    }

    public final void onPageFinished(WebView webView, String str) {
        if (this.a != null) {
            this.a.onPageFinishedCallBack(webView, str);
        }
        super.onPageFinished(webView, str);
    }

    public final void onPageStarted(WebView webView, final String str, Bitmap bitmap) {
        if (this.a != null) {
            this.a.onPageStartedCallBack(webView, str, bitmap);
        }
        if (!str.startsWith(this.c.a().getRedirectUrl()) || this.e) {
            super.onPageStarted(webView, str, bitmap);
            return;
        }
        this.e = true;
        Bundle a = h.a(str);
        String string = a.getString("error_no");
        String string2 = a.getString("error_code");
        String string3 = a.getString("error_desc");
        if (string == null && string2 == null) {
            StringBuilder stringBuilder = new StringBuilder("requestAccessTokenInfo, request: method = get, url = ");
            stringBuilder.append(str);
            Logger.d("ContentValues", stringBuilder.toString());
            new OkHttpClient().newBuilder().connectTimeout(30, TimeUnit.SECONDS).followRedirects(false).build().newCall(new Builder().url(str).build()).enqueue(/* anonymous class already generated */);
        } else if (this.d != null) {
            this.d.onXmlyException(new XmlyAuthException(string2, string, string3));
        }
        webView.stopLoading();
        XmlyBrowserComponent.closeBrowser(this.b, this.c.c());
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (this.a != null) {
            this.a.onReceivedErrorCallBack(webView, i, str, str2);
        }
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.a != null) {
            this.a.onReceivedSslErrorCallBack(webView, sslErrorHandler, sslError);
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.a != null) {
            this.a.shouldOverrideUrlLoadingCallBack(webView, str);
        }
        if (!str.startsWith(XmlyBrowserComponent.BROWSER_CLOSE_SCHEME)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        if (this.d != null) {
            this.d.onCancel();
        }
        XmlyBrowserComponent.closeBrowser(this.b, this.c.c());
        return true;
    }
}
