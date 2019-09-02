package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;

@Deprecated
/* compiled from: AuthRequest */
class o0OOOO0o extends oOO0OO0O {
    private Map<String, String> O000000o = new HashMap();
    private String O00000Oo;
    private Map<String, String> O00000o0 = new HashMap();

    o0OOOO0o() {
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(String str) {
        this.O00000Oo = str;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Map<String, String> map) {
        this.O000000o.clear();
        this.O000000o.putAll(map);
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(Map<String, String> map) {
        this.O00000o0.clear();
        this.O00000o0.putAll(map);
    }

    public Map<String, String> getParams() {
        return this.O00000o0;
    }

    public Map<String, String> getRequestHead() {
        return this.O000000o;
    }

    public String getURL() {
        return this.O00000Oo;
    }
}
