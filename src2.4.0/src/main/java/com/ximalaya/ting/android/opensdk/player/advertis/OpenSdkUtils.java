package com.ximalaya.ting.android.opensdk.player.advertis;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import com.ximalaya.ting.android.opensdk.httputil.XimalayaException;
import com.ximalaya.ting.android.opensdk.util.MyAsyncTask;
import defpackage.db;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class OpenSdkUtils {
    public static final int NETWORK_TYPE_MOBILE = 0;
    public static final int NETWORK_TYPE_NONE = -1;
    public static final int NETWORK_TYPE_WIFI = 1;
    public static final int OPERATOR_CMCC = 0;
    public static final int OPERATOR_OTHER = 3;
    public static final int OPERATOR_TELECOM = 2;
    public static final int OPERATOR_UNICOME = 1;
    private static Cipher cipher = null;
    private static String key = "1tyt1zuKMloXu/prwDTm5Q==";
    public static String mAndroidId = null;
    private static String mImei = null;
    private static String mMac = "";
    private static String mVersion = "";
    private static String phoneIp;

    public static String AesEcbNopaddingDecrypt(String str) throws Exception {
        return new String(AesEcbNopaddingDecrypt(Base64.decode(str, 0), Base64.decode(key, 0)));
    }

    public static byte[] AesEcbNopaddingDecrypt(byte[] bArr, byte[] bArr2) throws Exception {
        if (cipher == null) {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, secretKeySpec);
        }
        return cipher.doFinal(bArr);
    }

    public static String getAndroidId(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(mAndroidId)) {
            return mAndroidId;
        }
        try {
            mAndroidId = Secure.getString(context.getContentResolver(), db.O000000o);
            return mAndroidId;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo;
        if (context == null) {
            return null;
        }
        PackageManager packageManager;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (NameNotFoundException unused) {
            }
        } catch (NameNotFoundException unused2) {
            packageManager = null;
            applicationInfo = null;
            return (String) packageManager.getApplicationLabel(applicationInfo);
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public static String getIMEI(Context context) {
        try {
            return getIMEIAndNotDefual(context);
        } catch (Exception unused) {
            return "undefined";
        }
    }

    public static String getIMEIAndNotDefual(final Context context) throws Exception {
        AnonymousClass1 anonymousClass1 = new Runnable() {
            public void run() {
                try {
                    OpenSdkUtils.mImei = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                } catch (Exception unused) {
                    OpenSdkUtils.mImei = null;
                }
            }
        };
        if (TextUtils.isEmpty(mImei)) {
            anonymousClass1.run();
            if (!TextUtils.isEmpty(mImei)) {
                return mImei;
            }
            throw new Exception("未获取到imei");
        }
        MyAsyncTask.execute(anonymousClass1, true);
        return mImei;
    }

    @SuppressLint({"WifiManagerLeak"})
    public static String getLocalMacAddress(Context context) throws XimalayaException {
        if (TextUtils.isEmpty(mMac)) {
            mMac = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        }
        if (!TextUtils.isEmpty(mMac)) {
            return mMac;
        }
        throw new XimalayaException(XimalayaException.GET_SYSTEM_PARAMETER_ERROR, "get mac address error");
    }

    private static String getMobileIp() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && isIP(inetAddress.getHostAddress())) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getNetType(Context context) {
        if (context == null) {
            return -1;
        }
        ConnectivityManager connectivityManager;
        try {
            connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e) {
            e.printStackTrace();
            connectivityManager = null;
        }
        if (connectivityManager == null) {
            return -1;
        }
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            activeNetworkInfo = null;
        }
        return (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) ? -1 : activeNetworkInfo.getType() == 1 ? 1 : 0;
    }

    public static int getOperator(android.content.Context r6) {
        /*
        r0 = "phone";
        r6 = r6.getSystemService(r0);	 Catch:{ Exception -> 0x000d }
        r6 = (android.telephony.TelephonyManager) r6;	 Catch:{ Exception -> 0x000d }
        r6 = r6.getSimOperator();	 Catch:{ Exception -> 0x000d }
        goto L_0x0012;
    L_0x000d:
        r6 = move-exception;
        r6.printStackTrace();
        r6 = 0;
    L_0x0012:
        r0 = 3;
        if (r6 == 0) goto L_0x0065;
    L_0x0015:
        r1 = -1;
        r2 = r6.hashCode();
        r3 = 0;
        r4 = 1;
        r5 = 2;
        switch(r2) {
            case 49679470: goto L_0x0053;
            case 49679471: goto L_0x0049;
            case 49679472: goto L_0x003f;
            case 49679473: goto L_0x0035;
            case 49679474: goto L_0x0020;
            case 49679475: goto L_0x002b;
            case 49679476: goto L_0x0020;
            case 49679477: goto L_0x0021;
            default: goto L_0x0020;
        };
    L_0x0020:
        goto L_0x005d;
    L_0x0021:
        r2 = "46007";
        r6 = r6.equals(r2);
        if (r6 == 0) goto L_0x005d;
    L_0x0029:
        r6 = r5;
        goto L_0x005e;
    L_0x002b:
        r2 = "46005";
        r6 = r6.equals(r2);
        if (r6 == 0) goto L_0x005d;
    L_0x0033:
        r6 = 5;
        goto L_0x005e;
    L_0x0035:
        r2 = "46003";
        r6 = r6.equals(r2);
        if (r6 == 0) goto L_0x005d;
    L_0x003d:
        r6 = 4;
        goto L_0x005e;
    L_0x003f:
        r2 = "46002";
        r6 = r6.equals(r2);
        if (r6 == 0) goto L_0x005d;
    L_0x0047:
        r6 = r4;
        goto L_0x005e;
    L_0x0049:
        r2 = "46001";
        r6 = r6.equals(r2);
        if (r6 == 0) goto L_0x005d;
    L_0x0051:
        r6 = r0;
        goto L_0x005e;
    L_0x0053:
        r2 = "46000";
        r6 = r6.equals(r2);
        if (r6 == 0) goto L_0x005d;
    L_0x005b:
        r6 = r3;
        goto L_0x005e;
    L_0x005d:
        r6 = r1;
    L_0x005e:
        switch(r6) {
            case 0: goto L_0x0064;
            case 1: goto L_0x0064;
            case 2: goto L_0x0064;
            case 3: goto L_0x0063;
            case 4: goto L_0x0062;
            case 5: goto L_0x0062;
            default: goto L_0x0061;
        };
    L_0x0061:
        return r0;
    L_0x0062:
        return r5;
    L_0x0063:
        return r4;
    L_0x0064:
        return r3;
    L_0x0065:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.player.advertis.OpenSdkUtils.getOperator(android.content.Context):int");
    }

    public static String getPhoneIP(Context context) {
        if (!TextUtils.isEmpty(phoneIp)) {
            return phoneIp;
        }
        int netType = getNetType(context);
        if (netType == 0) {
            phoneIp = getMobileIp();
        } else if (netType == 1) {
            phoneIp = getWifiIp(context);
        }
        return TextUtils.isEmpty(phoneIp) ? "192.168.1.1" : phoneIp;
    }

    public static String getVersion(Context context) {
        String versionName = getVersionName(context);
        if (TextUtils.isEmpty(versionName)) {
            return versionName;
        }
        String[] split = versionName.split("\\.");
        if (split == null || split.length <= 3) {
            return versionName;
        }
        StringBuilder stringBuilder = null;
        for (int i = 0; i < 3; i++) {
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(split[i]);
            } else {
                stringBuilder.append(".");
                stringBuilder.append(split[i]);
            }
        }
        return stringBuilder != null ? stringBuilder.toString() : versionName;
    }

    public static String getVersionName(Context context) {
        if (!TextUtils.isEmpty(mVersion)) {
            return mVersion;
        }
        if (context == null) {
            return mVersion;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    mVersion = packageInfo.versionName;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            mVersion = "";
        }
        return mVersion;
    }

    private static String getWifiIp(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return "";
        }
        WifiInfo connectionInfo;
        try {
            connectionInfo = wifiManager.getConnectionInfo();
        } catch (Throwable th) {
            th.printStackTrace();
            connectionInfo = null;
        }
        return connectionInfo == null ? "" : intToIp(connectionInfo.getIpAddress());
    }

    private static String intToIp(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i & 255);
        stringBuilder.append(".");
        stringBuilder.append((i >> 8) & 255);
        stringBuilder.append(".");
        stringBuilder.append((i >> 16) & 255);
        stringBuilder.append(".");
        stringBuilder.append((i >> 24) & 255);
        return stringBuilder.toString();
    }

    public static <T> boolean isEmptyCollects(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isIP(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 7 || str.length() > 15) ? false : Pattern.compile("^((\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|\\d\\d|[0-1]\\d\\d|2[0-4]\\d|25[0-5]))$").matcher(str).find();
    }
}
