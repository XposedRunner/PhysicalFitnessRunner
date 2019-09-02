package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document.OutputSettings;

public class DataNode extends Node {
    private static final String O000000o = "data";

    public DataNode(String str, String str2) {
        super(str2);
        this.O00000oO.O000000o("data", str);
    }

    public static DataNode O000000o(String str, String str2) {
        return new DataNode(Entities.O00000oO(str), str2);
    }

    public String O000000o() {
        return "#data";
    }

    public DataNode O000000o(String str) {
        this.O00000oO.O000000o("data", str);
        return this;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        appendable.append(O00000Oo());
    }

    public String O00000Oo() {
        return this.O00000oO.O000000o("data");
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(Appendable appendable, int i, OutputSettings outputSettings) {
    }

    public String toString() {
        return O0000O0o();
    }
}
