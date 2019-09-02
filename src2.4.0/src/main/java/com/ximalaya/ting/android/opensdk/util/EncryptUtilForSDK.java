package com.ximalaya.ting.android.opensdk.util;

import android.content.Context;

public class EncryptUtilForSDK {
    private static EncryptUtilForSDK mInstance;
    private Context mContext;

    static {
        try {
            System.loadLibrary("xmopendatacrypto");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized EncryptUtilForSDK getInstance() {
        EncryptUtilForSDK encryptUtilForSDK;
        synchronized (EncryptUtilForSDK.class) {
            if (mInstance == null) {
                synchronized (EncryptUtilForSDK.class) {
                    if (mInstance == null) {
                        mInstance = new EncryptUtilForSDK();
                    }
                }
            }
            encryptUtilForSDK = mInstance;
        }
        return encryptUtilForSDK;
    }

    public static void release() {
        mInstance = null;
    }

    public byte[] decryptByKey2(byte[] bArr) {
        byte[] bArr2 = new byte[0];
        try {
            return decryptByPublicKey2(this.mContext, bArr, PayUtil.getKey0(), PayUtil.getKey1(), this.mContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return bArr2;
        }
    }

    public native byte[] decryptByPublicKey2(Context context, byte[] bArr, String str, String str2, String str3) throws Exception;

    public native String decryptRc4ByPublicKey(Context context, String str, String str2, String str3) throws Exception;

    public String decryptRc4ByPublicKey(String str) {
        try {
            return decryptRc4ByPublicKey(this.mContext, str, PayUtil.getName1(), this.mContext.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void init(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
    }
}
