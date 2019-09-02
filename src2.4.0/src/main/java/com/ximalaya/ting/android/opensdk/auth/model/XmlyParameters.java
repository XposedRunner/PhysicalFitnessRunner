package com.ximalaya.ting.android.opensdk.auth.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.ximalaya.ting.android.opensdk.auth.utils.Logger;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Set;

public class XmlyParameters {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private String mAppKey;
    private LinkedHashMap<String, Object> mParams = new LinkedHashMap();

    public XmlyParameters(String str) {
        this.mAppKey = str;
    }

    public boolean containsKey(String str) {
        return this.mParams.containsKey(str);
    }

    public boolean containsValue(String str) {
        return this.mParams.containsValue(str);
    }

    public String encodeAllUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : this.mParams.keySet()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("&");
            }
            Object obj2 = this.mParams.get(str);
            if (obj2 instanceof String) {
                String str2 = (String) obj2;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(URLEncoder.encode(str, "UTF-8"));
                        stringBuilder2.append("=");
                        stringBuilder2.append(URLEncoder.encode(str2, "UTF-8"));
                        stringBuilder.append(stringBuilder2.toString());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                Logger.i("encodeUrl", stringBuilder.toString());
            }
        }
        return stringBuilder.toString();
    }

    public String encodeUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : this.mParams.keySet()) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append("&");
            }
            Object obj2 = this.mParams.get(str);
            if (obj2 instanceof String) {
                String str2 = (String) obj2;
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(URLEncoder.encode(str, "UTF-8"));
                        stringBuilder2.append("=");
                        stringBuilder2.append(URLEncoder.encode(str2, "UTF-8"));
                        stringBuilder.append(stringBuilder2.toString());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
                Logger.i("encodeUrl", stringBuilder.toString());
            }
        }
        return stringBuilder.toString();
    }

    public Object get(String str) {
        return this.mParams.get(str);
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public LinkedHashMap<String, Object> getParams() {
        return this.mParams;
    }

    public boolean hasBinaryData() {
        for (String str : this.mParams.keySet()) {
            Object obj = this.mParams.get(str);
            if (!(obj instanceof ByteArrayOutputStream)) {
                if (obj instanceof Bitmap) {
                }
            }
            return true;
        }
        return false;
    }

    public Set<String> keySet() {
        return this.mParams.keySet();
    }

    public void put(String str, int i) {
        this.mParams.put(str, String.valueOf(i));
    }

    public void put(String str, long j) {
        this.mParams.put(str, String.valueOf(j));
    }

    public void put(String str, Bitmap bitmap) {
        this.mParams.put(str, bitmap);
    }

    public void put(String str, Object obj) {
        this.mParams.put(str, obj.toString());
    }

    public void put(String str, String str2) {
        this.mParams.put(str, str2);
    }

    public void remove(String str) {
        if (this.mParams.containsKey(str)) {
            this.mParams.remove(str);
            this.mParams.remove(this.mParams.get(str));
        }
    }

    public void setParams(LinkedHashMap<String, Object> linkedHashMap) {
        this.mParams = linkedHashMap;
    }

    public int size() {
        return this.mParams.size();
    }
}
