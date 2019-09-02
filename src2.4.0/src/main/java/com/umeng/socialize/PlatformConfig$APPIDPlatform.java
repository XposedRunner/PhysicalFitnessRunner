package com.umeng.socialize;

import android.text.TextUtils;
import defpackage.by;
import org.json.JSONObject;

public class PlatformConfig$APPIDPlatform implements PlatformConfig$Platform {
    public String appId = null;
    public String appkey = null;
    private by p;
    public String redirectUrl = null;

    public PlatformConfig$APPIDPlatform(by byVar) {
        this.p = byVar;
    }

    public String getAppSecret() {
        return this.appkey;
    }

    public String getAppid() {
        return this.appId;
    }

    public by getName() {
        return this.p;
    }

    public boolean isConfigured() {
        return (TextUtils.isEmpty(this.appId) || TextUtils.isEmpty(this.appkey)) ? false : true;
    }

    public void parse(JSONObject jSONObject) {
    }
}
