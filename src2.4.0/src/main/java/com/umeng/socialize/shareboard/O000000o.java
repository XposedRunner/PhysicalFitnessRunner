package com.umeng.socialize.shareboard;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.umeng.socialize.utils.O0000OOo;
import com.umeng.socialize.utils.ShareBoardlistener;
import com.ximalaya.ting.android.opensdk.auth.constants.XmlyConstants.ClientOSType;
import defpackage.by;
import java.util.List;

/* compiled from: ShareBoard */
public class O000000o extends PopupWindow {
    private O00000Oo O000000o;

    public O000000o(Context context, List<O00000o> list) {
        this(context, list, null);
    }

    public O000000o(Context context, List<O00000o> list, O00000Oo o00000Oo) {
        super(context);
        setWindowLayoutMode(-1, -1);
        boolean z = context.getResources().getConfiguration().orientation == 2;
        if (o00000Oo == null) {
            o00000Oo = new O00000Oo();
        }
        this.O000000o = o00000Oo;
        o00000Oo.O000000o(z);
        O0000Oo0 o0000Oo0 = new O0000Oo0(context);
        o0000Oo0.O000000o((List) list, o00000Oo);
        o0000Oo0.setLayoutParams(new LayoutParams(-1, -1));
        o0000Oo0.O000000o(new OnDismissListener() {
            public void onDismiss() {
                O000000o.this.dismiss();
            }
        });
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                OnDismissListener O00000Oo = O000000o.this.O000000o != null ? O000000o.this.O000000o.O00000Oo() : null;
                if (O00000Oo != null) {
                    O00000Oo.onDismiss();
                }
            }
        });
        setContentView(o0000Oo0);
        setFocusable(true);
        O000000o(context, o00000Oo);
    }

    private void O000000o(Context context, O00000Oo o00000Oo) {
        if (context != null && o00000Oo != null) {
            CharSequence charSequence = o00000Oo.O0000o0O == O00000Oo.O00000o0 ? "0" : ClientOSType.IOS;
            CharSequence charSequence2 = null;
            if (o00000Oo.O0000o == O00000Oo.O00000o) {
                charSequence2 = "0";
            } else if (o00000Oo.O0000o == O00000Oo.O00000oO) {
                charSequence2 = ClientOSType.IOS;
            } else if (o00000Oo.O0000o == O00000Oo.O00000oo) {
                charSequence2 = o00000Oo.O0000oO0 != 0 ? ClientOSType.ANDROID : ClientOSType.WEB_OR_H5;
            }
            if (!(TextUtils.isEmpty(charSequence) && TextUtils.isEmpty(charSequence2))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(charSequence2);
                stringBuilder.append(";");
                stringBuilder.append(charSequence);
                O0000OOo.O00000oo(context, stringBuilder.toString());
            }
        }
    }

    public void O000000o(final ShareBoardlistener shareBoardlistener) {
        if (this.O000000o != null) {
            this.O000000o.O000000o(new ShareBoardlistener() {
                public void O000000o(O00000o o00000o, by byVar) {
                    O000000o.this.setOnDismissListener(null);
                    O000000o.this.dismiss();
                    if (shareBoardlistener != null) {
                        shareBoardlistener.O000000o(o00000o, byVar);
                    }
                }
            });
        }
    }
}
