package com.geetest.sdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: GT3LogUtils */
final class O0OOO0 extends Handler {
    final /* synthetic */ O000000o O000000o;

    O0OOO0(O000000o o000000o, Looper looper) {
        this.O000000o = o000000o;
        super(looper);
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (Thread.interrupted() || !OO0oO.O000000o()) {
            return;
        }
        if (message.what == 0) {
            O000000o o000000o = (O000000o) message.obj;
            SimpleDateFormat O000000o = this.O000000o.O00000o0;
            long j = o000000o.O000000o;
            String str = o000000o.O00000Oo;
            String str2 = o000000o.O00000o0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(O000000o.format(new Date(j)));
            stringBuilder.append(9);
            stringBuilder.append(str);
            stringBuilder.append(10);
            stringBuilder.append(str2);
            stringBuilder.append(10);
            O000000o.O000000o(stringBuilder.toString());
            return;
        }
        if (message.what == 1) {
            O000000o.O00000o0();
        }
    }
}
