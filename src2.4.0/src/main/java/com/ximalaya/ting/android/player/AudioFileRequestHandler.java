package com.ximalaya.ting.android.player;

import com.ximalaya.ting.android.player.model.JNIDataModel;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.LinkedBlockingQueue;

public class AudioFileRequestHandler {
    public static int RELEASE_TYPE_IO_ERROR = -1;
    public static int RELEASE_TYPE_RESET = -2;
    private LinkedBlockingQueue<BufferItem> buffItemQueue;
    private volatile boolean isPollData = false;
    private String mPreBufferUrl = null;
    private ReadThread mReadThread;
    private volatile int mReleaseType = 0;
    private XMediaplayerJNI mXMediaplayerJNI;
    private int normalReleaseCode = 1000;

    public AudioFileRequestHandler(XMediaplayerJNI xMediaplayerJNI) {
        this.mXMediaplayerJNI = xMediaplayerJNI;
        this.mReleaseType = 0;
    }

    public AudioFileRequestHandler(XMediaplayerJNI xMediaplayerJNI, String str) {
        this.mXMediaplayerJNI = xMediaplayerJNI;
        this.mReleaseType = 0;
        this.mPreBufferUrl = str;
    }

    private synchronized int readDataFromSD(String str, int i, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
        long length = randomAccessFile.length();
        int i2 = 0;
        int readInt;
        if (str.endsWith(XMediaPlayerConstants.XM_SUFFIX)) {
            randomAccessFile.seek((long) 12);
            readInt = randomAccessFile.readInt();
            this.mXMediaplayerJNI.setCurFileSize(length - ((long) readInt));
            randomAccessFile.seek((long) (i + readInt));
            do {
                readInt = randomAccessFile.read(bArr, i2, bArr.length - i2);
                i2 += readInt;
            } while (readInt > 0);
            randomAccessFile.close();
            return i2;
        } else if (!str.endsWith(XMediaPlayerConstants.X2M_SUFFIX) || i >= MediadataCrytoUtil.ENCRYPT_DATA_LENGTH || length < ((long) MediadataCrytoUtil.ENCRYPT_DATA_LENGTH)) {
            this.mXMediaplayerJNI.setCurFileSize(length);
            randomAccessFile.seek((long) i);
            do {
                readInt = randomAccessFile.read(bArr, i2, bArr.length - i2);
                i2 += readInt;
            } while (readInt > 0);
            randomAccessFile.close();
            return i2;
        } else {
            this.mXMediaplayerJNI.setCurFileSize(length);
            randomAccessFile.seek(0);
            byte[] bArr2 = new byte[MediadataCrytoUtil.ENCRYPT_DATA_LENGTH];
            int i3 = 0;
            int read;
            do {
                read = randomAccessFile.read(bArr2, i3, bArr2.length - i3);
                i3 += read;
            } while (read > 0);
            bArr2 = MediadataCrytoUtil.getInstance().decryptData(bArr2);
            i3 = MediadataCrytoUtil.ENCRYPT_DATA_LENGTH - i;
            if (bArr.length > i3) {
                while (i2 < i3) {
                    bArr[i2] = bArr2[i + i2];
                    i2++;
                }
                randomAccessFile.seek((long) MediadataCrytoUtil.ENCRYPT_DATA_LENGTH);
                do {
                    readInt = randomAccessFile.read(bArr, i3, bArr.length - i3);
                    i3 += readInt;
                } while (readInt > 0);
                randomAccessFile.close();
                return i3;
            }
            while (i2 < bArr.length) {
                bArr[i2] = bArr2[i + i2];
                i2++;
            }
            randomAccessFile.close();
            return bArr.length;
        }
    }

    private boolean resetLoadDataPosition(int i, JNIDataModel jNIDataModel) {
        long comFileLen;
        Logger.log(XMediaplayerJNI.Tag, "dataStreamInputFuncCallBackT resetLoadDataPosition");
        this.buffItemQueue = new LinkedBlockingQueue(3);
        if (!(this.mReadThread == null || this.mReadThread.isClosed())) {
            Logger.log(XMediaplayerJNI.Tag, "dataStreamInputFuncCallBackT resetLoadDataPosition1");
            comFileLen = (long) this.mReadThread.getAudioFile().getFileInfo().getComFileLen();
            jNIDataModel.fileSize = comFileLen;
            this.mXMediaplayerJNI.setCurFileSize(comFileLen);
            if (this.mReadThread.resetIndex(i / 65536, this.buffItemQueue)) {
                return true;
            }
        }
        Logger.log(XMediaplayerJNI.Tag, "dataStreamInputFuncCallBackT resetLoadDataPosition0");
        try {
            AudioFile audioFile = AudioFile.getAudioFile(XMediaPlayerConstants.INCOM_AUDIO_FILE_DIRECTORY, this.mXMediaplayerJNI.getPlayUrl());
            if (audioFile == null || !audioFile.getFileInfo().isValid()) {
                Logger.log(XMediaplayerJNI.Tag, "mFile.getFileInfo().inValid()");
                return false;
            }
            if (this.mReadThread != null) {
                this.mReadThread.close();
                String str = XMediaplayerJNI.Tag;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("dataStreamInputFuncCallBackT mReadThread.close");
                stringBuilder.append(this.mReadThread.toString());
                Logger.log(str, stringBuilder.toString());
            }
            if (!audioFile.getFileInfo().isValid()) {
                return false;
            }
            comFileLen = (long) audioFile.getFileInfo().getComFileLen();
            jNIDataModel.fileSize = comFileLen;
            this.mXMediaplayerJNI.setCurFileSize(comFileLen);
            int i2 = i / 65536;
            if (this.mPreBufferUrl == null) {
                this.mReadThread = new ReadThread(audioFile, i2, this.buffItemQueue, this.mXMediaplayerJNI);
            } else {
                this.mReadThread = new ReadThread(audioFile, i2, this.buffItemQueue, this.mXMediaplayerJNI, this.mPreBufferUrl);
            }
            Logger.log(XMediaplayerJNI.Tag, "ReadThread.start()");
            this.mReadThread.start();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean shallReloadData() {
        return this.buffItemQueue == null || (this.mReadThread != null && this.mReadThread.isClosed() && this.buffItemQueue.size() == 0);
    }

    public int getCachePercent() {
        return PlayerUtil.isLocalFile(this.mXMediaplayerJNI.getPlayUrl()) ? 100 : this.mReadThread == null ? 0 : this.mReadThread.getCachePercent();
    }

    public boolean isRelease() {
        return this.mReleaseType < 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:83:0x0383  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x037b  */
    public int readData(com.ximalaya.ting.android.player.model.JNIDataModel r19, boolean r20, int r21) {
        /*
        r18 = this;
        r1 = r18;
        r2 = r19;
        r4 = r21;
        if (r4 >= 0) goto L_0x000a;
    L_0x0008:
        r2 = -2;
        return r2;
    L_0x000a:
        r5 = r18.isRelease();
        if (r5 == 0) goto L_0x0013;
    L_0x0010:
        r2 = r1.mReleaseType;
        return r2;
    L_0x0013:
        r5 = r2.filePath;
        r5 = com.ximalaya.ting.android.player.PlayerUtil.isLocalFile(r5);
        r6 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        if (r5 == 0) goto L_0x0046;
    L_0x001d:
        r3 = r2.bufSize;
        if (r3 <= r6) goto L_0x0022;
    L_0x0021:
        goto L_0x0024;
    L_0x0022:
        r6 = r2.bufSize;
    L_0x0024:
        r3 = new byte[r6];
        r2.buf = r3;
        r3 = r2.filePath;	 Catch:{ IOException -> 0x0044 }
        r5 = r2.buf;	 Catch:{ IOException -> 0x0044 }
        r1.readDataFromSD(r3, r4, r5);	 Catch:{ IOException -> 0x0044 }
        r3 = r1.mXMediaplayerJNI;
        r3 = r3.getCurFileSize();
        r2.fileSize = r3;
        r3 = r1.mXMediaplayerJNI;
        r4 = r18.getCachePercent();
        r3.onBufferingUpdateInner(r4);
        r2 = r2.buf;
        r2 = r2.length;
        return r2;
    L_0x0044:
        r2 = -1;
        return r2;
    L_0x0046:
        if (r20 != 0) goto L_0x004e;
    L_0x0048:
        r5 = r18.shallReloadData();
        if (r5 == 0) goto L_0x005c;
    L_0x004e:
        r5 = r1.resetLoadDataPosition(r4, r2);
        if (r5 != 0) goto L_0x005c;
    L_0x0054:
        r2 = r1.mReleaseType;
        r1.release(r2);
        r2 = r1.mReleaseType;
        return r2;
    L_0x005c:
        r5 = r1.mXMediaplayerJNI;
        r7 = r5.getCurFileSize();
        r5 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r9 = new java.lang.StringBuilder;
        r9.<init>();
        r10 = "dataStreamInputFuncCallBackT 0 tCurFileSize:";
        r9.append(r10);
        r9.append(r7);
        r9 = r9.toString();
        com.ximalaya.ting.android.player.Logger.log(r5, r9);
        r9 = 0;
        r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));
        if (r5 > 0) goto L_0x0086;
    L_0x007e:
        r2 = r1.mReleaseType;
        r1.release(r2);
        r2 = r1.mReleaseType;
        return r2;
    L_0x0086:
        r5 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r11 = "dataStreamInputFuncCallBackT 1";
        com.ximalaya.ting.android.player.Logger.log(r5, r11);
        r5 = 0;
        if (r20 != 0) goto L_0x00ad;
    L_0x0090:
        r11 = r1.mXMediaplayerJNI;	 Catch:{ InterruptedException -> 0x00a9 }
        r11 = r11.tmepBuf;	 Catch:{ InterruptedException -> 0x00a9 }
        if (r11 == 0) goto L_0x00ad;
    L_0x0096:
        r3 = r1.mXMediaplayerJNI;	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r3.tmepBuf;	 Catch:{ InterruptedException -> 0x00a9 }
        r2.buf = r3;	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r1.mXMediaplayerJNI;	 Catch:{ InterruptedException -> 0x00a9 }
        r3.tmepBuf = r5;	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = "dataStreamInputFuncCallBackT read temp buf";
        com.ximalaya.ting.android.player.Logger.log(r3, r4);	 Catch:{ InterruptedException -> 0x00a9 }
        goto L_0x0352;
    L_0x00a9:
        r0 = move-exception;
        r3 = r0;
        goto L_0x035d;
    L_0x00ad:
        r11 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r12 = "dataStreamInputFuncCallBackT 2";
        com.ximalaya.ting.android.player.Logger.log(r11, r12);	 Catch:{ InterruptedException -> 0x00a9 }
        r11 = r1.mXMediaplayerJNI;	 Catch:{ InterruptedException -> 0x00a9 }
        r11.tmepBuf = r5;	 Catch:{ InterruptedException -> 0x00a9 }
        r11 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r12 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r12.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = "dataStreamInputFuncCallBackT 2 buffItemQueue.size():";
        r12.append(r13);	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = r1.buffItemQueue;	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = r13.size();	 Catch:{ InterruptedException -> 0x00a9 }
        r12.append(r13);	 Catch:{ InterruptedException -> 0x00a9 }
        r12 = r12.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r11, r12);	 Catch:{ InterruptedException -> 0x00a9 }
        r11 = r1.buffItemQueue;	 Catch:{ InterruptedException -> 0x00a9 }
        r11 = r11.size();	 Catch:{ InterruptedException -> 0x00a9 }
        r12 = 0;
        if (r11 > 0) goto L_0x00e7;
    L_0x00dd:
        r11 = r1.mXMediaplayerJNI;	 Catch:{ InterruptedException -> 0x00a9 }
        r11 = r11.mContext;	 Catch:{ InterruptedException -> 0x00a9 }
        r11 = com.ximalaya.ting.android.player.PlayerUtil.isConnectNetwork(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        if (r11 == 0) goto L_0x014d;
    L_0x00e7:
        r5 = r18.isRelease();	 Catch:{ InterruptedException -> 0x00a9 }
        if (r5 == 0) goto L_0x00f0;
    L_0x00ed:
        r3 = r1.mReleaseType;	 Catch:{ InterruptedException -> 0x00a9 }
        return r3;
    L_0x00f0:
        r5 = 1;
        r1.isPollData = r5;	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r11 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r11.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = "dataStreamInputFuncCallBackT 2 buffItemQueue.size():";
        r11.append(r13);	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = r1.buffItemQueue;	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = r13.size();	 Catch:{ InterruptedException -> 0x00a9 }
        r11.append(r13);	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = " isPollData0:";
        r11.append(r13);	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = r1.isPollData;	 Catch:{ InterruptedException -> 0x00a9 }
        r11.append(r13);	 Catch:{ InterruptedException -> 0x00a9 }
        r11 = r11.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r5, r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = r1.buffItemQueue;	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r11 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = r5.poll(r13, r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = (com.ximalaya.ting.android.player.BufferItem) r5;	 Catch:{ InterruptedException -> 0x00a9 }
        r1.isPollData = r12;	 Catch:{ InterruptedException -> 0x00a9 }
        r11 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r13.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r14 = "dataStreamInputFuncCallBackT 2 buffItemQueue.size():";
        r13.append(r14);	 Catch:{ InterruptedException -> 0x00a9 }
        r14 = r1.buffItemQueue;	 Catch:{ InterruptedException -> 0x00a9 }
        r14 = r14.size();	 Catch:{ InterruptedException -> 0x00a9 }
        r13.append(r14);	 Catch:{ InterruptedException -> 0x00a9 }
        r14 = " isPollData1:";
        r13.append(r14);	 Catch:{ InterruptedException -> 0x00a9 }
        r14 = r1.isPollData;	 Catch:{ InterruptedException -> 0x00a9 }
        r13.append(r14);	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = r13.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r11, r13);	 Catch:{ InterruptedException -> 0x00a9 }
    L_0x014d:
        r11 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = "dataStreamInputFuncCallBackT 3";
        com.ximalaya.ting.android.player.Logger.log(r11, r13);	 Catch:{ InterruptedException -> 0x00a9 }
        if (r5 != 0) goto L_0x0165;
    L_0x0156:
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = "dataStreamInputFuncCallBackT timeout item null";
        com.ximalaya.ting.android.player.Logger.log(r3, r4);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r1.mReleaseType;	 Catch:{ InterruptedException -> 0x00a9 }
        r1.release(r3);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r1.mReleaseType;	 Catch:{ InterruptedException -> 0x00a9 }
        return r3;
    L_0x0165:
        r11 = r5.fails;	 Catch:{ InterruptedException -> 0x00a9 }
        if (r11 == 0) goto L_0x019c;
    L_0x0169:
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r4.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = "dataStreamInputFuncCallBackT timeout item null index:";
        r4.append(r6);	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = r5.getIndex();	 Catch:{ InterruptedException -> 0x00a9 }
        r4.append(r6);	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = " bItem.errorCode:";
        r4.append(r6);	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = r5.errorCode;	 Catch:{ InterruptedException -> 0x00a9 }
        r4.append(r5);	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r4.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r3, r4);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r1.mReleaseType;	 Catch:{ InterruptedException -> 0x00a9 }
        r1.release(r3);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = "dataStreamInputFuncCallBackT timeout item null return -1";
        com.ximalaya.ting.android.player.Logger.log(r3, r4);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r1.mReleaseType;	 Catch:{ InterruptedException -> 0x00a9 }
        return r3;
    L_0x019c:
        r11 = r5.getIndex();	 Catch:{ InterruptedException -> 0x00a9 }
        r13 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
        r9 = r7 / r13;
        r9 = (int) r9;	 Catch:{ InterruptedException -> 0x00a9 }
        r10 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r15 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r15.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r12 = "dataStreamInputFuncCallBackT 4 index:";
        r15.append(r12);	 Catch:{ InterruptedException -> 0x00a9 }
        r15.append(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r12 = "total index:";
        r15.append(r12);	 Catch:{ InterruptedException -> 0x00a9 }
        r15.append(r9);	 Catch:{ InterruptedException -> 0x00a9 }
        r12 = r15.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r10, r12);	 Catch:{ InterruptedException -> 0x00a9 }
        if (r11 < 0) goto L_0x0355;
    L_0x01c6:
        r10 = r5.isLastChunk();	 Catch:{ InterruptedException -> 0x00a9 }
        if (r10 != 0) goto L_0x0355;
    L_0x01cc:
        if (r11 <= r9) goto L_0x01d0;
    L_0x01ce:
        goto L_0x0355;
    L_0x01d0:
        r10 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r12 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r12.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r15 = "dataStreamInputFuncCallBackT seekParaTimeStampMs index:";
        r12.append(r15);	 Catch:{ InterruptedException -> 0x00a9 }
        r12.append(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r15 = "total index:";
        r12.append(r15);	 Catch:{ InterruptedException -> 0x00a9 }
        r12.append(r9);	 Catch:{ InterruptedException -> 0x00a9 }
        r12 = r12.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r10, r12);	 Catch:{ InterruptedException -> 0x00a9 }
        if (r20 == 0) goto L_0x02dd;
    L_0x01f0:
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r10 = "dataStreamInputFuncCallBackT seekParaTimeStampMs 1";
        com.ximalaya.ting.android.player.Logger.log(r3, r10);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r4 % r6;
        r4 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r6.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r10 = "dataStreamInputFuncCallBackT offset:";
        r6.append(r10);	 Catch:{ InterruptedException -> 0x00a9 }
        r6.append(r3);	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = r6.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r4, r6);	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r5.getBuffer();	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r4.array();	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r4.length;	 Catch:{ InterruptedException -> 0x00a9 }
        r15 = 0;
        r6 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1));
        if (r6 == 0) goto L_0x0257;
    L_0x021e:
        if (r11 != r9) goto L_0x0257;
    L_0x0220:
        r9 = r7 % r13;
        r4 = (int) r9;	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r9 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r9.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r10 = "dataStreamInputFuncCallBackT lastChunkLength:";
        r9.append(r10);	 Catch:{ InterruptedException -> 0x00a9 }
        r9.append(r4);	 Catch:{ InterruptedException -> 0x00a9 }
        r10 = " index:";
        r9.append(r10);	 Catch:{ InterruptedException -> 0x00a9 }
        r9.append(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r9 = r9.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r6, r9);	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r9 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r9.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r10 = "dataStreamInputFuncCallBackT seekParaTimeStampMs 2 index:";
        r9.append(r10);	 Catch:{ InterruptedException -> 0x00a9 }
        r9.append(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r9 = r9.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r6, r9);	 Catch:{ InterruptedException -> 0x00a9 }
    L_0x0257:
        r6 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r9 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r9.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r10 = "dataStreamInputFuncCallBackT offset:";
        r9.append(r10);	 Catch:{ InterruptedException -> 0x00a9 }
        r9.append(r3);	 Catch:{ InterruptedException -> 0x00a9 }
        r10 = "length:";
        r9.append(r10);	 Catch:{ InterruptedException -> 0x00a9 }
        r9.append(r4);	 Catch:{ InterruptedException -> 0x00a9 }
        r10 = " index:";
        r9.append(r10);	 Catch:{ InterruptedException -> 0x00a9 }
        r9.append(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r9 = r9.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r6, r9);	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = r5.getBuffer();	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r5.position(r3);	 Catch:{ InterruptedException -> 0x00a9 }
        r3.limit(r4);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r5.slice();	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r5.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = "dataStreamInputFuncCallBackT slice remaining:";
        r5.append(r6);	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = r3.remaining();	 Catch:{ InterruptedException -> 0x00a9 }
        r5.append(r6);	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = " index:";
        r5.append(r6);	 Catch:{ InterruptedException -> 0x00a9 }
        r5.append(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = r5.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r4, r5);	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r3.remaining();	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = new byte[r4];	 Catch:{ InterruptedException -> 0x00a9 }
        r2.buf = r4;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r2.buf;	 Catch:{ InterruptedException -> 0x00a9 }
        r3.get(r4);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r4.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = "dataStreamInputFuncCallBackT slice buf size:";
        r4.append(r5);	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = r2.buf;	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = r5.length;	 Catch:{ InterruptedException -> 0x00a9 }
        r4.append(r5);	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = " index:";
        r4.append(r5);	 Catch:{ InterruptedException -> 0x00a9 }
        r4.append(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r4.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r3, r4);	 Catch:{ InterruptedException -> 0x00a9 }
        goto L_0x0352;
    L_0x02dd:
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r4.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r6 = "dataStreamInputFuncCallBackT seekParaTimeStampMs 3 index:";
        r4.append(r6);	 Catch:{ InterruptedException -> 0x00a9 }
        r4.append(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r4.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r3, r4);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = 0;
        r6 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r6 == 0) goto L_0x0332;
    L_0x02f9:
        if (r11 != r9) goto L_0x0332;
    L_0x02fb:
        r3 = r7 % r13;
        r3 = (int) r3;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r5.getBuffer();	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = 0;
        r5 = r4.position(r5);	 Catch:{ InterruptedException -> 0x00a9 }
        r5.limit(r3);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r4.slice();	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r3.remaining();	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = new byte[r4];	 Catch:{ InterruptedException -> 0x00a9 }
        r2.buf = r4;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r2.buf;	 Catch:{ InterruptedException -> 0x00a9 }
        r3.get(r4);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r4.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = "dataStreamInputFuncCallBackT seekParaTimeStampMs 4 index:";
        r4.append(r5);	 Catch:{ InterruptedException -> 0x00a9 }
        r4.append(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r4.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r3, r4);	 Catch:{ InterruptedException -> 0x00a9 }
        goto L_0x0352;
    L_0x0332:
        r3 = r5.getBuffer();	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = r3.array();	 Catch:{ InterruptedException -> 0x00a9 }
        r2.buf = r3;	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00a9 }
        r4.<init>();	 Catch:{ InterruptedException -> 0x00a9 }
        r5 = "dataStreamInputFuncCallBackT seekParaTimeStampMs 5 index:";
        r4.append(r5);	 Catch:{ InterruptedException -> 0x00a9 }
        r4.append(r11);	 Catch:{ InterruptedException -> 0x00a9 }
        r4 = r4.toString();	 Catch:{ InterruptedException -> 0x00a9 }
        com.ximalaya.ting.android.player.Logger.log(r3, r4);	 Catch:{ InterruptedException -> 0x00a9 }
    L_0x0352:
        r2.fileSize = r7;	 Catch:{ InterruptedException -> 0x00a9 }
        goto L_0x0377;
    L_0x0355:
        r3 = RELEASE_TYPE_IO_ERROR;	 Catch:{ InterruptedException -> 0x00a9 }
        r1.release(r3);	 Catch:{ InterruptedException -> 0x00a9 }
        r3 = RELEASE_TYPE_IO_ERROR;	 Catch:{ InterruptedException -> 0x00a9 }
        return r3;
    L_0x035d:
        r4 = com.ximalaya.ting.android.player.XMediaplayerJNI.Tag;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "dataStreamInputFuncCallBackT 19";
        r5.append(r6);
        r3 = r3.getMessage();
        r5.append(r3);
        r3 = r5.toString();
        com.ximalaya.ting.android.player.Logger.log(r4, r3);
    L_0x0377:
        r3 = r2.buf;
        if (r3 != 0) goto L_0x0383;
    L_0x037b:
        r2 = RELEASE_TYPE_IO_ERROR;
        r1.release(r2);
        r2 = RELEASE_TYPE_IO_ERROR;
        return r2;
    L_0x0383:
        r2 = r2.buf;
        r2 = r2.length;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.AudioFileRequestHandler.readData(com.ximalaya.ting.android.player.model.JNIDataModel, boolean, int):int");
    }

    public void release(int i) {
        if (i == 0) {
            i = RELEASE_TYPE_IO_ERROR;
        }
        this.mReleaseType = i;
        String str = XMediaplayerJNI.Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AudioFileRequestHandler release mReadThread.close");
        stringBuilder.append(toString());
        Logger.log(str, stringBuilder.toString());
        if (this.mReadThread != null) {
            this.mReadThread.close();
            str = XMediaplayerJNI.Tag;
            stringBuilder = new StringBuilder();
            stringBuilder.append("AudioFileRequestHandler release mReadThread.close");
            stringBuilder.append(this.mReadThread.toString());
            Logger.log(str, stringBuilder.toString());
        }
        if (this.buffItemQueue != null) {
            str = XMediaplayerJNI.Tag;
            stringBuilder = new StringBuilder();
            stringBuilder.append("AudioFileRequestHandler release buffItemQueue.size():");
            stringBuilder.append(this.buffItemQueue.size());
            stringBuilder.append(" isPollData:");
            stringBuilder.append(this.isPollData);
            Logger.log(str, stringBuilder.toString());
            if (this.buffItemQueue.size() == 0 && this.isPollData) {
                BufferItem bufferItem = new BufferItem();
                bufferItem.fails = true;
                bufferItem.errorCode = this.normalReleaseCode;
                this.buffItemQueue.add(bufferItem);
                str = XMediaplayerJNI.Tag;
                stringBuilder = new StringBuilder();
                stringBuilder.append("AudioFileRequestHandler release normalReleaseCode:");
                stringBuilder.append(this.normalReleaseCode);
                Logger.log(str, stringBuilder.toString());
                return;
            }
            this.buffItemQueue.clear();
            Logger.log(XMediaplayerJNI.Tag, "AudioFileRequestHandler release buffItemQueue.clear");
        }
    }

    public void restart() {
        this.mReleaseType = 0;
    }

    public void setPreBufferUrl(String str) {
        this.mPreBufferUrl = str;
        if (this.mReadThread != null && !this.mReadThread.isClosed()) {
            this.mReadThread.setPreBufferUrl(this.mPreBufferUrl);
        }
    }
}
