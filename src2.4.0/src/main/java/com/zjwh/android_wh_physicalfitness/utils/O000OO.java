package com.zjwh.android_wh_physicalfitness.utils;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import org.xutils.common.util.DensityUtil;

/* compiled from: DeviceInfo */
public class O000OO {
    public static final String O000000o = "02:00:00:00:00:00";
    private static final String O00000Oo = "DeviceInfo";
    private static TelephonyManager O00000o;
    private static Context O00000o0;
    private static PackageInfo O00000oO;

    public static String O000000o() {
        String language = Locale.getDefault().getLanguage();
        return language == null ? "" : language;
    }

    private static String O000000o(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("x");
        stringBuilder.append(i2);
        return stringBuilder.toString();
    }

    private static String O000000o(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Character.toUpperCase(charAt));
        stringBuilder.append(str.substring(1));
        return stringBuilder.toString();
    }

    private static ArrayList<String> O000000o(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(strArr).getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return arrayList;
                }
                arrayList.add(readLine);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static void O000000o(Context context) {
        O00000o0 = context;
        try {
            O00000o = (TelephonyManager) context.getSystemService("phone");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Missing block: B:7:0x002b, code skipped:
            if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", new java.lang.Class[]{java.lang.String.class}).invoke(r6, new java.lang.Object[]{r7})).intValue() == 0) goto L_0x003c;
     */
    /* JADX WARNING: Missing block: B:9:0x003a, code skipped:
            if (r6.getPackageManager().checkPermission(r7, r6.getPackageName()) == 0) goto L_0x003c;
     */
    public static boolean O000000o(android.content.Context r6, java.lang.String r7) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.utils.O000OO.O000000o(android.content.Context, java.lang.String):boolean");
    }

    public static String O00000Oo() {
        String str = Build.PRODUCT;
        return str == null ? "" : str;
    }

    private static String O00000Oo(Context context) {
        if (context == null) {
            return O000000o;
        }
        try {
            return O000000o(context, "android.permission.ACCESS_WIFI_STATE") ? ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress() : O000000o;
        } catch (Throwable unused) {
            return O000000o;
        }
    }

    public static int O00000o() {
        return O00000o == null ? -1 : O00000o.getPhoneType();
    }

    public static String O00000o0() {
        String str = VERSION.RELEASE;
        return str == null ? "" : str;
    }

    public static String O00000oO() {
        return O000000o(DensityUtil.getScreenWidth(), DensityUtil.getScreenHeight());
    }

    public static String O00000oo() {
        return O000000o((int) (((float) DensityUtil.getScreenWidth()) / DensityUtil.getDensity()), (int) (((float) DensityUtil.getScreenHeight()) / DensityUtil.getDensity()));
    }

    public static String O0000O0o() {
        Exception e;
        String str = "";
        try {
            if (!O000000o(O00000o0, "android.permission.READ_PHONE_STATE")) {
                return "";
            }
            String subscriberId = O00000o.getSubscriberId();
            if (subscriberId != null) {
                return subscriberId;
            }
            try {
                return "";
            } catch (Exception e2) {
                String str2 = subscriberId;
                e = e2;
                str = str2;
                e.printStackTrace();
                return str;
            }
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return str;
        }
    }

    public static String O0000OOo() {
        try {
            String str = Build.MANUFACTURER;
            if (str == null) {
                str = "";
            }
            String str2 = Build.MODEL;
            if (str2 == null) {
                str2 = "";
            }
            if (str2.startsWith(str)) {
                return O000000o(str2).trim();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o(str));
            stringBuilder.append(" ");
            stringBuilder.append(str2);
            return stringBuilder.toString().trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String O0000Oo() {
        Exception e;
        String str = "";
        try {
            if (!O000000o(O00000o0, "android.permission.READ_PHONE_STATE")) {
                return "";
            }
            String deviceId = O00000o.getDeviceId();
            if (deviceId == null) {
                try {
                    str = "";
                } catch (Exception e2) {
                    String str2 = deviceId;
                    e = e2;
                    str = str2;
                }
            } else {
                str = deviceId;
            }
            return str;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return str;
        }
    }

    public static String O0000Oo0() {
        String str = "";
        try {
            ContentResolver contentResolver = O00000o0.getContentResolver();
            return contentResolver != null ? Secure.getString(contentResolver, "android_id") : str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static PackageInfo O0000OoO() throws NameNotFoundException {
        if (O00000oO == null) {
            synchronized (O000OO.class) {
                PackageManager packageManager = O00000o0.getApplicationContext().getPackageManager();
                if (packageManager != null) {
                    O00000oO = packageManager.getPackageInfo(O00000o0.getApplicationContext().getPackageName(), 16384);
                }
            }
        }
        return O00000oO;
    }

    public static long O0000Ooo() {
        long j = 0;
        try {
            if (O0000OoO() != null) {
                j = O0000OoO().firstInstallTime;
            }
            return j;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String O0000o() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date());
        } catch (Exception unused) {
            return "";
        }
    }

    public static String O0000o0() {
        CharSequence charSequence = Build.CPU_ABI;
        if (VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr != null && strArr.length > 0) {
                charSequence = strArr[0];
            }
        }
        return TextUtils.isEmpty(charSequence) ? "" : charSequence;
    }

    public static long O0000o00() {
        long j = 0;
        try {
            if (O0000OoO() != null) {
                j = O0000OoO().lastUpdateTime;
            }
            return j;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    public static java.lang.String O0000o0O() {
        /*
        r0 = "02:00:00:00:00:00";
        r1 = android.bluetooth.BluetoothAdapter.getDefaultAdapter();	 Catch:{ Exception -> 0x003c }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x003c }
        r3 = 23;
        if (r2 < r3) goto L_0x0037;
    L_0x000c:
        r2 = r1.getClass();	 Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040 }
        r3 = "mService";
        r2 = r2.getDeclaredField(r3);	 Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040 }
        r3 = 1;
        r2.setAccessible(r3);	 Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040 }
        r1 = r2.get(r1);	 Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040 }
        if (r1 == 0) goto L_0x0040;
    L_0x0020:
        r2 = r1.getClass();	 Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040 }
        r3 = "getAddress";
        r4 = 0;
        r5 = new java.lang.Class[r4];	 Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040 }
        r2 = r2.getMethod(r3, r5);	 Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040 }
        r3 = new java.lang.Object[r4];	 Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040 }
        r1 = r2.invoke(r1, r3);	 Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040 }
        r1 = (java.lang.String) r1;	 Catch:{ IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040, IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException -> 0x0040 }
    L_0x0035:
        r0 = r1;
        goto L_0x0040;
    L_0x0037:
        r1 = r1.getAddress();	 Catch:{ Exception -> 0x003c }
        goto L_0x0035;
    L_0x003c:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0040:
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 == 0) goto L_0x0048;
    L_0x0046:
        r0 = "02:00:00:00:00:00";
    L_0x0048:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.utils.O000OO.O0000o0O():java.lang.String");
    }

    public static String O0000o0o() {
        String str = "";
        if (O00000o0 == null) {
            return str;
        }
        if (VERSION.SDK_INT < 23) {
            str = O00000Oo(O00000o0);
        } else {
            str = O0000oo0();
            if (TextUtils.isEmpty(str)) {
                str = O00000Oo(O00000o0);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = O000000o;
        }
        return str;
    }

    public static boolean O0000oO() {
        try {
            if (!O000000o(O00000o0, "android.permission.ACCESS_WIFI_STATE")) {
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) O00000o0.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                if (allNetworkInfo != null) {
                    int i = 0;
                    while (i < allNetworkInfo.length) {
                        if (allNetworkInfo[i].getTypeName().equals("WIFI") && allNetworkInfo[i].isConnected()) {
                            return true;
                        }
                        i++;
                    }
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String O0000oO0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) O00000o0.getSystemService("connectivity");
            String toLowerCase = connectivityManager.getActiveNetworkInfo().getTypeName().toLowerCase(Locale.US);
            if (!toLowerCase.equals("wifi")) {
                toLowerCase = connectivityManager.getNetworkInfo(0).getExtraInfo();
            }
            return toLowerCase;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String O0000oOO() {
        try {
            String networkOperator = O00000o.getNetworkOperator();
            return networkOperator == null ? "" : networkOperator;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int O0000oOo() {
        return (O0000ooO() || O0000ooo() || O00oOooO() || O00oOooo() || O000O00o() || O000O0OO()) ? 1 : 0;
    }

    private static String O0000oo() {
        Exception e;
        String str = "";
        try {
            if (!O000000o(O00000o0, "android.permission.READ_PHONE_STATE")) {
                return "";
            }
            String simSerialNumber = O00000o.getSimSerialNumber();
            if (simSerialNumber == null) {
                try {
                    str = "";
                } catch (Exception e2) {
                    String str2 = simSerialNumber;
                    e = e2;
                    str = str2;
                }
            } else {
                str = simSerialNumber;
            }
            return str;
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            return str;
        }
    }

    @TargetApi(9)
    private static String O0000oo0() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = (NetworkInterface) networkInterfaces.nextElement();
                if ("wlan0".equals(networkInterface.getName()) || "eth0".equals(networkInterface.getName())) {
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
                            String toLowerCase = stringBuilder.toString().toLowerCase(Locale.getDefault());
                            if (!toLowerCase.equals(O000000o)) {
                                return toLowerCase;
                            }
                        }
                    }
                    return O000000o;
                }
            }
            return O000000o;
        } catch (Throwable th) {
            th.printStackTrace();
            return O000000o;
        }
    }

    private static boolean O0000ooO() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    private static boolean O0000ooo() {
        try {
            if (new File("/system/app/Superuser.apk").exists()) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static synchronized boolean O000O00o() {
        boolean z;
        synchronized (O000OO.class) {
            z = false;
            try {
                if (O000000o(new String[]{"busybox", "df"}) != null) {
                    z = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return z;
    }

    private static synchronized boolean O000O0OO() {
        boolean equals;
        synchronized (O000OO.class) {
            try {
                equals = "test_ok".equals(O000O0Oo());
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return equals;
    }

    private static String O000O0Oo() {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("/data/su_test"));
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    return new String(byteArrayOutputStream.toByteArray());
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean O00oOooO() {
        try {
            for (String str : new String[]{"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"}) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("su");
                if (new File(stringBuilder.toString()).exists()) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean O00oOooo() {
        return O000000o(new String[]{"/system/xbin/which", "su"}) != null;
    }
}
