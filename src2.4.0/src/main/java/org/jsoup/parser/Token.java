package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.BooleanAttribute;

abstract class Token {
    TokenType O000000o;

    static final class Character extends Token {
        private String O00000Oo;

        Character() {
            super();
            this.O000000o = TokenType.Character;
        }

        /* Access modifiers changed, original: 0000 */
        public Character O000000o(String str) {
            this.O00000Oo = str;
            return this;
        }

        /* Access modifiers changed, original: 0000 */
        public Token O00000Oo() {
            this.O00000Oo = null;
            return this;
        }

        /* Access modifiers changed, original: 0000 */
        public String O0000o0() {
            return this.O00000Oo;
        }

        public String toString() {
            return O0000o0();
        }
    }

    static final class Comment extends Token {
        final StringBuilder O00000Oo;
        boolean O00000o0;

        Comment() {
            super();
            this.O00000Oo = new StringBuilder();
            this.O00000o0 = false;
            this.O000000o = TokenType.Comment;
        }

        /* Access modifiers changed, original: 0000 */
        public Token O00000Oo() {
            Token.O000000o(this.O00000Oo);
            this.O00000o0 = false;
            return this;
        }

        /* Access modifiers changed, original: 0000 */
        public String O0000o0() {
            return this.O00000Oo.toString();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<!--");
            stringBuilder.append(O0000o0());
            stringBuilder.append("-->");
            return stringBuilder.toString();
        }
    }

    static final class Doctype extends Token {
        final StringBuilder O00000Oo;
        final StringBuilder O00000o;
        String O00000o0;
        final StringBuilder O00000oO;
        boolean O00000oo;

        Doctype() {
            super();
            this.O00000Oo = new StringBuilder();
            this.O00000o0 = null;
            this.O00000o = new StringBuilder();
            this.O00000oO = new StringBuilder();
            this.O00000oo = false;
            this.O000000o = TokenType.Doctype;
        }

        /* Access modifiers changed, original: 0000 */
        public Token O00000Oo() {
            Token.O000000o(this.O00000Oo);
            this.O00000o0 = null;
            Token.O000000o(this.O00000o);
            Token.O000000o(this.O00000oO);
            this.O00000oo = false;
            return this;
        }

        public String O0000o() {
            return this.O00000oO.toString();
        }

        /* Access modifiers changed, original: 0000 */
        public String O0000o0() {
            return this.O00000Oo.toString();
        }

        /* Access modifiers changed, original: 0000 */
        public String O0000o0O() {
            return this.O00000o0;
        }

        /* Access modifiers changed, original: 0000 */
        public String O0000o0o() {
            return this.O00000o.toString();
        }

        public boolean O0000oO0() {
            return this.O00000oo;
        }
    }

    static final class EOF extends Token {
        EOF() {
            super();
            this.O000000o = TokenType.EOF;
        }

        /* Access modifiers changed, original: 0000 */
        public Token O00000Oo() {
            return this;
        }
    }

    static abstract class Tag extends Token {
        protected String O00000Oo;
        boolean O00000o = false;
        protected String O00000o0;
        Attributes O00000oO;
        private String O00000oo;
        private StringBuilder O0000O0o = new StringBuilder();
        private String O0000OOo;
        private boolean O0000Oo = false;
        private boolean O0000Oo0 = false;

        Tag() {
            super();
        }

        private void O0000oo0() {
            this.O0000Oo = true;
            if (this.O0000OOo != null) {
                this.O0000O0o.append(this.O0000OOo);
                this.O0000OOo = null;
            }
        }

        /* Access modifiers changed, original: final */
        public final Tag O000000o(String str) {
            this.O00000Oo = str;
            this.O00000o0 = str.toLowerCase();
            return this;
        }

        /* Access modifiers changed, original: final */
        public final void O000000o(char c) {
            O00000Oo(String.valueOf(c));
        }

        /* Access modifiers changed, original: final */
        public final void O000000o(char[] cArr) {
            O0000oo0();
            this.O0000O0o.append(cArr);
        }

        /* Access modifiers changed, original: final */
        public final void O000000o(int[] iArr) {
            O0000oo0();
            for (int appendCodePoint : iArr) {
                this.O0000O0o.appendCodePoint(appendCodePoint);
            }
        }

        /* Access modifiers changed, original: final */
        public final void O00000Oo(char c) {
            O00000o0(String.valueOf(c));
        }

        /* Access modifiers changed, original: final */
        public final void O00000Oo(String str) {
            if (this.O00000Oo != null) {
                str = this.O00000Oo.concat(str);
            }
            this.O00000Oo = str;
            this.O00000o0 = this.O00000Oo.toLowerCase();
        }

        /* Access modifiers changed, original: final */
        public final void O00000o(String str) {
            O0000oo0();
            if (this.O0000O0o.length() == 0) {
                this.O0000OOo = str;
            } else {
                this.O0000O0o.append(str);
            }
        }

        /* Access modifiers changed, original: final */
        public final void O00000o0(char c) {
            O0000oo0();
            this.O0000O0o.append(c);
        }

        /* Access modifiers changed, original: final */
        public final void O00000o0(String str) {
            if (this.O00000oo != null) {
                str = this.O00000oo.concat(str);
            }
            this.O00000oo = str;
        }

        /* Access modifiers changed, original: final */
        public final String O0000o() {
            boolean z = this.O00000Oo == null || this.O00000Oo.length() == 0;
            Validate.O00000Oo(z);
            return this.O00000Oo;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: O0000o0 */
        public Tag O00000Oo() {
            this.O00000Oo = null;
            this.O00000o0 = null;
            this.O00000oo = null;
            Token.O000000o(this.O0000O0o);
            this.O0000OOo = null;
            this.O0000Oo0 = false;
            this.O0000Oo = false;
            this.O00000o = false;
            this.O00000oO = null;
            return this;
        }

        /* Access modifiers changed, original: final */
        public final void O0000o0O() {
            if (this.O00000oO == null) {
                this.O00000oO = new Attributes();
            }
            if (this.O00000oo != null) {
                Attribute attribute;
                if (this.O0000Oo) {
                    attribute = new Attribute(this.O00000oo, this.O0000O0o.length() > 0 ? this.O0000O0o.toString() : this.O0000OOo);
                } else {
                    attribute = this.O0000Oo0 ? new Attribute(this.O00000oo, "") : new BooleanAttribute(this.O00000oo);
                }
                this.O00000oO.O000000o(attribute);
            }
            this.O00000oo = null;
            this.O0000Oo0 = false;
            this.O0000Oo = false;
            Token.O000000o(this.O0000O0o);
            this.O0000OOo = null;
        }

        /* Access modifiers changed, original: final */
        public final void O0000o0o() {
            if (this.O00000oo != null) {
                O0000o0O();
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean O0000oO() {
            return this.O00000o;
        }

        /* Access modifiers changed, original: final */
        public final String O0000oO0() {
            return this.O00000o0;
        }

        /* Access modifiers changed, original: final */
        public final Attributes O0000oOO() {
            return this.O00000oO;
        }

        /* Access modifiers changed, original: final */
        public final void O0000oOo() {
            this.O0000Oo0 = true;
        }
    }

    static final class EndTag extends Tag {
        EndTag() {
            this.O000000o = TokenType.EndTag;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("</");
            stringBuilder.append(O0000o());
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    static final class StartTag extends Tag {
        StartTag() {
            this.O00000oO = new Attributes();
            this.O000000o = TokenType.StartTag;
        }

        /* Access modifiers changed, original: 0000 */
        public StartTag O000000o(String str, Attributes attributes) {
            this.O00000Oo = str;
            this.O00000oO = attributes;
            this.O00000o0 = this.O00000Oo.toLowerCase();
            return this;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: O0000o0 */
        public Tag O00000Oo() {
            super.O00000Oo();
            this.O00000oO = new Attributes();
            return this;
        }

        public String toString() {
            StringBuilder stringBuilder;
            if (this.O00000oO == null || this.O00000oO.O000000o() <= 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("<");
                stringBuilder.append(O0000o());
                stringBuilder.append(">");
                return stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("<");
            stringBuilder.append(O0000o());
            stringBuilder.append(" ");
            stringBuilder.append(this.O00000oO.toString());
            stringBuilder.append(">");
            return stringBuilder.toString();
        }
    }

    enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    private Token() {
    }

    static void O000000o(StringBuilder stringBuilder) {
        if (stringBuilder != null) {
            stringBuilder.delete(0, stringBuilder.length());
        }
    }

    /* Access modifiers changed, original: 0000 */
    public String O000000o() {
        return getClass().getSimpleName();
    }

    public abstract Token O00000Oo();

    /* Access modifiers changed, original: final */
    public final Doctype O00000o() {
        return (Doctype) this;
    }

    /* Access modifiers changed, original: final */
    public final boolean O00000o0() {
        return this.O000000o == TokenType.Doctype;
    }

    /* Access modifiers changed, original: final */
    public final boolean O00000oO() {
        return this.O000000o == TokenType.StartTag;
    }

    /* Access modifiers changed, original: final */
    public final StartTag O00000oo() {
        return (StartTag) this;
    }

    /* Access modifiers changed, original: final */
    public final boolean O0000O0o() {
        return this.O000000o == TokenType.EndTag;
    }

    /* Access modifiers changed, original: final */
    public final EndTag O0000OOo() {
        return (EndTag) this;
    }

    /* Access modifiers changed, original: final */
    public final Comment O0000Oo() {
        return (Comment) this;
    }

    /* Access modifiers changed, original: final */
    public final boolean O0000Oo0() {
        return this.O000000o == TokenType.Comment;
    }

    /* Access modifiers changed, original: final */
    public final boolean O0000OoO() {
        return this.O000000o == TokenType.Character;
    }

    /* Access modifiers changed, original: final */
    public final Character O0000Ooo() {
        return (Character) this;
    }

    /* Access modifiers changed, original: final */
    public final boolean O0000o00() {
        return this.O000000o == TokenType.EOF;
    }
}
