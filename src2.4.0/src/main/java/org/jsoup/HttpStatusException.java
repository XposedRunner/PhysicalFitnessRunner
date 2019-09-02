package org.jsoup;

import java.io.IOException;

public class HttpStatusException extends IOException {
    private int O000000o;
    private String O00000Oo;

    public HttpStatusException(String str, int i, String str2) {
        super(str);
        this.O000000o = i;
        this.O00000Oo = str2;
    }

    public int O000000o() {
        return this.O000000o;
    }

    public String O00000Oo() {
        return this.O00000Oo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(". Status=");
        stringBuilder.append(this.O000000o);
        stringBuilder.append(", URL=");
        stringBuilder.append(this.O00000Oo);
        return stringBuilder.toString();
    }
}
