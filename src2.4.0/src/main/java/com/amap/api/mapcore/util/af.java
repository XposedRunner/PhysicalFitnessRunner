package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SoInstallTaskRunner */
public final class af extends ag {
    private String O000000o;
    private oO0O00o0 O00000Oo;
    private Context O00000o;
    private List<com.amap.api.mapcore.util.ag.O000000o> O00000o0 = new ArrayList();
    private ao O00000oO;
    private x O00000oo;

    /* compiled from: SoInstallTaskRunner */
    static class O000000o implements com.amap.api.mapcore.util.ag.O000000o {
        private x O000000o;
        private ao O00000Oo;
        private Context O00000o;
        private oO0O00o0 O00000o0;

        public O000000o(x xVar, ao aoVar, oO0O00o0 oo0o00o0, Context context) {
            this.O000000o = xVar;
            this.O00000Oo = aoVar;
            this.O00000o0 = oo0o00o0;
            this.O00000o = context;
        }

        public final int O000000o() {
            kr O00000o = this.O00000o0.O00000o();
            t.O00000o(this.O000000o.O0000O0o());
            int i = 0;
            while (i < O00000o.O00000Oo().size()) {
                String O000000o = ((y) O00000o.O00000Oo().get(i)).O000000o();
                try {
                    t.O00000Oo(this.O000000o.O00000o0(O000000o), this.O000000o.O00000Oo(O000000o));
                    i++;
                } catch (Throwable unused) {
                    return 1003;
                }
            }
            this.O00000o0.O00000o(true);
            this.O00000o0.O00000Oo(this.O00000o);
            return 1000;
        }

        public final void O00000Oo() {
            this.O00000Oo.O00000o0(this.O000000o.O00000oo());
            oO0O00o0.O00000o0(this.O00000o);
        }
    }

    /* compiled from: SoInstallTaskRunner */
    static class O00000Oo implements com.amap.api.mapcore.util.ag.O000000o {
        private String O000000o;
        private x O00000Oo;
        private ao O00000o;
        private Context O00000o0;

        public O00000Oo(String str, x xVar, Context context, ao aoVar) {
            this.O000000o = str;
            this.O00000Oo = xVar;
            this.O00000o0 = context;
            this.O00000o = aoVar;
        }

        public final int O000000o() {
            try {
                t.O00000Oo(this.O000000o, this.O00000Oo.O0000Oo0());
                if (!aq.O000000o(this.O00000Oo.O0000Oo0())) {
                    return 1003;
                }
                t.O000000o(this.O00000Oo.O0000Oo0(), this.O00000Oo);
                return 1000;
            } catch (Throwable unused) {
                return 1003;
            }
        }

        public final void O00000Oo() {
            this.O00000o.O00000o0(this.O00000Oo.O00000oo());
        }
    }

    /* compiled from: SoInstallTaskRunner */
    static class O00000o0 implements com.amap.api.mapcore.util.ag.O000000o {
        private Context O000000o;
        private kr O00000Oo;
        private ao O00000o;
        private x O00000o0;

        public O00000o0(Context context, kr krVar, x xVar, ao aoVar) {
            this.O000000o = context;
            this.O00000Oo = krVar;
            this.O00000o0 = xVar;
            this.O00000o = aoVar;
        }

        public final int O000000o() {
            return this.O00000Oo.O000000o(this.O00000o0) ? 1000 : 1003;
        }

        public final void O00000Oo() {
            this.O00000o.O00000o0(this.O00000o0.O00000oo());
        }
    }

    public af(String str, oO0O00o0 oo0o00o0, Context context, ao aoVar, x xVar) {
        this.O000000o = str;
        this.O00000Oo = oo0o00o0;
        this.O00000o = context;
        this.O00000oO = aoVar;
        this.O00000oo = xVar;
        kr O00000o = this.O00000Oo.O00000o();
        this.O00000o0.add(new O00000Oo(this.O000000o, this.O00000oo, this.O00000o, this.O00000oO));
        this.O00000o0.add(new O00000o0(this.O00000o, O00000o, this.O00000oo, this.O00000oO));
        this.O00000o0.add(new O000000o(this.O00000oo, this.O00000oO, this.O00000Oo, this.O00000o));
    }

    /* Access modifiers changed, original: protected|final */
    public final List<com.amap.api.mapcore.util.ag.O000000o> O000000o() {
        return this.O00000o0;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:15:0x0023, code skipped:
            return false;
     */
    public final boolean O00000Oo() {
        /*
        r2 = this;
        r0 = r2.O000000o;
        r0 = android.text.TextUtils.isEmpty(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = r2.O00000Oo;
        if (r0 == 0) goto L_0x0023;
    L_0x000e:
        r0 = r2.O00000Oo;
        r0 = r0.O00000o();
        if (r0 != 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0023;
    L_0x0017:
        r0 = r2.O00000o;
        if (r0 != 0) goto L_0x001c;
    L_0x001b:
        return r1;
    L_0x001c:
        r0 = r2.O00000oo;
        if (r0 != 0) goto L_0x0021;
    L_0x0020:
        return r1;
    L_0x0021:
        r0 = 1;
        return r0;
    L_0x0023:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.af.O00000Oo():boolean");
    }
}
