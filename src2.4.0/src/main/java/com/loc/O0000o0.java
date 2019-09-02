package com.loc;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest */
public final class O0000o0 extends O00OOo {
    private byte[] O000000o;
    private String O00000Oo = "1";

    public O0000o0(byte[] bArr, String str) {
        this.O000000o = (byte[]) bArr.clone();
        this.O00000Oo = str;
    }

    public final Map<String, String> O000000o() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.O000000o.length));
        return hashMap;
    }

    public final Map<String, String> O00000Oo() {
        return null;
    }

    public final byte[] O00000o() {
        return this.O000000o;
    }

    public final String O00000o0() {
        String O00000o0 = OO0o000.O00000o0(O0000OOo.O00000o0);
        Object[] objArr = new Object[5];
        objArr[0] = "1";
        objArr[1] = this.O00000Oo;
        objArr[2] = "1";
        objArr[3] = "open";
        byte[] O000000o = OO0o000.O000000o(O0000OOo.O00000Oo);
        byte[] bArr = new byte[(O000000o.length + 50)];
        System.arraycopy(this.O000000o, 0, bArr, 0, 50);
        System.arraycopy(O000000o, 0, bArr, 50, O000000o.length);
        objArr[4] = OO0OOOO.O000000o(bArr);
        return String.format(O00000o0, objArr);
    }
}
