package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document.OutputSettings;

public class Comment extends Node {
    private static final String O000000o = "comment";

    public Comment(String str, String str2) {
        super(str2);
        this.O00000oO.O000000o(O000000o, str);
    }

    public String O000000o() {
        return "#comment";
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        if (outputSettings.O00000oO()) {
            O00000o0(appendable, i, outputSettings);
        }
        appendable.append("<!--").append(O00000Oo()).append("-->");
    }

    public String O00000Oo() {
        return this.O00000oO.O000000o(O000000o);
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(Appendable appendable, int i, OutputSettings outputSettings) {
    }

    public String toString() {
        return O0000O0o();
    }
}
