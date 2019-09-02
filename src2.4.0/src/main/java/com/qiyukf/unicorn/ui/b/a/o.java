package com.qiyukf.unicorn.ui.b.a;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.d;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nimlib.sdk.NIMClient;
import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.RequestCallbackWrapper;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.MsgServiceObserve;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.nimlib.sdk.msg.model.CustomNotification;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.f.a.a.a.k;
import com.qiyukf.unicorn.f.a.a.b;
import com.qiyukf.unicorn.f.a.a.c;
import com.qiyukf.unicorn.j.h;
import com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout;
import com.qiyukf.unicorn.widget.pulltorefresh.PullableListView;
import java.util.ArrayList;
import java.util.List;

public class o extends e implements OnClickListener, OnItemClickListener, OnDismissListener, com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout.a {
    private TextView a;
    private ListView b;
    private View c;
    private TextView d;
    private a e;
    private PopupWindow f;
    private View g;
    private View h;
    private PullToRefreshLayout i;
    private PullableListView j;
    private a k;
    private String l;
    private String m;
    private boolean n;
    private Observer<CustomNotification> o = new Observer<CustomNotification>() {
        public final /* synthetic */ void onEvent(Object obj) {
            CustomNotification customNotification = (CustomNotification) obj;
            if (o.this.n && customNotification.getSessionType() == SessionTypeEnum.Ysf && (customNotification.getAttachment() instanceof b)) {
                b bVar = (b) customNotification.getAttachment();
                if (bVar.a() instanceof k) {
                    o.this.n = false;
                    k kVar = (k) bVar.a();
                    if (kVar.e() == null || kVar.d().isEmpty()) {
                        o.this.j.a(false);
                        o.this.i.a(2);
                    } else {
                        o.this.l = kVar.e().b();
                        o.this.m = kVar.e().c();
                        o.this.k.b(kVar.d());
                        o.this.k.notifyDataSetChanged();
                        o.this.i.a(0);
                    }
                }
            }
        }
    };

    private static class a extends BaseAdapter {
        private List<Object> a;

        private static class a {
            private ImageView a;
            private TextView b;
            private TextView c;
            private TextView d;
            private TextView e;
            private TextView f;
            private View g;

            public a(View view) {
                this.a = (ImageView) view.findViewById(R.id.ysf_iv_goods_img);
                this.b = (TextView) view.findViewById(R.id.ysf_tv_goods_name);
                this.c = (TextView) view.findViewById(R.id.ysf_tv_goods_sku);
                this.d = (TextView) view.findViewById(R.id.ysf_tv_goods_price);
                this.e = (TextView) view.findViewById(R.id.ysf_tv_goods_count);
                this.f = (TextView) view.findViewById(R.id.ysf_tv_goods_state);
                this.g = view.findViewById(R.id.ysf_v_order_list_goods_divider);
            }

            public final void a(com.qiyukf.unicorn.f.a.a.a.k.b.a aVar, boolean z, boolean z2) {
                int a = d.a(60.0f);
                com.qiyukf.nim.uikit.a.a(aVar.e(), this.a, a, a);
                this.b.setText(aVar.f());
                this.c.setText(aVar.i());
                this.d.setText(aVar.g());
                this.e.setText(aVar.h());
                this.f.setText(aVar.d());
                this.g.setVisibility(z ? 8 : 0);
                int a2 = z2 ? 0 : d.a(10.0f);
                this.g.setPadding(a2, 0, a2, 0);
            }
        }

        private static class b {
            private View a;
            private View b;
            private TextView c;
            private TextView d;

            public b(View view) {
                this.a = view.findViewById(R.id.ysf_order_list_order_header_content);
                this.b = view.findViewById(R.id.ysf_order_list_header_divider);
                this.c = (TextView) view.findViewById(R.id.ysf_tv_order_shop_name);
                this.d = (TextView) view.findViewById(R.id.ysf_tv_order_state);
            }

            public final void a(com.qiyukf.unicorn.f.a.a.a.k.b bVar, boolean z) {
                this.c.setText(bVar.a());
                this.d.setText(bVar.b());
                int i = 0;
                this.a.setPadding(0, z ? 0 : d.a(10.0f), 0, 0);
                View view = this.b;
                if (z) {
                    i = 8;
                }
                view.setVisibility(i);
            }
        }

        private a() {
            this.a = new ArrayList();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(List<com.qiyukf.unicorn.f.a.a.a.k.b> list) {
            this.a.clear();
            b(list);
        }

        public final void b(List<com.qiyukf.unicorn.f.a.a.a.k.b> list) {
            for (int i = 0; i < list.size(); i++) {
                com.qiyukf.unicorn.f.a.a.a.k.b bVar = (com.qiyukf.unicorn.f.a.a.a.k.b) list.get(i);
                this.a.add(bVar);
                this.a.addAll(bVar.c());
            }
        }

        public final int getCount() {
            return this.a.size();
        }

        public final Object getItem(int i) {
            return this.a.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            return this.a.get(i) instanceof com.qiyukf.unicorn.f.a.a.a.k.b ? 0 : 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z = false;
            switch (getItemViewType(i)) {
                case 0:
                    b bVar;
                    if (view == null) {
                        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ysf_view_holder_order_list_order_header, null);
                        bVar = new b(view);
                        view.setTag(bVar);
                    } else {
                        bVar = (b) view.getTag();
                    }
                    com.qiyukf.unicorn.f.a.a.a.k.b bVar2 = (com.qiyukf.unicorn.f.a.a.a.k.b) this.a.get(i);
                    if (i == 0) {
                        z = true;
                    }
                    bVar.a(bVar2, z);
                    return view;
                case 1:
                    a aVar;
                    if (view == null) {
                        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ysf_view_holder_order_list_goods, null);
                        aVar = new a(view);
                        view.setTag(aVar);
                    } else {
                        aVar = (a) view.getTag();
                    }
                    boolean z2 = i < this.a.size() - 1 && (this.a.get(i + 1) instanceof com.qiyukf.unicorn.f.a.a.a.k.b);
                    com.qiyukf.unicorn.f.a.a.a.k.b.a aVar2 = (com.qiyukf.unicorn.f.a.a.a.k.b.a) this.a.get(i);
                    if (i == this.a.size() - 1) {
                        z = true;
                    }
                    aVar.a(aVar2, z, z2);
                    return view;
                default:
                    return view;
            }
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final boolean isEnabled(int i) {
            return this.a.get(i) instanceof com.qiyukf.unicorn.f.a.a.a.k.b.a;
        }
    }

    private void a(boolean z) {
        ((MsgServiceObserve) NIMClient.getService(MsgServiceObserve.class)).observeCustomNotification(this.o, z);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a() {
        k kVar = (k) this.message.getAttachment();
        this.a.setText(kVar.c());
        this.e.a(kVar.d());
        this.b.setAdapter(this.e);
        this.b.setOnItemClickListener(this);
        if (kVar.e() == null || kVar.d().size() < 3) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setVisibility(0);
        this.d.setText(kVar.e().a());
        this.d.setOnClickListener(this);
    }

    public final void d() {
        if (com.qiyukf.unicorn.d.g().c(this.message.getSessionId()) == 0) {
            this.i.a(1);
            g.a(R.string.ysf_bot_load_more_disabled);
            return;
        }
        c cVar = new c();
        cVar.a(this.l);
        cVar.b(this.m);
        com.qiyukf.unicorn.h.c.a(cVar, this.message.getSessionId(), false).setCallback(new RequestCallbackWrapper<Void>() {
            public final /* synthetic */ void onResult(int i, Object obj, Throwable th) {
                if (i == 200) {
                    o.this.n = true;
                    return;
                }
                o.this.n = false;
                o.this.i.a(1);
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
        this.e = new a();
    }

    public void onClick(View view) {
        if (view == this.d) {
            if (getAdapter().d().a()) {
                this.f = new PopupWindow(this.context);
                this.f.setWidth(-1);
                this.f.setHeight((int) (((double) d.b()) * 0.8d));
                this.f.setContentView(LayoutInflater.from(this.context).inflate(R.layout.ysf_popup_window_bot_list, null));
                this.f.setBackgroundDrawable(new ColorDrawable(0));
                this.f.setOutsideTouchable(false);
                this.f.setFocusable(true);
                this.f.setOnDismissListener(this);
                this.f.setAnimationStyle(R.style.ysf_dialog_window_animation_style);
                this.f.showAtLocation(((Activity) this.context).getWindow().getDecorView().findViewById(16908290), 81, 0, 0);
                h.a(((Activity) this.context).getWindow(), 0.3f);
                this.g = this.f.getContentView().findViewById(R.id.ysf_bot_list_placeholder);
                TextView textView = (TextView) this.f.getContentView().findViewById(R.id.ysf_bot_list_title);
                this.h = this.f.getContentView().findViewById(R.id.ysf_bot_list_close);
                this.i = (PullToRefreshLayout) this.f.getContentView().findViewById(R.id.ysf_ptr_layout_bot_list);
                this.j = (PullableListView) this.f.getContentView().findViewById(R.id.ysf_lv_bot_list);
                textView.setText(R.string.ysf_bot_order_list_title);
                this.g.setOnClickListener(this);
                this.h.setOnClickListener(this);
                this.j.setOnItemClickListener(this);
                k kVar = (k) this.message.getAttachment();
                this.l = kVar.e().b();
                this.m = kVar.e().c();
                if (this.k == null) {
                    this.k = new a();
                }
                this.k = this.k;
                this.k.a(kVar.d());
                this.j.setAdapter(this.k);
                this.j.a(true);
                this.i.a((com.qiyukf.unicorn.widget.pulltorefresh.PullToRefreshLayout.a) this);
                a(true);
                getAdapter().d().b();
            }
        } else if (view == this.h || view == this.g) {
            this.f.dismiss();
        }
    }

    public void onDismiss() {
        h.a(((Activity) this.context).getWindow(), 1.0f);
        a(false);
        this.n = false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.qiyukf.unicorn.f.a.a.a.k.b.a aVar = (com.qiyukf.unicorn.f.a.a.a.k.b.a) adapterView.getAdapter().getItem(i);
        com.qiyukf.unicorn.a.a.a.a.b.b bVar = new com.qiyukf.unicorn.a.a.a.a.b.b();
        bVar.fromJson(aVar.a());
        com.qiyukf.unicorn.a.a.a.a.b bVar2 = new com.qiyukf.unicorn.a.a.a.a.b();
        bVar2.a(aVar.b());
        bVar2.b(aVar.c());
        bVar2.a(bVar.c());
        bVar.a(bVar2);
        getAdapter().d().c(MessageBuilder.createCustomMessage(this.message.getSessionId(), SessionTypeEnum.Ysf, bVar));
        if (adapterView == this.j) {
            this.f.dismiss();
        }
    }
}
