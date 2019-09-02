package com.zjwh.android_wh_physicalfitness.activity.find;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseRefreshLoadListActivity;
import com.zjwh.android_wh_physicalfitness.entity.Eventbus.ArticleRefreshEvt;
import com.zjwh.android_wh_physicalfitness.entity.NewsBean;
import org.greenrobot.eventbus.O00000o0;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import s.h.e.l.l.C;

public class ArticleActivity extends BaseRefreshLoadListActivity<NewsBean, gv> {
    static {
        C.i(37);
    }

    public static native void O000000o(Activity activity);

    public native int O000000o();

    public native void O00000Oo();

    public native void O00000o();

    /* Access modifiers changed, original: protected|declared_synchronized */
    /* renamed from: O00000oO */
    public synchronized gv O0000OOo() {
        if (this.O00000o == null) {
            this.O00000o = new ir(this);
        }
        return (gv) this.O00000o;
    }

    public native void O00000oo();

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void handlerRefresh(ArticleRefreshEvt articleRefreshEvt) {
        if (articleRefreshEvt != null && articleRefreshEvt.isDataChanged()) {
            O0000OOo().O000000o();
        }
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        O00000o0.O000000o().O000000o(this);
    }

    public native void onDestroy();
}
