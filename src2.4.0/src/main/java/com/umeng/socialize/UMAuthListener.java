package com.umeng.socialize;

import defpackage.by;
import java.util.Map;

public interface UMAuthListener {
    public static final int ACTION_AUTHORIZE = 0;
    public static final int ACTION_DELETE = 1;
    public static final int ACTION_GET_PROFILE = 2;

    void onCancel(by byVar, int i);

    void onComplete(by byVar, int i, Map<String, String> map);

    void onError(by byVar, int i, Throwable th);

    void onStart(by byVar);
}
