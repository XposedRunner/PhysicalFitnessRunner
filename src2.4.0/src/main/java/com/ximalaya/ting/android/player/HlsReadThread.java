package com.ximalaya.ting.android.player;

import com.ximalaya.ting.android.player.XMediaplayerJNI.AudioType;
import java.util.concurrent.LinkedBlockingQueue;

public class HlsReadThread extends Thread {
    private static final String TAG = "dl_hls";
    private volatile LinkedBlockingQueue<BufferItem> buffItemQueue;
    private volatile int curIndex;
    private volatile int fromIndex;
    private volatile boolean isResetIndex;
    private boolean isStop = false;
    public volatile boolean isWaiting = false;
    private int mDownloadIndex;
    private HlsAudioFile mHlsAudioFile;
    private String mSourceUrl;
    private XMediaplayerJNI mXMediaplayerJNI;
    private volatile Object synKey = new Object();
    public Object synObject = new Object();
    public Object synWaitObject = new Object();

    public HlsReadThread(HlsAudioFile hlsAudioFile, XMediaplayerJNI xMediaplayerJNI, String str, LinkedBlockingQueue<BufferItem> linkedBlockingQueue) {
        super("HlsReadThreadForPlayer");
        this.mHlsAudioFile = hlsAudioFile;
        this.mXMediaplayerJNI = xMediaplayerJNI;
        this.mSourceUrl = str;
        this.buffItemQueue = linkedBlockingQueue;
        this.isResetIndex = true;
    }

    private void putItem(BufferItem bufferItem) {
        String str;
        StringBuilder stringBuilder;
        if (this.isResetIndex) {
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("putItem buffItemQueue.size()2:");
            stringBuilder.append(this.buffItemQueue.size());
            Logger.log(str, stringBuilder.toString());
            return;
        }
        String str2 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("putItem url:");
        stringBuilder2.append(this.mHlsAudioFile.getPlayUrl(bufferItem.getIndex()));
        stringBuilder2.append(" item Index:");
        stringBuilder2.append(bufferItem.getIndex());
        Logger.log(str2, stringBuilder2.toString());
        str2 = TAG;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("putItem buffItemQueue.size()0:");
        stringBuilder2.append(this.buffItemQueue.size());
        Logger.log(str2, stringBuilder2.toString());
        try {
            this.buffItemQueue.put(bufferItem);
        } catch (InterruptedException unused) {
        }
        str = TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("putItem buffItemQueue.size()1:");
        stringBuilder.append(this.buffItemQueue.size());
        Logger.log(str, stringBuilder.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0032 A:{SYNTHETIC, Splitter:B:25:0x0032} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b A:{SYNTHETIC, Splitter:B:17:0x002b} */
    private int readChunkData(java.io.File r5, com.ximalaya.ting.android.player.BufferItem r6) {
        /*
        r4 = this;
        r0 = 0;
        r1 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x002f, all -> 0x0027 }
        r2 = "rw";
        r1.<init>(r5, r2);	 Catch:{ IOException -> 0x002f, all -> 0x0027 }
        r2 = r1.length();	 Catch:{ IOException -> 0x0030, all -> 0x0025 }
        r5 = (int) r2;	 Catch:{ IOException -> 0x0030, all -> 0x0025 }
        r5 = new byte[r5];	 Catch:{ IOException -> 0x0030, all -> 0x0025 }
        r0 = 0;
    L_0x0010:
        r2 = r5.length;	 Catch:{ IOException -> 0x0030, all -> 0x0025 }
        r2 = r2 - r0;
        r2 = r1.read(r5, r0, r2);	 Catch:{ IOException -> 0x0030, all -> 0x0025 }
        r0 = r0 + r2;
        if (r2 > 0) goto L_0x0010;
    L_0x0019:
        r6.setBuffer(r5);	 Catch:{ IOException -> 0x0030, all -> 0x0025 }
        r1.close();	 Catch:{ IOException -> 0x0030, all -> 0x0025 }
        if (r1 == 0) goto L_0x0024;
    L_0x0021:
        r1.close();	 Catch:{ IOException -> 0x0024 }
    L_0x0024:
        return r0;
    L_0x0025:
        r5 = move-exception;
        goto L_0x0029;
    L_0x0027:
        r5 = move-exception;
        r1 = r0;
    L_0x0029:
        if (r1 == 0) goto L_0x002e;
    L_0x002b:
        r1.close();	 Catch:{ IOException -> 0x002e }
    L_0x002e:
        throw r5;
    L_0x002f:
        r1 = r0;
    L_0x0030:
        if (r1 == 0) goto L_0x0035;
    L_0x0032:
        r1.close();	 Catch:{ IOException -> 0x0035 }
    L_0x0035:
        r5 = -1;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.HlsReadThread.readChunkData(java.io.File, com.ximalaya.ting.android.player.BufferItem):int");
    }

    public void close() {
        this.isStop = true;
        if (this.buffItemQueue != null) {
            this.buffItemQueue.clear();
        }
        Logger.log(XMediaplayerJNI.Tag, "HlsReadThread hls readData close");
    }

    public int getCacheIndex() {
        return this.mDownloadIndex == 0 ? this.mHlsAudioFile.getPlayIndex() : this.mDownloadIndex;
    }

    public boolean isClose() {
        return this.isStop;
    }

    public void notifyDownload() {
        if (this.isWaiting) {
            synchronized (this.synWaitObject) {
                this.isWaiting = false;
                this.synWaitObject.notify();
            }
        }
    }

    public void resetIndex(LinkedBlockingQueue<BufferItem> linkedBlockingQueue) {
        synchronized (this.synKey) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("resetIndex bq.size()0:");
            stringBuilder.append(linkedBlockingQueue.size());
            Logger.log(str, stringBuilder.toString());
            this.isResetIndex = true;
            this.fromIndex = this.mHlsAudioFile.getPlayIndex();
            if (this.buffItemQueue != null) {
                this.buffItemQueue.clear();
            }
            this.buffItemQueue = linkedBlockingQueue;
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("resetIndex bq.size()1:");
            stringBuilder.append(linkedBlockingQueue.size());
            Logger.log(str, stringBuilder.toString());
        }
    }

    public void run() {
        this.fromIndex = this.mHlsAudioFile.getPlayIndex();
        this.isResetIndex = true;
        while (!this.isStop && MD5.getFileNameMd5(this.mXMediaplayerJNI.getPlayUrl()).equals(MD5.getFileNameMd5(this.mSourceUrl))) {
            String str;
            StringBuilder stringBuilder;
            synchronized (this.synKey) {
                if (this.isResetIndex) {
                    str = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("resetIndex isResetIndex buffItemQueue.size():");
                    stringBuilder.append(this.buffItemQueue.size());
                    Logger.log(str, stringBuilder.toString());
                    this.isResetIndex = false;
                    this.curIndex = this.fromIndex;
                    this.mDownloadIndex = this.fromIndex;
                }
            }
            if (this.curIndex >= this.mHlsAudioFile.getPlayUrlsLength() && !this.mXMediaplayerJNI.getAudioType().equals(AudioType.HLS_FILE) && !this.isResetIndex) {
                break;
            }
            if (this.mDownloadIndex < this.curIndex) {
                this.mDownloadIndex = this.curIndex;
            }
            int i = XMediaPlayerConstants.DOWNLOAD_QUEUE_SIZE - 3;
            while (this.mDownloadIndex - this.curIndex < i && this.buffItemQueue.size() >= 3 && !this.isStop && this.mDownloadIndex < this.mHlsAudioFile.getPlayUrlsLength() && !this.isResetIndex) {
                String playUrl = this.mHlsAudioFile.getPlayUrl(this.mDownloadIndex);
                String str2;
                StringBuilder stringBuilder2;
                if (new HlsDownloadThread(playUrl, null).download() > 0) {
                    str2 = TAG;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("url:");
                    stringBuilder2.append(playUrl);
                    stringBuilder2.append(" downloadIndex:");
                    stringBuilder2.append(this.mDownloadIndex);
                    stringBuilder2.append("下载并且缓存成功1");
                    Logger.log(str2, stringBuilder2.toString());
                    this.mDownloadIndex++;
                    this.mXMediaplayerJNI.onBufferingUpdateInner(this.mHlsAudioFile.getCachePercent());
                } else {
                    str2 = TAG;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("url:");
                    stringBuilder2.append(playUrl);
                    stringBuilder2.append(" downloadIndex:");
                    stringBuilder2.append(this.mDownloadIndex);
                    stringBuilder2.append("下载失败error1");
                    Logger.log(str2, stringBuilder2.toString());
                }
                playUrl = TAG;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("getCachePercent percent mDownloadIndex:");
                stringBuilder3.append(this.mDownloadIndex);
                Logger.log(playUrl, stringBuilder3.toString());
            }
            if (!this.isStop) {
                if (!this.isResetIndex) {
                    String playUrl2 = this.mHlsAudioFile.getPlayUrl(this.curIndex);
                    str = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("HlsReadThread downUrl0:");
                    stringBuilder.append(playUrl2);
                    stringBuilder.append("    cacheIndex:");
                    stringBuilder.append(this.curIndex);
                    stringBuilder.append("getPlayUrlsLength:");
                    stringBuilder.append(this.mHlsAudioFile.getPlayUrlsLength());
                    Logger.log(str, stringBuilder.toString());
                    if (playUrl2 == null) {
                        if (!this.mXMediaplayerJNI.getAudioType().equals(AudioType.HLS_FILE)) {
                            break;
                        }
                        synchronized (this.synWaitObject) {
                            this.isWaiting = true;
                            try {
                                this.synWaitObject.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        BufferItem bufferItem = new BufferItem();
                        bufferItem.setIndex(this.curIndex);
                        if (new HlsDownloadThread(playUrl2, bufferItem).download() <= 0) {
                            str = TAG;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("url:");
                            stringBuilder.append(playUrl2);
                            stringBuilder.append(" curIndex:");
                            stringBuilder.append(this.curIndex);
                            stringBuilder.append("下载并且缓存失败2");
                            Logger.log(str, stringBuilder.toString());
                            break;
                        }
                        putItem(bufferItem);
                        str = TAG;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("url:");
                        stringBuilder.append(playUrl2);
                        stringBuilder.append(" curIndex:");
                        stringBuilder.append(this.curIndex);
                        stringBuilder.append("下载并且缓存成功2");
                        Logger.log(str, stringBuilder.toString());
                        this.curIndex++;
                        this.mXMediaplayerJNI.onBufferingUpdateInner(this.mHlsAudioFile.getCachePercent());
                    }
                }
            } else {
                break;
            }
        }
        this.isStop = true;
        String str3 = XMediaplayerJNI.Tag;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("HlsReadThread isStop:");
        stringBuilder4.append(this.isStop);
        stringBuilder4.append("cacheIndex:");
        stringBuilder4.append(this.curIndex);
        Logger.log(str3, stringBuilder4.toString());
    }
}
