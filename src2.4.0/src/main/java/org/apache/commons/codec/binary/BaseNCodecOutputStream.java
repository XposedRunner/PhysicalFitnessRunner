package org.apache.commons.codec.binary;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BaseNCodecOutputStream extends FilterOutputStream {
    private final BaseNCodec baseNCodec;
    private final Context context = new Context();
    private final boolean doEncode;
    private final byte[] singleByte = new byte[1];

    public BaseNCodecOutputStream(OutputStream outputStream, BaseNCodec baseNCodec, boolean z) {
        super(outputStream);
        this.baseNCodec = baseNCodec;
        this.doEncode = z;
    }

    private void flush(boolean z) throws IOException {
        int available = this.baseNCodec.available(this.context);
        if (available > 0) {
            byte[] bArr = new byte[available];
            available = this.baseNCodec.readResults(bArr, 0, available, this.context);
            if (available > 0) {
                this.out.write(bArr, 0, available);
            }
        }
        if (z) {
            this.out.flush();
        }
    }

    public void close() throws IOException {
        if (this.doEncode) {
            this.baseNCodec.encode(this.singleByte, 0, -1, this.context);
        } else {
            this.baseNCodec.decode(this.singleByte, 0, -1, this.context);
        }
        flush();
        this.out.close();
    }

    public void flush() throws IOException {
        flush(true);
    }

    public void write(int i) throws IOException {
        this.singleByte[0] = (byte) i;
        write(this.singleByte, 0, 1);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        } else if (i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i > bArr.length || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i2 > 0) {
            if (this.doEncode) {
                this.baseNCodec.encode(bArr, i, i2, this.context);
            } else {
                this.baseNCodec.decode(bArr, i, i2, this.context);
            }
            flush(false);
        }
    }
}
