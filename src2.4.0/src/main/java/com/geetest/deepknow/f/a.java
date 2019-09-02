package com.geetest.deepknow.f;

import android.content.Context;
import android.os.AsyncTask;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.bean.DPJudgementBean;
import com.geetest.deepknow.c.b;
import com.geetest.deepknow.listener.DPJudgementListener;
import com.geetest.deepknow.utils.c;
import com.geetest.deepknow.utils.i;

/* compiled from: DPJudgementTaskUtils */
public class a extends AsyncTask<String, Void, String> {
    private final DPJudgementListener a;
    private final Context b;
    private DPJudgementBean c;
    private com.geetest.deepknow.c.a d;
    private b e;

    public a(Context context, DPJudgementListener dPJudgementListener, DPJudgementBean dPJudgementBean, com.geetest.deepknow.c.a aVar, b bVar) {
        this.b = context;
        this.a = dPJudgementListener;
        this.c = dPJudgementBean;
        this.d = aVar;
        this.e = bVar;
    }

    private void a(String str, String str2) {
        JniLib1557756502.cV(this, str, str2, Integer.valueOf(63));
    }

    /* Access modifiers changed, original: protected|varargs */
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        i.a("开始请求Judgement");
        return c.a(strArr[0], com.geetest.deepknow.e.c.a(this.b, this.d, "eventAction", this.c), this.d.e());
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        JniLib1557756502.cV(this, str, Integer.valueOf(62));
    }
}
