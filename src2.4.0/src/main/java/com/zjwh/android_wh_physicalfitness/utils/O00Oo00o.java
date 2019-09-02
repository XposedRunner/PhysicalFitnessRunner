package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UMengHelper */
public class O00Oo00o {

    /* compiled from: UMengHelper */
    public interface O000000o {
        public static final String O000000o = "shanp";
        public static final String O00000Oo = "tank";
        public static final String O00000o = "myreward";
        public static final String O00000o0 = "dwreward";
        public static final String O00000oO = "rewardbutton";
        public static final String O00000oo = "topbanner";
        public static final String O0000O0o = "ex_topic";
        public static final String O0000OOo = "ex_article";
        public static final String O0000Oo = "run_record";
        public static final String O0000Oo0 = "ex_activity";
        public static final String O0000OoO = "integral_record";
        public static final String O0000Ooo = "dtrecord";
        public static final String O0000o0 = "sport_music";
        public static final String O0000o00 = "sport_mood";
    }

    /* compiled from: UMengHelper */
    public interface O00000Oo {
        public static final String O000000o = "clickplace";
    }

    /* compiled from: UMengHelper */
    public interface O00000o0 {
        public static final String O000000o = "exposure";
        public static final String O00000Oo = "click";
        public static final String O00000o = "rbutton";
        public static final String O00000o0 = "close";
        public static final String O00000oO = "reselection";
        public static final String O00000oo = "share";
    }

    private static Map<String, String> O000000o(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        return hashMap;
    }

    public static void O000000o(Context context, String str, String str2) {
        x.O000000o(context, str, O000000o(O00000Oo.O000000o, str2));
    }
}
