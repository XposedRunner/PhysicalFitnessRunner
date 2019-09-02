package com.loc;

import android.content.Context;
import dalvik.system.DexFile;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BaseLoader */
abstract class O000Oo0 extends ClassLoader {
    protected final Context O000000o;
    protected final Map<String, Class<?>> O00000Oo = new HashMap();
    volatile boolean O00000o = true;
    protected DexFile O00000o0 = null;
    protected OO0Oo0 O00000oO;
    protected String O00000oo;
    protected volatile boolean O0000O0o = false;
    protected volatile boolean O0000OOo = false;

    public O000Oo0(Context context, OO0Oo0 oO0Oo0) {
        super(context.getClassLoader());
        this.O000000o = context;
        this.O00000oO = oO0Oo0;
    }

    public final boolean O000000o() {
        return this.O00000o0 != null;
    }

    /* Access modifiers changed, original: protected|final */
    public final void O00000Oo() {
        try {
            synchronized (this.O00000Oo) {
                this.O00000Oo.clear();
            }
            if (this.O00000o0 != null) {
                if (this.O0000OOo) {
                    synchronized (this.O00000o0) {
                        this.O00000o0.wait();
                    }
                }
                this.O0000O0o = true;
                this.O00000o0.close();
            }
        } catch (Throwable th) {
            O0000Oo.O000000o(th, "BaseLoader", "releaseDexFile()");
        }
    }
}
