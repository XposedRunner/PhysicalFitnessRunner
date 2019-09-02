package com.zjwh.android_wh_physicalfitness.activity.find;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.google.gson.reflect.TypeToken;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.HomePageActivity;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter.O000000o;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.DynamicLikeBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.fw;
import defpackage.ga;
import defpackage.gj;
import defpackage.gk;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class DynamicLikeActivity extends BaseActivity {
    public static final String O000000o = "extra_dynamic_id";
    @ViewInject(2131296949)
    protected SwipeRefreshLayout O00000Oo;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o;
    @ViewInject(2131296942)
    private RecyclerView O00000o0;
    private fw<DynamicLikeBean> O00000oO;
    private O00000o0 O00000oo;
    private int O0000O0o;
    private int O0000OOo = 0;
    private List<DynamicLikeBean> O0000Oo = new ArrayList();
    private boolean O0000Oo0;

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.find.DynamicLikeActivity$1 */
    class AnonymousClass1 extends fw<DynamicLikeBean> {
        AnonymousClass1(Context context, int i, List list) {
            super(context, i, list);
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, final DynamicLikeBean dynamicLikeBean, int i) {
            O00Oo0.O000000o(gaVar.itemView.getContext(), dynamicLikeBean.getAvatarUrl(), (ImageView) gaVar.O000000o(R.id.comment_avatar), dynamicLikeBean.getGender());
            gaVar.O000000o((int) R.id.comment_nickname, dynamicLikeBean.getNickName());
            gaVar.O000000o((int) R.id.comment_sub_title, TextUtils.isEmpty(dynamicLikeBean.getWhatsUp()) ? "这个人很懒，什么都没留下" : dynamicLikeBean.getWhatsUp());
            gaVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    HomePageActivity.O000000o(DynamicLikeActivity.this, dynamicLikeBean.getUid());
                }
            });
        }
    }

    static {
        C.i(16777302);
    }

    private void O000000o(int i) {
        if (i == 0) {
            O00000oO(getString(R.string.txt_loading));
        }
        gj gjVar = new gj(gk.O000OoO0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lastLikeId", i);
            jSONObject.put("id", this.O0000O0o);
            jSONObject.put("size", 20);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (!DynamicLikeActivity.this.isFinishing()) {
                    if (DynamicLikeActivity.this.O0000OOo == 0) {
                        DynamicLikeActivity.this.O00000o.O000000o(null, DynamicLikeActivity.this.getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                            public void onClick(View view) {
                                DynamicLikeActivity.this.O000000o(DynamicLikeActivity.this.O0000OOo);
                            }
                        });
                    } else {
                        O0000O0o.O000000o(DynamicLikeActivity.this, DynamicLikeActivity.this.O00000o0, 10, O000000o.NetWorkError, new OnClickListener() {
                            public void onClick(View view) {
                                O0000O0o.O000000o(DynamicLikeActivity.this, DynamicLikeActivity.this.O00000o0, 10, O000000o.Loading, null);
                                DynamicLikeActivity.this.O000000o(DynamicLikeActivity.this.O0000OOo);
                            }
                        });
                    }
                }
            }

            public void onFinished() {
                DynamicLikeActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                if (!DynamicLikeActivity.this.isFinishing()) {
                    DynamicLikeActivity.this.getWindow().setBackgroundDrawableResource(R.color.white);
                    List list = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<DynamicLikeBean>>() {
                    }.getType());
                    boolean z = false;
                    DynamicLikeActivity.this.O0000Oo0 = false;
                    if (list == null || list.size() <= 0) {
                        DynamicLikeActivity.this.O00000o.O000000o(ContextCompat.getDrawable(DynamicLikeActivity.this.O0000o0, R.drawable.empty_like_icon), null, "暂无任何点赞");
                    } else {
                        DynamicLikeActivity.this.O0000Oo.addAll(list);
                        DynamicLikeActivity.this.O0000OOo = ((DynamicLikeBean) list.get(list.size() - 1)).getOperationId();
                        DynamicLikeActivity.this.O00000oo.notifyDataSetChanged();
                        DynamicLikeActivity dynamicLikeActivity = DynamicLikeActivity.this;
                        if (list.size() >= 20) {
                            z = true;
                        }
                        dynamicLikeActivity.O0000Oo0 = z;
                    }
                    if (DynamicLikeActivity.this.O0000Oo0) {
                        O0000O0o.O000000o(DynamicLikeActivity.this.O00000o0, O000000o.Normal);
                    } else {
                        DynamicLikeActivity.this.O00000oo.O00000o(DynamicLikeActivity.this.O00000oo.O00000Oo());
                    }
                }
            }
        }));
    }

    public static native void O000000o(Activity activity, int i);

    private native void O000000o(Bundle bundle);

    private native void O00000o();

    private native void O00000oO();

    public native int O000000o();

    public native void O00000Oo();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        if (!isFinishing()) {
            O00000o();
            O000000o(this.O0000OOo);
        }
    }

    public native void onSaveInstanceState(Bundle bundle);
}
