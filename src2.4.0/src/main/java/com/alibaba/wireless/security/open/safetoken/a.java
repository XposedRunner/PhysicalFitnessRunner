package com.alibaba.wireless.security.open.safetoken;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import java.io.UnsupportedEncodingException;

public class a implements ISafeTokenComponent {
    private ISecurityGuardPlugin a;

    public a(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    private Object a(int i, String str, byte[] bArr, String str2, int i2) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("", 1601);
        } else if (i > 0 && i < 4) {
            return (Boolean) this.a.getRouter().doCommand(12101, new Object[]{Integer.valueOf(i), str, bArr, str2, Integer.valueOf(i2)});
        } else if (i <= 3 || i > 6) {
            return null;
        } else {
            byte[] bArr2 = (byte[]) this.a.getRouter().doCommand(12101, new Object[]{Integer.valueOf(i), str, bArr, str2, Integer.valueOf(i2)});
            return i == 6 ? new String(bArr2) : bArr2;
        }
    }

    public byte[] decryptWithToken(String str, byte[] bArr, int i) throws SecException {
        return (byte[]) a(5, str, bArr, null, i);
    }

    public byte[] encryptWithToken(String str, byte[] bArr, int i) throws SecException {
        return (byte[]) a(4, str, bArr, null, i);
    }

    public byte[] getOtp(String str, int i, String[] strArr, byte[][] bArr) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("", 1601);
        }
        return (byte[]) this.a.getRouter().doCommand(12102, new Object[]{str, Integer.valueOf(i), strArr, bArr, ""});
    }

    public byte[] getOtp(String str, int i, String[] strArr, byte[][] bArr, String str2) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("", 1601);
        }
        return (byte[]) this.a.getRouter().doCommand(12102, new Object[]{str, Integer.valueOf(i), strArr, bArr, str2});
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = iSecurityGuardPlugin;
        return 0;
    }

    public boolean isTokenExisted(String str) throws SecException {
        return ((Boolean) a(2, str, null, null, 0)).booleanValue();
    }

    public void removeToken(String str) throws SecException {
        a(3, str, null, null, 0);
    }

    public boolean saveToken(String str, String str2, String str3, int i) throws SecException {
        if (str2 == null || str2.length() <= 0) {
            throw new SecException("", 1601);
        }
        try {
            return ((Boolean) a(1, str, str2.getBytes("UTF-8"), str3, i)).booleanValue();
        } catch (UnsupportedEncodingException unused) {
            throw new SecException("", 1601);
        }
    }

    public String signWithToken(String str, byte[] bArr, int i) throws SecException {
        return (String) a(6, str, bArr, null, i);
    }
}
