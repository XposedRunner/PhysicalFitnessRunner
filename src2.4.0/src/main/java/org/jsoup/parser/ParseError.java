package org.jsoup.parser;

public class ParseError {
    private int O000000o;
    private String O00000Oo;

    ParseError(int i, String str) {
        this.O000000o = i;
        this.O00000Oo = str;
    }

    ParseError(int i, String str, Object... objArr) {
        this.O00000Oo = String.format(str, objArr);
        this.O000000o = i;
    }

    public String O000000o() {
        return this.O00000Oo;
    }

    public int O00000Oo() {
        return this.O000000o;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.O000000o);
        stringBuilder.append(": ");
        stringBuilder.append(this.O00000Oo);
        return stringBuilder.toString();
    }
}
