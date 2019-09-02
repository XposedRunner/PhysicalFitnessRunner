package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: BaseNetManager */
public class ooooOO00 {
    public static int O000000o = 0;
    public static String O00000Oo = "";
    private static ooooOO00 O00000o0;

    /* compiled from: BaseNetManager */
    public interface O000000o {
        URLConnection O000000o(Proxy proxy, URL url);
    }

    public static ooooOO00 O000000o() {
        if (O00000o0 == null) {
            O00000o0 = new ooooOO00();
        }
        return O00000o0;
    }

    public oOO0Oo00 O000000o(oOO0OO0O ooo0oo0o, boolean z) throws o0O0oo0o {
        o0O0oo0o e;
        try {
            O00000o0(ooo0oo0o);
            return new oOO0O00O(ooo0oo0o.a, ooo0oo0o.b, ooo0oo0o.c == null ? null : ooo0oo0o.c, z).O000000o(ooo0oo0o.b(), ooo0oo0o.isIPRequest(), ooo0oo0o.getIPDNSName(), ooo0oo0o.getRequestHead(), ooo0oo0o.c(), ooo0oo0o.isIgnoreGZip());
        } catch (o0O0oo0o e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            e2 = new o0O0oo0o(AMapException.ERROR_UNKNOWN);
        }
    }

    public byte[] O000000o(oOO0OO0O ooo0oo0o) throws o0O0oo0o {
        o0O0oo0o e;
        try {
            oOO0Oo00 O000000o = O000000o(ooo0oo0o, true);
            return O000000o != null ? O000000o.O000000o : null;
        } catch (o0O0oo0o e2) {
            throw e2;
        } catch (Throwable unused) {
            e2 = new o0O0oo0o(AMapException.ERROR_UNKNOWN);
        }
    }

    public byte[] O00000Oo(oOO0OO0O ooo0oo0o) throws o0O0oo0o {
        o0O0oo0o e;
        try {
            oOO0Oo00 O000000o = O000000o(ooo0oo0o, false);
            return O000000o != null ? O000000o.O000000o : null;
        } catch (o0O0oo0o e2) {
            throw e2;
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "bm", "msp");
            e2 = new o0O0oo0o(AMapException.ERROR_UNKNOWN);
        }
    }

    /* Access modifiers changed, original: protected */
    public void O00000o0(oOO0OO0O ooo0oo0o) throws o0O0oo0o {
        if (ooo0oo0o == null) {
            throw new o0O0oo0o("requeust is null");
        } else if (ooo0oo0o.getURL() == null || "".equals(ooo0oo0o.getURL())) {
            throw new o0O0oo0o("request url is empty");
        }
    }
}
