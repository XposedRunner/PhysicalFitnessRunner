package com.alibaba.wireless.security.open.staticdataencrypt;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import java.io.UnsupportedEncodingException;

public class a implements IStaticDataEncryptComponent {
    private ISecurityGuardPlugin a = null;

    public a(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    private byte[] a(int i, int i2, int i3, String str, byte[] bArr, String str2) {
        return (byte[]) this.a.getRouter().doCommand(10601, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, bArr, str2});
    }

    private byte[] a(int i, String str, byte[] bArr, String str2) {
        return a(1, i, 0, str, bArr, str2);
    }

    private byte[] b(int i, String str, byte[] bArr, String str2) {
        return a(2, i, 0, str, bArr, str2);
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = iSecurityGuardPlugin;
        return 0;
    }

    public byte[] staticBinarySafeDecrypt(int i, String str, byte[] bArr, String str2) throws SecException {
        if (str != null && str.length() > 0 && i >= 3 && i < 19 && bArr != null && bArr.length > 0) {
            return a(2, i, 1, str, bArr, str2);
        }
        throw new SecException("", 301);
    }

    public byte[] staticBinarySafeDecryptNoB64(int i, String str, byte[] bArr, String str2) throws SecException {
        if (str != null && str.length() > 0 && i >= 3 && i < 19 && bArr != null && bArr.length > 0) {
            return b(i, str, bArr, str2);
        }
        throw new SecException("", 301);
    }

    public byte[] staticBinarySafeEncrypt(int i, String str, byte[] bArr, String str2) throws SecException {
        if (str != null && str.length() > 0 && i >= 3 && i < 19 && bArr != null && bArr.length > 0) {
            return a(1, i, 1, str, bArr, str2);
        }
        throw new SecException("", 301);
    }

    public byte[] staticBinarySafeEncryptNoB64(int i, String str, byte[] bArr, String str2) throws SecException {
        if (str != null && str.length() > 0 && i >= 3 && i < 19 && bArr != null && bArr.length > 0) {
            return a(i, str, bArr, str2);
        }
        throw new SecException("", 301);
    }

    public String staticSafeDecrypt(int i, String str, String str2, String str3) throws SecException {
        if (str == null || str.length() <= 0 || i < 3 || i >= 19 || str2 == null || str2.length() <= 0) {
            throw new SecException("", 301);
        }
        byte[] a = a(2, i, 1, str, str2.getBytes(), str3);
        if (a != null) {
            try {
                return new String(a, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }

    public String staticSafeEncrypt(int i, String str, String str2, String str3) throws SecException {
        if (str == null || str.length() <= 0 || i < 3 || i >= 19 || str2 == null || str2.length() <= 0) {
            throw new SecException("", 301);
        }
        byte[] a = a(1, i, 1, str, str2.getBytes(), str3);
        if (a != null) {
            try {
                return new String(a, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return null;
    }
}
