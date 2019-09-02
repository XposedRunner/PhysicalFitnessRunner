package org.apache.commons.codec.net;

import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import jp.co.cyberagent.android.gpuimage.O000000o;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class URLCodec implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder {
    protected static final byte ESCAPE_CHAR = (byte) 37;
    static final int RADIX = 16;
    protected static final BitSet WWW_FORM_URL = new BitSet(O000000o.O00000oO);
    @Deprecated
    protected String charset;

    static {
        int i;
        for (i = 97; i <= XmPlayerService.CODE_GET_TRACKLIST_BYTRACKIDATALBUM; i++) {
            WWW_FORM_URL.set(i);
        }
        for (i = 65; i <= 90; i++) {
            WWW_FORM_URL.set(i);
        }
        for (i = 48; i <= 57; i++) {
            WWW_FORM_URL.set(i);
        }
        WWW_FORM_URL.set(45);
        WWW_FORM_URL.set(95);
        WWW_FORM_URL.set(46);
        WWW_FORM_URL.set(42);
        WWW_FORM_URL.set(32);
    }

    public URLCodec() {
        this("UTF-8");
    }

    public URLCodec(String str) {
        this.charset = str;
    }

    public static final byte[] decodeUrl(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < bArr.length) {
            byte b = bArr[i];
            if (b == (byte) 43) {
                byteArrayOutputStream.write(32);
            } else if (b == ESCAPE_CHAR) {
                i++;
                try {
                    int digit16 = Utils.digit16(bArr[i]);
                    i++;
                    byteArrayOutputStream.write((char) ((digit16 << 4) + Utils.digit16(bArr[i])));
                } catch (ArrayIndexOutOfBoundsException e) {
                    throw new DecoderException("Invalid URL encoding: ", e);
                }
            } else {
                byteArrayOutputStream.write(b);
            }
            i++;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static final byte[] encodeUrl(BitSet bitSet, byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bitSet == null) {
            bitSet = WWW_FORM_URL;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i : bArr) {
            int i2;
            if (i2 < 0) {
                i2 += O000000o.O00000oO;
            }
            if (bitSet.get(i2)) {
                if (i2 == 32) {
                    i2 = 43;
                }
                byteArrayOutputStream.write(i2);
            } else {
                byteArrayOutputStream.write(37);
                char toUpperCase = Character.toUpperCase(Character.forDigit((i2 >> 4) & 15, 16));
                char toUpperCase2 = Character.toUpperCase(Character.forDigit(i2 & 15, 16));
                byteArrayOutputStream.write(toUpperCase);
                byteArrayOutputStream.write(toUpperCase2);
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
        stringBuilder.append(" cannot be URL decoded");
        throw new DecoderException(stringBuilder.toString());
    }

    public String decode(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decode(str, getDefaultCharset());
        } catch (UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage(), e);
        }
    }

    public String decode(String str, String str2) throws DecoderException, UnsupportedEncodingException {
        return str == null ? null : new String(decode(StringUtils.getBytesUsAscii(str)), str2);
    }

    public byte[] decode(byte[] bArr) throws DecoderException {
        return decodeUrl(bArr);
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
        stringBuilder.append(" cannot be URL encoded");
        throw new EncoderException(stringBuilder.toString());
    }

    public String encode(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encode(str, getDefaultCharset());
        } catch (UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage(), e);
        }
    }

    public String encode(String str, String str2) throws UnsupportedEncodingException {
        return str == null ? null : StringUtils.newStringUsAscii(encode(str.getBytes(str2)));
    }

    public byte[] encode(byte[] bArr) {
        return encodeUrl(WWW_FORM_URL, bArr);
    }

    public String getDefaultCharset() {
        return this.charset;
    }

    @Deprecated
    public String getEncoding() {
        return this.charset;
    }
}
