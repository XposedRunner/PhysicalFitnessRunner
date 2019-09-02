package com.geetest.sdk.dialog.views;

import android.view.ViewGroup.LayoutParams;
import com.geetest.sdk.O0OO00O;
import com.geetest.sdk.O0OO0O;

/* compiled from: WebviewBuilder */
final class O0000OOo implements Runnable {
    final /* synthetic */ O000000o O000000o;

    O0000OOo(O000000o o000000o) {
        this.O000000o = o000000o;
    }

    public final void run() {
        O00000Oo.this.O0000Oo.setVoice(true);
        O00000Oo.this.O00000oo.O00000oo("voice");
        int O00000Oo = O0OO0O.O00000Oo(O00000Oo.this.O00000o);
        int O000000o = O0OO0O.O000000o(O00000Oo.this.O00000o);
        int O000000o2 = O0OO00O.O000000o(O00000Oo.this.O00000o, 275.0f);
        int O000000o3 = O0OO00O.O000000o(O00000Oo.this.O00000o, 348.0f);
        int O000000o4 = O0OO00O.O000000o(O00000Oo.this.O00000o, 300.0f);
        if (O00000Oo.this.O00000o.getResources().getConfiguration().orientation == 1) {
            O00000Oo = (O000000o << 2) / 5;
            if (O00000Oo >= O000000o4) {
                O000000o4 = O00000Oo;
            }
            if (O00000Oo <= O000000o3) {
                O000000o3 = O000000o4;
            }
            O00000Oo.O000000o = O000000o3;
            O00000Oo.O00000Oo = (O000000o3 * O00000Oo.this.O0000Oo0) / 100;
        } else {
            O00000Oo = O0OO00O.O000000o(O00000Oo.this.O00000o, (float) (O0OO00O.O00000Oo(O00000Oo.this.O00000o, (float) O00000Oo) - 44));
            if (O00000Oo >= O000000o2) {
                O000000o2 = O00000Oo;
            }
            if (O00000Oo > O000000o3) {
                O000000o2 = O000000o3;
            }
            O00000Oo.O00000Oo = O000000o2;
            O00000Oo.O000000o = (O000000o2 * 100) / O00000Oo.this.O0000Oo0;
        }
        if (O00000Oo.this.O0000Oo != null && O00000Oo.this.O0000Oo.getLayoutParams() != null) {
            LayoutParams layoutParams = O00000Oo.this.O0000Oo.getLayoutParams();
            layoutParams.width = O00000Oo.O000000o;
            layoutParams.height = O00000Oo.O00000Oo;
            O00000Oo.this.O0000Oo.setLayoutParams(layoutParams);
        }
    }
}
