package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMProcessDBManager */
/* renamed from: bl */
class bl {
    private static bl O000000o;
    private ConcurrentHashMap<String, O000000o> O00000Oo = new ConcurrentHashMap();
    private Context O00000o0;

    /* compiled from: UMProcessDBManager */
    /* renamed from: bl$O000000o */
    static class O000000o {
        private AtomicInteger O000000o = new AtomicInteger();
        private SQLiteOpenHelper O00000Oo;
        private SQLiteDatabase O00000o0;

        private O000000o() {
        }

        static O000000o O000000o(Context context, String str) {
            context = UMGlobalContext.getAppContext(context);
            O000000o o000000o = new O000000o();
            o000000o.O00000Oo = bk.O000000o(context, str);
            return o000000o;
        }

        /* Access modifiers changed, original: declared_synchronized */
        public synchronized SQLiteDatabase O000000o() {
            if (this.O000000o.incrementAndGet() == 1) {
                this.O00000o0 = this.O00000Oo.getWritableDatabase();
            }
            return this.O00000o0;
        }

        /* Access modifiers changed, original: declared_synchronized */
        public synchronized void O00000Oo() {
            try {
                if (this.O000000o.decrementAndGet() == 0) {
                    this.O00000o0.close();
                }
            } catch (Throwable unused) {
            }
        }
    }

    private bl() {
    }

    static bl O000000o(Context context) {
        if (O000000o == null) {
            synchronized (bl.class) {
                if (O000000o == null) {
                    O000000o = new bl();
                }
            }
        }
        O000000o.O00000o0 = context;
        return O000000o;
    }

    private O000000o O00000o0(String str) {
        if (this.O00000Oo.get(str) != null) {
            return (O000000o) this.O00000Oo.get(str);
        }
        O000000o O000000o = O000000o.O000000o(this.O00000o0, str);
        this.O00000Oo.put(str, O000000o);
        return O000000o;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized SQLiteDatabase O000000o(String str) {
        return O00000o0(str).O000000o();
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void O00000Oo(String str) {
        O00000o0(str).O00000Oo();
    }
}
