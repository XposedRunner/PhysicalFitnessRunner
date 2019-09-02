package com.qiyukf.unicorn.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.qiyukf.nimlib.sdk.uinfo.UserInfoProvider;
import com.qiyukf.unicorn.api.pop.ShopInfo;
import com.qiyukf.unicorn.c.a;
import com.qiyukf.unicorn.d;
import java.util.HashMap;
import java.util.Map;

public final class i implements UserInfoProvider {
    private Map<String, ShopInfo> a = new HashMap();

    /* renamed from: a */
    public final ShopInfo getUserInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str = str.toLowerCase();
        ShopInfo shopInfo = (ShopInfo) this.a.get(str);
        if (shopInfo == null) {
            shopInfo = a.b(str);
            if (shopInfo != null) {
                this.a.put(str, shopInfo);
            }
        }
        return shopInfo;
    }

    public final void a(h hVar) {
        if (hVar != null && !TextUtils.isEmpty(hVar.getAccount())) {
            this.a.put(hVar.getAccount(), hVar);
            a.a(hVar);
        }
    }

    public final int getDefaultIconResId() {
        return d.c().getApplicationInfo().icon;
    }

    public final Bitmap getTeamIcon(String str) {
        return null;
    }
}
