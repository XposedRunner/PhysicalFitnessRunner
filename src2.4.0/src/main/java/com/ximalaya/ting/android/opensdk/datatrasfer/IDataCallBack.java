package com.ximalaya.ting.android.opensdk.datatrasfer;

import android.support.annotation.Nullable;

public interface IDataCallBack<T> {
    void onError(int i, String str);

    void onSuccess(@Nullable T t);
}
