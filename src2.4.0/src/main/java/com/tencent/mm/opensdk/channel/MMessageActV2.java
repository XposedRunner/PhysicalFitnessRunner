package com.tencent.mm.opensdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public class MMessageActV2 {
    public static final String DEFAULT_ENTRY_CLASS_NAME = ".wxapi.WXEntryActivity";
    public static final String MM_ENTRY_PACKAGE_NAME = "com.tencent.mm";
    public static final String MM_MSG_ENTRY_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final String TAG = "MicroMsg.SDK.MMessageAct";

    public static class Args {
        public static final int INVALID_FLAGS = -1;
        public Bundle bundle;
        public String content;
        public int flags = -1;
        public String targetClassName;
        public String targetPkgName;

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("targetPkgName:");
            stringBuilder.append(this.targetPkgName);
            stringBuilder.append(", targetClassName:");
            stringBuilder.append(this.targetClassName);
            stringBuilder.append(", content:");
            stringBuilder.append(this.content);
            stringBuilder.append(", flags:");
            stringBuilder.append(this.flags);
            stringBuilder.append(", bundle:");
            stringBuilder.append(this.bundle);
            return stringBuilder.toString();
        }
    }

    public static boolean send(Context context, Args args) {
        String str;
        StringBuilder stringBuilder;
        if (context == null || args == null) {
            Log.e(TAG, "send fail, invalid argument");
            return false;
        } else if (d.a(args.targetPkgName)) {
            str = TAG;
            stringBuilder = new StringBuilder("send fail, invalid targetPkgName, targetPkgName = ");
            stringBuilder.append(args.targetPkgName);
            Log.e(str, stringBuilder.toString());
            return false;
        } else {
            if (d.a(args.targetClassName)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(args.targetPkgName);
                stringBuilder.append(DEFAULT_ENTRY_CLASS_NAME);
                args.targetClassName = stringBuilder.toString();
            }
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("send, targetPkgName = ");
            stringBuilder2.append(args.targetPkgName);
            stringBuilder2.append(", targetClassName = ");
            stringBuilder2.append(args.targetClassName);
            Log.d(str2, stringBuilder2.toString());
            Intent intent = new Intent();
            intent.setClassName(args.targetPkgName, args.targetClassName);
            if (args.bundle != null) {
                intent.putExtras(args.bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, 620823552);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, args.content);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(args.content, 620823552, packageName));
            if (args.flags == -1) {
                intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH).addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
            } else {
                intent.setFlags(args.flags);
            }
            try {
                context.startActivity(intent);
                str = TAG;
                StringBuilder stringBuilder3 = new StringBuilder("send mm message, intent=");
                stringBuilder3.append(intent);
                Log.d(str, stringBuilder3.toString());
                return true;
            } catch (Exception e) {
                String str3 = TAG;
                stringBuilder = new StringBuilder("send fail, ex = ");
                stringBuilder.append(e.getMessage());
                Log.e(str3, stringBuilder.toString());
                return false;
            }
        }
    }
}
