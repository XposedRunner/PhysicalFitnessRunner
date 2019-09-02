package com.umeng.commonsdk.framework;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.ULog;

/* compiled from: UMWorkDispatchImpl */
public class c {
    public static final String a = "content";
    public static final String b = "header";
    public static final String c = "exception";
    private static HandlerThread d = null;
    private static Handler e = null;
    private static b f = null;
    private static Object g = new Object();
    private static final int h = 768;
    private static final int i = 769;
    private static final int j = 770;
    private static final int k = 784;

    private c() {
    }

    public static void a() {
        if (e != null) {
            Message obtainMessage = e.obtainMessage();
            obtainMessage.what = k;
            e.sendMessage(obtainMessage);
        }
    }

    public static void a(long j) {
        if (e == null) {
            return;
        }
        if (e.hasMessages(j)) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS has exist. do nothing.");
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> MSG_DELAY_PROCESS not exist. send it.");
        Message obtainMessage = e.obtainMessage();
        obtainMessage.what = j;
        e.sendMessageDelayed(obtainMessage, j);
    }

    public static void a(Context context, int i, UMLogDataProtocol uMLogDataProtocol, Object obj) {
        if (context == null || uMLogDataProtocol == null) {
            ULog.d("--->>> Context or UMLogDataProtocol parameter cannot be null!");
            return;
        }
        UMModuleRegister.registerAppContext(context.getApplicationContext());
        if (UMModuleRegister.registerCallback(i, uMLogDataProtocol)) {
            if (d == null || e == null) {
                e();
            }
            try {
                if (e != null) {
                    if (UMGlobalContext.getInstance().isMainProcess(context)) {
                        synchronized (g) {
                            if (f == null) {
                                UMFrUtils.syncLegacyEnvelopeIfNeeded(context);
                                f = new b(context, e);
                            }
                        }
                    }
                    Message obtainMessage = e.obtainMessage();
                    obtainMessage.what = h;
                    obtainMessage.arg1 = i;
                    obtainMessage.obj = obj;
                    e.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        if (f != null) {
            b.a(uMSenderStateNotify);
        }
    }

    public static synchronized boolean a(int i) {
        synchronized (c.class) {
            if (e == null) {
                return false;
            }
            boolean hasMessages = e.hasMessages(i);
            return hasMessages;
        }
    }

    private static void b(Message message) {
        int i = message.arg1;
        Object obj = message.obj;
        UMLogDataProtocol callbackFromModuleName = UMModuleRegister.getCallbackFromModuleName(UMModuleRegister.eventType2ModuleName(i));
        if (callbackFromModuleName != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("--->>> dispatch:handleEvent: call back workEvent with msg type [ 0x");
            stringBuilder.append(Integer.toHexString(i));
            stringBuilder.append("]");
            ULog.d(stringBuilder.toString());
            callbackFromModuleName.workEvent(obj, i);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007e */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:23|24|(1:26)|27|28) */
    private static void d() {
        /*
        r0 = "--->>> delayProcess Enter...";
        com.umeng.commonsdk.statistics.common.ULog.d(r0);
        r0 = "MobclickRT";
        r1 = "--->>> delayProcess Enter...";
        com.umeng.commonsdk.debug.UMRTLog.i(r0, r1);
        r0 = com.umeng.commonsdk.framework.UMModuleRegister.getAppContext();
        if (r0 == 0) goto L_0x008c;
    L_0x0012:
        r1 = com.umeng.commonsdk.framework.UMFrUtils.isOnline(r0);
        if (r1 != 0) goto L_0x0019;
    L_0x0018:
        return;
    L_0x0019:
        r1 = com.umeng.commonsdk.framework.UMEnvelopeBuild.maxDataSpace(r0);
        r3 = "analytics";
        r3 = com.umeng.commonsdk.framework.UMModuleRegister.getCallbackFromModuleName(r3);
        r4 = 0;
        if (r3 == 0) goto L_0x0036;
    L_0x0026:
        r4 = r3.setupReportData(r1);	 Catch:{ Throwable -> 0x0034 }
        if (r4 != 0) goto L_0x0036;
    L_0x002c:
        r1 = "MobclickRT";
        r2 = "--->>> analyticsCB.setupReportData() return null";
        com.umeng.commonsdk.debug.UMRTLog.i(r1, r2);	 Catch:{ Throwable -> 0x0034 }
        return;
    L_0x0034:
        r1 = move-exception;
        goto L_0x0089;
    L_0x0036:
        if (r4 == 0) goto L_0x008c;
    L_0x0038:
        r1 = r4.length();	 Catch:{ Throwable -> 0x0034 }
        if (r1 <= 0) goto L_0x008c;
    L_0x003e:
        r1 = "header";
        r1 = r4.opt(r1);	 Catch:{ Throwable -> 0x0034 }
        r1 = (org.json.JSONObject) r1;	 Catch:{ Throwable -> 0x0034 }
        r2 = "content";
        r2 = r4.opt(r2);	 Catch:{ Throwable -> 0x0034 }
        r2 = (org.json.JSONObject) r2;	 Catch:{ Throwable -> 0x0034 }
        if (r0 == 0) goto L_0x008c;
    L_0x0050:
        if (r1 == 0) goto L_0x008c;
    L_0x0052:
        if (r2 == 0) goto L_0x008c;
    L_0x0054:
        r1 = com.umeng.commonsdk.framework.UMEnvelopeBuild.buildEnvelopeWithExtHeader(r0, r1, r2);	 Catch:{ Throwable -> 0x0034 }
        if (r1 == 0) goto L_0x008c;
    L_0x005a:
        r2 = "exception";
        r2 = r1.has(r2);	 Catch:{ Throwable -> 0x007e }
        if (r2 == 0) goto L_0x007e;
    L_0x0062:
        r2 = "MobclickRT";
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x007e }
        r4.<init>();	 Catch:{ Throwable -> 0x007e }
        r5 = "--->>> autoProcess: Build envelope error code: ";
        r4.append(r5);	 Catch:{ Throwable -> 0x007e }
        r5 = "exception";
        r5 = r1.getInt(r5);	 Catch:{ Throwable -> 0x007e }
        r4.append(r5);	 Catch:{ Throwable -> 0x007e }
        r4 = r4.toString();	 Catch:{ Throwable -> 0x007e }
        com.umeng.commonsdk.debug.UMRTLog.i(r2, r4);	 Catch:{ Throwable -> 0x007e }
    L_0x007e:
        r2 = "MobclickRT";
        r4 = "--->>> autoProcess: removeCacheData ... ";
        com.umeng.commonsdk.debug.UMRTLog.i(r2, r4);	 Catch:{ Throwable -> 0x0034 }
        r3.removeCacheData(r1);	 Catch:{ Throwable -> 0x0034 }
        goto L_0x008c;
    L_0x0089:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r0, r1);
    L_0x008c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.c.d():void");
    }

    private static synchronized void e() {
        synchronized (c.class) {
            ULog.d("--->>> Dispatch: init Enter...");
            try {
                if (d == null) {
                    d = new HandlerThread("work_thread");
                    d.start();
                    if (e == null) {
                        e = new Handler(d.getLooper()) {
                            public void handleMessage(Message message) {
                                int i = message.what;
                                if (i != c.k) {
                                    switch (i) {
                                        case c.h /*768*/:
                                            c.b(message);
                                            return;
                                        case c.j /*770*/:
                                            c.d();
                                            return;
                                        default:
                                            return;
                                    }
                                }
                                c.g();
                            }
                        };
                    }
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
            ULog.d("--->>> Dispatch: init Exit...");
        }
    }

    private static void f() {
        if (d != null) {
            d = null;
        }
        if (e != null) {
            e = null;
        }
        if (f != null) {
            f = null;
        }
    }

    private static void g() {
        if (f != null && d != null) {
            b.c();
            ULog.d("--->>> handleQuit: Quit dispatch thread.");
            d.quit();
            f();
        }
    }
}
