package com.zjwh.android_wh_physicalfitness.ui.music;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.zjwh.android_wh_physicalfitness.R;
import com.zjwh.android_wh_physicalfitness.activity.common.BaseRefreshLoadListActivity;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.LoadingFooter.O000000o;
import com.zjwh.android_wh_physicalfitness.common.recyclerview.more.O0000O0o;
import com.zjwh.android_wh_physicalfitness.entity.ResponseError;
import com.zjwh.android_wh_physicalfitness.entity.database.MusicHistoryBean;
import defpackage.gw;
import defpackage.kc;

public class MusicPlayHistoryActivity extends BaseRefreshLoadListActivity<MusicHistoryBean, gw<MusicHistoryBean>> {
    public static void O000000o(Activity activity) {
        activity.startActivity(new Intent(activity, MusicPlayHistoryActivity.class));
    }

    public int O000000o() {
        return R.layout.activity_music_play_history;
    }

    public void O000000o(ResponseError responseError) {
        if (!isFinishing()) {
            O0000O0o.O000000o(this, this.O00000o0, 20, O000000o.NetWorkError, new OnClickListener() {
                public void onClick(View view) {
                    O0000O0o.O000000o(MusicPlayHistoryActivity.this, MusicPlayHistoryActivity.this.O00000o0, 20, O000000o.Loading, null);
                    MusicPlayHistoryActivity.this.O0000OOo().O00000Oo(MusicPlayHistoryActivity.this.O0000o0);
                }
            });
        }
    }

    public void O00000Oo() {
        this.O0000Ooo.setText("播放历史");
    }

    /* Access modifiers changed, original: protected */
    public void O00000o() {
        super.O00000o();
        this.O00000Oo.setEnabled(false);
    }

    public void O00000oo() {
        super.O00000oo();
        this.O000000o.O000000o(ContextCompat.getDrawable(this.O0000o0, R.drawable.empty_music_history_icon), null, "暂无播放历史");
    }

    /* Access modifiers changed, original: protected */
    public gw<MusicHistoryBean> O0000OOo() {
        if (this.O00000o == null) {
            this.O00000o = new kc(this);
        }
        return this.O00000o;
    }
}
