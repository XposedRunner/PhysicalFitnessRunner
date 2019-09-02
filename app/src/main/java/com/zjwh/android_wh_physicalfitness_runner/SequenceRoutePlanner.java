package com.zjwh.android_wh_physicalfitness_runner;

import android.content.Context;
import android.util.Log;

import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;

import java.util.ArrayList;
import java.util.List;

public class SequenceRoutePlanner {
//    private RouteSearch mRouteSearch;
//    private LatLng mStart;
//    private List<RoutePoint> mBypassList;
//    private int mTargetLength;
//
//    private SequenceRoutePlanner(Context context) {
//        mRouteSearch = new RouteSearch(context);
//    }
//
//
//    public static SequenceRoutePlanner withContext(Context context) {
//        return new SequenceRoutePlanner(context);
//    }
//
//    public SequenceRoutePlanner start(LatLng latLng) {
//        mStart = latLng;
//        return this;
//    }
//
//    public SequenceRoutePlanner bypass(List<RoutePoint> routePointList) {
//        for (int i = 1; i < routePointList.size(); i++) {
//            for (int j = 1; j < routePointList.size() - i; j++) {
//                if (routePointList.get(i).order > routePointList.get(j).order) {
//                    RoutePoint iRoutePoint = routePointList.get(i);
//                    RoutePoint jRoutePoint = routePointList.get(j);
//                    routePointList.set(i, jRoutePoint);
//                    routePointList.set(j, iRoutePoint);
//                }
//            }
//        }
//        mBypassList = new ArrayList<>(routePointList);
//        return this;
//    }
//
//    public SequenceRoutePlanner target(int length) {
//        mTargetLength = length;
//        return this;
//    }
//
//    public void plan(final OnPlanCompleteListener onPlanCompleteListener) {
//        if (mStart == null || mBypassList == null || onPlanCompleteListener == null || mTargetLength < 0 || mBypassList.size() < 2) {
//            if (onPlanCompleteListener != null) {
//                onPlanCompleteListener.onError();
//            }
//            return;
//        }
//        final List<RouteSearchCache> routeSearchCacheList = new ArrayList<>();
//
//        mRouteSearch.setRouteSearchListener(new RouteSearch.OnRouteSearchListener() {
//            @Override
//            public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {
//
//            }
//
//            @Override
//            public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i) {
//
//            }
//
//            @Override
//            public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {
//                ZjwhRunner.log("SequenceRoutePlanner.plan: 2" + (walkRouteResult == null ? "null" : walkRouteResult.toString()) + " " + i);
//                if (i == 1000) {
//                    for (RouteSearchCache routeSearchCache : routeSearchCacheList) {
//                        if (routeSearchCache.walkRouteResult == null) {
//                            routeSearchCache.walkRouteResult = walkRouteResult;
//                            RouteSearchCache nextRouteSearchCache =
//                                    routeSearchCacheList.indexOf(routeSearchCache) + 1 < routeSearchCacheList.size()
//                                            ? routeSearchCacheList.get(routeSearchCacheList.indexOf(routeSearchCache) + 1) : null;
//                            if (nextRouteSearchCache != null) {
//                                ZjwhRunner.log("SequenceRoutePlanner.plan: 4");
//                                mRouteSearch.calculateWalkRouteAsyn(nextRouteSearchCache.walkRouteQuery);
//                            }
//                            break;
//                        }
//                    }
//                } else if (i / 100 == 11 || i / 100 == 18) {
//                    for (RouteSearchCache routeSearchCache : routeSearchCacheList) {
//                        if (routeSearchCache.walkRouteResult == null) {
//                            mRouteSearch.calculateWalkRouteAsyn(routeSearchCache.walkRouteQuery);
//                            break;
//                        }
//
//                    }
//                } else {
//                    onPlanCompleteListener.onError();
//                }
//                List<LatLng> latLngs = new ArrayList<>();
//                latLngs.add(mStart);
//                int distance = 0;
//                for (RouteSearchCache routeSearchCache : routeSearchCacheList) {
//                    if (routeSearchCache.walkRouteResult == null) {
//                        return;
//                    }
//                    distance += routeSearchCache.walkRouteResult.getPaths().get(0).getDistance();
//                    for (WalkStep walkStep : routeSearchCache.walkRouteResult.getPaths().get(0).getSteps()) {
//                        for (LatLonPoint latLonPoint : walkStep.getPolyline()) {
//                            latLngs.add(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
//                        }
//                    }
//                    latLngs.add(routeSearchCache.LatLngTo);// for those points cannot reach.
//                }
//                if (distance < mTargetLength + 100) {
////                    int size = setList.size();
////                    for (int i = 0; i < latLngList.size() - 2; i++) {
//                    int index = (int) Math.round(Math.random() * (mBypassList.size() - 0.51));
//                    while (mBypassList.get(index).latLng == routeSearchCacheList.get(routeSearchCacheList.size() - 1).LatLngTo
//                            || mBypassList.get(index).latLng == routeSearchCacheList.get(routeSearchCacheList.size() - 1).LatLngFrom) {
//                        index = (int) Math.round(Math.random() * (mBypassList.size() - 0.6));
//                    }
//                    RouteSearchCache routeSearchCache = new RouteSearchCache();
//                    routeSearchCache.LatLngFrom = routeSearchCacheList.get(routeSearchCacheList.size() - 1).LatLngTo;
//                    routeSearchCache.LatLngTo = mBypassList.get(index).latLng;
//                    routeSearchCache.fromAndTo =
//                            new RouteSearch.FromAndTo(new LatLonPoint(routeSearchCache.LatLngFrom.latitude, routeSearchCache.LatLngFrom.longitude)
//                                    , new LatLonPoint(routeSearchCache.LatLngTo.latitude, routeSearchCache.LatLngTo.longitude));
//                    routeSearchCache.walkRouteQuery = new RouteSearch.WalkRouteQuery(routeSearchCache.fromAndTo);
//                    routeSearchCacheList.add(routeSearchCache);
//                    mRouteSearch.calculateWalkRouteAsyn(routeSearchCacheList.get(routeSearchCacheList.size() - 1).walkRouteQuery);
//                    return;
//                }
//                onPlanCompleteListener.onComplete(latLngs);
////                routePlanSearch.destroy();
//
//            }
//
//            @Override
//            public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {
//
//            }
//        });
//        for (int i = 0; i < mBypassList.size(); i++) {
//            RouteSearchCache routeSearchCache = new RouteSearchCache();
//            routeSearchCache.LatLngFrom = (i == 0 ? mStart : mBypassList.get(i - 1).latLng);
//            routeSearchCache.LatLngTo = mBypassList.get(i).latLng;
//            routeSearchCache.fromAndTo =
//                    new RouteSearch.FromAndTo(new LatLonPoint(routeSearchCache.LatLngFrom.latitude, routeSearchCache.LatLngFrom.longitude)
//                            , new LatLonPoint(routeSearchCache.LatLngTo.latitude, routeSearchCache.LatLngTo.longitude));
//            routeSearchCache.walkRouteQuery = new RouteSearch.WalkRouteQuery(routeSearchCache.fromAndTo);
//            routeSearchCacheList.add(routeSearchCache);
//        }
//        mRouteSearch.calculateWalkRouteAsyn(routeSearchCacheList.get(0).walkRouteQuery);
//    }

    public static void plan(Context context, final LatLng start, final List<RoutePoint> bypass, final int length, final OnPlanCompleteListener onPlanCompleteListener) {
        if (context==null||start == null || bypass == null || onPlanCompleteListener == null || length < 0 || bypass.size() < 2) {
            if (onPlanCompleteListener != null) {
                onPlanCompleteListener.onError();
            }
            return;
        }
        final List<RouteSearchCache> routeSearchCacheList = new ArrayList<>();
        final RouteSearch routeSearch=new RouteSearch(context);
        routeSearch.setRouteSearchListener(new RouteSearch.OnRouteSearchListener() {
            @Override
            public void onBusRouteSearched(BusRouteResult busRouteResult, int i) {

            }

            @Override
            public void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i) {

            }

            @Override
            public void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i) {
                if (i == 1000) {
                    for (RouteSearchCache routeSearchCache : routeSearchCacheList) {
                        if (routeSearchCache.walkRouteResult == null) {
                            routeSearchCache.walkRouteResult = walkRouteResult;
                            RouteSearchCache nextRouteSearchCache =
                                    routeSearchCacheList.indexOf(routeSearchCache) + 1 < routeSearchCacheList.size()
                                            ? routeSearchCacheList.get(routeSearchCacheList.indexOf(routeSearchCache) + 1) : null;
                            if (nextRouteSearchCache != null) {
                                routeSearch.calculateWalkRouteAsyn(nextRouteSearchCache.walkRouteQuery);
                            }
                            break;
                        }
                    }
                } else if (i / 100 == 11 || i / 100 == 18) {
                    for (RouteSearchCache routeSearchCache : routeSearchCacheList) {
                        if (routeSearchCache.walkRouteResult == null) {
                            routeSearch.calculateWalkRouteAsyn(routeSearchCache.walkRouteQuery);
                            break;
                        }

                    }
                } else {
                    onPlanCompleteListener.onError();
                }
                List<LatLng> latLngs = new ArrayList<>();
                latLngs.add(start);
                int distance = 0;
                for (RouteSearchCache routeSearchCache : routeSearchCacheList) {
                    if (routeSearchCache.walkRouteResult == null) {
                        return;
                    }
                    distance += routeSearchCache.walkRouteResult.getPaths().get(0).getDistance();
                    for (WalkStep walkStep : routeSearchCache.walkRouteResult.getPaths().get(0).getSteps()) {
                        for (LatLonPoint latLonPoint : walkStep.getPolyline()) {
                            latLngs.add(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
                        }
                    }
//                    latLngs.add(routeSearchCache.LatLngTo);// for those points cannot reach.
                }
                if (distance < length + 100) {
                    int index = (int) Math.round(Math.random() * (bypass.size() - 0.51));
                    while (bypass.get(index).latLng == routeSearchCacheList.get(routeSearchCacheList.size() - 1).LatLngTo
                            || bypass.get(index).latLng == routeSearchCacheList.get(routeSearchCacheList.size() - 1).LatLngFrom) {
                        index = (int) Math.round(Math.random() * (bypass.size() - 0.6));
                    }
                    RouteSearchCache routeSearchCache = new RouteSearchCache();
                    routeSearchCache.LatLngFrom = routeSearchCacheList.get(routeSearchCacheList.size() - 1).LatLngTo;
                    routeSearchCache.LatLngTo = bypass.get(index).latLng;
                    routeSearchCache.fromAndTo =
                            new RouteSearch.FromAndTo(new LatLonPoint(routeSearchCache.LatLngFrom.latitude, routeSearchCache.LatLngFrom.longitude)
                                    , new LatLonPoint(routeSearchCache.LatLngTo.latitude, routeSearchCache.LatLngTo.longitude));
                    routeSearchCache.walkRouteQuery = new RouteSearch.WalkRouteQuery(routeSearchCache.fromAndTo);
                    routeSearchCacheList.add(routeSearchCache);
                    routeSearch.calculateWalkRouteAsyn(routeSearchCacheList.get(routeSearchCacheList.size() - 1).walkRouteQuery);
                    return;
                }
                onPlanCompleteListener.onComplete(latLngs);
            }

            @Override
            public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

            }
        });
        for (int i = 0; i < bypass.size(); i++) {
            RouteSearchCache routeSearchCache = new RouteSearchCache();
            routeSearchCache.LatLngFrom = (i == 0 ? start : bypass.get(i - 1).latLng);
            routeSearchCache.LatLngTo = bypass.get(i).latLng;
            routeSearchCache.fromAndTo =
                    new RouteSearch.FromAndTo(new LatLonPoint(routeSearchCache.LatLngFrom.latitude, routeSearchCache.LatLngFrom.longitude)
                            , new LatLonPoint(routeSearchCache.LatLngTo.latitude, routeSearchCache.LatLngTo.longitude));
            routeSearchCache.walkRouteQuery = new RouteSearch.WalkRouteQuery(routeSearchCache.fromAndTo);
            routeSearchCacheList.add(routeSearchCache);
        }
        routeSearch.calculateWalkRouteAsyn(routeSearchCacheList.get(0).walkRouteQuery);    }

    public interface OnPlanCompleteListener {
        void onComplete(List<LatLng> latLngs);

        void onError();
    }

    public static class RoutePoint {
        LatLng latLng;
        int order;
    }

    private static class RouteSearchCache {
        LatLng LatLngFrom;
        LatLng LatLngTo;
        RouteSearch.FromAndTo fromAndTo;
        RouteSearch.WalkRouteQuery walkRouteQuery;
        WalkRouteResult walkRouteResult;

        @Override
        public String toString() {
            return "RouteSearchCache{" +
                    "LatLngFrom=" + LatLngFrom +
                    ", LatLngTo=" + LatLngTo +
                    ", fromAndTo=" + fromAndTo +
                    ", walkRouteQuery=" + walkRouteQuery +
                    ", walkRouteResult=" + walkRouteResult +
                    '}';
        }
    }
}
