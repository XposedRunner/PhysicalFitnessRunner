package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest */
public class oO000OOO extends oOO0OO0O {
    private byte[] O000000o;
    private String O00000Oo = "1";

    public oO000OOO(byte[] bArr, String str) {
        this.O000000o = (byte[]) bArr.clone();
        this.O00000Oo = str;
    }

    private String O000000o() {
        byte[] O000000o = o0OOOO00.O000000o(oO0Ooo00.O00000Oo);
        byte[] bArr = new byte[(O000000o.length + 50)];
        System.arraycopy(this.O000000o, 0, bArr, 0, 50);
        System.arraycopy(O000000o, 0, bArr, 50, O000000o.length);
        return o0OO00o0.O000000o(bArr);
    }

    public byte[] getEntityBytes() {
        return this.O000000o;
    }

    public Map<String, String> getParams() {
        return null;
    }

    public Map<String, String> getRequestHead() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.O000000o.length));
        return hashMap;
    }

    public String getURL() {
        return String.format(o0OOOO00.O00000o0(oO0Ooo00.O00000o0), new Object[]{"1", this.O00000Oo, "1", "open", O000000o()});
    }
}
