package org.jsoup.select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;

public class Selector {
    private final Evaluator O000000o;
    private final Element O00000Oo;

    public static class SelectorParseException extends IllegalStateException {
        public SelectorParseException(String str, Object... objArr) {
            super(String.format(str, objArr));
        }
    }

    private Selector(String str, Element element) {
        Validate.O000000o((Object) str);
        str = str.trim();
        Validate.O000000o(str);
        Validate.O000000o((Object) element);
        this.O000000o = QueryParser.O000000o(str);
        this.O00000Oo = element;
    }

    private Selector(Evaluator evaluator, Element element) {
        Validate.O000000o((Object) evaluator);
        Validate.O000000o((Object) element);
        this.O000000o = evaluator;
        this.O00000Oo = element;
    }

    private Elements O000000o() {
        return Collector.O000000o(this.O000000o, this.O00000Oo);
    }

    public static Elements O000000o(String str, Iterable<Element> iterable) {
        Validate.O000000o(str);
        Validate.O000000o((Object) iterable);
        Evaluator O000000o = QueryParser.O000000o(str);
        List arrayList = new ArrayList();
        IdentityHashMap identityHashMap = new IdentityHashMap();
        for (Element O000000o2 : iterable) {
            Iterator it = O000000o(O000000o, O000000o2).iterator();
            while (it.hasNext()) {
                Element element = (Element) it.next();
                if (!identityHashMap.containsKey(element)) {
                    arrayList.add(element);
                    identityHashMap.put(element, Boolean.TRUE);
                }
            }
        }
        return new Elements(arrayList);
    }

    public static Elements O000000o(String str, Element element) {
        return new Selector(str, element).O000000o();
    }

    static Elements O000000o(Collection<Element> collection, Collection<Element> collection2) {
        Elements elements = new Elements();
        for (Element element : collection) {
            Object obj = null;
            for (Element equals : collection2) {
                if (element.equals(equals)) {
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                elements.add(element);
            }
        }
        return elements;
    }

    public static Elements O000000o(Evaluator evaluator, Element element) {
        return new Selector(evaluator, element).O000000o();
    }
}
