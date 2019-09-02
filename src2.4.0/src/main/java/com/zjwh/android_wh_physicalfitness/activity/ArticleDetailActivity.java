package com.zjwh.android_wh_physicalfitness.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sw.emoji.EmoticonsKeyboard;
import com.sw.emoji.EmoticonsKeyboard.O000000o;
import com.sw.emoji.EmoticonsKeyboard.O00000Oo;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseShareActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.CommentBean;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.ArticleRefreshEvt;
import com.zjwh.android_wh_physicalfitness.entity.FindDetailBean;
import com.zjwh.android_wh_physicalfitness.entity.NewsDetailBean;
import com.zjwh.android_wh_physicalfitness.entity.NewsHotCommentBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.ShareInfoBean;
import com.zjwh.android_wh_physicalfitness.entity.statistics.PvDataInfo;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00O0Oo0;
import com.zjwh.android_wh_physicalfitness.utils.O00OO0O;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import com.zjwh.android_wh_physicalfitness.view.WebView.VideoEnabledWebView;
import defpackage.dr;
import defpackage.gi;
import defpackage.gj;
import defpackage.gk;
import defpackage.jj;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ArticleDetailActivity extends BaseShareActivity {
    public static final String O000000o = "extra_news_id";
    public static final int O00000Oo = 1;
    public static final String O00000o = "text";
    public static final String O00000o0 = "id";
    @ViewInject(2131297469)
    ViewGroup O00000oO;
    @ViewInject(2131296859)
    ViewGroup O00000oo;
    @ViewInject(2131296716)
    private EmoticonsKeyboard O0000O0o;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000OOo;
    @ViewInject(2131296942)
    private RecyclerView O0000Oo;
    @ViewInject(2131297060)
    private NestedScrollView O0000Oo0;
    @ViewInject(2131296545)
    private TextView O0000o;
    @ViewInject(2131297490)
    private VideoEnabledWebView O0000oO;
    @ViewInject(2131296544)
    private TextView O0000oO0;
    @ViewInject(2131296542)
    private TextView O0000oOO;
    private dr O000O00o;
    private boolean O000O0OO;
    private int O000O0Oo;
    private FindDetailBean O000O0o;
    private ArrayMap<String, String> O000O0o0 = new ArrayMap();
    private int O000O0oO;
    private int O000O0oo;
    private NewsDetailBean O000OO;
    private int O000OO00 = 0;
    private int O000OO0o = 0;
    private int O000OOOo = 1;
    private int O000OOo;
    private int O000OOo0 = 0;
    private int O000OOoO = 0;
    private int O000OOoo;
    private long O000Oo0;
    private long O000Oo00;
    private int O00oOoOo;
    private O00000o0 O00oOooo;

    static {
        C.i(16777274);
    }

    private void O000000o(int i, int i2, int i3) {
        gj gjVar = new gj(gk.O0000o);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rootType", 1);
            jSONObject.put("rootId", this.O000OO.getNewsId());
            jSONObject.put("parentType", i);
            jSONObject.put("parentId", i2);
            jSONObject.put("parentUid", i3);
            jSONObject.put("content", this.O0000O0o.getEditText().getText().toString());
            jSONObject.put("latestCommentId", this.O000OO0o);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.postOp(this.O0000o0, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (!ArticleDetailActivity.this.isFinishing()) {
                    if (responseError.getError() == gi.O000000o || responseError.getError() == gi.O00000Oo || responseError.getError() == gi.O00000o0 || responseError.getError() == gi.O00000o) {
                        ArticleDetailActivity.this.O00000Oo(ArticleDetailActivity.this.getString(R.string.comment_post_fail), responseError.getMessage());
                    } else if (responseError.getError() == gi.O00000oO) {
                        ArticleDetailActivity.this.O000000o(ArticleDetailActivity.this.getString(R.string.comment_post_fail), responseError.getMessage(), new OnClickListener() {
                            public void onClick(View view) {
                                ArticleDetailActivity.this.finish();
                            }
                        });
                    } else if (responseError.getError() == gi.O0000o00) {
                        ArticleDetailActivity.this.O00000Oo("警告", responseError.getMessage());
                    } else {
                        ArticleDetailActivity.this.O0000O0o.O00000oo();
                        ArticleDetailActivity.this.O0000O0o.O00000Oo(false);
                        O00Oo00.O000000o(responseError.getMessage(), false);
                    }
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (!ArticleDetailActivity.this.isFinishing()) {
                    NewsHotCommentBean newsHotCommentBean = (NewsHotCommentBean) O000o000.O000000o().fromJson(str, NewsHotCommentBean.class);
                    if (!(newsHotCommentBean == null || newsHotCommentBean.getList() == null)) {
                        ArrayList arrayList = new ArrayList();
                        ArticleDetailActivity.this.O000OO0o = ((CommentBean) newsHotCommentBean.getList().get(0)).getId();
                        for (CommentBean commentBean : newsHotCommentBean.getList()) {
                            FindDetailBean findDetailBean = new FindDetailBean();
                            findDetailBean.setViewType(2);
                            findDetailBean.setBean(commentBean);
                            arrayList.add(findDetailBean);
                        }
                        ArticleDetailActivity.this.O0000O0o.getEditText().getText().clear();
                        ArticleDetailActivity.this.O000O0o0.clear();
                        ArticleDetailActivity.this.O000O00o.O000000o(arrayList, false, newsHotCommentBean.getCount());
                    }
                    ArticleDetailActivity.this.O0000O0o.O000000o(O000000o.O000000o);
                    ArticleDetailActivity.this.O0000O0o.O00000oo();
                    O00Oo00.O000000o(ArticleDetailActivity.this.getString(R.string.comment_success), true);
                }
            }
        }));
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
                ArticleDetailActivity.this.O0000OoO();
            }

            public void onError(ResponseError responseError) {
                ArticleDetailActivity.this.O0000OoO();
                if (!ArticleDetailActivity.this.isFinishing()) {
                    if (responseError.getError() == gi.O00000oo) {
                        ArticleDetailActivity.this.O00000Oo(ArticleDetailActivity.this.getString(R.string.comment_report_fail), responseError.getMessage());
                    } else {
                        if (responseError.getError() == gi.O000000o || responseError.getError() == gi.O00000Oo || responseError.getError() == gi.O0000Oo || responseError.getError() == gi.O0000OoO) {
                            responseError.setMessage(ArticleDetailActivity.this.getString(R.string.comment_report_fail));
                        }
                        O00Oo00.O000000o(responseError.getMessage(), false);
                    }
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                ArticleDetailActivity.this.O0000OoO();
                if (!ArticleDetailActivity.this.isFinishing()) {
                    O00Oo00.O000000o(ArticleDetailActivity.this.getString(R.string.comment_report_success), true);
                }
            }
        });
    }

    public static native void O000000o(Activity activity, int i);

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
                if (!ArticleDetailActivity.this.isFinishing()) {
                    O00Oo00.O000000o(responseError.getMessage(), false);
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (!ArticleDetailActivity.this.isFinishing()) {
                    ArticleDetailActivity.this.O000O00o.O000000o(findDetailBean);
                    O00Oo00.O000000o(ArticleDetailActivity.this.getString(R.string.delete_success), true);
                }
            }
        });
    }

    private native void O000000o(boolean z);

    private void O00000Oo(int i) {
        gj gjVar = new gj(gk.O0000oOo);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rootId", this.O000O0oo);
            jSONObject.put("lastCommentId", i);
            jSONObject.put("pageSize", 20);
            jSONObject.put("type", 1);
            jSONObject.put("hot", 0);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (!(ArticleDetailActivity.this.isFinishing() || ArticleDetailActivity.this.O000OO00 == 0)) {
                    O0000O0o.O000000o(ArticleDetailActivity.this, ArticleDetailActivity.this.O0000Oo, 10, LoadingFooter.O000000o.NetWorkError, new OnClickListener() {
                        public void onClick(View view) {
                            O0000O0o.O000000o(ArticleDetailActivity.this, ArticleDetailActivity.this.O0000Oo, 10, LoadingFooter.O000000o.Loading, null);
                            ArticleDetailActivity.this.O00000Oo(ArticleDetailActivity.this.O000OO00);
                        }
                    });
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (!ArticleDetailActivity.this.isFinishing()) {
                    NewsHotCommentBean newsHotCommentBean = (NewsHotCommentBean) O000o000.O000000o().fromJson(str, NewsHotCommentBean.class);
                    if (newsHotCommentBean != null) {
                        boolean z = false;
                        if (newsHotCommentBean.getList() != null && newsHotCommentBean.getList().size() > 0) {
                            ArrayList arrayList = new ArrayList();
                            ArticleDetailActivity.this.O000OO0o = ((CommentBean) newsHotCommentBean.getList().get(0)).getId();
                            for (CommentBean commentBean : newsHotCommentBean.getList()) {
                                FindDetailBean findDetailBean = new FindDetailBean();
                                findDetailBean.setViewType(2);
                                findDetailBean.setBean(commentBean);
                                ArticleDetailActivity.this.O000OO00 = commentBean.getId();
                                arrayList.add(findDetailBean);
                            }
                            ArticleDetailActivity.this.O000O00o.O000000o(arrayList, true, newsHotCommentBean.getCount());
                        }
                        ArticleDetailActivity articleDetailActivity = ArticleDetailActivity.this;
                        if (ArticleDetailActivity.this.O000O00o.getItemCount() - ArticleDetailActivity.this.O000O00o.O000000o() < newsHotCommentBean.getCount() + 1) {
                            z = true;
                        }
                        articleDetailActivity.O000O0OO = z;
                    }
                    if (ArticleDetailActivity.this.O000O0OO) {
                        O0000O0o.O000000o(ArticleDetailActivity.this.O0000Oo, LoadingFooter.O000000o.Normal);
                    } else {
                        ArticleDetailActivity.this.O00oOooo.O00000o(ArticleDetailActivity.this.O00oOooo.O00000Oo());
                    }
                }
            }
        }));
    }

    private native void O00000o();

    private native void O00000oO();

    private void O00000oo() {
        if (O0000O0o.O000000o(this.O0000Oo) != LoadingFooter.O000000o.Loading && this.O000O0OO && this.O000OO00 != 0) {
            O0000O0o.O000000o(this, this.O0000Oo, 10, LoadingFooter.O000000o.Loading, null);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public void run() {
                    if (!ArticleDetailActivity.this.isFinishing()) {
                        ArticleDetailActivity.this.O0000Oo0.smoothScrollBy(0, DensityUtil.dip2px(60.0f));
                    }
                }
            }, 17);
            O00000Oo(this.O000OO00);
        }
    }

    private native void O0000O0o();

    private void O0000OOo() {
        O00000oO(getString(R.string.txt_loading));
        gj gjVar = new gj(gk.O000o00O);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("newsId", this.O000O0oo);
            jSONObject.put("hotComment", 1);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(this, gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
                ArticleDetailActivity.this.O0000OoO();
            }

            public void onError(ResponseError responseError) {
                ArticleDetailActivity.this.O0000OoO();
                if (!ArticleDetailActivity.this.isFinishing()) {
                    if (responseError.getError() == gi.O0000O0o) {
                        ArticleDetailActivity.this.O000000o(ArticleDetailActivity.this.getString(R.string.read_fail), responseError.getMessage(), new OnClickListener() {
                            public void onClick(View view) {
                                ArticleDetailActivity.this.finish();
                            }
                        });
                    } else {
                        ArticleDetailActivity.this.O0000OOo.O000000o(null, ArticleDetailActivity.this.getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                            public void onClick(View view) {
                                ArticleDetailActivity.this.O0000OOo();
                                ArticleDetailActivity.this.O00000Oo(ArticleDetailActivity.this.O000OO00);
                            }
                        });
                    }
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (!ArticleDetailActivity.this.isFinishing()) {
                    ArticleDetailActivity.this.O000OO = (NewsDetailBean) O000o000.O000000o().fromJson(str, NewsDetailBean.class);
                    if (ArticleDetailActivity.this.O000OO != null) {
                        ArticleDetailActivity.this.O0000o.setText(ArticleDetailActivity.this.O000OO.getTitle());
                        boolean z = false;
                        if (TextUtils.isEmpty(ArticleDetailActivity.this.O000OO.getAuthor())) {
                            ArticleDetailActivity.this.O0000oO0.setText(O000O0o0.O000000o(O000O0o0.O0000o00, ArticleDetailActivity.this.O000OO.getPublishTime()));
                        } else {
                            SpannableString spannableString = new SpannableString(ArticleDetailActivity.this.getString(R.string.find_detail_sub_title, new Object[]{ArticleDetailActivity.this.O000OO.getAuthor(), O000O0o0.O000000o(O000O0o0.O0000o00, ArticleDetailActivity.this.O000OO.getPublishTime())}));
                            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(ArticleDetailActivity.this, R.color.green)), 3, ArticleDetailActivity.this.O000OO.getAuthor().length() + 3, 34);
                            ArticleDetailActivity.this.O0000oO0.setText(spannableString);
                        }
                        if (TextUtils.isEmpty(ArticleDetailActivity.this.O000OO.getHtmlUrl())) {
                            ArticleDetailActivity.this.O0000oO.loadData(ArticleDetailActivity.this.O000OO.getContent(), "text/html; charset=UTF-8", null);
                        } else {
                            ArticleDetailActivity.this.O0000oO.loadUrl(ArticleDetailActivity.this.O000OO.getHtmlUrl());
                        }
                        ArticleDetailActivity.this.O0000oOO.setText(ArticleDetailActivity.this.getString(R.string.find_detail_content_bottom, new Object[]{Integer.valueOf(ArticleDetailActivity.this.O000OO.getReadCount()), Integer.valueOf(ArticleDetailActivity.this.O000OO.getLikeCount())}));
                        if (ArticleDetailActivity.this.O000OO.getHotComments() != null && ArticleDetailActivity.this.O000OO.getHotComments().getCount() > 0) {
                            List arrayList = new ArrayList();
                            FindDetailBean findDetailBean = new FindDetailBean();
                            findDetailBean.setText("热门评论 ");
                            findDetailBean.setSize(ArticleDetailActivity.this.O000OO.getHotComments().getCount());
                            findDetailBean.setViewType(1);
                            arrayList.add(findDetailBean);
                            for (int i = 0; i < ArticleDetailActivity.this.O000OO.getHotComments().getList().size(); i++) {
                                FindDetailBean findDetailBean2 = new FindDetailBean();
                                findDetailBean2.setViewType(2);
                                findDetailBean2.setBean((CommentBean) ArticleDetailActivity.this.O000OO.getHotComments().getList().get(i));
                                arrayList.add(findDetailBean2);
                            }
                            ArticleDetailActivity.this.O000O00o.O000000o(arrayList);
                        }
                        ArticleDetailActivity.this.O000OOo = ArticleDetailActivity.this.O000OO.getAuthorUid();
                        ArticleDetailActivity.this.O000OOo0 = ArticleDetailActivity.this.O000OO.getNewsId();
                        ArticleDetailActivity.this.O000O00o.notifyDataSetChanged();
                        ArticleDetailActivity.this.O0000Oo.setVisibility(0);
                        ArticleDetailActivity.this.O0000O0o.O00000o0(ArticleDetailActivity.this.O000OO.getIsLiked() == 1);
                        EmoticonsKeyboard O000000o = ArticleDetailActivity.this.O0000O0o;
                        if (ArticleDetailActivity.this.O000OO.getIsUnliked() == 1) {
                            z = true;
                        }
                        O000000o.O00000o(z);
                        ArticleDetailActivity.this.O0000O0o.O000000o(O000000o.O000000o);
                        ArticleDetailActivity.this.O0000O0o.O00000Oo(true);
                    }
                    ArticleDetailActivity.this.O0000OOo.O000000o();
                }
            }
        }));
    }

    @Event({2131296717, 2131296722, 2131296709, 2131296719, 2131296708, 2131296544})
    private void onClick(View view) {
        if (!O00OOo0.O000000o()) {
            switch (view.getId()) {
                case R.id.find_detail_sub_title /*2131296544*/:
                    if (this.O000OOo > 0) {
                        HomePageActivity.O000000o((Activity) this, this.O000OOo);
                        break;
                    }
                    break;
                case R.id.keyboard_change /*2131296708*/:
                    this.O0000O0o.O000000o(O00000Oo.O00000Oo);
                    break;
                case R.id.keyboard_comment /*2131296709*/:
                case R.id.keyboard_post_btn /*2131296719*/:
                    if (!TextUtils.isEmpty(this.O0000O0o.getEditText().getText().toString().trim())) {
                        O000000o(this.O000OOOo, this.O000OOo0, this.O000OOoO);
                        break;
                    }
                    this.O0000O0o.getEditText().getText().clear();
                    this.O0000O0o.O00000oo();
                    return;
                case R.id.keyboard_like /*2131296717*/:
                    if (this.O000OO.getIsLiked() == 0) {
                        O000000o(jj.O000000o(this.O0000o0, 0, this.O000OO.getNewsId(), 1, 1, this.O000O0oo, -1, null));
                        this.O000OO.setIsLiked(1);
                        this.O0000O0o.O00000o0(true);
                        this.O000OO.setLikeCount(this.O000OO.getLikeCount() + 1);
                        this.O0000oOO.setText(getString(R.string.find_detail_content_bottom, new Object[]{Integer.valueOf(this.O000OO.getReadCount()), Integer.valueOf(this.O000OO.getLikeCount())}));
                        O00O0Oo0.O000000o(com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O000000o.O0000oO);
                        O00O0Oo0.O000000o(com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O000000o.O0000oOO);
                        org.greenrobot.eventbus.O00000o0.O000000o().O00000o(new ArticleRefreshEvt(true));
                        break;
                    }
                    break;
            }
        }
    }

    @Event(type = OnMenuItemClickListener.class, value = {2131297163})
    private boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_share) {
            if (this.O000OO == null) {
                O00Oo00.O00000Oo((int) R.string.get_extra_fail);
                return true;
            }
            this.O0000oo = new ShareInfoBean(1, this.O000OO.getTitle(), this.O000OO.getSummary(), this.O000OO.getThumbUrl(), this.O000OO.getShareUrl());
            O0000Oo0();
        }
        return true;
    }

    public native int O000000o();

    public native void O00000Oo();

    public native void onActivityResult(int i, int i2, Intent intent);

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o(bundle);
        if (!isFinishing()) {
            this.O0000ooO = 10001;
            this.O0000ooo = this.O000O0oo;
            O00000o();
            O0000OOo();
            O00000Oo(this.O000OO00);
        }
    }

    public native boolean onCreateOptionsMenu(Menu menu);

    public native void onDestroy();

    public native void onPause();

    /* Access modifiers changed, original: protected */
    public void onResume() {
        super.onResume();
        this.O000Oo00 = SystemClock.elapsedRealtime();
        if (this.O0000oO != null) {
            this.O0000oO.onResume();
        }
    }

    public native void onSaveInstanceState(Bundle bundle);

    /* Access modifiers changed, original: protected */
    public void onStop() {
        super.onStop();
        this.O000Oo0 = SystemClock.elapsedRealtime();
        int i = ((int) (this.O000Oo0 - this.O000Oo00)) / 1000;
        if (i > 0) {
            O00OO0O.O00000Oo(new PvDataInfo(10001, String.valueOf(this.O000O0oo), i));
        }
    }
}
