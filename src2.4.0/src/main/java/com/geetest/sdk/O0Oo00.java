package com.geetest.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.TelephonyManager;

/* compiled from: NetworkUtils */
public class O0Oo00 {
    static final /* synthetic */ boolean O000000o = true;

    public static boolean O000000o(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (!O000000o && connectivityManager == null) {
            throw new AssertionError();
        } else if (connectivityManager == null) {
            return false;
        } else {
            NetworkInfo[] allNetworkInfo;
            try {
                allNetworkInfo = connectivityManager.getAllNetworkInfo();
            } catch (Exception unused) {
                allNetworkInfo = null;
            }
            if (allNetworkInfo != null) {
                for (NetworkInfo state : allNetworkInfo) {
                    if (state.getState() == State.CONNECTED) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static String O00000Oo(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return "WIFI";
            }
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                return "NULL";
        }
    }
}
