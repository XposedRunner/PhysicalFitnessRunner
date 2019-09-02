package com.qiyukf.nimlib.e;

import android.os.Handler;
import android.util.SparseArray;
import com.qiyukf.nimlib.a.e.b;
import com.qiyukf.nimlib.a.e.c;
import com.qiyukf.nimlib.sdk.AbortableFuture;
import com.qiyukf.nimlib.sdk.auth.AuthService;
import com.qiyukf.nimlib.sdk.msg.MsgService;
import com.qiyukf.nimlib.sdk.msg.SystemMessageService;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class j {
    private final Map<String, a> a = new HashMap();
    private final SparseArray<f> b = new SparseArray();
    private final Handler c = com.qiyukf.basesdk.c.a.a().a("bg_executor");

    private static class a {
        private final Map<String, Method> a = new HashMap();
        private h b;

        public a(Class<?> cls, Class<? extends h> cls2) {
            for (Method method : cls.getDeclaredMethods()) {
                this.a.put(method.getName(), method);
            }
            try {
                this.b = (h) cls2.newInstance();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final Object a(i iVar) {
            return ((Method) this.a.get(iVar.a())).invoke(this.b, iVar.a.b);
        }
    }

    public j() {
        a(AuthService.class, com.qiyukf.nimlib.a.e.a.class);
        a(MsgService.class, b.class);
        a(SystemMessageService.class, c.class);
    }

    private void a(Class<?> cls, Class<? extends h> cls2) {
        this.a.put(cls.getSimpleName(), new a(cls, cls2));
    }

    public final Object a(i iVar) {
        a aVar = (a) this.a.get(iVar.a.a.substring(0, iVar.a.a.indexOf(47)));
        if (aVar == null) {
            return null;
        }
        h.a(iVar);
        StringBuilder stringBuilder;
        Object th;
        try {
            stringBuilder = new StringBuilder("execute ");
            stringBuilder.append(iVar);
            com.qiyukf.basesdk.a.a.a("TransEx", stringBuilder.toString());
            th = aVar.a(iVar);
            return th;
        } catch (Throwable th2) {
            th = th2;
            if ((th instanceof InvocationTargetException) && th.getCause() != null) {
                th = th.getCause();
            }
            stringBuilder = new StringBuilder("execute ");
            stringBuilder.append(iVar);
            stringBuilder.append(" exception");
            com.qiyukf.basesdk.a.a.a("TransEx", stringBuilder.toString(), th);
            iVar.b.a = 1000;
            iVar.b.b = th;
            a.c(iVar);
            return null;
        } finally {
            h.a();
        }
    }

    public final void b(final i iVar) {
        this.c.post(new Runnable() {
            public final void run() {
                Object a = j.this.a(iVar);
                if (a instanceof f) {
                    synchronized (j.this.b) {
                        j.this.b.put(iVar.c(), (f) a);
                    }
                }
            }
        });
    }

    public final void c(i iVar) {
        AbortableFuture abortableFuture;
        StringBuilder stringBuilder = new StringBuilder("abort ");
        stringBuilder.append(iVar);
        com.qiyukf.basesdk.a.a.a("TransEx", stringBuilder.toString());
        synchronized (this.b) {
            abortableFuture = (AbortableFuture) this.b.get(iVar.c());
            this.b.remove(iVar.c());
        }
        if (abortableFuture != null) {
            abortableFuture.abort();
        }
    }

    public final void d(i iVar) {
        synchronized (this.b) {
            this.b.remove(iVar.c());
        }
    }
}
