package com.alibaba.wireless.security.open.dynamicdataencrypt;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;

public class a implements IDynamicDataEncryptComponent {
    private ISecurityGuardPlugin a = null;

    public a(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    private String a(int i, String str, boolean z) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("Input data string is empty", 401);
        }
        byte[] bArr = (byte[]) this.a.getRouter().doCommand(10501, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), str});
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    return new String(bArr, "UTF-8");
                }
            } catch (Exception unused) {
                throw new SecException("dynamic crypt return with invalid string data", 499);
            }
        }
        throw new SecException("dynamic crypt return with null data", 499);
    }

    private byte[] a(int i, byte[] bArr, boolean z) throws SecException {
        if (bArr == null || bArr.length <= 0) {
            throw new SecException("Input byte data is empty", 401);
        }
        String a = com.alibaba.wireless.security.open.a.a.a(bArr);
        return (byte[]) this.a.getRouter().doCommand(10501, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), a});
    }

    public String dynamicDecrypt(String str) throws SecException {
        return a(2, str, false);
    }

    public byte[] dynamicDecryptByteArray(byte[] bArr) throws SecException {
        if (bArr != null && bArr.length > 0) {
            return com.alibaba.wireless.security.open.a.a.a(a(2, new String(bArr), false));
        }
        throw new SecException(401);
    }

    public byte[] dynamicDecryptByteArrayDDp(byte[] bArr) throws SecException {
        if (bArr != null && bArr.length > 0) {
            return com.alibaba.wireless.security.open.a.a.a(a(4, new String(bArr), true));
        }
        throw new SecException(401);
    }

    public String dynamicDecryptDDp(String str) throws SecException {
        return a(4, str, true);
    }

    public String dynamicEncrypt(String str) throws SecException {
        return a(1, str, false);
    }

    public byte[] dynamicEncryptByteArray(byte[] bArr) throws SecException {
        return a(1, bArr, false);
    }

    public byte[] dynamicEncryptByteArrayDDp(byte[] bArr) throws SecException {
        return a(3, bArr, true);
    }

    public String dynamicEncryptDDp(String str) throws SecException {
        return a(3, str, true);
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = iSecurityGuardPlugin;
        return 0;
    }
}
