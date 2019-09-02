package com.ximalaya.ting.android.player.model;

public class JNIDataModel {
    public byte[] buf;
    public int bufSize = 0;
    public String filePath;
    public long fileSize = 0;
    public int status;

    public JNIDataModel(String str, long j, byte[] bArr, int i, int i2) {
        this.filePath = str;
        this.fileSize = j;
        this.buf = bArr;
        this.bufSize = i;
        this.status = i2;
    }

    public JNIDataModel(byte[] bArr, int i, int i2) {
        this.buf = bArr;
        this.bufSize = i;
        this.status = i2;
    }
}
