package com.zjwh.android_wh_physicalfitness.utils;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.zjwh.android_wh_physicalfitness.entity.HomePageInfo;
import com.zjwh.android_wh_physicalfitness.entity.RunRuleModel;
import com.zjwh.android_wh_physicalfitness.entity.SemesterInfoModel;
import com.zjwh.android_wh_physicalfitness.entity.database.HomePageInfoCache;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.xutils.DbManager;

/* compiled from: CacheDataUtils */
public class O0000o {
    public static String O000000o = "[{\"moduleId\":10004,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://rankList?index=0\",\"moduleName\":\"校园榜单\"},{\"moduleId\":20002,\"iconUrl\":\"\",\"jumpUrl\":\"https://gxapp-h5.oss-cn-shanghai.aliyuncs.com/gxapp/point/prod/integral.html\",\"moduleName\":\"积分中心\"},{\"moduleId\":10005,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://musicIndex\",\"moduleName\":\"音乐\"}]";
    public static String O00000Oo = "[{\"moduleId\":30001,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://runPrize\",\"moduleName\":\"我的奖励\"},{\"moduleId\":30002,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://runHistory\",\"moduleName\":\"跑步记录\"},{\"moduleId\":30003,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://rankHistory\",\"moduleName\":\"历史排名\"},{\"moduleId\":30010,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://sportCampus\",\"moduleName\":\"运动校园\"},{\"moduleId\":30004,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://smartAttendance\",\"moduleName\":\"考勤签到\"},{\"moduleId\":30005,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://score\",\"moduleName\":\"我的成绩\"},{\"moduleId\":30006,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://course\",\"moduleName\":\"我的课程\"},{\"moduleId\":30008,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://noticeList\",\"moduleName\":\"校园公告\"},{\"moduleId\":30009,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://rollCall\",\"moduleName\":\"课堂点名\"}]";
    public static String O00000o = "[{\"moduleId\":10001,\"text\":\"运动\",\"iconNormal\":\"\",\"iconSelected\":\"\",\"colorNormal\":\"b2b2b2\",\"colorSelected\":\"33c4c2\",\"order\":1},{\"moduleId\":10002,\"text\":\"发现\",\"iconNormal\":\"\",\"iconSelected\":\"\",\"colorNormal\":\"b2b2b2\",\"colorSelected\":\"33c4c2\",\"order\":2},{\"colorNormal\":\"b2b2b2\",\"colorSelected\":\"33c4c2\",\"iconNormal\":\"\",\"iconSelected\":\"\",\"moduleId\":10005,\"order\":3,\"text\":\"福利社\"},{\"moduleId\":10003,\"text\":\"动态\",\"iconNormal\":\"\",\"iconSelected\":\"\",\"colorNormal\":\"b2b2b2\",\"colorSelected\":\"33c4c2\",\"order\":4},{\"moduleId\":10004,\"text\":\"我的\",\"iconNormal\":\"\",\"iconSelected\":\"\",\"colorNormal\":\"b2b2b2\",\"colorSelected\":\"33c4c2\",\"order\":5}]";
    public static String O00000o0 = "[{\"moduleId\":30001,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://runPrize\",\"moduleName\":\"我的奖励\"},{\"moduleId\":30002,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://runHistory\",\"moduleName\":\"跑步记录\"},{\"moduleId\":30003,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://rankHistory\",\"moduleName\":\"历史排名\"},{\"moduleId\":30010,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://sportCampus\",\"moduleName\":\"运动校园\"},{\"moduleId\":30004,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://smartAttendance\",\"moduleName\":\"考勤签到\"},{\"moduleId\":30005,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://score\",\"moduleName\":\"我的成绩\"},{\"moduleId\":30007,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://student\",\"moduleName\":\"我的学生\"},{\"moduleId\":30008,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://noticeList\",\"moduleName\":\"校园公告\"},{\"moduleId\":30009,\"iconUrl\":\"\",\"jumpUrl\":\"zjwh://rollCall\",\"moduleName\":\"课堂点名\"}]";

    public static HomePageInfo O000000o() {
        DbManager O0000O0o = O00Oo0.O0000O0o();
        try {
            HomePageInfoCache homePageInfoCache = (HomePageInfoCache) O0000O0o.findById(HomePageInfoCache.class, Integer.valueOf(O00Oo0.O000000o(O0000O0o)));
            if (homePageInfoCache == null) {
                return null;
            }
            return (HomePageInfo) new Gson().fromJson(homePageInfoCache.getHomepageInfoJson(), HomePageInfo.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> O000000o(String str, String str2, Type type) {
        str = (String) O00O0Oo0.O00000o0(str2, str);
        return !TextUtils.isEmpty(str) ? (List) O000o000.O000000o().fromJson(str, type) : new ArrayList();
    }

    public static RunRuleModel O00000Oo() {
        HomePageInfo O000000o = O000000o();
        return O000000o != null ? O000000o.getRunRuleModel() : null;
    }

    public static SemesterInfoModel O00000o0() {
        HomePageInfo O000000o = O000000o();
        return O000000o != null ? O000000o.getSemesterInfoModel() : null;
    }
}
