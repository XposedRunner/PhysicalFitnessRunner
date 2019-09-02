package com.qiyukf.nimlib.c.a;

import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class c {
    private final a[] a;

    public static final class a {
        private final String a;
        private final boolean b;
        private final List<b> c;

        public a(String str) {
            this(str, (byte) 0);
        }

        private a(String str, byte b) {
            this.c = new ArrayList();
            this.a = str;
            this.b = true;
        }

        private int a(int i) {
            int i2 = -1;
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                if (i >= ((b) this.c.get(i3)).a) {
                    i2 = i3;
                }
            }
            return i2;
        }

        private static void a(SQLiteDatabase sQLiteDatabase, String[] strArr) {
            if (strArr != null) {
                for (String execSQL : strArr) {
                    sQLiteDatabase.execSQL(execSQL);
                }
            }
        }

        private void b(SQLiteDatabase sQLiteDatabase, int i) {
            b bVar = (b) this.c.get(i);
            StringBuilder stringBuilder = new StringBuilder("create: table ");
            stringBuilder.append(this);
            stringBuilder.append(" target ");
            stringBuilder.append(bVar);
            com.qiyukf.basesdk.a.a.d("db", stringBuilder.toString());
            a(sQLiteDatabase, bVar.a());
        }

        private void b(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            b bVar = (b) this.c.get(i);
            b bVar2 = (b) this.c.get(i2);
            StringBuilder stringBuilder = new StringBuilder("upgrade: table ");
            stringBuilder.append(this);
            stringBuilder.append(" initial ");
            stringBuilder.append(bVar);
            stringBuilder.append(" target ");
            stringBuilder.append(bVar2);
            com.qiyukf.basesdk.a.a.d("db", stringBuilder.toString());
            a(sQLiteDatabase, bVar2.b());
        }

        public final a a(b bVar) {
            this.c.add(bVar);
            return this;
        }

        /* Access modifiers changed, original: final */
        public final void a(SQLiteDatabase sQLiteDatabase, int i) {
            i = a(i);
            if (i >= 0) {
                b(sQLiteDatabase, i);
            }
        }

        /* Access modifiers changed, original: final */
        public final void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            i2 = a(i2);
            i = a(i);
            if (i2 != i) {
                if (i < 0) {
                    b(sQLiteDatabase, i2);
                    return;
                }
                if (i < i2) {
                    if (this.b) {
                        while (i < i2) {
                            int i3 = i + 1;
                            b(sQLiteDatabase, i, i3);
                            i = i3;
                        }
                    } else {
                        b(sQLiteDatabase, i, i2);
                    }
                }
            }
        }

        public final String toString() {
            return this.a;
        }
    }

    public static abstract class b {
        final int a;

        public b(int i) {
            this.a = i;
        }

        public abstract String[] a();

        public abstract String[] b();

        public String toString() {
            return Integer.toString(this.a);
        }
    }

    public c(a[] aVarArr) {
        this.a = aVarArr;
    }

    public final void a(SQLiteDatabase sQLiteDatabase, int i) {
        for (a a : this.a) {
            a.a(sQLiteDatabase, i);
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        for (a a : this.a) {
            a.a(sQLiteDatabase, i, i2);
        }
    }
}
