package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBConstants.Base;
import com.sina.weibo.sdk.constant.WBConstants.Msg;
import com.sina.weibo.sdk.constant.WBConstants.Response;
import com.sina.weibo.sdk.constant.WBConstants.SDK;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.param.ShareWebViewRequestParam;

public class WbShareHandler {
    private Activity context;
    private boolean hasRegister = false;
    private int progressColor = -1;
    private int progressId = -1;

    public WbShareHandler(Activity activity) {
        this.context = activity;
    }

    private void sendBroadcast(Context context, String str, String str2, String str3, Bundle bundle) {
        Intent intent = new Intent(str);
        str = context.getPackageName();
        intent.putExtra(Base.SDK_VER, WbSdkVersion.WEIBO_SDK_VERSION_CODE);
        intent.putExtra(Base.APP_PKG, str);
        intent.putExtra(Base.APP_KEY, str2);
        intent.putExtra(SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
        intent.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(context, str)));
        if (!TextUtils.isEmpty(str3)) {
            intent.setPackage(str3);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.sendBroadcast(intent, WBConstants.ACTION_WEIBO_SDK_PERMISSION);
    }

    private void startClientShare(WeiboMultiMessage weiboMultiMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(WBConstants.COMMAND_TYPE_KEY, 1);
        bundle.putString(WBConstants.TRAN, String.valueOf(System.currentTimeMillis()));
        bundle.putLong(WBConstants.SHARE_CALLBACK_ID, 0);
        bundle.putAll(weiboMultiMessage.toBundle(bundle));
        Intent intent = new Intent();
        intent.setClass(this.context, WbShareTransActivity.class);
        intent.putExtra(WBConstants.SHARE_START_PACKAGE, WeiboAppManager.getInstance(this.context).getWbAppInfo().getPackageName());
        intent.putExtra(WBConstants.SHARE_START_ACTION, WBConstants.ACTIVITY_WEIBO);
        intent.putExtra(WBConstants.SHARE_START_FLAG, 0);
        intent.putExtra(WBConstants.SHARE_START_ACTIVITY, this.context.getClass().getName());
        intent.putExtra(WBConstants.TRANS_PROGRESS_COLOR, this.progressColor);
        intent.putExtra(WBConstants.TRANS_PROGRESS_ID, this.progressId);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        try {
            this.context.startActivity(intent);
        } catch (Exception e) {
            LogUtil.v("weibo sdk error ", e.toString());
        }
    }

    private void startWebShare(WeiboMultiMessage weiboMultiMessage) {
        Intent intent = new Intent(this.context, WbShareTransActivity.class);
        String packageName = this.context.getPackageName();
        ShareWebViewRequestParam shareWebViewRequestParam = new ShareWebViewRequestParam(WbSdk.getAuthInfo(), WebRequestType.SHARE, "", 1, "微博分享", null, this.context);
        shareWebViewRequestParam.setContext(this.context);
        shareWebViewRequestParam.setHashKey("");
        shareWebViewRequestParam.setPackageName(packageName);
        Oauth2AccessToken readAccessToken = AccessTokenKeeper.readAccessToken(this.context);
        if (!(readAccessToken == null || TextUtils.isEmpty(readAccessToken.getToken()))) {
            shareWebViewRequestParam.setToken(readAccessToken.getToken());
        }
        shareWebViewRequestParam.setMultiMessage(weiboMultiMessage);
        Bundle bundle = new Bundle();
        shareWebViewRequestParam.fillBundle(bundle);
        intent.putExtras(bundle);
        intent.putExtra(WBConstants.SHARE_START_FLAG, 0);
        intent.putExtra(WBConstants.SHARE_START_ACTIVITY, this.context.getClass().getName());
        intent.putExtra(WBConstants.SHARE_START_ACTION, WBConstants.ACTIVITY_WEIBO);
        intent.putExtra(WBConstants.SHARE_START_GOTO_ACTIVITY, "com.sina.weibo.sdk.web.WeiboSdkWebActivity");
        this.context.startActivity(intent);
    }

    public void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        if (wbShareCallback != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                switch (extras.getInt(Response.ERRCODE, -1)) {
                    case 0:
                        wbShareCallback.onWbShareSuccess();
                        break;
                    case 1:
                        wbShareCallback.onWbShareCancel();
                        break;
                    case 2:
                        wbShareCallback.onWbShareFail();
                        break;
                }
            }
        }
    }

    @Deprecated
    public boolean isWbAppInstalled() {
        return WbSdk.isWbInstall(this.context);
    }

    public boolean registerApp() {
        sendBroadcast(this.context, WBConstants.ACTION_WEIBO_REGISTER, WbSdk.getAuthInfo().getAppKey(), null, null);
        this.hasRegister = true;
        return true;
    }

    public void setProgressColor(int i) {
        this.progressColor = i;
    }

    public void setProgressId(int i) {
        this.progressId = i;
    }

    public void shareMessage(WeiboMultiMessage weiboMultiMessage, boolean z) {
        if (!this.hasRegister) {
            throw new RuntimeException("please call WbShareHandler.registerApp(),before use share function");
        } else if (!WbSdk.isWbInstall(this.context) && z) {
        } else {
            if (z) {
                startClientShare(weiboMultiMessage);
                return;
            }
            if (!WbSdk.isWbInstall(this.context) || WeiboAppManager.getInstance(this.context).getWbAppInfo().getSupportVersion() <= 10000) {
                startWebShare(weiboMultiMessage);
            } else {
                startClientShare(weiboMultiMessage);
            }
        }
    }

    public void shareToStory(StoryMessage storyMessage) {
        Intent intent = new Intent();
        intent.putExtra(Msg.STORY, storyMessage);
        intent.putExtra(WBConstants.SHARE_START_ACTIVITY, this.context.getClass().getName());
        intent.putExtra(WBConstants.TRANS_PROGRESS_COLOR, this.progressColor);
        intent.putExtra(WBConstants.TRANS_PROGRESS_ID, this.progressId);
        intent.setClass(this.context, WbShareToStoryActivity.class);
        this.context.startActivity(intent);
    }

    public boolean supportMulti() {
        return false;
    }
}
