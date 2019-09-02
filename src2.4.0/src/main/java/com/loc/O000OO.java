package com.loc;

import android.content.Context;
import java.util.List;

/* compiled from: SDKDBOperation */
public final class O000OO {
    private O000O0o O000000o;
    private Context O00000Oo;

    public O000OO(Context context, boolean z) {
        this.O00000Oo = context;
        this.O000000o = O000000o(this.O00000Oo, z);
    }

    private static O000O0o O000000o(Context context, boolean z) {
        try {
            return new O000O0o(context, O000O0o.O000000o(O000OO0o.class));
        } catch (Throwable th) {
            if (!z) {
                O0000o.O00000Oo(th, "sd", "gdb");
            }
            return null;
        }
    }

    public final List<OO0Oo0> O000000o() {
        try {
            return this.O000000o.O000000o(OO0Oo0.O0000O0o(), OO0Oo0.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void O000000o(OO0Oo0 oO0Oo0) {
        if (oO0Oo0 != null) {
            try {
                boolean z = false;
                if (this.O000000o == null) {
                    this.O000000o = O000000o(this.O00000Oo, false);
                }
                String O000000o = OO0Oo0.O000000o(oO0Oo0.O000000o());
                List<OO0Oo0> O00000Oo = this.O000000o.O00000Oo(O000000o, OO0Oo0.class);
                if (O00000Oo != null) {
                    if (O00000Oo.size() != 0) {
                        for (OO0Oo0 equals : O00000Oo) {
                            if (equals.equals(oO0Oo0)) {
                                break;
                            }
                        }
                        z = true;
                        if (z) {
                            this.O000000o.O000000o(O000000o, (Object) oO0Oo0);
                        }
                        return;
                    }
                }
                this.O000000o.O000000o((Object) oO0Oo0);
            } catch (Throwable th) {
                O0000o.O00000Oo(th, "sd", "it");
            }
        }
    }
}
