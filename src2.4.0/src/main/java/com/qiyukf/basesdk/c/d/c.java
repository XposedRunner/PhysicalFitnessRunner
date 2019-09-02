package com.qiyukf.basesdk.c.d;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

public final class c {
    public static byte a;
    private static final Uri b = Uri.parse("content://telephony/carriers/preferapn");

    public static int a(Context context) {
        NetworkInfo k = k(context);
        return k == null ? -1 : k.getType();
    }

    public static boolean b(Context context) {
        NetworkInfo k = k(context);
        return k != null ? k.isAvailable() : false;
    }

    public static boolean c(Context context) {
        NetworkInfo k = k(context);
        return k != null ? k.isConnected() : false;
    }

    public static boolean d(Context context) {
        return !(f(context) ? true : e(context));
    }

    public static boolean e(Context context) {
        int i = i(context);
        return i == 2 || i == 3;
    }

    public static boolean f(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception unused) {
        }
    }

    public static String g(Context context) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        return connectionInfo != null ? connectionInfo.getMacAddress() : "";
    }

    public static String h(Context context) {
        String str = "";
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return activeNetworkInfo.getTypeName();
                }
                StringBuilder stringBuilder = new StringBuilder();
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                stringBuilder.append(activeNetworkInfo.getTypeName());
                stringBuilder.append(" [");
                if (telephonyManager != null) {
                    stringBuilder.append(telephonyManager.getNetworkOperatorName());
                    stringBuilder.append("#");
                }
                stringBuilder.append(activeNetworkInfo.getSubtypeName());
                stringBuilder.append("]");
                str = stringBuilder.toString();
            }
        }
        return str;
    }

    public static int i(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 1;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 2;
                        case 13:
                            return 3;
                        default:
                            return 0;
                    }
                } else if (activeNetworkInfo.getType() == 1) {
                    return 10;
                }
            }
        }
        return 0;
    }

    public static String j(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimOperator() : null;
    }

    private static NetworkInfo k(Context context) {
        try {
            return ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }
}
