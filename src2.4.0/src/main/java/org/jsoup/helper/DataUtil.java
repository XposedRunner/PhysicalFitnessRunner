package org.jsoup.helper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.CharEncoding;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.parser.Parser;

public final class DataUtil {
    static final String O000000o = "UTF-8";
    static final int O00000Oo = 32;
    private static final int O00000o = 60000;
    private static final Pattern O00000o0 = Pattern.compile("(?i)\\bcharset=\\s*(?:\"|')?([^\\s,;\"']*)");
    private static final char[] O00000oO = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private DataUtil() {
    }

    static String O000000o(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = O00000o0.matcher(str);
        return matcher.find() ? O00000Oo(matcher.group(1).trim().replace("charset=", "")) : null;
    }

    private static String O000000o(ByteBuffer byteBuffer, String str) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= bArr.length) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        if ((bArr[0] == (byte) 0 && bArr[1] == (byte) 0 && bArr[2] == (byte) -2 && bArr[3] == (byte) -1) || (bArr[0] == (byte) -1 && bArr[1] == (byte) -2 && bArr[2] == (byte) 0 && bArr[3] == (byte) 0)) {
            return "UTF-32";
        }
        if ((bArr[0] == (byte) -2 && bArr[1] == (byte) -1) || (bArr[0] == (byte) -1 && bArr[1] == (byte) -2)) {
            return CharEncoding.UTF_16;
        }
        if (bArr[0] != (byte) -17 || bArr[1] != (byte) -69 || bArr[2] != (byte) -65) {
            return str;
        }
        str = "UTF-8";
        byteBuffer.position(3);
        return str;
    }

    static ByteBuffer O000000o() {
        return ByteBuffer.allocate(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0022  */
    static java.nio.ByteBuffer O000000o(java.io.File r4) throws java.io.IOException {
        /*
        r0 = 0;
        r1 = new java.io.RandomAccessFile;	 Catch:{ all -> 0x001e }
        r2 = "r";
        r1.<init>(r4, r2);	 Catch:{ all -> 0x001e }
        r2 = r1.length();	 Catch:{ all -> 0x001c }
        r4 = (int) r2;	 Catch:{ all -> 0x001c }
        r4 = new byte[r4];	 Catch:{ all -> 0x001c }
        r1.readFully(r4);	 Catch:{ all -> 0x001c }
        r4 = java.nio.ByteBuffer.wrap(r4);	 Catch:{ all -> 0x001c }
        if (r1 == 0) goto L_0x001b;
    L_0x0018:
        r1.close();
    L_0x001b:
        return r4;
    L_0x001c:
        r4 = move-exception;
        goto L_0x0020;
    L_0x001e:
        r4 = move-exception;
        r1 = r0;
    L_0x0020:
        if (r1 == 0) goto L_0x0025;
    L_0x0022:
        r1.close();
    L_0x0025:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.helper.DataUtil.O000000o(java.io.File):java.nio.ByteBuffer");
    }

    static ByteBuffer O000000o(InputStream inputStream) throws IOException {
        return O000000o(inputStream, 0);
    }

    public static ByteBuffer O000000o(InputStream inputStream, int i) throws IOException {
        int i2 = 1;
        Validate.O000000o(i >= 0, "maxSize must be 0 (unlimited) or larger");
        if (i <= 0) {
            i2 = 0;
        }
        int i3 = 60000;
        int i4 = (i2 == 0 || i >= 60000) ? 60000 : i;
        byte[] bArr = new byte[i4];
        if (i2 != 0) {
            i3 = i;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        while (!Thread.interrupted()) {
            i3 = inputStream.read(bArr);
            if (i3 == -1) {
                break;
            }
            if (i2 != 0) {
                if (i3 > i) {
                    byteArrayOutputStream.write(bArr, 0, i);
                    break;
                }
                i -= i3;
            }
            byteArrayOutputStream.write(bArr, 0, i3);
        }
        return ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
    }

    public static Document O000000o(File file, String str, String str2) throws IOException {
        return O000000o(O000000o(file), str, str2, Parser.O00000oO());
    }

    public static Document O000000o(InputStream inputStream, String str, String str2) throws IOException {
        return O000000o(O000000o(inputStream), str, str2, Parser.O00000oO());
    }

    public static Document O000000o(InputStream inputStream, String str, String str2, Parser parser) throws IOException {
        return O000000o(O000000o(inputStream), str, str2, parser);
    }

    static Document O000000o(ByteBuffer byteBuffer, String str, String str2, Parser parser) {
        String charBuffer;
        str = O000000o(byteBuffer, str);
        Document document = null;
        if (str == null) {
            String O000O0oo;
            charBuffer = Charset.forName("UTF-8").decode(byteBuffer).toString();
            Document O000000o = parser.O000000o(charBuffer, str2);
            Element O0000o0O = O000000o.O00000oo("meta[http-equiv=content-type], meta[charset]").O0000o0O();
            if (O0000o0O != null) {
                String O000000o2 = O0000o0O.O000OO00("http-equiv") ? O000000o(O0000o0O.O000O0oo("content")) : null;
                O000O0oo = (O000000o2 == null && O0000o0O.O000OO00("charset")) ? O0000o0O.O000O0oo("charset") : O000000o2;
            } else {
                O000O0oo = null;
            }
            if (O000O0oo == null && O000000o.O000Oo0o() > 0 && (O000000o.O00000oO(0) instanceof XmlDeclaration)) {
                XmlDeclaration xmlDeclaration = (XmlDeclaration) O000000o.O00000oO(0);
                if (xmlDeclaration.O00000Oo().equals("xml")) {
                    O000O0oo = xmlDeclaration.O000O0oo("encoding");
                }
            }
            O000O0oo = O00000Oo(O000O0oo);
            if (O000O0oo == null || O000O0oo.equals("UTF-8")) {
                document = O000000o;
            } else {
                str = O000O0oo.trim().replaceAll("[\"']", "");
                byteBuffer.rewind();
                charBuffer = Charset.forName(str).decode(byteBuffer).toString();
            }
        } else {
            Validate.O000000o(str, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
            charBuffer = Charset.forName(str).decode(byteBuffer).toString();
        }
        if (document != null) {
            return document;
        }
        document = parser.O000000o(charBuffer, str2);
        document.O0000OoO().O000000o(str);
        return document;
    }

    static void O000000o(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[60000];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    static String O00000Oo() {
        StringBuilder stringBuilder = new StringBuilder(32);
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            stringBuilder.append(O00000oO[random.nextInt(O00000oO.length)]);
        }
        return stringBuilder.toString();
    }

    private static String O00000Oo(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        str = str.trim().replaceAll("[\"']", "");
        try {
            if (Charset.isSupported(str)) {
                return str;
            }
            str = str.toUpperCase(Locale.ENGLISH);
            return Charset.isSupported(str) ? str : null;
        } catch (IllegalCharsetNameException unused) {
        }
    }
}
