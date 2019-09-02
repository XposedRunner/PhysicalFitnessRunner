package cn.jiguang.d.d;

import android.content.Context;
import org.json.JSONArray;

final class y implements Runnable {
    final /* synthetic */ JSONArray a;
    final /* synthetic */ Context b;

    y(JSONArray jSONArray, Context context) {
        this.a = jSONArray;
        this.b = context;
    }

    public final void run() {
        x.a(this.b, this.a, x.a(this.a));
    }
}
