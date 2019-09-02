package com.qiyukf.nimlib.h.c.a;

import com.alibaba.wireless.security.SecExceptionCode;
import java.security.PublicKey;
import javax.crypto.Cipher;

public final class b {
    public static byte[] a(PublicKey publicKey, byte[] bArr, int i, int i2) {
        if (bArr == null || i2 < 0 || i2 > bArr.length) {
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, publicKey);
            byte[] bArr2 = new byte[((((i2 - 1) / SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET) << 7) + 128)];
            int i3 = 0;
            while (i < i2) {
                int min = Math.min(i2 - (i3 * SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET), SecExceptionCode.SEC_ERROR_INIT_RESERVE_DEPENDENCY_NOT_MEET);
                byte[] doFinal = instance.doFinal(bArr, i, min);
                System.arraycopy(doFinal, 0, bArr2, i3 << 7, doFinal.length);
                i3++;
                i += min;
            }
            return bArr2;
        } catch (Exception unused) {
            return null;
        }
    }
}
