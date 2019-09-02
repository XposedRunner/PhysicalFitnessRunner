package org.xutils.http.app;

import cn.jiguang.net.HttpUtils;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpRequest;

public class DefaultParamsBuilder implements ParamsBuilder {
    private static SSLSocketFactory trustAllSSlSocketFactory;

    public static SSLSocketFactory getTrustAllSSLSocketFactory() {
        if (trustAllSSlSocketFactory == null) {
            synchronized (DefaultParamsBuilder.class) {
                if (trustAllSSlSocketFactory == null) {
                    TrustManager[] trustManagerArr = new TrustManager[]{new 1()};
                    try {
                        SSLContext instance = SSLContext.getInstance("TLS");
                        instance.init(null, trustManagerArr, null);
                        trustAllSSlSocketFactory = instance.getSocketFactory();
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                }
            }
        }
        return trustAllSSlSocketFactory;
    }

    public String buildCacheKey(RequestParams requestParams, String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(requestParams.getUri());
        stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR);
        String stringBuilder2 = stringBuilder.toString();
        for (String str : strArr) {
            String stringParameter = requestParams.getStringParameter(str);
            if (stringParameter != null) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2);
                stringBuilder3.append(str);
                stringBuilder3.append(HttpUtils.EQUAL_SIGN);
                stringBuilder3.append(stringParameter);
                stringBuilder3.append(HttpUtils.PARAMETERS_SEPARATOR);
                stringBuilder2 = stringBuilder3.toString();
            }
        }
        return stringBuilder2;
    }

    public void buildParams(RequestParams requestParams) {
    }

    public void buildSign(RequestParams requestParams, String[] strArr) {
    }

    public String buildUri(RequestParams requestParams, HttpRequest httpRequest) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(httpRequest.host());
        stringBuilder.append(HttpUtils.PATHS_SEPARATOR);
        stringBuilder.append(httpRequest.path());
        return stringBuilder.toString();
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return getTrustAllSSLSocketFactory();
    }
}
