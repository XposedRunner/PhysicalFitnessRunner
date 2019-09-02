package com.umeng.commonsdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import defpackage.db;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;

public class UMUtils {
    public static final int DEFAULT_TIMEZONE = 8;
    private static final String KEY_APP_KEY = "appkey";
    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_LAST_APP_KEY = "last_appkey";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";
    private static final String KEY_SHARED_PREFERENCES_NAME = "umeng_common_config";
    public static final String MOBILE_NETWORK = "2G/3G";
    private static final String SD_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static final String TAG = "UMUtils";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";
    private static final Pattern pattern = Pattern.compile("UTDID\">([^<]+)");
    private static Object spLock = new Object();

    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e A:{Splitter:B:3:0x0004, ExcHandler: Throwable (r8_1 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:10:0x003e, code skipped:
            r8 = move-exception;
     */
    /* JADX WARNING: Missing block: B:15:0x004b, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x004d;
     */
    /* JADX WARNING: Missing block: B:16:0x004d, code skipped:
            r1 = TAG;
            r2 = new java.lang.StringBuilder();
            r2.append("MD5 e is ");
            r2.append(r8);
            android.util.Log.e(r1, r2.toString());
     */
    /* JADX WARNING: Missing block: B:17:0x0063, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:18:0x0064, code skipped:
            r8 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:0x0067, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0069;
     */
    /* JADX WARNING: Missing block: B:21:0x0069, code skipped:
            r1 = TAG;
            r2 = new java.lang.StringBuilder();
            r2.append("MD5 e is ");
            r2.append(r8);
            android.util.Log.e(r1, r2.toString());
     */
    /* JADX WARNING: Missing block: B:22:0x007f, code skipped:
            return null;
     */
    public static java.lang.String MD5(java.lang.String r8) {
        /*
        r0 = 0;
        if (r8 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r8.getBytes();	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r2 = "MD5";
        r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r2.reset();	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r2.update(r1);	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r1 = r2.digest();	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r2 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r2.<init>();	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r3 = 0;
        r4 = r3;
    L_0x001f:
        r5 = r1.length;	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        if (r4 >= r5) goto L_0x0039;
    L_0x0022:
        r5 = "%02X";
        r6 = 1;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r7 = r1[r4];	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r7 = java.lang.Byte.valueOf(r7);	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r6[r3] = r7;	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r5 = java.lang.String.format(r5, r6);	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r2.append(r5);	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        r4 = r4 + 1;
        goto L_0x001f;
    L_0x0039:
        r1 = r2.toString();	 Catch:{ Exception -> 0x0040, Throwable -> 0x003e }
        return r1;
    L_0x003e:
        r8 = move-exception;
        goto L_0x0049;
    L_0x0040:
        r1 = "[^[a-z][A-Z][0-9][.][_]]";
        r2 = "";
        r8 = r8.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0064, Throwable -> 0x003e }
        return r8;
    L_0x0049:
        r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r1 == 0) goto L_0x0063;
    L_0x004d:
        r1 = "UMUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "MD5 e is ";
        r2.append(r3);
        r2.append(r8);
        r8 = r2.toString();
        android.util.Log.e(r1, r8);
    L_0x0063:
        return r0;
    L_0x0064:
        r8 = move-exception;
        r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r1 == 0) goto L_0x007f;
    L_0x0069:
        r1 = "UMUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "MD5 e is ";
        r2.append(r3);
        r2.append(r8);
        r8 = r2.toString();
        android.util.Log.e(r1, r8);
    L_0x007f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.MD5(java.lang.String):java.lang.String");
    }

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
            stringBuilder.append(toHexString.toUpperCase());
            if (i < bArr.length - 1) {
                stringBuilder.append(':');
            }
        }
        return stringBuilder.toString();
    }

    private static String bytes2Hex(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            StringBuilder stringBuilder;
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("0");
                str = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(toHexString);
            str = stringBuilder.toString();
        }
        return str;
    }

    public static boolean checkAndroidManifest(Context context, String str) {
        try {
            context.getApplicationContext().getPackageManager().getActivityInfo(new ComponentName(context.getApplicationContext().getPackageName(), str), 0);
            return true;
        } catch (NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkIntentFilterData(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("android.intent.category.BROWSABLE");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(db.O000Oo0O);
        stringBuilder.append(str);
        stringBuilder.append(":");
        intent.setData(Uri.parse(stringBuilder.toString()));
        List<ResolveInfo> queryIntentActivities = context.getApplicationContext().getPackageManager().queryIntentActivities(intent, 64);
        if (queryIntentActivities.size() <= 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo.activityInfo != null && resolveInfo.activityInfo.packageName.equals(context.getApplicationContext().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128);
            return (applicationInfo == null || applicationInfo.metaData.get(str) == null) ? false : true;
        } catch (NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean checkPath(String str) {
        try {
            return Class.forName(str) != null;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX WARNING: Missing block: B:7:0x002b, code skipped:
            if (((java.lang.Integer) java.lang.Class.forName("android.content.Context").getMethod("checkSelfPermission", new java.lang.Class[]{java.lang.String.class}).invoke(r6, new java.lang.Object[]{r7})).intValue() == 0) goto L_0x0041;
     */
    /* JADX WARNING: Missing block: B:11:0x003f, code skipped:
            if (r6.getPackageManager().checkPermission(r7, r6.getPackageName()) == 0) goto L_0x0041;
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
        if (r1 < r2) goto L_0x0033;
    L_0x000b:
        r1 = "android.content.Context";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x002e }
        r2 = "checkSelfPermission";
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x002e }
        r5 = java.lang.String.class;
        r4[r0] = r5;	 Catch:{ Exception -> 0x002e }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x002e }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x002e }
        r2[r0] = r7;	 Catch:{ Exception -> 0x002e }
        r7 = r1.invoke(r6, r2);	 Catch:{ Exception -> 0x002e }
        r7 = (java.lang.Integer) r7;	 Catch:{ Exception -> 0x002e }
        r7 = r7.intValue();	 Catch:{ Exception -> 0x002e }
        if (r7 != 0) goto L_0x0042;
    L_0x002d:
        goto L_0x0041;
    L_0x002e:
        r7 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r7);
        goto L_0x0042;
    L_0x0033:
        r1 = r6.getPackageManager();
        r6 = r6.getPackageName();
        r6 = r1.checkPermission(r7, r6);
        if (r6 != 0) goto L_0x0042;
    L_0x0041:
        r0 = r3;
    L_0x0042:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.checkPermission(android.content.Context, java.lang.String):boolean");
    }

    public static boolean checkResource(Context context, String str, String str2) {
        return context.getApplicationContext().getResources().getIdentifier(str, str2, context.getApplicationContext().getPackageName()) > 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0018 A:{Splitter:B:1:0x0001, ExcHandler: Throwable (r4_4 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:6:0x0017, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:8:0x0018, code skipped:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:10:0x001b, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x001d;
     */
    /* JADX WARNING: Missing block: B:11:0x001d, code skipped:
            r1 = TAG;
            r2 = new java.lang.StringBuilder();
            r2.append("encrypt by SHA1 e is ");
            r2.append(r4);
            android.util.Log.e(r1, r2.toString());
     */
    /* JADX WARNING: Missing block: B:12:0x0033, code skipped:
            return null;
     */
    public static java.lang.String encryptBySHA1(java.lang.String r4) {
        /*
        r0 = 0;
        r4 = r4.getBytes();	 Catch:{ Exception -> 0x0034, Throwable -> 0x0018 }
        r1 = "SHA1";
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x0017, Throwable -> 0x0018 }
        r1.update(r4);	 Catch:{ Exception -> 0x0017, Throwable -> 0x0018 }
        r4 = r1.digest();	 Catch:{ Exception -> 0x0017, Throwable -> 0x0018 }
        r4 = bytes2Hex(r4);	 Catch:{ Exception -> 0x0017, Throwable -> 0x0018 }
        return r4;
    L_0x0017:
        return r0;
    L_0x0018:
        r4 = move-exception;
        r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r1 == 0) goto L_0x0033;
    L_0x001d:
        r1 = "UMUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "encrypt by SHA1 e is ";
        r2.append(r3);
        r2.append(r4);
        r4 = r2.toString();
        android.util.Log.e(r1, r4);
    L_0x0033:
        return r0;
    L_0x0034:
        r4 = move-exception;
        r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r1 == 0) goto L_0x004f;
    L_0x0039:
        r1 = "UMUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "encrypt by SHA1 e is ";
        r2.append(r3);
        r2.append(r4);
        r4 = r2.toString();
        android.util.Log.e(r1, r4);
    L_0x004f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.encryptBySHA1(java.lang.String):java.lang.String");
    }

    public static String getAppHashKey(Context context) {
        return DeviceConfig.getAppHashKey(context);
    }

    public static String getAppMD5Signature(Context context) {
        String appMD5Signature = DeviceConfig.getAppMD5Signature(context);
        return !TextUtils.isEmpty(appMD5Signature) ? appMD5Signature.replace(":", "").toLowerCase() : appMD5Signature;
    }

    public static String getAppName(Context context) {
        String str;
        StringBuilder stringBuilder;
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app name e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app name e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
        }
        return str2;
    }

    public static String getAppSHA1Key(Context context) {
        return DeviceConfig.getAppSHA1Key(context);
    }

    public static String getAppVersinoCode(Context context, String str) {
        StringBuilder stringBuilder;
        if (context == null || str == null) {
            return "";
        }
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(str, 0).versionCode);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app version code e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app version code e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            return "";
        }
    }

    public static String getAppVersionCode(Context context) {
        String str;
        StringBuilder stringBuilder;
        if (context == null) {
            return "";
        }
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app version code e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app version code e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            return "";
        }
    }

    public static String getAppVersionName(Context context) {
        String str;
        StringBuilder stringBuilder;
        if (context == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app version name e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app version name e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            return "";
        }
    }

    public static String getAppVersionName(Context context, String str) {
        String str2;
        StringBuilder stringBuilder;
        if (context == null || str == null) {
            return "";
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (NameNotFoundException e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str2 = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app version name e is ");
                stringBuilder.append(e);
                Log.e(str2, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str2 = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app version name e is ");
                stringBuilder.append(th);
                Log.e(str2, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    public static String getAppkey(Context context) {
        String str;
        StringBuilder stringBuilder;
        if (context == null) {
            return null;
        }
        try {
            return getMultiProcessSP(context, "appkey");
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app key e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get app key e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getAppkeyByXML(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("UMENG_APPKEY");
                if (string != null) {
                    return string.trim();
                }
                if (AnalyticsConstants.UM_DEBUG) {
                    MLog.i(AnalyticsConstants.LOG_TAG, "Could not read UMENG_APPKEY meta-data from AndroidManifest.xml.");
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002d A:{SYNTHETIC, Splitter:B:20:0x002d} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0027 A:{SYNTHETIC, Splitter:B:14:0x0027} */
    public static java.util.Properties getBuildProp() {
        /*
        r0 = new java.util.Properties;
        r0.<init>();
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x002b, all -> 0x0024 }
        r3 = new java.io.File;	 Catch:{ IOException -> 0x002b, all -> 0x0024 }
        r4 = android.os.Environment.getRootDirectory();	 Catch:{ IOException -> 0x002b, all -> 0x0024 }
        r5 = "build.prop";
        r3.<init>(r4, r5);	 Catch:{ IOException -> 0x002b, all -> 0x0024 }
        r2.<init>(r3);	 Catch:{ IOException -> 0x002b, all -> 0x0024 }
        r0.load(r2);	 Catch:{ IOException -> 0x0022, all -> 0x001f }
        if (r2 == 0) goto L_0x0030;
    L_0x001b:
        r2.close();	 Catch:{ IOException -> 0x0030 }
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
        r1.close();	 Catch:{ IOException -> 0x002a }
    L_0x002a:
        throw r0;
    L_0x002b:
        if (r1 == 0) goto L_0x0030;
    L_0x002d:
        r1.close();	 Catch:{ IOException -> 0x0030 }
    L_0x0030:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getBuildProp():java.util.Properties");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073 A:{Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A:{Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A:{Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073 A:{Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002a A:{Catch:{ FileNotFoundException -> 0x0045 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073 A:{Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A:{Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A:{Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A:{Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073 A:{Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }} */
    public static java.lang.String getCPU() {
        /*
        r0 = 0;
        r1 = new java.io.FileReader;	 Catch:{ FileNotFoundException -> 0x0045 }
        r2 = "/proc/cpuinfo";
        r1.<init>(r2);	 Catch:{ FileNotFoundException -> 0x0045 }
        if (r1 == 0) goto L_0x0060;
    L_0x000a:
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0025 }
        r3 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2.<init>(r1, r3);	 Catch:{ IOException -> 0x0025 }
        r3 = r2.readLine();	 Catch:{ IOException -> 0x0025 }
        r2.close();	 Catch:{ IOException -> 0x0021, FileNotFoundException -> 0x001d }
        r1.close();	 Catch:{ IOException -> 0x0021, FileNotFoundException -> 0x001d }
        r0 = r3;
        goto L_0x0060;
    L_0x001d:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
        goto L_0x0046;
    L_0x0021:
        r0 = move-exception;
        r1 = r0;
        r0 = r3;
        goto L_0x0026;
    L_0x0025:
        r1 = move-exception;
    L_0x0026:
        r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;	 Catch:{ FileNotFoundException -> 0x0045 }
        if (r2 == 0) goto L_0x0060;
    L_0x002a:
        r2 = "UMUtils";
        r3 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0045 }
        r3.<init>();	 Catch:{ FileNotFoundException -> 0x0045 }
        r4 = "Could not read from file /proc/cpuinfo, e is ";
        r3.append(r4);	 Catch:{ FileNotFoundException -> 0x0045 }
        r3.append(r1);	 Catch:{ FileNotFoundException -> 0x0045 }
        r1 = r3.toString();	 Catch:{ FileNotFoundException -> 0x0045 }
        android.util.Log.e(r2, r1);	 Catch:{ FileNotFoundException -> 0x0045 }
        goto L_0x0060;
    L_0x0041:
        r0 = move-exception;
        goto L_0x0076;
    L_0x0043:
        r0 = move-exception;
        goto L_0x0093;
    L_0x0045:
        r1 = move-exception;
    L_0x0046:
        r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;	 Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }
        if (r2 == 0) goto L_0x0060;
    L_0x004a:
        r2 = "UMUtils";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }
        r3.<init>();	 Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }
        r4 = "Could not read from file /proc/cpuinfo, e is ";
        r3.append(r4);	 Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }
        r3.append(r1);	 Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }
        r1 = r3.toString();	 Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }
        android.util.Log.e(r2, r1);	 Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }
    L_0x0060:
        if (r0 == 0) goto L_0x0073;
    L_0x0062:
        r1 = 58;
        r1 = r0.indexOf(r1);	 Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }
        r1 = r1 + 1;
        r0 = r0.substring(r1);	 Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }
        r0 = r0.trim();	 Catch:{ Exception -> 0x0043, Throwable -> 0x0041 }
        return r0;
    L_0x0073:
        r0 = "";
        return r0;
    L_0x0076:
        r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r1 == 0) goto L_0x0090;
    L_0x007a:
        r1 = "UMUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "get cpu e is ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        android.util.Log.e(r1, r0);
    L_0x0090:
        r0 = "";
        return r0;
    L_0x0093:
        r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r1 == 0) goto L_0x00ad;
    L_0x0097:
        r1 = "UMUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "get cpu e is ";
        r2.append(r3);
        r2.append(r0);
        r0 = r2.toString();
        android.util.Log.e(r1, r0);
    L_0x00ad:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getCPU():java.lang.String");
    }

    public static String getChannel(Context context) {
        String str;
        StringBuilder stringBuilder;
        if (context == null) {
            return null;
        }
        try {
            return getMultiProcessSP(context, "channel");
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get channel e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get channel e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getChannelByXML(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get("UMENG_CHANNEL");
                if (obj != null) {
                    String obj2 = obj.toString();
                    if (obj2 != null) {
                        return obj2.trim();
                    }
                    if (AnalyticsConstants.UM_DEBUG) {
                        MLog.i(AnalyticsConstants.LOG_TAG, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String getDeviceToken(Context context) {
        if (context == null) {
            return null;
        }
        context = context.getApplicationContext();
        try {
            Class cls = Class.forName("com.umeng.message.MessageSharedPrefs");
            if (cls == null) {
                return null;
            }
            Method method = cls.getMethod("getInstance", new Class[]{Context.class});
            if (method == null) {
                return null;
            }
            Object invoke = method.invoke(cls, new Object[]{context});
            if (invoke == null) {
                return null;
            }
            Method method2 = cls.getMethod("getDeviceToken", new Class[0]);
            if (method2 == null) {
                return null;
            }
            invoke = method2.invoke(invoke, new Object[0]);
            return (invoke == null || !(invoke instanceof String)) ? null : (String) invoke;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getDeviceType(Context context) {
        String str;
        StringBuilder stringBuilder;
        try {
            String str2 = "Phone";
            if (context == null) {
                return str2;
            }
            return ((context.getResources().getConfiguration().screenLayout & 15) >= 3 ? 1 : null) != null ? "Tablet" : "Phone";
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get device type e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get device type e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getDisplayResolution(Context context) {
        String str;
        if (context == null) {
            return "";
        }
        StringBuilder stringBuilder;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return "";
            }
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(i2));
            stringBuilder.append("*");
            stringBuilder.append(String.valueOf(i));
            return stringBuilder.toString();
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get display resolution e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get display resolution e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    private static File getFile(Context context) {
        if (context != null && checkPermission(context, SD_PERMISSION) && Environment.getExternalStorageState().equals("mounted")) {
            try {
                return new File(Environment.getExternalStorageDirectory().getCanonicalPath(), ".UTSystemConfig/Global/Alvin2.xml");
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003e A:{Splitter:B:1:0x0003, ExcHandler: Throwable (r7_4 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:16:0x003d, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:18:0x003e, code skipped:
            r7 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:0x0041, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0043;
     */
    /* JADX WARNING: Missing block: B:21:0x0043, code skipped:
            r0 = TAG;
            r2 = new java.lang.StringBuilder();
            r2.append("get file MD5 e is ");
            r2.append(r7);
            android.util.Log.e(r0, r2.toString());
     */
    /* JADX WARNING: Missing block: B:22:0x0059, code skipped:
            return null;
     */
    public static java.lang.String getFileMD5(java.io.File r7) {
        /*
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = 0;
        r2 = new byte[r0];	 Catch:{ Exception -> 0x005a, Throwable -> 0x003e }
        r3 = r7.isFile();	 Catch:{ Exception -> 0x003d, Throwable -> 0x003e }
        if (r3 != 0) goto L_0x000e;
    L_0x000b:
        r7 = "";
        return r7;
    L_0x000e:
        r3 = "MD5";
        r3 = java.security.MessageDigest.getInstance(r3);	 Catch:{ Exception -> 0x003d, Throwable -> 0x003e }
        r4 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x003d, Throwable -> 0x003e }
        r4.<init>(r7);	 Catch:{ Exception -> 0x003d, Throwable -> 0x003e }
    L_0x0019:
        r7 = 0;
        r5 = r4.read(r2, r7, r0);	 Catch:{ Exception -> 0x003d, Throwable -> 0x003e }
        r6 = -1;
        if (r5 == r6) goto L_0x0025;
    L_0x0021:
        r3.update(r2, r7, r5);	 Catch:{ Exception -> 0x003d, Throwable -> 0x003e }
        goto L_0x0019;
    L_0x0025:
        r4.close();	 Catch:{ Exception -> 0x003d, Throwable -> 0x003e }
        r0 = new java.math.BigInteger;	 Catch:{ Exception -> 0x005a, Throwable -> 0x003e }
        r2 = r3.digest();	 Catch:{ Exception -> 0x005a, Throwable -> 0x003e }
        r3 = 1;
        r0.<init>(r3, r2);	 Catch:{ Exception -> 0x005a, Throwable -> 0x003e }
        r2 = "%1$032x";
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x005a, Throwable -> 0x003e }
        r3[r7] = r0;	 Catch:{ Exception -> 0x005a, Throwable -> 0x003e }
        r7 = java.lang.String.format(r2, r3);	 Catch:{ Exception -> 0x005a, Throwable -> 0x003e }
        return r7;
    L_0x003d:
        return r1;
    L_0x003e:
        r7 = move-exception;
        r0 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r0 == 0) goto L_0x0059;
    L_0x0043:
        r0 = "UMUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "get file MD5 e is ";
        r2.append(r3);
        r2.append(r7);
        r7 = r2.toString();
        android.util.Log.e(r0, r7);
    L_0x0059:
        return r1;
    L_0x005a:
        r7 = move-exception;
        r0 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r0 == 0) goto L_0x0075;
    L_0x005f:
        r0 = "UMUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "get file MD5 e is ";
        r2.append(r3);
        r2.append(r7);
        r7 = r2.toString();
        android.util.Log.e(r0, r7);
    L_0x0075:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getFileMD5(java.io.File):java.lang.String");
    }

    private static String getFlymeVersion(Properties properties) {
        try {
            String toLowerCase = properties.getProperty("ro.build.display.id").toLowerCase(Locale.getDefault());
            if (toLowerCase.contains("flyme os")) {
                return toLowerCase.split(" ")[2];
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static String[] getGPU(GL10 gl10) {
        String str;
        StringBuilder stringBuilder;
        try {
            String[] strArr = new String[2];
            String glGetString = gl10.glGetString(7936);
            String glGetString2 = gl10.glGetString(7937);
            strArr[0] = glGetString;
            strArr[1] = glGetString2;
            return strArr;
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Could not read gpu infor, e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            return new String[0];
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("Could not read gpu infor, e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            return new String[0];
        }
    }

    public static String getImsi(Context context) {
        String str;
        StringBuilder stringBuilder;
        String str2 = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (checkPermission(context, "android.permission.READ_PHONE_STATE") && telephonyManager != null) {
                str2 = telephonyManager.getSubscriberId();
            }
            return str2;
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get imei e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get imei e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    public static String getLastAppkey(Context context) {
        String str;
        StringBuilder stringBuilder;
        if (context == null) {
            return null;
        }
        try {
            return getMultiProcessSP(context, KEY_LAST_APP_KEY);
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get last app key e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get last app key e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A:{Catch:{ Exception -> 0x005b, Throwable -> 0x0018 }} */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018 A:{Splitter:B:3:0x0004, ExcHandler: Throwable (r1_2 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:7:0x0018, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:8:0x001a, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:11:0x001d, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x001f;
     */
    /* JADX WARNING: Missing block: B:12:0x001f, code skipped:
            r2 = TAG;
            r3 = new java.lang.StringBuilder();
            r3.append("fail to read user config locale, e is ");
            r3.append(r1);
            android.util.Log.e(r2, r3.toString());
     */
    /* JADX WARNING: Missing block: B:18:0x003f, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0041;
     */
    /* JADX WARNING: Missing block: B:19:0x0041, code skipped:
            r2 = TAG;
            r3 = new java.lang.StringBuilder();
            r3.append("get locale e is ");
            r3.append(r1);
            android.util.Log.e(r2, r3.toString());
     */
    /* JADX WARNING: Missing block: B:20:0x0057, code skipped:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
     */
    /* JADX WARNING: Missing block: B:21:0x005a, code skipped:
            return null;
     */
    public static java.util.Locale getLocale(android.content.Context r5) {
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new android.content.res.Configuration;	 Catch:{ Exception -> 0x001a, Throwable -> 0x0018 }
        r1.<init>();	 Catch:{ Exception -> 0x001a, Throwable -> 0x0018 }
        r1.setToDefaults();	 Catch:{ Exception -> 0x001a, Throwable -> 0x0018 }
        r2 = r5.getContentResolver();	 Catch:{ Exception -> 0x001a, Throwable -> 0x0018 }
        android.provider.Settings.System.getConfiguration(r2, r1);	 Catch:{ Exception -> 0x001a, Throwable -> 0x0018 }
        if (r1 == 0) goto L_0x0035;
    L_0x0015:
        r1 = r1.locale;	 Catch:{ Exception -> 0x001a, Throwable -> 0x0018 }
        goto L_0x0036;
    L_0x0018:
        r1 = move-exception;
        goto L_0x003d;
    L_0x001a:
        r1 = move-exception;
        r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;	 Catch:{ Exception -> 0x005b, Throwable -> 0x0018 }
        if (r2 == 0) goto L_0x0035;
    L_0x001f:
        r2 = "UMUtils";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005b, Throwable -> 0x0018 }
        r3.<init>();	 Catch:{ Exception -> 0x005b, Throwable -> 0x0018 }
        r4 = "fail to read user config locale, e is ";
        r3.append(r4);	 Catch:{ Exception -> 0x005b, Throwable -> 0x0018 }
        r3.append(r1);	 Catch:{ Exception -> 0x005b, Throwable -> 0x0018 }
        r1 = r3.toString();	 Catch:{ Exception -> 0x005b, Throwable -> 0x0018 }
        android.util.Log.e(r2, r1);	 Catch:{ Exception -> 0x005b, Throwable -> 0x0018 }
    L_0x0035:
        r1 = r0;
    L_0x0036:
        if (r1 != 0) goto L_0x003c;
    L_0x0038:
        r1 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x005b, Throwable -> 0x0018 }
    L_0x003c:
        return r1;
    L_0x003d:
        r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r2 == 0) goto L_0x0057;
    L_0x0041:
        r2 = "UMUtils";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "get locale e is ";
        r3.append(r4);
        r3.append(r1);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
    L_0x0057:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
        return r0;
    L_0x005b:
        r1 = move-exception;
        r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r2 == 0) goto L_0x0076;
    L_0x0060:
        r2 = "UMUtils";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "get locale e is ";
        r3.append(r4);
        r3.append(r1);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
    L_0x0076:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getLocale(android.content.Context):java.util.Locale");
    }

    public static String getMac(Context context) {
        String str;
        StringBuilder stringBuilder;
        if (context == null) {
            return null;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                return null;
            }
            if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                return wifiManager.getConnectionInfo().getMacAddress();
            }
            if (AnalyticsConstants.UM_DEBUG) {
                Log.e(TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            }
            return "";
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get mac e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get mac e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:22:0x004e, code skipped:
            return null;
     */
    public static java.lang.String getMultiProcessSP(android.content.Context r5, java.lang.String r6) {
        /*
        r0 = 0;
        r1 = spLock;	 Catch:{ Exception -> 0x0052, Throwable -> 0x0051 }
        monitor-enter(r1);	 Catch:{ Exception -> 0x0052, Throwable -> 0x0051 }
        if (r5 == 0) goto L_0x004d;
    L_0x0006:
        r2 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x004b }
        if (r2 == 0) goto L_0x000d;
    L_0x000c:
        goto L_0x004d;
    L_0x000d:
        r2 = isMainProgress(r5);	 Catch:{ all -> 0x004b }
        r3 = 0;
        if (r2 == 0) goto L_0x001f;
    L_0x0014:
        r5 = r5.getApplicationContext();	 Catch:{ all -> 0x004b }
        r2 = "umeng_common_config";
        r5 = r5.getSharedPreferences(r2, r3);	 Catch:{ all -> 0x004b }
        goto L_0x0041;
    L_0x001f:
        r2 = com.umeng.commonsdk.framework.UMFrUtils.getSubProcessName(r5);	 Catch:{ all -> 0x004b }
        r5 = r5.getApplicationContext();	 Catch:{ all -> 0x004b }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004b }
        r4.<init>();	 Catch:{ all -> 0x004b }
        r4.append(r2);	 Catch:{ all -> 0x004b }
        r2 = "_";
        r4.append(r2);	 Catch:{ all -> 0x004b }
        r2 = "umeng_common_config";
        r4.append(r2);	 Catch:{ all -> 0x004b }
        r2 = r4.toString();	 Catch:{ all -> 0x004b }
        r5 = r5.getSharedPreferences(r2, r3);	 Catch:{ all -> 0x004b }
    L_0x0041:
        if (r5 == 0) goto L_0x0049;
    L_0x0043:
        r5 = r5.getString(r6, r0);	 Catch:{ all -> 0x004b }
        monitor-exit(r1);	 Catch:{ all -> 0x004b }
        return r5;
    L_0x0049:
        monitor-exit(r1);	 Catch:{ all -> 0x004b }
        return r0;
    L_0x004b:
        r5 = move-exception;
        goto L_0x004f;
    L_0x004d:
        monitor-exit(r1);	 Catch:{ all -> 0x004b }
        return r0;
    L_0x004f:
        monitor-exit(r1);	 Catch:{ all -> 0x004b }
        throw r5;	 Catch:{ Exception -> 0x0052, Throwable -> 0x0051 }
    L_0x0051:
        return r0;
    L_0x0052:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getMultiProcessSP(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String[] getNetworkAccessMode(Context context) {
        String str;
        StringBuilder stringBuilder;
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
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get network access mode e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get network access mode e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static String getNetworkOperatorName(Context context) {
        String str;
        StringBuilder stringBuilder;
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return !checkPermission(context, "android.permission.READ_PHONE_STATE") ? "" : telephonyManager == null ? "" : telephonyManager.getNetworkOperatorName();
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get network operator e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return "";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get network operator e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return "";
        }
    }

    public static String getOperator(Context context) {
        String str;
        StringBuilder stringBuilder;
        if (context == null) {
            return "Unknown";
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager == null ? "Unknown" : telephonyManager.getNetworkOperator();
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get get operator e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return "Unknown";
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get get operator e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return "Unknown";
        }
    }

    public static String getRegisteredOperator(Context context) {
        String str;
        StringBuilder stringBuilder;
        String str2 = null;
        if (context == null) {
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                str2 = telephonyManager.getNetworkOperator();
            }
            return str2;
        } catch (Exception e) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get registered operator e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, e);
            return null;
        } catch (Throwable th) {
            if (AnalyticsConstants.UM_DEBUG) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("get registered operator e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
            UMCrashManager.reportCrash(context, th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0035 A:{Splitter:B:3:0x0004, ExcHandler: Throwable (r1_8 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0035 A:{Splitter:B:3:0x0004, ExcHandler: Throwable (r1_8 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:21:0x0035, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:23:0x0038, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x003a;
     */
    /* JADX WARNING: Missing block: B:24:0x003a, code skipped:
            r2 = TAG;
            r3 = new java.lang.StringBuilder();
            r3.append("get sub os name e is ");
            r3.append(r1);
            android.util.Log.e(r2, r3.toString());
     */
    /* JADX WARNING: Missing block: B:25:0x0050, code skipped:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
     */
    /* JADX WARNING: Missing block: B:26:0x0053, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:27:0x0054, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:29:0x0057, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0059;
     */
    /* JADX WARNING: Missing block: B:30:0x0059, code skipped:
            r2 = TAG;
            r3 = new java.lang.StringBuilder();
            r3.append("get sub os name e is ");
            r3.append(r1);
            android.util.Log.e(r2, r3.toString());
     */
    /* JADX WARNING: Missing block: B:31:0x006f, code skipped:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
     */
    /* JADX WARNING: Missing block: B:32:0x0072, code skipped:
            return null;
     */
    public static java.lang.String getSubOSName(android.content.Context r5) {
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = getBuildProp();	 Catch:{ Exception -> 0x0054, Throwable -> 0x0035 }
        r2 = "ro.miui.ui.version.name";
        r2 = r1.getProperty(r2);	 Catch:{ Exception -> 0x0030, Throwable -> 0x0035 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0030, Throwable -> 0x0035 }
        if (r3 == 0) goto L_0x002c;
    L_0x0014:
        r3 = isFlyMe();	 Catch:{ Exception -> 0x0030, Throwable -> 0x0035 }
        if (r3 == 0) goto L_0x001d;
    L_0x001a:
        r1 = "Flyme";
        goto L_0x002e;
    L_0x001d:
        r1 = getYunOSVersion(r1);	 Catch:{ Exception -> 0x0030, Throwable -> 0x0035 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0030, Throwable -> 0x0035 }
        if (r1 != 0) goto L_0x002a;
    L_0x0027:
        r1 = "YunOS";
        goto L_0x002e;
    L_0x002a:
        r0 = r2;
        goto L_0x0034;
    L_0x002c:
        r1 = "MIUI";
    L_0x002e:
        r0 = r1;
        goto L_0x0034;
    L_0x0030:
        r1 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);	 Catch:{ Exception -> 0x0054, Throwable -> 0x0035 }
    L_0x0034:
        return r0;
    L_0x0035:
        r1 = move-exception;
        r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r2 == 0) goto L_0x0050;
    L_0x003a:
        r2 = "UMUtils";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "get sub os name e is ";
        r3.append(r4);
        r3.append(r1);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
    L_0x0050:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
        return r0;
    L_0x0054:
        r1 = move-exception;
        r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r2 == 0) goto L_0x006f;
    L_0x0059:
        r2 = "UMUtils";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "get sub os name e is ";
        r3.append(r4);
        r3.append(r1);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
    L_0x006f:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getSubOSName(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c A:{Splitter:B:3:0x0004, ExcHandler: Throwable (r1_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c A:{Splitter:B:3:0x0004, ExcHandler: Throwable (r1_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c A:{Splitter:B:3:0x0004, ExcHandler: Throwable (r1_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:20:0x002c, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:22:0x002f, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0031;
     */
    /* JADX WARNING: Missing block: B:23:0x0031, code skipped:
            r2 = TAG;
            r3 = new java.lang.StringBuilder();
            r3.append("get sub os version e is ");
            r3.append(r1);
            android.util.Log.e(r2, r3.toString());
     */
    /* JADX WARNING: Missing block: B:24:0x0047, code skipped:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
     */
    /* JADX WARNING: Missing block: B:25:0x004a, code skipped:
            return null;
     */
    /* JADX WARNING: Missing block: B:26:0x004b, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:28:0x004e, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0050;
     */
    /* JADX WARNING: Missing block: B:29:0x0050, code skipped:
            r2 = TAG;
            r3 = new java.lang.StringBuilder();
            r3.append("get sub os version e is ");
            r3.append(r1);
            android.util.Log.e(r2, r3.toString());
     */
    /* JADX WARNING: Missing block: B:30:0x0066, code skipped:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
     */
    /* JADX WARNING: Missing block: B:31:0x0069, code skipped:
            return null;
     */
    public static java.lang.String getSubOSVersion(android.content.Context r5) {
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = getBuildProp();	 Catch:{ Exception -> 0x004b, Throwable -> 0x002c }
        r2 = "ro.miui.ui.version.name";
        r2 = r1.getProperty(r2);	 Catch:{ Exception -> 0x0027, Throwable -> 0x002c }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0027, Throwable -> 0x002c }
        if (r3 == 0) goto L_0x0025;
    L_0x0014:
        r3 = isFlyMe();	 Catch:{ Exception -> 0x0027, Throwable -> 0x002c }
        if (r3 == 0) goto L_0x0020;
    L_0x001a:
        r1 = getFlymeVersion(r1);	 Catch:{ Exception -> 0x0025, Throwable -> 0x002c }
    L_0x001e:
        r0 = r1;
        goto L_0x002b;
    L_0x0020:
        r1 = getYunOSVersion(r1);	 Catch:{ Exception -> 0x0025, Throwable -> 0x002c }
        goto L_0x001e;
    L_0x0025:
        r0 = r2;
        goto L_0x002b;
    L_0x0027:
        r1 = move-exception;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);	 Catch:{ Exception -> 0x004b, Throwable -> 0x002c }
    L_0x002b:
        return r0;
    L_0x002c:
        r1 = move-exception;
        r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r2 == 0) goto L_0x0047;
    L_0x0031:
        r2 = "UMUtils";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "get sub os version e is ";
        r3.append(r4);
        r3.append(r1);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
    L_0x0047:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
        return r0;
    L_0x004b:
        r1 = move-exception;
        r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r2 == 0) goto L_0x0066;
    L_0x0050:
        r2 = "UMUtils";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "get sub os version e is ";
        r3.append(r4);
        r3.append(r1);
        r3 = r3.toString();
        android.util.Log.e(r2, r3);
    L_0x0066:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r5, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getSubOSVersion(android.content.Context):java.lang.String");
    }

    public static int getTargetSdkVersion(Context context) {
        return context.getApplicationInfo().targetSdkVersion;
    }

    public static String getUMId(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return UMEnvelopeBuild.imprintProperty(context.getApplicationContext(), "umid", null);
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return null;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x0027 A:{Splitter:B:3:0x0004, ExcHandler: Throwable (r7_1 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:6:0x0027, code skipped:
            r7 = move-exception;
     */
    /* JADX WARNING: Missing block: B:9:0x002d, code skipped:
            return readUTDId(r7);
     */
    /* JADX WARNING: Missing block: B:11:0x0030, code skipped:
            if (com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG != false) goto L_0x0032;
     */
    /* JADX WARNING: Missing block: B:12:0x0032, code skipped:
            r1 = TAG;
            r2 = new java.lang.StringBuilder();
            r2.append("get utiid e is ");
            r2.append(r7);
            android.util.Log.e(r1, r2.toString());
     */
    /* JADX WARNING: Missing block: B:13:0x0048, code skipped:
            return null;
     */
    public static java.lang.String getUTDID(android.content.Context r7) {
        /*
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "com.ut.device.UTDevice";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
        r2 = "getUtdid";
        r3 = 1;
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
        r5 = android.content.Context.class;
        r6 = 0;
        r4[r6] = r5;	 Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
        r3 = r7.getApplicationContext();	 Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
        r2[r6] = r3;	 Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
        r1 = r1.invoke(r0, r2);	 Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0029, Throwable -> 0x0027 }
        return r1;
    L_0x0027:
        r7 = move-exception;
        goto L_0x002e;
    L_0x0029:
        r7 = readUTDId(r7);	 Catch:{ Exception -> 0x0049, Throwable -> 0x0027 }
        return r7;
    L_0x002e:
        r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r1 == 0) goto L_0x0048;
    L_0x0032:
        r1 = "UMUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "get utiid e is ";
        r2.append(r3);
        r2.append(r7);
        r7 = r2.toString();
        android.util.Log.e(r1, r7);
    L_0x0048:
        return r0;
    L_0x0049:
        r7 = move-exception;
        r1 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;
        if (r1 == 0) goto L_0x0064;
    L_0x004e:
        r1 = "UMUtils";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "get utiid e is ";
        r2.append(r3);
        r2.append(r7);
        r7 = r2.toString();
        android.util.Log.e(r1, r7);
    L_0x0064:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.getUTDID(android.content.Context):java.lang.String");
    }

    private static String getYunOSVersion(Properties properties) {
        String property = properties.getProperty("ro.yunos.version");
        return !TextUtils.isEmpty(property) ? property : null;
    }

    public static boolean isApplication(Context context) {
        try {
            String name = context.getApplicationContext().getClass().getSuperclass().getName();
            return !TextUtils.isEmpty(name) && name.equals("android.app.Application");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isDebug(Context context) {
        boolean z = false;
        if (context == null) {
            return false;
        }
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            UMCrashManager.reportCrash(context, e);
            return false;
        }
    }

    private static boolean isFlyMe() {
        try {
            Build.class.getMethod("hasSmartBar", new Class[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMainProgress(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = context.getApplicationContext().getPackageName();
            return (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isSdCardWrittenable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private static String parseId(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(1) : null;
    }

    private static String readStreamToString(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }

    private static String readUTDId(Context context) {
        if (context == null) {
            return null;
        }
        File file = getFile(context);
        if (file == null || !file.exists()) {
            return null;
        }
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            String parseId = parseId(readStreamToString(fileInputStream));
            safeClose(fileInputStream);
            return parseId;
        } catch (Exception unused) {
            return null;
        } catch (Throwable th) {
            safeClose(fileInputStream);
        }
    }

    private static void safeClose(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void setAppkey(Context context, String str) {
        String str2;
        StringBuilder stringBuilder;
        if (context != null && str != null) {
            try {
                setMultiProcessSP(context, "appkey", str);
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    str2 = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("set app key e is ");
                    stringBuilder.append(e);
                    Log.e(str2, stringBuilder.toString());
                }
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    str2 = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("set app key e is ");
                    stringBuilder.append(th);
                    Log.e(str2, stringBuilder.toString());
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static void setChannel(Context context, String str) {
        String str2;
        StringBuilder stringBuilder;
        if (context != null && str != null) {
            try {
                setMultiProcessSP(context, "channel", str);
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    str2 = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("set channel e is ");
                    stringBuilder.append(e);
                    Log.e(str2, stringBuilder.toString());
                }
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    str2 = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("set channel e is ");
                    stringBuilder.append(th);
                    Log.e(str2, stringBuilder.toString());
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    public static void setLastAppkey(Context context, String str) {
        String str2;
        StringBuilder stringBuilder;
        if (context != null && str != null) {
            try {
                setMultiProcessSP(context, KEY_LAST_APP_KEY, str);
            } catch (Exception e) {
                if (AnalyticsConstants.UM_DEBUG) {
                    str2 = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("set last app key e is ");
                    stringBuilder.append(e);
                    Log.e(str2, stringBuilder.toString());
                }
                UMCrashManager.reportCrash(context, e);
            } catch (Throwable th) {
                if (AnalyticsConstants.UM_DEBUG) {
                    str2 = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("set last app key e is ");
                    stringBuilder.append(th);
                    Log.e(str2, stringBuilder.toString());
                }
                UMCrashManager.reportCrash(context, th);
            }
        }
    }

    /* JADX WARNING: Missing block: B:20:0x0054, code skipped:
            return;
     */
    public static void setMultiProcessSP(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /*
        r0 = spLock;	 Catch:{ Exception | Throwable -> 0x0057, Exception | Throwable -> 0x0057 }
        monitor-enter(r0);	 Catch:{ Exception | Throwable -> 0x0057, Exception | Throwable -> 0x0057 }
        if (r4 == 0) goto L_0x0053;
    L_0x0005:
        r1 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x0051 }
        if (r1 != 0) goto L_0x0053;
    L_0x000b:
        if (r6 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0053;
    L_0x000e:
        r1 = isMainProgress(r4);	 Catch:{ all -> 0x0051 }
        r2 = 0;
        if (r1 == 0) goto L_0x0020;
    L_0x0015:
        r4 = r4.getApplicationContext();	 Catch:{ all -> 0x0051 }
        r1 = "umeng_common_config";
        r4 = r4.getSharedPreferences(r1, r2);	 Catch:{ all -> 0x0051 }
        goto L_0x0042;
    L_0x0020:
        r1 = com.umeng.commonsdk.framework.UMFrUtils.getSubProcessName(r4);	 Catch:{ all -> 0x0051 }
        r4 = r4.getApplicationContext();	 Catch:{ all -> 0x0051 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0051 }
        r3.<init>();	 Catch:{ all -> 0x0051 }
        r3.append(r1);	 Catch:{ all -> 0x0051 }
        r1 = "_";
        r3.append(r1);	 Catch:{ all -> 0x0051 }
        r1 = "umeng_common_config";
        r3.append(r1);	 Catch:{ all -> 0x0051 }
        r1 = r3.toString();	 Catch:{ all -> 0x0051 }
        r4 = r4.getSharedPreferences(r1, r2);	 Catch:{ all -> 0x0051 }
    L_0x0042:
        if (r4 == 0) goto L_0x004f;
    L_0x0044:
        r4 = r4.edit();	 Catch:{ all -> 0x0051 }
        r4 = r4.putString(r5, r6);	 Catch:{ all -> 0x0051 }
        r4.commit();	 Catch:{ all -> 0x0051 }
    L_0x004f:
        monitor-exit(r0);	 Catch:{ all -> 0x0051 }
        goto L_0x0057;
    L_0x0051:
        r4 = move-exception;
        goto L_0x0055;
    L_0x0053:
        monitor-exit(r0);	 Catch:{ all -> 0x0051 }
        return;
    L_0x0055:
        monitor-exit(r0);	 Catch:{ all -> 0x0051 }
        throw r4;	 Catch:{ Exception | Throwable -> 0x0057, Exception | Throwable -> 0x0057 }
    L_0x0057:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.utils.UMUtils.setMultiProcessSP(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
