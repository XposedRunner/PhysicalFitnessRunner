package org.xutils.http.request;

import android.text.TextUtils;
import java.lang.reflect.Type;
import java.util.HashMap;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.app.RequestTracker;

public final class UriRequestFactory {
    private static final HashMap<String, Class<? extends UriRequest>> SCHEME_CLS_MAP = new HashMap();
    private static Class<? extends RequestTracker> defaultTrackerCls;

    private UriRequestFactory() {
    }

    public static RequestTracker getDefaultTracker() {
        RequestTracker requestTracker = null;
        try {
            if (defaultTrackerCls != null) {
                requestTracker = (RequestTracker) defaultTrackerCls.newInstance();
            }
            return requestTracker;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return null;
        }
    }

    public static UriRequest getUriRequest(RequestParams requestParams, Type type) throws Throwable {
        String uri = requestParams.getUri();
        int indexOf = uri.indexOf(":");
        CharSequence substring = indexOf > 0 ? uri.substring(0, indexOf) : uri.startsWith("/") ? "file" : null;
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(substring)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("The url not be support: ");
            stringBuilder.append(uri);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        Class cls = (Class) SCHEME_CLS_MAP.get(substring);
        if (cls != null) {
            return (UriRequest) cls.getConstructor(new Class[]{RequestParams.class, Class.class}).newInstance(new Object[]{requestParams, type});
        } else if (substring.startsWith("http")) {
            return new HttpRequest(requestParams, type);
        } else {
            if (substring.equals("assets")) {
                return new AssetsRequest(requestParams, type);
            }
            if (substring.equals("file")) {
                return new LocalFileRequest(requestParams, type);
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("The url not be support: ");
            stringBuilder.append(uri);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static void registerDefaultTrackerClass(Class<? extends RequestTracker> cls) {
        defaultTrackerCls = cls;
    }

    public static void registerRequestClass(String str, Class<? extends UriRequest> cls) {
        SCHEME_CLS_MAP.put(str, cls);
    }
}
