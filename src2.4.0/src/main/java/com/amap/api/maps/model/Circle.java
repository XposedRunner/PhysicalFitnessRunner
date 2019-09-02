package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.ICircle;
import java.lang.ref.WeakReference;
import java.util.List;

public final class Circle extends BaseOverlay {
    WeakReference<IGlOverlayLayer> a;
    private ICircle iCircleDel;
    private CircleOptions options;
    private String overlayName = "";

    public Circle(IGlOverlayLayer iGlOverlayLayer, CircleOptions circleOptions) {
        this.a = new WeakReference(iGlOverlayLayer);
        this.options = circleOptions;
    }

    public Circle(ICircle iCircle) {
        this.iCircleDel = iCircle;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.a.get();
        if (iGlOverlayLayer != null) {
            iGlOverlayLayer.processCircleHoleOption(this.options);
        }
        if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        }
    }

    public boolean contains(LatLng latLng) {
        try {
            if (this.iCircleDel != null) {
                return this.iCircleDel.contains(latLng);
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.a.get();
            if (iGlOverlayLayer != null) {
                return iGlOverlayLayer.IsCircleContainPoint(this.options, latLng);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof Circle)) {
            return false;
        }
        try {
            if (this.iCircleDel != null) {
                return this.iCircleDel.equalsRemote(((Circle) obj).iCircleDel);
            }
            if (super.equals(obj) || ((Circle) obj).getId() == getId()) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public LatLng getCenter() {
        LatLng latLng = null;
        try {
            if (this.iCircleDel != null) {
                return this.iCircleDel.getCenter();
            }
            if (this.options != null) {
                latLng = this.options.getCenter();
            }
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int getFillColor() {
        int i = 0;
        try {
            if (this.iCircleDel != null) {
                return this.iCircleDel.getFillColor();
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
            if (this.iCircleDel != null) {
                return this.iCircleDel.getHoleOptions();
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
            return this.iCircleDel != null ? this.iCircleDel.getId() : this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public double getRadius() {
        double d = 0.0d;
        try {
            if (this.iCircleDel != null) {
                return this.iCircleDel.getRadius();
            }
            if (this.options != null) {
                d = this.options.getRadius();
            }
            return d;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0d;
        }
    }

    public int getStrokeColor() {
        int i = 0;
        try {
            if (this.iCircleDel != null) {
                return this.iCircleDel.getStrokeColor();
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

    public int getStrokeDottedLineType() {
        int i = -1;
        try {
            if (this.iCircleDel != null) {
                return this.iCircleDel.getDottedLineType();
            }
            if (this.options != null) {
                i = this.options.getStrokeDottedLineType();
            }
            return i;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public float getStrokeWidth() {
        float f = 0.0f;
        try {
            if (this.iCircleDel != null) {
                return this.iCircleDel.getStrokeWidth();
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
            if (this.iCircleDel != null) {
                return this.iCircleDel.getZIndex();
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
            return this.iCircleDel != null ? this.iCircleDel.hashCodeRemote() : super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean isVisible() {
        boolean z = false;
        try {
            if (this.iCircleDel != null) {
                return this.iCircleDel.isVisible();
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
            if (this.iCircleDel != null) {
                this.iCircleDel.remove();
                return;
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.a.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setCenter(LatLng latLng) {
        try {
            if (this.iCircleDel != null) {
                this.iCircleDel.setCenter(latLng);
            } else if (this.options != null) {
                this.options.center(latLng);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setFillColor(int i) {
        try {
            if (this.iCircleDel != null) {
                this.iCircleDel.setFillColor(i);
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
            if (this.iCircleDel != null) {
                this.iCircleDel.setHoleOptions(list);
            } else if (list != null) {
                synchronized (list) {
                    this.options.getHoleOptions().clear();
                    this.options.addHoles((Iterable) list);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setRadius(double d) {
        try {
            if (this.iCircleDel != null) {
                this.iCircleDel.setRadius(d);
            } else if (this.options != null) {
                this.options.radius(d);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStrokeColor(int i) {
        try {
            if (this.iCircleDel != null) {
                this.iCircleDel.setStrokeColor(i);
            } else if (this.options != null) {
                this.options.strokeColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStrokeDottedLineType(int i) {
        try {
            if (this.iCircleDel != null) {
                this.iCircleDel.setDottedLineType(i);
            } else if (this.options != null) {
                this.options.setStrokeDottedLineType(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setStrokeWidth(float f) {
        try {
            if (this.iCircleDel != null) {
                this.iCircleDel.setStrokeWidth(f);
            } else if (this.options != null) {
                this.options.strokeWidth(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            if (this.iCircleDel != null) {
                this.iCircleDel.setVisible(z);
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
            if (this.iCircleDel != null) {
                this.iCircleDel.setZIndex(f);
            } else if (this.options != null) {
                this.options.zIndex(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
