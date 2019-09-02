package com.baidu.mapsdkplatform.comapi.synchronization.c;

import com.tencent.connect.common.Constants;

class b extends a {
    final /* synthetic */ e a;
    final /* synthetic */ String b;
    final /* synthetic */ a c;

    b(a aVar, e eVar, String str) {
        this.c = aVar;
        this.a = eVar;
        this.b = str;
        super();
    }

    public void a() {
        c cVar = new c(Constants.HTTP_GET, this.a);
        cVar.b(this.c.a);
        cVar.a(this.c.b);
        cVar.a(this.b);
    }
}
