package com.geetest.deepknow.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import com.bangcle.andJni.JniLib1557756502;

/* compiled from: DPDataUtils */
public final class b {
    public static void a(Context context) {
        JniLib1557756502.cV(context, Integer.valueOf(59));
    }

    public static boolean b(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (VERSION.SDK_INT >= 21) {
                for (Network networkInfo : connectivityManager.getAllNetworks()) {
                    if (connectivityManager.getNetworkInfo(networkInfo).getState().equals(State.CONNECTED)) {
                        return true;
                    }
                }
            } else {
                NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                if (allNetworkInfo != null) {
                    for (NetworkInfo state : allNetworkInfo) {
                        if (state.getState() == State.CONNECTED) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }
}
