package cn.jiguang.d.d;

import java.io.File;
import org.json.JSONObject;

public final class n {
    private File a;
    private JSONObject b;
    private long c;
    private JSONObject d;
    private boolean e;
    private boolean f;

    public n(File file, JSONObject jSONObject) {
        this.a = file;
        this.b = jSONObject;
        this.c = file.length();
    }

    public final long a() {
        return this.c;
    }

    public final void a(File file) {
        this.a = file;
        b();
    }

    public final void a(JSONObject jSONObject) {
        this.b = null;
    }

    public final void a(boolean z) {
        this.e = z;
    }

    public final void b() {
        this.c = this.a.length();
    }

    public final void b(JSONObject jSONObject) {
        this.d = jSONObject;
    }

    public final void b(boolean z) {
        this.f = z;
    }

    public final File c() {
        return this.a;
    }

    public final JSONObject d() {
        return this.b;
    }

    public final JSONObject e() {
        return this.d;
    }

    public final boolean f() {
        return this.e;
    }

    public final boolean g() {
        return this.f;
    }
}
