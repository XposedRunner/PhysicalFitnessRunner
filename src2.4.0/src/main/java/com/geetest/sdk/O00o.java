package com.geetest.sdk;

import cn.jiguang.net.HttpUtils;
import java.io.UnsupportedEncodingException;

/* compiled from: GT3StringUtil */
public final class O00o {
    private static final char[] O000000o = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] O000000o(String str) {
        byte[] bArr = new byte[0];
        try {
            return str.getBytes(HttpUtils.ENCODING_UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return bArr;
        }
    }
}
