package com.umeng.socialize.net.dplus.cache;

import com.umeng.socialize.utils.O0000O0o;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonReader */
public class O0000Oo0 extends O0000OOo<JSONObject> {
    public O0000Oo0(String str) {
        super(str);
    }

    public void O000000o(String str) {
        try {
            this.O000000o = new JSONObject(str);
        } catch (JSONException e) {
            O0000O0o.O000000o(e);
        }
    }
}
