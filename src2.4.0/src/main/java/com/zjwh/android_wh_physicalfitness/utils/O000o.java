package com.zjwh.android_wh_physicalfitness.utils;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* compiled from: KeyboardUtils */
public class O000o {
    public static void O000000o(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void O00000Oo(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).toggleSoftInputFromWindow(view.getWindowToken(), 0, 2);
    }
}
