package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Oauth2AccessToken {
    public static final String KEY_ACCESS_TOKEN = "access_token";
    public static final String KEY_EXPIRES_IN = "expires_in";
    public static final String KEY_PHONE_NUM = "phone_num";
    public static final String KEY_REFRESH_TOKEN = "refresh_token";
    public static final String KEY_UID = "uid";
    Bundle bundle;
    private String mAccessToken = "";
    private long mExpiresTime = 0;
    private String mPhoneNum = "";
    private String mRefreshToken = "";
    private String mUid = "";

    @Deprecated
    public Oauth2AccessToken(String str) {
        if (str != null && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                setUid(jSONObject.optString(KEY_UID));
                setToken(jSONObject.optString("access_token"));
                setExpiresIn(jSONObject.optString("expires_in"));
                setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
                setPhoneNum(jSONObject.optString(KEY_PHONE_NUM));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public Oauth2AccessToken(String str, String str2) {
        this.mAccessToken = str;
        this.mExpiresTime = System.currentTimeMillis();
        if (str2 != null) {
            this.mExpiresTime += Long.parseLong(str2) * 1000;
        }
    }

    private static String getString(Bundle bundle, String str, String str2) {
        if (bundle == null) {
            return str2;
        }
        String string = bundle.getString(str);
        if (string == null) {
            string = str2;
        }
        return string;
    }

    public static Oauth2AccessToken parseAccessToken(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        oauth2AccessToken.setUid(getString(bundle, KEY_UID, ""));
        oauth2AccessToken.setToken(getString(bundle, "access_token", ""));
        oauth2AccessToken.setExpiresIn(getString(bundle, "expires_in", ""));
        oauth2AccessToken.setRefreshToken(getString(bundle, KEY_REFRESH_TOKEN, ""));
        oauth2AccessToken.setPhoneNum(getString(bundle, KEY_PHONE_NUM, ""));
        oauth2AccessToken.setBundle(bundle);
        return oauth2AccessToken;
    }

    public static Oauth2AccessToken parseAccessToken(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf("{") >= 0) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
                oauth2AccessToken.setUid(jSONObject.optString(KEY_UID));
                oauth2AccessToken.setToken(jSONObject.optString("access_token"));
                oauth2AccessToken.setExpiresIn(jSONObject.optString("expires_in"));
                oauth2AccessToken.setRefreshToken(jSONObject.optString(KEY_REFRESH_TOKEN));
                oauth2AccessToken.setPhoneNum(jSONObject.optString(KEY_PHONE_NUM));
                return oauth2AccessToken;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void setPhoneNum(String str) {
        this.mPhoneNum = str;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public long getExpiresTime() {
        return this.mExpiresTime;
    }

    public String getPhoneNum() {
        return this.mPhoneNum;
    }

    public String getRefreshToken() {
        return this.mRefreshToken;
    }

    public String getToken() {
        return this.mAccessToken;
    }

    public String getUid() {
        return this.mUid;
    }

    public boolean isSessionValid() {
        return TextUtils.isEmpty(this.mAccessToken) ^ 1;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public void setExpiresIn(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals("0")) {
            setExpiresTime(System.currentTimeMillis() + (Long.parseLong(str) * 1000));
        }
    }

    public void setExpiresTime(long j) {
        this.mExpiresTime = j;
    }

    public void setRefreshToken(String str) {
        this.mRefreshToken = str;
    }

    public void setToken(String str) {
        this.mAccessToken = str;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("uid: ");
        stringBuilder.append(this.mUid);
        stringBuilder.append(", ");
        stringBuilder.append("access_token");
        stringBuilder.append(": ");
        stringBuilder.append(this.mAccessToken);
        stringBuilder.append(", ");
        stringBuilder.append(KEY_REFRESH_TOKEN);
        stringBuilder.append(": ");
        stringBuilder.append(this.mRefreshToken);
        stringBuilder.append(", ");
        stringBuilder.append(KEY_PHONE_NUM);
        stringBuilder.append(": ");
        stringBuilder.append(this.mPhoneNum);
        stringBuilder.append(", ");
        stringBuilder.append("expires_in");
        stringBuilder.append(": ");
        stringBuilder.append(Long.toString(this.mExpiresTime));
        return stringBuilder.toString();
    }
}
