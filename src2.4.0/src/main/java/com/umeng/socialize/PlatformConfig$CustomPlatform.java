package com.umeng.socialize;

import defpackage.by;
import org.json.JSONObject;

public class PlatformConfig$CustomPlatform implements PlatformConfig$Platform {
    public static final String Name = "g+";
    public String appId = null;
    public String appkey = null;
    private by p;

    public PlatformConfig$CustomPlatform(by byVar) {
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
        return true;
    }

    public void parse(JSONObject jSONObject) {
    }
}
