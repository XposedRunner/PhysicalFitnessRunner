package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.INavigateArrow;
import java.lang.ref.WeakReference;
import java.util.List;

public class NavigateArrow extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private INavigateArrow navigateArrowDelegate;
    private NavigateArrowOptions options;
    private String overlayName = "";

    public NavigateArrow(IGlOverlayLayer iGlOverlayLayer, NavigateArrowOptions navigateArrowOptions) {
        this.glOverlayLayerRef = new WeakReference(iGlOverlayLayer);
        this.options = navigateArrowOptions;
    }

    public NavigateArrow(INavigateArrow iNavigateArrow) {
        this.navigateArrowDelegate = iNavigateArrow;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
        if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof NavigateArrow)) {
            return false;
        }
        try {
            if (this.navigateArrowDelegate != null) {
                return this.navigateArrowDelegate.equalsRemote(((NavigateArrow) obj).navigateArrowDelegate);
            }
            if (super.equals(obj) || ((NavigateArrow) obj).getId() == getId()) {
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
            return this.navigateArrowDelegate != null ? this.navigateArrowDelegate.getId() : this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public List<LatLng> getPoints() {
        List<LatLng> list = null;
        try {
            if (this.navigateArrowDelegate != null) {
                return this.navigateArrowDelegate.getPoints();
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

    @Deprecated
    public int getSideColor() {
        int i = 0;
        try {
            if (this.navigateArrowDelegate != null) {
                return this.navigateArrowDelegate.getSideColor();
            }
            if (this.options != null) {
                i = this.options.getSideColor();
            }
            return i;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getTopColor() {
        int i = 0;
        try {
            if (this.navigateArrowDelegate != null) {
                return this.navigateArrowDelegate.getTopColor();
            }
            if (this.options != null) {
                i = this.options.getTopColor();
            }
            return i;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public float getWidth() {
        float f = 0.0f;
        try {
            if (this.navigateArrowDelegate != null) {
                return this.navigateArrowDelegate.getWidth();
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
            if (this.navigateArrowDelegate != null) {
                return this.navigateArrowDelegate.getZIndex();
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
            return this.navigateArrowDelegate != null ? this.navigateArrowDelegate.hashCodeRemote() : super.hashCode();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public boolean is3DModel() {
        boolean z = false;
        try {
            if (this.navigateArrowDelegate != null) {
                return this.navigateArrowDelegate.is3DModel();
            }
            if (this.options != null) {
                z = this.options.is3DModel();
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public boolean isVisible() {
        boolean z = false;
        try {
            if (this.navigateArrowDelegate != null) {
                return this.navigateArrowDelegate.isVisible();
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
            if (this.navigateArrowDelegate != null) {
                this.navigateArrowDelegate.remove();
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

    public void set3DModel(boolean z) {
        try {
            if (this.navigateArrowDelegate != null) {
                this.navigateArrowDelegate.set3DModel(z);
            } else if (this.options != null) {
                this.options.set3DModel(z);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPoints(List<LatLng> list) {
        try {
            if (this.navigateArrowDelegate != null) {
                this.navigateArrowDelegate.setPoints(list);
            } else if (this.options != null) {
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSideColor(int i) {
        try {
            if (this.navigateArrowDelegate != null) {
                this.navigateArrowDelegate.setSideColor(i);
            } else if (this.options != null) {
                this.options.sideColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTopColor(int i) {
        try {
            if (this.navigateArrowDelegate != null) {
                this.navigateArrowDelegate.setTopColor(i);
            } else if (this.options != null) {
                this.options.topColor(i);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            if (this.navigateArrowDelegate != null) {
                this.navigateArrowDelegate.setVisible(z);
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
            if (this.navigateArrowDelegate != null) {
                this.navigateArrowDelegate.setWidth(f);
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
            if (this.navigateArrowDelegate != null) {
                this.navigateArrowDelegate.setZIndex(f);
            } else if (this.options != null) {
                this.options.zIndex(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
