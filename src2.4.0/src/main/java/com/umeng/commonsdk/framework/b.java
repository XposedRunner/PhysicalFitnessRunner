package com.umeng.commonsdk.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.tencent.connect.common.Constants;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;

/* compiled from: UMNetWorkSender */
class b implements UMImprintChangeCallback {
    private static HandlerThread a = null;
    private static Handler b = null;
    private static Handler c = null;
    private static final int d = 200;
    private static final int e = 273;
    private static final int f = 274;
    private static final int g = 512;
    private static final int h = 769;
    private static a i = null;
    private static ConnectivityManager j = null;
    private static NetworkInfo k = null;
    private static IntentFilter l = null;
    private static boolean m = false;
    private static ArrayList<UMSenderStateNotify> n = null;
    private static Object o = new Object();
    private static final String p = "report_policy";
    private static final String q = "report_interval";
    private static boolean r = false;
    private static final int s = 15000;
    private static final int t = 15;
    private static final int u = 90;
    private static int v = 15000;
    private static Object w = new Object();
    private static BroadcastReceiver x = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                Context appContext = UMModuleRegister.getAppContext();
                try {
                    if (b.j != null) {
                        b.k = b.j.getActiveNetworkInfo();
                        int i = 0;
                        if (b.k == null || !b.k.isAvailable()) {
                            ULog.i("--->>> network disconnected.");
                            b.m = false;
                            return;
                        }
                        ULog.i("--->>> network isAvailable, check if there are any files to send.");
                        b.m = true;
                        synchronized (b.o) {
                            if (b.n != null) {
                                int size = b.n.size();
                                if (size > 0) {
                                    while (i < size) {
                                        ((UMSenderStateNotify) b.n.get(i)).onConnectionAvailable();
                                        i++;
                                    }
                                }
                            }
                        }
                        b.c(b.e);
                        if (b.k.getType() == 1 && context != null) {
                            try {
                                if (!UMWorkDispatch.eventHasExist(com.umeng.commonsdk.internal.a.j)) {
                                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.j, com.umeng.commonsdk.internal.b.a(context).a(), null);
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(appContext, th);
                }
            }
        }
    };

    /* compiled from: UMNetWorkSender */
    static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        public void onEvent(int i, String str) {
            if ((i & 8) == 8) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("--->>> envelope file created >>> ");
                stringBuilder.append(str);
                ULog.d(stringBuilder.toString());
                String str2 = UMRTLog.RTLOG_TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("--->>> envelope file created >>> ");
                stringBuilder2.append(str);
                UMRTLog.i(str2, stringBuilder2.toString());
                b.c(b.e);
            }
        }
    }

    public b(Context context, Handler handler) {
        Context appContext = UMModuleRegister.getAppContext();
        j = (ConnectivityManager) appContext.getSystemService("connectivity");
        c = handler;
        try {
            if (a == null) {
                a = new HandlerThread("NetWorkSender");
                a.start();
                if (i == null) {
                    i = new a(UMFrUtils.getEnvelopeDirPath(context));
                    i.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                if (DeviceConfig.checkPermission(appContext, "android.permission.ACCESS_NETWORK_STATE") && j != null && l == null) {
                    l = new IntentFilter();
                    l.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    if (x != null) {
                        appContext.registerReceiver(x, l);
                    }
                }
                m();
                if (b == null) {
                    b = new Handler(a.getLooper()) {
                        public void handleMessage(Message message) {
                            int i = message.what;
                            if (i != 512) {
                                switch (i) {
                                    case b.e /*273*/:
                                        ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                        b.q();
                                        return;
                                    case b.f /*274*/:
                                        b.o();
                                        return;
                                    default:
                                        return;
                                }
                            }
                            b.p();
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    private static void a(int i, int i2) {
        if (m && b != null) {
            b.removeMessages(i);
            Message obtainMessage = b.obtainMessage();
            obtainMessage.what = i;
            b.sendMessageDelayed(obtainMessage, (long) i2);
        }
    }

    private static void a(int i, long j) {
        if (m && b != null) {
            Message obtainMessage = b.obtainMessage();
            obtainMessage.what = i;
            String str = UMRTLog.RTLOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("--->>> sendMsgDelayed: ");
            stringBuilder.append(j);
            UMRTLog.i(str, stringBuilder.toString());
            b.sendMessageDelayed(obtainMessage, j);
        }
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (o) {
            try {
                if (n == null) {
                    n = new ArrayList();
                }
                if (uMSenderStateNotify != null) {
                    for (int i = 0; i < n.size(); i++) {
                        if (uMSenderStateNotify == n.get(i)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    n.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (w) {
            z = r;
        }
        return z;
    }

    public static int b() {
        int i;
        synchronized (w) {
            i = v;
        }
        return i;
    }

    private static void b(int i) {
        if (m && b != null && !b.hasMessages(i)) {
            Message obtainMessage = b.obtainMessage();
            obtainMessage.what = i;
            b.sendMessage(obtainMessage);
        }
    }

    public static void c() {
    }

    private static void c(int i) {
        if (m && b != null) {
            Message obtainMessage = b.obtainMessage();
            obtainMessage.what = i;
            b.sendMessage(obtainMessage);
        }
    }

    public static void d() {
        b(e);
    }

    public static void e() {
        a((int) f, (int) SynchronizationConstants.LBS_STATUS_CODE_START_DEGRADED_DISPLAY);
    }

    private void m() {
        synchronized (w) {
            if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), p, ""))) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                r = true;
                v = s;
                int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), q, Constants.VIA_REPORT_TYPE_WPA_STATE)).intValue();
                String str = UMRTLog.RTLOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("--->>> set report_interval value to: ");
                stringBuilder.append(intValue);
                UMRTLog.i(str, stringBuilder.toString());
                if (intValue >= 15) {
                    if (intValue <= 90) {
                        v = intValue * 1000;
                    }
                }
                v = s;
            } else {
                r = false;
            }
        }
    }

    private static void n() {
        if (a != null) {
            a = null;
        }
        if (b != null) {
            b = null;
        }
        if (c != null) {
            c = null;
        }
    }

    private static void o() {
        synchronized (o) {
            if (n != null) {
                int size = n.size();
                if (size > 0) {
                    for (int i = 0; i < size; i++) {
                        ((UMSenderStateNotify) n.get(i)).onSenderIdle();
                    }
                }
            }
        }
    }

    private static void p() {
    }

    private static void q() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (m) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("--->>> Ready to send envelope file [");
                        stringBuilder.append(path);
                        stringBuilder.append("].");
                        ULog.d(stringBuilder.toString());
                        String str = UMRTLog.RTLOG_TAG;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("--->>> send envelope file [ ");
                        stringBuilder2.append(path);
                        stringBuilder2.append("].");
                        UMRTLog.i(str, stringBuilder2.toString());
                        if (new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file success, delete it.");
                            if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                                ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                                UMFrUtils.removeEnvelopeFile(envelopeFile);
                            }
                            c(e);
                            return;
                        }
                        ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    public void onImprintValueChanged(String str, String str2) {
        synchronized (w) {
            if (p.equals(str)) {
                if (Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE.equals(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    r = true;
                } else {
                    r = false;
                }
            }
            if (q.equals(str)) {
                int intValue = Integer.valueOf(str2).intValue();
                str2 = UMRTLog.RTLOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("--->>> set report_interval value to: ");
                stringBuilder.append(intValue);
                UMRTLog.i(str2, stringBuilder.toString());
                if (intValue >= 15) {
                    if (intValue <= 90) {
                        v = intValue * 1000;
                    }
                }
                v = s;
            }
        }
    }
}
