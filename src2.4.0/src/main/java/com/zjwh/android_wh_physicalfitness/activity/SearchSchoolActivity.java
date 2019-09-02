package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.activity.mine.ChooseCampusActivity;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.SchoolListEvt;
import com.zjwh.android_wh_physicalfitness.entity.School;
import com.zjwh.android_wh_physicalfitness.utils.O00000Oo;
import java.util.ArrayList;
import org.greenrobot.eventbus.O00000o0;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class SearchSchoolActivity extends BaseActivity implements OnItemClickListener {
    @ViewInject(2131296523)
    EditText O000000o;
    @ViewInject(2131297053)
    StickyListHeadersListView O00000Oo;
    @ViewInject(2131297432)
    TextView O00000o;
    @ViewInject(2131296800)
    ListView O00000o0;
    @ViewInject(2131296787)
    LinearLayout O00000oO;
    @ViewInject(2131297083)
    View O00000oo;
    OnEditorActionListener O0000O0o = new 2(this);
    private ArrayList<School> O0000OOo = new ArrayList();
    private ev O0000Oo;
    private ArrayList<School> O0000Oo0 = new ArrayList();
    private eu O0000o;
    private TextWatcher O0000oO0 = new 1(this);

    static {
        C.i(34);
    }

    public static native void O000000o(Activity activity);

    private native void O000000o(String str);

    private native void O00000Oo(String str);

    private native void O00000o();

    @Event({2131297321})
    private void onClick(View view) {
        if (view.getId() == 2131297321) {
            finish();
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getSchoolList(SchoolListEvt schoolListEvt) {
        if (schoolListEvt != null) {
            if (schoolListEvt.getList() != null && schoolListEvt.getList().size() > 0) {
                this.O0000OOo = schoolListEvt.getList();
            }
            O00000o0.O000000o().O0000O0o(schoolListEvt);
        }
    }

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Object O000000o = adapterView.getId() != 2131296800 ? this.O0000o.O000000o(i) : this.O0000Oo.O000000o(i);
        if (O000000o != null) {
            O00000o0.O000000o().O00000o(O000000o);
            O00000Oo.O00000o0(ChooseCampusActivity.class);
            O00000Oo.O00000o0(SearchSchoolActivity.class);
        }
    }
}
