package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LogBuilder {
    private static final String APPKEY = "WEIBO_APPKEY";
    private static final String CHANNEL = "WEIBO_CHANNEL";
    public static final String KEY_AID = "aid";
    public static final String KEY_APPKEY = "appkey";
    public static final String KEY_CHANNEL = "channel";
    private static final String KEY_DURATION = "duration";
    public static final String KEY_END_TIME = "endtime";
    private static final String KEY_EVENT_ID = "event_id";
    private static final String KEY_EXTEND = "extend";
    public static final String KEY_HASH = "key_hash";
    public static final String KEY_PACKAGE_NAME = "packagename";
    private static final String KEY_PAGE_ID = "page_id";
    public static final String KEY_PLATFORM = "platform";
    public static final String KEY_START_TIME = "starttime";
    private static final String KEY_TIME = "time";
    public static final String KEY_TYPE = "type";
    public static final String KEY_VERSION = "version";
    private static final int MAX_COUNT = 500;
    public static final long MAX_INTERVAL = 86400000;

    private static JSONObject addEventData(JSONObject jSONObject, EventLog eventLog) {
        try {
            jSONObject.put(KEY_EVENT_ID, eventLog.getEvent_id());
            if (eventLog.getExtend() != null) {
                Map extend = eventLog.getExtend();
                StringBuilder stringBuilder = new StringBuilder();
                int i = 0;
                for (String str : extend.keySet()) {
                    if (i >= 10) {
                        break;
                    } else if (!TextUtils.isEmpty((CharSequence) extend.get(str))) {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.append("|");
                        }
                        stringBuilder.append(str);
                        stringBuilder.append(":");
                        stringBuilder.append((String) extend.get(str));
                        i++;
                    }
                }
                jSONObject.put(KEY_EXTEND, stringBuilder.toString());
            }
        } catch (Exception e) {
            String str2 = WBAgent.TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("add event log error.");
            stringBuilder2.append(e);
            LogUtil.e(str2, stringBuilder2.toString());
        }
        return jSONObject;
    }

    private static String buildUploadLogs(String str) {
        String appLogs = LogFileUtil.getAppLogs(LogFileUtil.getAppLogPath(LogFileUtil.ANALYTICS_FILE_NAME));
        if (TextUtils.isEmpty(appLogs) && TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{applogs:[");
        if (!TextUtils.isEmpty(appLogs)) {
            stringBuilder.append(appLogs);
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) == ',') {
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
        }
        stringBuilder.append("]}");
        return stringBuilder.toString();
    }

    public static String getAppKey(Context context) {
        String str;
        StringBuilder stringBuilder;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get(APPKEY);
                if (obj != null) {
                    str = WBAgent.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("APPKEY: ");
                    stringBuilder.append(String.valueOf(obj));
                    LogUtil.i(str, stringBuilder.toString());
                    return String.valueOf(obj);
                }
                LogUtil.e(WBAgent.TAG, "Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e) {
            str = WBAgent.TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not read WEIBO_APPKEY meta-data from AndroidManifest.xml.");
            stringBuilder.append(e);
            LogUtil.e(str, stringBuilder.toString());
        }
        return null;
    }

    public static String getChannel(Context context) {
        String str;
        StringBuilder stringBuilder;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString(CHANNEL);
                if (string != null) {
                    str = WBAgent.TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("CHANNEL: ");
                    stringBuilder.append(string.trim());
                    LogUtil.i(str, stringBuilder.toString());
                    return string.trim();
                }
                LogUtil.e(WBAgent.TAG, "Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e) {
            str = WBAgent.TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not read WEIBO_CHANNEL meta-data from AndroidManifest.xml.");
            stringBuilder.append(e);
            LogUtil.e(str, stringBuilder.toString());
        }
        return null;
    }

    private static JSONObject getLogInfo(PageLog pageLog) {
        JSONObject jSONObject = new JSONObject();
        try {
            switch (pageLog.getType()) {
                case SESSION_START:
                    jSONObject.put("type", 0);
                    jSONObject.put(KEY_TIME, pageLog.getStartTime() / 1000);
                    break;
                case SESSION_END:
                    jSONObject.put("type", 1);
                    jSONObject.put(KEY_TIME, pageLog.getEndTime() / 1000);
                    jSONObject.put(KEY_DURATION, pageLog.getDuration() / 1000);
                    break;
                case FRAGMENT:
                    jSONObject.put("type", 2);
                    jSONObject.put(KEY_PAGE_ID, pageLog.getPage_id());
                    jSONObject.put(KEY_TIME, pageLog.getStartTime() / 1000);
                    jSONObject.put(KEY_DURATION, pageLog.getDuration() / 1000);
                    break;
                case EVENT:
                    jSONObject.put("type", 3);
                    jSONObject.put(KEY_PAGE_ID, pageLog.getPage_id());
                    jSONObject.put(KEY_TIME, pageLog.getStartTime() / 1000);
                    addEventData(jSONObject, (EventLog) pageLog);
                    break;
                case ACTIVITY:
                    jSONObject.put("type", 4);
                    jSONObject.put(KEY_PAGE_ID, pageLog.getPage_id());
                    jSONObject.put(KEY_TIME, pageLog.getStartTime() / 1000);
                    jSONObject.put(KEY_DURATION, pageLog.getDuration() / 1000);
                    break;
                case APP_AD_START:
                    AdEventLog adEventLog = (AdEventLog) pageLog;
                    jSONObject.put("type", 0);
                    jSONObject.put(KEY_PAGE_ID, adEventLog.getmImei());
                    jSONObject.put(KEY_TIME, adEventLog.getStartTime());
                    jSONObject.put("aid", adEventLog.getmAid());
                    addEventData(jSONObject, adEventLog);
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            String str = WBAgent.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get page log error.");
            stringBuilder.append(e);
            LogUtil.e(str, stringBuilder.toString());
        }
        return jSONObject;
    }

    public static String getPageLogs(CopyOnWriteArrayList<PageLog> copyOnWriteArrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            stringBuilder.append(getLogInfo((PageLog) it.next()).toString());
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    public static List<JSONArray> getValidUploadLogs(String str) {
        str = buildUploadLogs(str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONArray jSONArray2 = new JSONObject(str).getJSONArray("applogs");
            JSONArray jSONArray3 = jSONArray;
            int i = 0;
            int i2 = i;
            while (i < jSONArray2.length()) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                if (isDataValid(currentTimeMillis, jSONObject.getLong(KEY_TIME) * 1000)) {
                    if (i2 < 500) {
                        jSONArray3.put(jSONObject);
                        i2++;
                    } else {
                        arrayList.add(jSONArray3);
                        jSONArray3 = new JSONArray();
                        i2 = 0;
                    }
                }
                i++;
            }
            if (jSONArray3.length() > 0) {
                arrayList.add(jSONArray3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static String getVersion(Context context) {
        String str;
        StringBuilder stringBuilder;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = WBAgent.TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("versionName: ");
            stringBuilder.append(packageInfo.versionName);
            LogUtil.i(str, stringBuilder.toString());
            return packageInfo.versionName;
        } catch (NameNotFoundException e) {
            str = WBAgent.TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not read versionName from AndroidManifest.xml.");
            stringBuilder.append(e);
            LogUtil.e(str, stringBuilder.toString());
            return null;
        }
    }

    private static boolean isDataValid(long j, long j2) {
        return j - j2 < MAX_INTERVAL;
    }
}
