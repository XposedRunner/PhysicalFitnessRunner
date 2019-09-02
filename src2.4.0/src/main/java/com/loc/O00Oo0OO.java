package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.lang.ref.WeakReference;

/* compiled from: MarkInfoManager */
public class O00Oo0OO {
    static WeakReference<O00Oo00o> O000000o;

    public static void O000000o(final Context context) {
        O0000o.O00000o().submit(new Runnable() {
            public final void run() {
                synchronized (O00Oo0OO.class) {
                    O00Oo00o O000000o = O00Ooo00.O000000o(O00Oo0OO.O000000o);
                    O00Ooo00.O000000o(context, O000000o, O0000o00.O0000Oo, 50, 102400, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                    if (O000000o.O0000O0o == null) {
                        String O00000Oo = O00Oo0OO.O00000Oo(context);
                        O000000o.O0000O0o = new O00oo000(new O00o0(context, new O0O000o(), new OO0o(new O0000O0o(new O00000o0())), "WImFwcG5hbWUiOiIlcyIsInBrZyI6IiVzIiwiZGl1IjoiJXMi", OO00o00.O00000Oo(context), OO00o00.O00000o0(context), O00000Oo));
                    }
                    O000000o.O0000OOo = 14400000;
                    if (TextUtils.isEmpty(O000000o.O0000Oo0)) {
                        O000000o.O0000Oo0 = "eKey";
                    }
                    if (O000000o.O00000oo == null) {
                        O000000o.O00000oo = new O0O0O(context, O000000o.O0000OOo, O000000o.O0000Oo0, new O0O00o0(5, O000000o.O000000o, new O0O0OO(context)));
                    }
                    O00Oo0.O000000o(O000000o);
                }
            }
        });
    }

    static /* synthetic */ String O00000Oo(Context context) {
        String O0000oo0 = OO0O0o0.O0000oo0(context);
        if (!TextUtils.isEmpty(O0000oo0)) {
            return O0000oo0;
        }
        O0000oo0 = OO0O0o0.O0000OOo(context);
        if (!TextUtils.isEmpty(O0000oo0)) {
            return O0000oo0;
        }
        O0000oo0 = OO0O0o0.O0000o00(context);
        return !TextUtils.isEmpty(O0000oo0) ? O0000oo0 : OO0O0o0.O00000Oo(context);
    }
}
