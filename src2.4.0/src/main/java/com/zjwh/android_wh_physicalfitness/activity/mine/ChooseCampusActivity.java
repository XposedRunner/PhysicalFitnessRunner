package com.zjwh.android_wh_physicalfitness.activity.mine;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.School;
import com.zjwh.android_wh_physicalfitness.view.MyLetterListView;
import java.util.ArrayList;
import java.util.HashMap;
import s.h.e.l.l.C;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

public class ChooseCampusActivity extends BaseActivity implements OnClickListener {
    private ImageView O000000o;
    private StickyListHeadersListView O00000Oo;
    private ArrayList<School> O00000o;
    private MyLetterListView O00000o0;
    private StickyListHeadersAdapter O00000oO;
    private TextView O00000oo;
    private HashMap<String, Integer> O0000O0o;
    private Handler O0000OOo;
    private View O0000Oo;
    private O00000Oo O0000Oo0;
    private WindowManager O0000o;

    private class O000000o implements com.zjwh.android_wh_physicalfitness.view.MyLetterListView.O000000o {
        private O000000o() {
        }

        /* synthetic */ O000000o(ChooseCampusActivity chooseCampusActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void O000000o(String str) {
            if (ChooseCampusActivity.this.O0000O0o.get(str) != null) {
                ChooseCampusActivity.this.O00000Oo.setSelection(((Integer) ChooseCampusActivity.this.O0000O0o.get(str)).intValue());
                ChooseCampusActivity.this.O00000oo.setText(str);
                ChooseCampusActivity.this.O00000oo.setVisibility(0);
                ChooseCampusActivity.this.O0000OOo.removeCallbacks(ChooseCampusActivity.this.O0000Oo0);
                ChooseCampusActivity.this.O0000OOo.postDelayed(ChooseCampusActivity.this.O0000Oo0, 1500);
            }
        }
    }

    private class O00000Oo implements Runnable {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(ChooseCampusActivity chooseCampusActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void run() {
            ChooseCampusActivity.this.O00000oo.setVisibility(8);
        }
    }

    static {
        C.i(16777305);
    }

    private native String O000000o(String str);

    public static native void O000000o(Activity activity);

    private native void O00000oO();

    private void O00000oo() {
        this.O00000oo = (TextView) LayoutInflater.from(this).inflate(R.layout.overlay, null);
        this.O00000oo.setVisibility(4);
        LayoutParams layoutParams = new LayoutParams(-2, -2, 2, 24, -3);
        this.O0000o = (WindowManager) getSystemService("window");
        if (this.O0000o != null) {
            this.O0000o.addView(this.O00000oo, layoutParams);
        }
    }

    private native void O0000O0o();

    public native int O000000o();

    public native void O00000Oo();

    public native void O00000o();

    public void n_() {
    }

    public native void onClick(View view);

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
