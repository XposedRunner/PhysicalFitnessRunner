package com.qiyukf.nimlib.e;

import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.unicorn.api.RequestCallback;

public class k implements AbortableFuture {
    private RequestCallback a;
    private i b;

    public k(i iVar) {
        this.b = iVar;
    }

    public final void a() {
        if (this.a != null) {
            int i = this.b.b.a;
            Object obj = this.b.b.b;
            if (i == 200) {
                this.a.onSuccess(obj);
            } else if (obj instanceof Throwable) {
                this.a.onException((Throwable) obj);
            } else {
                this.a.onFailed(i);
            }
        }
    }

    public final void a(int i, Object obj) {
        this.b.a(i);
        this.b.a(obj);
    }

    public boolean abort() {
        return a.b(this.b);
    }

    public final void setCallback(RequestCallback requestCallback) {
        this.a = requestCallback;
    }
}
