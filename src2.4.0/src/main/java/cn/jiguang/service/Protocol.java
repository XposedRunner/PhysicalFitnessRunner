package cn.jiguang.service;

public class Protocol {
    static {
        try {
            System.loadLibrary("jcore126");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static native int GetSdkVersion();

    public static native String getCerTificate();
}
