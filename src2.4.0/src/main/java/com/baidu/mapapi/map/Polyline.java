package com.baidu.mapapi.map;

import android.os.Bundle;
import android.util.Log;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.mapsdkplatform.comapi.map.h;
import java.util.List;

public final class Polyline extends Overlay {
    int a;
    List<LatLng> b;
    int[] c;
    int[] d;
    int e;
    boolean f;
    boolean g;
    boolean h;
    BitmapDescriptor i;
    List<BitmapDescriptor> j;

    Polyline() {
        this.g = false;
        this.h = true;
        this.type = h.polyline;
    }

    private Bundle a(boolean z) {
        return (z ? BitmapDescriptorFactory.fromAsset("lineDashTexture.png") : this.i).b();
    }

    static void a(int[] iArr, Bundle bundle) {
        if (iArr != null && iArr.length > 0) {
            bundle.putIntArray("traffic_array", iArr);
        }
    }

    private Bundle b(boolean z) {
        Bundle bundle;
        if (z) {
            bundle = new Bundle();
            bundle.putInt("total", 1);
            bundle.putBundle("texture_0", BitmapDescriptorFactory.fromAsset("lineDashTexture.png").b());
            return bundle;
        }
        bundle = new Bundle();
        int i = 0;
        int i2 = 0;
        while (i < this.j.size()) {
            if (this.j.get(i) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("texture_");
                stringBuilder.append(String.valueOf(i2));
                bundle.putBundle(stringBuilder.toString(), ((BitmapDescriptor) this.j.get(i)).b());
                i2++;
            }
            i++;
        }
        bundle.putInt("total", i2);
        return bundle;
    }

    static void b(int[] iArr, Bundle bundle) {
        if (iArr != null && iArr.length > 0) {
            bundle.putIntArray("color_array", iArr);
            bundle.putInt("total", 1);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Bundle a(Bundle bundle) {
        super.a(bundle);
        GeoPoint ll2mc = CoordUtil.ll2mc((LatLng) this.b.get(0));
        bundle.putDouble("location_x", ll2mc.getLongitudeE6());
        bundle.putDouble("location_y", ll2mc.getLatitudeE6());
        bundle.putInt("width", this.e);
        Overlay.a(this.b, bundle);
        Overlay.a(this.a, bundle);
        a(this.c, bundle);
        b(this.d, bundle);
        int i = 1;
        if (this.c != null && this.c.length > 0 && this.c.length > this.b.size() - 1) {
            Log.e("baidumapsdk", "the size of textureIndexs is larger than the size of points");
        }
        if (this.f) {
            bundle.putInt("dotline", 1);
        } else {
            bundle.putInt("dotline", 0);
        }
        bundle.putInt("focus", this.g ? 1 : 0);
        try {
            if (this.i != null) {
                bundle.putInt("custom", 1);
                bundle.putBundle("image_info", a(false));
            } else {
                if (this.f) {
                    bundle.putBundle("image_info", a(true));
                }
                bundle.putInt("custom", 0);
            }
            if (this.j != null) {
                bundle.putInt("customlist", 1);
                bundle.putBundle("image_info_list", b(false));
            } else {
                if (this.f && ((this.c != null && this.c.length > 0) || (this.d != null && this.d.length > 0))) {
                    bundle.putBundle("image_info_list", b(true));
                }
                bundle.putInt("customlist", 0);
            }
            String str = "keep";
            if (!this.h) {
                i = 0;
            }
            bundle.putInt(str, i);
            return bundle;
        } catch (Exception unused) {
            Log.e("baidumapsdk", "load texture resource failed!");
            bundle.putInt("dotline", 0);
            return bundle;
        }
    }

    public int getColor() {
        return this.a;
    }

    public List<LatLng> getPoints() {
        return this.b;
    }

    public BitmapDescriptor getTexture() {
        return this.i;
    }

    public int getWidth() {
        return this.e;
    }

    public boolean isDottedLine() {
        return this.f;
    }

    public boolean isFocus() {
        return this.g;
    }

    public void setColor(int i) {
        this.a = i;
        this.listener.b(this);
    }

    public void setDottedLine(boolean z) {
        this.f = z;
        this.listener.b(this);
    }

    public void setFocus(boolean z) {
        this.g = z;
        this.listener.b(this);
    }

    public void setIndexs(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("indexList can not empty");
        }
        this.c = iArr;
    }

    public void setPoints(List<LatLng> list) {
        if (list == null) {
            throw new IllegalArgumentException("points list can not be null");
        } else if (list.size() < 2) {
            throw new IllegalArgumentException("points count can not less than 2 or more than 10000");
        } else if (list.contains(null)) {
            throw new IllegalArgumentException("points list can not contains null");
        } else {
            this.b = list;
            this.listener.b(this);
        }
    }

    public void setTexture(BitmapDescriptor bitmapDescriptor) {
        this.i = bitmapDescriptor;
        this.listener.b(this);
    }

    public void setTextureList(List<BitmapDescriptor> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("textureList can not empty");
        }
        this.j = list;
    }

    public void setWidth(int i) {
        if (i > 0) {
            this.e = i;
            this.listener.b(this);
        }
    }
}
