package com.baidu.mapsdkplatform.comjni.util;

public class JNIMD5 {
    public static native String encodeUrlParamsValue(String str);

    public static native String getSignMD5String(String str);
}
