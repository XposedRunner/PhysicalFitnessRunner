package com.zjwh.android_wh_physicalfitness.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.fragment.AttendanceListFragment;

class CheckAttendanceActivity$O000000o extends FragmentPagerAdapter {
    final /* synthetic */ CheckAttendanceActivity O000000o;

    CheckAttendanceActivity$O000000o(CheckAttendanceActivity checkAttendanceActivity, FragmentManager fragmentManager) {
        this.O000000o = checkAttendanceActivity;
        super(fragmentManager);
    }

    /* Access modifiers changed, original: 0000 */
    public View O000000o(int i) {
        View inflate = LayoutInflater.from(this.O000000o).inflate(R.layout.layout_attance_tabitem, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_attend_state);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_studentcounts);
        View findViewById = inflate.findViewById(R.id.tab_deliver);
        if (i == CheckAttendanceActivity.O00000o(this.O000000o).length - 1) {
            findViewById.setVisibility(4);
        }
        this.O000000o.O0000OOo.add(textView2);
        textView.setText(CheckAttendanceActivity.O00000o(this.O000000o)[i]);
        return inflate;
    }

    public int getCount() {
        return CheckAttendanceActivity.O00000o(this.O000000o).length;
    }

    public Fragment getItem(int i) {
        return AttendanceListFragment.O000000o(i);
    }
}
