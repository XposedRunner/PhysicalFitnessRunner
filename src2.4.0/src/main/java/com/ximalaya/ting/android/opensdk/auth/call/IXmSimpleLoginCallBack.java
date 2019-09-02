package com.ximalaya.ting.android.opensdk.auth.call;

import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import java.util.HashMap;

public interface IXmSimpleLoginCallBack {
    void request(HashMap<String, String> hashMap, IDataCallBack<String> iDataCallBack);
}
