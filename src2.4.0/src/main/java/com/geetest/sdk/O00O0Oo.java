package com.geetest.sdk;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TestHttpDns */
public final class O00O0Oo {
    private Handler O000000o;
    private List<String> O00000Oo;
    private Handler O00000o0 = new Handler(Looper.getMainLooper());

    public O00O0Oo(String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        this.O000000o = new Handler(handlerThread.getLooper());
    }

    private String O000000o(String str) {
        int size = this.O00000Oo.size() - 1;
        int nextInt = new Random().nextInt(size) % (size + 1);
        String str2 = (String) this.O00000Oo.get(nextInt);
        Long valueOf = Long.valueOf((System.currentTimeMillis() / 1000) + 4);
        String O000000o = O000Oo0.O000000o(String.format("%s-%s-%d", new Object[]{str, "142027ff5aeabefe5dccb9b845252dce", valueOf}));
        str = String.format("%s://%s/%s/sign_d?host=%s&t=%d&s=%s", new Object[]{"https", str2, "126617", str, Long.valueOf(r7), O000000o});
        O0OOO00.O000000o("url_sign-->".concat(String.valueOf(str)));
        this.O00000Oo.remove(nextInt);
        str = O000OOo.O000000o(str);
        if (TextUtils.isEmpty(str)) {
            O0OOO00.O000000o("请求报错");
            return null;
        }
        O0OOO00.O000000o("请求成功:".concat(String.valueOf(str)));
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("ips");
            return jSONArray.length() == 0 ? null : jSONArray.get(0).toString();
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("请求失败:");
            stringBuilder.append(e.toString());
            Log.i("GeetestHttpDns", stringBuilder.toString());
            return null;
        }
    }

    public final void O000000o(String str, O000OOo0 o000OOo0) {
        this.O00000Oo = new ArrayList();
        this.O00000Oo.add("203.107.1.1");
        this.O00000Oo.add("203.107.1.1");
        this.O00000Oo.add("203.107.1.1");
        this.O00000Oo.add("203.107.1.1");
        this.O000000o.post(new O000o000(this, str, o000OOo0));
    }
}
