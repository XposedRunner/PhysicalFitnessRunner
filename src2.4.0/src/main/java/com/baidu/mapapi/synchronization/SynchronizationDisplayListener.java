package com.baidu.mapapi.synchronization;

public interface SynchronizationDisplayListener {
    void onRoutePlanInfoFreshFinished(float f, long j);

    void onSynchronizationProcessResult(int i, String str);
}
