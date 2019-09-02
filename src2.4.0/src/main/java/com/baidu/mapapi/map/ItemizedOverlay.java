package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;
import com.baidu.mapsdkplatform.comapi.map.h;

public class ItemizedOverlay extends Overlay {
    MapView a;

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = h.marker;
        this.a = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions != null && overlayOptions != null) {
            this.a.getMap().addOverlay(overlayOptions);
        }
    }

    public void reAddAll() {
    }

    public void removeAll() {
        this.a.getMap().clear();
    }
}
