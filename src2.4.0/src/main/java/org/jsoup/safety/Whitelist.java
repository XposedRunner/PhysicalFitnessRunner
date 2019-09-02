package org.jsoup.safety;

import com.umeng.commonsdk.proguard.e;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import defpackage.db;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;

public class Whitelist {
    private Set<TagName> O000000o = new HashSet();
    private Map<TagName, Set<AttributeKey>> O00000Oo = new HashMap();
    private Map<TagName, Map<AttributeKey, Set<Protocol>>> O00000o = new HashMap();
    private Map<TagName, Map<AttributeKey, AttributeValue>> O00000o0 = new HashMap();
    private boolean O00000oO = false;

    static abstract class TypedValue {
        private String O000000o;

        TypedValue(String str) {
            Validate.O000000o((Object) str);
            this.O000000o = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            TypedValue typedValue = (TypedValue) obj;
            if (this.O000000o == null) {
                if (typedValue.O000000o != null) {
                    return false;
                }
            } else if (!this.O000000o.equals(typedValue.O000000o)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return 31 + (this.O000000o == null ? 0 : this.O000000o.hashCode());
        }

        public String toString() {
            return this.O000000o;
        }
    }

    static class AttributeKey extends TypedValue {
        AttributeKey(String str) {
            super(str);
        }

        static AttributeKey O000000o(String str) {
            return new AttributeKey(str);
        }
    }

    static class AttributeValue extends TypedValue {
        AttributeValue(String str) {
            super(str);
        }

        static AttributeValue O000000o(String str) {
            return new AttributeValue(str);
        }
    }

    static class Protocol extends TypedValue {
        Protocol(String str) {
            super(str);
        }

        static Protocol O000000o(String str) {
            return new Protocol(str);
        }
    }

    static class TagName extends TypedValue {
        TagName(String str) {
            super(str);
        }

        static TagName O000000o(String str) {
            return new TagName(str);
        }
    }

    public static Whitelist O000000o() {
        return new Whitelist();
    }

    private boolean O000000o(Element element, Attribute attribute, Set<Protocol> set) {
        String O000OOOo = element.O000OOOo(attribute.getKey());
        if (O000OOOo.length() == 0) {
            O000OOOo = attribute.getValue();
        }
        if (!this.O00000oO) {
            attribute.setValue(O000OOOo);
        }
        for (Protocol protocol : set) {
            String protocol2 = protocol.toString();
            if (!protocol2.equals("#")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(protocol2);
                stringBuilder.append(":");
                if (O000OOOo.toLowerCase().startsWith(stringBuilder.toString())) {
                    return true;
                }
            } else if (O00000o0(O000OOOo)) {
                return true;
            }
        }
        return false;
    }

    public static Whitelist O00000Oo() {
        return new Whitelist().O000000o("b", "em", e.aq, "strong", "u");
    }

    public static Whitelist O00000o() {
        return O00000o0().O000000o("img").O000000o("img", "align", "alt", db.O000o0OO, "src", "title", db.O000o0O).O000000o("img", "src", "http", "https");
    }

    public static Whitelist O00000o0() {
        String[] strArr = new String[]{"cite"};
        return new Whitelist().O000000o(e.al, "b", "blockquote", "br", "cite", "code", "dd", "dl", db.O0000o00, "em", e.aq, "li", "ol", e.ao, "pre", DTransferConstants.SEARCH_KEY, "small", "span", "strike", "strong", "sub", "sup", "u", "ul").O000000o(e.al, "href").O000000o("blockquote", strArr).O000000o(DTransferConstants.SEARCH_KEY, "cite").O000000o(e.al, "href", "ftp", "http", "https", "mailto").O000000o("blockquote", "cite", "http", "https").O000000o("cite", "cite", "http", "https").O000000o(e.al, "rel", "nofollow");
    }

    private boolean O00000o0(String str) {
        return str.startsWith("#") && !str.matches(".*\\s.*");
    }

    public static Whitelist O00000oO() {
        String[] strArr = new String[]{"cite"};
        strArr = new String[]{"span", db.O000o0O};
        strArr = new String[]{"span", db.O000o0O};
        strArr = new String[]{"align", "alt", db.O000o0OO, "src", "title", db.O000o0O};
        strArr = new String[]{"start", "type"};
        Whitelist O000000o = new Whitelist().O000000o(e.al, "b", "blockquote", "br", "caption", "cite", "code", "col", "colgroup", "dd", "div", "dl", db.O0000o00, "em", "h1", "h2", "h3", "h4", "h5", "h6", e.aq, "img", "li", "ol", e.ao, "pre", DTransferConstants.SEARCH_KEY, "small", "span", "strike", "strong", "sub", "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", "u", "ul").O000000o(e.al, "href", "title").O000000o("blockquote", strArr).O000000o("col", strArr).O000000o("colgroup", strArr).O000000o("img", strArr).O000000o("ol", strArr);
        return O000000o.O000000o(DTransferConstants.SEARCH_KEY, "cite").O000000o("table", db.O000Oooo, db.O000o0O).O000000o("td", "abbr", "axis", "colspan", "rowspan", db.O000o0O).O000000o("th", "abbr", "axis", "colspan", "rowspan", "scope", db.O000o0O).O000000o("ul", "type").O000000o(e.al, "href", "ftp", "http", "https", "mailto").O000000o("blockquote", "cite", "http", "https").O000000o("cite", "cite", "http", "https").O000000o("img", "src", "http", "https").O000000o(DTransferConstants.SEARCH_KEY, "cite", "http", "https");
    }

    public Whitelist O000000o(String str, String str2) {
        Validate.O000000o(str);
        Validate.O000000o(str2);
        TagName O000000o = TagName.O000000o(str);
        if (this.O000000o.contains(O000000o) && this.O00000o0.containsKey(O000000o)) {
            Map map = (Map) this.O00000o0.get(O000000o);
            map.remove(AttributeKey.O000000o(str2));
            if (map.isEmpty()) {
                this.O00000o0.remove(O000000o);
            }
        }
        return this;
    }

    public Whitelist O000000o(String str, String str2, String str3) {
        Validate.O000000o(str);
        Validate.O000000o(str2);
        Validate.O000000o(str3);
        TagName O000000o = TagName.O000000o(str);
        if (!this.O000000o.contains(O000000o)) {
            this.O000000o.add(O000000o);
        }
        AttributeKey O000000o2 = AttributeKey.O000000o(str2);
        AttributeValue O000000o3 = AttributeValue.O000000o(str3);
        if (this.O00000o0.containsKey(O000000o)) {
            ((Map) this.O00000o0.get(O000000o)).put(O000000o2, O000000o3);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(O000000o2, O000000o3);
            this.O00000o0.put(O000000o, hashMap);
        }
        return this;
    }

    public Whitelist O000000o(String str, String str2, String... strArr) {
        Map map;
        Set set;
        Validate.O000000o(str);
        Validate.O000000o(str2);
        Validate.O000000o((Object) strArr);
        TagName O000000o = TagName.O000000o(str);
        AttributeKey O000000o2 = AttributeKey.O000000o(str2);
        if (this.O00000o.containsKey(O000000o)) {
            map = (Map) this.O00000o.get(O000000o);
        } else {
            HashMap hashMap = new HashMap();
            this.O00000o.put(O000000o, hashMap);
            map = hashMap;
        }
        if (map.containsKey(O000000o2)) {
            set = (Set) map.get(O000000o2);
        } else {
            HashSet hashSet = new HashSet();
            map.put(O000000o2, hashSet);
            set = hashSet;
        }
        for (String str3 : strArr) {
            Validate.O000000o(str3);
            set.add(Protocol.O000000o(str3));
        }
        return this;
    }

    public Whitelist O000000o(String str, String... strArr) {
        Validate.O000000o(str);
        Validate.O000000o((Object) strArr);
        int i = 0;
        Validate.O000000o(strArr.length > 0, "No attribute names supplied.");
        TagName O000000o = TagName.O000000o(str);
        if (!this.O000000o.contains(O000000o)) {
            this.O000000o.add(O000000o);
        }
        HashSet hashSet = new HashSet();
        int length = strArr.length;
        while (i < length) {
            String str2 = strArr[i];
            Validate.O000000o(str2);
            hashSet.add(AttributeKey.O000000o(str2));
            i++;
        }
        if (this.O00000Oo.containsKey(O000000o)) {
            ((Set) this.O00000Oo.get(O000000o)).addAll(hashSet);
        } else {
            this.O00000Oo.put(O000000o, hashSet);
        }
        return this;
    }

    public Whitelist O000000o(boolean z) {
        this.O00000oO = z;
        return this;
    }

    public Whitelist O000000o(String... strArr) {
        Validate.O000000o((Object) strArr);
        for (String str : strArr) {
            Validate.O000000o(str);
            this.O000000o.add(TagName.O000000o(str));
        }
        return this;
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(String str) {
        return this.O000000o.contains(TagName.O000000o(str));
    }

    /* Access modifiers changed, original: protected */
    public boolean O000000o(String str, Element element, Attribute attribute) {
        TagName O000000o = TagName.O000000o(str);
        AttributeKey O000000o2 = AttributeKey.O000000o(attribute.getKey());
        Set set = (Set) this.O00000Oo.get(O000000o);
        boolean z = false;
        if (set == null || !set.contains(O000000o2)) {
            if (((Map) this.O00000o0.get(O000000o)) != null) {
                Attributes O00000Oo = O00000Oo(str);
                String O000000o3 = attribute.getKey();
                if (O00000Oo.O00000oo(O000000o3)) {
                    return O00000Oo.O00000Oo(O000000o3).equals(attribute.getValue());
                }
            }
            if (!str.equals(":all") && O000000o(":all", element, attribute)) {
                z = true;
            }
            return z;
        } else if (!this.O00000o.containsKey(O000000o)) {
            return true;
        } else {
            Map map = (Map) this.O00000o.get(O000000o);
            if (!map.containsKey(O000000o2) || O000000o(element, attribute, (Set) map.get(O000000o2))) {
                z = true;
            }
            return z;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Attributes O00000Oo(String str) {
        Attributes attributes = new Attributes();
        TagName O000000o = TagName.O000000o(str);
        if (this.O00000o0.containsKey(O000000o)) {
            for (Entry entry : ((Map) this.O00000o0.get(O000000o)).entrySet()) {
                attributes.O000000o(((AttributeKey) entry.getKey()).toString(), ((AttributeValue) entry.getValue()).toString());
            }
        }
        return attributes;
    }

    public Whitelist O00000Oo(String str, String str2, String... strArr) {
        Validate.O000000o(str);
        Validate.O000000o(str2);
        Validate.O000000o((Object) strArr);
        TagName O000000o = TagName.O000000o(str);
        AttributeKey O000000o2 = AttributeKey.O000000o(str2);
        Validate.O000000o(this.O00000o.containsKey(O000000o), "Cannot remove a protocol that is not set.");
        Map map = (Map) this.O00000o.get(O000000o);
        Validate.O000000o(map.containsKey(O000000o2), "Cannot remove a protocol that is not set.");
        Set set = (Set) map.get(O000000o2);
        for (String str3 : strArr) {
            Validate.O000000o(str3);
            set.remove(Protocol.O000000o(str3));
        }
        if (set.isEmpty()) {
            map.remove(O000000o2);
            if (map.isEmpty()) {
                this.O00000o.remove(O000000o);
            }
        }
        return this;
    }

    public Whitelist O00000Oo(String str, String... strArr) {
        Validate.O000000o(str);
        Validate.O000000o((Object) strArr);
        int i = 0;
        Validate.O000000o(strArr.length > 0, "No attribute names supplied.");
        TagName O000000o = TagName.O000000o(str);
        HashSet hashSet = new HashSet();
        int length = strArr.length;
        while (i < length) {
            String str2 = strArr[i];
            Validate.O000000o(str2);
            hashSet.add(AttributeKey.O000000o(str2));
            i++;
        }
        if (this.O000000o.contains(O000000o) && this.O00000Oo.containsKey(O000000o)) {
            Set set = (Set) this.O00000Oo.get(O000000o);
            set.removeAll(hashSet);
            if (set.isEmpty()) {
                this.O00000Oo.remove(O000000o);
            }
        }
        if (str.equals(":all")) {
            for (TagName tagName : this.O00000Oo.keySet()) {
                Set set2 = (Set) this.O00000Oo.get(tagName);
                set2.removeAll(hashSet);
                if (set2.isEmpty()) {
                    this.O00000Oo.remove(tagName);
                }
            }
        }
        return this;
    }

    public Whitelist O00000Oo(String... strArr) {
        Validate.O000000o((Object) strArr);
        for (String str : strArr) {
            Validate.O000000o(str);
            TagName O000000o = TagName.O000000o(str);
            if (this.O000000o.remove(O000000o)) {
                this.O00000Oo.remove(O000000o);
                this.O00000o0.remove(O000000o);
                this.O00000o.remove(O000000o);
            }
        }
        return this;
    }
}
