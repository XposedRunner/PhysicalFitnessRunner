package com.qiyukf.nim.uikit.common.activity;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.c.c;
import com.qiyukf.nim.uikit.common.fragment.TFragment;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.UICustomization;
import com.qiyukf.unicorn.d;
import s.h.e.l.l.C;

public abstract class BaseFragmentActivity extends FragmentActivity {
    protected ViewGroup a;
    private boolean b = false;

    static {
        C.i(24);
    }

    private View b(View view) {
        if (!a()) {
            return view;
        }
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        LayoutInflater from = LayoutInflater.from(this);
        UICustomization uICustomization = d.e().uiCustomization;
        int i = ((uICustomization == null || !uICustomization.titleCenter) && !c()) ? R.layout.ysf_title_bar : R.layout.ysf_title_bar_center;
        this.a = (ViewGroup) from.inflate(i, linearLayout, false);
        linearLayout.addView(this.a, -1, (int) getResources().getDimension(R.dimen.ysf_title_bar_height));
        linearLayout.addView(view, -1, -1);
        return linearLayout;
    }

    private void g() {
        if (a()) {
            setTitle(getTitle());
            View findViewById = findViewById(R.id.ysf_title_bar_back_area);
            View findViewById2 = findViewById(R.id.ysf_title_bar_back_view);
            if (b()) {
                findViewById.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        BaseFragmentActivity.this.onBackPressed();
                    }
                });
            } else {
                findViewById2.setVisibility(8);
            }
            e();
        }
    }

    private static boolean h() {
        UICustomization uICustomization = d.e().uiCustomization;
        return uICustomization != null && uICustomization.titleBarStyle == 1;
    }

    /* Access modifiers changed, original: protected|final */
    public final View a(View view) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ysf_title_bar_actions_layout);
        if (linearLayout != null) {
            linearLayout.addView(view);
        }
        return view;
    }

    /* Access modifiers changed, original: protected|final */
    public final TextView a(int i) {
        Resources resources;
        int i2;
        String string = getString(i);
        View view = (TextView) LayoutInflater.from(this).inflate(R.layout.ysf_action_bar_right_text_menu, null);
        if (h()) {
            resources = getResources();
            i2 = R.color.ysf_title_bar_text_color_light_selector;
        } else {
            resources = getResources();
            i2 = R.color.ysf_title_bar_text_color_dark_selector;
        }
        view.setTextColor(resources.getColorStateList(i2));
        view.setText(string);
        a(view);
        return view;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(int i, TFragment tFragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(i, tFragment);
        try {
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception unused) {
        }
    }

    /* Access modifiers changed, original: protected */
    public boolean a() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final View b(int i) {
        return a(LayoutInflater.from(this).inflate(i, null));
    }

    /* Access modifiers changed, original: protected */
    public boolean b() {
        return true;
    }

    /* Access modifiers changed, original: protected */
    public boolean c() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final int d() {
        return (this.a == null || this.a.getVisibility() != 0) ? 0 : this.a.getHeight();
    }

    /* Access modifiers changed, original: protected */
    public void e() {
        UICustomization uICustomization = d.e().uiCustomization;
        if (uICustomization != null) {
            if (uICustomization.titleBackgroundResId > 0) {
                this.a.setBackgroundResource(uICustomization.titleBackgroundResId);
            } else if (uICustomization.titleBackgroundColor != 0) {
                this.a.setBackgroundColor(uICustomization.titleBackgroundColor);
            }
            if (h()) {
                TextView textView = (TextView) findViewById(R.id.ysf_title_bar_title);
                ((ImageView) findViewById(R.id.ysf_title_bar_back_view)).setImageResource(R.drawable.ysf_title_bar_back_icon_white);
                textView.setTextColor(-1);
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean f() {
        return VERSION.SDK_INT >= 17 ? super.isDestroyed() : this.b || super.isFinishing();
    }

    public native void onBackPressed();

    public native void onCreate(Bundle bundle);

    public native void onDestroy();

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        c.a(i, iArr);
    }

    public native void setContentView(int i);

    public native void setContentView(View view);

    public void setContentView(View view, LayoutParams layoutParams) {
        super.setContentView(b(view), layoutParams);
        g();
    }

    public native void setTitle(int i);

    public native void setTitle(CharSequence charSequence);
}
