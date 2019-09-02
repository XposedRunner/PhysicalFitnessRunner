package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;

/* compiled from: AbstractImageWorker */
public abstract class o0ooo0OO {
    private o0OOoOoo O000000o;
    private com.amap.api.mapcore.util.o0OOoOoo.O000000o O00000Oo;
    protected Resources O00000o;
    protected boolean O00000o0 = false;
    private boolean O00000oO = false;
    private final Object O00000oo = new Object();
    private O00000o0 O0000O0o = null;

    /* compiled from: AbstractImageWorker */
    public interface O00000o0 {
        void O000000o();
    }

    /* compiled from: AbstractImageWorker */
    public class O000000o extends OO0Oo00<Boolean, Void, Bitmap> {
        private final WeakReference<com.amap.api.mapcore.util.OO00O0.O000000o> O00000oO;

        public O000000o(com.amap.api.mapcore.util.OO00O0.O000000o o000000o) {
            this.O00000oO = new WeakReference(o000000o);
        }

        private com.amap.api.mapcore.util.OO00O0.O000000o O00000oO() {
            com.amap.api.mapcore.util.OO00O0.O000000o o000000o = (com.amap.api.mapcore.util.OO00O0.O000000o) this.O00000oO.get();
            return this == o0ooo0OO.O00000o0(o000000o) ? o000000o : null;
        }

        /* Access modifiers changed, original: protected|varargs */
        public Bitmap O000000o(Boolean... boolArr) {
            try {
                boolean booleanValue = boolArr[0].booleanValue();
                Object obj = (com.amap.api.mapcore.util.OO00O0.O000000o) this.O00000oO.get();
                if (obj == null) {
                    return null;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(obj.O000000o);
                stringBuilder.append("-");
                stringBuilder.append(obj.O00000Oo);
                stringBuilder.append("-");
                stringBuilder.append(obj.O00000o0);
                String stringBuilder2 = stringBuilder.toString();
                synchronized (o0ooo0OO.this.O00000oo) {
                    while (o0ooo0OO.this.O00000o0 && !O00000o()) {
                        o0ooo0OO.this.O00000oo.wait();
                    }
                }
                Bitmap O00000Oo = (o0ooo0OO.this.O000000o == null || O00000o() || O00000oO() == null || o0ooo0OO.this.O00000oO) ? null : o0ooo0OO.this.O000000o.O00000Oo(stringBuilder2);
                if (!(!booleanValue || O00000Oo != null || O00000o() || O00000oO() == null || o0ooo0OO.this.O00000oO)) {
                    synchronized (o0ooo0OO.class) {
                        O00000Oo = o0ooo0OO.this.O000000o(obj);
                    }
                }
                if (!(O00000Oo == null || o0ooo0OO.this.O000000o == null)) {
                    o0ooo0OO.this.O000000o.O000000o(stringBuilder2, O00000Oo);
                }
                return O00000Oo;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(Bitmap bitmap) {
            try {
                if (O00000o() || o0ooo0OO.this.O00000oO) {
                    bitmap = null;
                }
                com.amap.api.mapcore.util.OO00O0.O000000o O00000oO = O00000oO();
                if (bitmap != null && !bitmap.isRecycled() && O00000oO != null) {
                    O00000oO.O000000o(bitmap);
                    if (o0ooo0OO.this.O0000O0o != null) {
                        o0ooo0OO.this.O0000O0o.O000000o();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* Access modifiers changed, original: protected */
        public void O00000Oo(Bitmap bitmap) {
            super.O00000Oo((Object) bitmap);
            synchronized (o0ooo0OO.this.O00000oo) {
                try {
                    o0ooo0OO.this.O00000oo.notifyAll();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* compiled from: AbstractImageWorker */
    protected class O00000Oo extends OO0Oo00<Object, Void, Void> {
        protected O00000Oo() {
        }

        /* Access modifiers changed, original: protected|varargs */
        /* renamed from: O00000o */
        public Void O000000o(Object... objArr) {
            try {
                switch (((Integer) objArr[0]).intValue()) {
                    case 0:
                        o0ooo0OO.this.O00000o0();
                        break;
                    case 1:
                        o0ooo0OO.this.O00000Oo();
                        break;
                    case 2:
                        o0ooo0OO.this.O00000o();
                        break;
                    case 3:
                        o0ooo0OO.this.O00000Oo(((Boolean) objArr[1]).booleanValue());
                        break;
                    case 4:
                        o0ooo0OO.this.O00000oO();
                        break;
                    default:
                        break;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            return null;
        }
    }

    protected o0ooo0OO(Context context) {
        this.O00000o = context.getResources();
    }

    public static void O000000o(com.amap.api.mapcore.util.OO00O0.O000000o o000000o) {
        O000000o O00000o0 = O00000o0(o000000o);
        if (O00000o0 != null) {
            O00000o0.O000000o(true);
        }
    }

    private static O000000o O00000o0(com.amap.api.mapcore.util.OO00O0.O000000o o000000o) {
        return o000000o != null ? o000000o.O0000Oo : null;
    }

    public abstract Bitmap O000000o(Object obj);

    /* Access modifiers changed, original: protected */
    public o0OOoOoo O000000o() {
        return this.O000000o;
    }

    public void O000000o(com.amap.api.mapcore.util.o0OOoOoo.O000000o o000000o) {
        this.O00000Oo = o000000o;
        this.O000000o = o0OOoOoo.O000000o(this.O00000Oo);
        new O00000Oo().O00000o0(Integer.valueOf(1));
    }

    public void O000000o(O00000o0 o00000o0) {
        this.O0000O0o = o00000o0;
    }

    public void O000000o(String str) {
        this.O00000Oo.O00000Oo(str);
        new O00000Oo().O00000o0(Integer.valueOf(4));
    }

    public void O000000o(boolean z) {
        synchronized (this.O00000oo) {
            this.O00000o0 = z;
            if (!this.O00000o0) {
                try {
                    this.O00000oo.notifyAll();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void O000000o(boolean z, com.amap.api.mapcore.util.OO00O0.O000000o o000000o) {
        if (o000000o != null) {
            Bitmap bitmap = null;
            try {
                if (this.O000000o != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(o000000o.O000000o);
                    stringBuilder.append("-");
                    stringBuilder.append(o000000o.O00000Oo);
                    stringBuilder.append("-");
                    stringBuilder.append(o000000o.O00000o0);
                    bitmap = this.O000000o.O000000o(stringBuilder.toString());
                }
                if (bitmap != null) {
                    o000000o.O000000o(bitmap);
                } else {
                    O000000o o000000o2 = new O000000o(o000000o);
                    o000000o.O0000Oo = o000000o2;
                    o000000o2.O000000o(OO0Oo00.O00000o0, (Object[]) new Boolean[]{Boolean.valueOf(z)});
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo() {
        if (this.O000000o != null) {
            this.O000000o.O000000o();
        }
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(boolean z) {
        if (this.O000000o != null) {
            this.O000000o.O000000o(z);
            this.O000000o = null;
        }
    }

    /* Access modifiers changed, original: protected */
    public void O00000o() {
        if (this.O000000o != null) {
            this.O000000o.O00000o0();
        }
    }

    /* Access modifiers changed, original: protected */
    public void O00000o0() {
        if (this.O000000o != null) {
            this.O000000o.O00000Oo();
        }
    }

    public void O00000o0(boolean z) {
        new O00000Oo().O00000o0(Integer.valueOf(3), Boolean.valueOf(z));
    }

    /* Access modifiers changed, original: protected */
    public void O00000oO() {
        if (this.O000000o != null) {
            this.O000000o.O000000o(false);
            this.O000000o.O000000o();
        }
    }

    public void O00000oo() {
        new O00000Oo().O00000o0(Integer.valueOf(0));
    }
}
