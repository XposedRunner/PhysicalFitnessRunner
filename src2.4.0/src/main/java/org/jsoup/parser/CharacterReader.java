package org.jsoup.parser;

import java.util.Arrays;
import java.util.Locale;
import org.jsoup.helper.Validate;

public final class CharacterReader {
    static final char O000000o = '￿';
    private static final int O00000Oo = 12;
    private final int O00000o;
    private final char[] O00000o0;
    private int O00000oO = 0;
    private int O00000oo = 0;
    private final String[] O0000O0o = new String[512];

    public CharacterReader(String str) {
        Validate.O000000o((Object) str);
        this.O00000o0 = str.toCharArray();
        this.O00000o = this.O00000o0.length;
    }

    private String O000000o(int i, int i2) {
        char[] cArr = this.O00000o0;
        String[] strArr = this.O0000O0o;
        if (i2 > 12) {
            return new String(cArr, i, i2);
        }
        int i3 = 0;
        int i4 = i;
        int i5 = 0;
        while (i3 < i2) {
            int i6 = 31 * i5;
            i3++;
            int i7 = cArr[i4] + i6;
            i4++;
            i5 = i7;
        }
        i3 = (strArr.length - 1) & i5;
        String str = strArr[i3];
        if (str == null) {
            str = new String(cArr, i, i2);
            strArr[i3] = str;
        } else if (O000000o(i, i2, str)) {
            return str;
        } else {
            str = new String(cArr, i, i2);
            strArr[i3] = str;
        }
        return str;
    }

    public int O000000o() {
        return this.O00000oO;
    }

    /* Access modifiers changed, original: 0000 */
    public int O000000o(char c) {
        for (int i = this.O00000oO; i < this.O00000o; i++) {
            if (c == this.O00000o0[i]) {
                return i - this.O00000oO;
            }
        }
        return -1;
    }

    /* Access modifiers changed, original: 0000 */
    public int O000000o(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        int i = this.O00000oO;
        while (i < this.O00000o) {
            if (charAt != this.O00000o0[i]) {
                while (true) {
                    i++;
                    if (i >= this.O00000o || charAt == this.O00000o0[i]) {
                        break;
                    }
                }
            }
            int i2 = i + 1;
            int length = (charSequence.length() + i2) - 1;
            if (i < this.O00000o && length <= this.O00000o) {
                int i3 = 1;
                int i4 = i2;
                while (i4 < length && charSequence.charAt(i3) == this.O00000o0[i4]) {
                    i4++;
                    i3++;
                }
                if (i4 == length) {
                    return i - this.O00000oO;
                }
            }
            i = i2;
        }
        return -1;
    }

    /* Access modifiers changed, original: 0000 */
    public String O000000o(String str) {
        int O000000o = O000000o((CharSequence) str);
        if (O000000o == -1) {
            return O0000Ooo();
        }
        String O000000o2 = O000000o(this.O00000oO, O000000o);
        this.O00000oO += O000000o;
        return O000000o2;
    }

    public String O000000o(char... cArr) {
        int i = this.O00000oO;
        int i2 = this.O00000o;
        char[] cArr2 = this.O00000o0;
        loop0:
        while (this.O00000oO < i2) {
            for (char c : cArr) {
                if (cArr2[this.O00000oO] == c) {
                    break loop0;
                }
            }
            this.O00000oO++;
        }
        return this.O00000oO > i ? O000000o(i, this.O00000oO - i) : "";
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O000000o(int i, int i2, String str) {
        if (i2 != str.length()) {
            return false;
        }
        char[] cArr = this.O00000o0;
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 == 0) {
                return true;
            }
            i2 = i + 1;
            int i5 = i3 + 1;
            if (cArr[i] != str.charAt(i3)) {
                return false;
            }
            i = i2;
            i2 = i4;
            i3 = i5;
        }
    }

    public String O00000Oo(char c) {
        int O000000o = O000000o(c);
        if (O000000o == -1) {
            return O0000Ooo();
        }
        String O000000o2 = O000000o(this.O00000oO, O000000o);
        this.O00000oO += O000000o;
        return O000000o2;
    }

    /* Access modifiers changed, original: varargs */
    public String O00000Oo(char... cArr) {
        int i = this.O00000oO;
        int i2 = this.O00000o;
        char[] cArr2 = this.O00000o0;
        while (this.O00000oO < i2 && Arrays.binarySearch(cArr, cArr2[this.O00000oO]) < 0) {
            this.O00000oO++;
        }
        return this.O00000oO > i ? O000000o(i, this.O00000oO - i) : "";
    }

    public boolean O00000Oo() {
        return this.O00000oO >= this.O00000o;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O00000Oo(String str) {
        int length = str.length();
        if (length > this.O00000o - this.O00000oO) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != this.O00000o0[this.O00000oO + i]) {
                return false;
            }
        }
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public char O00000o() {
        char c = this.O00000oO >= this.O00000o ? O000000o : this.O00000o0[this.O00000oO];
        this.O00000oO++;
        return c;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O00000o(String str) {
        if (!O00000Oo(str)) {
            return false;
        }
        this.O00000oO += str.length();
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O00000o(char[] cArr) {
        return !O00000Oo() && Arrays.binarySearch(cArr, this.O00000o0[this.O00000oO]) >= 0;
    }

    public char O00000o0() {
        return this.O00000oO >= this.O00000o ? O000000o : this.O00000o0[this.O00000oO];
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O00000o0(char c) {
        return !O00000Oo() && this.O00000o0[this.O00000oO] == c;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O00000o0(String str) {
        int length = str.length();
        if (length > this.O00000o - this.O00000oO) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (Character.toUpperCase(str.charAt(i)) != Character.toUpperCase(this.O00000o0[this.O00000oO + i])) {
                return false;
            }
        }
        return true;
    }

    /* Access modifiers changed, original: varargs */
    public boolean O00000o0(char... cArr) {
        if (O00000Oo()) {
            return false;
        }
        char c = this.O00000o0[this.O00000oO];
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000oO() {
        this.O00000oO--;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O00000oO(String str) {
        if (!O00000o0(str)) {
            return false;
        }
        this.O00000oO += str.length();
        return true;
    }

    public void O00000oo() {
        this.O00000oO++;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O00000oo(String str) {
        return O000000o(str.toLowerCase(Locale.ENGLISH)) > -1 || O000000o(str.toUpperCase(Locale.ENGLISH)) > -1;
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000O0o() {
        this.O00000oo = this.O00000oO;
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000OOo() {
        this.O00000oO = this.O00000oo;
    }

    /* Access modifiers changed, original: 0000 */
    public String O0000Oo() {
        int i = this.O00000oO;
        int i2 = this.O00000o;
        char[] cArr = this.O00000o0;
        while (this.O00000oO < i2) {
            char c = cArr[this.O00000oO];
            if (c == '&' || c == '<' || c == 0) {
                break;
            }
            this.O00000oO++;
        }
        return this.O00000oO > i ? O000000o(i, this.O00000oO - i) : "";
    }

    /* Access modifiers changed, original: 0000 */
    public String O0000Oo0() {
        char[] cArr = this.O00000o0;
        int i = this.O00000oO;
        this.O00000oO = i + 1;
        return new String(cArr, i, 1);
    }

    /* Access modifiers changed, original: 0000 */
    public String O0000OoO() {
        int i = this.O00000oO;
        int i2 = this.O00000o;
        char[] cArr = this.O00000o0;
        while (this.O00000oO < i2) {
            char c = cArr[this.O00000oO];
            if (c == 9 || c == 10 || c == 13 || c == 12 || c == ' ' || c == '/' || c == '>' || c == 0) {
                break;
            }
            this.O00000oO++;
        }
        return this.O00000oO > i ? O000000o(i, this.O00000oO - i) : "";
    }

    /* Access modifiers changed, original: 0000 */
    public String O0000Ooo() {
        String O000000o = O000000o(this.O00000oO, this.O00000o - this.O00000oO);
        this.O00000oO = this.O00000o;
        return O000000o;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O0000o() {
        boolean z = false;
        if (O00000Oo()) {
            return false;
        }
        char c = this.O00000o0[this.O00000oO];
        if ((c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || Character.isLetter(c))) {
            z = true;
        }
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public String O0000o0() {
        char c;
        int i = this.O00000oO;
        while (this.O00000oO < this.O00000o) {
            c = this.O00000o0[this.O00000oO];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c))) {
                break;
            }
            this.O00000oO++;
        }
        while (!O00000Oo()) {
            c = this.O00000o0[this.O00000oO];
            if (c < '0' || c > '9') {
                break;
            }
            this.O00000oO++;
        }
        return O000000o(i, this.O00000oO - i);
    }

    /* Access modifiers changed, original: 0000 */
    public String O0000o00() {
        int i = this.O00000oO;
        while (this.O00000oO < this.O00000o) {
            char c = this.O00000o0[this.O00000oO];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !Character.isLetter(c))) {
                break;
            }
            this.O00000oO++;
        }
        return O000000o(i, this.O00000oO - i);
    }

    /* Access modifiers changed, original: 0000 */
    public String O0000o0O() {
        int i = this.O00000oO;
        while (this.O00000oO < this.O00000o) {
            char c = this.O00000o0[this.O00000oO];
            if ((c < '0' || c > '9') && ((c < 'A' || c > 'F') && (c < 'a' || c > 'f'))) {
                break;
            }
            this.O00000oO++;
        }
        return O000000o(i, this.O00000oO - i);
    }

    /* Access modifiers changed, original: 0000 */
    public String O0000o0o() {
        int i = this.O00000oO;
        while (this.O00000oO < this.O00000o) {
            char c = this.O00000o0[this.O00000oO];
            if (c < '0' || c > '9') {
                break;
            }
            this.O00000oO++;
        }
        return O000000o(i, this.O00000oO - i);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O0000oO0() {
        boolean z = false;
        if (O00000Oo()) {
            return false;
        }
        char c = this.O00000o0[this.O00000oO];
        if (c >= '0' && c <= '9') {
            z = true;
        }
        return z;
    }

    public String toString() {
        return new String(this.O00000o0, this.O00000oO, this.O00000o - this.O00000oO);
    }
}
