package com.alibaba.wireless.security.open.staticdatastore;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;

public class a implements IStaticDataStoreComponent {
    private ISecurityGuardPlugin a = null;

    public a(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    public String getAppKeyByIndex(int i, String str) throws SecException {
        return (String) this.a.getRouter().doCommand(10602, new Object[]{Integer.valueOf(i), str});
    }

    public String getExtraData(String str, String str2) throws SecException {
        return (String) this.a.getRouter().doCommand(10603, new Object[]{str, str2});
    }

    public int getKeyType(String str, String str2) throws SecException {
        return ((Integer) this.a.getRouter().doCommand(10604, new Object[]{str, str2})).intValue();
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = iSecurityGuardPlugin;
        return 0;
    }
}
