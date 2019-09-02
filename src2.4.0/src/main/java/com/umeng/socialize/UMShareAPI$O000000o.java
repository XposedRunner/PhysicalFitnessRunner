package com.umeng.socialize;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000OOo;
import com.umeng.socialize.utils.O0000Oo0;
import com.umeng.socialize.utils.O0000o00.O00000o0;
import defpackage.cc.O00000Oo;
import defpackage.ce;
import defpackage.cf;
import defpackage.cl;
import defpackage.cq;
import defpackage.cv;

class UMShareAPI$O000000o extends O00000Oo<Void> {
    private Context O000000o;
    private boolean O00000Oo = false;
    private boolean O00000o0 = false;

    public UMShareAPI$O000000o(Context context) {
        this.O000000o = context;
        this.O00000Oo = O0000Oo0.O000000o(O0000OOo.O00000Oo(context));
        this.O00000o0 = O0000Oo0.O000000o();
    }

    private boolean O00000oO() {
        return this.O000000o.getSharedPreferences(ce.O000000o, 0).getBoolean("newinstall", false);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: O000000o */
    public Void O00000Oo() {
        boolean O00000oO = O00000oO();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O00000o0.O00000o);
        stringBuilder.append("6.9.4");
        O0000O0o.O000000o(stringBuilder.toString());
        if (!this.O00000Oo) {
            cl.O000000o(new cf(this.O000000o, O00000oO));
        }
        if (!this.O00000Oo) {
            O0000OOo.O00000oO(this.O000000o);
            cv.O000000o(com.umeng.socialize.utils.O00000Oo.O000000o());
            cq.O000000o(this.O000000o, true);
        } else if (this.O00000o0) {
            cv.O000000o(com.umeng.socialize.utils.O00000Oo.O000000o());
            cq.O000000o(this.O000000o, true);
        }
        return null;
    }

    public void O00000o0() {
        Editor edit = this.O000000o.getSharedPreferences(ce.O000000o, 0).edit();
        edit.putBoolean("newinstall", true);
        edit.commit();
    }
}
