package com.sina.weibo.sdk.web;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.web.param.DefaultWebViewRequestParam;
import com.umeng.commonsdk.framework.c;
import java.util.HashMap;
import java.util.Map.Entry;

public class WeiboPageUtils {
    private static final String USER_INFO_H5 = "http://m.weibo.cn/u/";
    private static final String USER_INFO_SCHEME = "sinaweibo://userinfo?";
    private static final String WEIBO_ARTICLE_H5 = "http://media.weibo.cn/article?";
    private static final String WEIBO_ARTICLE_SCHEME = "sinaweibo://article?";
    private static final String WEIBO_COMMENT_H5 = "http://m.weibo.cn/comment?";
    private static final String WEIBO_COMMENT_SCHEME = "sinaweibo://comment?";
    private static final String WEIBO_DETAIL_H5 = "http://m.weibo.cn/";
    private static final String WEIBO_DETAIL_SCHEME = "sinaweibo://detail?";
    private static final String WEIBO_GOTO_HOME_H5 = "http://m.weibo.cn/index/router?";
    private static final String WEIBO_GOTO_HOME_SCHEME = "sinaweibo://gotohome?";
    private static final String WEIBO_GOTO_MYPROFILE_H5 = "http://m.weibo.cn/index/router?";
    private static final String WEIBO_GOTO_MYPROFILE_SCHEME = "sinaweibo://myprofile?";
    private static final String WEIBO_SEARCH_URL_CHEME = "sinaweibo://searchall?";
    private static final String WEIBO_SEARCH_URL_H5 = "https://m.weibo.cn/p/100103type=1&";
    private static final String WEIBO_SEND_CONTENT_H5 = "http://m.weibo.cn/mblog?";
    private static final String WEIBO_SEND_CONTENT_SCHEME = "sinaweibo://sendweibo?";
    private static WeiboPageUtils weiboSdkUtils;
    private AuthInfo authInfo;
    private Context context;
    private WbAppInfo mWeiboInfo = null;

    private WeiboPageUtils(Context context, AuthInfo authInfo) {
        this.mWeiboInfo = WeiboAppManager.getInstance(context).getWbAppInfo();
        this.authInfo = authInfo;
        this.context = context;
    }

    private Intent createScheme(String str, HashMap<String, String> hashMap) {
        return new Intent("android.intent.action.VIEW", Uri.parse(schemeAddProperty(str, hashMap)));
    }

    public static WeiboPageUtils getInstance(Context context, AuthInfo authInfo) {
        if (weiboSdkUtils == null) {
            weiboSdkUtils = new WeiboPageUtils(context, authInfo);
        }
        return weiboSdkUtils;
    }

    private void gotoWebActivity(String str) {
        Intent intent = new Intent();
        intent.setClass(this.context, WeiboSdkWebActivity.class);
        DefaultWebViewRequestParam defaultWebViewRequestParam = new DefaultWebViewRequestParam(this.authInfo, WebRequestType.DEFAULT, null, null, str, this.context);
        Bundle bundle = new Bundle();
        defaultWebViewRequestParam.fillBundle(bundle);
        intent.putExtras(bundle);
        this.context.startActivity(intent);
    }

    private String schemeAddProperty(String str, HashMap<String, String> hashMap) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("luicode=10000360&&lfid=OP_");
        stringBuilder.append(this.authInfo.getAppKey());
        str = stringBuilder.toString();
        if (hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(HttpUtils.PARAMETERS_SEPARATOR);
                stringBuilder2.append(entry.getKey().toString());
                stringBuilder2.append(HttpUtils.EQUAL_SIGN);
                stringBuilder2.append(entry.getValue().toString());
                str = stringBuilder2.toString();
            }
        }
        return str;
    }

    public void commentWeibo(String str) {
        commentWeibo(str, false);
    }

    public void commentWeibo(String str, boolean z) {
        String str2;
        HashMap hashMap;
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            str2 = WEIBO_COMMENT_H5;
            hashMap = new HashMap();
            hashMap.put("id", str);
            gotoWebActivity(schemeAddProperty(str2, hashMap));
            return;
        }
        str2 = WEIBO_COMMENT_SCHEME;
        hashMap = new HashMap();
        hashMap.put("srcid", str);
        try {
            this.context.startActivity(createScheme(str2, hashMap));
        } catch (Exception unused) {
        }
    }

    public void gotoMyHomePage() {
        gotoMyHomePage(false);
    }

    public void gotoMyHomePage(boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            new HashMap().put("cookie", "0_all");
            gotoWebActivity(schemeAddProperty("http://m.weibo.cn/index/router?", null));
            return;
        }
        try {
            this.context.startActivity(createScheme(WEIBO_GOTO_HOME_SCHEME, null));
        } catch (Exception unused) {
        }
    }

    public void gotoMyProfile() {
        gotoMyProfile(false);
    }

    public void gotoMyProfile(boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            new HashMap().put("cookie", "3");
            gotoWebActivity(schemeAddProperty("http://m.weibo.cn/index/router?", null));
            return;
        }
        try {
            this.context.startActivity(createScheme(WEIBO_GOTO_MYPROFILE_SCHEME, null));
        } catch (Exception unused) {
        }
    }

    public void openWeiboSearchPage(String str) {
        openWeiboSearchPage(str, false);
    }

    public void openWeiboSearchPage(String str, boolean z) {
        String str2;
        HashMap hashMap;
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            str2 = WEIBO_SEARCH_URL_H5;
            hashMap = new HashMap();
            hashMap.put("q", str);
            gotoWebActivity(schemeAddProperty(str2, hashMap));
            return;
        }
        str2 = WEIBO_SEARCH_URL_CHEME;
        hashMap = new HashMap();
        hashMap.put("q", str);
        try {
            this.context.startActivity(createScheme(str2, hashMap));
        } catch (Exception unused) {
        }
    }

    public void shareToWeibo(String str) {
        shareToWeibo(str, false);
    }

    public void shareToWeibo(String str, boolean z) {
        String str2;
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            str2 = WEIBO_SEND_CONTENT_H5;
            new HashMap().put(c.a, str);
            gotoWebActivity(schemeAddProperty(str2, null));
            return;
        }
        str2 = WEIBO_SEND_CONTENT_SCHEME;
        HashMap hashMap = new HashMap();
        hashMap.put(c.a, str);
        try {
            this.context.startActivity(createScheme(str2, hashMap));
        } catch (Exception unused) {
        }
    }

    public void startOtherPage(String str) {
        startOtherPage(str, null);
    }

    public void startOtherPage(String str, HashMap<String, String> hashMap) {
        if (!TextUtils.isEmpty(str)) {
            gotoWebActivity(schemeAddProperty(str, hashMap));
        }
    }

    public void startUserMainPage(String str) {
        startUserMainPage(str, false);
    }

    public void startUserMainPage(String str, boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(USER_INFO_H5);
            stringBuilder.append(str);
            stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR);
            gotoWebActivity(schemeAddProperty(stringBuilder.toString(), null));
            return;
        }
        String str2 = USER_INFO_SCHEME;
        HashMap hashMap = new HashMap();
        hashMap.put(Oauth2AccessToken.KEY_UID, str);
        try {
            this.context.startActivity(createScheme(str2, hashMap));
        } catch (Exception unused) {
        }
    }

    public void startWeiboDetailPage(String str, String str2) {
        startWeiboDetailPage(str, str2, false);
    }

    public void startWeiboDetailPage(String str, String str2, boolean z) {
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(WEIBO_DETAIL_H5);
            stringBuilder.append(str2);
            stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
            stringBuilder.append(str);
            stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR);
            gotoWebActivity(schemeAddProperty(stringBuilder.toString(), null));
            return;
        }
        str2 = WEIBO_DETAIL_SCHEME;
        HashMap hashMap = new HashMap();
        hashMap.put("mblogid", str);
        try {
            this.context.startActivity(createScheme(str2, hashMap));
        } catch (Exception unused) {
        }
    }

    public void startWeiboTopPage(String str) {
        startWeiboTopPage(str, false);
    }

    public void startWeiboTopPage(String str, boolean z) {
        String str2;
        HashMap hashMap;
        if (z || this.mWeiboInfo == null || !this.mWeiboInfo.isLegal()) {
            str2 = WEIBO_ARTICLE_H5;
            hashMap = new HashMap();
            hashMap.put("id", str);
            gotoWebActivity(schemeAddProperty(str2, hashMap));
            return;
        }
        str2 = WEIBO_ARTICLE_SCHEME;
        hashMap = new HashMap();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1022:");
        stringBuilder.append(str);
        hashMap.put("object_id", stringBuilder.toString());
        try {
            this.context.startActivity(createScheme(str2, hashMap));
        } catch (Exception unused) {
        }
    }
}
