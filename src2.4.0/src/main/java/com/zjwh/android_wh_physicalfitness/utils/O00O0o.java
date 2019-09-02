package com.zjwh.android_wh_physicalfitness.utils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: SignCode */
public class O00O0o {
    private static String O000000o(String str) {
        try {
            int i;
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            char[] toCharArray = str.toCharArray();
            int i2 = 0;
            byte[] bArr = new byte[toCharArray.length];
            for (i = 0; i < toCharArray.length; i++) {
                bArr[i] = (byte) toCharArray[i];
            }
            byte[] digest = instance.digest(bArr);
            StringBuilder stringBuilder = new StringBuilder();
            int length = digest.length;
            while (i2 < length) {
                i = digest[i2] & 255;
                if (i < 16) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(Integer.toHexString(i));
                i2++;
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
    }

    public static String O000000o(Map<String, Object> map) {
        return O00000o0(O00000Oo(map));
    }

    public static String O000000o(Map<String, Object> map, String str) {
        return O000000o(O00000Oo(O00000Oo(map), str));
    }

    private static String O00000Oo(Map<String, Object> map, String str) {
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            String str2 = (String) arrayList.get(i);
            Object obj = map.get(str2);
            if (i == arrayList.size() - 1) {
                stringBuilder.append(str2);
                stringBuilder.append("=");
                stringBuilder.append(obj);
            } else {
                stringBuilder.append(str2);
                stringBuilder.append("=");
                stringBuilder.append(obj);
                stringBuilder.append("&");
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(stringBuilder.toString());
        stringBuilder2.append(str);
        return stringBuilder2.toString();
    }

    private static Map<String, Object> O00000Oo(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map == null || map.size() <= 0) {
            return hashMap;
        }
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj != null) {
                if (!str.equalsIgnoreCase("signature")) {
                    hashMap.put(str, obj);
                }
            }
        }
        return hashMap;
    }

    private static String O00000o0(Map<String, Object> map) {
        ArrayList arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            Object obj = map.get(str);
            if (i == arrayList.size() - 1) {
                stringBuilder.append(str);
                stringBuilder.append("=");
                stringBuilder.append(obj);
            } else {
                stringBuilder.append(str);
                stringBuilder.append("=");
                stringBuilder.append(obj);
                stringBuilder.append("&");
            }
        }
        return stringBuilder.toString();
    }
}
