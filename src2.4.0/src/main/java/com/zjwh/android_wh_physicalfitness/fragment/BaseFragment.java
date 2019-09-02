package com.zjwh.android_wh_physicalfitness.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.view.dialog.O0000Oo;
import java.util.ArrayList;
import org.xutils.common.Callback.Cancelable;
import s.h.e.l.l.C;

public class BaseFragment extends Fragment {
    private boolean O000000o = false;
    protected boolean O00000Oo;
    protected String O00000o = "";
    protected boolean O00000o0;
    protected boolean O00000oO = true;
    private Dialog O00000oo;
    private ArrayList<Cancelable> O0000O0o;
    private ArrayMap<String, Cancelable> O0000OOo;

    static {
        C.i(43);
    }

    public native O0000Oo O000000o(int i, int i2);

    /* Access modifiers changed, original: protected */
    public O0000Oo O000000o(int i, int i2, OnClickListener onClickListener) {
        String str = null;
        String string = i == -1 ? null : getString(i);
        if (i2 != -1) {
            str = getString(i2);
        }
        return O000000o(string, str, onClickListener);
    }

    /* Access modifiers changed, original: protected */
    public O0000Oo O000000o(String str, String str2, OnClickListener onClickListener) {
        O0000Oo O000000o = new O0000Oo(getContext()).O000000o();
        O000000o.O000000o(false);
        O000000o.O00000Oo(false);
        if (!TextUtils.isEmpty(str)) {
            O000000o.O000000o(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            O000000o.O00000Oo(str2);
        }
        O000000o.O000000o(2131689868, 2131099769, onClickListener);
        if (O0000Ooo()) {
            O000000o.O00000Oo();
        }
        return O000000o;
    }

    public native void O000000o(String str, boolean z);

    public void O000000o(Cancelable cancelable) {
        O000000o(cancelable, null);
    }

    public void O000000o(Cancelable cancelable, String str) {
        if (cancelable != null) {
            if (this.O0000O0o != null) {
                this.O0000O0o.add(cancelable);
            }
            if (!TextUtils.isEmpty(str)) {
                this.O0000OOo.put(str, cancelable);
            }
        }
    }

    public native O0000Oo O00000Oo(String str, String str2);

    public void O00000Oo(String str) {
        if (this.O0000OOo.containsKey(str)) {
            try {
                ((Cancelable) this.O0000OOo.get(str)).cancel();
            } catch (Throwable unused) {
                kz.O00000oO(getClass().getSimpleName(), "取消失败");
            }
        }
    }

    public native void O00000o0(String str);

    public native void O0000Oo();

    public native void O0000OoO();

    public native boolean O0000Ooo();

    public native void O0000o00();

    /* Access modifiers changed, original: protected */
    public void f_() {
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.O0000O0o = new ArrayList();
        this.O0000OOo = new ArrayMap();
    }

    public native void onDestroy();

    public native void onPause();

    public native void onResume();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.O000000o) {
            kz.O000000o(getClass().getSimpleName(), "onViewCreated: ");
        }
        this.O00000o0 = true;
    }

    public native void setUserVisibleHint(boolean z);
}
