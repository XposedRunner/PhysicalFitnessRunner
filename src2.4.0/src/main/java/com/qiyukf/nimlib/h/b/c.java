package com.qiyukf.nimlib.h.b;

public interface c {

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;
        public static final int h = 8;

        static {
            i = new int[]{a, b, c, d, e, f, g, h};
        }

        public static int[] a() {
            return (int[]) i.clone();
        }
    }
}
