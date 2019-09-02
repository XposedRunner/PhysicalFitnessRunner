package com.amap.api.mapcore.util;

import java.util.Map;

/* compiled from: ADIURequest */
public class oOO00000 extends oOO0OO0O {
    private byte[] O000000o;
    private Map<String, String> O00000Oo;

    public oOO00000(byte[] bArr, Map<String, String> map) {
        this.O000000o = bArr;
        this.O00000Oo = map;
    }

    public byte[] getEntityBytes() {
        return this.O000000o;
    }

    public Map<String, String> getParams() {
        return this.O00000Oo;
    }

    public Map<String, String> getRequestHead() {
        return null;
    }

    public String getURL() {
        return "https://adiu.amap.com/ws/device/adius";
    }
}
