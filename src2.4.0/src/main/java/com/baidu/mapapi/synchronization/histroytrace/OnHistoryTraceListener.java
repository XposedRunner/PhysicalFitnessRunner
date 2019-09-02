package com.baidu.mapapi.synchronization.histroytrace;

public interface OnHistoryTraceListener {
    void onQueryHistroyTraceData(int i, String str, HistoryTraceData historyTraceData);

    void onRenderHistroyTrace(int i, String str);
}
