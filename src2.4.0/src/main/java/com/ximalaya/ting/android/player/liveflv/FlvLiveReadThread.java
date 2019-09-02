package com.ximalaya.ting.android.player.liveflv;

import com.ximalaya.ting.android.player.BufferItem;
import com.ximalaya.ting.android.player.Logger;
import com.ximalaya.ting.android.player.XMediaplayerJNI;
import java.util.concurrent.LinkedBlockingQueue;

public class FlvLiveReadThread extends Thread {
    private static final String TAG = "dl_hls";
    private volatile LinkedBlockingQueue<BufferItem> buffItemQueue;
    private boolean isFlvDataCallbackEnable = true;
    private boolean isLiveDelay = false;
    private volatile boolean isStop = false;
    private FlvAacParser mFlvStream;
    long mLimitConnectTime;
    long mLimitDownloadSpeed;
    private String mSourceUrl;
    private XMediaplayerJNI mXMediaplayerJNI;

    public FlvLiveReadThread(XMediaplayerJNI xMediaplayerJNI, String str, LinkedBlockingQueue<BufferItem> linkedBlockingQueue) {
        super("FlvLiveReadThreadForPlayer");
        this.mXMediaplayerJNI = xMediaplayerJNI;
        this.mSourceUrl = str;
        this.buffItemQueue = linkedBlockingQueue;
        this.isStop = false;
        setPriority(10);
    }

    private void putItem(BufferItem bufferItem) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("putItem buffItemQueue.size()0:");
        stringBuilder.append(this.buffItemQueue.size());
        Logger.log(str, stringBuilder.toString());
        if (this.buffItemQueue.remainingCapacity() < 5) {
            this.isLiveDelay = true;
        } else {
            this.isLiveDelay = false;
        }
        try {
            this.buffItemQueue.put(bufferItem);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String str2 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("putItem buffItemQueue.size()1:");
        stringBuilder2.append(this.buffItemQueue.size());
        Logger.log(str2, stringBuilder2.toString());
    }

    public void close() {
        this.isStop = true;
        if (this.buffItemQueue != null) {
            this.buffItemQueue.clear();
        }
        interrupt();
        Logger.log(XMediaplayerJNI.Tag, "HlsReadThread hls readData close");
    }

    public boolean isClose() {
        return this.isStop;
    }

    public boolean isLiveDelay() {
        return this.isLiveDelay;
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x037f A:{SYNTHETIC, Splitter:B:143:0x037f} */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0389  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x042b A:{Catch:{ all -> 0x0500 }} */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0496 A:{Catch:{ all -> 0x04f9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0549 A:{SYNTHETIC, Splitter:B:246:0x0549} */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x042b A:{Catch:{ all -> 0x0500 }} */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0496 A:{Catch:{ all -> 0x04f9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04b8 A:{Catch:{ all -> 0x04f2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0549 A:{SYNTHETIC, Splitter:B:246:0x0549} */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x042b A:{Catch:{ all -> 0x0500 }} */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0496 A:{Catch:{ all -> 0x04f9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04b8 A:{Catch:{ all -> 0x04f2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0549 A:{SYNTHETIC, Splitter:B:246:0x0549} */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d4 A:{PHI: r11 , Splitter:B:39:0x00ae, ExcHandler: all (r0_5 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x042b A:{Catch:{ all -> 0x0500 }} */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0496 A:{Catch:{ all -> 0x04f9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04b8 A:{Catch:{ all -> 0x04f2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0549 A:{SYNTHETIC, Splitter:B:246:0x0549} */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x042b A:{Catch:{ all -> 0x0500 }} */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0496 A:{Catch:{ all -> 0x04f9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04b8 A:{Catch:{ all -> 0x04f2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0549 A:{SYNTHETIC, Splitter:B:246:0x0549} */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x042b A:{Catch:{ all -> 0x0500 }} */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0496 A:{Catch:{ all -> 0x04f9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04b8 A:{Catch:{ all -> 0x04f2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0549 A:{SYNTHETIC, Splitter:B:246:0x0549} */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x042b A:{Catch:{ all -> 0x0500 }} */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0496 A:{Catch:{ all -> 0x04f9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04b8 A:{Catch:{ all -> 0x04f2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0549 A:{SYNTHETIC, Splitter:B:246:0x0549} */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x042b A:{Catch:{ all -> 0x0500 }} */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0496 A:{Catch:{ all -> 0x04f9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04b8 A:{Catch:{ all -> 0x04f2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0549 A:{SYNTHETIC, Splitter:B:246:0x0549} */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x048b  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x042b A:{Catch:{ all -> 0x0500 }} */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0496 A:{Catch:{ all -> 0x04f9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04b8 A:{Catch:{ all -> 0x04f2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x0524  */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x0549 A:{SYNTHETIC, Splitter:B:246:0x0549} */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x03ad A:{Splitter:B:69:0x014a, ExcHandler: all (r0_22 'th' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x057b A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x06da A:{SYNTHETIC, Splitter:B:298:0x06da} */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x06e4  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:41:0x00d4, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:42:0x00d5, code skipped:
            r3 = r0;
            r13 = r6;
            r10 = r11;
     */
    /* JADX WARNING: Missing block: B:44:0x00db, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:45:0x00dc, code skipped:
            r3 = r0;
            r13 = r6;
            r10 = r11;
            r5 = null;
            r15 = com.yalantis.ucrop.view.CropImageView.DEFAULT_ASPECT_RATIO;
            r12 = 0;
     */
    /* JADX WARNING: Missing block: B:158:0x03ad, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:159:0x03ae, code skipped:
            r13 = r6;
            r3 = r0;
            r5 = r4;
     */
    /* JADX WARNING: Missing block: B:161:0x03b3, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:162:0x03b4, code skipped:
            r13 = r6;
            r5 = r4;
            r12 = 0;
     */
    public void run() {
        /*
        r29 = this;
        r1 = r29;
        r2 = r1.isStop;
        if (r2 != 0) goto L_0x0705;
    L_0x0006:
        r2 = r1.mXMediaplayerJNI;
        r2 = r2.getPlayUrl();
        r2 = com.ximalaya.ting.android.player.MD5.getFileNameMd5(r2);
        r3 = r1.mSourceUrl;
        r3 = com.ximalaya.ting.android.player.MD5.getFileNameMd5(r3);
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0705;
    L_0x001c:
        r2 = com.ximalaya.ting.android.player.cdn.CdnUtil.getCdnConfigModel();
        r3 = 0;
        r4 = 0;
        r5 = 1;
        if (r2 != 0) goto L_0x0028;
    L_0x0025:
        r6 = r3;
        r7 = r5;
        goto L_0x003e;
    L_0x0028:
        r6 = new com.ximalaya.ting.android.player.cdn.CdnCollectDataForPlay;
        r6.<init>();
        r7 = "play_flv_live";
        r6.setType(r7);
        r7 = java.util.UUID.randomUUID();
        r7 = r7.toString();
        r6.setRequestUUID(r7);
        r7 = r4;
    L_0x003e:
        r8 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r9 = "flv start run";
        com.ximalaya.ting.android.player.Logger.log(r8, r9);
        r8 = r1.mSourceUrl;
        r8 = android.text.TextUtils.isEmpty(r8);
        if (r8 == 0) goto L_0x0050;
    L_0x004d:
        r8 = "";
        goto L_0x005a;
    L_0x0050:
        r8 = r1.mSourceUrl;
        r8 = android.net.Uri.parse(r8);
        r8 = r8.getHost();
    L_0x005a:
        r9 = new java.lang.String[r5];
        r10 = r1.mSourceUrl;
        r9[r4] = r10;
        r10 = 3;
        r11 = "GET";
        r9 = com.ximalaya.ting.android.player.PlayerUtil.getConnectionUseDnsCache(r9, r3, r10, r4, r11);
        r13 = 0;
        r10 = r1.isStop;	 Catch:{ IOException -> 0x03fb, all -> 0x03f0 }
        if (r10 == 0) goto L_0x0087;
    L_0x006d:
        r8 = new java.io.IOException;	 Catch:{ IOException -> 0x007e, all -> 0x0075 }
        r10 = "Connection timeout flv has stop";
        r8.<init>(r10);	 Catch:{ IOException -> 0x007e, all -> 0x0075 }
        throw r8;	 Catch:{ IOException -> 0x007e, all -> 0x0075 }
    L_0x0075:
        r0 = move-exception;
        r5 = r3;
        r10 = r13;
        r15 = 0;
        r3 = r0;
    L_0x007a:
        r13 = r6;
    L_0x007b:
        r6 = r4;
        goto L_0x0579;
    L_0x007e:
        r0 = move-exception;
        r5 = r3;
        r12 = r4;
        r10 = r13;
        r15 = 0;
        r3 = r0;
    L_0x0084:
        r13 = r6;
        goto L_0x0404;
    L_0x0087:
        r10 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ IOException -> 0x03fb, all -> 0x03f0 }
        r3 = "flv getConnectionUseDnsCache return httpUrlConnection";
        com.ximalaya.ting.android.player.Logger.log(r10, r3);	 Catch:{ IOException -> 0x03fb, all -> 0x03f0 }
        if (r9 != 0) goto L_0x00a5;
    L_0x0090:
        r3 = new java.io.IOException;	 Catch:{ IOException -> 0x009e, all -> 0x0098 }
        r8 = "httpUrlConnection is null";
        r3.<init>(r8);	 Catch:{ IOException -> 0x009e, all -> 0x0098 }
        throw r3;	 Catch:{ IOException -> 0x009e, all -> 0x0098 }
    L_0x0098:
        r0 = move-exception;
        r3 = r0;
        r10 = r13;
        r5 = 0;
        r15 = 0;
        goto L_0x007a;
    L_0x009e:
        r0 = move-exception;
        r3 = r0;
        r12 = r4;
        r10 = r13;
        r5 = 0;
        r15 = 0;
        goto L_0x0084;
    L_0x00a5:
        if (r6 == 0) goto L_0x00e4;
    L_0x00a7:
        r18 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x009e, all -> 0x0098 }
        r11 = r18 - r13;
        r3 = (float) r11;
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r3, r4);	 Catch:{ IOException -> 0x00db, all -> 0x00d4 }
        r6.setConnectedTime(r3);	 Catch:{ IOException -> 0x00db, all -> 0x00d4 }
        r3 = r9.getURL();	 Catch:{ IOException -> 0x00db, all -> 0x00d4 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x00db, all -> 0x00d4 }
        r6.setAudioUrl(r3);	 Catch:{ IOException -> 0x00db, all -> 0x00d4 }
        r6.setCdnDomain(r8);	 Catch:{ IOException -> 0x00db, all -> 0x00d4 }
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.getUrlIp(r3);	 Catch:{ IOException -> 0x00db, all -> 0x00d4 }
        r6.setCdnIP(r3);	 Catch:{ IOException -> 0x00db, all -> 0x00d4 }
        r3 = "via";
        r3 = r9.getHeaderField(r3);	 Catch:{ IOException -> 0x00db, all -> 0x00d4 }
        r6.setViaInfo(r3);	 Catch:{ IOException -> 0x00db, all -> 0x00d4 }
        goto L_0x00e5;
    L_0x00d4:
        r0 = move-exception;
        r3 = r0;
        r13 = r6;
        r10 = r11;
    L_0x00d8:
        r5 = 0;
        r15 = 0;
        goto L_0x007b;
    L_0x00db:
        r0 = move-exception;
        r3 = r0;
        r13 = r6;
        r10 = r11;
        r5 = 0;
        r15 = 0;
        r12 = r4;
        goto L_0x0404;
    L_0x00e4:
        r11 = r13;
    L_0x00e5:
        r3 = r9.getResponseCode();	 Catch:{ IOException -> 0x03e9, all -> 0x03e1 }
        if (r6 == 0) goto L_0x012b;
    L_0x00eb:
        r18 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x0121, all -> 0x00d4 }
        r10 = r18 - r13;
        r8 = (float) r10;
        r8 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r8, r4);	 Catch:{ IOException -> 0x011b, all -> 0x0117 }
        r6.setConnectedTime(r8);	 Catch:{ IOException -> 0x011b, all -> 0x0117 }
        r8 = "via";
        r8 = r9.getHeaderField(r8);	 Catch:{ IOException -> 0x011b, all -> 0x0117 }
        r6.setViaInfo(r8);	 Catch:{ IOException -> 0x011b, all -> 0x0117 }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x011b, all -> 0x0117 }
        r8.<init>();	 Catch:{ IOException -> 0x011b, all -> 0x0117 }
        r8.append(r3);	 Catch:{ IOException -> 0x011b, all -> 0x0117 }
        r12 = "";
        r8.append(r12);	 Catch:{ IOException -> 0x011b, all -> 0x0117 }
        r8 = r8.toString();	 Catch:{ IOException -> 0x011b, all -> 0x0117 }
        r6.setStatusCode(r8);	 Catch:{ IOException -> 0x011b, all -> 0x0117 }
        goto L_0x012c;
    L_0x0117:
        r0 = move-exception;
        r3 = r0;
        r13 = r6;
        goto L_0x00d8;
    L_0x011b:
        r0 = move-exception;
        r12 = r4;
        r13 = r6;
        r5 = 0;
    L_0x011f:
        r15 = 0;
        goto L_0x0127;
    L_0x0121:
        r0 = move-exception;
        r13 = r6;
        r10 = r11;
        r5 = 0;
        r15 = 0;
        r12 = r4;
    L_0x0127:
        r4 = r3;
    L_0x0128:
        r3 = r0;
        goto L_0x0404;
    L_0x012b:
        r10 = r11;
    L_0x012c:
        r8 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ IOException -> 0x03d9, all -> 0x03d5 }
        r12 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x03d9, all -> 0x03d5 }
        r12.<init>();	 Catch:{ IOException -> 0x03d9, all -> 0x03d5 }
        r4 = "flv responseCode:";
        r12.append(r4);	 Catch:{ IOException -> 0x03d9, all -> 0x03d5 }
        r12.append(r3);	 Catch:{ IOException -> 0x03d9, all -> 0x03d5 }
        r4 = r12.toString();	 Catch:{ IOException -> 0x03d9, all -> 0x03d5 }
        com.ximalaya.ting.android.player.Logger.log(r8, r4);	 Catch:{ IOException -> 0x03d9, all -> 0x03d5 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r3 != r4) goto L_0x03b9;
    L_0x0146:
        r4 = r9.getInputStream();	 Catch:{ IOException -> 0x03d9, all -> 0x03d5 }
        r8 = new com.ximalaya.ting.android.player.liveflv.FlvAacParser;	 Catch:{ IOException -> 0x03b3, all -> 0x03ad }
        r8.<init>(r4);	 Catch:{ IOException -> 0x03b3, all -> 0x03ad }
        r1.mFlvStream = r8;	 Catch:{ IOException -> 0x03b3, all -> 0x03ad }
        r8 = r1.mFlvStream;	 Catch:{ IOException -> 0x03b3, all -> 0x03ad }
        r12 = r1.isFlvDataCallbackEnable;	 Catch:{ IOException -> 0x03b3, all -> 0x03ad }
        r8.setFlvDataCallbackIsEnable(r12);	 Catch:{ IOException -> 0x03b3, all -> 0x03ad }
        r8 = 0;
        r12 = 0;
    L_0x015a:
        r15 = r1.isStop;	 Catch:{ IOException -> 0x03a8, all -> 0x03ad }
        if (r15 != 0) goto L_0x0195;
    L_0x015e:
        r15 = r1.mFlvStream;	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r8 = r15.readFrame(r8);	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r15 = r8.length;	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r12 = r12 + r15;
        r13 = new com.ximalaya.ting.android.player.BufferItem;	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r13.<init>();	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r13.setBuffer(r8);	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r1.putItem(r13);	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r8 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r13 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r13.<init>();	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r14 = "flv read buf len:";
        r13.append(r14);	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r13.append(r15);	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r13 = r13.toString();	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        com.ximalaya.ting.android.player.Logger.log(r8, r13);	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        r8 = r15;
        r13 = 0;
        goto L_0x015a;
    L_0x018b:
        r0 = move-exception;
        r3 = r0;
        r5 = r4;
        r13 = r6;
        goto L_0x03b1;
    L_0x0191:
        r0 = move-exception;
        r5 = r4;
        r13 = r6;
        goto L_0x011f;
    L_0x0195:
        r8 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ IOException -> 0x03a8, all -> 0x03ad }
        r13 = "flv read BufferItem last";
        com.ximalaya.ting.android.player.Logger.log(r8, r13);	 Catch:{ IOException -> 0x03a8, all -> 0x03ad }
        r8 = new com.ximalaya.ting.android.player.BufferItem;	 Catch:{ IOException -> 0x03a8, all -> 0x03ad }
        r8.<init>();	 Catch:{ IOException -> 0x03a8, all -> 0x03ad }
        r8.setLastChunk();	 Catch:{ IOException -> 0x03a8, all -> 0x03ad }
        r1.putItem(r8);	 Catch:{ IOException -> 0x03a8, all -> 0x03ad }
        r1.isStop = r5;	 Catch:{ IOException -> 0x03a8, all -> 0x03ad }
        if (r6 == 0) goto L_0x022a;
    L_0x01ab:
        if (r12 <= 0) goto L_0x01b3;
    L_0x01ad:
        r8 = "success";
        r6.setDownloadResult(r8);	 Catch:{ IOException -> 0x0191, all -> 0x018b }
        goto L_0x01b8;
    L_0x01b3:
        r8 = "failed";
        r6.setDownloadResult(r8);	 Catch:{ IOException -> 0x03a8, all -> 0x03ad }
    L_0x01b8:
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ IOException -> 0x03a8, all -> 0x03ad }
        r23 = r6;
        r18 = 0;
        r5 = r13 - r18;
        r8 = (r5 > r18 ? 1 : (r5 == r18 ? 0 : -1));
        if (r8 == 0) goto L_0x01d4;
    L_0x01c6:
        r8 = (float) r12;
        r13 = 0;
        r8 = r8 + r13;
        r14 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r8 = r8 / r14;
        r14 = (float) r5;
        r14 = r14 + r13;
        r13 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r14 = r14 / r13;
        r15 = r8 / r14;
        goto L_0x01d5;
    L_0x01d4:
        r15 = 0;
    L_0x01d5:
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0224, all -> 0x021d }
        r8.<init>();	 Catch:{ IOException -> 0x0224, all -> 0x021d }
        r8.append(r12);	 Catch:{ IOException -> 0x0224, all -> 0x021d }
        r13 = "";
        r8.append(r13);	 Catch:{ IOException -> 0x0224, all -> 0x021d }
        r8 = r8.toString();	 Catch:{ IOException -> 0x0224, all -> 0x021d }
        r13 = r23;
        r13.setDownloaded(r8);	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r8 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r8.<init>();	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r8.append(r5);	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r5 = "";
        r8.append(r5);	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r5 = r8.toString();	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r13.setDownloadTime(r5);	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r5.<init>();	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r6 = 1;
        r8 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r6);	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r5.append(r8);	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r6 = "";
        r5.append(r6);	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        r13.setDownloadSpeed(r5);	 Catch:{ IOException -> 0x021b, all -> 0x0219 }
        goto L_0x022c;
    L_0x0219:
        r0 = move-exception;
        goto L_0x0220;
    L_0x021b:
        r0 = move-exception;
        goto L_0x0227;
    L_0x021d:
        r0 = move-exception;
        r13 = r23;
    L_0x0220:
        r3 = r0;
        r5 = r4;
        goto L_0x0577;
    L_0x0224:
        r0 = move-exception;
        r13 = r23;
    L_0x0227:
        r5 = r4;
        goto L_0x0127;
    L_0x022a:
        r13 = r6;
        r15 = 0;
    L_0x022c:
        if (r7 != 0) goto L_0x037b;
    L_0x022e:
        if (r13 == 0) goto L_0x037b;
    L_0x0230:
        r3 = r13.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x023e;
    L_0x023a:
        r3 = 0;
        r13.setViaInfo(r3);
    L_0x023e:
        r3 = r13.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x024d;
    L_0x0248:
        r3 = "";
        r13.setStatusCode(r3);
    L_0x024d:
        r5 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r5);
        r3 = r13.getDownloadResult();
        if (r3 == 0) goto L_0x0266;
    L_0x025a:
        r3 = r13.getDownloadResult();
        r5 = "success";
        r3 = r3.contains(r5);
        if (r3 != 0) goto L_0x026b;
    L_0x0266:
        r3 = "failed";
        r13.setDownloadResult(r3);
    L_0x026b:
        r3 = r2.getNetType();
        r5 = -1;
        if (r3 != r5) goto L_0x0275;
    L_0x0272:
        r7 = 1;
        goto L_0x037b;
    L_0x0275:
        if (r3 != 0) goto L_0x02f6;
    L_0x0277:
        r3 = r2.getCdnNotWifiConnectTimeout();
        r5 = (long) r3;
        r1.mLimitConnectTime = r5;
        r3 = r2.getCdnNotWifiAlertRate();
        r5 = (long) r3;
        r1.mLimitDownloadSpeed = r5;
        r5 = r1.mLimitConnectTime;
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = r5 * r16;
        r3 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r3 <= 0) goto L_0x02c1;
    L_0x028f:
        r3 = "cdn_connected_too_slow";
        r13.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "connected_time=";
        r3.append(r5);
        r5 = (float) r10;
        r6 = 0;
        r5 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r5, r6);
        r3.append(r5);
        r5 = "s, connected_time_threshold=";
        r3.append(r5);
        r5 = r1.mLimitConnectTime;
        r3.append(r5);
        r5 = "s";
        r3.append(r5);
        r3 = r3.toString();
        r13.setExceptionReason(r3);
    L_0x02bd:
        r22 = 1;
        goto L_0x037d;
    L_0x02c1:
        r5 = r1.mLimitDownloadSpeed;
        r3 = (float) r5;
        r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1));
        if (r3 <= 0) goto L_0x037b;
    L_0x02c8:
        r3 = "cdn_download_too_slow";
        r13.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "download_speed=";
        r3.append(r5);
        r5 = 1;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r5);
        r3.append(r6);
        r5 = "KB/s, download_speed_threshold=";
        r3.append(r5);
        r5 = r1.mLimitDownloadSpeed;
        r3.append(r5);
        r5 = "KB/s";
        r3.append(r5);
        r3 = r3.toString();
        r13.setExceptionReason(r3);
        goto L_0x02bd;
    L_0x02f6:
        r5 = 1;
        if (r3 != r5) goto L_0x037b;
    L_0x02f9:
        r3 = r2.getCdnWifiConnectTimeout();
        r5 = (long) r3;
        r1.mLimitConnectTime = r5;
        r3 = r2.getCdnWifiAlertRate();
        r5 = (long) r3;
        r1.mLimitDownloadSpeed = r5;
        r5 = 0;
        r1.mLimitConnectTime = r5;
        r5 = r1.mLimitConnectTime;
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = r5 * r16;
        r3 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r3 <= 0) goto L_0x0345;
    L_0x0315:
        r3 = "cdn_connected_too_slow";
        r13.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "connected_time=";
        r3.append(r5);
        r5 = (float) r10;
        r6 = 0;
        r5 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r5, r6);
        r3.append(r5);
        r5 = "s, connected_time_threshold=";
        r3.append(r5);
        r5 = r1.mLimitConnectTime;
        r3.append(r5);
        r5 = "s";
        r3.append(r5);
        r3 = r3.toString();
        r13.setExceptionReason(r3);
        goto L_0x02bd;
    L_0x0345:
        r5 = r1.mLimitDownloadSpeed;
        r3 = (float) r5;
        r3 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1));
        if (r3 <= 0) goto L_0x037b;
    L_0x034c:
        r3 = "cdn_download_too_slow";
        r13.setErrorType(r3);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r5 = "download_speed=";
        r3.append(r5);
        r5 = 1;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r5);
        r3.append(r6);
        r5 = "KB/s, download_speed_threshold=";
        r3.append(r5);
        r5 = r1.mLimitDownloadSpeed;
        r3.append(r5);
        r5 = "KB/s";
        r3.append(r5);
        r3 = r3.toString();
        r13.setExceptionReason(r3);
        goto L_0x02bd;
    L_0x037b:
        r22 = 0;
    L_0x037d:
        if (r4 == 0) goto L_0x0387;
    L_0x037f:
        r4.close();	 Catch:{ IOException -> 0x0383 }
        goto L_0x0387;
    L_0x0383:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0387:
        if (r9 == 0) goto L_0x038c;
    L_0x0389:
        r9.disconnect();
    L_0x038c:
        if (r13 == 0) goto L_0x0705;
    L_0x038e:
        if (r22 == 0) goto L_0x0705;
    L_0x0390:
        if (r7 != 0) goto L_0x0705;
    L_0x0392:
        r3 = r13.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0705;
    L_0x039c:
        r3 = r13.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0705;
    L_0x03a6:
        goto L_0x056e;
    L_0x03a8:
        r0 = move-exception;
        r13 = r6;
        r5 = r4;
        goto L_0x011f;
    L_0x03ad:
        r0 = move-exception;
        r13 = r6;
        r3 = r0;
        r5 = r4;
    L_0x03b1:
        r4 = 0;
        goto L_0x03e7;
    L_0x03b3:
        r0 = move-exception;
        r13 = r6;
        r5 = r4;
        r12 = 0;
        goto L_0x011f;
    L_0x03b9:
        r13 = r6;
        r4 = new java.io.IOException;	 Catch:{ IOException -> 0x03d3, all -> 0x03d1 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x03d3, all -> 0x03d1 }
        r5.<init>();	 Catch:{ IOException -> 0x03d3, all -> 0x03d1 }
        r6 = "httpCode";
        r5.append(r6);	 Catch:{ IOException -> 0x03d3, all -> 0x03d1 }
        r5.append(r3);	 Catch:{ IOException -> 0x03d3, all -> 0x03d1 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x03d3, all -> 0x03d1 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x03d3, all -> 0x03d1 }
        throw r4;	 Catch:{ IOException -> 0x03d3, all -> 0x03d1 }
    L_0x03d1:
        r0 = move-exception;
        goto L_0x03d7;
    L_0x03d3:
        r0 = move-exception;
        goto L_0x03db;
    L_0x03d5:
        r0 = move-exception;
        r13 = r6;
    L_0x03d7:
        r3 = r0;
        goto L_0x03e5;
    L_0x03d9:
        r0 = move-exception;
        r13 = r6;
    L_0x03db:
        r4 = r3;
        r5 = 0;
        r12 = 0;
        r15 = 0;
        goto L_0x0128;
    L_0x03e1:
        r0 = move-exception;
        r13 = r6;
        r3 = r0;
        r10 = r11;
    L_0x03e5:
        r4 = 0;
        r5 = 0;
    L_0x03e7:
        r6 = 0;
        goto L_0x03f8;
    L_0x03e9:
        r0 = move-exception;
        r13 = r6;
        r3 = r0;
        r10 = r11;
        r4 = 0;
        r5 = 0;
        goto L_0x0402;
    L_0x03f0:
        r0 = move-exception;
        r13 = r6;
        r3 = r0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        r10 = 0;
    L_0x03f8:
        r15 = 0;
        goto L_0x0579;
    L_0x03fb:
        r0 = move-exception;
        r13 = r6;
        r3 = r0;
        r4 = 0;
        r5 = 0;
        r10 = 0;
    L_0x0402:
        r12 = 0;
        r15 = 0;
    L_0x0404:
        r3.printStackTrace();	 Catch:{ all -> 0x0573 }
        r6 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x0573 }
        r8 = "flv read BufferItem last exception";
        com.ximalaya.ting.android.player.Logger.log(r6, r8);	 Catch:{ all -> 0x0573 }
        r6 = new com.ximalaya.ting.android.player.BufferItem;	 Catch:{ all -> 0x0573 }
        r6.<init>();	 Catch:{ all -> 0x0573 }
        r8 = 1;
        r6.fails = r8;	 Catch:{ all -> 0x0573 }
        r6.errorCode = r4;	 Catch:{ all -> 0x0573 }
        r1.putItem(r6);	 Catch:{ all -> 0x0573 }
        r1.isStop = r8;	 Catch:{ all -> 0x0573 }
        if (r7 != 0) goto L_0x0508;
    L_0x041f:
        if (r13 == 0) goto L_0x0508;
    L_0x0421:
        r4 = r13.getDownloadSpeed();	 Catch:{ all -> 0x0500 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ all -> 0x0500 }
        if (r4 == 0) goto L_0x048b;
    L_0x042b:
        r18 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0500 }
        r24 = r10;
        r20 = 0;
        r10 = r18 - r20;
        r4 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1));
        if (r4 == 0) goto L_0x0446;
    L_0x0439:
        r4 = (float) r12;
        r6 = 0;
        r4 = r4 + r6;
        r8 = 1149239296; // 0x44800000 float:1024.0 double:5.67799655E-315;
        r4 = r4 / r8;
        r8 = (float) r10;
        r8 = r8 + r6;
        r6 = 1148846080; // 0x447a0000 float:1000.0 double:5.676053805E-315;
        r8 = r8 / r6;
        r4 = r4 / r8;
        r15 = r4;
    L_0x0446:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0488 }
        r4.<init>();	 Catch:{ all -> 0x0488 }
        r6 = 1;
        r8 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r6);	 Catch:{ all -> 0x0488 }
        r4.append(r8);	 Catch:{ all -> 0x0488 }
        r6 = "";
        r4.append(r6);	 Catch:{ all -> 0x0488 }
        r4 = r4.toString();	 Catch:{ all -> 0x0488 }
        r13.setDownloadSpeed(r4);	 Catch:{ all -> 0x0488 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0488 }
        r4.<init>();	 Catch:{ all -> 0x0488 }
        r4.append(r12);	 Catch:{ all -> 0x0488 }
        r6 = "";
        r4.append(r6);	 Catch:{ all -> 0x0488 }
        r4 = r4.toString();	 Catch:{ all -> 0x0488 }
        r13.setDownloaded(r4);	 Catch:{ all -> 0x0488 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0488 }
        r4.<init>();	 Catch:{ all -> 0x0488 }
        r4.append(r10);	 Catch:{ all -> 0x0488 }
        r6 = "";
        r4.append(r6);	 Catch:{ all -> 0x0488 }
        r4 = r4.toString();	 Catch:{ all -> 0x0488 }
        r13.setDownloadTime(r4);	 Catch:{ all -> 0x0488 }
        goto L_0x048d;
    L_0x0488:
        r0 = move-exception;
        goto L_0x04fc;
    L_0x048b:
        r24 = r10;
    L_0x048d:
        r4 = r13.getConnectedTime();	 Catch:{ all -> 0x04f9 }
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 > 0) goto L_0x04b0;
    L_0x0496:
        r10 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x04f9 }
        r26 = r15;
        r18 = 0;
        r14 = r10 - r18;
        r4 = (float) r14;
        r6 = 0;
        r4 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r4, r6);	 Catch:{ all -> 0x04ac }
        r13.setConnectedTime(r4);	 Catch:{ all -> 0x04ac }
        r24 = r14;
        goto L_0x04b2;
    L_0x04ac:
        r0 = move-exception;
        r3 = r0;
        r10 = r14;
        goto L_0x04f6;
    L_0x04b0:
        r26 = r15;
    L_0x04b2:
        r4 = r3.getMessage();	 Catch:{ all -> 0x04f2 }
        if (r4 == 0) goto L_0x04e0;
    L_0x04b8:
        r4 = r3.getMessage();	 Catch:{ all -> 0x04f2 }
        r6 = "ENOSPC";
        r4 = r4.contains(r6);	 Catch:{ all -> 0x04f2 }
        if (r4 != 0) goto L_0x04d0;
    L_0x04c4:
        r4 = r3.getMessage();	 Catch:{ all -> 0x04f2 }
        r6 = "EACCES";
        r4 = r4.contains(r6);	 Catch:{ all -> 0x04f2 }
        if (r4 == 0) goto L_0x04e0;
    L_0x04d0:
        r4 = "0";
        r13.setDownloaded(r4);	 Catch:{ all -> 0x04f2 }
        r4 = "0";
        r13.setDownloadTime(r4);	 Catch:{ all -> 0x04f2 }
        r4 = "system_exception";
        r13.setErrorType(r4);	 Catch:{ all -> 0x04f2 }
        goto L_0x04e5;
    L_0x04e0:
        r4 = "cdn_io_exception";
        r13.setErrorType(r4);	 Catch:{ all -> 0x04f2 }
    L_0x04e5:
        r3 = com.ximalaya.ting.android.player.cdn.CdnUtil.exception2String(r3);	 Catch:{ all -> 0x04f2 }
        r13.setExceptionReason(r3);	 Catch:{ all -> 0x04f2 }
        r3 = "failed";
        r13.setDownloadResult(r3);	 Catch:{ all -> 0x04f2 }
        goto L_0x0508;
    L_0x04f2:
        r0 = move-exception;
        r3 = r0;
        r10 = r24;
    L_0x04f6:
        r15 = r26;
        goto L_0x0504;
    L_0x04f9:
        r0 = move-exception;
        r26 = r15;
    L_0x04fc:
        r3 = r0;
        r10 = r24;
        goto L_0x0504;
    L_0x0500:
        r0 = move-exception;
        r24 = r10;
        r3 = r0;
    L_0x0504:
        r4 = 1;
        r6 = 1;
        goto L_0x0579;
    L_0x0508:
        if (r7 != 0) goto L_0x0547;
    L_0x050a:
        if (r13 == 0) goto L_0x0547;
    L_0x050c:
        r3 = r13.getViaInfo();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x051a;
    L_0x0516:
        r3 = 0;
        r13.setViaInfo(r3);
    L_0x051a:
        r3 = r13.getStatusCode();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 == 0) goto L_0x0529;
    L_0x0524:
        r3 = "";
        r13.setStatusCode(r3);
    L_0x0529:
        r3 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r3);
        r3 = r13.getDownloadResult();
        if (r3 == 0) goto L_0x0542;
    L_0x0536:
        r3 = r13.getDownloadResult();
        r4 = "success";
        r3 = r3.contains(r4);
        if (r3 != 0) goto L_0x0547;
    L_0x0542:
        r3 = "failed";
        r13.setDownloadResult(r3);
    L_0x0547:
        if (r5 == 0) goto L_0x0551;
    L_0x0549:
        r5.close();	 Catch:{ IOException -> 0x054d }
        goto L_0x0551;
    L_0x054d:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0551:
        if (r9 == 0) goto L_0x0556;
    L_0x0553:
        r9.disconnect();
    L_0x0556:
        if (r13 == 0) goto L_0x0705;
    L_0x0558:
        if (r7 != 0) goto L_0x0705;
    L_0x055a:
        r3 = r13.getErrorType();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0705;
    L_0x0564:
        r3 = r13.getExceptionReason();
        r3 = android.text.TextUtils.isEmpty(r3);
        if (r3 != 0) goto L_0x0705;
    L_0x056e:
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r13, r2);
        goto L_0x0705;
    L_0x0573:
        r0 = move-exception;
        r24 = r10;
        r3 = r0;
    L_0x0577:
        r4 = 0;
        r6 = 0;
    L_0x0579:
        if (r7 != 0) goto L_0x06d2;
    L_0x057b:
        if (r13 == 0) goto L_0x06d2;
    L_0x057d:
        r8 = r13.getViaInfo();
        r8 = android.text.TextUtils.isEmpty(r8);
        if (r8 == 0) goto L_0x058b;
    L_0x0587:
        r8 = 0;
        r13.setViaInfo(r8);
    L_0x058b:
        r8 = r13.getStatusCode();
        r8 = android.text.TextUtils.isEmpty(r8);
        if (r8 == 0) goto L_0x059a;
    L_0x0595:
        r8 = "";
        r13.setStatusCode(r8);
    L_0x059a:
        r28 = r6;
        r27 = r7;
        r6 = java.lang.System.currentTimeMillis();
        r13.setTimestamp(r6);
        r6 = r13.getDownloadResult();
        if (r6 == 0) goto L_0x05b7;
    L_0x05ab:
        r6 = r13.getDownloadResult();
        r7 = "success";
        r6 = r6.contains(r7);
        if (r6 != 0) goto L_0x05bc;
    L_0x05b7:
        r6 = "failed";
        r13.setDownloadResult(r6);
    L_0x05bc:
        if (r4 != 0) goto L_0x06d6;
    L_0x05be:
        r4 = r2.getNetType();
        r6 = -1;
        if (r4 != r6) goto L_0x05cb;
    L_0x05c5:
        r22 = r28;
        r27 = 1;
        goto L_0x06d8;
    L_0x05cb:
        if (r4 != 0) goto L_0x064c;
    L_0x05cd:
        r4 = r2.getCdnNotWifiConnectTimeout();
        r6 = (long) r4;
        r1.mLimitConnectTime = r6;
        r4 = r2.getCdnNotWifiAlertRate();
        r6 = (long) r4;
        r1.mLimitDownloadSpeed = r6;
        r6 = r1.mLimitConnectTime;
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 * r16;
        r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0617;
    L_0x05e5:
        r4 = "cdn_connected_too_slow";
        r13.setErrorType(r4);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "connected_time=";
        r4.append(r6);
        r6 = (float) r10;
        r7 = 0;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r6, r7);
        r4.append(r6);
        r6 = "s, connected_time_threshold=";
        r4.append(r6);
        r6 = r1.mLimitConnectTime;
        r4.append(r6);
        r6 = "s";
        r4.append(r6);
        r4 = r4.toString();
        r13.setExceptionReason(r4);
    L_0x0613:
        r22 = 1;
        goto L_0x06d8;
    L_0x0617:
        r6 = r1.mLimitDownloadSpeed;
        r4 = (float) r6;
        r4 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1));
        if (r4 <= 0) goto L_0x06d6;
    L_0x061e:
        r4 = "cdn_download_too_slow";
        r13.setErrorType(r4);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "download_speed=";
        r4.append(r6);
        r6 = 1;
        r7 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r6);
        r4.append(r7);
        r6 = "KB/s, download_speed_threshold=";
        r4.append(r6);
        r6 = r1.mLimitDownloadSpeed;
        r4.append(r6);
        r6 = "KB/s";
        r4.append(r6);
        r4 = r4.toString();
        r13.setExceptionReason(r4);
        goto L_0x0613;
    L_0x064c:
        r6 = 1;
        if (r4 != r6) goto L_0x06d6;
    L_0x064f:
        r4 = r2.getCdnWifiConnectTimeout();
        r6 = (long) r4;
        r1.mLimitConnectTime = r6;
        r4 = r2.getCdnWifiAlertRate();
        r6 = (long) r4;
        r1.mLimitDownloadSpeed = r6;
        r6 = 0;
        r1.mLimitConnectTime = r6;
        r6 = r1.mLimitConnectTime;
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 * r16;
        r4 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x069b;
    L_0x066b:
        r4 = "cdn_connected_too_slow";
        r13.setErrorType(r4);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "connected_time=";
        r4.append(r6);
        r6 = (float) r10;
        r7 = 0;
        r6 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r6, r7);
        r4.append(r6);
        r6 = "s, connected_time_threshold=";
        r4.append(r6);
        r6 = r1.mLimitConnectTime;
        r4.append(r6);
        r6 = "s";
        r4.append(r6);
        r4 = r4.toString();
        r13.setExceptionReason(r4);
        goto L_0x0613;
    L_0x069b:
        r6 = r1.mLimitDownloadSpeed;
        r4 = (float) r6;
        r4 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1));
        if (r4 <= 0) goto L_0x06d6;
    L_0x06a2:
        r4 = "cdn_download_too_slow";
        r13.setErrorType(r4);
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r6 = "download_speed=";
        r4.append(r6);
        r6 = 1;
        r7 = com.ximalaya.ting.android.player.cdn.CdnUtil.oneDecimal(r15, r6);
        r4.append(r7);
        r7 = "KB/s, download_speed_threshold=";
        r4.append(r7);
        r7 = r1.mLimitDownloadSpeed;
        r4.append(r7);
        r7 = "KB/s";
        r4.append(r7);
        r4 = r4.toString();
        r13.setExceptionReason(r4);
        r22 = r6;
        goto L_0x06d8;
    L_0x06d2:
        r28 = r6;
        r27 = r7;
    L_0x06d6:
        r22 = r28;
    L_0x06d8:
        if (r5 == 0) goto L_0x06e2;
    L_0x06da:
        r5.close();	 Catch:{ IOException -> 0x06de }
        goto L_0x06e2;
    L_0x06de:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x06e2:
        if (r9 == 0) goto L_0x06e7;
    L_0x06e4:
        r9.disconnect();
    L_0x06e7:
        if (r13 == 0) goto L_0x0704;
    L_0x06e9:
        if (r22 == 0) goto L_0x0704;
    L_0x06eb:
        if (r27 != 0) goto L_0x0704;
    L_0x06ed:
        r4 = r13.getErrorType();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x0704;
    L_0x06f7:
        r4 = r13.getExceptionReason();
        r4 = android.text.TextUtils.isEmpty(r4);
        if (r4 != 0) goto L_0x0704;
    L_0x0701:
        com.ximalaya.ting.android.player.cdn.CdnUtil.statDownLoadCDN(r13, r2);
    L_0x0704:
        throw r3;
    L_0x0705:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.liveflv.FlvLiveReadThread.run():void");
    }

    public void setFlvDataCallbackIsEnable(boolean z) {
        this.isFlvDataCallbackEnable = z;
        if (this.mFlvStream != null) {
            this.mFlvStream.setFlvDataCallbackIsEnable(z);
        }
    }
}
