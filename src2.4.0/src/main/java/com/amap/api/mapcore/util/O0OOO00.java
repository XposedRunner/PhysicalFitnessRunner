package com.amap.api.mapcore.util;

import android.os.RemoteException;
import android.support.v4.internal.view.SupportMenu;
import com.amap.api.maps.model.BuildingOverlayOptions;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.AMapNativeBuildingRenderer;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BuildingOverlayDelegateImp */
public class O0OOO00 implements O0OOo, OooOO {
    long O000000o = -1;
    private by O00000Oo;
    private List<BuildingOverlayOptions> O00000o = new ArrayList();
    private BuildingOverlayOptions O00000o0;
    private List<BuildingOverlayOptions> O00000oO;
    private boolean O00000oo = true;
    private String O0000O0o;
    private float O0000OOo;
    private OO00O O0000Oo;
    private boolean O0000Oo0;

    public O0OOO00(by byVar) {
        try {
            this.O00000Oo = byVar;
            if (this.O00000o0 == null) {
                this.O00000o0 = new BuildingOverlayOptions();
                this.O00000o0.setVisible(true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new LatLng(84.9d, -179.9d));
                arrayList.add(new LatLng(84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, 179.9d));
                arrayList.add(new LatLng(-84.9d, -179.9d));
                this.O00000o0.setBuildingLatlngs(arrayList);
                this.O00000o0.setBuildingTopColor(SupportMenu.CATEGORY_MASK);
                this.O00000o0.setBuildingSideColor(-12303292);
                this.O00000o0.setVisible(true);
                this.O00000o0.setZIndex(1.0f);
                this.O00000o.add(this.O00000o0);
                O000000o(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void O000000o(boolean z) {
        try {
            synchronized (this) {
                if (z) {
                    this.O00000o.set(0, this.O00000o0);
                } else {
                    this.O00000o.removeAll(this.O00000oO);
                    this.O00000o.set(0, this.O00000o0);
                    this.O00000o.addAll(this.O00000oO);
                }
                this.O0000Oo0 = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
        }
    }

    public void O000000o(OO00O oo00o) {
        this.O0000Oo = oo00o;
    }

    public void O000000o(BuildingOverlayOptions buildingOverlayOptions) {
        if (buildingOverlayOptions != null) {
            synchronized (this) {
                this.O00000o0 = buildingOverlayOptions;
            }
            O000000o(true);
        }
    }

    public void O000000o(MapConfig mapConfig) throws RemoteException {
        if (mapConfig != null) {
            try {
                if (this.O000000o != -1) {
                    synchronized (this) {
                        if (this.O000000o != -1) {
                            if (this.O0000Oo0) {
                                AMapNativeBuildingRenderer.nativeClearBuildingOptions(this.O000000o);
                                for (int i = 0; i < this.O00000o.size(); i++) {
                                    AMapNativeBuildingRenderer.addBuildingOptions(this.O000000o, (BuildingOverlayOptions) this.O00000o.get(i));
                                }
                                this.O0000Oo0 = false;
                            }
                            AMapNativeBuildingRenderer.render(this.O000000o, mapConfig.getViewMatrix(), mapConfig.getProjectionMatrix(), mapConfig.getSX(), mapConfig.getSY(), mapConfig.getSZ(), mapConfig.getCurTileIds());
                        }
                    }
                } else {
                    this.O000000o = AMapNativeBuildingRenderer.nativeCreate();
                    if (!(this.O000000o == -1 || this.O0000Oo == null)) {
                        AMapNativeBuildingRenderer.nativeSetGLShaderManager(this.O000000o, this.O0000Oo.O000000o());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void O000000o(List<BuildingOverlayOptions> list) {
        if (list != null && list.size() > 0) {
            synchronized (this) {
                this.O00000oO = list;
            }
            O000000o(false);
        }
    }

    public boolean O000000o() {
        return true;
    }

    public List<BuildingOverlayOptions> O00000Oo() {
        return this.O00000oO;
    }

    public BuildingOverlayOptions O00000o() {
        BuildingOverlayOptions buildingOverlayOptions;
        synchronized (this) {
            buildingOverlayOptions = this.O00000o0;
        }
        return buildingOverlayOptions;
    }

    public boolean O00000o0() {
        return false;
    }

    public void destroy() {
        synchronized (this) {
            if (this.O000000o != -1) {
                AMapNativeBuildingRenderer.nativeDestory(this.O000000o);
                if (this.O00000o != null) {
                    this.O00000o.clear();
                }
                this.O00000oO = null;
                this.O00000o0 = null;
                this.O000000o = -1;
            }
        }
    }

    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return false;
    }

    public String getId() {
        if (this.O0000O0o == null) {
            this.O0000O0o = this.O00000Oo.O000000o("Building");
        }
        return this.O0000O0o;
    }

    public float getZIndex() {
        return this.O0000OOo;
    }

    public int hashCodeRemote() throws RemoteException {
        return 0;
    }

    public boolean isAboveMaskLayer() {
        return false;
    }

    public boolean isVisible() {
        return this.O00000oo;
    }

    public void remove() throws RemoteException {
    }

    public void setAboveMaskLayer(boolean z) {
    }

    public void setVisible(boolean z) {
        this.O00000oo = z;
    }

    public void setZIndex(float f) {
        try {
            this.O0000OOo = f;
            this.O00000Oo.O00000oO();
            synchronized (this) {
                this.O00000o0.setZIndex(this.O0000OOo);
            }
            O000000o(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
