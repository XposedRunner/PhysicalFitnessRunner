package com.ximalaya.ting.android.opensdk.datatrasfer;

import okhttp3.Headers;

public interface IDataCallBack2<T> {
    void onError(int i, String str);

    void onSuccess(T t, Headers headers);
}
