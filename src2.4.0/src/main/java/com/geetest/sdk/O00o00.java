package com.geetest.sdk;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: GT3Encryption */
public final class O00o00 {
    public static String O000000o() {
        return O000000o("2A2C22122832442026360522203D055621252031353630243551343A262126360C223F25023430274741292B231C3734231D2823240B4A3D500E523D000B27523D131D2F2147225C2F11523F5B5450550C50174D2611121009353C540B012C3704251015173804030029075212341C3702073F0C0B1B101E33094C2F01462D56232E22203D065250332F1D3F532C123A043445570C1C370F2A30110C282D1C1E0224113F1722242716362210265C36040B5721263C1D2F362803023B3E3417023608422E1D104E185D1D27281424011714252E2124252431");
    }

    private static String O000000o(String str) {
        int i;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
        int i2 = 0;
        for (i = 0; i < str.length(); i += 2) {
            byteArrayOutputStream.write(("0123456789ABCDEF".indexOf(str.charAt(i)) << 4) | "0123456789ABCDEF".indexOf(str.charAt(i + 1)));
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        i = toByteArray.length;
        while (i2 < i) {
            toByteArray[i2] = (byte) (toByteArray[i2] ^ "geetest".charAt(i2 % 7));
            i2++;
        }
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(toByteArray);
    }
}
