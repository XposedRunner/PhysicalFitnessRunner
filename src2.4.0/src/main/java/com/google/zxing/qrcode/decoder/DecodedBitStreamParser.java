package com.google.zxing.qrcode.decoder;

import android.support.v4.media.TransportMediator;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

final class DecodedBitStreamParser {
    private static final char[] ALPHANUMERIC_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'};
    private static final int GB2312_SUBSET = 1;

    private DecodedBitStreamParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e6 A:{LOOP_END, LOOP:0: B:1:0x001e->B:59:0x00e6} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c5 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c5 A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00e6 A:{LOOP_END, LOOP:0: B:1:0x001e->B:59:0x00e6} */
    static com.google.zxing.common.DecoderResult decode(byte[] r18, com.google.zxing.qrcode.decoder.Version r19, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r20, java.util.Map<com.google.zxing.DecodeHintType, ?> r21) throws com.google.zxing.FormatException {
        /*
        r0 = r19;
        r7 = new com.google.zxing.common.BitSource;
        r8 = r18;
        r7.<init>(r8);
        r9 = new java.lang.StringBuilder;
        r1 = 50;
        r9.<init>(r1);
        r10 = new java.util.ArrayList;
        r11 = 1;
        r10.<init>(r11);
        r1 = 0;
        r2 = -1;
        r12 = 0;
        r13 = r1;
        r15 = r2;
        r16 = r15;
        r14 = r12;
    L_0x001e:
        r1 = r7.available();	 Catch:{ IllegalArgumentException -> 0x00e9 }
        r2 = 4;
        if (r1 >= r2) goto L_0x0029;
    L_0x0025:
        r1 = com.google.zxing.qrcode.decoder.Mode.TERMINATOR;	 Catch:{ IllegalArgumentException -> 0x00e9 }
    L_0x0027:
        r6 = r1;
        goto L_0x0032;
    L_0x0029:
        r1 = r7.readBits(r2);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        r1 = com.google.zxing.qrcode.decoder.Mode.forBits(r1);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        goto L_0x0027;
    L_0x0032:
        r1 = com.google.zxing.qrcode.decoder.Mode.TERMINATOR;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r6 == r1) goto L_0x005e;
    L_0x0036:
        r1 = com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r6 == r1) goto L_0x00bf;
    L_0x003a:
        r1 = com.google.zxing.qrcode.decoder.Mode.FNC1_SECOND_POSITION;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r6 != r1) goto L_0x0040;
    L_0x003e:
        goto L_0x00bf;
    L_0x0040:
        r1 = com.google.zxing.qrcode.decoder.Mode.STRUCTURED_APPEND;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r6 != r1) goto L_0x0061;
    L_0x0044:
        r1 = r7.available();	 Catch:{ IllegalArgumentException -> 0x00e9 }
        r2 = 16;
        if (r1 >= r2) goto L_0x0051;
    L_0x004c:
        r0 = com.google.zxing.FormatException.getFormatInstance();	 Catch:{ IllegalArgumentException -> 0x00e9 }
        throw r0;	 Catch:{ IllegalArgumentException -> 0x00e9 }
    L_0x0051:
        r1 = 8;
        r2 = r7.readBits(r1);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        r1 = r7.readBits(r1);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        r16 = r1;
        r15 = r2;
    L_0x005e:
        r11 = r6;
        goto L_0x00c1;
    L_0x0061:
        r1 = com.google.zxing.qrcode.decoder.Mode.ECI;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r6 != r1) goto L_0x0074;
    L_0x0065:
        r1 = parseECIValue(r7);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        r14 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r1);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r14 != 0) goto L_0x005e;
    L_0x006f:
        r0 = com.google.zxing.FormatException.getFormatInstance();	 Catch:{ IllegalArgumentException -> 0x00e9 }
        throw r0;	 Catch:{ IllegalArgumentException -> 0x00e9 }
    L_0x0074:
        r1 = com.google.zxing.qrcode.decoder.Mode.HANZI;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r6 != r1) goto L_0x008a;
    L_0x0078:
        r1 = r7.readBits(r2);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        r2 = r6.getCharacterCountBits(r0);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        r2 = r7.readBits(r2);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r1 != r11) goto L_0x005e;
    L_0x0086:
        decodeHanziSegment(r7, r9, r2);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        goto L_0x005e;
    L_0x008a:
        r1 = r6.getCharacterCountBits(r0);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        r3 = r7.readBits(r1);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        r1 = com.google.zxing.qrcode.decoder.Mode.NUMERIC;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r6 != r1) goto L_0x009a;
    L_0x0096:
        decodeNumericSegment(r7, r9, r3);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        goto L_0x005e;
    L_0x009a:
        r1 = com.google.zxing.qrcode.decoder.Mode.ALPHANUMERIC;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r6 != r1) goto L_0x00a2;
    L_0x009e:
        decodeAlphanumericSegment(r7, r9, r3, r13);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        goto L_0x005e;
    L_0x00a2:
        r1 = com.google.zxing.qrcode.decoder.Mode.BYTE;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r6 != r1) goto L_0x00b1;
    L_0x00a6:
        r1 = r7;
        r2 = r9;
        r4 = r14;
        r5 = r10;
        r11 = r6;
        r6 = r21;
        decodeByteSegment(r1, r2, r3, r4, r5, r6);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        goto L_0x00c1;
    L_0x00b1:
        r11 = r6;
        r1 = com.google.zxing.qrcode.decoder.Mode.KANJI;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r11 != r1) goto L_0x00ba;
    L_0x00b6:
        decodeKanjiSegment(r7, r9, r3);	 Catch:{ IllegalArgumentException -> 0x00e9 }
        goto L_0x00c1;
    L_0x00ba:
        r0 = com.google.zxing.FormatException.getFormatInstance();	 Catch:{ IllegalArgumentException -> 0x00e9 }
        throw r0;	 Catch:{ IllegalArgumentException -> 0x00e9 }
    L_0x00bf:
        r11 = r6;
        r13 = 1;
    L_0x00c1:
        r1 = com.google.zxing.qrcode.decoder.Mode.TERMINATOR;	 Catch:{ IllegalArgumentException -> 0x00e9 }
        if (r11 != r1) goto L_0x00e6;
    L_0x00c5:
        r7 = new com.google.zxing.common.DecoderResult;
        r2 = r9.toString();
        r0 = r10.isEmpty();
        if (r0 == 0) goto L_0x00d3;
    L_0x00d1:
        r3 = r12;
        goto L_0x00d4;
    L_0x00d3:
        r3 = r10;
    L_0x00d4:
        if (r20 != 0) goto L_0x00d8;
    L_0x00d6:
        r4 = r12;
        goto L_0x00dd;
    L_0x00d8:
        r0 = r20.toString();
        r4 = r0;
    L_0x00dd:
        r0 = r7;
        r1 = r8;
        r5 = r15;
        r6 = r16;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        return r7;
    L_0x00e6:
        r11 = 1;
        goto L_0x001e;
    L_0x00e9:
        r0 = com.google.zxing.FormatException.getFormatInstance();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.decoder.DecodedBitStreamParser.decode(byte[], com.google.zxing.qrcode.decoder.Version, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.common.DecoderResult");
    }

    private static void decodeAlphanumericSegment(BitSource bitSource, StringBuilder stringBuilder, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (bitSource.available() < 11) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(11);
            stringBuilder.append(toAlphaNumericChar(readBits / 45));
            stringBuilder.append(toAlphaNumericChar(readBits % 45));
            i -= 2;
        }
        if (i == 1) {
            if (bitSource.available() < 6) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(bitSource.readBits(6)));
        }
        if (z) {
            for (int length = stringBuilder.length(); length < stringBuilder.length(); length++) {
                if (stringBuilder.charAt(length) == '%') {
                    if (length < stringBuilder.length() - 1) {
                        int i2 = length + 1;
                        if (stringBuilder.charAt(i2) == '%') {
                            stringBuilder.deleteCharAt(i2);
                        }
                    }
                    stringBuilder.setCharAt(length, 29);
                }
            }
        }
    }

    private static void decodeByteSegment(BitSource bitSource, StringBuilder stringBuilder, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if (8 * i > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) bitSource.readBits(8);
        }
        try {
            stringBuilder.append(new String(bArr, characterSetECI == null ? StringUtils.guessEncoding(bArr, map) : characterSetECI.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeHanziSegment(BitSource bitSource, StringBuilder stringBuilder, int i) throws FormatException {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[(2 * i)];
        int i2 = 0;
        while (i > 0) {
            int readBits = bitSource.readBits(13);
            readBits = (readBits % 96) | ((readBits / 96) << 8);
            readBits += readBits < 959 ? 41377 : 42657;
            bArr[i2] = (byte) ((readBits >> 8) & 255);
            bArr[i2 + 1] = (byte) (readBits & 255);
            i2 += 2;
            i--;
        }
        try {
            stringBuilder.append(new String(bArr, StringUtils.GB2312));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeKanjiSegment(BitSource bitSource, StringBuilder stringBuilder, int i) throws FormatException {
        if (i * 13 > bitSource.available()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[(2 * i)];
        int i2 = 0;
        while (i > 0) {
            int readBits = bitSource.readBits(13);
            readBits = (readBits % 192) | ((readBits / 192) << 8);
            readBits += readBits < 7936 ? 33088 : 49472;
            bArr[i2] = (byte) (readBits >> 8);
            bArr[i2 + 1] = (byte) readBits;
            i2 += 2;
            i--;
        }
        try {
            stringBuilder.append(new String(bArr, StringUtils.SHIFT_JIS));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    private static void decodeNumericSegment(BitSource bitSource, StringBuilder stringBuilder, int i) throws FormatException {
        while (i >= 3) {
            if (bitSource.available() < 10) {
                throw FormatException.getFormatInstance();
            }
            int readBits = bitSource.readBits(10);
            if (readBits >= 1000) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(readBits / 100));
            stringBuilder.append(toAlphaNumericChar((readBits / 10) % 10));
            stringBuilder.append(toAlphaNumericChar(readBits % 10));
            i -= 3;
        }
        int readBits2;
        if (i == 2) {
            if (bitSource.available() < 7) {
                throw FormatException.getFormatInstance();
            }
            readBits2 = bitSource.readBits(7);
            if (readBits2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(readBits2 / 10));
            stringBuilder.append(toAlphaNumericChar(readBits2 % 10));
        } else if (i != 1) {
        } else {
            if (bitSource.available() < 4) {
                throw FormatException.getFormatInstance();
            }
            readBits2 = bitSource.readBits(4);
            if (readBits2 >= 10) {
                throw FormatException.getFormatInstance();
            }
            stringBuilder.append(toAlphaNumericChar(readBits2));
        }
    }

    private static int parseECIValue(BitSource bitSource) throws FormatException {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & TransportMediator.KEYCODE_MEDIA_PAUSE;
        }
        if ((readBits & 192) == 128) {
            return bitSource.readBits(8) | ((readBits & 63) << 8);
        }
        if ((readBits & 224) == 192) {
            return bitSource.readBits(16) | ((readBits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    private static char toAlphaNumericChar(int i) throws FormatException {
        if (i < ALPHANUMERIC_CHARS.length) {
            return ALPHANUMERIC_CHARS[i];
        }
        throw FormatException.getFormatInstance();
    }
}
