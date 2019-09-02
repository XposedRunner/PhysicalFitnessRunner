package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;

public class XmlDeclaration extends Node {
    private final String O000000o;
    private final boolean O00000Oo;

    public XmlDeclaration(String str, String str2, boolean z) {
        super(str2);
        Validate.O000000o((Object) str);
        this.O000000o = str;
        this.O00000Oo = z;
    }

    public String O000000o() {
        return "#declaration";
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        appendable.append("<").append(this.O00000Oo ? "!" : "?").append(this.O000000o);
        this.O00000oO.O000000o(appendable, outputSettings);
        appendable.append(this.O00000Oo ? "!" : "?").append(">");
    }

    public String O00000Oo() {
        return this.O000000o;
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(Appendable appendable, int i, OutputSettings outputSettings) {
    }

    public String O00000o0() {
        return this.O00000oO.O00000o().trim();
    }

    public String toString() {
        return O0000O0o();
    }
}
