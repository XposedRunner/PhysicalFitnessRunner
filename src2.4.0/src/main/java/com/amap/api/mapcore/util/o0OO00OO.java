package com.amap.api.mapcore.util;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;

/* compiled from: HttpsDecisionUtil */
public class o0OO00OO {
    private volatile O00000Oo O000000o = new O00000Oo();
    private oO0O0Oo0 O00000Oo = new oO0O0Oo0("HttpsDecisionUtil");

    /* compiled from: HttpsDecisionUtil */
    private static class O000000o {
        static o0OO00OO O000000o = new o0OO00OO();
    }

    /* compiled from: HttpsDecisionUtil */
    private static class O00000Oo {
        protected boolean O000000o;
        private int O00000Oo;
        private boolean O00000o;
        private final boolean O00000o0;

        private O00000Oo() {
            this.O00000Oo = 0;
            this.O000000o = true;
            this.O00000o0 = true;
            this.O00000o = false;
        }

        private int O00000Oo() {
            return this.O00000Oo <= 0 ? 28 : this.O00000Oo;
        }

        private boolean O00000o() {
            return VERSION.SDK_INT >= 28;
        }

        private boolean O00000o0() {
            return O00000Oo() >= 28;
        }

        private boolean O00000oO() {
            boolean O00000o = O00000o();
            boolean z = !this.O000000o || O00000o0();
            return O00000o && z;
        }

        public void O000000o(Context context) {
            if (context != null && this.O00000Oo <= 0 && VERSION.SDK_INT >= 4) {
                this.O00000Oo = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public void O000000o(boolean z) {
            this.O000000o = z;
        }

        public boolean O000000o() {
            return this.O00000o || O00000oO();
        }

        public void O00000Oo(boolean z) {
            this.O00000o = z;
        }
    }

    public static o0OO00OO O000000o() {
        return O000000o.O000000o;
    }

    public static String O000000o(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("https")) {
            return str;
        }
        try {
            Builder buildUpon = Uri.parse(str).buildUpon();
            buildUpon.scheme("https");
            return buildUpon.build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    private void O00000Oo(Context context, boolean z) {
        this.O00000Oo.O000000o(context, "isTargetRequired", z);
    }

    private void O00000o(Context context) {
        this.O00000Oo.O000000o(context, "isTargetRequired", true);
    }

    public static boolean O00000o0() {
        return VERSION.SDK_INT == 19;
    }

    private boolean O00000o0(Context context) {
        return this.O00000Oo.O00000Oo(context, "isTargetRequired", true);
    }

    public void O000000o(Context context) {
        if (this.O000000o == null) {
            this.O000000o = new O00000Oo();
        }
        this.O000000o.O000000o(O00000o0(context));
        this.O000000o.O000000o(context);
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Context context, boolean z) {
        if (this.O000000o == null) {
            this.O000000o = new O00000Oo();
        }
        O00000Oo(context, z);
        this.O000000o.O000000o(z);
    }

    public void O000000o(boolean z) {
        if (this.O000000o == null) {
            this.O000000o = new O00000Oo();
        }
        this.O000000o.O00000Oo(z);
    }

    public void O00000Oo(Context context) {
        O00000o(context);
    }

    public boolean O00000Oo() {
        if (this.O000000o == null) {
            this.O000000o = new O00000Oo();
        }
        return this.O000000o.O000000o();
    }

    public boolean O00000Oo(boolean z) {
        boolean z2 = false;
        if (O00000o0()) {
            return false;
        }
        if (z || O00000Oo()) {
            z2 = true;
        }
        return z2;
    }
}
