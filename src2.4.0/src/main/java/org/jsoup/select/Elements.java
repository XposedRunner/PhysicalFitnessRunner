package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;

public class Elements extends ArrayList<Element> {
    public Elements(int i) {
        super(i);
    }

    public Elements(Collection<Element> collection) {
        super(collection);
    }

    public Elements(List<Element> list) {
        super(list);
    }

    public Elements(Element... elementArr) {
        super(Arrays.asList(elementArr));
    }

    private Elements O000000o(String str, boolean z, boolean z2) {
        Elements elements = new Elements();
        Evaluator O000000o = str != null ? QueryParser.O000000o(str) : null;
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            do {
                element = z ? element.O000O00o() : element.O000O0OO();
                if (element == null) {
                    break;
                } else if (O000000o == null) {
                    elements.add(element);
                    continue;
                } else if (element.O000000o(O000000o)) {
                    elements.add(element);
                    continue;
                } else {
                    continue;
                }
            } while (z2);
        }
        return elements;
    }

    public String O000000o(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element.O000OO00(str)) {
                return element.O000O0oo(str);
            }
        }
        return "";
    }

    /* renamed from: O000000o */
    public Elements clone() {
        Elements elements = new Elements(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            elements.add(((Element) it.next()).clone());
        }
        return elements;
    }

    public Elements O000000o(int i) {
        if (size() <= i) {
            return new Elements();
        }
        return new Elements((Element) get(i));
    }

    public Elements O000000o(String str, String str2) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O0000OOo(str, str2);
        }
        return this;
    }

    public Elements O000000o(NodeVisitor nodeVisitor) {
        Validate.O000000o((Object) nodeVisitor);
        NodeTraversor nodeTraversor = new NodeTraversor(nodeVisitor);
        Iterator it = iterator();
        while (it.hasNext()) {
            nodeTraversor.O000000o((Element) it.next());
        }
        return this;
    }

    public String O00000Oo() {
        return size() > 0 ? O0000o0O().O000OOo0() : "";
    }

    public boolean O00000Oo(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((Element) it.next()).O000OO00(str)) {
                return true;
            }
        }
        return false;
    }

    public Elements O00000o(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O00oOooo(str);
        }
        return this;
    }

    public boolean O00000o() {
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((Element) it.next()).O000OO00()) {
                return true;
            }
        }
        return false;
    }

    public String O00000o0() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (stringBuilder.length() != 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(element.O000O0oO());
        }
        return stringBuilder.toString();
    }

    public Elements O00000o0(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O000OO0o(str);
        }
        return this;
    }

    public String O00000oO() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (stringBuilder.length() != 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(element.O000OOo());
        }
        return stringBuilder.toString();
    }

    public Elements O00000oO(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O000O00o(str);
        }
        return this;
    }

    public String O00000oo() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (stringBuilder.length() != 0) {
                stringBuilder.append("\n");
            }
            stringBuilder.append(element.O0000O0o());
        }
        return stringBuilder.toString();
    }

    public Elements O00000oo(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O000O0OO(str);
        }
        return this;
    }

    public Elements O0000O0o() {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O000Ooo0();
        }
        return this;
    }

    public boolean O0000O0o(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((Element) it.next()).O00oOooO(str)) {
                return true;
            }
        }
        return false;
    }

    public Elements O0000OOo() {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O0000ooo();
        }
        return this;
    }

    public Elements O0000OOo(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O000O0Oo(str);
        }
        return this;
    }

    public Elements O0000Oo() {
        return O000000o(null, true, false);
    }

    public Elements O0000Oo(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O00oOoOo(str);
        }
        return this;
    }

    public Elements O0000Oo0() {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O000OoOo();
        }
        return this;
    }

    public Elements O0000Oo0(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O00000oO(str);
        }
        return this;
    }

    public Elements O0000OoO() {
        return O000000o(null, true, true);
    }

    public Elements O0000OoO(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O0000o00(str);
        }
        return this;
    }

    public Elements O0000Ooo() {
        return O000000o(null, false, false);
    }

    public Elements O0000Ooo(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O0000Ooo(str);
        }
        return this;
    }

    public List<FormElement> O0000o() {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element instanceof FormElement) {
                arrayList.add((FormElement) element);
            }
        }
        return arrayList;
    }

    public Elements O0000o(String str) {
        return Selector.O000000o((Collection) this, Selector.O000000o(str, (Iterable) this));
    }

    public Elements O0000o0() {
        Collection linkedHashSet = new LinkedHashSet();
        Iterator it = iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(((Element) it.next()).O0000oOo());
        }
        return new Elements(linkedHashSet);
    }

    public Elements O0000o0(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O000O0o(str);
        }
        return this;
    }

    public Elements O0000o00() {
        return O000000o(null, false, true);
    }

    public Elements O0000o00(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O000O0oO(str);
        }
        return this;
    }

    public Element O0000o0O() {
        return isEmpty() ? null : (Element) get(0);
    }

    public Elements O0000o0O(String str) {
        Validate.O000000o(str);
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).O000O0o0(str);
        }
        return this;
    }

    public Element O0000o0o() {
        return isEmpty() ? null : (Element) get(size() - 1);
    }

    public Elements O0000o0o(String str) {
        return Selector.O000000o(str, (Iterable) this);
    }

    public Elements O0000oO(String str) {
        return O000000o(str, true, false);
    }

    public boolean O0000oO0(String str) {
        Evaluator O000000o = QueryParser.O000000o(str);
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((Element) it.next()).O000000o(O000000o)) {
                return true;
            }
        }
        return false;
    }

    public Elements O0000oOO(String str) {
        return O000000o(str, true, true);
    }

    public Elements O0000oOo(String str) {
        return O000000o(str, false, false);
    }

    public Elements O0000oo0(String str) {
        return O000000o(str, false, true);
    }

    public String toString() {
        return O00000oo();
    }
}
