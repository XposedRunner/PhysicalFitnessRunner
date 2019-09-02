package com.qiyukf.unicorn.e;

import android.text.TextUtils;
import com.qiyukf.nim.uikit.b;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider.UserInfo;
import com.qiyukf.unicorn.d;

public final class l implements UserInfo {
    private String a;
    private String b;
    private String c;

    public l(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String getAccount() {
        return this.a;
    }

    public final String getAvatar() {
        String str;
        if (this.a.equals(b.b())) {
            str = null;
            if (d.e().uiCustomization != null) {
                str = d.e().uiCustomization.rightAvatar;
            }
            if (TextUtils.isEmpty(str)) {
                str = "selfDefault";
            }
            return str;
        }
        if (TextUtils.isEmpty(this.c)) {
            str = (d.e().uiCustomization == null || TextUtils.isEmpty(d.e().uiCustomization.leftAvatar)) ? "staffDefault" : d.e().uiCustomization.leftAvatar;
            this.c = str;
        }
        return this.c;
    }

    public final String getName() {
        return this.b;
    }
}
