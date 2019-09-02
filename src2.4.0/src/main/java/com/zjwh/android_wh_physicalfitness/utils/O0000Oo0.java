package com.zjwh.android_wh_physicalfitness.utils;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;

/* compiled from: BaseCode64 */
public class O0000Oo0 {
    public static String O000000o(String str) {
        try {
            return new String(Base64.encodeBase64(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}
