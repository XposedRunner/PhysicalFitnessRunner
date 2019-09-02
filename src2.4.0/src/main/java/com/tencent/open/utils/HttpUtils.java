package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class HttpUtils {

    /* compiled from: ProGuard */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";

        public HttpStatusException(String str) {
            super(str);
        }
    }

    /* compiled from: ProGuard */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /* compiled from: ProGuard */
    public static class a extends SSLSocketFactory {
        private final SSLContext a = SSLContext.getInstance("TLS");

        public a(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            b bVar;
            super(keyStore);
            try {
                bVar = new b();
            } catch (Exception unused) {
                bVar = null;
            }
            this.a.init(null, new TrustManager[]{bVar}, null);
        }

        public Socket createSocket() throws IOException {
            return this.a.getSocketFactory().createSocket();
        }

        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
            return this.a.getSocketFactory().createSocket(socket, str, i, z);
        }
    }

    /* compiled from: ProGuard */
    public static class b implements X509TrustManager {
        X509TrustManager a;

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
        b() throws java.lang.Exception {
            /*
            r5 = this;
            r5.<init>();
            r0 = 0;
            r1 = "JKS";
            r1 = java.security.KeyStore.getInstance(r1);	 Catch:{ Exception -> 0x000b }
            goto L_0x000c;
        L_0x000b:
            r1 = r0;
        L_0x000c:
            r2 = 0;
            r3 = new javax.net.ssl.TrustManager[r2];
            if (r1 == 0) goto L_0x0041;
        L_0x0011:
            r3 = new java.io.FileInputStream;	 Catch:{ all -> 0x0038 }
            r4 = "trustedCerts";
            r3.<init>(r4);	 Catch:{ all -> 0x0038 }
            r0 = "passphrase";
            r0 = r0.toCharArray();	 Catch:{ all -> 0x0036 }
            r1.load(r3, r0);	 Catch:{ all -> 0x0036 }
            r0 = "SunX509";
            r4 = "SunJSSE";
            r0 = javax.net.ssl.TrustManagerFactory.getInstance(r0, r4);	 Catch:{ all -> 0x0036 }
            r0.init(r1);	 Catch:{ all -> 0x0036 }
            r0 = r0.getTrustManagers();	 Catch:{ all -> 0x0036 }
            if (r3 == 0) goto L_0x0052;
        L_0x0032:
            r3.close();
            goto L_0x0052;
        L_0x0036:
            r0 = move-exception;
            goto L_0x003b;
        L_0x0038:
            r1 = move-exception;
            r3 = r0;
            r0 = r1;
        L_0x003b:
            if (r3 == 0) goto L_0x0040;
        L_0x003d:
            r3.close();
        L_0x0040:
            throw r0;
        L_0x0041:
            r1 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm();
            r1 = javax.net.ssl.TrustManagerFactory.getInstance(r1);
            r0 = (java.security.KeyStore) r0;
            r1.init(r0);
            r0 = r1.getTrustManagers();
        L_0x0052:
            r1 = r0.length;
            if (r2 >= r1) goto L_0x0065;
        L_0x0055:
            r1 = r0[r2];
            r1 = r1 instanceof javax.net.ssl.X509TrustManager;
            if (r1 == 0) goto L_0x0062;
        L_0x005b:
            r0 = r0[r2];
            r0 = (javax.net.ssl.X509TrustManager) r0;
            r5.a = r0;
            return;
        L_0x0062:
            r2 = r2 + 1;
            goto L_0x0052;
        L_0x0065:
            r0 = new java.lang.Exception;
            r1 = "Couldn't initialize";
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils$b.<init>():void");
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.a.checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.a.checkServerTrusted(x509CertificateArr, str);
        }

        public X509Certificate[] getAcceptedIssuers() {
            return this.a.getAcceptedIssuers();
        }
    }

    /* compiled from: ProGuard */
    public static class c {
        public final String a;
        public final int b;

        private c(String str, int i) {
            this.a = str;
            this.b = i;
        }

        /* synthetic */ c(String str, int i, AnonymousClass1 anonymousClass1) {
            this(str, i);
        }
    }

    private HttpUtils() {
    }

    private static int a(Context context) {
        if (VERSION.SDK_INT >= 11) {
            String property = System.getProperty("http.proxyPort");
            if (!TextUtils.isEmpty(property)) {
                try {
                    return Integer.parseInt(property);
                } catch (NumberFormatException unused) {
                }
            }
            return -1;
        } else if (context == null) {
            return Proxy.getDefaultPort();
        } else {
            int port = Proxy.getPort(context);
            return port < 0 ? Proxy.getDefaultPort() : port;
        }
    }

    private static String a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Header firstHeader = httpResponse.getFirstHeader("Content-Encoding");
        InputStream gZIPInputStream = (firstHeader == null || firstHeader.getValue().toLowerCase().indexOf("gzip") <= -1) ? content : new GZIPInputStream(content);
        byte[] bArr = new byte[512];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                String str = new String(byteArrayOutputStream.toByteArray(), cn.jiguang.net.HttpUtils.ENCODING_UTF_8);
                gZIPInputStream.close();
                return str;
            }
        }
    }

    private static void a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") > -1 || str.indexOf("upload_pic") > -1 || str.indexOf("add_topic") > -1 || str.indexOf("set_user_face") > -1 || str.indexOf("add_t") > -1 || str.indexOf("add_pic_t") > -1 || str.indexOf("add_pic_url") > -1 || str.indexOf("add_video") > -1) {
            com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
        }
    }

    private static String b(Context context) {
        if (VERSION.SDK_INT >= 11) {
            return System.getProperty("http.proxyHost");
        }
        if (context == null) {
            return Proxy.getDefaultHost();
        }
        String host = Proxy.getHost(context);
        return TextUtils.isEmpty(host) ? Proxy.getDefaultHost() : host;
    }

    public static String encodePostBody(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = -1;
        int size = bundle.size();
        for (String str2 : bundle.keySet()) {
            i++;
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Content-Disposition: form-data; name=\"");
                stringBuilder2.append(str2);
                stringBuilder2.append("\"");
                stringBuilder2.append("\r\n");
                stringBuilder2.append("\r\n");
                stringBuilder2.append((String) obj);
                stringBuilder.append(stringBuilder2.toString());
                if (i < size - 1) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("\r\n--");
                    stringBuilder3.append(str);
                    stringBuilder3.append("\r\n");
                    stringBuilder.append(stringBuilder3.toString());
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if ((obj instanceof String) || (obj instanceof String[])) {
                int i2 = 0;
                StringBuilder stringBuilder2;
                if (obj instanceof String[]) {
                    if (i != 0) {
                        i = 0;
                    } else {
                        stringBuilder.append(cn.jiguang.net.HttpUtils.PARAMETERS_SEPARATOR);
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(URLEncoder.encode(str));
                    stringBuilder2.append(cn.jiguang.net.HttpUtils.EQUAL_SIGN);
                    stringBuilder.append(stringBuilder2.toString());
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        while (i2 < stringArray.length) {
                            if (i2 == 0) {
                                stringBuilder.append(URLEncoder.encode(stringArray[i2]));
                            } else {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(",");
                                stringBuilder2.append(stringArray[i2]);
                                stringBuilder.append(URLEncoder.encode(stringBuilder2.toString()));
                            }
                            i2++;
                        }
                    }
                } else {
                    if (i != 0) {
                        i = 0;
                    } else {
                        stringBuilder.append(cn.jiguang.net.HttpUtils.PARAMETERS_SEPARATOR);
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(URLEncoder.encode(str));
                    stringBuilder2.append(cn.jiguang.net.HttpUtils.EQUAL_SIGN);
                    stringBuilder2.append(URLEncoder.encode(bundle.getString(str)));
                    stringBuilder.append(stringBuilder2.toString());
                }
            }
        }
        return stringBuilder.toString();
    }

    public static int getErrorCodeFromException(IOException iOException) {
        return iOException instanceof CharConversionException ? -20 : iOException instanceof MalformedInputException ? -21 : iOException instanceof UnmappableCharacterException ? -22 : iOException instanceof HttpResponseException ? -23 : iOException instanceof ClosedChannelException ? -24 : iOException instanceof ConnectionClosedException ? -25 : iOException instanceof EOFException ? -26 : iOException instanceof FileLockInterruptionException ? -27 : iOException instanceof FileNotFoundException ? -28 : iOException instanceof HttpRetryException ? -29 : iOException instanceof ConnectTimeoutException ? -7 : iOException instanceof SocketTimeoutException ? -8 : iOException instanceof InvalidPropertiesFormatException ? -30 : iOException instanceof MalformedChunkCodingException ? -31 : iOException instanceof MalformedURLException ? -3 : iOException instanceof NoHttpResponseException ? -32 : iOException instanceof InvalidClassException ? -33 : iOException instanceof InvalidObjectException ? -34 : iOException instanceof NotActiveException ? -35 : iOException instanceof NotSerializableException ? -36 : iOException instanceof OptionalDataException ? -37 : iOException instanceof StreamCorruptedException ? -38 : iOException instanceof WriteAbortedException ? -39 : iOException instanceof ProtocolException ? -40 : iOException instanceof SSLHandshakeException ? -41 : iOException instanceof SSLKeyException ? -42 : iOException instanceof SSLPeerUnverifiedException ? -43 : iOException instanceof SSLProtocolException ? -44 : iOException instanceof BindException ? -45 : iOException instanceof ConnectException ? -46 : iOException instanceof NoRouteToHostException ? -47 : iOException instanceof PortUnreachableException ? -48 : iOException instanceof SyncFailedException ? -49 : iOException instanceof UTFDataFormatException ? -50 : iOException instanceof UnknownHostException ? -51 : iOException instanceof UnknownServiceException ? -52 : iOException instanceof UnsupportedEncodingException ? -53 : iOException instanceof ZipException ? -54 : -2;
    }

    public static HttpClient getHttpClient(Context context, String str, String str2) {
        int a;
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        f fVar = null;
        if (VERSION.SDK_INT < 16) {
            try {
                KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
                instance.load(null, null);
                a aVar = new a(instance);
                aVar.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                schemeRegistry.register(new Scheme("https", aVar, 443));
            } catch (Exception unused) {
                schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
            }
        } else {
            schemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        if (context != null) {
            fVar = f.a(context, str);
        }
        int i = 0;
        if (fVar != null) {
            i = fVar.a("Common_HttpConnectionTimeout");
            a = fVar.a("Common_SocketConnectionTimeout");
        } else {
            a = 0;
        }
        if (i == 0) {
            i = 15000;
        }
        if (a == 0) {
            a = 30000;
        }
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        HttpConnectionParams.setSoTimeout(basicHttpParams, a);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basicHttpParams, cn.jiguang.net.HttpUtils.ENCODING_UTF_8);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AndroidSDK_");
        stringBuilder.append(VERSION.SDK);
        stringBuilder.append("_");
        stringBuilder.append(Build.DEVICE);
        stringBuilder.append("_");
        stringBuilder.append(VERSION.RELEASE);
        HttpProtocolParams.setUserAgent(basicHttpParams, stringBuilder.toString());
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
        c proxy = getProxy(context);
        if (proxy != null) {
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(proxy.a, proxy.b));
        }
        return defaultHttpClient;
    }

    public static c getProxy(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
            String b = b(context);
            int a = a(context);
            if (!TextUtils.isEmpty(b) && a >= 0) {
                return new c(b, a, null);
            }
        }
        return null;
    }

    public static com.tencent.open.utils.j.a openUrl2(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, NetworkUnavailableException, HttpStatusException {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
                }
            }
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        String string = bundle2.getString("appid_for_getting_config");
        bundle2.remove("appid_for_getting_config");
        HttpClient httpClient = getHttpClient(context, string, str);
        HttpUriRequest httpUriRequest = null;
        int i = 0;
        int i2 = -1;
        if (str2.equals(Constants.HTTP_GET)) {
            StringBuilder stringBuilder;
            str2 = encodeUrl(bundle2);
            i = 0 + str2.length();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("-->openUrl2 before url =");
            stringBuilder2.append(str);
            f.a("openSDK_LOG.HttpUtils", stringBuilder2.toString());
            if (str.indexOf(cn.jiguang.net.HttpUtils.URL_AND_PARA_SEPARATOR) == -1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(cn.jiguang.net.HttpUtils.URL_AND_PARA_SEPARATOR);
                str = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(cn.jiguang.net.HttpUtils.PARAMETERS_SEPARATOR);
                str = stringBuilder.toString();
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("-->openUrl2 encodedParam =");
            stringBuilder2.append(str2);
            stringBuilder2.append(" -- url = ");
            stringBuilder2.append(str);
            f.a("openSDK_LOG.HttpUtils", stringBuilder2.toString());
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            httpUriRequest = new HttpGet(stringBuilder.toString());
            httpUriRequest.addHeader("Accept-Encoding", "gzip");
        } else if (str2.equals(Constants.HTTP_POST)) {
            httpUriRequest = new HttpPost(str);
            httpUriRequest.addHeader("Accept-Encoding", "gzip");
            Bundle bundle3 = new Bundle();
            for (String str3 : bundle2.keySet()) {
                Object obj = bundle2.get(str3);
                if (obj instanceof byte[]) {
                    bundle3.putByteArray(str3, (byte[]) obj);
                }
            }
            if (!bundle2.containsKey("method")) {
                bundle2.putString("method", str2);
            }
            httpUriRequest.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            httpUriRequest.setHeader("Connection", "Keep-Alive");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(j.i("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            byteArrayOutputStream.write(j.i(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!bundle3.isEmpty()) {
                int size = bundle3.size();
                byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                for (String str32 : bundle3.keySet()) {
                    i2++;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Content-Disposition: form-data; name=\"");
                    stringBuilder3.append(str32);
                    stringBuilder3.append("\"; filename=\"");
                    stringBuilder3.append(str32);
                    stringBuilder3.append("\"");
                    stringBuilder3.append("\r\n");
                    byteArrayOutputStream.write(j.i(stringBuilder3.toString()));
                    byteArrayOutputStream.write(j.i("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = bundle3.getByteArray(str32);
                    if (byteArray != null) {
                        byteArrayOutputStream.write(byteArray);
                    }
                    if (i2 < size - 1) {
                        byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            byteArrayOutputStream.write(j.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            i = 0 + toByteArray.length;
            byteArrayOutputStream.close();
            httpUriRequest.setEntity(new ByteArrayEntity(toByteArray));
        }
        HttpResponse execute = httpClient.execute(httpUriRequest);
        int statusCode = execute.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            return new com.tencent.open.utils.j.a(a(execute), i);
        }
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(HttpStatusException.ERROR_INFO);
        stringBuilder4.append(statusCode);
        throw new HttpStatusException(stringBuilder4.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0175 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0135 A:{Splitter:B:9:0x00c5, ExcHandler: HttpStatusException (r0_6 'e' com.tencent.open.utils.HttpUtils$HttpStatusException)} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x012f A:{Splitter:B:9:0x00c5, ExcHandler: NetworkUnavailableException (r0_5 'e' com.tencent.open.utils.HttpUtils$NetworkUnavailableException)} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0119 A:{Splitter:B:9:0x00c5, ExcHandler: MalformedURLException (r0_4 'e' java.net.MalformedURLException)} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0100 A:{Splitter:B:9:0x00c5, ExcHandler: IOException (r0_3 'e' java.io.IOException)} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01ab A:{LOOP_END, LOOP:0: B:8:0x00bf->B:59:0x01ab} */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0199 A:{SYNTHETIC} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:13:0x00d6, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:14:0x00d7, code skipped:
            r10 = r0;
     */
    /* JADX WARNING: Missing block: B:15:0x00da, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:16:0x00db, code skipped:
            r10 = r0;
     */
    /* JADX WARNING: Missing block: B:17:0x00de, code skipped:
            r2 = -4;
     */
    /* JADX WARNING: Missing block: B:25:0x0100, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:26:0x0101, code skipped:
            r10 = r0;
            r10.printStackTrace();
            com.tencent.open.b.g.a().a(r4, r6, 0, 0, getErrorCodeFromException(r10));
     */
    /* JADX WARNING: Missing block: B:27:0x0118, code skipped:
            throw r10;
     */
    /* JADX WARNING: Missing block: B:28:0x0119, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:29:0x011a, code skipped:
            r10 = r0;
            r10.printStackTrace();
            com.tencent.open.b.g.a().a(r4, r6, 0, 0, -3);
     */
    /* JADX WARNING: Missing block: B:30:0x012e, code skipped:
            throw r10;
     */
    /* JADX WARNING: Missing block: B:31:0x012f, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:32:0x0130, code skipped:
            r1 = r0;
            r1.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:33:0x0134, code skipped:
            throw r1;
     */
    /* JADX WARNING: Missing block: B:34:0x0135, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:35:0x0136, code skipped:
            r10 = r0;
            r10.printStackTrace();
     */
    /* JADX WARNING: Missing block: B:37:?, code skipped:
            r1 = java.lang.Integer.parseInt(r10.getMessage().replace(com.tencent.open.utils.HttpUtils.HttpStatusException.ERROR_INFO, ""));
     */
    /* JADX WARNING: Missing block: B:38:0x014b, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:39:0x014c, code skipped:
            r0.printStackTrace();
            r1 = -9;
     */
    /* JADX WARNING: Missing block: B:46:0x0170, code skipped:
            r1 = android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARNING: Missing block: B:47:0x0175, code skipped:
            com.tencent.open.b.g.a().a(r4, r6, 0, 0, -8);
     */
    /* JADX WARNING: Missing block: B:48:0x0183, code skipped:
            throw r10;
     */
    /* JADX WARNING: Missing block: B:56:0x0199, code skipped:
            r14 = r2;
            r9 = r11;
            r10 = 0;
            r15 = 0;
     */
    public static org.json.JSONObject request(com.tencent.connect.auth.QQToken r21, android.content.Context r22, java.lang.String r23, android.os.Bundle r24, java.lang.String r25) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        /*
        r1 = r22;
        r2 = r23;
        r3 = "openSDK_LOG.HttpUtils";
        r4 = "OpenApi request";
        com.tencent.open.a.f.a(r3, r4);
        r3 = r23.toLowerCase();
        r4 = "http";
        r3 = r3.startsWith(r4);
        if (r3 != 0) goto L_0x004d;
    L_0x0017:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = com.tencent.open.utils.g.a();
        r5 = "https://openmobile.qq.com/";
        r4 = r4.a(r1, r5);
        r3.append(r4);
        r3.append(r2);
        r3 = r3.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = com.tencent.open.utils.g.a();
        r6 = "https://openmobile.qq.com/";
        r5 = r5.a(r1, r6);
        r4.append(r5);
        r4.append(r2);
        r4 = r4.toString();
        r5 = r3;
        r3 = r21;
        goto L_0x0051;
    L_0x004d:
        r3 = r21;
        r4 = r2;
        r5 = r4;
    L_0x0051:
        a(r1, r3, r2);
        r2 = 0;
        r6 = android.os.SystemClock.elapsedRealtime();
        r8 = 0;
        r9 = r21.getAppId();
        r9 = com.tencent.open.utils.f.a(r1, r9);
        r10 = "Common_HttpRetryCount";
        r9 = r9.a(r10);
        r10 = "OpenConfig_test";
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = "config 1:Common_HttpRetryCount            config_value:";
        r11.append(r12);
        r11.append(r9);
        r12 = "   appid:";
        r11.append(r12);
        r12 = r21.getAppId();
        r11.append(r12);
        r12 = "     url:";
        r11.append(r12);
        r11.append(r4);
        r11 = r11.toString();
        com.tencent.open.a.f.a(r10, r11);
        if (r9 != 0) goto L_0x0095;
    L_0x0094:
        r9 = 3;
    L_0x0095:
        r10 = "OpenConfig_test";
        r11 = new java.lang.StringBuilder;
        r11.<init>();
        r12 = "config 1:Common_HttpRetryCount            result_value:";
        r11.append(r12);
        r11.append(r9);
        r12 = "   appid:";
        r11.append(r12);
        r3 = r21.getAppId();
        r11.append(r3);
        r3 = "     url:";
        r11.append(r3);
        r11.append(r4);
        r3 = r11.toString();
        com.tencent.open.a.f.a(r10, r3);
    L_0x00bf:
        r8 = r8 + 1;
        r3 = r24;
        r12 = r25;
        r13 = openUrl2(r1, r5, r12, r3);	 Catch:{ ConnectTimeoutException -> 0x0184, SocketTimeoutException -> 0x0163, HttpStatusException -> 0x0135, NetworkUnavailableException -> 0x012f, MalformedURLException -> 0x0119, IOException -> 0x0100, JSONException -> 0x00ea }
        r14 = r13.a;	 Catch:{ ConnectTimeoutException -> 0x0184, SocketTimeoutException -> 0x0163, HttpStatusException -> 0x0135, NetworkUnavailableException -> 0x012f, MalformedURLException -> 0x0119, IOException -> 0x0100, JSONException -> 0x00ea }
        r14 = com.tencent.open.utils.j.d(r14);	 Catch:{ ConnectTimeoutException -> 0x0184, SocketTimeoutException -> 0x0163, HttpStatusException -> 0x0135, NetworkUnavailableException -> 0x012f, MalformedURLException -> 0x0119, IOException -> 0x0100, JSONException -> 0x00ea }
        r2 = "ret";
        r2 = r14.getInt(r2);	 Catch:{ JSONException -> 0x00de, ConnectTimeoutException -> 0x00da, SocketTimeoutException -> 0x00d6, HttpStatusException -> 0x0135, NetworkUnavailableException -> 0x012f, MalformedURLException -> 0x0119, IOException -> 0x0100 }
        goto L_0x00df;
    L_0x00d6:
        r0 = move-exception;
        r10 = r0;
        goto L_0x0166;
    L_0x00da:
        r0 = move-exception;
        r10 = r0;
        goto L_0x0187;
    L_0x00de:
        r2 = -4;
    L_0x00df:
        r10 = r13.b;	 Catch:{ ConnectTimeoutException -> 0x00da, SocketTimeoutException -> 0x00d6, HttpStatusException -> 0x0135, NetworkUnavailableException -> 0x012f, MalformedURLException -> 0x0119, IOException -> 0x0100, JSONException -> 0x00ea }
        r17 = r2;
        r1 = r13.c;	 Catch:{ ConnectTimeoutException -> 0x00da, SocketTimeoutException -> 0x00d6, HttpStatusException -> 0x0135, NetworkUnavailableException -> 0x012f, MalformedURLException -> 0x0119, IOException -> 0x0100, JSONException -> 0x00ea }
        r15 = r1;
        r9 = r17;
        goto L_0x019f;
    L_0x00ea:
        r0 = move-exception;
        r10 = r0;
        r10.printStackTrace();
        r9 = -4;
        r11 = 0;
        r13 = 0;
        r1 = com.tencent.open.b.g.a();
        r2 = r4;
        r3 = r6;
        r5 = r11;
        r7 = r13;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
    L_0x0100:
        r0 = move-exception;
        r10 = r0;
        r10.printStackTrace();
        r9 = getErrorCodeFromException(r10);
        r11 = 0;
        r13 = 0;
        r1 = com.tencent.open.b.g.a();
        r2 = r4;
        r3 = r6;
        r5 = r11;
        r7 = r13;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
    L_0x0119:
        r0 = move-exception;
        r10 = r0;
        r10.printStackTrace();
        r9 = -3;
        r11 = 0;
        r13 = 0;
        r1 = com.tencent.open.b.g.a();
        r2 = r4;
        r3 = r6;
        r5 = r11;
        r7 = r13;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
    L_0x012f:
        r0 = move-exception;
        r1 = r0;
        r1.printStackTrace();
        throw r1;
    L_0x0135:
        r0 = move-exception;
        r10 = r0;
        r10.printStackTrace();
        r1 = r10.getMessage();
        r2 = "http status code error:";
        r3 = "";
        r1 = r1.replace(r2, r3);	 Catch:{ Exception -> 0x014b }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x014b }
        goto L_0x0152;
    L_0x014b:
        r0 = move-exception;
        r1 = r0;
        r1.printStackTrace();
        r1 = -9;
    L_0x0152:
        r9 = r1;
        r11 = 0;
        r13 = 0;
        r1 = com.tencent.open.b.g.a();
        r2 = r4;
        r3 = r6;
        r5 = r11;
        r7 = r13;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
    L_0x0163:
        r0 = move-exception;
        r10 = r0;
        r14 = r2;
    L_0x0166:
        r10.printStackTrace();
        r11 = -8;
        r17 = 0;
        r19 = 0;
        if (r8 >= r9) goto L_0x0175;
    L_0x0170:
        r1 = android.os.SystemClock.elapsedRealtime();
        goto L_0x0195;
    L_0x0175:
        r1 = com.tencent.open.b.g.a();
        r2 = r4;
        r3 = r6;
        r5 = r17;
        r7 = r19;
        r9 = r11;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
    L_0x0184:
        r0 = move-exception;
        r10 = r0;
        r14 = r2;
    L_0x0187:
        r10.printStackTrace();
        r11 = -7;
        r17 = 0;
        r19 = 0;
        if (r8 >= r9) goto L_0x01af;
    L_0x0191:
        r1 = android.os.SystemClock.elapsedRealtime();
    L_0x0195:
        r6 = r1;
        r2 = r14;
        if (r8 < r9) goto L_0x01ab;
    L_0x0199:
        r14 = r2;
        r9 = r11;
        r10 = 0;
        r15 = 0;
    L_0x019f:
        r1 = com.tencent.open.b.g.a();
        r2 = r4;
        r3 = r6;
        r5 = r10;
        r7 = r15;
        r1.a(r2, r3, r5, r7, r9);
        return r14;
    L_0x01ab:
        r1 = r22;
        goto L_0x00bf;
    L_0x01af:
        r1 = com.tencent.open.b.g.a();
        r2 = r4;
        r3 = r6;
        r5 = r17;
        r7 = r19;
        r9 = r11;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.request(com.tencent.connect.auth.QQToken, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

    public static void requestAsync(QQToken qQToken, Context context, String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        f.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        final QQToken qQToken2 = qQToken;
        final Context context2 = context;
        final String str3 = str;
        final Bundle bundle2 = bundle;
        final String str4 = str2;
        final IRequestListener iRequestListener2 = iRequestListener;
        new Thread() {
            public void run() {
                try {
                    JSONObject request = HttpUtils.request(qQToken2, context2, str3, bundle2, str4);
                    if (iRequestListener2 != null) {
                        iRequestListener2.onComplete(request);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                    }
                } catch (MalformedURLException e) {
                    if (iRequestListener2 != null) {
                        iRequestListener2.onMalformedURLException(e);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException", e);
                    }
                } catch (ConnectTimeoutException e2) {
                    if (iRequestListener2 != null) {
                        iRequestListener2.onConnectTimeoutException(e2);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException", e2);
                    }
                } catch (SocketTimeoutException e3) {
                    if (iRequestListener2 != null) {
                        iRequestListener2.onSocketTimeoutException(e3);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException", e3);
                    }
                } catch (NetworkUnavailableException e4) {
                    if (iRequestListener2 != null) {
                        iRequestListener2.onNetworkUnavailableException(e4);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException", e4);
                    }
                } catch (HttpStatusException e5) {
                    if (iRequestListener2 != null) {
                        iRequestListener2.onHttpStatusException(e5);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException", e5);
                    }
                } catch (IOException e6) {
                    if (iRequestListener2 != null) {
                        iRequestListener2.onIOException(e6);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException", e6);
                    }
                } catch (JSONException e7) {
                    if (iRequestListener2 != null) {
                        iRequestListener2.onJSONException(e7);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException", e7);
                    }
                } catch (Exception e8) {
                    if (iRequestListener2 != null) {
                        iRequestListener2.onUnknowException(e8);
                        f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException", e8);
                    }
                }
            }
        }.start();
    }
}
