package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IArc;
import java.lang.ref.WeakReference;

public final class Arc extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private IArc iArcDel;
    private ArcOptions options;
    private String overlayName;

    public Arc(IGlOverlayLayer iGlOverlayLayer, ArcOptions arcOptions) {
        this.glOverlayLayerRef = new WeakReference(iGlOverlayLayer);
        this.options = arcOptions;
        this.overlayName = "";
    }

    public Arc(IArc iArc) {
        this.iArcDel = iArc;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
        if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof Arc)) {
            return false;
        }
        try {
            if (this.iArcDel != null) {
                return this.iArcDel.equalsRemote(((Arc) obj).iArcDel);
            }
            if (super.equals(obj) || ((Arc) obj).getId() == getId()) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public String getId() {
        try {
            return this.iArcDel != null ? this.iArcDel.getId() : this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int getStrokeColor() {
        int i = 0;
        try {
            if (this.iArcDel != null) {
                return this.iArcDel.getStrokeColor();
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
            if (this.iArcDel != null) {
                return this.iArcDel.getStrokeWidth();
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
            if (this.iArcDel != null) {
                return this.iArcDel.getZIndex();
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
            return this.iArcDel != null ? this.iArcDel.hashCodeRemote() : super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean isVisible() {
        boolean z = false;
        try {
            if (this.iArcDel != null) {
                return this.iArcDel.isVisible();
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
            if (this.iArcDel != null) {
                this.iArcDel.remove();
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

    public void setStrokeColor(int i) {
        try {
            if (this.iArcDel != null) {
                this.iArcDel.setStrokeColor(i);
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
            if (this.iArcDel != null) {
                this.iArcDel.setStrokeWidth(f);
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
            if (this.iArcDel != null) {
                this.iArcDel.setVisible(z);
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
            if (this.iArcDel != null) {
                this.iArcDel.setZIndex(f);
            } else if (this.options != null) {
                this.options.zIndex(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
