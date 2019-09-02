package org.jsoup.examples;

import com.umeng.commonsdk.proguard.e;
import defpackage.db;
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;

public class HtmlToPlainText {
    private static final String O000000o = "Mozilla/5.0 (jsoup)";
    private static final int O00000Oo = 5000;

    private class FormattingVisitor implements NodeVisitor {
        private static final int O00000Oo = 80;
        private StringBuilder O00000o;
        private int O00000o0;

        private FormattingVisitor() {
            this.O00000o0 = 0;
            this.O00000o = new StringBuilder();
        }

        /* JADX WARNING: Missing block: B:8:0x0038, code skipped:
            if (org.jsoup.helper.StringUtil.O000000o(r7.O00000o.substring(r7.O00000o.length() - 1), " ", "\n") != false) goto L_0x003a;
     */
        private void O000000o(java.lang.String r8) {
            /*
            r7 = this;
            r0 = "\n";
            r0 = r8.startsWith(r0);
            r1 = 0;
            if (r0 == 0) goto L_0x000b;
        L_0x0009:
            r7.O00000o0 = r1;
        L_0x000b:
            r0 = " ";
            r0 = r8.equals(r0);
            r2 = 1;
            if (r0 == 0) goto L_0x003b;
        L_0x0014:
            r0 = r7.O00000o;
            r0 = r0.length();
            if (r0 == 0) goto L_0x003a;
        L_0x001c:
            r0 = r7.O00000o;
            r3 = r7.O00000o;
            r3 = r3.length();
            r3 = r3 - r2;
            r0 = r0.substring(r3);
            r3 = 2;
            r3 = new java.lang.String[r3];
            r4 = " ";
            r3[r1] = r4;
            r4 = "\n";
            r3[r2] = r4;
            r0 = org.jsoup.helper.StringUtil.O000000o(r0, r3);
            if (r0 == 0) goto L_0x003b;
        L_0x003a:
            return;
        L_0x003b:
            r0 = r8.length();
            r3 = r7.O00000o0;
            r0 = r0 + r3;
            r3 = 80;
            if (r0 <= r3) goto L_0x0097;
        L_0x0046:
            r0 = "\\s+";
            r8 = r8.split(r0);
            r0 = r1;
        L_0x004d:
            r4 = r8.length;
            if (r0 >= r4) goto L_0x00a5;
        L_0x0050:
            r4 = r8[r0];
            r5 = r8.length;
            r5 = r5 - r2;
            if (r0 != r5) goto L_0x0058;
        L_0x0056:
            r5 = r2;
            goto L_0x0059;
        L_0x0058:
            r5 = r1;
        L_0x0059:
            if (r5 != 0) goto L_0x006c;
        L_0x005b:
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r5.append(r4);
            r4 = " ";
            r5.append(r4);
            r4 = r5.toString();
        L_0x006c:
            r5 = r4.length();
            r6 = r7.O00000o0;
            r5 = r5 + r6;
            if (r5 <= r3) goto L_0x0086;
        L_0x0075:
            r5 = r7.O00000o;
            r6 = "\n";
            r5.append(r6);
            r5.append(r4);
            r4 = r4.length();
            r7.O00000o0 = r4;
            goto L_0x0094;
        L_0x0086:
            r5 = r7.O00000o;
            r5.append(r4);
            r5 = r7.O00000o0;
            r4 = r4.length();
            r5 = r5 + r4;
            r7.O00000o0 = r5;
        L_0x0094:
            r0 = r0 + 1;
            goto L_0x004d;
        L_0x0097:
            r0 = r7.O00000o;
            r0.append(r8);
            r0 = r7.O00000o0;
            r8 = r8.length();
            r0 = r0 + r8;
            r7.O00000o0 = r0;
        L_0x00a5:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.examples.HtmlToPlainText$FormattingVisitor.O000000o(java.lang.String):void");
        }

        public void O000000o(Node node, int i) {
            String O000000o = node.O000000o();
            if (node instanceof TextNode) {
                O000000o(((TextNode) node).O00000Oo());
            } else if (O000000o.equals("li")) {
                O000000o("\n * ");
            } else if (O000000o.equals(db.O0000o00)) {
                O000000o("  ");
            } else {
                if (StringUtil.O000000o(O000000o, e.ao, "h1", "h2", "h3", "h4", "h5", "tr")) {
                    O000000o("\n");
                }
            }
        }

        public void O00000Oo(Node node, int i) {
            String O000000o = node.O000000o();
            if (StringUtil.O000000o(O000000o, "br", "dd", db.O0000o00, e.ao, "h1", "h2", "h3", "h4", "h5")) {
                O000000o("\n");
            } else if (O000000o.equals(e.al)) {
                O000000o(String.format(" <%s>", new Object[]{node.O000OOOo("href")}));
            }
        }

        public String toString() {
            return this.O00000o.toString();
        }
    }

    public static void O000000o(String... strArr) throws IOException {
        boolean z = strArr.length == 1 || strArr.length == 2;
        Validate.O000000o(z, "usage: java -cp jsoup.jar org.jsoup.examples.HtmlToPlainText url [selector]");
        String str = strArr[0];
        String str2 = strArr.length == 2 ? strArr[1] : null;
        Element O000000o = Jsoup.O00000Oo(str).O00000Oo(O000000o).O000000o((int) O00000Oo).O000000o();
        HtmlToPlainText htmlToPlainText = new HtmlToPlainText();
        if (str2 != null) {
            Iterator it = O000000o.O00000oo(str2).iterator();
            while (it.hasNext()) {
                System.out.println(htmlToPlainText.O000000o((Element) it.next()));
            }
            return;
        }
        System.out.println(htmlToPlainText.O000000o(O000000o));
    }

    public String O000000o(Element element) {
        FormattingVisitor formattingVisitor = new FormattingVisitor();
        new NodeTraversor(formattingVisitor).O000000o(element);
        return formattingVisitor.toString();
    }
}
