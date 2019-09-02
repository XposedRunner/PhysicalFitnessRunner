package com.baidu.location.d;

import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.os.EnvironmentCompat;
import com.baidu.location.Jni;
import com.baidu.location.g.b;
import com.baidu.location.g.e;
import com.baidu.location.g.j;
import com.sina.weibo.sdk.statistic.LogBuilder;
import com.tencent.stat.DeviceInfo;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;
import org.json.JSONObject;

final class f {
    private final g a;
    private final SQLiteDatabase b;
    private final a c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private String[] i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private double o;
    private double p;
    private double q;
    private double r;
    private double s;
    private int t;
    private boolean u = true;
    private long v = 8000;
    private long w = 5000;
    private long x = 5000;
    private long y = 5000;
    private long z = 5000;

    private final class a extends e {
        private int b;
        private long c;
        private long d;
        private boolean e;
        private final String f;

        private a() {
            this.b = 0;
            this.e = false;
            this.c = -1;
            this.d = -1;
            this.k = new HashMap();
            this.f = Jni.encodeOfflineLocationUpdateRequest(String.format(Locale.US, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f&mb=%s&os=A%s", new Object[]{"1", b.a().b, b.e, b.d, Float.valueOf(7.62f), Build.MODEL, VERSION.SDK}));
        }

        private void b() {
            if (!this.e) {
                boolean z = false;
                try {
                    File file = new File(f.this.a.c(), "ofl.config");
                    if (this.d == -1 && file.exists()) {
                        JSONObject jSONObject;
                        Scanner scanner = new Scanner(file);
                        String next = scanner.next();
                        scanner.close();
                        JSONObject jSONObject2 = new JSONObject(next);
                        f.this.d = jSONObject2.getBoolean("ol");
                        f.this.e = jSONObject2.getBoolean("fl");
                        f.this.f = jSONObject2.getBoolean("on");
                        f.this.g = jSONObject2.getBoolean("wn");
                        f.this.h = jSONObject2.getBoolean("oc");
                        this.d = jSONObject2.getLong("t");
                        if (jSONObject2.has("ol")) {
                            f.this.k = jSONObject2.getBoolean("olv2");
                        }
                        if (jSONObject2.has("cplist")) {
                            f.this.i = jSONObject2.getString("cplist").split(";");
                        }
                        if (jSONObject2.has("rgcgp")) {
                            f.this.l = jSONObject2.getInt("rgcgp");
                        }
                        if (jSONObject2.has("rgcon")) {
                            f.this.j = jSONObject2.getBoolean("rgcon");
                        }
                        if (jSONObject2.has("addrup")) {
                            f.this.n = jSONObject2.getInt("addrup");
                        }
                        if (jSONObject2.has("poiup")) {
                            f.this.m = jSONObject2.getInt("poiup");
                        }
                        if (jSONObject2.has("oflp")) {
                            jSONObject = jSONObject2.getJSONObject("oflp");
                            if (jSONObject.has("0")) {
                                f.this.o = jSONObject.getDouble("0");
                            }
                            if (jSONObject.has("1")) {
                                f.this.p = jSONObject.getDouble("1");
                            }
                            if (jSONObject.has("2")) {
                                f.this.q = jSONObject.getDouble("2");
                            }
                            if (jSONObject.has("3")) {
                                f.this.r = jSONObject.getDouble("3");
                            }
                            if (jSONObject.has("4")) {
                                f.this.s = jSONObject.getDouble("4");
                            }
                        }
                        if (jSONObject2.has("onlt")) {
                            jSONObject = jSONObject2.getJSONObject("onlt");
                            if (jSONObject.has("0")) {
                                f.this.z = jSONObject.getLong("0");
                            }
                            if (jSONObject.has("1")) {
                                f.this.y = jSONObject.getLong("1");
                            }
                            if (jSONObject.has("2")) {
                                f.this.v = jSONObject.getLong("2");
                            }
                            if (jSONObject.has("3")) {
                                f.this.w = jSONObject.getLong("3");
                            }
                            if (jSONObject.has("4")) {
                                f.this.x = jSONObject.getLong("4");
                            }
                        }
                        if (jSONObject2.has("minapn")) {
                            f.this.t = jSONObject2.getInt("minapn");
                        }
                    }
                    if (this.d == -1) {
                        file.exists();
                    }
                    if (this.d != -1 && this.d + LogBuilder.MAX_INTERVAL <= System.currentTimeMillis()) {
                        z = true;
                    }
                } catch (Exception unused) {
                }
                if ((this.d == -1 || z) && c() && j.a(f.this.a.b())) {
                    this.e = true;
                    c("https://ofloc.map.baidu.com/offline_loc");
                }
            }
        }

        private boolean c() {
            if (this.b < 2) {
                return true;
            }
            if (this.c + LogBuilder.MAX_INTERVAL >= System.currentTimeMillis()) {
                return false;
            }
            this.b = 0;
            this.c = -1;
            return true;
        }

        public void a() {
            this.k.clear();
            this.k.put("qt", "conf");
            this.k.put("req", this.f);
            this.h = g.b;
        }

        public void a(boolean z) {
            if (z && this.j != null) {
                try {
                    JSONObject jSONObject = new JSONObject(this.j);
                    Object obj = "1";
                    long j = 0;
                    if (jSONObject.has("ofl")) {
                        j = jSONObject.getLong("ofl");
                    }
                    if (jSONObject.has(DeviceInfo.TAG_VERSION)) {
                        obj = jSONObject.getString(DeviceInfo.TAG_VERSION);
                    }
                    if ((j & 1) == 1) {
                        f.this.d = true;
                    }
                    if ((j & 2) == 2) {
                        f.this.e = true;
                    }
                    if ((j & 4) == 4) {
                        f.this.f = true;
                    }
                    if ((j & 8) == 8) {
                        f.this.g = true;
                    }
                    if ((j & 16) == 16) {
                        f.this.h = true;
                    }
                    if ((j & 32) == 32) {
                        f.this.j = true;
                    }
                    if ((j & 64) == 64) {
                        f.this.k = true;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("cplist")) {
                        f.this.i = jSONObject.getString("cplist").split(";");
                        jSONObject2.put("cplist", jSONObject.getString("cplist"));
                    }
                    if (jSONObject.has("bklist")) {
                        f.this.a(jSONObject.getString("bklist").split(";"));
                    }
                    if (jSONObject.has("para")) {
                        JSONObject jSONObject3;
                        jSONObject = jSONObject.getJSONObject("para");
                        if (jSONObject.has("rgcgp")) {
                            f.this.l = jSONObject.getInt("rgcgp");
                        }
                        if (jSONObject.has("addrup")) {
                            f.this.n = jSONObject.getInt("addrup");
                        }
                        if (jSONObject.has("poiup")) {
                            f.this.m = jSONObject.getInt("poiup");
                        }
                        if (jSONObject.has("oflp")) {
                            jSONObject3 = jSONObject.getJSONObject("oflp");
                            if (jSONObject3.has("0")) {
                                f.this.o = jSONObject3.getDouble("0");
                            }
                            if (jSONObject3.has("1")) {
                                f.this.p = jSONObject3.getDouble("1");
                            }
                            if (jSONObject3.has("2")) {
                                f.this.q = jSONObject3.getDouble("2");
                            }
                            if (jSONObject3.has("3")) {
                                f.this.r = jSONObject3.getDouble("3");
                            }
                            if (jSONObject3.has("4")) {
                                f.this.s = jSONObject3.getDouble("4");
                            }
                        }
                        if (jSONObject.has("onlt")) {
                            jSONObject3 = jSONObject.getJSONObject("onlt");
                            if (jSONObject3.has("0")) {
                                f.this.z = jSONObject3.getLong("0");
                            }
                            if (jSONObject3.has("1")) {
                                f.this.y = jSONObject3.getLong("1");
                            }
                            if (jSONObject3.has("2")) {
                                f.this.v = jSONObject3.getLong("2");
                            }
                            if (jSONObject3.has("3")) {
                                f.this.w = jSONObject3.getLong("3");
                            }
                            if (jSONObject3.has("4")) {
                                f.this.x = jSONObject3.getLong("4");
                            }
                        }
                        if (jSONObject.has("minapn")) {
                            f.this.t = jSONObject.getInt("minapn");
                        }
                    }
                    jSONObject2.put("ol", f.this.d);
                    jSONObject2.put("olv2", f.this.k);
                    jSONObject2.put("fl", f.this.e);
                    jSONObject2.put("on", f.this.f);
                    jSONObject2.put("wn", f.this.g);
                    jSONObject2.put("oc", f.this.h);
                    this.d = System.currentTimeMillis();
                    jSONObject2.put("t", this.d);
                    jSONObject2.put(DeviceInfo.TAG_VERSION, obj);
                    jSONObject2.put("rgcon", f.this.j);
                    jSONObject2.put("rgcgp", f.this.l);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("0", f.this.o);
                    jSONObject4.put("1", f.this.p);
                    jSONObject4.put("2", f.this.q);
                    jSONObject4.put("3", f.this.r);
                    jSONObject4.put("4", f.this.s);
                    jSONObject2.put("oflp", jSONObject4);
                    jSONObject4 = new JSONObject();
                    jSONObject4.put("0", f.this.z);
                    jSONObject4.put("1", f.this.y);
                    jSONObject4.put("2", f.this.v);
                    jSONObject4.put("3", f.this.w);
                    jSONObject4.put("4", f.this.x);
                    jSONObject2.put("onlt", jSONObject4);
                    jSONObject2.put("addrup", f.this.n);
                    jSONObject2.put("poiup", f.this.m);
                    jSONObject2.put("minapn", f.this.t);
                    File file = new File(f.this.a.c(), "ofl.config");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(jSONObject2.toString());
                    fileWriter.close();
                } catch (Exception unused) {
                }
                this.e = false;
            }
            this.b++;
            this.c = System.currentTimeMillis();
            this.e = false;
        }
    }

    f(g gVar, SQLiteDatabase sQLiteDatabase) {
        this.a = gVar;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.j = false;
        this.k = false;
        this.l = 6;
        this.m = 30;
        this.n = 30;
        this.o = 0.0d;
        this.p = 0.0d;
        this.q = 0.0d;
        this.r = 0.0d;
        this.s = 0.0d;
        this.t = 8;
        this.i = new String[0];
        this.b = sQLiteDatabase;
        this.c = new a();
        if (this.b != null && this.b.isOpen()) {
            try {
                this.b.execSQL("CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);");
            } catch (Exception unused) {
            }
        }
        g();
    }

    /* Access modifiers changed, original: 0000 */
    public int a() {
        return this.t;
    }

    /* Access modifiers changed, original: 0000 */
    public long a(String str) {
        return str.equals("2G") ? this.v : str.equals("3G") ? this.w : str.equals("4G") ? this.x : str.equals("WIFI") ? this.y : str.equals(EnvironmentCompat.MEDIA_UNKNOWN) ? this.z : 5000;
    }

    /* Access modifiers changed, original: 0000 */
    public void a(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"");
            stringBuffer.append(strArr[i]);
            stringBuffer.append("\")");
        }
        if (this.b != null && this.b.isOpen() && stringBuffer.length() > 0) {
            try {
                this.b.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO BLACK VALUES %s;", new Object[]{stringBuffer.toString()}));
            } catch (Exception unused) {
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public double b() {
        return this.o;
    }

    /* Access modifiers changed, original: 0000 */
    public double c() {
        return this.p;
    }

    /* Access modifiers changed, original: 0000 */
    public double d() {
        return this.q;
    }

    /* Access modifiers changed, original: 0000 */
    public double e() {
        return this.r;
    }

    /* Access modifiers changed, original: 0000 */
    public double f() {
        return this.s;
    }

    /* Access modifiers changed, original: 0000 */
    public void g() {
        this.c.b();
    }

    /* Access modifiers changed, original: 0000 */
    public boolean h() {
        return this.d;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean i() {
        return this.f;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean j() {
        return this.g;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean k() {
        return this.e;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean l() {
        return this.j;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean m() {
        return this.u;
    }

    /* Access modifiers changed, original: 0000 */
    public int n() {
        return this.l;
    }

    /* Access modifiers changed, original: 0000 */
    public String[] o() {
        return this.i;
    }

    /* Access modifiers changed, original: 0000 */
    public int p() {
        return this.n;
    }

    /* Access modifiers changed, original: 0000 */
    public int q() {
        return this.m;
    }
}
