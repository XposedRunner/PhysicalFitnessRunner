package com.geetest.sdk;

import java.util.Random;

/* compiled from: GT3RandomUtil */
public final class O0OOO0O {
    public static String O000000o = "";

    public static String O000000o() {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            stringBuffer.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(36)));
        }
        return stringBuffer.toString();
    }
}
