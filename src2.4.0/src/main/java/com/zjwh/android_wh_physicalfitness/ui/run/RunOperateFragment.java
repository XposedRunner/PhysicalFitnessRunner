package com.zjwh.android_wh_physicalfitness.ui.run;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.yalantis.ucrop.view.CropImageView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0OO;
import com.zjwh.android_wh_physicalfitness.view.RunOperateButton;
import com.zjwh.android_wh_physicalfitness.view.RunOperateButton.O000000o;
import com.zjwh.android_wh_physicalfitness.view.RunOperateButton.O00000Oo;
import com.zjwh.android_wh_physicalfitness.view.SlideUnlockView;
import com.zjwh.android_wh_physicalfitness.view.shimmer.ShimmerTextView;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427633)
public class RunOperateFragment extends BaseFragment implements O000000o, O000000o, O00000Oo {
    public static final String O000000o = "RunOperateFragment";
    @ViewInject(2131297011)
    private ImageButton O00000oo;
    @ViewInject(2131297017)
    private ImageView O0000O0o;
    @ViewInject(2131297018)
    private TextView O0000OOo;
    @ViewInject(2131297029)
    private TextView O0000Oo;
    @ViewInject(2131297012)
    private TextView O0000Oo0;
    @ViewInject(2131297031)
    private TextView O0000OoO;
    @ViewInject(2131297010)
    private TextView O0000Ooo;
    @ViewInject(2131297028)
    private ShimmerTextView O0000o;
    @ViewInject(2131297019)
    private RunOperateButton O0000o0;
    @ViewInject(2131297027)
    private RunOperateButton O0000o00;
    @ViewInject(2131297014)
    private RunOperateButton O0000o0O;
    @ViewInject(2131297032)
    private SlideUnlockView O0000o0o;
    @ViewInject(2131297021)
    private ImageButton O0000oO;
    @ViewInject(2131297022)
    private View O0000oO0;
    @ViewInject(2131297023)
    private View O0000oOO;
    private BaseRunActivity O0000oOo;
    private Animator O0000oo;
    private com.zjwh.android_wh_physicalfitness.view.shimmer.O000000o O0000oo0;
    private Animator O0000ooO;
    private Animator O0000ooo;
    private Animator O00oOooO;

    static {
        C.i(16777366);
    }

    private native void O000000o(boolean z);

    private native void O00000o();

    private native void O00000o0();

    private native void O00000oO();

    @Event({2131297011, 2131297021})
    private void clickEvent(View view) {
        int id = view.getId();
        if (id != R.id.run_change_page) {
            if (id == R.id.run_lock_btn) {
                this.O00000oo.setEnabled(false);
                if (this.O0000oo0 != null) {
                    this.O0000oo0.O000000o(this.O0000o);
                }
                O00000o0();
            }
        } else if (this.O0000oOo != null) {
            this.O0000oOo.O00000oO(1);
        }
    }

    public native void O000000o(View view);

    public native void O000000o(RunOperateButton runOperateButton, float f);

    public native void O000000o(String str);

    public native void O00000Oo();

    public native void O00000Oo(int i, int i2);

    public native void O00000Oo(boolean z);

    public native void O00000o(String str);

    public native void O00000oO(String str);

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.O0000oo0 = new com.zjwh.android_wh_physicalfitness.view.shimmer.O000000o();
    }

    public native void onAttach(Context context);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.O00000oO = false;
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public native void onDestroy();

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000Oo0.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Impact.ttf"));
        this.O0000Oo.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Impact.ttf"));
        this.O0000OoO.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Impact.ttf"));
        this.O0000Ooo.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/Impact.ttf"));
        O00Oo0OO.O000000o(getActivity(), this.O00000oo);
        O00Oo0OO.O000000o(getActivity(), this.O0000O0o);
        O00Oo0OO.O000000o(getActivity(), this.O0000OOo);
        this.O0000o0o.setOnUnLockListener(new SlideUnlockView.O000000o() {
            public void O000000o(float f) {
                RunOperateFragment.this.O0000o.setVisibility(f == CropImageView.DEFAULT_ASPECT_RATIO ? 0 : 8);
            }

            public void O000000o(boolean z) {
                if (z) {
                    RunOperateFragment.this.O000000o(false);
                    RunOperateFragment.this.O00000oo.setEnabled(true);
                    RunOperateFragment.this.O0000oOO.setVisibility(8);
                    RunOperateFragment.this.O0000oOo.O0000o0().O000000o(false);
                    if (RunOperateFragment.this.O0000oo0 != null) {
                        RunOperateFragment.this.O0000oo0.O00000oo();
                    }
                }
            }
        });
        this.O0000o0.setOnOperateClickListener(this);
        this.O0000o00.setOnOperateClickListener(this);
        this.O0000o0O.setOnOperateProgressListener(this);
    }
}
