package com.zjwh.sw.map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.zjwh.sw.map.entity.SWLatLng;

/* compiled from: LocationUtils */
public class O00000Oo {
    private static final String O000000o = "map_location";

    public static SWLatLng O000000o(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(O000000o, 0);
        return new SWLatLng(Double.valueOf(sharedPreferences.getString("gLat", "0")).doubleValue(), Double.valueOf(sharedPreferences.getString("gLon", "0")).doubleValue(), -1.0d, -1.0d);
    }

    public static void O000000o(Context context, double d, double d2) {
        if (context != null) {
            Editor edit = context.getApplicationContext().getSharedPreferences(O000000o, 0).edit();
            edit.putString("gLat", String.valueOf(d));
            edit.putString("gLon", String.valueOf(d2));
            edit.apply();
        }
    }
}
