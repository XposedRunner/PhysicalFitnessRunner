package cn.jiguang.d.i;

import android.content.Context;
import cn.jiguang.d.d.x;
import java.util.ArrayList;
import org.json.JSONObject;

public abstract class a<T> {
    protected long a;
    protected String b;
    protected long c;
    protected String d = "";

    public final void a(long j) {
        this.a = 3600;
    }

    /* Access modifiers changed, original: protected */
    public void a(Context context, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            x.a(context, x.a(context, jSONObject, str));
        }
    }

    public final void a(Context context, boolean z) {
        if (context != null && a()) {
            if (z || a(context)) {
                b(context);
                d(context);
            }
        }
    }

    public final void a(String str) {
        this.b = str;
    }

    /* Access modifiers changed, original: protected */
    public boolean a() {
        return true;
    }

    public abstract boolean a(Context context);

    public final void b(long j) {
        this.c = j;
    }

    public abstract void b(Context context);

    public final void b(String str) {
        this.d = str;
    }

    public abstract ArrayList<cn.jiguang.d.d.a> c(Context context);

    public abstract void d(Context context);
}
