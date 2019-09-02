package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/* compiled from: SWIconModule */
/* renamed from: lh */
public class lh implements IconFontDescriptor {
    private final String O000000o = "fonts/swicon.ttf";
    private Typeface O00000Oo = null;

    public Typeface O000000o(Context context) {
        if (this.O00000Oo == null) {
            try {
                this.O00000Oo = Typeface.createFromAsset(context.getAssets(), "fonts/swicon.ttf");
            } catch (Exception unused) {
                return null;
            }
        }
        return this.O00000Oo;
    }

    public Icon[] characters() {
        return lg.values();
    }

    public String ttfFileName() {
        return "fonts/swicon.ttf";
    }
}
