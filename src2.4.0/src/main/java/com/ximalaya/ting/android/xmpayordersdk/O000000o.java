package com.ximalaya.ting.android.xmpayordersdk;

import java.util.HashMap;
import java.util.Map;

/* compiled from: IXmPayOrderListener */
public interface O000000o {
    public static final int O000000o = 2;
    public static final int O00000Oo = 4;
    public static final int O00000o = 101;
    public static final int O00000o0 = 110;
    public static final int O00000oO = 102;
    public static final int O00000oo = 200;
    public static final int O0000O0o = 500;
    public static final int O0000OOo = 100;
    public static final int O0000Oo = 601;
    public static final int O0000Oo0 = 600;
    public static final int O0000OoO = 602;
    public static final int O0000Ooo = 603;
    public static final int O0000o = 615;
    public static final int O0000o0 = 609;
    public static final int O0000o00 = 3;
    public static final int O0000o0O = 610;
    public static final int O0000o0o = 614;
    public static final int O0000oO = 619;
    public static final int O0000oO0 = 618;
    public static final int O0000oOO = 620;
    public static final int O0000oOo = 621;
    public static final int O0000oo = 1015;
    public static final int O0000oo0 = 1014;
    public static final int O0000ooO = 401;
    public static final int O0000ooo = 430;
    public static final int O000O00o = 433;
    public static final Map<Integer, String> O000O0OO = new HashMap<Integer, String>() {
        {
            put(Integer.valueOf(2), "取消购买");
            put(Integer.valueOf(4), "用户未登录");
            put(Integer.valueOf(110), "未知错误");
            put(Integer.valueOf(101), "网络错误");
            put(Integer.valueOf(102), "下单接口 json提取失败");
            put(Integer.valueOf(200), "下单成功");
            put(Integer.valueOf(500), "下单失败");
            put(Integer.valueOf(100), "参数常规校验失败");
            put(Integer.valueOf(600), "待购买内容已下架");
            put(Integer.valueOf(O000000o.O0000Oo), "待购买声音来自不同专辑");
            put(Integer.valueOf(O000000o.O0000OoO), "单价校验失败");
            put(Integer.valueOf(O000000o.O0000Ooo), "已存在未支付订单包含重叠付费音频");
            put(Integer.valueOf(3), "购买类型不支持");
            put(Integer.valueOf(O000000o.O0000o0), "应用没有付费音频接入资格");
            put(Integer.valueOf(O000000o.O0000o), "已经购买");
            put(Integer.valueOf(1014), "需要登录");
            put(Integer.valueOf(O000000o.O0000o0O), "应用IP不在白名单中");
            put(Integer.valueOf(O000000o.O0000o0o), "查询价格信息的专辑不存在");
            put(Integer.valueOf(1015), "获取价格信息出错");
            put(Integer.valueOf(O000000o.O0000ooO), "订单超时");
            put(Integer.valueOf(O000000o.O0000ooo), "订单处理中");
            put(Integer.valueOf(O000000o.O00oOooO), "支付宝支付失败");
            put(Integer.valueOf(O000000o.O00oOooo), "签名错误");
            put(Integer.valueOf(O000000o.O000O00o), "支付渠道错误");
            put(Integer.valueOf(O000000o.O0000oO0), "已经购买");
            put(Integer.valueOf(O000000o.O0000oO), "声音资源是免费试听的，无需购买");
            put(Integer.valueOf(O000000o.O0000oOO), "购买的资源是单集购买类型，不能当做整张类型购买");
            put(Integer.valueOf(O000000o.O0000oOo), "购买的商品不存在");
        }
    };
    public static final int O00oOooO = 431;
    public static final int O00oOooo = 432;

    void O000000o(O00000Oo o00000Oo);
}
