package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.utils.Utility;
import java.io.Serializable;

public class AuthInfo implements Parcelable, Serializable {
    public static final Creator<AuthInfo> CREATOR = new Creator<AuthInfo>() {
        public AuthInfo createFromParcel(Parcel parcel) {
            return new AuthInfo(parcel);
        }

        public AuthInfo[] newArray(int i) {
            return new AuthInfo[i];
        }
    };
    private String mAppKey = "";
    private String mKeyHash = "";
    private String mPackageName = "";
    private String mRedirectUrl = "";
    private String mScope = "";

    public AuthInfo(Context context, String str, String str2, String str3) {
        this.mAppKey = str;
        this.mRedirectUrl = str2;
        this.mScope = str3;
        this.mPackageName = context.getPackageName();
        this.mKeyHash = Utility.getSign(context, this.mPackageName);
    }

    protected AuthInfo(Parcel parcel) {
        this.mAppKey = parcel.readString();
        this.mRedirectUrl = parcel.readString();
        this.mScope = parcel.readString();
        this.mPackageName = parcel.readString();
        this.mKeyHash = parcel.readString();
    }

    public static AuthInfo parseBundleData(Context context, Bundle bundle) {
        return new AuthInfo(context, bundle.getString(WBConstants.SSO_APP_KEY), bundle.getString(WBConstants.SSO_REDIRECT_URL), bundle.getString("scope"));
    }

    public int describeContents() {
        return 0;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public Bundle getAuthBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(WBConstants.SSO_APP_KEY, this.mAppKey);
        bundle.putString(WBConstants.SSO_REDIRECT_URL, this.mRedirectUrl);
        bundle.putString("scope", this.mScope);
        bundle.putString("packagename", this.mPackageName);
        bundle.putString("key_hash", this.mKeyHash);
        return bundle;
    }

    public String getKeyHash() {
        return this.mKeyHash;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getRedirectUrl() {
        return this.mRedirectUrl;
    }

    public String getScope() {
        return this.mScope;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppKey);
        parcel.writeString(this.mRedirectUrl);
        parcel.writeString(this.mScope);
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mKeyHash);
    }
}
