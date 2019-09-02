package com.geetest.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

/* compiled from: GTWebviewObservable */
public final class O00OO0O extends Observable {
    private final ArrayList<O00OOOo> O000000o = new ArrayList();

    public final void O000000o() {
        Iterator it = this.O000000o.iterator();
        while (it.hasNext()) {
            ((O00OOOo) it.next()).O000000o();
        }
    }

    public final synchronized void O000000o(O00OOOo o00OOOo) {
        if (o00OOOo != null) {
            if (!this.O000000o.contains(o00OOOo)) {
                this.O000000o.add(o00OOOo);
            }
        }
    }

    public final void O000000o(String str) {
        Iterator it = this.O000000o.iterator();
        while (it.hasNext()) {
            ((O00OOOo) it.next()).O000000o(str);
        }
    }

    public final void O000000o(String str, String str2) {
        Iterator it = this.O000000o.iterator();
        while (it.hasNext()) {
            ((O00OOOo) it.next()).O000000o(str, str2);
        }
    }

    public final void O00000Oo() {
        Iterator it = this.O000000o.iterator();
        while (it.hasNext()) {
            ((O00OOOo) it.next()).O00000Oo();
        }
    }
}
