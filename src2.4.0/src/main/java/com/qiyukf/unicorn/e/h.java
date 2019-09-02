package com.qiyukf.unicorn.e;

import com.qiyukf.basesdk.c.b;
import com.qiyukf.unicorn.api.pop.ShopInfo;
import org.json.JSONObject;

public final class h implements ShopInfo {
    private String a;
    private String b;
    private String c;

    public h(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final void a(String str) {
        JSONObject a = b.a(str);
        if (a != null) {
            this.a = b.e(a, "id");
            this.b = b.e(a, "name");
            this.c = b.e(a, "logo");
        }
    }

    public final String getAccount() {
        return this.a;
    }

    public final String getAvatar() {
        return this.c;
    }

    public final String getName() {
        return this.b;
    }
}
