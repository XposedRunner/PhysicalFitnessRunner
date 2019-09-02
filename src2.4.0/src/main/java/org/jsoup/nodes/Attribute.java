package org.jsoup.nodes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map.Entry;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;
import org.jsoup.nodes.Document.OutputSettings.Syntax;

public class Attribute implements Cloneable, Entry<String, String> {
    private static final String[] O000000o = new String[]{"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    private String O00000Oo;
    private String O00000o0;

    public Attribute(String str, String str2) {
        Validate.O000000o(str);
        Validate.O000000o((Object) str2);
        this.O00000Oo = str.trim();
        this.O00000o0 = str2;
    }

    public static Attribute O000000o(String str, String str2) {
        return new Attribute(str, Entities.O000000o(str2, true));
    }

    /* renamed from: O000000o */
    public String getKey() {
        return this.O00000Oo;
    }

    /* Access modifiers changed, original: protected */
    public void O000000o(Appendable appendable, OutputSettings outputSettings) throws IOException {
        appendable.append(this.O00000Oo);
        if (!O000000o(outputSettings)) {
            appendable.append("=\"");
            Entities.O000000o(appendable, this.O00000o0, outputSettings, true, false, false);
            appendable.append('\"');
        }
    }

    public void O000000o(String str) {
        Validate.O000000o(str);
        this.O00000Oo = str.trim();
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean O000000o(OutputSettings outputSettings) {
        return ("".equals(this.O00000o0) || this.O00000o0.equalsIgnoreCase(this.O00000Oo)) && outputSettings.O00000o() == Syntax.html && O00000oO();
    }

    /* renamed from: O00000Oo */
    public String getValue() {
        return this.O00000o0;
    }

    /* renamed from: O00000Oo */
    public String setValue(String str) {
        Validate.O000000o((Object) str);
        String str2 = this.O00000o0;
        this.O00000o0 = str;
        return str2;
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000o() {
        return this.O00000Oo.startsWith("data-") && this.O00000Oo.length() > "data-".length();
    }

    public String O00000o0() {
        Appendable stringBuilder = new StringBuilder();
        try {
            O000000o(stringBuilder, new Document("").O0000OoO());
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean O00000oO() {
        return Arrays.binarySearch(O000000o, this.O00000Oo) >= 0;
    }

    /* renamed from: O00000oo */
    public Attribute clone() {
        try {
            return (Attribute) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attribute)) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        if (!this.O00000Oo == null ? this.O00000Oo.equals(attribute.O00000Oo) : attribute.O00000Oo == null) {
            return false;
        }
        if (this.O00000o0 == null ? attribute.O00000o0 != null : !this.O00000o0.equals(attribute.O00000o0)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = 31 * (this.O00000Oo != null ? this.O00000Oo.hashCode() : 0);
        if (this.O00000o0 != null) {
            i = this.O00000o0.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return O00000o0();
    }
}
