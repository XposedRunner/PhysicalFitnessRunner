package cn.jpush.android.data;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.a.e;
import cn.jpush.android.a.i;
import cn.jpush.android.b.a;
import cn.jpush.android.d.c;
import cn.jpush.android.d.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public abstract class b implements Serializable {
    public int A;
    public String B;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public boolean F = false;
    public int G = -1;
    public ArrayList<String> H = null;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public int N;
    public String O;
    public String P;
    private boolean a = false;
    public int b;
    public String c;
    public String d;
    public byte e = (byte) 0;
    public boolean f;
    public int g;
    public int h = 0;
    public boolean i;
    public String j;
    public String k;
    public int l = -1;
    public String m;
    public String n;
    public String o;
    public String p;
    public int q;
    public boolean r;
    public List<String> s = null;
    public int t;
    public String u;
    public String v;
    public int w;
    public String x;
    public String y;
    public String z;

    static boolean a(ArrayList<String> arrayList, Context context, String str, String str2, boolean z) {
        boolean z2 = true;
        if (i.a(str) && context != null && arrayList.size() > 0 && !TextUtils.isEmpty(str2)) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str3;
                StringBuilder stringBuilder;
                String str4 = (String) it.next();
                if (str4 == null || str4.startsWith("http://")) {
                    str3 = str4;
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(str4);
                    str3 = stringBuilder.toString();
                }
                byte[] a = a.a(str3, 5, 5000, 4);
                if (a != null) {
                    try {
                        if (str4.startsWith("http://")) {
                            str4 = c.a(str4);
                        }
                        if (z) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(c.b(context, str2));
                            stringBuilder.append(str4);
                        } else {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(c.a(context, str2));
                            stringBuilder.append(str4);
                        }
                        c.a(stringBuilder.toString(), a);
                    } catch (Exception e) {
                        f.c("Entity", "Write storage error,  create img file fail.", e);
                    }
                } else {
                    e.a(str2, 1020, cn.jpush.android.d.a.a(context, str3), context);
                    z2 = false;
                }
            }
        }
        return z2;
    }

    public abstract void a(Context context);

    public final void a(boolean z) {
        this.a = true;
    }

    public final boolean a() {
        return this.a;
    }

    public final boolean a(Context context, JSONObject jSONObject) {
        this.r = jSONObject.optInt("full_screen", 0) > 0;
        this.t = jSONObject.optInt("n_flag", 0);
        this.u = jSONObject.optString("n_title", "");
        this.v = jSONObject.optString("n_content", "");
        this.w = jSONObject.optInt("n_style", 0);
        this.x = jSONObject.optString("n_big_text", "");
        this.y = jSONObject.optString("n_big_pic_path", "");
        this.z = jSONObject.optString("n_inbox", "");
        this.n = jSONObject.optString("n_extras", "");
        this.A = jSONObject.optInt("n_priority", 0);
        this.B = jSONObject.optString("n_category", "");
        this.l = jSONObject.optInt("n_alert_type", -1);
        this.K = jSONObject.optString("n_small_icon", "");
        this.L = jSONObject.optString("n_large_icon", "");
        this.J = jSONObject.optString("n_source", "");
        JSONObject optJSONObject = jSONObject.optJSONObject("n_intent");
        if (optJSONObject != null) {
            this.M = optJSONObject.optString("n_url", "");
            this.N = optJSONObject.optInt("n_fail_handle_type", 0);
            this.O = optJSONObject.optString("n_fail_handle_url", "");
            this.P = optJSONObject.optString("n_package_name", "");
        }
        if (TextUtils.isEmpty(this.u)) {
            if (this.i) {
                this.u = cn.jpush.android.a.d;
            } else {
                e.a(this.c, 996, null, context);
                return false;
            }
        }
        JSONObject a = i.a(context, this.c, jSONObject, "ad_content");
        if (a == null) {
            return this.i && this.f;
        } else {
            if (this.i && this.f) {
                this.a = true;
            }
            return a(a);
        }
    }

    public abstract boolean a(JSONObject jSONObject);
}
