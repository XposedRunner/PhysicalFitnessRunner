package com.ximalaya.ting.android.player;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.ximalaya.ting.android.player.model.HttpConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PlayerUtil {
    public static final String TAIHE_TAG = "#ximalaya-taihe";
    private static String cpuInfo = "";

    public static boolean checkSdcard() {
        return "mounted".equals(Environment.getExternalStorageState()) && Environment.getExternalStorageDirectory().canWrite();
    }

    public static void cleanCacheByMD5SoundPlay(String str) {
        File file = new File(XMediaPlayerConstants.INCOM_AUDIO_FILE_DIRECTORY);
        if (file != null && file.isDirectory() && !TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".chunk");
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append(".index");
            str = stringBuilder3.toString();
            new File(file, stringBuilder2).delete();
            new File(file, str).delete();
        }
    }

    public static void cleanUpCacheSound(String str) {
        File file = new File(XMediaPlayerConstants.INCOM_AUDIO_FILE_DIRECTORY);
        if (file != null && file.isDirectory()) {
            String str2 = null;
            String str3;
            if (TextUtils.isEmpty(str)) {
                str3 = null;
            } else {
                str3 = MD5.getFileNameMd5(str);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str3);
                stringBuilder.append(".chunk");
                str2 = stringBuilder.toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str3);
                stringBuilder2.append(".index");
                str3 = stringBuilder2.toString();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2 != null && ((str2 == null || !str2.equalsIgnoreCase(file2.getName())) && ((str3 == null || !str3.equalsIgnoreCase(file2.getName())) && (str3 == null || !str3.endsWith(XMediaPlayerConstants.FILE_PLAY_CACHE_INFO))))) {
                        file2.delete();
                    }
                }
            }
        }
        PlayCacheByLRU.getInstance().removeAllExcludeCurPlay(str);
    }

    private static HttpConfig createPlayerConfig(Map<String, String> map) {
        HttpConfig httpConfig = new HttpConfig();
        httpConfig.connectionTimeOut = 20000;
        httpConfig.readTimeOut = 20000;
        httpConfig.useCache = true;
        httpConfig.property = new HashMap();
        if (StaticConfig.mUseragent != null) {
            httpConfig.property.put("User-Agent", StaticConfig.mUseragent);
        }
        if (StaticConfig.mHeads != null) {
            httpConfig.property.putAll(StaticConfig.mHeads);
        }
        if (map != null) {
            httpConfig.property.putAll(map);
        }
        return httpConfig;
    }

    public static boolean existSDCard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static File fileIsExistCreate(String str) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (!(parentFile == null || parentFile.exists())) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static String formatDuring(long j) {
        int i;
        int i2;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        String str;
        if (j >= 3600) {
            i = (int) (j / 3600);
            i2 = (int) (j % 3600);
            if (i2 >= 60) {
                StringBuilder stringBuilder3;
                String str2;
                String str3;
                int i3 = i2 / 60;
                i2 %= 60;
                stringBuilder = new StringBuilder();
                if (i < 10) {
                    stringBuilder3 = new StringBuilder();
                    str2 = "0";
                } else {
                    stringBuilder3 = new StringBuilder();
                    str2 = "";
                }
                stringBuilder3.append(str2);
                stringBuilder3.append(i);
                stringBuilder.append(stringBuilder3.toString());
                stringBuilder.append(":");
                if (i3 < 10) {
                    stringBuilder3 = new StringBuilder();
                    str3 = "0";
                } else {
                    stringBuilder3 = new StringBuilder();
                    str3 = "";
                }
                stringBuilder3.append(str3);
                stringBuilder3.append(i3);
                stringBuilder.append(stringBuilder3.toString());
                stringBuilder.append(":");
                if (i2 < 10) {
                    stringBuilder2 = new StringBuilder();
                    str = "0";
                } else {
                    stringBuilder2 = new StringBuilder();
                    str = "";
                }
                stringBuilder2.append(str);
                stringBuilder2.append(i2);
                stringBuilder.append(stringBuilder2.toString());
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            if (i < 10) {
                stringBuilder2 = new StringBuilder();
                str = "0";
            } else {
                stringBuilder2 = new StringBuilder();
                str = "";
            }
            stringBuilder2.append(str);
            stringBuilder2.append(i);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(":");
            if (i2 < 10) {
                stringBuilder2 = new StringBuilder();
                str = "00:0";
            } else {
                stringBuilder2 = new StringBuilder();
                str = "00:";
            }
            stringBuilder2.append(str);
            stringBuilder2.append(i2);
            stringBuilder.append(stringBuilder2.toString());
            return stringBuilder.toString();
        } else if (j >= 60) {
            i = (int) (j / 60);
            i2 = (int) (j % 60);
            stringBuilder = new StringBuilder();
            if (i < 10) {
                stringBuilder2 = new StringBuilder();
                str = "0";
            } else {
                stringBuilder2 = new StringBuilder();
                str = "";
            }
            stringBuilder2.append(str);
            stringBuilder2.append(i);
            stringBuilder.append(stringBuilder2.toString());
            stringBuilder.append(":");
            if (i2 < 10) {
                stringBuilder2 = new StringBuilder();
                str = "0";
            } else {
                stringBuilder2 = new StringBuilder();
                str = "";
            }
            stringBuilder2.append(str);
            stringBuilder2.append(i2);
            stringBuilder.append(stringBuilder2.toString());
            return stringBuilder.toString();
        } else {
            if (j < 10) {
                stringBuilder2 = new StringBuilder();
                str = "00:0";
            } else {
                stringBuilder2 = new StringBuilder();
                str = "00:";
            }
            stringBuilder2.append(str);
            stringBuilder2.append((int) j);
            return stringBuilder2.toString();
        }
    }

    private static String getCPUInfos() {
        String str = "/proc/cpuinfo";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(str), 8192);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
            }
            if (stringBuilder != null) {
                return stringBuilder.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x00db A:{SYNTHETIC, Splitter:B:71:0x00db} */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0259  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029a  */
    public static java.net.HttpURLConnection getConnectionUseDnsCache(java.lang.String[] r26, java.lang.String r27, int r28, boolean r29, java.lang.String r30) {
        /*
        r1 = r26;
        r2 = r27;
        r3 = r28;
        r4 = com.ximalaya.ting.android.player.StaticConfig.mIDomainServerIpCallback;
        r5 = 0;
        r6 = r5;
        r6 = (java.lang.String[][]) r6;
        r7 = 0;
        if (r4 == 0) goto L_0x0015;
    L_0x000f:
        r6 = r1[r7];
        r6 = r4.getStaticDomainServerIp(r6);
    L_0x0015:
        r8 = "";
        r9 = 0;
        r11 = 1;
        if (r6 == 0) goto L_0x0022;
    L_0x001c:
        r12 = r6.length;
        if (r12 != 0) goto L_0x0020;
    L_0x001f:
        goto L_0x0022;
    L_0x0020:
        r12 = r7;
        goto L_0x0030;
    L_0x0022:
        r6 = new java.lang.String[r11][];
        r12 = 2;
        r12 = new java.lang.String[r12];
        r13 = r1[r7];
        r12[r7] = r13;
        r12[r11] = r5;
        r6[r7] = r12;
        r12 = r11;
    L_0x0030:
        r13 = com.ximalaya.ting.android.player.StaticConfig.sIStatToServerFactory;
        if (r13 == 0) goto L_0x0039;
    L_0x0034:
        r13 = r13.getStatToServer();
        goto L_0x003a;
    L_0x0039:
        r13 = r5;
    L_0x003a:
        r14 = "UnicomDigestAuthenticator 000 == 开始获取httpconnect";
        com.ximalaya.ting.android.player.Logger.log(r14);
        r14 = r9;
        r9 = r7;
        r10 = r8;
        r8 = r5;
        r5 = r9;
    L_0x0044:
        r7 = r6.length;
        if (r5 >= r7) goto L_0x0303;
    L_0x0047:
        releaseHttpUrlConnection(r8);
        r7 = new java.util.HashMap;	 Catch:{ Exception -> 0x027c }
        r7.<init>();	 Catch:{ Exception -> 0x027c }
        r16 = android.text.TextUtils.isEmpty(r27);	 Catch:{ Exception -> 0x027c }
        if (r16 != 0) goto L_0x0065;
    L_0x0055:
        r11 = "RANGE";
        r7.put(r11, r2);	 Catch:{ Exception -> 0x005b }
        goto L_0x0065;
    L_0x005b:
        r0 = move-exception;
        r2 = r1;
        r24 = r8;
        r23 = r12;
    L_0x0061:
        r11 = r14;
    L_0x0062:
        r1 = r0;
        goto L_0x0286;
    L_0x0065:
        r11 = r6[r5];	 Catch:{ Exception -> 0x027c }
        r16 = 1;
        r11 = r11[r16];	 Catch:{ Exception -> 0x027c }
        if (r11 == 0) goto L_0x0095;
    L_0x006d:
        r11 = "Host";
        r17 = r6[r5];	 Catch:{ Exception -> 0x008b }
        r22 = r8;
        r8 = r17[r16];	 Catch:{ Exception -> 0x0089 }
        r7.put(r11, r8);	 Catch:{ Exception -> 0x0089 }
        r8 = r6[r5];	 Catch:{ Exception -> 0x0089 }
        r8 = r8[r16];	 Catch:{ Exception -> 0x0089 }
        r10 = "httpdnsType";
        r11 = "ip";
        r7.put(r10, r11);	 Catch:{ Exception -> 0x0085 }
        r10 = r8;
        goto L_0x009e;
    L_0x0085:
        r0 = move-exception;
        r2 = r1;
        r10 = r8;
        goto L_0x008f;
    L_0x0089:
        r0 = move-exception;
        goto L_0x008e;
    L_0x008b:
        r0 = move-exception;
        r22 = r8;
    L_0x008e:
        r2 = r1;
    L_0x008f:
        r23 = r12;
        r11 = r14;
        r24 = r22;
        goto L_0x0062;
    L_0x0095:
        r22 = r8;
        r8 = "httpdnsType";
        r11 = "domain";
        r7.put(r8, r11);	 Catch:{ Exception -> 0x0279 }
    L_0x009e:
        if (r3 != 0) goto L_0x00a7;
    L_0x00a0:
        r8 = "Accept-Encoding";
        r11 = "identity";
        r7.put(r8, r11);	 Catch:{ Exception -> 0x0089 }
    L_0x00a7:
        r8 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;	 Catch:{ Exception -> 0x0279 }
        if (r8 == 0) goto L_0x00c5;
    L_0x00ab:
        r8 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;	 Catch:{ Exception -> 0x0089 }
        r8 = r8.proxyType;	 Catch:{ Exception -> 0x0089 }
        r11 = 1;
        if (r8 != r11) goto L_0x00b7;
    L_0x00b2:
        r8 = 3;
        if (r8 != r3) goto L_0x00b7;
    L_0x00b5:
        r8 = 0;
        goto L_0x00c6;
    L_0x00b7:
        r8 = r6[r5];	 Catch:{ Exception -> 0x0089 }
        r11 = 0;
        r8 = r8[r11];	 Catch:{ Exception -> 0x0089 }
        r11 = "#ximalaya-taihe";
        r8 = r8.endsWith(r11);	 Catch:{ Exception -> 0x0089 }
        if (r8 == 0) goto L_0x00c5;
    L_0x00c4:
        goto L_0x00b5;
    L_0x00c5:
        r8 = 1;
    L_0x00c6:
        r11 = r6[r5];	 Catch:{ Exception -> 0x0279 }
        r16 = 0;
        r11 = r11[r16];	 Catch:{ Exception -> 0x0279 }
        r23 = r12;
        r12 = r30;
        r8 = getHttpURLConnection(r11, r8, r12, r7);	 Catch:{ Exception -> 0x0276 }
        r16 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x026f }
        r7 = 1;
        if (r3 != r7) goto L_0x00e5;
    L_0x00db:
        r8.connect();	 Catch:{ Exception -> 0x00df }
        goto L_0x00e5;
    L_0x00df:
        r0 = move-exception;
        r2 = r1;
        r24 = r8;
        goto L_0x0061;
    L_0x00e5:
        r11 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x026f }
        r9 = r9 + 1;
        r7 = r8.getResponseCode();	 Catch:{ Exception -> 0x0269 }
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0269 }
        r14.<init>();	 Catch:{ Exception -> 0x0269 }
        r15 = "UnicomDigestAuthenticator 456 == 耗时= ";
        r14.append(r15);	 Catch:{ Exception -> 0x0269 }
        r18 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0269 }
        r1 = r18 - r16;
        r14.append(r1);	 Catch:{ Exception -> 0x0262 }
        r1 = " | code = ";
        r14.append(r1);	 Catch:{ Exception -> 0x0262 }
        r14.append(r7);	 Catch:{ Exception -> 0x0262 }
        r1 = r14.toString();	 Catch:{ Exception -> 0x0262 }
        com.ximalaya.ting.android.player.Logger.log(r1);	 Catch:{ Exception -> 0x0262 }
        if (r3 != 0) goto L_0x0156;
    L_0x0113:
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r7 != r1) goto L_0x0156;
    L_0x0117:
        if (r13 == 0) goto L_0x0155;
    L_0x0119:
        r1 = r6[r5];	 Catch:{ Exception -> 0x014d }
        r2 = 0;
        r15 = r1[r2];	 Catch:{ Exception -> 0x014d }
        r16 = "success";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014d }
        r1.<init>();	 Catch:{ Exception -> 0x014d }
        r1.append(r9);	 Catch:{ Exception -> 0x014d }
        r2 = "";
        r1.append(r2);	 Catch:{ Exception -> 0x014d }
        r17 = r1.toString();	 Catch:{ Exception -> 0x014d }
        r19 = com.ximalaya.ting.android.player.StaticConfig.mUseragent;	 Catch:{ Exception -> 0x014d }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014d }
        r1.<init>();	 Catch:{ Exception -> 0x014d }
        r1.append(r11);	 Catch:{ Exception -> 0x014d }
        r2 = "";
        r1.append(r2);	 Catch:{ Exception -> 0x014d }
        r20 = r1.toString();	 Catch:{ Exception -> 0x014d }
        r21 = "";
        r14 = r13;
        r18 = r10;
        r14.addEndHttpDnsRequest(r15, r16, r17, r18, r19, r20, r21);	 Catch:{ Exception -> 0x014d }
        goto L_0x0155;
    L_0x014d:
        r0 = move-exception;
        r1 = r0;
        r24 = r8;
        r2 = r26;
        goto L_0x0286;
    L_0x0155:
        return r8;
    L_0x0156:
        if (r3 == 0) goto L_0x0196;
    L_0x0158:
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 < r1) goto L_0x0196;
    L_0x015c:
        r1 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r7 >= r1) goto L_0x0196;
    L_0x0160:
        if (r13 == 0) goto L_0x0195;
    L_0x0162:
        r1 = r6[r5];	 Catch:{ Exception -> 0x014d }
        r2 = 0;
        r15 = r1[r2];	 Catch:{ Exception -> 0x014d }
        r16 = "success";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014d }
        r1.<init>();	 Catch:{ Exception -> 0x014d }
        r1.append(r9);	 Catch:{ Exception -> 0x014d }
        r2 = "";
        r1.append(r2);	 Catch:{ Exception -> 0x014d }
        r17 = r1.toString();	 Catch:{ Exception -> 0x014d }
        r19 = com.ximalaya.ting.android.player.StaticConfig.mUseragent;	 Catch:{ Exception -> 0x014d }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014d }
        r1.<init>();	 Catch:{ Exception -> 0x014d }
        r1.append(r11);	 Catch:{ Exception -> 0x014d }
        r2 = "";
        r1.append(r2);	 Catch:{ Exception -> 0x014d }
        r20 = r1.toString();	 Catch:{ Exception -> 0x014d }
        r21 = "";
        r14 = r13;
        r18 = r10;
        r14.addEndHttpDnsRequest(r15, r16, r17, r18, r19, r20, r21);	 Catch:{ Exception -> 0x014d }
    L_0x0195:
        return r8;
    L_0x0196:
        if (r4 == 0) goto L_0x0259;
    L_0x0198:
        r1 = 403; // 0x193 float:5.65E-43 double:1.99E-321;
        if (r7 != r1) goto L_0x01c5;
    L_0x019c:
        if (r29 != 0) goto L_0x01c5;
    L_0x019e:
        r2 = r26;
        r14 = 0;
        r7 = r2[r14];	 Catch:{ Exception -> 0x01bd }
        r7 = r4.getNewDownloadUrlIfExpire(r7);	 Catch:{ Exception -> 0x01bd }
        r15 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Exception -> 0x01bd }
        if (r15 == 0) goto L_0x01af;
    L_0x01ad:
        goto L_0x0303;
    L_0x01af:
        r2[r14] = r7;	 Catch:{ Exception -> 0x01bd }
        r7 = "GET";
        r14 = 1;
        r15 = r27;
        r7 = getConnectionUseDnsCache(r2, r15, r3, r14, r7);	 Catch:{ Exception -> 0x01bb }
        return r7;
    L_0x01bb:
        r0 = move-exception;
        goto L_0x01c0;
    L_0x01bd:
        r0 = move-exception;
        r15 = r27;
    L_0x01c0:
        r1 = r0;
        r24 = r8;
        goto L_0x0286;
    L_0x01c5:
        r2 = r26;
        r15 = r27;
        r14 = r6[r5];	 Catch:{ Exception -> 0x0257 }
        r16 = 1;
        r14 = r14[r16];	 Catch:{ Exception -> 0x0257 }
        r16 = r6[r5];	 Catch:{ Exception -> 0x0257 }
        r17 = 0;
        r1 = r16[r17];	 Catch:{ Exception -> 0x0257 }
        r3 = r2[r17];	 Catch:{ Exception -> 0x0257 }
        r4.setBadIp(r14, r1, r3);	 Catch:{ Exception -> 0x0257 }
        if (r23 == 0) goto L_0x020d;
    L_0x01dc:
        if (r13 == 0) goto L_0x020a;
    L_0x01de:
        r1 = r2[r17];	 Catch:{ Exception -> 0x0257 }
        r3 = com.ximalaya.ting.android.player.StaticConfig.mUseragent;	 Catch:{ Exception -> 0x0257 }
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0257 }
        r14.<init>();	 Catch:{ Exception -> 0x0257 }
        r14.append(r11);	 Catch:{ Exception -> 0x0257 }
        r24 = r8;
        r8 = "";
        r14.append(r8);	 Catch:{ Exception -> 0x0254 }
        r8 = r14.toString();	 Catch:{ Exception -> 0x0254 }
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0254 }
        r14.<init>();	 Catch:{ Exception -> 0x0254 }
        r15 = "response code is ";
        r14.append(r15);	 Catch:{ Exception -> 0x0254 }
        r14.append(r7);	 Catch:{ Exception -> 0x0254 }
        r7 = r14.toString();	 Catch:{ Exception -> 0x0254 }
        r13.statNormalRequest(r1, r3, r8, r7);	 Catch:{ Exception -> 0x0254 }
        goto L_0x025d;
    L_0x020a:
        r24 = r8;
        goto L_0x025d;
    L_0x020d:
        r24 = r8;
        if (r13 == 0) goto L_0x025d;
    L_0x0211:
        r1 = r6[r5];	 Catch:{ Exception -> 0x0254 }
        r3 = 0;
        r15 = r1[r3];	 Catch:{ Exception -> 0x0254 }
        r16 = "fail";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0254 }
        r1.<init>();	 Catch:{ Exception -> 0x0254 }
        r1.append(r9);	 Catch:{ Exception -> 0x0254 }
        r3 = "";
        r1.append(r3);	 Catch:{ Exception -> 0x0254 }
        r17 = r1.toString();	 Catch:{ Exception -> 0x0254 }
        r19 = com.ximalaya.ting.android.player.StaticConfig.mUseragent;	 Catch:{ Exception -> 0x0254 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0254 }
        r1.<init>();	 Catch:{ Exception -> 0x0254 }
        r1.append(r11);	 Catch:{ Exception -> 0x0254 }
        r3 = "";
        r1.append(r3);	 Catch:{ Exception -> 0x0254 }
        r20 = r1.toString();	 Catch:{ Exception -> 0x0254 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0254 }
        r1.<init>();	 Catch:{ Exception -> 0x0254 }
        r3 = "response code is ";
        r1.append(r3);	 Catch:{ Exception -> 0x0254 }
        r1.append(r7);	 Catch:{ Exception -> 0x0254 }
        r21 = r1.toString();	 Catch:{ Exception -> 0x0254 }
        r14 = r13;
        r18 = r10;
        r14.addHttpDnsEvent(r15, r16, r17, r18, r19, r20, r21);	 Catch:{ Exception -> 0x0254 }
        goto L_0x025d;
    L_0x0254:
        r0 = move-exception;
        goto L_0x0062;
    L_0x0257:
        r0 = move-exception;
        goto L_0x026b;
    L_0x0259:
        r24 = r8;
        r2 = r26;
    L_0x025d:
        r14 = r11;
        r7 = 1;
        r8 = 0;
        goto L_0x02f5;
    L_0x0262:
        r0 = move-exception;
        r24 = r8;
        r2 = r26;
        goto L_0x0062;
    L_0x0269:
        r0 = move-exception;
        r2 = r1;
    L_0x026b:
        r24 = r8;
        goto L_0x0062;
    L_0x026f:
        r0 = move-exception;
        r2 = r1;
        r24 = r8;
        r1 = r0;
        r11 = r14;
        goto L_0x0286;
    L_0x0276:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0282;
    L_0x0279:
        r0 = move-exception;
        r2 = r1;
        goto L_0x0280;
    L_0x027c:
        r0 = move-exception;
        r2 = r1;
        r22 = r8;
    L_0x0280:
        r23 = r12;
    L_0x0282:
        r1 = r0;
        r11 = r14;
        r24 = r22;
    L_0x0286:
        r1.printStackTrace();
        r3 = r6[r5];
        r7 = 1;
        r3 = r3[r7];
        r8 = r6[r5];
        r14 = 0;
        r8 = r8[r14];
        r15 = r2[r14];
        r4.setBadIp(r3, r8, r15);
        if (r23 == 0) goto L_0x02bb;
    L_0x029a:
        if (r13 == 0) goto L_0x02b9;
    L_0x029c:
        r3 = r2[r14];
        r8 = com.ximalaya.ting.android.player.StaticConfig.mUseragent;
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r14.append(r11);
        r15 = "";
        r14.append(r15);
        r14 = r14.toString();
        r1 = r1.toString();
        r13.statNormalRequest(r3, r8, r14, r1);
        goto L_0x02f3;
    L_0x02b9:
        r8 = r14;
        goto L_0x02f4;
    L_0x02bb:
        if (r13 == 0) goto L_0x02f3;
    L_0x02bd:
        r3 = r6[r5];
        r8 = 0;
        r15 = r3[r8];
        r16 = "fail";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r9);
        r14 = "";
        r3.append(r14);
        r17 = r3.toString();
        r19 = com.ximalaya.ting.android.player.StaticConfig.mUseragent;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r11);
        r14 = "";
        r3.append(r14);
        r20 = r3.toString();
        r21 = r1.toString();
        r14 = r13;
        r18 = r10;
        r14.addHttpDnsEvent(r15, r16, r17, r18, r19, r20, r21);
        goto L_0x02f4;
    L_0x02f3:
        r8 = 0;
    L_0x02f4:
        r14 = r11;
    L_0x02f5:
        r5 = r5 + 1;
        r1 = r2;
        r11 = r7;
        r12 = r23;
        r8 = r24;
        r3 = r28;
        r2 = r27;
        goto L_0x0044;
    L_0x0303:
        r22 = r8;
        if (r13 == 0) goto L_0x030a;
    L_0x0307:
        r13.endAllHttpDnsRequest();
    L_0x030a:
        return r22;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.PlayerUtil.getConnectionUseDnsCache(java.lang.String[], java.lang.String, int, boolean, java.lang.String):java.net.HttpURLConnection");
    }

    public static String getCpuInfo() {
        if (!TextUtils.isEmpty(cpuInfo)) {
            return cpuInfo;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            String[] split = bufferedReader.readLine().split("\\s+");
            for (int i = 2; i < split.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(cpuInfo);
                stringBuilder.append(split[i]);
                stringBuilder.append(" ");
                cpuInfo = stringBuilder.toString();
            }
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return cpuInfo;
    }

    public static HttpURLConnection getHttpURLConnection(String str, String str2, Map<String, String> map) throws IOException {
        return getHttpURLConnection(str, true, str2, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ca  */
    public static java.net.HttpURLConnection getHttpURLConnection(java.lang.String r4, boolean r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) throws java.io.IOException {
        /*
        r0 = java.lang.System.out;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "PlayerUtil.getHttpURLConnection  ";
        r1.append(r2);
        r1.append(r4);
        r1 = r1.toString();
        r0.println(r1);
        r0 = new java.net.URL;
        r0.<init>(r4);
        r1 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;
        if (r1 == 0) goto L_0x00c7;
    L_0x001f:
        if (r5 == 0) goto L_0x00c7;
    L_0x0021:
        r5 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;
        r5 = r5.mGetHttpUrlConnectByUrl;
        if (r5 == 0) goto L_0x0035;
    L_0x0027:
        r5 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;
        r5 = r5.mGetHttpUrlConnectByUrl;
        r1 = createPlayerConfig(r7);
        r4 = r5.getHttpUrlConnect(r4, r6, r1);
        goto L_0x00c8;
    L_0x0035:
        r4 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;
        r4 = r4.proxyHost;
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x00c7;
    L_0x003f:
        r4 = new java.net.Proxy;
        r5 = java.net.Proxy.Type.HTTP;
        r1 = new java.net.InetSocketAddress;
        r2 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;
        r2 = r2.proxyHost;
        r3 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;
        r3 = r3.proxyPort;
        r1.<init>(r2, r3);
        r4.<init>(r5, r1);
        r4 = r0.openConnection(r4);
        r4 = (java.net.HttpURLConnection) r4;
        r4.setRequestMethod(r6);
        r5 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;
        r5 = r5.authorization;
        r5 = android.text.TextUtils.isEmpty(r5);
        if (r5 != 0) goto L_0x006f;
    L_0x0066:
        r5 = "Authorization";
        r1 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;
        r1 = r1.authorization;
        r4.setRequestProperty(r5, r1);
    L_0x006f:
        if (r7 == 0) goto L_0x0097;
    L_0x0071:
        r5 = r7.entrySet();
        r5 = r5.iterator();
    L_0x0079:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x0097;
    L_0x007f:
        r1 = r5.next();
        r1 = (java.util.Map.Entry) r1;
        if (r1 == 0) goto L_0x0079;
    L_0x0087:
        r2 = r1.getKey();
        r2 = (java.lang.String) r2;
        r1 = r1.getValue();
        r1 = (java.lang.String) r1;
        r4.setRequestProperty(r2, r1);
        goto L_0x0079;
    L_0x0097:
        r5 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;
        r5 = r5.property;
        if (r5 == 0) goto L_0x00c8;
    L_0x009d:
        r5 = com.ximalaya.ting.android.player.StaticConfig.mHttpConfig;
        r5 = r5.property;
        r5 = r5.entrySet();
        r5 = r5.iterator();
    L_0x00a9:
        r1 = r5.hasNext();
        if (r1 == 0) goto L_0x00c8;
    L_0x00af:
        r1 = r5.next();
        r1 = (java.util.Map.Entry) r1;
        if (r1 == 0) goto L_0x00a9;
    L_0x00b7:
        r2 = r1.getKey();
        r2 = (java.lang.String) r2;
        r1 = r1.getValue();
        r1 = (java.lang.String) r1;
        r4.setRequestProperty(r2, r1);
        goto L_0x00a9;
    L_0x00c7:
        r4 = 0;
    L_0x00c8:
        if (r4 != 0) goto L_0x0146;
    L_0x00ca:
        r4 = r0.openConnection();
        r4 = (java.net.HttpURLConnection) r4;
        r5 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r4.setConnectTimeout(r5);
        r4.setReadTimeout(r5);
        r5 = 1;
        r4.setUseCaches(r5);
        r4.setRequestMethod(r6);
        r5 = com.ximalaya.ting.android.player.StaticConfig.mUseragent;
        if (r5 == 0) goto L_0x00ea;
    L_0x00e3:
        r5 = "User-Agent";
        r6 = com.ximalaya.ting.android.player.StaticConfig.mUseragent;
        r4.setRequestProperty(r5, r6);
    L_0x00ea:
        r5 = com.ximalaya.ting.android.player.StaticConfig.mHeads;
        if (r5 == 0) goto L_0x011e;
    L_0x00ee:
        r5 = com.ximalaya.ting.android.player.StaticConfig.mHeads;
        r5 = r5.size();
        if (r5 <= 0) goto L_0x011e;
    L_0x00f6:
        r5 = com.ximalaya.ting.android.player.StaticConfig.mHeads;
        r5 = r5.entrySet();
        r5 = r5.iterator();
    L_0x0100:
        r6 = r5.hasNext();
        if (r6 == 0) goto L_0x011e;
    L_0x0106:
        r6 = r5.next();
        r6 = (java.util.Map.Entry) r6;
        if (r6 == 0) goto L_0x0100;
    L_0x010e:
        r0 = r6.getKey();
        r0 = (java.lang.String) r0;
        r6 = r6.getValue();
        r6 = (java.lang.String) r6;
        r4.setRequestProperty(r0, r6);
        goto L_0x0100;
    L_0x011e:
        if (r7 == 0) goto L_0x0146;
    L_0x0120:
        r5 = r7.entrySet();
        r5 = r5.iterator();
    L_0x0128:
        r6 = r5.hasNext();
        if (r6 == 0) goto L_0x0146;
    L_0x012e:
        r6 = r5.next();
        r6 = (java.util.Map.Entry) r6;
        if (r6 == 0) goto L_0x0128;
    L_0x0136:
        r7 = r6.getKey();
        r7 = (java.lang.String) r7;
        r6 = r6.getValue();
        r6 = (java.lang.String) r6;
        r4.setRequestProperty(r7, r6);
        goto L_0x0128;
    L_0x0146:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.PlayerUtil.getHttpURLConnection(java.lang.String, boolean, java.lang.String, java.util.Map):java.net.HttpURLConnection");
    }

    public static final long getPlayCacheSize() {
        return checkSdcard() ? 0 + sizeOfDirectory(new File(XMediaPlayerConstants.INCOM_AUDIO_FILE_DIRECTORY)) : 0;
    }

    public static boolean isArmV7Plus() {
        String arrays;
        if (VERSION.SDK_INT >= 21) {
            arrays = Arrays.toString(Build.SUPPORTED_ABIS);
        } else {
            arrays = Build.CPU_ABI;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(arrays);
            stringBuilder.append(Build.CPU_ABI2);
            arrays = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("supportAbi:");
        stringBuilder2.append(arrays);
        Log.i("os.arch", stringBuilder2.toString());
        return arrays != null && (arrays.contains("armeabi-v7a") || arrays.contains("arm64-v8a"));
    }

    public static boolean isConnectNetwork(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isLocalFile(String str) {
        return str == null || !str.startsWith("http://");
    }

    public static boolean isNEON() {
        String cPUInfos = getCPUInfos();
        if (cPUInfos == null) {
            return false;
        }
        cPUInfos = cPUInfos.toLowerCase();
        return cPUInfos != null && cPUInfos.contains("neon");
    }

    public static boolean isX86Arch() {
        String property = System.getProperty("os.arch");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(property);
        stringBuilder.append("000");
        Log.i("os.arch", stringBuilder.toString());
        if (property == null || !property.contains("86")) {
            return false;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(property);
        stringBuilder.append("111");
        Log.i("os.arch", stringBuilder.toString());
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0047 A:{SYNTHETIC, Splitter:B:26:0x0047} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0053 A:{SYNTHETIC, Splitter:B:33:0x0053} */
    public static java.lang.String readStrFromFile(java.lang.String r3) {
        /*
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 != 0) goto L_0x005c;
    L_0x0007:
        r0 = new java.io.File;
        r0.<init>(r3);
        r0 = r0.exists();
        if (r0 != 0) goto L_0x0013;
    L_0x0012:
        goto L_0x005c;
    L_0x0013:
        r0 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0040, all -> 0x003d }
        r2 = new java.io.FileReader;	 Catch:{ Exception -> 0x0040, all -> 0x003d }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0040, all -> 0x003d }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0040, all -> 0x003d }
        r3 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x003b }
        r3.<init>();	 Catch:{ Exception -> 0x003b }
    L_0x0022:
        r2 = r0.readLine();	 Catch:{ Exception -> 0x003b }
        if (r2 == 0) goto L_0x002c;
    L_0x0028:
        r3.append(r2);	 Catch:{ Exception -> 0x003b }
        goto L_0x0022;
    L_0x002c:
        r3 = r3.toString();	 Catch:{ Exception -> 0x003b }
        if (r0 == 0) goto L_0x003a;
    L_0x0032:
        r0.close();	 Catch:{ IOException -> 0x0036 }
        goto L_0x003a;
    L_0x0036:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x003a:
        return r3;
    L_0x003b:
        r3 = move-exception;
        goto L_0x0042;
    L_0x003d:
        r3 = move-exception;
        r0 = r1;
        goto L_0x0051;
    L_0x0040:
        r3 = move-exception;
        r0 = r1;
    L_0x0042:
        r3.printStackTrace();	 Catch:{ all -> 0x0050 }
        if (r0 == 0) goto L_0x004f;
    L_0x0047:
        r0.close();	 Catch:{ IOException -> 0x004b }
        goto L_0x004f;
    L_0x004b:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x004f:
        return r1;
    L_0x0050:
        r3 = move-exception;
    L_0x0051:
        if (r0 == 0) goto L_0x005b;
    L_0x0053:
        r0.close();	 Catch:{ IOException -> 0x0057 }
        goto L_0x005b;
    L_0x0057:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x005b:
        throw r3;
    L_0x005c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.PlayerUtil.readStrFromFile(java.lang.String):java.lang.String");
    }

    public static void releaseHttpUrlConnection(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public static long sizeOfDirectory(File file) {
        long j = 0;
        if (file == null || !file.exists()) {
            return 0;
        }
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            String str = null;
            StringBuilder stringBuilder;
            if (!file.exists()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(file);
                stringBuilder.append(" does not exist");
                str = stringBuilder.toString();
            } else if (!file.isDirectory()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(file);
                stringBuilder.append(" is not a directory");
                str = stringBuilder.toString();
            }
            return str != null ? 0 : 0;
        } else {
            for (File file2 : listFiles) {
                j = file2.isDirectory() ? j + sizeOfDirectory(file2) : j + file2.length();
            }
            return j;
        }
    }

    public static void writeFile(String str, byte[] bArr, int i) {
        try {
            if (str.contains("http")) {
                str = str.substring(str.length() - 10, str.length());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder.append("/ting/");
            stringBuilder.append(str);
            File file = new File(stringBuilder.toString());
            file.getParentFile().mkdirs();
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032 A:{SYNTHETIC, Splitter:B:21:0x0032} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003d A:{SYNTHETIC, Splitter:B:27:0x003d} */
    public static void writeStr2File(java.lang.String r3, java.lang.String r4) {
        /*
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 != 0) goto L_0x0046;
    L_0x0006:
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        goto L_0x0046;
    L_0x000d:
        fileIsExistCreate(r4);
        r0 = 0;
        r1 = new java.io.BufferedWriter;	 Catch:{ Exception -> 0x002c }
        r2 = new java.io.FileWriter;	 Catch:{ Exception -> 0x002c }
        r2.<init>(r4);	 Catch:{ Exception -> 0x002c }
        r1.<init>(r2);	 Catch:{ Exception -> 0x002c }
        r1.write(r3);	 Catch:{ Exception -> 0x0027, all -> 0x0024 }
        if (r1 == 0) goto L_0x003a;
    L_0x0020:
        r1.close();	 Catch:{ IOException -> 0x0036 }
        goto L_0x003a;
    L_0x0024:
        r3 = move-exception;
        r0 = r1;
        goto L_0x003b;
    L_0x0027:
        r3 = move-exception;
        r0 = r1;
        goto L_0x002d;
    L_0x002a:
        r3 = move-exception;
        goto L_0x003b;
    L_0x002c:
        r3 = move-exception;
    L_0x002d:
        r3.printStackTrace();	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x003a;
    L_0x0032:
        r0.close();	 Catch:{ IOException -> 0x0036 }
        goto L_0x003a;
    L_0x0036:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x003a:
        return;
    L_0x003b:
        if (r0 == 0) goto L_0x0045;
    L_0x003d:
        r0.close();	 Catch:{ IOException -> 0x0041 }
        goto L_0x0045;
    L_0x0041:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0045:
        throw r3;
    L_0x0046:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.PlayerUtil.writeStr2File(java.lang.String, java.lang.String):void");
    }
}
