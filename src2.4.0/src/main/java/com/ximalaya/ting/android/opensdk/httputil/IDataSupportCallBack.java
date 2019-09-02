package com.ximalaya.ting.android.opensdk.httputil;

public interface IDataSupportCallBack<T> {
    void onError(int i, String str);

    void onSuccess(T t);
}
