package com.zjwh.android_wh_physicalfitness.activity.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import com.zjwh.android_wh_physicalfitness.utils.O00O00o;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import java.util.ArrayList;
import org.xutils.common.Callback.Cancelable;
import org.xutils.x;
import s.h.e.l.l.C;

public abstract class BaseActivity extends AppCompatActivity {
    private boolean O000000o = false;
    private Dialog O00000Oo;
    private ArrayList<Cancelable> O00000o;
    private O0000Oo O00000o0;
    private ArrayMap<String, Cancelable> O00000oO;
    public Gson O0000OoO = new GsonBuilder().registerTypeAdapter(Double.class, new eb()).create();
    protected TextView O0000Ooo;
    protected Context O0000o0;
    protected Toolbar O0000o00;
    protected boolean O0000o0O = false;
    public boolean O0000o0o;

    static {
        C.i(35);
    }

    public abstract int O000000o();

    public O0000Oo O000000o(int i, int i2, OnClickListener onClickListener) {
        return O000000o(getString(i), getString(i2), onClickListener);
    }

    public O0000Oo O000000o(String str, String str2, OnClickListener onClickListener) {
        if (isFinishing()) {
            return null;
        }
        O0000Oo O000000o = new O0000Oo(this.O0000o0).O000000o();
        O000000o.O000000o(false);
        O000000o.O00000Oo(false);
        if (!TextUtils.isEmpty(str)) {
            O000000o.O000000o(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            O000000o.O00000Oo(str2);
        }
        O000000o.O000000o(2131689868, 2131099769, onClickListener);
        O000000o.O00000Oo();
        return O000000o;
    }

    public void O000000o(Cancelable cancelable) {
        O000000o(cancelable, null);
    }

    public void O000000o(Cancelable cancelable, String str) {
        if (this.O00000o != null) {
            this.O00000o.add(cancelable);
        }
        if (!TextUtils.isEmpty(str)) {
            this.O00000oO.put(str, cancelable);
        }
    }

    public native O0000Oo O00000Oo(int i, int i2);

    public native O0000Oo O00000Oo(String str, String str2);

    public abstract void O00000Oo();

    public void O00000o(String str) {
        if (this.O00000oO.containsKey(str)) {
            try {
                ((Cancelable) this.O00000oO.get(str)).cancel();
            } catch (Throwable unused) {
                kz.O00000oO(getClass().getSimpleName(), "取消失败");
            }
        }
    }

    public native void O00000oO(String str);

    public native void O0000Oo();

    public native void O0000OoO();

    public native boolean O0000o00();

    public void j_() {
        if (!isFinishing()) {
            O0000OoO();
            if (this.O00000o0 == null) {
                this.O00000o0 = O00O00o.O00000Oo(this);
            }
            if (!this.O00000o0.O00000oO()) {
                this.O00000o0.O00000Oo();
            }
        }
    }

    public abstract void n_();

    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException unused) {
            supportFinishAfterTransition();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (this.O000000o) {
            kz.O000000o(getClass().getSimpleName(), "onCreate");
        }
        setContentView(O000000o());
        this.O00000o = new ArrayList();
        this.O00000oO = new ArrayMap();
        this.O0000o00 = (Toolbar) findViewById(2131297163);
        if (this.O0000o00 != null) {
            this.O0000Ooo = (TextView) findViewById(2131297158);
            this.O0000o00.setNavigationIcon(2131230833);
            this.O0000o00.setTitle((CharSequence) "");
            this.O0000o00.setBackgroundColor(ContextCompat.getColor(this, 2131099948));
            setSupportActionBar(this.O0000o00);
            this.O0000o00.setNavigationOnClickListener(new 1(this));
        }
        O00000Oo.O000000o((Activity) this);
        x.view().inject(this);
        this.O0000o0 = this;
        O00000Oo();
        n_();
    }

    public native void onDestroy();

    public native void onPause();

    public native void onResume();

    public native void onStop();
}
