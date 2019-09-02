package com.alibaba.wireless.security.open.datacollection;

import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.taobao.wireless.security.adapter.datacollection.b;

public class a implements IDataCollectionComponent {
    private b a;

    public a(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    public String getNick() {
        return this.a.a();
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = b.a(iSecurityGuardPlugin);
        return 0;
    }

    public boolean setNick(String str) {
        return this.a.a(str);
    }
}
