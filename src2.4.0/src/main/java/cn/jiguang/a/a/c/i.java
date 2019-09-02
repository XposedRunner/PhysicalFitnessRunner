package cn.jiguang.a.a.c;

import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import cn.jiguang.d.d.x;
import cn.jiguang.d.h.f;
import cn.jiguang.g.a;
import com.sina.weibo.sdk.web.WebPicUploadResult;
import com.umeng.commonsdk.framework.c;
import java.io.File;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends Thread {
    private static ExecutorService a = Executors.newSingleThreadExecutor();
    private static final Object b = new Object();
    private static AtomicInteger c = new AtomicInteger();
    private static CookieManager j;
    private String d;
    private String e;
    private String f;
    private Context g;
    private int h = 0;
    private String i;

    private i() {
    }

    private i(Context context) {
        String d = a.d(context, this.d);
        String c = a.c(context, this.e);
        String e = a.e(context, this.f);
        CookieManager cookieManager = new CookieManager();
        j = cookieManager;
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(j);
        this.g = context;
        this.d = d;
        this.e = c;
        this.f = e;
    }

    public static int a(String str) {
        int i = -1;
        if (cn.jiguang.g.i.a(str)) {
            return -1;
        }
        if (str.equalsIgnoreCase("ChinaTelecom")) {
            return 2;
        }
        if (str.equalsIgnoreCase("ChinaMobile")) {
            return 0;
        }
        if (str.equalsIgnoreCase("ChinaUnicom")) {
            i = 1;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:198:0x02bb A:{SYNTHETIC, Splitter:B:198:0x02bb} */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02a4 A:{SYNTHETIC, Splitter:B:189:0x02a4} */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x028d A:{SYNTHETIC, Splitter:B:180:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0273 A:{SYNTHETIC, Splitter:B:169:0x0273} */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02bb A:{SYNTHETIC, Splitter:B:198:0x02bb} */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02a4 A:{SYNTHETIC, Splitter:B:189:0x02a4} */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x028d A:{SYNTHETIC, Splitter:B:180:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0249 A:{Splitter:B:13:0x003b, ExcHandler: all (r0_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02bb A:{SYNTHETIC, Splitter:B:198:0x02bb} */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02a4 A:{SYNTHETIC, Splitter:B:189:0x02a4} */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x028d A:{SYNTHETIC, Splitter:B:180:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0249 A:{Splitter:B:13:0x003b, ExcHandler: all (r0_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02a4 A:{SYNTHETIC, Splitter:B:189:0x02a4} */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x028d A:{SYNTHETIC, Splitter:B:180:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0249 A:{Splitter:B:13:0x003b, ExcHandler: all (r0_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02bb A:{SYNTHETIC, Splitter:B:198:0x02bb} */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02a4 A:{SYNTHETIC, Splitter:B:189:0x02a4} */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x028d A:{SYNTHETIC, Splitter:B:180:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0249 A:{Splitter:B:13:0x003b, ExcHandler: all (r0_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02bb A:{SYNTHETIC, Splitter:B:198:0x02bb} */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02a4 A:{SYNTHETIC, Splitter:B:189:0x02a4} */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x028d A:{SYNTHETIC, Splitter:B:180:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0273 A:{SYNTHETIC, Splitter:B:169:0x0273} */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02bb A:{SYNTHETIC, Splitter:B:198:0x02bb} */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02a4 A:{SYNTHETIC, Splitter:B:189:0x02a4} */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x028d A:{SYNTHETIC, Splitter:B:180:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0249 A:{Splitter:B:13:0x003b, ExcHandler: all (r0_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02a4 A:{SYNTHETIC, Splitter:B:189:0x02a4} */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x028d A:{SYNTHETIC, Splitter:B:180:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0249 A:{Splitter:B:13:0x003b, ExcHandler: all (r0_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02bb A:{SYNTHETIC, Splitter:B:198:0x02bb} */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x02a4 A:{SYNTHETIC, Splitter:B:189:0x02a4} */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x028d A:{SYNTHETIC, Splitter:B:180:0x028d} */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x022e A:{Splitter:B:84:0x01bd, ExcHandler: all (r0_1 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x02bb A:{SYNTHETIC, Splitter:B:198:0x02bb} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:21:0x0086, code skipped:
            r17 = r14;
     */
    /* JADX WARNING: Missing block: B:27:0x008e, code skipped:
            r17 = r14;
     */
    /* JADX WARNING: Missing block: B:33:0x0096, code skipped:
            r17 = r14;
     */
    /* JADX WARNING: Missing block: B:126:0x021f, code skipped:
            r13 = r8;
            r17 = r14;
     */
    /* JADX WARNING: Missing block: B:128:0x0224, code skipped:
            r13 = r8;
            r17 = r14;
     */
    /* JADX WARNING: Missing block: B:130:0x0229, code skipped:
            r13 = r8;
            r17 = r14;
     */
    /* JADX WARNING: Missing block: B:132:0x022e, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:133:0x022f, code skipped:
            r1 = r0;
            r13 = r8;
     */
    /* JADX WARNING: Missing block: B:145:0x0245, code skipped:
            if (r11 == null) goto L_0x02c8;
     */
    /* JADX WARNING: Missing block: B:146:0x0249, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:147:0x024a, code skipped:
            r1 = r0;
     */
    /* JADX WARNING: Missing block: B:148:0x024c, code skipped:
            r9 = r36;
            r27 = r8;
            r17 = r14;
     */
    /* JADX WARNING: Missing block: B:154:0x0257, code skipped:
            r9 = r36;
            r27 = r8;
            r17 = r14;
     */
    /* JADX WARNING: Missing block: B:160:0x0262, code skipped:
            r9 = r36;
            r27 = r8;
            r17 = r14;
     */
    /* JADX WARNING: Missing block: B:170:?, code skipped:
            r13.close();
     */
    /* JADX WARNING: Missing block: B:171:0x0277, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:172:0x0278, code skipped:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:174:0x027d, code skipped:
            r11.disconnect();
     */
    /* JADX WARNING: Missing block: B:181:?, code skipped:
            r13.close();
     */
    /* JADX WARNING: Missing block: B:182:0x0291, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:183:0x0292, code skipped:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:184:0x0295, code skipped:
            if (r11 != null) goto L_0x02c5;
     */
    /* JADX WARNING: Missing block: B:190:?, code skipped:
            r13.close();
     */
    /* JADX WARNING: Missing block: B:191:0x02a8, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:192:0x02a9, code skipped:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:193:0x02ac, code skipped:
            if (r11 != null) goto L_0x02c5;
     */
    /* JADX WARNING: Missing block: B:199:?, code skipped:
            r13.close();
     */
    /* JADX WARNING: Missing block: B:200:0x02bf, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:201:0x02c0, code skipped:
            r0.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:202:0x02c3, code skipped:
            if (r11 == null) goto L_0x02c8;
     */
    /* JADX WARNING: Missing block: B:203:0x02c5, code skipped:
            r11.disconnect();
     */
    /* JADX WARNING: Missing block: B:204:0x02c8, code skipped:
            r16 = r11;
            r14 = r17;
     */
    /* JADX WARNING: Missing block: B:205:0x02ce, code skipped:
            if (r15 == 404) goto L_0x02f4;
     */
    /* JADX WARNING: Missing block: B:207:0x02d2, code skipped:
            if (r15 == 200) goto L_0x02db;
     */
    /* JADX WARNING: Missing block: B:209:0x02d8, code skipped:
            if (cn.jiguang.g.a.d(r31) != false) goto L_0x02db;
     */
    /* JADX WARNING: Missing block: B:211:0x02dc, code skipped:
            if (r12 < 3) goto L_0x02e7;
     */
    /* JADX WARNING: Missing block: B:213:0x02e6, code skipped:
            return new cn.jiguang.a.a.c.j(-1, r14, "<<failed_with_retries>>");
     */
    /* JADX WARNING: Missing block: B:214:0x02e7, code skipped:
            r12 = r12 + 1;
     */
    /* JADX WARNING: Missing block: B:216:?, code skipped:
            java.lang.Thread.sleep(r2);
     */
    private cn.jiguang.a.a.c.j a(android.content.Context r31, java.lang.String r32, int r33, long r34, boolean r36, java.io.File r37, java.lang.String r38) {
        /*
        r30 = this;
        r4 = r37;
        r5 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r7 = (r34 > r5 ? 1 : (r34 == r5 ? 0 : -1));
        if (r7 < 0) goto L_0x0013;
    L_0x0008:
        r5 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r7 = (r34 > r5 ? 1 : (r34 == r5 ? 0 : -1));
        if (r7 <= 0) goto L_0x0010;
    L_0x000f:
        goto L_0x0013;
    L_0x0010:
        r2 = r34;
        goto L_0x0015;
    L_0x0013:
        r2 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
    L_0x0015:
        r5 = java.util.UUID.randomUUID();
        r5 = r5.toString();
        r6 = "--";
        r7 = "\r\n";
        r8 = "multipart/form-data";
        r9 = j;
        if (r9 != 0) goto L_0x002e;
    L_0x0027:
        r9 = new java.net.CookieManager;
        r9.<init>();
        j = r9;
    L_0x002e:
        r10 = 0;
        r12 = r10;
        r13 = 0;
        r14 = 0;
        r15 = -1;
        r16 = 0;
    L_0x0035:
        r11 = cn.jiguang.net.HttpUtils.getHttpURLConnectionWithProxy(r31, r32);	 Catch:{ SSLPeerUnverifiedException -> 0x02af, Exception -> 0x0298, AssertionError -> 0x0281, all -> 0x026d }
        r9 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r11.setConnectTimeout(r9);	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r11.setReadTimeout(r9);	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r9 = 1;
        r11.setDoInput(r9);	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r11.setDoOutput(r9);	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r11.setUseCaches(r10);	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r9 = "POST";
        r11.setRequestMethod(r9);	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r9 = "Charset";
        r10 = "UTF-8";
        r11.setRequestProperty(r9, r10);	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r9 = "User-Agent";
        r10 = "Mozilla/5.0 (Linux; Android 5.1.1; Nexus 6 Build/LYZ28E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.23 Mobile Safari/537.36";
        r11.addRequestProperty(r9, r10);	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r9 = j;	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r9 = r9.getCookieStore();	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r9 = r9.getCookies();	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        r9 = r9.size();	 Catch:{ SSLPeerUnverifiedException -> 0x0262, Exception -> 0x0257, AssertionError -> 0x024c, all -> 0x0249 }
        if (r9 <= 0) goto L_0x009e;
    L_0x006e:
        r9 = "Cookie";
        r10 = ";";
        r17 = r14;
        r14 = j;	 Catch:{ SSLPeerUnverifiedException -> 0x0098, Exception -> 0x0090, AssertionError -> 0x0088, all -> 0x0249 }
        r14 = r14.getCookieStore();	 Catch:{ SSLPeerUnverifiedException -> 0x0098, Exception -> 0x0090, AssertionError -> 0x0088, all -> 0x0249 }
        r14 = r14.getCookies();	 Catch:{ SSLPeerUnverifiedException -> 0x0098, Exception -> 0x0090, AssertionError -> 0x0088, all -> 0x0249 }
        r10 = android.text.TextUtils.join(r10, r14);	 Catch:{ SSLPeerUnverifiedException -> 0x0098, Exception -> 0x0090, AssertionError -> 0x0088, all -> 0x0249 }
        r11.setRequestProperty(r9, r10);	 Catch:{ SSLPeerUnverifiedException -> 0x0098, Exception -> 0x0090, AssertionError -> 0x0088, all -> 0x0249 }
        goto L_0x00a0;
    L_0x0086:
        r17 = r14;
    L_0x0088:
        r9 = r36;
    L_0x008a:
        r27 = r8;
        goto L_0x0252;
    L_0x008e:
        r17 = r14;
    L_0x0090:
        r9 = r36;
    L_0x0092:
        r27 = r8;
        goto L_0x025d;
    L_0x0096:
        r17 = r14;
    L_0x0098:
        r9 = r36;
    L_0x009a:
        r27 = r8;
        goto L_0x0268;
    L_0x009e:
        r17 = r14;
    L_0x00a0:
        r9 = r36;
        r11.setInstanceFollowRedirects(r9);	 Catch:{ SSLPeerUnverifiedException -> 0x009a, Exception -> 0x0092, AssertionError -> 0x008a, all -> 0x0249 }
        if (r4 == 0) goto L_0x0166;
    L_0x00a7:
        r10 = "Content-Type";
        r14 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x009a, Exception -> 0x0092, AssertionError -> 0x008a, all -> 0x0249 }
        r14.<init>();	 Catch:{ SSLPeerUnverifiedException -> 0x009a, Exception -> 0x0092, AssertionError -> 0x008a, all -> 0x0249 }
        r14.append(r8);	 Catch:{ SSLPeerUnverifiedException -> 0x009a, Exception -> 0x0092, AssertionError -> 0x008a, all -> 0x0249 }
        r27 = r8;
        r8 = ";boundary=";
        r14.append(r8);	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r14.append(r5);	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r8 = r14.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r11.setRequestProperty(r10, r8);	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r8 = r11.getOutputStream();	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r10 = new java.io.DataOutputStream;	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r10.<init>(r8);	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r8 = new java.lang.StringBuffer;	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r8.<init>();	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r8.append(r6);	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r8.append(r5);	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r8.append(r7);	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r14 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x0268, Exception -> 0x025d, AssertionError -> 0x0252, all -> 0x0249 }
        r28 = r15;
        r15 = "Content-Disposition: form-data; name=\"";
        r14.<init>(r15);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r15 = r38;
        r14.append(r15);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r15 = "\"; filename=\"";
        r14.append(r15);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r15 = r37.getName();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r14.append(r15);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r15 = "\"";
        r14.append(r15);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r14.append(r7);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r14 = r14.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8.append(r14);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r14 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r15 = "Content-Type: application/octet-stream; charset=UTF-8";
        r14.<init>(r15);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r14.append(r7);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r14 = r14.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8.append(r14);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8.append(r7);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8 = r8.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8 = r8.getBytes();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r10.write(r8);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8 = new java.io.FileInputStream;	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8.<init>(r4);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r14 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r14 = new byte[r14];	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
    L_0x012a:
        r15 = r8.read(r14);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r4 = -1;
        if (r15 == r4) goto L_0x0138;
    L_0x0131:
        r4 = 0;
        r10.write(r14, r4, r15);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r4 = r37;
        goto L_0x012a;
    L_0x0138:
        r4 = 0;
        r8.close();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8 = r7.getBytes();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r10.write(r8);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8 = new java.lang.StringBuilder;	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8.<init>();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8.append(r6);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8.append(r5);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8.append(r6);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8.append(r7);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8 = r8.toString();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8 = r8.getBytes();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r10.write(r8);	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r10.flush();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r10.close();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        goto L_0x016b;
    L_0x0166:
        r27 = r8;
        r28 = r15;
        r4 = 0;
    L_0x016b:
        r15 = r11.getResponseCode();	 Catch:{ SSLPeerUnverifiedException -> 0x026a, Exception -> 0x025f, AssertionError -> 0x0254, all -> 0x0249 }
        r8 = r11.getHeaderFields();	 Catch:{ SSLPeerUnverifiedException -> 0x02b9, Exception -> 0x02a2, AssertionError -> 0x028b, all -> 0x0249 }
        a(r8);	 Catch:{ SSLPeerUnverifiedException -> 0x02b9, Exception -> 0x02a2, AssertionError -> 0x028b, all -> 0x0249 }
        r8 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        if (r15 != r8) goto L_0x01b5;
    L_0x017a:
        r8 = "Location";
        r20 = r11.getHeaderField(r8);	 Catch:{ SSLPeerUnverifiedException -> 0x02b9, Exception -> 0x02a2, AssertionError -> 0x028b, all -> 0x0249 }
        if (r33 < 0) goto L_0x01a4;
    L_0x0182:
        r21 = r33 + -1;
        r22 = 0;
        r25 = 0;
        r26 = 0;
        r18 = r30;
        r19 = r31;
        r24 = r9;
        r8 = r18.a(r19, r20, r21, r22, r24, r25, r26);	 Catch:{ SSLPeerUnverifiedException -> 0x02b9, Exception -> 0x02a2, AssertionError -> 0x028b, all -> 0x0249 }
        if (r13 == 0) goto L_0x019e;
    L_0x0196:
        r13.close();	 Catch:{ IOException -> 0x019a }
        goto L_0x019e;
    L_0x019a:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x019e:
        if (r11 == 0) goto L_0x01a3;
    L_0x01a0:
        r11.disconnect();
    L_0x01a3:
        return r8;
    L_0x01a4:
        if (r13 == 0) goto L_0x01ae;
    L_0x01a6:
        r13.close();	 Catch:{ IOException -> 0x01aa }
        goto L_0x01ae;
    L_0x01aa:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x01ae:
        if (r11 == 0) goto L_0x01b3;
    L_0x01b0:
        r11.disconnect();
    L_0x01b3:
        r1 = 0;
        return r1;
    L_0x01b5:
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r15 != r8) goto L_0x023b;
    L_0x01b9:
        r8 = r11.getInputStream();	 Catch:{ SSLPeerUnverifiedException -> 0x02b9, Exception -> 0x02a2, AssertionError -> 0x028b, all -> 0x0249 }
        r14 = r11.getHeaderFields();	 Catch:{ SSLPeerUnverifiedException -> 0x0238, Exception -> 0x0235, AssertionError -> 0x0232, all -> 0x022e }
        r10 = cn.jiguang.g.f.a(r8);	 Catch:{ SSLPeerUnverifiedException -> 0x0229, Exception -> 0x0224, AssertionError -> 0x021f, all -> 0x022e }
        if (r10 == 0) goto L_0x01d2;
    L_0x01c7:
        r13 = r10.length;	 Catch:{ SSLPeerUnverifiedException -> 0x0229, Exception -> 0x0224, AssertionError -> 0x021f, all -> 0x022e }
        if (r13 <= 0) goto L_0x01d2;
    L_0x01ca:
        r13 = new java.lang.String;	 Catch:{ SSLPeerUnverifiedException -> 0x0229, Exception -> 0x0224, AssertionError -> 0x021f, all -> 0x022e }
        r4 = "UTF-8";
        r13.<init>(r10, r4);	 Catch:{ SSLPeerUnverifiedException -> 0x0229, Exception -> 0x0224, AssertionError -> 0x021f, all -> 0x022e }
        goto L_0x01d4;
    L_0x01d2:
        r13 = "";
    L_0x01d4:
        if (r8 == 0) goto L_0x01de;
    L_0x01d6:
        r8.close();	 Catch:{ IOException -> 0x01da }
        goto L_0x01de;
    L_0x01da:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x01de:
        if (r11 == 0) goto L_0x01e3;
    L_0x01e0:
        r11.disconnect();
    L_0x01e3:
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r15 < r1) goto L_0x01f3;
    L_0x01e7:
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r15 >= r1) goto L_0x01f3;
    L_0x01eb:
        if (r13 != 0) goto L_0x01f1;
    L_0x01ed:
        r1 = "<<error>>";
        r11 = r1;
        goto L_0x0219;
    L_0x01f1:
        r11 = r13;
        goto L_0x0219;
    L_0x01f3:
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r2 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r15 < r2) goto L_0x0217;
    L_0x01f9:
        if (r15 >= r1) goto L_0x0217;
    L_0x01fb:
        if (r2 != r15) goto L_0x0200;
    L_0x01fd:
        r11 = "server fail";
        goto L_0x0219;
    L_0x0200:
        r1 = 401; // 0x191 float:5.62E-43 double:1.98E-321;
        if (r1 == r15) goto L_0x0217;
    L_0x0204:
        r1 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        if (r1 == r15) goto L_0x0217;
    L_0x0208:
        r1 = 406; // 0x196 float:5.69E-43 double:2.006E-321;
        if (r1 == r15) goto L_0x0217;
    L_0x020c:
        r1 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
        if (r1 == r15) goto L_0x0217;
    L_0x0210:
        r1 = 409; // 0x199 float:5.73E-43 double:2.02E-321;
        if (r1 != r15) goto L_0x0215;
    L_0x0214:
        goto L_0x0217;
    L_0x0215:
        r11 = 0;
        goto L_0x0219;
    L_0x0217:
        r11 = "<<error>>";
    L_0x0219:
        r1 = new cn.jiguang.a.a.c.j;
        r1.<init>(r15, r14, r11);
        return r1;
    L_0x021f:
        r13 = r8;
        r17 = r14;
        goto L_0x028b;
    L_0x0224:
        r13 = r8;
        r17 = r14;
        goto L_0x02a2;
    L_0x0229:
        r13 = r8;
        r17 = r14;
        goto L_0x02b9;
    L_0x022e:
        r0 = move-exception;
        r1 = r0;
        r13 = r8;
        goto L_0x0271;
    L_0x0232:
        r13 = r8;
        goto L_0x028b;
    L_0x0235:
        r13 = r8;
        goto L_0x02a2;
    L_0x0238:
        r13 = r8;
        goto L_0x02b9;
    L_0x023b:
        if (r13 == 0) goto L_0x0245;
    L_0x023d:
        r13.close();	 Catch:{ IOException -> 0x0241 }
        goto L_0x0245;
    L_0x0241:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0245:
        if (r11 == 0) goto L_0x02c8;
    L_0x0247:
        goto L_0x02c5;
    L_0x0249:
        r0 = move-exception;
        r1 = r0;
        goto L_0x0271;
    L_0x024c:
        r9 = r36;
        r27 = r8;
        r17 = r14;
    L_0x0252:
        r28 = r15;
    L_0x0254:
        r15 = r28;
        goto L_0x028b;
    L_0x0257:
        r9 = r36;
        r27 = r8;
        r17 = r14;
    L_0x025d:
        r28 = r15;
    L_0x025f:
        r15 = r28;
        goto L_0x02a2;
    L_0x0262:
        r9 = r36;
        r27 = r8;
        r17 = r14;
    L_0x0268:
        r28 = r15;
    L_0x026a:
        r15 = r28;
        goto L_0x02b9;
    L_0x026d:
        r0 = move-exception;
        r1 = r0;
        r11 = r16;
    L_0x0271:
        if (r13 == 0) goto L_0x027b;
    L_0x0273:
        r13.close();	 Catch:{ IOException -> 0x0277 }
        goto L_0x027b;
    L_0x0277:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x027b:
        if (r11 == 0) goto L_0x0280;
    L_0x027d:
        r11.disconnect();
    L_0x0280:
        throw r1;
    L_0x0281:
        r9 = r36;
        r27 = r8;
        r17 = r14;
        r28 = r15;
        r11 = r16;
    L_0x028b:
        if (r13 == 0) goto L_0x0295;
    L_0x028d:
        r13.close();	 Catch:{ IOException -> 0x0291 }
        goto L_0x0295;
    L_0x0291:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0295:
        if (r11 == 0) goto L_0x02c8;
    L_0x0297:
        goto L_0x02c5;
    L_0x0298:
        r9 = r36;
        r27 = r8;
        r17 = r14;
        r28 = r15;
        r11 = r16;
    L_0x02a2:
        if (r13 == 0) goto L_0x02ac;
    L_0x02a4:
        r13.close();	 Catch:{ IOException -> 0x02a8 }
        goto L_0x02ac;
    L_0x02a8:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x02ac:
        if (r11 == 0) goto L_0x02c8;
    L_0x02ae:
        goto L_0x02c5;
    L_0x02af:
        r9 = r36;
        r27 = r8;
        r17 = r14;
        r28 = r15;
        r11 = r16;
    L_0x02b9:
        if (r13 == 0) goto L_0x02c3;
    L_0x02bb:
        r13.close();	 Catch:{ IOException -> 0x02bf }
        goto L_0x02c3;
    L_0x02bf:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x02c3:
        if (r11 == 0) goto L_0x02c8;
    L_0x02c5:
        r11.disconnect();
    L_0x02c8:
        r16 = r11;
        r14 = r17;
        r4 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        if (r15 == r4) goto L_0x02f4;
    L_0x02d0:
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r15 == r4) goto L_0x02db;
    L_0x02d4:
        r4 = cn.jiguang.g.a.d(r31);
        if (r4 != 0) goto L_0x02db;
    L_0x02da:
        goto L_0x02f4;
    L_0x02db:
        r4 = 3;
        if (r12 < r4) goto L_0x02e7;
    L_0x02de:
        r1 = new cn.jiguang.a.a.c.j;
        r2 = "<<failed_with_retries>>";
        r4 = -1;
        r1.<init>(r4, r14, r2);
        return r1;
    L_0x02e7:
        r4 = -1;
        r12 = r12 + 1;
        java.lang.Thread.sleep(r2);	 Catch:{ InterruptedException -> 0x02ed }
    L_0x02ed:
        r8 = r27;
        r4 = r37;
        r10 = 0;
        goto L_0x0035;
    L_0x02f4:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.i.a(android.content.Context, java.lang.String, int, long, boolean, java.io.File, java.lang.String):cn.jiguang.a.a.c.j");
    }

    private String a(int i) {
        String str;
        Context context = this.g;
        if (i < 0 || i >= 3) {
            str = "http://182.92.20.189:9099/";
        } else {
            StringBuilder stringBuilder = new StringBuilder("number_url");
            stringBuilder.append(i);
            str = cn.jiguang.d.a.a.b(context, stringBuilder.toString(), "http://182.92.20.189:9099/");
        }
        this.i = str;
        return this.i;
    }

    private String a(String str, j jVar) {
        return a(this.g, jVar) ? d(str) : null;
    }

    private String a(TreeMap<String, String> treeMap) {
        if (treeMap.size() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry value : treeMap.entrySet()) {
            stringBuilder.append(value.getValue());
        }
        String b = cn.jiguang.a.b.a.b(this.g);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(stringBuilder.toString());
        stringBuilder2.append(b);
        return a.a(stringBuilder2.toString()).toUpperCase();
    }

    public static void a(Context context) {
        if (c.get() < 2) {
            a.execute(new i(context));
        }
    }

    private static void a(Map<String, List<String>> map) {
        List<String> list = (List) map.get("Set-Cookie");
        if (list != null) {
            for (String parse : list) {
                j.getCookieStore().add(null, (HttpCookie) HttpCookie.parse(parse).get(0));
            }
        }
    }

    private static boolean a(Context context, j jVar) {
        if (context == null || jVar == null) {
            return false;
        }
        File a = f.a(context, "resp.raw");
        if (a == null) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        if (jVar.c != null && jVar.c.size() > 0) {
            for (Entry entry : jVar.c.entrySet()) {
                if (entry.getKey() != null) {
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append(": ");
                }
                Iterator it = ((List) entry.getValue()).iterator();
                if (it.hasNext()) {
                    while (true) {
                        stringBuilder.append((String) it.next());
                        if (!it.hasNext()) {
                            break;
                        }
                        stringBuilder.append(", ");
                    }
                }
                stringBuilder.append("\n");
            }
        }
        stringBuilder.append("\r\n\r\n");
        if (!TextUtils.isEmpty(jVar.b)) {
            stringBuilder.append(jVar.b);
        }
        if (!f.a(a, stringBuilder.toString())) {
            return false;
        }
        Collection arrayList = new ArrayList();
        arrayList.add(a);
        File a2 = f.a(context, "resp.zip");
        if (a2 == null) {
            return false;
        }
        f.a(a2);
        try {
            f.a(arrayList, a2);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x00fa */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:35|36|37|38|39|40|41|42) */
    private boolean a(java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
        r9 = this;
        r0 = new java.util.TreeMap;
        r0.<init>();
        r1 = cn.jiguang.g.i.a(r10);
        if (r1 != 0) goto L_0x0010;
    L_0x000b:
        r1 = "imei";
        r0.put(r1, r10);
    L_0x0010:
        r10 = cn.jiguang.g.i.a(r11);
        if (r10 != 0) goto L_0x001b;
    L_0x0016:
        r10 = "iccid";
        r0.put(r10, r11);
    L_0x001b:
        r10 = cn.jiguang.g.i.a(r12);
        if (r10 != 0) goto L_0x0026;
    L_0x0021:
        r10 = "imsi";
        r0.put(r10, r12);
    L_0x0026:
        r10 = "version";
        r11 = r9.g;
        r12 = "number_version";
        r1 = "1.3.0";
        r11 = cn.jiguang.d.a.a.b(r11, r12, r1);
        r0.put(r10, r11);
        r10 = "app_id";
        r11 = r9.g;
        r12 = "number_appid";
        r1 = "7";
        r11 = cn.jiguang.d.a.a.b(r11, r12, r1);
        r0.put(r10, r11);
        r10 = "req_time";
        r11 = cn.jiguang.d.h.c.b();
        r0.put(r10, r11);
        r10 = "sign";
        r11 = r9.a(r0);
        r0.put(r10, r11);
        r10 = "";
        r11 = r0.entrySet();
        r11 = r11.iterator();
    L_0x0060:
        r12 = r11.hasNext();
        if (r12 == 0) goto L_0x009a;
    L_0x0066:
        r12 = r11.next();
        r12 = (java.util.Map.Entry) r12;
        r0 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r0.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r0.append(r10);	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r1 = "&";
        r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r1 = r12.getKey();	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r1 = "=";
        r0.append(r1);	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r12 = r12.getValue();	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r12 = (java.lang.String) r12;	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r1 = "UTF-8";
        r12 = java.net.URLEncoder.encode(r12, r1);	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r0.append(r12);	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r12 = r0.toString();	 Catch:{ UnsupportedEncodingException -> 0x0060 }
        r10 = r12;
        goto L_0x0060;
    L_0x009a:
        r11 = 0;
        r1 = r9.g;	 Catch:{ Throwable -> 0x0118 }
        r12 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0118 }
        r12.<init>();	 Catch:{ Throwable -> 0x0118 }
        r0 = r9.i;	 Catch:{ Throwable -> 0x0118 }
        r12.append(r0);	 Catch:{ Throwable -> 0x0118 }
        r0 = "statistic/query?";
        r12.append(r0);	 Catch:{ Throwable -> 0x0118 }
        r12.append(r10);	 Catch:{ Throwable -> 0x0118 }
        r2 = r12.toString();	 Catch:{ Throwable -> 0x0118 }
        r3 = 10;
        r4 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r0 = r9;
        r12 = r0.a(r1, r2, r3, r4, r6, r7, r8);	 Catch:{ Throwable -> 0x0118 }
        r0 = r12.a;
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 == r1) goto L_0x00c6;
    L_0x00c5:
        return r11;
    L_0x00c6:
        r0 = r12.b;
        r0 = c(r0);
        r2 = 0;
        if (r0 == 0) goto L_0x00e4;
    L_0x00cf:
        r10 = "code";
        r12 = -1;
        r10 = r0.optInt(r10, r12);
        if (r10 == r1) goto L_0x00d9;
    L_0x00d8:
        return r11;
    L_0x00d9:
        r10 = "num";
        r10 = r0.optString(r10);
        r2 = r9.b(r10);
        goto L_0x0109;
    L_0x00e4:
        r0 = r12.c;
        if (r0 != 0) goto L_0x00f0;
    L_0x00e8:
        r0 = r12.b;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0109;
    L_0x00f0:
        r0 = b;
        monitor-enter(r0);
        r9.h = r11;	 Catch:{ all -> 0x0115 }
        r10 = r9.a(r10, r12);	 Catch:{ Throwable -> 0x00fa }
        r2 = r10;
    L_0x00fa:
        r10 = r9.g;	 Catch:{ all -> 0x0115 }
        r12 = "resp.raw";
        r10.deleteFile(r12);	 Catch:{ all -> 0x0115 }
        r10 = r9.g;	 Catch:{ all -> 0x0115 }
        r12 = "resp.zip";
        r10.deleteFile(r12);	 Catch:{ all -> 0x0115 }
        monitor-exit(r0);	 Catch:{ all -> 0x0115 }
    L_0x0109:
        r10 = android.text.TextUtils.isEmpty(r2);
        if (r10 != 0) goto L_0x0114;
    L_0x010f:
        r9.e(r2);
        r10 = 1;
        return r10;
    L_0x0114:
        return r11;
    L_0x0115:
        r10 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0115 }
        throw r10;
    L_0x0118:
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.i.a(java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        String d = a.d(context, "");
        String c = a.c(context, "");
        String e = a.e(context, "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d);
        stringBuilder.append(c);
        stringBuilder.append(e);
        return a.a(stringBuilder.toString());
    }

    private String b(String str) {
        str = f(str);
        if (cn.jiguang.g.i.a(str)) {
            return null;
        }
        if (!Patterns.PHONE.matcher(str).matches()) {
            str = null;
        }
        return str;
    }

    private static JSONObject c(String str) {
        try {
            return !TextUtils.isEmpty(str) ? new JSONObject(str) : null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String d(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Context context = this.g;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.i);
            stringBuilder.append("statistic/query?");
            stringBuilder.append(str);
            j a = a(context, stringBuilder.toString(), 10, StatisticConfig.MIN_UPLOAD_INTERVAL, false, f.a(this.g, "resp.zip"), "resp_data");
            if (a.a != 200) {
                return null;
            }
            JSONObject c = c(a.b);
            if (c != null) {
                return c.optInt(WebPicUploadResult.RESP_UPLOAD_PIC_PARAM_CODE, -1) != 200 ? null : b(c.optString("num"));
            } else {
                if (!(a.c == null && TextUtils.isEmpty(a.b))) {
                    if (this.h > 4) {
                        return null;
                    }
                    this.h++;
                    str2 = a(str, a);
                }
                return str2;
            }
        } catch (Throwable unused) {
        }
    }

    private void e(String str) {
        Context context = this.g;
        String b = b(context);
        if (cn.jiguang.g.i.a(b)) {
            b = "number_num";
        }
        cn.jiguang.d.a.a.a(context, b, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("num", str);
            if (!cn.jiguang.g.i.a(this.d)) {
                jSONObject.put("imei", this.d);
            }
            if (!cn.jiguang.g.i.a(this.f)) {
                jSONObject.put("imsi", this.f);
            }
            if (!cn.jiguang.g.i.a(this.e)) {
                jSONObject.put("iccid", this.e);
            }
            str = jSONObject.toString();
            try {
                str = cn.jiguang.d.h.a.a.a(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!cn.jiguang.g.i.a(str)) {
                jSONObject = new JSONObject();
                x.a(this.g, jSONObject, "nb");
                jSONObject.put(c.a, str);
                cn.jiguang.a.c.c.a(this.g, jSONObject);
                cn.jiguang.a.b.a.c(this.g, false);
            }
        } catch (JSONException unused) {
        }
    }

    private String f(String str) {
        try {
            return cn.jiguang.d.h.a.a.a(str, cn.jiguang.a.b.a.b(this.g).substring(0, 16));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00db A:{Catch:{ Exception -> 0x0103 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c6 A:{Catch:{ Exception -> 0x0103 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c6 A:{Catch:{ Exception -> 0x0103 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00db A:{Catch:{ Exception -> 0x0103 }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00db A:{Catch:{ Exception -> 0x0103 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c6 A:{Catch:{ Exception -> 0x0103 }} */
    public final void run() {
        /*
        r5 = this;
        r0 = c;
        r0.incrementAndGet();
        r0 = r5.d;	 Catch:{ Exception -> 0x0103 }
        r0 = cn.jiguang.g.i.a(r0);	 Catch:{ Exception -> 0x0103 }
        if (r0 == 0) goto L_0x001e;
    L_0x000d:
        r0 = r5.e;	 Catch:{ Exception -> 0x0103 }
        r0 = cn.jiguang.g.i.a(r0);	 Catch:{ Exception -> 0x0103 }
        if (r0 == 0) goto L_0x001e;
    L_0x0015:
        r0 = r5.f;	 Catch:{ Exception -> 0x0103 }
        r0 = cn.jiguang.g.i.a(r0);	 Catch:{ Exception -> 0x0103 }
        if (r0 == 0) goto L_0x001e;
    L_0x001d:
        return;
    L_0x001e:
        r0 = r5.g;	 Catch:{ Exception -> 0x0103 }
        r1 = b(r0);	 Catch:{ Exception -> 0x0103 }
        r2 = cn.jiguang.g.i.a(r1);	 Catch:{ Exception -> 0x0103 }
        if (r2 == 0) goto L_0x002c;
    L_0x002a:
        r1 = "number_num";
    L_0x002c:
        r2 = "";
        r0 = cn.jiguang.d.a.a.b(r0, r1, r2);	 Catch:{ Exception -> 0x0103 }
        r1 = cn.jiguang.g.i.a(r0);	 Catch:{ Exception -> 0x0103 }
        r2 = 0;
        if (r1 != 0) goto L_0x0053;
    L_0x0039:
        r1 = r5.g;	 Catch:{ Exception -> 0x0103 }
        r3 = "nb_upload";
        r4 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x0103 }
        r1 = cn.jiguang.d.a.d.b(r1, r3, r4);	 Catch:{ Exception -> 0x0103 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ Exception -> 0x0103 }
        r1 = r1.booleanValue();	 Catch:{ Exception -> 0x0103 }
        if (r1 == 0) goto L_0x004e;
    L_0x004d:
        goto L_0x0053;
    L_0x004e:
        r5.e(r0);	 Catch:{ Exception -> 0x0103 }
        goto L_0x0103;
    L_0x0053:
        r0 = r5.g;	 Catch:{ Exception -> 0x0103 }
        r1 = "nb_lasttime";
        r3 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0103 }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ Exception -> 0x0103 }
        cn.jiguang.d.a.d.a(r0, r1, r3);	 Catch:{ Exception -> 0x0103 }
        r0 = r5.f;	 Catch:{ Exception -> 0x0103 }
        r1 = cn.jiguang.g.i.a(r0);	 Catch:{ Exception -> 0x0103 }
        r3 = -1;
        if (r1 != 0) goto L_0x00c3;
    L_0x006b:
        r1 = "46000";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 != 0) goto L_0x00c1;
    L_0x0073:
        r1 = "46002";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 != 0) goto L_0x00c1;
    L_0x007b:
        r1 = "46007";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 != 0) goto L_0x00c1;
    L_0x0083:
        r1 = "46008";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 == 0) goto L_0x008c;
    L_0x008b:
        goto L_0x00c1;
    L_0x008c:
        r1 = "46001";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 != 0) goto L_0x00bf;
    L_0x0094:
        r1 = "46006";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 != 0) goto L_0x00bf;
    L_0x009c:
        r1 = "46009";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 == 0) goto L_0x00a5;
    L_0x00a4:
        goto L_0x00bf;
    L_0x00a5:
        r1 = "46003";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 != 0) goto L_0x00bd;
    L_0x00ad:
        r1 = "46005";
        r1 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 != 0) goto L_0x00bd;
    L_0x00b5:
        r1 = "46011";
        r0 = r0.startsWith(r1);	 Catch:{ Exception -> 0x0103 }
        if (r0 == 0) goto L_0x00c3;
    L_0x00bd:
        r0 = 2;
        goto L_0x00c4;
    L_0x00bf:
        r0 = 1;
        goto L_0x00c4;
    L_0x00c1:
        r0 = r2;
        goto L_0x00c4;
    L_0x00c3:
        r0 = r3;
    L_0x00c4:
        if (r0 == r3) goto L_0x00db;
    L_0x00c6:
        r5.a(r0);	 Catch:{ Exception -> 0x0103 }
        r0 = r5.i;	 Catch:{ Exception -> 0x0103 }
        r0 = cn.jiguang.g.i.a(r0);	 Catch:{ Exception -> 0x0103 }
        if (r0 != 0) goto L_0x0103;
    L_0x00d1:
        r0 = r5.d;	 Catch:{ Exception -> 0x0103 }
        r1 = r5.e;	 Catch:{ Exception -> 0x0103 }
        r2 = r5.f;	 Catch:{ Exception -> 0x0103 }
        r5.a(r0, r1, r2);	 Catch:{ Exception -> 0x0103 }
        goto L_0x0103;
    L_0x00db:
        r0 = "";
    L_0x00dd:
        r1 = 3;
        if (r2 >= r1) goto L_0x0103;
    L_0x00e0:
        r5.a(r2);	 Catch:{ Exception -> 0x0103 }
        r2 = r2 + 1;
        r1 = r5.i;	 Catch:{ Exception -> 0x0103 }
        r1 = cn.jiguang.g.i.a(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 != 0) goto L_0x00dd;
    L_0x00ed:
        r1 = r5.i;	 Catch:{ Exception -> 0x0103 }
        r1 = r0.equals(r1);	 Catch:{ Exception -> 0x0103 }
        if (r1 != 0) goto L_0x00dd;
    L_0x00f5:
        r0 = r5.i;	 Catch:{ Exception -> 0x0103 }
        r1 = r5.d;	 Catch:{ Exception -> 0x0103 }
        r3 = r5.e;	 Catch:{ Exception -> 0x0103 }
        r4 = r5.f;	 Catch:{ Exception -> 0x0103 }
        r1 = r5.a(r1, r3, r4);	 Catch:{ Exception -> 0x0103 }
        if (r1 == 0) goto L_0x00dd;
    L_0x0103:
        r0 = c;
        r0.decrementAndGet();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.a.a.c.i.run():void");
    }
}
