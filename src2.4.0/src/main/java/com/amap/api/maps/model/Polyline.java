package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.mapcore.util.ooOOOOoo;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IPolyline;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.List;

public class Polyline extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private PolylineOptions options;
    private IPolyline polylineDelegate;

    public Polyline(IGlOverlayLayer iGlOverlayLayer, PolylineOptions polylineOptions) {
        this.glOverlayLayerRef = new WeakReference(iGlOverlayLayer);
        this.options = polylineOptions;
    }

    public Polyline(IGlOverlayLayer iGlOverlayLayer, PolylineOptions polylineOptions, String str) {
        this.glOverlayLayerRef = new WeakReference(iGlOverlayLayer);
        this.options = polylineOptions;
        this.overlayName = str;
    }

    public Polyline(IPolyline iPolyline) {
        this.polylineDelegate = iPolyline;
    }

    private void a() {
        synchronized (this) {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (!(TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null)) {
                setOptionPointList(this.options);
                if (iGlOverlayLayer != null) {
                    iGlOverlayLayer.updateOption(this.overlayName, this.options);
                }
            }
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (!(obj instanceof Polyline)) {
            return false;
        }
        try {
            if (this.polylineDelegate != null) {
                return this.polylineDelegate.equalsRemote(((Polyline) obj).polylineDelegate);
            }
            if (super.equals(obj) || ((Polyline) obj).getId() == getId()) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public int getColor() {
        int i = 0;
        try {
            if (this.polylineDelegate != null) {
                return this.polylineDelegate.getColor();
            }
            if (this.options != null) {
                i = this.options.getColor();
            }
            return i;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public String getId() {
        try {
            return this.polylineDelegate != null ? this.polylineDelegate.getId() : this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public LatLng getNearestLatLng(LatLng latLng) {
        if (this.polylineDelegate != null) {
            return this.polylineDelegate.getNearestLatLng(latLng);
        }
        IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
        return iGlOverlayLayer != null ? iGlOverlayLayer.getNearestLatLng(this.options, latLng) : null;
    }

    public PolylineOptions getOptions() {
        return this.polylineDelegate != null ? this.polylineDelegate.getOptions() : this.options;
    }

    public List<LatLng> getPoints() {
        List<LatLng> list = null;
        try {
            if (this.polylineDelegate != null) {
                return this.polylineDelegate.getPoints();
            }
            if (this.options != null) {
                list = this.options.getPoints();
            }
            return list;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getShownRatio() {
        float f = -1.0f;
        try {
            if (this.polylineDelegate != null) {
                return this.polylineDelegate.getShownRatio();
            }
            if (this.options != null) {
                f = this.options.getShownRatio();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1.0f;
        }
    }

    public float getWidth() {
        float f = 0.0f;
        try {
            if (this.polylineDelegate != null) {
                return this.polylineDelegate.getWidth();
            }
            if (this.options != null) {
                f = this.options.getWidth();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getZIndex() {
        float f = 0.0f;
        try {
            if (this.polylineDelegate != null) {
                return this.polylineDelegate.getZIndex();
            }
            if (this.options != null) {
                f = this.options.getZIndex();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public int hashCode() {
        try {
            return this.polylineDelegate != null ? this.polylineDelegate.hashCodeRemote() : super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean isDottedLine() {
        if (this.polylineDelegate != null) {
            return this.polylineDelegate.isDottedLine();
        }
        return this.options != null ? this.options.isDottedLine() : false;
    }

    public boolean isGeodesic() {
        if (this.polylineDelegate.isGeodesic()) {
            return true;
        }
        return this.options != null ? this.options.isGeodesic() : false;
    }

    public boolean isVisible() {
        boolean z = false;
        try {
            if (this.polylineDelegate != null) {
                return this.polylineDelegate.isVisible();
            }
            if (this.options != null) {
                z = this.options.isVisible();
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void remove() {
        try {
            if (this.polylineDelegate != null) {
                this.polylineDelegate.remove();
                return;
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
            BitmapDescriptor customTexture = this.options.getCustomTexture();
            if (customTexture != null) {
                customTexture.recycle();
            }
            if (this.options.getCustomTextureList() != null) {
                for (BitmapDescriptor recycle : this.options.getCustomTextureList()) {
                    recycle.recycle();
                }
                this.options.getCustomTextureList().clear();
            }
            this.options = null;
            this.overlayName = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAboveMaskLayer(boolean z) {
        if (this.polylineDelegate != null) {
            this.polylineDelegate.setAboveMaskLayer(z);
        } else if (this.options != null) {
            this.options.aboveMaskLayer(z);
            a();
        }
    }

    public void setColor(int i) {
        try {
            if (this.polylineDelegate != null) {
                this.polylineDelegate.setColor(i);
            } else if (this.options != null) {
                this.options.color(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCustemTextureIndex(List<Integer> list) {
        if (this.polylineDelegate != null) {
            this.polylineDelegate.setCustemTextureIndex(list);
            return;
        }
        synchronized (this) {
            if (this.options != null) {
                this.options.setCustomTextureIndex(list);
                a();
            }
        }
    }

    public void setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        if (this.polylineDelegate != null) {
            this.polylineDelegate.setCustomTexture(bitmapDescriptor);
        } else if (this.options != null) {
            this.options.setCustomTexture(bitmapDescriptor);
            a();
        }
    }

    public void setCustomTextureList(List<BitmapDescriptor> list) {
        try {
            if (this.polylineDelegate != null) {
                this.polylineDelegate.setCustomTextureList(list);
                return;
            }
            this.options.setCustomTextureList(list);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDottedLine(boolean z) {
        if (this.polylineDelegate != null) {
            this.polylineDelegate.setDottedLine(z);
        } else if (this.options != null) {
            this.options.setDottedLine(z);
            a();
        }
    }

    public void setGeodesic(boolean z) {
        try {
            if (this.polylineDelegate != null) {
                if (this.polylineDelegate.isGeodesic() != z) {
                    List points = getPoints();
                    this.polylineDelegate.setGeodesic(z);
                    setPoints(points);
                }
            } else if (this.options != null) {
                this.options.geodesic(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* Access modifiers changed, original: protected */
    public void setOptionPointList(Object obj) {
        try {
            Class cls = obj.getClass();
            Field declaredField = cls.getDeclaredField("isPointsUpdated");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                if (declaredField.getBoolean(obj)) {
                    List points = ((PolylineOptions) obj).getPoints();
                    double[] dArr = new double[(points.size() * 2)];
                    for (int i = 0; i < points.size(); i++) {
                        int i2 = i * 2;
                        dArr[i2] = ((LatLng) points.get(i)).latitude;
                        dArr[i2 + 1] = ((LatLng) points.get(i)).longitude;
                    }
                    Field declaredField2 = cls.getDeclaredField("pointList");
                    if (declaredField2 != null) {
                        declaredField2.setAccessible(true);
                        declaredField2.set(obj, dArr);
                    }
                }
            }
        } catch (Throwable th) {
            ooOOOOoo.O00000o0(th, "Polyline", "setOptionPointList");
        }
    }

    public void setOptions(PolylineOptions polylineOptions) {
        if (this.polylineDelegate != null) {
            this.polylineDelegate.setOptions(polylineOptions);
            return;
        }
        this.options = polylineOptions;
        a();
    }

    public void setPoints(List<LatLng> list) {
        try {
            if (this.polylineDelegate != null) {
                this.polylineDelegate.setPoints(list);
                return;
            }
            synchronized (this) {
                if (this.options != null) {
                    this.options.setPoints(list);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setShownRange(float f, float f2) {
        try {
            if (this.polylineDelegate != null) {
                this.polylineDelegate.setShowRange(f, f2);
            } else if (this.options != null) {
                this.options.setShownRange(f, f2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setShownRatio(float f) {
        try {
            if (this.polylineDelegate != null) {
                this.polylineDelegate.setShownRatio(f);
            } else if (this.options != null) {
                this.options.setShownRatio(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTransparency(float f) {
        if (this.polylineDelegate != null) {
            this.polylineDelegate.setTransparency(f);
        } else if (this.options != null) {
            this.options.transparency(f);
            a();
        }
    }

    public void setVisible(boolean z) {
        try {
            if (this.polylineDelegate != null) {
                this.polylineDelegate.setVisible(z);
            } else if (this.options != null) {
                this.options.visible(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setWidth(float f) {
        try {
            if (this.polylineDelegate != null) {
                this.polylineDelegate.setWidth(f);
            } else if (this.options != null) {
                this.options.width(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            if (this.polylineDelegate != null) {
                this.polylineDelegate.setZIndex(f);
            } else if (this.options != null) {
                this.options.zIndex(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
