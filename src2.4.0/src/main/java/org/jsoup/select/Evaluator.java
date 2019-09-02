package org.jsoup.select;

import java.util.Iterator;
import java.util.regex.Pattern;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.XmlDeclaration;

public abstract class Evaluator {

    public static final class AllElements extends Evaluator {
        public boolean O000000o(Element element, Element element2) {
            return true;
        }

        public String toString() {
            return "*";
        }
    }

    public static final class Attribute extends Evaluator {
        private String O000000o;

        public Attribute(String str) {
            this.O000000o = str;
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O000OO00(this.O000000o);
        }

        public String toString() {
            return String.format("[%s]", new Object[]{this.O000000o});
        }
    }

    public static abstract class AttributeKeyPair extends Evaluator {
        String O000000o;
        String O00000Oo;

        public AttributeKeyPair(String str, String str2) {
            Validate.O000000o(str);
            Validate.O000000o(str2);
            this.O000000o = str.trim().toLowerCase();
            if ((str2.startsWith("\"") && str2.endsWith("\"")) || (str2.startsWith("'") && str2.endsWith("'"))) {
                str2 = str2.substring(1, str2.length() - 1);
            }
            this.O00000Oo = str2.trim().toLowerCase();
        }
    }

    public static final class AttributeStarting extends Evaluator {
        private String O000000o;

        public AttributeStarting(String str) {
            Validate.O000000o(str);
            this.O000000o = str.toLowerCase();
        }

        public boolean O000000o(Element element, Element element2) {
            for (org.jsoup.nodes.Attribute O000000o : element2.O000OOoo().O00000Oo()) {
                if (O000000o.getKey().toLowerCase().startsWith(this.O000000o)) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return String.format("[^%s]", new Object[]{this.O000000o});
        }
    }

    public static final class AttributeWithValue extends AttributeKeyPair {
        public AttributeWithValue(String str, String str2) {
            super(str, str2);
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O000OO00(this.O000000o) && this.O00000Oo.equalsIgnoreCase(element2.O000O0oo(this.O000000o).trim());
        }

        public String toString() {
            return String.format("[%s=%s]", new Object[]{this.O000000o, this.O00000Oo});
        }
    }

    public static final class AttributeWithValueContaining extends AttributeKeyPair {
        public AttributeWithValueContaining(String str, String str2) {
            super(str, str2);
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O000OO00(this.O000000o) && element2.O000O0oo(this.O000000o).toLowerCase().contains(this.O00000Oo);
        }

        public String toString() {
            return String.format("[%s*=%s]", new Object[]{this.O000000o, this.O00000Oo});
        }
    }

    public static final class AttributeWithValueEnding extends AttributeKeyPair {
        public AttributeWithValueEnding(String str, String str2) {
            super(str, str2);
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O000OO00(this.O000000o) && element2.O000O0oo(this.O000000o).toLowerCase().endsWith(this.O00000Oo);
        }

        public String toString() {
            return String.format("[%s$=%s]", new Object[]{this.O000000o, this.O00000Oo});
        }
    }

    public static final class AttributeWithValueMatching extends Evaluator {
        String O000000o;
        Pattern O00000Oo;

        public AttributeWithValueMatching(String str, Pattern pattern) {
            this.O000000o = str.trim().toLowerCase();
            this.O00000Oo = pattern;
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O000OO00(this.O000000o) && this.O00000Oo.matcher(element2.O000O0oo(this.O000000o)).find();
        }

        public String toString() {
            return String.format("[%s~=%s]", new Object[]{this.O000000o, this.O00000Oo.toString()});
        }
    }

    public static final class AttributeWithValueNot extends AttributeKeyPair {
        public AttributeWithValueNot(String str, String str2) {
            super(str, str2);
        }

        public boolean O000000o(Element element, Element element2) {
            return this.O00000Oo.equalsIgnoreCase(element2.O000O0oo(this.O000000o)) ^ 1;
        }

        public String toString() {
            return String.format("[%s!=%s]", new Object[]{this.O000000o, this.O00000Oo});
        }
    }

    public static final class AttributeWithValueStarting extends AttributeKeyPair {
        public AttributeWithValueStarting(String str, String str2) {
            super(str, str2);
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O000OO00(this.O000000o) && element2.O000O0oo(this.O000000o).toLowerCase().startsWith(this.O00000Oo);
        }

        public String toString() {
            return String.format("[%s^=%s]", new Object[]{this.O000000o, this.O00000Oo});
        }
    }

    public static final class Class extends Evaluator {
        private String O000000o;

        public Class(String str) {
            this.O000000o = str;
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O00oOooO(this.O000000o);
        }

        public String toString() {
            return String.format(".%s", new Object[]{this.O000000o});
        }
    }

    public static final class ContainsData extends Evaluator {
        private String O000000o;

        public ContainsData(String str) {
            this.O000000o = str.toLowerCase();
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O000OO0o().toLowerCase().contains(this.O000000o);
        }

        public String toString() {
            return String.format(":containsData(%s)", new Object[]{this.O000000o});
        }
    }

    public static final class ContainsOwnText extends Evaluator {
        private String O000000o;

        public ContainsOwnText(String str) {
            this.O000000o = str.toLowerCase();
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O000O0oo().toLowerCase().contains(this.O000000o);
        }

        public String toString() {
            return String.format(":containsOwn(%s)", new Object[]{this.O000000o});
        }
    }

    public static final class ContainsText extends Evaluator {
        private String O000000o;

        public ContainsText(String str) {
            this.O000000o = str.toLowerCase();
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O000O0oO().toLowerCase().contains(this.O000000o);
        }

        public String toString() {
            return String.format(":contains(%s)", new Object[]{this.O000000o});
        }
    }

    public static abstract class CssNthEvaluator extends Evaluator {
        protected final int O000000o;
        protected final int O00000Oo;

        public CssNthEvaluator(int i) {
            this(0, i);
        }

        public CssNthEvaluator(int i, int i2) {
            this.O000000o = i;
            this.O00000Oo = i2;
        }

        public abstract String O000000o();

        public boolean O000000o(Element element, Element element2) {
            Element O0000oOO = element2.O000OOoO();
            if (O0000oOO == null || (O0000oOO instanceof Document)) {
                return false;
            }
            int O00000Oo = O00000Oo(element, element2);
            boolean z = true;
            if (this.O000000o == 0) {
                if (O00000Oo != this.O00000Oo) {
                    z = false;
                }
                return z;
            }
            if ((O00000Oo - this.O00000Oo) * this.O000000o < 0 || (O00000Oo - this.O00000Oo) % this.O000000o != 0) {
                z = false;
            }
            return z;
        }

        public abstract int O00000Oo(Element element, Element element2);

        public String toString() {
            if (this.O000000o == 0) {
                return String.format(":%s(%d)", new Object[]{O000000o(), Integer.valueOf(this.O00000Oo)});
            } else if (this.O00000Oo == 0) {
                return String.format(":%s(%dn)", new Object[]{O000000o(), Integer.valueOf(this.O000000o)});
            } else {
                return String.format(":%s(%dn%+d)", new Object[]{O000000o(), Integer.valueOf(this.O000000o), Integer.valueOf(this.O00000Oo)});
            }
        }
    }

    public static final class Id extends Evaluator {
        private String O000000o;

        public Id(String str) {
            this.O000000o = str;
        }

        public boolean O000000o(Element element, Element element2) {
            return this.O000000o.equals(element2.O0000oO0());
        }

        public String toString() {
            return String.format("#%s", new Object[]{this.O000000o});
        }
    }

    public static abstract class IndexEvaluator extends Evaluator {
        int O000000o;

        public IndexEvaluator(int i) {
            this.O000000o = i;
        }
    }

    public static final class IndexEquals extends IndexEvaluator {
        public IndexEquals(int i) {
            super(i);
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O00oOoOo().intValue() == this.O000000o;
        }

        public String toString() {
            return String.format(":eq(%d)", new Object[]{Integer.valueOf(this.O000000o)});
        }
    }

    public static final class IndexGreaterThan extends IndexEvaluator {
        public IndexGreaterThan(int i) {
            super(i);
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O00oOoOo().intValue() > this.O000000o;
        }

        public String toString() {
            return String.format(":gt(%d)", new Object[]{Integer.valueOf(this.O000000o)});
        }
    }

    public static final class IndexLessThan extends IndexEvaluator {
        public IndexLessThan(int i) {
            super(i);
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O00oOoOo().intValue() < this.O000000o;
        }

        public String toString() {
            return String.format(":lt(%d)", new Object[]{Integer.valueOf(this.O000000o)});
        }
    }

    public static final class IsEmpty extends Evaluator {
        public boolean O000000o(Element element, Element element2) {
            for (Node node : element2.O000Oo0()) {
                if (!(node instanceof Comment) && !(node instanceof XmlDeclaration) && !(node instanceof DocumentType)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return ":empty";
        }
    }

    public static final class IsFirstChild extends Evaluator {
        public boolean O000000o(Element element, Element element2) {
            element = element2.O000OOoO();
            return (element == null || (element instanceof Document) || element2.O00oOoOo().intValue() != 0) ? false : true;
        }

        public String toString() {
            return ":first-child";
        }
    }

    public static class IsNthOfType extends CssNthEvaluator {
        public IsNthOfType(int i, int i2) {
            super(i, i2);
        }

        /* Access modifiers changed, original: protected */
        public String O000000o() {
            return "nth-of-type";
        }

        /* Access modifiers changed, original: protected */
        public int O00000Oo(Element element, Element element2) {
            Iterator it = element2.O000OOoO().O0000oo0().iterator();
            int i = 0;
            while (it.hasNext()) {
                Element element3 = (Element) it.next();
                if (element3.O0000o0o().equals(element2.O0000o0o())) {
                    i++;
                    continue;
                }
                if (element3 == element2) {
                    break;
                }
            }
            return i;
        }
    }

    public static final class IsFirstOfType extends IsNthOfType {
        public IsFirstOfType() {
            super(0, 1);
        }

        public String toString() {
            return ":first-of-type";
        }
    }

    public static final class IsLastChild extends Evaluator {
        public boolean O000000o(Element element, Element element2) {
            element = element2.O000OOoO();
            return (element == null || (element instanceof Document) || element2.O00oOoOo().intValue() != element.O0000oo0().size() - 1) ? false : true;
        }

        public String toString() {
            return ":last-child";
        }
    }

    public static class IsNthLastOfType extends CssNthEvaluator {
        public IsNthLastOfType(int i, int i2) {
            super(i, i2);
        }

        /* Access modifiers changed, original: protected */
        public String O000000o() {
            return "nth-last-of-type";
        }

        /* Access modifiers changed, original: protected */
        public int O00000Oo(Element element, Element element2) {
            Elements O0000oo0 = element2.O000OOoO().O0000oo0();
            int i = 0;
            for (int intValue = element2.O00oOoOo().intValue(); intValue < O0000oo0.size(); intValue++) {
                if (((Element) O0000oo0.get(intValue)).O0000o0o().equals(element2.O0000o0o())) {
                    i++;
                }
            }
            return i;
        }
    }

    public static final class IsLastOfType extends IsNthLastOfType {
        public IsLastOfType() {
            super(0, 1);
        }

        public String toString() {
            return ":last-of-type";
        }
    }

    public static final class IsNthChild extends CssNthEvaluator {
        public IsNthChild(int i, int i2) {
            super(i, i2);
        }

        /* Access modifiers changed, original: protected */
        public String O000000o() {
            return "nth-child";
        }

        /* Access modifiers changed, original: protected */
        public int O00000Oo(Element element, Element element2) {
            return element2.O00oOoOo().intValue() + 1;
        }
    }

    public static final class IsNthLastChild extends CssNthEvaluator {
        public IsNthLastChild(int i, int i2) {
            super(i, i2);
        }

        /* Access modifiers changed, original: protected */
        public String O000000o() {
            return "nth-last-child";
        }

        /* Access modifiers changed, original: protected */
        public int O00000Oo(Element element, Element element2) {
            return element2.O000OOoO().O0000oo0().size() - element2.O00oOoOo().intValue();
        }
    }

    public static final class IsOnlyChild extends Evaluator {
        public boolean O000000o(Element element, Element element2) {
            element = element2.O000OOoO();
            return (element == null || (element instanceof Document) || element2.O00oOooo().size() != 0) ? false : true;
        }

        public String toString() {
            return ":only-child";
        }
    }

    public static final class IsOnlyOfType extends Evaluator {
        public boolean O000000o(Element element, Element element2) {
            element = element2.O000OOoO();
            if (element == null || (element instanceof Document)) {
                return false;
            }
            Iterator it = element.O0000oo0().iterator();
            int i = 0;
            while (it.hasNext()) {
                if (((Element) it.next()).O0000o0o().equals(element2.O0000o0o())) {
                    i++;
                }
            }
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            return z;
        }

        public String toString() {
            return ":only-of-type";
        }
    }

    public static final class IsRoot extends Evaluator {
        public boolean O000000o(Element element, Element element2) {
            if (element instanceof Document) {
                element = element.O000000o(0);
            }
            return element2 == element;
        }

        public String toString() {
            return ":root";
        }
    }

    public static final class Matches extends Evaluator {
        private Pattern O000000o;

        public Matches(Pattern pattern) {
            this.O000000o = pattern;
        }

        public boolean O000000o(Element element, Element element2) {
            return this.O000000o.matcher(element2.O000O0oO()).find();
        }

        public String toString() {
            return String.format(":matches(%s)", new Object[]{this.O000000o});
        }
    }

    public static final class MatchesOwn extends Evaluator {
        private Pattern O000000o;

        public MatchesOwn(Pattern pattern) {
            this.O000000o = pattern;
        }

        public boolean O000000o(Element element, Element element2) {
            return this.O000000o.matcher(element2.O000O0oo()).find();
        }

        public String toString() {
            return String.format(":matchesOwn(%s)", new Object[]{this.O000000o});
        }
    }

    public static final class Tag extends Evaluator {
        private String O000000o;

        public Tag(String str) {
            this.O000000o = str;
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O0000o0O().equalsIgnoreCase(this.O000000o);
        }

        public String toString() {
            return String.format("%s", new Object[]{this.O000000o});
        }
    }

    public static final class TagEndsWith extends Evaluator {
        private String O000000o;

        public TagEndsWith(String str) {
            this.O000000o = str;
        }

        public boolean O000000o(Element element, Element element2) {
            return element2.O0000o0O().endsWith(this.O000000o);
        }

        public String toString() {
            return String.format("%s", new Object[]{this.O000000o});
        }
    }

    protected Evaluator() {
    }

    public abstract boolean O000000o(Element element, Element element2);
}
