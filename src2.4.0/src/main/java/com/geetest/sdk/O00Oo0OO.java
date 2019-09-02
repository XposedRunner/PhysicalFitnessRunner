package com.geetest.sdk;

import android.os.Handler;
import android.os.Looper;

/* compiled from: UICallback */
public final class O00Oo0OO<T> implements O00Oo00o<T> {
    private final Handler O000000o = new Handler(Looper.getMainLooper());
    private O00Oo00o<T> O00000Oo;

    private O00Oo0OO(O00Oo00o<T> o00Oo00o) {
        this.O00000Oo = o00Oo00o;
    }

    public static <T> O00Oo0OO<T> O000000o(O00Oo00o<T> o00Oo00o) {
        return new O00Oo0OO(o00Oo00o);
    }

    public final void O000000o(int i, String str, T t) {
        if (this.O00000Oo != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    this.O00000Oo.O000000o(i, str, t);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (this.O000000o != null) {
                this.O000000o.post(new O00Oo0o0(this, i, str, t));
            } else {
                new Handler(Looper.getMainLooper()).post(new O00Oo(this, i, str, t));
            }
        }
    }
}
