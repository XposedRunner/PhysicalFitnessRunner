package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
public final class O00O0Oo0 implements Closeable {
    private final InputStream O000000o;
    private final Charset O00000Oo;
    private int O00000o;
    private byte[] O00000o0;
    private int O00000oO;

    public O00O0Oo0(InputStream inputStream, Charset charset) {
        this(inputStream, charset, (byte) 0);
    }

    private O00O0Oo0(InputStream inputStream, Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (charset.equals(O00O0o00.O000000o)) {
            this.O000000o = inputStream;
            this.O00000Oo = charset;
            this.O00000o0 = new byte[8192];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    private void O00000Oo() throws IOException {
        int read = this.O000000o.read(this.O00000o0, 0, this.O00000o0.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.O00000o = 0;
        this.O00000oO = read;
    }

    public final String O000000o() throws IOException {
        synchronized (this.O000000o) {
            if (this.O00000o0 == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.O00000o >= this.O00000oO) {
                O00000Oo();
            }
            for (int i2 = this.O00000o; i2 != this.O00000oO; i2++) {
                if (this.O00000o0[i2] == (byte) 10) {
                    int i3;
                    String str;
                    if (i2 != this.O00000o) {
                        i3 = i2 - 1;
                        if (this.O00000o0[i3] == (byte) 13) {
                            str = new String(this.O00000o0, this.O00000o, i3 - this.O00000o, this.O00000Oo.name());
                            this.O00000o = i2 + 1;
                            return str;
                        }
                    }
                    i3 = i2;
                    str = new String(this.O00000o0, this.O00000o, i3 - this.O00000o, this.O00000Oo.name());
                    this.O00000o = i2 + 1;
                    return str;
                }
            }
            AnonymousClass1 anonymousClass1 = new ByteArrayOutputStream((this.O00000oO - this.O00000o) + 80) {
                public final String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != (byte) 13) ? this.count : this.count - 1;
                    try {
                        return new String(this.buf, 0, i, O00O0Oo0.this.O00000Oo.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                anonymousClass1.write(this.O00000o0, this.O00000o, this.O00000oO - this.O00000o);
                this.O00000oO = -1;
                O00000Oo();
                i = this.O00000o;
                while (i != this.O00000oO) {
                    if (this.O00000o0[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.O00000o) {
                anonymousClass1.write(this.O00000o0, this.O00000o, i - this.O00000o);
            }
            this.O00000o = i + 1;
            String byteArrayOutputStream = anonymousClass1.toString();
            return byteArrayOutputStream;
        }
    }

    public final void close() throws IOException {
        synchronized (this.O000000o) {
            if (this.O00000o0 != null) {
                this.O00000o0 = null;
                this.O000000o.close();
            }
        }
    }
}
