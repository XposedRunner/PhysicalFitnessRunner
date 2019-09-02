package org.jsoup.nodes;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class Document extends Element {
    private OutputSettings O000000o = new OutputSettings();
    private QuirksMode O00000Oo = QuirksMode.noQuirks;
    private String O0000OOo;
    private boolean O0000Oo0 = false;

    public static class OutputSettings implements Cloneable {
        private EscapeMode O000000o = EscapeMode.base;
        private Charset O00000Oo = Charset.forName("UTF-8");
        private boolean O00000o = false;
        private boolean O00000o0 = true;
        private int O00000oO = 1;
        private Syntax O00000oo = Syntax.html;

        public enum Syntax {
            html,
            xml
        }

        public OutputSettings O000000o(int i) {
            Validate.O000000o(i >= 0);
            this.O00000oO = i;
            return this;
        }

        public OutputSettings O000000o(String str) {
            O000000o(Charset.forName(str));
            return this;
        }

        public OutputSettings O000000o(Charset charset) {
            this.O00000Oo = charset;
            return this;
        }

        public OutputSettings O000000o(Syntax syntax) {
            this.O00000oo = syntax;
            return this;
        }

        public OutputSettings O000000o(EscapeMode escapeMode) {
            this.O000000o = escapeMode;
            return this;
        }

        public OutputSettings O000000o(boolean z) {
            this.O00000o0 = z;
            return this;
        }

        public EscapeMode O000000o() {
            return this.O000000o;
        }

        public Charset O00000Oo() {
            return this.O00000Oo;
        }

        public OutputSettings O00000Oo(boolean z) {
            this.O00000o = z;
            return this;
        }

        public Syntax O00000o() {
            return this.O00000oo;
        }

        /* Access modifiers changed, original: 0000 */
        public CharsetEncoder O00000o0() {
            return this.O00000Oo.newEncoder();
        }

        public boolean O00000oO() {
            return this.O00000o0;
        }

        public boolean O00000oo() {
            return this.O00000o;
        }

        public int O0000O0o() {
            return this.O00000oO;
        }

        /* renamed from: O0000OOo */
        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.O000000o(this.O00000Oo.name());
                outputSettings.O000000o = EscapeMode.valueOf(this.O000000o.name());
                return outputSettings;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.O000000o("#root", ParseSettings.O000000o), str);
        this.O0000OOo = str;
    }

    public static Document O000000o(String str) {
        Validate.O000000o((Object) str);
        Document document = new Document(str);
        Element O0000OOo = document.O0000OOo("html");
        O0000OOo.O0000OOo("head");
        O0000OOo.O0000OOo("body");
        return document;
    }

    private Element O000000o(String str, Node node) {
        if (node.O000000o().equals(str)) {
            return (Element) node;
        }
        for (Node O000000o : node.O00000o) {
            Element O000000o2 = O000000o(str, O000000o);
            if (O000000o2 != null) {
                return O000000o2;
            }
        }
        return null;
    }

    private void O000000o(String str, Element element) {
        Elements O0000o = O0000o(str);
        Node O0000o0O = O0000o.O0000o0O();
        int i = 1;
        if (O0000o.size() > 1) {
            ArrayList<Node> arrayList = new ArrayList();
            while (i < O0000o.size()) {
                Node node = (Node) O0000o.get(i);
                for (Node add : node.O00000o) {
                    arrayList.add(add);
                }
                node.O000OoOo();
                i++;
            }
            for (Node O000000o : arrayList) {
                O0000o0O.O000000o(O000000o);
            }
        }
        if (!O0000o0O.O000OOoO().equals(element)) {
            element.O000000o(O0000o0O);
        }
    }

    private void O00000Oo(Element element) {
        Node node;
        ArrayList arrayList = new ArrayList();
        for (Node node2 : element.O00000o) {
            if (node2 instanceof TextNode) {
                TextNode textNode = (TextNode) node2;
                if (!textNode.O00000o()) {
                    arrayList.add(textNode);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            node2 = (Node) arrayList.get(size);
            element.O0000Oo(node2);
            O00000o().O00000Oo(new TextNode(" ", ""));
            O00000o().O00000Oo(node2);
        }
    }

    private void O000o00o() {
        if (this.O0000Oo0) {
            Syntax O00000o = O0000OoO().O00000o();
            if (O00000o == Syntax.html) {
                Element O0000o0O = O00000oo("meta[charset]").O0000o0O();
                if (O0000o0O != null) {
                    O0000o0O.O0000OOo("charset", O0000OOo().displayName());
                } else {
                    O0000o0O = O00000o0();
                    if (O0000o0O != null) {
                        O0000o0O.O0000OOo("meta").O0000OOo("charset", O0000OOo().displayName());
                    }
                }
                O00000oo("meta[name=charset]").O0000Oo0();
            } else if (O00000o == Syntax.xml) {
                Node node = (Node) O000Oo0().get(0);
                XmlDeclaration xmlDeclaration;
                if (node instanceof XmlDeclaration) {
                    xmlDeclaration = (XmlDeclaration) node;
                    if (xmlDeclaration.O00000Oo().equals("xml")) {
                        xmlDeclaration.O0000OOo("encoding", O0000OOo().displayName());
                        if (xmlDeclaration.O000O0oo("version") != null) {
                            xmlDeclaration.O0000OOo("version", "1.0");
                            return;
                        }
                        return;
                    }
                    xmlDeclaration = new XmlDeclaration("xml", this.O00000oo, false);
                    xmlDeclaration.O0000OOo("version", "1.0");
                    xmlDeclaration.O0000OOo("encoding", O0000OOo().displayName());
                    O00000Oo((Node) xmlDeclaration);
                    return;
                }
                xmlDeclaration = new XmlDeclaration("xml", this.O00000oo, false);
                xmlDeclaration.O0000OOo("version", "1.0");
                xmlDeclaration.O0000OOo("encoding", O0000OOo().displayName());
                O00000Oo((Node) xmlDeclaration);
            }
        }
    }

    public String O000000o() {
        return "#document";
    }

    public Document O000000o(OutputSettings outputSettings) {
        Validate.O000000o((Object) outputSettings);
        this.O000000o = outputSettings;
        return this;
    }

    public Document O000000o(QuirksMode quirksMode) {
        this.O00000Oo = quirksMode;
        return this;
    }

    public void O000000o(Charset charset) {
        O000000o(true);
        this.O000000o.O000000o(charset);
        O000o00o();
    }

    public void O000000o(boolean z) {
        this.O0000Oo0 = z;
    }

    public String O00000Oo() {
        return this.O0000OOo;
    }

    public void O00000Oo(String str) {
        Validate.O000000o((Object) str);
        Element O0000o0O = O0000o("title").O0000o0O();
        if (O0000o0O == null) {
            O00000o0().O0000OOo("title").O00000o(str);
        } else {
            O0000o0O.O00000o(str);
        }
    }

    public Element O00000o() {
        return O000000o("body", (Node) this);
    }

    public Element O00000o(String str) {
        O00000o().O00000o(str);
        return this;
    }

    public Element O00000o0() {
        return O000000o("head", (Node) this);
    }

    public Element O00000o0(String str) {
        return new Element(Tag.O000000o(str, ParseSettings.O00000Oo), O000Oo00());
    }

    public String O00000oO() {
        Element O0000o0O = O0000o("title").O0000o0O();
        return O0000o0O != null ? StringUtil.O00000o0(O0000o0O.O000O0oO()).trim() : "";
    }

    public Document O00000oo() {
        Element O000000o = O000000o("html", (Node) this);
        if (O000000o == null) {
            O000000o = O0000OOo("html");
        }
        if (O00000o0() == null) {
            O000000o.O0000Oo0("head");
        }
        if (O00000o() == null) {
            O000000o.O0000OOo("body");
        }
        O00000Oo(O00000o0());
        O00000Oo(O000000o);
        O00000Oo((Element) this);
        O000000o("head", O000000o);
        O000000o("body", O000000o);
        O000o00o();
        return this;
    }

    public String O0000O0o() {
        return super.O000OOo();
    }

    public Charset O0000OOo() {
        return this.O000000o.O00000Oo();
    }

    /* renamed from: O0000Oo */
    public Document clone() {
        Document document = (Document) super.clone();
        document.O000000o = this.O000000o.clone();
        return document;
    }

    public boolean O0000Oo0() {
        return this.O0000Oo0;
    }

    public OutputSettings O0000OoO() {
        return this.O000000o;
    }

    public QuirksMode O0000Ooo() {
        return this.O00000Oo;
    }
}
