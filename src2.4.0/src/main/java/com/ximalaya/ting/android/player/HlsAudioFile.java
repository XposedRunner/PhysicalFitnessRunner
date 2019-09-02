package com.ximalaya.ting.android.player;

import com.umeng.commonsdk.proguard.c;
import com.ximalaya.ting.android.player.XMediaplayerJNI.AudioType;
import com.ximalaya.ting.android.player.model.JNIDataModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class HlsAudioFile {
    private LinkedBlockingQueue<BufferItem> buffItemQueue;
    private volatile boolean isPollData = false;
    private boolean isRunning = false;
    private int lastIndex = -1;
    private List<String> mHlsPlayUrls = new ArrayList();
    private HlsReadThread mHlsReadThread;
    private String mPlayUrl;
    private String mSourceUrl;
    private XMediaplayerJNI mXMediaplayerJNI;

    public HlsAudioFile(String str, XMediaplayerJNI xMediaplayerJNI) {
        this.mSourceUrl = str;
        this.mXMediaplayerJNI = xMediaplayerJNI;
    }

    private void startChacheFile() {
        if (this.mHlsReadThread == null || this.mHlsReadThread.isClose()) {
            this.buffItemQueue = new LinkedBlockingQueue(3);
            this.mHlsReadThread = new HlsReadThread(this, this.mXMediaplayerJNI, this.mSourceUrl, this.buffItemQueue);
            this.isRunning = false;
        }
        if (!(this.mHlsReadThread.isAlive() || this.isRunning || getPlayIndex() < 0)) {
            this.isRunning = true;
            this.mHlsReadThread.start();
        }
        this.mHlsReadThread.notifyDownload();
    }

    public void addPlayUrls(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.mHlsPlayUrls.addAll(Arrays.asList(strArr));
            startChacheFile();
        }
    }

    public int getCachePercent() {
        if (this.mHlsReadThread == null || getPlayUrlsLength() == 0) {
            return 0;
        }
        String str = XMediaplayerJNI.Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DownloadThread hls mHlsReadThread.getCacheIndex():");
        stringBuilder.append(this.mHlsReadThread.getCacheIndex());
        stringBuilder.append("getPlayUrlsLength():");
        stringBuilder.append(getPlayUrlsLength());
        Logger.log(str, stringBuilder.toString());
        int cacheIndex = (int) ((((float) (this.mHlsReadThread.getCacheIndex() - 1)) / ((float) getPlayUrlsLength())) * 100.0f);
        if (cacheIndex < 0) {
            cacheIndex = 0;
        }
        return cacheIndex;
    }

    public List<String> getHlsPlayUrls() {
        return this.mHlsPlayUrls;
    }

    public int getPlayIndex() {
        return this.mPlayUrl == null ? -1 : this.mHlsPlayUrls.indexOf(this.mPlayUrl);
    }

    public String getPlayUrl() {
        return this.mPlayUrl;
    }

    public String getPlayUrl(int i) {
        return i < this.mHlsPlayUrls.size() ? (String) this.mHlsPlayUrls.get(i) : null;
    }

    public int getPlayUrlsLength() {
        return this.mHlsPlayUrls.size();
    }

    public long readData(JNIDataModel jNIDataModel) {
        boolean z;
        String str = XMediaplayerJNI.Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hls readData callback:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.log(str, stringBuilder.toString());
        this.mPlayUrl = jNIDataModel.filePath;
        if (this.mXMediaplayerJNI.getAudioType().equals(AudioType.HLS_FILE)) {
            z = false;
        } else {
            int playIndex = getPlayIndex();
            String str2 = XMediaplayerJNI.Tag;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("HlsReadThread notify555 curIndex:");
            stringBuilder2.append(playIndex);
            stringBuilder2.append("lastIndex:");
            stringBuilder2.append(this.lastIndex);
            Logger.log(str2, stringBuilder2.toString());
            z = this.lastIndex + 1 != playIndex;
            this.lastIndex = playIndex;
        }
        startChacheFile();
        if (z) {
            this.buffItemQueue = new LinkedBlockingQueue(3);
            this.mHlsReadThread.resetIndex(this.buffItemQueue);
        }
        BufferItem bufferItem = null;
        try {
            if (this.buffItemQueue.size() > 0 || PlayerUtil.isConnectNetwork(this.mXMediaplayerJNI.mContext)) {
                this.isPollData = true;
                bufferItem = (BufferItem) this.buffItemQueue.poll(c.d, TimeUnit.MILLISECONDS);
                this.isPollData = false;
            }
            Logger.log(XMediaplayerJNI.Tag, "dataStreamInputFuncCallBackT 3");
            if (bufferItem != null) {
                if (!bufferItem.fails) {
                    jNIDataModel.buf = bufferItem.getBuffer().array();
                    jNIDataModel.fileSize = (long) jNIDataModel.buf.length;
                    return jNIDataModel.fileSize;
                }
            }
            Logger.log(XMediaplayerJNI.Tag, "dataStreamInputFuncCallBackT timeout item null");
            release();
            return -1;
        } catch (InterruptedException unused) {
            release();
            return -1;
        }
    }

    public void release() {
        if (this.mHlsReadThread != null) {
            this.mHlsReadThread.close();
        }
        if (this.buffItemQueue == null) {
            return;
        }
        if (this.buffItemQueue.size() == 0 && this.isPollData) {
            BufferItem bufferItem = new BufferItem();
            bufferItem.fails = true;
            bufferItem.errorCode = 500;
            this.buffItemQueue.add(bufferItem);
            return;
        }
        this.buffItemQueue.clear();
    }

    public void setPlayUrl(String str) {
        this.mPlayUrl = str;
    }
}
