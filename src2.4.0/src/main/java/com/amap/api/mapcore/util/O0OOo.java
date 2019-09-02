package com.amap.api.mapcore.util;

import com.amap.api.maps.model.BuildingOverlayOptions;
import java.util.List;

/* compiled from: IBuildingDelegate */
public interface O0OOo {
    void O000000o(BuildingOverlayOptions buildingOverlayOptions);

    void O000000o(List<BuildingOverlayOptions> list);

    List<BuildingOverlayOptions> O00000Oo();

    BuildingOverlayOptions O00000o();

    void destroy();

    String getId();

    float getZIndex();

    boolean isVisible();

    void setVisible(boolean z);

    void setZIndex(float f);
}
