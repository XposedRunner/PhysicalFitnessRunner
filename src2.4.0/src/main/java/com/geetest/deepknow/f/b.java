package com.geetest.deepknow.f;

import android.content.Context;
import android.os.AsyncTask;
import com.bangcle.andJni.JniLib1557756502;
import com.geetest.deepknow.c.a;
import com.geetest.deepknow.utils.c;
import com.geetest.deepknow.utils.i;

/* compiled from: DPTaskUtils */
public class b extends AsyncTask<String, Void, String> {
    private final Context a;
    private a b;
    private com.geetest.deepknow.c.b c;

    public b(Context context, a aVar, com.geetest.deepknow.c.b bVar) {
        this.a = context;
        this.b = aVar;
        this.c = bVar;
    }

    /* Access modifiers changed, original: protected|varargs */
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        i.a("开始全局请求");
        return c.a(strArr[0], com.geetest.deepknow.e.c.a(this.a, this.b, "event", null), this.b.e());
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        JniLib1557756502.cV(this, str, Integer.valueOf(64));
    }
}
