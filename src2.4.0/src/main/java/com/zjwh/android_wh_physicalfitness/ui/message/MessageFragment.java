package com.zjwh.android_wh_physicalfitness.ui.message;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.gson.reflect.TypeToken;
import com.sw.emoji.EmoticonsKeyboard;
import com.sw.emoji.EmoticonsKeyboard.O00000Oo;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.ArticleDetailActivity;
import com.zjwh.android_wh_physicalfitness.activity.HomePageActivity;
import com.zjwh.android_wh_physicalfitness.activity.WebViewActivity;
import com.zjwh.android_wh_physicalfitness.activity.find.DynamicDetailActivity;
import com.zjwh.android_wh_physicalfitness.activity.find.TopicDetailActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter.O000000o;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000o0;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.ConcernResultBean;
import com.zjwh.android_wh_physicalfitness.entity.MessageCommentBean;
import com.zjwh.android_wh_physicalfitness.entity.MessageFansBean;
import com.zjwh.android_wh_physicalfitness.entity.MessageNoticeBean;
import com.zjwh.android_wh_physicalfitness.entity.MultiAdapterBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.fragment.BaseFragment;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil;
import com.zjwh.android_wh_physicalfitness.utils.HttpUtil.MyCallback;
import com.zjwh.android_wh_physicalfitness.utils.O000o;
import com.zjwh.android_wh_physicalfitness.utils.O000o000;
import com.zjwh.android_wh_physicalfitness.utils.O00OOo0;
import com.zjwh.android_wh_physicalfitness.utils.O00Oo00;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.ei;
import defpackage.gi;
import defpackage.gj;
import defpackage.gk;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback.CancelledException;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

@ContentView(2131427592)
public class MessageFragment extends BaseFragment {
    public static final String O000000o = "item_type";
    public static final String O00000oo = "item_count";
    public static final String O0000O0o = "action_change_state";
    @ViewInject(2131296716)
    private EmoticonsKeyboard O0000OOo;
    @ViewInject(2131296795)
    private LoadingEmptyLayout O0000Oo;
    @ViewInject(2131296942)
    private RecyclerView O0000Oo0;
    private ei O0000OoO;
    private O00000o0 O0000Ooo;
    private long O0000o;
    private HashMap<String, String> O0000o0 = new HashMap();
    private MessageCommentBean O0000o00;
    private boolean O0000o0O;
    private boolean O0000o0o;
    private int O0000oO;
    private long O0000oO0 = 0;
    private int O0000oOO;
    private int O0000oOo = 0;
    private int O0000oo;
    private int O0000oo0 = 0;
    private int O0000ooO;
    private List<MultiAdapterBean> O0000ooo;
    private BroadcastReceiver O00oOooO;
    private LocalBroadcastManager O00oOooo;

    /* renamed from: com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment$5 */
    class AnonymousClass5 implements MyCallback<String> {
        final /* synthetic */ int O000000o;

        AnonymousClass5(int i) {
            this.O000000o = i;
        }

        public void onCancelled(CancelledException cancelledException) {
            if (MessageFragment.this.O0000ooo.size() > this.O000000o) {
                ((MessageFansBean) MessageFragment.this.O0000ooo.get(this.O000000o)).setServiceDoing(false);
                MessageFragment.this.O0000OoO.notifyItemChanged(this.O000000o);
            }
        }

        public void onError(ResponseError responseError) {
            if (MessageFragment.this.O0000ooo.size() > this.O000000o) {
                ((MessageFansBean) MessageFragment.this.O0000ooo.get(this.O000000o)).setServiceDoing(false);
                MessageFragment.this.O0000OoO.notifyItemChanged(this.O000000o);
            }
            O00Oo00.O000000o(responseError.getMessage());
        }

        public void onFinished() {
        }

        public void onSuccess(String str) {
            ConcernResultBean concernResultBean = (ConcernResultBean) O000o000.O000000o().fromJson(str, ConcernResultBean.class);
            if (concernResultBean != null && MessageFragment.this.O0000ooo.size() > this.O000000o) {
                MessageFansBean messageFansBean = (MessageFansBean) MessageFragment.this.O0000ooo.get(this.O000000o);
                messageFansBean.setServiceDoing(false);
                messageFansBean.setInterestStatus(concernResultBean.getInterestStatus());
                MessageFragment.this.O0000OoO.notifyItemChanged(this.O000000o);
            }
        }
    }

    static {
        C.i(16777324);
    }

    private native void O000000o(int i, int i2, int i3);

    private void O000000o(int i, int i2, int i3, int i4, int i5) {
        gj gjVar = new gj(gk.O0000o);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("rootType", i);
            jSONObject.put("rootId", i2);
            jSONObject.put("parentType", i3);
            jSONObject.put("parentId", i4);
            jSONObject.put("parentUid", i5);
            jSONObject.put("content", this.O0000OOo.getEditText().getText().toString());
            jSONObject.put("latestCommentId", this.O0000oOo);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.postOp(getContext(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
            }

            public void onError(ResponseError responseError) {
                if (MessageFragment.this.O0000Ooo()) {
                    if (responseError.getError() == gi.O000000o || responseError.getError() == gi.O00000Oo || responseError.getError() == gi.O00000o0 || responseError.getError() == gi.O00000o || responseError.getError() == gi.O00000oO) {
                        MessageFragment.this.O000000o(MessageFragment.this.getString(R.string.comment_post_fail), responseError.getMessage());
                    } else if (responseError.getError() == gi.O0000o00) {
                        MessageFragment.this.O00000Oo("警告", responseError.getMessage());
                    } else {
                        MessageFragment.this.O0000OOo.O00000oo();
                        MessageFragment.this.O0000OOo.O00000Oo(false);
                        O00Oo00.O000000o(responseError.getMessage(), false);
                    }
                }
            }

            public void onFinished() {
            }

            public void onSuccess(String str) {
                if (MessageFragment.this.O0000Ooo()) {
                    MessageFragment.this.O0000OOo.getEditText().clearFocus();
                    MessageFragment.this.O0000OOo.O00000oo();
                    MessageFragment.this.O0000OOo.O00000Oo(false);
                    MessageFragment.this.O0000OOo.getEditText().getText().clear();
                    MessageFragment.this.O0000o0.clear();
                    O00Oo00.O000000o(MessageFragment.this.getString(R.string.comment_success), true);
                }
            }
        }));
    }

    private void O000000o(int i, String str, int i2) {
        O00000o0(getString(R.string.txt_uploading));
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
        O000000o(HttpUtil.postOp(getContext(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
                MessageFragment.this.O0000o00();
            }

            public void onError(ResponseError responseError) {
                if (MessageFragment.this.O0000Ooo()) {
                    MessageFragment.this.O0000o00();
                    if (responseError.getError() == gi.O00000oo) {
                        MessageFragment.this.O000000o(MessageFragment.this.getString(R.string.comment_report_fail), responseError.getMessage());
                    } else {
                        if (responseError.getError() == gi.O000000o || responseError.getError() == gi.O00000Oo || responseError.getError() == gi.O0000Oo || responseError.getError() == gi.O0000OoO) {
                            responseError.setMessage(MessageFragment.this.getString(R.string.comment_report_fail));
                        }
                        O00Oo00.O000000o(responseError.getMessage(), false);
                    }
                }
            }

            public void onFinished() {
                if (MessageFragment.this.O0000Ooo()) {
                    MessageFragment.this.O0000o00();
                }
            }

            public void onSuccess(String str) {
                if (MessageFragment.this.O0000Ooo()) {
                    MessageFragment.this.O0000o00();
                    O00Oo00.O000000o(MessageFragment.this.getString(R.string.comment_report_success), true);
                }
            }
        }));
    }

    private void O000000o(final long j) {
        if (j == 0) {
            O00000o0(getString(R.string.txt_loading));
        }
        String str = this.O0000oO == 2 ? gk.O0000oo : this.O0000oO == 3 ? gk.O0000ooO : this.O0000oO == 1 ? gk.O0000oo0 : gk.O000Oo0O;
        gj gjVar = new gj(str);
        try {
            JSONObject jSONObject = new JSONObject();
            if (j > 0) {
                switch (this.O0000oO) {
                    case 2:
                        jSONObject.put("lastLikedId", j);
                        break;
                    case 3:
                        jSONObject.put("lastPublishedTime", j);
                        break;
                    case 4:
                        jSONObject.put("lastInterestTime", j);
                        break;
                    default:
                        jSONObject.put("lastCommentId", j);
                        break;
                }
            }
            jSONObject.put("size", 20);
            gjVar.setBodyContent(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(HttpUtil.post(getActivity(), gjVar, new MyCallback<String>() {
            public void onCancelled(CancelledException cancelledException) {
                MessageFragment.this.O0000o00();
            }

            public void onError(ResponseError responseError) {
                if (MessageFragment.this.O0000Ooo()) {
                    if (MessageFragment.this.O0000oOo == 0) {
                        MessageFragment.this.O0000Oo.O000000o(null, MessageFragment.this.getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                            public void onClick(View view) {
                                MessageFragment messageFragment = MessageFragment.this;
                                long O0000oOo = MessageFragment.this.O0000oO == 3 ? MessageFragment.this.O0000o : MessageFragment.this.O0000oO == 4 ? MessageFragment.this.O0000oO0 : (long) MessageFragment.this.O0000oOo;
                                messageFragment.O000000o(O0000oOo);
                            }
                        });
                    } else {
                        O0000O0o.O000000o(MessageFragment.this.getActivity(), MessageFragment.this.O0000Oo0, 20, O000000o.NetWorkError, new OnClickListener() {
                            public void onClick(View view) {
                                O0000O0o.O000000o(MessageFragment.this.getActivity(), MessageFragment.this.O0000Oo0, 20, O000000o.Loading, null);
                                MessageFragment messageFragment = MessageFragment.this;
                                long O0000oOo = MessageFragment.this.O0000oO == 3 ? MessageFragment.this.O0000o : MessageFragment.this.O0000oO == 4 ? MessageFragment.this.O0000oO0 : (long) MessageFragment.this.O0000oOo;
                                messageFragment.O000000o(O0000oOo);
                            }
                        });
                    }
                }
            }

            public void onFinished() {
                MessageFragment.this.O0000o00();
            }

            public void onSuccess(String str) {
                if (MessageFragment.this.O0000Ooo()) {
                    String str2 = "你还没有任何消息哦~";
                    int O00000Oo = MessageFragment.this.O0000oO;
                    int i = R.drawable.empty_message_icon;
                    boolean z = false;
                    switch (O00000Oo) {
                        case 1:
                        case 2:
                            MessageFragment.this.O0000ooo = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<MessageCommentBean>>() {
                            }.getType());
                            if (MessageFragment.this.O0000ooo != null) {
                                int i2 = 0;
                                while (i2 < MessageFragment.this.O0000ooo.size()) {
                                    MessageCommentBean messageCommentBean = (MessageCommentBean) MessageFragment.this.O0000ooo.get(i2);
                                    messageCommentBean.setTabIndex(MessageFragment.this.O0000oO);
                                    messageCommentBean.setNew(i2 < MessageFragment.this.O0000oo0);
                                    MessageFragment.this.O0000oOo = messageCommentBean.getId();
                                    i2++;
                                }
                            }
                            if (MessageFragment.this.O0000oO != 1) {
                                i = R.drawable.empty_like_icon;
                            }
                            str2 = MessageFragment.this.getString(MessageFragment.this.O0000oO == 1 ? R.string.empty_message_comment : R.string.empty_message_like);
                            break;
                        case 3:
                            MessageFragment.this.O0000ooo = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<MessageNoticeBean>>() {
                            }.getType());
                            if (MessageFragment.this.O0000ooo != null && MessageFragment.this.O0000ooo.size() > 0) {
                                MessageFragment.this.O0000o = ((MessageNoticeBean) MessageFragment.this.O0000ooo.get(MessageFragment.this.O0000ooo.size() - 1)).getTime();
                                break;
                            }
                        case 4:
                            MessageFragment.this.O0000ooo = (List) O000o000.O000000o().fromJson(str, new TypeToken<List<MessageFansBean>>() {
                            }.getType());
                            if (MessageFragment.this.O0000ooo != null && MessageFragment.this.O0000ooo.size() > 0) {
                                MessageFragment.this.O0000oO0 = ((MessageFansBean) MessageFragment.this.O0000ooo.get(MessageFragment.this.O0000ooo.size() - 1)).getInterestTime();
                            }
                            i = R.drawable.empty_fans_icon;
                            str2 = MessageFragment.this.getString(R.string.fans_no_data);
                            break;
                    }
                    MessageFragment.this.O0000Oo.O000000o();
                    if (MessageFragment.this.O0000ooo == null || MessageFragment.this.O0000ooo.size() <= 0) {
                        MessageFragment.this.O0000o0O = false;
                        if (j == 0) {
                            MessageFragment.this.O0000Oo.O000000o(ContextCompat.getDrawable(MessageFragment.this.getActivity(), i), null, str2);
                        }
                    } else {
                        if (j == 0) {
                            MessageFragment.this.O0000OoO.O000000o(MessageFragment.this.O0000ooo);
                            MessageFragment.this.O0000Oo0.setVisibility(0);
                        } else {
                            MessageFragment.this.O0000OoO.O00000Oo(MessageFragment.this.O0000ooo);
                        }
                        MessageFragment messageFragment = MessageFragment.this;
                        if (MessageFragment.this.O0000ooo.size() >= 20) {
                            z = true;
                        }
                        messageFragment.O0000o0O = z;
                    }
                    if (MessageFragment.this.O0000o0O) {
                        O0000O0o.O000000o(MessageFragment.this.O0000Oo0, O000000o.Normal);
                    } else {
                        MessageFragment.this.O0000Ooo.O00000o(MessageFragment.this.O0000Ooo.O00000Oo());
                    }
                }
            }
        }));
    }

    private native void O000000o(String str, String str2);

    public static native MessageFragment O00000Oo(int i, int i2);

    private native void O00000Oo();

    private native void O00000o();

    private native void O00000o0();

    private void O00000oO() {
        if (O0000O0o.O000000o(this.O0000Oo0) != O000000o.Loading && this.O0000o0O) {
            O0000O0o.O000000o(getActivity(), this.O0000Oo0, 20, O000000o.Loading, null);
            long j = this.O0000oO == 3 ? this.O0000o : this.O0000oO == 4 ? this.O0000oO0 : (long) this.O0000oOo;
            O000000o(j);
        }
    }

    @Event(type = OnClickListener.class, value = {2131296709, 2131296719, 2131296708})
    private void onClick(View view) {
        int id = view.getId();
        if (id != R.id.keyboard_post_btn) {
            switch (id) {
                case R.id.keyboard_change /*2131296708*/:
                    this.O0000OOo.O000000o(O00000Oo.O00000Oo);
                    break;
                case R.id.keyboard_comment /*2131296709*/:
                    break;
            }
        }
        if (!O00OOo0.O000000o()) {
            if (TextUtils.isEmpty(this.O0000OOo.getEditText().getText().toString().trim())) {
                this.O0000OOo.getEditText().getText().clear();
                this.O0000OOo.O00000oo();
                this.O0000OOo.O00000Oo(false);
            } else if (this.O0000o00 == null || this.O0000o00.getRoot() == null) {
                O00Oo00.O00000Oo("数据异常！");
            } else {
                O000000o(this.O0000o00.getRoot().getRootType(), this.O0000o00.getRoot().getRootId(), 3, this.O0000o00.getId(), this.O0000o00.getUid());
            }
        }
    }

    public native void O0000OoO();

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.O0000oO = getArguments().getInt(O000000o);
        this.O0000oo0 = getArguments().getInt(O00000oo);
        this.O00000o = String.valueOf(this.O0000oO);
        long j = this.O0000oO == 4 ? this.O0000oO0 : this.O0000oO == 3 ? this.O0000o : (long) this.O0000oOo;
        O000000o(j);
    }

    public native View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    public native void onDestroy();

    public native void onSaveInstanceState(Bundle bundle);

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        O00000Oo();
        this.O0000o0o = true;
        this.O0000Oo0.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.O0000OoO = new ei();
        this.O0000OoO.O000000o(new ei.O0000O0o() {
            public void O000000o(int i) {
                HomePageActivity.O000000o(MessageFragment.this.getActivity(), i);
            }

            public void O000000o(int i, MultiAdapterBean multiAdapterBean) {
                MessageFragment.this.O0000o00 = (MessageCommentBean) multiAdapterBean;
                if (MessageFragment.this.O0000o00.getRoot() != null) {
                    if (MessageFragment.this.O0000o00.getRoot().getIsDeleted() == 1) {
                        O00Oo00.O000000o("内容不存在", false);
                    } else if (MessageFragment.this.O0000o00.getRoot().getRootType() == 1) {
                        ArticleDetailActivity.O000000o(MessageFragment.this.getActivity(), MessageFragment.this.O0000o00.getRoot().getRootId());
                    } else {
                        DynamicDetailActivity.O000000o(MessageFragment.this.getActivity(), MessageFragment.this.O0000o00.getRoot().getRootId(), false);
                    }
                }
            }

            /* renamed from: O000000o */
            public void O00000Oo(View view, int i, MultiAdapterBean multiAdapterBean) {
                if (MessageFragment.this.O0000oO == 1) {
                    MessageFragment.this.O0000o00 = (MessageCommentBean) multiAdapterBean;
                    if ((MessageFragment.this.O0000o00.getRoot() != null && MessageFragment.this.O0000o00.getRoot().getIsDeleted() == 1) || MessageFragment.this.O0000o00.getIsDeleted() == 1) {
                        O00Oo00.O000000o("内容不存在", false);
                    } else if (MessageFragment.this.O0000OOo.O00000o()) {
                        MessageFragment.this.O0000oOO = 0;
                    } else {
                        MessageFragment.this.O0000OOo.O00000Oo(true);
                        MessageFragment.this.O0000OOo.getEditText().requestFocus();
                        MessageFragment.this.O0000OOo.getEditText().setHint(MessageFragment.this.getString(R.string.comment_hint_2_user, new Object[]{MessageFragment.this.O0000o00.getNickName()}));
                        String str = "";
                        if (MessageFragment.this.O0000o0.containsKey("id")) {
                            str = (String) MessageFragment.this.O0000o0.get("id");
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(MessageFragment.this.O0000o00.getId());
                        stringBuilder.append("");
                        if (!str.equals(stringBuilder.toString())) {
                            MessageFragment.this.O0000OOo.getEditText().getText().clear();
                        }
                        O000o.O00000Oo(view);
                        MessageFragment.this.O0000oOO = view.getBottom();
                    }
                } else if (MessageFragment.this.O0000oO == 3) {
                    MessageNoticeBean messageNoticeBean = (MessageNoticeBean) multiAdapterBean;
                    int type = messageNoticeBean.getType();
                    if (type != 6) {
                        switch (type) {
                            case 1:
                                ArticleDetailActivity.O000000o(MessageFragment.this.getActivity(), messageNoticeBean.getId());
                                return;
                            case 2:
                                DynamicDetailActivity.O000000o(MessageFragment.this.getActivity(), messageNoticeBean.getId(), false);
                                return;
                            default:
                                WebViewActivity.O000000o(MessageFragment.this.getActivity(), messageNoticeBean.getUrl());
                                return;
                        }
                    }
                    TopicDetailActivity.O000000o(MessageFragment.this.getActivity(), messageNoticeBean.getId());
                } else if (MessageFragment.this.O0000oO == 4) {
                    HomePageActivity.O000000o(MessageFragment.this.getActivity(), ((MessageFansBean) multiAdapterBean).getUid());
                }
            }

            public void O000000o(final MessageFansBean messageFansBean, final int i) {
                if (!messageFansBean.isServiceDoing() && MessageFragment.this.O0000oO == 4) {
                    if (messageFansBean.getInterestStatus() == 1) {
                        messageFansBean.setServiceDoing(true);
                        MessageFragment.this.O000000o(1, messageFansBean.getUid(), i);
                    } else {
                        new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o(MessageFragment.this.getContext()).O000000o().O000000o("你确定取消关注该用户么").O000000o(true).O00000Oo(true).O000000o("取消关注", com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O00000o0.Green, new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o() {
                            public void O000000o(int i) {
                                messageFansBean.setServiceDoing(true);
                                MessageFragment.this.O000000o(2, messageFansBean.getUid(), i);
                            }
                        }).O00000Oo();
                    }
                }
            }

            /* renamed from: O00000Oo */
            public void O000000o(View view, int i, MultiAdapterBean multiAdapterBean) {
                if (MessageFragment.this.O0000oO == 1) {
                    MessageFragment.this.O0000o00 = (MessageCommentBean) multiAdapterBean;
                    if ((MessageFragment.this.O0000o00.getRoot() != null && MessageFragment.this.O0000o00.getRoot().getIsDeleted() == 1) || MessageFragment.this.O0000o00.getIsDeleted() == 1) {
                        O00Oo00.O000000o("内容不存在", false);
                    } else if (!MessageFragment.this.O0000OOo.getEditText().hasFocus()) {
                        MessageFragment.this.O00000o0();
                    }
                }
            }
        });
        this.O0000Ooo = new O00000o0(this.O0000OoO);
        this.O0000Oo0.setAdapter(this.O0000Ooo);
        this.O0000Oo0.addOnScrollListener(new com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O00000Oo() {
            public void O000000o(View view) {
                MessageFragment.this.O00000oO();
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 && MessageFragment.this.O0000OOo.O00000o()) {
                    MessageFragment.this.O0000OOo.O00000oo();
                    MessageFragment.this.O0000OOo.O00000Oo(false);
                    MessageFragment.this.O0000ooO = 0;
                }
            }
        });
        this.O0000OOo.getEditText().setFilters(new InputFilter[]{new LengthFilter(200)});
        this.O0000OOo.O000000o(EmoticonsKeyboard.O000000o.O00000Oo);
        this.O0000OOo.setOnSoftListener(new EmoticonsKeyboard.O00000o0() {
            /* JADX WARNING: Missing block: B:10:0x0077, code skipped:
            if (r0.equals(r2.toString()) != false) goto L_0x0079;
     */
            public void O000000o() {
                /*
                r5 = this;
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0 = r0.O0000Ooo();
                if (r0 != 0) goto L_0x0009;
            L_0x0008:
                return;
            L_0x0009:
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0 = r0.O0000OOo;
                r0 = r0.getEditText();
                r0.clearFocus();
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0 = r0.O0000OOo;
                r1 = 0;
                r0.O00000Oo(r1);
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0 = r0.O0000o00;
                if (r0 == 0) goto L_0x00bc;
            L_0x0028:
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0 = r0.O0000OOo;
                r0 = r0.getEditText();
                r0 = r0.getText();
                r0 = android.text.TextUtils.isEmpty(r0);
                if (r0 == 0) goto L_0x0079;
            L_0x003c:
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0 = r0.O0000o0;
                r2 = "id";
                r0 = r0.containsKey(r2);
                if (r0 == 0) goto L_0x00bc;
            L_0x004a:
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0 = r0.O0000o0;
                r2 = "id";
                r0 = r0.get(r2);
                r0 = (java.lang.String) r0;
                r2 = new java.lang.StringBuilder;
                r2.<init>();
                r3 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r3 = r3.O0000o00;
                r3 = r3.getId();
                r2.append(r3);
                r3 = "";
                r2.append(r3);
                r2 = r2.toString();
                r0 = r0.equals(r2);
                if (r0 == 0) goto L_0x00bc;
            L_0x0079:
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0 = r0.O0000o0;
                r2 = "id";
                r3 = new java.lang.StringBuilder;
                r3.<init>();
                r4 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r4 = r4.O0000o00;
                r4 = r4.getId();
                r3.append(r4);
                r4 = "";
                r3.append(r4);
                r3 = r3.toString();
                r0.put(r2, r3);
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0 = r0.O0000o0;
                r2 = "text";
                r3 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r3 = r3.O0000OOo;
                r3 = r3.getEditText();
                r3 = r3.getText();
                r3 = r3.toString();
                r0.put(r2, r3);
            L_0x00bc:
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0 = r0.O0000OOo;
                r0 = r0.getEditText();
                r2 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r3 = 2131689559; // 0x7f0f0057 float:1.9008137E38 double:1.0531945787E-314;
                r2 = r2.getString(r3);
                r0.setHint(r2);
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0.O0000oOO = r1;
                r0 = com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment.this;
                r0.O0000ooO = r1;
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.zjwh.android_wh_physicalfitness.ui.message.MessageFragment$AnonymousClass7.O000000o():void");
            }

            public void O000000o(int i) {
                MessageFragment.this.O0000oo = i;
                MessageFragment.this.O0000OOo.O00000Oo(true);
                if (MessageFragment.this.O0000o00 != null && MessageFragment.this.O0000o0.containsKey("id")) {
                    String str = (String) MessageFragment.this.O0000o0.get("id");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(MessageFragment.this.O0000o00.getId());
                    stringBuilder.append("");
                    if (str.equals(stringBuilder.toString()) && MessageFragment.this.O0000o0.containsKey(ArticleDetailActivity.O00000o)) {
                        MessageFragment.this.O0000OOo.getEditText().setText((CharSequence) MessageFragment.this.O0000o0.get(ArticleDetailActivity.O00000o));
                        MessageFragment.this.O0000OOo.getEditText().setSelection(MessageFragment.this.O0000OOo.getEditText().getText().toString().length());
                    }
                }
                if (MessageFragment.this.O0000oOO != 0) {
                    MessageFragment.this.O0000Oo0.smoothScrollBy(0, MessageFragment.this.O0000oOO - (MessageFragment.this.O0000Oo0.getHeight() - i));
                }
            }

            public void O00000Oo(int i) {
                MessageFragment.this.O0000Oo0.smoothScrollBy(0, i - (MessageFragment.this.O0000ooO == 0 ? MessageFragment.this.O0000oo : MessageFragment.this.O0000ooO));
                MessageFragment.this.O0000ooO = i;
            }
        });
    }
}
