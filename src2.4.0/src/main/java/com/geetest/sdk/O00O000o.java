package com.geetest.sdk;

/* compiled from: ErrorBean */
public final class O00O000o {
    private String O000000o;
    private String O00000Oo;
    private String O00000o;
    private long O00000o0;
    private String O00000oO = "Sensebot";
    private String O00000oo = "4.0.7";
    private boolean O0000O0o = false;

    public final String O000000o() {
        return this.O000000o;
    }

    public final void O000000o(long j) {
        this.O00000o0 = j;
    }

    public final void O000000o(String str) {
        this.O000000o = str;
    }

    public final void O000000o(boolean z) {
        this.O0000O0o = z;
    }

    /* renamed from: O00000Oo */
    public final GT3ErrorBean clone() {
        GT3ErrorBean gT3ErrorBean = new GT3ErrorBean(this.O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo);
        gT3ErrorBean.setChangeDesc(this.O0000O0o);
        return gT3ErrorBean;
    }

    public final void O00000Oo(String str) {
        this.O00000Oo = str;
    }

    public final void O00000o0(String str) {
        this.O00000o = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ErrorBean{errorCode='");
        stringBuilder.append(this.O000000o);
        stringBuilder.append('\'');
        stringBuilder.append(", errorDesc='");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append('\'');
        stringBuilder.append(", duration=");
        stringBuilder.append(this.O00000o0);
        stringBuilder.append(", challenge='");
        stringBuilder.append(this.O00000o);
        stringBuilder.append('\'');
        stringBuilder.append(", type='");
        stringBuilder.append(this.O00000oO);
        stringBuilder.append('\'');
        stringBuilder.append(", sdkVersion='");
        stringBuilder.append(this.O00000oo);
        stringBuilder.append('\'');
        stringBuilder.append(", isChangeDesc=");
        stringBuilder.append(this.O0000O0o);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
