package com.sina.weibo.sdk.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import cn.jiguang.net.HttpUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.Utility;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Set;

public class HttpManager {
    private static final String BOUNDARY = getBoundry();
    private static final String END_MP_BOUNDARY;
    private static final String MP_BOUNDARY;
    private static final String TAG = "HttpManager";

    static {
        System.loadLibrary("weibosdkcore");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(BOUNDARY);
        MP_BOUNDARY = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(BOUNDARY);
        stringBuilder.append("--");
        END_MP_BOUNDARY = stringBuilder.toString();
    }

    public static void buildParams(OutputStream outputStream, WeiboParameters weiboParameters) throws WeiboException {
        try {
            StringBuilder stringBuilder;
            Set<String> keySet = weiboParameters.keySet();
            for (String str : keySet) {
                if (weiboParameters.get(str) instanceof String) {
                    stringBuilder = new StringBuilder(100);
                    stringBuilder.setLength(0);
                    stringBuilder.append(MP_BOUNDARY);
                    stringBuilder.append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"");
                    stringBuilder.append(str);
                    stringBuilder.append("\"\r\n\r\n");
                    stringBuilder.append(weiboParameters.get(str));
                    stringBuilder.append("\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                }
            }
            for (String str2 : keySet) {
                Object obj = weiboParameters.get(str2);
                if (obj instanceof Bitmap) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(MP_BOUNDARY);
                    stringBuilder.append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"");
                    stringBuilder.append(str2);
                    stringBuilder.append("\"; filename=\"file\"\r\n");
                    stringBuilder.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                    Bitmap bitmap = (Bitmap) obj;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                    outputStream.write(byteArrayOutputStream.toByteArray());
                    outputStream.write("\r\n".getBytes());
                } else if (obj instanceof ByteArrayOutputStream) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(MP_BOUNDARY);
                    stringBuilder.append("\r\n");
                    stringBuilder.append("content-disposition: form-data; name=\"");
                    stringBuilder.append(str2);
                    stringBuilder.append("\"; filename=\"file\"\r\n");
                    stringBuilder.append("Content-Type: application/octet-stream; charset=utf-8\r\n\r\n");
                    outputStream.write(stringBuilder.toString().getBytes());
                    ByteArrayOutputStream byteArrayOutputStream2 = (ByteArrayOutputStream) obj;
                    outputStream.write(byteArrayOutputStream2.toByteArray());
                    outputStream.write("\r\n".getBytes());
                    byteArrayOutputStream2.close();
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("\r\n");
            stringBuilder2.append(END_MP_BOUNDARY);
            outputStream.write(stringBuilder2.toString().getBytes());
        } catch (IOException e) {
            throw new WeiboException(e);
        }
    }

    private static native String calcOauthSignNative(Context context, String str, String str2);

    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00d7 */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061 A:{Catch:{ Exception -> 0x00d7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c A:{Catch:{ Exception -> 0x00d7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085 A:{Catch:{ Exception -> 0x00d7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083 A:{Catch:{ Exception -> 0x00d7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ac A:{SYNTHETIC, EDGE_INSN: B:55:0x00ac->B:36:0x00ac ?: BREAK  , EDGE_INSN: B:55:0x00ac->B:36:0x00ac ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a7 A:{LOOP_END, LOOP:0: B:33:0x00a0->B:35:0x00a7, Catch:{ Exception -> 0x00d7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b6 A:{Catch:{ Exception -> 0x00d7 }} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:17|18|19|20|21|22|(1:24)(1:25)|26|(1:28)(2:29|(1:31)(2:46|47))|32|(2:33|(1:35)(1:55))|36|(2:38|(1:40)(3:41|42|43))|44|45|48|49|50|51) */
    /* JADX WARNING: Can't wrap try/catch for region: R(19:17|18|19|20|21|22|(1:24)(1:25)|26|(1:28)(2:29|(1:31)(2:46|47))|32|(2:33|(1:35)(1:55))|36|(2:38|(1:40)(3:41|42|43))|44|45|48|49|50|51) */
    public static synchronized java.lang.String downloadFile(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) throws com.sina.weibo.sdk.exception.WeiboException {
        /*
        r0 = com.sina.weibo.sdk.net.HttpManager.class;
        monitor-enter(r0);
        r1 = new java.io.File;	 Catch:{ all -> 0x00db }
        r1.<init>(r10);	 Catch:{ all -> 0x00db }
        r2 = r1.exists();	 Catch:{ all -> 0x00db }
        if (r2 != 0) goto L_0x0011;
    L_0x000e:
        r1.mkdirs();	 Catch:{ all -> 0x00db }
    L_0x0011:
        r2 = new java.io.File;	 Catch:{ all -> 0x00db }
        r2.<init>(r1, r11);	 Catch:{ all -> 0x00db }
        r1 = r2.exists();	 Catch:{ all -> 0x00db }
        if (r1 == 0) goto L_0x0022;
    L_0x001c:
        r8 = r2.getPath();	 Catch:{ all -> 0x00db }
        monitor-exit(r0);
        return r8;
    L_0x0022:
        r1 = android.webkit.URLUtil.isValidUrl(r9);	 Catch:{ all -> 0x00db }
        if (r1 != 0) goto L_0x002c;
    L_0x0028:
        r8 = "";
        monitor-exit(r0);
        return r8;
    L_0x002c:
        r1 = new java.io.File;	 Catch:{ all -> 0x00db }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00db }
        r3.<init>();	 Catch:{ all -> 0x00db }
        r3.append(r11);	 Catch:{ all -> 0x00db }
        r11 = "_temp";
        r3.append(r11);	 Catch:{ all -> 0x00db }
        r11 = r3.toString();	 Catch:{ all -> 0x00db }
        r1.<init>(r10, r11);	 Catch:{ all -> 0x00db }
        r8 = com.sina.weibo.sdk.net.ConnectionFactory.createConnect(r9, r8);	 Catch:{ all -> 0x00db }
        r9 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
        r8.setConnectTimeout(r9);	 Catch:{ all -> 0x00db }
        r8.setReadTimeout(r9);	 Catch:{ all -> 0x00db }
        r9 = "GET";
        r8.setRequestMethod(r9);	 Catch:{ Exception -> 0x0054 }
    L_0x0054:
        r9 = r1.exists();	 Catch:{ Exception -> 0x00d7 }
        r10 = 0;
        if (r9 == 0) goto L_0x0061;
    L_0x005c:
        r3 = r1.length();	 Catch:{ Exception -> 0x00d7 }
        goto L_0x0065;
    L_0x0061:
        r1.createNewFile();	 Catch:{ Exception -> 0x00d7 }
        r3 = r10;
    L_0x0065:
        r9 = "RANGE";
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00d7 }
        r5.<init>();	 Catch:{ Exception -> 0x00d7 }
        r6 = "bytes=";
        r5.append(r6);	 Catch:{ Exception -> 0x00d7 }
        r5.append(r3);	 Catch:{ Exception -> 0x00d7 }
        r3 = r5.toString();	 Catch:{ Exception -> 0x00d7 }
        r8.setRequestProperty(r9, r3);	 Catch:{ Exception -> 0x00d7 }
        r9 = r8.getResponseCode();	 Catch:{ Exception -> 0x00d7 }
        r3 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r9 != r3) goto L_0x0085;
    L_0x0083:
        r3 = r10;
        goto L_0x008e;
    L_0x0085:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 != r3) goto L_0x00cc;
    L_0x0089:
        r9 = r8.getContentLength();	 Catch:{ Exception -> 0x00d7 }
        r3 = (long) r9;	 Catch:{ Exception -> 0x00d7 }
    L_0x008e:
        r8 = r8.getInputStream();	 Catch:{ Exception -> 0x00d7 }
        r9 = new java.io.RandomAccessFile;	 Catch:{ Exception -> 0x00d7 }
        r5 = "rw";
        r9.<init>(r1, r5);	 Catch:{ Exception -> 0x00d7 }
        r9.seek(r10);	 Catch:{ Exception -> 0x00d7 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r5];	 Catch:{ Exception -> 0x00d7 }
    L_0x00a0:
        r6 = r8.read(r5);	 Catch:{ Exception -> 0x00d7 }
        r7 = -1;
        if (r6 == r7) goto L_0x00ac;
    L_0x00a7:
        r7 = 0;
        r9.write(r5, r7, r6);	 Catch:{ Exception -> 0x00d7 }
        goto L_0x00a0;
    L_0x00ac:
        r9.close();	 Catch:{ Exception -> 0x00d7 }
        r8.close();	 Catch:{ Exception -> 0x00d7 }
        r8 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1));
        if (r8 == 0) goto L_0x00c8;
    L_0x00b6:
        r8 = r1.length();	 Catch:{ Exception -> 0x00d7 }
        r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1));
        if (r10 >= 0) goto L_0x00bf;
    L_0x00be:
        goto L_0x00c8;
    L_0x00bf:
        r1.renameTo(r2);	 Catch:{ Exception -> 0x00d7 }
        r8 = r2.getPath();	 Catch:{ Exception -> 0x00d7 }
        monitor-exit(r0);
        return r8;
    L_0x00c8:
        r1.delete();	 Catch:{ Exception -> 0x00d7 }
        goto L_0x00d7;
    L_0x00cc:
        r10 = 1;
        r8 = readConnectResponse(r8, r10);	 Catch:{ Exception -> 0x00d7 }
        r10 = new com.sina.weibo.sdk.exception.WeiboHttpException;	 Catch:{ Exception -> 0x00d7 }
        r10.<init>(r8, r9);	 Catch:{ Exception -> 0x00d7 }
        throw r10;	 Catch:{ Exception -> 0x00d7 }
    L_0x00d7:
        r8 = "";
        monitor-exit(r0);
        return r8;
    L_0x00db:
        r8 = move-exception;
        monitor-exit(r0);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.HttpManager.downloadFile(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String getBoundry() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < 12; i++) {
            long currentTimeMillis = System.currentTimeMillis() + ((long) i);
            long j = currentTimeMillis % 3;
            if (j == 0) {
                stringBuffer.append(((char) ((int) currentTimeMillis)) % 9);
            } else if (j == 1) {
                stringBuffer.append((char) ((int) (65 + (currentTimeMillis % 26))));
            } else {
                stringBuffer.append((char) ((int) (97 + (currentTimeMillis % 26))));
            }
        }
        return stringBuffer.toString();
    }

    private static String getOauthSign(Context context, String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            stringBuilder.append(str3);
        }
        return calcOauthSignNative(context, stringBuilder.toString(), str4);
    }

    private static String getTimestamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String openRedirectUrl4LocationUri(Context context, String str, String str2, WeiboParameters weiboParameters) {
        HttpURLConnection createConnect;
        if (str2.equals(Constants.HTTP_GET)) {
            StringBuilder stringBuilder;
            if (str.endsWith(HttpUtils.URL_AND_PARA_SEPARATOR)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(weiboParameters.encodeUrl());
                str = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(HttpUtils.URL_AND_PARA_SEPARATOR);
                stringBuilder.append(weiboParameters.encodeUrl());
                str = stringBuilder.toString();
            }
            createConnect = ConnectionFactory.createConnect(str, context);
        } else {
            createConnect = ConnectionFactory.createConnect(str, context);
        }
        str2 = "";
        try {
            createConnect.setInstanceFollowRedirects(false);
            createConnect.connect();
            int responseCode = createConnect.getResponseCode();
            if (responseCode != SecExceptionCode.SEC_ERROR_STA_DATA_FILE_MISMATCH) {
                if (responseCode != SecExceptionCode.SEC_ERROR_STA_INVALID_PARAM) {
                    if (responseCode != 200) {
                        return str2;
                    }
                    return str;
                }
            }
            str = createConnect.getHeaderField("Location");
            return str;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String openUrl(Context context, String str, String str2, WeiboParameters weiboParameters) throws WeiboException {
        String requestHttpExecute = requestHttpExecute(context, str, str2, weiboParameters);
        str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response : ");
        stringBuilder.append(requestHttpExecute);
        LogUtil.d(str, stringBuilder.toString());
        return requestHttpExecute;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0057 A:{SYNTHETIC, Splitter:B:39:0x0057} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005c A:{SYNTHETIC, Splitter:B:43:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0057 A:{SYNTHETIC, Splitter:B:39:0x0057} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005c A:{SYNTHETIC, Splitter:B:43:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0057 A:{SYNTHETIC, Splitter:B:39:0x0057} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005c A:{SYNTHETIC, Splitter:B:43:0x005c} */
    private static java.lang.String readConnectResponse(java.net.HttpURLConnection r4, boolean r5) {
        /*
        r0 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r1 = 0;
        r0 = new byte[r0];	 Catch:{ IOException -> 0x004b, all -> 0x0048 }
        if (r5 == 0) goto L_0x000c;
    L_0x0007:
        r4 = r4.getErrorStream();	 Catch:{ IOException -> 0x004b, all -> 0x0048 }
        goto L_0x0010;
    L_0x000c:
        r4 = r4.getInputStream();	 Catch:{ IOException -> 0x004b, all -> 0x0048 }
    L_0x0010:
        r5 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0043, all -> 0x003d }
        r5.<init>();	 Catch:{ IOException -> 0x0043, all -> 0x003d }
    L_0x0015:
        r1 = r4.read(r0);	 Catch:{ IOException -> 0x003b, all -> 0x0037 }
        r2 = -1;
        if (r1 == r2) goto L_0x0021;
    L_0x001c:
        r2 = 0;
        r5.write(r0, r2, r1);	 Catch:{ IOException -> 0x003b, all -> 0x0037 }
        goto L_0x0015;
    L_0x0021:
        r0 = new java.lang.String;	 Catch:{ IOException -> 0x003b, all -> 0x0037 }
        r1 = r5.toByteArray();	 Catch:{ IOException -> 0x003b, all -> 0x0037 }
        r2 = "UTF-8";
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x003b, all -> 0x0037 }
        if (r4 == 0) goto L_0x0031;
    L_0x002e:
        r4.close();	 Catch:{ Exception -> 0x0031 }
    L_0x0031:
        if (r5 == 0) goto L_0x0036;
    L_0x0033:
        r5.close();	 Catch:{ Exception -> 0x0036 }
    L_0x0036:
        return r0;
    L_0x0037:
        r0 = move-exception;
        r1 = r4;
        r4 = r0;
        goto L_0x0055;
    L_0x003b:
        r0 = move-exception;
        goto L_0x0046;
    L_0x003d:
        r5 = move-exception;
        r3 = r1;
        r1 = r4;
        r4 = r5;
        r5 = r3;
        goto L_0x0055;
    L_0x0043:
        r5 = move-exception;
        r0 = r5;
        r5 = r1;
    L_0x0046:
        r1 = r4;
        goto L_0x004e;
    L_0x0048:
        r4 = move-exception;
        r5 = r1;
        goto L_0x0055;
    L_0x004b:
        r4 = move-exception;
        r0 = r4;
        r5 = r1;
    L_0x004e:
        r4 = new com.sina.weibo.sdk.exception.WeiboException;	 Catch:{ all -> 0x0054 }
        r4.<init>(r0);	 Catch:{ all -> 0x0054 }
        throw r4;	 Catch:{ all -> 0x0054 }
    L_0x0054:
        r4 = move-exception;
    L_0x0055:
        if (r1 == 0) goto L_0x005a;
    L_0x0057:
        r1.close();	 Catch:{ Exception -> 0x005a }
    L_0x005a:
        if (r5 == 0) goto L_0x005f;
    L_0x005c:
        r5.close();	 Catch:{ Exception -> 0x005f }
    L_0x005f:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.HttpManager.readConnectResponse(java.net.HttpURLConnection, boolean):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    private static java.lang.String requestHttpExecute(android.content.Context r2, java.lang.String r3, java.lang.String r4, com.sina.weibo.sdk.net.WeiboParameters r5) {
        /*
        r0 = 0;
        setHttpCommonParam(r2, r5);	 Catch:{ IOException -> 0x009a }
        r1 = "GET";
        r4 = r1.equals(r4);	 Catch:{ IOException -> 0x009a }
        r1 = 1;
        if (r4 == 0) goto L_0x0035;
    L_0x000d:
        r4 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x009a }
        r4.<init>();	 Catch:{ IOException -> 0x009a }
        r4.append(r3);	 Catch:{ IOException -> 0x009a }
        r3 = "?";
        r4.append(r3);	 Catch:{ IOException -> 0x009a }
        r3 = r5.encodeUrl();	 Catch:{ IOException -> 0x009a }
        r4.append(r3);	 Catch:{ IOException -> 0x009a }
        r3 = r4.toString();	 Catch:{ IOException -> 0x009a }
        r2 = com.sina.weibo.sdk.net.ConnectionFactory.createConnect(r3, r2);	 Catch:{ IOException -> 0x009a }
        r3 = "GET";
        r2.setRequestMethod(r3);	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r2.setInstanceFollowRedirects(r1);	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r2.connect();	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        goto L_0x0074;
    L_0x0035:
        r2 = com.sina.weibo.sdk.net.ConnectionFactory.createConnect(r3, r2);	 Catch:{ IOException -> 0x009a }
        r2.setInstanceFollowRedirects(r1);	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r2.connect();	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r3 = r5.hasBinaryData();	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        if (r3 == 0) goto L_0x0058;
    L_0x0045:
        r3 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r4 = r2.getOutputStream();	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r3.<init>(r4);	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        buildParams(r3, r5);	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r3.flush();	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r3.close();	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        goto L_0x0074;
    L_0x0058:
        r3 = new java.io.DataOutputStream;	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r4 = r2.getOutputStream();	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r3.<init>(r4);	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r4 = r5.encodeUrl();	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r5 = "UTF-8";
        r4 = r4.getBytes(r5);	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r3.write(r4);	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r3.flush();	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
        r3.close();	 Catch:{ IOException -> 0x0095, all -> 0x0092 }
    L_0x0074:
        r0 = r2;
        r2 = r0.getResponseCode();	 Catch:{ IOException -> 0x009a }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 == r3) goto L_0x0087;
    L_0x007d:
        r3 = readConnectResponse(r0, r1);	 Catch:{ IOException -> 0x009a }
        r4 = new com.sina.weibo.sdk.exception.WeiboHttpException;	 Catch:{ IOException -> 0x009a }
        r4.<init>(r3, r2);	 Catch:{ IOException -> 0x009a }
        throw r4;	 Catch:{ IOException -> 0x009a }
    L_0x0087:
        r2 = 0;
        r2 = readConnectResponse(r0, r2);	 Catch:{ IOException -> 0x009a }
        if (r0 == 0) goto L_0x0091;
    L_0x008e:
        r0.disconnect();
    L_0x0091:
        return r2;
    L_0x0092:
        r3 = move-exception;
        r0 = r2;
        goto L_0x00a4;
    L_0x0095:
        r3 = move-exception;
        r0 = r2;
        goto L_0x009b;
    L_0x0098:
        r3 = move-exception;
        goto L_0x00a4;
    L_0x009a:
        r3 = move-exception;
    L_0x009b:
        r3.printStackTrace();	 Catch:{ all -> 0x0098 }
        r2 = new com.sina.weibo.sdk.exception.WeiboException;	 Catch:{ all -> 0x0098 }
        r2.<init>(r3);	 Catch:{ all -> 0x0098 }
        throw r2;	 Catch:{ all -> 0x0098 }
    L_0x00a4:
        if (r0 == 0) goto L_0x00a9;
    L_0x00a6:
        r0.disconnect();
    L_0x00a9:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.HttpManager.requestHttpExecute(android.content.Context, java.lang.String, java.lang.String, com.sina.weibo.sdk.net.WeiboParameters):java.lang.String");
    }

    private static void setHttpCommonParam(Context context, WeiboParameters weiboParameters) {
        String str = "";
        if (!TextUtils.isEmpty(weiboParameters.getAppKey())) {
            str = Utility.getAid(context, weiboParameters.getAppKey());
            if (!TextUtils.isEmpty(str)) {
                weiboParameters.put("aid", str);
            }
        }
        String timestamp = getTimestamp();
        weiboParameters.put("oauth_timestamp", timestamp);
        String str2 = "";
        Object obj = weiboParameters.get("access_token");
        Object obj2 = weiboParameters.get(Oauth2AccessToken.KEY_REFRESH_TOKEN);
        Object obj3 = weiboParameters.get("phone");
        if (obj != null && (obj instanceof String)) {
            str2 = (String) obj;
        } else if (obj2 != null && (obj2 instanceof String)) {
            str2 = (String) obj2;
        } else if (obj3 != null && (obj3 instanceof String)) {
            str2 = (String) obj3;
        }
        weiboParameters.put("oauth_sign", getOauthSign(context, str, str2, weiboParameters.getAppKey(), timestamp));
    }
}
