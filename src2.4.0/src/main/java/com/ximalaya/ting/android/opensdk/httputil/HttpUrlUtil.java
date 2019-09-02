package com.ximalaya.ting.android.opensdk.httputil;

import android.support.annotation.NonNull;
import com.ximalaya.ting.android.opensdk.httputil.util.freeflow.FreeFlowServiceUtil;
import com.ximalaya.ting.android.opensdk.httputil.util.freeflow.FreeFlowServiceUtil.ISetHttpUrlConnectAttribute;
import com.ximalaya.ting.android.opensdk.util.Logger;
import com.ximalaya.ting.android.player.cdn.CdnCollectDataForPlay;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class HttpUrlUtil {
    public static Config mConfig;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0074 A:{SYNTHETIC, Splitter:B:34:0x0074} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007f A:{SYNTHETIC, Splitter:B:40:0x007f} */
    public static int downloadFile(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
        r0 = -1;
        r1 = 0;
        r2 = mConfig;	 Catch:{ IOException -> 0x006e }
        r3 = "GET";
        r7 = getHttpURLConnection(r7, r2, r3, r1);	 Catch:{ IOException -> 0x006e }
        r7.connect();	 Catch:{ IOException -> 0x006e }
        r2 = r7.getResponseCode();	 Catch:{ IOException -> 0x006e }
        r3 = "Content-Length";
        r3 = r7.getHeaderField(r3);	 Catch:{ IOException -> 0x006e }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r4) goto L_0x006b;
    L_0x001b:
        r2 = android.text.TextUtils.isEmpty(r3);	 Catch:{ IOException -> 0x006e }
        if (r2 != 0) goto L_0x006b;
    L_0x0021:
        r2 = java.lang.Long.parseLong(r3);	 Catch:{ IOException -> 0x006e }
        r4 = 0;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 > 0) goto L_0x002c;
    L_0x002b:
        goto L_0x006b;
    L_0x002c:
        r7 = r7.getInputStream();	 Catch:{ IOException -> 0x006e }
        r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r2 = new byte[r2];	 Catch:{ IOException -> 0x006e }
        r3 = new java.io.File;	 Catch:{ IOException -> 0x006e }
        r3.<init>(r8);	 Catch:{ IOException -> 0x006e }
        r8 = r3.exists();	 Catch:{ IOException -> 0x006e }
        if (r8 != 0) goto L_0x0042;
    L_0x003f:
        r3.mkdirs();	 Catch:{ IOException -> 0x006e }
    L_0x0042:
        r8 = new java.io.File;	 Catch:{ IOException -> 0x006e }
        r8.<init>(r3, r9);	 Catch:{ IOException -> 0x006e }
        r9 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x006e }
        r3 = 0;
        r9.<init>(r8, r3);	 Catch:{ IOException -> 0x006e }
    L_0x004d:
        r8 = r7.read(r2);	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        if (r8 <= 0) goto L_0x0057;
    L_0x0053:
        r9.write(r2, r3, r8);	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        goto L_0x004d;
    L_0x0057:
        r9.flush();	 Catch:{ IOException -> 0x0068, all -> 0x0065 }
        if (r9 == 0) goto L_0x0064;
    L_0x005c:
        r9.close();	 Catch:{ IOException -> 0x0060 }
        goto L_0x0064;
    L_0x0060:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x0064:
        return r3;
    L_0x0065:
        r7 = move-exception;
        r1 = r9;
        goto L_0x007d;
    L_0x0068:
        r7 = move-exception;
        r1 = r9;
        goto L_0x006f;
    L_0x006b:
        return r0;
    L_0x006c:
        r7 = move-exception;
        goto L_0x007d;
    L_0x006e:
        r7 = move-exception;
    L_0x006f:
        r7.printStackTrace();	 Catch:{ all -> 0x006c }
        if (r1 == 0) goto L_0x007c;
    L_0x0074:
        r1.close();	 Catch:{ IOException -> 0x0078 }
        goto L_0x007c;
    L_0x0078:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x007c:
        return r0;
    L_0x007d:
        if (r1 == 0) goto L_0x0087;
    L_0x007f:
        r1.close();	 Catch:{ IOException -> 0x0083 }
        goto L_0x0087;
    L_0x0083:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x0087:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.opensdk.httputil.HttpUrlUtil.downloadFile(java.lang.String, java.lang.String, java.lang.String):int");
    }

    public static HttpURLConnection getHttpURLConnection(String str, Config config, String str2, ISetHttpUrlConnectAttribute iSetHttpUrlConnectAttribute) throws IOException {
        return FreeFlowServiceUtil.getHttpURLConnection(config, str, str2, iSetHttpUrlConnectAttribute);
    }

    private static void logToSD(HttpURLConnection httpURLConnection) {
        StringBuilder stringBuilder;
        Map requestProperties = httpURLConnection.getRequestProperties();
        String str = "OpenSDK.class header头 :";
        if (requestProperties.containsKey("Authorization")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("Authorization:");
            stringBuilder.append(requestProperties.get("Authorization"));
            stringBuilder.append("   ");
            str = stringBuilder.toString();
        }
        if (requestProperties.containsKey("spid")) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("spid:");
            stringBuilder.append(requestProperties.get("spid"));
            stringBuilder.append("   ");
            str = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("是否使用了代理 ");
        stringBuilder2.append(httpURLConnection.usingProxy());
        String stringBuilder3 = stringBuilder2.toString();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(simpleDateFormat.format(new Date(System.currentTimeMillis())));
        stringBuilder4.append("     ");
        stringBuilder4.append(stringBuilder3);
        stringBuilder3 = stringBuilder4.toString();
        Logger.logToSd(stringBuilder3);
        Logger.log(stringBuilder3);
    }

    public static void statDownLoadCDN(CdnCollectDataForPlay cdnCollectDataForPlay) {
        try {
            Class commonRequestM = BaseCall.getCommonRequestM();
            if (commonRequestM != null) {
                commonRequestM.getDeclaredMethod("statDownLoadCDN", new Class[]{CdnCollectDataForPlay.class}).invoke(commonRequestM, new Object[]{cdnCollectDataForPlay});
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
        }
    }

    public static int upload(String str, String str2) {
        try {
            final File file = new File(str2);
            if (file.exists() && !file.isDirectory()) {
                if (file.canRead()) {
                    try {
                        OutputStream outputStream = getHttpURLConnection(str, mConfig, "POST", new ISetHttpUrlConnectAttribute() {
                            public void setHttpUrlConnectAttributes(@NonNull HttpURLConnection httpURLConnection) {
                                httpURLConnection.setDoOutput(true);
                                httpURLConnection.setChunkedStreamingMode(134217728);
                                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("multipart/form-data;file=");
                                stringBuilder.append(file.getName());
                                httpURLConnection.setRequestProperty("Content-Type", stringBuilder.toString());
                                httpURLConnection.setRequestProperty("filename", file.getName());
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("");
                                stringBuilder.append(file.length());
                                httpURLConnection.setRequestProperty("Content-Length", stringBuilder.toString());
                            }
                        }).getOutputStream();
                        FileInputStream fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        outputStream.flush();
                        fileInputStream.close();
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    return -1;
                }
            }
            return -2;
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }
}
