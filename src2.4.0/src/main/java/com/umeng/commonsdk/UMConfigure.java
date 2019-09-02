package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.stateless.UMSLEnvelopeBuild;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.a;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UMConfigure {
    public static final int DEVICE_TYPE_BOX = 2;
    public static final int DEVICE_TYPE_PHONE = 1;
    private static final String KEY_FILE_NAME_APPKEY = "APPKEY";
    private static final String KEY_FILE_NAME_LOG = "LOG";
    private static final String KEY_METHOD_NAME_PUSH_SETCHANNEL = "setMessageChannel";
    private static final String KEY_METHOD_NAME_PUSH_SET_SECRET = "setSecret";
    private static final String KEY_METHOD_NAME_SETAPPKEY = "setAppkey";
    private static final String KEY_METHOD_NAME_SETCHANNEL = "setChannel";
    private static final String KEY_METHOD_NAME_SETDEBUGMODE = "setDebugMode";
    private static final String TAG = "UMConfigure";
    private static final String WRAPER_TYPE_COCOS2DX_X = "Cocos2d-x";
    private static final String WRAPER_TYPE_COCOS2DX_XLUA = "Cocos2d-x_lua";
    private static final String WRAPER_TYPE_FLUTTER = "flutter";
    private static final String WRAPER_TYPE_HYBRID = "hybrid";
    private static final String WRAPER_TYPE_NATIVE = "native";
    private static final String WRAPER_TYPE_PHONEGAP = "phonegap";
    private static final String WRAPER_TYPE_REACTNATIVE = "react-native";
    private static final String WRAPER_TYPE_UNITY = "Unity";
    private static final String WRAPER_TYPE_WEEX = "weex";
    private static boolean debugLog;
    private static boolean isFinish;
    private static Object lockObject = new Object();
    public static UMLog umDebugLog = new UMLog();

    private static Class<?> getClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private static Object getDecInstanceObject(Class<?> cls) {
        if (cls != null) {
            Constructor declaredConstructor;
            try {
                declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            } catch (NoSuchMethodException unused) {
                declaredConstructor = null;
            }
            if (declaredConstructor != null) {
                declaredConstructor.setAccessible(true);
                try {
                    return declaredConstructor.newInstance(new Object[0]);
                } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | InvocationTargetException unused2) {
                }
            }
        }
        return null;
    }

    private static Method getDecMethod(Class<?> cls, String str, Class<?>[] clsArr) {
        Method method = null;
        if (cls != null) {
            try {
                method = cls.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException unused) {
            }
            if (method != null) {
                method.setAccessible(true);
            }
        }
        return method;
    }

    public static boolean getInitStatus() {
        boolean z;
        synchronized (lockObject) {
            z = isFinish;
        }
        return z;
    }

    private Object getInstanceObject(Class<?> cls) {
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (IllegalAccessException | InstantiationException unused) {
            }
        }
        return null;
    }

    public static String[] getTestDeviceInfo(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception unused) {
            }
        }
        return strArr;
    }

    public static String getUMIDString(Context context) {
        return context != null ? UMUtils.getUMId(context.getApplicationContext()) : null;
    }

    public static void init(Context context, int i, String str) {
        init(context, null, null, i, str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:96:0x0215 A:{Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0209 A:{Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:89:0x0203 */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0354 A:{Splitter:B:0:0x0000, ExcHandler: Exception (r9_9 'e' java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01da A:{Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0209 A:{Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0215 A:{Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:81:0x01cd */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0338 A:{Splitter:B:0:0x0000, ExcHandler: Throwable (r9_7 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0292 A:{Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02e1 A:{Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }} */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02d7 A:{Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }} */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0331 A:{SYNTHETIC} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x028c */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0354 A:{Splitter:B:0:0x0000, ExcHandler: Exception (r9_9 'e' java.lang.Exception)} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:140:0x02eb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:142:0x0304 */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0354 A:{Splitter:B:0:0x0000, ExcHandler: Exception (r9_9 'e' java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0123 A:{Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }} */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01da A:{Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0215 A:{Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }} */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0209 A:{Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x011b */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0354 A:{Splitter:B:0:0x0000, ExcHandler: Exception (r9_9 'e' java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0354 A:{Splitter:B:0:0x0000, ExcHandler: Exception (r9_9 'e' java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0354 A:{Splitter:B:0:0x0000, ExcHandler: Exception (r9_9 'e' java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0338 A:{Splitter:B:0:0x0000, ExcHandler: Throwable (r9_7 'th' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:141:?, code skipped:
            java.lang.Class.forName("com.umeng.analytics.vismode.event.VisualHelper").getMethod("init", new java.lang.Class[]{android.content.Context.class}).invoke(null, new java.lang.Object[]{r9});
     */
    /* JADX WARNING: Missing block: B:153:0x0338, code skipped:
            r9 = move-exception;
     */
    /* JADX WARNING: Missing block: B:155:0x033b, code skipped:
            if (debugLog != false) goto L_0x033d;
     */
    /* JADX WARNING: Missing block: B:156:0x033d, code skipped:
            r10 = TAG;
            r11 = new java.lang.StringBuilder();
            r11.append("init e is ");
            r11.append(r9);
            android.util.Log.e(r10, r11.toString());
     */
    /* JADX WARNING: Missing block: B:157:0x0354, code skipped:
            r9 = move-exception;
     */
    /* JADX WARNING: Missing block: B:159:0x0357, code skipped:
            if (debugLog != false) goto L_0x0359;
     */
    /* JADX WARNING: Missing block: B:160:0x0359, code skipped:
            r10 = TAG;
            r11 = new java.lang.StringBuilder();
            r11.append("init e is ");
            r11.append(r9);
            android.util.Log.e(r10, r11.toString());
     */
    public static void init(android.content.Context r9, java.lang.String r10, java.lang.String r11, int r12, java.lang.String r13) {
        /*
        r0 = debugLog;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r0 == 0) goto L_0x0023;
    L_0x0004:
        r0 = "UMConfigure";
        r1 = "common version is 2.0.2";
        android.util.Log.i(r0, r1);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r0 = "UMConfigure";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r1.<init>();	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r2 = "common type is ";
        r1.append(r2);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r2 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r1.append(r2);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        android.util.Log.i(r0, r1);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x0023:
        if (r9 != 0) goto L_0x0031;
    L_0x0025:
        r9 = debugLog;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r9 == 0) goto L_0x0030;
    L_0x0029:
        r9 = "UMConfigure";
        r10 = "context is null !!!";
        android.util.Log.e(r9, r10);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x0030:
        return;
    L_0x0031:
        r0 = r9.getApplicationContext();	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r1 = debugLog;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r2 = 2;
        r3 = 0;
        r4 = 1;
        if (r1 == 0) goto L_0x006a;
    L_0x003c:
        r1 = com.umeng.commonsdk.utils.UMUtils.getAppkeyByXML(r0);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r5 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r5 != 0) goto L_0x006a;
    L_0x0046:
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r5 != 0) goto L_0x006a;
    L_0x004c:
        r5 = r10.equals(r1);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r5 != 0) goto L_0x006a;
    L_0x0052:
        r5 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r6 = "@";
        r5[r3] = r6;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r6 = "#";
        r5[r4] = r6;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r6 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r6[r3] = r10;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r6[r4] = r1;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r1 = "请注意：您init接口中设置的AppKey是@，manifest中设置的AppKey是#，init接口设置的AppKey会覆盖manifest中设置的AppKey";
        r7 = 3;
        r8 = "";
        com.umeng.commonsdk.debug.UMLog.mutlInfo(r1, r7, r8, r5, r6);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x006a:
        r1 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r1 == 0) goto L_0x0074;
    L_0x0070:
        r10 = com.umeng.commonsdk.utils.UMUtils.getAppkeyByXML(r0);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x0074:
        r1 = android.text.TextUtils.isEmpty(r11);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r1 == 0) goto L_0x007e;
    L_0x007a:
        r11 = com.umeng.commonsdk.utils.UMUtils.getChannelByXML(r0);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x007e:
        r1 = android.text.TextUtils.isEmpty(r11);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r1 == 0) goto L_0x0086;
    L_0x0084:
        r11 = "Unknown";
    L_0x0086:
        com.umeng.commonsdk.utils.UMUtils.setChannel(r0, r11);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r1 = debugLog;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r1 == 0) goto L_0x00a3;
    L_0x008d:
        r1 = "UMConfigure";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r5.<init>();	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r6 = "channel is ";
        r5.append(r6);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r5.append(r11);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        android.util.Log.i(r1, r5);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x00a3:
        r1 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r0);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r1 == 0) goto L_0x00ac;
    L_0x00a9:
        saveSDKComponent();	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x00ac:
        r1 = "x";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        if (r1 == 0) goto L_0x00f7;
    L_0x00b4:
        r5 = "init";
        r6 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r7 = android.content.Context.class;
        r6[r3] = r7;	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r5 = r1.getDeclaredMethod(r5, r6);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        if (r5 == 0) goto L_0x00d7;
    L_0x00c2:
        r5.setAccessible(r4);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r6 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r6[r3] = r0;	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r5.invoke(r1, r6);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r5 = debugLog;	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        if (r5 == 0) goto L_0x00d7;
    L_0x00d0:
        r5 = "统计SDK初始化成功";
        r6 = "";
        com.umeng.commonsdk.debug.UMLog.mutlInfo(r5, r2, r6);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
    L_0x00d7:
        r5 = "com.umeng.analytics.game.UMGameAgent";
        r5 = java.lang.Class.forName(r5);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        if (r5 == 0) goto L_0x00f7;
    L_0x00df:
        r5 = "setGameScenarioType";
        r6 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r7 = android.content.Context.class;
        r6[r3] = r7;	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r5 = r1.getDeclaredMethod(r5, r6);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        if (r5 == 0) goto L_0x00f7;
    L_0x00ed:
        r5.setAccessible(r4);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r6 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r6[r3] = r0;	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r5.invoke(r1, r6);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
    L_0x00f7:
        r1 = com.umeng.commonsdk.statistics.b.a;	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r5 = "e";
        r1 = r1.indexOf(r5);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        if (r1 < 0) goto L_0x011b;
    L_0x0101:
        r1 = "x";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        if (r1 == 0) goto L_0x011b;
    L_0x0109:
        r5 = "disableExceptionCatch";
        r6 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r5 = r1.getDeclaredMethod(r5, r6);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        if (r5 == 0) goto L_0x011b;
    L_0x0113:
        r5.setAccessible(r4);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r6 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
        r5.invoke(r1, r6);	 Catch:{ Throwable -> 0x011b, Exception -> 0x0354 }
    L_0x011b:
        r1 = "com.umeng.message.MessageSharedPrefs";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r1 == 0) goto L_0x01cd;
    L_0x0123:
        r5 = "getInstance";
        r6 = new java.lang.Class[r4];	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r7 = android.content.Context.class;
        r6[r3] = r7;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r5 = r1.getDeclaredMethod(r5, r6);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r5 == 0) goto L_0x01cd;
    L_0x0131:
        r6 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6[r3] = r0;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r5 = r5.invoke(r1, r6);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r5 == 0) goto L_0x01cd;
    L_0x013b:
        r6 = "setMessageAppKey";
        r7 = new java.lang.Class[r4];	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r8 = java.lang.String.class;
        r7[r3] = r8;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6 = r1.getDeclaredMethod(r6, r7);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r6 == 0) goto L_0x0160;
    L_0x0149:
        r6.setAccessible(r4);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r7 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r7[r3] = r10;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6.invoke(r5, r7);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6 = debugLog;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r6 == 0) goto L_0x0160;
    L_0x0157:
        r6 = umDebugLog;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6 = "PUSH AppKey设置成功";
        r7 = "";
        com.umeng.commonsdk.debug.UMLog.mutlInfo(r6, r2, r7);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
    L_0x0160:
        r6 = "setMessageChannel";
        r7 = new java.lang.Class[r4];	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r8 = java.lang.String.class;
        r7[r3] = r8;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6 = r1.getDeclaredMethod(r6, r7);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r6 == 0) goto L_0x0185;
    L_0x016e:
        r6.setAccessible(r4);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r7 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r7[r3] = r11;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6.invoke(r5, r7);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6 = debugLog;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r6 == 0) goto L_0x0185;
    L_0x017c:
        r6 = umDebugLog;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6 = "PUSH Channel设置成功";
        r7 = "";
        com.umeng.commonsdk.debug.UMLog.mutlInfo(r6, r2, r7);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
    L_0x0185:
        r6 = android.text.TextUtils.isEmpty(r13);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r6 == 0) goto L_0x018e;
    L_0x018b:
        r1 = debugLog;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        goto L_0x01cd;
    L_0x018e:
        r6 = debugLog;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r6 == 0) goto L_0x01a8;
    L_0x0192:
        r6 = "UMConfigure";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r7.<init>();	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r8 = "push secret is ";
        r7.append(r8);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r7.append(r13);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        android.util.Log.i(r6, r7);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
    L_0x01a8:
        r6 = "setMessageAppSecret";
        r7 = new java.lang.Class[r4];	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r8 = java.lang.String.class;
        r7[r3] = r8;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r1 = r1.getDeclaredMethod(r6, r7);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r1 == 0) goto L_0x01cd;
    L_0x01b6:
        r1.setAccessible(r4);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r6[r3] = r13;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r1.invoke(r5, r6);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r1 = debugLog;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        if (r1 == 0) goto L_0x01cd;
    L_0x01c4:
        r1 = umDebugLog;	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
        r1 = "PUSH Secret设置成功";
        r5 = "";
        com.umeng.commonsdk.debug.UMLog.mutlInfo(r1, r2, r5);	 Catch:{ Exception -> 0x01cd, Throwable -> 0x0338 }
    L_0x01cd:
        r1 = "com.umeng.socialize.UMShareAPI";
        r1 = getClass(r1);	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        r5 = "APPKEY";
        setFile(r1, r5, r10);	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        if (r1 == 0) goto L_0x0203;
    L_0x01da:
        r5 = "init";
        r6 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        r7 = android.content.Context.class;
        r6[r3] = r7;	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        r7 = java.lang.String.class;
        r6[r4] = r7;	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        r5 = r1.getDeclaredMethod(r5, r6);	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        if (r5 == 0) goto L_0x0203;
    L_0x01ec:
        r5.setAccessible(r4);	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        r6 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        r6[r3] = r0;	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        r6[r4] = r10;	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        r5.invoke(r1, r6);	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        r1 = debugLog;	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
        if (r1 == 0) goto L_0x0203;
    L_0x01fc:
        r1 = "Share AppKey设置成功";
        r5 = "";
        com.umeng.commonsdk.debug.UMLog.mutlInfo(r1, r2, r5);	 Catch:{ Throwable -> 0x0203, Exception -> 0x0354 }
    L_0x0203:
        r1 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r1 == 0) goto L_0x0215;
    L_0x0209:
        r9 = debugLog;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r9 == 0) goto L_0x0214;
    L_0x020d:
        r9 = com.umeng.commonsdk.debug.UMLogCommon.SC_10007;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r10 = "\\|";
        com.umeng.commonsdk.debug.UMLog.aq(r9, r3, r10);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x0214:
        return;
    L_0x0215:
        com.umeng.commonsdk.utils.UMUtils.setAppkey(r0, r10);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r1 = com.umeng.commonsdk.utils.UMUtils.getLastAppkey(r0);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r5 = android.text.TextUtils.isEmpty(r10);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r5 != 0) goto L_0x023c;
    L_0x0222:
        r5 = r10.equals(r1);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r5 != 0) goto L_0x023c;
    L_0x0228:
        r5 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r5 != 0) goto L_0x0239;
    L_0x022e:
        r5 = debugLog;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r5 == 0) goto L_0x0239;
    L_0x0232:
        r5 = "AppKey改变!!!";
        r6 = "";
        com.umeng.commonsdk.debug.UMLog.mutlInfo(r5, r2, r6);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x0239:
        com.umeng.commonsdk.utils.UMUtils.setLastAppkey(r0, r10);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x023c:
        r5 = debugLog;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r5 == 0) goto L_0x025e;
    L_0x0240:
        r5 = "UMConfigure";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r6.<init>();	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r7 = "current appkey is ";
        r6.append(r7);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r6.append(r10);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r7 = ", last appkey is ";
        r6.append(r7);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r6.append(r1);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r1 = r6.toString();	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        android.util.Log.i(r5, r1);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x025e:
        com.umeng.commonsdk.statistics.AnalyticsConstants.setDeviceType(r12);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r1 = "com.umeng.error.UMError";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x028c, Exception -> 0x0354 }
        if (r1 == 0) goto L_0x028c;
    L_0x0269:
        r5 = "init";
        r6 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x028c, Exception -> 0x0354 }
        r7 = android.content.Context.class;
        r6[r3] = r7;	 Catch:{ Throwable -> 0x028c, Exception -> 0x0354 }
        r5 = r1.getDeclaredMethod(r5, r6);	 Catch:{ Throwable -> 0x028c, Exception -> 0x0354 }
        if (r5 == 0) goto L_0x028c;
    L_0x0277:
        r5.setAccessible(r4);	 Catch:{ Throwable -> 0x028c, Exception -> 0x0354 }
        r6 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x028c, Exception -> 0x0354 }
        r6[r3] = r0;	 Catch:{ Throwable -> 0x028c, Exception -> 0x0354 }
        r5.invoke(r1, r6);	 Catch:{ Throwable -> 0x028c, Exception -> 0x0354 }
        r1 = debugLog;	 Catch:{ Throwable -> 0x028c, Exception -> 0x0354 }
        if (r1 == 0) goto L_0x028c;
    L_0x0285:
        r1 = "错误分析SDK初始化成功";
        r5 = "";
        com.umeng.commonsdk.debug.UMLog.mutlInfo(r1, r2, r5);	 Catch:{ Throwable -> 0x028c, Exception -> 0x0354 }
    L_0x028c:
        r1 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r0);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r1 == 0) goto L_0x02ba;
    L_0x0292:
        r1 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        if (r1 == r4) goto L_0x02b7;
    L_0x0296:
        r1 = "com.umeng.commonsdk.UMConfigureImpl";
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x02ba, Exception -> 0x0354 }
        if (r1 == 0) goto L_0x02ba;
    L_0x029e:
        r5 = "init";
        r6 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x02ba, Exception -> 0x0354 }
        r7 = android.content.Context.class;
        r6[r3] = r7;	 Catch:{ Throwable -> 0x02ba, Exception -> 0x0354 }
        r5 = r1.getDeclaredMethod(r5, r6);	 Catch:{ Throwable -> 0x02ba, Exception -> 0x0354 }
        if (r5 == 0) goto L_0x02ba;
    L_0x02ac:
        r5.setAccessible(r4);	 Catch:{ Throwable -> 0x02ba, Exception -> 0x0354 }
        r6 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x02ba, Exception -> 0x0354 }
        r6[r3] = r0;	 Catch:{ Throwable -> 0x02ba, Exception -> 0x0354 }
        r5.invoke(r1, r6);	 Catch:{ Throwable -> 0x02ba, Exception -> 0x0354 }
        goto L_0x02ba;
    L_0x02b7:
        com.umeng.commonsdk.a.a(r0);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x02ba:
        r1 = 0;
        r5 = "com.umeng.visual.UMVisualAgent";
        r5 = java.lang.Class.forName(r5);	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        r6 = "init";
        r7 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        r8 = android.content.Context.class;
        r7[r3] = r8;	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        r8 = java.lang.String.class;
        r7[r4] = r8;	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        r5 = r5.getMethod(r6, r7);	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        r6 = android.text.TextUtils.isEmpty(r10);	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        if (r6 != 0) goto L_0x02e1;
    L_0x02d7:
        r2 = new java.lang.Object[r2];	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        r2[r3] = r9;	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        r2[r4] = r10;	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        r5.invoke(r1, r2);	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        goto L_0x0304;
    L_0x02e1:
        r2 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        if (r2 == 0) goto L_0x0304;
    L_0x02e5:
        r2 = "initDebugSDK appkey  is null";
        com.umeng.commonsdk.statistics.common.MLog.e(r2);	 Catch:{ ClassNotFoundException -> 0x02eb, Throwable -> 0x0304, Exception -> 0x0354 }
        goto L_0x0304;
    L_0x02eb:
        r2 = "com.umeng.analytics.vismode.event.VisualHelper";
        r2 = java.lang.Class.forName(r2);	 Catch:{ Throwable -> 0x0304, Throwable -> 0x0338 }
        r5 = "init";
        r6 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x0304, Throwable -> 0x0338 }
        r7 = android.content.Context.class;
        r6[r3] = r7;	 Catch:{ Throwable -> 0x0304, Throwable -> 0x0338 }
        r2 = r2.getMethod(r5, r6);	 Catch:{ Throwable -> 0x0304, Throwable -> 0x0338 }
        r5 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0304, Throwable -> 0x0338 }
        r5[r3] = r9;	 Catch:{ Throwable -> 0x0304, Throwable -> 0x0338 }
        r2.invoke(r1, r5);	 Catch:{ Throwable -> 0x0304, Throwable -> 0x0338 }
    L_0x0304:
        r9 = new com.umeng.commonsdk.service.UMGlobalContext$a;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.<init>();	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.a = r0;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.b = r12;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.c = r13;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.d = r10;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.e = r11;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r10 = com.umeng.commonsdk.statistics.b.a;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.f = r10;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.g = r3;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r10 = com.umeng.commonsdk.framework.UMFrUtils.getCurrentProcessName(r0);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.h = r10;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r10 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r0);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.i = r10;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r10 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r0);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9.j = r10;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        com.umeng.commonsdk.service.UMGlobalContext.newUMGlobalContext(r9);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        r9 = lockObject;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        monitor-enter(r9);	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
        isFinish = r4;	 Catch:{ all -> 0x0335 }
        monitor-exit(r9);	 Catch:{ all -> 0x0335 }
        goto L_0x036f;
    L_0x0335:
        r10 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0335 }
        throw r10;	 Catch:{ Exception -> 0x0354, Throwable -> 0x0338 }
    L_0x0338:
        r9 = move-exception;
        r10 = debugLog;
        if (r10 == 0) goto L_0x036f;
    L_0x033d:
        r10 = "UMConfigure";
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = "init e is ";
        r11.append(r12);
        r11.append(r9);
        r9 = r11.toString();
        android.util.Log.e(r10, r9);
        goto L_0x036f;
    L_0x0354:
        r9 = move-exception;
        r10 = debugLog;
        if (r10 == 0) goto L_0x036f;
    L_0x0359:
        r10 = "UMConfigure";
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = "init e is ";
        r11.append(r12);
        r11.append(r9);
        r9 = r11.toString();
        android.util.Log.e(r10, r9);
    L_0x036f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.UMConfigure.init(android.content.Context, java.lang.String, java.lang.String, int, java.lang.String):void");
    }

    private static void invoke(Method method, Object obj, Object[] objArr) {
        if (method != null && obj != null) {
            try {
                method.invoke(obj, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    private static void invoke(Method method, Object[] objArr) {
        if (method != null) {
            try {
                method.invoke(null, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public static boolean isDebugLog() {
        return debugLog;
    }

    private static void saveSDKComponent() {
        StringBuffer stringBuffer = new StringBuffer();
        if (getClass("com.umeng.analytics.vismode.V") != null) {
            stringBuffer.append("v");
        } else if (getClass("x") != null) {
            stringBuffer.append("a");
        }
        if (getClass("com.umeng.visual.UMVisualAgent") != null) {
            stringBuffer.append("x");
        }
        if (getClass("com.umeng.message.PushAgent") != null) {
            stringBuffer.append("p");
        }
        if (getClass("com.umeng.socialize.UMShareAPI") != null) {
            stringBuffer.append("s");
        }
        if (getClass("com.umeng.error.UMError") != null) {
            stringBuffer.append("e");
        }
        stringBuffer.append("i");
        if (!(SdkVersion.SDK_TYPE == 1 || getClass("com.umeng.commonsdk.internal.UMOplus") == null)) {
            stringBuffer.append("o");
        }
        if (!TextUtils.isEmpty(stringBuffer)) {
            b.a = stringBuffer.toString();
            UMSLEnvelopeBuild.module = stringBuffer.toString();
        }
    }

    private static void setCheckDevice(boolean z) {
        AnalyticsConstants.CHECK_DEVICE = z;
    }

    public static void setEncryptEnabled(boolean z) {
        b.a(z);
        UMSLEnvelopeBuild.setEncryptEnabled(z);
    }

    private static void setFile(Class<?> cls, String str, String str2) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, str2);
            } catch (Exception unused) {
            }
        }
    }

    private static void setFile(Class<?> cls, String str, boolean z) {
        if (cls != null) {
            try {
                cls.getField(str).set(str, Boolean.valueOf(z));
            } catch (Exception unused) {
            }
        }
    }

    private static void setLatencyWindow(long j) {
        a.c = ((int) j) * 1000;
    }

    public static void setLogEnabled(boolean z) {
        String str;
        StringBuilder stringBuilder;
        try {
            debugLog = z;
            MLog.DEBUG = z;
            Class cls = getClass("com.umeng.message.PushAgent");
            Object decInstanceObject = getDecInstanceObject(cls);
            invoke(getDecMethod(cls, KEY_METHOD_NAME_SETDEBUGMODE, new Class[]{Boolean.TYPE}), decInstanceObject, new Object[]{Boolean.valueOf(z)});
            setFile(getClass("com.umeng.socialize.Config"), "DEBUG", z);
        } catch (Exception e) {
            if (debugLog) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("set log enabled e is ");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
            }
        } catch (Throwable th) {
            if (debugLog) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("set log enabled e is ");
                stringBuilder.append(th);
                Log.e(str, stringBuilder.toString());
            }
        }
    }

    public static void setProcessEvent(boolean z) {
        AnalyticsConstants.SUB_PROCESS_EVENT = z;
    }

    private static void setWraperType(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(WRAPER_TYPE_NATIVE)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_NATIVE;
                a.a = WRAPER_TYPE_NATIVE;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_X)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_COCOS2DX_X;
                a.a = WRAPER_TYPE_COCOS2DX_X;
            } else if (str.equals(WRAPER_TYPE_COCOS2DX_XLUA)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_COCOS2DX_XLUA;
                a.a = WRAPER_TYPE_COCOS2DX_XLUA;
            } else if (str.equals(WRAPER_TYPE_UNITY)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_UNITY;
                a.a = WRAPER_TYPE_UNITY;
            } else if (str.equals(WRAPER_TYPE_REACTNATIVE)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_REACTNATIVE;
                a.a = WRAPER_TYPE_REACTNATIVE;
            } else if (str.equals(WRAPER_TYPE_PHONEGAP)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_PHONEGAP;
                a.a = WRAPER_TYPE_PHONEGAP;
            } else if (str.equals(WRAPER_TYPE_WEEX)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_WEEX;
                a.a = WRAPER_TYPE_WEEX;
            } else if (str.equals(WRAPER_TYPE_HYBRID)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_HYBRID;
                a.a = WRAPER_TYPE_HYBRID;
            } else if (str.equals(WRAPER_TYPE_FLUTTER)) {
                com.umeng.commonsdk.stateless.a.a = WRAPER_TYPE_FLUTTER;
                a.a = WRAPER_TYPE_FLUTTER;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            com.umeng.commonsdk.stateless.a.b = str2;
            a.b = str2;
        }
    }
}
