package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import s.h.e.l.l.C;

public class SupportRequestManagerFragment extends Fragment {
    private O00o000 O000000o;
    private final O000000o O00000Oo;
    private final HashSet<SupportRequestManagerFragment> O00000o;
    private final O00oOooO O00000o0;
    private SupportRequestManagerFragment O00000oO;

    private class O000000o implements O00oOooO {
        private O000000o() {
        }

        public Set<O00o000> O000000o() {
            Set<SupportRequestManagerFragment> O00000o = SupportRequestManagerFragment.this.O00000o();
            HashSet hashSet = new HashSet(O00000o.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : O00000o) {
                if (supportRequestManagerFragment.O00000Oo() != null) {
                    hashSet.add(supportRequestManagerFragment.O00000Oo());
                }
            }
            return hashSet;
        }
    }

    static {
        C.i(17);
    }

    public SupportRequestManagerFragment() {
        this(new O000000o());
    }

    @SuppressLint({"ValidFragment"})
    public SupportRequestManagerFragment(O000000o o000000o) {
        this.O00000o0 = new O000000o();
        this.O00000o = new HashSet();
        this.O00000Oo = o000000o;
    }

    private native void O000000o(SupportRequestManagerFragment supportRequestManagerFragment);

    private native boolean O000000o(Fragment fragment);

    private native void O00000Oo(SupportRequestManagerFragment supportRequestManagerFragment);

    public native O000000o O000000o();

    public native void O000000o(O00o000 o00o000);

    public native O00o000 O00000Oo();

    public Set<SupportRequestManagerFragment> O00000o() {
        if (this.O00000oO == null) {
            return Collections.emptySet();
        }
        if (this.O00000oO == this) {
            return Collections.unmodifiableSet(this.O00000o);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment : this.O00000oO.O00000o()) {
            if (O000000o(supportRequestManagerFragment.getParentFragment())) {
                hashSet.add(supportRequestManagerFragment);
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
}
