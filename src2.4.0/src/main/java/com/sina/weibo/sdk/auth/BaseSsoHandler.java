package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.statistic.WBAgent;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.sina.weibo.sdk.utils.SecurityHelper;
import com.sina.weibo.sdk.utils.UIUtils;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbAuthConstants;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.WeiboCallbackManager;
import com.sina.weibo.sdk.web.WeiboSdkWebActivity;
import com.sina.weibo.sdk.web.param.AuthWebViewRequestParam;

public class BaseSsoHandler {
    protected static final String OAUTH2_BASE_URL = "https://open.weibo.cn/oauth2/authorize?";
    protected final int SSO_TYPE_INVALID = 3;
    protected WbAuthListener authListener;
    protected Activity mAuthActivity;
    protected int ssoRequestCode = -1;
    protected int ssoRequestType = 3;

    protected enum AuthType {
        ALL,
        SsoOnly,
        WebOnly
    }

    public BaseSsoHandler(Activity activity) {
        this.mAuthActivity = activity;
        AidTask.getInstance(this.mAuthActivity).aidTaskInit(WbSdk.getAuthInfo().getAppKey());
    }

    private void authorize(int i, WbAuthListener wbAuthListener, AuthType authType) {
        resetIntentFillData();
        if (wbAuthListener == null) {
            throw new RuntimeException("please set auth listener");
        }
        this.authListener = wbAuthListener;
        if (authType == AuthType.WebOnly) {
            if (wbAuthListener != null) {
                startWebAuth();
            }
            return;
        }
        Object obj = null;
        if (authType == AuthType.SsoOnly) {
            obj = 1;
        }
        if (isWbAppInstalled()) {
            startClientAuth(i);
        } else if (obj != null) {
            this.authListener.onFailure(new WbConnectErrorMessage());
        } else {
            startWebAuth();
        }
    }

    public void authorize(WbAuthListener wbAuthListener) {
        authorize(WbAuthConstants.REQUEST_CODE_SSO_AUTH, wbAuthListener, AuthType.ALL);
    }

    public void authorizeCallBack(int i, int i2, Intent intent) {
        if (WbAuthConstants.REQUEST_CODE_SSO_AUTH == i) {
            if (i2 == -1) {
                if (SecurityHelper.checkResponseAppLegal(this.mAuthActivity, WeiboAppManager.getInstance(this.mAuthActivity).getWbAppInfo(), intent)) {
                    String safeString = Utility.safeString(intent.getStringExtra("error"));
                    String safeString2 = Utility.safeString(intent.getStringExtra("error_type"));
                    String safeString3 = Utility.safeString(intent.getStringExtra("error_description"));
                    String str = WBAgent.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("error: ");
                    stringBuilder.append(safeString);
                    stringBuilder.append(", error_type: ");
                    stringBuilder.append(safeString2);
                    stringBuilder.append(", error_description: ");
                    stringBuilder.append(safeString3);
                    LogUtil.d(str, stringBuilder.toString());
                    if (TextUtils.isEmpty(safeString) && TextUtils.isEmpty(safeString2) && TextUtils.isEmpty(safeString3)) {
                        Oauth2AccessToken parseAccessToken = Oauth2AccessToken.parseAccessToken(intent.getExtras());
                        if (parseAccessToken != null && parseAccessToken.isSessionValid()) {
                            safeString2 = WBAgent.TAG;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Login Success! ");
                            stringBuilder2.append(parseAccessToken.toString());
                            LogUtil.d(safeString2, stringBuilder2.toString());
                            AccessTokenKeeper.writeAccessToken(this.mAuthActivity, parseAccessToken);
                            this.authListener.onSuccess(parseAccessToken);
                        }
                    } else if ("access_denied".equals(safeString) || "OAuthAccessDeniedException".equals(safeString)) {
                        LogUtil.d(WBAgent.TAG, "Login canceled by user.");
                        this.authListener.cancel();
                    } else {
                        String str2 = WBAgent.TAG;
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append("Login failed: ");
                        stringBuilder3.append(safeString);
                        LogUtil.d(str2, stringBuilder3.toString());
                        this.authListener.onFailure(new WbConnectErrorMessage(safeString2, safeString3));
                    }
                } else {
                    this.authListener.onFailure(new WbConnectErrorMessage(WbAuthConstants.AUTH_FAILED_INSTALL_APP_COUNTERFEIT_MESSAGE, WbAuthConstants.AUTH_FAILED_INSTALL_APP_COUNTERFEIT_CODE));
                }
            } else if (i2 == 0) {
                if (intent != null) {
                    this.authListener.cancel();
                } else {
                    this.authListener.cancel();
                }
            }
        }
    }

    public void authorizeClientSso(WbAuthListener wbAuthListener) {
        authorize(WbAuthConstants.REQUEST_CODE_SSO_AUTH, wbAuthListener, AuthType.SsoOnly);
    }

    public void authorizeWeb(WbAuthListener wbAuthListener) {
        authorize(WbAuthConstants.REQUEST_CODE_SSO_AUTH, wbAuthListener, AuthType.WebOnly);
    }

    /* Access modifiers changed, original: protected */
    public void couldNotStartWbSsoActivity() {
    }

    /* Access modifiers changed, original: protected */
    public void fillExtraIntent(Intent intent, int i) {
    }

    @Deprecated
    public boolean isWbAppInstalled() {
        return WbSdk.isWbInstall(this.mAuthActivity);
    }

    /* Access modifiers changed, original: protected */
    public void resetIntentFillData() {
        this.ssoRequestCode = WbAuthConstants.REQUEST_CODE_SSO_AUTH;
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0063 A:{Catch:{ Exception -> 0x0070 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x005f */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    public void startClientAuth(int r5) {
        /*
        r4 = this;
        r0 = r4.mAuthActivity;	 Catch:{ Exception -> 0x0070 }
        r0 = com.sina.weibo.sdk.WeiboAppManager.getInstance(r0);	 Catch:{ Exception -> 0x0070 }
        r0 = r0.getWbAppInfo();	 Catch:{ Exception -> 0x0070 }
        r1 = new android.content.Intent;	 Catch:{ Exception -> 0x0070 }
        r1.<init>();	 Catch:{ Exception -> 0x0070 }
        r2 = r0.getPackageName();	 Catch:{ Exception -> 0x0070 }
        r0 = r0.getAuthActivityName();	 Catch:{ Exception -> 0x0070 }
        r1.setClassName(r2, r0);	 Catch:{ Exception -> 0x0070 }
        r0 = com.sina.weibo.sdk.WbSdk.getAuthInfo();	 Catch:{ Exception -> 0x0070 }
        r0 = r0.getAuthBundle();	 Catch:{ Exception -> 0x0070 }
        r1.putExtras(r0);	 Catch:{ Exception -> 0x0070 }
        r0 = "_weibo_command_type";
        r2 = 3;
        r1.putExtra(r0, r2);	 Catch:{ Exception -> 0x0070 }
        r0 = "_weibo_transaction";
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0070 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x0070 }
        r1.putExtra(r0, r2);	 Catch:{ Exception -> 0x0070 }
        r0 = "aid";
        r2 = r4.mAuthActivity;	 Catch:{ Exception -> 0x0070 }
        r3 = com.sina.weibo.sdk.WbSdk.getAuthInfo();	 Catch:{ Exception -> 0x0070 }
        r3 = r3.getAppKey();	 Catch:{ Exception -> 0x0070 }
        r2 = com.sina.weibo.sdk.utils.Utility.getAid(r2, r3);	 Catch:{ Exception -> 0x0070 }
        r1.putExtra(r0, r2);	 Catch:{ Exception -> 0x0070 }
        r0 = r4.mAuthActivity;	 Catch:{ Exception -> 0x0070 }
        r0 = com.sina.weibo.sdk.utils.SecurityHelper.validateAppSignatureForIntent(r0, r1);	 Catch:{ Exception -> 0x0070 }
        if (r0 != 0) goto L_0x0054;
    L_0x0053:
        return;
    L_0x0054:
        r4.fillExtraIntent(r1, r5);	 Catch:{ Exception -> 0x0070 }
        r5 = r4.mAuthActivity;	 Catch:{ Exception -> 0x005f }
        r0 = r4.ssoRequestCode;	 Catch:{ Exception -> 0x005f }
        r5.startActivityForResult(r1, r0);	 Catch:{ Exception -> 0x005f }
        goto L_0x0070;
    L_0x005f:
        r5 = r4.authListener;	 Catch:{ Exception -> 0x0070 }
        if (r5 == 0) goto L_0x006d;
    L_0x0063:
        r5 = r4.authListener;	 Catch:{ Exception -> 0x0070 }
        r0 = new com.sina.weibo.sdk.auth.WbConnectErrorMessage;	 Catch:{ Exception -> 0x0070 }
        r0.<init>();	 Catch:{ Exception -> 0x0070 }
        r5.onFailure(r0);	 Catch:{ Exception -> 0x0070 }
    L_0x006d:
        r4.couldNotStartWbSsoActivity();	 Catch:{ Exception -> 0x0070 }
    L_0x0070:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.auth.BaseSsoHandler.startClientAuth(int):void");
    }

    /* Access modifiers changed, original: protected */
    public void startWebAuth() {
        AuthInfo authInfo = WbSdk.getAuthInfo();
        WeiboParameters weiboParameters = new WeiboParameters(authInfo.getAppKey());
        weiboParameters.put("client_id", authInfo.getAppKey());
        weiboParameters.put(WBConstants.AUTH_PARAMS_REDIRECT_URL, authInfo.getRedirectUrl());
        weiboParameters.put("scope", authInfo.getScope());
        weiboParameters.put(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE);
        weiboParameters.put("version", WbSdkVersion.WEIBO_SDK_VERSION_CODE);
        weiboParameters.put("luicode", "10000360");
        Oauth2AccessToken readAccessToken = AccessTokenKeeper.readAccessToken(this.mAuthActivity);
        if (!(readAccessToken == null || TextUtils.isEmpty(readAccessToken.getToken()))) {
            weiboParameters.put("trans_token", readAccessToken.getToken());
            weiboParameters.put("trans_access_token", readAccessToken.getToken());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OP_");
        stringBuilder.append(authInfo.getAppKey());
        weiboParameters.put("lfid", stringBuilder.toString());
        String aid = Utility.getAid(this.mAuthActivity, authInfo.getAppKey());
        if (!TextUtils.isEmpty(aid)) {
            weiboParameters.put("aid", aid);
        }
        weiboParameters.put("packagename", authInfo.getPackageName());
        weiboParameters.put("key_hash", authInfo.getKeyHash());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(OAUTH2_BASE_URL);
        stringBuilder2.append(weiboParameters.encodeUrl());
        String stringBuilder3 = stringBuilder2.toString();
        if (NetworkHelper.hasInternetPermission(this.mAuthActivity)) {
            String str;
            if (this.authListener != null) {
                WeiboCallbackManager instance = WeiboCallbackManager.getInstance();
                aid = instance.genCallbackKey();
                instance.setWeiboAuthListener(aid, this.authListener);
                str = aid;
            } else {
                str = null;
            }
            AuthWebViewRequestParam authWebViewRequestParam = new AuthWebViewRequestParam(authInfo, WebRequestType.AUTH, str, "微博登录", stringBuilder3, this.mAuthActivity);
            Intent intent = new Intent(this.mAuthActivity, WeiboSdkWebActivity.class);
            Bundle bundle = new Bundle();
            authWebViewRequestParam.fillBundle(bundle);
            intent.putExtras(bundle);
            this.mAuthActivity.startActivity(intent);
            return;
        }
        UIUtils.showAlert(this.mAuthActivity, "Error", "Application requires permission to access the Internet");
    }
}
