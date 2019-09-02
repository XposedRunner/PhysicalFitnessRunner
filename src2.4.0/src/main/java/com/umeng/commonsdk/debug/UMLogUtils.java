package com.umeng.commonsdk.debug;

public class UMLogUtils {
    public static String makeUrl(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://developer.umeng.com/docs/66632/detail/");
        stringBuilder.append(str);
        stringBuilder.append("?um_channel=sdk");
        return stringBuilder.toString();
    }
}
