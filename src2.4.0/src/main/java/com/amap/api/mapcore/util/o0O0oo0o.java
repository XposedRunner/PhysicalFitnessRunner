package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapException;

/* compiled from: AMapCoreException */
public class o0O0oo0o extends Exception {
    private String O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private int O00000oO;

    public o0O0oo0o(String str) {
        super(str);
        this.O000000o = AMapException.ERROR_UNKNOWN;
        this.O00000Oo = "";
        this.O00000o0 = "1900";
        this.O00000o = "UnknownError";
        this.O00000oO = -1;
        this.O000000o = str;
        O000000o(str);
    }

    public o0O0oo0o(String str, String str2) {
        this(str);
        this.O00000Oo = str2;
    }

    private void O000000o(String str) {
        if (AMapException.ERROR_IO.equals(str)) {
            this.O00000oO = 21;
            this.O00000o0 = "1902";
            this.O00000o = "IOException";
        } else if (AMapException.ERROR_SOCKET.equals(str)) {
            this.O00000oO = 22;
        } else if (AMapException.ERROR_SOCKE_TIME_OUT.equals(str)) {
            this.O00000oO = 23;
            this.O00000o0 = "1802";
            this.O00000o = "SocketTimeoutException";
        } else if (AMapException.ERROR_INVALID_PARAMETER.equals(str)) {
            this.O00000oO = 24;
            this.O00000o0 = "1901";
            this.O00000o = "IllegalArgumentException";
        } else if (AMapException.ERROR_NULL_PARAMETER.equals(str)) {
            this.O00000oO = 25;
            this.O00000o0 = "1903";
            this.O00000o = "NullPointException";
        } else if (AMapException.ERROR_URL.equals(str)) {
            this.O00000oO = 26;
            this.O00000o0 = "1803";
            this.O00000o = "MalformedURLException";
        } else if (AMapException.ERROR_UNKNOW_HOST.equals(str)) {
            this.O00000oO = 27;
            this.O00000o0 = "1804";
            this.O00000o = "UnknownHostException";
        } else if (AMapException.ERROR_UNKNOW_SERVICE.equals(str)) {
            this.O00000oO = 28;
            this.O00000o0 = "1805";
            this.O00000o = "CannotConnectToHostException";
        } else if (AMapException.ERROR_PROTOCOL.equals(str)) {
            this.O00000oO = 29;
            this.O00000o0 = "1801";
            this.O00000o = "ProtocolException";
        } else if (AMapException.ERROR_CONNECTION.equals(str)) {
            this.O00000oO = 30;
            this.O00000o0 = "1806";
            this.O00000o = "ConnectionException";
        } else if (AMapException.ERROR_UNKNOWN.equals(str)) {
            this.O00000oO = 31;
        } else if (AMapException.ERROR_FAILURE_AUTH.equals(str)) {
            this.O00000oO = 32;
        } else if ("requeust is null".equals(str)) {
            this.O00000oO = 1;
        } else if ("request url is empty".equals(str)) {
            this.O00000oO = 2;
        } else if ("response is null".equals(str)) {
            this.O00000oO = 3;
        } else if ("thread pool has exception".equals(str)) {
            this.O00000oO = 4;
        } else if ("sdk name is invalid".equals(str)) {
            this.O00000oO = 5;
        } else if ("sdk info is null".equals(str)) {
            this.O00000oO = 6;
        } else if ("sdk packages is null".equals(str)) {
            this.O00000oO = 7;
        } else if ("线程池为空".equals(str)) {
            this.O00000oO = 8;
        } else if ("获取对象错误".equals(str)) {
            this.O00000oO = 101;
        } else {
            this.O00000oO = -1;
        }
    }

    public String O000000o() {
        return this.O000000o;
    }

    public void O000000o(int i) {
        this.O00000oO = i;
    }

    public String O00000Oo() {
        return this.O00000o0;
    }

    public String O00000o() {
        return this.O00000Oo;
    }

    public String O00000o0() {
        return this.O00000o;
    }
}
