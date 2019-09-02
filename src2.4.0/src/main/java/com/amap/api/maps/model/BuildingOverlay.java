package com.amap.api.maps.model;

import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import com.amap.api.mapcore.util.O0OOo;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class BuildingOverlay extends BaseOverlay {
    private BuildingOverlayTotalOptions buildingOverlayTotalOptions = new BuildingOverlayTotalOptions();
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private BuildingOverlayOptions mDefaultOptions;
    private O0OOo mDelegate;
    private List<BuildingOverlayOptions> optionList;

    protected class BuildingOverlayTotalOptions extends BaseOptions {
        public List<BuildingOverlayOptions> allOptionList;
        public boolean isVisible = true;
        private final String type = "BuildingOptions";
        private float zIndex = 0.0f;

        protected BuildingOverlayTotalOptions() {
        }
    }

    public BuildingOverlay(O0OOo o0OOo) {
        this.mDelegate = o0OOo;
    }

    public BuildingOverlay(IGlOverlayLayer iGlOverlayLayer) {
        this.glOverlayLayerRef = new WeakReference(iGlOverlayLayer);
        this.buildingOverlayTotalOptions.allOptionList = new ArrayList();
        if (this.mDefaultOptions == null) {
            this.mDefaultOptions = new BuildingOverlayOptions();
            this.mDefaultOptions.setVisible(true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new LatLng(84.9d, -179.9d));
            arrayList.add(new LatLng(84.9d, 179.9d));
            arrayList.add(new LatLng(-84.9d, 179.9d));
            arrayList.add(new LatLng(-84.9d, -179.9d));
            this.mDefaultOptions.setBuildingLatlngs(arrayList);
            this.mDefaultOptions.setBuildingTopColor(SupportMenu.CATEGORY_MASK);
            this.mDefaultOptions.setBuildingSideColor(-12303292);
            this.mDefaultOptions.setVisible(true);
            this.mDefaultOptions.setZIndex(1.0f);
            this.buildingOverlayTotalOptions.allOptionList.add(this.mDefaultOptions);
            a(true);
        }
    }

    private void a() {
        IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
        if (!TextUtils.isEmpty(this.overlayName) && iGlOverlayLayer != null) {
            iGlOverlayLayer.updateOption(this.overlayName, this.buildingOverlayTotalOptions);
        }
    }

    private void a(boolean z) {
        try {
            synchronized (this) {
                if (z) {
                    this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);
                } else {
                    this.buildingOverlayTotalOptions.allOptionList.removeAll(this.optionList);
                    this.buildingOverlayTotalOptions.allOptionList.set(0, this.mDefaultOptions);
                    this.buildingOverlayTotalOptions.allOptionList.addAll(this.optionList);
                }
                IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
                if (iGlOverlayLayer != null) {
                    iGlOverlayLayer.updateOption(this.overlayName, this.buildingOverlayTotalOptions);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
        }
    }

    public void destroy() {
        try {
            if (this.mDelegate != null) {
                this.mDelegate.destroy();
                return;
            }
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (iGlOverlayLayer != null) {
                iGlOverlayLayer.removeOverlay(this.overlayName);
            }
        } catch (Throwable unused) {
        }
    }

    public List<BuildingOverlayOptions> getCustomOptions() {
        return this.mDelegate != null ? this.mDelegate.O00000Oo() : this.optionList;
    }

    public BuildingOverlayOptions getDefaultOptions() {
        return this.mDelegate != null ? this.mDelegate.O00000o() : this.mDefaultOptions;
    }

    public String getId() {
        return this.mDelegate != null ? this.mDelegate.getId() : this.overlayName;
    }

    public float getZIndex() {
        if (this.mDelegate != null) {
            return this.mDelegate.getZIndex();
        }
        return this.buildingOverlayTotalOptions != null ? this.buildingOverlayTotalOptions.zIndex : 0.0f;
    }

    public boolean isVisible() {
        if (this.mDelegate != null) {
            return this.mDelegate.isVisible();
        }
        return this.buildingOverlayTotalOptions != null ? this.buildingOverlayTotalOptions.isVisible : false;
    }

    public void setCustomOptions(List<BuildingOverlayOptions> list) {
        if (this.mDelegate != null) {
            this.mDelegate.O000000o((List) list);
        } else if (list != null && list.size() > 0) {
            synchronized (this) {
                this.optionList = list;
            }
            a(false);
        }
    }

    public void setDefaultOptions(BuildingOverlayOptions buildingOverlayOptions) {
        if (this.mDelegate != null) {
            this.mDelegate.O000000o(buildingOverlayOptions);
        } else if (buildingOverlayOptions != null) {
            synchronized (this) {
                this.mDefaultOptions = buildingOverlayOptions;
            }
            a(true);
        }
    }

    public void setVisible(boolean z) {
        if (this.mDelegate != null) {
            this.mDelegate.setVisible(z);
        } else if (this.buildingOverlayTotalOptions != null) {
            this.buildingOverlayTotalOptions.isVisible = z;
            a();
        }
    }

    public void setZIndex(float f) {
        if (this.mDelegate != null) {
            this.mDelegate.setZIndex(f);
            return;
        }
        if (this.mDefaultOptions != null) {
            this.mDefaultOptions.setZIndex(f);
        }
        if (this.buildingOverlayTotalOptions != null) {
            this.buildingOverlayTotalOptions.zIndex = f;
            a();
        }
    }
}
