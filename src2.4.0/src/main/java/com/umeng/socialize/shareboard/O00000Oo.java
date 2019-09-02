package com.umeng.socialize.shareboard;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.PopupWindow.OnDismissListener;
import com.umeng.socialize.utils.ShareBoardlistener;

/* compiled from: ShareBoardConfig */
public class O00000Oo {
    static int O000000o = 1;
    public static int O00000Oo = 2;
    public static int O00000o = 0;
    public static int O00000o0 = 3;
    public static int O00000oO = 1;
    public static int O00000oo = 2;
    static final int O0000ooO = 36;
    static final int O0000ooo = 16;
    static final int O000O00o = 10;
    static final int O000O0OO = 2;
    static final int O000O0o = 3;
    static final int O000O0o0 = 20;
    static final int O000O0oO = 5;
    static final int O000OO = 50;
    static final int O000OOOo = 15;
    private static final int O000OOo = 3;
    private static final int O000OOo0 = 4;
    private static final int O000OOoO = 6;
    private static final int O000OOoo = 5;
    static final int O00oOoOo = 20;
    static final int O00oOooO = 20;
    static final int O00oOooo = 20;
    boolean O0000O0o;
    String O0000OOo;
    boolean O0000Oo;
    int O0000Oo0;
    String O0000OoO;
    int O0000Ooo;
    int O0000o;
    int O0000o0;
    int O0000o00;
    int O0000o0O;
    int O0000o0o;
    int O0000oO;
    int O0000oO0;
    int O0000oOO;
    int O0000oOo;
    int O0000oo;
    int O0000oo0;
    int O000O0Oo;
    boolean O000O0oo;
    int O000OO00;
    int O000OO0o;
    private OnDismissListener O000Oo0;
    private ShareBoardlistener O000Oo00;

    public O00000Oo() {
        O00000o0();
    }

    private void O00000o0() {
        int parseColor = Color.parseColor("#575A5C");
        String str = "#ffffff";
        String str2 = "#22000000";
        O00000o(Color.parseColor("#E9EFF2"));
        O00000oO(O00000o0);
        O000000o("选择要分享到的平台");
        O000000o(parseColor);
        O00000Oo(O00000oo, 5);
        O00000o0(Color.parseColor(str), Color.parseColor(str2));
        O0000Oo0(Color.parseColor(str2));
        O0000OOo(parseColor);
        O00000Oo("取消分享");
        O00000Oo(parseColor);
        O000000o(Color.parseColor(str), Color.parseColor(str2));
        O00000o(Color.parseColor("#C2C9CC"), Color.parseColor("#0086DC"));
    }

    public O00000Oo O000000o(int i) {
        this.O0000Oo0 = i;
        return this;
    }

    public O00000Oo O000000o(int i, int i2) {
        this.O0000o00 = i;
        this.O0000o0 = i2;
        return this;
    }

    public O00000Oo O000000o(OnDismissListener onDismissListener) {
        this.O000Oo0 = onDismissListener;
        return this;
    }

    public O00000Oo O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            O00000Oo(false);
        } else {
            O00000Oo(true);
            this.O0000OOo = str;
        }
        return this;
    }

    /* Access modifiers changed, original: 0000 */
    public ShareBoardlistener O000000o() {
        return this.O000Oo00;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(ShareBoardlistener shareBoardlistener) {
        this.O000Oo00 = shareBoardlistener;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(boolean z) {
        if (z) {
            if (this.O0000o0O == O00000o0) {
                this.O000O0Oo = 6;
            } else if (this.O0000o0O == O00000Oo) {
                this.O000O0Oo = 5;
            }
        } else if (this.O0000o0O == O00000o0) {
            this.O000O0Oo = 4;
        } else if (this.O0000o0O == O00000Oo) {
            this.O000O0Oo = 3;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public OnDismissListener O00000Oo() {
        return this.O000Oo0;
    }

    public O00000Oo O00000Oo(int i) {
        this.O0000Ooo = i;
        return this;
    }

    public O00000Oo O00000Oo(int i, int i2) {
        if (!(i == O00000oO || i == O00000oo)) {
            i = O00000o;
        }
        this.O0000o = i;
        this.O0000oO0 = i2;
        return this;
    }

    public O00000Oo O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            O00000o0(false);
        } else {
            O00000o0(true);
            this.O0000OoO = str;
        }
        return this;
    }

    public O00000Oo O00000Oo(boolean z) {
        this.O0000O0o = z;
        return this;
    }

    public O00000Oo O00000o(int i) {
        this.O0000o0o = i;
        return this;
    }

    public O00000Oo O00000o(int i, int i2) {
        if (i != 0) {
            this.O000OO00 = i;
        }
        if (i2 != 0) {
            this.O000OO0o = i2;
        }
        O00000o(true);
        return this;
    }

    public O00000Oo O00000o(boolean z) {
        this.O000O0oo = z;
        return this;
    }

    public O00000Oo O00000o0(int i) {
        O000000o(i, 0);
        return this;
    }

    public O00000Oo O00000o0(int i, int i2) {
        this.O0000oO = i;
        this.O0000oOO = i2;
        return this;
    }

    public O00000Oo O00000o0(boolean z) {
        this.O0000Oo = z;
        return this;
    }

    public O00000Oo O00000oO(int i) {
        if (!(i == O00000o0 || i == O00000Oo || i == O000000o)) {
            i = O00000o0;
        }
        this.O0000o0O = i;
        return this;
    }

    public O00000Oo O00000oo(int i) {
        O00000Oo(i, 0);
        return this;
    }

    public O00000Oo O0000O0o(int i) {
        O00000o0(i, 0);
        return this;
    }

    public O00000Oo O0000OOo(int i) {
        this.O0000oOo = i;
        return this;
    }

    public O00000Oo O0000Oo(int i) {
        O00000o(i, 0);
        return this;
    }

    public O00000Oo O0000Oo0(int i) {
        this.O0000oo0 = i;
        return this;
    }

    public O00000Oo O0000OoO(int i) {
        this.O0000oo = i;
        return this;
    }

    /* Access modifiers changed, original: 0000 */
    public int O0000Ooo(int i) {
        int i2 = 2;
        if (i <= this.O000O0Oo) {
            i2 = 1;
        } else {
            int i3 = this.O000O0Oo * 2;
        }
        return ((75 * i2) + ((i2 - 1) * 20)) + 20;
    }
}
