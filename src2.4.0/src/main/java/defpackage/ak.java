package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UMDBManager */
/* renamed from: ak */
class ak {
    private static SQLiteOpenHelper O00000Oo;
    private static Context O00000o;
    private AtomicInteger O000000o;
    private SQLiteDatabase O00000o0;

    /* compiled from: UMDBManager */
    /* renamed from: ak$O000000o */
    private static class O000000o {
        private static final ak O000000o = new ak();

        private O000000o() {
        }
    }

    private ak() {
        this.O000000o = new AtomicInteger();
    }

    public static ak O000000o(Context context) {
        if (O00000o == null && context != null) {
            O00000o = context.getApplicationContext();
            O00000Oo = aj.O000000o(O00000o);
        }
        return O000000o.O000000o;
    }

    public synchronized SQLiteDatabase O000000o() {
        if (this.O000000o.incrementAndGet() == 1) {
            this.O00000o0 = O00000Oo.getWritableDatabase();
        }
        return this.O00000o0;
    }

    public synchronized void O00000Oo() {
        try {
            if (this.O000000o.decrementAndGet() == 0) {
                this.O00000o0.close();
            }
        } catch (Throwable unused) {
        }
    }
}
