package com.zjwh.android_wh_physicalfitness.ui.notice;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseActivity;
import com.zjwh.android_wh_physicalfitness.entity.NoticeDetailBean;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.utils.O000O0o0;
import com.zjwh.android_wh_physicalfitness.utils.O000o0;
import com.zjwh.android_wh_physicalfitness.view.LoadingEmptyLayout;
import defpackage.O00Oo;
import defpackage.he.O000000o;
import defpackage.he.O00000Oo;
import defpackage.jh;
import org.xutils.view.annotation.ViewInject;
import s.h.e.l.l.C;

public class NoticeDetailActivity extends BaseActivity implements O00000Oo {
    @ViewInject(2131296795)
    private LoadingEmptyLayout O000000o;
    @ViewInject(2131297430)
    private TextView O00000Oo;
    @ViewInject(2131297424)
    private TextView O00000o;
    @ViewInject(2131297314)
    private TextView O00000o0;
    @ViewInject(2131297337)
    private TextView O00000oO;
    @ViewInject(2131296692)
    private ImageView O00000oo;
    @ViewInject(2131296345)
    private View O0000O0o;
    @ViewInject(2131296984)
    private RelativeLayout O0000OOo;
    private O000000o O0000Oo;
    @ViewInject(2131296366)
    private Button O0000Oo0;

    static {
        C.i(16777350);
    }

    public static native void O000000o(Activity activity, int i);

    private synchronized O000000o O0000O0o() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new jh(this);
        }
        return this.O0000Oo;
    }

    public native int O000000o();

    public void O000000o(final NoticeDetailBean noticeDetailBean) {
        if (noticeDetailBean != null) {
            this.O00000Oo.setText(TextUtils.isEmpty(noticeDetailBean.getTitle()) ? "" : noticeDetailBean.getTitle());
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(noticeDetailBean.getPublisherRole())) {
                stringBuilder.append(noticeDetailBean.getPublisherRole());
            }
            if (!TextUtils.isEmpty(noticeDetailBean.getPublisher())) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("  ");
                }
                stringBuilder.append(noticeDetailBean.getPublisher());
            }
            this.O00000o0.setText(stringBuilder.toString());
            this.O00000o.setText(O000O0o0.O000000o(O000O0o0.O0000OoO, noticeDetailBean.getPublishDate()));
            this.O00000oO.setText(TextUtils.isEmpty(noticeDetailBean.getContent()) ? "" : noticeDetailBean.getContent());
            int i = 0;
            this.O00000oo.setVisibility(TextUtils.isEmpty(noticeDetailBean.getImageUrl()) ? 8 : 0);
            if (!TextUtils.isEmpty(noticeDetailBean.getImageUrl())) {
                O00Oo.O00000o0(this.O0000o0).O000000o(noticeDetailBean.getImageUrl()).O00000o(0.1f).O000000o(this.O00000oo);
            }
            this.O0000O0o.setVisibility(TextUtils.isEmpty(noticeDetailBean.getButtonText()) ? 8 : 0);
            RelativeLayout relativeLayout = this.O0000OOo;
            if (TextUtils.isEmpty(noticeDetailBean.getButtonText())) {
                i = 8;
            }
            relativeLayout.setVisibility(i);
            this.O0000Oo0.setText(TextUtils.isEmpty(noticeDetailBean.getButtonText()) ? "" : noticeDetailBean.getButtonText());
            this.O0000Oo0.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(noticeDetailBean.getButtonUrl())) {
                        O000o0.O000000o(NoticeDetailActivity.this, noticeDetailBean.getButtonUrl());
                    }
                }
            });
            this.O000000o.O000000o();
        }
    }

    public void O000000o(ResponseError responseError) {
        if (!isFinishing()) {
            this.O000000o.O000000o(null, getString(R.string.txt_request_failure), responseError.getMessage(), "", new OnClickListener() {
                public void onClick(View view) {
                    NoticeDetailActivity.this.O0000O0o().O000000o(NoticeDetailActivity.this.O0000o0);
                }
            });
        }
    }

    public native void O00000Oo();

    public native void O00000o();

    public native void O00000oO();

    public native void O00000oo();

    public void n_() {
    }

    public native void onCreate(Bundle bundle);

    public native void onDestroy();
}
