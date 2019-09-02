package com.zjwh.android_wh_physicalfitness.utils;

import android.os.Handler;
import android.os.Looper;
import defpackage.kz;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/* compiled from: SafeAsyncTask */
public class O00O0o00$O000000o<ResultT> implements Callable<Void> {
    protected final O00O0o00<ResultT> O000000o;
    protected final Handler O00000Oo;

    public O00O0o00$O000000o(O00O0o00<ResultT> o00O0o00) {
        this.O000000o = o00O0o00;
        this.O00000Oo = o00O0o00.handler != null ? o00O0o00.handler : new Handler(Looper.getMainLooper());
    }

    /* renamed from: O000000o */
    public Void call() throws Exception {
        try {
            O00000Oo();
            O000000o(O00000o0());
        } catch (Exception e) {
            try {
                O000000o(e);
            } catch (Exception e2) {
                kz.O00000oO(O00O0o00.TAG, e2.getMessage());
            }
        } catch (Throwable th) {
            try {
                O000000o(th);
            } catch (Exception e22) {
                kz.O00000oO(O00O0o00.TAG, e22.getMessage());
            } catch (Throwable th2) {
                O00000o();
            }
        }
        O00000o();
        return null;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(final Exception exception) throws Exception {
        if (this.O000000o.launchLocation != null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(exception.getStackTrace()));
            arrayList.addAll(Arrays.asList(this.O000000o.launchLocation));
            exception.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
        }
        O000000o(new Callable<Object>() {
            public Object call() throws Exception {
                if ((exception instanceof InterruptedException) || (exception instanceof InterruptedIOException)) {
                    O00O0o00$O000000o.this.O000000o.onInterrupted(exception);
                } else {
                    O00O0o00$O000000o.this.O000000o.onException(exception);
                }
                return null;
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(final ResultT resultT) throws Exception {
        O000000o(new Callable<Object>() {
            public Object call() throws Exception {
                O00O0o00$O000000o.this.O000000o.onSuccess(resultT);
                return null;
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(final Throwable th) throws Exception {
        if (this.O000000o.launchLocation != null) {
            ArrayList arrayList = new ArrayList(Arrays.asList(th.getStackTrace()));
            arrayList.addAll(Arrays.asList(this.O000000o.launchLocation));
            th.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
        }
        O000000o(new Callable<Object>() {
            public Object call() throws Exception {
                O00O0o00$O000000o.this.O000000o.onThrowable(th);
                return null;
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(final Callable callable) throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final Exception[] exceptionArr = new Exception[1];
        this.O00000Oo.post(new Runnable() {
            public void run() {
                try {
                    callable.call();
                } catch (Exception e) {
                    exceptionArr[0] = e;
                } catch (Throwable th) {
                    countDownLatch.countDown();
                }
                countDownLatch.countDown();
            }
        });
        countDownLatch.await();
        if (exceptionArr[0] != null) {
            throw exceptionArr[0];
        }
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo() throws Exception {
        O000000o(new Callable<Object>() {
            public Object call() throws Exception {
                O00O0o00$O000000o.this.O000000o.onPreExecute();
                return null;
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public void O00000o() throws Exception {
        O000000o(new Callable<Object>() {
            public Object call() throws Exception {
                O00O0o00$O000000o.this.O000000o.onFinally();
                return null;
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public ResultT O00000o0() throws Exception {
        return this.O000000o.call();
    }
}
