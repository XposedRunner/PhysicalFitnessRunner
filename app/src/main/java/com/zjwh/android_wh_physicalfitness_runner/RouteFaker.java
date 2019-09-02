package com.zjwh.android_wh_physicalfitness_runner;


import java.util.ArrayList;
import java.util.List;

import static com.zjwh.android_wh_physicalfitness_runner.MapUtils.getDistance;
import static com.zjwh.android_wh_physicalfitness_runner.MapUtils.nextLatLng;

public class RouteFaker {

    private RouteFaker() {

    }

    private static List<LatLng> fake(List<LatLng> latLngList) {
        List<LatLng> latLngs = new ArrayList<>(latLngList);
        for (int i = 1; i < latLngs.size() - 1; i++) {
//            if (i == 1) continue;
            Angle angle1 = Angle.elevate(latLngs.get(i - 1), latLngs.get(i));
            Angle angle2 = Angle.elevate(latLngs.get(i), latLngs.get(i + 1));
            double distance1 = getDistance(latLngs.get(i - 1), latLngs.get(i));
            double distance2 = getDistance(latLngs.get(i), latLngs.get(i - 1));
            double dAngle = Math.abs(angle1.deg() - angle2.deg());
            if ((dAngle > 30 && dAngle < 180) || (dAngle > 180 && dAngle < 330)) {
                LatLng latLng = latLngs.get(i);
                int size = latLngs.size();
                if (distance1 > 20) {
                    latLngs.add(latLngs.indexOf(latLng), nextLatLng(latLng, angle1, (double) -10));
                }
                if (distance2 > 20) {
                    latLngs.add(latLngs.indexOf(latLng) + 1, nextLatLng(latLng, angle2, (double) 10));
                }
                if (size != latLngs.size()) {
                    latLngs.remove(latLng);
                }

            }
        }
        return latLngs;

    }

    public static List<LatLng> fakeRoute(List<LatLng> latLngList) {
        List<LatLng> latLngs1 = new ArrayList<>();
        List<LatLng> latLngs2 = new ArrayList<>(latLngList);
        while (latLngs1.size() != latLngs2.size()) {
            latLngs1 = new ArrayList<>(latLngs2);
            latLngs2 = fake(latLngs2);
        }
        return latLngs1;
    }
}
