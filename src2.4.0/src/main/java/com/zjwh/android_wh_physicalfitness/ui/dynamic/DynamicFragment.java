package com.zjwh.android_wh_physicalfitness.ui.dynamic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.PageTabEvt;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.gq$O00000Oo;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427495)
public class DynamicFragment extends BaseFragment implements gq$O00000Oo {
    public static final String O000000o = "DynamicFragment";
    public static final int O00000oo = 1000;
    public static final String O0000O0o = "extra_user_id";
    public static final String O0000OOo = "extra_topic_id";
    public static final String O0000Oo = "key_action_comment_count";
    public static final String O0000Oo0 = "extra_type";
    public static final String O0000OoO = "key_action_comment";
    public static final String O0000Ooo = "key_action_comment_id";
    public static final String O0000o = "action_comment_dynamic";
    public static final String O0000o0 = "action_delete_dynamic";
    public static final String O0000o00 = "action_update_data";
    public static final String O0000o0O = "action_delete_dynamic_comment";
    public static final String O0000o0o = "action_like_dynamic";
    public static final String O0000oO0 = "action_comment_like";
    @ViewInject(2131296949)
    protected SwipeRefreshLayout O0000oO;
    @ViewInject(2131297288)
    private TextView O0000oOO;
    @ViewInject(2131296942)
    private RecyclerView O0000oOo;
    @ViewInject(2131296874)
    private NestedScrollView O0000oo;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000oo0;
    private O000000o O0000ooO;
    private O00000o0 O0000ooo;
    private BroadcastReceiver O000O00o;
    private O000000o O000O0OO;
    private O00000Oo O000O0Oo;
    private O00000o0 O00oOooO;
    private LocalBroadcastManager O00oOooo;

    static {
        C.i(45);
    }

    public static native DynamicFragment O000000o(int i, int i2, int i3);

    private synchronized O000000o O0000o0() {
        if (this.O0000ooO == null) {
            this.O0000ooO = new jl(this, getContext());
        }
        return this.O0000ooO;
    }

    private native void O0000o0O();

    public native void O000000o();

    public native void O000000o(int i);

    public native void O000000o(String str);

    public native void O000000o(String str, String str2);

    public void O000000o(O000000o o000000o, String str, OnClickListener onClickListener) {
        if (O0000Ooo()) {
            switch (4.O000000o[o000000o.ordinal()]) {
                case 1:
                    this.O0000oo.setVisibility(8);
                    this.O0000oO.setVisibility(0);
                    break;
                case 2:
                    this.O0000oo.setVisibility(0);
                    this.O0000oO.setVisibility(8);
                    if (!TextUtils.isEmpty(str)) {
                        this.O0000oo0.O000000o(null, getString(2131689986), str, "", onClickListener);
                        break;
                    }
                    this.O0000oo0.O000000o(str, onClickListener);
                    break;
                default:
                    this.O0000oOO.setVisibility(8);
                    this.O0000oo.setVisibility(0);
                    this.O0000oO.setVisibility(8);
                    this.O0000oo0.O000000o(O0000o0().O0000Oo(), str, onClickListener);
                    break;
            }
        }
    }

    public native void O000000o(boolean z);

    public native void O00000Oo();

    public native void O00000Oo(int i);

    public native void O00000o();

    public native void O00000o(int i);

    public native void O00000o0();

    public native void O00000o0(int i);

    public native void O00000oO();

    public native void O00000oO(int i);

    public native boolean O00000oo();

    public native void O0000O0o();

    public native void O0000OOo();

    public native void O0000Oo0();

    /* Access modifiers changed, original: protected */
    public void f_() {
        if (this.O00000o0 && this.O00000Oo) {
            O0000o0().O0000Oo0();
            this.O00000o0 = false;
            this.O00000Oo = false;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handleRunDataChanged(PageTabEvt pageTabEvt) {
        if (O0000o0().O000000o(pageTabEvt.getPosition())) {
            int[] findFirstVisibleItemPositions = ((StaggeredGridLayoutManager) this.O0000oOo.getLayoutManager()).findFirstVisibleItemPositions(null);
            if (findFirstVisibleItemPositions == null || findFirstVisibleItemPositions.length <= 0) {
                this.O0000oOo.scrollToPosition(0);
                return;
            }
            int i = findFirstVisibleItemPositions[0];
            if (i == 0) {
                this.O0000oOo.scrollBy(0, this.O0000oOo.getChildAt(i).getTop());
                return;
            }
            this.O0000oOo.scrollToPosition(0);
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (O0000o0().O00000oo()) {
            this.O00000Oo = true;
        }
        f_();
    }

    public native void onAttach(Context context);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O0000o0O();
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        org.greenrobot.eventbus.O00000o0.O000000o().O000000o(this);
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public native void onDestroy();

    public native void onDetach();

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        O0000o0().O00000Oo(bundle);
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        O000000o O0000o0 = O0000o0();
        if (bundle == null) {
            bundle = getArguments();
        }
        O0000o0.O000000o(bundle);
        this.O0000oOo.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        ((SimpleItemAnimator) this.O0000oOo.getItemAnimator()).setSupportsChangeAnimations(false);
        this.O0000oOo.getItemAnimator().setChangeDuration(0);
        this.O0000ooo = O0000o0().O00000Oo();
        this.O00oOooO = new O00000o0(this.O0000ooo);
        this.O0000oOo.setAdapter(this.O00oOooO);
        if (O0000o0().O00000oO()) {
            this.O000O0Oo = new 1(this);
            this.O0000oOo.addOnScrollListener(this.O000O0Oo);
        }
        this.O0000oO.setColorSchemeResources(2131099885, 2131099770, 2131099682, 2131099771);
        this.O0000oO.setOnRefreshListener(new 2(this));
        this.O0000oO.setEnabled(O0000o0().O00000o());
    }
}
