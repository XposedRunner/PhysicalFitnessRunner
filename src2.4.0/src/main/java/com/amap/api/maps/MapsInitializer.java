package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.mapcore.util.cf;
import com.amap.api.mapcore.util.o0O0O0o0;
import com.amap.api.mapcore.util.o0OO00OO;
import com.amap.api.mapcore.util.ooooOO00;

public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static boolean a = true;
    private static boolean b = true;
    private static boolean c = false;
    private static int d = 1;
    public static String sdcardDir = "";

    public static boolean getNetWorkEnable() {
        return a;
    }

    public static int getProtocol() {
        return d;
    }

    public static String getVersion() {
        return "6.8.0";
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            cf.O000000o = context.getApplicationContext();
        } else {
            Log.w("MapsInitializer", "the context is null");
        }
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return b;
    }

    public static boolean isLoadWorldGridMap() {
        return c;
    }

    public static void loadWorldGridMap(boolean z) {
        c = z;
    }

    public static void setApiKey(String str) {
        if (str != null && str.trim().length() > 0) {
            o0O0O0o0.O000000o(cf.O000000o, str);
        }
    }

    public static void setBuildingHeight(int i) {
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z) {
        b = z;
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            ooooOO00.O000000o = -1;
            ooooOO00.O00000Oo = "";
            return;
        }
        ooooOO00.O000000o = 1;
        ooooOO00.O00000Oo = str;
    }

    public static void setNetWorkEnable(boolean z) {
        a = z;
    }

    public static void setProtocol(int i) {
        d = i;
        o0OO00OO.O000000o().O000000o(d == 2);
    }
}
