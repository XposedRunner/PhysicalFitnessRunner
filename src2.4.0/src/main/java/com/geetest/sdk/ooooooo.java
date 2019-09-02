package com.geetest.sdk;

import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: Md5Utils */
public final class ooooooo {
    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    toHexString = "0".concat(String.valueOf(toHexString));
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(toHexString);
                str2 = stringBuilder.toString();
            }
            return str2;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
