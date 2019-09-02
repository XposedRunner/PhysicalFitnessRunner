package com.ximalaya.ting.android.player.xdcs;

public interface IStatToServer {
    void addEndHttpDnsRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void addHttpDnsEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7);

    void endAllHttpDnsRequest();

    void statNormalRequest(String str, String str2, String str3, String str4);
}
