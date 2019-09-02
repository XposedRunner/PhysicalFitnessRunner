package com.amap.api.mapcore.util;

import com.autonavi.ae.gmap.style.StyleItem;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: StyleParserResult */
public class OO0OOOO {
    private Map<Integer, StyleItem> O000000o = new ConcurrentHashMap();
    private Object O00000Oo = null;
    private StyleItem[] O00000o0;

    public Map<Integer, StyleItem> O000000o() {
        return this.O000000o;
    }

    public StyleItem[] O00000Oo() {
        if (this.O000000o == null || this.O000000o.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StyleItem styleItem : this.O000000o.values()) {
            if (styleItem.isValid()) {
                arrayList.add(styleItem);
            }
        }
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        this.O00000o0 = (StyleItem[]) arrayList.toArray(new StyleItem[size]);
        return this.O00000o0;
    }

    public Object O00000o() {
        return this.O00000Oo;
    }

    public StyleItem[] O00000o0() {
        return this.O00000o0;
    }
}
