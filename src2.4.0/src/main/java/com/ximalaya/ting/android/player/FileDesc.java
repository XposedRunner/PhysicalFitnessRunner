package com.ximalaya.ting.android.player;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;

public class FileDesc {
    private static final String TAG = "dl_mp3";
    public volatile BitSet chunkExist;
    private int chunkNum;
    public volatile ArrayList<Integer> chunkOffset;
    private int comChunkNum;
    private long comFileLen;
    private String dirPath;
    public volatile ArrayList<Integer> downloadedChunks;
    private String eTag;
    public volatile int statusCode;
    private String url;
    public volatile boolean valid = false;

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013c  */
    /* JADX WARNING: Missing block: B:26:0x00fb, code skipped:
            if (r2 != null) goto L_0x012f;
     */
    /* JADX WARNING: Missing block: B:49:0x012d, code skipped:
            if (r2 != null) goto L_0x012f;
     */
    /* JADX WARNING: Missing block: B:50:0x012f, code skipped:
            r2.close();
     */
    public FileDesc(java.lang.String r11, java.lang.String r12) throws java.io.IOException {
        /*
        r10 = this;
        r10.<init>();
        r0 = 0;
        r10.valid = r0;
        r1 = "dl_mp3";
        r2 = "======================FileDesc Constructor()";
        com.ximalaya.ting.android.player.Logger.log(r1, r2);
        r10.dirPath = r11;
        r10.url = r12;
        r10.createCacheDir();
        r1 = com.ximalaya.ting.android.player.MD5.getFileNameMd5(r12);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r11);
        r3 = "/";
        r2.append(r3);
        r2.append(r1);
        r3 = ".index";
        r2.append(r3);
        r2 = r2.toString();
        r3 = new java.io.File;
        r3.<init>(r2);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r11);
        r5 = "/";
        r4.append(r5);
        r4.append(r1);
        r1 = ".chunk";
        r4.append(r1);
        r1 = r4.toString();
        r4 = new java.io.File;
        r4.<init>(r1);
        r1 = r3.exists();
        r5 = r4.exists();
        if (r1 == r5) goto L_0x0064;
    L_0x005e:
        r3.delete();
        r4.delete();
    L_0x0064:
        r1 = r3.exists();
        if (r1 != 0) goto L_0x006f;
    L_0x006a:
        r10.initFileDescFormNet(r11, r12);
        goto L_0x0132;
    L_0x006f:
        r1 = 0;
        r5 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x011e, all -> 0x011a }
        r5.<init>(r2);	 Catch:{ Exception -> 0x011e, all -> 0x011a }
        r2 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0117, all -> 0x0114 }
        r2.<init>(r5);	 Catch:{ Exception -> 0x0117, all -> 0x0114 }
        r1 = r2.readUTF();	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r10.url = r1;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r1 = r10.url;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        if (r1 == 0) goto L_0x00fe;
    L_0x0084:
        r1 = r10.url;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r1 = com.ximalaya.ting.android.player.MD5.getFileNameMd5(r1);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r6 = com.ximalaya.ting.android.player.MD5.getFileNameMd5(r12);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r1 = r1.equals(r6);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        if (r1 != 0) goto L_0x0095;
    L_0x0094:
        goto L_0x00fe;
    L_0x0095:
        r6 = r2.readLong();	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r10.comFileLen = r6;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r1 = r2.readUTF();	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r10.eTag = r1;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r6 = r10.comFileLen;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r1 = (float) r6;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r6 = 1199570944; // 0x47800000 float:65536.0 double:5.92666793E-315;
        r1 = r1 / r6;
        r6 = (double) r1;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r6 = java.lang.Math.ceil(r6);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r1 = (int) r6;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r6 = "dl_mp3";
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r7.<init>();	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r8 = "calc002==comChunkNum==:";
        r7.append(r8);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r8 = r10.comFileLen;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r7.append(r8);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r8 = ", ";
        r7.append(r8);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r7.append(r1);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        com.ximalaya.ting.android.player.Logger.log(r6, r7);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r10.comChunkNum = r1;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r6 = r2.readInt();	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r10.chunkNum = r6;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r6 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r6.<init>();	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
    L_0x00da:
        r7 = r10.chunkNum;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        if (r0 >= r7) goto L_0x00ec;
    L_0x00de:
        r7 = r2.readInt();	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r6.add(r7);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r0 = r0 + 1;
        goto L_0x00da;
    L_0x00ec:
        r0 = r10.comChunkNum;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        if (r0 <= 0) goto L_0x00f6;
    L_0x00f0:
        r0 = 1;
        r10.valid = r0;	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r10.initFromArray(r6, r1);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
    L_0x00f6:
        if (r5 == 0) goto L_0x00fb;
    L_0x00f8:
        r5.close();
    L_0x00fb:
        if (r2 == 0) goto L_0x0132;
    L_0x00fd:
        goto L_0x012f;
    L_0x00fe:
        r3.delete();	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r4.delete();	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        r10.initFileDescFormNet(r11, r12);	 Catch:{ Exception -> 0x0118, all -> 0x0112 }
        if (r5 == 0) goto L_0x010c;
    L_0x0109:
        r5.close();
    L_0x010c:
        if (r2 == 0) goto L_0x0111;
    L_0x010e:
        r2.close();
    L_0x0111:
        return;
    L_0x0112:
        r11 = move-exception;
        goto L_0x0135;
    L_0x0114:
        r11 = move-exception;
        r2 = r1;
        goto L_0x0135;
    L_0x0117:
        r2 = r1;
    L_0x0118:
        r1 = r5;
        goto L_0x011f;
    L_0x011a:
        r11 = move-exception;
        r2 = r1;
        r5 = r2;
        goto L_0x0135;
    L_0x011e:
        r2 = r1;
    L_0x011f:
        r3.delete();	 Catch:{ all -> 0x0133 }
        r4.delete();	 Catch:{ all -> 0x0133 }
        r10.initFileDescFormNet(r11, r12);	 Catch:{ all -> 0x0133 }
        if (r1 == 0) goto L_0x012d;
    L_0x012a:
        r1.close();
    L_0x012d:
        if (r2 == 0) goto L_0x0132;
    L_0x012f:
        r2.close();
    L_0x0132:
        return;
    L_0x0133:
        r11 = move-exception;
        r5 = r1;
    L_0x0135:
        if (r5 == 0) goto L_0x013a;
    L_0x0137:
        r5.close();
    L_0x013a:
        if (r2 == 0) goto L_0x013f;
    L_0x013c:
        r2.close();
    L_0x013f:
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.FileDesc.<init>(java.lang.String, java.lang.String):void");
    }

    private boolean createCacheDir() {
        File file = new File(XMediaPlayerConstants.INCOM_AUDIO_FILE_DIRECTORY);
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("目录不存在，创建失败！");
        stringBuilder.append(XMediaPlayerConstants.INCOM_AUDIO_FILE_DIRECTORY);
        Logger.log(str, stringBuilder.toString());
        return false;
    }

    private void initFromArray(ArrayList<Integer> arrayList, int i) {
        this.chunkExist = new BitSet(i);
        this.chunkOffset = new ArrayList(i);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            this.chunkOffset.add(i3, Integer.valueOf(-1));
        }
        this.downloadedChunks = arrayList;
        while (i2 < arrayList.size()) {
            this.chunkExist.set(((Integer) arrayList.get(i2)).intValue());
            this.chunkOffset.set(((Integer) arrayList.get(i2)).intValue(), Integer.valueOf(i2));
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        boolean z = false;
        if (!(obj instanceof FileDesc)) {
            return false;
        }
        FileDesc fileDesc = (FileDesc) obj;
        String url = getUrl();
        if (url != null) {
            z = url.equals(fileDesc.getUrl());
        }
        return z;
    }

    public int getComChunkNum() {
        return this.comChunkNum;
    }

    public int getComFileLen() {
        return (int) this.comFileLen;
    }

    public synchronized int getDownloadedChunks() {
        if (this.downloadedChunks == null) {
            return 0;
        }
        return this.downloadedChunks.size();
    }

    public String getETag() {
        return this.eTag;
    }

    public int getErrorCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url == null ? 0 : this.url.hashCode();
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x019e A:{Splitter:B:10:0x0030, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:64:0x019e, code skipped:
            r12 = th;
     */
    /* JADX WARNING: Missing block: B:65:0x01a0, code skipped:
            r3 = e;
     */
    /* JADX WARNING: Missing block: B:73:0x01bc, code skipped:
            r5.disconnect();
     */
    /* JADX WARNING: Missing block: B:75:0x01c1, code skipped:
            com.ximalaya.ting.android.player.cdn.CdnUtil.statToXDCSError(com.ximalaya.ting.android.player.cdn.CdnConstants.CDN_HEAD_INFO_KEY, r1.toString());
     */
    public void initFileDescFormNet(java.lang.String r12, java.lang.String r13) throws java.io.IOException {
        /*
        r11 = this;
        r0 = java.util.UUID.randomUUID();
        r0 = r0.toString();
        r1 = 3;
    L_0x0009:
        r2 = r1 + -1;
        r3 = 1;
        r4 = 0;
        if (r1 <= 0) goto L_0x0220;
    L_0x000f:
        r1 = new com.ximalaya.ting.android.player.cdn.CdnCollectDataForPlay;
        r1.<init>();
        r5 = 0;
        r6 = new java.lang.String[r3];	 Catch:{ Exception -> 0x01a6 }
        r6[r4] = r13;	 Catch:{ Exception -> 0x01a6 }
        r7 = android.text.TextUtils.isEmpty(r13);	 Catch:{ Exception -> 0x01a6 }
        if (r7 == 0) goto L_0x0022;
    L_0x001f:
        r7 = "";
        goto L_0x002a;
    L_0x0022:
        r7 = android.net.Uri.parse(r13);	 Catch:{ Exception -> 0x01a6 }
        r7 = r7.getHost();	 Catch:{ Exception -> 0x01a6 }
    L_0x002a:
        r8 = "HEAD";
        r8 = com.ximalaya.ting.android.player.PlayerUtil.getConnectionUseDnsCache(r6, r5, r3, r4, r8);	 Catch:{ Exception -> 0x01a6 }
        r5 = r6[r4];	 Catch:{ Exception -> 0x01a0, all -> 0x019e }
        if (r8 != 0) goto L_0x0068;
    L_0x0034:
        if (r8 == 0) goto L_0x0039;
    L_0x0036:
        r8.disconnect();
    L_0x0039:
        if (r1 == 0) goto L_0x0044;
    L_0x003b:
        r13 = "cdn_head_info";
        r3 = r1.toString();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statToXDCSError(r13, r3);
    L_0x0044:
        if (r1 == 0) goto L_0x0065;
    L_0x0046:
        r13 = r11.valid;
        if (r13 != 0) goto L_0x0065;
    L_0x004a:
        r13 = r1.getErrorType();
        r13 = android.text.TextUtils.isEmpty(r13);
        if (r13 != 0) goto L_0x0065;
    L_0x0054:
        r13 = r1.getExceptionReason();
        r13 = android.text.TextUtils.isEmpty(r13);
        if (r13 != 0) goto L_0x0065;
    L_0x005e:
        r13 = com.ximalaya.ting.android.player.cdn.CdnUtil.getCdnConfigModel();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r1, r13);
    L_0x0065:
        r1 = r2;
        r13 = r5;
        goto L_0x0009;
    L_0x0068:
        r13 = r8.getResponseCode();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r11.statusCode = r13;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = "play_head_fail";
        r1.setType(r13);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = r8.getURL();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = r13.toString();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r1.setAudioUrl(r13);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = com.ximalaya.ting.android.player.cdn.CdnUtil.getUrlIp(r13);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r1.setCdnIP(r13);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = "via";
        r13 = r8.getHeaderField(r13);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r1.setViaInfo(r13);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13.<init>();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = r11.statusCode;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13.append(r6);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = "";
        r13.append(r6);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = r13.toString();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r1.setStatusCode(r13);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r1.setCdnDomain(r7);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r1.setRequestUUID(r0);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = r11.statusCode;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r13 < r6) goto L_0x00ee;
    L_0x00b0:
        r13 = "dl_mp3";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r3.<init>();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = "Error response code for get head for url: ";
        r3.append(r6);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r3.append(r5);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = ",status code is: ";
        r3.append(r6);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = r11.statusCode;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r3.append(r6);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = " in handler thread";
        r3.append(r6);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r3 = r3.toString();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        com.ximalaya.ting.android.player.Logger.w(r13, r3);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = new java.io.IOException;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r3.<init>();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = "http response status code is: ";
        r3.append(r6);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = r11.statusCode;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r3.append(r6);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r3 = r3.toString();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13.<init>(r3);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        throw r13;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
    L_0x00ee:
        r11.valid = r3;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = r8.getContentLength();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = (long) r13;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r11.comFileLen = r6;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = r11.comFileLen;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r1.setAudioBytes(r6);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = "dl_mp3";
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6.<init>();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r7 = "conn.getContentLength():";
        r6.append(r7);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r9 = r11.comFileLen;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6.append(r9);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = r6.toString();	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        com.ximalaya.ting.android.player.Logger.log(r13, r6);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r6 = r11.comFileLen;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r9 = 0;
        r13 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1));
        if (r13 > 0) goto L_0x0128;
    L_0x011c:
        r13 = "cdn_unknown_exception";
        r1.setErrorType(r13);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = "head request comFileLen<=0";
        r1.setExceptionReason(r13);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r11.valid = r4;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
    L_0x0128:
        r13 = "ETag";
        r13 = r8.getHeaderField(r13);	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r11.eTag = r13;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        r13 = r11.valid;	 Catch:{ Exception -> 0x019b, all -> 0x019e }
        if (r13 == 0) goto L_0x0168;
    L_0x0134:
        if (r8 == 0) goto L_0x0139;
    L_0x0136:
        r8.disconnect();
    L_0x0139:
        if (r1 == 0) goto L_0x0144;
    L_0x013b:
        r13 = "cdn_head_info";
        r0 = r1.toString();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statToXDCSError(r13, r0);
    L_0x0144:
        if (r1 == 0) goto L_0x0165;
    L_0x0146:
        r13 = r11.valid;
        if (r13 != 0) goto L_0x0165;
    L_0x014a:
        r13 = r1.getErrorType();
        r13 = android.text.TextUtils.isEmpty(r13);
        if (r13 != 0) goto L_0x0165;
    L_0x0154:
        r13 = r1.getExceptionReason();
        r13 = android.text.TextUtils.isEmpty(r13);
        if (r13 != 0) goto L_0x0165;
    L_0x015e:
        r13 = com.ximalaya.ting.android.player.cdn.CdnUtil.getCdnConfigModel();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r1, r13);
    L_0x0165:
        r13 = r5;
        goto L_0x0220;
    L_0x0168:
        if (r8 == 0) goto L_0x016d;
    L_0x016a:
        r8.disconnect();
    L_0x016d:
        if (r1 == 0) goto L_0x0178;
    L_0x016f:
        r13 = "cdn_head_info";
        r3 = r1.toString();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statToXDCSError(r13, r3);
    L_0x0178:
        if (r1 == 0) goto L_0x0199;
    L_0x017a:
        r13 = r11.valid;
        if (r13 != 0) goto L_0x0199;
    L_0x017e:
        r13 = r1.getErrorType();
        r13 = android.text.TextUtils.isEmpty(r13);
        if (r13 != 0) goto L_0x0199;
    L_0x0188:
        r13 = r1.getExceptionReason();
        r13 = android.text.TextUtils.isEmpty(r13);
        if (r13 != 0) goto L_0x0199;
    L_0x0192:
        r13 = com.ximalaya.ting.android.player.cdn.CdnUtil.getCdnConfigModel();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r1, r13);
    L_0x0199:
        r13 = r5;
        goto L_0x01eb;
    L_0x019b:
        r3 = move-exception;
        r13 = r5;
        goto L_0x01a1;
    L_0x019e:
        r12 = move-exception;
        goto L_0x01ee;
    L_0x01a0:
        r3 = move-exception;
    L_0x01a1:
        r5 = r8;
        goto L_0x01a7;
    L_0x01a3:
        r12 = move-exception;
        r8 = r5;
        goto L_0x01ee;
    L_0x01a6:
        r3 = move-exception;
    L_0x01a7:
        r11.valid = r4;	 Catch:{ all -> 0x01a3 }
        r4 = "cdn_io_exception";
        r1.setErrorType(r4);	 Catch:{ all -> 0x01a3 }
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x01a3 }
        r1.setExceptionReason(r3);	 Catch:{ all -> 0x01a3 }
        r3 = "failed";
        r1.setDownloadResult(r3);	 Catch:{ all -> 0x01a3 }
        if (r5 == 0) goto L_0x01bf;
    L_0x01bc:
        r5.disconnect();
    L_0x01bf:
        if (r1 == 0) goto L_0x01ca;
    L_0x01c1:
        r3 = "cdn_head_info";
        r4 = r1.toString();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statToXDCSError(r3, r4);
    L_0x01ca:
        if (r1 == 0) goto L_0x01eb;
    L_0x01cc:
        r3 = r11.valid;
        if (r3 != 0) goto L_0x01eb;
    L_0x01d0:
        r3 = r1.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x01eb;
    L_0x01da:
        r3 = r1.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x01eb;
    L_0x01e4:
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.getCdnConfigModel();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r1, r3);
    L_0x01eb:
        r1 = r2;
        goto L_0x0009;
    L_0x01ee:
        if (r8 == 0) goto L_0x01f3;
    L_0x01f0:
        r8.disconnect();
    L_0x01f3:
        if (r1 == 0) goto L_0x01fe;
    L_0x01f5:
        r13 = "cdn_head_info";
        r0 = r1.toString();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statToXDCSError(r13, r0);
    L_0x01fe:
        if (r1 == 0) goto L_0x021f;
    L_0x0200:
        r13 = r11.valid;
        if (r13 != 0) goto L_0x021f;
    L_0x0204:
        r13 = r1.getErrorType();
        r13 = android.text.TextUtils.isEmpty(r13);
        if (r13 != 0) goto L_0x021f;
    L_0x020e:
        r13 = r1.getExceptionReason();
        r13 = android.text.TextUtils.isEmpty(r13);
        if (r13 != 0) goto L_0x021f;
    L_0x0218:
        r13 = com.ximalaya.ting.android.player.cdn.CdnUtil.getCdnConfigModel();
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r1, r13);
    L_0x021f:
        throw r12;
    L_0x0220:
        r0 = r11.valid;
        if (r0 != 0) goto L_0x0251;
    L_0x0224:
        r12 = "dl_mp3";
        r13 = new java.lang.StringBuilder;
        r13.<init>();
        r0 = "valid0:";
        r13.append(r0);
        r0 = r11.valid;
        r13.append(r0);
        r0 = "comFileLen:";
        r13.append(r0);
        r0 = r11.comFileLen;
        r13.append(r0);
        r0 = "statusCode:";
        r13.append(r0);
        r0 = r11.statusCode;
        r13.append(r0);
        r13 = r13.toString();
        com.ximalaya.ting.android.player.Logger.log(r12, r13);
        return;
    L_0x0251:
        r0 = "dl_mp3";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "valid1:";
        r1.append(r2);
        r2 = r11.valid;
        r1.append(r2);
        r2 = "comFileLen:";
        r1.append(r2);
        r5 = r11.comFileLen;
        r1.append(r5);
        r2 = "statusCode:";
        r1.append(r2);
        r2 = r11.statusCode;
        r1.append(r2);
        r1 = r1.toString();
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        r0 = r11.comFileLen;
        r0 = (float) r0;
        r1 = 1199570944; // 0x47800000 float:65536.0 double:5.92666793E-315;
        r0 = r0 / r1;
        r0 = (double) r0;
        r0 = java.lang.Math.ceil(r0);
        r0 = (int) r0;
        r11.comChunkNum = r0;
        r0 = "dl_mp3";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "calc001==comFileLen==:";
        r1.append(r2);
        r5 = r11.comFileLen;
        r1.append(r5);
        r2 = ",comChunkNum:";
        r1.append(r2);
        r2 = r11.comChunkNum;
        r1.append(r2);
        r2 = "statusCode:";
        r1.append(r2);
        r2 = r11.statusCode;
        r1.append(r2);
        r1 = r1.toString();
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        r11.chunkNum = r4;
        r0 = new java.util.BitSet;
        r1 = r11.comChunkNum;
        r0.<init>(r1);
        r11.chunkExist = r0;
        r0 = r11.comChunkNum;
        if (r0 <= 0) goto L_0x02f1;
    L_0x02c6:
        r0 = new java.util.ArrayList;
        r1 = r11.comChunkNum;
        r0.<init>(r1);
        r11.chunkOffset = r0;
    L_0x02cf:
        r0 = r11.comChunkNum;
        if (r4 >= r0) goto L_0x02e0;
    L_0x02d3:
        r0 = r11.chunkOffset;
        r1 = -1;
        r1 = java.lang.Integer.valueOf(r1);
        r0.add(r4, r1);
        r4 = r4 + 1;
        goto L_0x02cf;
    L_0x02e0:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r11.downloadedChunks = r0;
        r13 = com.ximalaya.ting.android.player.MD5.getFileNameMd5(r13);
        r11.saveDescHeadToDisk(r12, r13);
        r11.valid = r3;
        goto L_0x02f7;
    L_0x02f1:
        r11.valid = r4;
        r12 = 408; // 0x198 float:5.72E-43 double:2.016E-321;
        r11.statusCode = r12;
    L_0x02f7:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.FileDesc.initFileDescFormNet(java.lang.String, java.lang.String):void");
    }

    public synchronized boolean isChunkDownloaded(int i) {
        boolean z;
        z = false;
        if (this.chunkExist != null && i >= 0 && i < this.chunkExist.length()) {
            z = this.chunkExist.get(i);
        }
        return z;
    }

    public boolean isIndexAvaliable(int i) {
        return this.chunkExist != null && i >= 0 && i < this.chunkExist.length();
    }

    public boolean isValid() {
        return this.valid && this.comChunkNum > 0;
    }

    public synchronized void saveDescHeadToDisk(String str, String str2) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("saveDescHeadToDisk(");
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(str2);
        stringBuilder.append(", ");
        stringBuilder.append(this.comFileLen);
        stringBuilder.append(")");
        Logger.log(str3, stringBuilder.toString());
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("/");
            stringBuilder.append(str2);
            stringBuilder.append(".index");
            FileOutputStream fileOutputStream = new FileOutputStream(stringBuilder.toString(), false);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeUTF(this.url);
            dataOutputStream.writeLong(this.comFileLen);
            dataOutputStream.writeUTF(this.eTag == null ? "" : this.eTag);
            dataOutputStream.writeInt(0);
            dataOutputStream.flush();
            dataOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("exception: saveDescHeadToDisk");
            stringBuilder2.append(e.getMessage());
            Logger.log(str2, stringBuilder2.toString());
        }
        return;
    }

    public synchronized boolean saveDescToDisk(String str, String str2) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("======================saveDescToDisk(");
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(str2);
        stringBuilder.append(")");
        Logger.log(str3, stringBuilder.toString());
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append("/");
            stringBuilder2.append(str2);
            stringBuilder2.append(".index");
            FileOutputStream fileOutputStream = new FileOutputStream(stringBuilder2.toString(), false);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
            dataOutputStream.writeUTF(this.url);
            dataOutputStream.writeLong(this.comFileLen);
            if (this.eTag == null) {
                str2 = "\"\"";
            } else {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("\"");
                stringBuilder3.append(this.eTag);
                stringBuilder3.append("\"");
                str2 = stringBuilder3.toString();
            }
            dataOutputStream.writeUTF(str2);
            dataOutputStream.writeInt(this.chunkNum);
            Iterator it = this.downloadedChunks.iterator();
            while (it.hasNext()) {
                dataOutputStream.writeInt(((Integer) it.next()).intValue());
            }
            dataOutputStream.flush();
            dataOutputStream.close();
            fileOutputStream.close();
        } catch (Exception unused) {
            return false;
        }
        return true;
    }

    public synchronized void update(int i) {
        if (this.chunkExist != null) {
            int size = this.downloadedChunks.size();
            this.chunkExist.set(i);
            this.chunkOffset.set(i, Integer.valueOf(size));
            this.downloadedChunks.add(Integer.valueOf(i));
            this.chunkNum++;
            saveDescToDisk(this.dirPath, MD5.getFileNameMd5(this.url));
        }
    }
}
