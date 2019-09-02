package com.ximalaya.ting.android.player;

import android.text.TextUtils;
import java.math.BigInteger;
import java.security.MessageDigest;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class MD5 {
    public static String getFileNameMd5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf("?");
        int indexOf2 = str.indexOf("/", "http://".length());
        if (indexOf == -1) {
            indexOf = str.length();
        }
        return md5(str.substring(indexOf2, indexOf));
    }

    public static String md5(String str) {
        if (str != null) {
            try {
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                instance.update(str.getBytes());
                String bigInteger = new BigInteger(1, instance.digest()).toString(16);
                while (true) {
                    str = bigInteger;
                    if (str.length() >= 32) {
                        break;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("0");
                    stringBuilder.append(str);
                    bigInteger = stringBuilder.toString();
                }
            } catch (Exception e) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("md5加密出错");
                stringBuilder2.append(e.getMessage());
                Logger.log(stringBuilder2.toString());
            }
        }
        return str;
    }

    public static String md5(byte[] bArr) {
        String str = "";
        if (bArr != null) {
            try {
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                instance.update(bArr);
                String bigInteger = new BigInteger(1, instance.digest()).toString(16);
                while (true) {
                    str = bigInteger;
                    if (str.length() >= 32) {
                        break;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("0");
                    stringBuilder.append(str);
                    bigInteger = stringBuilder.toString();
                }
            } catch (Exception e) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("md5加密出错");
                stringBuilder2.append(e.getMessage());
                Logger.log(stringBuilder2.toString());
            }
        }
        return str;
    }
}
