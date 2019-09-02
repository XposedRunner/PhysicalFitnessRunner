package com.zjwh.android_wh_physicalfitness.utils;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/* compiled from: MacSignature */
public class O00O000o {
    public static String O000000o(String str, String str2) throws InvalidKeyException, NoSuchAlgorithmException {
        Charset forName = Charset.forName("UTF-8");
        String str3 = "HmacSHA1";
        Mac instance = Mac.getInstance(str3);
        instance.init(new SecretKeySpec(str2.getBytes(forName), str3));
        return new String(Base64.encodeBase64(instance.doFinal(str.getBytes(forName))), forName);
    }

    public static String O000000o(String str, String str2, String str3) throws NoSuchAlgorithmException, InvalidKeyException {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return O000000o(arrayList, str2, str3);
    }

    public static String O000000o(List<String> list, String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        Collections.sort(list);
        String str3 = "";
        for (String str4 : list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append(str4);
            stringBuilder.append("\n");
            str3 = stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str3);
        stringBuilder2.append(str);
        return O000000o(stringBuilder2.toString(), str2);
    }

    public static String O00000Oo(String str, String str2) throws NoSuchAlgorithmException, InvalidKeyException {
        return O000000o(str, str2);
    }
}
