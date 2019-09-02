package com.ximalaya.ting.android.opensdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public class NetworkType {
    public static final int OPERATOR_CMCC = 0;
    public static final int OPERATOR_OTHER = 3;
    public static final int OPERATOR_TELECOM = 2;
    public static final int OPERATOR_UNICOME = 1;

    public enum NetWorkType {
        NETWORKTYPE_INVALID("no_network", 1),
        NETWORKTYPE_WAP("wap", 2),
        NETWORKTYPE_2G("2g", 3),
        NETWORKTYPE_3G("3g", 4),
        NETWORKTYPE_WIFI("wifi", 5);
        
        private int index;
        private String name;

        private NetWorkType(String str, int i) {
            this.name = str;
            this.index = i;
        }

        public static String getName(int i) {
            for (NetWorkType netWorkType : values()) {
                if (netWorkType.getIndex() == i) {
                    return netWorkType.name;
                }
            }
            return null;
        }

        public int getIndex() {
            return this.index;
        }

        public String getName() {
            return this.name;
        }

        public void setIndex(int i) {
            this.index = i;
        }

        public void setName(String str) {
            this.name = str;
        }
    }

    public static NetWorkType getNetWorkType(Context context) {
        if (context == null) {
            return NetWorkType.NETWORKTYPE_INVALID;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
        }
        NetWorkType netWorkType = NetWorkType.NETWORKTYPE_INVALID;
        if (networkInfo == null || !networkInfo.isConnected()) {
            netWorkType = NetWorkType.NETWORKTYPE_INVALID;
        } else {
            String typeName = networkInfo.getTypeName();
            if (typeName.equalsIgnoreCase("WIFI")) {
                netWorkType = NetWorkType.NETWORKTYPE_WIFI;
            } else if (typeName.equalsIgnoreCase("MOBILE")) {
                NetWorkType netWorkType2 = TextUtils.isEmpty(Proxy.getDefaultHost()) ? isFastMobileNetwork(context) ? NetWorkType.NETWORKTYPE_3G : NetWorkType.NETWORKTYPE_2G : NetWorkType.NETWORKTYPE_WAP;
                netWorkType = netWorkType2;
            }
        }
        return netWorkType;
    }

    public static int getOperator(Context context) {
        if (context == null) {
            return 3;
        }
        String simOperator;
        try {
            simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        } catch (Exception unused) {
            simOperator = null;
        }
        return simOperator != null ? (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007") || simOperator.equals("46020")) ? 0 : (simOperator.equals("46001") || simOperator.equals("46006") || simOperator.equals("46009")) ? 1 : (simOperator.equals("46003") || simOperator.equals("46005") || simOperator.equals("46011")) ? 2 : 3 : 3;
    }

    public static boolean isConnectMOBILE(Context context) {
        NetWorkType netWorkType = getNetWorkType(context);
        return netWorkType == NetWorkType.NETWORKTYPE_WAP || netWorkType == NetWorkType.NETWORKTYPE_2G || netWorkType == NetWorkType.NETWORKTYPE_3G;
    }

    public static boolean isConnectTONetWork(Context context) {
        return getNetWorkType(context) != NetWorkType.NETWORKTYPE_INVALID;
    }

    public static boolean isConnectToWifi(Context context) {
        return getNetWorkType(context) == NetWorkType.NETWORKTYPE_WIFI;
    }

    private static boolean isFastMobileNetwork(Context context) {
        int networkType;
        try {
            networkType = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
        } catch (Exception unused) {
            networkType = 0;
        }
        switch (networkType) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return false;
            case 5:
                return true;
            case 6:
                return true;
            case 7:
                return false;
            case 8:
                return true;
            case 9:
                return true;
            case 10:
                return true;
            case 11:
                return false;
            case 12:
                return true;
            case 13:
                return true;
            case 14:
                return true;
            case 15:
                return true;
            default:
                return false;
        }
    }
}
