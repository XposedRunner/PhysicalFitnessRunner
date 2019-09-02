package org.apache.commons.codec.net;

import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.util.BitSet;
import jp.co.cyberagent.android.gpuimage.O000000o;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder {
    private static final byte ESCAPE_CHAR = (byte) 61;
    private static final BitSet PRINTABLE_CHARS = new BitSet(O000000o.O00000oO);
    private static final byte SPACE = (byte) 32;
    private static final byte TAB = (byte) 9;
    private final Charset charset;

    static {
        int i;
        for (i = 33; i <= 60; i++) {
            PRINTABLE_CHARS.set(i);
        }
        for (i = 62; i <= XmPlayerService.CODE_GET_RADIO_LIST; i++) {
            PRINTABLE_CHARS.set(i);
        }
        PRINTABLE_CHARS.set(9);
        PRINTABLE_CHARS.set(32);
    }

    public QuotedPrintableCodec() {
        this(Charsets.UTF_8);
    }

    public QuotedPrintableCodec(String str) throws IllegalCharsetNameException, IllegalArgumentException, UnsupportedCharsetException {
        this(Charset.forName(str));
    }

    public QuotedPrintableCodec(Charset charset) {
        this.charset = charset;
    }

    public static final byte[] decodeQuotedPrintable(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == ESCAPE_CHAR) {
                i++;
                try {
                    int digit16 = Utils.digit16(bArr[i]);
                    i++;
                    byteArrayOutputStream.write((char) ((digit16 << 4) + Utils.digit16(bArr[i])));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DecoderException("Invalid quoted-printable encoding", e);
                }
            }
            byteArrayOutputStream.write(b);
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static final void encodeQuotedPrintable(int i, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.write(61);
        char toUpperCase = Character.toUpperCase(Character.forDigit((i >> 4) & 15, 16));
        char toUpperCase2 = Character.toUpperCase(Character.forDigit(i & 15, 16));
        byteArrayOutputStream.write(toUpperCase);
        byteArrayOutputStream.write(toUpperCase2);
    }

    public static final byte[] encodeQuotedPrintable(BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = PRINTABLE_CHARS;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i : bArr) {
            int i2;
            if (i2 < 0) {
                i2 += O000000o.O00000oO;
            }
            if (bitSet.get(i2)) {
                byteArrayOutputStream.write(i2);
            } else {
                encodeQuotedPrintable(i2, byteArrayOutputStream);
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Objects of type ");
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append(" cannot be quoted-printable decoded");
        throw new DecoderException(stringBuilder.toString());
    }

    public String decode(String str) throws DecoderException {
        return decode(str, getCharset());
    }

    public String decode(String str, String str2) throws DecoderException, UnsupportedEncodingException {
        return str == null ? null : new String(decode(StringUtils.getBytesUsAscii(str)), str2);
    }

    public String decode(String str, Charset charset) throws DecoderException {
        return str == null ? null : new String(decode(StringUtils.getBytesUsAscii(str)), charset);
    }

    public byte[] decode(byte[] bArr) throws DecoderException {
        return decodeQuotedPrintable(bArr);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        if (obj instanceof String) {
            return encode((String) obj);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Objects of type ");
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append(" cannot be quoted-printable encoded");
        throw new EncoderException(stringBuilder.toString());
    }

    public String encode(String str) throws EncoderException {
        return encode(str, getCharset());
    }

    public String encode(String str, String str2) throws UnsupportedEncodingException {
        return str == null ? null : StringUtils.newStringUsAscii(encode(str.getBytes(str2)));
    }

    public String encode(String str, Charset charset) {
        return str == null ? null : StringUtils.newStringUsAscii(encode(str.getBytes(charset)));
    }

    public byte[] encode(byte[] bArr) {
        return encodeQuotedPrintable(PRINTABLE_CHARS, bArr);
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getDefaultCharset() {
        return this.charset.name();
    }
}
