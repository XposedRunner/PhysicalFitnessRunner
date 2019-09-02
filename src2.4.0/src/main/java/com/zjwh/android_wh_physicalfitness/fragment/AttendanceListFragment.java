package com.zjwh.android_wh_physicalfitness.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.CheckAttendanceActivity;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.AttendanceRefEvt;
import com.zjwh.android_wh_physicalfitness.entity.SignResModel;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.SegmentControlView;
import com.zjwh.android_wh_physicalfitness.view.SegmentControlView.O00000Oo;
import defpackage.fw;
import defpackage.ga;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.O00000o0;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(2131427509)
public class AttendanceListFragment extends LazyFragment {
    @ViewInject(2131297035)
    RecyclerView O000000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000OOo;
    private int O0000Oo;
    private boolean O0000Oo0;
    private List<SignResModel> O0000OoO = new ArrayList();
    private fw<SignResModel> O0000Ooo;
    private int[] O0000o00 = new int[]{-16727669, -48072, -13421773};

    private class O000000o extends fw<SignResModel> {
        private boolean O00000Oo;

        O000000o(Context context, int i, List<SignResModel> list) {
            super(context, i, list);
        }

        public void O000000o(final ga gaVar, View view) {
            super.O000000o(gaVar, view);
            ((SegmentControlView) gaVar.O000000o(R.id.scv)).setOnSegmentChangedListener(new O00000Oo() {
                public void O000000o(int i) {
                    if (!O000000o.this.O00000Oo) {
                        int layoutPosition = gaVar.getLayoutPosition();
                        if (layoutPosition != -1 && layoutPosition < AttendanceListFragment.this.O0000OoO.size()) {
                            ((SignResModel) AttendanceListFragment.this.O0000OoO.get(layoutPosition)).status = i + 1;
                            if (AttendanceListFragment.this.O0000Oo != 0) {
                                AttendanceListFragment.this.O0000OoO.remove(layoutPosition);
                                AttendanceListFragment.this.O0000Ooo.notifyItemRemoved(layoutPosition);
                                if (AttendanceListFragment.this.O0000OoO.size() <= 0 || AttendanceListFragment.this.O0000OoO == null) {
                                    AttendanceListFragment.this.O0000OOo.O000000o(ContextCompat.getDrawable(AttendanceListFragment.this.getContext(), R.drawable.empty_smart_attendance_icon), "", AttendanceListFragment.this.getString(R.string.noattendance));
                                }
                            }
                            O00000o0.O000000o().O00000o(new AttendanceRefEvt(true));
                        }
                    }
                }
            });
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, SignResModel signResModel, int i) {
            this.O00000Oo = true;
            gaVar.O000000o((int) R.id.tv_studentname, signResModel.name);
            gaVar.O000000o((int) R.id.tv_studentnumber, signResModel.campusId);
            SegmentControlView segmentControlView = (SegmentControlView) gaVar.O000000o(R.id.scv);
            segmentControlView.setTextColors(AttendanceListFragment.this.O0000o00);
            segmentControlView.setSelectedIndex(signResModel.status - 1);
            this.O00000Oo = false;
        }
    }

    public static Fragment O000000o(int i) {
        AttendanceListFragment attendanceListFragment = new AttendanceListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("curIndex", i);
        attendanceListFragment.setArguments(bundle);
        O0000O0o = 0;
        return attendanceListFragment;
    }

    private void O00000Oo() {
        this.O000000o.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (this.O0000OoO == null || this.O0000OoO.size() <= 0) {
            this.O0000OOo.O000000o(ContextCompat.getDrawable(getContext(), R.drawable.empty_smart_attendance_icon), "", getString(R.string.noattendance));
            return;
        }
        this.O0000OOo.O000000o();
        this.O0000Ooo = new O000000o(getActivity(), R.layout.item_student_attendance, this.O0000OoO);
        this.O000000o.setAdapter(this.O0000Ooo);
    }

    /* Access modifiers changed, original: protected */
    public void f_() {
        if (getContext() != null && this.O0000Oo0 && this.O00000oo) {
            CheckAttendanceActivity checkAttendanceActivity = (CheckAttendanceActivity) getActivity();
            switch (this.O0000Oo) {
                case 0:
                    this.O0000OoO.clear();
                    this.O0000OoO.addAll(checkAttendanceActivity.O00000o);
                    break;
                case 1:
                    this.O0000OoO.clear();
                    this.O0000OoO.addAll(checkAttendanceActivity.O00000oO);
                    break;
                case 2:
                    this.O0000OoO.clear();
                    this.O0000OoO.addAll(checkAttendanceActivity.O00000oo);
                    break;
                case 3:
                    this.O0000OoO.clear();
                    this.O0000OoO.addAll(checkAttendanceActivity.O0000O0o);
                    break;
            }
            O00000Oo();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inject = x.view().inject(this, layoutInflater, viewGroup);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.O0000Oo = arguments.getInt("curIndex");
        }
        this.O0000Oo0 = true;
        return inject;
    }
}
