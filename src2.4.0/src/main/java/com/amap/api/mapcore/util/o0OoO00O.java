package com.amap.api.mapcore.util;

import android.support.v4.view.PointerIconCompat;
import com.alibaba.wireless.security.SecExceptionCode;
import com.amap.api.maps.AMapException;

/* compiled from: AMapException */
public class o0OoO00O extends Exception {
    private String O000000o = "";
    private int O00000Oo = 1000;

    public o0OoO00O(String str) {
        super(str);
        this.O000000o = str;
        O000000o(str);
    }

    private void O000000o(String str) {
        if ("用户签名未通过".equals(str)) {
            this.O00000Oo = 1001;
        } else if ("用户key不正确或过期".equals(str)) {
            this.O00000Oo = 1002;
        } else if ("请求服务不存在".equals(str)) {
            this.O00000Oo = 1003;
        } else if ("访问已超出日访问量".equals(str)) {
            this.O00000Oo = 1004;
        } else if ("用户访问过于频繁".equals(str)) {
            this.O00000Oo = 1005;
        } else if ("用户IP无效".equals(str)) {
            this.O00000Oo = 1006;
        } else if ("用户域名无效".equals(str)) {
            this.O00000Oo = 1007;
        } else if ("用户MD5安全码未通过".equals(str)) {
            this.O00000Oo = 1008;
        } else if ("请求key与绑定平台不符".equals(str)) {
            this.O00000Oo = 1009;
        } else if ("IP访问超限".equals(str)) {
            this.O00000Oo = 1010;
        } else if ("服务不支持https请求".equals(str)) {
            this.O00000Oo = 1011;
        } else if ("权限不足，服务请求被拒绝".equals(str)) {
            this.O00000Oo = PointerIconCompat.TYPE_NO_DROP;
        } else if ("开发者删除了key，key被删除后无法正常使用".equals(str)) {
            this.O00000Oo = PointerIconCompat.TYPE_ALL_SCROLL;
        } else if ("请求服务响应错误".equals(str)) {
            this.O00000Oo = 1100;
        } else if ("引擎返回数据异常".equals(str)) {
            this.O00000Oo = 1101;
        } else if ("服务端请求链接超时".equals(str)) {
            this.O00000Oo = 1102;
        } else if ("读取服务结果超时".equals(str)) {
            this.O00000Oo = SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_LENGTH;
        } else if ("请求参数非法".equals(str)) {
            this.O00000Oo = 1200;
        } else if ("缺少必填参数".equals(str)) {
            this.O00000Oo = 1201;
        } else if ("请求协议非法".equals(str)) {
            this.O00000Oo = 1202;
        } else if ("其他未知错误".equals(str)) {
            this.O00000Oo = 1203;
        } else if (AMapException.ERROR_PROTOCOL.equals(str)) {
            this.O00000Oo = 1801;
        } else if (AMapException.ERROR_SOCKE_TIME_OUT.equals(str)) {
            this.O00000Oo = 1802;
        } else if (AMapException.ERROR_URL.equals(str)) {
            this.O00000Oo = 1803;
        } else if (AMapException.ERROR_UNKNOW_HOST.equals(str)) {
            this.O00000Oo = 1804;
        } else if ("未知错误".equals(str)) {
            this.O00000Oo = 1900;
        } else if (AMapException.ERROR_INVALID_PARAMETER.equals(str)) {
            this.O00000Oo = SecExceptionCode.SEC_ERROR_GENERIC_AVMP_INVALID_ARGS;
        } else if ("http或socket连接失败 - ConnectionException".equals(str)) {
            this.O00000Oo = 1806;
        } else if (AMapException.ERROR_IO.equals(str)) {
            this.O00000Oo = SecExceptionCode.SEC_ERROR_GENERIC_AVMP_JPG_FILE_MISMATCH;
        } else if (AMapException.ERROR_NULL_PARAMETER.equals(str)) {
            this.O00000Oo = SecExceptionCode.SEC_ERROR_GENERIC_AVMP_INCORRECT_JPG_FILE;
        } else {
            this.O00000Oo = 1800;
        }
    }

    public String O000000o() {
        return this.O000000o;
    }
}
