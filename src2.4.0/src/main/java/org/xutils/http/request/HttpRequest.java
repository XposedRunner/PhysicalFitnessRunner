package org.xutils.http.request;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o.O00000o0;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.cache.LruDiskCache;
import org.xutils.common.util.IOUtil;
import org.xutils.common.util.KeyValue;
import org.xutils.common.util.LogUtil;
import org.xutils.ex.HttpException;
import org.xutils.http.BaseParams.Header;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.http.body.ProgressBody;
import org.xutils.http.body.RequestBody;
import org.xutils.http.cookie.DbCookieStore;

public class HttpRequest extends UriRequest {
    private static final CookieManager COOKIE_MANAGER = new CookieManager(DbCookieStore.INSTANCE, CookiePolicy.ACCEPT_ALL);
    private String cacheKey = null;
    private HttpURLConnection connection = null;
    private InputStream inputStream = null;
    private boolean isLoading = false;
    private int responseCode = 0;

    HttpRequest(RequestParams requestParams, Type type) throws Throwable {
        super(requestParams, type);
    }

    private static String toGMTString(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM y HH:mm:ss 'GMT'", Locale.US);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        simpleDateFormat.setTimeZone(timeZone);
        new GregorianCalendar(timeZone).setTimeInMillis(date.getTime());
        return simpleDateFormat.format(date);
    }

    /* Access modifiers changed, original: protected */
    public String buildQueryUrl(RequestParams requestParams) {
        String uri = requestParams.getUri();
        StringBuilder stringBuilder = new StringBuilder(uri);
        if (!uri.contains("?")) {
            stringBuilder.append("?");
        } else if (!uri.endsWith("?")) {
            stringBuilder.append("&");
        }
        List<KeyValue> queryStringParams = requestParams.getQueryStringParams();
        if (queryStringParams != null) {
            for (KeyValue keyValue : queryStringParams) {
                String str = keyValue.key;
                String valueStr = keyValue.getValueStr();
                if (!(TextUtils.isEmpty(str) || valueStr == null)) {
                    stringBuilder.append(Uri.encode(str, requestParams.getCharset()));
                    stringBuilder.append("=");
                    stringBuilder.append(Uri.encode(valueStr, requestParams.getCharset()));
                    stringBuilder.append("&");
                }
            }
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) == '&') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) == '?') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public void clearCacheHeader() {
        this.params.setHeader("If-Modified-Since", null);
        this.params.setHeader("If-None-Match", null);
    }

    public void close() throws IOException {
        if (this.inputStream != null) {
            IOUtil.closeQuietly(this.inputStream);
            this.inputStream = null;
        }
        if (this.connection != null) {
            this.connection.disconnect();
        }
    }

    public String getCacheKey() {
        if (this.cacheKey == null) {
            this.cacheKey = this.params.getCacheKey();
            if (TextUtils.isEmpty(this.cacheKey)) {
                this.cacheKey = this.params.toString();
            }
        }
        return this.cacheKey;
    }

    public long getContentLength() {
        long j = 0;
        if (this.connection == null) {
            return (long) getInputStream().available();
        }
        try {
            j = (long) this.connection.getContentLength();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        if (j >= 1) {
            return j;
        }
        try {
            return (long) getInputStream().available();
        } catch (Throwable unused) {
            return j;
        }
    }

    public String getETag() {
        return this.connection == null ? null : this.connection.getHeaderField("ETag");
    }

    public long getExpiration() {
        long j = -1;
        if (this.connection == null) {
            return -1;
        }
        String headerField = this.connection.getHeaderField("Cache-Control");
        if (!TextUtils.isEmpty(headerField)) {
            StringTokenizer stringTokenizer = new StringTokenizer(headerField, ",");
            while (stringTokenizer.hasMoreTokens()) {
                headerField = stringTokenizer.nextToken().trim().toLowerCase();
                if (headerField.startsWith("max-age")) {
                    int indexOf = headerField.indexOf(61);
                    if (indexOf > 0) {
                        try {
                            long parseLong = Long.parseLong(headerField.substring(indexOf + 1).trim());
                            if (parseLong > 0) {
                                j = System.currentTimeMillis() + (parseLong * 1000);
                            }
                        } catch (Throwable th) {
                            LogUtil.e(th.getMessage(), th);
                        }
                    }
                }
            }
        }
        if (j <= 0) {
            j = this.connection.getExpiration();
        }
        if (j <= 0 && this.params.getCacheMaxAge() > 0) {
            j = System.currentTimeMillis() + this.params.getCacheMaxAge();
        }
        if (j <= 0) {
            j = Long.MAX_VALUE;
        }
        return j;
    }

    public long getHeaderFieldDate(String str, long j) {
        return this.connection == null ? j : this.connection.getHeaderFieldDate(str, j);
    }

    public InputStream getInputStream() throws IOException {
        if (this.connection != null && this.inputStream == null) {
            this.inputStream = this.connection.getResponseCode() >= 400 ? this.connection.getErrorStream() : this.connection.getInputStream();
        }
        return this.inputStream;
    }

    public long getLastModified() {
        return getHeaderFieldDate("Last-Modified", System.currentTimeMillis());
    }

    public String getRequestUri() {
        String str = this.queryUrl;
        if (this.connection == null) {
            return str;
        }
        URL url = this.connection.getURL();
        return url != null ? url.toString() : str;
    }

    public int getResponseCode() throws IOException {
        return this.connection != null ? this.responseCode : getInputStream() != null ? 200 : 404;
    }

    public String getResponseHeader(String str) {
        return this.connection == null ? null : this.connection.getHeaderField(str);
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.connection == null ? null : this.connection.getHeaderFields();
    }

    public String getResponseMessage() throws IOException {
        if (this.connection == null) {
            return null;
        }
        return URLDecoder.decode(this.connection.getResponseMessage() == null ? "" : this.connection.getResponseMessage(), this.params.getCharset());
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public Object loadResult() throws Throwable {
        this.isLoading = true;
        return super.loadResult();
    }

    public Object loadResultFromCache() throws Throwable {
        this.isLoading = true;
        DiskCacheEntity diskCacheEntity = LruDiskCache.getDiskCache(this.params.getCacheDirName()).setMaxSize(this.params.getCacheSize()).get(getCacheKey());
        if (diskCacheEntity == null) {
            return null;
        }
        if (HttpMethod.permitsCache(this.params.getMethod())) {
            Date lastModify = diskCacheEntity.getLastModify();
            if (lastModify.getTime() > 0) {
                this.params.setHeader("If-Modified-Since", toGMTString(lastModify));
            }
            String etag = diskCacheEntity.getEtag();
            if (!TextUtils.isEmpty(etag)) {
                this.params.setHeader("If-None-Match", etag);
            }
        }
        return this.loader.loadFromCache(diskCacheEntity);
    }

    @TargetApi(19)
    public void sendRequest() throws Throwable {
        this.isLoading = false;
        this.responseCode = 0;
        URL url = new URL(this.queryUrl);
        Proxy proxy = this.params.getProxy();
        if (proxy != null) {
            this.connection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            this.connection = (HttpURLConnection) url.openConnection();
        }
        if (VERSION.SDK_INT < 19) {
            this.connection.setRequestProperty("Connection", O00000o0.O00000o0);
        }
        this.connection.setReadTimeout(this.params.getConnectTimeout());
        this.connection.setConnectTimeout(this.params.getConnectTimeout());
        this.connection.setInstanceFollowRedirects(this.params.getRedirectHandler() == null);
        if (this.connection instanceof HttpsURLConnection) {
            SSLSocketFactory sslSocketFactory = this.params.getSslSocketFactory();
            if (sslSocketFactory != null) {
                ((HttpsURLConnection) this.connection).setSSLSocketFactory(sslSocketFactory);
            }
        }
        if (this.params.isUseCookie()) {
            try {
                List list = (List) COOKIE_MANAGER.get(url.toURI(), new HashMap(0)).get("Cookie");
                if (list != null) {
                    this.connection.setRequestProperty("Cookie", TextUtils.join(";", list));
                }
            } catch (Throwable th) {
                LogUtil.e(th.getMessage(), th);
            }
        }
        List<Header> headers = this.params.getHeaders();
        if (headers != null) {
            for (Header header : headers) {
                String str = header.key;
                String valueStr = header.getValueStr();
                if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(valueStr))) {
                    if (header.setHeader) {
                        this.connection.setRequestProperty(str, valueStr);
                    } else {
                        this.connection.addRequestProperty(str, valueStr);
                    }
                }
            }
        }
        if (this.requestInterceptListener != null) {
            this.requestInterceptListener.beforeRequest(this);
        }
        HttpMethod method = this.params.getMethod();
        try {
            this.connection.setRequestMethod(method.toString());
        } catch (ProtocolException e) {
            Field declaredField = HttpURLConnection.class.getDeclaredField("method");
            declaredField.setAccessible(true);
            declaredField.set(this.connection, method.toString());
        }
        if (HttpMethod.permitsRequestBody(method)) {
            RequestBody requestBody = this.params.getRequestBody();
            if (requestBody != null) {
                if (requestBody instanceof ProgressBody) {
                    ((ProgressBody) requestBody).setProgressHandler(this.progressHandler);
                }
                String contentType = requestBody.getContentType();
                if (!TextUtils.isEmpty(contentType)) {
                    this.connection.setRequestProperty("Content-Type", contentType);
                }
                long contentLength = requestBody.getContentLength();
                if (contentLength < 0) {
                    this.connection.setChunkedStreamingMode(262144);
                } else if (contentLength < 2147483647L) {
                    this.connection.setFixedLengthStreamingMode((int) contentLength);
                } else if (VERSION.SDK_INT >= 19) {
                    this.connection.setFixedLengthStreamingMode(contentLength);
                } else {
                    this.connection.setChunkedStreamingMode(262144);
                }
                this.connection.setRequestProperty("Content-Length", String.valueOf(contentLength));
                this.connection.setDoOutput(true);
                requestBody.writeTo(this.connection.getOutputStream());
            }
        }
        if (this.params.isUseCookie()) {
            try {
                Map headerFields = this.connection.getHeaderFields();
                if (headerFields != null) {
                    COOKIE_MANAGER.put(url.toURI(), headerFields);
                }
            } catch (Throwable th2) {
                LogUtil.e(th2.getMessage(), th2);
            }
        }
        this.responseCode = this.connection.getResponseCode();
        if (this.requestInterceptListener != null) {
            this.requestInterceptListener.afterRequest(this);
        }
        if (this.responseCode == 204 || this.responseCode == 205) {
            throw new HttpException(this.responseCode, getResponseMessage());
        } else if (this.responseCode >= 300) {
            HttpException httpException = new HttpException(this.responseCode, getResponseMessage());
            try {
                httpException.setResult(IOUtil.readStr(getInputStream(), this.params.getCharset()));
            } catch (Throwable unused) {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(httpException.toString());
            stringBuilder.append(", url: ");
            stringBuilder.append(this.queryUrl);
            LogUtil.e(stringBuilder.toString());
            throw httpException;
        } else {
            this.isLoading = true;
        }
    }
}
