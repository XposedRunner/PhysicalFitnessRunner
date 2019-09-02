package com.amap.api.maps.model;

import android.text.TextUtils;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.amap.mapcore.interfaces.IGroundOverlay;
import java.lang.ref.WeakReference;

public final class GroundOverlay extends BaseOverlay {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private float high;
    private IGroundOverlay iGroundOverlayDelegate;
    private GroundOverlayOptions options;
    private String overlayName;
    private LatLng point;
    private float width;

    public GroundOverlay(IGlOverlayLayer iGlOverlayLayer, GroundOverlayOptions groundOverlayOptions) {
        this.glOverlayLayerRef = new WeakReference(iGlOverlayLayer);
        this.options = groundOverlayOptions;
        this.overlayName = "";
    }

    public GroundOverlay(IGroundOverlay iGroundOverlay) {
        this.iGroundOverlayDelegate = iGroundOverlay;
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
        if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
            iGlOverlayLayer.updateOption(this.overlayName, this.options);
        }
    }

    public void destroy() {
        try {
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.destroy();
                return;
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null || !(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            if (this.iGroundOverlayDelegate != null) {
                return this.iGroundOverlayDelegate.equalsRemote(((GroundOverlay) obj).iGroundOverlayDelegate);
            }
            if (super.equals(obj) || ((GroundOverlay) obj).getId() == getId()) {
                z = true;
            }
            return z;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public float getBearing() {
        float f = 0.0f;
        try {
            if (this.iGroundOverlayDelegate != null) {
                return this.iGroundOverlayDelegate.getBearing();
            }
            if (this.options != null) {
                f = this.options.getBearing();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public LatLngBounds getBounds() {
        LatLngBounds latLngBounds = null;
        try {
            if (this.iGroundOverlayDelegate != null) {
                return this.iGroundOverlayDelegate.getBounds();
            }
            if (this.options != null) {
                latLngBounds = this.options.getBounds();
            }
            return latLngBounds;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getHeight() {
        float f = 0.0f;
        try {
            if (this.iGroundOverlayDelegate != null) {
                return this.iGroundOverlayDelegate.getHeight();
            }
            if (this.options != null) {
                f = this.options.getHeight();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public String getId() {
        try {
            return this.iGroundOverlayDelegate != null ? this.iGroundOverlayDelegate.getId() : this.overlayName;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public LatLng getPosition() {
        LatLng latLng = null;
        try {
            if (this.iGroundOverlayDelegate != null) {
                return this.iGroundOverlayDelegate.getPosition();
            }
            if (this.options != null) {
                latLng = this.options.getLocation();
            }
            return latLng;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public float getTransparency() {
        float f = 0.0f;
        try {
            if (this.iGroundOverlayDelegate != null) {
                return this.iGroundOverlayDelegate.getTransparency();
            }
            if (this.options != null) {
                f = this.options.getTransparency();
            }
            return f;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0.0f;
        }
    }

    public float getWidth() {
        float f = 0.0f;
        try {
            if (this.iGroundOverlayDelegate != null) {
                return this.iGroundOverlayDelegate.getWidth();
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
            if (this.iGroundOverlayDelegate != null) {
                return this.iGroundOverlayDelegate.getZIndex();
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
        return this.iGroundOverlayDelegate != null ? this.iGroundOverlayDelegate.hashCode() : super.hashCode();
    }

    public boolean isVisible() {
        boolean z = false;
        try {
            if (this.iGroundOverlayDelegate != null) {
                return this.iGroundOverlayDelegate.isVisible();
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
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.remove();
                return;
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
            if (this.options != null && this.options.getImage() != null) {
                this.options.getImage().recycle();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setBearing(float f) {
        try {
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.setBearing(f);
            } else if (this.options != null) {
                this.options.bearing(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDimensions(float f) {
        try {
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.setDimensions(f);
            } else if (this.options != null) {
                LatLng location = this.point != null ? this.point : this.options.getLocation();
                if (location == null) {
                    this.width = f;
                    return;
                }
                this.options.position(location, f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setDimensions(float f, float f2) {
        try {
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.setDimensions(f, f2);
            } else if (this.options != null) {
                if ((this.point != null ? this.point : this.options.getLocation()) == null) {
                    this.width = f;
                    this.high = f2;
                    return;
                }
                this.options.position(this.options.getLocation(), f, f2);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setImage(BitmapDescriptor bitmapDescriptor) {
        try {
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.setImage(bitmapDescriptor);
            } else if (this.options != null) {
                this.options.image(bitmapDescriptor);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPosition(LatLng latLng) {
        try {
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.setPosition(latLng);
            } else if (this.options != null && latLng != null) {
                float width = this.width > 0.0f ? this.width : this.options.getWidth();
                float height = this.high > 0.0f ? this.high : this.options.getHeight();
                if (width == 0.0f) {
                    this.point = latLng;
                } else if (height == 0.0f) {
                    this.options.position(latLng, width);
                    a();
                } else if (height > 0.0f) {
                    this.options.position(latLng, width, height);
                    a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setPositionFromBounds(LatLngBounds latLngBounds) {
        try {
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.setPositionFromBounds(latLngBounds);
            } else if (this.options != null && latLngBounds != null) {
                this.options.positionFromBounds(latLngBounds);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTransparency(float f) {
        try {
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.setTransparency(f);
            } else if (this.options != null) {
                this.options.transparency(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVisible(boolean z) {
        try {
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.setVisible(z);
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
            if (this.iGroundOverlayDelegate != null) {
                this.iGroundOverlayDelegate.setZIndex(f);
            } else if (this.options != null) {
                this.options.zIndex(f);
                a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
