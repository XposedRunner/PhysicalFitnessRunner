package com.zjwh.android_wh_physicalfitness.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.view.CircleDoneSuccessView;

/* compiled from: ToastUtil */
public class O00Oo00 {
    private static Toast O000000o;
    private static Toast O00000Oo;

    public static void O000000o(int i) {
        O000000o(MyApplication.O000000o().getText(i).toString());
    }

    public static void O000000o(Context context, int i) {
        O000000o(context, MyApplication.O000000o().getText(i).toString());
    }

    public static void O000000o(Context context, String str) {
        O00000o0(str);
    }

    public static void O000000o(String str) {
        O00000o0(str);
    }

    public static void O000000o(String str, boolean z) {
        if (O00000Oo == null) {
            View inflate = LayoutInflater.from(MyApplication.O000000o()).inflate(R.layout.layout_toast_success, null);
            CircleDoneSuccessView circleDoneSuccessView = (CircleDoneSuccessView) inflate.findViewById(R.id.toast_success);
            ((TextView) inflate.findViewById(R.id.tv_toast)).setText(str);
            O00000Oo = new Toast(MyApplication.O000000o());
            O00000Oo.setGravity(1, 0, 0);
            O00000Oo.setDuration(0);
            O00000Oo.setView(inflate);
            if (z) {
                circleDoneSuccessView.O000000o();
            } else {
                circleDoneSuccessView.O00000Oo();
            }
        } else {
            CircleDoneSuccessView circleDoneSuccessView2 = (CircleDoneSuccessView) O00000Oo.getView().findViewById(R.id.toast_success);
            if (circleDoneSuccessView2 != null) {
                if (z) {
                    circleDoneSuccessView2.O000000o();
                } else {
                    circleDoneSuccessView2.O00000Oo();
                }
                ((TextView) O00000Oo.getView().findViewById(R.id.tv_toast)).setText(str);
                O00000Oo.setDuration(0);
            } else {
                return;
            }
        }
        O00000Oo.show();
    }

    public static void O00000Oo(int i) {
        if (O000000o == null) {
            View inflate = LayoutInflater.from(MyApplication.O000000o()).inflate(R.layout.layout_toast, null);
            ((TextView) inflate.findViewById(R.id.tv_toast)).setText(i);
            O000000o = new Toast(MyApplication.O000000o());
            O000000o.setGravity(1, 0, 300);
            O000000o.setDuration(0);
            O000000o.setView(inflate);
        } else {
            TextView textView = (TextView) O000000o.getView().findViewById(R.id.tv_toast);
            if (textView != null) {
                textView.setText(i);
                O000000o.setDuration(0);
            } else {
                return;
            }
        }
        O000000o.show();
    }

    public static void O00000Oo(String str) {
        if (O000000o == null) {
            View inflate = LayoutInflater.from(MyApplication.O000000o()).inflate(R.layout.layout_toast, null);
            ((TextView) inflate.findViewById(R.id.tv_toast)).setText(str);
            O000000o = new Toast(MyApplication.O000000o());
            O000000o.setGravity(1, 0, 300);
            O000000o.setDuration(0);
            O000000o.setView(inflate);
        } else {
            ((TextView) O000000o.getView().findViewById(R.id.tv_toast)).setText(str);
            O000000o.setDuration(0);
        }
        O000000o.show();
    }

    private static void O00000o0(String str) {
        View inflate = LayoutInflater.from(MyApplication.O000000o()).inflate(R.layout.layout_toast, null);
        ((TextView) inflate.findViewById(R.id.tv_toast)).setText(str);
        Toast toast = new Toast(MyApplication.O000000o());
        toast.setGravity(1, 0, 300);
        toast.setDuration(0);
        toast.setView(inflate);
        toast.show();
    }
}
