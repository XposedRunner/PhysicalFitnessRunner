package com.qiyukf.unicorn.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qiyukf.nim.uikit.b;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;
import com.qiyukf.unicorn.c.a;
import com.qiyukf.unicorn.d;
import java.util.HashMap;
import java.util.Map;

public final class j implements UserInfoProvider {
    private Map<String, l> a = new HashMap();

    public static String a(String str) {
        StringBuilder stringBuilder = new StringBuilder("QIYU_ROBOT");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static String b(String str) {
        StringBuilder stringBuilder = new StringBuilder("STAFF_GROUP");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public final void a(String str, String str2, String str3) {
        a(str, str2, str3, "");
    }

    public final void a(String str, String str2, String str3, String str4) {
        Map map;
        Object str5;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str5);
        stringBuilder.append(str4);
        l lVar = new l(stringBuilder.toString(), str2, str3);
        a.a(lVar);
        if (TextUtils.isEmpty(str4)) {
            map = this.a;
        } else {
            map = this.a;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str5);
            stringBuilder2.append(str4);
            str5 = stringBuilder2.toString();
        }
        map.put(str5, lVar);
    }

    public final int getDefaultIconResId() {
        return d.c().getApplicationInfo().icon;
    }

    public final Bitmap getTeamIcon(String str) {
        return null;
    }

    public final UserInfo getUserInfo(String str) {
        UserInfo userInfo = (l) this.a.get(str);
        if (userInfo == null) {
            if (TextUtils.equals(str, b.b())) {
                userInfo = new l(b.b(), "", "");
            } else {
                userInfo = a.a(str);
                if (userInfo == null) {
                    userInfo = new l(str, "", "");
                }
            }
            this.a.put(str, userInfo);
        }
        return userInfo;
    }
}
