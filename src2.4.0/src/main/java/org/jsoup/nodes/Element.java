package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Document.OutputSettings.Syntax;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.Evaluator.AllElements;
import org.jsoup.select.Evaluator.Attribute;
import org.jsoup.select.Evaluator.AttributeStarting;
import org.jsoup.select.Evaluator.AttributeWithValue;
import org.jsoup.select.Evaluator.AttributeWithValueContaining;
import org.jsoup.select.Evaluator.AttributeWithValueEnding;
import org.jsoup.select.Evaluator.AttributeWithValueMatching;
import org.jsoup.select.Evaluator.AttributeWithValueNot;
import org.jsoup.select.Evaluator.AttributeWithValueStarting;
import org.jsoup.select.Evaluator.Class;
import org.jsoup.select.Evaluator.ContainsOwnText;
import org.jsoup.select.Evaluator.ContainsText;
import org.jsoup.select.Evaluator.Id;
import org.jsoup.select.Evaluator.IndexEquals;
import org.jsoup.select.Evaluator.IndexGreaterThan;
import org.jsoup.select.Evaluator.IndexLessThan;
import org.jsoup.select.Evaluator.Matches;
import org.jsoup.select.Evaluator.MatchesOwn;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.QueryParser;
import org.jsoup.select.Selector;

public class Element extends Node {
    private static final Pattern O00000Oo = Pattern.compile("\\s+");
    private Tag O000000o;

    public Element(String str) {
        this(Tag.O000000o(str), "", new Attributes());
    }

    public Element(Tag tag, String str) {
        this(tag, str, new Attributes());
    }

    public Element(Tag tag, String str, Attributes attributes) {
        super(str, attributes);
        Validate.O000000o((Object) tag);
        this.O000000o = tag;
    }

    private static <E extends Element> Integer O000000o(Element element, List<E> list) {
        Validate.O000000o((Object) element);
        Validate.O000000o((Object) list);
        for (int i = 0; i < list.size(); i++) {
            if (((Element) list.get(i)) == element) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    private void O000000o(StringBuilder stringBuilder) {
        for (Node node : this.O00000o) {
            if (node instanceof TextNode) {
                O00000Oo(stringBuilder, (TextNode) node);
            } else if (node instanceof Element) {
                O000000o((Element) node, stringBuilder);
            }
        }
    }

    private static void O000000o(Element element, StringBuilder stringBuilder) {
        if (element.O000000o.O000000o().equals("br") && !TextNode.O000000o(stringBuilder)) {
            stringBuilder.append(" ");
        }
    }

    private static void O000000o(Element element, Elements elements) {
        element = element.O000OOoO();
        if (element != null && !element.O0000o0O().equals("#root")) {
            elements.add(element);
            O000000o(element, elements);
        }
    }

    private void O00000Oo(StringBuilder stringBuilder) {
        for (Node O00000Oo : this.O00000o) {
            O00000Oo.O00000Oo(stringBuilder);
        }
    }

    private static void O00000Oo(StringBuilder stringBuilder, TextNode textNode) {
        String O00000o0 = textNode.O00000o0();
        if (O00000oO(textNode.O00000o0)) {
            stringBuilder.append(O00000o0);
        } else {
            StringUtil.O000000o(stringBuilder, O00000o0, TextNode.O000000o(stringBuilder));
        }
    }

    static boolean O00000oO(Node node) {
        boolean z = false;
        if (node == null || !(node instanceof Element)) {
            return false;
        }
        Element element = (Element) node;
        if (element.O000000o.O0000Oo() || (element.O000OOoO() != null && element.O000OOoO().O000000o.O0000Oo())) {
            z = true;
        }
        return z;
    }

    public <T extends Appendable> T O000000o(T t) {
        for (Node O00000Oo : this.O00000o) {
            O00000Oo.O00000Oo(t);
        }
        return t;
    }

    public String O000000o() {
        return this.O000000o.O000000o();
    }

    public Element O000000o(int i) {
        return (Element) O0000oo0().get(i);
    }

    public Element O000000o(int i, Collection<? extends Node> collection) {
        Validate.O000000o((Object) collection, "Children collection to be inserted must not be null.");
        int O000Oo0o = O000Oo0o();
        if (i < 0) {
            i += O000Oo0o + 1;
        }
        boolean z = i >= 0 && i <= O000Oo0o;
        Validate.O000000o(z, "Insert position out of bounds.");
        ArrayList arrayList = new ArrayList(collection);
        O000000o(i, (Node[]) arrayList.toArray(new Node[arrayList.size()]));
        return this;
    }

    /* renamed from: O000000o */
    public Element O0000OOo(String str, String str2) {
        super.O0000OOo(str, str2);
        return this;
    }

    public Element O000000o(String str, boolean z) {
        this.O00000oO.O000000o(str, z);
        return this;
    }

    public Element O000000o(Set<String> set) {
        Validate.O000000o((Object) set);
        this.O00000oO.O000000o("class", StringUtil.O000000o((Collection) set, " "));
        return this;
    }

    public Element O000000o(Node node) {
        Validate.O000000o((Object) node);
        O0000OoO(node);
        O000Ooo();
        this.O00000o.add(node);
        node.O00000oo(this.O00000o.size() - 1);
        return this;
    }

    public Elements O000000o(String str, Pattern pattern) {
        return Collector.O000000o(new AttributeWithValueMatching(str, pattern), this);
    }

    public Elements O000000o(Pattern pattern) {
        return Collector.O000000o(new Matches(pattern), this);
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        if (outputSettings.O00000oO() && (this.O000000o.O00000o0() || ((O000OOoO() != null && O000OOoO().O0000o0o().O00000o0()) || outputSettings.O00000oo()))) {
            if (!(appendable instanceof StringBuilder)) {
                O00000o0(appendable, i, outputSettings);
            } else if (((StringBuilder) appendable).length() > 0) {
                O00000o0(appendable, i, outputSettings);
            }
        }
        appendable.append("<").append(O0000o0O());
        this.O00000oO.O000000o(appendable, outputSettings);
        if (!this.O00000o.isEmpty() || !this.O000000o.O0000OOo()) {
            appendable.append(">");
        } else if (outputSettings.O00000o() == Syntax.html && this.O000000o.O0000O0o()) {
            appendable.append('>');
        } else {
            appendable.append(" />");
        }
    }

    public boolean O000000o(Evaluator evaluator) {
        return evaluator.O000000o((Element) O000OoO(), this);
    }

    public Element O00000Oo(Node node) {
        Validate.O000000o((Object) node);
        O000000o(0, node);
        return this;
    }

    public Elements O00000Oo(int i) {
        return Collector.O000000o(new IndexLessThan(i), this);
    }

    public Elements O00000Oo(String str, String str2) {
        return Collector.O000000o(new AttributeWithValue(str, str2), this);
    }

    public Elements O00000Oo(Pattern pattern) {
        return Collector.O000000o(new MatchesOwn(pattern), this);
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo(Appendable appendable, int i, OutputSettings outputSettings) throws IOException {
        if (!this.O00000o.isEmpty() || !this.O000000o.O0000OOo()) {
            if (outputSettings.O00000oO() && !this.O00000o.isEmpty() && (this.O000000o.O00000o0() || (outputSettings.O00000oo() && (this.O00000o.size() > 1 || (this.O00000o.size() == 1 && !(this.O00000o.get(0) instanceof TextNode)))))) {
                O00000o0(appendable, i, outputSettings);
            }
            appendable.append("</").append(O0000o0O()).append(">");
        }
    }

    public Element O00000o(String str) {
        Validate.O000000o((Object) str);
        O0000ooo();
        O000000o(new TextNode(str, this.O00000oo));
        return this;
    }

    /* renamed from: O00000o */
    public Element O00000oo(Node node) {
        return (Element) super.O00000oo(node);
    }

    public Elements O00000o(int i) {
        return Collector.O000000o(new IndexEquals(i), this);
    }

    public Elements O00000o(String str, String str2) {
        return Collector.O000000o(new AttributeWithValueStarting(str, str2), this);
    }

    /* renamed from: O00000o0 */
    public Element O0000O0o(Node node) {
        return (Element) super.O0000O0o(node);
    }

    public Elements O00000o0(int i) {
        return Collector.O000000o(new IndexGreaterThan(i), this);
    }

    public Elements O00000o0(String str, String str2) {
        return Collector.O000000o(new AttributeWithValueNot(str, str2), this);
    }

    public Element O00000oO(String str) {
        Validate.O000000o(str, "Tag name must not be empty.");
        this.O000000o = Tag.O000000o(str, ParseSettings.O00000Oo);
        return this;
    }

    public Elements O00000oO(String str, String str2) {
        return Collector.O000000o(new AttributeWithValueEnding(str, str2), this);
    }

    public Elements O00000oo(String str) {
        return Selector.O000000o(str, this);
    }

    public Elements O00000oo(String str, String str2) {
        return Collector.O000000o(new AttributeWithValueContaining(str, str2), this);
    }

    public Elements O0000O0o(String str, String str2) {
        try {
            return O000000o(str, Pattern.compile(str2));
        } catch (PatternSyntaxException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pattern syntax error: ");
            stringBuilder.append(str2);
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        }
    }

    public boolean O0000O0o(String str) {
        return O000000o(QueryParser.O000000o(str));
    }

    public Element O0000OOo(String str) {
        Node element = new Element(Tag.O000000o(str), O000Oo00());
        O000000o(element);
        return element;
    }

    public Element O0000Oo(String str) {
        Validate.O000000o((Object) str);
        O000000o(new TextNode(str, O000Oo00()));
        return this;
    }

    public Element O0000Oo0(String str) {
        Node element = new Element(Tag.O000000o(str), O000Oo00());
        O00000Oo(element);
        return element;
    }

    public Element O0000OoO(String str) {
        Validate.O000000o((Object) str);
        O00000Oo(new TextNode(str, O000Oo00()));
        return this;
    }

    public Element O0000Ooo(String str) {
        Validate.O000000o((Object) str);
        List O000000o = Parser.O000000o(str, this, O000Oo00());
        O000000o((Node[]) O000000o.toArray(new Node[O000000o.size()]));
        return this;
    }

    public Elements O0000o(String str) {
        Validate.O000000o(str);
        return Collector.O000000o(new Evaluator.Tag(str.toLowerCase().trim()), this);
    }

    public boolean O0000o() {
        return this.O000000o.O00000Oo();
    }

    /* renamed from: O0000o0 */
    public Element O000O0oO(String str) {
        return (Element) super.O000O0oO(str);
    }

    /* renamed from: O0000o00 */
    public Element clone() {
        return (Element) super.clone();
    }

    public Element O0000o00(String str) {
        Validate.O000000o((Object) str);
        List O000000o = Parser.O000000o(str, this, O000Oo00());
        O000000o(0, (Node[]) O000000o.toArray(new Node[O000000o.size()]));
        return this;
    }

    public String O0000o0O() {
        return this.O000000o.O000000o();
    }

    /* renamed from: O0000o0O */
    public Element O000O0o(String str) {
        return (Element) super.O000O0o(str);
    }

    /* renamed from: O0000o0o */
    public Element O000O0o0(String str) {
        return (Element) super.O000O0o0(str);
    }

    public Tag O0000o0o() {
        return this.O000000o;
    }

    public Map<String, String> O0000oO() {
        return this.O00000oO.O00000o0();
    }

    public Elements O0000oO(String str) {
        Validate.O000000o(str);
        return Collector.O000000o(new Class(str), this);
    }

    public String O0000oO0() {
        return this.O00000oO.O00000Oo("id");
    }

    public Element O0000oO0(String str) {
        Validate.O000000o(str);
        Elements O000000o = Collector.O000000o(new Id(str), this);
        return O000000o.size() > 0 ? (Element) O000000o.get(0) : null;
    }

    /* renamed from: O0000oOO */
    public final Element O000OOoO() {
        return (Element) this.O00000o0;
    }

    public Elements O0000oOO(String str) {
        Validate.O000000o(str);
        return Collector.O000000o(new Attribute(str.trim()), this);
    }

    public Elements O0000oOo() {
        Elements elements = new Elements();
        O000000o(this, elements);
        return elements;
    }

    public Elements O0000oOo(String str) {
        Validate.O000000o(str);
        return Collector.O000000o(new AttributeStarting(str.trim()), this);
    }

    public List<TextNode> O0000oo() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.O00000o) {
            if (node instanceof TextNode) {
                arrayList.add((TextNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Elements O0000oo(String str) {
        return Collector.O000000o(new ContainsOwnText(str), this);
    }

    public Elements O0000oo0() {
        List arrayList = new ArrayList(this.O00000o.size());
        for (Node node : this.O00000o) {
            if (node instanceof Element) {
                arrayList.add((Element) node);
            }
        }
        return new Elements(arrayList);
    }

    public Elements O0000oo0(String str) {
        return Collector.O000000o(new ContainsText(str), this);
    }

    public List<DataNode> O0000ooO() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.O00000o) {
            if (node instanceof DataNode) {
                arrayList.add((DataNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Elements O0000ooO(String str) {
        try {
            return O000000o(Pattern.compile(str));
        } catch (PatternSyntaxException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pattern syntax error: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        }
    }

    public Element O0000ooo() {
        this.O00000o.clear();
        return this;
    }

    public Elements O0000ooo(String str) {
        try {
            return O00000Oo(Pattern.compile(str));
        } catch (PatternSyntaxException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Pattern syntax error: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString(), e);
        }
    }

    public Element O000O00o() {
        if (this.O00000o0 == null) {
            return null;
        }
        List O0000oo0 = O000OOoO().O0000oo0();
        Object O000000o = O000000o(this, O0000oo0);
        Validate.O000000o(O000000o);
        return O0000oo0.size() > O000000o.intValue() + 1 ? (Element) O0000oo0.get(O000000o.intValue() + 1) : null;
    }

    public Element O000O00o(String str) {
        Validate.O000000o((Object) str);
        Set O000OOOo = O000OOOo();
        O000OOOo.remove(str);
        O000000o(O000OOOo);
        return this;
    }

    public Element O000O0OO() {
        if (this.O00000o0 == null) {
            return null;
        }
        List O0000oo0 = O000OOoO().O0000oo0();
        Object O000000o = O000000o(this, O0000oo0);
        Validate.O000000o(O000000o);
        return O000000o.intValue() > 0 ? (Element) O0000oo0.get(O000000o.intValue() - 1) : null;
    }

    public Element O000O0OO(String str) {
        Validate.O000000o((Object) str);
        Set O000OOOo = O000OOOo();
        if (O000OOOo.contains(str)) {
            O000OOOo.remove(str);
        } else {
            O000OOOo.add(str);
        }
        O000000o(O000OOOo);
        return this;
    }

    public Element O000O0Oo() {
        Elements O0000oo0 = O000OOoO().O0000oo0();
        return O0000oo0.size() > 1 ? (Element) O0000oo0.get(0) : null;
    }

    public Element O000O0Oo(String str) {
        if (O0000o0O().equals("textarea")) {
            O00000o(str);
        } else {
            O0000OOo("value", str);
        }
        return this;
    }

    public Elements O000O0o() {
        return Collector.O000000o(new AllElements(), this);
    }

    public Element O000O0o0() {
        Elements O0000oo0 = O000OOoO().O0000oo0();
        return O0000oo0.size() > 1 ? (Element) O0000oo0.get(O0000oo0.size() - 1) : null;
    }

    public String O000O0oO() {
        final StringBuilder stringBuilder = new StringBuilder();
        new NodeTraversor(new NodeVisitor() {
            public void O000000o(Node node, int i) {
                if (node instanceof TextNode) {
                    Element.O00000Oo(stringBuilder, (TextNode) node);
                } else if (node instanceof Element) {
                    Element element = (Element) node;
                    if (stringBuilder.length() <= 0) {
                        return;
                    }
                    if ((element.O0000o() || element.O000000o.O000000o().equals("br")) && !TextNode.O000000o(stringBuilder)) {
                        stringBuilder.append(" ");
                    }
                }
            }

            public void O00000Oo(Node node, int i) {
            }
        }).O000000o(this);
        return stringBuilder.toString().trim();
    }

    public String O000O0oo() {
        StringBuilder stringBuilder = new StringBuilder();
        O000000o(stringBuilder);
        return stringBuilder.toString().trim();
    }

    public String O000OO() {
        return O000O0oo("class").trim();
    }

    public boolean O000OO00() {
        for (Node node : this.O00000o) {
            if (node instanceof TextNode) {
                if (!((TextNode) node).O00000o()) {
                    return true;
                }
            } else if ((node instanceof Element) && ((Element) node).O000OO00()) {
                return true;
            }
        }
        return false;
    }

    public String O000OO0o() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node node : this.O00000o) {
            if (node instanceof DataNode) {
                stringBuilder.append(((DataNode) node).O00000Oo());
            } else if (node instanceof Comment) {
                stringBuilder.append(((Comment) node).O00000Oo());
            } else if (node instanceof Element) {
                stringBuilder.append(((Element) node).O000OO0o());
            }
        }
        return stringBuilder.toString();
    }

    public Set<String> O000OOOo() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(O00000Oo.split(O000OO())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    public String O000OOo() {
        StringBuilder stringBuilder = new StringBuilder();
        O00000Oo(stringBuilder);
        return O000o00O().O00000oO() ? stringBuilder.toString().trim() : stringBuilder.toString();
    }

    public String O000OOo0() {
        return O0000o0O().equals("textarea") ? O000O0oO() : O000O0oo("value");
    }

    public Integer O00oOoOo() {
        return O000OOoO() == null ? Integer.valueOf(0) : O000000o(this, O000OOoO().O0000oo0());
    }

    public Element O00oOoOo(String str) {
        O0000ooo();
        O0000Ooo(str);
        return this;
    }

    public String O00oOooO() {
        StringBuilder stringBuilder;
        if (O0000oO0().length() > 0) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("#");
            stringBuilder.append(O0000oO0());
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder(O0000o0O().replace(':', '|'));
        String O000000o = StringUtil.O000000o(O000OOOo(), ".");
        if (O000000o.length() > 0) {
            stringBuilder2.append('.');
            stringBuilder2.append(O000000o);
        }
        if (O000OOoO() == null || (O000OOoO() instanceof Document)) {
            return stringBuilder2.toString();
        }
        stringBuilder2.insert(0, " > ");
        if (O000OOoO().O00000oo(stringBuilder2.toString()).size() > 1) {
            stringBuilder2.append(String.format(":nth-child(%d)", new Object[]{Integer.valueOf(O00oOoOo().intValue() + 1)}));
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(O000OOoO().O00oOooO());
        stringBuilder.append(stringBuilder2.toString());
        return stringBuilder.toString();
    }

    public boolean O00oOooO(String str) {
        String O000000o = this.O00000oO.O000000o("class");
        int length = O000000o.length();
        int length2 = str.length();
        if (length == 0 || length < length2) {
            return false;
        }
        if (length == length2) {
            return str.equalsIgnoreCase(O000000o);
        }
        boolean z = false;
        int i = z;
        int i2 = i;
        while (i < length) {
            if (Character.isWhitespace(O000000o.charAt(i))) {
                if (!z) {
                    continue;
                } else if (i - i2 == length2 && O000000o.regionMatches(true, i2, str, 0, length2)) {
                    return true;
                } else {
                    z = false;
                }
            } else if (!z) {
                i2 = i;
                z = true;
            }
            i++;
        }
        return (z && length - i2 == length2) ? O000000o.regionMatches(true, i2, str, 0, length2) : false;
    }

    public Element O00oOooo(String str) {
        Validate.O000000o((Object) str);
        Set O000OOOo = O000OOOo();
        O000OOOo.add(str);
        O000000o(O000OOOo);
        return this;
    }

    public Elements O00oOooo() {
        if (this.O00000o0 == null) {
            return new Elements(0);
        }
        Elements<Element> O0000oo0 = O000OOoO().O0000oo0();
        Elements elements = new Elements(O0000oo0.size() - 1);
        for (Element element : O0000oo0) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    public String toString() {
        return O0000O0o();
    }
}
