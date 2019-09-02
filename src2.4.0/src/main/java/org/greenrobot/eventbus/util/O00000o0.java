package org.greenrobot.eventbus.util;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import org.greenrobot.eventbus.util.ErrorDialogFragments.Support;

/* compiled from: ErrorDialogFragmentFactory */
public abstract class O00000o0<T> {
    protected final O00000Oo O000000o;

    @TargetApi(11)
    /* compiled from: ErrorDialogFragmentFactory */
    public static class O000000o extends O00000o0<Fragment> {
        public O000000o(O00000Oo o00000Oo) {
            super(o00000Oo);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: O00000o */
        public Fragment O000000o(O0000OOo o0000OOo, Bundle bundle) {
            org.greenrobot.eventbus.util.ErrorDialogFragments.O000000o o000000o = new org.greenrobot.eventbus.util.ErrorDialogFragments.O000000o();
            o000000o.setArguments(bundle);
            return o000000o;
        }
    }

    /* compiled from: ErrorDialogFragmentFactory */
    public static class O00000Oo extends O00000o0<android.support.v4.app.Fragment> {
        public O00000Oo(O00000Oo o00000Oo) {
            super(o00000Oo);
        }

        /* Access modifiers changed, original: protected */
        /* renamed from: O00000o */
        public android.support.v4.app.Fragment O000000o(O0000OOo o0000OOo, Bundle bundle) {
            Support support = new Support();
            support.setArguments(bundle);
            return support;
        }
    }

    protected O00000o0(O00000Oo o00000Oo) {
        this.O000000o = o00000Oo;
    }

    public abstract T O000000o(O0000OOo o0000OOo, Bundle bundle);

    /* Access modifiers changed, original: protected */
    public T O000000o(O0000OOo o0000OOo, boolean z, Bundle bundle) {
        if (o0000OOo.O00000o0()) {
            return null;
        }
        bundle = bundle != null ? (Bundle) bundle.clone() : new Bundle();
        if (!bundle.containsKey(ErrorDialogManager.O00000o)) {
            bundle.putString(ErrorDialogManager.O00000o, O00000Oo(o0000OOo, bundle));
        }
        if (!bundle.containsKey(ErrorDialogManager.O00000oO)) {
            bundle.putString(ErrorDialogManager.O00000oO, O00000o0(o0000OOo, bundle));
        }
        if (!bundle.containsKey(ErrorDialogManager.O00000oo)) {
            bundle.putBoolean(ErrorDialogManager.O00000oo, z);
        }
        if (!(bundle.containsKey(ErrorDialogManager.O0000OOo) || this.O000000o.O0000Oo0 == null)) {
            bundle.putSerializable(ErrorDialogManager.O0000OOo, this.O000000o.O0000Oo0);
        }
        if (!(bundle.containsKey(ErrorDialogManager.O0000O0o) || this.O000000o.O0000OOo == 0)) {
            bundle.putInt(ErrorDialogManager.O0000O0o, this.O000000o.O0000OOo);
        }
        return O000000o(o0000OOo, bundle);
    }

    /* Access modifiers changed, original: protected */
    public String O00000Oo(O0000OOo o0000OOo, Bundle bundle) {
        return this.O000000o.O000000o.getString(this.O000000o.O00000Oo);
    }

    /* Access modifiers changed, original: protected */
    public String O00000o0(O0000OOo o0000OOo, Bundle bundle) {
        return this.O000000o.O000000o.getString(this.O000000o.O000000o(o0000OOo.O000000o));
    }
}
