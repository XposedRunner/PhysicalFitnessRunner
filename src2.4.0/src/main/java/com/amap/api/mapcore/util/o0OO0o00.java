package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@hz(a = "a")
/* compiled from: SDKInfo */
public class o0OO0o00 {
    @ia(a = "a1", b = 6)
    private String O000000o;
    @ia(a = "a2", b = 6)
    private String O00000Oo;
    @ia(a = "a3", b = 6)
    private String O00000o;
    @ia(a = "a6", b = 2)
    private int O00000o0;
    @ia(a = "a4", b = 6)
    private String O00000oO;
    @ia(a = "a5", b = 6)
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

        public O000000o O000000o(String str) {
            this.O00000Oo = str;
            return this;
        }

        public O000000o O000000o(String[] strArr) {
            if (strArr != null) {
                this.O0000O0o = (String[]) strArr.clone();
            }
            return this;
        }

        public o0OO0o00 O000000o() throws o0O0oo0o {
            if (this.O0000O0o != null) {
                return new o0OO0o00(this);
            }
            throw new o0O0oo0o("sdk packages is null");
        }
    }

    private o0OO0o00() {
        this.O00000o0 = 1;
        this.O0000Ooo = null;
    }

    private o0OO0o00(O000000o o000000o) {
        this.O00000o0 = 1;
        this.O0000Ooo = null;
        this.O0000O0o = o000000o.O000000o;
        this.O0000OOo = o000000o.O00000Oo;
        this.O0000Oo = o000000o.O00000o0;
        this.O0000Oo0 = o000000o.O00000o;
        this.O00000o0 = o000000o.O00000oO;
        this.O0000OoO = o000000o.O00000oo;
        this.O0000Ooo = o000000o.O0000O0o;
        this.O00000Oo = o0OOOO00.O00000Oo(this.O0000OOo);
        this.O000000o = o0OOOO00.O00000Oo(this.O0000Oo);
        this.O00000o = o0OOOO00.O00000Oo(this.O0000Oo0);
        this.O00000oO = o0OOOO00.O00000Oo(O000000o(this.O0000Ooo));
        this.O00000oo = o0OOOO00.O00000Oo(this.O0000OoO);
    }

    public static String O000000o(String str) {
        Map hashMap = new HashMap();
        hashMap.put("a1", o0OOOO00.O00000Oo(str));
        return oO0O0o0o.O000000o(hashMap);
    }

    private String O000000o(String[] strArr) {
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

    private String[] O00000Oo(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String O0000OOo() {
        return "a6=1";
    }

    public String O000000o() {
        if (TextUtils.isEmpty(this.O0000Oo) && !TextUtils.isEmpty(this.O000000o)) {
            this.O0000Oo = o0OOOO00.O00000o0(this.O000000o);
        }
        return this.O0000Oo;
    }

    public void O000000o(boolean z) {
        this.O00000o0 = z;
    }

    public String O00000Oo() {
        return this.O0000O0o;
    }

    public String O00000o() {
        if (TextUtils.isEmpty(this.O0000Oo0) && !TextUtils.isEmpty(this.O00000o)) {
            this.O0000Oo0 = o0OOOO00.O00000o0(this.O00000o);
        }
        return this.O0000Oo0;
    }

    public String O00000o0() {
        if (TextUtils.isEmpty(this.O0000OOo) && !TextUtils.isEmpty(this.O00000Oo)) {
            this.O0000OOo = o0OOOO00.O00000o0(this.O00000Oo);
        }
        return this.O0000OOo;
    }

    public String O00000oO() {
        if (TextUtils.isEmpty(this.O0000OoO) && !TextUtils.isEmpty(this.O00000oo)) {
            this.O0000OoO = o0OOOO00.O00000o0(this.O00000oo);
        }
        if (TextUtils.isEmpty(this.O0000OoO)) {
            this.O0000OoO = "standard";
        }
        return this.O0000OoO;
    }

    public boolean O00000oo() {
        return this.O00000o0 == 1;
    }

    public String[] O0000O0o() {
        if ((this.O0000Ooo == null || this.O0000Ooo.length == 0) && !TextUtils.isEmpty(this.O00000oO)) {
            this.O0000Ooo = O00000Oo(o0OOOO00.O00000o0(this.O00000oO));
        }
        return (String[]) this.O0000Ooo.clone();
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (hashCode() == ((o0OO0o00) obj).hashCode()) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        oO0Ooooo oo0ooooo = new oO0Ooooo();
        oo0ooooo.O000000o(this.O0000Oo).O000000o(this.O0000O0o).O000000o(this.O0000OOo).O000000o(this.O0000Ooo);
        return oo0ooooo.O000000o();
    }
}
