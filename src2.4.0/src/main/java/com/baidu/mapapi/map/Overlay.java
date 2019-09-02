package com.baidu.mapapi.map;

import android.os.Bundle;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.h;
import java.util.List;

public abstract class Overlay {
    protected a listener;
    public h type;
    String v;
    int w;
    boolean x;
    Bundle y;

    interface a {
        void a(Overlay overlay);

        void b(Overlay overlay);
    }

    protected Overlay() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("_");
        stringBuilder.append(hashCode());
        this.v = stringBuilder.toString();
    }

    static void a(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        int i2 = i >>> 24;
        int i3 = (i >> 8) & 255;
        i &= 255;
        bundle2.putFloat("red", ((float) ((i >> 16) & 255)) / 255.0f);
        bundle2.putFloat("green", ((float) i3) / 255.0f);
        bundle2.putFloat("blue", ((float) i) / 255.0f);
        bundle2.putFloat("alpha", ((float) i2) / 255.0f);
        bundle.putBundle("color", bundle2);
    }

    static void a(List<LatLng> list, Bundle bundle) {
        int size = list.size();
        double[] dArr = new double[size];
        double[] dArr2 = new double[size];
        for (int i = 0; i < size; i++) {
            GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) list.get(i));
            dArr[i] = ll2mc.getLongitudeE6();
            dArr2[i] = ll2mc.getLatitudeE6();
        }
        bundle.putDoubleArray("x_array", dArr);
        bundle.putDoubleArray("y_array", dArr2);
    }

    /* Access modifiers changed, original: 0000 */
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("id", this.v);
        bundle.putInt("type", this.type.ordinal());
        return bundle;
    }

    /* Access modifiers changed, original: 0000 */
    public Bundle a(Bundle bundle) {
        bundle.putString("id", this.v);
        bundle.putInt("type", this.type.ordinal());
        bundle.putInt("visibility", this.x);
        bundle.putInt("z_index", this.w);
        return bundle;
    }

    public Bundle getExtraInfo() {
        return this.y;
    }

    public int getZIndex() {
        return this.w;
    }

    public boolean isVisible() {
        return this.x;
    }

    public void remove() {
        this.listener.a(this);
    }

    public void setExtraInfo(Bundle bundle) {
        this.y = bundle;
    }

    public void setVisible(boolean z) {
        this.x = z;
        this.listener.b(this);
    }

    public void setZIndex(int i) {
        this.w = i;
        this.listener.b(this);
    }
}
