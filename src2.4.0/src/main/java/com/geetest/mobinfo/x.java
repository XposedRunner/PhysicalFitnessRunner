package com.geetest.mobinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import com.baidu.location.BDLocation;
import com.bangcle.andJni.JniLib1557756502;
import java.util.List;
import org.json.JSONObject;

/* compiled from: WifiData */
public class x {
    public static String a(Context context) {
        return (String) JniLib1557756502.cL(context, Integer.valueOf(164));
    }

    public static JSONObject a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return (JSONObject) JniLib1557756502.cL(context, str, str2, str3, str4, str5, str6, str7, Integer.valueOf(165));
    }

    public static String b(Context context) {
        return (String) JniLib1557756502.cL(context, Integer.valueOf(166));
    }

    @SuppressLint({"MissingPermission"})
    private static WifiInfo c(Context context) {
        return (WifiInfo) JniLib1557756502.cL(context, Integer.valueOf(BDLocation.TypeServerError));
    }

    @SuppressLint({"MissingPermission"})
    private static int d(Context context) {
        int i = -1;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (VERSION.SDK_INT >= 17) {
                if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != 0 || telephonyManager == null) {
                    return -1;
                }
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        int dbm;
                        if (cellInfo instanceof CellInfoGsm) {
                            dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                        } else if (cellInfo instanceof CellInfoCdma) {
                            dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                        } else if (cellInfo instanceof CellInfoLte) {
                            dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                        } else if (VERSION.SDK_INT >= 18 && (cellInfo instanceof CellInfoWcdma)) {
                            dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                        }
                        i = dbm;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return i;
    }
}
