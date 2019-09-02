package com.tencent.open.b;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import cn.jiguang.net.HttpUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.e;
import com.tencent.open.utils.f;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class g {
    protected static g a;
    protected Random b = new Random();
    protected List<Serializable> c = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> d = Collections.synchronizedList(new ArrayList());
    protected HandlerThread e = null;
    protected Handler f;
    protected Executor g = i.b();
    protected Executor h = i.b();

    private g() {
        if (this.e == null) {
            this.e = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e.start();
        }
        if (this.e.isAlive() && this.e.getLooper() != null) {
            this.f = new Handler(this.e.getLooper()) {
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 1000:
                            g.this.b();
                            break;
                        case 1001:
                            g.this.e();
                            break;
                    }
                    super.handleMessage(message);
                }
            };
        }
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    /* Access modifiers changed, original: protected */
    public int a(int i) {
        if (i == 0) {
            i = f.a(e.a(), null).a("Common_CGIReportFrequencySuccess");
            return i == 0 ? 10 : i;
        } else {
            i = f.a(e.a(), null).a("Common_CGIReportFrequencyFailed");
            return i == 0 ? 100 : i;
        }
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("-->reportVia, bundle: ");
            stringBuilder.append(bundle.toString());
            com.tencent.open.a.f.a("openSDK_LOG.ReportManager", stringBuilder.toString());
            if (a("report_via", str) || z) {
                this.g.execute(new Runnable() {
                    public void run() {
                        try {
                            Bundle bundle = new Bundle();
                            bundle.putString("uin", Constants.DEFAULT_UIN);
                            bundle.putString("imei", c.b(e.a()));
                            bundle.putString("imsi", c.c(e.a()));
                            bundle.putString("android_id", c.d(e.a()));
                            bundle.putString("mac", c.a());
                            bundle.putString("platform", "1");
                            bundle.putString("os_ver", VERSION.RELEASE);
                            bundle.putString("position", j.c(e.a()));
                            bundle.putString("network", a.a(e.a()));
                            bundle.putString("language", c.b());
                            bundle.putString("resolution", c.a(e.a()));
                            bundle.putString("apn", a.b(e.a()));
                            bundle.putString("model_name", Build.MODEL);
                            bundle.putString("timezone", TimeZone.getDefault().getID());
                            bundle.putString("sdk_ver", Constants.SDK_VERSION);
                            bundle.putString("qz_ver", j.d(e.a(), Constants.PACKAGE_QZONE));
                            bundle.putString("qq_ver", j.c(e.a(), "com.tencent.mobileqq"));
                            bundle.putString("qua", j.e(e.a(), e.b()));
                            bundle.putString("packagename", e.b());
                            bundle.putString("app_ver", j.d(e.a(), e.b()));
                            if (bundle != null) {
                                bundle.putAll(bundle);
                            }
                            g.this.d.add(new b(bundle));
                            int size = g.this.d.size();
                            int a = f.a(e.a(), null).a("Agent_ReportTimeInterval");
                            if (a == 0) {
                                a = 10000;
                            }
                            if (!g.this.a("report_via", size)) {
                                if (!z) {
                                    if (!g.this.f.hasMessages(1001)) {
                                        Message obtain = Message.obtain();
                                        obtain.what = 1001;
                                        g.this.f.sendMessageDelayed(obtain, (long) a);
                                        return;
                                    }
                                    return;
                                }
                            }
                            g.this.e();
                            g.this.f.removeMessages(1001);
                        } catch (Exception e) {
                            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                        }
                    }
                });
            }
        }
    }

    public void a(String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, "", false);
    }

    public void a(String str, long j, long j2, long j3, int i, String str2, boolean z) {
        final int i2 = i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->reportCgi, command: ");
        final String str3 = str;
        stringBuilder.append(str3);
        stringBuilder.append(" | startTime: ");
        final long j4 = j;
        stringBuilder.append(j4);
        stringBuilder.append(" | reqSize:");
        final long j5 = j2;
        stringBuilder.append(j5);
        stringBuilder.append(" | rspSize: ");
        final long j6 = j3;
        stringBuilder.append(j6);
        stringBuilder.append(" | responseCode: ");
        stringBuilder.append(i2);
        stringBuilder.append(" | detail: ");
        final String str4 = str2;
        stringBuilder.append(str4);
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("");
        stringBuilder2.append(i2);
        if (a("report_cgi", stringBuilder2.toString()) || z) {
            final boolean z2 = z;
            this.h.execute(new Runnable() {
                public void run() {
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - j4;
                        Bundle bundle = new Bundle();
                        String a = a.a(e.a());
                        bundle.putString("apn", a);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str3);
                        bundle.putString("detail", str4);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("network=");
                        stringBuilder.append(a);
                        stringBuilder.append('&');
                        stringBuilder.append("sdcard=");
                        stringBuilder.append(Environment.getExternalStorageState().equals("mounted"));
                        stringBuilder.append('&');
                        stringBuilder.append("wifi=");
                        stringBuilder.append(a.e(e.a()));
                        bundle.putString("deviceInfo", stringBuilder.toString());
                        int i = 100;
                        int a2 = 100 / g.this.a(i2);
                        if (a2 <= 0) {
                            i = 1;
                        } else if (a2 <= 100) {
                            i = a2;
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(i);
                        stringBuilder2.append("");
                        bundle.putString("frequency", stringBuilder2.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(j5);
                        stringBuilder.append("");
                        bundle.putString("reqSize", stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(i2);
                        stringBuilder.append("");
                        bundle.putString("resultCode", stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(j6);
                        stringBuilder.append("");
                        bundle.putString("rspSize", stringBuilder.toString());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(elapsedRealtime);
                        stringBuilder.append("");
                        bundle.putString("timeCost", stringBuilder.toString());
                        bundle.putString("uin", Constants.DEFAULT_UIN);
                        g.this.c.add(new b(bundle));
                        int size = g.this.c.size();
                        a2 = f.a(e.a(), null).a("Agent_ReportTimeInterval");
                        if (a2 == 0) {
                            a2 = 10000;
                        }
                        if (!g.this.a("report_cgi", size)) {
                            if (!z2) {
                                if (!g.this.f.hasMessages(1000)) {
                                    Message obtain = Message.obtain();
                                    obtain.what = 1000;
                                    g.this.f.sendMessageDelayed(obtain, (long) a2);
                                    return;
                                }
                                return;
                            }
                        }
                        g.this.b();
                        g.this.f.removeMessages(1000);
                    } catch (Exception e) {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    public void a(String str, String str2, Bundle bundle, boolean z) {
        final Bundle bundle2 = bundle;
        final String str3 = str;
        final boolean z2 = z;
        final String str4 = str2;
        i.a(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00f8 A:{Catch:{ Exception -> 0x0108 }} */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00f0 A:{Catch:{ Exception -> 0x0108 }} */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00f0 A:{Catch:{ Exception -> 0x0108 }} */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00f8 A:{Catch:{ Exception -> 0x0108 }} */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00ee A:{SYNTHETIC} */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x00ee A:{SYNTHETIC} */
            /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00d5 */
            public void run() {
                /*
                r10 = this;
                r0 = r2;	 Catch:{ Exception -> 0x0108 }
                if (r0 != 0) goto L_0x000c;
            L_0x0004:
                r0 = "openSDK_LOG.ReportManager";
                r1 = "-->httpRequest, params is null!";
                com.tencent.open.a.f.e(r0, r1);	 Catch:{ Exception -> 0x0108 }
                return;
            L_0x000c:
                r0 = com.tencent.open.b.e.a();	 Catch:{ Exception -> 0x0108 }
                if (r0 != 0) goto L_0x0013;
            L_0x0012:
                r0 = 3;
            L_0x0013:
                r1 = "openSDK_LOG.ReportManager";
                r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0108 }
                r2.<init>();	 Catch:{ Exception -> 0x0108 }
                r3 = "-->httpRequest, retryCount: ";
                r2.append(r3);	 Catch:{ Exception -> 0x0108 }
                r2.append(r0);	 Catch:{ Exception -> 0x0108 }
                r2 = r2.toString();	 Catch:{ Exception -> 0x0108 }
                com.tencent.open.a.f.b(r1, r2);	 Catch:{ Exception -> 0x0108 }
                r1 = com.tencent.open.utils.e.a();	 Catch:{ Exception -> 0x0108 }
                r2 = 0;
                r3 = r3;	 Catch:{ Exception -> 0x0108 }
                r1 = com.tencent.open.utils.HttpUtils.getHttpClient(r1, r2, r3);	 Catch:{ Exception -> 0x0108 }
                r2 = r2;	 Catch:{ Exception -> 0x0108 }
                r2 = com.tencent.open.utils.HttpUtils.encodeUrl(r2);	 Catch:{ Exception -> 0x0108 }
                r3 = r4;	 Catch:{ Exception -> 0x0108 }
                if (r3 == 0) goto L_0x0042;
            L_0x003e:
                r2 = java.net.URLEncoder.encode(r2);	 Catch:{ Exception -> 0x0108 }
            L_0x0042:
                r3 = r5;	 Catch:{ Exception -> 0x0108 }
                r3 = r3.toUpperCase();	 Catch:{ Exception -> 0x0108 }
                r4 = "GET";
                r3 = r3.equals(r4);	 Catch:{ Exception -> 0x0108 }
                if (r3 == 0) goto L_0x0064;
            L_0x0050:
                r3 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0108 }
                r4 = r3;	 Catch:{ Exception -> 0x0108 }
                r3.<init>(r4);	 Catch:{ Exception -> 0x0108 }
                r3.append(r2);	 Catch:{ Exception -> 0x0108 }
                r2 = new org.apache.http.client.methods.HttpGet;	 Catch:{ Exception -> 0x0108 }
                r3 = r3.toString();	 Catch:{ Exception -> 0x0108 }
                r2.<init>(r3);	 Catch:{ Exception -> 0x0108 }
                goto L_0x0086;
            L_0x0064:
                r3 = r5;	 Catch:{ Exception -> 0x0108 }
                r3 = r3.toUpperCase();	 Catch:{ Exception -> 0x0108 }
                r4 = "POST";
                r3 = r3.equals(r4);	 Catch:{ Exception -> 0x0108 }
                if (r3 == 0) goto L_0x0100;
            L_0x0072:
                r3 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Exception -> 0x0108 }
                r4 = r3;	 Catch:{ Exception -> 0x0108 }
                r3.<init>(r4);	 Catch:{ Exception -> 0x0108 }
                r2 = com.tencent.open.utils.j.i(r2);	 Catch:{ Exception -> 0x0108 }
                r4 = new org.apache.http.entity.ByteArrayEntity;	 Catch:{ Exception -> 0x0108 }
                r4.<init>(r2);	 Catch:{ Exception -> 0x0108 }
                r3.setEntity(r4);	 Catch:{ Exception -> 0x0108 }
                r2 = r3;
            L_0x0086:
                r3 = "Accept-Encoding";
                r4 = "gzip";
                r2.addHeader(r3, r4);	 Catch:{ Exception -> 0x0108 }
                r3 = "Content-Type";
                r4 = "application/x-www-form-urlencoded";
                r2.addHeader(r3, r4);	 Catch:{ Exception -> 0x0108 }
                r3 = 0;
                r4 = r3;
            L_0x0096:
                r5 = 1;
                r3 = r3 + r5;
                r6 = r1.execute(r2);	 Catch:{ ConnectTimeoutException -> 0x00e5, SocketTimeoutException -> 0x00dd, Exception -> 0x00d5 }
                r6 = r6.getStatusLine();	 Catch:{ ConnectTimeoutException -> 0x00e5, SocketTimeoutException -> 0x00dd, Exception -> 0x00d5 }
                r6 = r6.getStatusCode();	 Catch:{ ConnectTimeoutException -> 0x00e5, SocketTimeoutException -> 0x00dd, Exception -> 0x00d5 }
                r7 = "openSDK_LOG.ReportManager";
                r8 = new java.lang.StringBuilder;	 Catch:{ ConnectTimeoutException -> 0x00e5, SocketTimeoutException -> 0x00dd, Exception -> 0x00d5 }
                r8.<init>();	 Catch:{ ConnectTimeoutException -> 0x00e5, SocketTimeoutException -> 0x00dd, Exception -> 0x00d5 }
                r9 = "-->httpRequest, statusCode: ";
                r8.append(r9);	 Catch:{ ConnectTimeoutException -> 0x00e5, SocketTimeoutException -> 0x00dd, Exception -> 0x00d5 }
                r8.append(r6);	 Catch:{ ConnectTimeoutException -> 0x00e5, SocketTimeoutException -> 0x00dd, Exception -> 0x00d5 }
                r8 = r8.toString();	 Catch:{ ConnectTimeoutException -> 0x00e5, SocketTimeoutException -> 0x00dd, Exception -> 0x00d5 }
                com.tencent.open.a.f.b(r7, r8);	 Catch:{ ConnectTimeoutException -> 0x00e5, SocketTimeoutException -> 0x00dd, Exception -> 0x00d5 }
                r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
                if (r6 == r7) goto L_0x00c6;
            L_0x00be:
                r6 = "openSDK_LOG.ReportManager";
                r7 = "-->ReportCenter httpRequest : HttpStatuscode != 200";
                com.tencent.open.a.f.b(r6, r7);	 Catch:{ ConnectTimeoutException -> 0x00e5, SocketTimeoutException -> 0x00dd, Exception -> 0x00d5 }
                goto L_0x00ee;
            L_0x00c6:
                r4 = "openSDK_LOG.ReportManager";
                r6 = "-->ReportCenter httpRequest Thread success";
                com.tencent.open.a.f.b(r4, r6);	 Catch:{ ConnectTimeoutException -> 0x00d3, SocketTimeoutException -> 0x00d1, Exception -> 0x00cf }
                r4 = r5;
                goto L_0x00ee;
            L_0x00cf:
                r4 = r5;
                goto L_0x00d5;
            L_0x00d1:
                r4 = r5;
                goto L_0x00dd;
            L_0x00d3:
                r4 = r5;
                goto L_0x00e5;
            L_0x00d5:
                r0 = "openSDK_LOG.ReportManager";
                r1 = "-->ReportCenter httpRequest Exception";
                com.tencent.open.a.f.b(r0, r1);	 Catch:{ Exception -> 0x0108 }
                goto L_0x00ee;
            L_0x00dd:
                r6 = "openSDK_LOG.ReportManager";
                r7 = "-->ReportCenter httpRequest SocketTimeoutException";
                com.tencent.open.a.f.b(r6, r7);	 Catch:{ Exception -> 0x0108 }
                goto L_0x00ec;
            L_0x00e5:
                r6 = "openSDK_LOG.ReportManager";
                r7 = "-->ReportCenter httpRequest ConnectTimeoutException";
                com.tencent.open.a.f.b(r6, r7);	 Catch:{ Exception -> 0x0108 }
            L_0x00ec:
                if (r3 < r0) goto L_0x0096;
            L_0x00ee:
                if (r4 != r5) goto L_0x00f8;
            L_0x00f0:
                r0 = "openSDK_LOG.ReportManager";
                r1 = "-->ReportCenter httpRequest Thread request success";
                com.tencent.open.a.f.b(r0, r1);	 Catch:{ Exception -> 0x0108 }
                goto L_0x010f;
            L_0x00f8:
                r0 = "openSDK_LOG.ReportManager";
                r1 = "-->ReportCenter httpRequest Thread request failed";
                com.tencent.open.a.f.b(r0, r1);	 Catch:{ Exception -> 0x0108 }
                goto L_0x010f;
            L_0x0100:
                r0 = "openSDK_LOG.ReportManager";
                r1 = "-->httpRequest unkonw request method return.";
                com.tencent.open.a.f.e(r0, r1);	 Catch:{ Exception -> 0x0108 }
                return;
            L_0x0108:
                r0 = "openSDK_LOG.ReportManager";
                r1 = "-->httpRequest, exception in serial executor.";
                com.tencent.open.a.f.b(r0, r1);
            L_0x010f:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g$AnonymousClass6.run():void");
            }
        });
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0061 A:{RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARNING: Missing block: B:3:0x0019, code skipped:
            if (r0 == 0) goto L_0x001b;
     */
    /* JADX WARNING: Missing block: B:8:0x0033, code skipped:
            if (r0 == 0) goto L_0x001b;
     */
    public boolean a(java.lang.String r6, int r7) {
        /*
        r5 = this;
        r0 = "report_cgi";
        r0 = r6.equals(r0);
        r1 = 5;
        r2 = 0;
        r3 = 0;
        if (r0 == 0) goto L_0x001d;
    L_0x000b:
        r0 = com.tencent.open.utils.e.a();
        r0 = com.tencent.open.utils.f.a(r0, r2);
        r2 = "Common_CGIReportMaxcount";
        r0 = r0.a(r2);
        if (r0 != 0) goto L_0x0037;
    L_0x001b:
        r0 = r1;
        goto L_0x0037;
    L_0x001d:
        r0 = "report_via";
        r0 = r6.equals(r0);
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r0 = com.tencent.open.utils.e.a();
        r0 = com.tencent.open.utils.f.a(r0, r2);
        r2 = "Agent_ReportBatchCount";
        r0 = r0.a(r2);
        if (r0 != 0) goto L_0x0037;
    L_0x0035:
        goto L_0x001b;
    L_0x0036:
        r0 = r3;
    L_0x0037:
        r1 = "openSDK_LOG.ReportManager";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = "-->availableCount, report: ";
        r2.append(r4);
        r2.append(r6);
        r6 = " | dataSize: ";
        r2.append(r6);
        r2.append(r7);
        r6 = " | maxcount: ";
        r2.append(r6);
        r2.append(r0);
        r6 = r2.toString();
        com.tencent.open.a.f.b(r1, r6);
        if (r7 < r0) goto L_0x0061;
    L_0x005f:
        r6 = 1;
        return r6;
    L_0x0061:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.a(java.lang.String, int):boolean");
    }

    /* Access modifiers changed, original: protected */
    /* JADX WARNING: Missing block: B:8:0x003f, code skipped:
            if (r4.b.nextInt(100) < r5) goto L_0x0057;
     */
    /* JADX WARNING: Missing block: B:14:0x0055, code skipped:
            if (r4.b.nextInt(100) < r5) goto L_0x0057;
     */
    public boolean a(java.lang.String r5, java.lang.String r6) {
        /*
        r4 = this;
        r0 = "openSDK_LOG.ReportManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "-->availableFrequency, report: ";
        r1.append(r2);
        r1.append(r5);
        r2 = " | ext: ";
        r1.append(r2);
        r1.append(r6);
        r1 = r1.toString();
        com.tencent.open.a.f.b(r0, r1);
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        if (r0 == 0) goto L_0x0026;
    L_0x0025:
        return r1;
    L_0x0026:
        r0 = "report_cgi";
        r0 = r5.equals(r0);
        r2 = 1;
        r3 = 100;
        if (r0 == 0) goto L_0x0043;
    L_0x0031:
        r5 = java.lang.Integer.parseInt(r6);	 Catch:{ Exception -> 0x0042 }
        r5 = r4.a(r5);
        r6 = r4.b;
        r6 = r6.nextInt(r3);
        if (r6 >= r5) goto L_0x005a;
    L_0x0041:
        goto L_0x0057;
    L_0x0042:
        return r1;
    L_0x0043:
        r0 = "report_via";
        r5 = r5.equals(r0);
        if (r5 == 0) goto L_0x0059;
    L_0x004b:
        r5 = com.tencent.open.b.e.a(r6);
        r6 = r4.b;
        r6 = r6.nextInt(r3);
        if (r6 >= r5) goto L_0x005a;
    L_0x0057:
        r1 = r2;
        goto L_0x005a;
    L_0x0059:
        r5 = r3;
    L_0x005a:
        r6 = "openSDK_LOG.ReportManager";
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = "-->availableFrequency, result: ";
        r0.append(r2);
        r0.append(r1);
        r2 = " | frequency: ";
        r0.append(r2);
        r0.append(r5);
        r5 = r0.toString();
        com.tencent.open.a.f.b(r6, r5);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.a(java.lang.String, java.lang.String):boolean");
    }

    /* Access modifiers changed, original: protected */
    public void b() {
        this.h.execute(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:24:0x00b3 A:{Catch:{ Exception -> 0x00c8 }} */
            public void run() {
                /*
                r10 = this;
                r0 = com.tencent.open.b.g.this;	 Catch:{ Exception -> 0x00c8 }
                r0 = r0.c();	 Catch:{ Exception -> 0x00c8 }
                if (r0 != 0) goto L_0x0009;
            L_0x0008:
                return;
            L_0x0009:
                r1 = com.tencent.open.utils.e.a();	 Catch:{ Exception -> 0x00c8 }
                r2 = 0;
                r1 = com.tencent.open.utils.f.a(r1, r2);	 Catch:{ Exception -> 0x00c8 }
                r3 = "Common_HttpRetryCount";
                r1 = r1.a(r3);	 Catch:{ Exception -> 0x00c8 }
                if (r1 != 0) goto L_0x001b;
            L_0x001a:
                r1 = 3;
            L_0x001b:
                r3 = "openSDK_LOG.ReportManager";
                r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00c8 }
                r4.<init>();	 Catch:{ Exception -> 0x00c8 }
                r5 = "-->doReportCgi, retryCount: ";
                r4.append(r5);	 Catch:{ Exception -> 0x00c8 }
                r4.append(r1);	 Catch:{ Exception -> 0x00c8 }
                r4 = r4.toString();	 Catch:{ Exception -> 0x00c8 }
                com.tencent.open.a.f.b(r3, r4);	 Catch:{ Exception -> 0x00c8 }
                r3 = 0;
                r4 = r3;
            L_0x0033:
                r5 = 1;
                r4 = r4 + r5;
                r6 = com.tencent.open.utils.e.a();	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r7 = "https://wspeed.qq.com/w.cgi";
                r6 = com.tencent.open.utils.HttpUtils.getHttpClient(r6, r2, r7);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r7 = new org.apache.http.client.methods.HttpPost;	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r8 = "https://wspeed.qq.com/w.cgi";
                r7.<init>(r8);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r8 = "Accept-Encoding";
                r9 = "gzip";
                r7.addHeader(r8, r9);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r8 = "Content-Type";
                r9 = "application/x-www-form-urlencoded";
                r7.setHeader(r8, r9);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r8 = com.tencent.open.utils.HttpUtils.encodeUrl(r0);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r8 = com.tencent.open.utils.j.i(r8);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r9 = new org.apache.http.entity.ByteArrayEntity;	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r9.<init>(r8);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r7.setEntity(r9);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r6 = r6.execute(r7);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r6 = r6.getStatusLine();	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r6 = r6.getStatusCode();	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r7 = "openSDK_LOG.ReportManager";
                r8 = new java.lang.StringBuilder;	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r8.<init>();	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r9 = "-->doReportCgi, statusCode: ";
                r8.append(r9);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r8.append(r6);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r8 = r8.toString();	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                com.tencent.open.a.f.b(r7, r8);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r7 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
                if (r6 != r7) goto L_0x00b1;
            L_0x008a:
                r6 = com.tencent.open.b.f.a();	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r7 = "report_cgi";
                r6.b(r7);	 Catch:{ ConnectTimeoutException -> 0x00a7, SocketTimeoutException -> 0x009e, Exception -> 0x0095 }
                r3 = r5;
                goto L_0x00b1;
            L_0x0095:
                r0 = move-exception;
                r1 = "openSDK_LOG.ReportManager";
                r2 = "-->doReportCgi, doupload exception";
                com.tencent.open.a.f.b(r1, r2, r0);	 Catch:{ Exception -> 0x00c8 }
                goto L_0x00b1;
            L_0x009e:
                r5 = move-exception;
                r6 = "openSDK_LOG.ReportManager";
                r7 = "-->doReportCgi, doupload exception";
                com.tencent.open.a.f.b(r6, r7, r5);	 Catch:{ Exception -> 0x00c8 }
                goto L_0x00af;
            L_0x00a7:
                r5 = move-exception;
                r6 = "openSDK_LOG.ReportManager";
                r7 = "-->doReportCgi, doupload exception";
                com.tencent.open.a.f.b(r6, r7, r5);	 Catch:{ Exception -> 0x00c8 }
            L_0x00af:
                if (r4 < r1) goto L_0x0033;
            L_0x00b1:
                if (r3 != 0) goto L_0x00c0;
            L_0x00b3:
                r0 = com.tencent.open.b.f.a();	 Catch:{ Exception -> 0x00c8 }
                r1 = "report_cgi";
                r2 = com.tencent.open.b.g.this;	 Catch:{ Exception -> 0x00c8 }
                r2 = r2.c;	 Catch:{ Exception -> 0x00c8 }
                r0.a(r1, r2);	 Catch:{ Exception -> 0x00c8 }
            L_0x00c0:
                r0 = com.tencent.open.b.g.this;	 Catch:{ Exception -> 0x00c8 }
                r0 = r0.c;	 Catch:{ Exception -> 0x00c8 }
                r0.clear();	 Catch:{ Exception -> 0x00c8 }
                goto L_0x00d0;
            L_0x00c8:
                r0 = move-exception;
                r1 = "openSDK_LOG.ReportManager";
                r2 = "-->doReportCgi, doupload exception out.";
                com.tencent.open.a.f.b(r1, r2, r0);
            L_0x00d0:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g$AnonymousClass4.run():void");
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public Bundle c() {
        if (this.c.size() == 0) {
            return null;
        }
        int i = 0;
        b bVar = (b) this.c.get(0);
        if (bVar == null) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = (String) bVar.a.get("appid");
        List a = f.a().a("report_cgi");
        if (a != null) {
            this.c.addAll(a);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->prepareCgiData, mCgiList size: ");
        stringBuilder.append(this.c.size());
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", stringBuilder.toString());
        if (this.c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", Constants.SDK_VERSION_REPORT);
            bundle.putString("device", Build.DEVICE);
            bundle.putString("qua", Constants.SDK_QUA);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            while (i < this.c.size()) {
                bVar = (b) this.c.get(i);
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_1");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("apn"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_2");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("frequency"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_3");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("commandid"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_4");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("resultCode"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_5");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("timeCost"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_6");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("reqSize"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_7");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("rspSize"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_8");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("detail"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_9");
                bundle.putString(stringBuilder.toString(), (String) bVar.a.get("uin"));
                stringBuilder = new StringBuilder();
                stringBuilder.append(c.e(e.a()));
                stringBuilder.append(HttpUtils.PARAMETERS_SEPARATOR);
                stringBuilder.append((String) bVar.a.get("deviceInfo"));
                str = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(i);
                stringBuilder.append("_10");
                bundle.putString(stringBuilder.toString(), str);
                i++;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("-->prepareCgiData, end. params: ");
            stringBuilder2.append(bundle.toString());
            com.tencent.open.a.f.a("openSDK_LOG.ReportManager", stringBuilder2.toString());
            return bundle;
        } catch (Exception e) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public Bundle d() {
        List a = f.a().a("report_via");
        if (a != null) {
            this.d.addAll(a);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-->prepareViaData, mViaList size: ");
        stringBuilder.append(this.d.size());
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", stringBuilder.toString());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.d) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) serializable;
            for (String str : bVar.a.keySet()) {
                try {
                    Object obj = (String) bVar.a.get(str);
                    if (obj == null) {
                        obj = "";
                    }
                    jSONObject.put(str, obj);
                } catch (JSONException e) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("-->prepareViaData, JSONArray array: ");
        stringBuilder2.append(jSONArray.toString());
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", stringBuilder2.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            bundle.putString("data", jSONObject2.toString());
            return bundle;
        } catch (JSONException e2) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    /* Access modifiers changed, original: protected */
    public void e() {
        this.g.execute(new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:72:0x0106 A:{Catch:{ Exception -> 0x0131 }} */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x00fc A:{Catch:{ Exception -> 0x0131 }} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00c0 */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x00fc A:{Catch:{ Exception -> 0x0131 }} */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x0106 A:{Catch:{ Exception -> 0x0131 }} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Removed duplicated region for block: B:65:? A:{SYNTHETIC, Splitter:B:8:0x0039, ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException)} */
            /* JADX WARNING: Removed duplicated region for block: B:63:? A:{SYNTHETIC, Splitter:B:8:0x0039, ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException)} */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x00c0 A:{SYNTHETIC, Splitter:B:56:0x00c0} */
            /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00c0 */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x0106 A:{Catch:{ Exception -> 0x0131 }} */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x00fc A:{Catch:{ Exception -> 0x0131 }} */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x0095 A:{Splitter:B:8:0x0039, ExcHandler: IOException (e java.io.IOException)} */
            /* JADX WARNING: Removed duplicated region for block: B:42:? A:{SYNTHETIC, Splitter:B:8:0x0039, ExcHandler: Exception (unused java.lang.Exception)} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x00c0 A:{SYNTHETIC, Splitter:B:56:0x00c0} */
            /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00c0 */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x00fc A:{Catch:{ Exception -> 0x0131 }} */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x0106 A:{Catch:{ Exception -> 0x0131 }} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Removed duplicated region for block: B:40:? A:{SYNTHETIC, Splitter:B:22:0x006f, ExcHandler: ConnectTimeoutException (unused org.apache.http.conn.ConnectTimeoutException)} */
            /* JADX WARNING: Removed duplicated region for block: B:38:? A:{SYNTHETIC, Splitter:B:22:0x006f, ExcHandler: SocketTimeoutException (unused java.net.SocketTimeoutException)} */
            /* JADX WARNING: Removed duplicated region for block: B:36:? A:{SYNTHETIC, Splitter:B:22:0x006f, ExcHandler: JSONException (unused org.json.JSONException)} */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x00c0 A:{SYNTHETIC, Splitter:B:56:0x00c0} */
            /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x00c0 */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x0106 A:{Catch:{ Exception -> 0x0131 }} */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x00fc A:{Catch:{ Exception -> 0x0131 }} */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A:{Splitter:B:22:0x006f, ExcHandler: IOException (e java.io.IOException)} */
            /* JADX WARNING: Removed duplicated region for block: B:30:? A:{SYNTHETIC, Splitter:B:22:0x006f, ExcHandler: Exception (unused java.lang.Exception)} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x00e5 A:{SYNTHETIC} */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing block: B:14:0x0058, code skipped:
            r8 = -4;
     */
            /* JADX WARNING: Missing block: B:29:0x007f, code skipped:
            r4 = r19;
     */
            /* JADX WARNING: Missing block: B:31:0x0082, code skipped:
            r0 = e;
     */
            /* JADX WARNING: Missing block: B:32:0x0084, code skipped:
            r0 = move-exception;
     */
            /* JADX WARNING: Missing block: B:33:0x0085, code skipped:
            r2 = r0;
     */
            /* JADX WARNING: Missing block: B:35:0x0089, code skipped:
            r4 = r19;
     */
            /* JADX WARNING: Missing block: B:37:0x008c, code skipped:
            r4 = r19;
     */
            /* JADX WARNING: Missing block: B:39:0x008f, code skipped:
            r4 = r19;
     */
            /* JADX WARNING: Missing block: B:41:0x0092, code skipped:
            r5 = -6;
            r6 = r3;
     */
            /* JADX WARNING: Missing block: B:43:0x0095, code skipped:
            r0 = e;
     */
            /* JADX WARNING: Missing block: B:44:0x0096, code skipped:
            r19 = r4;
     */
            /* JADX WARNING: Missing block: B:48:0x009d, code skipped:
            r5 = com.tencent.open.utils.HttpUtils.getErrorCodeFromException(r0);
            r4 = r19;
     */
            /* JADX WARNING: Missing block: B:49:0x00a1, code skipped:
            r0 = move-exception;
     */
            /* JADX WARNING: Missing block: B:50:0x00a2, code skipped:
            r18 = r5;
            r2 = r0;
     */
            /* JADX WARNING: Missing block: B:62:0x00d6, code skipped:
            r7 = android.os.SystemClock.elapsedRealtime();
            r5 = -8;
     */
            /* JADX WARNING: Missing block: B:64:0x00dc, code skipped:
            r7 = android.os.SystemClock.elapsedRealtime();
            r5 = -7;
     */
            /* JADX WARNING: Missing block: B:66:0x00e1, code skipped:
            r9 = r7;
     */
            public void run() {
                /*
                r28 = this;
                r1 = r28;
                r2 = com.tencent.open.b.g.this;	 Catch:{ Exception -> 0x0131 }
                r2 = r2.d();	 Catch:{ Exception -> 0x0131 }
                if (r2 != 0) goto L_0x000b;
            L_0x000a:
                return;
            L_0x000b:
                r3 = "openSDK_LOG.ReportManager";
                r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0131 }
                r4.<init>();	 Catch:{ Exception -> 0x0131 }
                r5 = "-->doReportVia, params: ";
                r4.append(r5);	 Catch:{ Exception -> 0x0131 }
                r5 = r2.toString();	 Catch:{ Exception -> 0x0131 }
                r4.append(r5);	 Catch:{ Exception -> 0x0131 }
                r4 = r4.toString();	 Catch:{ Exception -> 0x0131 }
                com.tencent.open.a.f.a(r3, r4);	 Catch:{ Exception -> 0x0131 }
                r3 = com.tencent.open.b.e.a();	 Catch:{ Exception -> 0x0131 }
                r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x0131 }
                r6 = 0;
                r9 = r4;
                r4 = r6;
                r5 = r4;
                r11 = 0;
                r13 = 0;
            L_0x0035:
                r15 = 1;
                r6 = r6 + r15;
                r16 = -4;
                r7 = com.tencent.open.utils.e.a();	 Catch:{ ConnectTimeoutException -> 0x00dc, SocketTimeoutException -> 0x00d6, JSONException -> 0x00cf, NetworkUnavailableException -> 0x00c0, HttpStatusException -> 0x00a1, IOException -> 0x0095, Exception -> 0x0092 }
                r8 = "https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report";
                r15 = "POST";
                r7 = com.tencent.open.utils.HttpUtils.openUrl2(r7, r8, r15, r2);	 Catch:{ ConnectTimeoutException -> 0x00dc, SocketTimeoutException -> 0x00d6, JSONException -> 0x00cf, NetworkUnavailableException -> 0x00c0, HttpStatusException -> 0x00a1, IOException -> 0x0095, Exception -> 0x0092 }
                r8 = r7.a;	 Catch:{ ConnectTimeoutException -> 0x00dc, SocketTimeoutException -> 0x00d6, JSONException -> 0x00cf, NetworkUnavailableException -> 0x00c0, HttpStatusException -> 0x00a1, IOException -> 0x0095, Exception -> 0x0092 }
                r8 = com.tencent.open.utils.j.d(r8);	 Catch:{ ConnectTimeoutException -> 0x00dc, SocketTimeoutException -> 0x00d6, JSONException -> 0x00cf, NetworkUnavailableException -> 0x00c0, HttpStatusException -> 0x00a1, IOException -> 0x0095, Exception -> 0x0092 }
                r15 = "ret";
                r8 = r8.getInt(r15);	 Catch:{ JSONException -> 0x0058, ConnectTimeoutException -> 0x00dc, SocketTimeoutException -> 0x00d6, NetworkUnavailableException -> 0x00c0, HttpStatusException -> 0x0052, IOException -> 0x0095, Exception -> 0x0092 }
                goto L_0x005a;
            L_0x0052:
                r0 = move-exception;
                r2 = r0;
                r18 = r5;
                goto L_0x00a5;
            L_0x0058:
                r8 = r16;
            L_0x005a:
                if (r8 == 0) goto L_0x006a;
            L_0x005c:
                r8 = r7.a;	 Catch:{ ConnectTimeoutException -> 0x00dc, SocketTimeoutException -> 0x00d6, JSONException -> 0x00cf, NetworkUnavailableException -> 0x00c0, HttpStatusException -> 0x0052, IOException -> 0x0095, Exception -> 0x0092 }
                r8 = android.text.TextUtils.isEmpty(r8);	 Catch:{ ConnectTimeoutException -> 0x00dc, SocketTimeoutException -> 0x00d6, JSONException -> 0x00cf, NetworkUnavailableException -> 0x00c0, HttpStatusException -> 0x0052, IOException -> 0x0095, Exception -> 0x0092 }
                if (r8 != 0) goto L_0x0065;
            L_0x0064:
                goto L_0x006a;
            L_0x0065:
                r19 = r4;
                r18 = r5;
                goto L_0x006f;
            L_0x006a:
                r6 = r3;
                r18 = r5;
                r19 = 1;
            L_0x006f:
                r4 = r7.b;	 Catch:{ ConnectTimeoutException -> 0x008f, SocketTimeoutException -> 0x008c, JSONException -> 0x0089, NetworkUnavailableException -> 0x00c0, HttpStatusException -> 0x0084, IOException -> 0x0082, Exception -> 0x007f }
                r7 = r7.c;	 Catch:{ ConnectTimeoutException -> 0x008f, SocketTimeoutException -> 0x008c, JSONException -> 0x0089, NetworkUnavailableException -> 0x00c0, HttpStatusException -> 0x007b, IOException -> 0x0082, Exception -> 0x007f }
                r11 = r4;
                r13 = r7;
                r5 = r18;
                r4 = r19;
                goto L_0x00e3;
            L_0x007b:
                r0 = move-exception;
                r2 = r0;
                r11 = r4;
                goto L_0x0086;
            L_0x007f:
                r4 = r19;
                goto L_0x0092;
            L_0x0082:
                r0 = move-exception;
                goto L_0x0098;
            L_0x0084:
                r0 = move-exception;
                r2 = r0;
            L_0x0086:
                r4 = r19;
                goto L_0x00a5;
            L_0x0089:
                r4 = r19;
                goto L_0x00cf;
            L_0x008c:
                r4 = r19;
                goto L_0x00d6;
            L_0x008f:
                r4 = r19;
                goto L_0x00dc;
            L_0x0092:
                r5 = -6;
                r6 = r3;
                goto L_0x00d1;
            L_0x0095:
                r0 = move-exception;
                r19 = r4;
            L_0x0098:
                r4 = r0;
                r4 = com.tencent.open.utils.HttpUtils.getErrorCodeFromException(r4);	 Catch:{ Exception -> 0x0131 }
                r5 = r4;
                r4 = r19;
                goto L_0x00d1;
            L_0x00a1:
                r0 = move-exception;
                r18 = r5;
                r2 = r0;
            L_0x00a5:
                r2 = r2.getMessage();	 Catch:{ Exception -> 0x00b7 }
                r3 = "http status code error:";
                r5 = "";
                r2 = r2.replace(r3, r5);	 Catch:{ Exception -> 0x00b7 }
                r5 = java.lang.Integer.parseInt(r2);	 Catch:{ Exception -> 0x00b7 }
                r18 = r5;
            L_0x00b7:
                r19 = r9;
                r21 = r11;
                r23 = r13;
                r25 = r18;
                goto L_0x00ed;
            L_0x00c0:
                r2 = com.tencent.open.b.g.this;	 Catch:{ Exception -> 0x0131 }
                r2 = r2.d;	 Catch:{ Exception -> 0x0131 }
                r2.clear();	 Catch:{ Exception -> 0x0131 }
                r2 = "openSDK_LOG.ReportManager";
                r3 = "doReportVia, NetworkUnavailableException.";
                com.tencent.open.a.f.b(r2, r3);	 Catch:{ Exception -> 0x0131 }
                return;
            L_0x00cf:
                r5 = r16;
            L_0x00d1:
                r11 = 0;
                r13 = 0;
                goto L_0x00e3;
            L_0x00d6:
                r7 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x0131 }
                r5 = -8;
                goto L_0x00e1;
            L_0x00dc:
                r7 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x0131 }
                r5 = -7;
            L_0x00e1:
                r9 = r7;
                goto L_0x00d1;
            L_0x00e3:
                if (r6 < r3) goto L_0x0035;
            L_0x00e5:
                r25 = r5;
                r19 = r9;
                r21 = r11;
                r23 = r13;
            L_0x00ed:
                r2 = com.tencent.open.b.g.this;	 Catch:{ Exception -> 0x0131 }
                r18 = "mapp_apptrace_sdk";
                r26 = 0;
                r27 = 0;
                r17 = r2;
                r17.a(r18, r19, r21, r23, r25, r26, r27);	 Catch:{ Exception -> 0x0131 }
                if (r4 == 0) goto L_0x0106;
            L_0x00fc:
                r2 = com.tencent.open.b.f.a();	 Catch:{ Exception -> 0x0131 }
                r3 = "report_via";
                r2.b(r3);	 Catch:{ Exception -> 0x0131 }
                goto L_0x0113;
            L_0x0106:
                r2 = com.tencent.open.b.f.a();	 Catch:{ Exception -> 0x0131 }
                r3 = "report_via";
                r5 = com.tencent.open.b.g.this;	 Catch:{ Exception -> 0x0131 }
                r5 = r5.d;	 Catch:{ Exception -> 0x0131 }
                r2.a(r3, r5);	 Catch:{ Exception -> 0x0131 }
            L_0x0113:
                r2 = com.tencent.open.b.g.this;	 Catch:{ Exception -> 0x0131 }
                r2 = r2.d;	 Catch:{ Exception -> 0x0131 }
                r2.clear();	 Catch:{ Exception -> 0x0131 }
                r2 = "openSDK_LOG.ReportManager";
                r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0131 }
                r3.<init>();	 Catch:{ Exception -> 0x0131 }
                r5 = "-->doReportVia, uploadSuccess: ";
                r3.append(r5);	 Catch:{ Exception -> 0x0131 }
                r3.append(r4);	 Catch:{ Exception -> 0x0131 }
                r3 = r3.toString();	 Catch:{ Exception -> 0x0131 }
                com.tencent.open.a.f.b(r2, r3);	 Catch:{ Exception -> 0x0131 }
                goto L_0x013a;
            L_0x0131:
                r0 = move-exception;
                r2 = r0;
                r3 = "openSDK_LOG.ReportManager";
                r4 = "-->doReportVia, exception in serial executor.";
                com.tencent.open.a.f.b(r3, r4, r2);
            L_0x013a:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g$AnonymousClass5.run():void");
            }
        });
    }
}
