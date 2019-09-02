package com.tencent.connect.common;

import android.os.Handler;
import android.os.Message;
import com.tencent.open.a.f;

/* compiled from: ProGuard */
class AssistActivity$1 extends Handler {
    final /* synthetic */ AssistActivity a;

    AssistActivity$1(AssistActivity assistActivity) {
        this.a = assistActivity;
    }

    public void handleMessage(Message message) {
        if (message.what == 0 && !this.a.isFinishing()) {
            f.d("openSDK_LOG.AssistActivity", "-->finish by timeout");
            this.a.finish();
        }
    }
}
