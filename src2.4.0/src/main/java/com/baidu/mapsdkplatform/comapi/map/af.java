package com.baidu.mapsdkplatform.comapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comjni.map.basemap.a;
import org.json.JSONException;
import org.json.JSONObject;

public class af {
    private a a;

    public af(a aVar) {
        this.a = aVar;
    }

    public Point a(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return null;
        }
        Point point = new Point(0, 0);
        String b = this.a.b((int) geoPoint.getLongitudeE6(), (int) geoPoint.getLatitudeE6());
        if (b == null || b.isEmpty()) {
            return point;
        }
        try {
            JSONObject jSONObject = new JSONObject(b);
            point.x = jSONObject.getInt("scrx");
            point.y = jSONObject.getInt("scry");
            return point;
        } catch (JSONException e) {
            e.printStackTrace();
            return point;
        }
    }

    public GeoPoint a(int i, int i2) {
        GeoPoint geoPoint = new GeoPoint(0.0d, 0.0d);
        String a = this.a.a(i, i2);
        if (a == null || a.isEmpty()) {
            return geoPoint;
        }
        try {
            JSONObject jSONObject = new JSONObject(a);
            geoPoint.setLongitudeE6((double) jSONObject.getInt("geox"));
            geoPoint.setLatitudeE6((double) jSONObject.getInt("geoy"));
            return geoPoint;
        } catch (JSONException e) {
            e.printStackTrace();
            return geoPoint;
        }
    }
}
