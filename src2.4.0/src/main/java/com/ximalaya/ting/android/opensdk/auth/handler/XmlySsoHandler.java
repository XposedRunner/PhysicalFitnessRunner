package com.ximalaya.ting.android.opensdk.auth.handler;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.auth.call.IXmlyAuthListener;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyAuthErrorNoConstants;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.RequestParams;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ResponseParams;
import com.ximalaya.ting.android.opensdk.auth.exception.XmlyAuthException;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyAuth2AccessToken;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyAuthInfo;
import com.ximalaya.ting.android.opensdk.auth.utils.AccessTokenKeeper;
import com.ximalaya.ting.android.opensdk.auth.utils.Logger;
import com.ximalaya.ting.android.opensdk.auth.utils.a;
import com.ximalaya.ting.android.opensdk.auth.utils.b;
import com.ximalaya.ting.android.opensdk.auth.utils.c;
import com.ximalaya.ting.android.opensdk.auth.utils.e;
import com.ximalaya.ting.android.opensdk.auth.utils.g;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest$IRequestCallBack;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import java.util.HashMap;
import org.json.JSONObject;

public class XmlySsoHandler {
    public static final String OBTAIN_AUTH_TYPE_CODE = "code";
    public static final String OBTAIN_AUTH_TYPE_TOKEN = "token";
    private static final int REQUEST_CODE_SSO_AUTH = 4096;
    private static final String SSO_ACTIVITY_NAME = "com.ximalaya.ting.android.activity.account.LoginActivity";
    private static final String SSO_PACKAGE_NAME = "com.ximalaya.ting.android";
    private static final String TAG = "XmlySsoHandler";
    private Activity mAuthActivity;
    private XmlyAuthInfo mAuthInfo;
    private IXmlyAuthListener mAuthListener;
    private a mThirdAuthHandler;
    private b mWebAuthHandler;

    public XmlySsoHandler(Activity activity, XmlyAuthInfo xmlyAuthInfo) {
        this.mAuthActivity = activity;
        this.mAuthInfo = xmlyAuthInfo;
        this.mWebAuthHandler = new b(activity, xmlyAuthInfo);
        this.mThirdAuthHandler = new a(activity);
    }

    private boolean isXmlyAppInstalled() {
        return a.b(this.mAuthActivity, SSO_PACKAGE_NAME);
    }

    private boolean startSingleSignOn(String str, boolean z) {
        Intent intent = new Intent();
        intent.setClassName(SSO_PACKAGE_NAME, SSO_ACTIVITY_NAME);
        intent.putExtra(RequestParams.BUNDLE_KEY_IS_LOGIN_FROM_OAUTH_SDK, true);
        intent.putExtra(RequestParams.BUNDLE_KEY_IS_QUICK_LOGIN_TYPE, z);
        if (TextUtils.isEmpty(str)) {
            this.mAuthInfo.setObtainAuthType("token");
        } else {
            this.mAuthInfo.setObtainAuthType(str);
        }
        this.mAuthInfo.setClientOsType(ClientOSType.ANDROID);
        intent.putExtras(this.mAuthInfo.getAuthBundle());
        if (e.a(this.mAuthActivity, intent)) {
            if (e.b(this.mAuthActivity, SSO_PACKAGE_NAME) >= XmPlayerService.CODE_GET_SUGGEST_ALBUMS) {
                try {
                    this.mAuthActivity.startActivityForResult(intent, REQUEST_CODE_SSO_AUTH);
                    return true;
                } catch (ActivityNotFoundException unused) {
                    return false;
                }
            }
        }
        return false;
    }

    public void authorize(IXmlyAuthListener iXmlyAuthListener) {
        if (!c.b(this.mAuthActivity)) {
            g.a(this.mAuthActivity, "网络不给力，稍后再试试");
        }
        this.mAuthListener = iXmlyAuthListener;
        if (iXmlyAuthListener == null) {
            return;
        }
        if (!isXmlyAppInstalled() || !startSingleSignOn("token", false)) {
            this.mWebAuthHandler.a(iXmlyAuthListener);
        }
    }

    public void authorize(IXmlyAuthListener iXmlyAuthListener, String str) {
        if (!c.b(this.mAuthActivity)) {
            g.a(this.mAuthActivity, "网络不给力，稍后再试试");
        }
        this.mAuthListener = iXmlyAuthListener;
        if (iXmlyAuthListener == null) {
            return;
        }
        if (!isXmlyAppInstalled() || !startSingleSignOn(str, false)) {
            this.mWebAuthHandler.a(iXmlyAuthListener);
        }
    }

    public void authorizeByThird(String str, String str2, IXmlyAuthListener iXmlyAuthListener) {
        if (!c.b(this.mAuthActivity)) {
            g.a(this.mAuthActivity, "网络不给力，稍后再试试");
        }
        this.mAuthListener = iXmlyAuthListener;
        if (iXmlyAuthListener != null) {
            a aVar = this.mThirdAuthHandler;
            HashMap hashMap = new HashMap();
            hashMap.put(XmlyConstants.AUTH_PARAMS_GRANT_TYPE, "token_exchange");
            long currentTimeMillis = System.currentTimeMillis();
            hashMap.put("nonce", b.a(String.valueOf(currentTimeMillis)));
            hashMap.put("timestamp", String.valueOf(currentTimeMillis));
            hashMap.put("third_uid", str);
            hashMap.put("third_token", str2);
            try {
                hashMap.put(XmlyConstants.AUTH_PARAMS_CLIENT_ID, CommonRequest.getInstanse().getAppKey());
            } catch (XimalayaException e) {
                e.printStackTrace();
            }
            CommonRequest.basePostRequest(DTransferConstants.GET_THIRD_LOGIN, hashMap, new IDataCallBack<a>(str, iXmlyAuthListener) {
                private void a(a aVar) {
                    if (aVar != null) {
                        XmlyAuth2AccessToken xmlyAuth2AccessToken = new XmlyAuth2AccessToken(aVar.b(), aVar.a());
                        xmlyAuth2AccessToken.setUid(r6);
                        if (r8 != null) {
                            if (xmlyAuth2AccessToken.isSessionValid()) {
                                AccessTokenKeeper.clear(a.this.c);
                                AccessTokenKeeper.writeAccessToken(a.this.c, xmlyAuth2AccessToken);
                                r8.onComplete(xmlyAuth2AccessToken.toBundle());
                                return;
                            }
                            r8.onXmlyException(new XmlyAuthException("token 失效", null, "token 失效"));
                            Logger.d(a.a, "Failed to receive access token by Web");
                        }
                        return;
                    }
                    if (r8 != null) {
                        r8.onXmlyException(new XmlyAuthException("json 转换失败", "1007", "json 转换失败"));
                    }
                }

                public final void onError(int i, String str) {
                    IXmlyAuthListener iXmlyAuthListener = r8;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append(":");
                    stringBuilder.append(str);
                    iXmlyAuthListener.onXmlyException(new XmlyAuthException(stringBuilder.toString(), str, str));
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    a aVar = (a) obj;
                    if (aVar != null) {
                        XmlyAuth2AccessToken xmlyAuth2AccessToken = new XmlyAuth2AccessToken(aVar.b(), aVar.a());
                        xmlyAuth2AccessToken.setUid(r6);
                        if (r8 != null) {
                            if (xmlyAuth2AccessToken.isSessionValid()) {
                                AccessTokenKeeper.clear(a.this.c);
                                AccessTokenKeeper.writeAccessToken(a.this.c, xmlyAuth2AccessToken);
                                r8.onComplete(xmlyAuth2AccessToken.toBundle());
                                return;
                            }
                            r8.onXmlyException(new XmlyAuthException("token 失效", null, "token 失效"));
                            Logger.d(a.a, "Failed to receive access token by Web");
                        }
                        return;
                    }
                    if (r8 != null) {
                        r8.onXmlyException(new XmlyAuthException("json 转换失败", "1007", "json 转换失败"));
                    }
                }
            }, new CommonRequest$IRequestCallBack<a>(str) {
                private a a(String str) throws Exception {
                    JSONObject jSONObject = new JSONObject(str);
                    return new a(jSONObject.optString("access_token"), jSONObject.optString("expires_in"), r6);
                }

                public final /* synthetic */ Object success(String str) throws Exception {
                    JSONObject jSONObject = new JSONObject(str);
                    return new a(jSONObject.optString("access_token"), jSONObject.optString("expires_in"), r6);
                }
            });
        }
    }

    @WorkerThread
    public Bundle authorizeByThirdSync(String str, String str2) {
        if (!c.b(this.mAuthActivity)) {
            g.a(this.mAuthActivity, "网络不给力，稍后再试试");
        }
        return this.mThirdAuthHandler.a(str, str2);
    }

    public void authorizeCallBack(int i, int i2, Intent intent) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("requestCode: ");
        stringBuilder.append(i);
        stringBuilder.append(", resultCode: ");
        stringBuilder.append(i2);
        stringBuilder.append(", data: ");
        stringBuilder.append(intent);
        Logger.d(str, stringBuilder.toString());
        if (i == REQUEST_CODE_SSO_AUTH) {
            String stringExtra;
            String stringExtra2;
            String str2;
            StringBuilder stringBuilder2;
            if (i2 == -1) {
                Context context = this.mAuthActivity;
                stringExtra = intent != null ? intent.getStringExtra(XmlyConstants.XMLY_TING_APP_PACKAGE_NAME) : null;
                Object obj = (stringExtra == null || !e.a(context, stringExtra)) ? null : 1;
                if (obj != null) {
                    stringExtra2 = intent.getStringExtra("error");
                    if (stringExtra2 == null) {
                        stringExtra2 = intent.getStringExtra("error_no");
                    }
                    if (stringExtra2 == null) {
                        Bundle extras = intent.getExtras();
                        XmlyAuth2AccessToken parseAccessToken = XmlyAuth2AccessToken.parseAccessToken(extras);
                        if (parseAccessToken == null || !parseAccessToken.isSessionValid()) {
                            Logger.d(TAG, "Failed to receive access token by SSO");
                            this.mWebAuthHandler.a(this.mAuthListener);
                            return;
                        }
                        str2 = TAG;
                        StringBuilder stringBuilder3 = new StringBuilder("Login Success! ");
                        stringBuilder3.append(parseAccessToken.toString());
                        Logger.d(str2, stringBuilder3.toString());
                        AccessTokenKeeper.clear(this.mAuthActivity);
                        AccessTokenKeeper.writeAccessToken(this.mAuthActivity, parseAccessToken);
                        this.mAuthListener.onComplete(extras);
                    } else if (stringExtra2.equals("access_denied") || stringExtra2.equals("OAuthAccessDeniedException")) {
                        Logger.d(TAG, "Login canceled by user.");
                        this.mAuthListener.onCancel();
                    } else {
                        stringExtra = intent.getStringExtra("error_desc");
                        if (stringExtra != null) {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(stringExtra2);
                            stringBuilder2.append(":");
                            stringBuilder2.append(stringExtra);
                            stringExtra2 = stringBuilder2.toString();
                        }
                        str2 = TAG;
                        stringBuilder = new StringBuilder("Login failed: ");
                        stringBuilder.append(stringExtra2);
                        Logger.d(str2, stringBuilder.toString());
                        this.mAuthListener.onXmlyException(new XmlyAuthException(stringExtra2, null, stringExtra));
                    }
                }
            } else if (i2 == 0) {
                if (intent != null) {
                    stringExtra2 = intent.getStringExtra("error");
                    if (TextUtils.isEmpty(stringExtra2)) {
                        stringExtra2 = intent.getStringExtra("error_no");
                        stringExtra = intent.getStringExtra("error_code");
                        str = intent.getStringExtra("error_desc");
                        if (TextUtils.isEmpty(intent.getStringExtra(ResponseParams.BUNDLE_KEY_ERROR_SERVICE))) {
                            str2 = "";
                        } else {
                            stringBuilder2 = new StringBuilder(" error service");
                            stringBuilder2.append(str);
                            str2 = stringBuilder2.toString();
                        }
                        String str3 = TAG;
                        StringBuilder stringBuilder4 = new StringBuilder("Login failed: error no = ");
                        stringBuilder4.append(stringExtra2);
                        stringBuilder4.append(" error code = ");
                        stringBuilder4.append(stringExtra);
                        stringBuilder4.append(" error desc = ");
                        stringBuilder4.append(str);
                        stringBuilder4.append(str2);
                        Logger.d(str3, stringBuilder4.toString());
                        if (TextUtils.equals(XmlyAuthErrorNoConstants.XM_OAUTH2_ACCESS_USER_LOGIN_FAILED, stringExtra2)) {
                            this.mWebAuthHandler.a(this.mAuthListener);
                            return;
                        } else {
                            this.mAuthListener.onXmlyException(new XmlyAuthException(stringExtra2, stringExtra, str));
                            return;
                        }
                    }
                    stringExtra = TAG;
                    stringBuilder2 = new StringBuilder("Login failed: ");
                    stringBuilder2.append(stringExtra2);
                    Logger.d(stringExtra, stringBuilder2.toString());
                    this.mAuthListener.onXmlyException(new XmlyAuthException(stringExtra2, null, null));
                    return;
                }
                Logger.d(TAG, "Login canceled by user.");
                this.mAuthListener.onCancel();
            }
        }
    }

    public void authorizeWeb(IXmlyAuthListener iXmlyAuthListener) {
        if (!c.b(this.mAuthActivity)) {
            g.a(this.mAuthActivity, "网络不给力，稍后再试试");
        }
        if (iXmlyAuthListener != null) {
            this.mWebAuthHandler.a(iXmlyAuthListener);
        }
    }

    public void registerAndAuthorize(IXmlyAuthListener iXmlyAuthListener) {
        if (!c.b(this.mAuthActivity)) {
            g.a(this.mAuthActivity, "网络不给力，稍后再试试");
        }
        this.mAuthListener = iXmlyAuthListener;
        if (iXmlyAuthListener == null) {
            return;
        }
        if (!isXmlyAppInstalled() || !startSingleSignOn("token", true)) {
            this.mWebAuthHandler.b(iXmlyAuthListener);
        }
    }
}
