package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build.VERSION;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import s.h.e.l.l.C;

@TargetApi(11)
/* compiled from: RequestManagerFragment */
public class O0000o0 extends Fragment {
    private final O000000o O000000o;
    private final O00oOooO O00000Oo;
    private final HashSet<O0000o0> O00000o;
    private O00o000 O00000o0;
    private O0000o0 O00000oO;

    /* compiled from: RequestManagerFragment */
    private class O000000o implements O00oOooO {
        private O000000o() {
        }

        public Set<O00o000> O000000o() {
            Set<O0000o0> O00000o = O0000o0.this.O00000o();
            HashSet hashSet = new HashSet(O00000o.size());
            for (O0000o0 o0000o0 : O00000o) {
                if (o0000o0.O00000Oo() != null) {
                    hashSet.add(o0000o0.O00000Oo());
                }
            }
            return hashSet;
        }
    }

    static {
        C.i(16);
    }

    public O0000o0() {
        this(new O000000o());
    }

    @SuppressLint({"ValidFragment"})
    O0000o0(O000000o o000000o) {
        this.O00000Oo = new O000000o();
        this.O00000o = new HashSet();
        this.O000000o = o000000o;
    }

    private native void O000000o(O0000o0 o0000o0);

    @TargetApi(17)
    private boolean O000000o(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (fragment.getParentFragment() != null) {
            if (fragment.getParentFragment() == parentFragment) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private native void O00000Oo(O0000o0 o0000o0);

    public native O000000o O000000o();

    public native void O000000o(O00o000 o00o000);

    public native O00o000 O00000Oo();

    @TargetApi(17)
    public Set<O0000o0> O00000o() {
        if (this.O00000oO == this) {
            return Collections.unmodifiableSet(this.O00000o);
        }
        if (this.O00000oO == null || VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (O0000o0 o0000o0 : this.O00000oO.O00000o()) {
            if (O000000o(o0000o0.getParentFragment())) {
                hashSet.add(o0000o0);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public native O00oOooO O00000o0();

    public native void onAttach(Activity activity);

    public native void onDestroy();

    public native void onDetach();

    public native void onLowMemory();

    public native void onStart();

    public native void onStop();

    public native void onTrimMemory(int i);
}
