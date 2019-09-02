package com.geetest.deepknow.c;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.b.a;
import com.geetest.deepknow.bean.DPJudgementBean;
import com.geetest.deepknow.listener.DPJudgementListener;
import com.geetest.deepknow.utils.d;
import com.geetest.deepknow.utils.g;

/* compiled from: DPTransaction */
public class b {
    private static final g a = new g();
    private final Context b;
    private final d c;
    private String d = null;
    private a e;
    private a f;

    public b(Context context, a aVar) {
        this.b = context;
        this.e = aVar;
        this.f = new a(context, this);
        this.c = new d(a.a(context, "DPAPI", new com.geetest.deepknow.utils.g.b() {
            public void a(SharedPreferences sharedPreferences) {
            }
        }));
        if (VERSION.SDK_INT >= 14) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new com.geetest.deepknow.collection.b(this.c, context, aVar, this, this.f));
        }
    }

    public void a() {
        JniLib1557756502.cV(this, Integer.valueOf(29));
    }

    public void a(Activity activity) {
        JniLib1557756502.cV(this, activity, Integer.valueOf(30));
    }

    public void a(DPJudgementBean dPJudgementBean, DPJudgementListener dPJudgementListener) {
        JniLib1557756502.cV(this, dPJudgementBean, dPJudgementListener, Integer.valueOf(31));
    }

    public void a(String str) {
        JniLib1557756502.cV(this, str, Integer.valueOf(32));
    }

    public void b() {
        JniLib1557756502.cV(this, Integer.valueOf(33));
    }

    public void b(String str) {
        this.d = str;
    }

    public void c() {
        this.f.a();
    }
}
