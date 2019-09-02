package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DexInstallTaskRunner */
public final class ac extends ag {
    private oO00OO0O O000000o;
    private v O00000Oo;
    private String O00000o;
    private Context O00000o0;
    private ao O00000oO;
    private oO0O00o0 O00000oo;
    private List<com.amap.api.mapcore.util.ag.O000000o> O0000O0o = new ArrayList();

    /* compiled from: DexInstallTaskRunner */
    static class O000000o implements com.amap.api.mapcore.util.ag.O000000o {
        private String O000000o;
        private String O00000Oo;
        private ao O00000o;
        private v O00000o0;
        private oO0O00o0 O00000oO;
        private Context O00000oo;

        public O000000o(String str, String str2, v vVar, ao aoVar, oO0O00o0 oo0o00o0, Context context) {
            this.O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = vVar;
            this.O00000o = aoVar;
            this.O00000oO = oo0o00o0;
            this.O00000oo = context;
        }

        public final int O000000o() {
            String O0000Oo0 = this.O00000o0.O0000Oo0();
            t.O000000o(this.O000000o, O0000Oo0);
            if (!t.O0000O0o(O0000Oo0) || !aq.O000000o(O0000Oo0)) {
                return 1003;
            }
            t.O00000Oo(O0000Oo0, this.O00000o0.O0000O0o());
            if (!t.O00000o(this.O00000Oo, O0000Oo0)) {
                return 1003;
            }
            t.O00000oO(this.O00000o0.O0000Oo());
            t.O000000o(O0000Oo0, this.O00000o0.O0000Oo());
            return !t.O0000O0o(this.O00000o0.O0000Oo()) ? 1003 : 1000;
        }

        public final void O00000Oo() {
            this.O00000o.O00000Oo(this.O00000o0.O0000Oo0());
            this.O00000o.O00000Oo(this.O000000o);
            this.O00000o.O00000o0(this.O00000o0.O0000Oo());
        }
    }

    public ac(oO00OO0O oo00oo0o, v vVar, Context context, String str, ao aoVar, oO0O00o0 oo0o00o0) {
        this.O000000o = oo00oo0o;
        this.O00000Oo = vVar;
        this.O00000o0 = context;
        this.O00000o = str;
        this.O00000oO = aoVar;
        this.O00000oo = oo0o00o0;
    }

    /* Access modifiers changed, original: protected|final */
    public final List<com.amap.api.mapcore.util.ag.O000000o> O000000o() {
        this.O0000O0o.add(new O000000o(this.O00000o, this.O000000o.O00000Oo(), this.O00000Oo, this.O00000oO, this.O00000oo, this.O00000o0));
        return this.O0000O0o;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O00000Oo() {
        return (TextUtils.isEmpty(this.O00000o) || this.O000000o == null) ? false : true;
    }
}
