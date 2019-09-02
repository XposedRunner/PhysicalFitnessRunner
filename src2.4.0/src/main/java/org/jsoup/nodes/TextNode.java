package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;

public class TextNode extends Node {
    private static final String O00000Oo = "text";
    String O000000o;

    public TextNode(String str, String str2) {
        this.O00000oo = str2;
        this.O000000o = str;
    }

    public static TextNode O000000o(String str, String str2) {
        return new TextNode(Entities.O00000oO(str), str2);
    }

    static boolean O000000o(StringBuilder stringBuilder) {
        return stringBuilder.length() != 0 && stringBuilder.charAt(stringBuilder.length() - 1) == ' ';
    }

    static String O00000Oo(String str) {
        return StringUtil.O00000o0(str);
    }

    static String O00000o0(String str) {
        return str.replaceFirst("^\\s+", "");
    }

    private void O00000oO() {
        if (this.O00000oO == null) {
            this.O00000oO = new Attributes();
            this.O00000oO.O000000o("text", this.O000000o);
        }
    }

    public String O000000o() {
        return "#text";
    }

    public TextNode O000000o(int i) {
        Validate.O000000o(i >= 0, "Split offset must be not be negative");
        Validate.O000000o(i < this.O000000o.length(), "Split offset must not be greater than current text length");
        String substring = O00000o0().substring(0, i);
        String substring2 = O00000o0().substring(i);
        O000000o(substring);
        TextNode textNode = new TextNode(substring2, O000Oo00());
        if (O000OOoO() != null) {
            O000OOoO().O000000o(O000o00() + 1, textNode);
        }
        return textNode;
    }

    public TextNode O000000o(String str) {
        this.O000000o = str;
        if (this.O00000oO != null) {
            this.O00000oO.O000000o("text", str);
        }
        return this;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        if (outputSettings.O00000oO() && ((O000o00() == 0 && (this.O00000o0 instanceof Element) && ((Element) this.O00000o0).O0000o0o().O00000o0() && !O00000o()) || (outputSettings.O00000oo() && O000OooO().size() > 0 && !O00000o()))) {
            O00000o0(appendable, i, outputSettings);
        }
        boolean z = outputSettings.O00000oO() && (O000OOoO() instanceof Element) && !Element.O00000oO(O000OOoO());
        Entities.O000000o(appendable, O00000o0(), outputSettings, false, z, false);
    }

    public String O00000Oo() {
        return O00000Oo(O00000o0());
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(Appendable appendable, int i, OutputSettings outputSettings) {
    }

    public boolean O00000o() {
        return StringUtil.O000000o(O00000o0());
    }

    public String O00000o0() {
        return this.O00000oO == null ? this.O000000o : this.O00000oO.O000000o("text");
    }

    public Node O0000OOo(String str, String str2) {
        O00000oO();
        return super.O0000OOo(str, str2);
    }

    public String O000O0oo(String str) {
        O00000oO();
        return super.O000O0oo(str);
    }

    public boolean O000OO00(String str) {
        O00000oO();
        return super.O000OO00(str);
    }

    public Node O000OO0o(String str) {
        O00000oO();
        return super.O000OO0o(str);
    }

    public String O000OOOo(String str) {
        O00000oO();
        return super.O000OOOo(str);
    }

    public Attributes O000OOoo() {
        O00000oO();
        return super.O000OOoo();
    }

    public String toString() {
        return O0000O0o();
    }
}
