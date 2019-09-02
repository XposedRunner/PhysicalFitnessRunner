package org.apache.commons.codec.binary;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import jp.co.cyberagent.android.gpuimage.O000000o;

public class BaseNCodecInputStream extends FilterInputStream {
    private final BaseNCodec baseNCodec;
    private final Context context = new Context();
    private final boolean doEncode;
    private final byte[] singleByte = new byte[1];

    protected BaseNCodecInputStream(InputStream inputStream, BaseNCodec baseNCodec, boolean z) {
        super(inputStream);
        this.doEncode = z;
        this.baseNCodec = baseNCodec;
    }

    public int available() throws IOException {
        return this.context.eof ^ 1;
    }

    public synchronized void mark(int i) {
    }

    public boolean markSupported() {
        return false;
    }

    public int read() throws IOException {
        int read = read(this.singleByte, 0, 1);
        while (read == 0) {
            read = read(this.singleByte, 0, 1);
        }
        if (read <= 0) {
            return -1;
        }
        read = this.singleByte[0];
        if (read < 0) {
            read += O000000o.O00000oO;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr == null) {
            throw new NullPointerException();
        } else if (i < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i > bArr.length || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            int i3 = 0;
            while (i3 == 0) {
                if (!this.baseNCodec.hasData(this.context)) {
                    byte[] bArr2 = new byte[(this.doEncode ? 4096 : 8192)];
                    int read = this.in.read(bArr2);
                    if (this.doEncode) {
                        this.baseNCodec.encode(bArr2, 0, read, this.context);
                    } else {
                        this.baseNCodec.decode(bArr2, 0, read, this.context);
                    }
                }
                i3 = this.baseNCodec.readResults(bArr, i, i2, this.context);
            }
            return i3;
        }
    }

    public synchronized void reset() throws IOException {
        throw new IOException("mark/reset not supported");
    }

    public long skip(long j) throws IOException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Negative skip length: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        byte[] bArr = new byte[512];
        long j2 = j;
        while (j2 > 0) {
            int read = read(bArr, 0, (int) Math.min((long) bArr.length, j2));
            if (read == -1) {
                break;
            }
            j2 -= (long) read;
        }
        return j - j2;
    }
}
