package org.jsoup.select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.parser.TokenQueue;
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
import org.jsoup.select.Evaluator.ContainsData;
import org.jsoup.select.Evaluator.ContainsOwnText;
import org.jsoup.select.Evaluator.ContainsText;
import org.jsoup.select.Evaluator.Id;
import org.jsoup.select.Evaluator.IndexEquals;
import org.jsoup.select.Evaluator.IndexGreaterThan;
import org.jsoup.select.Evaluator.IndexLessThan;
import org.jsoup.select.Evaluator.IsEmpty;
import org.jsoup.select.Evaluator.IsFirstChild;
import org.jsoup.select.Evaluator.IsFirstOfType;
import org.jsoup.select.Evaluator.IsLastChild;
import org.jsoup.select.Evaluator.IsLastOfType;
import org.jsoup.select.Evaluator.IsNthChild;
import org.jsoup.select.Evaluator.IsNthLastChild;
import org.jsoup.select.Evaluator.IsNthLastOfType;
import org.jsoup.select.Evaluator.IsNthOfType;
import org.jsoup.select.Evaluator.IsOnlyChild;
import org.jsoup.select.Evaluator.IsOnlyOfType;
import org.jsoup.select.Evaluator.IsRoot;
import org.jsoup.select.Evaluator.Matches;
import org.jsoup.select.Evaluator.MatchesOwn;
import org.jsoup.select.Evaluator.Tag;
import org.jsoup.select.Evaluator.TagEndsWith;
import org.jsoup.select.Selector.SelectorParseException;

public class QueryParser {
    private static final String[] O000000o = new String[]{",", ">", "+", "~", " "};
    private static final String[] O00000Oo = new String[]{"=", "!=", "^=", "$=", "*=", "~="};
    private static final Pattern O00000oo = Pattern.compile("((\\+|-)?(\\d+)?)n(\\s*(\\+|-)?\\s*\\d+)?", 2);
    private static final Pattern O0000O0o = Pattern.compile("(\\+|-)?(\\d+)");
    private String O00000o;
    private TokenQueue O00000o0;
    private List<Evaluator> O00000oO = new ArrayList();

    private QueryParser(String str) {
        this.O00000o = str;
        this.O00000o0 = new TokenQueue(str);
    }

    public static Evaluator O000000o(String str) {
        return new QueryParser(str).O000000o();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b2  */
    private void O000000o(char r11) {
        /*
        r10 = this;
        r0 = r10.O00000o0;
        r0.O0000OOo();
        r0 = r10.O00000Oo();
        r0 = O000000o(r0);
        r1 = r10.O00000oO;
        r1 = r1.size();
        r2 = 44;
        r3 = 1;
        r4 = 0;
        if (r1 != r3) goto L_0x0036;
    L_0x0019:
        r1 = r10.O00000oO;
        r1 = r1.get(r4);
        r1 = (org.jsoup.select.Evaluator) r1;
        r5 = r1 instanceof org.jsoup.select.CombiningEvaluator.Or;
        if (r5 == 0) goto L_0x0033;
    L_0x0025:
        if (r11 == r2) goto L_0x0033;
    L_0x0027:
        r5 = r1;
        r5 = (org.jsoup.select.CombiningEvaluator.Or) r5;
        r5 = r5.O000000o();
        r6 = r3;
        r9 = r5;
        r5 = r1;
        r1 = r9;
        goto L_0x003e;
    L_0x0033:
        r5 = r1;
        r6 = r4;
        goto L_0x003e;
    L_0x0036:
        r1 = new org.jsoup.select.CombiningEvaluator$And;
        r5 = r10.O00000oO;
        r1.<init>(r5);
        goto L_0x0033;
    L_0x003e:
        r7 = r10.O00000oO;
        r7.clear();
        r7 = 62;
        r8 = 2;
        if (r11 != r7) goto L_0x0059;
    L_0x0048:
        r11 = new org.jsoup.select.CombiningEvaluator$And;
        r2 = new org.jsoup.select.Evaluator[r8];
        r2[r4] = r0;
        r0 = new org.jsoup.select.StructuralEvaluator$ImmediateParent;
        r0.<init>(r1);
        r2[r3] = r0;
        r11.<init>(r2);
        goto L_0x00b0;
    L_0x0059:
        r7 = 32;
        if (r11 != r7) goto L_0x006e;
    L_0x005d:
        r11 = new org.jsoup.select.CombiningEvaluator$And;
        r2 = new org.jsoup.select.Evaluator[r8];
        r2[r4] = r0;
        r0 = new org.jsoup.select.StructuralEvaluator$Parent;
        r0.<init>(r1);
        r2[r3] = r0;
        r11.<init>(r2);
        goto L_0x00b0;
    L_0x006e:
        r7 = 43;
        if (r11 != r7) goto L_0x0083;
    L_0x0072:
        r11 = new org.jsoup.select.CombiningEvaluator$And;
        r2 = new org.jsoup.select.Evaluator[r8];
        r2[r4] = r0;
        r0 = new org.jsoup.select.StructuralEvaluator$ImmediatePreviousSibling;
        r0.<init>(r1);
        r2[r3] = r0;
        r11.<init>(r2);
        goto L_0x00b0;
    L_0x0083:
        r7 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
        if (r11 != r7) goto L_0x0098;
    L_0x0087:
        r11 = new org.jsoup.select.CombiningEvaluator$And;
        r2 = new org.jsoup.select.Evaluator[r8];
        r2[r4] = r0;
        r0 = new org.jsoup.select.StructuralEvaluator$PreviousSibling;
        r0.<init>(r1);
        r2[r3] = r0;
        r11.<init>(r2);
        goto L_0x00b0;
    L_0x0098:
        if (r11 != r2) goto L_0x00bf;
    L_0x009a:
        r11 = r1 instanceof org.jsoup.select.CombiningEvaluator.Or;
        if (r11 == 0) goto L_0x00a5;
    L_0x009e:
        r1 = (org.jsoup.select.CombiningEvaluator.Or) r1;
        r1.O00000Oo(r0);
        r11 = r1;
        goto L_0x00b0;
    L_0x00a5:
        r11 = new org.jsoup.select.CombiningEvaluator$Or;
        r11.<init>();
        r11.O00000Oo(r1);
        r11.O00000Oo(r0);
    L_0x00b0:
        if (r6 == 0) goto L_0x00b9;
    L_0x00b2:
        r0 = r5;
        r0 = (org.jsoup.select.CombiningEvaluator.Or) r0;
        r0.O000000o(r11);
        r11 = r5;
    L_0x00b9:
        r0 = r10.O00000oO;
        r0.add(r11);
        return;
    L_0x00bf:
        r0 = new org.jsoup.select.Selector$SelectorParseException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unknown combinator: ";
        r1.append(r2);
        r1.append(r11);
        r11 = r1.toString();
        r1 = new java.lang.Object[r4];
        r0.<init>(r11, r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.select.QueryParser.O000000o(char):void");
    }

    private void O000000o(boolean z) {
        this.O00000o0.O00000oO(z ? ":containsOwn" : ":contains");
        String O0000Oo = TokenQueue.O0000Oo(this.O00000o0.O000000o('(', ')'));
        Validate.O000000o(O0000Oo, ":contains(text) query must not be empty");
        if (z) {
            this.O00000oO.add(new ContainsOwnText(O0000Oo));
        } else {
            this.O00000oO.add(new ContainsText(O0000Oo));
        }
    }

    private void O000000o(boolean z, boolean z2) {
        String toLowerCase = this.O00000o0.O0000OOo(")").trim().toLowerCase();
        Matcher matcher = O00000oo.matcher(toLowerCase);
        Matcher matcher2 = O0000O0o.matcher(toLowerCase);
        int i = 2;
        int i2 = 0;
        if ("odd".equals(toLowerCase)) {
            i2 = 1;
        } else if (!"even".equals(toLowerCase)) {
            int parseInt;
            if (matcher.matches()) {
                i = matcher.group(3) != null ? Integer.parseInt(matcher.group(1).replaceFirst("^\\+", "")) : 1;
                if (matcher.group(4) != null) {
                    parseInt = Integer.parseInt(matcher.group(4).replaceFirst("^\\+", ""));
                }
            } else if (matcher2.matches()) {
                parseInt = Integer.parseInt(matcher2.group().replaceFirst("^\\+", ""));
                i = 0;
            } else {
                throw new SelectorParseException("Could not parse nth-index '%s': unexpected format", toLowerCase);
            }
            i2 = parseInt;
        }
        if (z2) {
            if (z) {
                this.O00000oO.add(new IsNthLastOfType(i, i2));
            } else {
                this.O00000oO.add(new IsNthOfType(i, i2));
            }
        } else if (z) {
            this.O00000oO.add(new IsNthLastChild(i, i2));
        } else {
            this.O00000oO.add(new IsNthChild(i, i2));
        }
    }

    private String O00000Oo() {
        StringBuilder stringBuilder = new StringBuilder();
        while (!this.O00000o0.O000000o()) {
            if (this.O00000o0.O00000Oo("(")) {
                stringBuilder.append("(");
                stringBuilder.append(this.O00000o0.O000000o('(', ')'));
                stringBuilder.append(")");
            } else if (this.O00000o0.O00000Oo("[")) {
                stringBuilder.append("[");
                stringBuilder.append(this.O00000o0.O000000o('[', ']'));
                stringBuilder.append("]");
            } else if (this.O00000o0.O000000o(O000000o)) {
                break;
            } else {
                stringBuilder.append(this.O00000o0.O0000O0o());
            }
        }
        return stringBuilder.toString();
    }

    private void O00000Oo(boolean z) {
        this.O00000o0.O00000oO(z ? ":matchesOwn" : ":matches");
        String O000000o = this.O00000o0.O000000o('(', ')');
        Validate.O000000o(O000000o, ":matches(regex) query must not be empty");
        if (z) {
            this.O00000oO.add(new MatchesOwn(Pattern.compile(O000000o)));
        } else {
            this.O00000oO.add(new Matches(Pattern.compile(O000000o)));
        }
    }

    private void O00000o() {
        String O0000Ooo = this.O00000o0.O0000Ooo();
        Validate.O000000o(O0000Ooo);
        this.O00000oO.add(new Id(O0000Ooo));
    }

    private void O00000o0() {
        if (this.O00000o0.O00000o("#")) {
            O00000o();
        } else if (this.O00000o0.O00000o(".")) {
            O00000oO();
        } else if (this.O00000o0.O00000oO() || this.O00000o0.O00000Oo("*|")) {
            O00000oo();
        } else if (this.O00000o0.O00000Oo("[")) {
            O0000O0o();
        } else if (this.O00000o0.O00000o("*")) {
            O0000OOo();
        } else if (this.O00000o0.O00000o(":lt(")) {
            O0000Oo0();
        } else if (this.O00000o0.O00000o(":gt(")) {
            O0000Oo();
        } else if (this.O00000o0.O00000o(":eq(")) {
            O0000OoO();
        } else if (this.O00000o0.O00000Oo(":has(")) {
            O0000o00();
        } else if (this.O00000o0.O00000Oo(":contains(")) {
            O000000o(false);
        } else if (this.O00000o0.O00000Oo(":containsOwn(")) {
            O000000o(true);
        } else if (this.O00000o0.O00000Oo(":containsData(")) {
            O0000o0();
        } else if (this.O00000o0.O00000Oo(":matches(")) {
            O00000Oo(false);
        } else if (this.O00000o0.O00000Oo(":matchesOwn(")) {
            O00000Oo(true);
        } else if (this.O00000o0.O00000Oo(":not(")) {
            O0000o0O();
        } else if (this.O00000o0.O00000o(":nth-child(")) {
            O000000o(false, false);
        } else if (this.O00000o0.O00000o(":nth-last-child(")) {
            O000000o(true, false);
        } else if (this.O00000o0.O00000o(":nth-of-type(")) {
            O000000o(false, true);
        } else if (this.O00000o0.O00000o(":nth-last-of-type(")) {
            O000000o(true, true);
        } else if (this.O00000o0.O00000o(":first-child")) {
            this.O00000oO.add(new IsFirstChild());
        } else if (this.O00000o0.O00000o(":last-child")) {
            this.O00000oO.add(new IsLastChild());
        } else if (this.O00000o0.O00000o(":first-of-type")) {
            this.O00000oO.add(new IsFirstOfType());
        } else if (this.O00000o0.O00000o(":last-of-type")) {
            this.O00000oO.add(new IsLastOfType());
        } else if (this.O00000o0.O00000o(":only-child")) {
            this.O00000oO.add(new IsOnlyChild());
        } else if (this.O00000o0.O00000o(":only-of-type")) {
            this.O00000oO.add(new IsOnlyOfType());
        } else if (this.O00000o0.O00000o(":empty")) {
            this.O00000oO.add(new IsEmpty());
        } else if (this.O00000o0.O00000o(":root")) {
            this.O00000oO.add(new IsRoot());
        } else {
            throw new SelectorParseException("Could not parse query '%s': unexpected token at '%s'", this.O00000o, this.O00000o0.O0000o0());
        }
    }

    private void O00000oO() {
        String O0000Ooo = this.O00000o0.O0000Ooo();
        Validate.O000000o(O0000Ooo);
        this.O00000oO.add(new Class(O0000Ooo.trim()));
    }

    private void O00000oo() {
        String O0000OoO = this.O00000o0.O0000OoO();
        Validate.O000000o(O0000OoO);
        if (O0000OoO.startsWith("*|")) {
            this.O00000oO.add(new Or(new Tag(O0000OoO.trim().toLowerCase()), new TagEndsWith(O0000OoO.replace("*|", ":").trim().toLowerCase())));
            return;
        }
        if (O0000OoO.contains("|")) {
            O0000OoO = O0000OoO.replace("|", ":");
        }
        this.O00000oO.add(new Tag(O0000OoO.trim()));
    }

    private void O0000O0o() {
        TokenQueue tokenQueue = new TokenQueue(this.O00000o0.O000000o('[', ']'));
        String O00000Oo = tokenQueue.O00000Oo(O00000Oo);
        Validate.O000000o(O00000Oo);
        tokenQueue.O0000OOo();
        if (tokenQueue.O000000o()) {
            if (O00000Oo.startsWith("^")) {
                this.O00000oO.add(new AttributeStarting(O00000Oo.substring(1)));
            } else {
                this.O00000oO.add(new Attribute(O00000Oo));
            }
        } else if (tokenQueue.O00000o("=")) {
            this.O00000oO.add(new AttributeWithValue(O00000Oo, tokenQueue.O0000o0()));
        } else if (tokenQueue.O00000o("!=")) {
            this.O00000oO.add(new AttributeWithValueNot(O00000Oo, tokenQueue.O0000o0()));
        } else if (tokenQueue.O00000o("^=")) {
            this.O00000oO.add(new AttributeWithValueStarting(O00000Oo, tokenQueue.O0000o0()));
        } else if (tokenQueue.O00000o("$=")) {
            this.O00000oO.add(new AttributeWithValueEnding(O00000Oo, tokenQueue.O0000o0()));
        } else if (tokenQueue.O00000o("*=")) {
            this.O00000oO.add(new AttributeWithValueContaining(O00000Oo, tokenQueue.O0000o0()));
        } else if (tokenQueue.O00000o("~=")) {
            this.O00000oO.add(new AttributeWithValueMatching(O00000Oo, Pattern.compile(tokenQueue.O0000o0())));
        } else {
            throw new SelectorParseException("Could not parse attribute query '%s': unexpected token at '%s'", this.O00000o, tokenQueue.O0000o0());
        }
    }

    private void O0000OOo() {
        this.O00000oO.add(new AllElements());
    }

    private void O0000Oo() {
        this.O00000oO.add(new IndexGreaterThan(O0000Ooo()));
    }

    private void O0000Oo0() {
        this.O00000oO.add(new IndexLessThan(O0000Ooo()));
    }

    private void O0000OoO() {
        this.O00000oO.add(new IndexEquals(O0000Ooo()));
    }

    private int O0000Ooo() {
        String trim = this.O00000o0.O0000OOo(")").trim();
        Validate.O000000o(StringUtil.O00000Oo(trim), "Index must be numeric");
        return Integer.parseInt(trim);
    }

    private void O0000o0() {
        this.O00000o0.O00000oO(":containsData");
        String O0000Oo = TokenQueue.O0000Oo(this.O00000o0.O000000o('(', ')'));
        Validate.O000000o(O0000Oo, ":containsData(text) query must not be empty");
        this.O00000oO.add(new ContainsData(O0000Oo));
    }

    private void O0000o00() {
        this.O00000o0.O00000oO(":has");
        String O000000o = this.O00000o0.O000000o('(', ')');
        Validate.O000000o(O000000o, ":has(el) subselect must not be empty");
        this.O00000oO.add(new Has(O000000o(O000000o)));
    }

    private void O0000o0O() {
        this.O00000o0.O00000oO(":not");
        String O000000o = this.O00000o0.O000000o('(', ')');
        Validate.O000000o(O000000o, ":not(selector) subselect must not be empty");
        this.O00000oO.add(new Not(O000000o(O000000o)));
    }

    /* Access modifiers changed, original: 0000 */
    public Evaluator O000000o() {
        this.O00000o0.O0000OOo();
        if (this.O00000o0.O000000o(O000000o)) {
            this.O00000oO.add(new Root());
            O000000o(this.O00000o0.O0000O0o());
        } else {
            O00000o0();
        }
        while (!this.O00000o0.O000000o()) {
            boolean O0000OOo = this.O00000o0.O0000OOo();
            if (this.O00000o0.O000000o(O000000o)) {
                O000000o(this.O00000o0.O0000O0o());
            } else if (O0000OOo) {
                O000000o(' ');
            } else {
                O00000o0();
            }
        }
        return this.O00000oO.size() == 1 ? (Evaluator) this.O00000oO.get(0) : new And(this.O00000oO);
    }
}
