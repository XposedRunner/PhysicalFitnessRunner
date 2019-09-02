package com.ximalaya.ting.android.opensdk.datatrasfer;

import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;
import com.ximalaya.ting.android.opensdk.util.Logger;
import com.ximalaya.ting.android.opensdk.util.MethodUtil;
import com.ximalaya.ting.android.xmpayordersdk.O000000o;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class CommonRequestForMain {
    public static String getChargeDownloadUrl(Track track) {
        Object invokeStaticMethod;
        Class commonRequestM = BaseCall.getCommonRequestM();
        if (commonRequestM == null) {
            return null;
        }
        try {
            invokeStaticMethod = MethodUtil.invokeStaticMethod(commonRequestM, "getChargeDownloadUrl", new Object[]{new HashMap(), track}, new Class[]{Map.class, Track.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return (String) invokeStaticMethod;
        invokeStaticMethod = null;
        return (String) invokeStaticMethod;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    public static java.lang.String[][] getStaticDomainServerIpInner(java.lang.String r8) {
        /*
        r0 = 0;
        r1 = "com.sina.util.dnscache.DNSCache";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0085 }
        r2 = 0;
        r3 = 1;
        r4 = "getStaticDomainServerIp";
        r5 = new java.lang.Object[r3];	 Catch:{ NoSuchMethodException -> 0x0024, IllegalAccessException -> 0x001f, InvocationTargetException -> 0x001a }
        r5[r2] = r8;	 Catch:{ NoSuchMethodException -> 0x0024, IllegalAccessException -> 0x001f, InvocationTargetException -> 0x001a }
        r6 = new java.lang.Class[r3];	 Catch:{ NoSuchMethodException -> 0x0024, IllegalAccessException -> 0x001f, InvocationTargetException -> 0x001a }
        r7 = java.lang.String.class;
        r6[r2] = r7;	 Catch:{ NoSuchMethodException -> 0x0024, IllegalAccessException -> 0x001f, InvocationTargetException -> 0x001a }
        r1 = com.ximalaya.ting.android.opensdk.util.MethodUtil.invokeStaticMethod(r1, r4, r5, r6);	 Catch:{ NoSuchMethodException -> 0x0024, IllegalAccessException -> 0x001f, InvocationTargetException -> 0x001a }
        goto L_0x0029;
    L_0x001a:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0028;
    L_0x001f:
        r1 = move-exception;
        r1.printStackTrace();
        goto L_0x0028;
    L_0x0024:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0028:
        r1 = r0;
    L_0x0029:
        if (r1 == 0) goto L_0x0082;
    L_0x002b:
        r1 = (java.lang.String) r1;
        r4 = android.text.TextUtils.isEmpty(r1);
        if (r4 == 0) goto L_0x0036;
    L_0x0033:
        r0 = (java.lang.String[][]) r0;
        return r0;
    L_0x0036:
        r0 = "__&__";
        r0 = r1.split(r0);
        r1 = r0.length;
        r1 = r1 + r3;
        r3 = 2;
        r1 = new int[]{r1, r3};
        r3 = java.lang.String.class;
        r1 = java.lang.reflect.Array.newInstance(r3, r1);
        r1 = (java.lang.String[][]) r1;
        r3 = r2;
    L_0x004c:
        r4 = r0.length;
        if (r3 >= r4) goto L_0x007c;
    L_0x004f:
        r4 = r0[r3];
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x0079;
    L_0x0057:
        r4 = r0[r3];
        r5 = "__#__";
        r4 = r4.split(r5);
        r1[r3] = r4;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "getStaticDomainServerIp ipsAndHostStrArr:";
        r5.append(r6);
        r4 = java.util.Arrays.toString(r4);
        r5.append(r4);
        r4 = r5.toString();
        com.ximalaya.ting.android.opensdk.util.Logger.log(r4);
    L_0x0079:
        r3 = r3 + 1;
        goto L_0x004c;
    L_0x007c:
        r0 = r0.length;
        r0 = r1[r0];
        r0[r2] = r8;
        return r1;
    L_0x0082:
        r0 = (java.lang.String[][]) r0;
        return r0;
    L_0x0085:
        r8 = move-exception;
        r8.printStackTrace();
        r0 = (java.lang.String[][]) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequestForMain.getStaticDomainServerIpInner(java.lang.String):java.lang.String[][]");
    }

    public static Track getTrackInfo(final long j) {
        Object invokeStaticMethod;
        Class commonRequestM = BaseCall.getCommonRequestM();
        if (commonRequestM == null) {
            return null;
        }
        try {
            invokeStaticMethod = MethodUtil.invokeStaticMethod(commonRequestM, "getTrackInfoDetailSync", new Object[]{new HashMap<String, String>() {
            }}, new Class[]{Map.class});
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return (Track) invokeStaticMethod;
        invokeStaticMethod = null;
        return (Track) invokeStaticMethod;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A:{SYNTHETIC, Splitter:B:14:0x0021} */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020 A:{RETURN} */
    public static java.lang.String getUseragent() {
        /*
        r0 = com.ximalaya.ting.android.opensdk.httputil.BaseCall.getCommonRequestM();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = "getInstanse";
        r0 = com.ximalaya.ting.android.opensdk.util.MethodUtil.invokeStaticMethod(r0, r2, r1, r1);	 Catch:{ NoSuchMethodException -> 0x0019, IllegalAccessException -> 0x0014, InvocationTargetException -> 0x000f }
        goto L_0x001e;
    L_0x000f:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x001d;
    L_0x0014:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x001d;
    L_0x0019:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x001d:
        r0 = r1;
    L_0x001e:
        if (r0 != 0) goto L_0x0021;
    L_0x0020:
        return r1;
    L_0x0021:
        r2 = "getUserAgent";
        r0 = com.ximalaya.ting.android.opensdk.util.MethodUtil.invokeMethod(r0, r2, r1, r1);	 Catch:{ NoSuchMethodException -> 0x0032, IllegalAccessException -> 0x002d, InvocationTargetException -> 0x0028 }
        goto L_0x0037;
    L_0x0028:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0036;
    L_0x002d:
        r0 = move-exception;
        r0.printStackTrace();
        goto L_0x0036;
    L_0x0032:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0036:
        r0 = r1;
    L_0x0037:
        r0 = (java.lang.String) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequestForMain.getUseragent():java.lang.String");
    }

    public static <T> boolean invokeFuncWithCommonRequestM(Map<String, String> map, IDataCallBack<T> iDataCallBack, Track track, String str) {
        Class commonRequestM = BaseCall.getCommonRequestM();
        if (commonRequestM == null) {
            return false;
        }
        try {
            MethodUtil.invokeStaticMethod(commonRequestM, str, new Object[]{map, iDataCallBack, track}, new Class[]{Map.class, IDataCallBack.class, Track.class});
            Logger.log("encryptStr 1");
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("func ");
            stringBuilder.append(str);
            stringBuilder.append(" invoke fail");
            iDataCallBack.onError(O000000o.O0000Ooo, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("encryptStr 2");
            stringBuilder2.append(e);
            Logger.log(stringBuilder2.toString());
        }
        return true;
    }

    public static <T> boolean invokeFuncWithCommonRequestM(Map<String, String> map, IDataCallBack<T> iDataCallBack, String str) {
        Class commonRequestM = BaseCall.getCommonRequestM();
        if (commonRequestM == null) {
            return false;
        }
        try {
            MethodUtil.invokeStaticMethod(commonRequestM, str, new Object[]{map, iDataCallBack}, new Class[]{Map.class, IDataCallBack.class});
            Logger.log("encryptStr 1");
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("func ");
            stringBuilder.append(str);
            stringBuilder.append(" invoke fail");
            iDataCallBack.onError(O000000o.O0000Ooo, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("encryptStr 2");
            stringBuilder2.append(e);
            Logger.log(stringBuilder2.toString());
        }
        return true;
    }

    public static void setBadIp(String str, String str2, String str3) {
        try {
            Class.forName("com.sina.util.dnscache.DNSCache").getDeclaredMethod("setBadIp", new Class[]{String.class, String.class, String.class}).invoke(null, new Object[]{str, str2, str3});
        } catch (Exception unused) {
        }
    }

    public static void updateLoginInfo() {
        String str = "getLocalUserInfo";
        Logger.log("encryptStr 1");
        if (BaseUtil.isMainApp()) {
            try {
                MethodUtil.invokeStaticMethod(BaseCall.getCommonRequestM(), str, null, null);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    public static void updateTrackForPlay(Map<String, String> map, IDataCallBack<String> iDataCallBack, Track track) {
        String str = "updateTrackForPlay";
        Logger.log("encryptStr 0");
        if (!invokeFuncWithCommonRequestM(map, iDataCallBack, track, str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("call ");
            stringBuilder.append(str);
            stringBuilder.append(" is not in mainapp or class.forName CommonRequestM error");
            iDataCallBack.onError(O000000o.O0000Ooo, stringBuilder.toString());
        }
    }
}
