package com.zjwh.android_wh_physicalfitness.ui.run;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter.O000000o;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.DueRun;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fu;
import defpackage.fu.O00000Oo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

@ContentView(2131427520)
public class WaitRunFragment extends BaseFragment implements O00000Oo {
    public static final String O000000o = "extra_user_id";
    public static final String O00000oo = "extra_campus_id";
    public static final String O0000O0o = "extra_status";
    List<DueRun> O0000OOo = new ArrayList();
    Runnable O0000Oo = new Runnable() {
        public void run() {
            if (WaitRunFragment.this.O0000Ooo()) {
                if (WaitRunFragment.this.O0000OOo.size() == 0) {
                    WaitRunFragment.this.O0000o0.O000000o(ContextCompat.getDrawable(WaitRunFragment.this.getContext(), R.drawable.empty_run_room_icon), null, WaitRunFragment.this.O0000oO0 == 1 ? "暂无可加入的房间，去创建一个房间吧！" : "无已结束的约跑，快去参加一次约跑吧！");
                }
                WaitRunFragment.this.O0000o0O.notifyDataSetChanged();
            }
        }
    };
    Timer O0000Oo0;
    Handler O0000OoO = new Handler();
    @ViewInject(2131297046)
    private RecyclerView O0000Ooo;
    private int O0000o = 1;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000o0;
    @ViewInject(2131297108)
    private SwipeRefreshLayout O0000o00;
    private fu O0000o0O;
    private O00000o0 O0000o0o;
    private long O0000oO;
    private int O0000oO0 = 1;
    private boolean O0000oOO;
    private boolean O0000oOo = true;

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.run.WaitRunFragment$4 */
    class AnonymousClass4 implements MyCallback<String> {
        final /* synthetic */ int O000000o;

        AnonymousClass4(int i) {
            this.O000000o = i;
        }

        public void onCancelled(CancelledException cancelledException) {
        }

        public void onError(ResponseError responseError) {
            if (WaitRunFragment.this.O0000Ooo()) {
                if (WaitRunFragment.this.O0000o == 1) {
                    WaitRunFragment.this.O0000o0.O000000o(null, WaitRunFragment.this.getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                        public void onClick(View view) {
                            WaitRunFragment.this.O00000o0(WaitRunFragment.this.getString(R.string.txt_loading));
                            WaitRunFragment.this.O00000Oo(1);
                        }
                    });
                } else {
                    O0000O0o.O000000o(WaitRunFragment.this.getActivity(), WaitRunFragment.this.O0000Ooo, 20, O000000o.NetWorkError, new OnClickListener() {
                        public void onClick(View view) {
                            O0000O0o.O000000o(WaitRunFragment.this.getActivity(), WaitRunFragment.this.O0000Ooo, 20, O000000o.Loading, null);
                            WaitRunFragment.this.O00000Oo(WaitRunFragment.this.O0000o);
                        }
                    });
                }
            }
        }

        public void onFinished() {
            if (WaitRunFragment.this.O0000Ooo()) {
                WaitRunFragment.this.O0000o00.setRefreshing(false);
                WaitRunFragment.this.O0000o00();
            }
        }

        public void onSuccess(String str) {
            if (WaitRunFragment.this.O0000Ooo()) {
                WaitRunFragment.this.O0000o0.O000000o();
                List<DueRun> list = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<DueRun>>() {
                }.getType());
                boolean z = false;
                if (list == null || list.size() <= 0) {
                    if (WaitRunFragment.this.O0000o == 1) {
                        WaitRunFragment.this.O0000o0.O000000o(ContextCompat.getDrawable(WaitRunFragment.this.getContext(), R.drawable.empty_run_room_icon), null, WaitRunFragment.this.O0000oO0 == 1 ? "暂无可加入的房间，去创建一个房间吧！" : "无已结束的约跑，快去参加一次约跑吧！");
                    }
                    WaitRunFragment.this.O0000oOO = false;
                } else {
                    if (this.O000000o == 1) {
                        if (WaitRunFragment.this.O0000oO0 == 1) {
                            WaitRunFragment.this.O00000o0();
                            WaitRunFragment.this.O0000Oo0 = new Timer();
                            WaitRunFragment.this.O0000Oo0.schedule(new TimerTask() {
                                public void run() {
                                    if (WaitRunFragment.this.O0000Ooo() && WaitRunFragment.this.O0000OOo != null) {
                                        Iterator it = WaitRunFragment.this.O0000OOo.iterator();
                                        while (it.hasNext()) {
                                            DueRun dueRun = (DueRun) it.next();
                                            if (dueRun != null) {
                                                WaitRunFragment.this.O0000oO = dueRun.getLeftTime();
                                                WaitRunFragment.this.O0000oO = WaitRunFragment.this.O0000oO - 1000;
                                                dueRun.setLeftTime(WaitRunFragment.this.O0000oO);
                                                if (WaitRunFragment.this.O0000oO <= com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O000000o.O00000o0) {
                                                    it.remove();
                                                }
                                            }
                                        }
                                        WaitRunFragment.this.O0000OoO.post(WaitRunFragment.this.O0000Oo);
                                    }
                                }
                            }, 1000, 1000);
                        }
                        WaitRunFragment.this.O0000OOo.clear();
                    } else if (WaitRunFragment.this.O0000OOo == null) {
                        WaitRunFragment.this.O0000OOo = new ArrayList();
                    }
                    for (DueRun dueRun : list) {
                        long abs = Math.abs(System.currentTimeMillis() - dueRun.getEndTime());
                        if (Math.abs(abs - (dueRun.getLeftTime() / 1000)) < 5) {
                            dueRun.setLeftTime(abs);
                        }
                        WaitRunFragment.this.O0000OOo.add(dueRun);
                    }
                    WaitRunFragment waitRunFragment = WaitRunFragment.this;
                    if (list.size() >= 20) {
                        z = true;
                    }
                    waitRunFragment.O0000oOO = z;
                    WaitRunFragment.this.O0000o = WaitRunFragment.this.O0000o + 1;
                }
                if (WaitRunFragment.this.O0000o0O != null) {
                    if (WaitRunFragment.this.O0000oOO) {
                        O0000O0o.O000000o(WaitRunFragment.this.O0000Ooo, O000000o.Normal);
                    } else {
                        WaitRunFragment.this.O0000o0o.O00000o(WaitRunFragment.this.O0000o0o.O00000Oo());
                    }
                    WaitRunFragment.this.O0000o0O.notifyDataSetChanged();
                }
            }
        }
    }

    static {
        C.i(16777369);
    }

    public static native WaitRunFragment O000000o(int i);

    private native void O000000o(Bundle bundle);

    private native void O00000o0();

    public native void O000000o(DueRun dueRun);

    public native void O00000Oo();

    public native void O00000Oo(int i);

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
    }

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDestroy();

    public native void onHiddenChanged(boolean z);

    public native void onResume();

    public native void onSaveInstanceState(Bundle bundle);

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O0000o00.setColorSchemeResources(new int[]{R.color.sport_green, R.color.green2, R.color.big_red, R.color.green3});
        this.O0000o00.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                if (WaitRunFragment.this.O0000Oo0 != null) {
                    WaitRunFragment.this.O0000Oo0.cancel();
                    WaitRunFragment.this.O0000Oo0 = null;
                }
                WaitRunFragment.this.O0000o = 1;
                WaitRunFragment.this.O00000Oo(WaitRunFragment.this.O0000o);
            }
        });
        boolean z = true;
        this.O0000o00.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.O0000Ooo.setLayoutManager(new GridLayoutManager(getContext(), 2));
        List list = this.O0000OOo;
        if (this.O0000oO0 != 1) {
            z = false;
        }
        this.O0000o0O = new fu(list, this, z);
        this.O0000o0o = new O00000o0(this.O0000o0O);
        this.O0000Ooo.setAdapter(this.O0000o0o);
        this.O0000Ooo.addOnScrollListener(new com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo() {
            public void O000000o(View view) {
                WaitRunFragment.this.O00000Oo();
            }
        });
    }
}
