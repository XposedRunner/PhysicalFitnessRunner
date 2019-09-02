package com.baidu.mapapi.map;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import org.json.JSONObject;

public final class MapPoi {
    private static final String d = "MapPoi";
    String a;
    LatLng b;
    String c;

    /* Access modifiers changed, original: 0000 */
    public void a(JSONObject jSONObject) {
        this.a = jSONObject.optString("tx");
        if (!(this.a == null || this.a.equals(""))) {
            this.a = this.a.replaceAll("\\\\", "").replaceAll("/?[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        }
        this.b = CoordUtil.decodeNodeLocation(jSONObject.optString("geo"));
        this.c = jSONObject.optString("ud");
    }

    public String getName() {
        return this.a;
    }

    public LatLng getPosition() {
        return this.b;
    }

    public String getUid() {
        return this.c;
    }
}
