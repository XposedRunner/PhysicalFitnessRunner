package com.baidu.mapsdkplatform.comapi.synchronization.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceData.HistoryTracePoint;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapapi.synchronization.histroytrace.OnHistoryTraceListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class a extends Handler {
    private static final String a = "a";
    private static OnHistoryTraceListener b;
    private static boolean h;
    private HistoryTraceData c = new HistoryTraceData();
    private List<HistoryTracePoint> d = new ArrayList();
    private com.baidu.mapsdkplatform.comapi.synchronization.b.b.a e;
    private HistoryTraceQueryOptions f;
    private boolean g = false;
    private int i = 0;
    private String j = HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_SUCCESS;
    private SparseArray<List<HistoryTracePoint>> k = new SparseArray();

    a(Looper looper) {
        super(looper);
    }

    private LatLng a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Coord string is null");
            return null;
        }
        String[] split = str.split(",");
        if (split.length == 0 || 2 != split.length) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Coord result is error");
            return null;
        }
        try {
            try {
                return new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
            } catch (NumberFormatException e) {
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Parser coord latitude failed", e);
                return null;
            }
        } catch (NumberFormatException e2) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "Parser coord longitude failed", e2);
            return null;
        }
    }

    private List<HistoryTracePoint> a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Request result not contain points info");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                HistoryTracePoint historyTracePoint = new HistoryTracePoint();
                historyTracePoint.setPoint(new LatLng(optJSONObject.optDouble("latitude"), optJSONObject.optDouble("longitude")));
                historyTracePoint.setLocationTime(optJSONObject.optLong("loc_time"));
                historyTracePoint.setCreateTime(optJSONObject.optString("create_time"));
                arrayList.add(historyTracePoint);
            }
        }
        return arrayList;
    }

    private void a(int i) {
        if (this.e == null) {
            this.e = new com.baidu.mapsdkplatform.comapi.synchronization.b.b.a();
        }
        Message obtainMessage = this.e.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = this.f;
        this.e.sendMessage(obtainMessage);
    }

    private void a(int i, String str, int i2, HistoryTraceData historyTraceData) {
        if (b == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "OnHistoryTraceListener is null");
        } else if (1 == i2) {
            b.onQueryHistroyTraceData(i, str, historyTraceData);
        } else {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Undefined message type to notify");
        }
    }

    private boolean a(String str, HistoryTraceData historyTraceData, int i) {
        if (TextUtils.isEmpty(str) || historyTraceData == null) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Parameter error when parser");
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_PARSER_FAILED, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i, null);
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (a(jSONObject, i)) {
                this.g = false;
                int optInt = jSONObject.optInt("total");
                historyTraceData.setTotalPoints(optInt);
                i = jSONObject.optInt("size");
                int optInt2 = jSONObject.optInt("req_page_index");
                if (i * optInt2 < optInt) {
                    h = true;
                    optInt2++;
                    f.a(optInt2);
                }
                historyTraceData.setCurrentPageIndex(optInt2);
                historyTraceData.setDistance(jSONObject.optDouble("distance"));
                historyTraceData.setTollDiatance(jSONObject.optDouble("toll_distance"));
                historyTraceData.setCurrentOrderState(jSONObject.optInt("o_status"));
                historyTraceData.setOrderStartPosition(a(jSONObject.optString("o_start_point")));
                historyTraceData.setOrderEndPosition(a(jSONObject.optString("o_end_point")));
                if (!(this.d == null || this.d.isEmpty())) {
                    this.d.clear();
                }
                List a = a(jSONObject.optJSONArray("points"));
                if (!(a == null || a.isEmpty())) {
                    this.d.addAll(a);
                }
                return true;
            }
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Request result contain error");
            return false;
        } catch (JSONException e) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(a, "JSONException happened when parser request result", e);
            return false;
        }
    }

    private boolean a(JSONObject jSONObject, int i) {
        if (jSONObject == null || !jSONObject.has("status")) {
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_PARSER_FAILED, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_PARSER_FAILED, i, null);
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Request result no status");
            return false;
        }
        this.i = jSONObject.optInt("status");
        this.j = jSONObject.optString("message");
        if (this.i == 0) {
            this.g = false;
            return true;
        } else if (1 != this.i || this.g) {
            return true;
        } else {
            a(i);
            this.g = true;
            return false;
        }
    }

    public void a() {
        if (b != null) {
            b = null;
        }
        if (this.d != null) {
            this.d.clear();
            this.d = null;
        }
        this.c = null;
    }

    public void a(HistoryTraceQueryOptions historyTraceQueryOptions) {
        this.f = historyTraceQueryOptions;
    }

    public void a(OnHistoryTraceListener onHistoryTraceListener) {
        b = onHistoryTraceListener;
    }

    public void a(com.baidu.mapsdkplatform.comapi.synchronization.b.b.a aVar) {
        this.e = aVar;
    }

    public void handleMessage(Message message) {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Message type = ");
        stringBuilder.append(message.what);
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, stringBuilder.toString());
        if (message.what != 3) {
            com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "Undefined message type");
            return;
        }
        int i = message.arg1;
        String str2 = (String) message.obj;
        if (str2 == null) {
            a(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_NULL, HistoryTraceConstant.LBS_HISTORY_TRACE_MESSAGE_QUERY_RESULT_NULL, i, null);
            return;
        }
        boolean a = a(str2, this.c, i);
        if (a) {
            this.k.put(this.c.getCurrentPageIndex() - 1, this.d);
            if (h) {
                a(i);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.k.size(); i2++) {
            List list = (List) this.k.get(i2);
            if (!(list == null || list.isEmpty())) {
                arrayList.addAll(list);
            }
        }
        this.c.setPointsList(arrayList);
        HistoryTraceData historyTraceData = this.c;
        if (a && !h) {
            a(this.i, this.j, i, historyTraceData);
            this.c = null;
            this.c = new HistoryTraceData();
            this.d.clear();
            this.d = null;
            this.d = new ArrayList();
            this.k.clear();
        }
        h = false;
    }
}
