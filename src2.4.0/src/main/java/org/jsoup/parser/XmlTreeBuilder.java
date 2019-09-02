package org.jsoup.parser;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Document.OutputSettings.Syntax;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.XmlDeclaration;

public class XmlTreeBuilder extends TreeBuilder {
    private void O000000o(Node node) {
        O00oOooo().O000000o(node);
    }

    private void O000000o(EndTag endTag) {
        Element element;
        String O0000o = endTag.O0000o();
        for (int size = this.O00000oo.size() - 1; size >= 0; size--) {
            element = (Element) this.O00000oo.get(size);
            if (element.O000000o().equals(O0000o)) {
                break;
            }
        }
        element = null;
        if (element != null) {
            for (int size2 = this.O00000oo.size() - 1; size2 >= 0; size2--) {
                Element element2 = (Element) this.O00000oo.get(size2);
                this.O00000oo.remove(size2);
                if (element2 == element) {
                    break;
                }
            }
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Document O000000o(String str, String str2) {
        return O000000o(str, str2, ParseErrorList.O00000o0(), ParseSettings.O00000Oo);
    }

    /* Access modifiers changed, original: 0000 */
    public Element O000000o(StartTag startTag) {
        Tag O000000o = Tag.O000000o(startTag.O0000o(), this.O0000Oo);
        Node element = new Element(O000000o, this.O0000O0o, this.O0000Oo.O000000o(startTag.O00000oO));
        O000000o(element);
        if (startTag.O0000oO()) {
            this.O00000o.O00000o0();
            if (!O000000o.O0000Oo0()) {
                O000000o.O0000o00();
            }
        } else {
            this.O00000oo.add(element);
        }
        return element;
    }

    /* Access modifiers changed, original: 0000 */
    public ParseSettings O000000o() {
        return ParseSettings.O00000Oo;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Character character) {
        O000000o(new TextNode(character.O0000o0(), this.O0000O0o));
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Comment comment) {
        Node comment2 = new Comment(comment.O0000o0(), this.O0000O0o);
        if (comment.O00000o0) {
            String O00000Oo = comment2.O00000Oo();
            if (O00000Oo.length() > 1 && (O00000Oo.startsWith("!") || O00000Oo.startsWith("?"))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("<");
                stringBuilder.append(O00000Oo.substring(1, O00000Oo.length() - 1));
                stringBuilder.append(">");
                Element O000000o = Jsoup.O000000o(stringBuilder.toString(), this.O0000O0o, Parser.O00000oo()).O000000o(0);
                Node xmlDeclaration = new XmlDeclaration(this.O0000Oo.O000000o(O000000o.O0000o0O()), comment2.O000Oo00(), O00000Oo.startsWith("!"));
                xmlDeclaration.O000OOoo().O000000o(O000000o.O000OOoo());
                comment2 = xmlDeclaration;
            }
        }
        O000000o(comment2);
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Doctype doctype) {
        O000000o(new DocumentType(this.O0000Oo.O000000o(doctype.O0000o0()), doctype.O0000o0O(), doctype.O0000o0o(), doctype.O0000o(), this.O0000O0o));
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(Token token) {
        switch (token.O000000o) {
            case StartTag:
                O000000o(token.O00000oo());
                break;
            case EndTag:
                O000000o(token.O0000OOo());
                break;
            case Comment:
                O000000o(token.O0000Oo());
                break;
            case Character:
                O000000o(token.O0000Ooo());
                break;
            case Doctype:
                O000000o(token.O00000o());
                break;
            case EOF:
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected token type: ");
                stringBuilder.append(token.O000000o);
                Validate.O00000Oo(stringBuilder.toString());
                break;
        }
        return true;
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        super.O00000Oo(str, str2, parseErrorList, parseSettings);
        this.O00000oo.add(this.O00000oO);
        this.O00000oO.O0000OoO().O000000o(Syntax.xml);
    }

    /* Access modifiers changed, original: 0000 */
    public List<Node> O00000o0(String str, String str2, ParseErrorList parseErrorList, ParseSettings parseSettings) {
        O00000Oo(str, str2, parseErrorList, parseSettings);
        O00oOooO();
        return this.O00000oO.O000Oo0();
    }
}
