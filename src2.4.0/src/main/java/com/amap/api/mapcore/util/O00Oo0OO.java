package com.amap.api.mapcore.util;

@hz(a = "update_item")
/* compiled from: DTInfo */
public class O00Oo0OO {
    @ia(a = "title", b = 6)
    protected String O000000o = null;
    @ia(a = "url", b = 6)
    protected String O00000Oo = null;
    @ia(a = "fileName", b = 6)
    protected String O00000o = null;
    @ia(a = "mAdcode", b = 6)
    protected String O00000o0 = null;
    @ia(a = "version", b = 6)
    protected String O00000oO = "";
    @ia(a = "lLocalLength", b = 5)
    protected long O00000oo = 0;
    @ia(a = "lRemoteLength", b = 5)
    protected long O0000O0o = 0;
    @ia(a = "localPath", b = 6)
    protected String O0000OOo;
    @ia(a = "mCompleteCode", b = 2)
    protected int O0000Oo;
    @ia(a = "isProvince", b = 2)
    protected int O0000Oo0 = 0;
    @ia(a = "mCityCode", b = 6)
    protected String O0000OoO = "";
    @ia(a = "mState", b = 2)
    public int O0000Ooo;
    @ia(a = "mPinyin", b = 6)
    public String O0000o00 = "";

    public static String O00000oO(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mAdcode");
        stringBuilder.append("='");
        stringBuilder.append(str);
        stringBuilder.append("'");
        return stringBuilder.toString();
    }

    public static String O00000oo(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mPinyin");
        stringBuilder.append("='");
        stringBuilder.append(str);
        stringBuilder.append("'");
        return stringBuilder.toString();
    }

    public String O00000o() {
        return this.O000000o;
    }

    public void O00000o(String str) {
        this.O0000OoO = str;
    }

    public void O00000o0(String str) {
        this.O00000o0 = str;
    }

    public String O00000oO() {
        return this.O00000oO;
    }

    public String O00000oo() {
        return this.O00000o0;
    }

    public String O0000O0o() {
        return this.O00000Oo;
    }

    public int O0000OOo() {
        return this.O0000Oo;
    }

    public String O0000Oo0() {
        return this.O0000o00;
    }
}
