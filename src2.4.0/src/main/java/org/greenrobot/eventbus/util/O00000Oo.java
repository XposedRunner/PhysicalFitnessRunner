package org.greenrobot.eventbus.util;

import android.content.res.Resources;
import android.util.Log;
import org.greenrobot.eventbus.O00000o0;

/* compiled from: ErrorDialogConfig */
public class O00000Oo {
    final Resources O000000o;
    final int O00000Oo;
    final O00000o O00000o;
    final int O00000o0;
    O00000o0 O00000oO;
    boolean O00000oo = true;
    String O0000O0o;
    int O0000OOo;
    Class<?> O0000Oo0;

    public O00000Oo(Resources resources, int i, int i2) {
        this.O000000o = resources;
        this.O00000Oo = i;
        this.O00000o0 = i2;
        this.O00000o = new O00000o();
    }

    public int O000000o(Throwable th) {
        Integer O000000o = this.O00000o.O000000o(th);
        if (O000000o != null) {
            return O000000o.intValue();
        }
        String str = O00000o0.O000000o;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No specific message ressource ID found for ");
        stringBuilder.append(th);
        Log.d(str, stringBuilder.toString());
        return this.O00000o0;
    }

    public O00000Oo O000000o(Class<? extends Throwable> cls, int i) {
        this.O00000o.O000000o(cls, i);
        return this;
    }

    public void O000000o() {
        this.O00000oo = false;
    }

    public void O000000o(int i) {
        this.O0000OOo = i;
    }

    public void O000000o(Class<?> cls) {
        this.O0000Oo0 = cls;
    }

    public void O000000o(String str) {
        this.O0000O0o = str;
    }

    public void O000000o(O00000o0 o00000o0) {
        this.O00000oO = o00000o0;
    }

    /* Access modifiers changed, original: 0000 */
    public O00000o0 O00000Oo() {
        return this.O00000oO != null ? this.O00000oO : O00000o0.O000000o();
    }
}
