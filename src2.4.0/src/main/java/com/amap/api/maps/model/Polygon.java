package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.mapcore.util.ooOOOOoo;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IPolygon;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class Polygon extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private PolygonOptions options;
    private IPolygon polygonDelegate;

    public Polygon(IGlOverlayLayer iGlOverlayLayer, PolygonOptions polygonOptions) {
        this.glOverlayLayerRef = new WeakReference(iGlOverlayLayer);
        this.options = polygonOptions;
    }

    public Polygon(IPolygon iPolygon) {
        this.polygonDelegate = iPolygon;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
        if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
            setOptionPointList(this.options);
            iGlOverlayLayer.processPolygonHoleOption(this.options);
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        }
    }

    public boolean contains(LatLng latLng) {
        try {
            if (this.polygonDelegate != null) {
                return this.polygonDelegate.contains(latLng);
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            return iGlOverlayLayer != null ? iGlOverlayLayer.IsPolygonContainsPoint(this.options, latLng) : false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof Polygon)) {
            return false;
        }
        try {
            if (this.polygonDelegate != null) {
                return this.polygonDelegate.equalsRemote(((Polygon) obj).polygonDelegate);
            }
            if (super.equals(obj) || ((Polygon) obj).getId() == getId()) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public int getFillColor() {
        int i = 0;
        try {
            if (this.polygonDelegate != null) {
                return this.polygonDelegate.getFillColor();
            }
            if (this.options != null) {
                i = this.options.getFillColor();
            }
            return i;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public List<BaseHoleOptions> getHoleOptions() {
        List<BaseHoleOptions> list = null;
        try {
            if (this.polygonDelegate != null) {
                return this.polygonDelegate.getHoleOptions();
            }
            if (this.options != null) {
                list = this.options.getHoleOptions();
            }
            return list;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getId() {
        try {
            return this.polygonDelegate != null ? this.polygonDelegate.getId() : this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<LatLng> getPoints() {
        List<LatLng> list = null;
        try {
            if (this.polygonDelegate != null) {
                return this.polygonDelegate.getPoints();
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

    public int getStrokeColor() {
        int i = 0;
        try {
            if (this.polygonDelegate != null) {
                return this.polygonDelegate.getStrokeColor();
            }
            if (this.options != null) {
                i = this.options.getStrokeColor();
            }
            return i;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public float getStrokeWidth() {
        float f = 0.0f;
        try {
            if (this.polygonDelegate != null) {
                return this.polygonDelegate.getStrokeWidth();
            }
            if (this.options != null) {
                f = this.options.getStrokeWidth();
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
            if (this.polygonDelegate != null) {
                return this.polygonDelegate.getZIndex();
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
            return this.polygonDelegate != null ? this.polygonDelegate.hashCodeRemote() : super.hashCode();
        } catch (Throwable unused) {
            return super.hashCode();
        }
    }

    public boolean isVisible() {
        boolean z = false;
        try {
            if (this.polygonDelegate != null) {
                return this.polygonDelegate.isVisible();
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
            if (this.polygonDelegate != null) {
                this.polygonDelegate.remove();
                return;
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setFillColor(int i) {
        try {
            if (this.polygonDelegate != null) {
                this.polygonDelegate.setFillColor(i);
            } else if (this.options != null) {
                this.options.fillColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            if (this.polygonDelegate != null) {
                this.polygonDelegate.setHoleOptions(list);
                return;
            }
            List list2;
            if (list2 == null) {
                list2 = new ArrayList();
            }
            this.options.setHoleOptions(list2);
            a();
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
                    List points = ((PolygonOptions) obj).getPoints();
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
            ooOOOOoo.O00000o0(th, "Polygon", "setOptionPointList");
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            if (this.polygonDelegate != null) {
                this.polygonDelegate.setPoints(list);
                return;
            }
            this.options.setPoints(list);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStrokeColor(int i) {
        try {
            if (this.polygonDelegate != null) {
                this.polygonDelegate.setStrokeColor(i);
            } else if (this.options != null) {
                this.options.strokeColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStrokeWidth(float f) {
        try {
            if (this.polygonDelegate != null) {
                this.polygonDelegate.setStrokeWidth(f);
                return;
            }
            this.options.strokeWidth(f);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            if (this.polygonDelegate != null) {
                this.polygonDelegate.setVisible(z);
            } else if (this.options != null) {
                this.options.visible(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setZIndex(float f) {
        try {
            if (this.polygonDelegate != null) {
                this.polygonDelegate.setZIndex(f);
            } else if (this.options != null) {
                this.options.zIndex(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
