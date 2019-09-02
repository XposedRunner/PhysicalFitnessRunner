package com.qiyukf.unicorn.ui.b;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nim.uikit.a;
import com.qiyukf.nim.uikit.session.viewholder.b;
import com.qiyukf.nimlib.sdk.msg.MessageBuilder;
import com.qiyukf.nimlib.sdk.msg.constant.MsgDirectionEnum;
import com.qiyukf.nimlib.sdk.msg.constant.SessionTypeEnum;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.OnMessageItemClickListener;
import com.qiyukf.unicorn.api.msg.attachment.ProductAttachment;
import com.qiyukf.unicorn.d;

public class c extends b {
    private View a;
    private TextView b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private LinearLayout o;
    private View p;
    private View q;
    private ImageView r;
    private View s;
    private TextView t;
    private LinearLayout u;
    private View v;
    private TextView w;
    private ProductAttachment x;

    /* Access modifiers changed, original: protected */
    public void bindContentView() {
        this.x = (ProductAttachment) this.message.getAttachment();
        this.a.setBackgroundResource(isReceivedMessage() ? R.drawable.ysf_message_left_bg_product_selector : R.drawable.ysf_message_right_bg_product_selector);
        LayoutParams layoutParams;
        String picture;
        if (this.x.getTemplate() == null || !"pictureLink".equals(this.x.getTemplate())) {
            TextView textView;
            StringBuilder stringBuilder;
            layoutParams = (LayoutParams) this.a.getLayoutParams();
            layoutParams.width = (int) ((255.0f * this.context.getResources().getDisplayMetrics().density) + 0.5f);
            this.a.setLayoutParams(layoutParams);
            this.r.setVisibility(8);
            this.u.setVisibility(0);
            this.b.setText(this.x.getTitle());
            this.d.setText(this.x.getDesc());
            this.c.setImageResource(R.drawable.ysf_image_placeholder_loading);
            picture = this.x.getPicture();
            a.a(TextUtils.isEmpty(picture) ? "" : picture.trim(), this.c, this.c.getWidth(), this.c.getHeight());
            if (TextUtils.isEmpty(this.x.getOrderSku())) {
                this.n.setVisibility(8);
            } else {
                this.n.setVisibility(0);
                this.n.setText(this.x.getOrderSku());
            }
            if (TextUtils.isEmpty(this.x.getNote())) {
                this.e.setVisibility(8);
            } else {
                this.e.setText(this.x.getNote());
                this.e.setVisibility(0);
            }
            if (TextUtils.isEmpty(this.x.getOrderTime())) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                textView = this.l;
                stringBuilder = new StringBuilder("下单时间：");
                stringBuilder.append(this.x.getOrderTime());
                textView.setText(stringBuilder.toString());
            }
            if (TextUtils.isEmpty(this.x.getOrderID())) {
                this.k.setVisibility(8);
                this.p.setVisibility(8);
            } else {
                this.p.setVisibility(0);
                this.k.setVisibility(0);
                textView = this.k;
                stringBuilder = new StringBuilder("订单编号：");
                stringBuilder.append(this.x.getOrderID());
                textView.setText(stringBuilder.toString());
            }
            if (TextUtils.isEmpty(this.x.getActivity())) {
                this.m.setVisibility(8);
                this.q.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                this.q.setVisibility(0);
                this.m.setText(this.x.getActivity());
                if (!TextUtils.isEmpty(this.x.getActivityHref())) {
                    this.m.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            d.e().onMessageItemClickListener.onURLClicked(c.this.context, c.this.x.getActivityHref());
                        }
                    });
                }
            }
            this.h.setVisibility(0);
            if (TextUtils.isEmpty(this.x.getPrice())) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                this.f.setText(this.x.getPrice());
            }
            if (TextUtils.isEmpty(this.x.getOrderStatus())) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
                this.g.setText(this.x.getOrderStatus());
            }
            if (TextUtils.isEmpty(this.x.getPayMoney())) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.i.setText(this.x.getPayMoney());
            }
            if (TextUtils.isEmpty(this.x.getOrderCount())) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
                this.j.setText(this.x.getOrderCount());
            }
        } else {
            layoutParams = (LayoutParams) this.a.getLayoutParams();
            layoutParams.width = -2;
            this.a.setLayoutParams(layoutParams);
            this.r.setVisibility(0);
            this.u.setVisibility(8);
            this.k.setVisibility(8);
            this.p.setVisibility(8);
            this.l.setVisibility(8);
            this.q.setVisibility(8);
            this.m.setVisibility(8);
            this.r.setImageResource(R.drawable.ysf_image_placeholder_loading);
            picture = this.x.getPicture();
            a.a(TextUtils.isEmpty(picture) ? "" : picture.trim(), this.r, this.r.getWidth(), this.r.getHeight());
            if (!TextUtils.isEmpty(this.x.getUrl())) {
                this.r.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        d.e().onMessageItemClickListener.onURLClicked(c.this.context, c.this.x.getUrl());
                    }
                });
            }
        }
        if (this.x.getSendByUser() == 1 && this.message.getDirect() == MsgDirectionEnum.Out && d.g().e(this.message.getSessionId()) != 1) {
            this.t.setText(TextUtils.isEmpty(this.x.getActionText()) ? "发送链接" : this.x.getActionText());
            this.t.setTextColor(this.x.getActionTextColor() == 0 ? -10578718 : this.x.getActionTextColor());
            this.s.setVisibility(0);
            this.t.setVisibility(0);
            this.t.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    int i;
                    if (d.g().e(c.this.message.getSessionId()) == 1) {
                        i = R.string.ysf_send_card_robot;
                    } else if (com.qiyukf.unicorn.h.c.b()) {
                        ProductAttachment clone = c.this.x.clone();
                        if (clone != null) {
                            clone.setSendByUser(0);
                            clone.setActionText("");
                            com.qiyukf.unicorn.h.c.b(MessageBuilder.createCustomMessage(c.this.message.getSessionId(), SessionTypeEnum.Ysf, clone));
                        }
                        return;
                    } else {
                        i = R.string.ysf_send_card_error;
                    }
                    g.b(i);
                }
            });
        } else {
            this.t.setVisibility(8);
            this.s.setVisibility(8);
        }
        if (this.message.getDirect() == MsgDirectionEnum.Out && this.x.isOpenReselect()) {
            this.w.setVisibility(0);
            this.v.setVisibility(0);
            this.w.setText(TextUtils.isEmpty(this.x.getReselectText()) ? "重新选择" : this.x.getReselectText());
            this.w.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    c.this.x.getProductReslectOnclickListener().onClick(c.this.context, c.this.x.getHandlerTag());
                }
            });
            return;
        }
        this.w.setVisibility(8);
        this.v.setVisibility(8);
    }

    /* Access modifiers changed, original: protected */
    public int getContentResId() {
        return R.layout.ysf_message_item_product;
    }

    /* Access modifiers changed, original: protected */
    public void inflateContentView() {
        this.a = findViewById(R.id.ysf_product_content);
        this.b = (TextView) findViewById(R.id.ysf_product_title);
        this.c = (ImageView) findViewById(R.id.ysf_product_image);
        this.d = (TextView) findViewById(R.id.ysf_product_description);
        this.e = (TextView) findViewById(R.id.ysf_product_note);
        this.n = (TextView) findViewById(R.id.ysf_product_sku);
        this.f = (TextView) findViewById(R.id.ysf_product_price);
        this.g = (TextView) findViewById(R.id.ysf_product_order_status);
        this.h = (LinearLayout) findViewById(R.id.ysf_ll_product_price_and_count_parent);
        this.i = (TextView) findViewById(R.id.ysf_tv_product_pay_money);
        this.j = (TextView) findViewById(R.id.ysf_tv_product_count);
        this.k = (TextView) findViewById(R.id.ysf_tv_product_number);
        this.l = (TextView) findViewById(R.id.ysf_tv_product_time);
        this.m = (TextView) findViewById(R.id.ysf_tv_product_activity);
        this.o = (LinearLayout) findViewById(R.id.ysf_product_tags);
        this.p = findViewById(R.id.ysf_view_product_order_line);
        this.q = findViewById(R.id.view_ysf_message_item_activity_line);
        this.r = (ImageView) findViewById(R.id.iv_ysf_message_product_template);
        this.s = findViewById(R.id.view_ysf_message_item_send_line);
        this.t = (TextView) findViewById(R.id.tv_ysf_message_product_send);
        this.u = (LinearLayout) findViewById(R.id.ll_ysf_message_product_top_parent);
        this.v = findViewById(R.id.view_ysf_message_item_reselect_line);
        this.w = (TextView) findViewById(R.id.tv_ysf_message_product_reselect);
    }

    /* Access modifiers changed, original: protected */
    public int leftBackground() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public void onItemClick() {
        if (this.x.getUrl() != null) {
            String trim = this.x.getUrl().trim();
            Uri parse = Uri.parse(trim);
            if (TextUtils.isEmpty(parse.getScheme())) {
                StringBuilder stringBuilder = new StringBuilder("http://");
                stringBuilder.append(trim);
                trim = stringBuilder.toString();
                parse = Uri.parse(trim);
            }
            try {
                OnMessageItemClickListener onMessageItemClickListener = d.e().onMessageItemClickListener;
                if (onMessageItemClickListener != null) {
                    onMessageItemClickListener.onURLClicked(this.context, trim);
                    return;
                }
                this.context.startActivity(new Intent("android.intent.action.VIEW", parse));
            } catch (Exception unused) {
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public int rightBackground() {
        return 0;
    }
}
