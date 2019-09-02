package com.baidu.mapsdkplatform.comapi.synchronization.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceDisplayOptions;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;

public class b {
    private static final String a = "b";
    private static com.baidu.mapsdkplatform.comapi.synchronization.c.a b;
    private static OnHistoryTraceListener c;
    private static a e;
    private static int g;
    private HandlerThread d;
    private a f;
    private HandlerThread h;
    private e i;
    private volatile boolean j = false;

    public static class a extends Handler {
        a() {
        }

        private String a(HistoryTraceQueryOptions historyTraceQueryOptions) {
            String a = new f(historyTraceQueryOptions).a();
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Build request url failed");
            return null;
        }

        private void a(int i, String str, int i2, HistoryTraceQueryOptions historyTraceQueryOptions) {
            if (b.e == null) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Data parser handler is null");
                return;
            }
            Message obtainMessage = b.e.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.arg1 = i2;
            obtainMessage.obj = str;
            b.e.sendMessage(obtainMessage);
            b.e.a(historyTraceQueryOptions);
        }

        private void a(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
            String a = a(historyTraceQueryOptions);
            if (TextUtils.isEmpty(a)) {
                b.b(10002, "QueryOptions is null, please check.", i);
            } else {
                a(a, i, historyTraceQueryOptions);
            }
        }

        private void a(com.baidu.mapsdkplatform.comapi.synchronization.c.c.a aVar, int i) {
            int i2;
            String str;
            switch (c.a[aVar.ordinal()]) {
                case 1:
                    i2 = 0;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
                    break;
                case 2:
                case 3:
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_SERVER_INNER_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SERVER_INNER_ERROR;
                    break;
                case 4:
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_NETWORK_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_NETWORK_ERROR;
                    break;
                case 5:
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_REQUEST_PARAMETER_ERROR;
                    break;
                default:
                    i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_UNDEFINE_ERROR;
                    str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_UNDEFINE_ERROR;
                    break;
            }
            b.b(i2, str, i);
        }

        private void a(String str, int i, HistoryTraceQueryOptions historyTraceQueryOptions) {
            if (TextUtils.isEmpty(str)) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(b.a, "Request url is null");
                return;
            }
            if (b.b == null) {
                b.b = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
            }
            b.b.a(str, new d(this, i, historyTraceQueryOptions, str));
        }

        public void handleMessage(Message message) {
            int i = message.what;
            String c = b.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("The query type is: ");
            stringBuilder.append(i);
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(c, stringBuilder.toString());
            HistoryTraceQueryOptions historyTraceQueryOptions = (HistoryTraceQueryOptions) message.obj;
            if (i == 1) {
                a(historyTraceQueryOptions, i);
            }
        }
    }

    public b() {
        b = new com.baidu.mapsdkplatform.comapi.synchronization.c.a();
        this.f = new a();
        this.d = new HandlerThread("HistoryTraceDataParser");
        this.d.start();
        e = new a(this.d.getLooper());
        e.a(this.f);
        this.h = new HandlerThread("HistoryTraceRender");
        this.h.start();
        this.i = new e(this.h.getLooper());
    }

    private void a(HistoryTraceData historyTraceData, int i) {
        if (this.i == null) {
            this.i = new e(this.h.getLooper());
        }
        Message obtainMessage = this.i.obtainMessage();
        obtainMessage.what = i;
        if (historyTraceData != null) {
            obtainMessage.obj = historyTraceData;
        }
        this.i.sendMessage(obtainMessage);
    }

    private boolean a(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
        int i2;
        String str;
        if (historyTraceQueryOptions == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "QueryOptions is null, please check!");
            i2 = 10001;
            str = "QueryOptions is null, please check.";
        } else if (TextUtils.isEmpty(historyTraceQueryOptions.getOrderId())) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Query orderId is null, please check");
            i2 = 10003;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ORDER_ID_NULL;
        } else if (historyTraceQueryOptions.getRoleType() != 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Current role type not the passenger");
            i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_ROLE_TYPE_ERROR;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_ROLE_TYPE_ERROR;
        } else if (TextUtils.isEmpty(historyTraceQueryOptions.getUserId())) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Order's user id is null");
            i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_USER_ID_NULL;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_USER_ID_NULL;
        } else if (!TextUtils.isEmpty(historyTraceQueryOptions.getDriverId())) {
            return true;
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Driver id is null");
            i2 = HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_DRIVER_ID_NULL;
            str = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_DRIVER_ID_NULL;
        }
        b(i2, str, i);
        return false;
    }

    private static void b(int i, String str, int i2) {
        if (c == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "OnHistoryTraceListener is null");
            return;
        }
        switch (i2) {
            case 1:
                c.onQueryHistroyTraceData(i, str, null);
                return;
            case 2:
                c.onRenderHistroyTrace(i, str);
                return;
            default:
                return;
        }
    }

    private void b(HistoryTraceQueryOptions historyTraceQueryOptions, int i) {
        if (this.f == null) {
            this.f = new a();
        }
        Message obtainMessage = this.f.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = historyTraceQueryOptions;
        this.f.sendMessage(obtainMessage);
    }

    public void a() {
        if (b != null) {
            b = null;
        }
        if (c != null) {
            c = null;
        }
        if (this.f != null) {
            this.f.removeCallbacksAndMessages(null);
            this.f = null;
        }
        if (e != null) {
            e.removeCallbacksAndMessages(null);
            e.a();
            e = null;
        }
        if (this.d != null) {
            this.d.quit();
            this.d = null;
        }
        if (this.i != null) {
            this.i.removeCallbacksAndMessages(null);
            this.i.a();
            this.i = null;
        }
        if (this.h != null) {
            this.h.quit();
            this.h = null;
        }
        this.j = false;
    }

    public void a(BaiduMap baiduMap, HistoryTraceData historyTraceData, HistoryTraceDisplayOptions historyTraceDisplayOptions, int i) {
        if (baiduMap == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "BaiduMap instance is null");
            if (c != null) {
                c.onRenderHistroyTrace(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_BAIDUMAP_NULL);
            }
        } else if (5 != i) {
            if (c != null) {
                c.onRenderHistroyTrace(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_CURRENT_ORDER_STATE_NOT_COMPLETE);
            }
        } else {
            this.i.a(historyTraceDisplayOptions, baiduMap, i);
            a(historyTraceData, 4);
        }
    }

    public void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        if (a(historyTraceQueryOptions, 1)) {
            b(historyTraceQueryOptions, 1);
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "QueryOptions error, please check!");
        }
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        c = onHistoryTraceListener;
        e.a(onHistoryTraceListener);
        this.i.a(onHistoryTraceListener);
    }

    public void a(boolean z) {
        c.b = z;
    }

    public boolean b() {
        return c.b;
    }
}
