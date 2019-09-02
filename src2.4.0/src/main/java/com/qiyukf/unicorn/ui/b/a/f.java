package com.qiyukf.unicorn.ui.b.a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.e;
import com.qiyukf.unicorn.f.a.a.a.e.c;
import com.qiyukf.unicorn.j.h;
import com.qiyukf.unicorn.ui.activity.CardPopupActivity;
import com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout;
import com.qiyukf.unicorn.widget.pulltorefresh.PullableListView;
import java.util.ArrayList;
import java.util.List;

public class f extends e implements OnClickListener, OnItemClickListener, OnDismissListener, com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout.a {
    private TextView a;
    private ListView b;
    private View c;
    private TextView d;
    private e e;
    private a f;
    private PopupWindow g;
    private View h;
    private View i;
    private PullToRefreshLayout j;
    private PullableListView k;
    private a l;
    private String m;
    private String n;
    private boolean o;
    private Observer<CustomNotification> p = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            CustomNotification customNotification = (CustomNotification) obj;
            if (f.this.o && customNotification.getSessionType() == SessionTypeEnum.Ysf && (customNotification.getAttachment() instanceof com.qiyukf.unicorn.f.a.a.b)) {
                com.qiyukf.unicorn.f.a.a.b bVar = (com.qiyukf.unicorn.f.a.a.b) customNotification.getAttachment();
                if (bVar.a() instanceof e) {
                    f.this.o = false;
                    e eVar = (e) bVar.a();
                    if (eVar.e() == null || eVar.d().isEmpty()) {
                        f.this.k.a(false);
                        f.this.j.a(2);
                    } else {
                        f.this.m = eVar.e().a();
                        f.this.n = eVar.e().b();
                        f.this.l.b(eVar.d());
                        f.this.l.notifyDataSetChanged();
                        f.this.j.a(0);
                    }
                }
            }
        }
    };

    private static class a extends BaseAdapter {
        private List<c> a = new ArrayList();
        private boolean b;

        public a(boolean z) {
            this.b = z;
        }

        /* renamed from: a */
        public final c getItem(int i) {
            return (c) this.a.get(i);
        }

        public final void a(List<c> list) {
            this.a.clear();
            b(list);
        }

        public final void b(List<c> list) {
            this.a.addAll(list);
        }

        public final int getCount() {
            return this.a.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            boolean z = false;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ysf_view_holder_card, viewGroup, false);
                bVar = new b(view, this.b);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.a((c) this.a.get(i));
            if (i < this.a.size() - 1) {
                z = true;
            }
            bVar.a(z);
            return view;
        }
    }

    static class b {
        private LinearLayout a;
        private View b;
        private boolean c;

        b(View view, boolean z) {
            this.c = z;
            this.a = (LinearLayout) view.findViewById(R.id.ysf_holder_card_container);
            this.b = view.findViewById(R.id.ysf_holder_card_divider);
        }

        /* Access modifiers changed, original: final */
        public final void a(c cVar) {
            this.a.removeAllViews();
            for (List<com.qiyukf.unicorn.f.a.a.a.e.b> list : cVar.b()) {
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getContext()).inflate(R.layout.ysf_message_item_card_layout, this.a, false);
                for (com.qiyukf.unicorn.f.a.a.a.e.b a : list) {
                    b.a(a, linearLayout, list.size(), this.c);
                }
                this.a.addView(linearLayout);
            }
        }

        /* Access modifiers changed, original: final */
        public final void a(boolean z) {
            this.b.setVisibility(z ? 0 : 8);
        }
    }

    private void a(boolean z) {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.p, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        this.e = (e) this.message.getAttachment();
        this.a.setText(this.e.c());
        this.f.a(this.e.d());
        this.b.setAdapter(this.f);
        this.b.setOnItemClickListener(this);
        if (this.e.e() != null) {
            this.c.setVisibility(0);
            this.d.setText(this.e.e().d());
            this.d.setOnClickListener(this);
            return;
        }
        this.c.setVisibility(8);
    }

    public final void a(String str, String str2) {
        if (getAdapter().d().a()) {
            CardPopupActivity.start(this.context, this.message.getSessionId(), str, str2);
        }
    }

    public final void c() {
        if (getAdapter().d().a()) {
            this.g = new PopupWindow(this.context);
            this.g.setWidth(-1);
            this.g.setHeight((int) (((double) d.b()) * 0.8d));
            this.g.setContentView(LayoutInflater.from(this.context).inflate(R.layout.ysf_popup_window_bot_list, null));
            this.g.setBackgroundDrawable(new ColorDrawable(0));
            this.g.setOutsideTouchable(false);
            this.g.setFocusable(true);
            this.g.setOnDismissListener(this);
            this.g.setAnimationStyle(R.style.ysf_dialog_window_animation_style);
            this.g.showAtLocation(((Activity) this.context).getWindow().getDecorView().findViewById(16908290), 81, 0, 0);
            h.a(((Activity) this.context).getWindow(), 0.3f);
            this.h = this.g.getContentView().findViewById(R.id.ysf_bot_list_placeholder);
            TextView textView = (TextView) this.g.getContentView().findViewById(R.id.ysf_bot_list_title);
            this.i = this.g.getContentView().findViewById(R.id.ysf_bot_list_close);
            this.j = (PullToRefreshLayout) this.g.getContentView().findViewById(R.id.ysf_ptr_layout_bot_list);
            this.k = (PullableListView) this.g.getContentView().findViewById(R.id.ysf_lv_bot_list);
            textView.setText(this.e.e().e());
            this.h.setOnClickListener(this);
            this.i.setOnClickListener(this);
            this.k.setOnItemClickListener(this);
            this.m = this.e.e().a();
            this.n = this.e.e().b();
            if (this.l == null) {
                this.l = new a(false);
            }
            this.l = this.l;
            this.l.a(this.e.d());
            this.k.setAdapter(this.l);
            this.k.a(true);
            this.j.a((com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout.a) this);
            a(true);
            getAdapter().d().b();
        }
    }

    public final void d() {
        if (com.qiyukf.unicorn.d.g().c(this.message.getSessionId()) == 0) {
            this.j.a(1);
            g.a(R.string.ysf_bot_load_more_disabled);
            return;
        }
        com.qiyukf.unicorn.f.a.a.c cVar = new com.qiyukf.unicorn.f.a.a.c();
        cVar.a(this.m);
        cVar.b(this.n);
        com.qiyukf.unicorn.h.c.a(cVar, this.message.getSessionId(), false).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (i == 200) {
                    f.this.o = true;
                    return;
                }
                f.this.o = false;
                f.this.j.a(1);
            }
        });
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_bot_list;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = (TextView) findViewById(R.id.ysf_tv_bot_list_title);
        this.b = (ListView) findViewById(R.id.ysf_lv_bot_list);
        this.c = findViewById(R.id.ysf_bot_footer_layout);
        this.d = (TextView) findViewById(R.id.ysf_bot_footer_text);
        this.f = new a(true);
    }

    public void onClick(View view) {
        if (view == this.d) {
            a.a(this.e.e(), this);
            return;
        }
        if (view == this.i || view == this.h) {
            this.g.dismiss();
        }
    }

    public void onDismiss() {
        h.a(((Activity) this.context).getWindow(), 1.0f);
        a(false);
        this.o = false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.qiyukf.unicorn.f.a.a.a.e.a a = ((a) adapterView.getAdapter()).getItem(i).a();
        a.a(a, this);
        if (adapterView == this.k && !TextUtils.equals(a.c(), "popup")) {
            this.g.dismiss();
        }
    }
}
