package com.zjwh.android_wh_physicalfitness.ui.music;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.BannerBean;
import com.zjwh.android_wh_physicalfitness.entity.music.AlbumListBean;
import com.zjwh.android_wh_physicalfitness.entity.music.MusicClassifyBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.O0000OOo;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0OO;
import com.zjwh.android_wh_physicalfitness.view.banner.DecentBanner;
import com.zjwh.android_wh_physicalfitness.view.banner.O000000o.O00000Oo;
import com.zjwh.android_wh_physicalfitness.view.banner.O00000o;
import defpackage.fl;
import defpackage.fo;
import defpackage.gf;
import defpackage.hs;
import defpackage.hs.O000000o;
import defpackage.kb;
import java.util.ArrayList;
import java.util.List;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class MusicMainActivity extends BaseActivity implements O00000Oo, hs.O00000Oo {
    @ViewInject(2131296303)
    private AppBarLayout O000000o;
    @ViewInject(2131296740)
    private ImageView O00000Oo;
    @ViewInject(2131296972)
    private ImageView O00000o;
    @ViewInject(2131297158)
    private TextView O00000o0;
    @ViewInject(2131296949)
    private SwipeRefreshLayout O00000oO;
    @ViewInject(2131296538)
    private DecentBanner O00000oo;
    @ViewInject(2131296943)
    private RecyclerView O0000O0o;
    @ViewInject(2131296945)
    private RecyclerView O0000OOo;
    private O000000o O0000Oo;
    @ViewInject(2131296555)
    private FloatingActionButton O0000Oo0;
    private fl O0000o;
    private OnOffsetChangedListener O0000oO;
    private O00000o0 O0000oO0;

    static {
        C.i(16777347);
    }

    public static native void O000000o(Activity activity);

    private void O0000Oo0() {
        this.O0000oO = new OnOffsetChangedListener() {
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                MusicMainActivity.this.O00000oO.setEnabled(i >= 0);
            }
        };
        this.O00000oO.setColorSchemeResources(new int[]{R.color.sport_green, R.color.green2, R.color.big_red, R.color.green3});
        this.O00000oO.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                MusicMainActivity.this.O0000OOo().O000000o(MusicMainActivity.this.O0000o0);
            }
        });
        this.O00000oO.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.O000000o.addOnOffsetChangedListener(this.O0000oO);
        this.O0000O0o.setLayoutManager(new GridLayoutManager(this, 5));
        this.O0000OOo.setLayoutManager(new GridLayoutManager(this, 2));
        this.O0000OOo.addItemDecoration(new O00O0Oo(2, DensityUtil.dip2px(15.0f), true));
        this.O0000o = new fl();
        this.O0000oO0 = new O00000o0(this.O0000o);
        this.O0000OOo.setAdapter(this.O0000oO0);
        this.O0000OOo.addOnScrollListener(new com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo() {
            public void O000000o(View view) {
                if (!(O0000O0o.O000000o(MusicMainActivity.this.O0000OOo) == LoadingFooter.O000000o.Loading || MusicMainActivity.this.O0000Oo == null)) {
                    MusicMainActivity.this.O0000Oo.O00000Oo();
                }
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (MusicMainActivity.this.O0000o.getItemCount() > 0) {
                    if (i == 0) {
                        int findFirstVisibleItemPosition = ((GridLayoutManager) MusicMainActivity.this.O0000OOo.getLayoutManager()).findFirstVisibleItemPosition();
                        View childAt = MusicMainActivity.this.O0000OOo.getChildAt(0);
                        if (childAt != null && (Math.abs(childAt.getTop()) > DensityUtil.dip2px(15.0f) || findFirstVisibleItemPosition > 0)) {
                            O00Oo0OO.O00000Oo(MusicMainActivity.this.O0000Oo0);
                        }
                    } else {
                        O00Oo0OO.O000000o(MusicMainActivity.this.O0000Oo0);
                    }
                }
            }
        });
        this.O0000Oo0.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (((GridLayoutManager) MusicMainActivity.this.O0000OOo.getLayoutManager()).findFirstVisibleItemPosition() == 0) {
                    MusicMainActivity.this.O0000OOo.scrollBy(0, MusicMainActivity.this.O0000OOo.getChildAt(0).getTop());
                } else {
                    MusicMainActivity.this.O0000OOo.scrollToPosition(0);
                }
                MusicMainActivity.this.O0000Oo0.setVisibility(8);
            }
        });
    }

    @Event({2131297260, 2131297238, 2131297226})
    private void onClick(View view) {
        if (!O00OOo0.O000000o()) {
            int id = view.getId();
            if (id == R.id.tvHistory) {
                MusicPlayHistoryActivity.O000000o((Activity) this);
            } else if (id == R.id.tvPaid) {
                MusicPurchasedActivity.O000000o((Activity) this);
            } else if (id == R.id.tvSearch) {
                MusicSearchActivity.O000000o(this, 2);
            }
        }
    }

    public native int O000000o();

    public native void O000000o(com.zjwh.android_wh_physicalfitness.view.banner.O000000o o000000o);

    public void O000000o(List<BannerBean> list) {
        if (list == null || list.size() <= 0) {
            this.O00000oo.setVisibility(8);
            return;
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            O00000o o00000o = new O00000o(this.O0000o0);
            BannerBean bannerBean = (BannerBean) list.get(i);
            if (bannerBean != null) {
                O0000OOo.O000000o(o00000o, bannerBean, i);
                o00000o.O000000o((O00000Oo) this);
                arrayList.add(o00000o);
                if (i < 3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(gf.O000o00);
                    stringBuilder.append(bannerBean.getId());
                    O00OO0O.O000000o(new PvDataInfoV29(gf.O000Oo0, stringBuilder.toString()));
                    String str = O00Oo00o.O000000o.O0000o0;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(O00Oo00o.O00000o0.O000000o);
                    stringBuilder2.append(i);
                    stringBuilder2.append("_");
                    stringBuilder2.append(bannerBean.getId());
                    O00Oo00o.O000000o(this, str, stringBuilder2.toString());
                }
            }
        }
        this.O00000oo.O000000o(arrayList);
        this.O00000oo.setVisibility(0);
    }

    public void O000000o(List<AlbumListBean> list, boolean z, boolean z2) {
        if (this.O0000o != null) {
            if (z) {
                this.O0000o.O000000o(list);
            } else {
                this.O0000o.O00000Oo(list);
            }
            if (z2) {
                O0000O0o.O000000o(this.O0000OOo, LoadingFooter.O000000o.Normal);
            } else {
                this.O0000oO0.O00000o(this.O0000oO0.O00000Oo());
            }
        }
    }

    public native void O00000Oo();

    public void O00000Oo(List<MusicClassifyBean> list) {
        this.O0000O0o.setAdapter(new fo(list));
    }

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public native void O0000O0o();

    public O000000o O0000OOo() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new kb(this, this.O0000o0);
        }
        return this.O0000Oo;
    }

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(R.color.white);
        O0000Oo0();
        O0000OOo().O000000o(this.O0000o0);
    }

    public native void onDestroy();
}
