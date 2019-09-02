package com.ximalaya.ting.android.opensdk.auth.model;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class XmlyAuth2AccessToken {
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_SCOPE = "scope";
    public static final String KEY_UID = "uid";
    private String mAccessToken = "";
    private String mDeviceId = "";
    private long mExpiresAtMillis = 0;
    private String mRefreshToken = "";
    private String mScope = "";
    private String mUid = "";

    public XmlyAuth2AccessToken(String str, String str2) {
        this.mAccessToken = str;
        this.mExpiresAtMillis = System.currentTimeMillis();
        if (str2 != null) {
            this.mExpiresAtMillis += Long.parseLong(str2) * 1000;
        }
    }

    private static String getString(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            return str2;
        }
        String string = bundle.getString(str);
        return string != null ? string : str2;
    }

    public static XmlyAuth2AccessToken parseAccessToken(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        XmlyAuth2AccessToken xmlyAuth2AccessToken = new XmlyAuth2AccessToken();
        xmlyAuth2AccessToken.setUid(getString(bundle, "uid", ""));
        xmlyAuth2AccessToken.setToken(getString(bundle, "access_token", ""));
        xmlyAuth2AccessToken.setExpiresIn(getString(bundle, "expires_in", ""));
        xmlyAuth2AccessToken.setRefreshToken(getString(bundle, "refresh_token", ""));
        xmlyAuth2AccessToken.setScope(getString(bundle, "scope", ""));
        xmlyAuth2AccessToken.setDeviceId(getString(bundle, "device_id", ""));
        return xmlyAuth2AccessToken;
    }

    public static XmlyAuth2AccessToken parseAccessToken(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                XmlyAuth2AccessToken xmlyAuth2AccessToken = new XmlyAuth2AccessToken();
                xmlyAuth2AccessToken.setUid(String.valueOf(jSONObject.optInt("uid")));
                xmlyAuth2AccessToken.setToken(jSONObject.optString("access_token"));
                xmlyAuth2AccessToken.setExpiresIn(jSONObject.optString("expires_in"));
                xmlyAuth2AccessToken.setRefreshToken(jSONObject.optString("refresh_token"));
                xmlyAuth2AccessToken.setScope(jSONObject.optString("scope"));
                xmlyAuth2AccessToken.setDeviceId(jSONObject.optString("device_id"));
                return xmlyAuth2AccessToken;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public long getExpiresAt() {
        return this.mExpiresAtMillis;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getToken() {
        return this.mAccessToken;
    }

    public String getUid() {
        return this.mUid;
    }

    public boolean isSessionValid() {
        return !TextUtils.isEmpty(this.mAccessToken);
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public void setExpiresAt(long j) {
        this.mExpiresAtMillis = j;
    }

    public void setExpiresIn(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("0")) {
            setExpiresAt(System.currentTimeMillis() + (Long.parseLong(str) * 1000));
        }
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setScope(String str) {
        this.mScope = str;
    }

    public void setToken(String str) {
        this.mAccessToken = str;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("uid", this.mUid);
        bundle.putString("access_token", this.mAccessToken);
        bundle.putString("refresh_token", this.mRefreshToken);
        bundle.putString("expires_in", Long.toString(this.mExpiresAtMillis));
        bundle.putString("scope", this.mScope);
        bundle.putString("device_id", this.mDeviceId);
        return bundle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("uid:");
        stringBuilder.append(this.mUid);
        stringBuilder.append(", access_token: ");
        stringBuilder.append(this.mAccessToken);
        stringBuilder.append(", refresh_token: ");
        stringBuilder.append(this.mRefreshToken);
        stringBuilder.append(", scope: ");
        stringBuilder.append(this.mScope);
        stringBuilder.append(", expires_in: ");
        stringBuilder.append(Long.toString(this.mExpiresAtMillis));
        stringBuilder.append(", device_id: ");
        stringBuilder.append(this.mDeviceId);
        return stringBuilder.toString();
    }
}
