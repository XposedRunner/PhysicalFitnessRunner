package org.jsoup.examples;

import defpackage.db;
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListLinks {
    private static String O000000o(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.substring(0, i - 1));
        stringBuilder.append(".");
        return stringBuilder.toString();
    }

    private static void O000000o(String str, Object... objArr) {
        System.out.println(String.format(str, objArr));
    }

    public static void O000000o(String[] strArr) throws IOException {
        Validate.O000000o(strArr.length == 1, "usage: supply url to fetch");
        O000000o("Fetching %s...", strArr[0]);
        Document O000000o = Jsoup.O00000Oo(r10).O000000o();
        Elements O00000oo = O000000o.O00000oo("a[href]");
        Elements O00000oo2 = O000000o.O00000oo("[src]");
        Elements O00000oo3 = O000000o.O00000oo("link[href]");
        O000000o("\nMedia: (%d)", Integer.valueOf(O00000oo2.size()));
        Iterator it = O00000oo2.iterator();
        while (it.hasNext()) {
            if (((Element) it.next()).O0000o0O().equals("img")) {
                O000000o(" * %s: <%s> %sx%s (%s)", ((Element) it.next()).O0000o0O(), ((Element) it.next()).O000O0oo("abs:src"), ((Element) it.next()).O000O0oo(db.O000o0O), ((Element) it.next()).O000O0oo(db.O000o0OO), O000000o(((Element) it.next()).O000O0oo("alt"), 20));
            } else {
                O000000o(" * %s: <%s>", ((Element) it.next()).O0000o0O(), ((Element) it.next()).O000O0oo("abs:src"));
            }
        }
        O000000o("\nImports: (%d)", Integer.valueOf(O00000oo3.size()));
        Iterator it2 = O00000oo3.iterator();
        while (it2.hasNext()) {
            Element element = (Element) it2.next();
            O000000o(" * %s <%s> (%s)", element.O0000o0O(), element.O000O0oo("abs:href"), element.O000O0oo("rel"));
        }
        O000000o("\nLinks: (%d)", Integer.valueOf(O00000oo.size()));
        it2 = O00000oo.iterator();
        while (it2.hasNext()) {
            Element element2 = (Element) it2.next();
            O000000o(" * a: <%s>  (%s)", element2.O000O0oo("abs:href"), O000000o(element2.O000O0oO(), 35));
        }
    }
}
