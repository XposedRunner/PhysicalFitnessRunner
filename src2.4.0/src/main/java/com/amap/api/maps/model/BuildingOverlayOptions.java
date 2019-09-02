package com.amap.api.maps.model;

import android.graphics.Point;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import java.util.ArrayList;
import java.util.List;

public class BuildingOverlayOptions extends BaseOptions {
    private int buildingHeight = -1;
    private int buildingHeightScale = 1;
    private List<LatLng> buildingLatlngs = new ArrayList();
    private int[] buildingLatlngsPoints;
    private int buildingSideColor = -7829368;
    private int buildingTopColor = -7829368;
    private boolean isVisible = true;
    private float zindex;

    public int getBuildingHeight() {
        return this.buildingHeight;
    }

    public int getBuildingHeightScale() {
        return this.buildingHeightScale;
    }

    public List<LatLng> getBuildingLatlngs() {
        return this.buildingLatlngs;
    }

    public int getBuildingSideColor() {
        return this.buildingSideColor;
    }

    public int getBuildingTopColor() {
        return this.buildingTopColor;
    }

    public int[] getPoints() {
        int i = 0;
        if (this.buildingLatlngs == null || this.buildingLatlngs.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[(this.buildingLatlngs.size() * 2)];
        int i2 = 0;
        while (i < this.buildingLatlngs.size()) {
            LatLng latLng = (LatLng) this.buildingLatlngs.get(i);
            Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
            int i3 = i2 + 1;
            iArr[i2] = latLongToPixels.x;
            i2 = i3 + 1;
            iArr[i3] = latLongToPixels.y;
            i++;
        }
        return iArr;
    }

    public float getZIndex() {
        return this.zindex;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    public BuildingOverlayOptions setBuildingHeight(int i) {
        this.buildingHeight = i;
        return this;
    }

    public BuildingOverlayOptions setBuildingHeightScale(int i) {
        this.buildingHeightScale = i;
        return this;
    }

    public BuildingOverlayOptions setBuildingLatlngs(List<LatLng> list) {
        this.buildingLatlngs = list;
        if (list != null && list.size() > 0) {
            this.buildingLatlngsPoints = new int[(list.size() * 2)];
            int i = 0;
            int i2 = 0;
            while (i < list.size()) {
                LatLng latLng = (LatLng) list.get(i);
                Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
                int i3 = i2 + 1;
                this.buildingLatlngsPoints[i2] = latLongToPixels.x;
                int i4 = i3 + 1;
                this.buildingLatlngsPoints[i3] = latLongToPixels.y;
                i++;
                i2 = i4;
            }
        }
        return this;
    }

    public BuildingOverlayOptions setBuildingSideColor(int i) {
        this.buildingSideColor = i;
        return this;
    }

    public BuildingOverlayOptions setBuildingTopColor(int i) {
        this.buildingTopColor = i;
        return this;
    }

    public void setVisible(boolean z) {
        this.isVisible = z;
    }

    public void setZIndex(float f) {
        this.zindex = f;
    }
}
