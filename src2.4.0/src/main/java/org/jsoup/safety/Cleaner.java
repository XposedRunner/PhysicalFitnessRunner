package org.jsoup.safety;

import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.ParseErrorList;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public class Cleaner {
    private Whitelist O000000o;

    private final class CleaningVisitor implements NodeVisitor {
        private int O00000Oo;
        private Element O00000o;
        private final Element O00000o0;

        private CleaningVisitor(Element element, Element element2) {
            this.O00000Oo = 0;
            this.O00000o0 = element;
            this.O00000o = element2;
        }

        public void O000000o(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (Cleaner.this.O000000o.O000000o(element.O0000o0O())) {
                    ElementMeta O000000o = Cleaner.this.O000000o(element);
                    Node node2 = O000000o.O000000o;
                    this.O00000o.O000000o(node2);
                    this.O00000Oo += O000000o.O00000Oo;
                    this.O00000o = node2;
                } else if (node != this.O00000o0) {
                    this.O00000Oo++;
                }
            } else if (node instanceof TextNode) {
                this.O00000o.O000000o(new TextNode(((TextNode) node).O00000o0(), node.O000Oo00()));
            } else if ((node instanceof DataNode) && Cleaner.this.O000000o.O000000o(node.O000OOoO().O000000o())) {
                this.O00000o.O000000o(new DataNode(((DataNode) node).O00000Oo(), node.O000Oo00()));
            } else {
                this.O00000Oo++;
            }
        }

        public void O00000Oo(Node node, int i) {
            if ((node instanceof Element) && Cleaner.this.O000000o.O000000o(node.O000000o())) {
                this.O00000o = this.O00000o.O000OOoO();
            }
        }
    }

    private static class ElementMeta {
        Element O000000o;
        int O00000Oo;

        ElementMeta(Element element, int i) {
            this.O000000o = element;
            this.O00000Oo = i;
        }
    }

    public Cleaner(Whitelist whitelist) {
        Validate.O000000o((Object) whitelist);
        this.O000000o = whitelist;
    }

    private int O000000o(Element element, Element element2) {
        CleaningVisitor cleaningVisitor = new CleaningVisitor(element, element2);
        new NodeTraversor(cleaningVisitor).O000000o(element);
        return cleaningVisitor.O00000Oo;
    }

    private ElementMeta O000000o(Element element) {
        String O0000o0O = element.O0000o0O();
        Attributes attributes = new Attributes();
        Element element2 = new Element(Tag.O000000o(O0000o0O), element.O000Oo00(), attributes);
        Iterator it = element.O000OOoo().iterator();
        int i = 0;
        while (it.hasNext()) {
            Attribute attribute = (Attribute) it.next();
            if (this.O000000o.O000000o(O0000o0O, element, attribute)) {
                attributes.O000000o(attribute);
            } else {
                i++;
            }
        }
        attributes.O000000o(this.O000000o.O00000Oo(O0000o0O));
        return new ElementMeta(element2, i);
    }

    public Document O000000o(Document document) {
        Validate.O000000o((Object) document);
        Document O000000o = Document.O000000o(document.O000Oo00());
        if (document.O00000o() != null) {
            O000000o(document.O00000o(), O000000o.O00000o());
        }
        return O000000o;
    }

    public boolean O000000o(String str) {
        Document O000000o = Document.O000000o("");
        Document O000000o2 = Document.O000000o("");
        ParseErrorList O000000o3 = ParseErrorList.O000000o(1);
        O000000o2.O00000o().O000000o(0, Parser.O000000o(str, O000000o2.O00000o(), "", O000000o3));
        return O000000o(O000000o2.O00000o(), O000000o.O00000o()) == 0 && O000000o3.size() == 0;
    }

    public boolean O00000Oo(Document document) {
        Validate.O000000o((Object) document);
        return O000000o(document.O00000o(), Document.O000000o(document.O000Oo00()).O00000o()) == 0 && document.O00000o0().O000Oo0().size() == 0;
    }
}
