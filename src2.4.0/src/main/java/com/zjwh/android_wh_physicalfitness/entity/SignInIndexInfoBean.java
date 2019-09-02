package com.zjwh.android_wh_physicalfitness.entity;

public class SignInIndexInfoBean {
    private long currentTime;
    private SignInBean signin;

    public long getCurrentTime() {
        return this.currentTime;
    }

    public SignInBean getSignin() {
        return this.signin;
    }

    public void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public void setSignin(SignInBean signInBean) {
        this.signin = signInBean;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SignInIndexInfoBean{currentTime=");
        stringBuilder.append(this.currentTime);
        stringBuilder.append(", signin=");
        stringBuilder.append(this.signin);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
