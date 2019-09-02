package cn.jpush.android.a;

import android.content.Context;
import android.content.Intent;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JRequest;
import cn.jiguang.api.utils.OutputDataUtil;
import cn.jpush.a.c;
import cn.jpush.android.a;

public final class f {
    private static f b;
    private Context a = null;

    private f(Context context) {
        this.a = context;
    }

    public static synchronized f a(Context context) {
        f fVar;
        synchronized (f.class) {
            if (b == null) {
                b = new f(context);
            }
            fVar = b;
        }
        return fVar;
    }

    public final void a(long j, int i) {
        try {
            int a = o.a().a(j);
            Intent intent = new Intent();
            intent.addCategory(a.c);
            intent.setPackage(this.a.getPackageName());
            if (a == 0) {
                intent.setAction("cn.jpush.android.intent.TAG_ALIAS_TIMEOUT");
            } else {
                intent.setAction("cn.jpush.android.intent.RECEIVE_MESSAGE");
                if (a == 1) {
                    intent.putExtra("message_type", 1);
                } else {
                    intent.putExtra("message_type", 2);
                }
            }
            intent.putExtra("tagalias_errorcode", i);
            intent.putExtra("tagalias_seqid", j);
            this.a.sendBroadcast(intent);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("onTagaliasTimeout error:");
            stringBuilder.append(th.getMessage());
            cn.jpush.android.d.f.c("JPushRequestHelper", stringBuilder.toString());
        }
    }

    public final void a(JRequest jRequest, int i) {
        if (jRequest != null) {
            StringBuilder stringBuilder = new StringBuilder("Action - sendJPushRequest, timeout:");
            stringBuilder.append(20000);
            stringBuilder.append(", threadId:");
            stringBuilder.append(Thread.currentThread().getId());
            cn.jpush.android.d.f.a("JPushRequestHelper", stringBuilder.toString());
            Long rid = jRequest.getRid();
            int command = jRequest.getCommand();
            long uid = JCoreInterface.getUid();
            int sid = JCoreInterface.getSid();
            if (command != 10) {
                switch (command) {
                    case 28:
                    case 29:
                        break;
                    default:
                        return;
                }
            }
            long longValue = rid.longValue();
            String appKey = JCoreInterface.getAppKey();
            short version = (short) jRequest.getVersion();
            short command2 = (short) jRequest.getCommand();
            String a = ((c) jRequest).a();
            OutputDataUtil outputDataUtil = new OutputDataUtil(20480);
            outputDataUtil.writeU16(0);
            outputDataUtil.writeU8(version);
            outputDataUtil.writeU8(command2);
            outputDataUtil.writeU64(longValue);
            outputDataUtil.writeU32((long) sid);
            outputDataUtil.writeU64(uid);
            if (command2 == (short) 10) {
                outputDataUtil.writeByteArrayincludeLength(appKey.getBytes());
            }
            outputDataUtil.writeByteArrayincludeLength(a.getBytes());
            outputDataUtil.writeU16At(outputDataUtil.current(), 0);
            JCoreInterface.sendRequestData(this.a, a.a, 20000, outputDataUtil.toByteArray());
        }
    }
}
