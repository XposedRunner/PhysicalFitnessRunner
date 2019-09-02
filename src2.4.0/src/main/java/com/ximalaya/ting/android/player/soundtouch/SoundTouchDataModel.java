package com.ximalaya.ting.android.player.soundtouch;

public class SoundTouchDataModel {
    public byte[] inputDataBuf;
    public int inputDataLen = 0;
    public byte[] outputDataBuf;
    public int outputDatalen = 0;

    public SoundTouchDataModel(byte[] bArr, int i) {
        this.inputDataBuf = bArr;
        this.inputDataLen = i;
    }
}
