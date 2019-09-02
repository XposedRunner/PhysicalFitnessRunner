package com.zjwh.android_wh_physicalfitness.ui.music;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.model.track.TrackList;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter.O000000o;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.MusicSwitchEvt;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.O00O00Oo;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fm$O00000Oo;
import defpackage.hp$O00000Oo;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import s.h.e.l.l.C;

@ContentView(2131427445)
public class AlbumListFragment extends BaseFragment implements fm$O00000Oo, hp$O00000Oo {
    public static final String O000000o = "extra_album_id";
    public static final String O00000oo = "extra_paid";
    public static final String O0000O0o = "extra_album_buy_type";
    public static final String O0000OOo = "extra_album_count";
    @ViewInject(2131296945)
    private RecyclerView O0000Oo;
    @ViewInject(2131297108)
    public SwipeRefreshLayout O0000Oo0;
    @ViewInject(2131296792)
    private LoadingEmptyLayout O0000OoO;
    private O000000o O0000Ooo;
    private O00000o0 O0000o0;
    private fm O0000o00;
    private AlbumDetailActivity O0000o0O;

    static {
        C.i(50);
    }

    public static native AlbumListFragment O000000o(long j, boolean z, int i, long j2);

    private O000000o O00000oo() {
        if (this.O0000Ooo == null) {
            this.O0000Ooo = new jx(this);
        }
        return this.O0000Ooo;
    }

    private native void O0000O0o();

    public native void O000000o();

    public void O000000o(int i) {
        if (getActivity() != null) {
            O00O00Oo.O000000o().O000000o(O00000oo().O000000o(), i, O00000oo().O00000o0(), O00000oo().O00000o());
        }
    }

    public native void O000000o(long j);

    public native void O000000o(TrackList trackList);

    public void O000000o(List<Track> list, boolean z) {
        if (O0000Ooo()) {
            this.O0000OoO.O000000o();
            if (this.O0000o00 != null) {
                if (z) {
                    O0000O0o.O000000o(this.O0000Oo, O000000o.O000000o);
                } else {
                    this.O0000o0.O00000o(this.O0000o0.O00000Oo());
                }
                this.O0000o00.O000000o(list);
            }
            if (getActivity() != null) {
                int O000000o = O00000oo().O000000o(O00O00Oo.O000000o().O0000OOo());
                if (O000000o >= 0 && this.O0000o00 != null) {
                    this.O0000o00.O000000o(O000000o);
                }
            }
        }
    }

    public native void O000000o(boolean z);

    public void O00000Oo() {
        if (O0000Ooo()) {
            this.O0000OoO.O000000o(null, getString(2131689968), getString(2131689969), "", new 3(this));
            if (this.O0000o0O != null) {
                this.O0000o0O.O000000o(null);
            }
        }
    }

    public native void O00000Oo(long j);

    public native void O00000o();

    public native void O00000o0();

    public native void O00000oO();

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        O00000oo().O000000o(false);
    }

    public native void onAttach(Context context);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o O00000oo = O00000oo();
        if (bundle == null) {
            bundle = getArguments();
        }
        O00000oo.O000000o(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        org.greenrobot.eventbus.O00000o0.O000000o().O000000o(this);
        return x.view().inject(this, layoutInflater, viewGroup);
    }

    public native void onDestroy();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MusicSwitchEvt musicSwitchEvt) {
        int O000000o = O00000oo().O000000o(musicSwitchEvt);
        if (O000000o >= 0 && this.O0000o00 != null) {
            this.O0000o00.O000000o(O000000o);
        }
    }

    public native void onSaveInstanceState(Bundle bundle);

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000Oo.setLayoutManager(new LinearLayoutManager(getContext()));
        this.O0000o00 = new fm(this, O00000oo().O00000oo());
        this.O0000o0 = new O00000o0(this.O0000o00);
        this.O0000Oo.setAdapter(this.O0000o0);
        this.O0000Oo.addOnScrollListener(new 1(this));
        this.O0000Oo0.setColorSchemeResources(2131099885, 2131099770, 2131099682, 2131099771);
        this.O0000Oo0.setOnRefreshListener(new 2(this));
        this.O0000Oo0.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
    }
}
