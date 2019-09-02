package com.sina.weibo.sdk.web.client;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBConstants.Base;
import com.sina.weibo.sdk.constant.WBConstants.Response;
import com.sina.weibo.sdk.utils.WbUtils;
import com.sina.weibo.sdk.web.WebViewRequestCallback;
import com.sina.weibo.sdk.web.WeiboCallbackManager;
import com.sina.weibo.sdk.web.param.BaseWebViewRequestParam;

public class ShareWebViewClient extends BaseWebViewClient {
    private static final String RESP_PARAM_CODE = "code";
    private static final String RESP_PARAM_MSG = "msg";
    private static final String RESP_SUCC_CODE = "0";
    private Activity activity;
    private boolean hasCallbacked = false;

    public ShareWebViewClient(Activity activity, WebViewRequestCallback webViewRequestCallback, BaseWebViewRequestParam baseWebViewRequestParam) {
        super(webViewRequestCallback, baseWebViewRequestParam);
        this.activity = activity;
    }

    private boolean needOverLoad(String str) {
        if (!str.startsWith("sinaweibo://browser/close")) {
            return false;
        }
        String callback;
        Bundle parseUri = WbUtils.parseUri(str);
        if (!(this.param.getBaseData() == null || TextUtils.isEmpty(this.param.getBaseData().getCallback()))) {
            callback = this.param.getBaseData().getCallback();
            WeiboCallbackManager instance = WeiboCallbackManager.getInstance();
            if (!(instance.getWeiboAuthListener(callback) == null || parseUri.isEmpty())) {
                instance.removeWeiboAuthListener(callback);
            }
        }
        callback = parseUri.getString("code");
        str = parseUri.getString("msg");
        if (TextUtils.isEmpty(callback)) {
            sendSdkCancleResponse(this.activity);
        } else if ("0".equals(callback)) {
            sendSdkOkResponse(this.activity);
        } else {
            sendSdkErrorResponse(this.activity, str);
        }
        if (this.requestCallback != null) {
            this.requestCallback.closePage();
        }
        return true;
    }

    private void sendSdkResponse(Activity activity, int i, String str) {
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null && !this.hasCallbacked) {
            Intent intent = new Intent(WBConstants.ACTIVITY_REQ_SDK);
            String string = extras.getString("packageName");
            intent.setFlags(131072);
            intent.setPackage(string);
            intent.putExtras(extras);
            intent.putExtra(Base.APP_PKG, activity.getPackageName());
            intent.putExtra(Response.ERRCODE, i);
            intent.putExtra(Response.ERRMSG, str);
            try {
                activity.startActivityForResult(intent, WBConstants.SDK_ACTIVITY_FOR_RESULT_CODE);
            } catch (ActivityNotFoundException unused) {
            }
            this.hasCallbacked = true;
        }
    }

    public void closeWeb() {
        super.closeWeb();
        sendSdkCancleResponse(this.activity);
    }

    public void errorBack(Activity activity, String str) {
        super.errorBack(activity, str);
        sendSdkErrorResponse(activity, str);
    }

    public boolean onBackKeyDown() {
        closeWeb();
        if (this.requestCallback != null) {
            this.requestCallback.closePage();
        }
        return true;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.requestCallback != null) {
            this.requestCallback.onPageFinishedCallBack(webView, str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.requestCallback != null) {
            this.requestCallback.onPageStartedCallBack(webView, str, bitmap);
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.requestCallback != null) {
            this.requestCallback.onReceivedErrorCallBack(webView, i, str, str2);
        }
    }

    @RequiresApi(api = 23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.requestCallback != null) {
            this.requestCallback.onReceivedErrorCallBack(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    public void sendSdkCancleResponse(Activity activity) {
        sendSdkResponse(activity, 1, "send cancel!!!");
    }

    public void sendSdkErrorResponse(Activity activity, String str) {
        sendSdkResponse(activity, 2, str);
    }

    public void sendSdkOkResponse(Activity activity) {
        sendSdkResponse(activity, 0, "send ok!!!");
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return needOverLoad(webResourceRequest.getUrl().toString());
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (this.requestCallback != null) {
            this.requestCallback.shouldOverrideUrlLoadingCallBack(webView, str);
        }
        return needOverLoad(str);
    }
}
