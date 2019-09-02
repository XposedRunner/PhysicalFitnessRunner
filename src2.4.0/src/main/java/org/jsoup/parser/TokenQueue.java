package org.jsoup.parser;

import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;

public class TokenQueue {
    private static final char O00000o0 = '\\';
    private String O000000o;
    private int O00000Oo = 0;

    public TokenQueue(String str) {
        Validate.O000000o((Object) str);
        this.O000000o = str;
    }

    public static String O0000Oo(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] toCharArray = str.toCharArray();
        int i = 0;
        int length = toCharArray.length;
        int i2 = 0;
        while (i < length) {
            char c = toCharArray[i];
            if (c != O00000o0) {
                stringBuilder.append(c);
            } else if (i2 != 0 && i2 == 92) {
                stringBuilder.append(c);
            }
            i++;
            char i22 = c;
        }
        return stringBuilder.toString();
    }

    private int O0000o0O() {
        return this.O000000o.length() - this.O00000Oo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067 A:{SYNTHETIC, EDGE_INSN: B:32:0x0067->B:28:0x0067 ?: BREAK  } */
    public java.lang.String O000000o(char r9, char r10) {
        /*
        r8 = this;
        r0 = 0;
        r1 = -1;
        r2 = r0;
        r5 = r2;
        r3 = r1;
        r4 = r3;
    L_0x0006:
        r6 = r8.O000000o();
        if (r6 == 0) goto L_0x000d;
    L_0x000c:
        goto L_0x0067;
    L_0x000d:
        r6 = r8.O0000O0o();
        r6 = java.lang.Character.valueOf(r6);
        if (r0 == 0) goto L_0x001b;
    L_0x0017:
        r7 = 92;
        if (r0 == r7) goto L_0x005b;
    L_0x001b:
        r7 = 39;
        r7 = java.lang.Character.valueOf(r7);
        r7 = r6.equals(r7);
        if (r7 != 0) goto L_0x0033;
    L_0x0027:
        r7 = 34;
        r7 = java.lang.Character.valueOf(r7);
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x003b;
    L_0x0033:
        r7 = r6.charValue();
        if (r7 == r9) goto L_0x003b;
    L_0x0039:
        r2 = r2 ^ 1;
    L_0x003b:
        if (r2 == 0) goto L_0x003e;
    L_0x003d:
        goto L_0x0065;
    L_0x003e:
        r7 = java.lang.Character.valueOf(r9);
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x004f;
    L_0x0048:
        r5 = r5 + 1;
        if (r3 != r1) goto L_0x005b;
    L_0x004c:
        r3 = r8.O00000Oo;
        goto L_0x005b;
    L_0x004f:
        r7 = java.lang.Character.valueOf(r10);
        r7 = r6.equals(r7);
        if (r7 == 0) goto L_0x005b;
    L_0x0059:
        r5 = r5 + -1;
    L_0x005b:
        if (r5 <= 0) goto L_0x0061;
    L_0x005d:
        if (r0 == 0) goto L_0x0061;
    L_0x005f:
        r4 = r8.O00000Oo;
    L_0x0061:
        r0 = r6.charValue();
    L_0x0065:
        if (r5 > 0) goto L_0x0006;
    L_0x0067:
        if (r4 < 0) goto L_0x0070;
    L_0x0069:
        r9 = r8.O000000o;
        r9 = r9.substring(r3, r4);
        goto L_0x0072;
    L_0x0070:
        r9 = "";
    L_0x0072:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.TokenQueue.O000000o(char, char):java.lang.String");
    }

    public void O000000o(Character ch) {
        O000000o(ch.toString());
    }

    public void O000000o(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.O000000o.substring(this.O00000Oo));
        this.O000000o = stringBuilder.toString();
        this.O00000Oo = 0;
    }

    public boolean O000000o() {
        return O0000o0O() == 0;
    }

    public boolean O000000o(char... cArr) {
        if (O000000o()) {
            return false;
        }
        for (char c : cArr) {
            if (this.O000000o.charAt(this.O00000Oo) == c) {
                return true;
            }
        }
        return false;
    }

    public boolean O000000o(String... strArr) {
        for (String O00000Oo : strArr) {
            if (O00000Oo(O00000Oo)) {
                return true;
            }
        }
        return false;
    }

    public char O00000Oo() {
        return O000000o() ? 0 : this.O000000o.charAt(this.O00000Oo);
    }

    public String O00000Oo(String... strArr) {
        int i = this.O00000Oo;
        while (!O000000o() && !O000000o(strArr)) {
            this.O00000Oo++;
        }
        return this.O000000o.substring(i, this.O00000Oo);
    }

    public boolean O00000Oo(String str) {
        return this.O000000o.regionMatches(true, this.O00000Oo, str, 0, str.length());
    }

    public boolean O00000o() {
        return !O000000o() && StringUtil.O00000Oo(this.O000000o.charAt(this.O00000Oo));
    }

    public boolean O00000o(String str) {
        if (!O00000Oo(str)) {
            return false;
        }
        this.O00000Oo += str.length();
        return true;
    }

    public boolean O00000o0() {
        return O0000o0O() >= 2 && this.O000000o.charAt(this.O00000Oo) == '<' && Character.isLetter(this.O000000o.charAt(this.O00000Oo + 1));
    }

    public boolean O00000o0(String str) {
        return this.O000000o.startsWith(str, this.O00000Oo);
    }

    public void O00000oO(String str) {
        if (O00000Oo(str)) {
            int length = str.length();
            if (length > O0000o0O()) {
                throw new IllegalStateException("Queue not long enough to consume sequence");
            }
            this.O00000Oo += length;
            return;
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public boolean O00000oO() {
        return !O000000o() && Character.isLetterOrDigit(this.O000000o.charAt(this.O00000Oo));
    }

    public String O00000oo(String str) {
        int indexOf = this.O000000o.indexOf(str, this.O00000Oo);
        if (indexOf == -1) {
            return O0000o0();
        }
        str = this.O000000o.substring(this.O00000Oo, indexOf);
        this.O00000Oo += str.length();
        return str;
    }

    public void O00000oo() {
        if (!O000000o()) {
            this.O00000Oo++;
        }
    }

    public char O0000O0o() {
        String str = this.O000000o;
        int i = this.O00000Oo;
        this.O00000Oo = i + 1;
        return str.charAt(i);
    }

    public String O0000O0o(String str) {
        int i = this.O00000Oo;
        String substring = str.substring(0, 1);
        boolean equals = substring.toLowerCase().equals(substring.toUpperCase());
        while (!O000000o() && !O00000Oo(str)) {
            if (equals) {
                int indexOf = this.O000000o.indexOf(substring, this.O00000Oo) - this.O00000Oo;
                if (indexOf == 0) {
                    this.O00000Oo++;
                } else if (indexOf < 0) {
                    this.O00000Oo = this.O000000o.length();
                } else {
                    this.O00000Oo += indexOf;
                }
            } else {
                this.O00000Oo++;
            }
        }
        return this.O000000o.substring(i, this.O00000Oo);
    }

    public String O0000OOo(String str) {
        String O00000oo = O00000oo(str);
        O00000o(str);
        return O00000oo;
    }

    public boolean O0000OOo() {
        boolean z = false;
        while (O00000o()) {
            this.O00000Oo++;
            z = true;
        }
        return z;
    }

    public String O0000Oo() {
        int i = this.O00000Oo;
        while (!O000000o() && (O00000oO() || O000000o(':', '_', '-'))) {
            this.O00000Oo++;
        }
        return this.O000000o.substring(i, this.O00000Oo);
    }

    public String O0000Oo0() {
        int i = this.O00000Oo;
        while (O00000oO()) {
            this.O00000Oo++;
        }
        return this.O000000o.substring(i, this.O00000Oo);
    }

    public String O0000Oo0(String str) {
        String O0000O0o = O0000O0o(str);
        O00000o(str);
        return O0000O0o;
    }

    public String O0000OoO() {
        int i = this.O00000Oo;
        while (!O000000o()) {
            if (!O00000oO()) {
                if (!O000000o("*|", "|", "_", "-")) {
                    break;
                }
            }
            this.O00000Oo++;
        }
        return this.O000000o.substring(i, this.O00000Oo);
    }

    public String O0000Ooo() {
        int i = this.O00000Oo;
        while (!O000000o() && (O00000oO() || O000000o('-', '_'))) {
            this.O00000Oo++;
        }
        return this.O000000o.substring(i, this.O00000Oo);
    }

    public String O0000o0() {
        String substring = this.O000000o.substring(this.O00000Oo, this.O000000o.length());
        this.O00000Oo = this.O000000o.length();
        return substring;
    }

    public String O0000o00() {
        int i = this.O00000Oo;
        while (!O000000o() && (O00000oO() || O000000o('-', '_', ':'))) {
            this.O00000Oo++;
        }
        return this.O000000o.substring(i, this.O00000Oo);
    }

    public String toString() {
        return this.O000000o.substring(this.O00000Oo);
    }
}
