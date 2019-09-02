package org.xutils.http;

import android.text.TextUtils;
import java.io.IOException;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.SSLSocketFactory;
import org.xutils.common.task.Priority;
import org.xutils.common.util.LogUtil;
import org.xutils.http.annotation.HttpRequest;
import org.xutils.http.app.DefaultParamsBuilder;
import org.xutils.http.app.HttpRetryHandler;
import org.xutils.http.app.ParamsBuilder;
import org.xutils.http.app.RedirectHandler;
import org.xutils.http.app.RequestTracker;
import org.xutils.http.body.RequestBody;

public class RequestParams extends BaseParams {
    private boolean autoRename;
    private boolean autoResume;
    private String buildCacheKey;
    private String buildUri;
    private ParamsBuilder builder;
    private String cacheDirName;
    private final String[] cacheKeys;
    private long cacheMaxAge;
    private long cacheSize;
    private boolean cancelFast;
    private int connectTimeout;
    private Executor executor;
    private HttpRequest httpRequest;
    private HttpRetryHandler httpRetryHandler;
    private boolean invokedGetHttpRequest;
    private int loadingUpdateMaxTimeSpan;
    private int maxRetryCount;
    private Priority priority;
    private Proxy proxy;
    private RedirectHandler redirectHandler;
    private RequestTracker requestTracker;
    private String saveFilePath;
    private final String[] signs;
    private SSLSocketFactory sslSocketFactory;
    private final String uri;
    private boolean useCookie;

    public RequestParams() {
        this(null, null, null, null);
    }

    public RequestParams(String str) {
        this(str, null, null, null);
    }

    public RequestParams(String str, ParamsBuilder paramsBuilder, String[] strArr, String[] strArr2) {
        this.useCookie = true;
        this.priority = Priority.DEFAULT;
        this.connectTimeout = 15000;
        this.autoResume = true;
        this.autoRename = false;
        this.maxRetryCount = 2;
        this.cancelFast = false;
        this.loadingUpdateMaxTimeSpan = 300;
        this.invokedGetHttpRequest = false;
        if (str != null && paramsBuilder == null) {
            paramsBuilder = new DefaultParamsBuilder();
        }
        this.uri = str;
        this.signs = strArr;
        this.cacheKeys = strArr2;
        this.builder = paramsBuilder;
    }

    private HttpRequest getHttpRequest() {
        if (this.httpRequest == null && !this.invokedGetHttpRequest) {
            this.invokedGetHttpRequest = true;
            Class cls = getClass();
            if (cls != RequestParams.class) {
                this.httpRequest = (HttpRequest) cls.getAnnotation(HttpRequest.class);
            }
        }
        return this.httpRequest;
    }

    private void initEntityParams() {
        RequestParamsHelper.parseKV(this, getClass(), new ParseKVListener() {
            public void onParseKV(String str, Object obj) {
                RequestParams.this.addParameter(str, obj);
            }
        });
    }

    public /* bridge */ /* synthetic */ void addBodyParameter(String str, Object obj, String str2) {
        super.addBodyParameter(str, obj, str2);
    }

    public /* bridge */ /* synthetic */ void addBodyParameter(String str, Object obj, String str2, String str3) {
        super.addBodyParameter(str, obj, str2, str3);
    }

    public /* bridge */ /* synthetic */ void addHeader(String str, String str2) {
        super.addHeader(str, str2);
    }

    public /* bridge */ /* synthetic */ void addParameter(String str, Object obj) {
        super.addParameter(str, obj);
    }

    public /* bridge */ /* synthetic */ void addQueryStringParameter(String str, String str2) {
        super.addQueryStringParameter(str, str2);
    }

    public /* bridge */ /* synthetic */ void clearParams() {
        super.clearParams();
    }

    public /* bridge */ /* synthetic */ String getBodyContent() {
        return super.getBodyContent();
    }

    public /* bridge */ /* synthetic */ List getBodyParams() {
        return super.getBodyParams();
    }

    public String getCacheDirName() {
        return this.cacheDirName;
    }

    public String getCacheKey() {
        if (TextUtils.isEmpty(this.buildCacheKey) && this.builder != null) {
            HttpRequest httpRequest = getHttpRequest();
            if (httpRequest != null) {
                this.buildCacheKey = this.builder.buildCacheKey(this, httpRequest.cacheKeys());
            } else {
                this.buildCacheKey = this.builder.buildCacheKey(this, this.cacheKeys);
            }
        }
        return this.buildCacheKey;
    }

    public long getCacheMaxAge() {
        return this.cacheMaxAge;
    }

    public long getCacheSize() {
        return this.cacheSize;
    }

    public /* bridge */ /* synthetic */ String getCharset() {
        return super.getCharset();
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    public /* bridge */ /* synthetic */ List getFileParams() {
        return super.getFileParams();
    }

    public /* bridge */ /* synthetic */ List getHeaders() {
        return super.getHeaders();
    }

    public HttpRetryHandler getHttpRetryHandler() {
        return this.httpRetryHandler;
    }

    public int getLoadingUpdateMaxTimeSpan() {
        return this.loadingUpdateMaxTimeSpan;
    }

    public int getMaxRetryCount() {
        return this.maxRetryCount;
    }

    public /* bridge */ /* synthetic */ HttpMethod getMethod() {
        return super.getMethod();
    }

    public /* bridge */ /* synthetic */ List getParams(String str) {
        return super.getParams(str);
    }

    public Priority getPriority() {
        return this.priority;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public /* bridge */ /* synthetic */ List getQueryStringParams() {
        return super.getQueryStringParams();
    }

    public RedirectHandler getRedirectHandler() {
        return this.redirectHandler;
    }

    public /* bridge */ /* synthetic */ RequestBody getRequestBody() throws IOException {
        return super.getRequestBody();
    }

    public RequestTracker getRequestTracker() {
        return this.requestTracker;
    }

    public String getSaveFilePath() {
        return this.saveFilePath;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public /* bridge */ /* synthetic */ String getStringParameter(String str) {
        return super.getStringParameter(str);
    }

    public /* bridge */ /* synthetic */ List getStringParams() {
        return super.getStringParams();
    }

    public String getUri() {
        return TextUtils.isEmpty(this.buildUri) ? this.uri : this.buildUri;
    }

    /* Access modifiers changed, original: 0000 */
    public void init() throws Throwable {
        if (!TextUtils.isEmpty(this.buildUri)) {
            return;
        }
        if (TextUtils.isEmpty(this.uri) && getHttpRequest() == null) {
            throw new IllegalStateException("uri is empty && @HttpRequest == null");
        }
        initEntityParams();
        this.buildUri = this.uri;
        HttpRequest httpRequest = getHttpRequest();
        if (httpRequest != null) {
            this.builder = (ParamsBuilder) httpRequest.builder().newInstance();
            this.buildUri = this.builder.buildUri(this, httpRequest);
            this.builder.buildParams(this);
            this.builder.buildSign(this, httpRequest.signs());
            if (this.sslSocketFactory == null) {
                this.sslSocketFactory = this.builder.getSSLSocketFactory();
            }
        } else if (this.builder != null) {
            this.builder.buildParams(this);
            this.builder.buildSign(this, this.signs);
            if (this.sslSocketFactory == null) {
                this.sslSocketFactory = this.builder.getSSLSocketFactory();
            }
        }
    }

    public /* bridge */ /* synthetic */ boolean isAsJsonContent() {
        return super.isAsJsonContent();
    }

    public boolean isAutoRename() {
        return this.autoRename;
    }

    public boolean isAutoResume() {
        return this.autoResume;
    }

    public boolean isCancelFast() {
        return this.cancelFast;
    }

    public /* bridge */ /* synthetic */ boolean isMultipart() {
        return super.isMultipart();
    }

    public boolean isUseCookie() {
        return this.useCookie;
    }

    public /* bridge */ /* synthetic */ void removeParameter(String str) {
        super.removeParameter(str);
    }

    public /* bridge */ /* synthetic */ void setAsJsonContent(boolean z) {
        super.setAsJsonContent(z);
    }

    public void setAutoRename(boolean z) {
        this.autoRename = z;
    }

    public void setAutoResume(boolean z) {
        this.autoResume = z;
    }

    public /* bridge */ /* synthetic */ void setBodyContent(String str) {
        super.setBodyContent(str);
    }

    public void setCacheDirName(String str) {
        this.cacheDirName = str;
    }

    public void setCacheMaxAge(long j) {
        this.cacheMaxAge = j;
    }

    public void setCacheSize(long j) {
        this.cacheSize = j;
    }

    public void setCancelFast(boolean z) {
        this.cancelFast = z;
    }

    public /* bridge */ /* synthetic */ void setCharset(String str) {
        super.setCharset(str);
    }

    public void setConnectTimeout(int i) {
        if (i > 0) {
            this.connectTimeout = i;
        }
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public /* bridge */ /* synthetic */ void setHeader(String str, String str2) {
        super.setHeader(str, str2);
    }

    public void setHttpRetryHandler(HttpRetryHandler httpRetryHandler) {
        this.httpRetryHandler = httpRetryHandler;
    }

    public void setLoadingUpdateMaxTimeSpan(int i) {
        this.loadingUpdateMaxTimeSpan = i;
    }

    public void setMaxRetryCount(int i) {
        this.maxRetryCount = i;
    }

    public /* bridge */ /* synthetic */ void setMethod(HttpMethod httpMethod) {
        super.setMethod(httpMethod);
    }

    public /* bridge */ /* synthetic */ void setMultipart(boolean z) {
        super.setMultipart(z);
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public void setRedirectHandler(RedirectHandler redirectHandler) {
        this.redirectHandler = redirectHandler;
    }

    public /* bridge */ /* synthetic */ void setRequestBody(RequestBody requestBody) {
        super.setRequestBody(requestBody);
    }

    public void setRequestTracker(RequestTracker requestTracker) {
        this.requestTracker = requestTracker;
    }

    public void setSaveFilePath(String str) {
        this.saveFilePath = str;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setUseCookie(boolean z) {
        this.useCookie = z;
    }

    public /* bridge */ /* synthetic */ String toJSONString() {
        return super.toJSONString();
    }

    public String toString() {
        try {
            init();
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
        }
        String uri = getUri();
        if (TextUtils.isEmpty(uri)) {
            return super.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(uri);
        stringBuilder.append(uri.contains("?") ? "&" : "?");
        stringBuilder.append(super.toString());
        return stringBuilder.toString();
    }
}
