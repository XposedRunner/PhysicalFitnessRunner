package com.amap.api.mapcore.util;

import java.util.Hashtable;
import java.util.Map;

/* compiled from: OfflineDownloadRequest */
public class O0O00o0 extends OO0OOo0 {
    private String O000000o;

    public O0O00o0(String str) {
        this.O000000o = str;
    }

    public Map<String, String> getParams() {
        return null;
    }

    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(32);
        hashtable.put("User-Agent", "MAC=channel:amapapi");
        return hashtable;
    }

    public String getURL() {
        return this.O000000o;
    }
}
