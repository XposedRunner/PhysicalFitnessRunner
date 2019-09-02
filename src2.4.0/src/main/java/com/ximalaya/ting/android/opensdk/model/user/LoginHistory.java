package com.ximalaya.ting.android.opensdk.model.user;

import com.google.gson.annotations.SerializedName;

class LoginHistory {
    @SerializedName("cty_code")
    private String cityCode;
    @SerializedName("login_times")
    private String loginTimes;

    LoginHistory() {
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public String getLoginTimes() {
        return this.loginTimes;
    }

    public void setCityCode(String str) {
        this.cityCode = str;
    }

    public void setLoginTimes(String str) {
        this.loginTimes = str;
    }
}
