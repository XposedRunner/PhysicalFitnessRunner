package com.amap.api.mapcore.util;

import com.amap.api.maps.model.LatLng;

/* compiled from: BaseOverlayImp */
public abstract class bi implements ce {
    public abstract String getId();

    public abstract LatLng getPosition();

    public abstract String getSnippet();

    public abstract String getTitle();

    public boolean isDraggable() {
        return false;
    }

    public boolean isInfoWindowAutoOverturn() {
        return false;
    }

    public abstract boolean isVisible();
}
