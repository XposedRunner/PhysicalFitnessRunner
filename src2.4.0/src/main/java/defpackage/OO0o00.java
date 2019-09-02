package defpackage;

import android.util.Log;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: FifoPriorityThreadPoolExecutor */
/* renamed from: OO0o00 */
public class OO0o00 extends ThreadPoolExecutor {
    private static final String O000000o = "PriorityExecutor";
    private final AtomicInteger O00000Oo;
    private final O00000o0 O00000o0;

    /* compiled from: FifoPriorityThreadPoolExecutor */
    /* renamed from: OO0o00$O000000o */
    public static class O000000o implements ThreadFactory {
        int O000000o;

        /* compiled from: FifoPriorityThreadPoolExecutor */
        /* renamed from: OO0o00$O000000o$1 */
        class 1 extends Thread {
            final /* synthetic */ O000000o O000000o;

            1(O000000o o000000o, Runnable runnable, String str) {
            }

            public void run() {
            }
        }

        public Thread newThread(Runnable runnable) {
            return null;
        }
    }

    /* compiled from: FifoPriorityThreadPoolExecutor */
    /* renamed from: OO0o00$O00000Oo */
    static class O00000Oo<T> extends FutureTask<T> implements Comparable<O00000Oo<?>> {
        private final int O000000o;
        private final int O00000Oo;

        public O00000Oo(Runnable runnable, T t, int i) {
        }

        public int O000000o(O00000Oo<?> o00000Oo) {
            return 0;
        }

        public /* synthetic */ int compareTo(Object obj) {
            return 0;
        }

        public boolean equals(Object obj) {
            return false;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* compiled from: FifoPriorityThreadPoolExecutor */
    /* renamed from: OO0o00$O00000o0 */
    public enum O00000o0 {
        IGNORE,
        LOG {
            /* Access modifiers changed, original: protected */
            public void O000000o(Throwable th) {
                if (Log.isLoggable(OO0o00.O000000o, 6)) {
                    Log.e(OO0o00.O000000o, "Request threw uncaught throwable", th);
                }
            }
        },
        THROW {
            /* Access modifiers changed, original: protected */
            public void O000000o(Throwable th) {
                super.O000000o(th);
                throw new RuntimeException(th);
            }
        };

        /* Access modifiers changed, original: protected */
        public void O000000o(Throwable th) {
        }
    }

    public OO0o00(int i) {
    }

    public OO0o00(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, O00000o0 o00000o0) {
    }

    public OO0o00(int i, O00000o0 o00000o0) {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:1:0x0001
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:364)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:60)
        	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:42)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:292)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
        */
    protected void afterExecute(java.lang.Runnable r1, java.lang.Throwable r2) {
        /*
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.OO0o00.afterExecute(java.lang.Runnable, java.lang.Throwable):void");
    }

    /* Access modifiers changed, original: protected */
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return null;
    }
}
