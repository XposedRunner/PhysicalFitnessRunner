package org.jsoup.parser;

import java.util.Iterator;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;

public class ParseSettings {
    public static final ParseSettings O000000o = new ParseSettings(false, false);
    public static final ParseSettings O00000Oo = new ParseSettings(true, true);
    private final boolean O00000o;
    private final boolean O00000o0;

    public ParseSettings(boolean z, boolean z2) {
        this.O00000o0 = z;
        this.O00000o = z2;
    }

    /* Access modifiers changed, original: 0000 */
    public String O000000o(String str) {
        str = str.trim();
        return !this.O00000o0 ? str.toLowerCase() : str;
    }

    /* Access modifiers changed, original: 0000 */
    public Attributes O000000o(Attributes attributes) {
        if (!this.O00000o) {
            Iterator it = attributes.iterator();
            while (it.hasNext()) {
                Attribute attribute = (Attribute) it.next();
                attribute.O000000o(attribute.getKey().toLowerCase());
            }
        }
        return attributes;
    }

    /* Access modifiers changed, original: 0000 */
    public String O00000Oo(String str) {
        str = str.trim();
        return !this.O00000o ? str.toLowerCase() : str;
    }
}
