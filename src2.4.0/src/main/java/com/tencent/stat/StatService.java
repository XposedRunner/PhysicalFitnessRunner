package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import com.tencent.stat.a.a;
import com.tencent.stat.a.b;
import com.tencent.stat.a.c;
import com.tencent.stat.a.d;
import com.tencent.stat.a.g;
import com.tencent.stat.a.h;
import com.tencent.stat.a.j;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.f;
import com.tencent.stat.common.k;
import com.tencent.stat.common.p;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class StatService {
    private static Handler a = null;
    private static volatile Map<c, Long> b = new ConcurrentHashMap();
    private static volatile long c = 0;
    private static volatile long d = 0;
    private static volatile int e = 0;
    private static volatile String f = "";
    private static volatile String g = "";
    private static Map<String, Long> h = new ConcurrentHashMap();
    private static StatLogger i = k.b();
    private static UncaughtExceptionHandler j = null;
    private static volatile boolean k = true;

    static int a(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        int i = (!z || currentTimeMillis - c < ((long) StatConfig.getSessionTimoutMillis())) ? 0 : 1;
        c = currentTimeMillis;
        if (d == 0) {
            d = k.c();
        }
        if (currentTimeMillis >= d) {
            d = k.c();
            if (n.a(context).b(context).getUserType() != 1) {
                n.a(context).b(context).b(1);
            }
            StatConfig.b(0);
            StatMid.a(context);
            i = 1;
        }
        if (k) {
            i = 1;
        }
        if (i != 0) {
            if (StatConfig.e() < StatConfig.getMaxDaySessionNumbers()) {
                k.F(context);
                d(context);
            } else {
                i.e((Object) "Exceed StatConfig.getMaxDaySessionNumbers().");
            }
        }
        if (k) {
            f.b(context);
            testSpeed(context);
            e(context);
            k = false;
        }
        return e;
    }

    static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (StatConfig.b.d != 0) {
                jSONObject2.put("v", StatConfig.b.d);
            }
            jSONObject.put(Integer.toString(StatConfig.b.a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (StatConfig.a.d != 0) {
                jSONObject2.put("v", StatConfig.a.d);
            }
            jSONObject.put(Integer.toString(StatConfig.a.a), jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            i.e(e);
            return jSONObject;
        }
    }

    /* JADX WARNING: Missing block: B:30:0x008c, code skipped:
            return;
     */
    static synchronized void a(android.content.Context r3) {
        /*
        r0 = com.tencent.stat.StatService.class;
        monitor-enter(r0);
        if (r3 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r0);
        return;
    L_0x0007:
        r1 = a;	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x008b;
    L_0x000b:
        r1 = b(r3);	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x0013;
    L_0x0011:
        monitor-exit(r0);
        return;
    L_0x0013:
        r1 = com.tencent.stat.common.f.a(r3);	 Catch:{ all -> 0x008d }
        if (r1 != 0) goto L_0x002d;
    L_0x0019:
        r3 = i;	 Catch:{ all -> 0x008d }
        r1 = "ooh, Compatibility problem was found in this device!";
        r3.e(r1);	 Catch:{ all -> 0x008d }
        r3 = i;	 Catch:{ all -> 0x008d }
        r1 = "If you are on debug mode, please delete apk and try again.";
        r3.e(r1);	 Catch:{ all -> 0x008d }
        r3 = 0;
        com.tencent.stat.StatConfig.setEnableStatService(r3);	 Catch:{ all -> 0x008d }
        monitor-exit(r0);
        return;
    L_0x002d:
        r1 = new android.os.HandlerThread;	 Catch:{ all -> 0x008d }
        r2 = "StatService";
        r1.<init>(r2);	 Catch:{ all -> 0x008d }
        r1.start();	 Catch:{ all -> 0x008d }
        r2 = new android.os.Handler;	 Catch:{ all -> 0x008d }
        r1 = r1.getLooper();	 Catch:{ all -> 0x008d }
        r2.<init>(r1);	 Catch:{ all -> 0x008d }
        a = r2;	 Catch:{ all -> 0x008d }
        com.tencent.stat.n.a(r3);	 Catch:{ all -> 0x008d }
        com.tencent.stat.d.a(r3);	 Catch:{ all -> 0x008d }
        com.tencent.stat.d.b();	 Catch:{ all -> 0x008d }
        com.tencent.stat.StatConfig.getDeviceInfo(r3);	 Catch:{ all -> 0x008d }
        r1 = java.lang.Thread.getDefaultUncaughtExceptionHandler();	 Catch:{ all -> 0x008d }
        j = r1;	 Catch:{ all -> 0x008d }
        r1 = com.tencent.stat.StatConfig.isAutoExceptionCaught();	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x0067;
    L_0x005a:
        r1 = r3.getApplicationContext();	 Catch:{ all -> 0x008d }
        r2 = new com.tencent.stat.g;	 Catch:{ all -> 0x008d }
        r2.<init>(r1);	 Catch:{ all -> 0x008d }
        java.lang.Thread.setDefaultUncaughtExceptionHandler(r2);	 Catch:{ all -> 0x008d }
        goto L_0x006e;
    L_0x0067:
        r1 = i;	 Catch:{ all -> 0x008d }
        r2 = "MTA SDK AutoExceptionCaught is disable";
        r1.warn(r2);	 Catch:{ all -> 0x008d }
    L_0x006e:
        r1 = com.tencent.stat.StatConfig.getStatSendStrategy();	 Catch:{ all -> 0x008d }
        r2 = com.tencent.stat.StatReportStrategy.APP_LAUNCH;	 Catch:{ all -> 0x008d }
        if (r1 != r2) goto L_0x0084;
    L_0x0076:
        r1 = com.tencent.stat.common.k.h(r3);	 Catch:{ all -> 0x008d }
        if (r1 == 0) goto L_0x0084;
    L_0x007c:
        r3 = com.tencent.stat.n.a(r3);	 Catch:{ all -> 0x008d }
        r1 = -1;
        r3.a(r1);	 Catch:{ all -> 0x008d }
    L_0x0084:
        r3 = i;	 Catch:{ all -> 0x008d }
        r1 = "Init MTA StatService success.";
        r3.d(r1);	 Catch:{ all -> 0x008d }
    L_0x008b:
        monitor-exit(r0);
        return;
    L_0x008d:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.StatService.a(android.content.Context):void");
    }

    static void a(Context context, Throwable th) {
        try {
            if (!StatConfig.isEnableStatService()) {
                return;
            }
            if (context == null) {
                i.error((Object) "The Context of StatService.reportSdkSelfException() can not be null!");
                return;
            }
            d dVar = new d(context, a(context, false), 99, th);
            if (c(context) != null) {
                c(context).post(new k(dVar));
            }
        } catch (Throwable th2) {
            StatLogger statLogger = i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("reportSdkSelfException error: ");
            stringBuilder.append(th2);
            statLogger.e(stringBuilder.toString());
        }
    }

    static void a(Context context, Map<String, ?> map) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            i.error((Object) "The Context of StatService.sendAdditionEvent() can not be null!");
            return;
        }
        try {
            a aVar = new a(context, a(context, false), map);
            if (c(context) != null) {
                c(context).post(new k(aVar));
            }
        } catch (Throwable th) {
            i.e((Object) th);
            a(context, th);
        }
    }

    static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    static boolean b(Context context) {
        if (k.b(StatConstants.VERSION) > p.a(context, StatConfig.c, 0)) {
            return true;
        }
        StatConfig.setEnableStatService(false);
        return false;
    }

    static Handler c(Context context) {
        if (a == null) {
            a(context);
        }
        return a;
    }

    public static void commitEvents(Context context, int i) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.commitEvents() can not be null!";
            } else if (i < -1 || i == 0) {
                statLogger = i;
                obj = "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.";
            } else {
                try {
                    n.a(context).a(i);
                    return;
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                    return;
                }
            }
            statLogger.error(obj);
        }
    }

    static void d(Context context) {
        if (c(context) != null) {
            i.d("start new session.");
            e = k.a();
            StatConfig.a(0);
            StatConfig.d();
            c(context).post(new k(new com.tencent.stat.a.k(context, e, a())));
        }
    }

    static void e(Context context) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            i.error((Object) "The Context of StatService.reportNativeCrash() can not be null!");
            return;
        }
        try {
            if (c(context) != null) {
                c(context).post(new i(context));
            }
        } catch (Throwable th) {
            i.e((Object) th);
            a(context, th);
        }
    }

    public static void onPause(Context context) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            i.error((Object) "The Context of StatService.onPause() can not be null!");
        } else {
            trackEndPage(context, k.k(context));
        }
    }

    public static void onResume(Context context) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            i.error((Object) "The Context of StatService.onResume() can not be null!");
        } else {
            trackBeginPage(context, k.k(context));
        }
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor == null) {
                statLogger = i;
                obj = "The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor.getInterfaceName() == null) {
                statLogger = i;
                obj = "The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!";
            } else {
                try {
                    h hVar = new h(context, a(context, false), statAppMonitor);
                    if (c(context) != null) {
                        c(context).post(new k(hVar));
                        return;
                    }
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void reportError(Context context, String str) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.reportError() can not be null!";
            } else if (a(str)) {
                statLogger = i;
                obj = "Error message in StatService.reportError() is empty.";
            } else {
                try {
                    d dVar = new d(context, a(context, false), str, 0, StatConfig.getMaxReportEventLength());
                    if (c(context) != null) {
                        c(context).post(new k(dVar));
                        return;
                    }
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void reportException(Context context, Throwable th) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.reportException() can not be null!";
            } else if (th == null) {
                statLogger = i;
                obj = "The Throwable error message of StatService.reportException() can not be null!";
            } else {
                d dVar = new d(context, a(context, false), 1, th);
                if (c(context) != null) {
                    c(context).post(new k(dVar));
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void reportGameUser(Context context, StatGameUser statGameUser) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.reportGameUser() can not be null!";
            } else if (statGameUser == null) {
                statLogger = i;
                obj = "The gameUser of StatService.reportGameUser() can not be null!";
            } else if (statGameUser.getAccount() == null || statGameUser.getAccount().length() == 0) {
                statLogger = i;
                obj = "The account of gameUser on StatService.reportGameUser() can not be null or empty!";
            } else {
                try {
                    g gVar = new g(context, a(context, false), statGameUser);
                    if (c(context) != null) {
                        c(context).post(new k(gVar));
                        return;
                    }
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void reportQQ(Context context, String str) {
        Object str2;
        if (str2 == null) {
            str2 = "";
        }
        if (!StatConfig.d.equals(str2)) {
            StatConfig.d = new String(str2);
            a(context, null);
        }
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            i.error((Object) "The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            com.tencent.stat.common.a.a(context, map);
        } catch (JSONException e) {
            i.e(e);
        }
    }

    public static void startNewSession(Context context) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            i.error((Object) "The Context of StatService.startNewSession() can not be null!");
            return;
        }
        try {
            stopSession();
            a(context, true);
        } catch (Throwable th) {
            i.e((Object) th);
            a(context, th);
        }
    }

    public static boolean startStatService(Context context, String str, String str2) {
        if (StatConfig.isEnableStatService()) {
            String str3 = StatConstants.VERSION;
            StatLogger statLogger = i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("MTA SDK version, current: ");
            stringBuilder.append(str3);
            stringBuilder.append(" ,required: ");
            stringBuilder.append(str2);
            statLogger.d(stringBuilder.toString());
            String str4;
            if (context == null || str2 == null) {
                str4 = "Context or mtaSdkVersion in StatService.startStatService() is null, please check it!";
                i.error((Object) str4);
                StatConfig.setEnableStatService(false);
                throw new MtaSDkException(str4);
            } else if (k.b(str3) < k.b(str2)) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("MTA SDK version conflicted, current: ");
                stringBuilder2.append(str3);
                stringBuilder2.append(",required: ");
                stringBuilder2.append(str2);
                str4 = stringBuilder2.toString();
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str4);
                stringBuilder3.append(". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                str4 = stringBuilder3.toString();
                i.error((Object) str4);
                StatConfig.setEnableStatService(false);
                throw new MtaSDkException(str4);
            } else {
                try {
                    str2 = StatConfig.getInstallChannel(context);
                    if (str2 == null || str2.length() == 0) {
                        StatConfig.setInstallChannel("-");
                    }
                    if (str != null) {
                        StatConfig.setAppKey(context, str);
                    }
                    c(context);
                    a(context, false);
                    return true;
                } catch (Throwable th) {
                    i.e(th);
                    return false;
                }
            }
        }
        i.error((Object) "MTA StatService is disable.");
        return false;
    }

    public static void stopSession() {
        c = 0;
    }

    public static void testSpeed(Context context) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null) {
            i.error((Object) "The Context of StatService.testSpeed() can not be null!");
            return;
        }
        try {
            if (c(context) != null) {
                c(context).post(new j(context, null));
            }
        } catch (Throwable th) {
            i.e((Object) th);
            a(context, th);
        }
    }

    public static void testSpeed(Context context, Map<String, Integer> map) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.testSpeed() can not be null!";
            } else if (map == null || map.size() == 0) {
                statLogger = i;
                obj = "The domainMap of StatService.testSpeed() can not be null or empty!";
            } else {
                try {
                    if (c(context) != null) {
                        c(context).post(new j(context, map));
                        return;
                    }
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void trackBeginPage(Context context, String str) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null || str == null || str.length() == 0) {
            i.error((Object) "The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
            return;
        }
        try {
            synchronized (h) {
                StatLogger statLogger;
                StringBuilder stringBuilder;
                if (h.size() >= StatConfig.getMaxParallelTimmingEvents()) {
                    statLogger = i;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The number of page events exceeds the maximum value ");
                    stringBuilder.append(Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                    statLogger.error(stringBuilder.toString());
                    return;
                }
                f = str;
                if (h.containsKey(f)) {
                    statLogger = i;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Duplicate PageID : ");
                    stringBuilder.append(f);
                    stringBuilder.append(", onResume() repeated?");
                    statLogger.e(stringBuilder.toString());
                    return;
                }
                h.put(f, Long.valueOf(System.currentTimeMillis()));
                a(context, true);
            }
        } catch (Throwable th) {
            i.e((Object) th);
            a(context, th);
        }
    }

    public static void trackCustomBeginEvent(Context context, String str, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.trackCustomBeginEvent() can not be null!";
            } else if (a(str)) {
                statLogger = i;
                obj = "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.";
            } else {
                try {
                    c cVar = new c(str, strArr, null);
                    StatLogger statLogger2;
                    StringBuilder stringBuilder;
                    if (b.containsKey(cVar)) {
                        statLogger2 = i;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Duplicate CustomEvent key: ");
                        stringBuilder.append(cVar.toString());
                        stringBuilder.append(", trackCustomBeginEvent() repeated?");
                        statLogger2.error(stringBuilder.toString());
                        return;
                    } else if (b.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                        b.put(cVar, Long.valueOf(System.currentTimeMillis()));
                        return;
                    } else {
                        statLogger2 = i;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("The number of timedEvent exceeds the maximum value ");
                        stringBuilder.append(Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                        statLogger2.error(stringBuilder.toString());
                        return;
                    }
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                    return;
                }
            }
            statLogger.error(obj);
        }
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.trackCustomBeginEvent() can not be null!";
            } else if (a(str)) {
                statLogger = i;
                obj = "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.";
            } else {
                try {
                    c cVar = new c(str, null, properties);
                    StatLogger statLogger2;
                    StringBuilder stringBuilder;
                    if (b.containsKey(cVar)) {
                        statLogger2 = i;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Duplicate CustomEvent key: ");
                        stringBuilder.append(cVar.toString());
                        stringBuilder.append(", trackCustomBeginKVEvent() repeated?");
                        statLogger2.error(stringBuilder.toString());
                        return;
                    } else if (b.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                        b.put(cVar, Long.valueOf(System.currentTimeMillis()));
                        return;
                    } else {
                        statLogger2 = i;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("The number of timedEvent exceeds the maximum value ");
                        stringBuilder.append(Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                        statLogger2.error(stringBuilder.toString());
                        return;
                    }
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                    return;
                }
            }
            statLogger.error(obj);
        }
    }

    public static void trackCustomEndEvent(Context context, String str, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else if (a(str)) {
                statLogger = i;
                obj = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            } else {
                try {
                    c cVar = new c(str, strArr, null);
                    Long l = (Long) b.remove(cVar);
                    if (l != null) {
                        b bVar = new b(context, a(context, false), str);
                        bVar.a(strArr);
                        Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                        bVar.a(Long.valueOf(valueOf.longValue() == 0 ? 1 : valueOf.longValue()).longValue());
                        if (c(context) != null) {
                            c(context).post(new k(bVar));
                            return;
                        }
                        return;
                    }
                    StatLogger statLogger2 = i;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No start time found for custom event: ");
                    stringBuilder.append(cVar.toString());
                    stringBuilder.append(", lost trackCustomBeginEvent()?");
                    statLogger2.error(stringBuilder.toString());
                    return;
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                }
            }
            statLogger.error(obj);
        }
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else if (a(str)) {
                statLogger = i;
                obj = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            } else {
                try {
                    c cVar = new c(str, null, properties);
                    Long l = (Long) b.remove(cVar);
                    if (l != null) {
                        b bVar = new b(context, a(context, false), str);
                        bVar.a(properties);
                        Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                        bVar.a(Long.valueOf(valueOf.longValue() == 0 ? 1 : valueOf.longValue()).longValue());
                        if (c(context) != null) {
                            c(context).post(new k(bVar));
                            return;
                        }
                        return;
                    }
                    StatLogger statLogger2 = i;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No start time found for custom event: ");
                    stringBuilder.append(cVar.toString());
                    stringBuilder.append(", lost trackCustomBeginKVEvent()?");
                    statLogger2.error(stringBuilder.toString());
                    return;
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                }
            }
            statLogger.error(obj);
        }
    }

    public static void trackCustomEvent(Context context, String str, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (a(str)) {
                statLogger = i;
                obj = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            } else {
                try {
                    b bVar = new b(context, a(context, false), str);
                    bVar.a(strArr);
                    if (c(context) != null) {
                        c(context).post(new k(bVar));
                        return;
                    }
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (context == null) {
                statLogger = i;
                obj = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (a(str)) {
                statLogger = i;
                obj = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            } else {
                try {
                    b bVar = new b(context, a(context, false), str);
                    bVar.a(properties);
                    if (c(context) != null) {
                        c(context).post(new k(bVar));
                        return;
                    }
                } catch (Throwable th) {
                    i.e((Object) th);
                    a(context, th);
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void trackEndPage(Context context, String str) {
        if (!StatConfig.isEnableStatService()) {
            return;
        }
        if (context == null || str == null || str.length() == 0) {
            i.error((Object) "The Context or pageName of StatService.trackEndPage() can not be null or empty!");
            return;
        }
        try {
            Long l;
            synchronized (h) {
                l = (Long) h.remove(str);
            }
            if (l != null) {
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                if (valueOf.longValue() <= 0) {
                    valueOf = Long.valueOf(1);
                }
                Long l2 = valueOf;
                String str2 = g;
                if (str2 != null && str2.equals(str)) {
                    str2 = "-";
                }
                String str3 = str2;
                if (c(context) != null) {
                    j jVar = new j(context, str3, str, a(context, false), l2);
                    if (!str.equals(f)) {
                        i.warn("Invalid invocation since previous onResume on diff page.");
                    }
                    c(context).post(new k(jVar));
                }
                g = str;
                return;
            }
            StatLogger statLogger = i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Starttime for PageID:");
            stringBuilder.append(str);
            stringBuilder.append(" not found, lost onResume()?");
            statLogger.e(stringBuilder.toString());
        } catch (Throwable th) {
            i.e((Object) th);
            a(context, th);
        }
    }
}
