package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter.O000000o;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.PrizeListBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfoV29;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00o;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.eo;
import defpackage.gf;
import defpackage.gj;
import defpackage.gk;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class PrizeListActivity extends BaseActivity {
    @ViewInject(2131297108)
    public SwipeRefreshLayout O000000o;
    @ViewInject(2131297038)
    public RecyclerView O00000Oo;
    private O00000o0 O00000o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o0;
    private eo O00000oO;
    private boolean O00000oo;
    private int O0000O0o = 1;

    static {
        C.i(16777285);
    }

    private void O000000o(final int i) {
        SwipeRefreshLayout swipeRefreshLayout = this.O000000o;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        swipeRefreshLayout.setRefreshing(z);
        gj gjVar = new gj(gk.O00O00Oo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pageSize", 20);
            jSONObject.put("pageNum", i);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (!PrizeListActivity.this.isFinishing()) {
                    if (PrizeListActivity.this.O0000O0o == 1) {
                        PrizeListActivity.this.O00000o0.O000000o(null, PrizeListActivity.this.getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                            public void onClick(View view) {
                                PrizeListActivity.this.O00000oO(PrizeListActivity.this.getString(R.string.txt_loading));
                                PrizeListActivity.this.O000000o(1);
                            }
                        });
                    } else {
                        O0000O0o.O000000o(PrizeListActivity.this, PrizeListActivity.this.O00000Oo, 20, O000000o.NetWorkError, new OnClickListener() {
                            public void onClick(View view) {
                                O0000O0o.O000000o(PrizeListActivity.this, PrizeListActivity.this.O00000Oo, 20, O000000o.Loading, null);
                                PrizeListActivity.this.O000000o(PrizeListActivity.this.O0000O0o);
                            }
                        });
                    }
                }
            }

            public void onFinished() {
                PrizeListActivity.this.O000000o.setRefreshing(false);
                PrizeListActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                if (!PrizeListActivity.this.isFinishing()) {
                    PrizeListActivity.this.O00000o0.O000000o();
                    List<PrizeListBean> list = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<PrizeListBean>>() {
                    }.getType());
                    boolean z = false;
                    if (list == null || list.size() <= 0) {
                        if (PrizeListActivity.this.O0000O0o == 1) {
                            PrizeListActivity.this.O00000o0.O000000o(ContextCompat.getDrawable(PrizeListActivity.this.O0000o0, R.drawable.empty_prize_icon), null, "暂无任何奖励");
                        }
                        PrizeListActivity.this.O00000oo = false;
                    } else {
                        if (i == 1) {
                            PrizeListActivity.this.O00000oO.O000000o(list);
                        } else {
                            PrizeListActivity.this.O00000oO.O00000Oo(list);
                        }
                        for (PrizeListBean prizeListBean : list) {
                            if (!TextUtils.isEmpty(prizeListBean.getAdExposingCodes())) {
                                com.zjwh.android_wh_physicalfitness.utils.O00000o0.O00000Oo(prizeListBean.getAdExposingCodes());
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(gf.O000o00);
                            stringBuilder.append(prizeListBean.getPrizeName());
                            O00OO0O.O000000o(new PvDataInfoV29(gf.O000OOo, stringBuilder.toString()));
                            Context O00000oO = PrizeListActivity.this.O0000o0;
                            String str2 = O00Oo00o.O000000o.O00000o;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(gf.O000o00);
                            stringBuilder.append(prizeListBean.getPrizeName());
                            O00Oo00o.O000000o(O00000oO, str2, stringBuilder.toString());
                        }
                        PrizeListActivity prizeListActivity = PrizeListActivity.this;
                        if (list.size() >= 20) {
                            z = true;
                        }
                        prizeListActivity.O00000oo = z;
                        PrizeListActivity.this.O0000O0o = PrizeListActivity.this.O0000O0o + 1;
                    }
                    if (PrizeListActivity.this.O00000oO != null) {
                        if (PrizeListActivity.this.O00000oo) {
                            O0000O0o.O000000o(PrizeListActivity.this.O00000Oo, O000000o.Normal);
                        } else {
                            PrizeListActivity.this.O00000o.O00000o(PrizeListActivity.this.O00000o.O00000Oo());
                        }
                    }
                }
            }
        }));
    }

    public static native void O000000o(Activity activity);

    private native void O00000o();

    private native void O00000oO();

    public native int O000000o();

    public void O00000Oo() {
        this.O0000Ooo.setText("奖励列表");
        this.O000000o.setColorSchemeResources(new int[]{R.color.sport_green, R.color.green2, R.color.big_red, R.color.green3});
        this.O000000o.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                PrizeListActivity.this.O0000O0o = 1;
                PrizeListActivity.this.O000000o(PrizeListActivity.this.O0000O0o);
            }
        });
        this.O000000o.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
    }

    public void n_() {
    }

    public native void onCreate(Bundle bundle);
}
