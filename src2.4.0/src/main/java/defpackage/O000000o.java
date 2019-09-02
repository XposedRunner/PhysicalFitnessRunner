package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PushbackInputStream;

/* compiled from: BASE64Decoder */
/* renamed from: O000000o */
public class O000000o extends O0000O0o {
    private static final char[] O00000Oo = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] O00000o0 = new byte[256];
    byte[] O000000o;

    static {
        int i = 0;
        for (int i2 = 0; i2 < 255; i2++) {
            O00000o0[i2] = (byte) -1;
        }
        while (i < O00000Oo.length) {
            O00000o0[O00000Oo[i]] = (byte) i;
            i++;
        }
    }

    /* Access modifiers changed, original: protected */
    public int O000000o() {
        return 4;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(PushbackInputStream pushbackInputStream, OutputStream outputStream, int i) throws IOException {
    }

    /* Access modifiers changed, original: protected */
    public int O00000Oo() {
        return 0;
    }
}
