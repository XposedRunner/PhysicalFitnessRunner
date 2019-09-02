package com.geetest.deepknow.c;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.bean.DPJudgementBean;
import com.geetest.deepknow.listener.DPJudgementListener;
import com.geetest.deepknow.listener.DPListener;
import com.geetest.deepknow.utils.h;
import com.geetest.deepknow.utils.i;
import com.geetest.geeguard.R;

/* compiled from: DPHelper */
public class a {
    private final Context a;
    private boolean b = true;
    private final com.geetest.deepknow.a.a.a.a c;
    private DPListener d;
    private String e;
    private b f;
    private String g;
    private int h = 300000;
    private int i = 5000;
    private int j = 49;
    private int k = 200;

    public a(Context context, String str) {
        a(context, str);
        this.a = context;
        this.e = str;
        this.c = new com.geetest.deepknow.a.a.a.a(context);
        this.f = new b(context, this);
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(Activity activity) {
        JniLib1557756502.cV(this, activity, Integer.valueOf(21));
    }

    public void a(Context context, String str) {
        JniLib1557756502.cV(this, context, str, Integer.valueOf(22));
    }

    public void a(View view, String str) {
        JniLib1557756502.cV(this, view, str, Integer.valueOf(23));
    }

    public void a(DPJudgementBean dPJudgementBean, DPJudgementListener dPJudgementListener) {
        JniLib1557756502.cV(this, dPJudgementBean, dPJudgementListener, Integer.valueOf(24));
    }

    public void a(String str) {
        this.g = str;
    }

    public void a(boolean z, boolean z2) {
        JniLib1557756502.cV(this, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(25));
    }

    public void a(View... viewArr) {
        for (Object obj : viewArr) {
            if (!h.a(obj)) {
                obj.setTag(R.id.deepknow_tag_view_ignored, "1");
            }
        }
    }

    public void a(String... strArr) {
        for (String str : strArr) {
            Context context = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.b);
            stringBuilder.append(str);
            h.a(context, stringBuilder.toString(), str, false);
        }
    }

    public boolean a() {
        return this.b;
    }

    public DPListener b() {
        return this.d;
    }

    public void b(int i) {
        this.i = i;
    }

    public void b(View view, String str) {
        JniLib1557756502.cV(this, view, str, Integer.valueOf(26));
    }

    public void b(View... viewArr) {
        for (Object obj : viewArr) {
            if (!h.a(obj)) {
                obj.setTag(R.id.deepknow_tag_view_ignored, "0");
            }
        }
    }

    public void b(String... strArr) {
        for (String str : strArr) {
            Context context = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.b);
            stringBuilder.append(str);
            h.a(context, stringBuilder.toString(), null, true);
        }
    }

    public String c() {
        return this.e;
    }

    public void c(int i) {
        this.j = i;
    }

    public int d() {
        return this.h;
    }

    public void d(int i) {
        this.k = i;
    }

    public int e() {
        return this.i;
    }

    public com.geetest.deepknow.a.a.a.a f() {
        return this.c;
    }

    public String g() {
        return (String) JniLib1557756502.cL(this, Integer.valueOf(27));
    }

    public void h() {
        JniLib1557756502.cV(this, Integer.valueOf(28));
    }

    public String i() {
        return this.g;
    }

    public void j() {
        this.c.d();
    }

    public void k() {
        this.f.c();
    }

    public int l() {
        return this.j;
    }

    public int m() {
        return this.k;
    }

    public void setDPListener(DPListener dPListener) {
        this.d = dPListener;
    }
}
