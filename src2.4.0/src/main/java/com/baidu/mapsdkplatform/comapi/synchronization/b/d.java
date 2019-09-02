package com.baidu.mapsdkplatform.comapi.synchronization.b;

import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceQueryOptions;
import com.baidu.mapsdkplatform.comapi.synchronization.b.b.a;
import com.baidu.mapsdkplatform.comapi.synchronization.c.c;
import com.baidu.mapsdkplatform.comapi.synchronization.c.e;

class d extends e {
    final /* synthetic */ int a;
    final /* synthetic */ HistoryTraceQueryOptions b;
    final /* synthetic */ String c;
    final /* synthetic */ a d;

    d(a aVar, int i, HistoryTraceQueryOptions historyTraceQueryOptions, String str) {
        this.d = aVar;
        this.a = i;
        this.b = historyTraceQueryOptions;
        this.c = str;
    }

    public void a(c.a aVar) {
        if ((c.a.SERVER_ERROR == aVar || c.a.NETWORK_ERROR == aVar || c.a.INNER_ERROR == aVar || c.a.REQUEST_ERROR == aVar) && b.g <= 2) {
            this.d.a(this.c, this.a, this.b);
            b.g = b.g + 1;
        }
        if (2 < b.g) {
            this.d.a(aVar, this.a);
        }
    }

    public void a(String str) {
        String c = b.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request success, the result = ");
        stringBuilder.append(str);
        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(c, stringBuilder.toString());
        this.d.a(3, str, this.a, this.b);
        b.g = 0;
    }
}
