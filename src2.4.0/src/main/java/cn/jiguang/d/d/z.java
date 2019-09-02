package cn.jiguang.d.d;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class z implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ Context b;

    z(JSONObject jSONObject, Context context) {
        this.a = jSONObject;
        this.b = context;
    }

    public final void run() {
        String b = x.c(this.a);
        Set hashSet = new HashSet();
        hashSet.add(b);
        x.a(this.b, new JSONArray().put(this.a), hashSet);
    }
}
