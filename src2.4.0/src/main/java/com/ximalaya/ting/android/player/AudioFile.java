package com.ximalaya.ting.android.player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class AudioFile {
    private static final String TAG = "dl_mp3";
    private ByteBuffer bBuffer;
    private String dirPath;
    private FileDesc fileInfo;
    private String fileName;
    private String mUrl = null;

    private AudioFile(String str, String str2) throws FileNotFoundException, IOException {
        Logger.log(TAG, "======================AudioFile Constructor()");
        this.dirPath = str;
        this.fileName = MD5.getFileNameMd5(str2);
        this.mUrl = str2;
        this.fileInfo = new FileDesc(str, str2);
    }

    public static AudioFile getAudioFile(String str, String str2) throws FileNotFoundException, IOException {
        return new AudioFile(str, str2);
    }

    private synchronized int readChunkData(int i, byte[] bArr, int i2, int i3) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dirPath);
        stringBuilder.append("/");
        stringBuilder.append(this.fileName);
        stringBuilder.append(".chunk");
        RandomAccessFile randomAccessFile = new RandomAccessFile(stringBuilder.toString(), "r");
        String str = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("======================readChunkData0(");
        stringBuilder2.append(i);
        stringBuilder2.append(":");
        stringBuilder2.append(randomAccessFile.length());
        stringBuilder2.append(")");
        Logger.log(str, stringBuilder2.toString());
        randomAccessFile.seek((long) i);
        i = randomAccessFile.read(bArr, i2, i3);
        randomAccessFile.close();
        return i;
    }

    private synchronized int writeChunkData(byte[] bArr, int i, int i2) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.dirPath);
            stringBuilder.append("/");
            stringBuilder.append(this.fileName);
            stringBuilder.append(".chunk");
            RandomAccessFile randomAccessFile = new RandomAccessFile(stringBuilder.toString(), "rw");
            randomAccessFile.seek((long) (this.fileInfo.getDownloadedChunks() * 65536));
            randomAccessFile.write(bArr, i, i2);
            randomAccessFile.close();
        } catch (IOException unused) {
            return -1;
        }
        return i2;
    }

    public String getDirPath() {
        return this.dirPath;
    }

    public synchronized FileDesc getFileInfo() {
        return this.fileInfo;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFilePath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.dirPath);
        stringBuilder.append("/");
        stringBuilder.append(this.fileName);
        return stringBuilder.toString();
    }

    public String getUrl() {
        return this.mUrl;
    }

    public ByteBuffer getbBuffer() {
        return this.bBuffer;
    }

    public final synchronized boolean isChunkExists(int i) {
        return this.fileInfo.isChunkDownloaded(i);
    }

    public synchronized int readChunkData(int i, int i2, byte[] bArr, int i3) throws IOException {
        if (this.fileInfo.chunkExist.get(i)) {
            i2 = readChunkData(((Integer) this.fileInfo.chunkOffset.get(i)).intValue() * i2, bArr, i3, i2);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("======================readChunkData(");
            stringBuilder.append(i);
            stringBuilder.append(":");
            stringBuilder.append(i2);
            stringBuilder.append(")");
            Logger.log(str, stringBuilder.toString());
            return i2;
        }
        String str2 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("fileInfo.chunkExist.get(");
        stringBuilder2.append(i);
        stringBuilder2.append(")false");
        Logger.log(str2, stringBuilder2.toString());
        return -1;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setbBuffer(ByteBuffer byteBuffer) {
        this.bBuffer = byteBuffer;
    }

    /* JADX WARNING: Missing block: B:11:0x0017, code skipped:
            return;
     */
    public synchronized void writeChunkData(int r2, byte[] r3, int r4, int r5) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.fileInfo;	 Catch:{ all -> 0x0018 }
        r0 = r0.isChunkDownloaded(r2);	 Catch:{ all -> 0x0018 }
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        monitor-exit(r1);
        return;
    L_0x000b:
        r3 = r1.writeChunkData(r3, r4, r5);	 Catch:{ all -> 0x0018 }
        if (r3 <= 0) goto L_0x0016;
    L_0x0011:
        r3 = r1.fileInfo;	 Catch:{ all -> 0x0018 }
        r3.update(r2);	 Catch:{ all -> 0x0018 }
    L_0x0016:
        monitor-exit(r1);
        return;
    L_0x0018:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ximalaya.ting.android.player.AudioFile.writeChunkData(int, byte[], int, int):void");
    }

    public synchronized void writeFails(int i) {
        this.fileInfo.valid = false;
        this.fileInfo.statusCode = i;
    }
}
