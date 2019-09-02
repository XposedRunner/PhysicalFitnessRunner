package com.zjwh.android_wh_physicalfitness.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.MultiImageSelectorActivity;
import com.zjwh.android_wh_physicalfitness.view.dialog.O000000o;
import com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O00000o0;

/* compiled from: ShowChangeImgDialogUtils */
public class O00O0o0 {
    public static void O000000o(final Activity activity, final int i, final int i2) {
        new O000000o(activity).O000000o().O000000o(true).O00000Oo(true).O000000o(activity.getString(R.string.txt_take_pic), O00000o0.Black, new O000000o.O000000o() {
            public void O000000o(int i) {
                O00O0O0o.O00000Oo(activity);
            }
        }).O000000o(activity.getString(R.string.txt_choose_local_pic), O00000o0.Black, new O000000o.O000000o() {
            public void O000000o(int i) {
                Intent intent = new Intent(activity, MultiImageSelectorActivity.class);
                intent.putExtra("show_camera", false);
                intent.putExtra("max_select_count", i);
                intent.putExtra("select_count_mode", i2);
                if (activity.getPackageManager().resolveActivity(intent, 65536) != null) {
                    activity.startActivityForResult(intent, 0);
                } else {
                    O00Oo00.O000000o("无法启动系统相册");
                }
            }
        }).O00000Oo();
    }

    public static void O000000o(final Fragment fragment, final int i, final int i2) {
        new O000000o(fragment.getContext()).O000000o().O000000o(true).O00000Oo(true).O000000o(fragment.getString(R.string.txt_take_pic), O00000o0.Black, new O000000o.O000000o() {
            public void O000000o(int i) {
                O00O0O0o.O000000o(fragment, fragment.getContext());
            }
        }).O000000o(fragment.getString(R.string.txt_choose_local_pic), O00000o0.Black, new O000000o.O000000o() {
            public void O000000o(int i) {
                Intent intent = new Intent(fragment.getActivity(), MultiImageSelectorActivity.class);
                intent.putExtra("show_camera", false);
                intent.putExtra("max_select_count", i);
                intent.putExtra("select_count_mode", i2);
                if (fragment.getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                    fragment.startActivityForResult(intent, 0);
                } else {
                    O00Oo00.O000000o("无法启动系统相册");
                }
            }
        }).O00000Oo();
    }
}
