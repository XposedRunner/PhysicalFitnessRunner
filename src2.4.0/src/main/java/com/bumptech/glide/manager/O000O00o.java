package com.bumptech.glide.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: RequestTracker */
public class O000O00o {
    private final Set<oO0Oo0O0> O000000o = Collections.newSetFromMap(new WeakHashMap());
    private final List<oO0Oo0O0> O00000Oo = new ArrayList();
    private boolean O00000o0;

    public void O000000o(oO0Oo0O0 oo0oo0o0) {
        this.O000000o.add(oo0oo0o0);
        if (this.O00000o0) {
            this.O00000Oo.add(oo0oo0o0);
        } else {
            oo0oo0o0.O00000Oo();
        }
    }

    public boolean O000000o() {
        return this.O00000o0;
    }

    public void O00000Oo() {
        this.O00000o0 = true;
        for (oO0Oo0O0 oo0oo0o0 : oOOO000o.O000000o(this.O000000o)) {
            if (oo0oo0o0.O0000O0o()) {
                oo0oo0o0.O00000oo();
                this.O00000Oo.add(oo0oo0o0);
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(oO0Oo0O0 oo0oo0o0) {
        this.O000000o.add(oo0oo0o0);
    }

    public void O00000o() {
        for (oO0Oo0O0 O00000o : oOOO000o.O000000o(this.O000000o)) {
            O00000o.O00000o();
        }
        this.O00000Oo.clear();
    }

    public void O00000o0() {
        this.O00000o0 = false;
        for (oO0Oo0O0 oo0oo0o0 : oOOO000o.O000000o(this.O000000o)) {
            if (!(oo0oo0o0.O0000OOo() || oo0oo0o0.O0000Oo() || oo0oo0o0.O0000O0o())) {
                oo0oo0o0.O00000Oo();
            }
        }
        this.O00000Oo.clear();
    }

    public void O00000o0(oO0Oo0O0 oo0oo0o0) {
        this.O000000o.remove(oo0oo0o0);
        this.O00000Oo.remove(oo0oo0o0);
    }

    public void O00000oO() {
        for (oO0Oo0O0 oo0oo0o0 : oOOO000o.O000000o(this.O000000o)) {
            if (!(oo0oo0o0.O0000OOo() || oo0oo0o0.O0000Oo())) {
                oo0oo0o0.O00000oo();
                if (this.O00000o0) {
                    this.O00000Oo.add(oo0oo0o0);
                } else {
                    oo0oo0o0.O00000Oo();
                }
            }
        }
    }
}
