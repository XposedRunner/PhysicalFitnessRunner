package com.ximalaya.ting.android.player.cdn;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel;
import com.yalantis.ucrop.view.CropImageView;
import defpackage.ah;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.text.DecimalFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CdnUtil {
    private static final String cdnUrl = "http://xdcs-collector.ximalaya.com/api/v1/cdnAndroid";
    private static final String cdnUrlTest = "http://xdcs-collector.test.ximalaya.com/api/v1/cdnAndroid";
    private static InputStream is;
    private static CdnConfigModel mCdnConfigModel;
    private static HttpURLConnection mConn;
    private static OutputStream os;

    private CdnUtil() {
    }

    public static String exception2String(Throwable th) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        if (stackTraceElement == null) {
            return th.getMessage();
        }
        String stringBuilder;
        if (TextUtils.isEmpty(th.getMessage())) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("null  located at:");
            stringBuilder2.append(stackTraceElement.toString());
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder = th.getMessage();
        }
        return stringBuilder;
    }

    public static CdnConfigModel getCdnConfigModel() {
        return mCdnConfigModel;
    }

    private static String getHostName(String str) {
        if (str == null || str.trim().equals("")) {
            return "";
        }
        String str2 = "";
        Matcher matcher = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+").matcher(str);
        if (matcher.find()) {
            str2 = matcher.group();
        }
        return str2;
    }

    public static String getUrlIp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str = InetAddress.getByName(getHostName(str)).getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        return str;
    }

    public static String objectTOJSON(List<CdnEvent> list) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (CdnEvent cdnEvent : list) {
            if (cdnEvent != null) {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(cdnEvent.getViewId())) {
                    jSONObject2.put("viewId", cdnEvent.getViewId());
                }
                if (!TextUtils.isEmpty(cdnEvent.getParentSpanId())) {
                    jSONObject2.put("parentSpanId", cdnEvent.getParentSpanId());
                }
                if (!TextUtils.isEmpty(cdnEvent.getSpanId())) {
                    jSONObject2.put("viewId", cdnEvent.getSpanId());
                }
                if (!TextUtils.isEmpty(cdnEvent.getTraceId())) {
                    jSONObject2.put("viewId", cdnEvent.getTraceId());
                }
                if (cdnEvent.getTs() >= 0) {
                    jSONObject2.put("ts", cdnEvent.getTs());
                }
                if (cdnEvent.getSeqId() >= 0) {
                    jSONObject2.put("seqId", cdnEvent.getSeqId());
                }
                if (!TextUtils.isEmpty(cdnEvent.getType())) {
                    jSONObject2.put("type", cdnEvent.getType());
                }
                if (cdnEvent.getProps() != null) {
                    StringBuilder stringBuilder;
                    CdnCollectDataForPlay props = cdnEvent.getProps();
                    JSONObject jSONObject3 = new JSONObject();
                    if (!TextUtils.isEmpty(props.getAudioUrl())) {
                        jSONObject3.put("audioUrl", props.getAudioUrl());
                    }
                    if (!TextUtils.isEmpty(props.getCdnIP())) {
                        jSONObject3.put("cdnIP", props.getCdnIP());
                    }
                    if (TextUtils.isEmpty(props.getDownloadSpeed())) {
                        jSONObject3.put("downloadSpeed", "0.0");
                    } else {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(props.getDownloadSpeed());
                        stringBuilder.append("");
                        jSONObject3.put("downloadSpeed", stringBuilder.toString());
                    }
                    if (!TextUtils.isEmpty(props.getErrorType())) {
                        jSONObject3.put("errorType", props.getErrorType());
                    }
                    if (!TextUtils.isEmpty(props.getExceptionReason())) {
                        jSONObject3.put("exceptionReason", props.getExceptionReason());
                    }
                    if (!TextUtils.isEmpty(props.getStatusCode())) {
                        jSONObject3.put("statusCode", props.getStatusCode());
                    }
                    if (!TextUtils.isEmpty(props.getType())) {
                        jSONObject3.put("type", props.getType());
                    }
                    if (!TextUtils.isEmpty(props.getViaInfo())) {
                        jSONObject3.put("viaInfo", props.getViaInfo());
                    }
                    if (props.getAudioBytes() > 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(props.getAudioBytes());
                        stringBuilder.append("");
                        jSONObject3.put("audioBytes", stringBuilder.toString());
                    } else {
                        jSONObject3.put("audioBytes", 0);
                    }
                    if (props.getConnectedTime() >= CropImageView.DEFAULT_ASPECT_RATIO) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(props.getConnectedTime());
                        stringBuilder.append("");
                        jSONObject3.put("connectedTime", stringBuilder.toString());
                    }
                    if (props.getTimestamp() >= 0) {
                        jSONObject3.put("timestamp", props.getTimestamp());
                    }
                    if (props.getRange() != null) {
                        jSONObject3.put("range", props.getRange());
                    }
                    if (props.getFileSize() != null) {
                        jSONObject3.put("fileSize", props.getFileSize());
                    }
                    if (TextUtils.isEmpty(props.getDownloaded())) {
                        jSONObject3.put("downloaded", "");
                    } else {
                        jSONObject3.put("downloaded", props.getDownloaded());
                    }
                    if (TextUtils.isEmpty(props.getDownloadTime())) {
                        jSONObject3.put("downloadTime", "");
                    } else {
                        jSONObject3.put("downloadTime", props.getDownloadTime());
                    }
                    if (TextUtils.isEmpty(props.getDownloadResult())) {
                        jSONObject3.put("downloadResult", CdnConstants.DOWNLOAD_FAILED);
                    } else {
                        jSONObject3.put("downloadResult", props.getDownloadResult());
                    }
                    if (!TextUtils.isEmpty(props.getCdnDomain())) {
                        jSONObject3.put("cdnDomain", props.getCdnDomain());
                    }
                    jSONObject3.put("timeout", props.isTimeout());
                    jSONObject2.put("props", jSONObject3);
                }
                jSONArray.put(jSONObject2);
            }
        }
        jSONObject.put(ah.O000o0o, jSONArray);
        return jSONObject.toString();
    }

    public static float oneDecimal(float f, boolean z) {
        if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        String format;
        if (z) {
            format = new DecimalFormat(".0").format((double) f);
        } else if (((double) f) < 0.1d) {
            return 0.001f;
        } else {
            format = new DecimalFormat(".000").format((double) (f / 1000.0f));
        }
        try {
            return Float.valueOf(format).floatValue();
        } catch (Exception unused) {
            return f;
        }
    }

    public static void setCdnConfigModel(CdnConfigModel cdnConfigModel) {
        mCdnConfigModel = cdnConfigModel;
    }

    /* JADX WARNING: Missing block: B:34:0x0169, code skipped:
            if (mConn != null) goto L_0x0192;
     */
    /* JADX WARNING: Missing block: B:52:0x0190, code skipped:
            if (mConn == null) goto L_0x0199;
     */
    /* JADX WARNING: Missing block: B:53:0x0192, code skipped:
            mConn.disconnect();
            mConn = null;
     */
    /* JADX WARNING: Missing block: B:54:0x0199, code skipped:
            return;
     */
    public static void statDownLoadCDN(com.ximalaya.ting.android.player.cdn.CdnCollectDataForPlay r8, com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel r9) {
        /*
        if (r8 == 0) goto L_0x01c2;
    L_0x0002:
        if (r9 != 0) goto L_0x0006;
    L_0x0004:
        goto L_0x01c2;
    L_0x0006:
        r0 = 0;
        r1 = new com.ximalaya.ting.android.player.cdn.CdnEvent;	 Catch:{ Exception -> 0x016e }
        r1.<init>();	 Catch:{ Exception -> 0x016e }
        r2 = "CDN";
        r1.setType(r2);	 Catch:{ Exception -> 0x016e }
        r1.setProps(r8);	 Catch:{ Exception -> 0x016e }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x016e }
        r1.setTs(r2);	 Catch:{ Exception -> 0x016e }
        r8 = new java.util.ArrayList;	 Catch:{ Exception -> 0x016e }
        r8.<init>();	 Catch:{ Exception -> 0x016e }
        r8.add(r1);	 Catch:{ Exception -> 0x016e }
        r8 = objectTOJSON(r8);	 Catch:{ Exception -> 0x016e }
        r1 = r9.getDoMain();	 Catch:{ Exception -> 0x016e }
        r2 = r9.getPath();	 Catch:{ Exception -> 0x016e }
        r3 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x016e }
        r3.<init>();	 Catch:{ Exception -> 0x016e }
        r4 = r9.getMap();	 Catch:{ Exception -> 0x016e }
        if (r4 == 0) goto L_0x0065;
    L_0x003a:
        r5 = r4.keySet();	 Catch:{ Exception -> 0x016e }
        r5 = r5.iterator();	 Catch:{ Exception -> 0x016e }
    L_0x0042:
        r6 = r5.hasNext();	 Catch:{ Exception -> 0x016e }
        if (r6 == 0) goto L_0x0065;
    L_0x0048:
        r6 = r5.next();	 Catch:{ Exception -> 0x016e }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x016e }
        r3.append(r6);	 Catch:{ Exception -> 0x016e }
        r7 = "=";
        r3.append(r7);	 Catch:{ Exception -> 0x016e }
        r6 = r4.get(r6);	 Catch:{ Exception -> 0x016e }
        r6 = (java.lang.String) r6;	 Catch:{ Exception -> 0x016e }
        r3.append(r6);	 Catch:{ Exception -> 0x016e }
        r6 = ";";
        r3.append(r6);	 Catch:{ Exception -> 0x016e }
        goto L_0x0042;
    L_0x0065:
        r4 = new java.util.HashMap;	 Catch:{ Exception -> 0x016e }
        r4.<init>();	 Catch:{ Exception -> 0x016e }
        r5 = "Cookie";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x016e }
        r6.<init>();	 Catch:{ Exception -> 0x016e }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016e }
        r6.append(r3);	 Catch:{ Exception -> 0x016e }
        r3 = "domain=";
        r6.append(r3);	 Catch:{ Exception -> 0x016e }
        r6.append(r1);	 Catch:{ Exception -> 0x016e }
        r1 = ";path=";
        r6.append(r1);	 Catch:{ Exception -> 0x016e }
        r6.append(r2);	 Catch:{ Exception -> 0x016e }
        r1 = r6.toString();	 Catch:{ Exception -> 0x016e }
        r4.put(r5, r1);	 Catch:{ Exception -> 0x016e }
        r1 = "User-Agent";
        r2 = r9.getUserAgent();	 Catch:{ Exception -> 0x016e }
        r4.put(r1, r2);	 Catch:{ Exception -> 0x016e }
        r1 = "Content-Length";
        r2 = r8.length();	 Catch:{ Exception -> 0x016e }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x016e }
        r4.put(r1, r2);	 Catch:{ Exception -> 0x016e }
        r1 = "Content-Type";
        r2 = "application/json";
        r4.put(r1, r2);	 Catch:{ Exception -> 0x016e }
        r1 = r9.getCdnUrl();	 Catch:{ Exception -> 0x016e }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x016e }
        if (r1 == 0) goto L_0x00b9;
    L_0x00b6:
        r9 = "http://xdcs-collector.ximalaya.com/api/v1/cdnAndroid";
        goto L_0x00bd;
    L_0x00b9:
        r9 = r9.getCdnUrl();	 Catch:{ Exception -> 0x016e }
    L_0x00bd:
        r1 = "POST";
        r9 = com.ximalaya.ting.android.player.PlayerUtil.getHttpURLConnection(r9, r1, r4);	 Catch:{ Exception -> 0x016e }
        mConn = r9;	 Catch:{ Exception -> 0x016e }
        r9 = mConn;	 Catch:{ Exception -> 0x016e }
        r9.connect();	 Catch:{ Exception -> 0x016e }
        r9 = mConn;	 Catch:{ Exception -> 0x016e }
        r9 = r9.getOutputStream();	 Catch:{ Exception -> 0x016e }
        os = r9;	 Catch:{ Exception -> 0x016e }
        r9 = os;	 Catch:{ Exception -> 0x016e }
        r1 = "utf-8";
        r8 = r8.getBytes(r1);	 Catch:{ Exception -> 0x016e }
        r9.write(r8);	 Catch:{ Exception -> 0x016e }
        r8 = os;	 Catch:{ Exception -> 0x016e }
        r8.flush();	 Catch:{ Exception -> 0x016e }
        r8 = os;	 Catch:{ Exception -> 0x016e }
        r8.close();	 Catch:{ Exception -> 0x016e }
        r8 = mConn;	 Catch:{ Exception -> 0x016e }
        r8 = r8.getResponseCode();	 Catch:{ Exception -> 0x016e }
        r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x016e }
        r9.<init>();	 Catch:{ Exception -> 0x016e }
        r1 = "post to xdcs url: ";
        r9.append(r1);	 Catch:{ Exception -> 0x016e }
        r1 = mConn;	 Catch:{ Exception -> 0x016e }
        r1 = r1.getURL();	 Catch:{ Exception -> 0x016e }
        r9.append(r1);	 Catch:{ Exception -> 0x016e }
        r9 = r9.toString();	 Catch:{ Exception -> 0x016e }
        com.ximalaya.ting.android.player.Logger.log(r9);	 Catch:{ Exception -> 0x016e }
        r9 = java.lang.System.out;	 Catch:{ Exception -> 0x016e }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x016e }
        r1.<init>();	 Catch:{ Exception -> 0x016e }
        r2 = "post to xdcs Response Code : ";
        r1.append(r2);	 Catch:{ Exception -> 0x016e }
        r1.append(r8);	 Catch:{ Exception -> 0x016e }
        r8 = r1.toString();	 Catch:{ Exception -> 0x016e }
        r9.println(r8);	 Catch:{ Exception -> 0x016e }
        r8 = mConn;	 Catch:{ Exception -> 0x016e }
        r8 = r8.getInputStream();	 Catch:{ Exception -> 0x016e }
        is = r8;	 Catch:{ Exception -> 0x016e }
        r8 = is;	 Catch:{ Exception -> 0x016e }
        if (r8 == 0) goto L_0x014b;
    L_0x0129:
        r8 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x016e }
        r9 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x016e }
        r1 = is;	 Catch:{ Exception -> 0x016e }
        r9.<init>(r1);	 Catch:{ Exception -> 0x016e }
        r8.<init>(r9);	 Catch:{ Exception -> 0x016e }
        r9 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x016e }
        r9.<init>();	 Catch:{ Exception -> 0x016e }
    L_0x013a:
        r1 = r8.readLine();	 Catch:{ Exception -> 0x016e }
        if (r1 == 0) goto L_0x0144;
    L_0x0140:
        r9.append(r1);	 Catch:{ Exception -> 0x016e }
        goto L_0x013a;
    L_0x0144:
        r8 = r9.toString();	 Catch:{ Exception -> 0x016e }
        com.ximalaya.ting.android.player.Logger.log(r8);	 Catch:{ Exception -> 0x016e }
    L_0x014b:
        r8 = os;
        if (r8 == 0) goto L_0x0159;
    L_0x014f:
        r8 = os;	 Catch:{ Exception -> 0x0155 }
        r8.close();	 Catch:{ Exception -> 0x0155 }
        goto L_0x0159;
    L_0x0155:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0159:
        r8 = is;
        if (r8 == 0) goto L_0x0167;
    L_0x015d:
        r8 = is;	 Catch:{ Exception -> 0x0163 }
        r8.close();	 Catch:{ Exception -> 0x0163 }
        goto L_0x0167;
    L_0x0163:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0167:
        r8 = mConn;
        if (r8 == 0) goto L_0x0199;
    L_0x016b:
        goto L_0x0192;
    L_0x016c:
        r8 = move-exception;
        goto L_0x019a;
    L_0x016e:
        r8 = move-exception;
        r8.printStackTrace();	 Catch:{ all -> 0x016c }
        r8 = os;
        if (r8 == 0) goto L_0x0180;
    L_0x0176:
        r8 = os;	 Catch:{ Exception -> 0x017c }
        r8.close();	 Catch:{ Exception -> 0x017c }
        goto L_0x0180;
    L_0x017c:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0180:
        r8 = is;
        if (r8 == 0) goto L_0x018e;
    L_0x0184:
        r8 = is;	 Catch:{ Exception -> 0x018a }
        r8.close();	 Catch:{ Exception -> 0x018a }
        goto L_0x018e;
    L_0x018a:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x018e:
        r8 = mConn;
        if (r8 == 0) goto L_0x0199;
    L_0x0192:
        r8 = mConn;
        r8.disconnect();
        mConn = r0;
    L_0x0199:
        return;
    L_0x019a:
        r9 = os;
        if (r9 == 0) goto L_0x01a8;
    L_0x019e:
        r9 = os;	 Catch:{ Exception -> 0x01a4 }
        r9.close();	 Catch:{ Exception -> 0x01a4 }
        goto L_0x01a8;
    L_0x01a4:
        r9 = move-exception;
        r9.printStackTrace();
    L_0x01a8:
        r9 = is;
        if (r9 == 0) goto L_0x01b6;
    L_0x01ac:
        r9 = is;	 Catch:{ Exception -> 0x01b2 }
        r9.close();	 Catch:{ Exception -> 0x01b2 }
        goto L_0x01b6;
    L_0x01b2:
        r9 = move-exception;
        r9.printStackTrace();
    L_0x01b6:
        r9 = mConn;
        if (r9 == 0) goto L_0x01c1;
    L_0x01ba:
        r9 = mConn;
        r9.disconnect();
        mConn = r0;
    L_0x01c1:
        throw r8;
    L_0x01c2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(com.ximalaya.ting.android.player.cdn.CdnCollectDataForPlay, com.ximalaya.ting.android.opensdk.model.xdcs.CdnConfigModel):void");
    }

    public static void statToXDCSError(String str, String str2) {
    }
}
