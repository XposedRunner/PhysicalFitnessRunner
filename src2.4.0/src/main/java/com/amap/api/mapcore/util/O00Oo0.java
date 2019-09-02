package com.amap.api.mapcore.util;

@hz(a = "update_item_file")
/* compiled from: DTFileInfo */
class O00Oo0 {
    @ia(a = "mAdcode", b = 6)
    private String O000000o = "";
    @ia(a = "file", b = 6)
    private String O00000Oo = "";

    public O00Oo0(String str, String str2) {
        this.O000000o = str;
        this.O00000Oo = str2;
    }

    public static String O000000o(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mAdcode");
        stringBuilder.append("='");
        stringBuilder.append(str);
        stringBuilder.append("'");
        return stringBuilder.toString();
    }

    public String O000000o() {
        return this.O00000Oo;
    }
}
