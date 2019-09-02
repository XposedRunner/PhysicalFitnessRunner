package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import cn.jiguang.net.HttpUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;

public class g {
    private Context a;
    private String b = null;
    private HashMap<String, String> c = null;
    private String d = null;

    public g(Context context) {
        this.a = context;
    }

    private String a(Context context) {
        String str = "wifi";
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo != null && (extraInfo.trim().toLowerCase().equals("cmwap") || extraInfo.trim().toLowerCase().equals("uniwap") || extraInfo.trim().toLowerCase().equals("3gwap") || extraInfo.trim().toLowerCase().equals("ctwap"))) {
                if (extraInfo.trim().toLowerCase().equals("ctwap")) {
                    return "ctwap";
                }
                str = "cmwap";
            }
            return str;
        } catch (Exception e) {
            if (a.a) {
                e.printStackTrace();
            }
            return null;
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:92:0x0136=Splitter:B:92:0x0136, B:105:0x0166=Splitter:B:105:0x0166, B:118:0x0197=Splitter:B:118:0x0197} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fa A:{SYNTHETIC, Splitter:B:58:0x00fa} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b3 A:{Catch:{ all -> 0x0109 }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f5 A:{Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fa A:{SYNTHETIC, Splitter:B:58:0x00fa} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011d A:{Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011d A:{Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b3 A:{Catch:{ all -> 0x0109 }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f5 A:{Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fa A:{SYNTHETIC, Splitter:B:58:0x00fa} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011d A:{Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b3 A:{Catch:{ all -> 0x0109 }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f5 A:{Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }} */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fa A:{SYNTHETIC, Splitter:B:58:0x00fa} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011d A:{Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x019b A:{Catch:{ all -> 0x0131 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01bb A:{SYNTHETIC, Splitter:B:124:0x01bb} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x016a A:{Catch:{ all -> 0x0131 }} */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x018a A:{SYNTHETIC, Splitter:B:111:0x018a} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x013a A:{Catch:{ all -> 0x0131 }} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x015a A:{SYNTHETIC, Splitter:B:98:0x015a} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0221 A:{SYNTHETIC, Splitter:B:140:0x0221} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x019b A:{Catch:{ all -> 0x0131 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01bb A:{SYNTHETIC, Splitter:B:124:0x01bb} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x016a A:{Catch:{ all -> 0x0131 }} */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x018a A:{SYNTHETIC, Splitter:B:111:0x018a} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x013a A:{Catch:{ all -> 0x0131 }} */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x015a A:{SYNTHETIC, Splitter:B:98:0x015a} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01c8 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0121 A:{Splitter:B:7:0x002f, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:62:0x0102, code skipped:
            if (com.baidu.lbsapi.auth.a.a == false) goto L_0x01c6;
     */
    /* JADX WARNING: Missing block: B:63:0x0104, code skipped:
            r13.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:78:0x0121, code skipped:
            r13 = th;
     */
    /* JADX WARNING: Missing block: B:79:0x0122, code skipped:
            r3 = r6;
     */
    /* JADX WARNING: Missing block: B:80:0x0125, code skipped:
            r13 = e;
     */
    /* JADX WARNING: Missing block: B:81:0x0126, code skipped:
            r8 = -1;
     */
    /* JADX WARNING: Missing block: B:83:0x0129, code skipped:
            r13 = e;
     */
    /* JADX WARNING: Missing block: B:84:0x012a, code skipped:
            r8 = -1;
     */
    /* JADX WARNING: Missing block: B:86:0x012d, code skipped:
            r13 = e;
     */
    /* JADX WARNING: Missing block: B:87:0x012e, code skipped:
            r8 = -1;
     */
    /* JADX WARNING: Missing block: B:102:0x0161, code skipped:
            if (com.baidu.lbsapi.auth.a.a == false) goto L_0x01c6;
     */
    /* JADX WARNING: Missing block: B:115:0x0191, code skipped:
            if (com.baidu.lbsapi.auth.a.a == false) goto L_0x01c6;
     */
    /* JADX WARNING: Missing block: B:128:0x01c2, code skipped:
            if (com.baidu.lbsapi.auth.a.a == false) goto L_0x01c6;
     */
    private void a(javax.net.ssl.HttpsURLConnection r13) {
        /*
        r12 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "https Post start,url:";
        r0.append(r1);
        r1 = r12.b;
        r0.append(r1);
        r0 = r0.toString();
        com.baidu.lbsapi.auth.a.a(r0);
        r0 = r12.c;
        if (r0 != 0) goto L_0x0023;
    L_0x001a:
        r13 = "httpsPost request paramters is null.";
        r13 = com.baidu.lbsapi.auth.ErrorMessage.a(r13);
        r12.d = r13;
        return;
    L_0x0023:
        r0 = 1;
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r2 = -1;
        r3 = 0;
        r4 = 0;
        r5 = -11;
        r6 = r13.getOutputStream();	 Catch:{ MalformedURLException -> 0x0195, IOException -> 0x0164, Exception -> 0x0134 }
        r7 = new java.io.BufferedWriter;	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r8 = new java.io.OutputStreamWriter;	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r9 = "UTF-8";
        r8.<init>(r6, r9);	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r7.<init>(r8);	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r8 = r12.c;	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r8 = b(r8);	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r7.write(r8);	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r8 = r12.c;	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r8 = b(r8);	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        com.baidu.lbsapi.auth.a.a(r8);	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r7.flush();	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r7.close();	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r13.connect();	 Catch:{ MalformedURLException -> 0x012d, IOException -> 0x0129, Exception -> 0x0125, all -> 0x0121 }
        r7 = r13.getInputStream();	 Catch:{ IOException -> 0x00ac, all -> 0x00a8 }
        r8 = r13.getResponseCode();	 Catch:{ IOException -> 0x00a3, all -> 0x009d }
        if (r1 != r8) goto L_0x008c;
    L_0x0060:
        r9 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x008a, all -> 0x0088 }
        r10 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x008a, all -> 0x0088 }
        r11 = "UTF-8";
        r10.<init>(r7, r11);	 Catch:{ IOException -> 0x008a, all -> 0x0088 }
        r9.<init>(r10);	 Catch:{ IOException -> 0x008a, all -> 0x0088 }
        r3 = new java.lang.StringBuffer;	 Catch:{ IOException -> 0x0086, all -> 0x0084 }
        r3.<init>();	 Catch:{ IOException -> 0x0086, all -> 0x0084 }
    L_0x0071:
        r10 = r9.read();	 Catch:{ IOException -> 0x0086, all -> 0x0084 }
        if (r10 == r2) goto L_0x007c;
    L_0x0077:
        r10 = (char) r10;	 Catch:{ IOException -> 0x0086, all -> 0x0084 }
        r3.append(r10);	 Catch:{ IOException -> 0x0086, all -> 0x0084 }
        goto L_0x0071;
    L_0x007c:
        r3 = r3.toString();	 Catch:{ IOException -> 0x0086, all -> 0x0084 }
        r12.d = r3;	 Catch:{ IOException -> 0x0086, all -> 0x0084 }
        r3 = r9;
        goto L_0x008c;
    L_0x0084:
        r0 = move-exception;
        goto L_0x00a0;
    L_0x0086:
        r0 = move-exception;
        goto L_0x00a6;
    L_0x0088:
        r0 = move-exception;
        goto L_0x009f;
    L_0x008a:
        r0 = move-exception;
        goto L_0x00a5;
    L_0x008c:
        if (r7 == 0) goto L_0x0096;
    L_0x008e:
        if (r3 == 0) goto L_0x0096;
    L_0x0090:
        r3.close();	 Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }
        r7.close();	 Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }
    L_0x0096:
        if (r13 == 0) goto L_0x009b;
    L_0x0098:
        r13.disconnect();	 Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }
    L_0x009b:
        r4 = r0;
        goto L_0x00f8;
    L_0x009d:
        r0 = move-exception;
        r8 = r2;
    L_0x009f:
        r9 = r3;
    L_0x00a0:
        r3 = r7;
        goto L_0x010a;
    L_0x00a3:
        r0 = move-exception;
        r8 = r2;
    L_0x00a5:
        r9 = r3;
    L_0x00a6:
        r3 = r7;
        goto L_0x00af;
    L_0x00a8:
        r0 = move-exception;
        r8 = r2;
        r9 = r3;
        goto L_0x010a;
    L_0x00ac:
        r0 = move-exception;
        r8 = r2;
        r9 = r3;
    L_0x00af:
        r7 = com.baidu.lbsapi.auth.a.a;	 Catch:{ all -> 0x0109 }
        if (r7 == 0) goto L_0x00ce;
    L_0x00b3:
        r0.printStackTrace();	 Catch:{ all -> 0x0109 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0109 }
        r7.<init>();	 Catch:{ all -> 0x0109 }
        r10 = "httpsPost parse failed;";
        r7.append(r10);	 Catch:{ all -> 0x0109 }
        r10 = r0.getMessage();	 Catch:{ all -> 0x0109 }
        r7.append(r10);	 Catch:{ all -> 0x0109 }
        r7 = r7.toString();	 Catch:{ all -> 0x0109 }
        com.baidu.lbsapi.auth.a.a(r7);	 Catch:{ all -> 0x0109 }
    L_0x00ce:
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0109 }
        r7.<init>();	 Catch:{ all -> 0x0109 }
        r10 = "httpsPost failed,IOException:";
        r7.append(r10);	 Catch:{ all -> 0x0109 }
        r0 = r0.getMessage();	 Catch:{ all -> 0x0109 }
        r7.append(r0);	 Catch:{ all -> 0x0109 }
        r0 = r7.toString();	 Catch:{ all -> 0x0109 }
        r0 = com.baidu.lbsapi.auth.ErrorMessage.a(r5, r0);	 Catch:{ all -> 0x0109 }
        r12.d = r0;	 Catch:{ all -> 0x0109 }
        if (r3 == 0) goto L_0x00f3;
    L_0x00eb:
        if (r9 == 0) goto L_0x00f3;
    L_0x00ed:
        r9.close();	 Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }
        r3.close();	 Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }
    L_0x00f3:
        if (r13 == 0) goto L_0x00f8;
    L_0x00f5:
        r13.disconnect();	 Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }
    L_0x00f8:
        if (r6 == 0) goto L_0x01c6;
    L_0x00fa:
        r6.close();	 Catch:{ IOException -> 0x00ff }
        goto L_0x01c6;
    L_0x00ff:
        r13 = move-exception;
        r0 = com.baidu.lbsapi.auth.a.a;
        if (r0 == 0) goto L_0x01c6;
    L_0x0104:
        r13.printStackTrace();
        goto L_0x01c6;
    L_0x0109:
        r0 = move-exception;
    L_0x010a:
        if (r3 == 0) goto L_0x011b;
    L_0x010c:
        if (r9 == 0) goto L_0x011b;
    L_0x010e:
        r9.close();	 Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }
        r3.close();	 Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }
        goto L_0x011b;
    L_0x0115:
        r13 = move-exception;
        goto L_0x0127;
    L_0x0117:
        r13 = move-exception;
        goto L_0x012b;
    L_0x0119:
        r13 = move-exception;
        goto L_0x012f;
    L_0x011b:
        if (r13 == 0) goto L_0x0120;
    L_0x011d:
        r13.disconnect();	 Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }
    L_0x0120:
        throw r0;	 Catch:{ MalformedURLException -> 0x0119, IOException -> 0x0117, Exception -> 0x0115, all -> 0x0121 }
    L_0x0121:
        r13 = move-exception;
        r3 = r6;
        goto L_0x021f;
    L_0x0125:
        r13 = move-exception;
        r8 = r2;
    L_0x0127:
        r3 = r6;
        goto L_0x0136;
    L_0x0129:
        r13 = move-exception;
        r8 = r2;
    L_0x012b:
        r3 = r6;
        goto L_0x0166;
    L_0x012d:
        r13 = move-exception;
        r8 = r2;
    L_0x012f:
        r3 = r6;
        goto L_0x0197;
    L_0x0131:
        r13 = move-exception;
        goto L_0x021f;
    L_0x0134:
        r13 = move-exception;
        r8 = r2;
    L_0x0136:
        r0 = com.baidu.lbsapi.auth.a.a;	 Catch:{ all -> 0x0131 }
        if (r0 == 0) goto L_0x013d;
    L_0x013a:
        r13.printStackTrace();	 Catch:{ all -> 0x0131 }
    L_0x013d:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
        r0.<init>();	 Catch:{ all -> 0x0131 }
        r6 = "httpsPost failed,Exception:";
        r0.append(r6);	 Catch:{ all -> 0x0131 }
        r13 = r13.getMessage();	 Catch:{ all -> 0x0131 }
        r0.append(r13);	 Catch:{ all -> 0x0131 }
        r13 = r0.toString();	 Catch:{ all -> 0x0131 }
        r13 = com.baidu.lbsapi.auth.ErrorMessage.a(r5, r13);	 Catch:{ all -> 0x0131 }
        r12.d = r13;	 Catch:{ all -> 0x0131 }
        if (r3 == 0) goto L_0x01c6;
    L_0x015a:
        r3.close();	 Catch:{ IOException -> 0x015e }
        goto L_0x01c6;
    L_0x015e:
        r13 = move-exception;
        r0 = com.baidu.lbsapi.auth.a.a;
        if (r0 == 0) goto L_0x01c6;
    L_0x0163:
        goto L_0x0104;
    L_0x0164:
        r13 = move-exception;
        r8 = r2;
    L_0x0166:
        r0 = com.baidu.lbsapi.auth.a.a;	 Catch:{ all -> 0x0131 }
        if (r0 == 0) goto L_0x016d;
    L_0x016a:
        r13.printStackTrace();	 Catch:{ all -> 0x0131 }
    L_0x016d:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
        r0.<init>();	 Catch:{ all -> 0x0131 }
        r6 = "httpsPost failed,IOException:";
        r0.append(r6);	 Catch:{ all -> 0x0131 }
        r13 = r13.getMessage();	 Catch:{ all -> 0x0131 }
        r0.append(r13);	 Catch:{ all -> 0x0131 }
        r13 = r0.toString();	 Catch:{ all -> 0x0131 }
        r13 = com.baidu.lbsapi.auth.ErrorMessage.a(r5, r13);	 Catch:{ all -> 0x0131 }
        r12.d = r13;	 Catch:{ all -> 0x0131 }
        if (r3 == 0) goto L_0x01c6;
    L_0x018a:
        r3.close();	 Catch:{ IOException -> 0x018e }
        goto L_0x01c6;
    L_0x018e:
        r13 = move-exception;
        r0 = com.baidu.lbsapi.auth.a.a;
        if (r0 == 0) goto L_0x01c6;
    L_0x0193:
        goto L_0x0104;
    L_0x0195:
        r13 = move-exception;
        r8 = r2;
    L_0x0197:
        r0 = com.baidu.lbsapi.auth.a.a;	 Catch:{ all -> 0x0131 }
        if (r0 == 0) goto L_0x019e;
    L_0x019b:
        r13.printStackTrace();	 Catch:{ all -> 0x0131 }
    L_0x019e:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
        r0.<init>();	 Catch:{ all -> 0x0131 }
        r6 = "httpsPost failed,MalformedURLException:";
        r0.append(r6);	 Catch:{ all -> 0x0131 }
        r13 = r13.getMessage();	 Catch:{ all -> 0x0131 }
        r0.append(r13);	 Catch:{ all -> 0x0131 }
        r13 = r0.toString();	 Catch:{ all -> 0x0131 }
        r13 = com.baidu.lbsapi.auth.ErrorMessage.a(r5, r13);	 Catch:{ all -> 0x0131 }
        r12.d = r13;	 Catch:{ all -> 0x0131 }
        if (r3 == 0) goto L_0x01c6;
    L_0x01bb:
        r3.close();	 Catch:{ IOException -> 0x01bf }
        goto L_0x01c6;
    L_0x01bf:
        r13 = move-exception;
        r0 = com.baidu.lbsapi.auth.a.a;
        if (r0 == 0) goto L_0x01c6;
    L_0x01c4:
        goto L_0x0104;
    L_0x01c6:
        if (r4 == 0) goto L_0x01f6;
    L_0x01c8:
        if (r1 == r8) goto L_0x01f6;
    L_0x01ca:
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r0 = "httpsPost failed,statusCode:";
        r13.append(r0);
        r13.append(r8);
        r13 = r13.toString();
        com.baidu.lbsapi.auth.a.a(r13);
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r0 = "httpsPost failed,statusCode:";
        r13.append(r0);
        r13.append(r8);
        r13 = r13.toString();
        r13 = com.baidu.lbsapi.auth.ErrorMessage.a(r5, r13);
        r12.d = r13;
        return;
    L_0x01f6:
        r13 = r12.d;
        if (r13 != 0) goto L_0x0208;
    L_0x01fa:
        r13 = "httpsPost failed,mResult is null";
        com.baidu.lbsapi.auth.a.a(r13);
        r13 = "httpsPost failed,internal error";
        r13 = com.baidu.lbsapi.auth.ErrorMessage.a(r2, r13);
        r12.d = r13;
        return;
    L_0x0208:
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r0 = "httpsPost success end,parse result = ";
        r13.append(r0);
        r0 = r12.d;
        r13.append(r0);
        r13 = r13.toString();
        com.baidu.lbsapi.auth.a.a(r13);
        return;
    L_0x021f:
        if (r3 == 0) goto L_0x022d;
    L_0x0221:
        r3.close();	 Catch:{ IOException -> 0x0225 }
        goto L_0x022d;
    L_0x0225:
        r0 = move-exception;
        r1 = com.baidu.lbsapi.auth.a.a;
        if (r1 == 0) goto L_0x022d;
    L_0x022a:
        r0.printStackTrace();
    L_0x022d:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.g.a(javax.net.ssl.HttpsURLConnection):void");
    }

    private static String b(HashMap<String, String> hashMap) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Entry entry : hashMap.entrySet()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(HttpUtils.PARAMETERS_SEPARATOR);
            }
            stringBuilder.append(URLEncoder.encode((String) entry.getKey(), HttpUtils.ENCODING_UTF_8));
            stringBuilder.append(HttpUtils.EQUAL_SIGN);
            stringBuilder.append(URLEncoder.encode((String) entry.getValue(), HttpUtils.ENCODING_UTF_8));
        }
        return stringBuilder.toString();
    }

    private HttpsURLConnection b() {
        String str;
        try {
            URL url = new URL(this.b);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https URL: ");
            stringBuilder.append(this.b);
            a.a(stringBuilder.toString());
            String a = a(this.a);
            if (a != null) {
                if (!a.equals("")) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("checkNetwork = ");
                    stringBuilder2.append(a);
                    a.a(stringBuilder2.toString());
                    URLConnection openConnection = a.equals("cmwap") ? url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(HttpUtils.HTTP_DEFUALT_PROXY, 80))) : a.equals("ctwap") ? url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection();
                    HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                    httpsURLConnection.setHostnameVerifier(new h(this));
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setRequestMethod(Constants.HTTP_POST);
                    httpsURLConnection.setConnectTimeout(50000);
                    httpsURLConnection.setReadTimeout(50000);
                    return httpsURLConnection;
                }
            }
            a.c("Current network is not available.");
            this.d = ErrorMessage.a(-10, "Current network is not available.");
            return null;
        } catch (MalformedURLException e) {
            if (a.a) {
                e.printStackTrace();
                a.a(e.getMessage());
            }
            str = "Auth server could not be parsed as a URL.";
            this.d = ErrorMessage.a(-11, str);
            return null;
        } catch (Exception e2) {
            if (a.a) {
                e2.printStackTrace();
                a.a(e2.getMessage());
            }
            str = "Init httpsurlconnection failed.";
            this.d = ErrorMessage.a(-11, str);
            return null;
        }
    }

    private HashMap<String, String> c(HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        for (String str : hashMap.keySet()) {
            String str2 = str2.toString();
            hashMap2.put(str2, hashMap.get(str2));
        }
        return hashMap2;
    }

    /* Access modifiers changed, original: protected */
    public String a(HashMap<String, String> hashMap) {
        this.c = c(hashMap);
        this.b = (String) this.c.get(SocialConstants.PARAM_URL);
        HttpsURLConnection b = b();
        if (b == null) {
            a.c("syncConnect failed,httpsURLConnection is null");
        } else {
            a(b);
        }
        return this.d;
    }

    /* Access modifiers changed, original: protected */
    public boolean a() {
        a.a("checkNetwork start");
        boolean z = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.a.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (!activeNetworkInfo.isAvailable()) {
                    return false;
                }
                a.a("checkNetwork end");
                z = true;
            }
            return z;
        } catch (Exception e) {
            if (a.a) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
