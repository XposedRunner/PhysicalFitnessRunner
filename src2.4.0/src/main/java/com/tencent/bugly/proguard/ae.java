package com.tencent.bugly.proguard;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
public final class ae implements ag {
    private String a = null;

    public final void a(String str) {
        if (str != null) {
            for (int length = str.length(); length < 16; length++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("0");
                str = stringBuilder.toString();
            }
            this.a = str.substring(0, 16);
        }
    }

    public final byte[] a(byte[] bArr) throws Exception {
        if (this.a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (byte b : bArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append(" ");
            stringBuffer.append(stringBuilder.toString());
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.a.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(this.a.getBytes()));
        bArr = instance.doFinal(bArr);
        stringBuffer = new StringBuffer();
        int length = bArr.length;
        while (i < length) {
            byte b2 = bArr[i];
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(b2);
            stringBuilder2.append(" ");
            stringBuffer.append(stringBuilder2.toString());
            i++;
        }
        return bArr;
    }

    public final byte[] b(byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (this.a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (byte b : bArr) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append(" ");
            stringBuffer.append(stringBuilder.toString());
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.a.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(this.a.getBytes()));
        bArr = instance.doFinal(bArr);
        stringBuffer = new StringBuffer();
        int length = bArr.length;
        while (i < length) {
            byte b2 = bArr[i];
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(b2);
            stringBuilder2.append(" ");
            stringBuffer.append(stringBuilder2.toString());
            i++;
        }
        return bArr;
    }
}
