package com.umeng.socialize;

import defpackage.by;

public interface UMShareListener {
    void onCancel(by byVar);

    void onError(by byVar, Throwable th);

    void onResult(by byVar);

    void onStart(by byVar);
}
