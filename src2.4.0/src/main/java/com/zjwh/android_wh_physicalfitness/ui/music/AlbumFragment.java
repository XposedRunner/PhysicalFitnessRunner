package com.zjwh.android_wh_physicalfitness.ui.music;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.music.AlbumListBean;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fk;
import defpackage.hm.O000000o;
import defpackage.hm.O00000Oo;
import defpackage.jy;
import java.util.List;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427508)
public class AlbumFragment extends BaseFragment implements O00000Oo {
    public static final String O000000o = "extra_classify_if";
    public static final String O00000oo = "extra_tag_name";
    public static final String O0000O0o = "extra_calc_dimension";
    @ViewInject(2131297108)
    public SwipeRefreshLayout O0000OOo;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000Oo;
    @ViewInject(2131296945)
    private RecyclerView O0000Oo0;
    private O000000o O0000OoO;
    private fk O0000Ooo;
    private O00000o0 O0000o00;

    static {
        C.i(16777344);
    }

    public static native AlbumFragment O000000o(long j, String str, int i);

    private O000000o O00000oo() {
        if (this.O0000OoO == null) {
            this.O0000OoO = new jy(this);
        }
        return this.O0000OoO;
    }

    private native void O0000O0o();

    public native void O000000o();

    public void O000000o(List<AlbumListBean> list, boolean z) {
        if (O0000Ooo()) {
            this.O0000Oo.O000000o();
            if (this.O0000Ooo != null) {
                this.O0000Ooo.O000000o(list);
                if (z) {
                    O0000O0o.O000000o(this.O0000Oo0, LoadingFooter.O000000o.Normal);
                } else {
                    this.O0000o00.O00000o(this.O0000o00.O00000Oo());
                }
            }
        }
    }

    public native void O000000o(boolean z);

    public void O00000Oo() {
        if (O0000Ooo()) {
            this.O0000Oo.O000000o(null, getString(R.string.txt_music_error), getString(R.string.txt_music_reload), "", new OnClickListener() {
                public void onClick(View view) {
                    AlbumFragment.this.O00000oo().O000000o(1);
                    AlbumFragment.this.O00000oo().O000000o(true);
                }
            });
        }
    }

    public native void O00000o();

    public native void O00000o0();

    public native void O00000oO();

    /* Access modifiers changed, original: protected */
    public void f_() {
        super.f_();
        if (this.O00000o0 && this.O00000Oo) {
            O00000oo().O000000o(false);
            this.O00000o0 = false;
            this.O00000Oo = false;
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        f_();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O00000oo().O000000o(getArguments());
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public native void onDestroy();

    public native void onSaveInstanceState(Bundle bundle);

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000Oo0.setLayoutManager(new LinearLayoutManager(getContext()));
        this.O0000Ooo = new fk();
        this.O0000o00 = new O00000o0(this.O0000Ooo);
        this.O0000Oo0.setAdapter(this.O0000o00);
        this.O0000Oo0.addOnScrollListener(new com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo() {
            public void O000000o(View view) {
                AlbumFragment.this.O0000O0o();
            }
        });
        this.O0000OOo.setColorSchemeResources(new int[]{R.color.sport_green, R.color.green2, R.color.big_red, R.color.green3});
        this.O0000OOo.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                AlbumFragment.this.O00000oo().O000000o(1);
                AlbumFragment.this.O00000oo().O000000o(false);
            }
        });
        this.O0000OOo.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
    }
}
