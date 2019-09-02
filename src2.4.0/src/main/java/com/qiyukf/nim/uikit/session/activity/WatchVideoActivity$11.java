package com.qiyukf.nim.uikit.session.activity;

import com.qiyukf.nimlib.sdk.Observer;
import com.qiyukf.nimlib.sdk.msg.model.AttachmentProgress;
import com.qiyukf.unicorn.R;

class WatchVideoActivity$11 implements Observer<AttachmentProgress> {
    final /* synthetic */ WatchVideoActivity a;

    WatchVideoActivity$11(WatchVideoActivity watchVideoActivity) {
        this.a = watchVideoActivity;
    }

    public final /* synthetic */ void onEvent(Object obj) {
        long j;
        AttachmentProgress attachmentProgress = (AttachmentProgress) obj;
        long total = attachmentProgress.getTotal();
        long transferred = attachmentProgress.getTransferred();
        float f = ((float) transferred) / ((float) total);
        if (((double) f) > 1.0d) {
            f = 1.0f;
            j = total;
        } else {
            j = transferred;
        }
        if (((double) (f - WatchVideoActivity.l(this.a))) >= 0.1d) {
            WatchVideoActivity.a(this.a, f);
            WatchVideoActivity.a(this.a, this.a.getString(R.string.ysf_download_video), j, total);
            return;
        }
        if (((double) WatchVideoActivity.l(this.a)) == 0.0d) {
            WatchVideoActivity.a(this.a, f);
            WatchVideoActivity.a(this.a, this.a.getString(R.string.ysf_download_video), j, total);
        }
        if (((double) f) == 1.0d && ((double) WatchVideoActivity.l(this.a)) != 1.0d) {
            WatchVideoActivity.a(this.a, f);
            WatchVideoActivity.a(this.a, this.a.getString(R.string.ysf_download_video), j, total);
        }
    }
}
