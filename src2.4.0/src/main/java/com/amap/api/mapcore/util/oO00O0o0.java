package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;

/* compiled from: SDKDBOperation */
public class oO00O0o0 {
    private oO0O0o0o O000000o;
    private Context O00000Oo;

    public oO00O0o0(Context context, boolean z) {
        this.O00000Oo = context;
        this.O000000o = O000000o(this.O00000Oo, z);
    }

    private oO0O0o0o O000000o(Context context, boolean z) {
        try {
            return new oO0O0o0o(context, oO0O0o0o.O000000o(oO0O0OoO.class));
        } catch (Throwable th) {
            if (!z) {
                ooOOOOoo.O00000o0(th, "sd", "gdb");
            }
            return null;
        }
    }

    private boolean O000000o(List<o0OO0o00> list, o0OO0o00 o0oo0o00) {
        for (o0OO0o00 equals : list) {
            if (equals.equals(o0oo0o00)) {
                return false;
            }
        }
        return true;
    }

    public List<o0OO0o00> O000000o() {
        try {
            return this.O000000o.O000000o(o0OO0o00.O0000OOo(), o0OO0o00.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void O000000o(o0OO0o00 o0oo0o00) {
        if (o0oo0o00 != null) {
            try {
                if (this.O000000o == null) {
                    this.O000000o = O000000o(this.O00000Oo, false);
                }
                String O000000o = o0OO0o00.O000000o(o0oo0o00.O000000o());
                List O00000Oo = this.O000000o.O00000Oo(O000000o, o0OO0o00.class);
                if (O00000Oo != null) {
                    if (O00000Oo.size() != 0) {
                        if (O000000o(O00000Oo, o0oo0o00)) {
                            this.O000000o.O000000o(O000000o, (Object) o0oo0o00);
                        }
                    }
                }
                this.O000000o.O000000o((Object) o0oo0o00);
            } catch (Throwable th) {
                ooOOOOoo.O00000o0(th, "sd", "it");
            }
        }
    }
}
