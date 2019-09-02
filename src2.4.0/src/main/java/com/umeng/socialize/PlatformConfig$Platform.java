package com.umeng.socialize;

import defpackage.by;
import org.json.JSONObject;

public interface PlatformConfig$Platform {
    String getAppSecret();

    String getAppid();

    by getName();

    boolean isConfigured();

    void parse(JSONObject jSONObject);
}
