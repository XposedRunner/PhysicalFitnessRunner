package com.qiyukf.nimlib.e;

import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.unicorn.api.RequestCallback;

public abstract class f<T> implements AbortableFuture {
    protected T c;

    public f(T t) {
        this.c = t;
    }

    public void setCallback(RequestCallback requestCallback) {
    }
}
