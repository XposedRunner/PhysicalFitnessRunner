package com.loc;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.TextUtils;

/* compiled from: HttpsDecisionUtil */
public final class OO0OO0o {
    private volatile O00000Oo O000000o = new O00000Oo();
    private O00O00o O00000Oo = new O00O00o("HttpsDecisionUtil");

    /* compiled from: HttpsDecisionUtil */
    private static class O000000o {
        static OO0OO0o O000000o = new OO0OO0o();
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

        /* synthetic */ O00000Oo(byte b) {
            this();
        }

        public final void O000000o(Context context) {
            if (context != null && this.O00000Oo <= 0 && VERSION.SDK_INT >= 4) {
                this.O00000Oo = context.getApplicationContext().getApplicationInfo().targetSdkVersion;
            }
        }

        public final void O000000o(boolean z) {
            this.O000000o = z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0030 A:{RETURN} */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x002f A:{RETURN} */
        public final boolean O000000o() {
            /*
            r5 = this;
            r0 = r5.O00000o;
            r1 = 1;
            if (r0 != 0) goto L_0x0031;
        L_0x0005:
            r0 = android.os.Build.VERSION.SDK_INT;
            r2 = 28;
            r3 = 0;
            if (r0 < r2) goto L_0x000e;
        L_0x000c:
            r0 = r1;
            goto L_0x000f;
        L_0x000e:
            r0 = r3;
        L_0x000f:
            r4 = r5.O000000o;
            if (r4 == 0) goto L_0x0025;
        L_0x0013:
            r4 = r5.O00000Oo;
            if (r4 > 0) goto L_0x0019;
        L_0x0017:
            r4 = r2;
            goto L_0x001b;
        L_0x0019:
            r4 = r5.O00000Oo;
        L_0x001b:
            if (r4 < r2) goto L_0x001f;
        L_0x001d:
            r2 = r1;
            goto L_0x0020;
        L_0x001f:
            r2 = r3;
        L_0x0020:
            if (r2 == 0) goto L_0x0023;
        L_0x0022:
            goto L_0x0025;
        L_0x0023:
            r2 = r3;
            goto L_0x0026;
        L_0x0025:
            r2 = r1;
        L_0x0026:
            if (r0 == 0) goto L_0x002c;
        L_0x0028:
            if (r2 == 0) goto L_0x002c;
        L_0x002a:
            r0 = r1;
            goto L_0x002d;
        L_0x002c:
            r0 = r3;
        L_0x002d:
            if (r0 == 0) goto L_0x0030;
        L_0x002f:
            return r1;
        L_0x0030:
            return r3;
        L_0x0031:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.OO0OO0o$O00000Oo.O000000o():boolean");
        }

        public final void O00000Oo(boolean z) {
            this.O00000o = z;
        }
    }

    public static OO0OO0o O000000o() {
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

    public static boolean O00000Oo() {
        return VERSION.SDK_INT == 19;
    }

    public final void O000000o(Context context) {
        if (this.O000000o == null) {
            this.O000000o = new O00000Oo();
        }
        this.O000000o.O000000o(this.O00000Oo.O000000o(context, "isTargetRequired"));
        this.O000000o.O000000o(context);
    }

    /* Access modifiers changed, original: final */
    public final void O000000o(Context context, boolean z) {
        if (this.O000000o == null) {
            this.O000000o = new O00000Oo();
        }
        this.O00000Oo.O000000o(context, "isTargetRequired", z);
        this.O000000o.O000000o(z);
    }

    public final void O000000o(boolean z) {
        if (this.O000000o == null) {
            this.O000000o = new O00000Oo();
        }
        this.O000000o.O00000Oo(z);
    }

    public final void O00000Oo(Context context) {
        this.O00000Oo.O000000o(context, "isTargetRequired", true);
    }

    public final boolean O00000Oo(boolean z) {
        if (O00000Oo()) {
            return false;
        }
        if (!z) {
            if (this.O000000o == null) {
                this.O000000o = new O00000Oo();
            }
            if (!this.O000000o.O000000o()) {
                return false;
            }
        }
        return true;
    }
}
