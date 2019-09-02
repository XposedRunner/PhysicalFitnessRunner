package com.geetest.sdk;

import java.util.Map;
import org.json.JSONObject;

public class GT3ConfigBean {
    private JSONObject api1Json;
    private String apiServerHost = "api.geetest.com";
    private boolean canceledOnTouchOutside;
    private boolean debug = false;
    private String lang;
    private GT3Listener listener;
    private int pattern = 1;
    private int timeout;
    private Map<String, String> userInfo;
    private int webviewTimeout;

    public JSONObject getApi1Json() {
        return this.api1Json;
    }

    public String getApiServerHost() {
        return this.apiServerHost;
    }

    public String getLang() {
        return this.lang;
    }

    public GT3Listener getListener() {
        return this.listener;
    }

    public int getPattern() {
        return this.pattern;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public Map<String, String> getUserInfo() {
        return this.userInfo;
    }

    public int getWebviewTimeout() {
        return this.webviewTimeout;
    }

    public boolean isCanceledOnTouchOutside() {
        return this.canceledOnTouchOutside;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public void setApi1Json(JSONObject jSONObject) {
        this.api1Json = jSONObject;
    }

    public void setApiServerHost(String str) {
        this.apiServerHost = str;
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.canceledOnTouchOutside = z;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setListener(GT3Listener gT3Listener) {
        this.listener = gT3Listener;
    }

    public void setPattern(int i) {
        this.pattern = i;
    }

    public void setTimeout(int i) {
        this.timeout = i;
    }

    public void setUserInfo(Map<String, String> map) {
        this.userInfo = map;
    }

    public void setWebviewTimeout(int i) {
        this.webviewTimeout = i;
    }
}
