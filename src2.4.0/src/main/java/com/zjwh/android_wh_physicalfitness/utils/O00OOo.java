package com.zjwh.android_wh_physicalfitness.utils;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* compiled from: TimeCountUtil */
public class O00OOo extends CountDownTimer {
    private WeakReference<TextView> O000000o;
    private WeakReference<Activity> O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO = -1;
    private int O00000oo = -1;
    private O000000o O0000O0o;

    /* compiled from: TimeCountUtil */
    public interface O000000o {
        void O000000o();
    }

    public O00OOo(Activity activity, long j, long j2, TextView textView, O000000o o000000o) {
        super(j, j2);
        this.O00000Oo = new WeakReference(activity);
        this.O000000o = new WeakReference(textView);
        this.O00000o0 = ContextCompat.getColor(((Activity) this.O00000Oo.get()).getApplicationContext(), R.color.text_color_hint);
        this.O00000o = ContextCompat.getColor(((Activity) this.O00000Oo.get()).getApplicationContext(), R.color.text_color_major);
        this.O0000O0o = o000000o;
    }

    public void O000000o(int i, int i2) {
        this.O00000o0 = i;
        this.O00000o = i2;
    }

    public void O00000Oo(int i, int i2) {
        this.O00000oO = i;
        this.O00000oo = i2;
    }

    public void onFinish() {
        if (!(this.O00000Oo.get() == null || this.O000000o.get() == null)) {
            ((TextView) this.O000000o.get()).setText(R.string.txt_get_ver_code);
            ((TextView) this.O000000o.get()).setTextColor(this.O00000o);
            if (this.O00000oO != -1) {
                ((TextView) this.O000000o.get()).setBackgroundResource(this.O00000oo);
            }
            ((TextView) this.O000000o.get()).setEnabled(true);
        }
        if (this.O0000O0o != null) {
            this.O0000O0o.O000000o();
        }
    }

    public void onTick(long j) {
        if (this.O00000Oo.get() != null && this.O000000o.get() != null) {
            ((TextView) this.O000000o.get()).setEnabled(false);
            ((TextView) this.O000000o.get()).setTextColor(this.O00000o0);
            if (this.O00000oO != -1) {
                ((TextView) this.O000000o.get()).setBackgroundResource(this.O00000oO);
            }
            ((TextView) this.O000000o.get()).setText(String.format(Locale.getDefault(), "%dS", new Object[]{Long.valueOf(j / 1000)}));
        }
    }
}
