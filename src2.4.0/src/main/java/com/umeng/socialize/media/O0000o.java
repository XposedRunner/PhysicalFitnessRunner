package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject.O000000o;
import defpackage.db;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UMWeb */
public class O0000o extends O000000o {
    public O0000o(String str) {
        super(str);
    }

    public O0000o(String str, String str2, String str3, O0000Oo o0000Oo) {
        this.O00000Oo = str;
        O000000o(o0000Oo);
        this.O00000oO = str3;
        O00000Oo(str2);
    }

    public byte[] O0000O0o() {
        return this.O00000oo != null ? this.O00000oo.O0000O0o() : null;
    }

    public Map<String, Object> O0000OOo() {
        HashMap hashMap = new HashMap();
        if (O00000oO()) {
            hashMap.put(db.O0000oo, this.O00000Oo);
            hashMap.put(db.O0000ooO, O0000Oo0());
        }
        return hashMap;
    }

    public O000000o O0000Oo0() {
        return O000000o.WEBPAGE;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UMWEB [media_url=");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append(", title=");
        stringBuilder.append(this.O00000o0);
        stringBuilder.append("");
        stringBuilder.append("media_url=");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append(", des=");
        stringBuilder.append(this.O00000oO);
        stringBuilder.append(", qzone_thumb=");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
