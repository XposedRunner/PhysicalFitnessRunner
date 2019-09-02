package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: UMSLNetWorkSenderHelper */
public class e {
    private String a = "10.0.0.172";
    private int b = 80;
    private Context c;

    public e(Context context) {
        this.c = context;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.g = DataHelper.assembleStatelessURL(imprintProperty);
        }
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.h = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.g = a.h;
        if (!TextUtils.isEmpty(b.b)) {
            if (b.b.startsWith("460") || b.b.startsWith("461")) {
                a.g = a.f;
            }
        }
    }

    private boolean c() {
        if (this.c == null || this.c.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", this.c.getPackageName()) != 0) {
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

    /* JADX WARNING: Unknown top exception splitter block from list: {B:53:0x0122=Splitter:B:53:0x0122, B:42:0x010f=Splitter:B:42:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0137 A:{SYNTHETIC, Splitter:B:65:0x0137} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013c A:{SYNTHETIC, Splitter:B:69:0x013c} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0129 A:{SYNTHETIC, Splitter:B:56:0x0129} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012e A:{SYNTHETIC, Splitter:B:60:0x012e} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0116 A:{SYNTHETIC, Splitter:B:45:0x0116} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011b A:{SYNTHETIC, Splitter:B:49:0x011b} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0137 A:{SYNTHETIC, Splitter:B:65:0x0137} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x013c A:{SYNTHETIC, Splitter:B:69:0x013c} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0129 A:{SYNTHETIC, Splitter:B:56:0x0129} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012e A:{SYNTHETIC, Splitter:B:60:0x012e} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0116 A:{SYNTHETIC, Splitter:B:45:0x0116} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011b A:{SYNTHETIC, Splitter:B:49:0x011b} */
    public boolean a(byte[] r9, java.lang.String r10) {
        /*
        r8 = this;
        r0 = 1;
        r1 = 0;
        if (r9 == 0) goto L_0x0147;
    L_0x0004:
        if (r10 != 0) goto L_0x0008;
    L_0x0006:
        goto L_0x0147;
    L_0x0008:
        r2 = com.umeng.commonsdk.statistics.SdkVersion.SDK_TYPE;
        if (r2 != 0) goto L_0x0010;
    L_0x000c:
        r8.a();
        goto L_0x0017;
    L_0x0010:
        r2 = com.umeng.commonsdk.stateless.a.h;
        com.umeng.commonsdk.stateless.a.f = r2;
        r8.b();
    L_0x0017:
        r2 = 0;
        r3 = r8.c();	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        if (r3 == 0) goto L_0x0050;
    L_0x001e:
        r3 = new java.net.Proxy;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r4 = java.net.Proxy.Type.HTTP;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r5 = new java.net.InetSocketAddress;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r6 = r8.a;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r7 = r8.b;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r5.<init>(r6, r7);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r3.<init>(r4, r5);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r4 = new java.net.URL;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r5 = new java.lang.StringBuilder;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r5.<init>();	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r6 = com.umeng.commonsdk.stateless.a.g;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r5.append(r6);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r6 = "/";
        r5.append(r6);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r5.append(r10);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r5 = r5.toString();	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r4.<init>(r5);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r3 = r4.openConnection(r3);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r3 = (javax.net.ssl.HttpsURLConnection) r3;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        goto L_0x0071;
    L_0x0050:
        r3 = new java.net.URL;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r4 = new java.lang.StringBuilder;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r4.<init>();	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r5 = com.umeng.commonsdk.stateless.a.g;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r4.append(r5);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r5 = "/";
        r4.append(r5);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r4.append(r10);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r4 = r4.toString();	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r3.<init>(r4);	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r3 = r3.openConnection();	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
        r3 = (javax.net.ssl.HttpsURLConnection) r3;	 Catch:{ SSLHandshakeException -> 0x0120, Throwable -> 0x010d, all -> 0x010a }
    L_0x0071:
        r4 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r3.setHostnameVerifier(r4);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r4 = "TLS";
        r4 = javax.net.ssl.SSLContext.getInstance(r4);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r5 = new java.security.SecureRandom;	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r5.<init>();	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r4.init(r2, r2, r5);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r4 = r4.getSocketFactory();	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r3.setSSLSocketFactory(r4);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r4 = "X-Umeng-UTC";
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r5 = java.lang.String.valueOf(r5);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r3.setRequestProperty(r4, r5);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r4 = "Msg-Type";
        r5 = "envelope/json";
        r3.setRequestProperty(r4, r5);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r3.setConnectTimeout(r4);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r3.setReadTimeout(r4);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r4 = "POST";
        r3.setRequestMethod(r4);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r3.setDoOutput(r0);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r3.setDoInput(r0);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r3.setUseCaches(r1);	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r4 = r3.getOutputStream();	 Catch:{ SSLHandshakeException -> 0x0108, Throwable -> 0x0106 }
        r4.write(r9);	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r4.flush();	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r3.connect();	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r9 = r3.getResponseCode();	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 != r2) goto L_0x00eb;
    L_0x00ca:
        r9 = "MobclickRT";
        r2 = new java.lang.StringBuilder;	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r2.<init>();	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r5 = "--->>> send stateless message success : ";
        r2.append(r5);	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r5 = com.umeng.commonsdk.stateless.a.g;	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r2.append(r5);	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r5 = "/";
        r2.append(r5);	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r2.append(r10);	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r10 = r2.toString();	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        com.umeng.commonsdk.debug.UMRTLog.i(r9, r10);	 Catch:{ SSLHandshakeException -> 0x0103, Throwable -> 0x0100, all -> 0x00fd }
        r1 = r0;
    L_0x00eb:
        if (r4 == 0) goto L_0x00f0;
    L_0x00ed:
        r4.close();	 Catch:{ Exception -> 0x00f0 }
    L_0x00f0:
        if (r3 == 0) goto L_0x0133;
    L_0x00f2:
        r9 = r3.getInputStream();	 Catch:{ IOException -> 0x00f9 }
    L_0x00f6:
        r9.close();	 Catch:{ IOException -> 0x00f9 }
    L_0x00f9:
        r3.disconnect();
        goto L_0x0133;
    L_0x00fd:
        r9 = move-exception;
        r2 = r4;
        goto L_0x0135;
    L_0x0100:
        r9 = move-exception;
        r2 = r4;
        goto L_0x010f;
    L_0x0103:
        r9 = move-exception;
        r2 = r4;
        goto L_0x0122;
    L_0x0106:
        r9 = move-exception;
        goto L_0x010f;
    L_0x0108:
        r9 = move-exception;
        goto L_0x0122;
    L_0x010a:
        r9 = move-exception;
        r3 = r2;
        goto L_0x0135;
    L_0x010d:
        r9 = move-exception;
        r3 = r2;
    L_0x010f:
        r10 = "Exception,Failed to send message.";
        com.umeng.commonsdk.statistics.common.MLog.e(r10, r9);	 Catch:{ all -> 0x0134 }
        if (r2 == 0) goto L_0x0119;
    L_0x0116:
        r2.close();	 Catch:{ Exception -> 0x0119 }
    L_0x0119:
        if (r3 == 0) goto L_0x0133;
    L_0x011b:
        r9 = r3.getInputStream();	 Catch:{ IOException -> 0x00f9 }
        goto L_0x00f6;
    L_0x0120:
        r9 = move-exception;
        r3 = r2;
    L_0x0122:
        r10 = "SSLHandshakeException, Failed to send message.";
        com.umeng.commonsdk.statistics.common.MLog.e(r10, r9);	 Catch:{ all -> 0x0134 }
        if (r2 == 0) goto L_0x012c;
    L_0x0129:
        r2.close();	 Catch:{ Exception -> 0x012c }
    L_0x012c:
        if (r3 == 0) goto L_0x0133;
    L_0x012e:
        r9 = r3.getInputStream();	 Catch:{ IOException -> 0x00f9 }
        goto L_0x00f6;
    L_0x0133:
        return r1;
    L_0x0134:
        r9 = move-exception;
    L_0x0135:
        if (r2 == 0) goto L_0x013a;
    L_0x0137:
        r2.close();	 Catch:{ Exception -> 0x013a }
    L_0x013a:
        if (r3 == 0) goto L_0x0146;
    L_0x013c:
        r10 = r3.getInputStream();	 Catch:{ IOException -> 0x0143 }
        r10.close();	 Catch:{ IOException -> 0x0143 }
    L_0x0143:
        r3.disconnect();
    L_0x0146:
        throw r9;
    L_0x0147:
        r9 = "walle";
        r10 = new java.lang.Object[r0];
        r0 = "[stateless] sendMessage, envelopeByte == null || path == null ";
        r10[r1] = r0;
        com.umeng.commonsdk.statistics.common.ULog.i(r9, r10);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.e.a(byte[], java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1 A:{SYNTHETIC, Splitter:B:34:0x00c1} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb A:{SYNTHETIC, Splitter:B:41:0x00cb} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c1 A:{SYNTHETIC, Splitter:B:34:0x00c1} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb A:{SYNTHETIC, Splitter:B:41:0x00cb} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d0  */
    /* JADX WARNING: Missing block: B:19:0x00a7, code skipped:
            if (r9 == null) goto L_0x00c7;
     */
    /* JADX WARNING: Missing block: B:21:0x00a9, code skipped:
            r9.disconnect();
     */
    /* JADX WARNING: Missing block: B:36:0x00c4, code skipped:
            if (r9 == null) goto L_0x00c7;
     */
    /* JADX WARNING: Missing block: B:38:0x00c7, code skipped:
            return r0;
     */
    public boolean b(byte[] r8, java.lang.String r9) {
        /*
        r7 = this;
        r0 = 0;
        if (r8 == 0) goto L_0x00d4;
    L_0x0003:
        if (r9 != 0) goto L_0x0007;
    L_0x0005:
        goto L_0x00d4;
    L_0x0007:
        r1 = 0;
        r2 = r7.c();	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        if (r2 == 0) goto L_0x0040;
    L_0x000e:
        r2 = new java.net.Proxy;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r3 = java.net.Proxy.Type.HTTP;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r4 = new java.net.InetSocketAddress;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r5 = r7.a;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r6 = r7.b;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r4.<init>(r5, r6);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r2.<init>(r3, r4);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r3 = new java.net.URL;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r4.<init>();	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r5 = com.umeng.commonsdk.stateless.a.g;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r4.append(r5);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r5 = "/";
        r4.append(r5);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r4.append(r9);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r9 = r4.toString();	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r3.<init>(r9);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r9 = r3.openConnection(r2);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r9 = (java.net.HttpURLConnection) r9;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        goto L_0x0061;
    L_0x0040:
        r2 = new java.net.URL;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r3.<init>();	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r4 = com.umeng.commonsdk.stateless.a.g;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r3.append(r4);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r4 = "/";
        r3.append(r4);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r3.append(r9);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r9 = r3.toString();	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r2.<init>(r9);	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r9 = r2.openConnection();	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
        r9 = (java.net.HttpURLConnection) r9;	 Catch:{ Throwable -> 0x00b8, all -> 0x00b5 }
    L_0x0061:
        r2 = "X-Umeng-UTC";
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00b3 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Throwable -> 0x00b3 }
        r9.setRequestProperty(r2, r3);	 Catch:{ Throwable -> 0x00b3 }
        r2 = "Msg-Type";
        r3 = "envelope/json";
        r9.setRequestProperty(r2, r3);	 Catch:{ Throwable -> 0x00b3 }
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r9.setConnectTimeout(r2);	 Catch:{ Throwable -> 0x00b3 }
        r9.setReadTimeout(r2);	 Catch:{ Throwable -> 0x00b3 }
        r2 = "POST";
        r9.setRequestMethod(r2);	 Catch:{ Throwable -> 0x00b3 }
        r2 = 1;
        r9.setDoOutput(r2);	 Catch:{ Throwable -> 0x00b3 }
        r9.setDoInput(r2);	 Catch:{ Throwable -> 0x00b3 }
        r9.setUseCaches(r0);	 Catch:{ Throwable -> 0x00b3 }
        r3 = r9.getOutputStream();	 Catch:{ Throwable -> 0x00b3 }
        r3.write(r8);	 Catch:{ Throwable -> 0x00b0, all -> 0x00ad }
        r3.flush();	 Catch:{ Throwable -> 0x00b0, all -> 0x00ad }
        r9.connect();	 Catch:{ Throwable -> 0x00b0, all -> 0x00ad }
        r8 = r9.getResponseCode();	 Catch:{ Throwable -> 0x00b0, all -> 0x00ad }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r8 != r1) goto L_0x00a2;
    L_0x00a1:
        r0 = r2;
    L_0x00a2:
        if (r3 == 0) goto L_0x00a7;
    L_0x00a4:
        r3.close();	 Catch:{ Exception -> 0x00a7 }
    L_0x00a7:
        if (r9 == 0) goto L_0x00c7;
    L_0x00a9:
        r9.disconnect();
        goto L_0x00c7;
    L_0x00ad:
        r8 = move-exception;
        r1 = r3;
        goto L_0x00c9;
    L_0x00b0:
        r8 = move-exception;
        r1 = r3;
        goto L_0x00ba;
    L_0x00b3:
        r8 = move-exception;
        goto L_0x00ba;
    L_0x00b5:
        r8 = move-exception;
        r9 = r1;
        goto L_0x00c9;
    L_0x00b8:
        r8 = move-exception;
        r9 = r1;
    L_0x00ba:
        r2 = r7.c;	 Catch:{ all -> 0x00c8 }
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r2, r8);	 Catch:{ all -> 0x00c8 }
        if (r1 == 0) goto L_0x00c4;
    L_0x00c1:
        r1.close();	 Catch:{ Exception -> 0x00c4 }
    L_0x00c4:
        if (r9 == 0) goto L_0x00c7;
    L_0x00c6:
        goto L_0x00a9;
    L_0x00c7:
        return r0;
    L_0x00c8:
        r8 = move-exception;
    L_0x00c9:
        if (r1 == 0) goto L_0x00ce;
    L_0x00cb:
        r1.close();	 Catch:{ Exception -> 0x00ce }
    L_0x00ce:
        if (r9 == 0) goto L_0x00d3;
    L_0x00d0:
        r9.disconnect();
    L_0x00d3:
        throw r8;
    L_0x00d4:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.e.b(byte[], java.lang.String):boolean");
    }
}
