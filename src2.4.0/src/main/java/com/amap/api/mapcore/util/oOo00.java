package com.amap.api.mapcore.util;

import android.text.TextUtils;

/* compiled from: StyleItemAdaptor */
public class oOo00 {
    public static final int[][] O000000o;
    public static final String[] O00000Oo = new String[]{"land", "water", "green", "building", "highway", "arterial", "local", "railway", "subway", "boundary", "poilabel", "districtlable"};
    public static final String[] O00000o = new String[]{"regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels"};
    public static final String[][] O00000o0;

    static {
        r1 = new int[12][];
        r1[1] = new int[]{12};
        r1[2] = new int[]{1};
        r1[3] = new int[]{13};
        r1[4] = new int[]{14};
        r1[5] = new int[]{15, 16};
        r1[6] = new int[]{17, 18, 19, 20, 21, 26, 27, 28};
        r1[7] = new int[]{22, 23};
        r1[8] = new int[]{24, 25};
        r1[9] = new int[]{39, 40, 41};
        r1[10] = new int[]{29, 30, 31};
        r1[11] = new int[]{32, 33, 34, 35, 36, 37, 38};
        O000000o = r1;
        r1 = new String[12][];
        r1[0] = new String[]{"land", "edu", "public", "traffic", "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway"};
        r1[1] = new String[]{"water"};
        r1[2] = new String[]{"green"};
        r1[3] = new String[]{"buildings"};
        r1[4] = new String[]{"highWay"};
        r1[5] = new String[]{"ringRoad", "nationalRoad"};
        r1[6] = new String[]{"provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", "other"};
        r1[7] = new String[]{"railway", "highSpeedRailway"};
        r1[8] = new String[]{"subwayline", "subwayBeingBuilt"};
        r1[9] = new String[]{"China", "foreign", "provincial"};
        r1[10] = new String[]{"guideBoards", "pois", "aois"};
        r1[11] = new String[]{"continent", "country", "province", "city", "district", "town", "village"};
        O00000o0 = r1;
    }

    public static String[] O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = -1;
        for (int i2 = 0; i2 < O00000Oo.length; i2++) {
            if (O00000Oo[i2].equals(str)) {
                i = i2;
                break;
            }
        }
        return i >= 0 ? O00000o0[i] : null;
    }

    public static String O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i = -1;
        for (int i2 = 0; i2 < O00000Oo.length; i2++) {
            if (O00000Oo[i2].equals(str)) {
                i = i2;
                break;
            }
        }
        return i >= 0 ? O00000o[i] : null;
    }
}
