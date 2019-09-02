package org.apache.commons.codec.binary;

import com.umeng.commonsdk.proguard.ap;
import java.util.Arrays;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public abstract class BaseNCodec implements BinaryDecoder, BinaryEncoder {
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD_DEFAULT = (byte) 61;
    public static final int PEM_CHUNK_SIZE = 64;
    protected final byte PAD = PAD_DEFAULT;
    private final int chunkSeparatorLength;
    private final int encodedBlockSize;
    protected final int lineLength;
    private final int unencodedBlockSize;

    static class Context {
        byte[] buffer;
        int currentLinePos;
        boolean eof;
        int ibitWorkArea;
        long lbitWorkArea;
        int modulus;
        int pos;
        int readPos;

        Context() {
        }

        public String toString() {
            return String.format("%s[buffer=%s, currentLinePos=%s, eof=%s, ibitWorkArea=%s, lbitWorkArea=%s, modulus=%s, pos=%s, readPos=%s]", new Object[]{getClass().getSimpleName(), Arrays.toString(this.buffer), Integer.valueOf(this.currentLinePos), Boolean.valueOf(this.eof), Integer.valueOf(this.ibitWorkArea), Long.valueOf(this.lbitWorkArea), Integer.valueOf(this.modulus), Integer.valueOf(this.pos), Integer.valueOf(this.readPos)});
        }
    }

    protected BaseNCodec(int i, int i2, int i3, int i4) {
        this.unencodedBlockSize = i;
        this.encodedBlockSize = i2;
        i = 0;
        int i5 = (i3 <= 0 || i4 <= 0) ? 0 : 1;
        if (i5 != 0) {
            i = (i3 / i2) * i2;
        }
        this.lineLength = i;
        this.chunkSeparatorLength = i4;
    }

    protected static boolean isWhiteSpace(byte b) {
        if (!(b == ap.k || b == (byte) 32)) {
            switch (b) {
                case (byte) 9:
                case (byte) 10:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private byte[] resizeBuffer(Context context) {
        if (context.buffer == null) {
            context.buffer = new byte[getDefaultBufferSize()];
            context.pos = 0;
            context.readPos = 0;
        } else {
            byte[] bArr = new byte[(context.buffer.length * 2)];
            System.arraycopy(context.buffer, 0, bArr, 0, context.buffer.length);
            context.buffer = bArr;
        }
        return context.buffer;
    }

    /* Access modifiers changed, original: 0000 */
    public int available(Context context) {
        return context.buffer != null ? context.pos - context.readPos : 0;
    }

    /* Access modifiers changed, original: protected */
    public boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (PAD_DEFAULT == b || isInAlphabet(b)) {
                return true;
            }
        }
        return false;
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public abstract void decode(byte[] bArr, int i, int i2, Context context);

    public byte[] decode(String str) {
        return decode(StringUtils.getBytesUtf8(str));
    }

    public byte[] decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        decode(bArr, 0, bArr.length, context);
        decode(bArr, 0, -1, context);
        bArr = new byte[context.pos];
        readResults(bArr, 0, bArr.length, context);
        return bArr;
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }

    public abstract void encode(byte[] bArr, int i, int i2, Context context);

    public byte[] encode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Context context = new Context();
        encode(bArr, 0, bArr.length, context);
        encode(bArr, 0, -1, context);
        bArr = new byte[(context.pos - context.readPos)];
        readResults(bArr, 0, bArr.length, context);
        return bArr;
    }

    public String encodeAsString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    public String encodeToString(byte[] bArr) {
        return StringUtils.newStringUtf8(encode(bArr));
    }

    /* Access modifiers changed, original: protected */
    public byte[] ensureBufferSize(int i, Context context) {
        return (context.buffer == null || context.buffer.length < context.pos + i) ? resizeBuffer(context) : context.buffer;
    }

    /* Access modifiers changed, original: protected */
    public int getDefaultBufferSize() {
        return DEFAULT_BUFFER_SIZE;
    }

    public long getEncodedLength(byte[] bArr) {
        long length = ((long) (((bArr.length + this.unencodedBlockSize) - 1) / this.unencodedBlockSize)) * ((long) this.encodedBlockSize);
        return this.lineLength > 0 ? length + ((((length + ((long) this.lineLength)) - 1) / ((long) this.lineLength)) * ((long) this.chunkSeparatorLength)) : length;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean hasData(Context context) {
        return context.buffer != null;
    }

    public abstract boolean isInAlphabet(byte b);

    public boolean isInAlphabet(String str) {
        return isInAlphabet(StringUtils.getBytesUtf8(str), true);
    }

    public boolean isInAlphabet(byte[] bArr, boolean z) {
        int i = 0;
        while (i < bArr.length) {
            if (!isInAlphabet(bArr[i]) && (!z || (bArr[i] != PAD_DEFAULT && !isWhiteSpace(bArr[i])))) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    public int readResults(byte[] bArr, int i, int i2, Context context) {
        if (context.buffer != null) {
            i2 = Math.min(available(context), i2);
            System.arraycopy(context.buffer, context.readPos, bArr, i, i2);
            context.readPos += i2;
            if (context.readPos >= context.pos) {
                context.buffer = null;
            }
            return i2;
        }
        return context.eof ? -1 : 0;
    }
}
