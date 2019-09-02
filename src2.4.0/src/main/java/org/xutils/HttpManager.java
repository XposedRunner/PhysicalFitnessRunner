package org.xutils;

import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CommonCallback;
import org.xutils.common.Callback.TypedCallback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;

public interface HttpManager {
    <T> Cancelable get(RequestParams requestParams, CommonCallback<T> commonCallback);

    <T> T getSync(RequestParams requestParams, Class<T> cls) throws Throwable;

    <T> Cancelable post(RequestParams requestParams, CommonCallback<T> commonCallback);

    <T> T postSync(RequestParams requestParams, Class<T> cls) throws Throwable;

    <T> Cancelable request(HttpMethod httpMethod, RequestParams requestParams, CommonCallback<T> commonCallback);

    <T> T requestSync(HttpMethod httpMethod, RequestParams requestParams, Class<T> cls) throws Throwable;

    <T> T requestSync(HttpMethod httpMethod, RequestParams requestParams, TypedCallback<T> typedCallback) throws Throwable;
}
