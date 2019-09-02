package com.umeng.commonsdk.internal.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.umeng.commonsdk.proguard.e;
import com.umeng.commonsdk.utils.UMUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: UMInternalUtils */
public class k {
    private static final String a = "um_pri";
    private static final String b = "um_common_strength";
    private static final String c = "um_common_battery";

    public static String a(Context context) {
        if (context != null) {
            if (VERSION.SDK_INT >= 23) {
                return Secure.getString(context.getContentResolver(), "bluetooth_address");
            }
            if (UMUtils.checkPermission(context, "android.permission.BLUETOOTH")) {
                return BluetoothAdapter.getDefaultAdapter().getAddress();
            }
        }
        return null;
    }

    public static void a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(b, str).commit();
            }
        }
    }

    public static String b(Context context) {
        String str = null;
        if (context != null && UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            str = telephonyManager.getSimSerialNumber();
        }
        return str;
    }

    public static void b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString(c, str).commit();
            }
        }
    }

    public static String c(Context context) {
        String str = null;
        if (context != null && VERSION.SDK_INT >= 23 && UMUtils.checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager == null) {
                    return null;
                }
                Class cls = telephonyManager.getClass();
                if (((Integer) cls.getMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue() == 2) {
                    str = (String) cls.getMethod("getDeviceId", new Class[]{Integer.TYPE}).invoke(telephonyManager, new Object[]{Integer.valueOf(2)});
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    public static JSONObject d(Context context) {
        JSONObject jSONObject = null;
        if (context != null && (UMUtils.checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION") || UMUtils.checkPermission(context, "android.permission.ACCESS_FINE_LOCATION"))) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            JSONObject jSONObject2;
            CellLocation cellLocation = telephonyManager.getCellLocation();
            int phoneType = telephonyManager.getPhoneType();
            int lac;
            if (phoneType == 1 && (cellLocation instanceof GsmCellLocation)) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                phoneType = gsmCellLocation.getCid();
                if (phoneType > 0 && phoneType != 65535) {
                    lac = gsmCellLocation.getLac();
                    jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("cid", phoneType);
                        jSONObject2.put("lacid", lac);
                        jSONObject2.put("ts", System.currentTimeMillis());
                    } catch (Exception unused) {
                    }
                }
            } else if (phoneType == 2 && (cellLocation instanceof CdmaCellLocation)) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                phoneType = cdmaCellLocation.getBaseStationId();
                lac = cdmaCellLocation.getNetworkId();
                jSONObject2 = new JSONObject();
                jSONObject2.put("cid", phoneType);
                jSONObject2.put("lacid", lac);
                jSONObject2.put("ts", System.currentTimeMillis());
            }
            jSONObject = jSONObject2;
        }
        return jSONObject;
    }

    public static String e(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        return sharedPreferences != null ? sharedPreferences.getString(b, null) : null;
    }

    public static String f(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(a, 0);
        return sharedPreferences != null ? sharedPreferences.getString(c, null) : null;
    }

    public static JSONArray g(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (context != null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService(e.aa);
            if (sensorManager == null) {
                return jSONArray;
            }
            for (Sensor sensor : sensorManager.getSensorList(-1)) {
                if (sensor != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("a_type", sensor.getType());
                        jSONObject.put("a_ven", sensor.getVendor());
                        if (VERSION.SDK_INT >= 24) {
                            jSONObject.put("a_id", sensor.getId());
                        }
                        jSONObject.put("a_na", sensor.getName());
                        jSONObject.put("a_ver", sensor.getVersion());
                        jSONObject.put("a_mar", (double) sensor.getMaximumRange());
                        jSONObject.put("a_ver", sensor.getVersion());
                        jSONObject.put("a_res", (double) sensor.getResolution());
                        jSONObject.put("a_po", (double) sensor.getPower());
                        if (VERSION.SDK_INT >= 9) {
                            jSONObject.put("a_mid", sensor.getMinDelay());
                        }
                        if (VERSION.SDK_INT >= 21) {
                            jSONObject.put("a_mad", sensor.getMaxDelay());
                        }
                        jSONObject.put("ts", System.currentTimeMillis());
                    } catch (Exception unused) {
                    }
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray;
    }
}
