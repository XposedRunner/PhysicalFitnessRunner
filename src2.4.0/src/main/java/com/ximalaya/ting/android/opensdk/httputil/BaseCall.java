package com.ximalaya.ting.android.opensdk.httputil;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.ConstantsOpenSdk;
import com.ximalaya.ting.android.opensdk.httputil.util.freeflow.FreeFlowServiceUtil;
import com.ximalaya.ting.android.opensdk.util.BaseUtil;
import com.ximalaya.ting.android.opensdk.util.Logger;
import defpackage.db;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class BaseCall {
    public static String COLLECTOR_SWITCH = "x-a1-xdcs-collector-switch";
    public static int DEFAULT_TIMEOUT = 0;
    public static int DEFAULT_TIMEOUT_SHORT = 3000;
    public static int ERROR_CODE_DEFALUT = 603;
    public static String HTTPDNS_SWITCH = "x-a1-httpdns-switch";
    public static final String NET_ERR_CONTENT = "网络请求失败";
    private static Class commonRequestClass = null;
    public static boolean isEnableDnsCache = false;
    public static boolean isEnableXdcsCollect = true;
    private static Context mContext;
    private static volatile BaseCall singleton;
    private IIgnoreProxyUrl mIgnoreProxy;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private OkHttpClient okHttpClientNotProxy;

    public interface IIgnoreProxyUrl {
        boolean isIgnoreUrl(URL url);
    }

    private BaseCall() {
    }

    public static Response doSync(OkHttpClient okHttpClient, Request request) throws Exception {
        return okHttpClient.newCall(request).execute();
    }

    @Nullable
    public static Class getCommonRequestM() {
        if (commonRequestClass != null) {
            return commonRequestClass;
        }
        try {
            Class cls = Class.forName(ConstantsOpenSdk.MAIN_COMMONREQUESTM);
            commonRequestClass = cls;
            return cls;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static synchronized BaseCall getInstanse() {
        BaseCall baseCall;
        synchronized (BaseCall.class) {
            if (singleton == null) {
                synchronized (BaseCall.class) {
                    if (singleton == null) {
                        singleton = new BaseCall();
                    }
                }
            }
            baseCall = singleton;
        }
        return baseCall;
    }

    private static String getMsg(Response response, String str) {
        try {
            JSONObject jSONObject = new JSONObject(response.body().toString());
            return jSONObject.has(db.O000OO00) ? jSONObject.getString(db.O000OO00) : str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    @NonNull
    private OkHttpClient getOkHttpClient(@NonNull Request request) {
        if (this.mIgnoreProxy != null && request.url() != null && this.mIgnoreProxy.isIgnoreUrl(request.url().url())) {
            return getOkHttpClientNotProxy();
        }
        return request.isHttps() ? getOkHttpClientNotProxy() : this.okHttpClient;
    }

    public static void init(Context context) {
        mContext = context;
    }

    public static synchronized void release() {
        synchronized (BaseCall.class) {
            if (singleton != null) {
                singleton = null;
            }
        }
    }

    private void setHttpConfigToBuilder(Context context, Config config, Builder builder, boolean z) {
        FreeFlowServiceUtil.updateProxyToBuilder(context, config, builder, z);
        if (mContext != null) {
            builder.cache(new Cache(new File(mContext.getCacheDir(), "request_cache"), 52428800));
        }
    }

    public synchronized void addInterceptor(Interceptor interceptor) {
        if (this.okHttpClient != null) {
            Builder newBuilder = this.okHttpClient.newBuilder();
            if (!newBuilder.interceptors().contains(interceptor)) {
                newBuilder.addInterceptor(interceptor);
            }
            this.okHttpClient = newBuilder.build();
        }
    }

    /* JADX WARNING: Missing block: B:33:0x0066, code skipped:
            return;
     */
    public synchronized void cancleTag(java.lang.String r5) {
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x0067 }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r4);
        return;
    L_0x0009:
        r0 = r4.okHttpClient;	 Catch:{ all -> 0x0067 }
        if (r0 == 0) goto L_0x0065;
    L_0x000d:
        r0 = r0.dispatcher();	 Catch:{ all -> 0x0067 }
        if (r0 == 0) goto L_0x0065;
    L_0x0013:
        r1 = r0.runningCalls();	 Catch:{ all -> 0x0067 }
        r1 = r1.iterator();	 Catch:{ all -> 0x0067 }
    L_0x001b:
        r2 = r1.hasNext();	 Catch:{ all -> 0x0067 }
        if (r2 == 0) goto L_0x003c;
    L_0x0021:
        r2 = r1.next();	 Catch:{ all -> 0x0067 }
        r2 = (okhttp3.Call) r2;	 Catch:{ all -> 0x0067 }
        r3 = r2.request();	 Catch:{ all -> 0x0067 }
        if (r3 == 0) goto L_0x001b;
    L_0x002d:
        r3 = r3.tag();	 Catch:{ all -> 0x0067 }
        r3 = r5.equals(r3);	 Catch:{ all -> 0x0067 }
        if (r3 == 0) goto L_0x001b;
    L_0x0037:
        r2.cancel();	 Catch:{ all -> 0x0067 }
        monitor-exit(r4);
        return;
    L_0x003c:
        r0 = r0.queuedCalls();	 Catch:{ all -> 0x0067 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0067 }
    L_0x0044:
        r1 = r0.hasNext();	 Catch:{ all -> 0x0067 }
        if (r1 == 0) goto L_0x0065;
    L_0x004a:
        r1 = r0.next();	 Catch:{ all -> 0x0067 }
        r1 = (okhttp3.Call) r1;	 Catch:{ all -> 0x0067 }
        r2 = r1.request();	 Catch:{ all -> 0x0067 }
        if (r2 == 0) goto L_0x0044;
    L_0x0056:
        r2 = r2.tag();	 Catch:{ all -> 0x0067 }
        r2 = r5.equals(r2);	 Catch:{ all -> 0x0067 }
        if (r2 == 0) goto L_0x0044;
    L_0x0060:
        r1.cancel();	 Catch:{ all -> 0x0067 }
        monitor-exit(r4);
        return;
    L_0x0065:
        monitor-exit(r4);
        return;
    L_0x0067:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.httputil.BaseCall.cancleTag(java.lang.String):void");
    }

    public void doAsync(OkHttpClient okHttpClient, Request request, final IHttpCallBack iHttpCallBack) {
        if (okHttpClient == null) {
            doAsync(request, iHttpCallBack);
            return;
        }
        try {
            okHttpClient.newCall(request).enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    if (iHttpCallBack != null) {
                        String str = BaseCall.NET_ERR_CONTENT;
                        if (ConstantsOpenSdk.isDebug) {
                            str = iOException.getMessage();
                            if (TextUtils.isEmpty(str)) {
                                str = BaseCall.NET_ERR_CONTENT;
                            }
                        }
                        iHttpCallBack.onFailure(604, str);
                    }
                }

                public void onResponse(Call call, Response response) throws IOException {
                    if (iHttpCallBack == null) {
                        response.body().close();
                        return;
                    }
                    String header;
                    if (response != null) {
                        header = response.header(BaseCall.HTTPDNS_SWITCH);
                        String header2 = response.header(BaseCall.COLLECTOR_SWITCH);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(header);
                        stringBuilder.append("   ");
                        stringBuilder.append(header2);
                        Logger.i("SAVE_LIFE", stringBuilder.toString());
                        if (!TextUtils.isEmpty(header)) {
                            if (header.equals("on")) {
                                BaseCall.isEnableDnsCache = true;
                            } else if (header.equals("off")) {
                                BaseCall.isEnableDnsCache = false;
                            }
                        }
                        if (!TextUtils.isEmpty(header2)) {
                            if (header2.equals("on")) {
                                BaseCall.isEnableXdcsCollect = true;
                            } else if (header2.equals("off")) {
                                BaseCall.isEnableXdcsCollect = false;
                            }
                        }
                    }
                    if (!BaseUtil.isMainApp()) {
                        iHttpCallBack.onResponse(response);
                    } else if (response.code() >= 400) {
                        header = new BaseResponse(response).getResponseBodyToString();
                        if (TextUtils.isEmpty(header) || !header.contains("ret")) {
                            IHttpCallBack iHttpCallBack = iHttpCallBack;
                            int code = response.code();
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("网络请求失败(");
                            stringBuilder2.append(response.code());
                            stringBuilder2.append(")");
                            iHttpCallBack.onFailure(code, stringBuilder2.toString());
                        } else {
                            iHttpCallBack.onFailure(response.code(), header);
                        }
                    } else {
                        iHttpCallBack.onResponse(response);
                    }
                    response.body().close();
                }
            });
        } catch (Exception unused) {
            if (iHttpCallBack != null) {
                iHttpCallBack.onFailure(604, NET_ERR_CONTENT);
            }
        }
    }

    public void doAsync(Request request, final IHttpCallBack iHttpCallBack) {
        if (this.okHttpClient != null) {
            try {
                getOkHttpClient(request).newCall(request).enqueue(new Callback() {
                    public void onFailure(Call call, IOException iOException) {
                        if (iHttpCallBack != null) {
                            String str = BaseCall.NET_ERR_CONTENT;
                            if (ConstantsOpenSdk.isDebug) {
                                str = iOException.getMessage();
                                if (TextUtils.isEmpty(str)) {
                                    str = BaseCall.NET_ERR_CONTENT;
                                }
                            }
                            iHttpCallBack.onFailure(604, str);
                        }
                    }

                    public void onResponse(Call call, Response response) throws IOException {
                        if (iHttpCallBack == null) {
                            response.body().close();
                            return;
                        }
                        if (!BaseUtil.isMainApp()) {
                            iHttpCallBack.onResponse(response);
                        } else if (response.code() >= 400) {
                            String responseBodyToString = new BaseResponse(response).getResponseBodyToString();
                            if (TextUtils.isEmpty(responseBodyToString) || !responseBodyToString.contains("ret")) {
                                IHttpCallBack iHttpCallBack = iHttpCallBack;
                                int code = response.code();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("网络请求失败(");
                                stringBuilder.append(response.code());
                                stringBuilder.append(")");
                                iHttpCallBack.onFailure(code, stringBuilder.toString());
                            } else {
                                iHttpCallBack.onFailure(response.code(), responseBodyToString);
                            }
                        } else {
                            iHttpCallBack.onResponse(response);
                        }
                        response.body().close();
                    }
                });
            } catch (Exception unused) {
                if (iHttpCallBack != null) {
                    iHttpCallBack.onFailure(604, NET_ERR_CONTENT);
                }
            }
        }
    }

    public void doAsync(Request request, IHttpCallBack iHttpCallBack, int i) {
        OkHttpClient okHttpClient = getOkHttpClient(request);
        if (i != DEFAULT_TIMEOUT) {
            Builder newBuilder = okHttpClient.newBuilder();
            long j = (long) i;
            newBuilder.connectTimeout(j, TimeUnit.MILLISECONDS);
            newBuilder.readTimeout(j, TimeUnit.MILLISECONDS);
            newBuilder.writeTimeout(j, TimeUnit.MILLISECONDS);
            okHttpClient = newBuilder.build();
        }
        doAsync(okHttpClient, request, iHttpCallBack);
    }

    public Response doSync(Request request) throws Exception {
        return this.okHttpClient == null ? null : getOkHttpClient(request).newCall(request).execute();
    }

    public Response doSync(Request request, int i) throws IOException {
        OkHttpClient okHttpClient = getOkHttpClient(request);
        if (i != DEFAULT_TIMEOUT) {
            Builder newBuilder = okHttpClient.newBuilder();
            long j = (long) i;
            newBuilder.connectTimeout(j, TimeUnit.MILLISECONDS);
            newBuilder.readTimeout(j, TimeUnit.MILLISECONDS);
            newBuilder.writeTimeout(j, TimeUnit.MILLISECONDS);
            okHttpClient = newBuilder.build();
        }
        return okHttpClient.newCall(request).execute();
    }

    public OkHttpClient getOkHttpClient(@Nullable URL url) {
        if (url == null) {
            return this.okHttpClient;
        }
        if (this.mIgnoreProxy != null && this.mIgnoreProxy.isIgnoreUrl(url)) {
            return getOkHttpClientNotProxy();
        }
        return url.getPath().startsWith("https") ? getOkHttpClientNotProxy() : this.okHttpClient;
    }

    public OkHttpClient getOkHttpClientNotProxy() {
        if (this.okHttpClientNotProxy != null) {
            return this.okHttpClientNotProxy;
        }
        this.okHttpClientNotProxy = new Builder().connectionPool(new ConnectionPool(1, 1, TimeUnit.MINUTES)).build();
        return this.okHttpClientNotProxy;
    }

    public void setHttpConfig(Config config) {
        Builder newBuilder = this.okHttpClient.newBuilder();
        setHttpConfigToBuilder(mContext, config, newBuilder, false);
        this.okHttpClient = newBuilder.build();
    }

    public void setIgnoreProxy(IIgnoreProxyUrl iIgnoreProxyUrl) {
        this.mIgnoreProxy = iIgnoreProxyUrl;
    }

    public synchronized void updateOkhttpClient() {
        this.okHttpClient = new OkHttpClient();
    }

    public synchronized void updateOkhttpClientConnectPool() {
        Builder newBuilder = this.okHttpClient.newBuilder();
        newBuilder.connectionPool(new ConnectionPool());
        this.okHttpClient = newBuilder.build();
    }
}
