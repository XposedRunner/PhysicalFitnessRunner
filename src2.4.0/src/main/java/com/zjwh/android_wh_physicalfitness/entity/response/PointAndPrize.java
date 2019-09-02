package com.zjwh.android_wh_physicalfitness.entity.response;

import com.zjwh.android_wh_physicalfitness.entity.database.FivePoint;
import java.util.List;

public class PointAndPrize {
    private List<FivePoint> pointsResModels;
    private long sportStartTime;

    public List<FivePoint> getPointsResModels() {
        return this.pointsResModels;
    }

    public long getSportStartTime() {
        return this.sportStartTime;
    }

    public void setPointsResModels(List<FivePoint> list) {
        this.pointsResModels = list;
    }

    public void setSportStartTime(long j) {
        this.sportStartTime = j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PointAndPrize{pointsResModels=");
        stringBuilder.append(this.pointsResModels);
        stringBuilder.append(", sportStartTime=");
        stringBuilder.append(this.sportStartTime);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
