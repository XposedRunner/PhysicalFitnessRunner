package com.zjwh.android_wh_physicalfitness.view.banner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import defpackage.O00Oo;
import defpackage.O00Oo00;
import defpackage.O00o000;
import defpackage.O0Oo0;
import defpackage.o0OoO00O;
import defpackage.oO00OOOo;
import defpackage.oOo000o0;
import defpackage.ooOOO0Oo;
import java.io.File;

/* compiled from: BaseSliderView */
public abstract class O000000o {
    protected Context O000000o;
    private int O00000Oo;
    private String O00000o;
    private int O00000o0;
    private String O00000oO;
    private File O00000oo;
    private int O0000O0o;
    private int O0000OOo;
    private boolean O0000Oo;
    private int O0000Oo0;
    private O00000Oo O0000OoO;
    private O000000o O0000Ooo;
    private int O0000o0;
    private String O0000o00;
    private int O0000o0O;
    private O00000o0 O0000o0o = O00000o0.Fit;

    /* compiled from: BaseSliderView */
    interface O000000o {
        void O000000o(O000000o o000000o);

        void O000000o(boolean z, O000000o o000000o);
    }

    /* compiled from: BaseSliderView */
    public enum O00000o0 {
        CenterCrop,
        CenterInside,
        Fit,
        FitCenterCrop
    }

    protected O000000o(Context context) {
        this.O000000o = context;
    }

    public int O000000o() {
        return this.O0000o0;
    }

    public O000000o O000000o(int i) {
        this.O00000o0 = i;
        return this;
    }

    public O000000o O000000o(O00000Oo o00000Oo) {
        this.O0000OoO = o00000Oo;
        return this;
    }

    public O000000o O000000o(O00000o0 o00000o0) {
        this.O0000o0o = o00000o0;
        return this;
    }

    public O000000o O000000o(File file) {
        if (this.O00000o == null && this.O0000O0o == 0) {
            this.O00000oo = file;
            return this;
        }
        throw new IllegalStateException("Call multi image function,you only have permission to call it once");
    }

    public O000000o O000000o(String str) {
        this.O0000o00 = str;
        return this;
    }

    public O000000o O000000o(boolean z) {
        this.O0000Oo = z;
        return this;
    }

    /* Access modifiers changed, original: 0000 */
    public void O000000o(final View view, ImageView imageView, TextView textView) {
        view.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (O000000o.this.O0000OoO != null) {
                    O000000o.this.O0000OoO.O000000o(this);
                }
            }
        });
        if (imageView != null) {
            O00Oo00 O000000o;
            if (textView != null) {
                if (TextUtils.isEmpty(this.O00000oO)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(this.O00000oO);
                    textView.setVisibility(0);
                }
            }
            if (this.O0000Ooo != null) {
                this.O0000Ooo.O000000o(this);
            }
            O00o000 O00000o0 = O00Oo.O00000o0(this.O000000o);
            if (this.O00000o != null) {
                O000000o = O00000o0.O000000o(this.O00000o);
            } else if (this.O00000oo != null) {
                O000000o = O00000o0.O000000o(this.O00000oo);
            } else if (this.O0000O0o != 0) {
                O000000o = O00000o0.O000000o(Integer.valueOf(this.O0000O0o));
            } else {
                return;
            }
            if (O000000o != null) {
                if (this.O0000Oo) {
                    O000000o.O00000Oo(O0Oo0.NONE);
                    O000000o.O00000Oo(true);
                }
                if (O00000o() != 0) {
                    O000000o.O0000O0o(O00000o());
                }
                if (O00000oO() != 0) {
                    O000000o.O00000oO(O00000oO());
                }
                O000000o.O00000Oo((ooOOO0Oo) new oOo000o0(imageView) {
                    public void O000000o(Exception exception, Drawable drawable) {
                        super.O000000o(exception, drawable);
                        if (O000000o.this.O0000Ooo != null) {
                            O000000o.this.O0000Ooo.O000000o(false, this);
                        }
                        if (view.findViewById(R.id.loading_bar) != null) {
                            view.findViewById(R.id.loading_bar).setVisibility(4);
                        }
                    }

                    public void O000000o(o0OoO00O o0ooo00o, oO00OOOo<? super o0OoO00O> oo00oooo) {
                        super.O000000o(o0ooo00o, (oO00OOOo) oo00oooo);
                        if (view.findViewById(R.id.loading_bar) != null) {
                            view.findViewById(R.id.loading_bar).setVisibility(4);
                        }
                    }
                });
            }
        }
    }

    public void O000000o(O000000o o000000o) {
        this.O0000Ooo = o000000o;
    }

    public O000000o O00000Oo(int i) {
        this.O00000Oo = i;
        return this;
    }

    public O000000o O00000Oo(String str) {
        if (this.O00000oo == null && this.O0000O0o == 0) {
            this.O00000o = str;
            return this;
        }
        throw new IllegalStateException("Call multi image function,you only have permission to call it once");
    }

    public String O00000Oo() {
        return this.O00000oO;
    }

    public int O00000o() {
        return this.O00000o0;
    }

    public O000000o O00000o(int i) {
        this.O0000o0 = i;
        return this;
    }

    public O000000o O00000o0(int i) {
        if (this.O00000o == null && this.O00000oo == null) {
            this.O0000O0o = i;
            return this;
        }
        throw new IllegalStateException("Call multi image function,you only have permission to call it once");
    }

    public O000000o O00000o0(String str) {
        this.O00000oO = str;
        return this;
    }

    public String O00000o0() {
        return this.O00000o;
    }

    public int O00000oO() {
        return this.O00000Oo;
    }

    public O000000o O00000oO(int i) {
        this.O0000OOo = i;
        return this;
    }

    public O000000o O00000oo(int i) {
        this.O0000o0O = i;
        return this;
    }

    public String O00000oo() {
        return this.O0000o00;
    }

    public Context O0000O0o() {
        return this.O000000o;
    }

    public O000000o O0000O0o(int i) {
        this.O0000Oo0 = i;
        return this;
    }

    public O00000o0 O0000OOo() {
        return this.O0000o0o;
    }

    public int O0000Oo() {
        return this.O0000OOo;
    }

    public abstract View O0000Oo0();

    public int O0000OoO() {
        return this.O0000o0O;
    }

    public int O0000Ooo() {
        return this.O0000Oo0;
    }
}
