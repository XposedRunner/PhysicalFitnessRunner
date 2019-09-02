package cn.jiguang.d.d;

import android.content.Context;
import java.io.File;
import java.util.Set;
import org.json.JSONObject;

final class aa implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Set b;
    final /* synthetic */ JSONObject c;
    final /* synthetic */ File d;

    aa(Context context, Set set, JSONObject jSONObject, File file) {
        this.a = context;
        this.b = set;
        this.c = jSONObject;
        this.d = file;
    }

    public final void run() {
        try {
            x.a(this.a, this.b, this.c, this.d);
        } finally {
            p.a(this.d);
        }
    }
}
