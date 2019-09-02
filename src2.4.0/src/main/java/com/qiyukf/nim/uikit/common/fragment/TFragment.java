package com.qiyukf.nim.uikit.common.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import com.qiyukf.basesdk.c.c;
import s.h.e.l.l.C;

public abstract class TFragment extends Fragment {
    private static final Handler a = new Handler();
    private int b;
    private boolean c;

    static {
        C.i(25);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(final Runnable runnable, long j) {
        a.postDelayed(new Runnable() {
            public final void run() {
                if (TFragment.this.isAdded()) {
                    runnable.run();
                }
            }
        }, j);
    }

    public native void onActivityCreated(Bundle bundle);

    public native void onDestroy();

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        c.a(i, iArr);
    }

    public native void setContainerId(int i);
}
