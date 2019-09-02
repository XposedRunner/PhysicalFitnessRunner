package com.ximalaya.ting.android.opensdk.httputil.util;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SignatureUtil {
    public static String caculateSignature(String str, Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            stringBuffer.append((String) entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append((String) entry.getValue());
            stringBuffer.append("&");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        try {
            return CrypterUtil.hmacSHA1ToStr(BASE64Encoder.encode(stringBuffer.toString()), str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String generateSignature(String str, Map<String, String> map) {
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(map);
        return caculateSignature(str, treeMap);
    }
}
