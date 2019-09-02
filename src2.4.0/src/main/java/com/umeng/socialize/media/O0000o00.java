package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject.O000000o;
import defpackage.db;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UMMin */
public class O0000o00 extends O000000o {
    private String O0000O0o;
    private String O0000OOo;

    public O0000o00(String str) {
        super(str);
    }

    public void O00000o(String str) {
        this.O0000OOo = str;
    }

    public void O00000o0(String str) {
        this.O0000O0o = str;
    }

    public byte[] O0000O0o() {
        return this.O00000oo != null ? this.O00000oo.O0000O0o() : null;
    }

    public Map<String, Object> O0000OOo() {
        HashMap hashMap = new HashMap();
        if (O00000oO()) {
            hashMap.put(db.O0000oo, this.O00000Oo);
            hashMap.put(db.O0000ooO, O0000Oo0());
            hashMap.put(db.O0000ooo, this.O00000o0);
        }
        return hashMap;
    }

    public String O0000Oo() {
        return this.O0000O0o;
    }

    public O000000o O0000Oo0() {
        return O000000o.WEBPAGE;
    }

    public String O0000OoO() {
        return this.O0000OOo;
    }
}
