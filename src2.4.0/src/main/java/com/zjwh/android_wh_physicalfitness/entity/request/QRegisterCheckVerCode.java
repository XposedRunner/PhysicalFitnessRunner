package com.zjwh.android_wh_physicalfitness.entity.request;

public class QRegisterCheckVerCode {
    private String code;
    private String password;
    private String phone;

    public QRegisterCheckVerCode(String str, String str2, String str3) {
        this.phone = str;
        this.code = str2;
        this.password = str3;
    }

    public String getCode() {
        return this.code;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }
}
