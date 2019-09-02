package com.zjwh.android_wh_physicalfitness.utils;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import com.google.gson.Gson;
import com.zjwh.android_wh_physicalfitness.activity.ArticleDetailActivity;
import com.zjwh.android_wh_physicalfitness.activity.WebViewActivity;
import com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity;
import com.zjwh.android_wh_physicalfitness.activity.find.TopicDetailActivity;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.entity.MessageBodyBean;
import com.zjwh.android_wh_physicalfitness.entity.database.UserInfo;
import com.zjwh.android_wh_physicalfitness.ui.message.CommentActivity;
import com.zjwh.android_wh_physicalfitness.ui.message.FansActivity;
import com.zjwh.android_wh_physicalfitness.ui.message.LikeActivity;
import com.zjwh.android_wh_physicalfitness.ui.message.MessageActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* compiled from: JPushCmdUtils */
public class O000o0 {
    public static final int O000000o = 1;
    public static final int O00000Oo = 2;
    private static final int O00000o = 3;
    public static final int O00000o0 = 6;
    private static final int O00000oO = 4;
    private static final int O00000oo = 5;
    private static final int O0000O0o = 7;
    private static final int O0000OOo = 8;
    private static final String O0000Oo = "zjwh://";
    private static final String O0000Oo0 = "O000o0";
    private static final String O0000OoO = "topicDetail";
    private static final String O0000Ooo = "articleDetail";
    private static final String O0000o = "activityList";
    private static final String O0000o0 = "run";
    private static final String O0000o00 = "dynamicDetail";
    private static final String O0000o0O = "topicList";
    private static final String O0000o0o = "articleList";
    private static final String O0000oO = "rankList";
    private static final String O0000oO0 = "announcementDetail";
    private static final String O0000oOO = "index";
    private static final String O0000oOo = "personalData";
    private static final String O0000oo = "sportDynamic";
    private static final String O0000oo0 = "hotDynamic";
    private static final String O0000ooO = "runPrize";
    private static final String O0000ooo = "runHistory";
    private static final String O000O00o = "score";
    private static final String O000O0OO = "course";
    private static final String O000O0Oo = "student";
    private static final String O000O0o = "weChatProgram";
    private static final String O000O0o0 = "rollCall";
    private static final String O000O0oO = "musicIndex";
    private static final String O000O0oo = "musicAlbumDetail";
    private static final String O000OO00 = "sportCampus";
    private static final String O000OO0o = "welfareClub";
    private static final String O00oOoOo = "noticeList";
    private static final String O00oOooO = "rankHistory";
    private static final String O00oOooo = "smartAttendance";

    private static Map<String, String> O000000o(Uri uri) {
        if (uri == null) {
            return null;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (TextUtils.isEmpty(encodedQuery)) {
            return null;
        }
        String[] split = encodedQuery.split("&");
        HashMap hashMap = new HashMap();
        for (String str : split) {
            int indexOf = str.indexOf("=");
            if (indexOf != -1) {
                hashMap.put(str.substring(0, indexOf), str.substring(indexOf + 1));
            } else {
                hashMap.put(str, null);
            }
        }
        return hashMap;
    }

    public static void O000000o() {
        UserInfo O00000o0 = O00Oo0.O00000o0();
        if (O00000o0 != null) {
            JPushInterface.setAlias(MyApplication.O000000o(), O00000o0.getAlias(), new TagAliasCallback() {
                public void gotResult(int i, String str, Set<String> set) {
                }
            });
            if (!TextUtils.isEmpty(O00000o0.getUserTag())) {
                HashSet hashSet = new HashSet();
                Collections.addAll(hashSet, O00000o0.getUserTag().split(","));
                JPushInterface.setTags(MyApplication.O000000o(), JPushInterface.filterValidTags(hashSet), new TagAliasCallback() {
                    public void gotResult(int i, String str, Set<String> set) {
                    }
                });
            }
        }
    }

    /* JADX WARNING: Missing block: B:99:0x0178, code skipped:
            r12 = -1;
     */
    /* JADX WARNING: Missing block: B:101:0x017b, code skipped:
            switch(r12) {
                case 0: goto L_0x0342;
                case 1: goto L_0x033e;
                case 2: goto L_0x033a;
                case 3: goto L_0x0329;
                case 4: goto L_0x0325;
                case 5: goto L_0x030d;
                case 6: goto L_0x02f5;
                case 7: goto L_0x02f0;
                case 8: goto L_0x02eb;
                case 9: goto L_0x02e6;
                case 10: goto L_0x02e1;
                case 11: goto L_0x02da;
                case 12: goto L_0x02d5;
                case 13: goto L_0x02d0;
                case 14: goto L_0x02cb;
                case 15: goto L_0x02c6;
                case 16: goto L_0x02c1;
                case 17: goto L_0x02bc;
                case 18: goto L_0x02a0;
                case 19: goto L_0x0284;
                case 20: goto L_0x0268;
                case 21: goto L_0x024c;
                case 22: goto L_0x022e;
                case 23: goto L_0x01ea;
                case 24: goto L_0x019f;
                case 25: goto L_0x0182;
                default: goto L_0x017e;
            };
     */
    /* JADX WARNING: Missing block: B:103:0x0182, code skipped:
            com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o("extra_module_id", java.lang.Integer.valueOf(com.zjwh.android_wh_physicalfitness.entity.MainBottomItemBean.MAIN_BOTTOM_COMMERCE));
     */
    /* JADX WARNING: Missing block: B:104:0x018f, code skipped:
            if ((r11 instanceof com.zjwh.android_wh_physicalfitness.activity.MainActivity) == false) goto L_0x0198;
     */
    /* JADX WARNING: Missing block: B:105:0x0191, code skipped:
            ((com.zjwh.android_wh_physicalfitness.activity.MainActivity) r11).O00000oO();
     */
    /* JADX WARNING: Missing block: B:106:0x0198, code skipped:
            com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O000000o(com.zjwh.android_wh_physicalfitness.activity.MainActivity.class);
     */
    /* JADX WARNING: Missing block: B:107:0x019f, code skipped:
            r12 = (java.lang.String) r1.get("id");
            r7 = (java.lang.String) r1.get("nickName");
            r2 = (java.lang.String) r1.get(com.ximalaya.ting.android.opensdk.constants.DTransferConstants.PAGE_SIZE);
     */
    /* JADX WARNING: Missing block: B:108:0x01c8, code skipped:
            if (java.lang.Integer.valueOf((java.lang.String) r1.get("isPaid")).intValue() != 1) goto L_0x01cc;
     */
    /* JADX WARNING: Missing block: B:109:0x01ca, code skipped:
            r8 = true;
     */
    /* JADX WARNING: Missing block: B:110:0x01cc, code skipped:
            r8 = false;
     */
    /* JADX WARNING: Missing block: B:112:0x01d1, code skipped:
            if (android.text.TextUtils.isEmpty(r12) == false) goto L_0x01d4;
     */
    /* JADX WARNING: Missing block: B:113:0x01d3, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:114:0x01d4, code skipped:
            com.zjwh.android_wh_physicalfitness.ui.music.AlbumDetailActivity.O000000o(r11, java.lang.Long.valueOf(r12).longValue(), r7, r8, java.lang.Long.valueOf(r2).longValue());
     */
    /* JADX WARNING: Missing block: B:115:0x01ea, code skipped:
            r11 = com.tencent.mm.opensdk.openapi.WXAPIFactory.createWXAPI(r11, r11.getString(com.zjwh.android_wh_physicalfitness.R.string.wechat_app_id));
     */
    /* JADX WARNING: Missing block: B:116:0x01f9, code skipped:
            if (r11.isWXAppInstalled() != false) goto L_0x0202;
     */
    /* JADX WARNING: Missing block: B:117:0x01fb, code skipped:
            com.zjwh.android_wh_physicalfitness.utils.O00Oo00.O000000o((int) com.zjwh.android_wh_physicalfitness.R.string.umeng_socialize_text_wechat_no_install);
     */
    /* JADX WARNING: Missing block: B:118:0x0201, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:119:0x0202, code skipped:
            r12 = (java.lang.String) r1.get("id");
            r1 = (java.lang.String) r1.get("path");
     */
    /* JADX WARNING: Missing block: B:120:0x0216, code skipped:
            if (android.text.TextUtils.isEmpty(r12) != false) goto L_0x0361;
     */
    /* JADX WARNING: Missing block: B:121:0x0218, code skipped:
            r2 = new com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req();
            r2.userName = r12;
     */
    /* JADX WARNING: Missing block: B:122:0x0223, code skipped:
            if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x0227;
     */
    /* JADX WARNING: Missing block: B:123:0x0225, code skipped:
            r2.path = r1;
     */
    /* JADX WARNING: Missing block: B:124:0x0227, code skipped:
            r2.miniprogramType = 0;
            r11.sendReq(r2);
     */
    /* JADX WARNING: Missing block: B:125:0x022e, code skipped:
            r12 = (java.lang.String) r1.get(O0000oOO);
     */
    /* JADX WARNING: Missing block: B:126:0x023a, code skipped:
            if (android.text.TextUtils.isEmpty(r12) == false) goto L_0x023d;
     */
    /* JADX WARNING: Missing block: B:127:0x023c, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:128:0x023d, code skipped:
            com.zjwh.android_wh_physicalfitness.ui.rank.RankingListActivity.O000000o(r11, "", java.lang.Integer.valueOf(r12).intValue());
     */
    /* JADX WARNING: Missing block: B:129:0x024c, code skipped:
            r12 = (java.lang.String) r1.get("id");
     */
    /* JADX WARNING: Missing block: B:130:0x0258, code skipped:
            if (android.text.TextUtils.isEmpty(r12) == false) goto L_0x025b;
     */
    /* JADX WARNING: Missing block: B:131:0x025a, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:132:0x025b, code skipped:
            com.zjwh.android_wh_physicalfitness.ui.notice.NoticeDetailActivity.O000000o(r11, java.lang.Integer.valueOf(r12).intValue());
     */
    /* JADX WARNING: Missing block: B:133:0x0268, code skipped:
            r12 = (java.lang.String) r1.get("id");
     */
    /* JADX WARNING: Missing block: B:134:0x0274, code skipped:
            if (android.text.TextUtils.isEmpty(r12) == false) goto L_0x0277;
     */
    /* JADX WARNING: Missing block: B:135:0x0276, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:136:0x0277, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity.O000000o(r11, java.lang.Integer.valueOf(r12).intValue(), false);
     */
    /* JADX WARNING: Missing block: B:137:0x0284, code skipped:
            r12 = (java.lang.String) r1.get("id");
     */
    /* JADX WARNING: Missing block: B:138:0x0290, code skipped:
            if (android.text.TextUtils.isEmpty(r12) == false) goto L_0x0293;
     */
    /* JADX WARNING: Missing block: B:139:0x0292, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:140:0x0293, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.ArticleDetailActivity.O000000o(r11, java.lang.Integer.valueOf(r12).intValue());
     */
    /* JADX WARNING: Missing block: B:141:0x02a0, code skipped:
            r12 = (java.lang.String) r1.get("id");
     */
    /* JADX WARNING: Missing block: B:142:0x02ac, code skipped:
            if (android.text.TextUtils.isEmpty(r12) == false) goto L_0x02af;
     */
    /* JADX WARNING: Missing block: B:143:0x02ae, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:144:0x02af, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.find.TopicDetailActivity.O000000o(r11, java.lang.Integer.valueOf(r12).intValue());
     */
    /* JADX WARNING: Missing block: B:145:0x02bc, code skipped:
            com.zjwh.android_wh_physicalfitness.ui.mine.SportCampusActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:146:0x02c1, code skipped:
            com.zjwh.android_wh_physicalfitness.ui.music.MusicMainActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:147:0x02c6, code skipped:
            com.zjwh.android_wh_physicalfitness.ui.mine.RollCallActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:148:0x02cb, code skipped:
            com.zjwh.android_wh_physicalfitness.ui.notice.NoticeListActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:149:0x02d0, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.mine.MyStudentActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:150:0x02d5, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.mine.MyCourseActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:151:0x02da, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.WebViewActivity.O000000o(r11, com.zjwh.android_wh_physicalfitness.O000000o.O0000OoO);
     */
    /* JADX WARNING: Missing block: B:152:0x02e1, code skipped:
            com.zjwh.android_wh_physicalfitness.ui.mine.AttendanceActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:153:0x02e6, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.mine.HistoryRankActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:154:0x02eb, code skipped:
            com.zjwh.android_wh_physicalfitness.ui.mine.RunHistoryActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:155:0x02f0, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.PrizeListActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:156:0x02f5, code skipped:
            com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o("extra_module_id", java.lang.Integer.valueOf(10003));
            com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o(com.zjwh.android_wh_physicalfitness.ui.dynamic.DynamicMainFragment.O000000o, java.lang.Integer.valueOf(2));
            com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O000000o(com.zjwh.android_wh_physicalfitness.activity.MainActivity.class);
     */
    /* JADX WARNING: Missing block: B:157:0x030d, code skipped:
            com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o("extra_module_id", java.lang.Integer.valueOf(10003));
            com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o(com.zjwh.android_wh_physicalfitness.ui.dynamic.DynamicMainFragment.O000000o, java.lang.Integer.valueOf(0));
            com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O000000o(com.zjwh.android_wh_physicalfitness.activity.MainActivity.class);
     */
    /* JADX WARNING: Missing block: B:158:0x0325, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.mine.PersonalInfoActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:159:0x0329, code skipped:
            com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o("extra_module_id", java.lang.Integer.valueOf(10001));
            com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O000000o(com.zjwh.android_wh_physicalfitness.activity.MainActivity.class);
     */
    /* JADX WARNING: Missing block: B:160:0x033a, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.find.ActivitiesActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:161:0x033e, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.find.ArticleActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:162:0x0342, code skipped:
            com.zjwh.android_wh_physicalfitness.activity.find.TopicActivity.O000000o(r11);
     */
    /* JADX WARNING: Missing block: B:163:0x0346, code skipped:
            com.zjwh.android_wh_physicalfitness.utils.O00Oo00.O00000Oo("暂不支持该跳转！");
     */
    /* JADX WARNING: Missing block: B:164:0x0349, code skipped:
            return false;
     */
    public static boolean O000000o(android.app.Activity r11, java.lang.String r12) {
        /*
        r0 = 0;
        r1 = android.net.Uri.parse(r12);	 Catch:{ Exception -> 0x0364 }
        if (r1 == 0) goto L_0x0363;
    L_0x0007:
        r2 = r1.isHierarchical();	 Catch:{ Exception -> 0x0364 }
        if (r2 == 0) goto L_0x0363;
    L_0x000d:
        r2 = r1.isAbsolute();	 Catch:{ Exception -> 0x0364 }
        if (r2 != 0) goto L_0x0015;
    L_0x0013:
        goto L_0x0363;
    L_0x0015:
        r2 = "zjwh://";
        r2 = r12.startsWith(r2);	 Catch:{ Exception -> 0x0364 }
        r3 = 1;
        if (r2 == 0) goto L_0x034a;
    L_0x001e:
        r2 = "?";
        r2 = r12.indexOf(r2);	 Catch:{ Exception -> 0x0364 }
        if (r2 <= 0) goto L_0x0031;
    L_0x0026:
        r4 = "zjwh://";
        r4 = r4.length();	 Catch:{ Exception -> 0x0364 }
        r12 = r12.substring(r4, r2);	 Catch:{ Exception -> 0x0364 }
        goto L_0x003b;
    L_0x0031:
        r2 = "zjwh://";
        r2 = r2.length();	 Catch:{ Exception -> 0x0364 }
        r12 = r12.substring(r2);	 Catch:{ Exception -> 0x0364 }
    L_0x003b:
        r2 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Exception -> 0x0364 }
        if (r2 == 0) goto L_0x0042;
    L_0x0041:
        return r0;
    L_0x0042:
        r1 = O000000o(r1);	 Catch:{ Exception -> 0x0364 }
        r2 = -1;
        r4 = r12.hashCode();	 Catch:{ Exception -> 0x0364 }
        r5 = 2;
        switch(r4) {
            case -1879145925: goto L_0x016d;
            case -1733728568: goto L_0x0162;
            case -1368581026: goto L_0x0157;
            case -1354571749: goto L_0x014c;
            case -1269526634: goto L_0x0141;
            case -1253347950: goto L_0x0136;
            case -1090414221: goto L_0x012b;
            case -919281783: goto L_0x0120;
            case -878906784: goto L_0x0115;
            case -800499283: goto L_0x0109;
            case -260642693: goto L_0x00fd;
            case -259167734: goto L_0x00f2;
            case -124010265: goto L_0x00e6;
            case 60094832: goto L_0x00da;
            case 100346066: goto L_0x00cf;
            case 109264530: goto L_0x00c3;
            case 215220344: goto L_0x00b7;
            case 255818474: goto L_0x00ab;
            case 388153965: goto L_0x00a0;
            case 802220103: goto L_0x0095;
            case 817989300: goto L_0x008a;
            case 1532213090: goto L_0x007e;
            case 1628567629: goto L_0x0073;
            case 2037683259: goto L_0x0067;
            case 2070438706: goto L_0x005c;
            case 2131969579: goto L_0x0051;
            default: goto L_0x004f;
        };	 Catch:{ Exception -> 0x0364 }
    L_0x004f:
        goto L_0x0178;
    L_0x0051:
        r4 = "sportDynamic";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0059:
        r12 = 6;
        goto L_0x0179;
    L_0x005c:
        r4 = "hotDynamic";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0064:
        r12 = 5;
        goto L_0x0179;
    L_0x0067:
        r4 = "musicAlbumDetail";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x006f:
        r12 = 24;
        goto L_0x0179;
    L_0x0073:
        r4 = "activityList";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x007b:
        r12 = r5;
        goto L_0x0179;
    L_0x007e:
        r4 = "welfareClub";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0086:
        r12 = 25;
        goto L_0x0179;
    L_0x008a:
        r4 = "articleList";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0092:
        r12 = r3;
        goto L_0x0179;
    L_0x0095:
        r4 = "runPrize";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x009d:
        r12 = 7;
        goto L_0x0179;
    L_0x00a0:
        r4 = "topicList";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x00a8:
        r12 = r0;
        goto L_0x0179;
    L_0x00ab:
        r4 = "rankList";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x00b3:
        r12 = 22;
        goto L_0x0179;
    L_0x00b7:
        r4 = "announcementDetail";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x00bf:
        r12 = 21;
        goto L_0x0179;
    L_0x00c3:
        r4 = "score";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x00cb:
        r12 = 11;
        goto L_0x0179;
    L_0x00cf:
        r4 = "index";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x00d7:
        r12 = 3;
        goto L_0x0179;
    L_0x00da:
        r4 = "dynamicDetail";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x00e2:
        r12 = 20;
        goto L_0x0179;
    L_0x00e6:
        r4 = "articleDetail";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x00ee:
        r12 = 19;
        goto L_0x0179;
    L_0x00f2:
        r4 = "personalData";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x00fa:
        r12 = 4;
        goto L_0x0179;
    L_0x00fd:
        r4 = "rollCall";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0105:
        r12 = 15;
        goto L_0x0179;
    L_0x0109:
        r4 = "musicIndex";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0111:
        r12 = 16;
        goto L_0x0179;
    L_0x0115:
        r4 = "topicDetail";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x011d:
        r12 = 18;
        goto L_0x0179;
    L_0x0120:
        r4 = "runHistory";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0128:
        r12 = 8;
        goto L_0x0179;
    L_0x012b:
        r4 = "sportCampus";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0133:
        r12 = 17;
        goto L_0x0179;
    L_0x0136:
        r4 = "smartAttendance";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x013e:
        r12 = 10;
        goto L_0x0179;
    L_0x0141:
        r4 = "noticeList";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0149:
        r12 = 14;
        goto L_0x0179;
    L_0x014c:
        r4 = "course";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0154:
        r12 = 12;
        goto L_0x0179;
    L_0x0157:
        r4 = "weChatProgram";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x015f:
        r12 = 23;
        goto L_0x0179;
    L_0x0162:
        r4 = "rankHistory";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x016a:
        r12 = 9;
        goto L_0x0179;
    L_0x016d:
        r4 = "student";
        r12 = r12.equals(r4);	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0178;
    L_0x0175:
        r12 = 13;
        goto L_0x0179;
    L_0x0178:
        r12 = r2;
    L_0x0179:
        r2 = 10003; // 0x2713 float:1.4017E-41 double:4.942E-320;
        switch(r12) {
            case 0: goto L_0x0342;
            case 1: goto L_0x033e;
            case 2: goto L_0x033a;
            case 3: goto L_0x0329;
            case 4: goto L_0x0325;
            case 5: goto L_0x030d;
            case 6: goto L_0x02f5;
            case 7: goto L_0x02f0;
            case 8: goto L_0x02eb;
            case 9: goto L_0x02e6;
            case 10: goto L_0x02e1;
            case 11: goto L_0x02da;
            case 12: goto L_0x02d5;
            case 13: goto L_0x02d0;
            case 14: goto L_0x02cb;
            case 15: goto L_0x02c6;
            case 16: goto L_0x02c1;
            case 17: goto L_0x02bc;
            case 18: goto L_0x02a0;
            case 19: goto L_0x0284;
            case 20: goto L_0x0268;
            case 21: goto L_0x024c;
            case 22: goto L_0x022e;
            case 23: goto L_0x01ea;
            case 24: goto L_0x019f;
            case 25: goto L_0x0182;
            default: goto L_0x017e;
        };	 Catch:{ Exception -> 0x0364 }
    L_0x017e:
        r11 = "暂不支持该跳转！";
        goto L_0x0346;
    L_0x0182:
        r12 = "extra_module_id";
        r1 = 10005; // 0x2715 float:1.402E-41 double:4.943E-320;
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o(r12, r1);	 Catch:{ Exception -> 0x0364 }
        r12 = r11 instanceof com.zjwh.android_wh_physicalfitness.activity.MainActivity;	 Catch:{ Exception -> 0x0364 }
        if (r12 == 0) goto L_0x0198;
    L_0x0191:
        r11 = (com.zjwh.android_wh_physicalfitness.activity.MainActivity) r11;	 Catch:{ Exception -> 0x0364 }
        r11.O00000oO();	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x0198:
        r11 = com.zjwh.android_wh_physicalfitness.activity.MainActivity.class;
        com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x019f:
        r12 = "id";
        r12 = r1.get(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = (java.lang.String) r12;	 Catch:{ Exception -> 0x0364 }
        r2 = "nickName";
        r2 = r1.get(r2);	 Catch:{ Exception -> 0x0364 }
        r7 = r2;
        r7 = (java.lang.String) r7;	 Catch:{ Exception -> 0x0364 }
        r2 = "count";
        r2 = r1.get(r2);	 Catch:{ Exception -> 0x0364 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0364 }
        r4 = "isPaid";
        r1 = r1.get(r4);	 Catch:{ Exception -> 0x0364 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0364 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x0364 }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x0364 }
        if (r1 != r3) goto L_0x01cc;
    L_0x01ca:
        r8 = r3;
        goto L_0x01cd;
    L_0x01cc:
        r8 = r0;
    L_0x01cd:
        r1 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Exception -> 0x0364 }
        if (r1 == 0) goto L_0x01d4;
    L_0x01d3:
        return r0;
    L_0x01d4:
        r12 = java.lang.Long.valueOf(r12);	 Catch:{ Exception -> 0x0364 }
        r5 = r12.longValue();	 Catch:{ Exception -> 0x0364 }
        r12 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0364 }
        r9 = r12.longValue();	 Catch:{ Exception -> 0x0364 }
        r4 = r11;
        com.zjwh.android_wh_physicalfitness.ui.music.AlbumDetailActivity.O000000o(r4, r5, r7, r8, r9);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x01ea:
        r12 = 2131690069; // 0x7f0f0255 float:1.9009171E38 double:1.0531948307E-314;
        r12 = r11.getString(r12);	 Catch:{ Exception -> 0x0364 }
        r11 = com.tencent.mm.opensdk.openapi.WXAPIFactory.createWXAPI(r11, r12);	 Catch:{ Exception -> 0x0364 }
        r12 = r11.isWXAppInstalled();	 Catch:{ Exception -> 0x0364 }
        if (r12 != 0) goto L_0x0202;
    L_0x01fb:
        r11 = 2131690056; // 0x7f0f0248 float:1.9009145E38 double:1.0531948243E-314;
        com.zjwh.android_wh_physicalfitness.utils.O00Oo00.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        return r0;
    L_0x0202:
        r12 = "id";
        r12 = r1.get(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = (java.lang.String) r12;	 Catch:{ Exception -> 0x0364 }
        r2 = "path";
        r1 = r1.get(r2);	 Catch:{ Exception -> 0x0364 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0364 }
        r2 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Exception -> 0x0364 }
        if (r2 != 0) goto L_0x0361;
    L_0x0218:
        r2 = new com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req;	 Catch:{ Exception -> 0x0364 }
        r2.<init>();	 Catch:{ Exception -> 0x0364 }
        r2.userName = r12;	 Catch:{ Exception -> 0x0364 }
        r12 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0364 }
        if (r12 != 0) goto L_0x0227;
    L_0x0225:
        r2.path = r1;	 Catch:{ Exception -> 0x0364 }
    L_0x0227:
        r2.miniprogramType = r0;	 Catch:{ Exception -> 0x0364 }
        r11.sendReq(r2);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x022e:
        r12 = "index";
        r12 = r1.get(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = (java.lang.String) r12;	 Catch:{ Exception -> 0x0364 }
        r1 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Exception -> 0x0364 }
        if (r1 == 0) goto L_0x023d;
    L_0x023c:
        return r0;
    L_0x023d:
        r1 = "";
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = r12.intValue();	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.ui.rank.RankingListActivity.O000000o(r11, r1, r12);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x024c:
        r12 = "id";
        r12 = r1.get(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = (java.lang.String) r12;	 Catch:{ Exception -> 0x0364 }
        r1 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Exception -> 0x0364 }
        if (r1 == 0) goto L_0x025b;
    L_0x025a:
        return r0;
    L_0x025b:
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = r12.intValue();	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.ui.notice.NoticeDetailActivity.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x0268:
        r12 = "id";
        r12 = r1.get(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = (java.lang.String) r12;	 Catch:{ Exception -> 0x0364 }
        r1 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Exception -> 0x0364 }
        if (r1 == 0) goto L_0x0277;
    L_0x0276:
        return r0;
    L_0x0277:
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = r12.intValue();	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity.O000000o(r11, r12, r0);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x0284:
        r12 = "id";
        r12 = r1.get(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = (java.lang.String) r12;	 Catch:{ Exception -> 0x0364 }
        r1 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Exception -> 0x0364 }
        if (r1 == 0) goto L_0x0293;
    L_0x0292:
        return r0;
    L_0x0293:
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = r12.intValue();	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.activity.ArticleDetailActivity.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02a0:
        r12 = "id";
        r12 = r1.get(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = (java.lang.String) r12;	 Catch:{ Exception -> 0x0364 }
        r1 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Exception -> 0x0364 }
        if (r1 == 0) goto L_0x02af;
    L_0x02ae:
        return r0;
    L_0x02af:
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x0364 }
        r12 = r12.intValue();	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.activity.find.TopicDetailActivity.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02bc:
        com.zjwh.android_wh_physicalfitness.ui.mine.SportCampusActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02c1:
        com.zjwh.android_wh_physicalfitness.ui.music.MusicMainActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02c6:
        com.zjwh.android_wh_physicalfitness.ui.mine.RollCallActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02cb:
        com.zjwh.android_wh_physicalfitness.ui.notice.NoticeListActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02d0:
        com.zjwh.android_wh_physicalfitness.activity.mine.MyStudentActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02d5:
        com.zjwh.android_wh_physicalfitness.activity.mine.MyCourseActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02da:
        r12 = "https://gxapp-h5.oss-cn-shanghai.aliyuncs.com/gxapp/myScore/myscore.html";
        com.zjwh.android_wh_physicalfitness.activity.WebViewActivity.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02e1:
        com.zjwh.android_wh_physicalfitness.ui.mine.AttendanceActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02e6:
        com.zjwh.android_wh_physicalfitness.activity.mine.HistoryRankActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02eb:
        com.zjwh.android_wh_physicalfitness.ui.mine.RunHistoryActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02f0:
        com.zjwh.android_wh_physicalfitness.activity.PrizeListActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x02f5:
        r11 = "extra_module_id";
        r12 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
        r11 = "extra_hot_dynamic_v2";
        r12 = java.lang.Integer.valueOf(r5);	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
        r11 = com.zjwh.android_wh_physicalfitness.activity.MainActivity.class;
        com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x030d:
        r11 = "extra_module_id";
        r12 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
        r11 = "extra_hot_dynamic_v2";
        r12 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
        r11 = com.zjwh.android_wh_physicalfitness.activity.MainActivity.class;
        com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x0325:
        com.zjwh.android_wh_physicalfitness.activity.mine.PersonalInfoActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x0329:
        r11 = "extra_module_id";
        r12 = 10001; // 0x2711 float:1.4014E-41 double:4.941E-320;
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x0364 }
        com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
        r11 = com.zjwh.android_wh_physicalfitness.activity.MainActivity.class;
        com.zjwh.android_wh_physicalfitness.utils.O00000Oo.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x033a:
        com.zjwh.android_wh_physicalfitness.activity.find.ActivitiesActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x033e:
        com.zjwh.android_wh_physicalfitness.activity.find.ArticleActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x0342:
        com.zjwh.android_wh_physicalfitness.activity.find.TopicActivity.O000000o(r11);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x0346:
        com.zjwh.android_wh_physicalfitness.utils.O00Oo00.O00000Oo(r11);	 Catch:{ Exception -> 0x0364 }
        return r0;
    L_0x034a:
        r1 = "http";
        r1 = r12.startsWith(r1);	 Catch:{ Exception -> 0x0364 }
        if (r1 == 0) goto L_0x0362;
    L_0x0352:
        r1 = "welfare.club";
        r1 = r12.contains(r1);	 Catch:{ Exception -> 0x0364 }
        if (r1 == 0) goto L_0x035e;
    L_0x035a:
        com.zjwh.android_wh_physicalfitness.ui.welfare.WelfareClubActivity.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
        goto L_0x0361;
    L_0x035e:
        com.zjwh.android_wh_physicalfitness.activity.WebViewActivity.O000000o(r11, r12);	 Catch:{ Exception -> 0x0364 }
    L_0x0361:
        return r3;
    L_0x0362:
        return r0;
    L_0x0363:
        return r0;
    L_0x0364:
        r11 = move-exception;
        r11.printStackTrace();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.utils.O000o0.O000000o(android.app.Activity, java.lang.String):boolean");
    }

    public static void O00000Oo() {
        JPushInterface.setAliasAndTags(MyApplication.O000000o(), "", new HashSet(), new TagAliasCallback() {
            public void gotResult(int i, String str, Set<String> set) {
            }
        });
    }

    public static void O00000Oo(Activity activity, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                UserInfo O00000o0 = O00Oo0.O00000o0();
                if (!(O00000o0 == null || O00000o0.isLogout() || !O00000o0.isRegisted())) {
                    JSONObject jSONObject = new JSONObject(str);
                    MessageBodyBean messageBodyBean = (MessageBodyBean) new Gson().fromJson(jSONObject.optString("body"), MessageBodyBean.class);
                    if (messageBodyBean != null) {
                        int optInt = jSONObject.optInt("type");
                        int id = messageBodyBean.getId();
                        str = messageBodyBean.getUrl();
                        switch (optInt) {
                            case 1:
                                ArticleDetailActivity.O000000o(activity, id);
                                break;
                            case 2:
                                DynamicDetailActivity.O000000o(activity, id, false);
                                break;
                            case 3:
                                CommentActivity.O000000o(activity, 0);
                                break;
                            case 4:
                                LikeActivity.O000000o(activity, 0);
                                break;
                            case 5:
                                WebViewActivity.O000000o(activity, str);
                                break;
                            case 6:
                                TopicDetailActivity.O000000o(activity, id);
                                break;
                            case 7:
                                FansActivity.O000000o(activity, 0);
                                break;
                            case 8:
                                MessageActivity.O000000o(activity);
                                break;
                            default:
                                break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
