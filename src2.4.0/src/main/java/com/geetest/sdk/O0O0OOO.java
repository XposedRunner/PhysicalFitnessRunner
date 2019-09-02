package com.geetest.sdk;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: ReportUtils */
final class O0O0OOO implements Runnable {
    final /* synthetic */ String O000000o;
    final /* synthetic */ String O00000Oo;
    final /* synthetic */ Long O00000o;
    final /* synthetic */ String O00000o0;

    O0O0OOO(String str, String str2, String str3, Long l) {
        this.O000000o = str;
        this.O00000Oo = str2;
        this.O00000o0 = str3;
        this.O00000o = l;
    }

    public final void run() {
        JSONObject O000000o = O0O0OO0.O000000o(this.O000000o, this.O00000Oo, this.O00000o0, "4.0.7");
        O0OOO00.O000000o();
        String.format("消耗时间为:%sMS", new Object[]{Long.valueOf((System.nanoTime() - this.O00000o.longValue()) / 1000000)});
        O0OOO00.O000000o();
        if (!TextUtils.isEmpty(O0O00oO.O000000o("https://monitor.geetest.com/monitor/send", O000000o))) {
            O0OOO00.O000000o();
        }
    }
}
