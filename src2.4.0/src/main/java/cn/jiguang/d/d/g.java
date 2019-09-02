package cn.jiguang.d.d;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.a.a.c.e;
import cn.jiguang.a.c.b;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JResponse;
import cn.jiguang.d.b.d;
import cn.jiguang.d.e.a.a.a;
import cn.jiguang.d.e.a.a.c;
import defpackage.O0000Oo0;
import java.nio.ByteBuffer;

public class g implements JAction {
    public long dispatchMessage(Context context, long j, int i, Object obj, ByteBuffer byteBuffer) {
        JResponse a = a.a((c) obj, byteBuffer);
        if (a != null) {
            if (a.code != 0) {
                StringBuilder stringBuilder = new StringBuilder("Received error response - code:");
                stringBuilder.append(a.code);
                cn.jiguang.e.c.c("JCoreAction", stringBuilder.toString());
            } else {
                int command = a.getCommand();
                if (command != 19) {
                    if (command != 30 && command != 32) {
                        switch (command) {
                            case 25:
                                cn.jiguang.a.c.a.a(context, d.a().b(), j, a);
                                break;
                            case 26:
                                if (a.code != 0) {
                                    f.a().a(context, a.getRid().longValue());
                                    break;
                                }
                                f.a().b(context, a.getRid().longValue());
                                break;
                        }
                    }
                    cn.jiguang.d.f.a.a().a(a.code, a.getCommand());
                } else {
                    d.a().a(a, j);
                }
            }
        }
        return a != null ? a.getHead().b().longValue() : -1;
    }

    public void dispatchTimeOutMessage(Context context, long j, long j2, int i) {
        if (i == 26) {
            f.a().c(context, j2);
            return;
        }
        if (i == 32 || i == 30) {
            cn.jiguang.d.f.a.a().a(context, i);
        }
    }

    public IBinder getBinderByType(String str) {
        return null;
    }

    public String getSdkVersion() {
        return O0000Oo0.O00000oo;
    }

    public void handleMessage(Context context, long j, Object obj) {
    }

    public boolean isSupportedCMD(int i) {
        boolean z = true;
        if (!(i == 0 || i == 1 || i == 19 || i == 25 || i == 26 || i == 30)) {
            if (i == 32) {
                return true;
            }
            z = false;
        }
        return z;
    }

    public void onActionRun(Context context, long j, Bundle bundle, Object obj) {
        String string;
        if (bundle != null) {
            string = bundle.getString("action");
            if (!TextUtils.isEmpty(string) && string.equals("asm")) {
                cn.jiguang.d.f.a.a().a(context, bundle);
                return;
            }
        }
        b.a();
        StringBuilder stringBuilder = new StringBuilder(" pkg:");
        stringBuilder.append(cn.jiguang.d.a.c);
        cn.jiguang.e.c.a("ARunAction", stringBuilder.toString());
        string = "ARunAction";
        stringBuilder = new StringBuilder("bundle:");
        stringBuilder.append(bundle);
        cn.jiguang.e.c.a(string, stringBuilder.toString() != null ? bundle.toString() : "");
        if (bundle != null) {
            if ("cn.jpush.android.intent.REPORT".equals(bundle.getString("action"))) {
                string = bundle.getString("report");
                bundle.getString("report.extra.info");
                e.a(context, string);
            }
        }
    }

    public void onEvent(Context context, long j, int i) {
    }
}
