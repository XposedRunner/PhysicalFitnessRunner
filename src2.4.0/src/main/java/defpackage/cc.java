package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.umeng.socialize.utils.O0000Oo0;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: QueuedWork */
/* renamed from: cc */
public class cc {
    public static boolean O000000o;
    private static Handler O00000Oo;
    private static ExecutorService O00000o = Executors.newFixedThreadPool(5);
    private static ExecutorService O00000o0 = Executors.newFixedThreadPool(5);

    /* compiled from: QueuedWork */
    /* renamed from: cc$O00000Oo */
    public static abstract class O00000Oo<Result> {
        protected Runnable O00000oo;

        /* compiled from: QueuedWork */
        /* renamed from: cc$O00000Oo$1 */
        class 1 implements Runnable {
            1() {
            }

            public void run() {
                final Object O00000Oo = O00000Oo.this.O00000Oo();
                cc.O000000o(new Runnable() {
                    public void run() {
                        O00000Oo.this.O000000o(O00000Oo);
                    }
                });
            }
        }

        /* compiled from: QueuedWork */
        /* renamed from: cc$O00000Oo$2 */
        class 2 implements Runnable {
            2() {
            }

            public void run() {
                O00000Oo.this.c_();
            }
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(Result result) {
        }

        public abstract Result O00000Oo();

        public final O00000Oo<Result> O00000o() {
            this.O00000oo = new 1();
            cc.O000000o(new 2());
            cc.O000000o(this.O00000oo, false);
            return this;
        }

        /* Access modifiers changed, original: protected */
        public void c_() {
        }
    }

    /* compiled from: QueuedWork */
    /* renamed from: cc$O000000o */
    public static abstract class O000000o<T> extends O00000Oo {
        Dialog O00000oO = null;

        public O000000o(Context context) {
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(Object obj) {
            super.O000000o(obj);
            O0000Oo0.O000000o(this.O00000oO);
        }

        /* Access modifiers changed, original: protected */
        public void c_() {
            super.c_();
            O0000Oo0.O00000Oo(this.O00000oO);
        }
    }

    public static void O000000o(Runnable runnable) {
        if (O00000Oo == null) {
            O00000Oo = new Handler(Looper.getMainLooper());
        }
        O00000Oo.post(runnable);
    }

    public static void O000000o(Runnable runnable, boolean z) {
        if (!O000000o) {
            new Thread(runnable).start();
        } else if (z) {
            O00000o.execute(runnable);
        } else {
            O00000o0.execute(runnable);
        }
    }
}
