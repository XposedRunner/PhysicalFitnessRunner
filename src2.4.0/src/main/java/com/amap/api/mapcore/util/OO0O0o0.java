package com.amap.api.mapcore.util;

/* compiled from: StyleElementType */
public enum OO0O0o0 {
    STYLE_ELEMENT_LABELFILL_OLD("labels.text.fill", 0),
    STYLE_ELEMENT_LABELSTROKE_OLD("labels.text.stroke", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE_OLD("geometry.stroke", 2),
    STYLE_ELEMENT_GEOMETRYFILL_OLD("geometry.fill", 3),
    STYLE_ELEMENT_LABELFILL("textFillColor", 0),
    STYLE_ELEMENT_LABELSTROKE("textStrokeColor", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE("strokeColor", 2),
    STYLE_ELEMENT_GEOMETRYFILL("fillColor", 3),
    STYLE_ELEMENT_GEOMETRYFILL1("color", 3),
    STYLE_ELEMENT_GEOMETRYFILL2("textureName", 3),
    STYLE_ELEMENT_BACKGROUNDFILL("backgroundColor", 4),
    STYLE_ELEMENT_VISIBLE("visible", 5);
    
    private int O0000o0;
    private String O0000o00;

    private OO0O0o0(String str, int i) {
        this.O0000o00 = str;
        this.O0000o0 = i;
    }

    public static int O000000o(String str) {
        for (OO0O0o0 oO0O0o0 : values()) {
            if (oO0O0o0.O000000o().equals(str)) {
                return oO0O0o0.O0000o0;
            }
        }
        return -1;
    }

    public String O000000o() {
        return this.O0000o00;
    }
}
