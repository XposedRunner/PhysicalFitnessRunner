package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: Rollbacker */
public class oO0O0O00 {
    volatile ak O000000o = new ak();
    private Context O00000Oo;
    private volatile am O00000o = new am();
    private o0OO0o00 O00000o0;
    private com.amap.api.mapcore.util.ooOOOOoo.O000000o O00000oO = new com.amap.api.mapcore.util.ooOOOOoo.O000000o() {
        public final void O000000o(Thread thread, Throwable th) {
            String str;
            oO0O0O00 oo0o0o00 = oO0O0O00.this;
            StringBuffer stringBuffer = new StringBuffer();
            if (thread == null || th == null) {
                str = "";
            } else {
                StringBuilder stringBuilder = new StringBuilder("THREAD:");
                ak akVar = oO0O0O00.this.O000000o;
                stringBuilder.append(ak.O000000o(thread));
                stringBuffer.append(stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder("THROWABLE:");
                stringBuilder2.append(th);
                stringBuffer.append(stringBuilder2.toString());
                str = stringBuffer.toString();
            }
            oo0o0o00.O000000o(str);
        }
    };

    /* compiled from: Rollbacker */
    static class O000000o {
        public static oO0O0O00 O000000o = new oO0O0O00();
    }

    public static oO0O0O00 O000000o() {
        return O000000o.O000000o;
    }

    public void O000000o(Context context) {
        if (context != null) {
            this.O00000Oo = context.getApplicationContext();
        }
    }

    public void O000000o(o0OO0o00 o0oo0o00) {
        this.O00000o0 = o0oo0o00;
    }

    public void O000000o(String str) {
        try {
            this.O00000o.O00000Oo(this.O00000Oo, this.O00000o0.O000000o(), this.O00000o0.O00000o0());
            this.O000000o.O000000o(this.O00000o0);
        } catch (Throwable unused) {
        }
    }

    public boolean O000000o(String str, String str2, String str3) {
        return this.O00000o.O000000o(this.O00000Oo, str, str3);
    }
}
