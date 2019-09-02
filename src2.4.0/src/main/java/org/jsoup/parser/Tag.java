package org.jsoup.parser;

import com.umeng.commonsdk.proguard.e;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import defpackage.db;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;

public class Tag {
    private static final Map<String, Tag> O000000o = new HashMap();
    private static final String[] O0000Ooo;
    private static final String[] O0000o = new String[]{"button", "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
    private static final String[] O0000o0 = new String[]{"meta", "link", "base", "frame", "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
    private static final String[] O0000o00 = new String[]{"object", "base", "font", "tt", e.aq, "b", "u", "big", "small", "em", "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", e.al, "img", "br", "wbr", "map", DTransferConstants.SEARCH_KEY, "sub", "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", "button", "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", db.O000Oooo, "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi"};
    private static final String[] O0000o0O = new String[]{"title", e.al, e.ao, "h1", "h2", "h3", "h4", "h5", "h6", "pre", "address", "li", "th", "td", "script", "style", "ins", "del", e.ap};
    private static final String[] O0000o0o = new String[]{"pre", "plaintext", "title", "textarea"};
    private static final String[] O0000oO0 = new String[]{"input", "keygen", "object", "select", "textarea"};
    private String O00000Oo;
    private boolean O00000o = true;
    private boolean O00000o0 = true;
    private boolean O00000oO = true;
    private boolean O00000oo = true;
    private boolean O0000O0o = false;
    private boolean O0000OOo = false;
    private boolean O0000Oo = false;
    private boolean O0000Oo0 = false;
    private boolean O0000OoO = false;

    static {
        Object obj;
        r0 = new String[64];
        int i = 0;
        r0[0] = "html";
        r0[1] = "head";
        r0[2] = "body";
        r0[3] = "frameset";
        r0[4] = "script";
        r0[5] = "noscript";
        r0[6] = "style";
        r0[7] = "meta";
        r0[8] = "link";
        r0[9] = "title";
        r0[10] = "frame";
        r0[11] = "noframes";
        r0[12] = "section";
        r0[13] = "nav";
        r0[14] = "aside";
        r0[15] = "hgroup";
        r0[16] = "header";
        r0[17] = "footer";
        r0[18] = e.ao;
        r0[19] = "h1";
        r0[20] = "h2";
        r0[21] = "h3";
        r0[22] = "h4";
        r0[23] = "h5";
        r0[24] = "h6";
        r0[25] = "ul";
        r0[26] = "ol";
        r0[27] = "pre";
        r0[28] = "div";
        r0[29] = "blockquote";
        r0[30] = "hr";
        r0[31] = "address";
        r0[32] = "figure";
        r0[33] = "figcaption";
        r0[34] = "form";
        r0[35] = "fieldset";
        r0[36] = "ins";
        r0[37] = "del";
        r0[38] = e.ap;
        r0[39] = "dl";
        r0[40] = db.O0000o00;
        r0[41] = "dd";
        r0[42] = "li";
        r0[43] = "table";
        r0[44] = "caption";
        r0[45] = "thead";
        r0[46] = "tfoot";
        r0[47] = "tbody";
        r0[48] = "colgroup";
        r0[49] = "col";
        r0[50] = "tr";
        r0[51] = "th";
        r0[52] = "td";
        r0[53] = "video";
        r0[54] = "audio";
        r0[55] = "canvas";
        r0[56] = "details";
        r0[57] = "menu";
        r0[58] = "plaintext";
        r0[59] = "template";
        r0[60] = "article";
        r0[61] = "main";
        r0[62] = "svg";
        r0[63] = "math";
        O0000Ooo = r0;
        for (String tag : O0000Ooo) {
            O000000o(new Tag(tag));
        }
        for (String tag2 : O0000o00) {
            Tag tag3 = new Tag(tag2);
            tag3.O00000o0 = false;
            tag3.O00000oO = false;
            tag3.O00000o = false;
            O000000o(tag3);
        }
        for (Object obj2 : O0000o0) {
            obj2 = (Tag) O000000o.get(obj2);
            Validate.O000000o(obj2);
            obj2.O00000oO = false;
            obj2.O00000oo = false;
            obj2.O0000O0o = true;
        }
        for (Object obj22 : O0000o0O) {
            obj22 = (Tag) O000000o.get(obj22);
            Validate.O000000o(obj22);
            obj22.O00000o = false;
        }
        for (Object obj222 : O0000o0o) {
            obj222 = (Tag) O000000o.get(obj222);
            Validate.O000000o(obj222);
            obj222.O0000Oo0 = true;
        }
        for (Object obj2222 : O0000o) {
            obj2222 = (Tag) O000000o.get(obj2222);
            Validate.O000000o(obj2222);
            obj2222.O0000Oo = true;
        }
        r0 = O0000oO0;
        int length = r0.length;
        while (i < length) {
            Object obj3 = (Tag) O000000o.get(r0[i]);
            Validate.O000000o(obj3);
            obj3.O0000OoO = true;
            i++;
        }
    }

    private Tag(String str) {
        this.O00000Oo = str;
    }

    public static Tag O000000o(String str) {
        return O000000o(str, ParseSettings.O00000Oo);
    }

    public static Tag O000000o(String str, ParseSettings parseSettings) {
        Validate.O000000o((Object) str);
        Tag tag = (Tag) O000000o.get(str);
        if (tag != null) {
            return tag;
        }
        str = parseSettings.O000000o(str);
        Validate.O000000o(str);
        tag = (Tag) O000000o.get(str);
        if (tag != null) {
            return tag;
        }
        tag = new Tag(str);
        tag.O00000o0 = false;
        tag.O00000oO = true;
        return tag;
    }

    private static void O000000o(Tag tag) {
        O000000o.put(tag.O00000Oo, tag);
    }

    public static boolean O00000Oo(String str) {
        return O000000o.containsKey(str);
    }

    public String O000000o() {
        return this.O00000Oo;
    }

    public boolean O00000Oo() {
        return this.O00000o0;
    }

    public boolean O00000o() {
        return this.O00000oO;
    }

    public boolean O00000o0() {
        return this.O00000o;
    }

    public boolean O00000oO() {
        return this.O00000o0 ^ 1;
    }

    public boolean O00000oo() {
        return (this.O00000oo || O0000O0o()) ? false : true;
    }

    public boolean O0000O0o() {
        return this.O0000O0o;
    }

    public boolean O0000OOo() {
        return this.O0000O0o || this.O0000OOo;
    }

    public boolean O0000Oo() {
        return this.O0000Oo0;
    }

    public boolean O0000Oo0() {
        return O000000o.containsKey(this.O00000Oo);
    }

    public boolean O0000OoO() {
        return this.O0000Oo;
    }

    public boolean O0000Ooo() {
        return this.O0000OoO;
    }

    /* Access modifiers changed, original: 0000 */
    public Tag O0000o00() {
        this.O0000OOo = true;
        return this;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (!this.O00000Oo.equals(tag.O00000Oo) || this.O00000oO != tag.O00000oO || this.O00000oo != tag.O00000oo || this.O0000O0o != tag.O0000O0o || this.O00000o != tag.O00000o || this.O00000o0 != tag.O00000o0 || this.O0000Oo0 != tag.O0000Oo0 || this.O0000OOo != tag.O0000OOo || this.O0000Oo != tag.O0000Oo) {
            return false;
        }
        if (this.O0000OoO != tag.O0000OoO) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (31 * ((((((((((((((((this.O00000Oo.hashCode() * 31) + this.O00000o0) * 31) + this.O00000o) * 31) + this.O00000oO) * 31) + this.O00000oo) * 31) + this.O0000O0o) * 31) + this.O0000OOo) * 31) + this.O0000Oo0) * 31) + this.O0000Oo)) + this.O0000OoO;
    }

    public String toString() {
        return this.O00000Oo;
    }
}
