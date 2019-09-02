package cn.jiguang.a.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import cn.jiguang.d.a.d;
import cn.jiguang.d.d.x;
import cn.jiguang.g.a;
import cn.jiguang.g.i;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.umeng.commonsdk.framework.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    private static volatile f c;
    private static final Object d = new Object();
    public boolean a = false;
    protected Handler b;
    private Context e;
    private String f = MsgService.MSG_CHATTING_ACCOUNT_ALL;
    private boolean g = true;
    private String h = null;
    private String i = null;
    private String j = null;
    private boolean k = false;
    private a l;
    private c m;
    private h n;

    private f(Context context) {
        this.e = context;
        this.l = new a(context, this);
        this.n = new h(context);
        this.m = new c(context, this);
    }

    public static e a(Context context) {
        e d = c != null ? c.d() : null;
        if (d == null || !d.a()) {
            d = e.a(d.l(context));
        }
        return (d == null || !d.a()) ? new e(200.0d, 200.0d, 0.0d, 0.0f, 0.0f, "", 0, false) : d;
    }

    public static void a(Context context, boolean z) {
        if (context != null) {
            if (c == null) {
                synchronized (d) {
                    if (c == null) {
                        c = new f(context);
                    }
                }
            }
            c.a = z;
            f fVar = c;
            try {
                if (fVar.b == null) {
                    HandlerThread handlerThread = new HandlerThread("location");
                    handlerThread.start();
                    fVar.b = new g(fVar, handlerThread.getLooper());
                }
                fVar.b.sendEmptyMessage(1000);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean a(JSONArray jSONArray, JSONArray jSONArray2, String str) {
        if (i.a(str)) {
            if (!i.a(this.j)) {
                return false;
            }
        } else if (!str.equals(this.j)) {
            return false;
        }
        if (i.a(this.i)) {
            if (!(jSONArray2 == null || jSONArray2.length() == 0)) {
                return false;
            }
        } else if (jSONArray2 == null || jSONArray2.length() == 0 || !this.i.equals(jSONArray2.toString())) {
            return false;
        }
        if (i.a(this.h)) {
            if (!(jSONArray == null || jSONArray.length() == 0)) {
                return false;
            }
        } else if (jSONArray == null || jSONArray.length() == 0) {
            return false;
        } else {
            try {
                String optString = ((JSONObject) jSONArray.get(0)).optString("ssid");
                if (!(i.a(optString) || optString.equals(this.h))) {
                    return false;
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ void b(f fVar) {
        fVar.l.c();
        fVar.n.a();
        fVar.m.b();
    }

    private void c() {
        if (d.d(this.e)) {
            JSONArray c = this.n.c();
            JSONArray b = this.l.b();
            e d = this.a ? null : d();
            JSONObject f = d != null ? d.f() : null;
            if (f != null || b != null || c != null) {
                String jSONObject = f != null ? f.toString() : "";
                if (!a(c, b, jSONObject)) {
                    JSONArray jSONArray;
                    if (f == null || f.length() <= 0) {
                        jSONArray = null;
                    } else {
                        jSONArray = new JSONArray();
                        jSONArray.put(f);
                    }
                    f = new JSONObject();
                    try {
                        JSONObject a;
                        x.a(this.e, f, "loc_info");
                        f.put("network_type", a.e(this.e));
                        f.put("local_dns", a.b());
                        if (c != null && c.length() > 0) {
                            f.put("wifi", c);
                            this.h = ((JSONObject) c.get(0)).optString("ssid");
                        }
                        if (b != null && b.length() > 0) {
                            f.put("cell", b);
                            this.i = b.toString();
                        }
                        if (!(this.a || jSONArray == null || jSONArray.length() <= 0)) {
                            f.put("gps", jSONArray);
                            this.j = jSONObject;
                        }
                        Context context = this.e;
                        synchronized ("jpush_lbs_info.json") {
                            a = x.a(context, "jpush_lbs_info.json");
                        }
                        if (a == null) {
                            a = new JSONObject();
                        }
                        b = a.optJSONArray(c.a);
                        if (b == null) {
                            b = new JSONArray();
                        }
                        try {
                            int i;
                            b.put(f);
                            long longValue = ((Long) d.b(context, "last_report_location", Long.valueOf(0))).longValue();
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - longValue > cn.jiguang.a.b.a.a(context)) {
                                d.a(context, "last_report_location", Long.valueOf(currentTimeMillis));
                                i = 1;
                            } else {
                                i = 0;
                            }
                            if (i == 0) {
                                if (!((Boolean) d.b(context, "lbs_report_now", Boolean.valueOf(false))).booleanValue()) {
                                    a.put(c.a, b);
                                    synchronized ("jpush_lbs_info.json") {
                                        x.a(context, "jpush_lbs_info.json", a);
                                    }
                                    return;
                                }
                            }
                            cn.jiguang.a.b.a.b(context, false);
                            d.a(context, "last_report_location", Long.valueOf(System.currentTimeMillis()));
                            x.a(context, b);
                            synchronized ("jpush_lbs_info.json") {
                                if (!x.a(context, "jpush_lbs_info.json", null)) {
                                    context.deleteFile("jpush_lbs_info.json");
                                }
                            }
                        } catch (JSONException e) {
                            cn.jiguang.e.c.a("MyLocationManager", "unexpected on lbs reportPrepare", e);
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    static /* synthetic */ void c(f fVar) {
        if (a.a(fVar.e, "android.permission.ACCESS_COARSE_LOCATION")) {
            fVar.l.a();
        } else {
            fVar.a();
        }
    }

    private e d() {
        return this.m != null ? this.m.a() : null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        this.n.b();
        this.m.a(this.e);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b() {
        try {
            if (this.g) {
                JSONObject a;
                Context context;
                if (this.f.equals("cell_towers")) {
                    if (d.d(this.e)) {
                        a = a.a("loc_cell", this.l.b());
                        if (a != null && a.length() > 0) {
                            context = this.e;
                        }
                    }
                } else if (this.f.equals("wifi_towers")) {
                    if (d.d(this.e)) {
                        a = a.a("loc_wifi", this.n.c());
                        if (a != null && a.length() > 0) {
                            context = this.e;
                        }
                    }
                } else if (this.f.equals("gps")) {
                    if (d.d(this.e) && !this.a) {
                        e d = d();
                        a = d != null ? d.f() : null;
                        if (a != null && a.length() > 0) {
                            JSONArray jSONArray = new JSONArray();
                            jSONArray.put(a);
                            a = a.a("loc_gps", jSONArray);
                            if (a != null && a.length() > 0) {
                                context = this.e;
                            }
                        }
                    }
                } else if (this.f.equals(MsgService.MSG_CHATTING_ACCOUNT_ALL)) {
                    c();
                }
                x.a(context, a);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.k = false;
        }
        this.k = false;
        if (this.b != null) {
            this.b.removeCallbacksAndMessages(null);
            try {
                this.b.getLooper().quit();
            } catch (Exception unused2) {
            }
            this.b = null;
        }
    }
}
