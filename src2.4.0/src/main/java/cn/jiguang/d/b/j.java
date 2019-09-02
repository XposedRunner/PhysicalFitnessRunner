package cn.jiguang.d.b;

import cn.jiguang.d.a.a;
import cn.jiguang.d.a.d;
import cn.jiguang.e.c;
import cn.jiguang.g.i;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j {
    private static j m;
    private static Pattern n = Pattern.compile("(([0-1]?[0-9]{1,2}\\.)|(2[0-4][0-9]\\.)|(25[0-5]\\.)){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))");
    List<String> a = new ArrayList();
    List<String> b = new ArrayList();
    List<String> c = new ArrayList();
    List<String> d = new ArrayList();
    boolean e = false;
    String f;
    String g;
    int h;
    List<String> i = new ArrayList();
    List<Integer> j = new ArrayList();
    String k;
    boolean l = false;

    public static boolean c(String str) {
        return n.matcher(str).matches();
    }

    public final String a() {
        return this.g;
    }

    public final void a(String str) {
        if (i.a(str)) {
            str = a.k();
        }
        if (!i.a(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("ips");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    int i;
                    int i2 = 0;
                    for (i = 0; i < optJSONArray.length(); i++) {
                        this.a.add(optJSONArray.optString(i));
                    }
                    optJSONArray = jSONObject.optJSONArray("ssl_ips");
                    if (optJSONArray != null && optJSONArray.length() != 0) {
                        for (i = 0; i < optJSONArray.length(); i++) {
                            this.b.add(optJSONArray.optString(i));
                        }
                        optJSONArray = jSONObject.optJSONArray("op_conns");
                        if (optJSONArray != null) {
                            optJSONArray.length();
                        }
                        if (optJSONArray != null) {
                            for (i = 0; i < optJSONArray.length(); i++) {
                                this.c.add(optJSONArray.optString(i));
                            }
                        }
                        optJSONArray = jSONObject.optJSONArray("sis_ips");
                        if (optJSONArray != null && optJSONArray.length() > 0) {
                            while (i2 < optJSONArray.length()) {
                                this.d.add(optJSONArray.optString(i2));
                                i2++;
                            }
                        }
                        this.e = jSONObject.optBoolean("data_report");
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final int b() {
        return this.h;
    }

    public final void b(String str) {
        String str2;
        this.k = str;
        if (this.a == null) {
            str = "SisInfo";
            str2 = "Unexpected - Invalid sis - no ips key.";
        } else if (this.a.size() == 0) {
            str = "SisInfo";
            str2 = "Unexpected - invalid sis - ips array len is 0";
        } else {
            try {
                k kVar = new k((String) this.a.get(0));
                this.g = kVar.a;
                this.h = kVar.b;
                if (this.c != null) {
                    for (String kVar2 : this.c) {
                        try {
                            k kVar3 = new k(kVar2);
                            this.i.add(kVar3.a);
                            this.j.add(Integer.valueOf(kVar3.b));
                        } catch (Exception unused) {
                        }
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                c.a("SisInfo", "Failed to parse ips-1 - main ip.", e);
            }
        }
        c.d(str, str2);
        this.l = true;
    }

    public final List<String> c() {
        return this.i;
    }

    public final List<Integer> d() {
        return this.j;
    }

    public final boolean e() {
        return this.l;
    }

    public final List<String> f() {
        return this.d;
    }

    public final boolean g() {
        return this.e;
    }

    public final void h() {
        int size = this.a.size();
        if (size != 0) {
            a.c(this.k);
            if (size > 1) {
                try {
                    k kVar = new k((String) this.a.get(1));
                    a.b(kVar.a, kVar.b);
                } catch (Exception e) {
                    c.a("SisInfo", "Failed to parse ips-2 - default ip.", e);
                }
            } else {
                c.c("SisInfo", "Only main ip in sis.");
            }
            if (this.b.size() > 2) {
                d.a((String) this.b.get(2));
            } else {
                c.c("SisInfo", "No report backup ip.");
            }
            if (this.f != null) {
                a.b(this.f);
            }
        }
    }
}
