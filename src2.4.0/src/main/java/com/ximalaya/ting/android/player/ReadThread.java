package com.ximalaya.ting.android.player;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;

public class ReadThread extends Thread {
    private static final String TAG = "dl_mp3";
    private volatile LinkedBlockingQueue<BufferItem> buffItemQueue;
    private volatile int curIndex = 0;
    private DownloadThread currentDownload;
    private volatile int fromIndex;
    private volatile boolean isResetIndex;
    private int mDownloadIndex;
    private AudioFile mFile;
    private AudioFile mPreBufferAudioFile;
    private String mPreBufferUrl = null;
    private XMediaplayerJNI mXMediaplayerJNI;
    private volatile boolean stopFlag;
    private volatile Object synKey = new Object();

    public ReadThread(AudioFile audioFile, int i, LinkedBlockingQueue<BufferItem> linkedBlockingQueue, XMediaplayerJNI xMediaplayerJNI) {
        super("ReadThreadForPlayer");
        setPriority(5);
        this.mFile = audioFile;
        this.fromIndex = i;
        this.buffItemQueue = linkedBlockingQueue;
        this.stopFlag = false;
        this.isResetIndex = true;
        this.mXMediaplayerJNI = xMediaplayerJNI;
    }

    public ReadThread(AudioFile audioFile, int i, LinkedBlockingQueue<BufferItem> linkedBlockingQueue, XMediaplayerJNI xMediaplayerJNI, String str) {
        super("ReadThreadForPlayer");
        setPriority(5);
        this.mFile = audioFile;
        this.fromIndex = i;
        this.buffItemQueue = linkedBlockingQueue;
        this.stopFlag = false;
        this.isResetIndex = true;
        this.mXMediaplayerJNI = xMediaplayerJNI;
        this.mPreBufferUrl = str;
    }

    private void putItem(BufferItem bufferItem) throws InterruptedException {
        String str;
        StringBuilder stringBuilder;
        if (this.isResetIndex) {
            str = TAG;
            stringBuilder = new StringBuilder();
            stringBuilder.append("resetIndex count5:");
            stringBuilder.append(this.buffItemQueue.size());
            Logger.log(str, stringBuilder.toString());
            return;
        }
        String str2 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("putItem url:");
        stringBuilder2.append(this.mFile.getUrl());
        stringBuilder2.append(" item Index:");
        stringBuilder2.append(bufferItem.getIndex());
        Logger.log(str2, stringBuilder2.toString());
        str2 = TAG;
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("resetIndex count3 putItem:");
        stringBuilder2.append(this.buffItemQueue.size());
        Logger.log(str2, stringBuilder2.toString());
        this.buffItemQueue.put(bufferItem);
        str = TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("resetIndex count4 putItem:");
        stringBuilder.append(this.buffItemQueue.size());
        Logger.log(str, stringBuilder.toString());
    }

    private BufferItem readChunk(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(65536);
        try {
            if (this.mFile.readChunkData(i, 65536, allocate.array(), 0) == 65536) {
                BufferItem bufferItem = new BufferItem();
                bufferItem.setBuffer(allocate);
                bufferItem.setIndex(i);
                return bufferItem;
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public void close() {
        String str = XMediaplayerJNI.Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mReadThread close");
        stringBuilder.append(toString());
        Logger.log(str, stringBuilder.toString());
        this.stopFlag = true;
        this.buffItemQueue.clear();
        if (this.currentDownload != null) {
            this.currentDownload.close();
        }
        this.mXMediaplayerJNI = null;
    }

    public AudioFile getAudioFile() {
        return this.mFile;
    }

    public int getCacheIndex() {
        return this.mDownloadIndex;
    }

    public int getCachePercent() {
        int chargeDataRealLength = this.mXMediaplayerJNI.getChargeDataRealLength() / 65536;
        if (chargeDataRealLength == 0) {
            chargeDataRealLength = this.mFile.getFileInfo().getComChunkNum();
        }
        chargeDataRealLength = (int) ((((float) (this.mDownloadIndex - 1)) / ((float) chargeDataRealLength)) * 100.0f);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getCachePercent percent:");
        stringBuilder.append(chargeDataRealLength);
        stringBuilder.append(" mDownloadIndex:");
        stringBuilder.append(this.mDownloadIndex);
        stringBuilder.append("getComChunkNum:");
        stringBuilder.append(this.mFile.getFileInfo().getComChunkNum());
        Logger.log(str, stringBuilder.toString());
        return chargeDataRealLength < 0 ? 0 : chargeDataRealLength;
    }

    public boolean isClosed() {
        return this.stopFlag;
    }

    /* JADX WARNING: Missing block: B:14:0x009a, code skipped:
            if (isClosed() == false) goto L_0x009d;
     */
    /* JADX WARNING: Missing block: B:15:0x009c, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:16:0x009d, code skipped:
            return true;
     */
    public boolean resetIndex(int r6, java.util.concurrent.LinkedBlockingQueue<com.ximalaya.ting.android.player.BufferItem> r7) {
        /*
        r5 = this;
        r0 = r5.buffItemQueue;
        if (r0 == 0) goto L_0x0042;
    L_0x0004:
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "resetIndex count0-0:";
        r1.append(r2);
        r2 = r5.buffItemQueue;
        r2 = r2.size();
        r1.append(r2);
        r1 = r1.toString();
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        r0 = r5.buffItemQueue;
        r0.clear();
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "resetIndex count0-1:";
        r1.append(r2);
        r2 = r5.buffItemQueue;
        r2 = r2.size();
        r1.append(r2);
        r1 = r1.toString();
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
        goto L_0x0049;
    L_0x0042:
        r0 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r1 = "resetIndex count0-0 buffItemQueue == null";
        com.ximalaya.ting.android.player.Logger.log(r0, r1);
    L_0x0049:
        r0 = r5.synKey;
        monitor-enter(r0);
        r1 = r5.isClosed();	 Catch:{ all -> 0x009e }
        r2 = 0;
        if (r1 == 0) goto L_0x0055;
    L_0x0053:
        monitor-exit(r0);	 Catch:{ all -> 0x009e }
        return r2;
    L_0x0055:
        r1 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x009e }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009e }
        r3.<init>();	 Catch:{ all -> 0x009e }
        r4 = "resetIndex count0:";
        r3.append(r4);	 Catch:{ all -> 0x009e }
        r4 = r7.size();	 Catch:{ all -> 0x009e }
        r3.append(r4);	 Catch:{ all -> 0x009e }
        r3 = r3.toString();	 Catch:{ all -> 0x009e }
        com.ximalaya.ting.android.player.Logger.log(r1, r3);	 Catch:{ all -> 0x009e }
        r1 = 1;
        r5.isResetIndex = r1;	 Catch:{ all -> 0x009e }
        r5.fromIndex = r6;	 Catch:{ all -> 0x009e }
        r6 = r5.buffItemQueue;	 Catch:{ all -> 0x009e }
        r6.clear();	 Catch:{ all -> 0x009e }
        r5.buffItemQueue = r7;	 Catch:{ all -> 0x009e }
        r6 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ all -> 0x009e }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009e }
        r3.<init>();	 Catch:{ all -> 0x009e }
        r4 = "resetIndex count1:";
        r3.append(r4);	 Catch:{ all -> 0x009e }
        r7 = r7.size();	 Catch:{ all -> 0x009e }
        r3.append(r7);	 Catch:{ all -> 0x009e }
        r7 = r3.toString();	 Catch:{ all -> 0x009e }
        com.ximalaya.ting.android.player.Logger.log(r6, r7);	 Catch:{ all -> 0x009e }
        monitor-exit(r0);	 Catch:{ all -> 0x009e }
        r6 = r5.isClosed();
        if (r6 == 0) goto L_0x009d;
    L_0x009c:
        return r2;
    L_0x009d:
        return r1;
    L_0x009e:
        r6 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x009e }
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.ReadThread.resetIndex(int, java.util.concurrent.LinkedBlockingQueue):boolean");
    }

    public void run() {
        Logger.log(TAG, "======================ReadThread run() start");
        while (!this.stopFlag && MD5.getFileNameMd5(this.mXMediaplayerJNI.getPlayUrl()).equals(MD5.getFileNameMd5(this.mFile.getFileInfo().getUrl()))) {
            String str;
            StringBuilder stringBuilder;
            try {
                String str2 = TAG;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("======================ReadThread start while(");
                stringBuilder2.append(this.curIndex);
                stringBuilder2.append(":");
                stringBuilder2.append(this.mFile.getFileInfo().getComChunkNum());
                stringBuilder2.append(") stopFlag:");
                stringBuilder2.append(this.stopFlag);
                stringBuilder2.append(" curIndex:");
                stringBuilder2.append(this.curIndex);
                Logger.log(str2, stringBuilder2.toString());
                FileDesc fileInfo = this.mFile.getFileInfo();
                BufferItem bufferItem;
                if (!fileInfo.isValid()) {
                    bufferItem = new BufferItem();
                    bufferItem.fails = true;
                    bufferItem.errorCode = this.mFile.getFileInfo().statusCode;
                    str = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("resetIndex count5-1 put:");
                    stringBuilder.append(this.buffItemQueue.size());
                    Logger.log(str, stringBuilder.toString());
                    try {
                        this.buffItemQueue.put(bufferItem);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    str2 = TAG;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("resetIndex count5-2 put:");
                    stringBuilder2.append(this.buffItemQueue.size());
                    Logger.log(str2, stringBuilder2.toString());
                    str2 = TAG;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("fileDesc not Valid stopFlag:");
                    stringBuilder2.append(this.stopFlag);
                    stringBuilder2.append(" curIndex:");
                    stringBuilder2.append(this.curIndex);
                    Logger.log(str2, stringBuilder2.toString());
                    this.stopFlag = true;
                    break;
                }
                synchronized (this.synKey) {
                    String str3 = TAG;
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("resetIndex count6:");
                    stringBuilder3.append(this.buffItemQueue.size());
                    stringBuilder3.append(" stopFlag:");
                    stringBuilder3.append(this.stopFlag);
                    stringBuilder3.append(" curIndex:");
                    stringBuilder3.append(this.curIndex);
                    Logger.log(str3, stringBuilder3.toString());
                    if (this.isResetIndex) {
                        this.isResetIndex = false;
                        this.curIndex = this.fromIndex;
                        this.mDownloadIndex = this.fromIndex;
                    }
                    str3 = TAG;
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("resetIndex count7:");
                    stringBuilder4.append(this.buffItemQueue.size());
                    stringBuilder4.append(" stopFlag:");
                    stringBuilder4.append(this.stopFlag);
                    stringBuilder4.append(" curIndex:");
                    stringBuilder4.append(this.curIndex);
                    Logger.log(str3, stringBuilder4.toString());
                    str3 = TAG;
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("before put last item isResetIndex:");
                    stringBuilder4.append(this.isResetIndex);
                    Logger.log(str3, stringBuilder4.toString());
                    if (this.curIndex >= fileInfo.getComChunkNum()) {
                        BufferItem bufferItem2 = new BufferItem();
                        bufferItem2.setBuffer(ByteBuffer.allocate(65536));
                        bufferItem2.setIndex(this.curIndex);
                        bufferItem2.setLastChunk();
                        String str4 = TAG;
                        stringBuilder4 = new StringBuilder();
                        stringBuilder4.append("putLastChunk stopFlag:");
                        stringBuilder4.append(this.stopFlag);
                        stringBuilder4.append(" curIndex:");
                        stringBuilder4.append(this.curIndex);
                        stringBuilder4.append(" getComChunkNum");
                        stringBuilder4.append(fileInfo.getComChunkNum());
                        Logger.log(str4, stringBuilder4.toString());
                        try {
                            putItem(bufferItem2);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        this.stopFlag = true;
                        Logger.log(TAG, "put LastChunk and close read thread");
                        break;
                    }
                    if (this.mDownloadIndex < this.curIndex) {
                        this.mDownloadIndex = this.curIndex;
                    }
                    int i = XMediaPlayerConstants.DOWNLOAD_QUEUE_SIZE - 3;
                    while (this.mDownloadIndex - this.curIndex < i && this.buffItemQueue.size() >= 3 && !this.stopFlag && this.mDownloadIndex < fileInfo.getComChunkNum() && !this.isResetIndex) {
                        String str5;
                        StringBuilder stringBuilder5;
                        if (!(this.mPreBufferUrl == null || this.mPreBufferAudioFile != null || this.mPreBufferUrl.equals(this.mFile.getUrl()))) {
                            try {
                                this.mPreBufferAudioFile = AudioFile.getAudioFile(XMediaPlayerConstants.INCOM_AUDIO_FILE_DIRECTORY, this.mPreBufferUrl);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                                this.mPreBufferAudioFile.getFileInfo().valid = false;
                            }
                            if (this.mPreBufferAudioFile.getFileInfo().isValid() && !this.mPreBufferAudioFile.getFileInfo().isChunkDownloaded(0)) {
                                new DownloadThread(this.mPreBufferAudioFile, 0).download();
                                if (this.mPreBufferAudioFile.getbBuffer() != null) {
                                    this.mPreBufferAudioFile.writeChunkData(0, this.mPreBufferAudioFile.getbBuffer().array(), 0, this.mPreBufferAudioFile.getbBuffer().array().length);
                                    this.mPreBufferAudioFile.setbBuffer(null);
                                    str5 = TAG;
                                    stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append("预缓冲 url_0:");
                                    stringBuilder5.append(this.mPreBufferAudioFile.getUrl());
                                    stringBuilder5.append(" downloadIndex:");
                                    stringBuilder5.append(0);
                                    stringBuilder5.append("下载并且缓存成功");
                                    Logger.log(str5, stringBuilder5.toString());
                                } else {
                                    str5 = TAG;
                                    stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append("预缓冲 url_0:");
                                    stringBuilder5.append(this.mPreBufferAudioFile.getUrl());
                                    stringBuilder5.append(" downloadIndex:");
                                    stringBuilder5.append(0);
                                    stringBuilder5.append("失败");
                                    Logger.log(str5, stringBuilder5.toString());
                                }
                            }
                        }
                        boolean isChunkDownloaded = this.mFile.getFileInfo().isChunkDownloaded(this.mDownloadIndex);
                        this.mXMediaplayerJNI.onBufferingUpdateInner(getCachePercent());
                        if (!isChunkDownloaded) {
                            if (new DownloadThread(this.mFile, this.mDownloadIndex).download() != 200) {
                                if (this.mFile.getbBuffer() == null) {
                                    str2 = TAG;
                                    stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("url:");
                                    stringBuilder2.append(this.mFile.getUrl());
                                    stringBuilder2.append(" downloadIndex:");
                                    stringBuilder2.append(this.mDownloadIndex);
                                    stringBuilder2.append("下载失败error");
                                    Logger.log(str2, stringBuilder2.toString());
                                    break;
                                }
                                this.mFile.writeChunkData(this.mDownloadIndex, this.mFile.getbBuffer().array(), 0, this.mFile.getbBuffer().array().length);
                                this.mFile.setbBuffer(null);
                                str5 = TAG;
                                stringBuilder5 = new StringBuilder();
                                stringBuilder5.append("url:");
                                stringBuilder5.append(this.mFile.getUrl());
                                stringBuilder5.append(" downloadIndex:");
                                stringBuilder5.append(this.mDownloadIndex);
                                stringBuilder5.append("下载并且缓存成功");
                                Logger.log(str5, stringBuilder5.toString());
                                this.mDownloadIndex++;
                            } else {
                                throw new IOException();
                            }
                        }
                        this.mDownloadIndex++;
                        str5 = TAG;
                        stringBuilder5 = new StringBuilder();
                        stringBuilder5.append("getCachePercent percent mDownloadIndex0:");
                        stringBuilder5.append(this.mDownloadIndex);
                        Logger.log(str5, stringBuilder5.toString());
                    }
                    if (this.stopFlag) {
                        str2 = TAG;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("fileDesc not Valid stopFlag:");
                        stringBuilder2.append(this.stopFlag);
                        stringBuilder2.append(" curIndex:");
                        stringBuilder2.append(this.curIndex);
                        Logger.log(str2, stringBuilder2.toString());
                        break;
                    } else if (this.isResetIndex) {
                        str2 = TAG;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("fileDesc not Valid stopFlag:");
                        stringBuilder2.append(this.stopFlag);
                        stringBuilder2.append(" curIndex:");
                        stringBuilder2.append(this.curIndex);
                        stringBuilder2.append(" isResetIndex:");
                        stringBuilder2.append(this.isResetIndex);
                        Logger.log(str2, stringBuilder2.toString());
                    } else {
                        this.mXMediaplayerJNI.onBufferingUpdateInner(getCachePercent());
                        str2 = TAG;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("开始获取分段数据：url:");
                        stringBuilder2.append(this.mFile.getUrl());
                        stringBuilder2.append(" curIndex:");
                        stringBuilder2.append(this.curIndex);
                        Logger.log(str2, stringBuilder2.toString());
                        DownloadThread downloadThread;
                        if (!this.mFile.getFileInfo().isChunkDownloaded(this.curIndex)) {
                            str2 = TAG;
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("url:");
                            stringBuilder2.append(this.mFile.getUrl());
                            stringBuilder2.append(" curIndex:");
                            stringBuilder2.append(this.curIndex);
                            stringBuilder2.append("缓存命中失败");
                            Logger.log(str2, stringBuilder2.toString());
                            downloadThread = new DownloadThread(this.mFile, this.curIndex);
                            this.currentDownload = downloadThread;
                            if (downloadThread.download() != 200) {
                                if (this.mFile.getbBuffer() == null) {
                                    str2 = TAG;
                                    stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append("url:");
                                    stringBuilder2.append(this.mFile.getUrl());
                                    stringBuilder2.append(" curIndex:");
                                    stringBuilder2.append(this.curIndex);
                                    stringBuilder2.append("下载失败error");
                                    Logger.log(str2, stringBuilder2.toString());
                                    break;
                                }
                                bufferItem = new BufferItem();
                                bufferItem.setBuffer(this.mFile.getbBuffer());
                                bufferItem.setIndex(this.curIndex);
                                putItem(bufferItem);
                                this.mFile.writeChunkData(this.curIndex, this.mFile.getbBuffer().array(), 0, this.mFile.getbBuffer().array().length);
                                this.mFile.setbBuffer(null);
                                str2 = TAG;
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append("url:");
                                stringBuilder2.append(this.mFile.getUrl());
                                stringBuilder2.append(" curIndex:");
                                stringBuilder2.append(this.curIndex);
                                stringBuilder2.append("下载并且缓存成功");
                                Logger.log(str2, stringBuilder2.toString());
                                this.curIndex++;
                            } else {
                                throw new IOException();
                            }
                        }
                        str2 = TAG;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("url:");
                        stringBuilder2.append(this.mFile.getUrl());
                        stringBuilder2.append(" curIndex:");
                        stringBuilder2.append(this.curIndex);
                        stringBuilder2.append("缓存命中成功");
                        Logger.log(str2, stringBuilder2.toString());
                        bufferItem = readChunk(this.curIndex);
                        if (bufferItem != null) {
                            str = TAG;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append("url:");
                            stringBuilder.append(this.mFile.getUrl());
                            stringBuilder.append(" curIndex:");
                            stringBuilder.append(this.curIndex);
                            stringBuilder.append("缓存获取成功");
                            Logger.log(str, stringBuilder.toString());
                            putItem(bufferItem);
                            this.curIndex++;
                        } else {
                            str2 = TAG;
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("url:");
                            stringBuilder2.append(this.mFile.getUrl());
                            stringBuilder2.append(" curIndex:");
                            stringBuilder2.append(this.curIndex);
                            stringBuilder2.append("缓存获取失败error");
                            Logger.log(str2, stringBuilder2.toString());
                            downloadThread = new DownloadThread(this.mFile, this.curIndex);
                            this.currentDownload = downloadThread;
                            downloadThread.download();
                            if (this.mFile.getbBuffer() != null) {
                                bufferItem = new BufferItem();
                                bufferItem.setBuffer(this.mFile.getbBuffer());
                                bufferItem.setIndex(this.curIndex);
                                putItem(bufferItem);
                                this.mFile.setbBuffer(null);
                                this.curIndex++;
                            }
                        }
                        str2 = TAG;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("结束获取分段数据：url:");
                        stringBuilder2.append(this.mFile.getUrl());
                        stringBuilder2.append(" curIndex:");
                        stringBuilder2.append(this.curIndex);
                        Logger.log(str2, stringBuilder2.toString());
                        str2 = TAG;
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("======================ReadThread end while(");
                        stringBuilder2.append(this.curIndex);
                        stringBuilder2.append(":");
                        stringBuilder2.append(this.mFile.getFileInfo().getComChunkNum());
                        stringBuilder2.append(") stopFlag:");
                        stringBuilder2.append(this.stopFlag);
                        stringBuilder2.append(" curIndex:");
                        stringBuilder2.append(this.curIndex);
                        Logger.log(str2, stringBuilder2.toString());
                    }
                }
            } catch (Exception e4) {
                str = TAG;
                stringBuilder = new StringBuilder();
                stringBuilder.append("ReadThread Exception:");
                stringBuilder.append(e4.getMessage());
                Logger.log(str, stringBuilder.toString());
            }
        }
        this.stopFlag = true;
        Logger.log(TAG, "======================ReadThread run() end");
    }

    public void setPreBufferUrl(String str) {
        this.mPreBufferUrl = str;
    }
}
