package org.jsoup.parser;

import java.util.ArrayList;

public class ParseErrorList extends ArrayList<ParseError> {
    private static final int O000000o = 16;
    private final int O00000Oo;

    ParseErrorList(int i, int i2) {
        super(i);
        this.O00000Oo = i2;
    }

    public static ParseErrorList O000000o(int i) {
        return new ParseErrorList(16, i);
    }

    public static ParseErrorList O00000o0() {
        return new ParseErrorList(0, 0);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean O000000o() {
        return size() < this.O00000Oo;
    }

    /* Access modifiers changed, original: 0000 */
    public int O00000Oo() {
        return this.O00000Oo;
    }
}
