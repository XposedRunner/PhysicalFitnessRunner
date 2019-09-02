package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DexSoInstallTaskRunner */
public final class ad extends ag {
    private Context O000000o;
    private oO00OO0O O00000Oo;
    private oO0O00o0 O00000o;
    private ao O00000o0;
    private w O00000oO;
    private v O00000oo;
    private x O0000O0o;
    private List<com.amap.api.mapcore.util.ag.O000000o> O0000OOo = new ArrayList();

    /* compiled from: DexSoInstallTaskRunner */
    static class O000000o implements com.amap.api.mapcore.util.ag.O000000o {
        private ac O000000o;

        public O000000o(oO00OO0O oo00oo0o, v vVar, Context context, String str, ao aoVar, oO0O00o0 oo0o00o0) {
            this.O000000o = new ac(oo00oo0o, vVar, context, str, aoVar, oo0o00o0);
        }

        public final int O000000o() {
            return this.O000000o == null ? 1003 : this.O000000o.O00000o0();
        }

        public final void O00000Oo() {
        }
    }

    /* compiled from: DexSoInstallTaskRunner */
    static class O00000Oo implements com.amap.api.mapcore.util.ag.O000000o {
        private String O000000o;
        private ao O00000Oo;

        public O00000Oo(String str, ao aoVar) {
            this.O000000o = str;
            this.O00000Oo = aoVar;
        }

        public final int O000000o() {
            return !t.O0000O0o(this.O000000o) ? 1003 : 1000;
        }

        public final void O00000Oo() {
        }
    }

    /* compiled from: DexSoInstallTaskRunner */
    static class O00000o0 implements com.amap.api.mapcore.util.ag.O000000o {
        private af O000000o;

        public O00000o0(String str, oO0O00o0 oo0o00o0, Context context, ao aoVar, x xVar) {
            this.O000000o = new af(str, oo0o00o0, context, aoVar, xVar);
        }

        public final int O000000o() {
            return this.O000000o.O00000o0();
        }

        public final void O00000Oo() {
        }
    }

    /* compiled from: DexSoInstallTaskRunner */
    static class O00000o implements com.amap.api.mapcore.util.ag.O000000o {
        private String O000000o = null;
        private w O00000Oo;
        private ao O00000o0;

        public O00000o(String str, w wVar, ao aoVar) {
            this.O000000o = str;
            this.O00000Oo = wVar;
            this.O00000o0 = aoVar;
        }

        public final int O000000o() {
            String O0000Ooo = this.O00000Oo.O0000Ooo();
            String O0000OoO = this.O00000Oo.O0000OoO();
            String O0000Oo = this.O00000Oo.O0000Oo();
            t.O00000o0(this.O000000o, O0000Ooo);
            if (!aq.O000000o(O0000Ooo)) {
                return 1003;
            }
            t.O000000o(O0000Ooo, O0000OoO, O0000Oo);
            return 1000;
        }

        public final void O00000Oo() {
            String O0000Ooo = this.O00000Oo.O0000Ooo();
            String O0000O0o = this.O00000Oo.O0000O0o();
            String O0000OoO = this.O00000Oo.O0000OoO();
            String O0000Oo = this.O00000Oo.O0000Oo();
            ao.O000000o(O0000OoO);
            this.O00000o0.O00000Oo(O0000Oo);
            this.O00000o0.O00000Oo(O0000Ooo);
            this.O00000o0.O00000o0(O0000O0o);
        }
    }

    public ad(Context context, oO00OO0O oo00oo0o, ao aoVar, oO0O00o0 oo0o00o0, w wVar, v vVar, x xVar) {
        this.O000000o = context;
        this.O00000Oo = oo00oo0o;
        this.O00000o0 = aoVar;
        this.O00000o = oo0o00o0;
        this.O00000oO = wVar;
        this.O00000oo = vVar;
        this.O0000O0o = xVar;
        this.O0000OOo.add(new O00000Oo(this.O00000oO.O0000OOo(), this.O00000o0));
        this.O0000OOo.add(new ae(this.O00000oO.O0000OOo(), this.O00000Oo.O00000Oo(), this.O00000o0));
        this.O0000OOo.add(new O00000o(this.O00000oO.O0000OOo(), this.O00000oO, this.O00000o0));
        this.O0000OOo.add(new O000000o(this.O00000o.O00000o0(), this.O00000oo, this.O000000o, this.O00000oO.O0000OoO(), this.O00000o0, this.O00000o));
        this.O0000OOo.add(new O00000o0(this.O00000oO.O0000Oo(), this.O00000o, this.O000000o, this.O00000o0, this.O0000O0o));
    }

    /* Access modifiers changed, original: protected|final */
    public final List<com.amap.api.mapcore.util.ag.O000000o> O000000o() {
        return this.O0000OOo;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:22:0x0035, code skipped:
            return false;
     */
    /* JADX WARNING: Missing block: B:23:0x0036, code skipped:
            return false;
     */
    public final boolean O00000Oo() {
        /*
        r2 = this;
        r0 = r2.O000000o;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r2.O00000Oo;
        if (r0 == 0) goto L_0x0036;
    L_0x000a:
        r0 = r2.O00000Oo;
        r0 = r0.O00000Oo();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0017;
    L_0x0016:
        goto L_0x0036;
    L_0x0017:
        r0 = r2.O00000o;
        if (r0 == 0) goto L_0x0035;
    L_0x001b:
        r0 = r2.O00000o;
        r0 = r0.O00000o0();
        if (r0 != 0) goto L_0x0024;
    L_0x0023:
        goto L_0x0035;
    L_0x0024:
        r0 = r2.O00000oO;
        if (r0 != 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r0 = r2.O00000oo;
        if (r0 != 0) goto L_0x002e;
    L_0x002d:
        return r1;
    L_0x002e:
        r0 = r2.O0000O0o;
        if (r0 != 0) goto L_0x0033;
    L_0x0032:
        return r1;
    L_0x0033:
        r0 = 1;
        return r0;
    L_0x0035:
        return r1;
    L_0x0036:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ad.O00000Oo():boolean");
    }
}
