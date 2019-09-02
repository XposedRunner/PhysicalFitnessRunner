package com.zjwh.android_wh_physicalfitness.activity.find;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gson.reflect.TypeToken;
import com.sw.emoji.EmoticonsKeyboard;
import com.sw.emoji.EmoticonsKeyboard.O00000Oo;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.HomePageActivity;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.application.MyApplication;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.CommentBean;
import com.zjwh.android_wh_physicalfitness.entity.ConcernResultBean;
import com.zjwh.android_wh_physicalfitness.entity.DynamicBean;
import com.zjwh.android_wh_physicalfitness.entity.DynamicCommentBean;
import com.zjwh.android_wh_physicalfitness.entity.DynamicFileBean;
import com.zjwh.android_wh_physicalfitness.entity.DynamicLikeBean;
import com.zjwh.android_wh_physicalfitness.entity.DynamicTagBean;
import com.zjwh.android_wh_physicalfitness.entity.FansListBean;
import com.zjwh.android_wh_physicalfitness.entity.FindDetailBean;
import com.zjwh.android_wh_physicalfitness.entity.NewsHotCommentBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o;
import defpackage.O00Oo;
import defpackage.dr;
import defpackage.fc;
import defpackage.fw;
import defpackage.ga;
import defpackage.gi;
import defpackage.gj;
import defpackage.gk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class DynamicDetailActivity extends BaseActivity {
    public static final String O000000o = "dynamic_id";
    public static final String O00000Oo = "extra_show_input";
    @ViewInject(2131296795)
    private LoadingEmptyLayout O00000o;
    @ViewInject(2131296716)
    private EmoticonsKeyboard O00000o0;
    @ViewInject(2131296942)
    private RecyclerView O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private ImageView O0000OOo;
    private TextView O0000Oo;
    private RecyclerView O0000Oo0;
    private TextView O0000o;
    private TextView O0000oO;
    private TextView O0000oO0;
    private TextView O0000oOO;
    private TextView O0000oOo;
    private View O0000oo;
    private ImageButton O0000oo0;
    private View O0000ooO;
    private ImageView O0000ooo;
    private dr O000O00o;
    private O00000o0 O000O0OO;
    private HashMap<String, String> O000O0Oo = new HashMap();
    private DynamicBean O000O0o;
    private int O000O0o0;
    private List<DynamicLikeBean> O000O0oO = new ArrayList();
    private int O000O0oo;
    private int O000OO;
    private int O000OO00 = 0;
    private int O000OO0o = 0;
    private int O000OOOo;
    private int O000OOo = 0;
    private int O000OOo0 = 2;
    private int O000OOoO;
    private boolean O000OOoo;
    private boolean O000Oo00;
    private FindDetailBean O00oOoOo;
    private TextView O00oOooO;
    private fw<DynamicLikeBean> O00oOooo;

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity$10 */
    class AnonymousClass10 implements MyCallback<String> {
        final /* synthetic */ FansListBean O000000o;

        AnonymousClass10(FansListBean fansListBean) {
            this.O000000o = fansListBean;
        }

        public void onCancelled(CancelledException cancelledException) {
            this.O000000o.setServiceDoing(false);
        }

        public void onError(ResponseError responseError) {
            this.O000000o.setServiceDoing(false);
            O00Oo00.O000000o(responseError.getMessage(), false);
        }

        public void onFinished() {
        }

        public void onSuccess(String str) {
            ConcernResultBean concernResultBean = (ConcernResultBean) O000o000.O000000o().fromJson(str, ConcernResultBean.class);
            this.O000000o.setServiceDoing(false);
            if (concernResultBean != null) {
                this.O000000o.setInterestStatus(concernResultBean.getInterestStatus());
                DynamicDetailActivity.this.O000000o(concernResultBean.getInterestStatus());
            }
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity$24 */
    class AnonymousClass24 extends fw<DynamicLikeBean> {
        AnonymousClass24(Context context, int i, List list) {
            super(context, i, list);
        }

        /* Access modifiers changed, original: protected */
        public void O000000o(ga gaVar, final DynamicLikeBean dynamicLikeBean, int i) {
            O00Oo0.O000000o(gaVar.itemView.getContext(), dynamicLikeBean.getAvatarUrl(), (ImageView) gaVar.O000000o(R.id.dynamic_like_avatar), dynamicLikeBean.getGender());
            gaVar.itemView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    HomePageActivity.O000000o(DynamicDetailActivity.this, dynamicLikeBean.getUid());
                }
            });
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity$4 */
    class AnonymousClass4 implements O000000o {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;

        AnonymousClass4(int i, int i2) {
            this.O000000o = i;
            this.O00000Oo = i2;
        }

        public void O000000o(int i) {
            DynamicDetailActivity.this.O000000o(this.O000000o, this.O00000Oo);
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity$5 */
    class AnonymousClass5 implements O000000o {
        final /* synthetic */ int O000000o;

        AnonymousClass5(int i) {
            this.O000000o = i;
        }

        public void O000000o(int i) {
            if (this.O000000o == 1) {
                DynamicDetailActivity.this.O000000o(DynamicDetailActivity.this.O00oOoOo);
            } else {
                DynamicDetailActivity.this.O0000o0O();
            }
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity$6 */
    class AnonymousClass6 implements O000000o {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;

        AnonymousClass6(int i, int i2) {
            this.O000000o = i;
            this.O00000Oo = i2;
        }

        public void O000000o(int i) {
            DynamicDetailActivity.this.O000000o(this.O000000o, DynamicDetailActivity.this.getString(R.string.comment_report_other), this.O00000Oo);
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity$7 */
    class AnonymousClass7 implements O000000o {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;

        AnonymousClass7(int i, int i2) {
            this.O000000o = i;
            this.O00000Oo = i2;
        }

        public void O000000o(int i) {
            DynamicDetailActivity.this.O000000o(this.O000000o, DynamicDetailActivity.this.getString(R.string.comment_report_advertising), this.O00000Oo);
        }
    }

    /* renamed from: com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity$8 */
    class AnonymousClass8 implements O000000o {
        final /* synthetic */ int O000000o;
        final /* synthetic */ int O00000Oo;

        AnonymousClass8(int i, int i2) {
            this.O000000o = i;
            this.O00000Oo = i2;
        }

        public void O000000o(int i) {
            DynamicDetailActivity.this.O000000o(this.O000000o, DynamicDetailActivity.this.getString(R.string.comment_report_unfriendly), this.O00000Oo);
        }
    }

    static {
        C.i(16777301);
    }

    private native void O000000o(int i);

    private native void O000000o(int i, int i2);

    private void O000000o(int i, int i2, int i3) {
        if (this.O000O0o != null) {
            gj gjVar = new gj(gk.O0000o);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("rootType", 2);
                jSONObject.put("rootId", this.O000O0o.getId());
                jSONObject.put("parentType", i);
                jSONObject.put("parentId", i2);
                jSONObject.put("parentUid", i3);
                jSONObject.put("content", this.O00000o0.getEditText().getText().toString());
                jSONObject.put("latestCommentId", this.O000OO0o);
                gjVar.setBodyContent(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
                public void onCancelled(CancelledException cancelledException) {
                }

                public void onError(ResponseError responseError) {
                    if (!DynamicDetailActivity.this.isFinishing()) {
                        if (responseError.getError() == gi.O000000o || responseError.getError() == gi.O00000Oo || responseError.getError() == gi.O00000o0 || responseError.getError() == gi.O00000o) {
                            DynamicDetailActivity.this.O00000Oo(DynamicDetailActivity.this.getString(R.string.comment_post_fail), responseError.getMessage());
                        } else if (responseError.getError() == gi.O0000OoO) {
                            DynamicDetailActivity.this.O000000o(DynamicDetailActivity.this.getString(R.string.comment_post_fail), responseError.getMessage(), new OnClickListener() {
                                public void onClick(View view) {
                                    DynamicDetailActivity.this.finish();
                                }
                            });
                        } else if (responseError.getError() == gi.O0000o00) {
                            DynamicDetailActivity.this.O00000Oo("警告", responseError.getMessage());
                        } else {
                            DynamicDetailActivity.this.O00000o0.O00000oo();
                            O00Oo00.O000000o(responseError.getMessage(), false);
                        }
                    }
                }

                public void onFinished() {
                }

                public void onSuccess(String str) {
                    if (!DynamicDetailActivity.this.isFinishing()) {
                        NewsHotCommentBean newsHotCommentBean = (NewsHotCommentBean) O000o000.O000000o().fromJson(str, NewsHotCommentBean.class);
                        if (!(newsHotCommentBean == null || newsHotCommentBean.getList() == null)) {
                            ArrayList arrayList = new ArrayList();
                            CommentBean commentBean = (CommentBean) newsHotCommentBean.getList().get(0);
                            DynamicDetailActivity.this.O000OO0o = commentBean.getId();
                            for (CommentBean commentBean2 : newsHotCommentBean.getList()) {
                                FindDetailBean findDetailBean = new FindDetailBean();
                                findDetailBean.setViewType(2);
                                findDetailBean.setBean(commentBean2);
                                arrayList.add(findDetailBean);
                            }
                            DynamicDetailActivity.this.O00000o0.getEditText().getText().clear();
                            DynamicDetailActivity.this.O000O0Oo.clear();
                            DynamicDetailActivity.this.O000O00o.O000000o(arrayList, false, newsHotCommentBean.getCount());
                            DynamicDetailActivity.this.O000O0o.setCommentCount(newsHotCommentBean.getCount());
                            Intent intent = new Intent("action_comment_dynamic");
                            intent.putExtra("key_action_comment_count", DynamicDetailActivity.this.O000O0o.getCommentCount());
                            intent.putExtra("key_action_comment", new DynamicCommentBean(commentBean.getId(), commentBean.getNickName(), commentBean.getContent()));
                            intent.putExtra(DynamicDetailActivity.O000000o, DynamicDetailActivity.this.O000O0oo);
                            LocalBroadcastManager.getInstance(MyApplication.O000000o()).sendBroadcast(intent);
                            DynamicDetailActivity.this.O0000oOO.setText(String.valueOf(DynamicDetailActivity.this.O000O0o.getLikeCount()));
                            DynamicDetailActivity.this.O0000oOo.setText(String.valueOf(DynamicDetailActivity.this.O000O0o.getCommentCount()));
                        }
                        DynamicDetailActivity.this.O00000o0.O00000oo();
                        O00Oo00.O000000o(DynamicDetailActivity.this.getString(R.string.comment_success), true);
                    }
                }
            }));
        }
    }

    private void O000000o(int i, String str, int i2) {
        O00000oO(getString(R.string.txt_uploading));
        gj gjVar = new gj(gk.O0000oO);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("targetId", i);
            jSONObject.put("reason", str);
            jSONObject.put("targetType", i2);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
                DynamicDetailActivity.this.O0000OoO();
            }

            public void onError(ResponseError responseError) {
                DynamicDetailActivity.this.O0000OoO();
                if (!DynamicDetailActivity.this.isFinishing()) {
                    if (responseError.getError() == gi.O00000oo) {
                        DynamicDetailActivity.this.O00000Oo(DynamicDetailActivity.this.getString(R.string.comment_report_fail), responseError.getMessage());
                    } else {
                        if (responseError.getError() == gi.O000000o || responseError.getError() == gi.O00000Oo || responseError.getError() == gi.O0000Oo || responseError.getError() == gi.O0000OoO) {
                            responseError.setMessage(DynamicDetailActivity.this.getString(R.string.comment_report_fail));
                        }
                        O00Oo00.O000000o(responseError.getMessage(), false);
                    }
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                DynamicDetailActivity.this.O0000OoO();
                if (!DynamicDetailActivity.this.isFinishing()) {
                    O00Oo00.O000000o(DynamicDetailActivity.this.getString(R.string.comment_report_success), true);
                }
            }
        });
    }

    public static native void O000000o(Activity activity, int i, boolean z);

    private native void O000000o(Context context, FansListBean fansListBean);

    private native void O000000o(Bundle bundle);

    private void O000000o(final FindDetailBean findDetailBean) {
        gj gjVar = new gj(gk.O0000oO0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("commentId", findDetailBean.getBean().getId());
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (!DynamicDetailActivity.this.isFinishing()) {
                    O00Oo00.O000000o(responseError.getMessage(), false);
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (!DynamicDetailActivity.this.isFinishing()) {
                    Intent intent = new Intent("action_delete_dynamic_comment");
                    intent.putExtra(DynamicDetailActivity.O000000o, DynamicDetailActivity.this.O000O0oo);
                    intent.putExtra("key_action_comment_id", findDetailBean.getBean().getId());
                    LocalBroadcastManager.getInstance(MyApplication.O000000o()).sendBroadcast(intent);
                    DynamicDetailActivity.this.O000O00o.O000000o(findDetailBean);
                    O00Oo00.O000000o(DynamicDetailActivity.this.getString(R.string.delete_success), true);
                }
            }
        });
    }

    private native void O000000o(boolean z, boolean z2, int i, int i2);

    private native void O00000o();

    private void O00000o0(int i, final int i2) {
        gj gjVar = new gj(gk.O0000oOo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rootId", this.O000O0oo);
            jSONObject.put("lastCommentId", i);
            jSONObject.put("pageSize", 20);
            jSONObject.put("type", 2);
            jSONObject.put("hot", i2);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (!(DynamicDetailActivity.this.isFinishing() || DynamicDetailActivity.this.O000OO00 == 0 || i2 != 0)) {
                    O0000O0o.O000000o(DynamicDetailActivity.this, DynamicDetailActivity.this.O00000oO, 10, LoadingFooter.O000000o.NetWorkError, new OnClickListener() {
                        public void onClick(View view) {
                            O0000O0o.O000000o(DynamicDetailActivity.this, DynamicDetailActivity.this.O00000oO, 10, LoadingFooter.O000000o.Loading, null);
                            DynamicDetailActivity.this.O00000o0(DynamicDetailActivity.this.O000OO00, 0);
                        }
                    });
                }
            }

            public void onFinished() {
                DynamicDetailActivity.this.O0000OoO();
            }

            public void onSuccess(String str) {
                if (!DynamicDetailActivity.this.isFinishing()) {
                    NewsHotCommentBean newsHotCommentBean = (NewsHotCommentBean) O000o000.O000000o().fromJson(str, NewsHotCommentBean.class);
                    if (newsHotCommentBean != null) {
                        boolean z = false;
                        if (i2 != 1) {
                            if (newsHotCommentBean.getList() != null && newsHotCommentBean.getList().size() > 0) {
                                ArrayList arrayList = new ArrayList();
                                DynamicDetailActivity.this.O000OO0o = ((CommentBean) newsHotCommentBean.getList().get(0)).getId();
                                for (CommentBean commentBean : newsHotCommentBean.getList()) {
                                    FindDetailBean findDetailBean = new FindDetailBean();
                                    findDetailBean.setViewType(2);
                                    findDetailBean.setBean(commentBean);
                                    DynamicDetailActivity.this.O000OO00 = commentBean.getId();
                                    arrayList.add(findDetailBean);
                                }
                                DynamicDetailActivity.this.O000O00o.O000000o(arrayList, true, newsHotCommentBean.getCount());
                            }
                            DynamicDetailActivity dynamicDetailActivity = DynamicDetailActivity.this;
                            if (DynamicDetailActivity.this.O000O00o.getItemCount() - DynamicDetailActivity.this.O000O00o.O000000o() < newsHotCommentBean.getCount() + 1) {
                                z = true;
                            }
                            dynamicDetailActivity.O000OOoo = z;
                        } else if (newsHotCommentBean.getCount() > 0) {
                            List arrayList2 = new ArrayList();
                            FindDetailBean findDetailBean2 = new FindDetailBean();
                            findDetailBean2.setText("热门评论 ");
                            findDetailBean2.setSize(newsHotCommentBean.getCount());
                            findDetailBean2.setViewType(1);
                            arrayList2.add(findDetailBean2);
                            int i;
                            while (i < newsHotCommentBean.getList().size()) {
                                FindDetailBean findDetailBean3 = new FindDetailBean();
                                findDetailBean3.setViewType(2);
                                findDetailBean3.setBean((CommentBean) newsHotCommentBean.getList().get(i));
                                arrayList2.add(findDetailBean3);
                                i++;
                            }
                            DynamicDetailActivity.this.O000O00o.O000000o(arrayList2);
                        }
                    }
                    if (DynamicDetailActivity.this.O000OOoo) {
                        O0000O0o.O000000o(DynamicDetailActivity.this.O00000oO, LoadingFooter.O000000o.Normal);
                    } else {
                        DynamicDetailActivity.this.O000O0OO.O00000o(DynamicDetailActivity.this.O000O0OO.O00000Oo());
                    }
                }
            }
        }));
    }

    private native View O00000oO();

    private native View O00000oo();

    private native void O0000O0o();

    private native void O0000OOo();

    private void O0000Oo0() {
        O00000oO(getString(R.string.txt_loading));
        gj gjVar = new gj(gk.O00O0o0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dynamicId", this.O000O0oo);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
                DynamicDetailActivity.this.O0000OoO();
            }

            public void onError(ResponseError responseError) {
                DynamicDetailActivity.this.O0000OoO();
                if (!DynamicDetailActivity.this.isFinishing()) {
                    if (responseError.getError() == gi.O0000Oo) {
                        DynamicDetailActivity.this.O000000o(DynamicDetailActivity.this.getString(R.string.read_fail), responseError.getMessage(), new OnClickListener() {
                            public void onClick(View view) {
                                DynamicDetailActivity.this.finish();
                            }
                        });
                    } else {
                        DynamicDetailActivity.this.O00000o.O000000o(null, DynamicDetailActivity.this.getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                            public void onClick(View view) {
                                DynamicDetailActivity.this.O0000Oo0();
                            }
                        });
                    }
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (!DynamicDetailActivity.this.isFinishing()) {
                    DynamicDetailActivity.this.O00000o.O000000o();
                    DynamicDetailActivity.this.O000O0o = (DynamicBean) DynamicDetailActivity.this.O0000OoO.fromJson(str, DynamicBean.class);
                    if (DynamicDetailActivity.this.O000O0o != null) {
                        DynamicDetailActivity.this.O000OOoO = DynamicDetailActivity.this.O000O0o.getUid();
                        DynamicDetailActivity.this.O00000oo.setText(DynamicDetailActivity.this.O000O0o.getNickName());
                        DynamicDetailActivity.this.O0000O0o.setText(DynamicDetailActivity.this.O000O0o.getUniversity());
                        DynamicDetailActivity.this.O0000o.setText(DynamicDetailActivity.this.O000O0o.getTopicTitle());
                        DynamicDetailActivity.this.O0000oO0.setText(DynamicDetailActivity.this.O000O0o.getContent());
                        DynamicDetailActivity.this.O0000oO.setText(O000O0o0.O00000o0(DynamicDetailActivity.this.O000O0o.getTime()));
                        DynamicDetailActivity.this.O0000oOO.setText(String.valueOf(DynamicDetailActivity.this.O000O0o.getLikeCount()));
                        DynamicDetailActivity.this.O0000oOo.setText(String.valueOf(DynamicDetailActivity.this.O000O0o.getCommentCount()));
                        DynamicDetailActivity.this.O0000oo.setVisibility(0);
                        O00Oo0.O000000o(DynamicDetailActivity.this, DynamicDetailActivity.this.O000O0o.getAvatarUrl(), DynamicDetailActivity.this.O0000OOo, DynamicDetailActivity.this.O000O0o.getGender());
                        List files = DynamicDetailActivity.this.O000O0o.getFiles();
                        boolean z = true;
                        if (files == null || files.isEmpty()) {
                            DynamicDetailActivity.this.O0000Oo0.setVisibility(8);
                        } else {
                            files = new ArrayList();
                            for (DynamicFileBean dynamicFileBean : DynamicDetailActivity.this.O000O0o.getFiles()) {
                                if (dynamicFileBean.isImage()) {
                                    files.add(dynamicFileBean.getUrl());
                                }
                            }
                            if (files.size() > 0) {
                                DynamicDetailActivity.this.O0000Oo0.setVisibility(0);
                                if (files.size() == 1) {
                                    DynamicDetailActivity.this.O0000Oo0.setLayoutManager(new LinearLayoutManager(DynamicDetailActivity.this.O0000o0));
                                } else if (files.size() == 2 || files.size() == 4) {
                                    DynamicDetailActivity.this.O0000Oo0.setLayoutManager(new GridLayoutManager(DynamicDetailActivity.this.O0000o0, 2));
                                } else {
                                    DynamicDetailActivity.this.O0000Oo0.setLayoutManager(new GridLayoutManager(DynamicDetailActivity.this.O0000o0, 3));
                                }
                                fc fcVar = new fc();
                                fcVar.O000000o(files);
                                DynamicDetailActivity.this.O0000Oo0.setAdapter(fcVar);
                            } else {
                                DynamicDetailActivity.this.O0000Oo0.setVisibility(8);
                            }
                        }
                        DynamicDetailActivity.this.O0000Oo.setVisibility(DynamicDetailActivity.this.O000O0o.getUid() == O00Oo0.O00000oO() ? 8 : 0);
                        DynamicDetailActivity.this.O000000o(DynamicDetailActivity.this.O000O0o.getInterestStatus());
                        DynamicDetailActivity.this.O0000Oo.setOnClickListener(new OnClickListener() {
                            public void onClick(View view) {
                                FansListBean fansListBean = new FansListBean();
                                fansListBean.setUid(DynamicDetailActivity.this.O000O0o.getUid());
                                fansListBean.setInterestStatus(DynamicDetailActivity.this.O000O0o.getInterestStatus());
                                DynamicDetailActivity.this.O000000o(DynamicDetailActivity.this.O0000o0, fansListBean);
                            }
                        });
                        DynamicDetailActivity.this.O0000oo0.setImageResource(DynamicDetailActivity.this.O000O0o.getIsLiked() == 1 ? R.drawable.topic_dynamic_liked : R.drawable.topic_dynamic_dislike);
                        DynamicDetailActivity.this.O0000o.setVisibility(TextUtils.isEmpty(DynamicDetailActivity.this.O000O0o.getTopicTitle()) ? 8 : 0);
                        DynamicDetailActivity.this.O0000oO0.setVisibility(TextUtils.isEmpty(DynamicDetailActivity.this.O000O0o.getContent()) ? 8 : 0);
                        ImageButton O0000o0O = DynamicDetailActivity.this.O0000oo0;
                        if (DynamicDetailActivity.this.O000O0o.getIsLiked() != 0) {
                            z = false;
                        }
                        O0000o0O.setEnabled(z);
                        if (DynamicDetailActivity.this.O000O0o.getTagList() == null || DynamicDetailActivity.this.O000O0o.getTagList().size() <= 0) {
                            DynamicDetailActivity.this.O0000ooO.setVisibility(8);
                        } else {
                            DynamicDetailActivity.this.O0000ooO.setVisibility(0);
                            DynamicTagBean dynamicTagBean = (DynamicTagBean) DynamicDetailActivity.this.O000O0o.getTagList().get(0);
                            DynamicDetailActivity.this.O00oOooO.setText(dynamicTagBean.getTagContent());
                            O00Oo.O000000o(DynamicDetailActivity.this).O000000o(dynamicTagBean.getTagUrl()).O000000o(DynamicDetailActivity.this.O0000ooo);
                        }
                    }
                    DynamicDetailActivity.this.O0000o0();
                }
            }
        }));
    }

    private void O0000o0() {
        gj gjVar = new gj(gk.O000OoO0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("lastLikeId", 0);
            jSONObject.put("id", this.O000O0oo);
            jSONObject.put("size", 20);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
            }

            public void onFinished() {
                if (!DynamicDetailActivity.this.isFinishing()) {
                    DynamicDetailActivity.this.O00000o0(0, 1);
                    DynamicDetailActivity.this.O00000o0(DynamicDetailActivity.this.O000OO00, 0);
                }
            }

            public void onSuccess(String str) {
                if (!DynamicDetailActivity.this.isFinishing()) {
                    Collection collection = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<DynamicLikeBean>>() {
                    }.getType());
                    if (collection != null && collection.size() > 0) {
                        DynamicDetailActivity.this.O000O0oO.clear();
                        List O0000oO0;
                        if (DensityUtil.getScreenWidth() > 480) {
                            O0000oO0 = DynamicDetailActivity.this.O000O0oO;
                            if (collection.size() >= 7) {
                                collection = collection.subList(0, 7);
                            }
                            O0000oO0.addAll(collection);
                        } else {
                            O0000oO0 = DynamicDetailActivity.this.O000O0oO;
                            if (collection.size() >= 5) {
                                collection = collection.subList(0, 5);
                            }
                            O0000oO0.addAll(collection);
                        }
                        DynamicDetailActivity.this.O000O0OO.O000000o(DynamicDetailActivity.this.O00000oo());
                    }
                }
            }
        }));
    }

    private void O0000o0O() {
        gj gjVar = new gj(gk.O00oOooo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dynamicId", this.O000O0oo);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (!DynamicDetailActivity.this.isFinishing()) {
                    O00Oo00.O000000o(responseError.getMessage(), false);
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (!DynamicDetailActivity.this.isFinishing()) {
                    Intent intent = new Intent("action_delete_dynamic");
                    intent.putExtra(DynamicDetailActivity.O000000o, DynamicDetailActivity.this.O000O0oo);
                    LocalBroadcastManager.getInstance(MyApplication.O000000o()).sendBroadcast(intent);
                    O00Oo00.O000000o(DynamicDetailActivity.this.getString(R.string.delete_success), true);
                    DynamicDetailActivity.this.finish();
                }
            }
        });
    }

    @Event({2131296470, 2131296709, 2131296719, 2131296708})
    private void onClick(View view) {
        if (!O00OOo0.O000000o()) {
            int id = view.getId();
            if (id != R.id.keyboard_post_btn) {
                switch (id) {
                    case R.id.keyboard_change /*2131296708*/:
                        this.O00000o0.O000000o(O00000Oo.O00000Oo);
                        break;
                    case R.id.keyboard_comment /*2131296709*/:
                        break;
                }
            }
            if (TextUtils.isEmpty(this.O00000o0.getEditText().getText().toString().trim())) {
                this.O00000o0.O00000oo();
                this.O00000o0.getEditText().getText().clear();
                return;
            }
            O000000o(this.O000OOo0, this.O000OOo, this.O000OOoO);
        }
    }

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
            O0000Oo0();
        }
    }

    public native void onSaveInstanceState(Bundle bundle);
}
