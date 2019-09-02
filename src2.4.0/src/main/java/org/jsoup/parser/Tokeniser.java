package org.jsoup.parser;

import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.util.Arrays;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities;

final class Tokeniser {
    static final char O000000o = '�';
    private static final char[] O0000Oo0 = new char[]{9, 10, 13, 12, ' ', '<', '&'};
    StringBuilder O00000Oo = new StringBuilder(XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
    StartTag O00000o = new StartTag();
    Tag O00000o0;
    EndTag O00000oO = new EndTag();
    Character O00000oo = new Character();
    Doctype O0000O0o = new Doctype();
    Comment O0000OOo = new Comment();
    private final CharacterReader O0000Oo;
    private final ParseErrorList O0000OoO;
    private TokeniserState O0000Ooo = TokeniserState.Data;
    private String O0000o;
    private boolean O0000o0 = false;
    private Token O0000o00;
    private String O0000o0O = null;
    private StringBuilder O0000o0o = new StringBuilder(XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE);
    private final int[] O0000oO = new int[1];
    private boolean O0000oO0 = true;
    private final int[] O0000oOO = new int[2];

    static {
        Arrays.sort(O0000Oo0);
    }

    Tokeniser(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.O0000Oo = characterReader;
        this.O0000OoO = parseErrorList;
    }

    private void O00000Oo(String str) {
        if (this.O0000OoO.O000000o()) {
            this.O0000OoO.add(new ParseError(this.O0000Oo.O000000o(), "Invalid character reference: %s", str));
        }
    }

    private void O00000o0(String str) {
        if (this.O0000OoO.O000000o()) {
            this.O0000OoO.add(new ParseError(this.O0000Oo.O000000o(), str));
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Tag O000000o(boolean z) {
        this.O00000o0 = z ? this.O00000o.O00000Oo() : this.O00000oO.O00000Oo();
        return this.O00000o0;
    }

    /* Access modifiers changed, original: 0000 */
    public Token O000000o() {
        if (!this.O0000oO0) {
            O00000o0("Self closing flag not acknowledged");
            this.O0000oO0 = true;
        }
        while (!this.O0000o0) {
            this.O0000Ooo.O000000o(this, this.O0000Oo);
        }
        if (this.O0000o0o.length() > 0) {
            String stringBuilder = this.O0000o0o.toString();
            this.O0000o0o.delete(0, this.O0000o0o.length());
            this.O0000o0O = null;
            return this.O00000oo.O000000o(stringBuilder);
        } else if (this.O0000o0O != null) {
            Character O000000o = this.O00000oo.O000000o(this.O0000o0O);
            this.O0000o0O = null;
            return O000000o;
        } else {
            this.O0000o0 = false;
            return this.O0000o00;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(char c) {
        O000000o(String.valueOf(c));
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(String str) {
        if (this.O0000o0O == null) {
            this.O0000o0O = str;
            return;
        }
        if (this.O0000o0o.length() == 0) {
            this.O0000o0o.append(this.O0000o0O);
        }
        this.O0000o0o.append(str);
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Token token) {
        Validate.O00000Oo(this.O0000o0, "There is an unread token pending!");
        this.O0000o00 = token;
        this.O0000o0 = true;
        if (token.O000000o == TokenType.StartTag) {
            StartTag startTag = (StartTag) token;
            this.O0000o = startTag.O00000Oo;
            if (startTag.O00000o) {
                this.O0000oO0 = false;
            }
        } else if (token.O000000o == TokenType.EndTag && ((EndTag) token).O00000oO != null) {
            O00000o0("Attributes incorrectly present on end tag");
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(TokeniserState tokeniserState) {
        this.O0000Ooo = tokeniserState;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(char[] cArr) {
        O000000o(String.valueOf(cArr));
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(int[] iArr) {
        O000000o(new String(iArr, 0, iArr.length));
    }

    /* Access modifiers changed, original: 0000 */
    public int[] O000000o(Character ch, boolean z) {
        if (this.O0000Oo.O00000Oo()) {
            return null;
        }
        if ((ch != null && ch.charValue() == this.O0000Oo.O00000o0()) || this.O0000Oo.O00000o(O0000Oo0)) {
            return null;
        }
        int[] iArr = this.O0000oO;
        this.O0000Oo.O0000O0o();
        String O0000o0O;
        int intValue;
        if (this.O0000Oo.O00000o("#")) {
            z = this.O0000Oo.O00000oO("X");
            O0000o0O = z ? this.O0000Oo.O0000o0O() : this.O0000Oo.O0000o0o();
            if (O0000o0O.length() == 0) {
                O00000Oo("numeric reference with no numerals");
                this.O0000Oo.O0000OOo();
                return null;
            }
            if (!this.O0000Oo.O00000o(";")) {
                O00000Oo("missing semicolon");
            }
            try {
                intValue = Integer.valueOf(O0000o0O, z ? 16 : 10).intValue();
            } catch (NumberFormatException unused) {
                intValue = -1;
            }
            if (intValue == -1 || ((intValue >= 55296 && intValue <= 57343) || intValue > 1114111)) {
                O00000Oo("character outside of valid range");
                iArr[0] = 65533;
                return iArr;
            }
            iArr[0] = intValue;
            return iArr;
        }
        O0000o0O = this.O0000Oo.O0000o0();
        boolean O00000o0 = this.O0000Oo.O00000o0(';');
        int i = (Entities.O00000Oo(O0000o0O) || (Entities.O000000o(O0000o0O) && O00000o0)) ? 1 : 0;
        if (i == 0) {
            this.O0000Oo.O0000OOo();
            if (O00000o0) {
                O00000Oo(String.format("invalid named referenece '%s'", new Object[]{O0000o0O}));
            }
            return null;
        } else if (z && (this.O0000Oo.O0000o() || this.O0000Oo.O0000oO0() || this.O0000Oo.O00000o0('=', '-', '_'))) {
            this.O0000Oo.O0000OOo();
            return null;
        } else {
            if (!this.O0000Oo.O00000o(";")) {
                O00000Oo("missing semicolon");
            }
            intValue = Entities.O000000o(O0000o0O, this.O0000oOO);
            if (intValue == 1) {
                iArr[0] = this.O0000oOO[0];
                return iArr;
            } else if (intValue == 2) {
                return this.O0000oOO;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected characters returned for ");
                stringBuilder.append(O0000o0O);
                Validate.O00000Oo(stringBuilder.toString());
                return this.O0000oOO;
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public String O00000Oo(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        while (!this.O0000Oo.O00000Oo()) {
            stringBuilder.append(this.O0000Oo.O00000Oo('&'));
            if (this.O0000Oo.O00000o0('&')) {
                this.O0000Oo.O00000o();
                int[] O000000o = O000000o(null, z);
                if (O000000o == null || O000000o.length == 0) {
                    stringBuilder.append('&');
                } else {
                    stringBuilder.appendCodePoint(O000000o[0]);
                    if (O000000o.length == 2) {
                        stringBuilder.appendCodePoint(O000000o[1]);
                    }
                }
            }
        }
        return stringBuilder.toString();
    }

    /* Access modifiers changed, original: 0000 */
    public TokeniserState O00000Oo() {
        return this.O0000Ooo;
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(TokeniserState tokeniserState) {
        this.O0000Oo.O00000oo();
        this.O0000Ooo = tokeniserState;
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o() {
        this.O00000o0.O0000o0o();
        O000000o(this.O00000o0);
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o(TokeniserState tokeniserState) {
        if (this.O0000OoO.O000000o()) {
            this.O0000OoO.add(new ParseError(this.O0000Oo.O000000o(), "Unexpectedly reached end of file (EOF) in input state [%s]", tokeniserState));
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o0() {
        this.O0000oO0 = true;
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000o0(TokeniserState tokeniserState) {
        if (this.O0000OoO.O000000o()) {
            this.O0000OoO.add(new ParseError(this.O0000Oo.O000000o(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.O0000Oo.O00000o0()), tokeniserState));
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000oO() {
        this.O0000OOo.O00000Oo();
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000oo() {
        O000000o(this.O0000OOo);
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000O0o() {
        this.O0000O0o.O00000Oo();
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000OOo() {
        O000000o(this.O0000O0o);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O0000Oo() {
        return this.O0000o != null && this.O00000o0.O0000o().equalsIgnoreCase(this.O0000o);
    }

    /* Access modifiers changed, original: 0000 */
    public void O0000Oo0() {
        Token.O000000o(this.O00000Oo);
    }

    /* Access modifiers changed, original: 0000 */
    public String O0000OoO() {
        return this.O0000o == null ? null : this.O0000o;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O0000Ooo() {
        return true;
    }
}
