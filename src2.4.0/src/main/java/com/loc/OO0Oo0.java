package com.loc;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@ap(a = "a")
/* compiled from: SDKInfo */
public class OO0Oo0 {
    @aq(a = "a1", b = 6)
    private String O000000o;
    @aq(a = "a2", b = 6)
    private String O00000Oo;
    @aq(a = "a3", b = 6)
    private String O00000o;
    @aq(a = "a6", b = 2)
    private int O00000o0;
    @aq(a = "a4", b = 6)
    private String O00000oO;
    @aq(a = "a5", b = 6)
    private String O00000oo;
    private String O0000O0o;
    private String O0000OOo;
    private String O0000Oo;
    private String O0000Oo0;
    private String O0000OoO;
    private String[] O0000Ooo;

    /* compiled from: SDKInfo */
    public static class O000000o {
        private String O000000o;
        private String O00000Oo;
        private String O00000o;
        private String O00000o0;
        private boolean O00000oO = true;
        private String O00000oo = "standard";
        private String[] O0000O0o = null;

        public O000000o(String str, String str2, String str3) {
            this.O000000o = str2;
            this.O00000Oo = str2;
            this.O00000o = str3;
            this.O00000o0 = str;
        }

        public final O000000o O000000o(String str) {
            this.O00000Oo = str;
            return this;
        }

        public final O000000o O000000o(String[] strArr) {
            if (strArr != null) {
                this.O0000O0o = (String[]) strArr.clone();
            }
            return this;
        }

        public final OO0Oo0 O000000o() throws OO00Oo0 {
            if (this.O0000O0o != null) {
                return new OO0Oo0(this, (byte) 0);
            }
            throw new OO00Oo0("sdk packages is null");
        }
    }

    private OO0Oo0() {
        this.O00000o0 = 1;
        this.O0000Ooo = null;
    }

    private OO0Oo0(O000000o o000000o) {
        this.O00000o0 = 1;
        this.O0000Ooo = null;
        this.O0000O0o = o000000o.O000000o;
        this.O0000OOo = o000000o.O00000Oo;
        this.O0000Oo = o000000o.O00000o0;
        this.O0000Oo0 = o000000o.O00000o;
        this.O00000o0 = o000000o.O00000oO;
        this.O0000OoO = o000000o.O00000oo;
        this.O0000Ooo = o000000o.O0000O0o;
        this.O00000Oo = OO0o000.O00000Oo(this.O0000OOo);
        this.O000000o = OO0o000.O00000Oo(this.O0000Oo);
        this.O00000o = OO0o000.O00000Oo(this.O0000Oo0);
        this.O00000oO = OO0o000.O00000Oo(O000000o(this.O0000Ooo));
        this.O00000oo = OO0o000.O00000Oo(this.O0000OoO);
    }

    /* synthetic */ OO0Oo0(O000000o o000000o, byte b) {
        this(o000000o);
    }

    public static String O000000o(String str) {
        Map hashMap = new HashMap();
        hashMap.put("a1", OO0o000.O00000Oo(str));
        return O000O0o.O000000o(hashMap);
    }

    private static String O000000o(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (String append : strArr) {
                stringBuilder.append(append);
                stringBuilder.append(";");
            }
            return stringBuilder.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String[] O00000Oo(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String O0000O0o() {
        return "a6=1";
    }

    public final String O000000o() {
        if (TextUtils.isEmpty(this.O0000Oo) && !TextUtils.isEmpty(this.O000000o)) {
            this.O0000Oo = OO0o000.O00000o0(this.O000000o);
        }
        return this.O0000Oo;
    }

    public final void O000000o(boolean z) {
        this.O00000o0 = z;
    }

    public final String O00000Oo() {
        return this.O0000O0o;
    }

    public final String O00000o() {
        if (TextUtils.isEmpty(this.O0000OoO) && !TextUtils.isEmpty(this.O00000oo)) {
            this.O0000OoO = OO0o000.O00000o0(this.O00000oo);
        }
        if (TextUtils.isEmpty(this.O0000OoO)) {
            this.O0000OoO = "standard";
        }
        return this.O0000OoO;
    }

    public final String O00000o0() {
        if (TextUtils.isEmpty(this.O0000OOo) && !TextUtils.isEmpty(this.O00000Oo)) {
            this.O0000OOo = OO0o000.O00000o0(this.O00000Oo);
        }
        return this.O0000OOo;
    }

    public final boolean O00000oO() {
        return this.O00000o0 == 1;
    }

    public final String[] O00000oo() {
        if ((this.O0000Ooo == null || this.O0000Ooo.length == 0) && !TextUtils.isEmpty(this.O00000oO)) {
            this.O0000Ooo = O00000Oo(OO0o000.O00000o0(this.O00000oO));
        }
        return (String[]) this.O0000Ooo.clone();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return hashCode() == ((OO0Oo0) obj).hashCode();
    }

    public int hashCode() {
        O0000Oo0 o0000Oo0 = new O0000Oo0();
        o0000Oo0.O000000o(this.O0000Oo).O000000o(this.O0000O0o).O000000o(this.O0000OOo).O000000o(this.O0000Ooo);
        return o0000Oo0.O000000o();
    }
}
