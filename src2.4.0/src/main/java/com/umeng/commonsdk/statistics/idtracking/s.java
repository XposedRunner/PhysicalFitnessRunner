package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* compiled from: UUIDTracker */
public class s extends a {
    private static final String a = "uuid";
    private static final String e = "yosuid";
    private static final String f = "23346339";
    private Context b = null;
    private String c = null;
    private String d = null;

    public s(Context context) {
        super(a);
        this.b = context;
        this.c = null;
        this.d = null;
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{str, str2});
        } catch (Exception unused) {
            return str2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e9 A:{SYNTHETIC, Splitter:B:41:0x00e9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ee A:{SYNTHETIC, Splitter:B:45:0x00ee} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f3 A:{SYNTHETIC, Splitter:B:49:0x00f3} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010a A:{SYNTHETIC, Splitter:B:64:0x010a} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f A:{SYNTHETIC, Splitter:B:68:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0114 A:{SYNTHETIC, Splitter:B:72:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010a A:{SYNTHETIC, Splitter:B:64:0x010a} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f A:{SYNTHETIC, Splitter:B:68:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0114 A:{SYNTHETIC, Splitter:B:72:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0120 A:{SYNTHETIC, Splitter:B:82:0x0120} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f9 A:{Splitter:B:15:0x00a0, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0120 A:{SYNTHETIC, Splitter:B:82:0x0120} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010a A:{SYNTHETIC, Splitter:B:64:0x010a} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f A:{SYNTHETIC, Splitter:B:68:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0114 A:{SYNTHETIC, Splitter:B:72:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x010a A:{SYNTHETIC, Splitter:B:64:0x010a} */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f A:{SYNTHETIC, Splitter:B:68:0x010f} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0114 A:{SYNTHETIC, Splitter:B:72:0x0114} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0119  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:51:0x00f6, code skipped:
            if (r0 != null) goto L_0x0125;
     */
    /* JADX WARNING: Missing block: B:53:0x00f9, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:54:0x00fa, code skipped:
            r3 = null;
            r7 = r2;
     */
    /* JADX WARNING: Missing block: B:84:0x0123, code skipped:
            if (r0 == null) goto L_0x0128;
     */
    /* JADX WARNING: Missing block: B:86:0x0125, code skipped:
            r0.disconnect();
     */
    private java.lang.String b(java.lang.String r7) {
        /*
        r6 = this;
        r7 = "ro.yunos.openuuid";
        r0 = "";
        r7 = a(r7, r0);
        r6.d = r7;
        r7 = r6.d;
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 != 0) goto L_0x0015;
    L_0x0012:
        r7 = r6.d;
        return r7;
    L_0x0015:
        r7 = "ro.aliyun.clouduuid";
        r0 = "";
        r7 = a(r7, r0);
        r6.c = r7;
        r7 = r6.c;
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 == 0) goto L_0x0031;
    L_0x0027:
        r7 = "ro.sys.aliyun.clouduuid";
        r0 = "";
        r7 = a(r7, r0);
        r6.c = r7;
    L_0x0031:
        r7 = r6.c;
        r7 = android.text.TextUtils.isEmpty(r7);
        if (r7 != 0) goto L_0x0128;
    L_0x0039:
        r7 = 0;
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x011d, all -> 0x0103 }
        r1 = "https://cmnsguider.yunos.com:443/genDeviceToken";
        r0.<init>(r1);	 Catch:{ Exception -> 0x011d, all -> 0x0103 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x011d, all -> 0x0103 }
        r0 = (javax.net.ssl.HttpsURLConnection) r0;	 Catch:{ Exception -> 0x011d, all -> 0x0103 }
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r0.setConnectTimeout(r1);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r0.setReadTimeout(r1);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1 = "POST";
        r0.setRequestMethod(r1);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1 = 1;
        r0.setDoInput(r1);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r0.setDoOutput(r1);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1 = 0;
        r0.setUseCaches(r1);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1 = "Content-Type";
        r2 = "application/x-www-form-urlencoded";
        r0.setRequestProperty(r1, r2);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1 = new com.umeng.commonsdk.statistics.idtracking.s$1;	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1.<init>();	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r0.setHostnameVerifier(r1);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1.<init>();	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r2 = "appKey=";
        r1.append(r2);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r2 = "23338940";
        r3 = "UTF-8";
        r2 = java.net.URLEncoder.encode(r2, r3);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1.append(r2);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r2 = "&uuid=";
        r1.append(r2);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r2 = "FC1FE84794417B1BEF276234F6FB4E63";
        r3 = "UTF-8";
        r2 = java.net.URLEncoder.encode(r2, r3);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1.append(r2);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r1 = r1.toString();	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r2 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r3 = r0.getOutputStream();	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r2.<init>(r3);	 Catch:{ Exception -> 0x011e, all -> 0x00ff }
        r2.writeBytes(r1);	 Catch:{ Exception -> 0x00fd, all -> 0x00f9 }
        r2.flush();	 Catch:{ Exception -> 0x00fd, all -> 0x00f9 }
        r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x00fd, all -> 0x00f9 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r3) goto L_0x00e6;
    L_0x00ae:
        r1 = r0.getInputStream();	 Catch:{ Exception -> 0x00e6, all -> 0x00f9 }
        r3 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00e4, all -> 0x00dc }
        r4 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00e4, all -> 0x00dc }
        r4.<init>(r1);	 Catch:{ Exception -> 0x00e4, all -> 0x00dc }
        r3.<init>(r4);	 Catch:{ Exception -> 0x00e4, all -> 0x00dc }
        r7 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x00d3, all -> 0x00d5 }
        r7.<init>();	 Catch:{ Exception -> 0x00d3, all -> 0x00d5 }
    L_0x00c1:
        r4 = r3.readLine();	 Catch:{ Exception -> 0x00d3, all -> 0x00d5 }
        if (r4 == 0) goto L_0x00cb;
    L_0x00c7:
        r7.append(r4);	 Catch:{ Exception -> 0x00d3, all -> 0x00d5 }
        goto L_0x00c1;
    L_0x00cb:
        if (r7 == 0) goto L_0x00d3;
    L_0x00cd:
        r7 = r7.toString();	 Catch:{ Exception -> 0x00d3, all -> 0x00d5 }
        r6.d = r7;	 Catch:{ Exception -> 0x00d3, all -> 0x00d5 }
    L_0x00d3:
        r7 = r1;
        goto L_0x00e7;
    L_0x00d5:
        r7 = move-exception;
        r5 = r1;
        r1 = r7;
        r7 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x0108;
    L_0x00dc:
        r3 = move-exception;
        r5 = r3;
        r3 = r7;
        r7 = r2;
        r2 = r0;
        r0 = r1;
        r1 = r5;
        goto L_0x0108;
    L_0x00e4:
        r3 = r7;
        goto L_0x00d3;
    L_0x00e6:
        r3 = r7;
    L_0x00e7:
        if (r2 == 0) goto L_0x00ec;
    L_0x00e9:
        r2.close();	 Catch:{ Exception -> 0x00ec }
    L_0x00ec:
        if (r3 == 0) goto L_0x00f1;
    L_0x00ee:
        r3.close();	 Catch:{ Exception -> 0x00f1 }
    L_0x00f1:
        if (r7 == 0) goto L_0x00f6;
    L_0x00f3:
        r7.close();	 Catch:{ Exception -> 0x00f6 }
    L_0x00f6:
        if (r0 == 0) goto L_0x0128;
    L_0x00f8:
        goto L_0x0125;
    L_0x00f9:
        r1 = move-exception;
        r3 = r7;
        r7 = r2;
        goto L_0x0101;
    L_0x00fd:
        r7 = r2;
        goto L_0x011e;
    L_0x00ff:
        r1 = move-exception;
        r3 = r7;
    L_0x0101:
        r2 = r0;
        goto L_0x0107;
    L_0x0103:
        r0 = move-exception;
        r2 = r7;
        r3 = r2;
        r1 = r0;
    L_0x0107:
        r0 = r3;
    L_0x0108:
        if (r7 == 0) goto L_0x010d;
    L_0x010a:
        r7.close();	 Catch:{ Exception -> 0x010d }
    L_0x010d:
        if (r3 == 0) goto L_0x0112;
    L_0x010f:
        r3.close();	 Catch:{ Exception -> 0x0112 }
    L_0x0112:
        if (r0 == 0) goto L_0x0117;
    L_0x0114:
        r0.close();	 Catch:{ Exception -> 0x0117 }
    L_0x0117:
        if (r2 == 0) goto L_0x011c;
    L_0x0119:
        r2.disconnect();
    L_0x011c:
        throw r1;
    L_0x011d:
        r0 = r7;
    L_0x011e:
        if (r7 == 0) goto L_0x0123;
    L_0x0120:
        r7.close();	 Catch:{ Exception -> 0x0123 }
    L_0x0123:
        if (r0 == 0) goto L_0x0128;
    L_0x0125:
        r0.disconnect();
    L_0x0128:
        r7 = r6.d;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.s.b(java.lang.String):java.lang.String");
    }

    public String f() {
        try {
            if (!(TextUtils.isEmpty(a("ro.yunos.version", "")) || this.b == null)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.b);
                if (sharedPreferences != null) {
                    String string = sharedPreferences.getString(e, "");
                    if (!TextUtils.isEmpty(string)) {
                        return string;
                    }
                    this.d = b(f);
                    if (!(TextUtils.isEmpty(this.d) || this.b == null || sharedPreferences == null)) {
                        Editor edit = sharedPreferences.edit();
                        if (edit != null) {
                            edit.putString(e, this.d).commit();
                        }
                    }
                    return this.d;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
