package com.umeng.socialize.media;

import com.umeng.socialize.media.UMediaObject.O000000o;
import defpackage.db;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UMVideo */
public class O0000o0 extends O000000o {
    private String O0000O0o;
    private String O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private int O0000OoO;

    public O0000o0(String str) {
        super(str);
    }

    public void O000000o(int i) {
        this.O0000OoO = i;
    }

    public void O00000o(String str) {
        this.O0000Oo0 = str;
    }

    public void O00000o0(String str) {
        this.O0000OOo = str;
    }

    public void O00000oO(String str) {
        this.O0000Oo = str;
    }

    public void O00000oo(String str) {
        this.O0000O0o = str;
    }

    public byte[] O0000O0o() {
        return this.O00000oo != null ? this.O00000oo.O0000O0o() : null;
    }

    public final Map<String, Object> O0000OOo() {
        HashMap hashMap = new HashMap();
        if (O00000oO()) {
            hashMap.put(db.O0000oo, this.O00000Oo);
            hashMap.put(db.O0000ooO, O0000Oo0());
        }
        return hashMap;
    }

    public int O0000Oo() {
        return this.O0000OoO;
    }

    public O000000o O0000Oo0() {
        return O000000o.VEDIO;
    }

    public String O0000OoO() {
        return this.O0000O0o;
    }

    public String O0000Ooo() {
        return this.O0000OOo;
    }

    public String O0000o0() {
        return this.O0000Oo;
    }

    public String O0000o00() {
        return this.O0000Oo0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UMVedio [media_url=");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append(", qzone_title=");
        stringBuilder.append(this.O00000o0);
        stringBuilder.append(", qzone_thumb=");
        stringBuilder.append("media_url=");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append(", qzone_title=");
        stringBuilder.append(this.O00000o0);
        stringBuilder.append(", qzone_thumb=");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
