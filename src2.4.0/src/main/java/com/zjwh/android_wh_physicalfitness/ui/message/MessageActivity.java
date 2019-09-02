package com.zjwh.android_wh_physicalfitness.ui.message;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseRefreshLoadListActivity;
import com.zjwh.android_wh_physicalfitness.entity.ChatListBean;
import defpackage.hc.O000000o;
import defpackage.hc.O00000Oo;
import defpackage.jf;
import s.h.e.l.l.C;

public class MessageActivity extends BaseRefreshLoadListActivity<ChatListBean, O000000o> implements OnClickListener, O00000Oo {
    private TextView O0000OOo;
    private TextView O0000Oo;
    private TextView O0000Oo0;
    private TextView O0000o;
    private BroadcastReceiver O0000oO;
    private LocalBroadcastManager O0000oO0;

    static {
        C.i(16777323);
    }

    private void O000000o(int i, int i2) {
        switch (i) {
            case 1:
                if (i2 > 0) {
                    this.O0000OOo.setText(String.valueOf(i2));
                    this.O0000OOo.setVisibility(0);
                    return;
                }
                this.O0000OOo.setVisibility(8);
                O0000OOo().O000000o(i2);
                return;
            case 2:
                if (i2 > 0) {
                    this.O0000Oo0.setText(String.valueOf(i2));
                    this.O0000Oo0.setVisibility(0);
                    return;
                }
                this.O0000Oo0.setVisibility(8);
                O0000OOo().O00000Oo(i2);
                return;
            case 3:
                if (i2 > 0) {
                    this.O0000Oo.setText(String.valueOf(i2));
                    this.O0000Oo.setVisibility(0);
                    return;
                }
                this.O0000Oo.setVisibility(8);
                O0000OOo().O00000o0(i2);
                return;
            case 4:
                if (i2 > 0) {
                    this.O0000o.setText(String.valueOf(i2));
                    this.O0000o.setVisibility(0);
                    return;
                }
                this.O0000o.setVisibility(8);
                O0000OOo().O00000o(i2);
                return;
            default:
                return;
        }
    }

    public static native void O000000o(Activity activity);

    private native View O0000o();

    private native void O0000o0o();

    public native int O000000o();

    public native void O000000o(int i, int i2, int i3, int i4);

    public native void O00000Oo();

    public native void O00000o();

    public native boolean O00000oO();

    /* Access modifiers changed, original: protected|declared_synchronized */
    /* renamed from: O0000O0o */
    public synchronized O000000o O0000OOo() {
        if (this.O00000o == null) {
            this.O00000o = new jf(this);
        }
        return (O000000o) this.O00000o;
    }

    public void g_() {
        this.O00000oO.notifyDataSetChanged();
    }

    public native void onActivityResult(int i, int i2, Intent intent);

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.message_comment_layout /*2131296817*/:
                CommentActivity.O000000o(this, O0000OOo().O00000Oo());
                O000000o(1, 0);
                return;
            case R.id.message_fans_layout /*2131296818*/:
                FansActivity.O000000o(this, O0000OOo().O00000oO());
                O000000o(4, 0);
                return;
            case R.id.message_like_layout /*2131296837*/:
                LikeActivity.O000000o(this, O0000OOo().O00000o0());
                O000000o(2, 0);
                return;
            case R.id.message_notice_layout /*2131296838*/:
                NoticeActivity.O000000o(this, O0000OOo().O00000o());
                O000000o(3, 0);
                return;
            default:
                return;
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O0000o0o();
    }

    public native void onDestroy();
}
