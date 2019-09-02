package com.qiyukf.nim.uikit.session.activity;

import android.widget.ImageView;
import android.widget.TextView;
import com.qiyukf.basesdk.c.d.f;
import com.qiyukf.unicorn.R;
import java.util.Date;

class CaptureVideoActivity$1 implements Runnable {
    final /* synthetic */ CaptureVideoActivity a;

    CaptureVideoActivity$1(CaptureVideoActivity captureVideoActivity) {
        this.a = captureVideoActivity;
    }

    public final void run() {
        CharSequence charSequence;
        int i;
        ImageView g;
        CaptureVideoActivity.a(this.a, new Date().getTime());
        CaptureVideoActivity.b(this.a, CaptureVideoActivity.a(this.a) - CaptureVideoActivity.b(this.a));
        int c = (int) (CaptureVideoActivity.c(this.a) / 1000);
        TextView d = CaptureVideoActivity.d(this.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c);
        stringBuilder.append("秒");
        d.setText(stringBuilder.toString());
        CaptureVideoActivity.e(this.a).setProgress(c);
        d = CaptureVideoActivity.f(this.a);
        if (c <= 0) {
            charSequence = "00:00";
        } else {
            i = c / 60;
            int i2;
            if (i < 60) {
                i2 = c % 60;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(f.a(i));
                stringBuilder2.append(":");
                stringBuilder2.append(f.a(i2));
                charSequence = stringBuilder2.toString();
            } else {
                int i3 = i / 60;
                if (i3 > 99) {
                    charSequence = "99:59:59";
                } else {
                    i %= 60;
                    i2 = (c - (i3 * 3600)) - (i * 60);
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(f.a(i3));
                    stringBuilder3.append(":");
                    stringBuilder3.append(f.a(i));
                    stringBuilder3.append(":");
                    stringBuilder3.append(f.a(i2));
                    charSequence = stringBuilder3.toString();
                }
            }
        }
        d.setText(charSequence);
        if (c % 2 == 0) {
            g = CaptureVideoActivity.g(this.a);
            i = R.drawable.ysf_record_start;
        } else {
            g = CaptureVideoActivity.g(this.a);
            i = R.drawable.ysf_record_video;
        }
        g.setBackgroundResource(i);
        if (c >= 30) {
            CaptureVideoActivity.e(this.a).setProgress(100);
            CaptureVideoActivity.d(this.a).setText("30秒");
            CaptureVideoActivity.h(this.a);
            return;
        }
        this.a.b.postDelayed(this, 1000);
    }
}
