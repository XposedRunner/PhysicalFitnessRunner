package com.amap.api.mapcore.util;

@hz(a = "update_item_download_info")
/* compiled from: DTDownloadInfo */
class O00Oo00o {
    @ia(a = "mAdcode", b = 6)
    private String O000000o = "";
    @ia(a = "fileLength", b = 5)
    private long O00000Oo = 0;
    @ia(a = "startPos", b = 5)
    private long O00000o = 0;
    @ia(a = "splitter", b = 2)
    private int O00000o0 = 0;
    @ia(a = "endPos", b = 5)
    private long O00000oO = 0;

    public O00Oo00o(String str, long j, int i, long j2, long j3) {
        this.O000000o = str;
        this.O00000Oo = j;
        this.O00000o0 = i;
        this.O00000o = j2;
        this.O00000oO = j3;
    }

    public static String O000000o(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mAdcode");
        stringBuilder.append("='");
        stringBuilder.append(str);
        stringBuilder.append("'");
        return stringBuilder.toString();
    }
}
