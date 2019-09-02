package cn.jiguang.c;

import android.text.TextUtils;
import cn.jiguang.api.MultiSpHelper;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.json.JSONObject;

public final class a implements b {
    private static final LinkedHashMap<String, Integer> a;
    private static final LinkedHashMap<String, Integer> b;
    private static final LinkedHashSet<String> c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a = linkedHashMap;
        linkedHashMap.put("s.jpush.cn", Integer.valueOf(19000));
        a.put("sis.jpush.io", Integer.valueOf(19000));
        a.put("easytomessage.com", Integer.valueOf(19000));
        linkedHashMap = new LinkedHashMap();
        b = linkedHashMap;
        linkedHashMap.put("123.196.118.23", Integer.valueOf(19000));
        b.put("103.229.215.60", Integer.valueOf(19000));
        b.put("117.121.49.100", Integer.valueOf(19000));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c = linkedHashSet;
        linkedHashSet.add("https://tsis.jpush.cn");
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                str = jSONObject.optString("srv");
                if (!TextUtils.isEmpty(str)) {
                    MultiSpHelper.commitString(cn.jiguang.d.a.d, "srv", str);
                }
                str = jSONObject.optString("conn");
                if (!TextUtils.isEmpty(str)) {
                    MultiSpHelper.commitString(cn.jiguang.d.a.d, "conn", str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final String a() {
        return "CN";
    }

    public final LinkedHashMap<String, Integer> b() {
        return a;
    }

    public final LinkedHashMap<String, Integer> c() {
        return b;
    }

    public final String d() {
        String string = MultiSpHelper.getString(cn.jiguang.d.a.d, "conn", "im64.jpush.cn");
        return TextUtils.isEmpty(string) ? "im64.jpush.cn" : string;
    }

    public final String e() {
        String string = MultiSpHelper.getString(cn.jiguang.d.a.d, "srv", "_im64._tcp.jpush.cn");
        return TextUtils.isEmpty(string) ? "_im64._tcp.jpush.cn" : string;
    }

    public final String f() {
        return "_psis._udp.jpush.cn";
    }

    public final String g() {
        return "stats.jpush.cn";
    }

    public final LinkedHashSet<String> h() {
        return c;
    }
}
