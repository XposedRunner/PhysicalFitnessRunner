package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.al.O000000o;

/* compiled from: RollbackInfoDelegate */
public final class am {
    private volatile al O000000o = null;
    private String O00000Oo = "";

    private String O000000o() {
        if (!TextUtils.isEmpty(this.O00000Oo)) {
            return this.O00000Oo;
        }
        this.O00000Oo = o0OO00o0.O00000Oo("ROLL_BACK_KEY");
        return this.O00000Oo;
    }

    public final boolean O000000o(Context context, String str, String str2) {
        if (context == null) {
            return false;
        }
        if (this.O000000o == null) {
            this.O000000o = al.O000000o(t.O000000o(context, O000000o(), "i"));
        }
        al alVar = this.O000000o;
        if (alVar == null || alVar.O000000o() == null || alVar.O000000o().size() == 0) {
            return false;
        }
        for (O000000o o000000o : alVar.O000000o()) {
            String O000000o = o000000o.O000000o();
            boolean equalsIgnoreCase = (TextUtils.isEmpty(str) || TextUtils.isEmpty(O000000o)) ? false : str.trim().equalsIgnoreCase(O000000o.trim());
            if (equalsIgnoreCase && ar.O00000Oo(str2, o000000o.O00000Oo())) {
                return true;
            }
        }
        return false;
    }

    public final void O00000Oo(Context context, String str, String str2) {
        if (this.O000000o == null) {
            this.O000000o = al.O000000o(t.O000000o(context, O000000o(), "i"));
        }
        this.O000000o.O000000o(str, str2);
        t.O000000o(context, O000000o(), "i", this.O000000o.O00000Oo());
    }
}
