package org.jsoup.select;

import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class Collector {

    private static class Accumulator implements NodeVisitor {
        private final Element O000000o;
        private final Elements O00000Oo;
        private final Evaluator O00000o0;

        Accumulator(Element element, Elements elements, Evaluator evaluator) {
            this.O000000o = element;
            this.O00000Oo = elements;
            this.O00000o0 = evaluator;
        }

        public void O000000o(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (this.O00000o0.O000000o(this.O000000o, element)) {
                    this.O00000Oo.add(element);
                }
            }
        }

        public void O00000Oo(Node node, int i) {
        }
    }

    private Collector() {
    }

    public static Elements O000000o(Evaluator evaluator, Element element) {
        Elements elements = new Elements();
        new NodeTraversor(new Accumulator(element, elements, evaluator)).O000000o(element);
        return elements;
    }
}
