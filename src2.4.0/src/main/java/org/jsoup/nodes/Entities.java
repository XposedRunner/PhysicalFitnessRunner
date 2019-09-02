package org.jsoup.nodes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import org.apache.commons.codec.CharEncoding;
import org.jsoup.SerializationException;
import org.jsoup.helper.DataUtil;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.parser.CharacterReader;
import org.jsoup.parser.Parser;

public class Entities {
    static final int O000000o = 36;
    private static final int O00000Oo = -1;
    private static final HashMap<String, String> O00000o = new HashMap();
    private static final String O00000o0 = "";
    private static final char[] O00000oO = new char[]{',', ';'};

    private enum CoreCharset {
        ascii,
        utf,
        fallback;

        private static CoreCharset O00000Oo(String str) {
            return str.equals(CharEncoding.US_ASCII) ? ascii : str.startsWith("UTF-") ? utf : fallback;
        }
    }

    public enum EscapeMode {
        xhtml("entities-xhtml.properties", 4),
        base("entities-base.properties", 106),
        extended("entities-full.properties", 2125);
        
        private String[] O00000o;
        private int[] O00000oO;
        private int[] O00000oo;
        private String[] O0000O0o;

        private EscapeMode(String str, int i) {
            Entities.O00000Oo(this, str, i);
        }

        private int O000000o() {
            return this.O00000o.length;
        }

        /* Access modifiers changed, original: 0000 */
        public int O000000o(String str) {
            int binarySearch = Arrays.binarySearch(this.O00000o, str);
            return binarySearch >= 0 ? this.O00000oO[binarySearch] : -1;
        }

        /* Access modifiers changed, original: 0000 */
        public String O000000o(int i) {
            int binarySearch = Arrays.binarySearch(this.O00000oo, i);
            if (binarySearch < 0) {
                return "";
            }
            String str;
            if (binarySearch < this.O0000O0o.length - 1) {
                int i2 = binarySearch + 1;
                if (this.O00000oo[i2] == i) {
                    str = this.O0000O0o[i2];
                    return str;
                }
            }
            str = this.O0000O0o[binarySearch];
            return str;
        }
    }

    private Entities() {
    }

    public static int O000000o(String str, int[] iArr) {
        String str2 = (String) O00000o.get(str);
        if (str2 != null) {
            iArr[0] = str2.codePointAt(0);
            iArr[1] = str2.codePointAt(1);
            return 2;
        }
        int O000000o = EscapeMode.extended.O000000o(str);
        if (O000000o == -1) {
            return 0;
        }
        iArr[0] = O000000o;
        return 1;
    }

    static String O000000o(String str, OutputSettings outputSettings) {
        Appendable stringBuilder = new StringBuilder(str.length() * 2);
        try {
            O000000o(stringBuilder, str, outputSettings, false, false, false);
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    static String O000000o(String str, boolean z) {
        return Parser.O000000o(str, z);
    }

    static void O000000o(Appendable appendable, String str, OutputSettings outputSettings, boolean z, boolean z2, boolean z3) throws IOException {
        EscapeMode O000000o = outputSettings.O000000o();
        CharsetEncoder O00000o0 = outputSettings.O00000o0();
        CoreCharset O000000o2 = CoreCharset.O00000Oo(O00000o0.charset().name());
        int length = str.length();
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            int i4 = 1;
            if (!z2) {
                i4 = i2;
            } else if (StringUtil.O00000Oo(codePointAt)) {
                if (!(z3 && i2 == 0) && i3 == 0) {
                    appendable.append(' ');
                    i3 = 1;
                }
                i += Character.charCount(codePointAt);
            } else {
                i3 = 0;
            }
            if (codePointAt < 65536) {
                char c = (char) codePointAt;
                if (c != '\"') {
                    if (c == '&') {
                        appendable.append("&amp;");
                    } else if (c != '<') {
                        if (c != '>') {
                            if (c != 160) {
                                if (O000000o(O000000o2, c, O00000o0)) {
                                    appendable.append(c);
                                } else {
                                    O000000o(appendable, O000000o, codePointAt);
                                }
                            } else if (O000000o != EscapeMode.xhtml) {
                                appendable.append("&nbsp;");
                            } else {
                                appendable.append("&#xa0;");
                            }
                        } else if (z) {
                            appendable.append(c);
                        } else {
                            appendable.append("&gt;");
                        }
                    } else if (!z || O000000o == EscapeMode.xhtml) {
                        appendable.append("&lt;");
                    } else {
                        appendable.append(c);
                    }
                } else if (z) {
                    appendable.append("&quot;");
                } else {
                    appendable.append(c);
                }
            } else {
                String str2 = new String(Character.toChars(codePointAt));
                if (O00000o0.canEncode(str2)) {
                    appendable.append(str2);
                } else {
                    O000000o(appendable, O000000o, codePointAt);
                }
            }
            i2 = i4;
            i += Character.charCount(codePointAt);
        }
    }

    private static void O000000o(Appendable appendable, EscapeMode escapeMode, int i) throws IOException {
        String O000000o = escapeMode.O000000o(i);
        if (O000000o != "") {
            appendable.append('&').append(O000000o).append(';');
        } else {
            appendable.append("&#x").append(Integer.toHexString(i)).append(';');
        }
    }

    public static boolean O000000o(String str) {
        return EscapeMode.extended.O000000o(str) != -1;
    }

    private static boolean O000000o(CoreCharset coreCharset, char c, CharsetEncoder charsetEncoder) {
        boolean z = true;
        switch (coreCharset) {
            case ascii:
                if (c >= 128) {
                    z = false;
                }
                return z;
            case utf:
                return true;
            default:
                return charsetEncoder.canEncode(c);
        }
    }

    private static void O00000Oo(EscapeMode escapeMode, String str, int i) {
        escapeMode.O00000o = new String[i];
        escapeMode.O00000oO = new int[i];
        escapeMode.O00000oo = new int[i];
        escapeMode.O0000O0o = new String[i];
        InputStream resourceAsStream = Entities.class.getResourceAsStream(str);
        StringBuilder stringBuilder;
        if (resourceAsStream == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Could not read resource ");
            stringBuilder.append(str);
            stringBuilder.append(". Make sure you copy resources for ");
            stringBuilder.append(Entities.class.getCanonicalName());
            throw new IllegalStateException(stringBuilder.toString());
        }
        try {
            CharacterReader characterReader = new CharacterReader(Charset.forName("ascii").decode(DataUtil.O000000o(resourceAsStream, 0)).toString());
            i = 0;
            while (!characterReader.O00000Oo()) {
                int parseInt;
                String O00000Oo = characterReader.O00000Oo('=');
                characterReader.O00000oo();
                int parseInt2 = Integer.parseInt(characterReader.O000000o(O00000oO), 36);
                char O00000o0 = characterReader.O00000o0();
                characterReader.O00000oo();
                if (O00000o0 == ',') {
                    parseInt = Integer.parseInt(characterReader.O00000Oo(';'), 36);
                    characterReader.O00000oo();
                } else {
                    parseInt = -1;
                }
                String O00000Oo2 = characterReader.O00000Oo(10);
                if (O00000Oo2.charAt(O00000Oo2.length() - 1) == 13) {
                    O00000Oo2 = O00000Oo2.substring(0, O00000Oo2.length() - 1);
                }
                int parseInt3 = Integer.parseInt(O00000Oo2, 36);
                characterReader.O00000oo();
                escapeMode.O00000o[i] = O00000Oo;
                escapeMode.O00000oO[i] = parseInt2;
                escapeMode.O00000oo[parseInt3] = parseInt2;
                escapeMode.O0000O0o[parseInt3] = O00000Oo;
                if (parseInt != -1) {
                    O00000o.put(O00000Oo, new String(new int[]{parseInt2, parseInt}, 0, 2));
                }
                i++;
            }
        } catch (IOException unused) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Error reading resource ");
            stringBuilder.append(str);
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public static boolean O00000Oo(String str) {
        return EscapeMode.base.O000000o(str) != -1;
    }

    public static String O00000o(String str) {
        String str2 = (String) O00000o.get(str);
        if (str2 != null) {
            return str2;
        }
        if (EscapeMode.extended.O000000o(str) == -1) {
            return "";
        }
        return new String(new int[]{EscapeMode.extended.O000000o(str)}, 0, 1);
    }

    public static Character O00000o0(String str) {
        return Character.valueOf((char) EscapeMode.extended.O000000o(str));
    }

    static String O00000oO(String str) {
        return O000000o(str, false);
    }
}
