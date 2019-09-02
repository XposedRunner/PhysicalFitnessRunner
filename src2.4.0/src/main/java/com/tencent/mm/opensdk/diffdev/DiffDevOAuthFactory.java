package com.tencent.mm.opensdk.diffdev;

import com.tencent.mm.opensdk.diffdev.a.a;
import com.tencent.mm.opensdk.utils.Log;

public class DiffDevOAuthFactory {
    public static final int MAX_SUPPORTED_VERSION = 1;
    private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
    public static final int VERSION_1 = 1;
    private static IDiffDevOAuth v1Instance;

    private DiffDevOAuthFactory() {
    }

    public static IDiffDevOAuth getDiffDevOAuth() {
        return getDiffDevOAuth(1);
    }

    public static IDiffDevOAuth getDiffDevOAuth(int i) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("getDiffDevOAuth, version = ");
        stringBuilder.append(i);
        Log.v(str, stringBuilder.toString());
        if (i > 1) {
            String str2 = TAG;
            StringBuilder stringBuilder2 = new StringBuilder("getDiffDevOAuth fail, unsupported version = ");
            stringBuilder2.append(i);
            Log.e(str2, stringBuilder2.toString());
            return null;
        } else if (i != 1) {
            return null;
        } else {
            if (v1Instance == null) {
                v1Instance = new a();
            }
            return v1Instance;
        }
    }
}
