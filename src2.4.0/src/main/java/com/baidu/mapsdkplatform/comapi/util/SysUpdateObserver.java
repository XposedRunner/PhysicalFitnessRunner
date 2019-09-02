package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;

public interface SysUpdateObserver {
    void init();

    void updateNetworkInfo(Context context);

    void updateNetworkProxy(Context context);

    void updatePhoneInfo();
}
