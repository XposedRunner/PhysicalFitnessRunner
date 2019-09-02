package com.zjwh.android_wh_physicalfitness.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import defpackage.O00Oo;
import defpackage.O0Oo0;
import defpackage.dt;
import java.util.ArrayList;
import java.util.List;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class WelcomeLoginActivity extends BaseActivity implements OnTouchListener {
    @ViewInject(2131297485)
    public ViewPager O000000o;
    @ViewInject(2131296751)
    public LinearLayout O00000Oo;
    Runnable O00000o = new Runnable() {
        public void run() {
            WelcomeLoginActivity.this.O000000o.setCurrentItem(WelcomeLoginActivity.this.O000000o.getCurrentItem() + 1);
            WelcomeLoginActivity.this.O00000o0.postDelayed(WelcomeLoginActivity.this.O00000o, 3000);
        }
    };
    Handler O00000o0 = new Handler();
    private List<ImageView> O00000oO;
    private int[] O00000oo = new int[]{R.drawable.welcome_login_img_1, R.drawable.welcome_login_img_2, R.drawable.welcome_login_img_3, R.drawable.welcome_login_img_4};
    private int O0000O0o = 0;

    private class O000000o implements OnPageChangeListener {
        private O000000o() {
        }

        /* synthetic */ O000000o(WelcomeLoginActivity welcomeLoginActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            i %= WelcomeLoginActivity.this.O00000oo.length;
            WelcomeLoginActivity.this.O00000Oo.getChildAt(i).setEnabled(true);
            WelcomeLoginActivity.this.O00000Oo.getChildAt(WelcomeLoginActivity.this.O0000O0o).setEnabled(false);
            WelcomeLoginActivity.this.O0000O0o = i;
        }
    }

    static {
        C.i(16777292);
    }

    private native void O00000o();

    @Event(type = OnClickListener.class, value = {2131297392, 2131297367})
    private void onClick(View view) {
        if (!O00OOo0.O000000o()) {
            try {
                startActivity(view.getId() != R.id.tv_login ? new Intent(this, RegisterActivity.class) : new Intent(this, LoginActivity.class));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
        this.O00000oO = new ArrayList();
        for (int i : this.O00000oo) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(new LayoutParams(-1, -1));
            imageView.setScaleType(ScaleType.CENTER_CROP);
            O00Oo.O000000o((FragmentActivity) this).O000000o(Integer.valueOf(i)).O00000Oo(true).O00000Oo(O0Oo0.NONE).O000000o(imageView);
            this.O00000oO.add(imageView);
            View view = new View(this);
            LayoutParams layoutParams = new LayoutParams(DensityUtil.dip2px(7.0f), DensityUtil.dip2px(7.0f));
            layoutParams.leftMargin = DensityUtil.dip2px(5.0f);
            layoutParams.rightMargin = DensityUtil.dip2px(5.0f);
            view.setBackgroundResource(R.drawable.selector_dot);
            view.setLayoutParams(layoutParams);
            view.setEnabled(false);
            this.O00000Oo.addView(view);
        }
        this.O000000o.setAdapter(new dt(this.O00000oO));
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public native boolean onKeyDown(int i, KeyEvent keyEvent);

    public native void onPause();

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
        if (this.O00000o0 != null && this.O00000o != null) {
            this.O00000o0.postDelayed(this.O00000o, 3000);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 3) {
            switch (action) {
                case 0:
                    this.O00000o0.removeCallbacks(this.O00000o);
                    break;
                case 1:
                    break;
            }
        }
        this.O00000o0.postDelayed(this.O00000o, 3000);
        return false;
    }
}
