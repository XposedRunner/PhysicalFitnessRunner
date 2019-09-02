package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: DexSoDownload */
public final class aa extends oOo00OO0 {
    private w O00000oo;
    private oO0O00o0 O0000O0o;
    private x O0000OOo;
    private v O0000Oo0;

    public aa(Context context, oO00OO0O oo00oo0o, oO0O00o0 oo0o00o0, o0OO0o00 o0oo0o00) {
        super(context, oo00oo0o, o0oo0o00);
        this.O0000O0o = oo0o00o0;
        this.O00000oo = new w(context, o0oo0o00);
        this.O00000o0 = this.O00000oo.O0000OOo();
        this.O0000OOo = new x(context, o0oo0o00);
        this.O0000Oo0 = new v(this.O00000oO, o0oo0o00);
    }

    public static boolean O000000o(o0OO0o00 o0oo0o00) {
        if (o0oo0o00 == null) {
            return false;
        }
        String O00000Oo = o0oo0o00.O00000Oo();
        String O00000o0 = o0oo0o00.O00000o0();
        return TextUtils.isEmpty(O00000o0) || ar.O000000o(O00000o0, O00000Oo) > 0;
    }

    public final void O000000o() {
        if (t.O0000O0o(this.O00000o0)) {
            onFinish();
        } else if (ap.O000000o(this.O00000oO)) {
            super.O000000o();
        }
    }

    public final void onFinish() {
        try {
            if (this.O00000o != null) {
                oOo00ooO.O000000o(this.O00000o);
            }
            Context context = this.O00000oO;
            if (context != null) {
                new ad(context, this.O000000o, ao.O000000o(), this.O0000O0o, this.O00000oo, this.O0000Oo0, this.O0000OOo).O00000o0();
            }
        } catch (Throwable th) {
            oOo00ooO.O000000o(th, "dDownLoad", "onFinish()");
        }
    }
}
