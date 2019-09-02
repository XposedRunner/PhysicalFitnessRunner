package com.geetest.sdk;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: GtRequest */
public class O00OOo {
    private static final String O000000o = "O00OOo";
    private static List<O00OOo> O00000o0 = new ArrayList();
    private boolean O00000Oo = false;

    private O00OOo() {
    }

    public static O00OOo O000000o() {
        O00OOo o00OOo = new O00OOo();
        O00000o0.add(o00OOo);
        return o00OOo;
    }

    public static void O00000Oo() {
        if (O00000o0 != null && O00000o0.size() > 0) {
            for (O00OOo o00OOo : O00000o0) {
                o00OOo.O00000Oo = true;
            }
            O00000o0.clear();
        }
    }

    public final <T> void O000000o(O00OOo0<T> o00OOo0, O00Oo00o<T> o00Oo00o) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("This thread(non_ui) forbids invoke.");
        }
        O0Oo0.O000000o().O000000o(new O00Oo00(this, o00OOo0, O00Oo0OO.O000000o((O00Oo00o) o00Oo00o)));
    }

    public final <T> void O00000Oo(O00OOo0<T> o00OOo0, O00Oo00o<T> o00Oo00o) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new RuntimeException("This thread(ui) forbids invoke.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o00OOo0.O00000o0());
        stringBuilder.append(" REQUEST START");
        O0OOO00.O000000o(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(o00OOo0.O00000o0());
        stringBuilder.append(" REQUEST URL: ");
        stringBuilder.append(o00OOo0.O0000O0o());
        O0OOO00.O000000o(stringBuilder.toString());
        if (O0Oo00.O000000o(o00OOo0.O0000OOo())) {
            byte[] O00000oO = o00OOo0.O00000oO();
            if (this.O00000Oo) {
                O00OOo0.O0000OoO();
                return;
            }
            String O000000o = O0OOOo0.O000000o(o00OOo0.O0000O0o(), o00OOo0.O00000oo(), o00OOo0.O0000Oo0(), O00000oO, o00OOo0.O0000Oo(), o00OOo0.O00000o0());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(o00OOo0.O00000o0());
            stringBuilder2.append(" REQUEST END");
            O0OOO00.O000000o(stringBuilder2.toString());
            if (this.O00000Oo) {
                O00OOo0.O0000OoO();
                return;
            }
            o00OOo0.O00000Oo(O000000o);
            o00OOo0.O000000o((O00Oo00o) o00Oo00o);
            return;
        }
        o00OOo0.O000000o(-1, o00OOo0.O000000o("Network Not Avaliable", new Object[0]));
        o00OOo0.O000000o((O00Oo00o) o00Oo00o);
    }
}
