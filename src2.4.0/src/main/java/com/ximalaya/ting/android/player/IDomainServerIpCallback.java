package com.ximalaya.ting.android.player;

public interface IDomainServerIpCallback {
    String getNewDownloadUrlIfExpire(String str);

    String[][] getStaticDomainServerIp(String str);

    void setBadIp(String str, String str2, String str3);
}
