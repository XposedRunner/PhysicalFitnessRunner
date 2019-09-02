package com.amap.api.mapcore.util;

import java.util.Locale;
import java.util.Random;

/* compiled from: RandomUtil */
public class OOOOo0 {
    private static String O000000o = "0123456789";

    /* compiled from: RandomUtil */
    static class O000000o {
        private String O000000o;
        private int O00000Oo;
        private int O00000o0;

        public O000000o() {
            this(11);
        }

        public O000000o(int i) {
            this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", i);
        }

        public O000000o(String str, int i) {
            this.O00000Oo = 1103515245;
            this.O00000o0 = 12345;
            this.O000000o = O000000o(str, i, str.length());
        }

        public char O000000o(int i, boolean z) {
            int length = this.O000000o.length();
            if (z) {
                i = length - i;
            }
            return this.O000000o.charAt(i);
        }

        public int O000000o(char c, boolean z) {
            int length = this.O000000o.length();
            int indexOf = this.O000000o.indexOf(c);
            return z ? length - indexOf : indexOf;
        }

        public int O000000o(int i) {
            return (int) (((((long) i) * ((long) this.O00000Oo)) + ((long) this.O00000o0)) & 2147483647L);
        }

        public String O000000o(int i, String str) {
            return O000000o(false, i, str);
        }

        public String O000000o(String str, int i, int i2) {
            StringBuffer stringBuffer = new StringBuffer(str);
            int length = str.length();
            for (int i3 = 0; i3 < i2; i3++) {
                i = O000000o(i);
                int i4 = i % length;
                i = O000000o(i);
                int i5 = i % length;
                char charAt = stringBuffer.charAt(i4);
                stringBuffer.setCharAt(i4, stringBuffer.charAt(i5));
                stringBuffer.setCharAt(i5, charAt);
            }
            return stringBuffer.toString();
        }

        public String O000000o(boolean z, int i, String str) {
            StringBuilder stringBuilder = new StringBuilder();
            int length = this.O000000o.length();
            int length2 = str.length();
            for (int i2 = 0; i2 < length2; i2++) {
                int O000000o = O000000o(str.charAt(i2), z);
                if (O000000o < 0) {
                    break;
                }
                stringBuilder.append(O000000o(((O000000o + i) + i2) % length, z));
            }
            return stringBuilder.length() == length2 ? stringBuilder.toString() : null;
        }
    }

    public static String O000000o() {
        Random random = new Random();
        int nextInt = random.nextInt(10);
        String format = String.format(Locale.US, "%05d", new Object[]{Integer.valueOf(nextInt)});
        format = new O000000o(O000000o, random.nextInt(100)).O000000o(random.nextInt(10), format);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(format);
        stringBuilder.append(String.format(Locale.US, "%01d", new Object[]{Integer.valueOf(r1)}));
        stringBuilder.append(String.format(Locale.US, "%02d", new Object[]{Integer.valueOf(r0)}));
        return stringBuilder.toString();
    }
}
