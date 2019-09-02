package com.alibaba.wireless.security.open.atlasencrypt;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import java.io.UnsupportedEncodingException;

public class a implements IAtlasEncryptComponent {
    private ISecurityGuardPlugin a;

    public a(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    private byte[] a(String str, String str2, String str3) {
        return (byte[]) this.a.getRouter().doCommand(11901, new Object[]{str, str2, str3});
    }

    public String atlasSafeEncrypt(String str, String str2) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("", 1001);
        }
        byte[] a = a("a", str, str2);
        if (a != null) {
            try {
                return new String(a, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = iSecurityGuardPlugin;
        return 0;
    }
}
