package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.net.HttpResponse;
import cn.jpush.android.b.a;

final class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;

    j(String str, Context context, String str2) {
        this.a = str;
        this.b = context;
        this.c = str2;
    }

    public final void run() {
        String responseBody;
        Object obj = null;
        int i = 0;
        while (i < 4) {
            i++;
            HttpResponse a = a.a(this.a, 5, 8000);
            if (a != null && a.getResponseCode() == 200) {
                responseBody = a.getResponseBody();
                obj = 1;
                break;
            }
        }
        responseBody = null;
        if (obj == null || TextUtils.isEmpty(responseBody)) {
            e.a(this.c, 1021, cn.jpush.android.d.a.a(this.b, this.a), this.b);
            e.a(this.c, 996, null, this.b);
            return;
        }
        i.a(this.b, responseBody);
    }
}
