package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle */
class O000000o implements O0000Oo0 {
    private final Set<O0000Oo> O000000o = Collections.newSetFromMap(new WeakHashMap());
    private boolean O00000Oo;
    private boolean O00000o0;

    O000000o() {
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o() {
        this.O00000Oo = true;
        for (O0000Oo O0000O0o : oOOO000o.O000000o(this.O000000o)) {
            O0000O0o.O0000O0o();
        }
    }

    public void O000000o(O0000Oo o0000Oo) {
        this.O000000o.add(o0000Oo);
        if (this.O00000o0) {
            o0000Oo.O0000Oo0();
        } else if (this.O00000Oo) {
            o0000Oo.O0000O0o();
        } else {
            o0000Oo.O0000OOo();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo() {
        this.O00000Oo = false;
        for (O0000Oo O0000OOo : oOOO000o.O000000o(this.O000000o)) {
            O0000OOo.O0000OOo();
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o0() {
        this.O00000o0 = true;
        for (O0000Oo O0000Oo0 : oOOO000o.O000000o(this.O000000o)) {
            O0000Oo0.O0000Oo0();
        }
    }
}
