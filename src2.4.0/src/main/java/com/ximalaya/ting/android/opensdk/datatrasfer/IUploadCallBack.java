package com.ximalaya.ting.android.opensdk.datatrasfer;

public interface IUploadCallBack {
    void onError(int i, String str);

    void onProgress(long j, long j2);

    void onSuccess();
}
