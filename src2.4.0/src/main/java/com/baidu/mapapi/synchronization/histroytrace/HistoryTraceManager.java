package com.baidu.mapapi.synchronization.histroytrace;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b;
import com.baidu.mapsdkplatform.comapi.synchronization.d.a;

public class HistoryTraceManager {
    private b a = new b();

    public boolean isHttpsEnable() {
        if (this.a != null) {
            return this.a.b();
        }
        a.b("HistoryTraceManager", "The implement instance is null");
        return true;
    }

    public void queryHistoryTraceData(HistoryTraceQueryOptions historyTraceQueryOptions) {
        if (this.a != null) {
            this.a.a(historyTraceQueryOptions);
        }
    }

    public void release() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public void renderHistoryTrace(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i) {
        if (this.a != null) {
            this.a.a(baiduMap, historyTraceData, historyTraceDisplayOptions, i);
        }
    }

    public void setHttpsEnable(boolean z) {
        if (this.a == null) {
            a.b("HistoryTraceManager", "The implement instance is null");
        } else {
            this.a.a(z);
        }
    }

    public void setOnHistoryTraceListener(OnHistoryTraceListener onHistoryTraceListener) {
        if (onHistoryTraceListener == null) {
            throw new IllegalArgumentException("HistoryTraceManager-- OnHistoryTraceListener must not be null.");
        } else if (this.a != null) {
            this.a.a(onHistoryTraceListener);
        }
    }
}
