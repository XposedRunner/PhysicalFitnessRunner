package com.ximalaya.ting.android.player;

import com.ximalaya.ting.android.player.liveflv.IFlvDataCallback;
import com.ximalaya.ting.android.player.model.HttpConfig;
import com.ximalaya.ting.android.player.xdcs.IStatToServerFactory;
import java.util.Map;

public class StaticConfig {
    public static Map<String, String> mHeads;
    public static HttpConfig mHttpConfig;
    public static IDomainServerIpCallback mIDomainServerIpCallback;
    public static IFlvDataCallback mIFlvDataCallback;
    public static String mUseragent;
    public static IStatToServerFactory sIStatToServerFactory;

    public static void release() {
        mIDomainServerIpCallback = null;
        mHttpConfig = null;
        sIStatToServerFactory = null;
        mIFlvDataCallback = null;
    }

    public static void setDomainServerIpCallback(IDomainServerIpCallback iDomainServerIpCallback) {
        mIDomainServerIpCallback = iDomainServerIpCallback;
    }

    public static void setFlvDataCallback(IFlvDataCallback iFlvDataCallback) {
        mIFlvDataCallback = iFlvDataCallback;
    }

    public static void setHeads(Map<String, String> map) {
        mHeads = map;
    }

    public static void setHttpConfig(HttpConfig httpConfig) {
        mHttpConfig = httpConfig;
    }

    public static void setIStatToServerFactory(IStatToServerFactory iStatToServerFactory) {
        sIStatToServerFactory = iStatToServerFactory;
    }

    public static void setUseragent(String str) {
        mUseragent = str;
    }
}
