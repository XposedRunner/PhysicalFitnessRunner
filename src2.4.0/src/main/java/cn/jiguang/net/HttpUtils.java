package cn.jiguang.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import cn.jiguang.d.h.c;
import cn.jiguang.g.f;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtils {
    public static final String ENCODING_UTF_8 = "UTF-8";
    public static final String EQUAL_SIGN = "=";
    public static final String HTTP_DEFUALT_PROXY = "10.0.0.172";
    public static final String PARAMETERS_SEPARATOR = "&";
    public static final String PATHS_SEPARATOR = "/";
    public static final String URL_AND_PARA_SEPARATOR = "?";

    public abstract class HttpListener {
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f8 A:{Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0116 A:{SYNTHETIC, Splitter:B:75:0x0116} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0122 A:{Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }} */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01d6 A:{Catch:{ all -> 0x01fa }} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01cb A:{Catch:{ all -> 0x01fa }} */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01cb A:{Catch:{ all -> 0x01fa }} */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01d6 A:{Catch:{ all -> 0x01fa }} */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01d6 A:{Catch:{ all -> 0x01fa }} */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01cb A:{Catch:{ all -> 0x01fa }} */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0223  */
    /* JADX WARNING: Missing block: B:80:0x0145, code skipped:
            if (r8 == null) goto L_0x0215;
     */
    /* JADX WARNING: Missing block: B:113:0x018a, code skipped:
            if (r8 != null) goto L_0x0212;
     */
    /* JADX WARNING: Missing block: B:151:0x0210, code skipped:
            if (r8 != null) goto L_0x0212;
     */
    /* JADX WARNING: Missing block: B:152:0x0212, code skipped:
            r8.disconnect();
     */
    private static cn.jiguang.net.HttpResponse a(android.content.Context r8, cn.jiguang.net.HttpRequest r9, boolean r10) {
        /*
        r0 = 0;
        if (r9 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new cn.jiguang.net.HttpResponse;
        r2 = r9.getUrl();
        r1.<init>(r2);
        r2 = r9.getUrl();	 Catch:{ MalformedURLException -> 0x01fe, IOException -> 0x01ba, Exception -> 0x018e, StackOverflowError -> 0x0178, all -> 0x0173 }
        r8 = getHttpURLConnectionWithProxy(r8, r2);	 Catch:{ MalformedURLException -> 0x01fe, IOException -> 0x01ba, Exception -> 0x018e, StackOverflowError -> 0x0178, all -> 0x0173 }
        r2 = r8.getURL();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r2.getPort();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        if (r9 == 0) goto L_0x0042;
    L_0x001e:
        if (r8 != 0) goto L_0x0021;
    L_0x0020:
        goto L_0x0042;
    L_0x0021:
        r2 = r9.getRequestProperties();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        setURLConnection(r2, r8);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r2 = r9.getConnectTimeout();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        if (r2 < 0) goto L_0x0035;
    L_0x002e:
        r2 = r9.getConnectTimeout();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r8.setConnectTimeout(r2);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
    L_0x0035:
        r2 = r9.getReadTimeout();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        if (r2 < 0) goto L_0x0042;
    L_0x003b:
        r2 = r9.getReadTimeout();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r8.setReadTimeout(r2);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
    L_0x0042:
        r2 = r8 instanceof javax.net.ssl.HttpsURLConnection;	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r3 = 1;
        if (r2 == 0) goto L_0x00aa;
    L_0x0047:
        r2 = r9.getSslTrustManager();	 Catch:{ Throwable -> 0x0092 }
        if (r2 == 0) goto L_0x0070;
    L_0x004d:
        r2 = "TLS";
        r2 = javax.net.ssl.SSLContext.getInstance(r2);	 Catch:{ Throwable -> 0x0092 }
        r4 = new javax.net.ssl.TrustManager[r3];	 Catch:{ Throwable -> 0x0092 }
        r5 = 0;
        r6 = r9.getSslTrustManager();	 Catch:{ Throwable -> 0x0092 }
        r4[r5] = r6;	 Catch:{ Throwable -> 0x0092 }
        r5 = new java.security.SecureRandom;	 Catch:{ Throwable -> 0x0092 }
        r5.<init>();	 Catch:{ Throwable -> 0x0092 }
        r2.init(r0, r4, r5);	 Catch:{ Throwable -> 0x0092 }
        if (r2 == 0) goto L_0x0070;
    L_0x0066:
        r4 = r8;
        r4 = (javax.net.ssl.HttpsURLConnection) r4;	 Catch:{ Throwable -> 0x0092 }
        r2 = r2.getSocketFactory();	 Catch:{ Throwable -> 0x0092 }
        r4.setSSLSocketFactory(r2);	 Catch:{ Throwable -> 0x0092 }
    L_0x0070:
        r2 = r9.getHostnameVerifier();	 Catch:{ Throwable -> 0x0092 }
        if (r2 == 0) goto L_0x0081;
    L_0x0076:
        r2 = r8;
        r2 = (javax.net.ssl.HttpsURLConnection) r2;	 Catch:{ Throwable -> 0x0092 }
        r4 = r9.getHostnameVerifier();	 Catch:{ Throwable -> 0x0092 }
    L_0x007d:
        r2.setHostnameVerifier(r4);	 Catch:{ Throwable -> 0x0092 }
        goto L_0x00aa;
    L_0x0081:
        r2 = r8;
        r2 = (javax.net.ssl.HttpsURLConnection) r2;	 Catch:{ Throwable -> 0x0092 }
        r4 = new cn.jiguang.net.DefaultHostVerifier;	 Catch:{ Throwable -> 0x0092 }
        r5 = r8.getURL();	 Catch:{ Throwable -> 0x0092 }
        r5 = r5.getHost();	 Catch:{ Throwable -> 0x0092 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0092 }
        goto L_0x007d;
    L_0x0092:
        r2 = move-exception;
        r4 = "HttpUtils";
        r5 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r6 = "set ssl config error:";
        r5.<init>(r6);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r2 = r2.getMessage();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r5.append(r2);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r2 = r5.toString();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        cn.jiguang.e.c.c(r4, r2);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
    L_0x00aa:
        if (r10 == 0) goto L_0x00c4;
    L_0x00ac:
        r10 = "POST";
        r8.setRequestMethod(r10);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r8.setDoOutput(r3);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r8.setDoInput(r3);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r10 = r9.getParas();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        if (r10 == 0) goto L_0x00c4;
    L_0x00bd:
        r2 = r8.getOutputStream();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r2.write(r10);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
    L_0x00c4:
        r10 = r8.getResponseCode();	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r1.setResponseCode(r10);	 Catch:{ MalformedURLException -> 0x0170, IOException -> 0x016b, Exception -> 0x0167, StackOverflowError -> 0x0165, all -> 0x0160 }
        r2 = r8.getInputStream();	 Catch:{ Throwable -> 0x00d0 }
        goto L_0x00d1;
    L_0x00d0:
        r2 = r0;
    L_0x00d1:
        r3 = r9.isHaveRspData();	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
        if (r3 == 0) goto L_0x00eb;
    L_0x00d7:
        if (r2 == 0) goto L_0x00eb;
    L_0x00d9:
        r3 = readInputStream(r2);	 Catch:{ Throwable -> 0x00eb }
        if (r3 == 0) goto L_0x00ec;
    L_0x00df:
        r4 = r9.isRspDatazip();	 Catch:{ Throwable -> 0x00ec }
        if (r4 == 0) goto L_0x00ec;
    L_0x00e5:
        r4 = cn.jiguang.d.h.x.b(r3);	 Catch:{ Throwable -> 0x00ec }
        r3 = r4;
        goto L_0x00ec;
    L_0x00eb:
        r3 = r0;
    L_0x00ec:
        if (r3 != 0) goto L_0x0114;
    L_0x00ee:
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r10 == r4) goto L_0x0114;
    L_0x00f2:
        r9 = r9.isNeedErrorInput();	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
        if (r9 == 0) goto L_0x0114;
    L_0x00f8:
        r9 = r8.getErrorStream();	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
        r3 = readInputStream(r9);	 Catch:{ MalformedURLException -> 0x015d, IOException -> 0x010e, Exception -> 0x0106, StackOverflowError -> 0x014f, all -> 0x0102 }
        r0 = r9;
        goto L_0x0114;
    L_0x0102:
        r10 = move-exception;
        r0 = r2;
        goto L_0x0217;
    L_0x0106:
        r10 = move-exception;
        r0 = r2;
        r7 = r10;
        r10 = r8;
        r8 = r9;
        r9 = r7;
        goto L_0x0191;
    L_0x010e:
        r10 = move-exception;
        r0 = r8;
        r8 = r9;
        r9 = r10;
        goto L_0x01bd;
    L_0x0114:
        if (r3 == 0) goto L_0x0120;
    L_0x0116:
        r9 = new java.lang.String;	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
        r10 = "UTF-8";
        r9.<init>(r3, r10);	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
        r1.setResponseBody(r9);	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
    L_0x0120:
        if (r8 == 0) goto L_0x013f;
    L_0x0122:
        r9 = r8.getResponseCode();	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
        r1.setResponseCode(r9);	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
        r9 = "expires";
        r10 = "Expires";
        r10 = r8.getHeaderField(r10);	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
        r1.setResponseHeader(r9, r10);	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
        r9 = "cache-control";
        r10 = "Cache-Control";
        r10 = r8.getHeaderField(r10);	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
        r1.setResponseHeader(r9, r10);	 Catch:{ MalformedURLException -> 0x015c, IOException -> 0x0156, Exception -> 0x0151, StackOverflowError -> 0x014e, all -> 0x0149 }
    L_0x013f:
        cn.jiguang.g.f.a(r2);
        cn.jiguang.g.f.a(r0);
        if (r8 == 0) goto L_0x0215;
    L_0x0147:
        goto L_0x0212;
    L_0x0149:
        r9 = move-exception;
        r10 = r8;
        r8 = r0;
        goto L_0x01fc;
    L_0x014e:
        r9 = r0;
    L_0x014f:
        r0 = r2;
        goto L_0x017a;
    L_0x0151:
        r9 = move-exception;
        r10 = r8;
        r8 = r0;
        r0 = r2;
        goto L_0x0191;
    L_0x0156:
        r9 = move-exception;
        r7 = r0;
        r0 = r8;
        r8 = r7;
        goto L_0x01bd;
    L_0x015c:
        r9 = r0;
    L_0x015d:
        r0 = r2;
        goto L_0x0200;
    L_0x0160:
        r9 = move-exception;
        r10 = r8;
        r8 = r0;
        goto L_0x021b;
    L_0x0165:
        r9 = r0;
        goto L_0x017a;
    L_0x0167:
        r9 = move-exception;
        r10 = r8;
        r8 = r0;
        goto L_0x0191;
    L_0x016b:
        r9 = move-exception;
        r2 = r0;
        r0 = r8;
        r8 = r2;
        goto L_0x01bd;
    L_0x0170:
        r9 = r0;
        goto L_0x0200;
    L_0x0173:
        r9 = move-exception;
        r8 = r0;
        r10 = r8;
        goto L_0x021b;
    L_0x0178:
        r8 = r0;
        r9 = r8;
    L_0x017a:
        r10 = 3007; // 0xbbf float:4.214E-42 double:1.4857E-320;
        r1.setResponseCode(r10);	 Catch:{ all -> 0x0216 }
        r10 = "StackOverflowError";
        r1.setResponseBody(r10);	 Catch:{ all -> 0x0216 }
        cn.jiguang.g.f.a(r0);
        cn.jiguang.g.f.a(r9);
        if (r8 == 0) goto L_0x0215;
    L_0x018c:
        goto L_0x0212;
    L_0x018e:
        r9 = move-exception;
        r8 = r0;
        r10 = r8;
    L_0x0191:
        r2 = 3006; // 0xbbe float:4.212E-42 double:1.485E-320;
        r1.setResponseCode(r2);	 Catch:{ all -> 0x01b7 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01b7 }
        r3 = "UNKnow execption";
        r2.<init>(r3);	 Catch:{ all -> 0x01b7 }
        r9 = r9.getMessage();	 Catch:{ all -> 0x01b7 }
        r2.append(r9);	 Catch:{ all -> 0x01b7 }
        r9 = r2.toString();	 Catch:{ all -> 0x01b7 }
        r1.setResponseBody(r9);	 Catch:{ all -> 0x01b7 }
        cn.jiguang.g.f.a(r0);
        cn.jiguang.g.f.a(r8);
        if (r10 == 0) goto L_0x0215;
    L_0x01b3:
        r10.disconnect();
        return r1;
    L_0x01b7:
        r9 = move-exception;
        goto L_0x021b;
    L_0x01ba:
        r9 = move-exception;
        r8 = r0;
        r2 = r8;
    L_0x01bd:
        r10 = 2998; // 0xbb6 float:4.201E-42 double:1.481E-320;
        r1.setResponseCode(r10);	 Catch:{ all -> 0x01fa }
        r10 = "网络错误";
        r1.setResponseBody(r10);	 Catch:{ all -> 0x01fa }
        r10 = r9 instanceof java.net.SocketTimeoutException;	 Catch:{ all -> 0x01fa }
        if (r10 == 0) goto L_0x01d6;
    L_0x01cb:
        r9 = 3001; // 0xbb9 float:4.205E-42 double:1.4827E-320;
        r1.setResponseCode(r9);	 Catch:{ all -> 0x01fa }
        r9 = "请求超时";
    L_0x01d2:
        r1.setResponseBody(r9);	 Catch:{ all -> 0x01fa }
        goto L_0x01ee;
    L_0x01d6:
        r10 = r9 instanceof java.net.UnknownHostException;	 Catch:{ all -> 0x01fa }
        if (r10 == 0) goto L_0x01e2;
    L_0x01da:
        r9 = 3003; // 0xbbb float:4.208E-42 double:1.4837E-320;
        r1.setResponseCode(r9);	 Catch:{ all -> 0x01fa }
        r9 = "域名无效";
        goto L_0x01d2;
    L_0x01e2:
        r9 = r9 instanceof javax.net.ssl.SSLHandshakeException;	 Catch:{ all -> 0x01fa }
        if (r9 == 0) goto L_0x01ee;
    L_0x01e6:
        r9 = 3005; // 0xbbd float:4.211E-42 double:1.4847E-320;
        r1.setResponseCode(r9);	 Catch:{ all -> 0x01fa }
        r9 = "SSL失败";
        goto L_0x01d2;
    L_0x01ee:
        cn.jiguang.g.f.a(r2);
        cn.jiguang.g.f.a(r8);
        if (r0 == 0) goto L_0x0215;
    L_0x01f6:
        r0.disconnect();
        return r1;
    L_0x01fa:
        r9 = move-exception;
        r10 = r0;
    L_0x01fc:
        r0 = r2;
        goto L_0x021b;
    L_0x01fe:
        r8 = r0;
        r9 = r8;
    L_0x0200:
        r10 = 3004; // 0xbbc float:4.21E-42 double:1.484E-320;
        r1.setResponseCode(r10);	 Catch:{ all -> 0x0216 }
        r10 = "MalformedURLException";
        r1.setResponseBody(r10);	 Catch:{ all -> 0x0216 }
        cn.jiguang.g.f.a(r0);
        cn.jiguang.g.f.a(r9);
        if (r8 == 0) goto L_0x0215;
    L_0x0212:
        r8.disconnect();
    L_0x0215:
        return r1;
    L_0x0216:
        r10 = move-exception;
    L_0x0217:
        r7 = r10;
        r10 = r8;
        r8 = r9;
        r9 = r7;
    L_0x021b:
        cn.jiguang.g.f.a(r0);
        cn.jiguang.g.f.a(r8);
        if (r10 == 0) goto L_0x0226;
    L_0x0223:
        r10.disconnect();
    L_0x0226:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.net.HttpUtils.a(android.content.Context, cn.jiguang.net.HttpRequest, boolean):cn.jiguang.net.HttpResponse");
    }

    public static String appendParaToUrl(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append(!str.contains(URL_AND_PARA_SEPARATOR) ? URL_AND_PARA_SEPARATOR : PARAMETERS_SEPARATOR);
        stringBuilder.append(str2);
        stringBuilder.append(EQUAL_SIGN);
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    public static HttpURLConnection getHttpURLConnectionWithProxy(Context context, String str) {
        URL url = new URL(str);
        if (context != null) {
            try {
                if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                    if (!(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                        String extraInfo = activeNetworkInfo.getExtraInfo();
                        if (extraInfo != null && (extraInfo.equals("cmwap") || extraInfo.equals("3gwap") || extraInfo.equals("uniwap"))) {
                            return (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(HTTP_DEFUALT_PROXY, 80)));
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static String getUrlWithParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        str = joinParas(map);
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(URL_AND_PARA_SEPARATOR);
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static String getUrlWithValueEncodeParas(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        str = joinParasWithEncodedValue(map);
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(URL_AND_PARA_SEPARATOR);
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static HttpResponse httpGet(Context context, HttpRequest httpRequest) {
        return a(context, httpRequest, false);
    }

    public static HttpResponse httpGet(Context context, String str) {
        return httpGet(context, new HttpRequest(str));
    }

    public static void httpGet(Context context, HttpRequest httpRequest, HttpListener httpListener) {
        new a(context, httpListener).execute(new HttpRequest[]{httpRequest});
    }

    public static void httpGet(Context context, String str, HttpListener httpListener) {
        new b(httpListener, context).execute(new String[]{str});
    }

    public static String httpGetString(Context context, HttpRequest httpRequest) {
        HttpResponse httpGet = httpGet(context, httpRequest);
        return httpGet == null ? null : httpGet.getResponseBody();
    }

    public static String httpGetString(Context context, String str) {
        HttpResponse httpGet = httpGet(context, new HttpRequest(str));
        return httpGet == null ? null : httpGet.getResponseBody();
    }

    public static HttpResponse httpPost(Context context, HttpRequest httpRequest) {
        return a(context, httpRequest, true);
    }

    public static HttpResponse httpPost(Context context, String str) {
        return httpPost(context, new HttpRequest(str));
    }

    public static String httpPostString(Context context, String str) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str));
        return httpPost == null ? null : httpPost.getResponseBody();
    }

    public static String httpPostString(Context context, String str, Map<String, String> map) {
        HttpResponse httpPost = httpPost(context, new HttpRequest(str, map));
        return httpPost == null ? null : httpPost.getResponseBody();
    }

    public static String joinParas(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            stringBuilder.append((String) entry.getKey());
            stringBuilder.append(EQUAL_SIGN);
            stringBuilder.append((String) entry.getValue());
            if (it.hasNext()) {
                stringBuilder.append(PARAMETERS_SEPARATOR);
            }
        }
        return stringBuilder.toString();
    }

    public static String joinParasWithEncodedValue(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (map != null && map.size() > 0) {
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Entry entry = (Entry) it.next();
                    stringBuilder.append((String) entry.getKey());
                    stringBuilder.append(EQUAL_SIGN);
                    stringBuilder.append(URLEncoder.encode((String) entry.getValue(), ENCODING_UTF_8));
                    if (it.hasNext()) {
                        stringBuilder.append(PARAMETERS_SEPARATOR);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

    public static long parseGmtTime(String str) {
        try {
            return c.a("EEE, d MMM yyyy HH:mm:ss z").parse(str).getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static byte[] readInputStream(InputStream inputStream) {
        return f.a(inputStream);
    }

    public static void setURLConnection(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null && map.size() != 0 && httpURLConnection != null) {
            for (Entry entry : map.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
    }
}
