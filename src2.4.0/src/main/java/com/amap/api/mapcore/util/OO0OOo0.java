package com.amap.api.mapcore.util;

import com.amap.api.maps.MapsInitializer;
import java.util.Map;

/* compiled from: AbstractAMapRequest */
public abstract class OO0OOo0 extends oOO0OO0O {
    protected boolean isPostFlag = true;

    public Map<String, String> getParams() {
        return null;
    }

    public Map<String, String> getRequestHead() {
        return null;
    }

    /* Access modifiers changed, original: protected */
    public byte[] makeHttpRequest() throws o0O0oo0o {
        int protocol = MapsInitializer.getProtocol();
        oOO0O0O0 O000000o = oOO0O0O0.O000000o(false);
        return protocol == 1 ? this.isPostFlag ? O000000o.O00000Oo(this) : O000000o.O00000o(this) : protocol == 2 ? this.isPostFlag ? O000000o.O000000o(this) : O000000o.O00000oO(this) : null;
    }
}
