package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.socialize.media.UMediaObject;
import com.umeng.socialize.utils.O0000O0o;
import com.umeng.socialize.utils.O0000OOo;
import com.umeng.socialize.utils.O0000o00.O0000Oo;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: SocialAnalytics */
/* renamed from: cq */
public final class cq {
    private static cr O000000o = new cr();
    private static ExecutorService O00000Oo = Executors.newCachedThreadPool();

    public static void O000000o(Context context, by byVar, String str) {
        cv.O000000o(context, byVar, str);
    }

    public static void O000000o(Context context, by byVar, String str, String str2, String str3) {
        cv.O00000Oo(context, byVar, str3, str, str2);
    }

    public static void O000000o(Context context, by byVar, String str, String str2, String str3, Map<String, String> map) {
        cv.O00000o0(context, byVar, str3, str, str2);
        if (map != null) {
            cv.O000000o(context, (Map) map, byVar, str3);
        }
    }

    public static void O000000o(Context context, by byVar, String str, boolean z, String str2) {
        cv.O000000o(context, z, byVar, str2);
    }

    public static void O000000o(Context context, by byVar, String str, boolean z, String str2, String str3, Map<String, String> map) {
        cv.O000000o(context, byVar, str3, str, str2);
        if (map != null) {
            cv.O000000o(context, (Map) map, z, byVar, str3);
        }
    }

    public static void O000000o(final Context context, final String str, final String str2, final UMediaObject uMediaObject) {
        cq.O000000o(new Runnable() {
            public void run() {
                co coVar = new co(context, str, str2);
                coVar.O000000o(uMediaObject);
                coVar.O000000o(1);
                cp cpVar = (cp) cq.O000000o.O000000o(coVar);
                if (cpVar == null || !cpVar.O00000o0()) {
                    O0000O0o.O00000o0(O0000Oo.O0000Ooo);
                } else {
                    O0000O0o.O00000o0(O0000Oo.O0000OoO);
                }
            }
        });
    }

    public static void O000000o(Context context, boolean z) {
        Bundle O00000o0 = dh.O00000o0();
        int i = ((O00000o0.getBoolean("isjump") ? cu.O000o00O : 0) | ((O00000o0.getBoolean("share") ? cu.O000o000 : 0) | (O00000o0.getBoolean("auth") ? 268435456 : 0))) | (dh.O00000o() ? cu.O000o00 : 0);
        String O00000oo = O0000OOo.O00000oo(context);
        Map hashMap = new HashMap();
        if (TextUtils.isEmpty(O00000oo)) {
            cv.O000000o(context, null, i);
            return;
        }
        String[] split = O00000oo.split(";");
        if (split.length == 2) {
            CharSequence charSequence = split[0];
            CharSequence charSequence2 = split[1];
            if (!TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2)) {
                hashMap.put(cu.O000OOo, split[1]);
                hashMap.put(cu.O000OOoO, split[0]);
                cv.O000000o(context, hashMap, i);
            }
        }
    }

    private static void O000000o(Runnable runnable) {
        if (O00000Oo != null && runnable != null) {
            O00000Oo.execute(runnable);
        }
    }
}
