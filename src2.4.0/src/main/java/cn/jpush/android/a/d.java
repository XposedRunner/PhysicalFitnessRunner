package cn.jpush.android.a;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JActionExtra;
import cn.jpush.android.a;

public class d extends JActionExtra {
    public Object beforLogin(Context context, int i, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        if ("platformtype".equals(str)) {
            if (i >= 16) {
                return Byte.valueOf(cn.jpush.android.c.d.a().d(context));
            }
        } else if ("platformregid".equals(str)) {
            return cn.jpush.android.c.d.a().e(context);
        }
        return null;
    }

    public Object onSendData(Context context, long j, long j2, int i, int i2) {
        if (!a.a(context)) {
            return null;
        }
        if (i != 10) {
            if (i != 26) {
                switch (i) {
                    case 28:
                    case 29:
                        break;
                    default:
                        return null;
                }
            }
            g.a().a(context, j2, i2);
            return null;
        }
        f.a(context).a(j2, i2);
        return null;
    }
}
