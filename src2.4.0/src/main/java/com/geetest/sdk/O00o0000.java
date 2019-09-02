package com.geetest.sdk;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* compiled from: CryptionUtils */
public final class O00o0000 {
    private static final byte[] O000000o = "0000000000000000".getBytes();
    private static final char[] O00000Oo = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static String O00000o0 = "RSA/ECB/PKCS1Padding";

    private static String O000000o(String str) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
        int i2 = 0;
        for (i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write(("0123456789ABCDEF".indexOf(str.charAt(i)) << 4) | "0123456789ABCDEF".indexOf(str.charAt(i + 1)));
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        i = toByteArray.length;
        while (i2 < i) {
            toByteArray[i2] = (byte) (toByteArray[i2] ^ "geetest".charAt(i2 % 7));
            i2++;
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(toByteArray);
    }

    public static String O000000o(String str, int i) {
        IvParameterSpec ivParameterSpec;
        switch (i) {
            case 1:
                O0OOO0O.O000000o = O0OOO0O.O000000o();
                try {
                    O00oo000.O000000o(O0OOO0O.O000000o, (RSAPublicKey) O00oo000.O000000o(O00o00.O000000o()));
                    PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(O000000o("2A2C22122832442026360522203D055621252031353630243551343A262126360C223F25023430274741292B231C3734231D2823240B4A3D500E523D000B27523D131D2F2147225C2F11523F5B5450550C50174D2611121009353C540B012C3704251015173804030029075212341C3702073F0C0B1B101E33094C2F01462D56232E22203D065250332F1D3F532C123A043445570C1C370F2A30110C282D1C1E0224113F1722242716362210265C36040B5721263C1D2F362803023B3E3417023608422E1D104E185D1D27281424011714252E2124252431"), 4)));
                    if (generatePublic == null) {
                        throw new Exception("加密公钥为空, 请设置");
                    }
                    Cipher instance = Cipher.getInstance(O00000o0);
                    instance.init(1, generatePublic);
                    String O000000o = O000000o(instance.doFinal(O0OOO0O.O000000o.getBytes()));
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("lang", str);
                    try {
                        ivParameterSpec = new IvParameterSpec(O000000o);
                        SecretKeySpec secretKeySpec = new SecretKeySpec(O0OOO0O.O000000o.getBytes(), "AES");
                        Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
                        byte[] bytes = jSONObject.toString().getBytes("utf-8");
                        instance2.init(1, secretKeySpec, ivParameterSpec);
                        str = String.valueOf(O00o000.O000000o(instance2.doFinal(bytes)));
                        StringBuilder stringBuilder = new StringBuilder("&w=");
                        stringBuilder.append(str);
                        stringBuilder.append(O000000o);
                        return stringBuilder.toString();
                    } catch (NoSuchPaddingException e) {
                        e.printStackTrace();
                        return null;
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                        return null;
                    } catch (UnsupportedEncodingException e3) {
                        e3.printStackTrace();
                        return null;
                    } catch (InvalidKeyException e4) {
                        e4.printStackTrace();
                        return null;
                    } catch (IllegalBlockSizeException e5) {
                        e5.printStackTrace();
                        return null;
                    } catch (BadPaddingException e6) {
                        e6.printStackTrace();
                        return null;
                    } catch (InvalidAlgorithmParameterException e7) {
                        e7.printStackTrace();
                        return null;
                    }
                } catch (NoSuchAlgorithmException unused) {
                    throw new Exception("无此加密算法");
                } catch (NoSuchPaddingException e8) {
                    e8.printStackTrace();
                    return null;
                } catch (InvalidKeyException unused2) {
                    throw new Exception("加密公钥非法,请检查");
                } catch (IllegalBlockSizeException unused3) {
                    throw new Exception("明文长度非法");
                } catch (BadPaddingException unused4) {
                    throw new Exception("明文数据已损坏");
                } catch (Exception e9) {
                    e9.printStackTrace();
                    return null;
                }
            case 2:
                try {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jSONObject2.put("sign", String.valueOf(O00o000.O000000o(O00o0.O000000o(jSONObject2.getString("mi"), "e6OXZ8q2cdJQctncOhd4qyT8iR32jZwU"))));
                    ivParameterSpec = new IvParameterSpec(O000000o);
                    SecretKeySpec secretKeySpec2 = new SecretKeySpec(O0OOO0O.O000000o.getBytes(), "AES");
                    Cipher instance3 = Cipher.getInstance("AES/CBC/PKCS5Padding");
                    byte[] bytes2 = jSONObject2.toString().getBytes("utf-8");
                    instance3.init(1, secretKeySpec2, ivParameterSpec);
                    return String.valueOf(O00o000.O000000o(instance3.doFinal(bytes2)));
                } catch (NoSuchPaddingException e82) {
                    e82.printStackTrace();
                    return null;
                } catch (NoSuchAlgorithmException e22) {
                    e22.printStackTrace();
                    return null;
                } catch (UnsupportedEncodingException e32) {
                    e32.printStackTrace();
                    return null;
                } catch (InvalidKeyException e42) {
                    e42.printStackTrace();
                    return null;
                } catch (IllegalBlockSizeException e52) {
                    e52.printStackTrace();
                    return null;
                } catch (BadPaddingException e62) {
                    e62.printStackTrace();
                    return null;
                } catch (InvalidAlgorithmParameterException e72) {
                    e72.printStackTrace();
                    return null;
                } catch (Exception e92) {
                    e92.printStackTrace();
                    return null;
                }
            default:
                return null;
        }
    }

    private static String O000000o(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            stringBuilder.append(O00000Oo[(bArr[i] >> 4) & 15]);
            stringBuilder.append(O00000Oo[bArr[i] & 15]);
        }
        return stringBuilder.toString();
    }
}
