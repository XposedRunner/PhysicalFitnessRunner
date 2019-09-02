package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.statistics.common.ULog;

/* compiled from: UMConfigureInternation */
public class a {
    private static boolean a;

    public static synchronized void a(final Context context) {
        synchronized (a.class) {
            if (context != null) {
                try {
                    if (!a) {
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName) && UMEnvelopeBuild.isReadyBuild(context, UMBusinessType.U_INTERNAL)) {
                                        UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.m, b.a(context).a(), null);
                                    }
                                } catch (Throwable unused) {
                                }
                            }
                        }).start();
                        a = true;
                    }
                } catch (Throwable th) {
                    String str = UMModuleRegister.INNER;
                    Object[] objArr = new Object[1];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("e is ");
                    stringBuilder.append(th.getMessage());
                    objArr[0] = stringBuilder.toString();
                    ULog.e(str, objArr);
                }
            }
        }
        return;
    }
}
