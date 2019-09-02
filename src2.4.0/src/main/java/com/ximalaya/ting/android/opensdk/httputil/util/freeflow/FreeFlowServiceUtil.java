package com.ximalaya.ting.android.opensdk.httputil.util.freeflow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.httputil.BaseCall;
import com.ximalaya.ting.android.opensdk.httputil.Config;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;
import com.ximalaya.ting.android.player.IGetHttpUrlConnectByUrl;
import com.ximalaya.ting.android.player.model.HttpConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import okhttp3.Authenticator;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.huc.OkHttpURLConnection;

public class FreeFlowServiceUtil {
    private static Interceptor interceptor;

    public interface ISetHttpUrlConnectAttribute {
        void setHttpUrlConnectAttributes(@NonNull HttpURLConnection httpURLConnection);
    }

    public static HttpURLConnection getHttpURLConnection(@Nullable Config config, String str, String str2, ISetHttpUrlConnectAttribute iSetHttpUrlConnectAttribute) throws IOException {
        if (str == null) {
            return null;
        }
        try {
            Proxy proxy;
            HttpURLConnection httpURLConnection;
            URL url = new URL(str);
            try {
                proxy = getProxy(config, "https".equalsIgnoreCase(url.toURI().getScheme()));
            } catch (Exception e) {
                e.printStackTrace();
                proxy = null;
            }
            boolean z = config != null ? config.useProxy : false;
            if (proxy == null || proxy == Proxy.NO_PROXY || !z) {
                httpURLConnection = (HttpURLConnection) url.openConnection();
            } else {
                httpURLConnection = new OkHttpURLConnection(url, BaseCall.getInstanse().getOkHttpClient(url));
                Map map = config.property;
                if (map != null) {
                    for (Entry entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                httpURLConnection.setInstanceFollowRedirects(false);
            }
            if (config != null) {
                httpURLConnection.setConnectTimeout(config.connectionTimeOut);
                httpURLConnection.setReadTimeout(config.readTimeOut);
            }
            httpURLConnection.setRequestMethod(str2);
            if (iSetHttpUrlConnectAttribute != null) {
                iSetHttpUrlConnectAttribute.setHttpUrlConnectAttributes(httpURLConnection);
            }
            return httpURLConnection;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Nullable
    public static Proxy getProxy(@Nullable Config config, boolean z) {
        if (config == null || !config.useProxy) {
            return null;
        }
        int i = config.proxyPort;
        if (z && config.httpsProxyPort > 0) {
            i = config.httpsProxyPort;
        }
        return new Proxy(Type.HTTP, new InetSocketAddress(config.proxyHost, i));
    }

    private static boolean shouldUpdateConnectPool(@NonNull Builder builder, long j) {
        try {
            Field declaredField = Builder.class.getDeclaredField("connectionPool");
            declaredField.setAccessible(true);
            ConnectionPool connectionPool = (ConnectionPool) declaredField.get(builder);
            if (connectionPool == null) {
                return true;
            }
            declaredField = ConnectionPool.class.getDeclaredField("keepAliveDurationNs");
            declaredField.setAccessible(true);
            return ((Long) declaredField.get(connectionPool)).longValue() != j;
        } catch (Exception e) {
            if (ConstantsOpenSdk.isDebug) {
                throw new RuntimeException("Config -> OKHTTP 底层框架发生改变需要做相应的处理!!!");
            }
            e.printStackTrace();
            return true;
        }
    }

    @Nullable
    public static HttpConfig toHttpConfig(@Nullable final Config config) {
        if (config == null) {
            return null;
        }
        HttpConfig httpConfig = new HttpConfig();
        httpConfig.useProxy = config.useProxy;
        httpConfig.useCache = config.useCache;
        httpConfig.proxyHost = config.proxyHost;
        httpConfig.proxyPort = config.proxyPort;
        httpConfig.httpsProxyPort = config.httpsProxyPort;
        httpConfig.authorization = config.authorization;
        httpConfig.connectionTimeOut = config.connectionTimeOut;
        httpConfig.readTimeOut = config.readTimeOut;
        httpConfig.writeTimeOut = config.writeTimeOut;
        httpConfig.method = config.method;
        httpConfig.property = config.property;
        if (BaseUtil.isMainApp()) {
            httpConfig.mGetHttpUrlConnectByUrl = new IGetHttpUrlConnectByUrl() {
                public HttpURLConnection getHttpUrlConnect(String str, String str2, final HttpConfig httpConfig) {
                    try {
                        return FreeFlowServiceUtil.getHttpURLConnection(config, str, str2, new ISetHttpUrlConnectAttribute() {
                            public void setHttpUrlConnectAttributes(@NonNull HttpURLConnection httpURLConnection) {
                                if (httpConfig != null) {
                                    httpURLConnection.setReadTimeout(httpConfig.readTimeOut);
                                    httpURLConnection.setConnectTimeout(httpConfig.connectionTimeOut);
                                    if (httpConfig.property != null) {
                                        for (Entry entry : httpConfig.property.entrySet()) {
                                            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                                        }
                                    }
                                }
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            };
        }
        return httpConfig;
    }

    public static Builder updateProxyToBuilder(@NonNull Context context, @Nullable final Config config, @NonNull Builder builder, boolean z) {
        builder.retryOnConnectionFailure(true);
        if (config != null) {
            builder.connectTimeout((long) config.connectionTimeOut, TimeUnit.MILLISECONDS);
            builder.readTimeout((long) config.connectionTimeOut, TimeUnit.MILLISECONDS);
            builder.writeTimeout((long) config.writeTimeOut, TimeUnit.MILLISECONDS);
        }
        if (config == null || !config.useProxy || TextUtils.isEmpty(config.proxyHost) || config.proxyPort <= 0) {
            builder.proxy(null);
            if (interceptor != null) {
                builder.interceptors().remove(interceptor);
            }
            if (shouldUpdateConnectPool(builder, TimeUnit.MINUTES.toNanos(5))) {
                builder.connectionPool(new ConnectionPool());
            }
            builder.authenticator(Authenticator.NONE);
            builder.proxyAuthenticator(Authenticator.NONE);
        } else {
            if (shouldUpdateConnectPool(builder, TimeUnit.SECONDS.toNanos(10))) {
                builder.connectionPool(new ConnectionPool(10, 10, TimeUnit.SECONDS));
            }
            int i = config.proxyPort;
            if (z) {
                i = config.httpsProxyPort > 0 ? config.httpsProxyPort : config.proxyPort;
            }
            final Proxy[] proxyArr = new Proxy[1];
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try {
                        proxyArr[0] = new Proxy(Type.HTTP, new InetSocketAddress(config.proxyHost, i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "Config.java Create Proxy");
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            builder.proxy(proxyArr[0]);
            if (interceptor == null) {
                interceptor = new Interceptor() {
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder newBuilder = chain.request().newBuilder();
                        Map map = config.property;
                        if (map != null) {
                            for (Entry entry : map.entrySet()) {
                                newBuilder.header((String) entry.getKey(), (String) entry.getValue());
                            }
                        }
                        return chain.proceed(newBuilder.build());
                    }
                };
            }
            if (!builder.interceptors().contains(interceptor)) {
                builder.addInterceptor(interceptor);
            }
        }
        return builder;
    }
}
