package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.UMUtils;
import defpackage.db;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Properties;
import javax.microedition.khronos.opengles.GL10;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class DeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_EMUI_VERSION_CODE = "ro.build.hw_emui_api_level";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    protected static final String LOG_TAG = "com.umeng.commonsdk.statistics.common.DeviceConfig";
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";

    private static String byte2HexFormatted(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            String toHexString = Integer.toHexString(bArr[i]);
            int length = toHexString.length();
            if (length == 1) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("0");
                stringBuilder2.append(toHexString);
                toHexString = stringBuilder2.toString();
            }
            if (length > 2) {
                toHexString = toHexString.substring(length - 2, length);
            }
            stringBuilder.append(toHexString.toUpperCase(Locale.getDefault()));
            if (i < bArr.length - 1) {
                stringBuilder.append(':');
            }
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: Missing block: B:7:0x002b, code skipped:
            if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", new java.lang.Class[]{java.lang.String.class}).invoke(r6, new java.lang.Object[]{r7})).intValue() == 0) goto L_0x003c;
     */
    /* JADX WARNING: Missing block: B:9:0x003a, code skipped:
            if (r6.getPackageManager().checkPermission(r7, r6.getPackageName()) == 0) goto L_0x003c;
     */
    public static boolean checkPermission(android.content.Context r6, java.lang.String r7) {
        /*
        r0 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 23;
        r3 = 1;
        if (r1 < r2) goto L_0x002e;
    L_0x000b:
        r1 = "android.content.Context";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x003d }
        r2 = "checkSelfPermission";
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x003d }
        r5 = java.lang.String.class;
        r4[r0] = r5;	 Catch:{ Throwable -> 0x003d }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Throwable -> 0x003d }
        r2 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x003d }
        r2[r0] = r7;	 Catch:{ Throwable -> 0x003d }
        r6 = r1.invoke(r6, r2);	 Catch:{ Throwable -> 0x003d }
        r6 = (java.lang.Integer) r6;	 Catch:{ Throwable -> 0x003d }
        r6 = r6.intValue();	 Catch:{ Throwable -> 0x003d }
        if (r6 != 0) goto L_0x003d;
    L_0x002d:
        goto L_0x003c;
    L_0x002e:
        r1 = r6.getPackageManager();
        r6 = r6.getPackageName();
        r6 = r1.checkPermission(r7, r6);
        if (r6 != 0) goto L_0x003d;
    L_0x003c:
        r0 = r3;
    L_0x003d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    public static String getAndroidId(Context context) {
        if (context != null) {
            try {
                return Secure.getString(context.getContentResolver(), db.O000000o);
            } catch (Exception unused) {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w("can't read android id");
                }
            }
        }
        return null;
    }

    public static String getAppHashKey(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures;
            if (signatureArr.length > 0) {
                Signature signature = signatureArr[0];
                MessageDigest instance = MessageDigest.getInstance("SHA");
                instance.update(signature.toByteArray());
                return Base64.encodeToString(instance.digest(), 0).trim();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String getAppMD5Signature(Context context) {
        if (context == null) {
            return null;
        }
        String byte2HexFormatted;
        try {
            byte2HexFormatted = byte2HexFormatted(MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Throwable unused) {
            byte2HexFormatted = null;
        }
        return byte2HexFormatted;
    }

    public static String getAppName(Context context) {
        if (context == null) {
            return null;
        }
        String charSequence;
        try {
            charSequence = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.i(LOG_TAG, th);
            }
            charSequence = null;
        }
        return charSequence;
    }

    public static String getAppSHA1Key(Context context) {
        try {
            return byte2HexFormatted(MessageDigest.getInstance("SHA1").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(getPackageName(context), 64).signatures[0].toByteArray()))).getEncoded()));
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getAppVersionCode(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String getAppVersionName(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static String getApplicationLable(Context context) {
        return context == null ? "" : context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002d A:{SYNTHETIC, Splitter:B:20:0x002d} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027 A:{SYNTHETIC, Splitter:B:14:0x0027} */
    private static java.util.Properties getBuildProp() {
        /*
        r0 = new java.util.Properties;
        r0.<init>();
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x002b, all -> 0x0024 }
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x002b, all -> 0x0024 }
        r4 = android.os.Environment.getRootDirectory();	 Catch:{ Throwable -> 0x002b, all -> 0x0024 }
        r5 = "build.prop";
        r3.<init>(r4, r5);	 Catch:{ Throwable -> 0x002b, all -> 0x0024 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x002b, all -> 0x0024 }
        r0.load(r2);	 Catch:{ Throwable -> 0x0022, all -> 0x001f }
        if (r2 == 0) goto L_0x0030;
    L_0x001b:
        r2.close();	 Catch:{ Throwable -> 0x0030 }
        goto L_0x0030;
    L_0x001f:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0025;
    L_0x0022:
        r1 = r2;
        goto L_0x002b;
    L_0x0024:
        r0 = move-exception;
    L_0x0025:
        if (r1 == 0) goto L_0x002a;
    L_0x0027:
        r1.close();	 Catch:{ Throwable -> 0x002a }
    L_0x002a:
        throw r0;
    L_0x002b:
        if (r1 == 0) goto L_0x0030;
    L_0x002d:
        r1.close();	 Catch:{ Throwable -> 0x0030 }
    L_0x0030:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getBuildProp():java.util.Properties");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    public static java.lang.String getCPU() {
        /*
        r0 = 0;
        r1 = new java.io.FileReader;	 Catch:{ FileNotFoundException -> 0x002e }
        r2 = "/proc/cpuinfo";
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x002e }
        if (r1 == 0) goto L_0x0036;
    L_0x000a:
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0025 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2.<init>(r1, r3);	 Catch:{ Throwable -> 0x0025 }
        r3 = r2.readLine();	 Catch:{ Throwable -> 0x0025 }
        r2.close();	 Catch:{ Throwable -> 0x0021, FileNotFoundException -> 0x001d }
        r1.close();	 Catch:{ Throwable -> 0x0021, FileNotFoundException -> 0x001d }
        r0 = r3;
        goto L_0x0036;
    L_0x001d:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
        goto L_0x002f;
    L_0x0021:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
        goto L_0x0026;
    L_0x0025:
        r1 = move-exception;
    L_0x0026:
        r2 = LOG_TAG;	 Catch:{ FileNotFoundException -> 0x002e }
        r3 = "Could not read from file /proc/cpuinfo";
        com.umeng.commonsdk.statistics.common.MLog.e(r2, r3, r1);	 Catch:{ FileNotFoundException -> 0x002e }
        goto L_0x0036;
    L_0x002e:
        r1 = move-exception;
    L_0x002f:
        r2 = LOG_TAG;
        r3 = "Could not open file /proc/cpuinfo";
        com.umeng.commonsdk.statistics.common.MLog.e(r2, r3, r1);
    L_0x0036:
        if (r0 == 0) goto L_0x0049;
    L_0x0038:
        r1 = 58;
        r1 = r0.indexOf(r1);
        r1 = r1 + 1;
        r0 = r0.substring(r1);
        r0 = r0.trim();
        return r0;
    L_0x0049:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getCPU():java.lang.String");
    }

    public static String getDBencryptID(Context context) {
        CharSequence charSequence = null;
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                charSequence = telephonyManager.getDeviceId();
            }
            if (!TextUtils.isEmpty(charSequence)) {
                return charSequence;
            }
            String string = Secure.getString(context.getContentResolver(), db.O000000o);
            try {
                if (TextUtils.isEmpty(string) && VERSION.SDK_INT >= 9) {
                    if (VERSION.SDK_INT < 26) {
                        return Build.SERIAL;
                    }
                    Class cls = Class.forName("android.os.Build");
                    return (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
                }
            } catch (Throwable unused) {
            }
            return string;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static String getDeviceId(Context context) {
        return AnalyticsConstants.getDeviceType() == 2 ? getDeviceIdForBox(context) : getDeviceIdForGeneral(context);
    }

    public static String getDeviceIdForBox(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        String str2;
        Object[] objArr;
        StringBuilder stringBuilder;
        Object[] objArr2;
        StringBuilder stringBuilder2;
        if (VERSION.SDK_INT < 23) {
            str = Secure.getString(context.getContentResolver(), db.O000000o);
            if (AnalyticsConstants.UM_DEBUG) {
                str2 = LOG_TAG;
                objArr = new Object[1];
                stringBuilder = new StringBuilder();
                stringBuilder.append("getDeviceId, ANDROID_ID: ");
                stringBuilder.append(str);
                objArr[0] = stringBuilder.toString();
                MLog.i(str2, objArr);
            }
            if (TextUtils.isEmpty(str)) {
                str = getMacBySystemInterface(context);
                if (AnalyticsConstants.UM_DEBUG) {
                    str2 = LOG_TAG;
                    objArr2 = new Object[1];
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("getDeviceId, MAC: ");
                    stringBuilder2.append(str);
                    objArr2[0] = stringBuilder2.toString();
                    MLog.i(str2, objArr2);
                }
                if (TextUtils.isEmpty(str)) {
                    str = getSerialNo();
                    if (TextUtils.isEmpty(str)) {
                        str = getIMEI(context);
                    }
                }
            }
        } else if (VERSION.SDK_INT == 23) {
            str = Secure.getString(context.getContentResolver(), db.O000000o);
            if (AnalyticsConstants.UM_DEBUG) {
                str2 = LOG_TAG;
                objArr = new Object[1];
                stringBuilder = new StringBuilder();
                stringBuilder.append("getDeviceId, ANDROID_ID: ");
                stringBuilder.append(str);
                objArr[0] = stringBuilder.toString();
                MLog.i(str2, objArr);
            }
            if (TextUtils.isEmpty(str)) {
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    str = AnalyticsConstants.CHECK_DEVICE ? getMacShell() : getMacBySystemInterface(context);
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    str2 = LOG_TAG;
                    objArr2 = new Object[1];
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("getDeviceId, MAC: ");
                    stringBuilder2.append(str);
                    objArr2[0] = stringBuilder2.toString();
                    MLog.i(str2, objArr2);
                }
                if (TextUtils.isEmpty(str)) {
                    str = getSerialNo();
                    if (TextUtils.isEmpty(str)) {
                        str = getIMEI(context);
                    }
                }
            }
        } else {
            str = Secure.getString(context.getContentResolver(), db.O000000o);
            if (AnalyticsConstants.UM_DEBUG) {
                str2 = LOG_TAG;
                objArr = new Object[1];
                stringBuilder = new StringBuilder();
                stringBuilder.append("getDeviceId: ANDROID_ID: ");
                stringBuilder.append(str);
                objArr[0] = stringBuilder.toString();
                MLog.i(str2, objArr);
            }
            if (TextUtils.isEmpty(str)) {
                str = getSerialNo();
                if (TextUtils.isEmpty(str)) {
                    str = getIMEI(context);
                    if (TextUtils.isEmpty(str)) {
                        str = getMacByJavaAPI();
                        if (TextUtils.isEmpty(str)) {
                            str = getMacBySystemInterface(context);
                            if (AnalyticsConstants.UM_DEBUG) {
                                String str3 = LOG_TAG;
                                Object[] objArr3 = new Object[1];
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append("getDeviceId, MAC: ");
                                stringBuilder3.append(str);
                                objArr3[0] = stringBuilder3.toString();
                                MLog.i(str3, objArr3);
                            }
                        }
                    }
                }
            }
        }
        return str;
    }

    public static String getDeviceIdForGeneral(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        String str2;
        Object[] objArr;
        StringBuilder stringBuilder;
        String str3;
        Object[] objArr2;
        StringBuilder stringBuilder2;
        if (VERSION.SDK_INT < 23) {
            str = getIMEI(context);
            if (TextUtils.isEmpty(str)) {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w(LOG_TAG, "No IMEI.");
                }
                str = getMacBySystemInterface(context);
                if (TextUtils.isEmpty(str)) {
                    str = Secure.getString(context.getContentResolver(), db.O000000o);
                    if (AnalyticsConstants.UM_DEBUG) {
                        str2 = LOG_TAG;
                        objArr = new Object[1];
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("getDeviceId, ANDROID_ID: ");
                        stringBuilder.append(str);
                        objArr[0] = stringBuilder.toString();
                        MLog.i(str2, objArr);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = getSerialNo();
                    }
                }
            }
        } else if (VERSION.SDK_INT == 23) {
            str = getIMEI(context);
            if (TextUtils.isEmpty(str)) {
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    str = AnalyticsConstants.CHECK_DEVICE ? getMacShell() : getMacBySystemInterface(context);
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    str3 = LOG_TAG;
                    objArr2 = new Object[1];
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("getDeviceId, MAC: ");
                    stringBuilder2.append(str);
                    objArr2[0] = stringBuilder2.toString();
                    MLog.i(str3, objArr2);
                }
                if (TextUtils.isEmpty(str)) {
                    str = Secure.getString(context.getContentResolver(), db.O000000o);
                    if (AnalyticsConstants.UM_DEBUG) {
                        str2 = LOG_TAG;
                        objArr = new Object[1];
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("getDeviceId, ANDROID_ID: ");
                        stringBuilder.append(str);
                        objArr[0] = stringBuilder.toString();
                        MLog.i(str2, objArr);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = getSerialNo();
                    }
                }
            }
        } else {
            str = getIMEI(context);
            if (TextUtils.isEmpty(str)) {
                str = getSerialNo();
                if (TextUtils.isEmpty(str)) {
                    str = Secure.getString(context.getContentResolver(), db.O000000o);
                    if (AnalyticsConstants.UM_DEBUG) {
                        str3 = LOG_TAG;
                        objArr2 = new Object[1];
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("getDeviceId, ANDROID_ID: ");
                        stringBuilder2.append(str);
                        objArr2[0] = stringBuilder2.toString();
                        MLog.i(str3, objArr2);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = getMacByJavaAPI();
                        if (TextUtils.isEmpty(str)) {
                            str = getMacBySystemInterface(context);
                            if (AnalyticsConstants.UM_DEBUG) {
                                str2 = LOG_TAG;
                                objArr = new Object[1];
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("getDeviceId, MAC: ");
                                stringBuilder.append(str);
                                objArr[0] = stringBuilder.toString();
                                MLog.i(str2, objArr);
                            }
                        }
                    }
                }
            }
        }
        return str;
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return HelperUtils.getUmengMD5(getDeviceId(context));
    }

    public static String getDeviceType(Context context) {
        String str = "Phone";
        if (context == null) {
            return str;
        }
        return ((context.getResources().getConfiguration().screenLayout & 15) >= 3 ? 1 : null) != null ? "Tablet" : "Phone";
    }

    public static String getDisplayResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(i2));
            stringBuilder.append("*");
            stringBuilder.append(String.valueOf(i));
            return stringBuilder.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String getEmuiVersion(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String toLowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (toLowerCase.contains("flyme os")) {
                return toLowerCase.split(" ")[2];
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            String[] strArr = new String[2];
            String glGetString = gl10.glGetString(7936);
            String glGetString2 = gl10.glGetString(7937);
            strArr[0] = glGetString;
            strArr[1] = glGetString2;
            return strArr;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(LOG_TAG, "Could not read gpu infor:", th);
            }
            return new String[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    private static java.lang.String getIMEI(android.content.Context r6) {
        /*
        r0 = "";
        if (r6 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r1 = "phone";
        r1 = r6.getSystemService(r1);
        r1 = (android.telephony.TelephonyManager) r1;
        if (r1 == 0) goto L_0x004e;
    L_0x000f:
        r2 = "android.permission.READ_PHONE_STATE";
        r6 = checkPermission(r6, r2);	 Catch:{ Throwable -> 0x003e }
        if (r6 == 0) goto L_0x004e;
    L_0x0017:
        r6 = r1.getDeviceId();	 Catch:{ Throwable -> 0x003e }
        r0 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;	 Catch:{ Throwable -> 0x003c }
        if (r0 == 0) goto L_0x004d;
    L_0x001f:
        r0 = LOG_TAG;	 Catch:{ Throwable -> 0x003c }
        r1 = 1;
        r1 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x003c }
        r2 = 0;
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x003c }
        r3.<init>();	 Catch:{ Throwable -> 0x003c }
        r4 = "getDeviceId, IMEI: ";
        r3.append(r4);	 Catch:{ Throwable -> 0x003c }
        r3.append(r6);	 Catch:{ Throwable -> 0x003c }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x003c }
        r1[r2] = r3;	 Catch:{ Throwable -> 0x003c }
        com.umeng.commonsdk.statistics.common.MLog.i(r0, r1);	 Catch:{ Throwable -> 0x003c }
        goto L_0x004d;
    L_0x003c:
        r0 = move-exception;
        goto L_0x0042;
    L_0x003e:
        r6 = move-exception;
        r5 = r0;
        r0 = r6;
        r6 = r5;
    L_0x0042:
        r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r1 == 0) goto L_0x004d;
    L_0x0046:
        r1 = LOG_TAG;
        r2 = "No IMEI.";
        com.umeng.commonsdk.statistics.common.MLog.w(r1, r2, r0);
    L_0x004d:
        r0 = r6;
    L_0x004e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getIMEI(android.content.Context):java.lang.String");
    }

    public static String getImei(Context context) {
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return (telephonyManager == null || !checkPermission(context, "android.permission.READ_PHONE_STATE")) ? null : telephonyManager.getDeviceId();
        } catch (Exception e) {
            if (!AnalyticsConstants.UM_DEBUG) {
                return null;
            }
            MLog.w("No IMEI.", e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b A:{Catch:{ Exception -> 0x0046 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0035 */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:10|11|12|13|14|(1:16)(1:27)) */
    public static java.lang.String getImeiNew(android.content.Context r5) {
        /*
        r0 = 0;
        if (r5 == 0) goto L_0x0050;
    L_0x0003:
        r1 = "phone";
        r1 = r5.getSystemService(r1);	 Catch:{ Exception -> 0x0046 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x0046 }
        if (r1 == 0) goto L_0x0050;
    L_0x000d:
        r2 = "android.permission.READ_PHONE_STATE";
        r5 = checkPermission(r5, r2);	 Catch:{ Exception -> 0x0046 }
        if (r5 == 0) goto L_0x0050;
    L_0x0015:
        r5 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0046 }
        r2 = 26;
        if (r5 < r2) goto L_0x0040;
    L_0x001b:
        r5 = r1.getClass();	 Catch:{ Exception -> 0x0035 }
        r2 = "getImei";
        r3 = 0;
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0035 }
        r5 = r5.getMethod(r2, r4);	 Catch:{ Exception -> 0x0035 }
        r2 = 1;
        r5.setAccessible(r2);	 Catch:{ Exception -> 0x0035 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0035 }
        r5 = r5.invoke(r1, r2);	 Catch:{ Exception -> 0x0035 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0035 }
        r0 = r5;
    L_0x0035:
        r5 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0046 }
        if (r5 == 0) goto L_0x0050;
    L_0x003b:
        r5 = r1.getDeviceId();	 Catch:{ Exception -> 0x0046 }
        goto L_0x0044;
    L_0x0040:
        r5 = r1.getDeviceId();	 Catch:{ Exception -> 0x0046 }
    L_0x0044:
        r0 = r5;
        goto L_0x0050;
    L_0x0046:
        r5 = move-exception;
        r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r1 == 0) goto L_0x0050;
    L_0x004b:
        r1 = "No IMEI.";
        com.umeng.commonsdk.statistics.common.MLog.w(r1, r5);
    L_0x0050:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.getImeiNew(android.content.Context):java.lang.String");
    }

    public static String getImsi(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
            str = telephonyManager.getSubscriberId();
        }
        return str;
    }

    private static Locale getLocale(Context context) {
        if (context == null) {
            return Locale.getDefault();
        }
        Locale locale = null;
        try {
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            System.getConfiguration(context.getContentResolver(), configuration);
            if (configuration != null) {
                locale = configuration.locale;
            }
        } catch (Throwable unused) {
            MLog.e(LOG_TAG, "fail to read user config locale");
        }
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return locale;
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = new String[]{"Unknown", "Unknown"};
        if (context == null) {
            return strArr;
        }
        try {
            Locale locale = getLocale(context);
            if (locale != null) {
                strArr[0] = locale.getCountry();
                strArr[1] = locale.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Throwable th) {
            MLog.e(LOG_TAG, "error in getLocaleInfo", th);
            return strArr;
        }
    }

    public static String getMCCMNC(Context context) {
        if (context == null || getImsi(context) == null) {
            return null;
        }
        int i = context.getResources().getConfiguration().mcc;
        int i2 = context.getResources().getConfiguration().mnc;
        if (i == 0) {
            return null;
        }
        String valueOf = String.valueOf(i2);
        if (i2 < 10) {
            valueOf = String.format("%02d", new Object[]{Integer.valueOf(i2)});
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf(i));
        stringBuffer.append(valueOf);
        return stringBuffer.toString();
    }

    public static String getMac(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        String macBySystemInterface;
        if (VERSION.SDK_INT < 23) {
            macBySystemInterface = getMacBySystemInterface(context);
        } else {
            if (VERSION.SDK_INT == 23) {
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    macBySystemInterface = AnalyticsConstants.CHECK_DEVICE ? getMacShell() : getMacBySystemInterface(context);
                }
            } else {
                str = getMacByJavaAPI();
                if (TextUtils.isEmpty(str)) {
                    macBySystemInterface = getMacBySystemInterface(context);
                }
            }
            macBySystemInterface = str;
        }
        return macBySystemInterface;
    }

    private static String getMacByJavaAPI() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if (!"wlan0".equals(networkInterface.getName())) {
                    if ("eth0".equals(networkInterface.getName())) {
                    }
                }
                byte[] hardwareAddress = networkInterface.getHardwareAddress();
                if (hardwareAddress != null) {
                    if (hardwareAddress.length != 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        return stringBuilder.toString().toLowerCase(Locale.getDefault());
                    }
                }
                return null;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static String getMacBySystemInterface(Context context) {
        if (context == null) {
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager != null ? wifiManager.getConnectionInfo().getMacAddress() : "";
            } else {
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                }
                return "";
            }
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                String str = LOG_TAG;
                Object[] objArr = new Object[1];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not get mac address.");
                stringBuilder.append(th.toString());
                objArr[0] = stringBuilder.toString();
                MLog.w(str, objArr);
            }
            return "";
        }
    }

    private static String getMacShell() {
        try {
            r0 = new String[3];
            int i = 0;
            r0[0] = "/sys/class/net/wlan0/address";
            r0[1] = "/sys/class/net/eth0/address";
            r0[2] = "/sys/devices/virtual/net/wlan0/address";
            while (i < r0.length) {
                String reaMac = reaMac(r0[i]);
                if (reaMac != null) {
                    return reaMac;
                }
                i++;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = new String[]{"", ""};
        if (context == null) {
            return strArr;
        }
        try {
            if (checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null) {
                    strArr[0] = "";
                    return strArr;
                }
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                    if (networkInfo2 != null && networkInfo2.getState() == State.CONNECTED) {
                        strArr[0] = "2G/3G";
                        strArr[1] = networkInfo2.getSubtypeName();
                        return strArr;
                    }
                    return strArr;
                }
                strArr[0] = "Wi-Fi";
                return strArr;
            }
            strArr[0] = "";
            return strArr;
        } catch (Throwable unused) {
        }
    }

    public static String getNetworkOperatorName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String getPackageName(Context context) {
        return context == null ? null : context.getPackageName();
    }

    public static String getRegisteredOperator(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
            str = telephonyManager.getNetworkOperator();
        }
        return str;
    }

    public static int[] getResolutionArray(Context context) {
        if (context == null) {
            return null;
        }
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return null;
            }
            int reflectMetrics;
            int reflectMetrics2;
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                reflectMetrics = reflectMetrics(displayMetrics, "noncompatWidthPixels");
                reflectMetrics2 = reflectMetrics(displayMetrics, "noncompatHeightPixels");
            } else {
                reflectMetrics = -1;
                reflectMetrics2 = reflectMetrics;
            }
            if (reflectMetrics == -1 || r3 == -1) {
                reflectMetrics = displayMetrics.widthPixels;
                reflectMetrics2 = displayMetrics.heightPixels;
            }
            int[] iArr = new int[2];
            if (reflectMetrics > reflectMetrics2) {
                iArr[0] = reflectMetrics2;
                iArr[1] = reflectMetrics;
            } else {
                iArr[0] = reflectMetrics;
                iArr[1] = reflectMetrics2;
            }
            return iArr;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                MLog.e(LOG_TAG, "read resolution fail", th);
            }
            return null;
        }
    }

    public static String getSerial() {
        String str = null;
        if (VERSION.SDK_INT < 9) {
            return null;
        }
        if (VERSION.SDK_INT >= 26) {
            try {
                Class cls = Class.forName("android.os.Build");
                str = (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
            } catch (Throwable unused) {
            }
        } else {
            str = Build.SERIAL;
        }
        return str;
    }

    private static String getSerialNo() {
        String str = "";
        if (VERSION.SDK_INT >= 9) {
            if (VERSION.SDK_INT >= 26) {
                try {
                    Class cls = Class.forName("android.os.Build");
                    str = (String) cls.getMethod("getSerial", new Class[0]).invoke(cls, new Object[0]);
                } catch (Throwable unused) {
                }
            } else {
                str = Build.SERIAL;
            }
        }
        if (AnalyticsConstants.UM_DEBUG) {
            String str2 = LOG_TAG;
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getDeviceId, serial no: ");
            stringBuilder.append(str);
            objArr[0] = stringBuilder.toString();
            MLog.i(str2, objArr);
        }
        return str;
    }

    public static String getSubOSName(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            return TextUtils.isEmpty(property) ? isFlyMe() ? "Flyme" : isEmui(buildProp) ? "Emui" : !TextUtils.isEmpty(getYunOSVersion(buildProp)) ? "YunOS" : property : "MIUI";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getSubOSVersion(Context context) {
        Properties buildProp = getBuildProp();
        try {
            String property = buildProp.getProperty(KEY_MIUI_VERSION_NAME);
            if (TextUtils.isEmpty(property)) {
                if (!isFlyMe()) {
                    return isEmui(buildProp) ? getEmuiVersion(buildProp) : getYunOSVersion(buildProp);
                } else {
                    try {
                        return getFlymeVersion(buildProp);
                    } catch (Throwable unused) {
                    }
                }
            }
            return property;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int getTimeZone(Context context) {
        if (context == null) {
            return 8;
        }
        try {
            Calendar instance = Calendar.getInstance(getLocale(context));
            if (instance != null) {
                return instance.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Throwable th) {
            MLog.i(LOG_TAG, "error in getTimeZone", th);
        }
        return 8;
    }

    private static String getYunOSVersion(Properties properties) {
        String property = properties.getProperty("ro.yunos.version");
        return !TextUtils.isEmpty(property) ? property : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A:{RETURN} */
    public static boolean isChineseAera(android.content.Context r4) {
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "country";
        r2 = "";
        r1 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r4, r1, r2);
        r2 = android.text.TextUtils.isEmpty(r1);
        r3 = 1;
        if (r2 != 0) goto L_0x001d;
    L_0x0013:
        r4 = "cn";
        r4 = r1.equals(r4);
        if (r4 == 0) goto L_0x001c;
    L_0x001b:
        return r3;
    L_0x001c:
        return r0;
    L_0x001d:
        r1 = getImsi(r4);
        if (r1 != 0) goto L_0x0038;
    L_0x0023:
        r4 = getLocaleInfo(r4);
        r4 = r4[r0];
        r1 = android.text.TextUtils.isEmpty(r4);
        if (r1 != 0) goto L_0x0062;
    L_0x002f:
        r1 = "cn";
        r4 = r4.equalsIgnoreCase(r1);
        if (r4 == 0) goto L_0x0062;
    L_0x0037:
        return r3;
    L_0x0038:
        r1 = r4.getResources();
        r1 = r1.getConfiguration();
        r1 = r1.mcc;
        r2 = 460; // 0x1cc float:6.45E-43 double:2.273E-321;
        if (r1 == r2) goto L_0x0063;
    L_0x0046:
        r2 = 461; // 0x1cd float:6.46E-43 double:2.28E-321;
        if (r1 != r2) goto L_0x004b;
    L_0x004a:
        goto L_0x0063;
    L_0x004b:
        if (r1 != 0) goto L_0x0062;
    L_0x004d:
        r4 = getLocaleInfo(r4);
        r4 = r4[r0];
        r1 = android.text.TextUtils.isEmpty(r4);
        if (r1 != 0) goto L_0x0062;
    L_0x0059:
        r1 = "cn";
        r4 = r4.equalsIgnoreCase(r1);
        if (r4 == 0) goto L_0x0062;
    L_0x0061:
        return r3;
    L_0x0062:
        return r0;
    L_0x0063:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.isChineseAera(android.content.Context):boolean");
    }

    private static boolean isEmui(Properties properties) {
        try {
            return properties.getProperty(KEY_EMUI_VERSION_CODE, null) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isOnline(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnectedOrConnecting();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isWiFiAvailable(Context context) {
        return context == null ? false : "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0025 A:{SYNTHETIC, Splitter:B:21:0x0025} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x002a A:{SYNTHETIC, Splitter:B:25:0x002a} */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|(0)|(0)|27|28) */
    private static java.lang.String reaMac(java.lang.String r3) {
        /*
        r0 = 0;
        r1 = new java.io.FileReader;	 Catch:{ Throwable -> 0x002e }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x002e }
        if (r1 == 0) goto L_0x002e;
    L_0x0008:
        r3 = new java.io.BufferedReader;	 Catch:{ all -> 0x0021 }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3.<init>(r1, r2);	 Catch:{ all -> 0x0021 }
        r2 = r3.readLine();	 Catch:{ all -> 0x001f }
        if (r1 == 0) goto L_0x0018;
    L_0x0015:
        r1.close();	 Catch:{ Throwable -> 0x0018 }
    L_0x0018:
        if (r3 == 0) goto L_0x001d;
    L_0x001a:
        r3.close();	 Catch:{ Throwable -> 0x001d }
    L_0x001d:
        r0 = r2;
        goto L_0x002e;
    L_0x001f:
        r2 = move-exception;
        goto L_0x0023;
    L_0x0021:
        r2 = move-exception;
        r3 = r0;
    L_0x0023:
        if (r1 == 0) goto L_0x0028;
    L_0x0025:
        r1.close();	 Catch:{ Throwable -> 0x0028 }
    L_0x0028:
        if (r3 == 0) goto L_0x002d;
    L_0x002a:
        r3.close();	 Catch:{ Throwable -> 0x002d }
    L_0x002d:
        throw r2;	 Catch:{ Throwable -> 0x002e }
    L_0x002e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.DeviceConfig.reaMac(java.lang.String):java.lang.String");
    }

    private static int reflectMetrics(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Throwable unused) {
            return -1;
        }
    }
}
