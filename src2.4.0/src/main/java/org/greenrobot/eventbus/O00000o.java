package org.greenrobot.eventbus;

import defpackage.ms;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: EventBusBuilder */
public class O00000o {
    private static final ExecutorService O0000Ooo = Executors.newCachedThreadPool();
    boolean O000000o = true;
    boolean O00000Oo = true;
    boolean O00000o = true;
    boolean O00000o0 = true;
    boolean O00000oO;
    boolean O00000oo = true;
    boolean O0000O0o;
    boolean O0000OOo;
    List<Class<?>> O0000Oo;
    ExecutorService O0000Oo0 = O0000Ooo;
    List<ms> O0000OoO;

    O00000o() {
    }

    public O00000o0 O000000o() {
        O00000o0 o00000o0;
        synchronized (O00000o0.class) {
            if (O00000o0.O00000Oo != null) {
                throw new O0000O0o("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
            O00000o0.O00000Oo = O00000Oo();
            o00000o0 = O00000o0.O00000Oo;
        }
        return o00000o0;
    }

    public O00000o O000000o(Class<?> cls) {
        if (this.O0000Oo == null) {
            this.O0000Oo = new ArrayList();
        }
        this.O0000Oo.add(cls);
        return this;
    }

    public O00000o O000000o(ExecutorService executorService) {
        this.O0000Oo0 = executorService;
        return this;
    }

    public O00000o O000000o(ms msVar) {
        if (this.O0000OoO == null) {
            this.O0000OoO = new ArrayList();
        }
        this.O0000OoO.add(msVar);
        return this;
    }

    public O00000o O000000o(boolean z) {
        this.O000000o = z;
        return this;
    }

    public O00000o0 O00000Oo() {
        return new O00000o0(this);
    }

    public O00000o O00000Oo(boolean z) {
        this.O00000Oo = z;
        return this;
    }

    public O00000o O00000o(boolean z) {
        this.O00000o = z;
        return this;
    }

    public O00000o O00000o0(boolean z) {
        this.O00000o0 = z;
        return this;
    }

    public O00000o O00000oO(boolean z) {
        this.O00000oO = z;
        return this;
    }

    public O00000o O00000oo(boolean z) {
        this.O00000oo = z;
        return this;
    }

    public O00000o O0000O0o(boolean z) {
        this.O0000O0o = z;
        return this;
    }

    public O00000o O0000OOo(boolean z) {
        this.O0000OOo = z;
        return this;
    }
}
