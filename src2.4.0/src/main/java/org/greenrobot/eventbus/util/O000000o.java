package org.greenrobot.eventbus.util;

import android.app.Activity;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.O00000o0;

/* compiled from: AsyncExecutor */
public class O000000o {
    private final Executor O000000o;
    private final Constructor<?> O00000Oo;
    private final Object O00000o;
    private final O00000o0 O00000o0;

    /* compiled from: AsyncExecutor */
    public static class O000000o {
        private Executor O000000o;
        private Class<?> O00000Oo;
        private O00000o0 O00000o0;

        private O000000o() {
        }

        /* synthetic */ O000000o(AnonymousClass1 anonymousClass1) {
            this();
        }

        public O000000o O000000o(Class<?> cls) {
            this.O00000Oo = cls;
            return this;
        }

        public O000000o O000000o(Executor executor) {
            this.O000000o = executor;
            return this;
        }

        public O000000o O000000o(O00000o0 o00000o0) {
            this.O00000o0 = o00000o0;
            return this;
        }

        public O000000o O000000o() {
            return O000000o(null);
        }

        public O000000o O000000o(Activity activity) {
            return O000000o(activity.getClass());
        }

        public O000000o O000000o(Object obj) {
            if (this.O00000o0 == null) {
                this.O00000o0 = O00000o0.O000000o();
            }
            if (this.O000000o == null) {
                this.O000000o = Executors.newCachedThreadPool();
            }
            if (this.O00000Oo == null) {
                this.O00000Oo = O0000OOo.class;
            }
            return new O000000o(this.O000000o, this.O00000o0, this.O00000Oo, obj, null);
        }
    }

    /* compiled from: AsyncExecutor */
    public interface O00000Oo {
        void O000000o() throws Exception;
    }

    private O000000o(Executor executor, O00000o0 o00000o0, Class<?> cls, Object obj) {
        this.O000000o = executor;
        this.O00000o0 = o00000o0;
        this.O00000o = obj;
        try {
            this.O00000Oo = cls.getConstructor(new Class[]{Throwable.class});
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e);
        }
    }

    /* synthetic */ O000000o(Executor executor, O00000o0 o00000o0, Class cls, Object obj, AnonymousClass1 anonymousClass1) {
        this(executor, o00000o0, cls, obj);
    }

    public static O000000o O000000o() {
        return new O000000o();
    }

    public static O000000o O00000Oo() {
        return new O000000o().O000000o();
    }

    public void O000000o(final O00000Oo o00000Oo) {
        this.O000000o.execute(new Runnable() {
            public void run() {
                try {
                    o00000Oo.O000000o();
                } catch (Exception e) {
                    try {
                        Object newInstance = O000000o.this.O00000Oo.newInstance(new Object[]{e});
                        if (newInstance instanceof O0000O0o) {
                            ((O0000O0o) newInstance).O000000o(O000000o.this.O00000o);
                        }
                        O000000o.this.O00000o0.O00000o(newInstance);
                    } catch (Exception e2) {
                        Log.e(O00000o0.O000000o, "Original exception:", e);
                        throw new RuntimeException("Could not create failure event", e2);
                    }
                }
            }
        });
    }
}
