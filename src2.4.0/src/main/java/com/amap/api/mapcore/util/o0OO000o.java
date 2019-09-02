package com.amap.api.mapcore.util;

import cn.jiguang.net.HttpUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: Encrypt */
public class o0OO000o {
    private static final char[] O000000o = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] O00000Oo = new byte[128];

    static {
        int i;
        for (int i2 = 0; i2 < 128; i2++) {
            O00000Oo[i2] = (byte) -1;
        }
        for (i = 65; i <= 90; i++) {
            O00000Oo[i] = (byte) (i - 65);
        }
        for (i = 97; i <= SecExceptionCode.SEC_ERROR_INIT_NO_DATA_FILE; i++) {
            O00000Oo[i] = (byte) ((i - 97) + 26);
        }
        for (i = 48; i <= 57; i++) {
            O00000Oo[i] = (byte) ((i - 48) + 52);
        }
        O00000Oo[43] = (byte) 62;
        O00000Oo[47] = (byte) 63;
    }

    public static String O000000o(String str) {
        return o0OOOO00.O000000o(O00000Oo(str));
    }

    public static byte[] O000000o(byte[] bArr) throws CertificateException, InvalidKeySpecException, NoSuchAlgorithmException, NullPointerException, IOException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        Key O00000o = o0OOOO00.O00000o();
        if (O00000o == null) {
            return null;
        }
        byte[] O000000o = O000000o(encoded, O00000o);
        bArr = O000000o(encoded, bArr);
        byte[] bArr2 = new byte[(O000000o.length + bArr.length)];
        System.arraycopy(O000000o, 0, bArr2, 0, O000000o.length);
        System.arraycopy(bArr, 0, bArr2, O000000o.length, bArr.length);
        return bArr2;
    }

    static byte[] O000000o(byte[] bArr, Key key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher instance = Cipher.getInstance(o0OOOO00.O00000o0(oO0Ooo00.O000000o));
        instance.init(1, key);
        return instance.doFinal(bArr);
    }

    static byte[] O000000o(byte[] bArr, byte[] bArr2) {
        try {
            return O00000Oo(bArr, bArr2);
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "er", "asEn");
            return null;
        }
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        return O00000o(bArr, bArr2, bArr3);
    }

    public static String O00000Oo(byte[] bArr) {
        try {
            return O00000o(bArr);
        } catch (Throwable th) {
            oO0OoOO0.O000000o(th, "er", "e64");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009c A:{SYNTHETIC, EDGE_INSN: B:52:0x009c->B:43:0x009c ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026 A:{LOOP_START, LOOP:2: B:11:0x0026->B:14:0x0033, PHI: r4 } */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009c A:{SYNTHETIC, EDGE_INSN: B:50:0x009c->B:43:0x009c ?: BREAK  } */
    public static byte[] O00000Oo(java.lang.String r8) {
        /*
        r0 = 0;
        if (r8 != 0) goto L_0x0006;
    L_0x0003:
        r8 = new byte[r0];
        return r8;
    L_0x0006:
        r8 = com.amap.api.mapcore.util.o0OOOO00.O000000o(r8);
        r1 = r8.length;
        r2 = new java.io.ByteArrayOutputStream;
        r2.<init>(r1);
    L_0x0010:
        if (r0 >= r1) goto L_0x009c;
    L_0x0012:
        r3 = O00000Oo;
        r4 = r0 + 1;
        r0 = r8[r0];
        r0 = r3[r0];
        r3 = -1;
        if (r4 >= r1) goto L_0x0022;
    L_0x001d:
        if (r0 == r3) goto L_0x0020;
    L_0x001f:
        goto L_0x0022;
    L_0x0020:
        r0 = r4;
        goto L_0x0012;
    L_0x0022:
        if (r0 != r3) goto L_0x0026;
    L_0x0024:
        goto L_0x009c;
    L_0x0026:
        r5 = O00000Oo;
        r6 = r4 + 1;
        r4 = r8[r4];
        r4 = r5[r4];
        if (r6 >= r1) goto L_0x0035;
    L_0x0030:
        if (r4 == r3) goto L_0x0033;
    L_0x0032:
        goto L_0x0035;
    L_0x0033:
        r4 = r6;
        goto L_0x0026;
    L_0x0035:
        if (r4 != r3) goto L_0x0039;
    L_0x0037:
        goto L_0x009c;
    L_0x0039:
        r0 = r0 << 2;
        r5 = r4 & 48;
        r5 = r5 >>> 4;
        r0 = r0 | r5;
        r2.write(r0);
    L_0x0043:
        if (r6 != r1) goto L_0x004a;
    L_0x0045:
        r8 = r2.toByteArray();
        return r8;
    L_0x004a:
        r0 = r6 + 1;
        r5 = r8[r6];
        r6 = 61;
        if (r5 != r6) goto L_0x0057;
    L_0x0052:
        r8 = r2.toByteArray();
        return r8;
    L_0x0057:
        r7 = O00000Oo;
        r5 = r7[r5];
        if (r0 >= r1) goto L_0x0062;
    L_0x005d:
        if (r5 == r3) goto L_0x0060;
    L_0x005f:
        goto L_0x0062;
    L_0x0060:
        r6 = r0;
        goto L_0x0043;
    L_0x0062:
        if (r5 != r3) goto L_0x0065;
    L_0x0064:
        goto L_0x009c;
    L_0x0065:
        r4 = r4 & 15;
        r4 = r4 << 4;
        r7 = r5 & 60;
        r7 = r7 >>> 2;
        r4 = r4 | r7;
        r2.write(r4);
    L_0x0071:
        if (r0 != r1) goto L_0x0078;
    L_0x0073:
        r8 = r2.toByteArray();
        return r8;
    L_0x0078:
        r4 = r0 + 1;
        r0 = r8[r0];
        if (r0 != r6) goto L_0x0083;
    L_0x007e:
        r8 = r2.toByteArray();
        return r8;
    L_0x0083:
        r7 = O00000Oo;
        r0 = r7[r0];
        if (r4 >= r1) goto L_0x008e;
    L_0x0089:
        if (r0 == r3) goto L_0x008c;
    L_0x008b:
        goto L_0x008e;
    L_0x008c:
        r0 = r4;
        goto L_0x0071;
    L_0x008e:
        if (r0 != r3) goto L_0x0091;
    L_0x0090:
        goto L_0x009c;
    L_0x0091:
        r3 = r5 & 3;
        r3 = r3 << 6;
        r0 = r0 | r3;
        r2.write(r0);
        r0 = r4;
        goto L_0x0010;
    L_0x009c:
        r8 = r2.toByteArray();
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.o0OO000o.O00000Oo(java.lang.String):byte[]");
    }

    private static byte[] O00000Oo(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        return O00000o0(bArr, bArr2, o0OOOO00.O00000o0());
    }

    public static byte[] O00000Oo(byte[] bArr, byte[] bArr2, byte[] bArr3) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        return O00000o0(bArr, bArr2, bArr3);
    }

    private static String O00000o(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int length = bArr.length;
        while (i < length) {
            int i2 = i + 1;
            i = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(O000000o[i >>> 2]);
                stringBuffer.append(O000000o[(i & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i3 = i2 + 1;
            i2 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(O000000o[i >>> 2]);
                stringBuffer.append(O000000o[((i & 3) << 4) | ((i2 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >>> 4)]);
                stringBuffer.append(O000000o[(i2 & 15) << 2]);
                stringBuffer.append(HttpUtils.EQUAL_SIGN);
                break;
            }
            int i4 = i3 + 1;
            i3 = bArr[i3] & 255;
            stringBuffer.append(O000000o[i >>> 2]);
            stringBuffer.append(O000000o[((i & 3) << 4) | ((i2 & GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN) >>> 4)]);
            stringBuffer.append(O000000o[((i2 & 15) << 2) | ((i3 & 192) >>> 6)]);
            stringBuffer.append(O000000o[i3 & 63]);
            i = i4;
        }
        return stringBuffer.toString();
    }

    private static byte[] O00000o(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, ivParameterSpec);
        return instance.doFinal(bArr2);
    }

    public static String O00000o0(byte[] bArr) {
        try {
            return O00000o(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] O00000o0(byte[] bArr, byte[] bArr2, byte[] bArr3) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        try {
            instance.init(1, secretKeySpec, ivParameterSpec);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return instance.doFinal(bArr2);
    }
}
