package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import cn.jiguang.net.HttpUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TraceHandlerAbstract */
public class o0oO0Ooo extends o0O00OOO<List<TraceLocation>, List<LatLng>> implements Runnable {
    private List<TraceLocation> O00000oO;
    private Handler O00000oo = null;
    private int O0000O0o = 0;
    private int O0000OOo = 0;
    private String O0000Oo0;

    public o0oO0Ooo(Context context, Handler handler, List<TraceLocation> list, int i, String str, int i2, int i3) {
        super(context, list);
        this.O00000oO = list;
        this.O00000oo = handler;
        this.O0000OOo = i2;
        this.O0000O0o = i3;
        this.O0000Oo0 = str;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O000000o */
    public List<LatLng> O00000o0(String str) throws o0OoO00O {
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return arrayList;
            }
            JSONArray optJSONArray = jSONObject.optJSONObject("data").optJSONArray("points");
            if (optJSONArray != null) {
                if (optJSONArray.length() != 0) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        arrayList.add(new LatLng(Double.parseDouble(optJSONObject.optString("y")), Double.parseDouble(optJSONObject.optString("x"))));
                    }
                    return arrayList;
                }
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* Access modifiers changed, original: protected */
    public String O00000o0() {
        JSONArray jSONArray = new JSONArray();
        long j = 0;
        int i = 0;
        long j2 = 0;
        while (i < this.O00000oO.size()) {
            TraceLocation traceLocation = (TraceLocation) this.O00000oO.get(i);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i == 0) {
                    if (time == j) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put("tm", time / 1000);
                } else {
                    if (time != j) {
                        long j3 = time - j2;
                        if (j3 >= 1000) {
                            jSONObject.put("tm", j3 / 1000);
                        }
                    }
                    jSONObject.put("tm", 1);
                }
                j2 = time;
                jSONObject.put("sp", (int) traceLocation.getSpeed());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
            i++;
            j = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getURL());
        stringBuilder.append(HttpUtils.PARAMETERS_SEPARATOR);
        stringBuilder.append(jSONArray.toString());
        this.O00000o = stringBuilder.toString();
        return jSONArray.toString();
    }

    public String getURL() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key=");
        stringBuilder.append(o0O0O0Oo.O00000oo(this.O00000o0));
        String stringBuilder2 = stringBuilder.toString();
        String O000000o = o0O0OOOo.O000000o();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("&ts=");
        stringBuilder3.append(O000000o);
        String stringBuilder4 = stringBuilder3.toString();
        O000000o = o0O0OOOo.O000000o(this.O00000o0, O000000o, stringBuilder2);
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("&scode=");
        stringBuilder5.append(O000000o);
        O000000o = stringBuilder5.toString();
        stringBuilder5 = new StringBuilder();
        stringBuilder5.append("http://restapi.amap.com/v4/grasproad/driving?");
        stringBuilder5.append(stringBuilder2);
        stringBuilder5.append(stringBuilder4);
        stringBuilder5.append(O000000o);
        return stringBuilder5.toString();
    }

    public void run() {
        ArrayList arrayList = new ArrayList();
        try {
            o0O0O00O.O000000o().O000000o(this.O0000Oo0, this.O0000O0o, (List) O000000o());
            o0O0O00O.O000000o().O000000o(this.O0000Oo0).O000000o(this.O00000oo);
        } catch (o0OoO00O e) {
            o0O0O00O.O000000o().O000000o(this.O00000oo, this.O0000OOo, e.O000000o());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
