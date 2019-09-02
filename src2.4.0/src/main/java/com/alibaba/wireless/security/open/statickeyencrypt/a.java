package com.alibaba.wireless.security.open.statickeyencrypt;

import android.util.Base64;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.taobao.wireless.security.adapter.common.SPUtility2;

public class a implements IStaticKeyEncryptComponent {
    private ISecurityGuardPlugin a = null;

    public a(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    private int a(String str, byte[] bArr) throws SecException {
        if (str == null || str.length() <= 0 || bArr == null || bArr.length <= 0) {
            throw new SecException(701);
        }
        bArr = a(704, str.getBytes(), bArr);
        int i = 1;
        if (bArr != null && bArr.length > 0) {
            String readFromSPUnified = SPUtility2.readFromSPUnified("StaticKey", str, null);
            if (SPUtility2.saveToSPUnified("StaticKey", str, new String(bArr), true)) {
                if (readFromSPUnified != null && readFromSPUnified.length() > 0) {
                    return 2;
                }
                return i;
            }
        }
        i = 0;
        return i;
    }

    private byte[] a(int i, int i2, byte[] bArr, byte[] bArr2) {
        return (byte[]) this.a.getRouter().doCommand(10605, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), bArr, bArr2});
    }

    private byte[] a(int i, String str, String str2) throws SecException {
        str = SPUtility2.readFromSPUnified("StaticKey", str, null);
        str2 = SPUtility2.readFromSPUnified("StaticKey", str2, null);
        if (str == null || str.length() == 0) {
            throw new SecException(703);
        } else if (str2 == null || str2.length() == 0) {
            throw new SecException(703);
        } else {
            byte[] a = a(703, i, str.getBytes(), str2.getBytes());
            if (a != null && a.length > 0) {
                try {
                    return Base64.decode(a, 0);
                } catch (Exception unused) {
                    a = null;
                }
            }
            return a;
        }
    }

    private byte[] a(int i, String str, byte[] bArr) throws SecException {
        str = SPUtility2.readFromSPUnified("StaticKey", str, null);
        if (str == null || str.length() <= 0) {
            throw new SecException(703);
        }
        byte[] a = a(701, i, str.getBytes(), bArr);
        return (a == null || a.length <= 0) ? a : Base64.decode(a, 0);
    }

    private byte[] a(int i, byte[] bArr) {
        return (byte[]) this.a.getRouter().doCommand(10605, new Object[]{Integer.valueOf(i), bArr});
    }

    private byte[] a(int i, byte[] bArr, byte[] bArr2) {
        return (byte[]) this.a.getRouter().doCommand(10605, new Object[]{Integer.valueOf(i), bArr, bArr2});
    }

    private boolean b(String str) {
        str = SPUtility2.readFromSPUnified("StaticKey", str, null);
        return str != null && str.length() > 0;
    }

    private byte[] b(int i, String str, byte[] bArr) throws SecException {
        str = SPUtility2.readFromSPUnified("StaticKey", str, null);
        if (str == null || str.length() <= 0) {
            throw new SecException(703);
        }
        return a(702, i, str.getBytes(), Base64.encode(bArr, 2));
    }

    private int c(String str) {
        return SPUtility2.readFromSPUnified("StaticKey", str, null) == null ? 2 : SPUtility2.removeFromSPUnified("StaticKey", str, true);
    }

    public String a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String readFromSPUnified = SPUtility2.readFromSPUnified("StaticKey", str, null);
        if (readFromSPUnified == null || readFromSPUnified.length() <= 0) {
            return readFromSPUnified;
        }
        byte[] a = a(705, readFromSPUnified.getBytes());
        return (a == null || a.length <= 0) ? readFromSPUnified : Base64.encodeToString(a, 2);
    }

    public byte[] decrypt(int i, String str, byte[] bArr) throws SecException {
        if (str != null && str.length() > 0 && bArr != null && bArr.length > 0 && i >= 16 && i <= 18) {
            return b(i, str, bArr);
        }
        throw new SecException(701);
    }

    public byte[] encrypt(int i, String str, byte[] bArr) throws SecException {
        if (str != null && str.length() > 0 && bArr != null && bArr.length > 0 && i >= 16 && i <= 18) {
            return a(i, str, bArr);
        }
        throw new SecException(701);
    }

    public byte[] encryptSecretData(int i, String str, String str2) throws SecException {
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0 && i >= 16 && i <= 18) {
            return a(i, str, str2);
        }
        throw new SecException(701);
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = iSecurityGuardPlugin;
        return 0;
    }

    public boolean isSecretExist(String str) throws SecException {
        if (str != null && str.length() > 0) {
            return b(str);
        }
        throw new SecException(701);
    }

    public int removeSecret(String str) throws SecException {
        if (str != null && str.length() > 0) {
            return c(str);
        }
        throw new SecException(701);
    }

    public int saveSecret(String str, byte[] bArr) throws SecException {
        if (str != null && str.length() > 0 && bArr != null && bArr.length > 0) {
            return a(str, bArr);
        }
        throw new SecException(701);
    }
}
