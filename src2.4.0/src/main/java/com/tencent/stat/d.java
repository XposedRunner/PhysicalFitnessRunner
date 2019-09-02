package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import cn.jiguang.net.HttpUtils;
import com.tencent.stat.a.e;
import com.tencent.stat.a.f;
import com.tencent.stat.common.StatConstants;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.k;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class d {
    private static StatLogger c = k.b();
    private static long d = -1;
    private static d e;
    private static Context f;
    DefaultHttpClient a = null;
    Handler b = null;

    private d() {
        try {
            HandlerThread handlerThread = new HandlerThread("StatDispatcher");
            handlerThread.start();
            d = handlerThread.getId();
            this.b = new Handler(handlerThread.getLooper());
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
            HttpConnectionParams.setSoTimeout(basicHttpParams, 10000);
            this.a = new DefaultHttpClient(basicHttpParams);
            this.a.setKeepAliveStrategy(new e(this));
            if (StatConfig.b() != null) {
                this.a.getParams().setParameter("http.route.default-proxy", StatConfig.b());
            }
        } catch (Throwable th) {
            c.e(th);
        }
    }

    static Context a() {
        return f;
    }

    static void a(Context context) {
        f = context.getApplicationContext();
    }

    static synchronized d b() {
        d dVar;
        synchronized (d.class) {
            if (e == null) {
                e = new d();
            }
            dVar = e;
        }
        return dVar;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(e eVar, c cVar) {
        b(Arrays.asList(new String[]{eVar.d()}), cVar);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(List<String> list, c cVar) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            int i;
            StatLogger statLogger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            int i2 = 0;
            while (true) {
                i = 1;
                if (i2 >= list.size()) {
                    break;
                }
                stringBuilder.append((String) list.get(i2));
                if (i2 != list.size() - 1) {
                    stringBuilder.append(",");
                }
                i2++;
            }
            stringBuilder.append("]");
            String statReportUrl = StatConfig.getStatReportUrl();
            StatLogger statLogger2 = c;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("[");
            stringBuilder2.append(statReportUrl);
            stringBuilder2.append("]Send request(");
            stringBuilder2.append(stringBuilder.toString().length());
            stringBuilder2.append("bytes):");
            stringBuilder2.append(stringBuilder.toString());
            statLogger2.i(stringBuilder2.toString());
            HttpPost httpPost = new HttpPost(statReportUrl);
            httpPost.addHeader("Accept-Encoding", "gzip");
            httpPost.setHeader("Connection", "Keep-Alive");
            httpPost.removeHeaders("Cache-Control");
            HttpHost a = k.a(f);
            if (a != null) {
                this.a.getParams().setParameter("http.route.default-proxy", k.a(f));
                httpPost.addHeader("X-Online-Host", StatConstants.MTA_SERVER);
                httpPost.addHeader("Accept", "*/*");
                httpPost.addHeader("Content-Type", "json");
            } else {
                i = 0;
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = stringBuilder.toString().getBytes(HttpUtils.ENCODING_UTF_8);
            int length = bytes.length;
            String str;
            if (stringBuilder.length() < 256) {
                if (a == null) {
                    statReportUrl = "Content-Encoding";
                    str = "rc4";
                } else {
                    statReportUrl = "X-Content-Encoding";
                    str = "rc4";
                }
                httpPost.addHeader(statReportUrl, str);
            } else {
                if (a == null) {
                    statReportUrl = "Content-Encoding";
                    str = "rc4,gzip";
                } else {
                    statReportUrl = "X-Content-Encoding";
                    str = "rc4,gzip";
                }
                httpPost.addHeader(statReportUrl, str);
                byteArrayOutputStream.write(new byte[4]);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                bytes = byteArrayOutputStream.toByteArray();
                ByteBuffer.wrap(bytes, 0, 4).putInt(length);
                statLogger = c;
                stringBuilder = new StringBuilder();
                stringBuilder.append("before Gzip:");
                stringBuilder.append(length);
                stringBuilder.append(" bytes, after Gzip:");
                stringBuilder.append(bytes.length);
                stringBuilder.append(" bytes");
                statLogger.d(stringBuilder.toString());
            }
            httpPost.setEntity(new ByteArrayEntity(com.tencent.stat.common.e.a(bytes)));
            HttpResponse execute = this.a.execute(httpPost);
            if (i != 0) {
                this.a.getParams().removeParameter("http.route.default-proxy");
            }
            HttpEntity entity = execute.getEntity();
            int statusCode = execute.getStatusLine().getStatusCode();
            long contentLength = entity.getContentLength();
            statLogger2 = c;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("recv response status code:");
            stringBuilder3.append(statusCode);
            stringBuilder3.append(", content length:");
            stringBuilder3.append(contentLength);
            statLogger2.i(stringBuilder3.toString());
            if (contentLength == 0) {
                EntityUtils.toString(entity);
                if (statusCode != 200) {
                    statLogger = c;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Server response error code:");
                    stringBuilder.append(statusCode);
                    statLogger.error(stringBuilder.toString());
                } else if (cVar != null) {
                    cVar.a();
                }
            } else if (contentLength > 0) {
                InputStream content = entity.getContent();
                DataInputStream dataInputStream = new DataInputStream(content);
                byte[] bArr = new byte[((int) entity.getContentLength())];
                dataInputStream.readFully(bArr);
                content.close();
                dataInputStream.close();
                Header firstHeader = execute.getFirstHeader("Content-Encoding");
                if (firstHeader != null) {
                    if (firstHeader.getValue().equalsIgnoreCase("gzip,rc4")) {
                        bArr = com.tencent.stat.common.e.b(k.a(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4,gzip")) {
                        bArr = k.a(com.tencent.stat.common.e.b(bArr));
                    } else if (firstHeader.getValue().equalsIgnoreCase("gzip")) {
                        bArr = k.a(bArr);
                    } else if (firstHeader.getValue().equalsIgnoreCase("rc4")) {
                        bArr = com.tencent.stat.common.e.b(bArr);
                    }
                }
                StringBuilder stringBuilder4;
                if (statusCode == 200) {
                    statReportUrl = new String(bArr, HttpUtils.ENCODING_UTF_8);
                    c.d(statReportUrl);
                    JSONObject jSONObject = new JSONObject(statReportUrl);
                    if (!jSONObject.isNull("cfg")) {
                        StatConfig.a(jSONObject.getJSONObject("cfg"));
                    }
                    if (!(jSONObject.isNull("et") || jSONObject.isNull("st"))) {
                        StatLogger statLogger3 = c;
                        stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("get mid respone:");
                        stringBuilder4.append(statReportUrl);
                        statLogger3.d(stringBuilder4.toString());
                        if (jSONObject.getInt("et") == f.SESSION_ENV.a()) {
                            int i3 = jSONObject.getInt("st");
                            switch (i3) {
                                case -1:
                                case 0:
                                    if (!jSONObject.isNull(DeviceInfo.TAG_MID)) {
                                        StatMid.updateDeviceInfo(f, jSONObject.getString(DeviceInfo.TAG_MID));
                                        break;
                                    }
                                    break;
                                default:
                                    StatLogger statLogger4 = c;
                                    StringBuilder stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append("error type for st:");
                                    stringBuilder5.append(i3);
                                    statLogger4.e(stringBuilder5.toString());
                                    break;
                            }
                        }
                    }
                    if (cVar != null) {
                        cVar.a();
                    }
                } else {
                    statLogger = c;
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("Server response error code:");
                    stringBuilder4.append(statusCode);
                    stringBuilder4.append(", error:");
                    stringBuilder4.append(new String(bArr, HttpUtils.ENCODING_UTF_8));
                    statLogger.error(stringBuilder4.toString());
                }
                content.close();
            } else {
                EntityUtils.toString(entity);
            }
        } catch (Throwable th) {
            c.e(th);
            if (cVar != null) {
                try {
                    cVar.b();
                    return;
                } catch (Throwable th2) {
                    c.e(th2);
                    return;
                }
            }
            return;
        }
        byteArrayOutputStream.close();
    }

    /* Access modifiers changed, original: 0000 */
    public void b(List<String> list, c cVar) {
        if (!list.isEmpty() && this.b != null) {
            this.b.post(new f(this, list, cVar));
        }
    }
}
