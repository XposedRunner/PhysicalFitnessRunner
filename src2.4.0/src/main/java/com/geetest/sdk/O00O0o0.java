package com.geetest.sdk;

import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: GettypeBean */
public final class O00O0o0 {
    private Map<String, Integer> O000000o;
    private String O00000Oo;
    private String O00000o;
    private String O00000o0;
    private String O00000oO;
    private String O00000oo;
    private String O0000O0o;
    private List<String> O0000OOo;
    private JSONObject O0000Oo0;

    public final Map<String, Integer> O000000o() {
        return this.O000000o;
    }

    public final void O000000o(String str) {
        this.O00000Oo = str;
    }

    public final void O000000o(List<String> list) {
        this.O0000OOo = list;
    }

    public final void O000000o(Map<String, Integer> map) {
        this.O000000o = map;
    }

    public final void O000000o(JSONObject jSONObject) {
        this.O0000Oo0 = jSONObject;
    }

    public final JSONObject O00000Oo() {
        return this.O0000Oo0;
    }

    public final void O00000Oo(String str) {
        this.O00000o0 = str;
    }

    public final void O00000o(String str) {
        this.O00000oO = str;
    }

    public final void O00000o0(String str) {
        this.O00000o = str;
    }

    public final void O00000oO(String str) {
        this.O00000oo = str;
    }

    public final void O00000oo(String str) {
        this.O0000O0o = str;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("GettypeBean{aspect_radio=");
        stringBuilder.append(this.O000000o);
        stringBuilder.append(", type='");
        stringBuilder.append(this.O00000Oo);
        stringBuilder.append('\'');
        stringBuilder.append(", type_value='");
        stringBuilder.append(this.O00000o0);
        stringBuilder.append('\'');
        stringBuilder.append(", geetest='");
        stringBuilder.append(this.O00000o);
        stringBuilder.append('\'');
        stringBuilder.append(", click='");
        stringBuilder.append(this.O00000oO);
        stringBuilder.append('\'');
        stringBuilder.append(", voice='");
        stringBuilder.append(this.O00000oo);
        stringBuilder.append('\'');
        stringBuilder.append(", slide='");
        stringBuilder.append(this.O0000O0o);
        stringBuilder.append('\'');
        stringBuilder.append(", static_servers=");
        stringBuilder.append(this.O0000OOo);
        stringBuilder.append(", jsonObject=");
        stringBuilder.append(this.O0000Oo0);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
