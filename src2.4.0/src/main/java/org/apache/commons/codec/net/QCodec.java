package org.apache.commons.codec.net;

import com.ximalaya.ting.android.opensdk.player.service.XmPlayerService;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.BitSet;
import jp.co.cyberagent.android.gpuimage.O000000o;
import org.apache.commons.codec.Charsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

public class QCodec extends RFC1522Codec implements StringDecoder, StringEncoder {
    private static final byte BLANK = (byte) 32;
    private static final BitSet PRINTABLE_CHARS = new BitSet(O000000o.O00000oO);
    private static final byte UNDERSCORE = (byte) 95;
    private final Charset charset;
    private boolean encodeBlanks;

    static {
        int i;
        PRINTABLE_CHARS.set(32);
        PRINTABLE_CHARS.set(33);
        PRINTABLE_CHARS.set(34);
        PRINTABLE_CHARS.set(35);
        PRINTABLE_CHARS.set(36);
        PRINTABLE_CHARS.set(37);
        PRINTABLE_CHARS.set(38);
        PRINTABLE_CHARS.set(39);
        PRINTABLE_CHARS.set(40);
        PRINTABLE_CHARS.set(41);
        PRINTABLE_CHARS.set(42);
        PRINTABLE_CHARS.set(43);
        PRINTABLE_CHARS.set(44);
        PRINTABLE_CHARS.set(45);
        PRINTABLE_CHARS.set(46);
        PRINTABLE_CHARS.set(47);
        for (i = 48; i <= 57; i++) {
            PRINTABLE_CHARS.set(i);
        }
        PRINTABLE_CHARS.set(58);
        PRINTABLE_CHARS.set(59);
        PRINTABLE_CHARS.set(60);
        PRINTABLE_CHARS.set(62);
        PRINTABLE_CHARS.set(64);
        for (i = 65; i <= 90; i++) {
            PRINTABLE_CHARS.set(i);
        }
        PRINTABLE_CHARS.set(91);
        PRINTABLE_CHARS.set(92);
        PRINTABLE_CHARS.set(93);
        PRINTABLE_CHARS.set(94);
        PRINTABLE_CHARS.set(96);
        for (i = 97; i <= XmPlayerService.CODE_GET_TRACKLIST_BYTRACKIDATALBUM; i++) {
            PRINTABLE_CHARS.set(i);
        }
        PRINTABLE_CHARS.set(XmPlayerService.CODE_GET_RECOMMEND_ALBUMLIST_BY_ALBUMID);
        PRINTABLE_CHARS.set(XmPlayerService.CODE_GET_RECOMMEND_ALBUMLIST_BY_TRACKID);
        PRINTABLE_CHARS.set(XmPlayerService.CODE_GET_PROVINCES);
        PRINTABLE_CHARS.set(XmPlayerService.CODE_GET_RADIO_LIST);
    }

    public QCodec() {
        this(Charsets.UTF_8);
    }

    public QCodec(String str) {
        this(Charset.forName(str));
    }

    public QCodec(Charset charset) {
        this.encodeBlanks = false;
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
        stringBuilder.append(" cannot be decoded using Q codec");
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
    public byte[] doDecoding(byte[] bArr) throws DecoderException {
        if (bArr == null) {
            return null;
        }
        int i;
        int i2 = 0;
        for (byte b : bArr) {
            if (b == UNDERSCORE) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            return QuotedPrintableCodec.decodeQuotedPrintable(bArr);
        }
        byte[] bArr2 = new byte[bArr.length];
        while (i2 < bArr.length) {
            byte b2 = bArr[i2];
            if (b2 != UNDERSCORE) {
                bArr2[i2] = b2;
            } else {
                bArr2[i2] = BLANK;
            }
            i2++;
        }
        return QuotedPrintableCodec.decodeQuotedPrintable(bArr2);
    }

    /* Access modifiers changed, original: protected */
    public byte[] doEncoding(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        bArr = QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, bArr);
        if (this.encodeBlanks) {
            for (int i = 0; i < bArr.length; i++) {
                if (bArr[i] == BLANK) {
                    bArr[i] = UNDERSCORE;
                }
            }
        }
        return bArr;
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
        stringBuilder.append(" cannot be encoded using Q codec");
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
        return "Q";
    }

    public boolean isEncodeBlanks() {
        return this.encodeBlanks;
    }

    public void setEncodeBlanks(boolean z) {
        this.encodeBlanks = z;
    }
}
