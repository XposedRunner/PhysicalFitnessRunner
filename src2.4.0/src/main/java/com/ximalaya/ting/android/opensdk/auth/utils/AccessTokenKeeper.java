package com.ximalaya.ting.android.opensdk.auth.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.ximalaya.ting.android.opensdk.auth.model.XmlyAuth2AccessToken;

public class AccessTokenKeeper {
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_DEVICE_ID = "device_id";
    private static final String KEY_EXPIRES_IN = "expires_in";
    private static final String KEY_REFRESH_TOKEN = "refresh_token";
    private static final String KEY_SCOPE = "scope";
    private static final String KEY_UID = "uid";
    private static final String PREFERENCES_NAME = "com_ximalaya_oauth_sdk_android";

    public static void clear(Context context) {
        if (context != null) {
            Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 32768).edit();
            edit.clear();
            edit.apply();
        }
    }

    public static XmlyAuth2AccessToken readAccessToken(Context context) {
        if (context == null) {
            return null;
        }
        XmlyAuth2AccessToken xmlyAuth2AccessToken = new XmlyAuth2AccessToken();
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 32768);
        xmlyAuth2AccessToken.setUid(sharedPreferences.getString("uid", ""));
        xmlyAuth2AccessToken.setToken(sharedPreferences.getString("access_token", ""));
        xmlyAuth2AccessToken.setRefreshToken(sharedPreferences.getString("refresh_token", ""));
        xmlyAuth2AccessToken.setExpiresAt(sharedPreferences.getLong("expires_in", 0));
        xmlyAuth2AccessToken.setScope(sharedPreferences.getString("scope", ""));
        xmlyAuth2AccessToken.setDeviceId(sharedPreferences.getString("device_id", ""));
        return xmlyAuth2AccessToken;
    }

    public static void writeAccessToken(Context context, XmlyAuth2AccessToken xmlyAuth2AccessToken) {
        if (context != null && xmlyAuth2AccessToken != null) {
            Editor edit = context.getSharedPreferences(PREFERENCES_NAME, 32768).edit();
            edit.putString("uid", xmlyAuth2AccessToken.getUid());
            edit.putString("access_token", xmlyAuth2AccessToken.getToken());
            edit.putString("refresh_token", xmlyAuth2AccessToken.getRefreshToken());
            edit.putLong("expires_in", xmlyAuth2AccessToken.getExpiresAt());
            edit.putString("scope", xmlyAuth2AccessToken.getScope());
            edit.putString("device_id", xmlyAuth2AccessToken.getDeviceId());
            edit.commit();
        }
    }
}
