package com.zjwh.android_wh_physicalfitness.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESUtils */
public class O000000o {
    private static O000000o O00000Oo;
    private String O000000o = "smkldospdosldaaa";

    O000000o() {
    }

    public static O000000o O000000o() {
        if (O00000Oo == null) {
            O00000Oo = new O000000o();
        }
        return O00000Oo;
    }

    public String O000000o(String str) throws Exception {
        try {
            Cipher instance = Cipher.getInstance("AES");
            instance.init(1, new SecretKeySpec(this.O000000o.getBytes(), "AES"));
            return new O00000Oo().O000000o(instance.doFinal(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String O000000o(String str, String str2) throws Exception {
        try {
            Cipher instance = Cipher.getInstance("AES");
            instance.init(1, new SecretKeySpec(str2.getBytes(), "AES"));
            return new O00000Oo().O000000o(instance.doFinal(str.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String O00000Oo(String str) throws Exception {
        try {
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, new SecretKeySpec(this.O000000o.getBytes(), "AES"));
            return new String(instance.doFinal(new O000000o().O000000o(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String O00000Oo(String str, String str2) throws Exception {
        try {
            Cipher instance = Cipher.getInstance("AES");
            instance.init(2, new SecretKeySpec(str2.getBytes(), "AES"));
            return new String(instance.doFinal(new O000000o().O000000o(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
