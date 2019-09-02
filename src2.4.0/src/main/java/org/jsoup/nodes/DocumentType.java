package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Document.OutputSettings.Syntax;

public class DocumentType extends Node {
    public static final String O000000o = "PUBLIC";
    public static final String O00000Oo = "SYSTEM";
    private static final String O0000OOo = "name";
    private static final String O0000Oo = "publicId";
    private static final String O0000Oo0 = "pubSysKey";
    private static final String O0000OoO = "systemId";

    public DocumentType(String str, String str2, String str3, String str4) {
        super(str4);
        O0000OOo("name", str);
        O0000OOo(O0000Oo, str2);
        if (O000000o(O0000Oo)) {
            O0000OOo(O0000Oo0, O000000o);
        }
        O0000OOo(O0000OoO, str3);
    }

    public DocumentType(String str, String str2, String str3, String str4, String str5) {
        super(str5);
        O0000OOo("name", str);
        if (str2 != null) {
            O0000OOo(O0000Oo0, str2);
        }
        O0000OOo(O0000Oo, str3);
        O0000OOo(O0000OoO, str4);
    }

    private boolean O000000o(String str) {
        return StringUtil.O000000o(O000O0oo(str)) ^ 1;
    }

    public String O000000o() {
        return "#doctype";
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        if (outputSettings.O00000o() != Syntax.html || O000000o(O0000Oo) || O000000o(O0000OoO)) {
            appendable.append("<!DOCTYPE");
        } else {
            appendable.append("<!doctype");
        }
        if (O000000o("name")) {
            appendable.append(" ").append(O000O0oo("name"));
        }
        if (O000000o(O0000Oo0)) {
            appendable.append(" ").append(O000O0oo(O0000Oo0));
        }
        if (O000000o(O0000Oo)) {
            appendable.append(" \"").append(O000O0oo(O0000Oo)).append('\"');
        }
        if (O000000o(O0000OoO)) {
            appendable.append(" \"").append(O000O0oo(O0000OoO)).append('\"');
        }
        appendable.append('>');
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(Appendable appendable, int i, OutputSettings outputSettings) {
    }
}
