package com.sina.weibo.sdk.statistic;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

class LogReport {
    private static final int CONNECTION_TIMEOUT = 25000;
    private static final String PRIVATE_CODE = "dqwef1864il4c9m6";
    private static final int SOCKET_TIMEOUT = 20000;
    private static String UPLOADTIME = "uploadtime";
    private static String mAid = null;
    private static String mAppkey = null;
    private static String mBaseUrl = "https://api.weibo.com/2/proxy/sdk/statistic.json";
    private static String mChannel;
    private static String mKeyHash;
    public static LogReport mLogReport;
    private static String mPackageName;
    private static JSONObject mParams;
    private static String mVersionName;

    public LogReport(Context context) {
        try {
            if (mPackageName == null) {
                mPackageName = context.getPackageName();
            }
            mAppkey = StatisticConfig.getAppkey(context);
            checkAid(context);
            mKeyHash = Utility.getSign(context, mPackageName);
            mVersionName = LogBuilder.getVersion(context);
            mChannel = StatisticConfig.getChannel(context);
        } catch (Exception e) {
            LogUtil.e(WBAgent.TAG, e.toString());
        }
        initCommonParams();
    }

    private static boolean checkAid(Context context) {
        if (TextUtils.isEmpty(mAid)) {
            mAid = Utility.getAid(context, mAppkey);
        }
        if (mParams == null) {
            mParams = new JSONObject();
        }
        try {
            mParams.put("aid", mAid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return !TextUtils.isEmpty(mAid);
    }

    public static String getPackageName() {
        return mPackageName;
    }

    private static String getSign(String str, String str2, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append(str2);
        stringBuilder.append(PRIVATE_CODE);
        stringBuilder.append(j);
        str = MD5.hexdigest(stringBuilder.toString());
        str = str.substring(str.length() - 6);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(str.substring(0, 4));
        str2 = MD5.hexdigest(stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(str);
        stringBuilder3.append(str2.substring(str2.length() - 1));
        return stringBuilder3.toString();
    }

    public static long getTime(Context context) {
        return context.getSharedPreferences(UPLOADTIME, 0).getLong("lasttime", 0);
    }

    private static byte[] gzipLogs(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bytes = str.getBytes("utf-8");
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static JSONObject initCommonParams() {
        if (mParams == null) {
            mParams = new JSONObject();
        }
        try {
            mParams.put(LogBuilder.KEY_APPKEY, mAppkey);
            mParams.put("platform", "Android");
            mParams.put("packagename", mPackageName);
            mParams.put("key_hash", mKeyHash);
            mParams.put("version", mVersionName);
            mParams.put(LogBuilder.KEY_CHANNEL, mChannel);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mParams;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:47:0x0112=Splitter:B:47:0x0112, B:42:0x0109=Splitter:B:42:0x0109} */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011b A:{SYNTHETIC, Splitter:B:53:0x011b} */
    /* JADX WARNING: Missing block: B:44:0x010c, code skipped:
            if (r7 != null) goto L_0x010e;
     */
    /* JADX WARNING: Missing block: B:46:?, code skipped:
            r7.close();
     */
    /* JADX WARNING: Missing block: B:49:0x0115, code skipped:
            if (r7 == null) goto L_0x0118;
     */
    private static boolean requestHttpExecute(java.lang.String r6, java.lang.String r7, org.json.JSONObject r8, org.json.JSONArray r9, android.content.Context r10) {
        /*
        r7 = mAppkey;
        r7 = android.text.TextUtils.isEmpty(r7);
        r0 = 0;
        if (r7 == 0) goto L_0x0011;
    L_0x0009:
        r6 = "WBAgent";
        r7 = "unexpected null AppKey";
        com.sina.weibo.sdk.utils.LogUtil.e(r6, r7);
        return r0;
    L_0x0011:
        r7 = 0;
        if (r8 != 0) goto L_0x0022;
    L_0x0014:
        r8 = initCommonParams();	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        goto L_0x0022;
    L_0x0019:
        r6 = move-exception;
        goto L_0x0119;
    L_0x001c:
        r6 = move-exception;
        goto L_0x0109;
    L_0x001f:
        r6 = move-exception;
        goto L_0x0112;
    L_0x0022:
        r1 = "time";
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x0072 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r2 / r4;
        r8.put(r1, r2);	 Catch:{ JSONException -> 0x0072 }
        r1 = "length";
        r2 = r9.length();	 Catch:{ JSONException -> 0x0072 }
        r8.put(r1, r2);	 Catch:{ JSONException -> 0x0072 }
        r1 = "sign";
        r2 = "aid";
        r2 = r8.getString(r2);	 Catch:{ JSONException -> 0x0072 }
        r3 = "appkey";
        r3 = r8.getString(r3);	 Catch:{ JSONException -> 0x0072 }
        r4 = "time";
        r4 = r8.getLong(r4);	 Catch:{ JSONException -> 0x0072 }
        r2 = getSign(r2, r3, r4);	 Catch:{ JSONException -> 0x0072 }
        r8.put(r1, r2);	 Catch:{ JSONException -> 0x0072 }
        r1 = "content";
        r8.put(r1, r9);	 Catch:{ JSONException -> 0x0072 }
        r9 = "WBAgent";
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0072 }
        r1.<init>();	 Catch:{ JSONException -> 0x0072 }
        r2 = "post content--- ";
        r1.append(r2);	 Catch:{ JSONException -> 0x0072 }
        r2 = r8.toString();	 Catch:{ JSONException -> 0x0072 }
        r1.append(r2);	 Catch:{ JSONException -> 0x0072 }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x0072 }
        com.sina.weibo.sdk.utils.LogUtil.d(r9, r1);	 Catch:{ JSONException -> 0x0072 }
        goto L_0x0076;
    L_0x0072:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
    L_0x0076:
        r9 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9.<init>();	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r6 = "?source=";
        r9.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r6 = mAppkey;	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9.append(r6);	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r6 = r9.toString();	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r6 = com.sina.weibo.sdk.net.ConnectionFactory.createConnect(r6, r10);	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9 = new java.io.ByteArrayOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r9.<init>();	 Catch:{ UnsupportedEncodingException -> 0x001f, IOException -> 0x001c }
        r7 = com.sina.weibo.sdk.statistic.StatisticConfig.isNeedGizp();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        if (r7 == 0) goto L_0x00a7;
    L_0x009b:
        r7 = r8.toString();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r7 = gzipLogs(r7);	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r9.write(r7);	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        goto L_0x00b2;
    L_0x00a7:
        r7 = r8.toString();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r7 = r7.getBytes();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r9.write(r7);	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
    L_0x00b2:
        setPost(r6);	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r6.connect();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r7 = new java.io.DataOutputStream;	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r10 = r6.getOutputStream();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r7.<init>(r10);	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r8 = r8.toString();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r8 = gzipLogs(r8);	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r7.write(r8);	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r7.flush();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r7.close();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r7 = r6.getResponseCode();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 != r8) goto L_0x00e4;
    L_0x00da:
        r6.getResponseMessage();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r6 = 1;
        if (r9 == 0) goto L_0x00e3;
    L_0x00e0:
        r9.close();	 Catch:{ IOException -> 0x00e3 }
    L_0x00e3:
        return r6;
    L_0x00e4:
        r6 = "WBAgent";
        r8 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r8.<init>();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r10 = "status code = ";
        r8.append(r10);	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r8.append(r7);	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        r7 = r8.toString();	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        com.sina.weibo.sdk.utils.LogUtil.i(r6, r7);	 Catch:{ UnsupportedEncodingException -> 0x0106, IOException -> 0x0103, all -> 0x0100 }
        if (r9 == 0) goto L_0x0118;
    L_0x00fc:
        r9.close();	 Catch:{ IOException -> 0x0118 }
        goto L_0x0118;
    L_0x0100:
        r6 = move-exception;
        r7 = r9;
        goto L_0x0119;
    L_0x0103:
        r6 = move-exception;
        r7 = r9;
        goto L_0x0109;
    L_0x0106:
        r6 = move-exception;
        r7 = r9;
        goto L_0x0112;
    L_0x0109:
        r6.printStackTrace();	 Catch:{ all -> 0x0019 }
        if (r7 == 0) goto L_0x0118;
    L_0x010e:
        r7.close();	 Catch:{ IOException -> 0x0118 }
        goto L_0x0118;
    L_0x0112:
        r6.printStackTrace();	 Catch:{ all -> 0x0019 }
        if (r7 == 0) goto L_0x0118;
    L_0x0117:
        goto L_0x010e;
    L_0x0118:
        return r0;
    L_0x0119:
        if (r7 == 0) goto L_0x011e;
    L_0x011b:
        r7.close();	 Catch:{ IOException -> 0x011e }
    L_0x011e:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogReport.requestHttpExecute(java.lang.String, java.lang.String, org.json.JSONObject, org.json.JSONArray, android.content.Context):boolean");
    }

    public static void setPackageName(String str) {
        mPackageName = str;
    }

    private static void setPost(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Charset", HttpUtils.ENCODING_UTF_8);
        } catch (Exception unused) {
        }
    }

    private static void updateTime(Context context, Long l) {
        Editor edit = context.getSharedPreferences(UPLOADTIME, 0).edit();
        edit.putLong("lasttime", l.longValue());
        edit.commit();
    }

    /* JADX WARNING: Missing block: B:35:0x00aa, code skipped:
            return;
     */
    public static synchronized void uploadAppLogs(android.content.Context r8, java.lang.String r9) {
        /*
        r0 = com.sina.weibo.sdk.statistic.LogReport.class;
        monitor-enter(r0);
        r1 = mLogReport;	 Catch:{ all -> 0x00ab }
        if (r1 != 0) goto L_0x000e;
    L_0x0007:
        r1 = new com.sina.weibo.sdk.statistic.LogReport;	 Catch:{ all -> 0x00ab }
        r1.<init>(r8);	 Catch:{ all -> 0x00ab }
        mLogReport = r1;	 Catch:{ all -> 0x00ab }
    L_0x000e:
        r1 = com.sina.weibo.sdk.net.NetStateManager.isNetworkConnected(r8);	 Catch:{ all -> 0x00ab }
        r2 = 1;
        if (r1 != 0) goto L_0x0027;
    L_0x0015:
        r8 = "WBAgent";
        r1 = "network is not connected";
        com.sina.weibo.sdk.utils.LogUtil.i(r8, r1);	 Catch:{ all -> 0x00ab }
        r8 = "app_logs";
        r8 = com.sina.weibo.sdk.statistic.LogFileUtil.getAppLogPath(r8);	 Catch:{ all -> 0x00ab }
        com.sina.weibo.sdk.statistic.LogFileUtil.writeToFile(r8, r9, r2);	 Catch:{ all -> 0x00ab }
        monitor-exit(r0);
        return;
    L_0x0027:
        r9 = com.sina.weibo.sdk.statistic.LogBuilder.getValidUploadLogs(r9);	 Catch:{ all -> 0x00ab }
        if (r9 != 0) goto L_0x0036;
    L_0x002d:
        r8 = "WBAgent";
        r9 = "applogs is null";
        com.sina.weibo.sdk.utils.LogUtil.i(r8, r9);	 Catch:{ all -> 0x00ab }
        monitor-exit(r0);
        return;
    L_0x0036:
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00ab }
        r1.<init>();	 Catch:{ all -> 0x00ab }
        r3 = checkAid(r8);	 Catch:{ all -> 0x00ab }
        r9 = r9.iterator();	 Catch:{ all -> 0x00ab }
    L_0x0043:
        r4 = r9.hasNext();	 Catch:{ all -> 0x00ab }
        if (r4 == 0) goto L_0x0075;
    L_0x0049:
        r4 = r9.next();	 Catch:{ all -> 0x00ab }
        r4 = (org.json.JSONArray) r4;	 Catch:{ all -> 0x00ab }
        r5 = 0;
        if (r3 == 0) goto L_0x005c;
    L_0x0052:
        r5 = mBaseUrl;	 Catch:{ all -> 0x00ab }
        r6 = "POST";
        r7 = mParams;	 Catch:{ all -> 0x00ab }
        r5 = requestHttpExecute(r5, r6, r7, r4, r8);	 Catch:{ all -> 0x00ab }
    L_0x005c:
        if (r5 != 0) goto L_0x0069;
    L_0x005e:
        r1.add(r4);	 Catch:{ all -> 0x00ab }
        r4 = "WBAgent";
        r5 = "upload applogs error";
        com.sina.weibo.sdk.utils.LogUtil.e(r4, r5);	 Catch:{ all -> 0x00ab }
        goto L_0x0043;
    L_0x0069:
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x00ab }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x00ab }
        updateTime(r8, r4);	 Catch:{ all -> 0x00ab }
        goto L_0x0043;
    L_0x0075:
        r8 = "app_logs";
        r8 = com.sina.weibo.sdk.statistic.LogFileUtil.getAppLogPath(r8);	 Catch:{ all -> 0x00ab }
        com.sina.weibo.sdk.statistic.LogFileUtil.delete(r8);	 Catch:{ all -> 0x00ab }
        r8 = r1.size();	 Catch:{ all -> 0x00ab }
        if (r8 <= 0) goto L_0x00a9;
    L_0x0084:
        r8 = r1.iterator();	 Catch:{ all -> 0x00ab }
    L_0x0088:
        r9 = r8.hasNext();	 Catch:{ all -> 0x00ab }
        if (r9 == 0) goto L_0x00a9;
    L_0x008e:
        r9 = r8.next();	 Catch:{ all -> 0x00ab }
        r9 = (org.json.JSONArray) r9;	 Catch:{ all -> 0x00ab }
        r1 = "app_logs";
        r1 = com.sina.weibo.sdk.statistic.LogFileUtil.getAppLogPath(r1);	 Catch:{ all -> 0x00ab }
        r9 = r9.toString();	 Catch:{ all -> 0x00ab }
        com.sina.weibo.sdk.statistic.LogFileUtil.writeToFile(r1, r9, r2);	 Catch:{ all -> 0x00ab }
        r9 = "WBAgent";
        r1 = "save failed_log";
        com.sina.weibo.sdk.utils.LogUtil.d(r9, r1);	 Catch:{ all -> 0x00ab }
        goto L_0x0088;
    L_0x00a9:
        monitor-exit(r0);
        return;
    L_0x00ab:
        r8 = move-exception;
        monitor-exit(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.LogReport.uploadAppLogs(android.content.Context, java.lang.String):void");
    }
}
