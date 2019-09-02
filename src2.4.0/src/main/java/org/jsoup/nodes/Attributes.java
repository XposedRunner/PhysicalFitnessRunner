package org.jsoup.nodes;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document.OutputSettings;

public class Attributes implements Cloneable, Iterable<Attribute> {
    protected static final String O000000o = "data-";
    private LinkedHashMap<String, Attribute> O00000Oo = null;

    private class Dataset extends AbstractMap<String, String> {

        private class DatasetIterator implements Iterator<Entry<String, String>> {
            private Iterator<Attribute> O00000Oo;
            private Attribute O00000o0;

            private DatasetIterator() {
                this.O00000Oo = Attributes.this.O00000Oo.values().iterator();
            }

            /* renamed from: O000000o */
            public Entry<String, String> next() {
                return new Attribute(this.O00000o0.getKey().substring(Attributes.O000000o.length()), this.O00000o0.getValue());
            }

            public boolean hasNext() {
                while (this.O00000Oo.hasNext()) {
                    this.O00000o0 = (Attribute) this.O00000Oo.next();
                    if (this.O00000o0.O00000o()) {
                        return true;
                    }
                }
                return false;
            }

            public void remove() {
                Attributes.this.O00000Oo.remove(this.O00000o0.getKey());
            }
        }

        private class EntrySet extends AbstractSet<Entry<String, String>> {
            private EntrySet() {
            }

            public Iterator<Entry<String, String>> iterator() {
                return new DatasetIterator();
            }

            public int size() {
                int i = 0;
                while (new DatasetIterator().hasNext()) {
                    i++;
                }
                return i;
            }
        }

        private Dataset() {
            if (Attributes.this.O00000Oo == null) {
                Attributes.this.O00000Oo = new LinkedHashMap(2);
            }
        }

        /* renamed from: O000000o */
        public String put(String str, String str2) {
            str = Attributes.O0000OOo(str);
            String O00000Oo = Attributes.this.O00000oO(str) ? ((Attribute) Attributes.this.O00000Oo.get(str)).getValue() : null;
            Attributes.this.O00000Oo.put(str, new Attribute(str, str2));
            return O00000Oo;
        }

        public Set<Entry<String, String>> entrySet() {
            return new EntrySet();
        }
    }

    private static String O0000OOo(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(O000000o);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public int O000000o() {
        return this.O00000Oo == null ? 0 : this.O00000Oo.size();
    }

    public String O000000o(String str) {
        Validate.O000000o(str);
        if (this.O00000Oo == null) {
            return "";
        }
        Attribute attribute = (Attribute) this.O00000Oo.get(str);
        return attribute != null ? attribute.getValue() : "";
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(Appendable appendable, OutputSettings outputSettings) throws IOException {
        if (this.O00000Oo != null) {
            for (Entry value : this.O00000Oo.entrySet()) {
                Attribute attribute = (Attribute) value.getValue();
                appendable.append(" ");
                attribute.O000000o(appendable, outputSettings);
            }
        }
    }

    public void O000000o(String str, String str2) {
        O000000o(new Attribute(str, str2));
    }

    public void O000000o(String str, boolean z) {
        if (z) {
            O000000o(new BooleanAttribute(str));
        } else {
            O00000o0(str);
        }
    }

    public void O000000o(Attribute attribute) {
        Validate.O000000o((Object) attribute);
        if (this.O00000Oo == null) {
            this.O00000Oo = new LinkedHashMap(2);
        }
        this.O00000Oo.put(attribute.getKey(), attribute);
    }

    public void O000000o(Attributes attributes) {
        if (attributes.O000000o() != 0) {
            if (this.O00000Oo == null) {
                this.O00000Oo = new LinkedHashMap(attributes.O000000o());
            }
            this.O00000Oo.putAll(attributes.O00000Oo);
        }
    }

    public String O00000Oo(String str) {
        Validate.O000000o(str);
        if (this.O00000Oo == null) {
            return "";
        }
        for (String str2 : this.O00000Oo.keySet()) {
            if (str2.equalsIgnoreCase(str)) {
                return ((Attribute) this.O00000Oo.get(str2)).getValue();
            }
        }
        return "";
    }

    public List<Attribute> O00000Oo() {
        if (this.O00000Oo == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.O00000Oo.size());
        for (Entry value : this.O00000Oo.entrySet()) {
            arrayList.add(value.getValue());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String O00000o() {
        Appendable stringBuilder = new StringBuilder();
        try {
            O000000o(stringBuilder, new Document("").O0000OoO());
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public void O00000o(String str) {
        Validate.O000000o(str);
        if (this.O00000Oo != null) {
            Iterator it = this.O00000Oo.keySet().iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equalsIgnoreCase(str)) {
                    it.remove();
                }
            }
        }
    }

    public Map<String, String> O00000o0() {
        return new Dataset();
    }

    public void O00000o0(String str) {
        Validate.O000000o(str);
        if (this.O00000Oo != null) {
            this.O00000Oo.remove(str);
        }
    }

    /* renamed from: O00000oO */
    public Attributes clone() {
        if (this.O00000Oo == null) {
            return new Attributes();
        }
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.O00000Oo = new LinkedHashMap(this.O00000Oo.size());
            Iterator it = iterator();
            while (it.hasNext()) {
                Attribute attribute = (Attribute) it.next();
                attributes.O00000Oo.put(attribute.getKey(), attribute.clone());
            }
            return attributes;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean O00000oO(String str) {
        return this.O00000Oo != null && this.O00000Oo.containsKey(str);
    }

    public boolean O00000oo(String str) {
        if (this.O00000Oo == null) {
            return false;
        }
        for (String equalsIgnoreCase : this.O00000Oo.keySet()) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attributes)) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.O00000Oo == null ? attributes.O00000Oo != null : !this.O00000Oo.equals(attributes.O00000Oo)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return this.O00000Oo != null ? this.O00000Oo.hashCode() : 0;
    }

    public Iterator<Attribute> iterator() {
        return (this.O00000Oo == null || this.O00000Oo.isEmpty()) ? Collections.emptyList().iterator() : this.O00000Oo.values().iterator();
    }

    public String toString() {
        return O00000o();
    }
}
