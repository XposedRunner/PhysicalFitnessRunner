package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import com.sina.weibo.BuildConfig;

public class WbAppInfo {
    private String authActivityName = "com.sina.weibo.SSOActivity";
    private String packageName = BuildConfig.APPLICATION_ID;
    private int supportVersion;

    public String getAuthActivityName() {
        return this.authActivityName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getSupportVersion() {
        return this.supportVersion;
    }

    public boolean isLegal() {
        return !TextUtils.isEmpty(this.packageName) && this.supportVersion > 0;
    }

    public void setAuthActivityName(String str) {
        this.authActivityName = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSupportVersion(int i) {
        this.supportVersion = i;
    }
}
