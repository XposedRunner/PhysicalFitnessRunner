package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: MobileUpdateStrategy */
public class l extends p {
    private Context O00000Oo;
    private int O00000o;
    private boolean O00000o0;
    private int O00000oO;

    public l(Context context, boolean z, int i, int i2) {
        this.O00000Oo = context;
        this.O00000o0 = z;
        this.O00000o = i;
        this.O00000oO = i2;
    }

    public void O000000o(int i) {
        if (o0O0o000.O0000oO0(this.O00000Oo) != 1) {
            String O000000o = o0OOOO00.O000000o(System.currentTimeMillis(), "yyyyMMdd");
            String O000000o2 = oO0Oo0oo.O000000o(this.O00000Oo, "iKey");
            if (!TextUtils.isEmpty(O000000o2)) {
                String[] split = O000000o2.split("\\|");
                if (split == null || split.length < 2) {
                    oO0Oo0oo.O00000Oo(this.O00000Oo, "iKey");
                } else if (O000000o.equals(split[0])) {
                    i += Integer.parseInt(split[1]);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o);
            stringBuilder.append("|");
            stringBuilder.append(i);
            oO0Oo0oo.O000000o(this.O00000Oo, "iKey", stringBuilder.toString());
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o() {
        if (o0O0o000.O0000oO0(this.O00000Oo) == 1) {
            return true;
        }
        if (!this.O00000o0) {
            return false;
        }
        String O000000o = oO0Oo0oo.O000000o(this.O00000Oo, "iKey");
        if (TextUtils.isEmpty(O000000o)) {
            return true;
        }
        String[] split = O000000o.split("\\|");
        if (split == null || split.length < 2) {
            oO0Oo0oo.O00000Oo(this.O00000Oo, "iKey");
            return true;
        }
        return !o0OOOO00.O000000o(System.currentTimeMillis(), "yyyyMMdd").equals(split[0]) || Integer.parseInt(split[1]) < this.O00000oO;
    }

    public int O00000Oo() {
        int i = (o0O0o000.O0000oO0(this.O00000Oo) == 1 || this.O00000o <= 0) ? ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.O00000o;
        return this.O000000o != null ? Math.max(i, this.O000000o.O00000Oo()) : i;
    }
}
