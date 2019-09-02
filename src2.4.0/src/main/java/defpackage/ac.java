package defpackage;

import android.text.TextUtils;

/* compiled from: EventBlackList */
/* renamed from: ac */
public class ac extends ab {
    private af O00000oO;
    private Object O00000oo = new Object();

    public ac(String str, String str2) {
        super(str, str2);
    }

    public void O000000o(boolean z) {
        u.O0000Oo0 = z;
    }

    public boolean O000000o(String str) {
        if (TextUtils.isEmpty(this.O00000o0)) {
            return false;
        }
        boolean O000000o;
        synchronized (this.O00000oo) {
            if (this.O00000oO == null) {
                this.O00000oO = new af(false, this.O00000o0);
            }
            O000000o = this.O00000oO.O000000o(str);
        }
        return O000000o;
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo() {
        if (!TextUtils.isEmpty(this.O00000o0)) {
            synchronized (this.O00000oo) {
                this.O00000oO = null;
                this.O00000oO = new af(false, this.O00000o0);
            }
        }
    }
}
