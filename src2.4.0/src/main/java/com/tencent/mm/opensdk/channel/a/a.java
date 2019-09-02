package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class a {

    public static class a {
        public String a;
        public String action;
        public long b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, a aVar) {
        String str;
        String str2;
        if (context == null) {
            str = "MicroMsg.SDK.MMessage";
            str2 = "send fail, invalid argument";
        } else if (d.a(aVar.action)) {
            str = "MicroMsg.SDK.MMessage";
            str2 = "send fail, action is null";
        } else {
            String str3 = null;
            if (!d.a(aVar.a)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(aVar.a);
                stringBuilder.append(".permission.MM_MESSAGE");
                str3 = stringBuilder.toString();
            }
            Intent intent = new Intent(aVar.action);
            if (aVar.bundle != null) {
                intent.putExtras(aVar.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 620823552);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.b);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(aVar.content, 620823552, packageName));
            context.sendBroadcast(intent, str3);
            StringBuilder stringBuilder2 = new StringBuilder("send mm message, intent=");
            stringBuilder2.append(intent);
            stringBuilder2.append(", perm=");
            stringBuilder2.append(str3);
            Log.d("MicroMsg.SDK.MMessage", stringBuilder2.toString());
            return true;
        }
        Log.e(str, str2);
        return false;
    }
}
