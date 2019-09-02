package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.StringUtils;

abstract class RFC1522Codec {
    protected static final String POSTFIX = "?=";
    protected static final String PREFIX = "=?";
    protected static final char SEP = '?';

    RFC1522Codec() {
    }

    /* Access modifiers changed, original: protected */
    public String decodeText(String str) throws DecoderException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        if (str.startsWith(PREFIX) && str.endsWith(POSTFIX)) {
            int length = str.length() - 2;
            int indexOf = str.indexOf(63, 2);
            if (indexOf == length) {
                throw new DecoderException("RFC 1522 violation: charset token not found");
            }
            String substring = str.substring(2, indexOf);
            if (substring.equals("")) {
                throw new DecoderException("RFC 1522 violation: charset not specified");
            }
            indexOf++;
            int indexOf2 = str.indexOf(63, indexOf);
            if (indexOf2 == length) {
                throw new DecoderException("RFC 1522 violation: encoding token not found");
            }
            String substring2 = str.substring(indexOf, indexOf2);
            if (getEncoding().equalsIgnoreCase(substring2)) {
                indexOf2++;
                return new String(doDecoding(StringUtils.getBytesUsAscii(str.substring(indexOf2, str.indexOf(63, indexOf2)))), substring);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("This codec cannot decode ");
            stringBuilder.append(substring2);
            stringBuilder.append(" encoded content");
            throw new DecoderException(stringBuilder.toString());
        }
        throw new DecoderException("RFC 1522 violation: malformed encoded content");
    }

    public abstract byte[] doDecoding(byte[] bArr) throws DecoderException;

    public abstract byte[] doEncoding(byte[] bArr) throws EncoderException;

    /* Access modifiers changed, original: protected */
    public String encodeText(String str, String str2) throws EncoderException, UnsupportedEncodingException {
        return str == null ? null : encodeText(str, Charset.forName(str2));
    }

    /* Access modifiers changed, original: protected */
    public String encodeText(String str, Charset charset) throws EncoderException {
        if (str == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PREFIX);
        stringBuilder.append(charset);
        stringBuilder.append(SEP);
        stringBuilder.append(getEncoding());
        stringBuilder.append(SEP);
        stringBuilder.append(StringUtils.newStringUsAscii(doEncoding(str.getBytes(charset))));
        stringBuilder.append(POSTFIX);
        return stringBuilder.toString();
    }

    public abstract String getEncoding();
}
