package com.ximalaya.ting.android.opensdk.auth.model;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants;
import com.ximalaya.ting.android.opensdk.auth.utils.a;

public class XmlyAuthInfo {
    private String mAppKey;
    private String mClientOsType;
    private String mDeviceId;
    private String mObtainAuthType;
    private String mPackageId;
    private String mRedirectUrl;
    private String mState;
    private String mThirdAppName;

    public XmlyAuthInfo(Context context, String str, String str2, String str3) {
        this(context, str, context.getPackageName(), str2, str3);
    }

    public XmlyAuthInfo(Context context, String str, String str2, String str3, String str4) {
        this.mAppKey = "";
        this.mRedirectUrl = "";
        this.mState = "";
        this.mDeviceId = "";
        this.mPackageId = "";
        this.mClientOsType = "";
        this.mObtainAuthType = "";
        this.mThirdAppName = "";
        this.mAppKey = str;
        this.mRedirectUrl = str3;
        if (TextUtils.isEmpty(str4)) {
            str4 = "";
        }
        this.mState = str4;
        this.mDeviceId = a.a(context);
        this.mPackageId = str2;
        this.mObtainAuthType = "token";
        String a = a.a(context, context.getPackageName());
        if (TextUtils.isEmpty(a)) {
            a = "";
        }
        this.mThirdAppName = a;
    }

    private XmlyAuthInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.mAppKey = "";
        this.mRedirectUrl = "";
        this.mState = "";
        this.mDeviceId = "";
        this.mPackageId = "";
        this.mClientOsType = "";
        this.mObtainAuthType = "";
        this.mThirdAppName = "";
        this.mAppKey = str;
        this.mRedirectUrl = str2;
        this.mDeviceId = str3;
        this.mPackageId = str4;
        this.mState = str5;
        this.mClientOsType = str6;
        this.mObtainAuthType = str7;
        this.mThirdAppName = str8;
    }

    public static XmlyAuthInfo parseBundleData(Context context, Bundle bundle) {
        return new XmlyAuthInfo(bundle.getString("app_key"), bundle.getString("redirect_uri"), a.a(context), bundle.getString("pack_id"), bundle.getString("state"), bundle.getString("client_os_type"), bundle.getString("obtain_auth_type"), bundle.getString(XmlyConstants.SSO_THIRD_APP_NAME));
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public Bundle getAuthBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("app_key", this.mAppKey);
        bundle.putString("redirect_uri", this.mRedirectUrl);
        bundle.putString("state", this.mState);
        bundle.putString("device_id", this.mDeviceId);
        bundle.putString("pack_id", this.mPackageId);
        bundle.putString("client_os_type", this.mClientOsType);
        bundle.putString("obtain_auth_type", this.mObtainAuthType);
        bundle.putString(XmlyConstants.SSO_THIRD_APP_NAME, this.mThirdAppName);
        return bundle;
    }

    public String getClientOsType() {
        return this.mClientOsType;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getObtainAuthType() {
        return this.mObtainAuthType;
    }

    public String getPackId() {
        return this.mPackageId;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public String getState() {
        return this.mState;
    }

    public String getThirdAppName() {
        return this.mThirdAppName;
    }

    public void setClientOsType(String str) {
        this.mClientOsType = str;
    }

    public void setObtainAuthType(String str) {
        this.mObtainAuthType = str;
    }
}
