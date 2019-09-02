package com.ximalaya.ting.android.player.model;

import com.ximalaya.ting.android.player.IGetHttpUrlConnectByUrl;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.util.Map;

public class HttpConfig {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_POST = "POST";
    public String authorization;
    public int connectionTimeOut = XMediaPlayerConstants.TIME_OUT;
    public int httpsProxyPort;
    public IGetHttpUrlConnectByUrl mGetHttpUrlConnectByUrl;
    public String method = "GET";
    public Map<String, String> property;
    public String proxyHost;
    public int proxyPort;
    public int proxyType = -1;
    public int readTimeOut = XMediaPlayerConstants.TIME_OUT;
    public boolean useCache = true;
    public boolean useProxy = false;
    public int writeTimeOut = XMediaPlayerConstants.TIME_OUT;
}
