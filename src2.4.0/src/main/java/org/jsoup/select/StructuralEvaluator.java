package org.jsoup.select;

import java.util.Iterator;
import org.jsoup.nodes.Element;

abstract class StructuralEvaluator extends Evaluator {
    Evaluator O000000o;

    static class Has extends StructuralEvaluator {
        public Has(Evaluator evaluator) {
            this.O000000o = evaluator;
        }

        public boolean O000000o(Element element, Element element2) {
            Iterator it = element2.O000O0o().iterator();
            while (it.hasNext()) {
                Element element3 = (Element) it.next();
                if (element3 != element2 && this.O000000o.O000000o(element, element3)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":has(%s)", new Object[]{this.O000000o});
        }
    }

    static class ImmediateParent extends StructuralEvaluator {
        public ImmediateParent(Evaluator evaluator) {
            this.O000000o = evaluator;
        }

        public boolean O000000o(Element element, Element element2) {
            boolean z = false;
            if (element == element2) {
                return false;
            }
            element2 = element2.O000OOoO();
            if (element2 != null && this.O000000o.O000000o(element, element2)) {
                z = true;
            }
            return z;
        }

        public String toString() {
            return String.format(":ImmediateParent%s", new Object[]{this.O000000o});
        }
    }

    static class ImmediatePreviousSibling extends StructuralEvaluator {
        public ImmediatePreviousSibling(Evaluator evaluator) {
            this.O000000o = evaluator;
        }

        public boolean O000000o(Element element, Element element2) {
            boolean z = false;
            if (element == element2) {
                return false;
            }
            element2 = element2.O000O0OO();
            if (element2 != null && this.O000000o.O000000o(element, element2)) {
                z = true;
            }
            return z;
        }

        public String toString() {
            return String.format(":prev%s", new Object[]{this.O000000o});
        }
    }

    static class Not extends StructuralEvaluator {
        public Not(Evaluator evaluator) {
            this.O000000o = evaluator;
        }

        public boolean O000000o(Element element, Element element2) {
            return this.O000000o.O000000o(element, element2) ^ 1;
        }

        public String toString() {
            return String.format(":not%s", new Object[]{this.O000000o});
        }
    }

    static class Parent extends StructuralEvaluator {
        public Parent(Evaluator evaluator) {
            this.O000000o = evaluator;
        }

        public boolean O000000o(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (element2 = element2.O000OOoO(); !this.O000000o.O000000o(element, element2); element2 = element2.O000OOoO()) {
                if (element2 == element) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return String.format(":parent%s", new Object[]{this.O000000o});
        }
    }

    static class PreviousSibling extends StructuralEvaluator {
        public PreviousSibling(Evaluator evaluator) {
            this.O000000o = evaluator;
        }

        public boolean O000000o(Element element, Element element2) {
            if (element == element2) {
                return false;
            }
            for (element2 = element2.O000O0OO(); element2 != null; element2 = element2.O000O0OO()) {
                if (this.O000000o.O000000o(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format(":prev*%s", new Object[]{this.O000000o});
        }
    }

    static class Root extends Evaluator {
        Root() {
        }

        public boolean O000000o(Element element, Element element2) {
            return element == element2;
        }
    }

    StructuralEvaluator() {
    }
}
