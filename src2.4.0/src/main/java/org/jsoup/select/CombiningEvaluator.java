package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Element;

abstract class CombiningEvaluator extends Evaluator {
    final ArrayList<Evaluator> O000000o;
    int O00000Oo;

    static final class And extends CombiningEvaluator {
        And(Collection<Evaluator> collection) {
            super(collection);
        }

        And(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }

        public boolean O000000o(Element element, Element element2) {
            for (int i = 0; i < this.O00000Oo; i++) {
                if (!((Evaluator) this.O000000o.get(i)).O000000o(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return StringUtil.O000000o(this.O000000o, " ");
        }
    }

    static final class Or extends CombiningEvaluator {
        Or() {
        }

        Or(Collection<Evaluator> collection) {
            if (this.O00000Oo > 1) {
                this.O000000o.add(new And((Collection) collection));
            } else {
                this.O000000o.addAll(collection);
            }
            O00000Oo();
        }

        Or(Evaluator... evaluatorArr) {
            this(Arrays.asList(evaluatorArr));
        }

        public boolean O000000o(Element element, Element element2) {
            for (int i = 0; i < this.O00000Oo; i++) {
                if (((Evaluator) this.O000000o.get(i)).O000000o(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public void O00000Oo(Evaluator evaluator) {
            this.O000000o.add(evaluator);
            O00000Oo();
        }

        public String toString() {
            return String.format(":or%s", new Object[]{this.O000000o});
        }
    }

    CombiningEvaluator() {
        this.O00000Oo = 0;
        this.O000000o = new ArrayList();
    }

    CombiningEvaluator(Collection<Evaluator> collection) {
        this();
        this.O000000o.addAll(collection);
        O00000Oo();
    }

    /* Access modifiers changed, original: 0000 */
    public Evaluator O000000o() {
        return this.O00000Oo > 0 ? (Evaluator) this.O000000o.get(this.O00000Oo - 1) : null;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Evaluator evaluator) {
        this.O000000o.set(this.O00000Oo - 1, evaluator);
    }

    /* Access modifiers changed, original: 0000 */
    public void O00000Oo() {
        this.O00000Oo = this.O000000o.size();
    }
}
