package org.jsoup.nodes;

import defpackage.cu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Connection.KeyVal;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.helper.HttpConnection;
import org.jsoup.helper.Validate;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

public class FormElement extends Element {
    private final Elements O000000o = new Elements();

    public FormElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
    }

    public FormElement O00000Oo(Element element) {
        this.O000000o.add(element);
        return this;
    }

    public Elements O00000Oo() {
        return this.O000000o;
    }

    public List<KeyVal> O00000o() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.O000000o.iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element.O0000o0o().O0000Ooo()) {
                if (!element.O000OO00("disabled")) {
                    String O000O0oo = element.O000O0oo(cu.O000OO0o);
                    if (O000O0oo.length() != 0) {
                        String O000O0oo2 = element.O000O0oo("type");
                        if ("select".equals(element.O0000o0O())) {
                            Object obj = null;
                            Iterator it2 = element.O00000oo("option[selected]").iterator();
                            while (it2.hasNext()) {
                                arrayList.add(HttpConnection.KeyVal.O000000o(O000O0oo, ((Element) it2.next()).O000OOo0()));
                                obj = 1;
                            }
                            if (obj == null) {
                                element = element.O00000oo("option").O0000o0O();
                                if (element != null) {
                                    arrayList.add(HttpConnection.KeyVal.O000000o(O000O0oo, element.O000OOo0()));
                                }
                            }
                        } else if (!"checkbox".equalsIgnoreCase(O000O0oo2) && !"radio".equalsIgnoreCase(O000O0oo2)) {
                            arrayList.add(HttpConnection.KeyVal.O000000o(O000O0oo, element.O000OOo0()));
                        } else if (element.O000OO00("checked")) {
                            arrayList.add(HttpConnection.KeyVal.O000000o(O000O0oo, element.O000OOo0().length() > 0 ? element.O000OOo0() : "on"));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public Connection O00000o0() {
        String O000OOOo = O000OO00("action") ? O000OOOo("action") : O000Oo00();
        Validate.O000000o(O000OOOo, "Could not determine a form action URL for submit. Ensure you set a base URI when parsing.");
        return Jsoup.O00000Oo(O000OOOo).O000000o(O00000o()).O000000o(O000O0oo("method").toUpperCase().equals("POST") ? Method.POST : Method.GET);
    }
}
