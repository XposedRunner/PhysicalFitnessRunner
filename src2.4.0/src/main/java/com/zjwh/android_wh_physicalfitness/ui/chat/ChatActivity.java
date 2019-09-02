package com.zjwh.android_wh_physicalfitness.ui.chat;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.sw.emoji.EmoticonsKeyboard;
import com.sw.emoji.EmoticonsKeyboard.O00000o0;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.ChatBean;
import com.zjwh.android_wh_physicalfitness.entity.ChatBean.Status;
import com.zjwh.android_wh_physicalfitness.entity.database.ChatFriendBean;
import defpackage.dx;
import defpackage.go.O000000o;
import defpackage.go.O00000Oo;
import defpackage.iv;
import defpackage.oOOO0O0o;
import java.util.List;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class ChatActivity extends BaseActivity implements O00000Oo {
    @ViewInject(2131296949)
    protected SwipeRefreshLayout O000000o;
    @ViewInject(2131296741)
    private TextView O00000Oo;
    @ViewInject(2131296972)
    private View O00000o;
    @ViewInject(2131297158)
    private TextView O00000o0;
    @ViewInject(2131296707)
    private EmoticonsKeyboard O00000oO;
    @ViewInject(2131296942)
    private RecyclerView O00000oo;
    private O000000o O0000O0o;
    private dx O0000OOo;
    private BroadcastReceiver O0000Oo;
    private LocalBroadcastManager O0000Oo0;

    static {
        C.i(16777318);
    }

    public static native void O000000o(Activity activity, ChatFriendBean chatFriendBean);

    private O000000o O0000O0o() {
        if (this.O0000O0o == null) {
            this.O0000O0o = new iv(this);
        }
        return this.O0000O0o;
    }

    private void O0000OOo() {
        this.O00000o0.setText(O0000O0o().O00000oo());
        this.O000000o.setColorSchemeResources(new int[]{R.color.sport_green, R.color.green2, R.color.big_red, R.color.green3});
        this.O000000o.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                ChatActivity.this.O0000O0o().O0000Oo0();
            }
        });
        this.O00000oO.getEditText().setFilters(new InputFilter[]{new LengthFilter(oOOO0O0o.O00000Oo)});
        this.O00000oO.O00000Oo(true);
        this.O00000oO.O000000o(EmoticonsKeyboard.O000000o.O00000Oo);
        this.O00000oO.setOnSoftListener(new O00000o0() {
            public void O000000o() {
            }

            public void O000000o(int i) {
            }

            public void O00000Oo(int i) {
                ChatActivity.this.O0000o0();
            }
        });
        this.O00000oO.getEditText().setText(O0000O0o().O000000o());
        this.O00000oo.addOnScrollListener(new OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                switch (i) {
                    case 1:
                        ChatActivity.this.O00000oO.O00000oo();
                        return;
                    default:
                        return;
                }
            }
        });
        this.O00000oo.setLayoutManager(new LinearLayoutManager(this));
        this.O0000OOo = new dx(O0000O0o().O00000oO(), O0000O0o().O00000o(), O0000O0o().O00000o0());
        this.O0000OOo.O000000o(new dx.O00000Oo() {
            public void O000000o(View view, ChatBean chatBean, int i) {
                chatBean.setStatus(Status.Loading);
                ChatActivity.this.O0000OOo.notifyItemChanged(i);
                ChatActivity.this.O0000O0o().O000000o(ChatActivity.this.O0000o0, i, chatBean);
            }
        });
        this.O00000oo.setAdapter(this.O0000OOo);
    }

    private native void O0000Oo0();

    private native void O0000o0();

    @Event(type = OnClickListener.class, value = {2131296709, 2131296719, 2131296708, 2131296740, 2131296972})
    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.keyboard_change /*2131296708*/:
                this.O00000oO.O000000o(EmoticonsKeyboard.O00000Oo.O00000Oo);
                break;
            case R.id.keyboard_comment /*2131296709*/:
            case R.id.keyboard_post_btn /*2131296719*/:
                if (!TextUtils.isEmpty(this.O00000oO.getEditText().getText().toString().trim())) {
                    O0000O0o().O000000o(this, this.O0000OOo.getItemCount() - 1, O0000O0o().O00000Oo(this.O00000oO.getEditText().getText().toString().trim()));
                    this.O00000oO.getEditText().getText().clear();
                    break;
                }
                O00000Oo("", "不能发送空白消息");
                return;
            case R.id.left_image /*2131296740*/:
                onBackPressed();
                break;
            case R.id.right_image /*2131296972*/:
                new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o(this).O000000o().O000000o(O0000O0o().O0000O0o()).O000000o(true).O00000Oo(true).O000000o(O0000O0o().O0000OOo(), com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O00000o0.Green, new com.zjwh.android_wh_physicalfitness.view.dialog.O000000o.O000000o() {
                    public void O000000o(int i) {
                        ChatActivity.this.O0000O0o().O00000Oo(ChatActivity.this.O0000o0);
                    }
                }).O00000Oo();
                break;
        }
    }

    public native int O000000o();

    public native void O000000o(int i);

    public native void O000000o(ChatBean chatBean);

    public native void O000000o(String str);

    public void O000000o(List<ChatBean> list) {
        this.O0000OOo.O00000Oo((List) list);
        O0000o0();
    }

    public native void O00000Oo();

    public native void O00000Oo(int i);

    public void O00000Oo(final List<ChatBean> list) {
        this.O0000OOo.O00000o0((List) list);
        this.O000000o.setRefreshing(false);
        this.O00000oo.requestLayout();
        this.O00000oo.post(new Runnable() {
            public void run() {
                ChatActivity.this.O00000oo.smoothScrollToPosition(list.size() - 1);
            }
        });
    }

    public native void O00000o();

    public void O00000o0(List<ChatBean> list) {
        this.O0000OOo.O000000o((List) list);
        O0000o0();
    }

    public native void O00000oO();

    public native void O00000oo();

    public void n_() {
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O000000o O0000O0o = O0000O0o();
        if (bundle == null) {
            bundle = getIntent().getExtras();
        }
        O0000O0o.O000000o(bundle);
        if (!isFinishing()) {
            O0000O0o().O000000o((Context) this);
            O0000OOo();
            O0000Oo0();
            O0000O0o().O0000Oo0();
        }
    }

    public native void onDestroy();

    /* Access modifiers changed, original: protected */
    public void onPause() {
        super.onPause();
        O0000O0o().O000000o(this.O00000oO.getEditText().getText().toString());
    }

    public native void onSaveInstanceState(Bundle bundle);
}
