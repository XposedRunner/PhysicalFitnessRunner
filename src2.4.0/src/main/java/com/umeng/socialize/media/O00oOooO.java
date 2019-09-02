package com.umeng.socialize.media;

import android.os.Parcel;
import com.umeng.socialize.media.UMediaObject.O000000o;
import defpackage.db;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UMusic */
public class O00oOooO extends O000000o {
    private String O0000O0o;
    private String O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private int O0000OoO;
    private String O0000Ooo;

    protected O00oOooO(Parcel parcel) {
        super(parcel);
    }

    public O00oOooO(String str) {
        super(str);
    }

    public void O000000o(int i) {
        this.O0000OoO = i;
    }

    public O0000Oo O00000o() {
        return this.O00000oo;
    }

    public void O00000o(String str) {
        this.O0000Oo = str;
    }

    public void O00000o0(String str) {
        this.O0000Ooo = str;
    }

    public void O00000oO(String str) {
        this.O0000OOo = str;
    }

    public void O00000oo(String str) {
        this.O0000Oo0 = str;
    }

    public void O0000O0o(String str) {
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
            hashMap.put(db.O0000ooo, this.O00000o0);
        }
        return hashMap;
    }

    public String O0000Oo() {
        return this.O0000Ooo;
    }

    public O000000o O0000Oo0() {
        return O000000o.MUSIC;
    }

    public int O0000OoO() {
        return this.O0000OoO;
    }

    public String O0000Ooo() {
        return this.O0000Oo;
    }

    public String O0000o0() {
        return this.O0000Oo0;
    }

    public String O0000o00() {
        return this.O0000OOo;
    }

    public String O0000o0O() {
        return this.O0000O0o;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UMusic [title=");
        stringBuilder.append(this.O00000o0);
        stringBuilder.append("media_url=");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append(", qzone_title=");
        stringBuilder.append(this.O00000o0);
        stringBuilder.append(", qzone_thumb=");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
