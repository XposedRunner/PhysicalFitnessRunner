package org.jsoup.parser;

import java.util.ArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

abstract class TreeBuilder {
    private StartTag O000000o = new StartTag();
    private EndTag O00000Oo = new EndTag();
    Tokeniser O00000o;
    CharacterReader O00000o0;
    protected Document O00000oO;
    protected ArrayList<Element> O00000oo;
    protected String O0000O0o;
    protected Token O0000OOo;
    protected ParseSettings O0000Oo;
    protected ParseErrorList O0000Oo0;

    TreeBuilder() {
    }

    /* Access modifiers changed, original: 0000 */
    public Document O000000o(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        O00000Oo(str, str2, parseErrorList, parseSettings);
        O00oOooO();
        return this.O00000oO;
    }

    public abstract ParseSettings O000000o();

    public boolean O000000o(String str, Attributes attributes) {
        if (this.O0000OOo == this.O000000o) {
            return O000000o(new StartTag().O000000o(str, attributes));
        }
        this.O000000o.O00000Oo();
        this.O000000o.O000000o(str, attributes);
        return O000000o(this.O000000o);
    }

    public abstract boolean O000000o(Token token);

    /* Access modifiers changed, original: protected */
    public void O00000Oo(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        Validate.O000000o((Object) str, "String input must not be null");
        Validate.O000000o((Object) str2, "BaseURI must not be null");
        this.O00000oO = new Document(str2);
        this.O0000Oo = parseSettings;
        this.O00000o0 = new CharacterReader(str);
        this.O0000Oo0 = parseErrorList;
        this.O00000o = new Tokeniser(this.O00000o0, parseErrorList);
        this.O00000oo = new ArrayList(32);
        this.O0000O0o = str2;
    }

    /* Access modifiers changed, original: protected */
    public boolean O0000Ooo(String str) {
        return this.O0000OOo == this.O000000o ? O000000o(new StartTag().O000000o(str)) : O000000o(this.O000000o.O00000Oo().O000000o(str));
    }

    /* Access modifiers changed, original: protected */
    public boolean O0000o00(String str) {
        return this.O0000OOo == this.O00000Oo ? O000000o(new EndTag().O000000o(str)) : O000000o(this.O00000Oo.O00000Oo().O000000o(str));
    }

    /* Access modifiers changed, original: protected */
    public void O00oOooO() {
        Token O000000o;
        do {
            O000000o = this.O00000o.O000000o();
            O000000o(O000000o);
            O000000o.O00000Oo();
        } while (O000000o.O000000o != TokenType.EOF);
    }

    /* Access modifiers changed, original: protected */
    public Element O00oOooo() {
        int size = this.O00000oo.size();
        return size > 0 ? (Element) this.O00000oo.get(size - 1) : null;
    }
}
