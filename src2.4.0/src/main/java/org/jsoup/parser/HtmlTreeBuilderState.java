package org.jsoup.parser;

import com.umeng.commonsdk.proguard.e;
import defpackage.cu;
import defpackage.db;
import java.util.ArrayList;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document.QuirksMode;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

enum HtmlTreeBuilderState {
    Initial {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.O00000Oo(token)) {
                return true;
            }
            if (token.O0000Oo0()) {
                htmlTreeBuilder.O000000o(token.O0000Oo());
            } else if (token.O00000o0()) {
                Doctype O00000o = token.O00000o();
                htmlTreeBuilder.O00000oo().O000000o((Node) new DocumentType(htmlTreeBuilder.O0000Oo.O000000o(O00000o.O0000o0()), O00000o.O0000o0O(), O00000o.O0000o0o(), O00000o.O0000o(), htmlTreeBuilder.O0000O0o()));
                if (O00000o.O0000oO0()) {
                    htmlTreeBuilder.O00000oo().O000000o(QuirksMode.quirks);
                }
                htmlTreeBuilder.O000000o(BeforeHtml);
            } else {
                htmlTreeBuilder.O000000o(BeforeHtml);
                return htmlTreeBuilder.O000000o(token);
            }
            return true;
        }
    },
    BeforeHtml {
        private boolean O00000Oo(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.O000000o("html");
            htmlTreeBuilder.O000000o(BeforeHead);
            return htmlTreeBuilder.O000000o(token);
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.O00000o0()) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                return false;
            }
            if (token.O0000Oo0()) {
                htmlTreeBuilder.O000000o(token.O0000Oo());
            } else if (HtmlTreeBuilderState.O00000Oo(token)) {
                return true;
            } else {
                if (token.O00000oO() && token.O00000oo().O0000oO0().equals("html")) {
                    htmlTreeBuilder.O000000o(token.O00000oo());
                    htmlTreeBuilder.O000000o(BeforeHead);
                } else {
                    if (token.O0000O0o()) {
                        if (StringUtil.O000000o(token.O0000OOo().O0000oO0(), "head", "body", "html", "br")) {
                            return O00000Oo(token, htmlTreeBuilder);
                        }
                    }
                    if (!token.O0000O0o()) {
                        return O00000Oo(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                }
            }
            return true;
        }
    },
    BeforeHead {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.O00000Oo(token)) {
                return true;
            }
            if (token.O0000Oo0()) {
                htmlTreeBuilder.O000000o(token.O0000Oo());
            } else if (token.O00000o0()) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                return false;
            } else if (token.O00000oO() && token.O00000oo().O0000oO0().equals("html")) {
                return InBody.O000000o(token, htmlTreeBuilder);
            } else {
                if (token.O00000oO() && token.O00000oo().O0000oO0().equals("head")) {
                    htmlTreeBuilder.O0000O0o(htmlTreeBuilder.O000000o(token.O00000oo()));
                    htmlTreeBuilder.O000000o(InHead);
                } else {
                    if (token.O0000O0o()) {
                        if (StringUtil.O000000o(token.O0000OOo().O0000oO0(), "head", "body", "html", "br")) {
                            htmlTreeBuilder.O0000Ooo("head");
                            return htmlTreeBuilder.O000000o(token);
                        }
                    }
                    if (token.O0000O0o()) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    }
                    htmlTreeBuilder.O0000Ooo("head");
                    return htmlTreeBuilder.O000000o(token);
                }
            }
            return true;
        }
    },
    InHead {
        private boolean O000000o(Token token, TreeBuilder treeBuilder) {
            treeBuilder.O0000o00("head");
            return treeBuilder.O000000o(token);
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.O00000Oo(token)) {
                htmlTreeBuilder.O000000o(token.O0000Ooo());
                return true;
            }
            switch (token.O000000o) {
                case Comment:
                    htmlTreeBuilder.O000000o(token.O0000Oo());
                    break;
                case Doctype:
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                case StartTag:
                    StartTag O00000oo = token.O00000oo();
                    String O0000oO0 = O00000oo.O0000oO0();
                    if (O0000oO0.equals("html")) {
                        return InBody.O000000o(token, htmlTreeBuilder);
                    }
                    if (StringUtil.O000000o(O0000oO0, "base", "basefont", "bgsound", "command", "link")) {
                        Element O00000Oo = htmlTreeBuilder.O00000Oo(O00000oo);
                        if (O0000oO0.equals("base") && O00000Oo.O000OO00("href")) {
                            htmlTreeBuilder.O000000o(O00000Oo);
                            break;
                        }
                    } else if (O0000oO0.equals("meta")) {
                        htmlTreeBuilder.O00000Oo(O00000oo);
                        break;
                    } else if (O0000oO0.equals("title")) {
                        HtmlTreeBuilderState.O00000o0(O00000oo, htmlTreeBuilder);
                        break;
                    } else {
                        if (StringUtil.O000000o(O0000oO0, "noframes", "style")) {
                            HtmlTreeBuilderState.O00000o(O00000oo, htmlTreeBuilder);
                            break;
                        } else if (O0000oO0.equals("noscript")) {
                            htmlTreeBuilder.O000000o(O00000oo);
                            htmlTreeBuilder.O000000o(InHeadNoscript);
                            break;
                        } else if (O0000oO0.equals("script")) {
                            htmlTreeBuilder.O00000o.O000000o(TokeniserState.ScriptData);
                            htmlTreeBuilder.O00000o0();
                            htmlTreeBuilder.O000000o(Text);
                            htmlTreeBuilder.O000000o(O00000oo);
                            break;
                        } else if (!O0000oO0.equals("head")) {
                            return O000000o(token, (TreeBuilder) htmlTreeBuilder);
                        } else {
                            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                            return false;
                        }
                    }
                case EndTag:
                    String O0000oO02 = token.O0000OOo().O0000oO0();
                    if (O0000oO02.equals("head")) {
                        htmlTreeBuilder.O0000Oo0();
                        htmlTreeBuilder.O000000o(AfterHead);
                        break;
                    }
                    if (StringUtil.O000000o(O0000oO02, "body", "html", "br")) {
                        return O000000o(token, (TreeBuilder) htmlTreeBuilder);
                    }
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                default:
                    return O000000o(token, (TreeBuilder) htmlTreeBuilder);
            }
            return true;
        }
    },
    InHeadNoscript {
        private boolean O00000Oo(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
            htmlTreeBuilder.O000000o(new Character().O000000o(token.toString()));
            return true;
        }

        /* Access modifiers changed, original: 0000 */
        /* JADX WARNING: Missing block: B:22:0x0085, code skipped:
            if (org.jsoup.helper.StringUtil.O000000o(r8.O00000oo().O0000oO0(), "basefont", "bgsound", "link", "meta", "noframes", "style") != false) goto L_0x00d0;
     */
        /* JADX WARNING: Missing block: B:32:0x00bf, code skipped:
            if (org.jsoup.helper.StringUtil.O000000o(r8.O00000oo().O0000oO0(), "head", "noscript") == false) goto L_0x00c1;
     */
        public boolean O000000o(org.jsoup.parser.Token r8, org.jsoup.parser.HtmlTreeBuilder r9) {
            /*
            r7 = this;
            r0 = r8.O00000o0();
            r1 = 1;
            if (r0 == 0) goto L_0x000b;
        L_0x0007:
            r9.O00000Oo(r7);
            goto L_0x0046;
        L_0x000b:
            r0 = r8.O00000oO();
            if (r0 == 0) goto L_0x0028;
        L_0x0011:
            r0 = r8.O00000oo();
            r0 = r0.O0000oO0();
            r2 = "html";
            r0 = r0.equals(r2);
            if (r0 == 0) goto L_0x0028;
        L_0x0021:
            r0 = InBody;
            r8 = r9.O000000o(r8, r0);
            return r8;
        L_0x0028:
            r0 = r8.O0000O0o();
            if (r0 == 0) goto L_0x0047;
        L_0x002e:
            r0 = r8.O0000OOo();
            r0 = r0.O0000oO0();
            r2 = "noscript";
            r0 = r0.equals(r2);
            if (r0 == 0) goto L_0x0047;
        L_0x003e:
            r9.O0000Oo0();
            r8 = InHead;
            r9.O000000o(r8);
        L_0x0046:
            return r1;
        L_0x0047:
            r0 = org.jsoup.parser.HtmlTreeBuilderState.O00000Oo(r8);
            if (r0 != 0) goto L_0x00d0;
        L_0x004d:
            r0 = r8.O0000Oo0();
            if (r0 != 0) goto L_0x00d0;
        L_0x0053:
            r0 = r8.O00000oO();
            r2 = 2;
            r3 = 0;
            if (r0 == 0) goto L_0x0088;
        L_0x005b:
            r0 = r8.O00000oo();
            r0 = r0.O0000oO0();
            r4 = 6;
            r4 = new java.lang.String[r4];
            r5 = "basefont";
            r4[r3] = r5;
            r5 = "bgsound";
            r4[r1] = r5;
            r5 = "link";
            r4[r2] = r5;
            r5 = 3;
            r6 = "meta";
            r4[r5] = r6;
            r5 = 4;
            r6 = "noframes";
            r4[r5] = r6;
            r5 = 5;
            r6 = "style";
            r4[r5] = r6;
            r0 = org.jsoup.helper.StringUtil.O000000o(r0, r4);
            if (r0 == 0) goto L_0x0088;
        L_0x0087:
            goto L_0x00d0;
        L_0x0088:
            r0 = r8.O0000O0o();
            if (r0 == 0) goto L_0x00a3;
        L_0x008e:
            r0 = r8.O0000OOo();
            r0 = r0.O0000oO0();
            r4 = "br";
            r0 = r0.equals(r4);
            if (r0 == 0) goto L_0x00a3;
        L_0x009e:
            r8 = r7.O00000Oo(r8, r9);
            return r8;
        L_0x00a3:
            r0 = r8.O00000oO();
            if (r0 == 0) goto L_0x00c1;
        L_0x00a9:
            r0 = r8.O00000oo();
            r0 = r0.O0000oO0();
            r2 = new java.lang.String[r2];
            r4 = "head";
            r2[r3] = r4;
            r4 = "noscript";
            r2[r1] = r4;
            r0 = org.jsoup.helper.StringUtil.O000000o(r0, r2);
            if (r0 != 0) goto L_0x00c7;
        L_0x00c1:
            r0 = r8.O0000O0o();
            if (r0 == 0) goto L_0x00cb;
        L_0x00c7:
            r9.O00000Oo(r7);
            return r3;
        L_0x00cb:
            r8 = r7.O00000Oo(r8, r9);
            return r8;
        L_0x00d0:
            r0 = InHead;
            r8 = r9.O000000o(r8, r0);
            return r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState$AnonymousClass5.O000000o(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }
    },
    AfterHead {
        private boolean O00000Oo(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.O0000Ooo("body");
            htmlTreeBuilder.O000000o(true);
            return htmlTreeBuilder.O000000o(token);
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.O00000Oo(token)) {
                htmlTreeBuilder.O000000o(token.O0000Ooo());
            } else if (token.O0000Oo0()) {
                htmlTreeBuilder.O000000o(token.O0000Oo());
            } else if (token.O00000o0()) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
            } else if (token.O00000oO()) {
                StartTag O00000oo = token.O00000oo();
                String O0000oO0 = O00000oo.O0000oO0();
                if (O0000oO0.equals("html")) {
                    return htmlTreeBuilder.O000000o(token, InBody);
                }
                if (O0000oO0.equals("body")) {
                    htmlTreeBuilder.O000000o(O00000oo);
                    htmlTreeBuilder.O000000o(false);
                    htmlTreeBuilder.O000000o(InBody);
                } else if (O0000oO0.equals("frameset")) {
                    htmlTreeBuilder.O000000o(O00000oo);
                    htmlTreeBuilder.O000000o(InFrameset);
                } else {
                    if (StringUtil.O000000o(O0000oO0, "base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "title")) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        Element O0000o0O = htmlTreeBuilder.O0000o0O();
                        htmlTreeBuilder.O00000o0(O0000o0O);
                        htmlTreeBuilder.O000000o(token, InHead);
                        htmlTreeBuilder.O00000oO(O0000o0O);
                    } else if (O0000oO0.equals("head")) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    } else {
                        O00000Oo(token, htmlTreeBuilder);
                    }
                }
            } else if (token.O0000O0o()) {
                if (StringUtil.O000000o(token.O0000OOo().O0000oO0(), "body", "html")) {
                    O00000Oo(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                }
            } else {
                O00000Oo(token, htmlTreeBuilder);
            }
            return true;
        }
    },
    InBody {
        /* Access modifiers changed, original: 0000 */
        /* JADX WARNING: Removed duplicated region for block: B:212:0x0407  */
        /* JADX WARNING: Removed duplicated region for block: B:299:0x05eb  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x0133  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0126  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x016b A:{LOOP_END, LOOP:3: B:74:0x0169->B:75:0x016b} */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00d0  */
        /* JADX WARNING: Removed duplicated region for block: B:433:0x00c5 A:{SYNTHETIC} */
        /* JADX WARNING: Missing block: B:2:0x0015, code skipped:
            r1 = r4;
     */
        /* JADX WARNING: Missing block: B:259:0x051d, code skipped:
            return false;
     */
        /* JADX WARNING: Missing block: B:431:0x0920, code skipped:
            return r1;
     */
        public boolean O000000o(org.jsoup.parser.Token r18, org.jsoup.parser.HtmlTreeBuilder r19) {
            /*
            r17 = this;
            r0 = r17;
            r1 = r18;
            r2 = r19;
            r3 = org.jsoup.parser.HtmlTreeBuilderState.AnonymousClass24.O000000o;
            r4 = r1.O000000o;
            r4 = r4.ordinal();
            r3 = r3[r4];
            r4 = 1;
            r5 = 0;
            switch(r3) {
                case 1: goto L_0x0918;
                case 2: goto L_0x0914;
                case 3: goto L_0x033d;
                case 4: goto L_0x004b;
                case 5: goto L_0x0018;
                default: goto L_0x0015;
            };
        L_0x0015:
            r1 = r4;
            goto L_0x0920;
        L_0x0018:
            r1 = r18.O0000Ooo();
            r3 = r1.O0000o0();
            r6 = org.jsoup.parser.HtmlTreeBuilderState.O0000ooO;
            r3 = r3.equals(r6);
            if (r3 == 0) goto L_0x002e;
        L_0x002a:
            r2.O00000Oo(r0);
            return r5;
        L_0x002e:
            r3 = r19.O00000oO();
            if (r3 == 0) goto L_0x0041;
        L_0x0034:
            r3 = org.jsoup.parser.HtmlTreeBuilderState.O00000Oo(r1);
            if (r3 == 0) goto L_0x0041;
        L_0x003a:
            r19.O0000oo();
            r2.O000000o(r1);
            goto L_0x0015;
        L_0x0041:
            r19.O0000oo();
            r2.O000000o(r1);
            r2.O000000o(r5);
            goto L_0x0015;
        L_0x004b:
            r3 = r18.O0000OOo();
            r6 = r3.O0000oO0();
            r7 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000o0o;
            r7 = org.jsoup.helper.StringUtil.O00000Oo(r6, r7);
            r8 = 0;
            if (r7 == 0) goto L_0x0184;
        L_0x005e:
            r3 = r5;
        L_0x005f:
            r7 = 8;
            if (r3 >= r7) goto L_0x0015;
        L_0x0063:
            r7 = r2.O0000OoO(r6);
            if (r7 != 0) goto L_0x006e;
        L_0x0069:
            r1 = r17.O00000Oo(r18, r19);
            return r1;
        L_0x006e:
            r9 = r2.O00000o(r7);
            if (r9 != 0) goto L_0x007b;
        L_0x0074:
            r2.O00000Oo(r0);
            r2.O0000Oo(r7);
            return r4;
        L_0x007b:
            r9 = r7.O000000o();
            r9 = r2.O00000oO(r9);
            if (r9 != 0) goto L_0x0089;
        L_0x0085:
            r2.O00000Oo(r0);
            return r5;
        L_0x0089:
            r9 = r19.O00oOooo();
            if (r9 == r7) goto L_0x0092;
        L_0x008f:
            r2.O00000Oo(r0);
        L_0x0092:
            r9 = r19.O0000Oo();
            r10 = r9.size();
            r11 = r5;
            r12 = r11;
            r13 = r8;
        L_0x009d:
            if (r11 >= r10) goto L_0x00c2;
        L_0x009f:
            r14 = 64;
            if (r11 >= r14) goto L_0x00c2;
        L_0x00a3:
            r14 = r9.get(r11);
            r14 = (org.jsoup.nodes.Element) r14;
            if (r14 != r7) goto L_0x00b6;
        L_0x00ab:
            r12 = r11 + -1;
            r12 = r9.get(r12);
            r12 = (org.jsoup.nodes.Element) r12;
            r13 = r12;
            r12 = r4;
            goto L_0x00bf;
        L_0x00b6:
            if (r12 == 0) goto L_0x00bf;
        L_0x00b8:
            r15 = r2.O0000OOo(r14);
            if (r15 == 0) goto L_0x00bf;
        L_0x00be:
            goto L_0x00c3;
        L_0x00bf:
            r11 = r11 + 1;
            goto L_0x009d;
        L_0x00c2:
            r14 = r8;
        L_0x00c3:
            if (r14 != 0) goto L_0x00d0;
        L_0x00c5:
            r1 = r7.O000000o();
            r2.O00000o0(r1);
            r2.O0000Oo(r7);
            return r4;
        L_0x00d0:
            r9 = r5;
            r10 = r14;
            r11 = r10;
        L_0x00d3:
            r12 = 3;
            if (r9 >= r12) goto L_0x0118;
        L_0x00d6:
            r12 = r2.O00000o(r10);
            if (r12 == 0) goto L_0x00e0;
        L_0x00dc:
            r10 = r2.O00000oo(r10);
        L_0x00e0:
            r12 = r2.O0000OoO(r10);
            if (r12 != 0) goto L_0x00ea;
        L_0x00e6:
            r2.O00000oO(r10);
            goto L_0x0114;
        L_0x00ea:
            if (r10 != r7) goto L_0x00ed;
        L_0x00ec:
            goto L_0x0118;
        L_0x00ed:
            r12 = new org.jsoup.nodes.Element;
            r15 = r10.O000000o();
            r4 = org.jsoup.parser.ParseSettings.O00000Oo;
            r4 = org.jsoup.parser.Tag.O000000o(r15, r4);
            r15 = r19.O0000O0o();
            r12.<init>(r4, r15);
            r2.O00000o0(r10, r12);
            r2.O00000Oo(r10, r12);
            r4 = r11.O000OOoO();
            if (r4 == 0) goto L_0x010f;
        L_0x010c:
            r11.O000OoOo();
        L_0x010f:
            r12.O000000o(r11);
            r10 = r12;
            r11 = r10;
        L_0x0114:
            r9 = r9 + 1;
            r4 = 1;
            goto L_0x00d3;
        L_0x0118:
            r4 = r13.O000000o();
            r9 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000o;
            r4 = org.jsoup.helper.StringUtil.O00000Oo(r4, r9);
            if (r4 == 0) goto L_0x0133;
        L_0x0126:
            r4 = r11.O000OOoO();
            if (r4 == 0) goto L_0x012f;
        L_0x012c:
            r11.O000OoOo();
        L_0x012f:
            r2.O000000o(r11);
            goto L_0x013f;
        L_0x0133:
            r4 = r11.O000OOoO();
            if (r4 == 0) goto L_0x013c;
        L_0x0139:
            r11.O000OoOo();
        L_0x013c:
            r13.O000000o(r11);
        L_0x013f:
            r4 = new org.jsoup.nodes.Element;
            r9 = r7.O0000o0o();
            r10 = r19.O0000O0o();
            r4.<init>(r9, r10);
            r9 = r4.O000OOoo();
            r10 = r7.O000OOoo();
            r9.O000000o(r10);
            r9 = r14.O000Oo0();
            r10 = r14.O000Oo0o();
            r10 = new org.jsoup.nodes.Node[r10];
            r9 = r9.toArray(r10);
            r9 = (org.jsoup.nodes.Node[]) r9;
            r10 = r9.length;
            r11 = r5;
        L_0x0169:
            if (r11 >= r10) goto L_0x0173;
        L_0x016b:
            r12 = r9[r11];
            r4.O000000o(r12);
            r11 = r11 + 1;
            goto L_0x0169;
        L_0x0173:
            r14.O000000o(r4);
            r2.O0000Oo(r7);
            r2.O00000oO(r7);
            r2.O000000o(r14, r4);
            r3 = r3 + 1;
            r4 = 1;
            goto L_0x005f;
        L_0x0184:
            r4 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000o0O;
            r4 = org.jsoup.helper.StringUtil.O00000Oo(r6, r4);
            if (r4 == 0) goto L_0x01b1;
        L_0x018e:
            r1 = r2.O00000oO(r6);
            if (r1 != 0) goto L_0x0198;
        L_0x0194:
            r2.O00000Oo(r0);
            return r5;
        L_0x0198:
            r19.O0000oOO();
            r1 = r19.O00oOooo();
            r1 = r1.O000000o();
            r1 = r1.equals(r6);
            if (r1 != 0) goto L_0x01ac;
        L_0x01a9:
            r2.O00000Oo(r0);
        L_0x01ac:
            r2.O00000o0(r6);
            goto L_0x091f;
        L_0x01b1:
            r4 = "span";
            r4 = r6.equals(r4);
            if (r4 == 0) goto L_0x01be;
        L_0x01b9:
            r1 = r17.O00000Oo(r18, r19);
            return r1;
        L_0x01be:
            r4 = "li";
            r4 = r6.equals(r4);
            if (r4 == 0) goto L_0x01e9;
        L_0x01c6:
            r1 = r2.O00000oo(r6);
            if (r1 != 0) goto L_0x01d0;
        L_0x01cc:
            r2.O00000Oo(r0);
            return r5;
        L_0x01d0:
            r2.O0000Oo(r6);
            r1 = r19.O00oOooo();
            r1 = r1.O000000o();
            r1 = r1.equals(r6);
            if (r1 != 0) goto L_0x01e4;
        L_0x01e1:
            r2.O00000Oo(r0);
        L_0x01e4:
            r2.O00000o0(r6);
            goto L_0x091f;
        L_0x01e9:
            r4 = "body";
            r4 = r6.equals(r4);
            if (r4 == 0) goto L_0x0204;
        L_0x01f1:
            r1 = "body";
            r1 = r2.O00000oO(r1);
            if (r1 != 0) goto L_0x01fd;
        L_0x01f9:
            r2.O00000Oo(r0);
            return r5;
        L_0x01fd:
            r1 = AfterBody;
            r2.O000000o(r1);
            goto L_0x091f;
        L_0x0204:
            r4 = "html";
            r4 = r6.equals(r4);
            if (r4 == 0) goto L_0x0219;
        L_0x020c:
            r1 = "body";
            r1 = r2.O0000o00(r1);
            if (r1 == 0) goto L_0x091f;
        L_0x0214:
            r1 = r2.O000000o(r3);
            return r1;
        L_0x0219:
            r4 = "form";
            r4 = r6.equals(r4);
            if (r4 == 0) goto L_0x024e;
        L_0x0221:
            r1 = r19.O0000o();
            r2.O000000o(r8);
            if (r1 == 0) goto L_0x024a;
        L_0x022a:
            r3 = r2.O00000oO(r6);
            if (r3 != 0) goto L_0x0231;
        L_0x0230:
            goto L_0x024a;
        L_0x0231:
            r19.O0000oOO();
            r3 = r19.O00oOooo();
            r3 = r3.O000000o();
            r3 = r3.equals(r6);
            if (r3 != 0) goto L_0x0245;
        L_0x0242:
            r2.O00000Oo(r0);
        L_0x0245:
            r2.O00000oO(r1);
            goto L_0x091f;
        L_0x024a:
            r2.O00000Oo(r0);
            return r5;
        L_0x024e:
            r4 = "p";
            r4 = r6.equals(r4);
            if (r4 == 0) goto L_0x0280;
        L_0x0256:
            r1 = r2.O0000O0o(r6);
            if (r1 != 0) goto L_0x0267;
        L_0x025c:
            r2.O00000Oo(r0);
            r2.O0000Ooo(r6);
            r1 = r2.O000000o(r3);
            return r1;
        L_0x0267:
            r2.O0000Oo(r6);
            r1 = r19.O00oOooo();
            r1 = r1.O000000o();
            r1 = r1.equals(r6);
            if (r1 != 0) goto L_0x027b;
        L_0x0278:
            r2.O00000Oo(r0);
        L_0x027b:
            r2.O00000o0(r6);
            goto L_0x091f;
        L_0x0280:
            r3 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000oo;
            r3 = org.jsoup.helper.StringUtil.O00000Oo(r6, r3);
            if (r3 == 0) goto L_0x02ad;
        L_0x028a:
            r1 = r2.O00000oO(r6);
            if (r1 != 0) goto L_0x0294;
        L_0x0290:
            r2.O00000Oo(r0);
            return r5;
        L_0x0294:
            r2.O0000Oo(r6);
            r1 = r19.O00oOooo();
            r1 = r1.O000000o();
            r1 = r1.equals(r6);
            if (r1 != 0) goto L_0x02a8;
        L_0x02a5:
            r2.O00000Oo(r0);
        L_0x02a8:
            r2.O00000o0(r6);
            goto L_0x091f;
        L_0x02ad:
            r3 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000o0;
            r3 = org.jsoup.helper.StringUtil.O00000Oo(r6, r3);
            if (r3 == 0) goto L_0x02e2;
        L_0x02b7:
            r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000o0;
            r1 = r2.O00000Oo(r1);
            if (r1 != 0) goto L_0x02c5;
        L_0x02c1:
            r2.O00000Oo(r0);
            return r5;
        L_0x02c5:
            r2.O0000Oo(r6);
            r1 = r19.O00oOooo();
            r1 = r1.O000000o();
            r1 = r1.equals(r6);
            if (r1 != 0) goto L_0x02d9;
        L_0x02d6:
            r2.O00000Oo(r0);
        L_0x02d9:
            r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000o0;
            r2.O000000o(r1);
            goto L_0x091f;
        L_0x02e2:
            r3 = "sarcasm";
            r3 = r6.equals(r3);
            if (r3 == 0) goto L_0x02ef;
        L_0x02ea:
            r1 = r17.O00000Oo(r18, r19);
            return r1;
        L_0x02ef:
            r3 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000OOo;
            r3 = org.jsoup.helper.StringUtil.O00000Oo(r6, r3);
            if (r3 == 0) goto L_0x0327;
        L_0x02f9:
            r1 = "name";
            r1 = r2.O00000oO(r1);
            if (r1 != 0) goto L_0x091f;
        L_0x0301:
            r1 = r2.O00000oO(r6);
            if (r1 != 0) goto L_0x030b;
        L_0x0307:
            r2.O00000Oo(r0);
            return r5;
        L_0x030b:
            r19.O0000oOO();
            r1 = r19.O00oOooo();
            r1 = r1.O000000o();
            r1 = r1.equals(r6);
            if (r1 != 0) goto L_0x031f;
        L_0x031c:
            r2.O00000Oo(r0);
        L_0x031f:
            r2.O00000o0(r6);
            r19.O0000ooO();
            goto L_0x091f;
        L_0x0327:
            r3 = "br";
            r3 = r6.equals(r3);
            if (r3 == 0) goto L_0x0338;
        L_0x032f:
            r2.O00000Oo(r0);
            r1 = "br";
            r2.O0000Ooo(r1);
            return r5;
        L_0x0338:
            r1 = r17.O00000Oo(r18, r19);
            return r1;
        L_0x033d:
            r3 = r18.O00000oo();
            r4 = r3.O0000oO0();
            r6 = "a";
            r6 = r4.equals(r6);
            if (r6 == 0) goto L_0x0377;
        L_0x034d:
            r1 = "a";
            r1 = r2.O0000OoO(r1);
            if (r1 == 0) goto L_0x036b;
        L_0x0355:
            r2.O00000Oo(r0);
            r1 = "a";
            r2.O0000o00(r1);
            r1 = "a";
            r1 = r2.O00000Oo(r1);
            if (r1 == 0) goto L_0x036b;
        L_0x0365:
            r2.O0000Oo(r1);
            r2.O00000oO(r1);
        L_0x036b:
            r19.O0000oo();
            r1 = r2.O000000o(r3);
            r2.O0000Oo0(r1);
            goto L_0x091f;
        L_0x0377:
            r6 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000Oo0;
            r6 = org.jsoup.helper.StringUtil.O00000Oo(r4, r6);
            if (r6 == 0) goto L_0x038c;
        L_0x0381:
            r19.O0000oo();
            r2.O00000Oo(r3);
            r2.O000000o(r5);
            goto L_0x091f;
        L_0x038c:
            r6 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000Oo;
            r6 = org.jsoup.helper.StringUtil.O00000Oo(r4, r6);
            if (r6 == 0) goto L_0x03a8;
        L_0x0396:
            r1 = "p";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x03a3;
        L_0x039e:
            r1 = "p";
            r2.O0000o00(r1);
        L_0x03a3:
            r2.O000000o(r3);
            goto L_0x091f;
        L_0x03a8:
            r6 = "span";
            r6 = r4.equals(r6);
            if (r6 == 0) goto L_0x03b8;
        L_0x03b0:
            r19.O0000oo();
            r2.O000000o(r3);
            goto L_0x091f;
        L_0x03b8:
            r6 = "li";
            r6 = r4.equals(r6);
            if (r6 == 0) goto L_0x0411;
        L_0x03c0:
            r2.O000000o(r5);
            r1 = r19.O0000Oo();
            r4 = r1.size();
            r5 = 1;
            r4 = r4 - r5;
        L_0x03cd:
            if (r4 <= 0) goto L_0x03ff;
        L_0x03cf:
            r5 = r1.get(r4);
            r5 = (org.jsoup.nodes.Element) r5;
            r6 = r5.O000000o();
            r7 = "li";
            r6 = r6.equals(r7);
            if (r6 == 0) goto L_0x03e7;
        L_0x03e1:
            r1 = "li";
            r2.O0000o00(r1);
            goto L_0x03ff;
        L_0x03e7:
            r6 = r2.O0000OOo(r5);
            if (r6 == 0) goto L_0x03fc;
        L_0x03ed:
            r5 = r5.O000000o();
            r6 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000oO;
            r5 = org.jsoup.helper.StringUtil.O00000Oo(r5, r6);
            if (r5 != 0) goto L_0x03fc;
        L_0x03fb:
            goto L_0x03ff;
        L_0x03fc:
            r4 = r4 + -1;
            goto L_0x03cd;
        L_0x03ff:
            r1 = "p";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x040c;
        L_0x0407:
            r1 = "p";
            r2.O0000o00(r1);
        L_0x040c:
            r2.O000000o(r3);
            goto L_0x091f;
        L_0x0411:
            r6 = "html";
            r6 = r4.equals(r6);
            if (r6 == 0) goto L_0x044c;
        L_0x0419:
            r2.O00000Oo(r0);
            r1 = r19.O0000Oo();
            r1 = r1.get(r5);
            r1 = (org.jsoup.nodes.Element) r1;
            r2 = r3.O0000oOO();
            r2 = r2.iterator();
        L_0x042e:
            r3 = r2.hasNext();
            if (r3 == 0) goto L_0x091f;
        L_0x0434:
            r3 = r2.next();
            r3 = (org.jsoup.nodes.Attribute) r3;
            r4 = r3.getKey();
            r4 = r1.O000OO00(r4);
            if (r4 != 0) goto L_0x042e;
        L_0x0444:
            r4 = r1.O000OOoo();
            r4.O000000o(r3);
            goto L_0x042e;
        L_0x044c:
            r6 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O000000o;
            r6 = org.jsoup.helper.StringUtil.O00000Oo(r4, r6);
            if (r6 == 0) goto L_0x045d;
        L_0x0456:
            r3 = InHead;
            r1 = r2.O000000o(r1, r3);
            return r1;
        L_0x045d:
            r1 = "body";
            r1 = r4.equals(r1);
            r6 = 2;
            if (r1 == 0) goto L_0x04bd;
        L_0x0466:
            r2.O00000Oo(r0);
            r1 = r19.O0000Oo();
            r4 = r1.size();
            r7 = 1;
            if (r4 == r7) goto L_0x04bc;
        L_0x0474:
            r4 = r1.size();
            if (r4 <= r6) goto L_0x048d;
        L_0x047a:
            r4 = r1.get(r7);
            r4 = (org.jsoup.nodes.Element) r4;
            r4 = r4.O000000o();
            r6 = "body";
            r4 = r4.equals(r6);
            if (r4 != 0) goto L_0x048d;
        L_0x048c:
            goto L_0x04bc;
        L_0x048d:
            r2.O000000o(r5);
            r1 = r1.get(r7);
            r1 = (org.jsoup.nodes.Element) r1;
            r2 = r3.O0000oOO();
            r2 = r2.iterator();
        L_0x049e:
            r3 = r2.hasNext();
            if (r3 == 0) goto L_0x091f;
        L_0x04a4:
            r3 = r2.next();
            r3 = (org.jsoup.nodes.Attribute) r3;
            r4 = r3.getKey();
            r4 = r1.O000OO00(r4);
            if (r4 != 0) goto L_0x049e;
        L_0x04b4:
            r4 = r1.O000OOoo();
            r4.O000000o(r3);
            goto L_0x049e;
        L_0x04bc:
            return r5;
        L_0x04bd:
            r1 = "frameset";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x051e;
        L_0x04c5:
            r2.O00000Oo(r0);
            r1 = r19.O0000Oo();
            r4 = r1.size();
            r7 = 1;
            if (r4 == r7) goto L_0x051d;
        L_0x04d3:
            r4 = r1.size();
            if (r4 <= r6) goto L_0x04ec;
        L_0x04d9:
            r4 = r1.get(r7);
            r4 = (org.jsoup.nodes.Element) r4;
            r4 = r4.O000000o();
            r6 = "body";
            r4 = r4.equals(r6);
            if (r4 != 0) goto L_0x04ec;
        L_0x04eb:
            goto L_0x051d;
        L_0x04ec:
            r4 = r19.O00000oO();
            if (r4 != 0) goto L_0x04f3;
        L_0x04f2:
            return r5;
        L_0x04f3:
            r4 = 1;
            r5 = r1.get(r4);
            r5 = (org.jsoup.nodes.Element) r5;
            r6 = r5.O000OOoO();
            if (r6 == 0) goto L_0x0503;
        L_0x0500:
            r5.O000OoOo();
        L_0x0503:
            r5 = r1.size();
            if (r5 <= r4) goto L_0x0513;
        L_0x0509:
            r5 = r1.size();
            r5 = r5 - r4;
            r1.remove(r5);
            r4 = 1;
            goto L_0x0503;
        L_0x0513:
            r2.O000000o(r3);
            r1 = InFrameset;
            r2.O000000o(r1);
            goto L_0x091f;
        L_0x051d:
            return r5;
        L_0x051e:
            r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000o0;
            r1 = org.jsoup.helper.StringUtil.O00000Oo(r4, r1);
            if (r1 == 0) goto L_0x0552;
        L_0x0528:
            r1 = "p";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x0535;
        L_0x0530:
            r1 = "p";
            r2.O0000o00(r1);
        L_0x0535:
            r1 = r19.O00oOooo();
            r1 = r1.O000000o();
            r4 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000o0;
            r1 = org.jsoup.helper.StringUtil.O00000Oo(r1, r4);
            if (r1 == 0) goto L_0x054d;
        L_0x0547:
            r2.O00000Oo(r0);
            r19.O0000Oo0();
        L_0x054d:
            r2.O000000o(r3);
            goto L_0x091f;
        L_0x0552:
            r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000o;
            r1 = org.jsoup.helper.StringUtil.O00000Oo(r4, r1);
            if (r1 == 0) goto L_0x0571;
        L_0x055c:
            r1 = "p";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x0569;
        L_0x0564:
            r1 = "p";
            r2.O0000o00(r1);
        L_0x0569:
            r2.O000000o(r3);
            r2.O000000o(r5);
            goto L_0x091f;
        L_0x0571:
            r1 = "form";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x0596;
        L_0x0579:
            r1 = r19.O0000o();
            if (r1 == 0) goto L_0x0583;
        L_0x057f:
            r2.O00000Oo(r0);
            return r5;
        L_0x0583:
            r1 = "p";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x0590;
        L_0x058b:
            r1 = "p";
            r2.O0000o00(r1);
        L_0x0590:
            r1 = 1;
            r2.O000000o(r3, r1);
            goto L_0x0920;
        L_0x0596:
            r1 = 1;
            r6 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000oo;
            r6 = org.jsoup.helper.StringUtil.O00000Oo(r4, r6);
            if (r6 == 0) goto L_0x05f5;
        L_0x05a1:
            r2.O000000o(r5);
            r4 = r19.O0000Oo();
            r5 = r4.size();
            r5 = r5 - r1;
        L_0x05ad:
            if (r5 <= 0) goto L_0x05e3;
        L_0x05af:
            r1 = r4.get(r5);
            r1 = (org.jsoup.nodes.Element) r1;
            r6 = r1.O000000o();
            r7 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000oo;
            r6 = org.jsoup.helper.StringUtil.O00000Oo(r6, r7);
            if (r6 == 0) goto L_0x05cb;
        L_0x05c3:
            r1 = r1.O000000o();
            r2.O0000o00(r1);
            goto L_0x05e3;
        L_0x05cb:
            r6 = r2.O0000OOo(r1);
            if (r6 == 0) goto L_0x05e0;
        L_0x05d1:
            r1 = r1.O000000o();
            r6 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O00000oO;
            r1 = org.jsoup.helper.StringUtil.O00000Oo(r1, r6);
            if (r1 != 0) goto L_0x05e0;
        L_0x05df:
            goto L_0x05e3;
        L_0x05e0:
            r5 = r5 + -1;
            goto L_0x05ad;
        L_0x05e3:
            r1 = "p";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x05f0;
        L_0x05eb:
            r1 = "p";
            r2.O0000o00(r1);
        L_0x05f0:
            r2.O000000o(r3);
            goto L_0x091f;
        L_0x05f5:
            r1 = "plaintext";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x0616;
        L_0x05fd:
            r1 = "p";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x060a;
        L_0x0605:
            r1 = "p";
            r2.O0000o00(r1);
        L_0x060a:
            r2.O000000o(r3);
            r1 = r2.O00000o;
            r2 = org.jsoup.parser.TokeniserState.PLAINTEXT;
            r1.O000000o(r2);
            goto L_0x091f;
        L_0x0616:
            r1 = "button";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x063e;
        L_0x061e:
            r1 = "button";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x0633;
        L_0x0626:
            r2.O00000Oo(r0);
            r1 = "button";
            r2.O0000o00(r1);
            r2.O000000o(r3);
            goto L_0x091f;
        L_0x0633:
            r19.O0000oo();
            r2.O000000o(r3);
            r2.O000000o(r5);
            goto L_0x091f;
        L_0x063e:
            r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000O0o;
            r1 = org.jsoup.helper.StringUtil.O00000Oo(r4, r1);
            if (r1 == 0) goto L_0x0654;
        L_0x0648:
            r19.O0000oo();
            r1 = r2.O000000o(r3);
            r2.O0000Oo0(r1);
            goto L_0x091f;
        L_0x0654:
            r1 = "nobr";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x067b;
        L_0x065c:
            r19.O0000oo();
            r1 = "nobr";
            r1 = r2.O00000oO(r1);
            if (r1 == 0) goto L_0x0672;
        L_0x0667:
            r2.O00000Oo(r0);
            r1 = "nobr";
            r2.O0000o00(r1);
            r19.O0000oo();
        L_0x0672:
            r1 = r2.O000000o(r3);
            r2.O0000Oo0(r1);
            goto L_0x091f;
        L_0x067b:
            r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000OOo;
            r1 = org.jsoup.helper.StringUtil.O00000Oo(r4, r1);
            if (r1 == 0) goto L_0x0693;
        L_0x0685:
            r19.O0000oo();
            r2.O000000o(r3);
            r19.O0000ooo();
            r2.O000000o(r5);
            goto L_0x091f;
        L_0x0693:
            r1 = "table";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x06c1;
        L_0x069b:
            r1 = r19.O00000oo();
            r1 = r1.O0000Ooo();
            r4 = org.jsoup.nodes.Document.QuirksMode.quirks;
            if (r1 == r4) goto L_0x06b4;
        L_0x06a7:
            r1 = "p";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x06b4;
        L_0x06af:
            r1 = "p";
            r2.O0000o00(r1);
        L_0x06b4:
            r2.O000000o(r3);
            r2.O000000o(r5);
            r1 = InTable;
            r2.O000000o(r1);
            goto L_0x091f;
        L_0x06c1:
            r1 = "input";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x06e3;
        L_0x06c9:
            r19.O0000oo();
            r1 = r2.O00000Oo(r3);
            r3 = "type";
            r1 = r1.O000O0oo(r3);
            r3 = "hidden";
            r1 = r1.equalsIgnoreCase(r3);
            if (r1 != 0) goto L_0x091f;
        L_0x06de:
            r2.O000000o(r5);
            goto L_0x091f;
        L_0x06e3:
            r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000Oo;
            r1 = org.jsoup.helper.StringUtil.O00000Oo(r4, r1);
            if (r1 == 0) goto L_0x06f2;
        L_0x06ed:
            r2.O00000Oo(r3);
            goto L_0x091f;
        L_0x06f2:
            r1 = "hr";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x070f;
        L_0x06fa:
            r1 = "p";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x0707;
        L_0x0702:
            r1 = "p";
            r2.O0000o00(r1);
        L_0x0707:
            r2.O00000Oo(r3);
            r2.O000000o(r5);
            goto L_0x091f;
        L_0x070f:
            r1 = "image";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x072f;
        L_0x0717:
            r1 = "svg";
            r1 = r2.O00000Oo(r1);
            if (r1 != 0) goto L_0x072a;
        L_0x071f:
            r1 = "img";
            r1 = r3.O000000o(r1);
            r1 = r2.O000000o(r1);
            return r1;
        L_0x072a:
            r2.O000000o(r3);
            goto L_0x091f;
        L_0x072f:
            r1 = "isindex";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x07d7;
        L_0x0737:
            r2.O00000Oo(r0);
            r1 = r19.O0000o();
            if (r1 == 0) goto L_0x0741;
        L_0x0740:
            return r5;
        L_0x0741:
            r1 = r2.O00000o;
            r1.O00000o0();
            r1 = "form";
            r2.O0000Ooo(r1);
            r1 = r3.O00000oO;
            r4 = "action";
            r1 = r1.O00000oO(r4);
            if (r1 == 0) goto L_0x0766;
        L_0x0755:
            r1 = r19.O0000o();
            r4 = "action";
            r5 = r3.O00000oO;
            r6 = "action";
            r5 = r5.O000000o(r6);
            r1.O0000OOo(r4, r5);
        L_0x0766:
            r1 = "hr";
            r2.O0000Ooo(r1);
            r1 = "label";
            r2.O0000Ooo(r1);
            r1 = r3.O00000oO;
            r4 = "prompt";
            r1 = r1.O00000oO(r4);
            if (r1 == 0) goto L_0x0783;
        L_0x077a:
            r1 = r3.O00000oO;
            r4 = "prompt";
            r1 = r1.O000000o(r4);
            goto L_0x0785;
        L_0x0783:
            r1 = "This is a searchable index. Enter search keywords: ";
        L_0x0785:
            r4 = new org.jsoup.parser.Token$Character;
            r4.<init>();
            r1 = r4.O000000o(r1);
            r2.O000000o(r1);
            r1 = new org.jsoup.nodes.Attributes;
            r1.<init>();
            r3 = r3.O00000oO;
            r3 = r3.iterator();
        L_0x079c:
            r4 = r3.hasNext();
            if (r4 == 0) goto L_0x07ba;
        L_0x07a2:
            r4 = r3.next();
            r4 = (org.jsoup.nodes.Attribute) r4;
            r5 = r4.getKey();
            r6 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000OoO;
            r5 = org.jsoup.helper.StringUtil.O00000Oo(r5, r6);
            if (r5 != 0) goto L_0x079c;
        L_0x07b6:
            r1.O000000o(r4);
            goto L_0x079c;
        L_0x07ba:
            r3 = "name";
            r4 = "isindex";
            r1.O000000o(r3, r4);
            r3 = "input";
            r2.O000000o(r3, r1);
            r1 = "label";
            r2.O0000o00(r1);
            r1 = "hr";
            r2.O0000Ooo(r1);
            r1 = "form";
            r2.O0000o00(r1);
            goto L_0x091f;
        L_0x07d7:
            r1 = "textarea";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x07f6;
        L_0x07df:
            r2.O000000o(r3);
            r1 = r2.O00000o;
            r3 = org.jsoup.parser.TokeniserState.Rcdata;
            r1.O000000o(r3);
            r19.O00000o0();
            r2.O000000o(r5);
            r1 = Text;
            r2.O000000o(r1);
            goto L_0x091f;
        L_0x07f6:
            r1 = "xmp";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x0816;
        L_0x07fe:
            r1 = "p";
            r1 = r2.O0000O0o(r1);
            if (r1 == 0) goto L_0x080b;
        L_0x0806:
            r1 = "p";
            r2.O0000o00(r1);
        L_0x080b:
            r19.O0000oo();
            r2.O000000o(r5);
            org.jsoup.parser.HtmlTreeBuilderState.O00000o(r3, r2);
            goto L_0x091f;
        L_0x0816:
            r1 = "iframe";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x0826;
        L_0x081e:
            r2.O000000o(r5);
            org.jsoup.parser.HtmlTreeBuilderState.O00000o(r3, r2);
            goto L_0x091f;
        L_0x0826:
            r1 = "noembed";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x0833;
        L_0x082e:
            org.jsoup.parser.HtmlTreeBuilderState.O00000o(r3, r2);
            goto L_0x091f;
        L_0x0833:
            r1 = "select";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x087f;
        L_0x083b:
            r19.O0000oo();
            r2.O000000o(r3);
            r2.O000000o(r5);
            r1 = r19.O00000Oo();
            r3 = InTable;
            r3 = r1.equals(r3);
            if (r3 != 0) goto L_0x0878;
        L_0x0850:
            r3 = InCaption;
            r3 = r1.equals(r3);
            if (r3 != 0) goto L_0x0878;
        L_0x0858:
            r3 = InTableBody;
            r3 = r1.equals(r3);
            if (r3 != 0) goto L_0x0878;
        L_0x0860:
            r3 = InRow;
            r3 = r1.equals(r3);
            if (r3 != 0) goto L_0x0878;
        L_0x0868:
            r3 = InCell;
            r1 = r1.equals(r3);
            if (r1 == 0) goto L_0x0871;
        L_0x0870:
            goto L_0x0878;
        L_0x0871:
            r1 = InSelect;
            r2.O000000o(r1);
            goto L_0x091f;
        L_0x0878:
            r1 = InSelectInTable;
            r2.O000000o(r1);
            goto L_0x091f;
        L_0x087f:
            r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000Ooo;
            r1 = org.jsoup.helper.StringUtil.O00000Oo(r4, r1);
            if (r1 == 0) goto L_0x08a6;
        L_0x0889:
            r1 = r19.O00oOooo();
            r1 = r1.O000000o();
            r4 = "option";
            r1 = r1.equals(r4);
            if (r1 == 0) goto L_0x089e;
        L_0x0899:
            r1 = "option";
            r2.O0000o00(r1);
        L_0x089e:
            r19.O0000oo();
            r2.O000000o(r3);
            goto L_0x091f;
        L_0x08a6:
            r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000o00;
            r1 = org.jsoup.helper.StringUtil.O00000Oo(r4, r1);
            if (r1 == 0) goto L_0x08d7;
        L_0x08b0:
            r1 = "ruby";
            r1 = r2.O00000oO(r1);
            if (r1 == 0) goto L_0x091f;
        L_0x08b8:
            r19.O0000oOO();
            r1 = r19.O00oOooo();
            r1 = r1.O000000o();
            r4 = "ruby";
            r1 = r1.equals(r4);
            if (r1 != 0) goto L_0x08d3;
        L_0x08cb:
            r2.O00000Oo(r0);
            r1 = "ruby";
            r2.O00000o(r1);
        L_0x08d3:
            r2.O000000o(r3);
            goto L_0x091f;
        L_0x08d7:
            r1 = "math";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x08eb;
        L_0x08df:
            r19.O0000oo();
            r2.O000000o(r3);
            r1 = r2.O00000o;
            r1.O00000o0();
            goto L_0x091f;
        L_0x08eb:
            r1 = "svg";
            r1 = r4.equals(r1);
            if (r1 == 0) goto L_0x08ff;
        L_0x08f3:
            r19.O0000oo();
            r2.O000000o(r3);
            r1 = r2.O00000o;
            r1.O00000o0();
            goto L_0x091f;
        L_0x08ff:
            r1 = org.jsoup.parser.HtmlTreeBuilderState.Constants.O0000o0;
            r1 = org.jsoup.helper.StringUtil.O00000Oo(r4, r1);
            if (r1 == 0) goto L_0x090d;
        L_0x0909:
            r2.O00000Oo(r0);
            return r5;
        L_0x090d:
            r19.O0000oo();
            r2.O000000o(r3);
            goto L_0x091f;
        L_0x0914:
            r2.O00000Oo(r0);
            return r5;
        L_0x0918:
            r1 = r18.O0000Oo();
            r2.O000000o(r1);
        L_0x091f:
            r1 = 1;
        L_0x0920:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState$AnonymousClass7.O000000o(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O00000Oo(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String O0000oO0 = token.O0000OOo().O0000oO0();
            ArrayList O0000Oo = htmlTreeBuilder.O0000Oo();
            int size = O0000Oo.size() - 1;
            while (size >= 0) {
                Element element = (Element) O0000Oo.get(size);
                if (element.O000000o().equals(O0000oO0)) {
                    htmlTreeBuilder.O0000Oo(O0000oO0);
                    if (!O0000oO0.equals(htmlTreeBuilder.O00oOooo().O000000o())) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    }
                    htmlTreeBuilder.O00000o0(O0000oO0);
                    return true;
                } else if (htmlTreeBuilder.O0000OOo(element)) {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                } else {
                    size--;
                }
            }
            return true;
        }
    },
    Text {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.O0000OoO()) {
                htmlTreeBuilder.O000000o(token.O0000Ooo());
            } else if (token.O0000o00()) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                htmlTreeBuilder.O0000Oo0();
                htmlTreeBuilder.O000000o(htmlTreeBuilder.O00000o());
                return htmlTreeBuilder.O000000o(token);
            } else if (token.O0000O0o()) {
                htmlTreeBuilder.O0000Oo0();
                htmlTreeBuilder.O000000o(htmlTreeBuilder.O00000o());
            }
            return true;
        }
    },
    InTable {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.O0000OoO()) {
                htmlTreeBuilder.O0000oO0();
                htmlTreeBuilder.O00000o0();
                htmlTreeBuilder.O000000o(InTableText);
                return htmlTreeBuilder.O000000o(token);
            } else if (token.O0000Oo0()) {
                htmlTreeBuilder.O000000o(token.O0000Oo());
                return true;
            } else if (token.O00000o0()) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                return false;
            } else if (token.O00000oO()) {
                StartTag O00000oo = token.O00000oo();
                String O0000oO0 = O00000oo.O0000oO0();
                if (O0000oO0.equals("caption")) {
                    htmlTreeBuilder.O0000OoO();
                    htmlTreeBuilder.O0000ooo();
                    htmlTreeBuilder.O000000o(O00000oo);
                    htmlTreeBuilder.O000000o(InCaption);
                } else if (O0000oO0.equals("colgroup")) {
                    htmlTreeBuilder.O0000OoO();
                    htmlTreeBuilder.O000000o(O00000oo);
                    htmlTreeBuilder.O000000o(InColumnGroup);
                } else if (O0000oO0.equals("col")) {
                    htmlTreeBuilder.O0000Ooo("colgroup");
                    return htmlTreeBuilder.O000000o(token);
                } else {
                    if (StringUtil.O000000o(O0000oO0, "tbody", "tfoot", "thead")) {
                        htmlTreeBuilder.O0000OoO();
                        htmlTreeBuilder.O000000o(O00000oo);
                        htmlTreeBuilder.O000000o(InTableBody);
                    } else {
                        if (StringUtil.O000000o(O0000oO0, "td", "th", "tr")) {
                            htmlTreeBuilder.O0000Ooo("tbody");
                            return htmlTreeBuilder.O000000o(token);
                        } else if (O0000oO0.equals("table")) {
                            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                            if (htmlTreeBuilder.O0000o00("table")) {
                                return htmlTreeBuilder.O000000o(token);
                            }
                        } else {
                            if (StringUtil.O000000o(O0000oO0, "style", "script")) {
                                return htmlTreeBuilder.O000000o(token, InHead);
                            }
                            if (O0000oO0.equals("input")) {
                                if (!O00000oo.O00000oO.O000000o("type").equalsIgnoreCase("hidden")) {
                                    return O00000Oo(token, htmlTreeBuilder);
                                }
                                htmlTreeBuilder.O00000Oo(O00000oo);
                            } else if (!O0000oO0.equals("form")) {
                                return O00000Oo(token, htmlTreeBuilder);
                            } else {
                                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                                if (htmlTreeBuilder.O0000o() != null) {
                                    return false;
                                }
                                htmlTreeBuilder.O000000o(O00000oo, false);
                            }
                        }
                    }
                }
                return true;
            } else if (token.O0000O0o()) {
                String O0000oO02 = token.O0000OOo().O0000oO0();
                if (!O0000oO02.equals("table")) {
                    if (!StringUtil.O000000o(O0000oO02, "body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                        return O00000Oo(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                } else if (htmlTreeBuilder.O0000OOo(O0000oO02)) {
                    htmlTreeBuilder.O00000o0("table");
                    htmlTreeBuilder.O0000o0();
                    return true;
                } else {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                }
            } else if (!token.O0000o00()) {
                return O00000Oo(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.O00oOooo().O000000o().equals("html")) {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                }
                return true;
            }
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O00000Oo(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
            if (!StringUtil.O000000o(htmlTreeBuilder.O00oOooo().O000000o(), "table", "tbody", "tfoot", "thead", "tr")) {
                return htmlTreeBuilder.O000000o(token, InBody);
            }
            htmlTreeBuilder.O00000Oo(true);
            boolean O000000o = htmlTreeBuilder.O000000o(token, InBody);
            htmlTreeBuilder.O00000Oo(false);
            return O000000o;
        }
    },
    InTableText {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (AnonymousClass24.O000000o[token.O000000o.ordinal()] != 5) {
                if (htmlTreeBuilder.O0000oO().size() > 0) {
                    for (String str : htmlTreeBuilder.O0000oO()) {
                        if (HtmlTreeBuilderState.O00000Oo(str)) {
                            htmlTreeBuilder.O000000o(new Character().O000000o(str));
                        } else {
                            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                            if (StringUtil.O000000o(htmlTreeBuilder.O00oOooo().O000000o(), "table", "tbody", "tfoot", "thead", "tr")) {
                                htmlTreeBuilder.O00000Oo(true);
                                htmlTreeBuilder.O000000o(new Character().O000000o(str), InBody);
                                htmlTreeBuilder.O00000Oo(false);
                            } else {
                                htmlTreeBuilder.O000000o(new Character().O000000o(str), InBody);
                            }
                        }
                    }
                    htmlTreeBuilder.O0000oO0();
                }
                htmlTreeBuilder.O000000o(htmlTreeBuilder.O00000o());
                return htmlTreeBuilder.O000000o(token);
            }
            Character O0000Ooo = token.O0000Ooo();
            if (O0000Ooo.O0000o0().equals(HtmlTreeBuilderState.O0000ooO)) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                return false;
            }
            htmlTreeBuilder.O0000oO().add(O0000Ooo.O0000o0());
            return true;
        }
    },
    InCaption {
        /* Access modifiers changed, original: 0000 */
        /* JADX WARNING: Missing block: B:15:0x0090, code skipped:
            if (org.jsoup.helper.StringUtil.O000000o(r14.O00000oo().O0000oO0(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr") == false) goto L_0x0092;
     */
        public boolean O000000o(org.jsoup.parser.Token r14, org.jsoup.parser.HtmlTreeBuilder r15) {
            /*
            r13 = this;
            r0 = r14.O0000O0o();
            r1 = 1;
            r2 = 0;
            if (r0 == 0) goto L_0x004e;
        L_0x0008:
            r0 = r14.O0000OOo();
            r0 = r0.O0000oO0();
            r3 = "caption";
            r0 = r0.equals(r3);
            if (r0 == 0) goto L_0x004e;
        L_0x0018:
            r14 = r14.O0000OOo();
            r14 = r14.O0000oO0();
            r14 = r15.O0000OOo(r14);
            if (r14 != 0) goto L_0x002a;
        L_0x0026:
            r15.O00000Oo(r13);
            return r2;
        L_0x002a:
            r15.O0000oOO();
            r14 = r15.O00oOooo();
            r14 = r14.O000000o();
            r0 = "caption";
            r14 = r14.equals(r0);
            if (r14 != 0) goto L_0x0040;
        L_0x003d:
            r15.O00000Oo(r13);
        L_0x0040:
            r14 = "caption";
            r15.O00000o0(r14);
            r15.O0000ooO();
            r14 = InTable;
            r15.O000000o(r14);
            goto L_0x00b8;
        L_0x004e:
            r0 = r14.O00000oO();
            r3 = 8;
            r4 = 7;
            r5 = 6;
            r6 = 5;
            r7 = 4;
            r8 = 3;
            r9 = 2;
            r10 = 9;
            if (r0 == 0) goto L_0x0092;
        L_0x005e:
            r0 = r14.O00000oo();
            r0 = r0.O0000oO0();
            r11 = new java.lang.String[r10];
            r12 = "caption";
            r11[r2] = r12;
            r12 = "col";
            r11[r1] = r12;
            r12 = "colgroup";
            r11[r9] = r12;
            r12 = "tbody";
            r11[r8] = r12;
            r12 = "td";
            r11[r7] = r12;
            r12 = "tfoot";
            r11[r6] = r12;
            r12 = "th";
            r11[r5] = r12;
            r12 = "thead";
            r11[r4] = r12;
            r12 = "tr";
            r11[r3] = r12;
            r0 = org.jsoup.helper.StringUtil.O000000o(r0, r11);
            if (r0 != 0) goto L_0x00a8;
        L_0x0092:
            r0 = r14.O0000O0o();
            if (r0 == 0) goto L_0x00b9;
        L_0x0098:
            r0 = r14.O0000OOo();
            r0 = r0.O0000oO0();
            r11 = "table";
            r0 = r0.equals(r11);
            if (r0 == 0) goto L_0x00b9;
        L_0x00a8:
            r15.O00000Oo(r13);
            r0 = "caption";
            r0 = r15.O0000o00(r0);
            if (r0 == 0) goto L_0x00b8;
        L_0x00b3:
            r14 = r15.O000000o(r14);
            return r14;
        L_0x00b8:
            return r1;
        L_0x00b9:
            r0 = r14.O0000O0o();
            if (r0 == 0) goto L_0x00fd;
        L_0x00bf:
            r0 = r14.O0000OOo();
            r0 = r0.O0000oO0();
            r11 = 10;
            r11 = new java.lang.String[r11];
            r12 = "body";
            r11[r2] = r12;
            r12 = "col";
            r11[r1] = r12;
            r1 = "colgroup";
            r11[r9] = r1;
            r1 = "html";
            r11[r8] = r1;
            r1 = "tbody";
            r11[r7] = r1;
            r1 = "td";
            r11[r6] = r1;
            r1 = "tfoot";
            r11[r5] = r1;
            r1 = "th";
            r11[r4] = r1;
            r1 = "thead";
            r11[r3] = r1;
            r1 = "tr";
            r11[r10] = r1;
            r0 = org.jsoup.helper.StringUtil.O000000o(r0, r11);
            if (r0 == 0) goto L_0x00fd;
        L_0x00f9:
            r15.O00000Oo(r13);
            return r2;
        L_0x00fd:
            r0 = InBody;
            r14 = r15.O000000o(r14, r0);
            return r14;
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilderState$AnonymousClass11.O000000o(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }
    },
    InColumnGroup {
        private boolean O000000o(Token token, TreeBuilder treeBuilder) {
            return treeBuilder.O0000o00("colgroup") ? treeBuilder.O000000o(token) : true;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.O00000Oo(token)) {
                htmlTreeBuilder.O000000o(token.O0000Ooo());
                return true;
            }
            int i = AnonymousClass24.O000000o[token.O000000o.ordinal()];
            if (i == 6) {
                return htmlTreeBuilder.O00oOooo().O000000o().equals("html") ? true : O000000o(token, (TreeBuilder) htmlTreeBuilder);
            } else {
                switch (i) {
                    case 1:
                        htmlTreeBuilder.O000000o(token.O0000Oo());
                        break;
                    case 2:
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        break;
                    case 3:
                        StartTag O00000oo = token.O00000oo();
                        String O0000oO0 = O00000oo.O0000oO0();
                        if (O0000oO0.equals("html")) {
                            return htmlTreeBuilder.O000000o(token, InBody);
                        }
                        if (O0000oO0.equals("col")) {
                            htmlTreeBuilder.O00000Oo(O00000oo);
                            break;
                        }
                        return O000000o(token, (TreeBuilder) htmlTreeBuilder);
                    case 4:
                        if (token.O0000OOo().O0000oO0().equals("colgroup")) {
                            if (!htmlTreeBuilder.O00oOooo().O000000o().equals("html")) {
                                htmlTreeBuilder.O0000Oo0();
                                htmlTreeBuilder.O000000o(InTable);
                                break;
                            }
                            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                            return false;
                        }
                        return O000000o(token, (TreeBuilder) htmlTreeBuilder);
                    default:
                        return O000000o(token, (TreeBuilder) htmlTreeBuilder);
                }
                return true;
            }
        }
    },
    InTableBody {
        private boolean O00000Oo(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.O0000OOo("tbody") || htmlTreeBuilder.O0000OOo("thead") || htmlTreeBuilder.O00000oO("tfoot")) {
                htmlTreeBuilder.O0000Ooo();
                htmlTreeBuilder.O0000o00(htmlTreeBuilder.O00oOooo().O000000o());
                return htmlTreeBuilder.O000000o(token);
            }
            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
            return false;
        }

        private boolean O00000o0(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.O000000o(token, InTable);
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass24.O000000o[token.O000000o.ordinal()]) {
                case 3:
                    Token O00000oo = token.O00000oo();
                    String O0000oO0 = O00000oo.O0000oO0();
                    if (O0000oO0.equals("tr")) {
                        htmlTreeBuilder.O0000Ooo();
                        htmlTreeBuilder.O000000o((StartTag) O00000oo);
                        htmlTreeBuilder.O000000o(InRow);
                        break;
                    }
                    if (StringUtil.O000000o(O0000oO0, "th", "td")) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        htmlTreeBuilder.O0000Ooo("tr");
                        return htmlTreeBuilder.O000000o(O00000oo);
                    }
                    return StringUtil.O000000o(O0000oO0, "caption", "col", "colgroup", "tbody", "tfoot", "thead") ? O00000Oo(token, htmlTreeBuilder) : O00000o0(token, htmlTreeBuilder);
                case 4:
                    String O0000oO02 = token.O0000OOo().O0000oO0();
                    if (StringUtil.O000000o(O0000oO02, "tbody", "tfoot", "thead")) {
                        if (htmlTreeBuilder.O0000OOo(O0000oO02)) {
                            htmlTreeBuilder.O0000Ooo();
                            htmlTreeBuilder.O0000Oo0();
                            htmlTreeBuilder.O000000o(InTable);
                            break;
                        }
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    } else if (O0000oO02.equals("table")) {
                        return O00000Oo(token, htmlTreeBuilder);
                    } else {
                        if (!StringUtil.O000000o(O0000oO02, "body", "caption", "col", "colgroup", "html", "td", "th", "tr")) {
                            return O00000o0(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    }
                default:
                    return O00000o0(token, htmlTreeBuilder);
            }
            return true;
        }
    },
    InRow {
        private boolean O000000o(Token token, TreeBuilder treeBuilder) {
            return treeBuilder.O0000o00("tr") ? treeBuilder.O000000o(token) : false;
        }

        private boolean O00000Oo(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.O000000o(token, InTable);
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.O00000oO()) {
                StartTag O00000oo = token.O00000oo();
                String O0000oO0 = O00000oo.O0000oO0();
                if (StringUtil.O000000o(O0000oO0, "th", "td")) {
                    htmlTreeBuilder.O0000o00();
                    htmlTreeBuilder.O000000o(O00000oo);
                    htmlTreeBuilder.O000000o(InCell);
                    htmlTreeBuilder.O0000ooo();
                } else {
                    return StringUtil.O000000o(O0000oO0, "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr") ? O000000o(token, (TreeBuilder) htmlTreeBuilder) : O00000Oo(token, htmlTreeBuilder);
                }
            } else if (!token.O0000O0o()) {
                return O00000Oo(token, htmlTreeBuilder);
            } else {
                String O0000oO02 = token.O0000OOo().O0000oO0();
                if (O0000oO02.equals("tr")) {
                    if (htmlTreeBuilder.O0000OOo(O0000oO02)) {
                        htmlTreeBuilder.O0000o00();
                        htmlTreeBuilder.O0000Oo0();
                        htmlTreeBuilder.O000000o(InTableBody);
                    } else {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    }
                } else if (O0000oO02.equals("table")) {
                    return O000000o(token, (TreeBuilder) htmlTreeBuilder);
                } else {
                    if (!StringUtil.O000000o(O0000oO02, "tbody", "tfoot", "thead")) {
                        if (!StringUtil.O000000o(O0000oO02, "body", "caption", "col", "colgroup", "html", "td", "th")) {
                            return O00000Oo(token, htmlTreeBuilder);
                        }
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    } else if (htmlTreeBuilder.O0000OOo(O0000oO02)) {
                        htmlTreeBuilder.O0000o00("tr");
                        return htmlTreeBuilder.O000000o(token);
                    } else {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    }
                }
            }
            return true;
        }
    },
    InCell {
        private void O000000o(HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.O0000OOo("td")) {
                htmlTreeBuilder.O0000o00("td");
            } else {
                htmlTreeBuilder.O0000o00("th");
            }
        }

        private boolean O00000Oo(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return htmlTreeBuilder.O000000o(token, InBody);
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.O0000O0o()) {
                String O0000oO0 = token.O0000OOo().O0000oO0();
                if (!StringUtil.O000000o(O0000oO0, "td", "th")) {
                    if (StringUtil.O000000o(O0000oO0, "body", "caption", "col", "colgroup", "html")) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    }
                    if (!StringUtil.O000000o(O0000oO0, "table", "tbody", "tfoot", "thead", "tr")) {
                        return O00000Oo(token, htmlTreeBuilder);
                    }
                    if (htmlTreeBuilder.O0000OOo(O0000oO0)) {
                        O000000o(htmlTreeBuilder);
                        return htmlTreeBuilder.O000000o(token);
                    }
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                } else if (htmlTreeBuilder.O0000OOo(O0000oO0)) {
                    htmlTreeBuilder.O0000oOO();
                    if (!htmlTreeBuilder.O00oOooo().O000000o().equals(O0000oO0)) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    }
                    htmlTreeBuilder.O00000o0(O0000oO0);
                    htmlTreeBuilder.O0000ooO();
                    htmlTreeBuilder.O000000o(InRow);
                    return true;
                } else {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    htmlTreeBuilder.O000000o(InRow);
                    return false;
                }
            }
            if (token.O00000oO()) {
                if (StringUtil.O000000o(token.O00000oo().O0000oO0(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                    if (htmlTreeBuilder.O0000OOo("td") || htmlTreeBuilder.O0000OOo("th")) {
                        O000000o(htmlTreeBuilder);
                        return htmlTreeBuilder.O000000o(token);
                    }
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                }
            }
            return O00000Oo(token, htmlTreeBuilder);
        }
    },
    InSelect {
        private boolean O00000Oo(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
            return false;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            switch (AnonymousClass24.O000000o[token.O000000o.ordinal()]) {
                case 1:
                    htmlTreeBuilder.O000000o(token.O0000Oo());
                    break;
                case 2:
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                case 3:
                    Token O00000oo = token.O00000oo();
                    String O0000oO0 = O00000oo.O0000oO0();
                    if (O0000oO0.equals("html")) {
                        return htmlTreeBuilder.O000000o(O00000oo, InBody);
                    }
                    if (O0000oO0.equals("option")) {
                        htmlTreeBuilder.O0000o00("option");
                        htmlTreeBuilder.O000000o((StartTag) O00000oo);
                        break;
                    } else if (O0000oO0.equals("optgroup")) {
                        if (htmlTreeBuilder.O00oOooo().O000000o().equals("option")) {
                            htmlTreeBuilder.O0000o00("option");
                        } else if (htmlTreeBuilder.O00oOooo().O000000o().equals("optgroup")) {
                            htmlTreeBuilder.O0000o00("optgroup");
                        }
                        htmlTreeBuilder.O000000o((StartTag) O00000oo);
                        break;
                    } else if (O0000oO0.equals("select")) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return htmlTreeBuilder.O0000o00("select");
                    } else {
                        if (!StringUtil.O000000o(O0000oO0, "input", "keygen", "textarea")) {
                            return O0000oO0.equals("script") ? htmlTreeBuilder.O000000o(token, InHead) : O00000Oo(token, htmlTreeBuilder);
                        } else {
                            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                            if (!htmlTreeBuilder.O0000Oo0("select")) {
                                return false;
                            }
                            htmlTreeBuilder.O0000o00("select");
                            return htmlTreeBuilder.O000000o(O00000oo);
                        }
                    }
                case 4:
                    String O0000oO02 = token.O0000OOo().O0000oO0();
                    if (O0000oO02.equals("optgroup")) {
                        if (htmlTreeBuilder.O00oOooo().O000000o().equals("option") && htmlTreeBuilder.O00000oo(htmlTreeBuilder.O00oOooo()) != null && htmlTreeBuilder.O00000oo(htmlTreeBuilder.O00oOooo()).O000000o().equals("optgroup")) {
                            htmlTreeBuilder.O0000o00("option");
                        }
                        if (!htmlTreeBuilder.O00oOooo().O000000o().equals("optgroup")) {
                            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                            break;
                        }
                        htmlTreeBuilder.O0000Oo0();
                        break;
                    } else if (O0000oO02.equals("option")) {
                        if (!htmlTreeBuilder.O00oOooo().O000000o().equals("option")) {
                            htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                            break;
                        }
                        htmlTreeBuilder.O0000Oo0();
                        break;
                    } else if (O0000oO02.equals("select")) {
                        if (htmlTreeBuilder.O0000Oo0(O0000oO02)) {
                            htmlTreeBuilder.O00000o0(O0000oO02);
                            htmlTreeBuilder.O0000o0();
                            break;
                        }
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    } else {
                        return O00000Oo(token, htmlTreeBuilder);
                    }
                case 5:
                    Character O0000Ooo = token.O0000Ooo();
                    if (!O0000Ooo.O0000o0().equals(HtmlTreeBuilderState.O0000ooO)) {
                        htmlTreeBuilder.O000000o(O0000Ooo);
                        break;
                    }
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                case 6:
                    if (!htmlTreeBuilder.O00oOooo().O000000o().equals("html")) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        break;
                    }
                    break;
                default:
                    return O00000Oo(token, htmlTreeBuilder);
            }
            return true;
        }
    },
    InSelectInTable {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.O00000oO()) {
                if (StringUtil.O000000o(token.O00000oo().O0000oO0(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    htmlTreeBuilder.O0000o00("select");
                    return htmlTreeBuilder.O000000o(token);
                }
            }
            if (token.O0000O0o()) {
                if (StringUtil.O000000o(token.O0000OOo().O0000oO0(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    if (!htmlTreeBuilder.O0000OOo(token.O0000OOo().O0000oO0())) {
                        return false;
                    }
                    htmlTreeBuilder.O0000o00("select");
                    return htmlTreeBuilder.O000000o(token);
                }
            }
            return htmlTreeBuilder.O000000o(token, InSelect);
        }
    },
    AfterBody {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.O00000Oo(token)) {
                return htmlTreeBuilder.O000000o(token, InBody);
            }
            if (token.O0000Oo0()) {
                htmlTreeBuilder.O000000o(token.O0000Oo());
            } else if (token.O00000o0()) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                return false;
            } else if (token.O00000oO() && token.O00000oo().O0000oO0().equals("html")) {
                return htmlTreeBuilder.O000000o(token, InBody);
            } else {
                if (token.O0000O0o() && token.O0000OOo().O0000oO0().equals("html")) {
                    if (htmlTreeBuilder.O0000OOo()) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    }
                    htmlTreeBuilder.O000000o(AfterAfterBody);
                } else if (!token.O0000o00()) {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    htmlTreeBuilder.O000000o(InBody);
                    return htmlTreeBuilder.O000000o(token);
                }
            }
            return true;
        }
    },
    InFrameset {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.O00000Oo(token)) {
                htmlTreeBuilder.O000000o(token.O0000Ooo());
            } else if (token.O0000Oo0()) {
                htmlTreeBuilder.O000000o(token.O0000Oo());
            } else if (token.O00000o0()) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                return false;
            } else if (token.O00000oO()) {
                token = token.O00000oo();
                String O0000oO0 = token.O0000oO0();
                if (O0000oO0.equals("html")) {
                    return htmlTreeBuilder.O000000o(token, InBody);
                }
                if (O0000oO0.equals("frameset")) {
                    htmlTreeBuilder.O000000o((StartTag) token);
                } else if (O0000oO0.equals("frame")) {
                    htmlTreeBuilder.O00000Oo((StartTag) token);
                } else if (O0000oO0.equals("noframes")) {
                    return htmlTreeBuilder.O000000o(token, InHead);
                } else {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                }
            } else if (token.O0000O0o() && token.O0000OOo().O0000oO0().equals("frameset")) {
                if (htmlTreeBuilder.O00oOooo().O000000o().equals("html")) {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                }
                htmlTreeBuilder.O0000Oo0();
                if (!(htmlTreeBuilder.O0000OOo() || htmlTreeBuilder.O00oOooo().O000000o().equals("frameset"))) {
                    htmlTreeBuilder.O000000o(AfterFrameset);
                }
            } else if (!token.O0000o00()) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                return false;
            } else if (!htmlTreeBuilder.O00oOooo().O000000o().equals("html")) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                return true;
            }
            return true;
        }
    },
    AfterFrameset {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (HtmlTreeBuilderState.O00000Oo(token)) {
                htmlTreeBuilder.O000000o(token.O0000Ooo());
            } else if (token.O0000Oo0()) {
                htmlTreeBuilder.O000000o(token.O0000Oo());
            } else if (token.O00000o0()) {
                htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                return false;
            } else if (token.O00000oO() && token.O00000oo().O0000oO0().equals("html")) {
                return htmlTreeBuilder.O000000o(token, InBody);
            } else {
                if (token.O0000O0o() && token.O0000OOo().O0000oO0().equals("html")) {
                    htmlTreeBuilder.O000000o(AfterAfterFrameset);
                } else if (token.O00000oO() && token.O00000oo().O0000oO0().equals("noframes")) {
                    return htmlTreeBuilder.O000000o(token, InHead);
                } else {
                    if (!token.O0000o00()) {
                        htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                        return false;
                    }
                }
            }
            return true;
        }
    },
    AfterAfterBody {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.O0000Oo0()) {
                htmlTreeBuilder.O000000o(token.O0000Oo());
            } else if (token.O00000o0() || HtmlTreeBuilderState.O00000Oo(token) || (token.O00000oO() && token.O00000oo().O0000oO0().equals("html"))) {
                return htmlTreeBuilder.O000000o(token, InBody);
            } else {
                if (!token.O0000o00()) {
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    htmlTreeBuilder.O000000o(InBody);
                    return htmlTreeBuilder.O000000o(token);
                }
            }
            return true;
        }
    },
    AfterAfterFrameset {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.O0000Oo0()) {
                htmlTreeBuilder.O000000o(token.O0000Oo());
            } else if (token.O00000o0() || HtmlTreeBuilderState.O00000Oo(token) || (token.O00000oO() && token.O00000oo().O0000oO0().equals("html"))) {
                return htmlTreeBuilder.O000000o(token, InBody);
            } else {
                if (!token.O0000o00()) {
                    if (token.O00000oO() && token.O00000oo().O0000oO0().equals("noframes")) {
                        return htmlTreeBuilder.O000000o(token, InHead);
                    }
                    htmlTreeBuilder.O00000Oo((HtmlTreeBuilderState) this);
                    return false;
                }
            }
            return true;
        }
    },
    ForeignContent {
        /* Access modifiers changed, original: 0000 */
        public boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    private static String O0000ooO;

    private static final class Constants {
        private static final String[] O000000o = null;
        private static final String[] O00000Oo = null;
        private static final String[] O00000o = null;
        private static final String[] O00000o0 = null;
        private static final String[] O00000oO = null;
        private static final String[] O00000oo = null;
        private static final String[] O0000O0o = null;
        private static final String[] O0000OOo = null;
        private static final String[] O0000Oo = null;
        private static final String[] O0000Oo0 = null;
        private static final String[] O0000OoO = null;
        private static final String[] O0000Ooo = null;
        private static final String[] O0000o = null;
        private static final String[] O0000o0 = null;
        private static final String[] O0000o00 = null;
        private static final String[] O0000o0O = null;
        private static final String[] O0000o0o = null;

        static {
            O000000o = new String[]{"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title"};
            O00000Oo = new String[]{"address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", e.ao, "section", db.O000Oooo, "ul"};
            O00000o0 = new String[]{"h1", "h2", "h3", "h4", "h5", "h6"};
            O00000o = new String[]{"pre", "listing"};
            O00000oO = new String[]{"address", "div", e.ao};
            O00000oo = new String[]{"dd", db.O0000o00};
            O0000O0o = new String[]{"b", "big", "code", "em", "font", e.aq, e.ap, "small", "strike", "strong", "tt", "u"};
            O0000OOo = new String[]{"applet", "marquee", "object"};
            O0000Oo0 = new String[]{"area", "br", "embed", "img", "keygen", "wbr"};
            O0000Oo = new String[]{"param", "source", "track"};
            O0000OoO = new String[]{cu.O000OO0o, "action", "prompt"};
            O0000Ooo = new String[]{"optgroup", "option"};
            O0000o00 = new String[]{"rp", "rt"};
            O0000o0 = new String[]{"caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
            O0000o0O = new String[]{"address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", db.O000Oooo, "ul"};
            O0000o0o = new String[]{e.al, "b", "big", "code", "em", "font", e.aq, "nobr", e.ap, "small", "strike", "strong", "tt", "u"};
            O0000o = new String[]{"table", "tbody", "tfoot", "thead", "tr"};
        }

        private Constants() {
        }
    }

    static {
        O0000ooO = String.valueOf(0);
    }

    private static boolean O00000Oo(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!StringUtil.O00000Oo(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean O00000Oo(Token token) {
        return token.O0000OoO() ? O00000Oo(token.O0000Ooo().O0000o0()) : false;
    }

    private static void O00000o(StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.O000000o(startTag);
        htmlTreeBuilder.O00000o.O000000o(TokeniserState.Rawtext);
        htmlTreeBuilder.O00000o0();
        htmlTreeBuilder.O000000o(Text);
    }

    private static void O00000o0(StartTag startTag, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.O000000o(startTag);
        htmlTreeBuilder.O00000o.O000000o(TokeniserState.Rcdata);
        htmlTreeBuilder.O00000o0();
        htmlTreeBuilder.O000000o(Text);
    }

    public abstract boolean O000000o(Token token, HtmlTreeBuilder htmlTreeBuilder);
}
