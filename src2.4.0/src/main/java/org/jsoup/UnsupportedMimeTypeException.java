package org.jsoup;

import java.io.IOException;

public class UnsupportedMimeTypeException extends IOException {
    private String O000000o;
    private String O00000Oo;

    public UnsupportedMimeTypeException(String str, String str2, String str3) {
        super(str);
        this.O000000o = str2;
        this.O00000Oo = str3;
    }

    public String O000000o() {
        return this.O000000o;
    }

    public String O00000Oo() {
        return this.O00000Oo;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(". Mimetype=");
        stringBuilder.append(this.O000000o);
        stringBuilder.append(", URL=");
        stringBuilder.append(this.O00000Oo);
        return stringBuilder.toString();
    }
}
