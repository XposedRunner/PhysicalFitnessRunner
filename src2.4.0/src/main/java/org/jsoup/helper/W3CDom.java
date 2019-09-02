package org.jsoup.helper;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class W3CDom {
    protected DocumentBuilderFactory O000000o = DocumentBuilderFactory.newInstance();

    protected static class W3CBuilder implements NodeVisitor {
        private static final String O000000o = "xmlns";
        private static final String O00000Oo = "xmlns:";
        private final HashMap<String, String> O00000o = new HashMap();
        private final Document O00000o0;
        private Element O00000oO;

        public W3CBuilder(Document document) {
            this.O00000o0 = document;
        }

        private String O000000o(org.jsoup.nodes.Element element) {
            Iterator it = element.O000OOoo().iterator();
            while (it.hasNext()) {
                Object obj;
                Attribute attribute = (Attribute) it.next();
                String O000000o = attribute.getKey();
                if (O000000o.equals(O000000o)) {
                    obj = "";
                } else if (O000000o.startsWith(O00000Oo)) {
                    obj = O000000o.substring(O00000Oo.length());
                }
                this.O00000o.put(obj, attribute.getValue());
            }
            int indexOf = element.O0000o0O().indexOf(":");
            return indexOf > 0 ? element.O0000o0O().substring(0, indexOf) : "";
        }

        private void O000000o(Node node, Element element) {
            Iterator it = node.O000OOoo().iterator();
            while (it.hasNext()) {
                Attribute attribute = (Attribute) it.next();
                String replaceAll = attribute.getKey().replaceAll("[^-a-zA-Z0-9_:.]", "");
                if (replaceAll.matches("[a-zA-Z_:]{1}[-a-zA-Z0-9_:.]*")) {
                    element.setAttribute(replaceAll, attribute.getValue());
                }
            }
        }

        public void O000000o(Node node, int i) {
            if (node instanceof org.jsoup.nodes.Element) {
                node = (org.jsoup.nodes.Element) node;
                Element createElementNS = this.O00000o0.createElementNS((String) this.O00000o.get(O000000o(node)), node.O0000o0O());
                O000000o(node, createElementNS);
                if (this.O00000oO == null) {
                    this.O00000o0.appendChild(createElementNS);
                } else {
                    this.O00000oO.appendChild(createElementNS);
                }
                this.O00000oO = createElementNS;
            } else if (node instanceof TextNode) {
                this.O00000oO.appendChild(this.O00000o0.createTextNode(((TextNode) node).O00000o0()));
            } else if (node instanceof Comment) {
                this.O00000oO.appendChild(this.O00000o0.createComment(((Comment) node).O00000Oo()));
            } else if (node instanceof DataNode) {
                this.O00000oO.appendChild(this.O00000o0.createTextNode(((DataNode) node).O00000Oo()));
            }
        }

        public void O00000Oo(Node node, int i) {
            if ((node instanceof org.jsoup.nodes.Element) && (this.O00000oO.getParentNode() instanceof Element)) {
                this.O00000oO = (Element) this.O00000oO.getParentNode();
            }
        }
    }

    public String O000000o(Document document) {
        try {
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            TransformerFactory.newInstance().newTransformer().transform(dOMSource, new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (TransformerException e) {
            throw new IllegalStateException(e);
        }
    }

    public Document O000000o(org.jsoup.nodes.Document document) {
        Validate.O000000o((Object) document);
        try {
            this.O000000o.setNamespaceAware(true);
            Document newDocument = this.O000000o.newDocumentBuilder().newDocument();
            O000000o(document, newDocument);
            return newDocument;
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException(e);
        }
    }

    public void O000000o(org.jsoup.nodes.Document document, Document document2) {
        if (!StringUtil.O000000o(document.O00000Oo())) {
            document2.setDocumentURI(document.O00000Oo());
        }
        new NodeTraversor(new W3CBuilder(document2)).O000000o(document.O000000o(0));
    }
}
