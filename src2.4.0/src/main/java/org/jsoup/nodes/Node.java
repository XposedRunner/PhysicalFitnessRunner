package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public abstract class Node implements Cloneable {
    private static final List<Node> O000000o = Collections.emptyList();
    List<Node> O00000o;
    Node O00000o0;
    Attributes O00000oO;
    String O00000oo;
    int O0000O0o;

    private static class OuterHtmlVisitor implements NodeVisitor {
        private Appendable O000000o;
        private OutputSettings O00000Oo;

        OuterHtmlVisitor(Appendable appendable, OutputSettings outputSettings) {
            this.O000000o = appendable;
            this.O00000Oo = outputSettings;
        }

        public void O000000o(Node node, int i) {
            try {
                node.O000000o(this.O000000o, i, this.O00000Oo);
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }

        public void O00000Oo(Node node, int i) {
            if (!node.O000000o().equals("#text")) {
                try {
                    node.O00000Oo(this.O000000o, i, this.O00000Oo);
                } catch (IOException e) {
                    throw new SerializationException(e);
                }
            }
        }
    }

    protected Node() {
        this.O00000o = O000000o;
        this.O00000oO = null;
    }

    protected Node(String str) {
        this(str, new Attributes());
    }

    protected Node(String str, Attributes attributes) {
        Validate.O000000o((Object) str);
        Validate.O000000o((Object) attributes);
        this.O00000o = O000000o;
        this.O00000oo = str.trim();
        this.O00000oO = attributes;
    }

    private Element O000000o(Element element) {
        Elements O0000oo0 = element.O0000oo0();
        return O0000oo0.size() > 0 ? O000000o((Element) O0000oo0.get(0)) : element;
    }

    private void O000000o(int i) {
        while (i < this.O00000o.size()) {
            ((Node) this.O00000o.get(i)).O00000oo(i);
            i++;
        }
    }

    private void O000000o(int i, String str) {
        Validate.O000000o((Object) str);
        Validate.O000000o(this.O00000o0);
        List O000000o = Parser.O000000o(str, O000OOoO() instanceof Element ? (Element) O000OOoO() : null, O000Oo00());
        this.O00000o0.O000000o(i, (Node[]) O000000o.toArray(new Node[O000000o.size()]));
    }

    public <T extends Appendable> T O000000o(T t) {
        O00000Oo(t);
        return t;
    }

    public abstract String O000000o();

    public Node O000000o(NodeVisitor nodeVisitor) {
        Validate.O000000o((Object) nodeVisitor);
        new NodeTraversor(nodeVisitor).O000000o(this);
        return this;
    }

    /* Access modifiers changed, original: protected|varargs */
    public void O000000o(int i, Node... nodeArr) {
        Validate.O000000o((Object[]) nodeArr);
        O000Ooo();
        for (int length = nodeArr.length - 1; length >= 0; length--) {
            Node node = nodeArr[length];
            O0000OoO(node);
            this.O00000o.add(i, node);
            O000000o(i);
        }
    }

    public abstract void O000000o(Appendable appendable, int i, OutputSettings outputSettings) throws IOException;

    /* Access modifiers changed, original: protected */
    public void O000000o(Node node, Node node2) {
        Validate.O000000o(node.O00000o0 == this);
        Validate.O000000o((Object) node2);
        if (node2.O00000o0 != null) {
            node2.O00000o0.O0000Oo(node2);
        }
        int i = node.O0000O0o;
        this.O00000o.set(i, node2);
        node2.O00000o0 = this;
        node2.O00000oo(i);
        node.O00000o0 = null;
    }

    /* Access modifiers changed, original: protected|varargs */
    public void O000000o(Node... nodeArr) {
        for (Node node : nodeArr) {
            O0000OoO(node);
            O000Ooo();
            this.O00000o.add(node);
            node.O00000oo(this.O00000o.size() - 1);
        }
    }

    public boolean O000000o(Object obj) {
        return this == obj ? true : (obj == null || getClass() != obj.getClass()) ? false : O0000O0o().equals(((Node) obj).O0000O0o());
    }

    /* Access modifiers changed, original: protected */
    public void O00000Oo(Appendable appendable) {
        new NodeTraversor(new OuterHtmlVisitor(appendable, O000o00O())).O000000o(this);
    }

    public abstract void O00000Oo(Appendable appendable, int i, OutputSettings outputSettings) throws IOException;

    /* Access modifiers changed, original: protected */
    public void O00000o0(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        appendable.append("\n").append(StringUtil.O000000o(i * outputSettings.O0000O0o()));
    }

    public Node O00000oO(int i) {
        return (Node) this.O00000o.get(i);
    }

    public Node O00000oo(Node node) {
        Validate.O000000o((Object) node);
        Validate.O000000o(this.O00000o0);
        this.O00000o0.O000000o(this.O0000O0o + 1, node);
        return this;
    }

    /* Access modifiers changed, original: protected */
    public void O00000oo(int i) {
        this.O0000O0o = i;
    }

    public String O0000O0o() {
        StringBuilder stringBuilder = new StringBuilder(128);
        O00000Oo(stringBuilder);
        return stringBuilder.toString();
    }

    public Node O0000O0o(Node node) {
        Validate.O000000o((Object) node);
        Validate.O000000o(this.O00000o0);
        this.O00000o0.O000000o(this.O0000O0o, node);
        return this;
    }

    public Node O0000OOo(String str, String str2) {
        this.O00000oO.O000000o(str, str2);
        return this;
    }

    public void O0000OOo(Node node) {
        Validate.O000000o((Object) node);
        Validate.O000000o(this.O00000o0);
        this.O00000o0.O000000o(this, node);
    }

    /* Access modifiers changed, original: protected */
    public void O0000Oo(Node node) {
        Validate.O000000o(node.O00000o0 == this);
        int i = node.O0000O0o;
        this.O00000o.remove(i);
        O000000o(i);
        node.O00000o0 = null;
    }

    /* Access modifiers changed, original: protected */
    public void O0000Oo0(Node node) {
        if (this.O00000o0 != null) {
            this.O00000o0.O0000Oo(this);
        }
        this.O00000o0 = node;
    }

    /* Access modifiers changed, original: protected */
    public void O0000OoO(Node node) {
        if (node.O00000o0 != null) {
            node.O00000o0.O0000Oo(node);
        }
        node.O0000Oo0(this);
    }

    /* Access modifiers changed, original: protected */
    public Node O0000Ooo(Node node) {
        try {
            Node node2 = (Node) super.clone();
            node2.O00000o0 = node;
            node2.O0000O0o = node == null ? 0 : this.O0000O0o;
            node2.O00000oO = this.O00000oO != null ? this.O00000oO.clone() : null;
            node2.O00000oo = this.O00000oo;
            node2.O00000o = new ArrayList(this.O00000o.size());
            for (Node add : this.O00000o) {
                node2.O00000o.add(add);
            }
            return node2;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: O0000o0 */
    public Node clone() {
        Node O0000Ooo = O0000Ooo(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(O0000Ooo);
        while (!linkedList.isEmpty()) {
            Node node = (Node) linkedList.remove();
            for (int i = 0; i < node.O00000o.size(); i++) {
                Node O0000Ooo2 = ((Node) node.O00000o.get(i)).O0000Ooo(node);
                node.O00000o.set(i, O0000Ooo2);
                linkedList.add(O0000Ooo2);
            }
        }
        return O0000Ooo;
    }

    public Node O000O0o(String str) {
        O000000o(this.O0000O0o + 1, str);
        return this;
    }

    public Node O000O0o0(String str) {
        Validate.O000000o(str);
        List O000000o = Parser.O000000o(str, O000OOoO() instanceof Element ? (Element) O000OOoO() : null, O000Oo00());
        int i = 0;
        Node node = (Node) O000000o.get(0);
        if (node == null || !(node instanceof Element)) {
            return null;
        }
        node = (Element) node;
        Element O000000o2 = O000000o((Element) node);
        this.O00000o0.O000000o(this, node);
        O000000o2.O000000o(this);
        if (O000000o.size() > 0) {
            while (i < O000000o.size()) {
                Node node2 = (Node) O000000o.get(i);
                node2.O00000o0.O0000Oo(node2);
                node.O000000o(node2);
                i++;
            }
        }
        return this;
    }

    public Node O000O0oO(String str) {
        O000000o(this.O0000O0o, str);
        return this;
    }

    public String O000O0oo(String str) {
        Validate.O000000o((Object) str);
        String O00000Oo = this.O00000oO.O00000Oo(str);
        return O00000Oo.length() > 0 ? O00000Oo : str.toLowerCase().startsWith("abs:") ? O000OOOo(str.substring("abs:".length())) : "";
    }

    public void O000OO(final String str) {
        Validate.O000000o((Object) str);
        O000000o(new NodeVisitor() {
            public void O000000o(Node node, int i) {
                node.O00000oo = str;
            }

            public void O00000Oo(Node node, int i) {
            }
        });
    }

    public boolean O000OO00(String str) {
        Validate.O000000o((Object) str);
        if (str.startsWith("abs:")) {
            String substring = str.substring("abs:".length());
            if (this.O00000oO.O00000oo(substring) && !O000OOOo(substring).equals("")) {
                return true;
            }
        }
        return this.O00000oO.O00000oo(str);
    }

    public Node O000OO0o(String str) {
        Validate.O000000o((Object) str);
        this.O00000oO.O00000o(str);
        return this;
    }

    public String O000OOOo(String str) {
        Validate.O000000o(str);
        return !O000OO00(str) ? "" : StringUtil.O000000o(this.O00000oo, O000O0oo(str));
    }

    public Node O000OOoO() {
        return this.O00000o0;
    }

    public Attributes O000OOoo() {
        return this.O00000oO;
    }

    public List<Node> O000Oo0() {
        return Collections.unmodifiableList(this.O00000o);
    }

    public String O000Oo00() {
        return this.O00000oo;
    }

    public List<Node> O000Oo0O() {
        ArrayList arrayList = new ArrayList(this.O00000o.size());
        for (Node O0000o0 : this.O00000o) {
            arrayList.add(O0000o0.clone());
        }
        return arrayList;
    }

    public final int O000Oo0o() {
        return this.O00000o.size();
    }

    public Node O000OoO() {
        Node node = this;
        while (node.O00000o0 != null) {
            node = node.O00000o0;
        }
        return node;
    }

    /* Access modifiers changed, original: protected */
    public Node[] O000OoO0() {
        return (Node[]) this.O00000o.toArray(new Node[O000Oo0o()]);
    }

    public Document O000OoOO() {
        Node O000OoO = O000OoO();
        return O000OoO instanceof Document ? (Document) O000OoO : null;
    }

    public void O000OoOo() {
        Validate.O000000o(this.O00000o0);
        this.O00000o0.O0000Oo(this);
    }

    /* Access modifiers changed, original: protected */
    public void O000Ooo() {
        if (this.O00000o == O000000o) {
            this.O00000o = new ArrayList(4);
        }
    }

    public Node O000Ooo0() {
        Validate.O000000o(this.O00000o0);
        Node node = this.O00000o.size() > 0 ? (Node) this.O00000o.get(0) : null;
        this.O00000o0.O000000o(this.O0000O0o, O000OoO0());
        O000OoOo();
        return node;
    }

    public List<Node> O000OooO() {
        if (this.O00000o0 == null) {
            return Collections.emptyList();
        }
        List<Node> list = this.O00000o0.O00000o;
        ArrayList arrayList = new ArrayList(list.size() - 1);
        for (Node node : list) {
            if (node != this) {
                arrayList.add(node);
            }
        }
        return arrayList;
    }

    public Node O000Oooo() {
        if (this.O00000o0 == null) {
            return null;
        }
        List list = this.O00000o0.O00000o;
        int i = this.O0000O0o + 1;
        return list.size() > i ? (Node) list.get(i) : null;
    }

    public int O000o00() {
        return this.O0000O0o;
    }

    public Node O000o000() {
        return (this.O00000o0 != null && this.O0000O0o > 0) ? (Node) this.O00000o0.O00000o.get(this.O0000O0o - 1) : null;
    }

    /* Access modifiers changed, original: 0000 */
    public OutputSettings O000o00O() {
        Document O000OoOO = O000OoOO();
        if (O000OoOO == null) {
            O000OoOO = new Document("");
        }
        return O000OoOO.O0000OoO();
    }

    public final Node O00O0Oo() {
        return this.O00000o0;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    public String toString() {
        return O0000O0o();
    }
}
