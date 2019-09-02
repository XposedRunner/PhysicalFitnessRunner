package com.ximalaya.ting.android.player.liveflv;

import com.ximalaya.ting.android.player.BufferItem;
import com.ximalaya.ting.android.player.Logger;
import com.ximalaya.ting.android.player.PlayerUtil;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import com.ximalaya.ting.android.player.XMediaplayerJNI;
import com.ximalaya.ting.android.player.model.JNIDataModel;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class FlvLiveAudioFile {
    private int LastUseLessBlockCode = 800;
    private LinkedBlockingQueue<BufferItem> buffItemQueue;
    private volatile boolean isFirst = true;
    private volatile boolean isPollData = false;
    private boolean isRunning = false;
    private int mBufNumForStart = 100;
    private FlvLiveReadThread mHlsReadThread;
    private XMediaplayerJNI mXMediaplayerJNI;
    private Object waitObject = new Object();

    public FlvLiveAudioFile(XMediaplayerJNI xMediaplayerJNI) {
        this.mXMediaplayerJNI = xMediaplayerJNI;
        this.buffItemQueue = new LinkedBlockingQueue(XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
    }

    private void startChacheFile() {
        if (this.mHlsReadThread == null || this.mHlsReadThread.isClose()) {
            this.buffItemQueue = new LinkedBlockingQueue(XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
            if (this.mHlsReadThread != null) {
                this.mHlsReadThread.setFlvDataCallbackIsEnable(false);
            }
            this.mHlsReadThread = new FlvLiveReadThread(this.mXMediaplayerJNI, this.mXMediaplayerJNI.getPlayUrl(), this.buffItemQueue);
            this.isRunning = false;
            this.isFirst = true;
        }
        if (!this.mHlsReadThread.isAlive() && !this.isRunning) {
            this.isRunning = true;
            this.mHlsReadThread.start();
        }
    }

    public int readData(JNIDataModel jNIDataModel) {
        String str = XMediaplayerJNI.Tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FlvLiveAudioFile readData start time:");
        stringBuilder.append(System.currentTimeMillis());
        Logger.log(str, stringBuilder.toString());
        startChacheFile();
        BufferItem bufferItem = null;
        try {
            if (this.buffItemQueue.size() > 0 || PlayerUtil.isConnectNetwork(this.mXMediaplayerJNI.mContext)) {
                Logger.log(XMediaplayerJNI.Tag, "flv readDataT wait");
                this.isPollData = true;
                bufferItem = (BufferItem) this.buffItemQueue.poll(20000, TimeUnit.MILLISECONDS);
                this.isPollData = false;
                Logger.log(XMediaplayerJNI.Tag, "flv readDataT wait end");
            }
            if (bufferItem == null || bufferItem.errorCode != this.LastUseLessBlockCode) {
                Logger.log(XMediaplayerJNI.Tag, "flv dataStreamInputFuncCallBackT 3");
                if (bufferItem != null) {
                    if (!bufferItem.fails) {
                        if (bufferItem.isLastChunk()) {
                            release();
                            return 0;
                        }
                        jNIDataModel.buf = bufferItem.getBuffer().array();
                        jNIDataModel.fileSize = (long) jNIDataModel.buf.length;
                        jNIDataModel.bufSize = jNIDataModel.buf.length;
                        str = XMediaplayerJNI.Tag;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("flv buf fileSize:");
                        stringBuilder2.append(jNIDataModel.fileSize);
                        Logger.log(str, stringBuilder2.toString());
                        return jNIDataModel.buf.length;
                    }
                }
                Logger.log(XMediaplayerJNI.Tag, "flv dataStreamInputFuncCallBackT timeout item null");
                release();
                return -1;
            }
            Logger.log(XMediaplayerJNI.Tag, "flv dataStreamInputFuncCallBackT releae last data");
            release();
            return -2;
        } catch (InterruptedException unused) {
            release();
            return -1;
        }
    }

    public void release() {
        Logger.log(XMediaplayerJNI.Tag, "flv FlvLiveFile relase readDataT");
        this.isRunning = false;
        if (this.mHlsReadThread != null) {
            this.mHlsReadThread.close();
        }
        if (this.buffItemQueue != null) {
            int size = this.buffItemQueue.size();
            String str = XMediaplayerJNI.Tag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("flv readDataT relase isPollData:");
            stringBuilder.append(this.isPollData);
            stringBuilder.append(" size:");
            stringBuilder.append(size);
            Logger.log(str, stringBuilder.toString());
            if (size == 0 && this.isPollData) {
                Logger.log(XMediaplayerJNI.Tag, "flv readDataT relase put last buf item start");
                BufferItem bufferItem = new BufferItem();
                bufferItem.fails = true;
                bufferItem.errorCode = this.LastUseLessBlockCode;
                this.buffItemQueue.add(bufferItem);
                Logger.log(XMediaplayerJNI.Tag, "flv readDataT relase put last buf item end");
                return;
            }
            Logger.log(XMediaplayerJNI.Tag, "flv readDataT relase clear item start");
            this.buffItemQueue.clear();
            Logger.log(XMediaplayerJNI.Tag, "flv readDataT relase clear item end");
        }
    }
}
