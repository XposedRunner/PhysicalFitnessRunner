package cn.jiguang.net;

import android.content.Context;
import android.os.AsyncTask;
import cn.jiguang.net.HttpUtils.HttpListener;

final class b extends AsyncTask<String, Void, HttpResponse> {
    private HttpListener a;
    private Context b;

    public b(HttpListener httpListener, Context context) {
        this.a = httpListener;
        this.b = context;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        String[] strArr = (String[]) objArr;
        return (strArr == null || strArr.length == 0) ? null : HttpUtils.httpGet(this.b, strArr[0]);
    }

    /* Access modifiers changed, original: protected|final|bridge|synthetic */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
    }

    /* Access modifiers changed, original: protected|final */
    public final void onPreExecute() {
    }
}
