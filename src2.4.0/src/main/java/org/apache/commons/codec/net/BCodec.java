package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;

public class BCodec extends RFC1522Codec implements StringDecoder, StringEncoder {
    private final Charset charset;

    public BCodec() {
        this(Charsets.UTF_8);
    }

    public BCodec(String str) {
        this(Charset.forName(str));
    }

    public BCodec(Charset charset) {
        this.charset = charset;
    }

    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Objects of type ");
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append(" cannot be decoded using BCodec");
        throw new DecoderException(stringBuilder.toString());
    }

    public String decode(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return decodeText(str);
        } catch (UnsupportedEncodingException e) {
            throw new DecoderException(e.getMessage(), e);
        }
    }

    /* Access modifiers changed, original: protected */
    public byte[] doDecoding(byte[] bArr) {
        return bArr == null ? null : Base64.decodeBase64(bArr);
    }

    /* Access modifiers changed, original: protected */
    public byte[] doEncoding(byte[] bArr) {
        return bArr == null ? null : Base64.encodeBase64(bArr);
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return encode((String) obj);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Objects of type ");
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append(" cannot be encoded using BCodec");
        throw new EncoderException(stringBuilder.toString());
    }

    public String encode(String str) throws EncoderException {
        return str == null ? null : encode(str, getCharset());
    }

    public String encode(String str, String str2) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return encodeText(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new EncoderException(e.getMessage(), e);
        }
    }

    public String encode(String str, Charset charset) throws EncoderException {
        return str == null ? null : encodeText(str, charset);
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getDefaultCharset() {
        return this.charset.name();
    }

    /* Access modifiers changed, original: protected */
    public String getEncoding() {
        return "B";
    }
}
