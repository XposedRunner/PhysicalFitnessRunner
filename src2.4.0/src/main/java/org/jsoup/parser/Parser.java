package org.jsoup.parser;

import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class Parser {
    private static final int O000000o = 0;
    private TreeBuilder O00000Oo;
    private ParseErrorList O00000o;
    private int O00000o0 = 0;
    private ParseSettings O00000oO;

    public Parser(TreeBuilder treeBuilder) {
        this.O00000Oo = treeBuilder;
        this.O00000oO = treeBuilder.O000000o();
    }

    public static String O000000o(String str, boolean z) {
        return new Tokeniser(new CharacterReader(str), ParseErrorList.O00000o0()).O00000Oo(z);
    }

    public static List<Node> O000000o(String str, Element element, String str2) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        return htmlTreeBuilder.O000000o(str, element, str2, ParseErrorList.O00000o0(), htmlTreeBuilder.O000000o());
    }

    public static List<Node> O000000o(String str, Element element, String str2, ParseErrorList parseErrorList) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        return htmlTreeBuilder.O000000o(str, element, str2, parseErrorList, htmlTreeBuilder.O000000o());
    }

    public static Document O00000Oo(String str, String str2) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        return htmlTreeBuilder.O000000o(str, str2, ParseErrorList.O00000o0(), htmlTreeBuilder.O000000o());
    }

    public static Document O00000o(String str, String str2) {
        int length;
        Document O000000o = Document.O000000o(str2);
        Element O00000o = O000000o.O00000o();
        List O000000o2 = O000000o(str, O00000o, str2);
        Node[] nodeArr = (Node[]) O000000o2.toArray(new Node[O000000o2.size()]);
        for (length = nodeArr.length - 1; length > 0; length--) {
            nodeArr[length].O000OoOo();
        }
        for (Node O000000o3 : nodeArr) {
            O00000o.O000000o(O000000o3);
        }
        return O000000o;
    }

    public static List<Node> O00000o0(String str, String str2) {
        XmlTreeBuilder xmlTreeBuilder = new XmlTreeBuilder();
        return xmlTreeBuilder.O00000o0(str, str2, ParseErrorList.O00000o0(), xmlTreeBuilder.O000000o());
    }

    public static Document O00000oO(String str, String str2) {
        return O00000Oo(str, str2);
    }

    public static Parser O00000oO() {
        return new Parser(new HtmlTreeBuilder());
    }

    public static Parser O00000oo() {
        return new Parser(new XmlTreeBuilder());
    }

    public Document O000000o(String str, String str2) {
        this.O00000o = O00000Oo() ? ParseErrorList.O000000o(this.O00000o0) : ParseErrorList.O00000o0();
        return this.O00000Oo.O000000o(str, str2, this.O00000o, this.O00000oO);
    }

    public Parser O000000o(int i) {
        this.O00000o0 = i;
        return this;
    }

    public Parser O000000o(ParseSettings parseSettings) {
        this.O00000oO = parseSettings;
        return this;
    }

    public Parser O000000o(TreeBuilder treeBuilder) {
        this.O00000Oo = treeBuilder;
        return this;
    }

    public TreeBuilder O000000o() {
        return this.O00000Oo;
    }

    public boolean O00000Oo() {
        return this.O00000o0 > 0;
    }

    public ParseSettings O00000o() {
        return this.O00000oO;
    }

    public List<ParseError> O00000o0() {
        return this.O00000o;
    }
}
