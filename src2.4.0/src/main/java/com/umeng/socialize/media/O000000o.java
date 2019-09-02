package com.umeng.socialize.media;

import android.os.Parcel;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseMediaObject */
public abstract class O000000o implements UMediaObject {
    public String O000000o = null;
    protected String O00000Oo = "";
    protected Map<String, Object> O00000o = new HashMap();
    protected String O00000o0 = "";
    protected String O00000oO = "";
    protected O0000Oo O00000oo;

    protected O000000o(Parcel parcel) {
        if (parcel != null) {
            this.O00000Oo = parcel.readString();
            this.O00000o0 = parcel.readString();
        }
    }

    public O000000o(String str) {
        this.O00000Oo = str;
    }

    public String O000000o() {
        return this.O00000oO;
    }

    public void O000000o(O0000Oo o0000Oo) {
        this.O00000oo = o0000Oo;
    }

    public void O000000o(String str) {
        this.O00000oO = str;
    }

    public void O000000o(String str, Object obj) {
        this.O00000o.put(str, obj);
    }

    public Map<String, Object> O00000Oo() {
        return this.O00000o;
    }

    public void O00000Oo(String str) {
        this.O00000o0 = str;
    }

    public O0000Oo O00000o() {
        return this.O00000oo;
    }

    public String O00000o0() {
        return this.O00000Oo;
    }

    public boolean O00000oO() {
        return !TextUtils.isEmpty(this.O00000Oo);
    }

    public String O00000oo() {
        return this.O00000o0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BaseMediaObject [media_url=");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append(", qzone_title=");
        stringBuilder.append(this.O00000o0);
        stringBuilder.append(", qzone_thumb=");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
