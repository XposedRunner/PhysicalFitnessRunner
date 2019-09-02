package com.ximalaya.ting.android.opensdk.httputil.util;

import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONObject;

public class Util {
    public static String ConvertMap2HttpParams(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        TreeMap treeMap = new TreeMap();
        treeMap.putAll(map);
        for (Entry entry : treeMap.entrySet()) {
            String str = (String) entry.getValue();
            if (str != null) {
                stringBuilder.append((String) entry.getKey());
                stringBuilder.append("=");
                stringBuilder.append(str);
                stringBuilder.append("&");
            } else if (entry.getKey() != null) {
                map.remove(entry.getKey());
            }
        }
        if (!map.isEmpty() && stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public static JSONObject HttpParameters2Json(Map<String, Object> map) {
        return new JSONObject(map);
    }

    public static Map<String, String> cType(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            hashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        return hashMap;
    }

    public static Map<String, String> encoderName(Map<String, String> map) {
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (!str.equals(DTransferConstants.SEARCH_KEY)) {
                if (str.equals(DTransferConstants.TAG_NAME)) {
                }
            }
            Object obj = null;
            try {
                obj = URLEncoder.encode((String) entry.getValue(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            map.put(str, obj);
        }
        return map;
    }

    public static boolean isEmpty(String str) {
        return (TextUtils.isEmpty(str) || "null".equals(str)) ? false : true;
    }

    public static String readInputStream(InputStream inputStream) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return stringBuffer.toString();
            }
            stringBuffer.append(readLine.trim());
        }
    }
}
