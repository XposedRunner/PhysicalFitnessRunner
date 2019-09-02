package com.amap.api.mapcore.util;

import com.amap.api.mapcore.util.o0OO0o00.O000000o;
import com.autonavi.amap.mapcore.Inner_3dMap_location;
import com.tencent.connect.common.Constants;

/* compiled from: Util */
public final class bd {
    static o0OO0o00 O000000o;
    private static final String[] O00000Oo = new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"};
    private static final String[] O00000o = new String[]{"com.amap.trace"};
    private static final String[] O00000o0 = new String[]{"com.amap.api.mapcore2d", "com.amap.api.maps2d"};

    public static o0OO0o00 O000000o() throws o0O0oo0o {
        if (O000000o != null) {
            return O000000o;
        }
        Class cls;
        try {
            cls = Class.forName("com.amap.api.maps.MapsInitializer");
        } catch (Throwable unused) {
            cls = null;
        }
        StringBuilder stringBuilder;
        if (cls != null) {
            try {
                String str = (String) br.O000000o(cls, "getVersion", null, null);
                stringBuilder = new StringBuilder("AMAP_SDK_Android_Map_");
                stringBuilder.append(str);
                O000000o = new O000000o("3dmap", str, stringBuilder.toString()).O000000o(O00000Oo).O000000o();
            } catch (Throwable unused2) {
            }
        } else {
            Class cls2 = Class.forName("com.amap.api.maps2d.MapsInitializer");
            try {
                String str2 = (String) br.O000000o(cls2, "getVersion", null, null);
                stringBuilder = new StringBuilder("AMAP_SDK_Android_2DMap_");
                stringBuilder.append(str2);
                O000000o = new O000000o("2dmap", str2, stringBuilder.toString()).O000000o(O00000o0).O000000o();
            } catch (Throwable unused3) {
            }
            cls = cls2;
        }
        if (cls == null) {
            try {
                cls = Class.forName("com.amap.trace.AMapTraceClient");
            } catch (Throwable unused4) {
                cls = null;
            }
            if (cls != null) {
                try {
                    String str3 = (String) br.O000000o(cls, "getVersion", null, null);
                    StringBuilder stringBuilder2 = new StringBuilder("AMAP_TRACE_Android_");
                    stringBuilder2.append(str3);
                    O000000o = new O000000o("trace", str3, stringBuilder2.toString()).O000000o(O00000o).O000000o();
                } catch (Throwable unused5) {
                }
            }
        }
        return O000000o;
    }

    public static boolean O000000o(ls lsVar) {
        return (lsVar == null || lsVar.O00000o().equals(Constants.VIA_SHARE_TYPE_PUBLISHVIDEO) || lsVar.O00000o().equals("5") || lsVar.O00000o().equals(Constants.VIA_SHARE_TYPE_INFO)) ? false : O000000o((Inner_3dMap_location) lsVar);
    }

    private static boolean O000000o(Inner_3dMap_location inner_3dMap_location) {
        double longitude = inner_3dMap_location.getLongitude();
        double latitude = inner_3dMap_location.getLatitude();
        boolean z = false;
        if (!(longitude == 0.0d && latitude == 0.0d) && longitude <= 180.0d) {
            if (latitude > 90.0d) {
                return false;
            }
            if (longitude >= -180.0d) {
                if (latitude < -90.0d) {
                    return false;
                }
                z = true;
            }
        }
        return z;
    }
}
