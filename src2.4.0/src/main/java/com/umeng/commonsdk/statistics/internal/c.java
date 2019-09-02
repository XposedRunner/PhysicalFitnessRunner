package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: NetworkHelper */
public class c {
    private static boolean e;
    private String a = "10.0.0.172";
    private int b = 80;
    private Context c;
    private b d;

    public c(Context context) {
        this.c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        imprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "oversea_domain_p", "");
        imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (!TextUtils.isEmpty(b.b)) {
            if (b.b.startsWith("460") || b.b.startsWith("461")) {
                AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
            }
        }
    }

    private boolean c() {
        if (this.c.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.c.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.c.getSystemService("connectivity");
            if (!DeviceConfig.checkPermission(this.c, "android.permission.ACCESS_NETWORK_STATE") || connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                String extraInfo = activeNetworkInfo.getExtraInfo();
                return extraInfo != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"));
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.c, th);
        }
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0132  */
    public byte[] a(byte[] r7, java.lang.String r8) {
        /*
        r6 = this;
        r0 = 0;
        r1 = r6.d;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        if (r1 == 0) goto L_0x000a;
    L_0x0005:
        r1 = r6.d;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r1.onRequestStart();	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
    L_0x000a:
        r1 = r6.c();	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        if (r1 == 0) goto L_0x002c;
    L_0x0010:
        r1 = new java.net.Proxy;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r2 = java.net.Proxy.Type.HTTP;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r3 = new java.net.InetSocketAddress;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r4 = r6.a;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r5 = r6.b;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r3.<init>(r4, r5);	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r1.<init>(r2, r3);	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r2 = new java.net.URL;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r2.<init>(r8);	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r1 = r2.openConnection(r1);	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        goto L_0x0037;
    L_0x002c:
        r1 = new java.net.URL;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r1.<init>(r8);	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r1 = r1.openConnection();	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ Throwable -> 0x0122, all -> 0x011f }
    L_0x0037:
        r2 = "X-Umeng-UTC";
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x011d }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Throwable -> 0x011d }
        r1.setRequestProperty(r2, r3);	 Catch:{ Throwable -> 0x011d }
        r2 = "X-Umeng-Sdk";
        r3 = r6.c;	 Catch:{ Throwable -> 0x011d }
        r3 = com.umeng.commonsdk.statistics.internal.a.a(r3);	 Catch:{ Throwable -> 0x011d }
        r3 = r3.b();	 Catch:{ Throwable -> 0x011d }
        r1.setRequestProperty(r2, r3);	 Catch:{ Throwable -> 0x011d }
        r2 = "Msg-Type";
        r3 = "envelope/json";
        r1.setRequestProperty(r2, r3);	 Catch:{ Throwable -> 0x011d }
        r2 = "Content-Type";
        r3 = r6.c;	 Catch:{ Throwable -> 0x011d }
        r3 = com.umeng.commonsdk.statistics.internal.a.a(r3);	 Catch:{ Throwable -> 0x011d }
        r3 = r3.a();	 Catch:{ Throwable -> 0x011d }
        r1.setRequestProperty(r2, r3);	 Catch:{ Throwable -> 0x011d }
        r2 = "X-Umeng-Pro-Ver";
        r3 = "1.0.0";
        r1.setRequestProperty(r2, r3);	 Catch:{ Throwable -> 0x011d }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r1.setConnectTimeout(r2);	 Catch:{ Throwable -> 0x011d }
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r1.setReadTimeout(r2);	 Catch:{ Throwable -> 0x011d }
        r2 = "POST";
        r1.setRequestMethod(r2);	 Catch:{ Throwable -> 0x011d }
        r2 = 1;
        r1.setDoOutput(r2);	 Catch:{ Throwable -> 0x011d }
        r1.setDoInput(r2);	 Catch:{ Throwable -> 0x011d }
        r3 = 0;
        r1.setUseCaches(r3);	 Catch:{ Throwable -> 0x011d }
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x011d }
        r5 = 8;
        if (r4 >= r5) goto L_0x0097;
    L_0x0090:
        r4 = "http.keepAlive";
        r5 = "false";
        java.lang.System.setProperty(r4, r5);	 Catch:{ Throwable -> 0x011d }
    L_0x0097:
        r4 = r1.getOutputStream();	 Catch:{ Throwable -> 0x011d }
        r4.write(r7);	 Catch:{ Throwable -> 0x011d }
        r4.flush();	 Catch:{ Throwable -> 0x011d }
        r4.close();	 Catch:{ Throwable -> 0x011d }
        r7 = r6.d;	 Catch:{ Throwable -> 0x011d }
        if (r7 == 0) goto L_0x00ad;
    L_0x00a8:
        r7 = r6.d;	 Catch:{ Throwable -> 0x011d }
        r7.onRequestEnd();	 Catch:{ Throwable -> 0x011d }
    L_0x00ad:
        r7 = r1.getResponseCode();	 Catch:{ Throwable -> 0x011d }
        r4 = "Content-Type";
        r4 = r1.getHeaderField(r4);	 Catch:{ Throwable -> 0x011d }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x011d }
        if (r5 != 0) goto L_0x00c6;
    L_0x00bd:
        r5 = "application/thrift";
        r4 = r4.equalsIgnoreCase(r5);	 Catch:{ Throwable -> 0x011d }
        if (r4 == 0) goto L_0x00c6;
    L_0x00c5:
        goto L_0x00c7;
    L_0x00c6:
        r2 = r3;
    L_0x00c7:
        r3 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;	 Catch:{ Throwable -> 0x011d }
        if (r3 == 0) goto L_0x00e7;
    L_0x00cb:
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011d }
        r3.<init>();	 Catch:{ Throwable -> 0x011d }
        r4 = "status code : ";
        r3.append(r4);	 Catch:{ Throwable -> 0x011d }
        r3.append(r7);	 Catch:{ Throwable -> 0x011d }
        r4 = "; isThrifit:";
        r3.append(r4);	 Catch:{ Throwable -> 0x011d }
        r3.append(r2);	 Catch:{ Throwable -> 0x011d }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x011d }
        com.umeng.commonsdk.statistics.common.MLog.d(r3);	 Catch:{ Throwable -> 0x011d }
    L_0x00e7:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 != r3) goto L_0x0117;
    L_0x00eb:
        if (r2 == 0) goto L_0x0117;
    L_0x00ed:
        r7 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011d }
        r7.<init>();	 Catch:{ Throwable -> 0x011d }
        r2 = "Send message to ";
        r7.append(r2);	 Catch:{ Throwable -> 0x011d }
        r7.append(r8);	 Catch:{ Throwable -> 0x011d }
        r7 = r7.toString();	 Catch:{ Throwable -> 0x011d }
        com.umeng.commonsdk.statistics.common.MLog.i(r7);	 Catch:{ Throwable -> 0x011d }
        r7 = r1.getInputStream();	 Catch:{ Throwable -> 0x011d }
        r8 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r7);	 Catch:{ all -> 0x0112 }
        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r7);	 Catch:{ Throwable -> 0x011d }
        if (r1 == 0) goto L_0x0111;
    L_0x010e:
        r1.disconnect();
    L_0x0111:
        return r8;
    L_0x0112:
        r8 = move-exception;
        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r7);	 Catch:{ Throwable -> 0x011d }
        throw r8;	 Catch:{ Throwable -> 0x011d }
    L_0x0117:
        if (r1 == 0) goto L_0x011c;
    L_0x0119:
        r1.disconnect();
    L_0x011c:
        return r0;
    L_0x011d:
        r7 = move-exception;
        goto L_0x0124;
    L_0x011f:
        r7 = move-exception;
        r1 = r0;
        goto L_0x0130;
    L_0x0122:
        r7 = move-exception;
        r1 = r0;
    L_0x0124:
        r8 = "IOException,Failed to send message.";
        com.umeng.commonsdk.statistics.common.MLog.e(r8, r7);	 Catch:{ all -> 0x012f }
        if (r1 == 0) goto L_0x012e;
    L_0x012b:
        r1.disconnect();
    L_0x012e:
        return r0;
    L_0x012f:
        r7 = move-exception;
    L_0x0130:
        if (r1 == 0) goto L_0x0135;
    L_0x0132:
        r1.disconnect();
    L_0x0135:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.internal.c.a(byte[], java.lang.String):byte[]");
    }

    public byte[] a(byte[] bArr, boolean z) {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        byte[] bArr2 = null;
        for (String b : AnalyticsConstants.APPLOG_URL_LIST) {
            bArr2 = b(bArr, b);
            if (bArr2 != null) {
                if (this.d != null) {
                    this.d.onRequestSucceed(z);
                }
                return bArr2;
            }
            if (this.d != null) {
                this.d.onRequestFailed();
            }
        }
        return bArr2;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:85:0x019b=Splitter:B:85:0x019b, B:100:0x01bd=Splitter:B:100:0x01bd} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x01bd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:85:0x019b */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0182 A:{SYNTHETIC, Splitter:B:73:0x0182} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018e A:{SYNTHETIC, Splitter:B:78:0x018e} */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0182 A:{SYNTHETIC, Splitter:B:73:0x0182} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018e A:{SYNTHETIC, Splitter:B:78:0x018e} */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01e1 A:{SYNTHETIC, Splitter:B:116:0x01e1} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01ed A:{SYNTHETIC, Splitter:B:121:0x01ed} */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01e1 A:{SYNTHETIC, Splitter:B:116:0x01e1} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01ed A:{SYNTHETIC, Splitter:B:121:0x01ed} */
    public byte[] b(byte[] r9, java.lang.String r10) {
        /*
        r8 = this;
        r0 = 2;
        r1 = 0;
        r2 = r8.d;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        if (r2 == 0) goto L_0x000b;
    L_0x0006:
        r2 = r8.d;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r2.onRequestStart();	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
    L_0x000b:
        r2 = r8.c();	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        if (r2 == 0) goto L_0x002d;
    L_0x0011:
        r2 = new java.net.Proxy;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r3 = java.net.Proxy.Type.HTTP;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r4 = new java.net.InetSocketAddress;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r5 = r8.a;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r6 = r8.b;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r4.<init>(r5, r6);	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r2.<init>(r3, r4);	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r3 = new java.net.URL;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r3.<init>(r10);	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r2 = r3.openConnection(r2);	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r2 = (javax.net.ssl.HttpsURLConnection) r2;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        goto L_0x0038;
    L_0x002d:
        r2 = new java.net.URL;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r2.<init>(r10);	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r2 = r2.openConnection();	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
        r2 = (javax.net.ssl.HttpsURLConnection) r2;	 Catch:{ SSLHandshakeException -> 0x01bb, UnknownHostException -> 0x0199, Throwable -> 0x017e, all -> 0x017b }
    L_0x0038:
        r3 = e;	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r4 = 1;
        if (r3 != 0) goto L_0x0059;
    L_0x003d:
        r3 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r2.setHostnameVerifier(r3);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r3 = "TLS";
        r3 = javax.net.ssl.SSLContext.getInstance(r3);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r5 = new java.security.SecureRandom;	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r5.<init>();	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r3.init(r1, r1, r5);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r3 = r3.getSocketFactory();	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r2.setSSLSocketFactory(r3);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        e = r4;	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
    L_0x0059:
        r3 = "X-Umeng-UTC";
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r2.setRequestProperty(r3, r5);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r3 = "X-Umeng-Sdk";
        r5 = r8.c;	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r5 = com.umeng.commonsdk.statistics.internal.a.a(r5);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r5 = r5.b();	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r2.setRequestProperty(r3, r5);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r3 = "Content-Type";
        r5 = r8.c;	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r5 = com.umeng.commonsdk.statistics.internal.a.a(r5);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r5 = r5.a();	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r2.setRequestProperty(r3, r5);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r3 = "Msg-Type";
        r5 = "envelope/json";
        r2.setRequestProperty(r3, r5);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r3 = "X-Umeng-Pro-Ver";
        r5 = "1.0.0";
        r2.setRequestProperty(r3, r5);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r3 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r2.setConnectTimeout(r3);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r2.setReadTimeout(r3);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r3 = "POST";
        r2.setRequestMethod(r3);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r2.setDoOutput(r4);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r2.setDoInput(r4);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r3 = 0;
        r2.setUseCaches(r3);	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r5 = r2.getOutputStream();	 Catch:{ SSLHandshakeException -> 0x0179, UnknownHostException -> 0x0177, Throwable -> 0x0175, all -> 0x0172 }
        r5.write(r9);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r5.flush();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r2.connect();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r9 = r8.d;	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        if (r9 == 0) goto L_0x00bf;
    L_0x00ba:
        r9 = r8.d;	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r9.onRequestEnd();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
    L_0x00bf:
        r9 = r2.getResponseCode();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r6 = "Content-Type";
        r6 = r2.getHeaderField(r6);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r7 = android.text.TextUtils.isEmpty(r6);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        if (r7 != 0) goto L_0x00d8;
    L_0x00cf:
        r7 = "application/thrift";
        r6 = r6.equalsIgnoreCase(r7);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        if (r6 == 0) goto L_0x00d8;
    L_0x00d7:
        r3 = r4;
    L_0x00d8:
        r4 = com.umeng.commonsdk.statistics.AnalyticsConstants.UM_DEBUG;	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        if (r4 == 0) goto L_0x00f8;
    L_0x00dc:
        r4 = new java.lang.StringBuilder;	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r4.<init>();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r6 = "status code : ";
        r4.append(r6);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r4.append(r9);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r6 = "; isThrifit:";
        r4.append(r6);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r4.append(r3);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r4 = r4.toString();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        com.umeng.commonsdk.statistics.common.MLog.i(r4);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
    L_0x00f8:
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 != r4) goto L_0x0159;
    L_0x00fc:
        if (r3 == 0) goto L_0x0159;
    L_0x00fe:
        r3 = new java.lang.StringBuilder;	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r3.<init>();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r4 = "Send message to server. status code is: ";
        r3.append(r4);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r3.append(r9);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r3 = r3.toString();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        com.umeng.commonsdk.statistics.common.MLog.i(r3);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r3 = "MobclickRT";
        r4 = new java.lang.StringBuilder;	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r4.<init>();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r6 = "Send message to server. status code is: ";
        r4.append(r6);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r4.append(r9);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r9 = "; url = ";
        r4.append(r9);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r4.append(r10);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r9 = r4.toString();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        com.umeng.commonsdk.debug.UMRTLog.i(r3, r9);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r9 = r2.getInputStream();	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        r10 = com.umeng.commonsdk.statistics.common.HelperUtils.readStreamToByteArray(r9);	 Catch:{ all -> 0x0154 }
        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r9);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        if (r5 == 0) goto L_0x0147;
    L_0x013d:
        r5.close();	 Catch:{ Exception -> 0x0141 }
        goto L_0x0147;
    L_0x0141:
        r9 = move-exception;
        r0 = r8.c;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r0, r9);
    L_0x0147:
        if (r2 == 0) goto L_0x0153;
    L_0x0149:
        r9 = r2.getInputStream();	 Catch:{ IOException -> 0x0150 }
        r9.close();	 Catch:{ IOException -> 0x0150 }
    L_0x0150:
        r2.disconnect();
    L_0x0153:
        return r10;
    L_0x0154:
        r10 = move-exception;
        com.umeng.commonsdk.statistics.common.HelperUtils.safeClose(r9);	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
        throw r10;	 Catch:{ SSLHandshakeException -> 0x01bd, UnknownHostException -> 0x019b, Throwable -> 0x0180 }
    L_0x0159:
        if (r5 == 0) goto L_0x0165;
    L_0x015b:
        r5.close();	 Catch:{ Exception -> 0x015f }
        goto L_0x0165;
    L_0x015f:
        r9 = move-exception;
        r10 = r8.c;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r10, r9);
    L_0x0165:
        if (r2 == 0) goto L_0x0171;
    L_0x0167:
        r9 = r2.getInputStream();	 Catch:{ IOException -> 0x016e }
        r9.close();	 Catch:{ IOException -> 0x016e }
    L_0x016e:
        r2.disconnect();
    L_0x0171:
        return r1;
    L_0x0172:
        r9 = move-exception;
        goto L_0x01df;
    L_0x0175:
        r5 = r1;
        goto L_0x0180;
    L_0x0177:
        r5 = r1;
        goto L_0x019b;
    L_0x0179:
        r5 = r1;
        goto L_0x01bd;
    L_0x017b:
        r9 = move-exception;
        r2 = r1;
        goto L_0x01df;
    L_0x017e:
        r2 = r1;
        r5 = r2;
    L_0x0180:
        if (r5 == 0) goto L_0x018c;
    L_0x0182:
        r5.close();	 Catch:{ Exception -> 0x0186 }
        goto L_0x018c;
    L_0x0186:
        r9 = move-exception;
        r10 = r8.c;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r10, r9);
    L_0x018c:
        if (r2 == 0) goto L_0x0198;
    L_0x018e:
        r9 = r2.getInputStream();	 Catch:{ IOException -> 0x0195 }
        r9.close();	 Catch:{ IOException -> 0x0195 }
    L_0x0195:
        r2.disconnect();
    L_0x0198:
        return r1;
    L_0x0199:
        r2 = r1;
        r5 = r2;
    L_0x019b:
        r9 = "A_10200";
        r10 = "\\|";
        com.umeng.commonsdk.debug.UMLog.aq(r9, r0, r10);	 Catch:{ all -> 0x01dd }
        if (r5 == 0) goto L_0x01ae;
    L_0x01a4:
        r5.close();	 Catch:{ Exception -> 0x01a8 }
        goto L_0x01ae;
    L_0x01a8:
        r9 = move-exception;
        r10 = r8.c;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r10, r9);
    L_0x01ae:
        if (r2 == 0) goto L_0x01ba;
    L_0x01b0:
        r9 = r2.getInputStream();	 Catch:{ IOException -> 0x01b7 }
        r9.close();	 Catch:{ IOException -> 0x01b7 }
    L_0x01b7:
        r2.disconnect();
    L_0x01ba:
        return r1;
    L_0x01bb:
        r2 = r1;
        r5 = r2;
    L_0x01bd:
        r9 = "A_10201";
        r10 = "\\|";
        com.umeng.commonsdk.debug.UMLog.aq(r9, r0, r10);	 Catch:{ all -> 0x01dd }
        if (r5 == 0) goto L_0x01d0;
    L_0x01c6:
        r5.close();	 Catch:{ Exception -> 0x01ca }
        goto L_0x01d0;
    L_0x01ca:
        r9 = move-exception;
        r10 = r8.c;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r10, r9);
    L_0x01d0:
        if (r2 == 0) goto L_0x01dc;
    L_0x01d2:
        r9 = r2.getInputStream();	 Catch:{ IOException -> 0x01d9 }
        r9.close();	 Catch:{ IOException -> 0x01d9 }
    L_0x01d9:
        r2.disconnect();
    L_0x01dc:
        return r1;
    L_0x01dd:
        r9 = move-exception;
        r1 = r5;
    L_0x01df:
        if (r1 == 0) goto L_0x01eb;
    L_0x01e1:
        r1.close();	 Catch:{ Exception -> 0x01e5 }
        goto L_0x01eb;
    L_0x01e5:
        r10 = move-exception;
        r0 = r8.c;
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r0, r10);
    L_0x01eb:
        if (r2 == 0) goto L_0x01f7;
    L_0x01ed:
        r10 = r2.getInputStream();	 Catch:{ IOException -> 0x01f4 }
        r10.close();	 Catch:{ IOException -> 0x01f4 }
    L_0x01f4:
        r2.disconnect();
    L_0x01f7:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.internal.c.b(byte[], java.lang.String):byte[]");
    }
}
