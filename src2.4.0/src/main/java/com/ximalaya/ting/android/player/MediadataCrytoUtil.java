package com.ximalaya.ting.android.player;

public class MediadataCrytoUtil {
    public static int ENCRYPT_DATA_LENGTH = 1024;
    private static MediadataCrytoUtil mInstance;
    private long ctx = initLogistic();

    static {
        try {
            System.loadLibrary("mediadatacryto");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private MediadataCrytoUtil() {
    }

    private native byte[] decryptData(long j, byte[] bArr, int i);

    private native void destroyEncryptCtx(long j);

    private native byte[] encryptData(long j, byte[] bArr, int i);

    public static synchronized MediadataCrytoUtil getInstance() {
        MediadataCrytoUtil mediadataCrytoUtil;
        synchronized (MediadataCrytoUtil.class) {
            if (mInstance == null) {
                mInstance = new MediadataCrytoUtil();
            }
            mediadataCrytoUtil = mInstance;
        }
        return mediadataCrytoUtil;
    }

    private native long initLogistic();

    public static void release() {
        if (mInstance != null) {
            mInstance.destroyEncryptCtx(mInstance.ctx);
            mInstance = null;
        }
    }

    public byte[] decryptData(byte[] bArr) {
        return decryptData(this.ctx, bArr, bArr.length);
    }

    public byte[] encryptData(byte[] bArr) {
        return encryptData(this.ctx, bArr, bArr.length);
    }
}
