package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapException;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CoreUtil */
public class o0O00Oo0 {
    private static String[] O000000o = new String[]{"com.amap.api.trace", "com.amap.api.trace.core"};

    public static int O000000o(List<LatLng> list) {
        int i = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i2 = 0;
        while (i < list.size() - 1) {
            LatLng latLng = (LatLng) list.get(i);
            i++;
            LatLng latLng2 = (LatLng) list.get(i);
            if (latLng == null || latLng2 == null) {
                return i2;
            }
            i2 = (int) (((float) i2) + AMapUtils.calculateLineDistance(latLng, latLng2));
        }
        return i2;
    }

    protected static void O000000o(int i, String str, String str2) throws o0OoO00O {
        if (i != 0) {
            switch (i) {
                case 10000:
                    return;
                case 10001:
                    throw new o0OoO00O("用户key不正确或过期");
                case 10002:
                    throw new o0OoO00O("请求服务不存在");
                case 10003:
                    throw new o0OoO00O("访问已超出日访问量");
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_ROLE_TYPE_ERROR /*10004*/:
                    throw new o0OoO00O("用户访问过于频繁");
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_USER_ID_NULL /*10005*/:
                    throw new o0OoO00O("用户IP无效");
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_DRIVER_ID_NULL /*10006*/:
                    throw new o0OoO00O("用户域名无效");
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_BAIDUMAP_NULL /*10007*/:
                    throw new o0OoO00O("用户签名未通过");
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_NULL /*10008*/:
                    throw new o0OoO00O("用户MD5安全码未通过");
                case HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_QUERY_RESULT_PARSER_FAILED /*10009*/:
                    throw new o0OoO00O("请求key与绑定平台不符");
                case 10010:
                    throw new o0OoO00O("IP访问超限");
                case 10011:
                    throw new o0OoO00O("服务不支持https请求");
                case 10012:
                    throw new o0OoO00O("权限不足，服务请求被拒绝");
                case 10013:
                    throw new o0OoO00O("开发者删除了key，key被删除后无法正常使用");
                default:
                    switch (i) {
                        case 20000:
                            throw new o0OoO00O("请求参数非法");
                        case 20001:
                            throw new o0OoO00O("缺少必填参数");
                        case 20002:
                            throw new o0OoO00O("请求协议非法");
                        case 20003:
                            throw new o0OoO00O("其他未知错误");
                        default:
                            switch (i) {
                                case 30000:
                                    throw new o0OoO00O("请求服务响应错误");
                                case 30001:
                                    throw new o0OoO00O("引擎返回数据异常");
                                case 30002:
                                    throw new o0OoO00O("服务端请求链接超时");
                                case 30003:
                                    throw new o0OoO00O("读取服务结果超时");
                                default:
                                    throw new o0OoO00O(str);
                            }
                    }
            }
        }
    }

    public static void O000000o(String str, String str2) throws o0OoO00O {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject == null || !jSONObject.has("errcode")) {
                if (jSONObject.has("status")) {
                    if (jSONObject.has("infocode")) {
                        str = jSONObject.getString("status");
                        int i = jSONObject.getInt("infocode");
                        if (!"1".equals(str)) {
                            String string = jSONObject.getString("info");
                            if ("0".equals(str)) {
                                O000000o(i, string, str2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            O000000o(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"), str2);
        } catch (JSONException unused) {
            throw new o0OoO00O(AMapException.ERROR_PROTOCOL);
        }
    }
}
