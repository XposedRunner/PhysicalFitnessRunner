package com.zjwh.android_wh_physicalfitness_runner;

import android.content.Context;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;

import java.util.ArrayList;
import java.util.List;

public class RandomRoutePlanner {
//    private RouteSearch mRouteSearch;
//    private LatLng mStart;
//    private List<RoutePoint> mBypassList;
//    private int mTargetLength;
//
//    public RandomRoutePlanner(Context context) {
//        mRouteSearch = new RouteSearch(context);
////        mStart = start;
////        mBypassList = routePointList;
////        mTargetLength = length;
//    }
//
//    public static RandomRoutePlanner withContext(Context context) {
//        ZjwhRunner.log("RandomRoutePlanner.withContext 1");
//        return new RandomRoutePlanner(context);
//    }
//
//    public RandomRoutePlanner start(LatLng latLng) {
//        ZjwhRunner.log("RandomRoutePlanner.start 1");
//        mStart = latLng;
//        return this;
//    }
//
//    public RandomRoutePlanner bypass(List<RoutePoint> routePointList) {
//        ZjwhRunner.log("RandomRoutePlanner.bypass 1");
//        mBypassList = new ArrayList<>(routePointList);
//        return this;
//    }
//
//    public RandomRoutePlanner target(int length) {
//        ZjwhRunner.log("RandomRoutePlanner.target 1");
//        mTargetLength = length;
//        return this;
//    }
//
//    public void plan(final OnPlanCompleteListener onPlanCompleteListener) {
//        ZjwhRunner.log("RandomRoutePlanner.plan 1");
//        if (mStart == null || mBypassList == null || onPlanCompleteListener == null || mTargetLength < 0 || mBypassList.size() < 2) {
//            if (onPlanCompleteListener != null) {
//                onPlanCompleteListener.onError();
//            }
//            return;
//        }
//        ZjwhRunner.log("RandomRoutePlanner.plan 2");
//        final List<RouteSearchCache> routeSearchCacheList = new ArrayList<>();
//        final List<RouteSearchCache> finalRouteSearchCacheList = new ArrayList<>();
//        mRouteSearch.setRouteSearchListener(new RouteSearch.OnRouteSearchListener() {
//            private int mustCount = 0, justCount = 0;
//
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
//                ZjwhRunner.log("RandomRoutePlanner.plan 3");
//                if (i == 1000) {
//                    ZjwhRunner.log("RandomRoutePlanner.plan 3-1");
//                    for (RouteSearchCache routeSearchCache : routeSearchCacheList) {
//
//                        if (routeSearchCache.walkRouteResult == null) {
//                            ZjwhRunner.log("RandomRoutePlanner.plan 3-1-1");
//                            routeSearchCache.walkRouteResult = walkRouteResult;
//                            RouteSearchCache nextRouteSearchCache =
//                                    routeSearchCacheList.indexOf(routeSearchCache) + 1 < routeSearchCacheList.size()
//                                            ? routeSearchCacheList.get(routeSearchCacheList.indexOf(routeSearchCache) + 1) : null;
//                            if (nextRouteSearchCache != null) {
//                                ZjwhRunner.log("RandomRoutePlanner.plan 3-1-2");
//                                mRouteSearch.calculateWalkRouteAsyn(nextRouteSearchCache.walkRouteQuery);
//                            } else {
//                                if (mustCount < 1 || justCount < 2) {
//                                    int index = 0;
//                                    int minDistance = Integer.MAX_VALUE;
//                                    for (RouteSearchCache searchCache : routeSearchCacheList) {
//                                        float distance = searchCache.walkRouteResult.getPaths().get(0).getDistance();
//                                        if (distance < minDistance) {
//                                            if (justCount < 2 && !(mustCount < 1)) {
//                                                if (searchCache.routePointTo.required) {
//                                                    continue;
//                                                }
//                                            }
//                                            if (!(justCount < 2) && mustCount < 1) {
//                                                if (!searchCache.routePointTo.required) {
//                                                    continue;
//                                                }
//                                            }
//                                            minDistance = (int) distance;
//                                            index = routeSearchCacheList.indexOf(searchCache);
//                                        }
//                                    }
//                                    RouteSearchCache searchCache = routeSearchCacheList.get(index);
//                                    if (searchCache.routePointTo.required) {
//                                        mustCount++;
//                                    } else {
//                                        justCount++;
//                                    }
//                                    finalRouteSearchCacheList.add(searchCache);
//                                } else {
//                                    int index = 0;
//                                    int maxDistance = Integer.MIN_VALUE;
//                                    for (RouteSearchCache searchCache : routeSearchCacheList) {
//                                        float distance = searchCache.walkRouteResult.getPaths().get(0).getDistance();
//                                        if (distance > maxDistance) {
//                                            maxDistance = (int) distance;
//                                            index = routeSearchCacheList.indexOf(searchCache);
//                                        }
//                                    }
//                                    finalRouteSearchCacheList.add(routeSearchCacheList.get(index));
//                                }
////                                calcSetList.addAll(setList);
//                                routeSearchCacheList.clear();
//                            }
//                            break;
//                        }
//                    }
//                } else if (i / 100 == 11 || i / 100 == 18) {
//                    ZjwhRunner.log("RandomRoutePlanner.plan 3-2");
//                    for (RouteSearchCache routeSearchCache : routeSearchCacheList) {
//                        if (routeSearchCache.walkRouteResult == null) {
//                            mRouteSearch.calculateWalkRouteAsyn(routeSearchCache.walkRouteQuery);
//                            break;
//                        }
//                    }
//                } else {
//                    ZjwhRunner.log("RandomRoutePlanner.plan 3-3");
//                    onPlanCompleteListener.onError();
//                }
//                List<LatLng> latLngs = new ArrayList<>();
////                latLngs.add(start);
//                int distance = 0;
//                for (RouteSearchCache searchCache : finalRouteSearchCacheList) {
//                    distance += searchCache.walkRouteResult.getPaths().get(0).getDistance();
//                    for (WalkStep walkStep : searchCache.walkRouteResult.getPaths().get(0).getSteps()) {
//                        for (LatLonPoint latLonPoint : walkStep.getPolyline()) {
//                            latLngs.add(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
//                        }
//                    }
////                    latLngs.add(searchCache.routePointTo.latLng);// for those points cannot reach.
//                }
//                if (distance < mTargetLength + 100 || mustCount < 1 || justCount < 2) {
//                    for (RoutePoint routePoint : mBypassList) {
//                        if (routePoint.latLng.equals(finalRouteSearchCacheList.get(finalRouteSearchCacheList.size() - 1).routePointTo.latLng)
//                                || routePoint.latLng.equals(finalRouteSearchCacheList.get(finalRouteSearchCacheList.size() - 1).routePointFrom.latLng)) {
//                            continue;
//                        }
//                        RouteSearchCache routeSearchCache = new RouteSearchCache();
//                        routeSearchCache.routePointFrom = finalRouteSearchCacheList.get(finalRouteSearchCacheList.size() - 1).routePointTo;
//                        routeSearchCache.routePointTo = routePoint;
//                        routeSearchCache.fromAndTo =
//                                new RouteSearch.FromAndTo(new LatLonPoint(routeSearchCache.routePointFrom.latLng.latitude, routeSearchCache.routePointFrom.latLng.longitude)
//                                        , new LatLonPoint(routeSearchCache.routePointTo.latLng.latitude, routeSearchCache.routePointTo.latLng.longitude));
//                        routeSearchCache.walkRouteQuery = new RouteSearch.WalkRouteQuery(routeSearchCache.fromAndTo);
//                        routeSearchCacheList.add(routeSearchCache);
//                    }
//                    mRouteSearch.calculateWalkRouteAsyn(routeSearchCacheList.get(0).walkRouteQuery);
//                    return;
//                }
//                onPlanCompleteListener.onComplete(latLngs);
//            }
//
//            @Override
//            public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {
//
//            }
//        });
//        ZjwhRunner.log("RandomRoutePlanner.plan 4");
//        for (RoutePoint routePoint : mBypassList) {
//            RouteSearchCache routeSearchCache = new RouteSearchCache();
//            RoutePoint routePointStart = new RoutePoint();
//            routePointStart.latLng = mStart;
//            routeSearchCache.routePointFrom = routePointStart;
//            routeSearchCache.routePointTo = routePoint;
//            routeSearchCache.fromAndTo =
//                    new RouteSearch.FromAndTo(new LatLonPoint(routeSearchCache.routePointFrom.latLng.latitude, routeSearchCache.routePointFrom.latLng.longitude)
//                            , new LatLonPoint(routeSearchCache.routePointTo.latLng.latitude, routeSearchCache.routePointTo.latLng.longitude));
//            routeSearchCache.walkRouteQuery = new RouteSearch.WalkRouteQuery(routeSearchCache.fromAndTo);
//            routeSearchCacheList.add(routeSearchCache);
//            ZjwhRunner.log("RandomRoutePlanner.plan 5");
//        }
//        mRouteSearch.calculateWalkRouteAsyn(routeSearchCacheList.get(0).walkRouteQuery);
//    }

    public static void plan(Context context, LatLng start, final List<RoutePoint> bypass, final int length, final OnPlanCompleteListener onPlanCompleteListener) {
        if (start == null || bypass == null || onPlanCompleteListener == null || length < 0 || bypass.size() < 2) {
            if (onPlanCompleteListener != null) {
                onPlanCompleteListener.onError();
            }
            return;
        }
        final List<RouteSearchCache> routeSearchCacheList = new ArrayList<>();
        final List<RouteSearchCache> finalRouteSearchCacheList = new ArrayList<>();
        final RouteSearch routeSearch=new RouteSearch(context);
        routeSearch.setRouteSearchListener(new RouteSearch.OnRouteSearchListener() {
            private int mustCount = 0, justCount = 0;

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
                            } else {
                                if (mustCount < 1 || justCount < 2) {
                                    int index = 0;
                                    int minDistance = Integer.MAX_VALUE;
                                    for (RouteSearchCache searchCache : routeSearchCacheList) {
                                        float distance = searchCache.walkRouteResult.getPaths().get(0).getDistance();
                                        if (distance < minDistance) {
                                            if (justCount < 2 && !(mustCount < 1)) {
                                                if (searchCache.routePointTo.required) {
                                                    continue;
                                                }
                                            }
                                            if (!(justCount < 2) && mustCount < 1) {
                                                if (!searchCache.routePointTo.required) {
                                                    continue;
                                                }
                                            }
                                            minDistance = (int) distance;
                                            index = routeSearchCacheList.indexOf(searchCache);
                                        }
                                    }
                                    RouteSearchCache searchCache = routeSearchCacheList.get(index);
                                    if (searchCache.routePointTo.required) {
                                        mustCount++;
                                    } else {
                                        justCount++;
                                    }
                                    finalRouteSearchCacheList.add(searchCache);
                                } else {
                                    int index = 0;
                                    int maxDistance = Integer.MIN_VALUE;
                                    for (RouteSearchCache searchCache : routeSearchCacheList) {
                                        float distance = searchCache.walkRouteResult.getPaths().get(0).getDistance();
                                        if (distance > maxDistance) {
                                            maxDistance = (int) distance;
                                            index = routeSearchCacheList.indexOf(searchCache);
                                        }
                                    }
                                    finalRouteSearchCacheList.add(routeSearchCacheList.get(index));
                                }
//                                calcSetList.addAll(setList);
                                routeSearchCacheList.clear();
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
                int distance = 0;
                for (RouteSearchCache searchCache : finalRouteSearchCacheList) {
                    distance += searchCache.walkRouteResult.getPaths().get(0).getDistance();
                    for (WalkStep walkStep : searchCache.walkRouteResult.getPaths().get(0).getSteps()) {
                        for (LatLonPoint latLonPoint : walkStep.getPolyline()) {
                            latLngs.add(new LatLng(latLonPoint.getLatitude(), latLonPoint.getLongitude()));
                        }
                    }
//                    latLngs.add(searchCache.routePointTo.latLng);// for those points cannot reach.
                }
                if (distance < length + 100 || mustCount < 1 || justCount < 2) {
                    for (RoutePoint routePoint : bypass) {
                        if (routePoint.latLng.equals(finalRouteSearchCacheList.get(finalRouteSearchCacheList.size() - 1).routePointTo.latLng)
                                || routePoint.latLng.equals(finalRouteSearchCacheList.get(finalRouteSearchCacheList.size() - 1).routePointFrom.latLng)) {
                            continue;
                        }
                        RouteSearchCache routeSearchCache = new RouteSearchCache();
                        routeSearchCache.routePointFrom = finalRouteSearchCacheList.get(finalRouteSearchCacheList.size() - 1).routePointTo;
                        routeSearchCache.routePointTo = routePoint;
                        routeSearchCache.fromAndTo =
                                new RouteSearch.FromAndTo(new LatLonPoint(routeSearchCache.routePointFrom.latLng.latitude, routeSearchCache.routePointFrom.latLng.longitude)
                                        , new LatLonPoint(routeSearchCache.routePointTo.latLng.latitude, routeSearchCache.routePointTo.latLng.longitude));
                        routeSearchCache.walkRouteQuery = new RouteSearch.WalkRouteQuery(routeSearchCache.fromAndTo);
                        routeSearchCacheList.add(routeSearchCache);
                    }
                    routeSearch.calculateWalkRouteAsyn(routeSearchCacheList.get(0).walkRouteQuery);
                    return;
                }
                onPlanCompleteListener.onComplete(latLngs);
            }

            @Override
            public void onRideRouteSearched(RideRouteResult rideRouteResult, int i) {

            }
        });
        for (RoutePoint routePoint : bypass) {
            RouteSearchCache routeSearchCache = new RouteSearchCache();
            RoutePoint routePointStart = new RoutePoint();
            routePointStart.latLng = start;
            routeSearchCache.routePointFrom = routePointStart;
            routeSearchCache.routePointTo = routePoint;
            routeSearchCache.fromAndTo =
                    new RouteSearch.FromAndTo(new LatLonPoint(routeSearchCache.routePointFrom.latLng.latitude, routeSearchCache.routePointFrom.latLng.longitude)
                            , new LatLonPoint(routeSearchCache.routePointTo.latLng.latitude, routeSearchCache.routePointTo.latLng.longitude));
            routeSearchCache.walkRouteQuery = new RouteSearch.WalkRouteQuery(routeSearchCache.fromAndTo);
            routeSearchCacheList.add(routeSearchCache);
        }
        routeSearch.calculateWalkRouteAsyn(routeSearchCacheList.get(0).walkRouteQuery);
    }


    public interface OnPlanCompleteListener {
        void onComplete(List<LatLng> latLngs);

        void onError();
    }

    public static class RoutePoint {
        public RoutePoint() {
        }

        LatLng latLng;
        boolean required;

        @Override
        public String toString() {
            return "RoutePoint{" +
                    "latLng=" + latLng +
                    ", required=" + required +
                    '}';
        }
    }

    private static class RouteSearchCache {
        RoutePoint routePointFrom;
        RoutePoint routePointTo;
        RouteSearch.FromAndTo fromAndTo;
        RouteSearch.WalkRouteQuery walkRouteQuery;
        WalkRouteResult walkRouteResult;
    }
}
