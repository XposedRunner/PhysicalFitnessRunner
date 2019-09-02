package com.alibaba.wireless.security.open.dynamicdatastore;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import java.io.UnsupportedEncodingException;

public class a implements IDynamicDataStoreComponent {
    private ISecurityGuardPlugin a;

    public a(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    private int a(String str, String str2, String str3, boolean z) throws SecException {
        return ((Integer) this.a.getRouter().doCommand(10502, new Object[]{Integer.valueOf(5), str3, Boolean.valueOf(z), str, str2})).intValue();
    }

    private Object a(int i, String str, byte[] bArr, int i2) throws SecException {
        if (str == null || str.length() <= 0) {
            throw new SecException("", 501);
        } else if (i == 8 || i == 9 || i == 13 || i == 12) {
            return (Boolean) this.a.getRouter().doCommand(10503, new Object[]{Integer.valueOf(i), str, bArr, Integer.valueOf(i2)});
        } else if (i != 10 && i != 11) {
            return null;
        } else {
            byte[] bArr2 = (byte[]) this.a.getRouter().doCommand(10503, new Object[]{Integer.valueOf(i), str, bArr, Integer.valueOf(i2)});
            return i == 10 ? new String(bArr2) : bArr2;
        }
    }

    private String a(String str, String str2, boolean z) throws SecException {
        byte[] bArr = (byte[]) this.a.getRouter().doCommand(10502, new Object[]{Integer.valueOf(6), str2, Boolean.valueOf(z), str, null});
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    return new String(bArr, "UTF-8");
                }
            } catch (Exception unused) {
                throw new SecException("return invalid String result", 499);
            }
        }
        throw new SecException("return null byteResult", 499);
    }

    private void b(String str, String str2, boolean z) throws SecException {
        this.a.getRouter().doCommand(10502, new Object[]{Integer.valueOf(7), str2, Boolean.valueOf(z), str, null});
    }

    public boolean getBoolean(String str) throws SecException {
        str = a(str, "Z", false);
        if (str != null) {
            try {
                return "1".equals(str);
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public byte[] getByteArray(String str) throws SecException {
        str = a(str, "[B", false);
        if (str != null) {
            try {
                return com.alibaba.wireless.security.open.a.a.a(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public byte[] getByteArrayDDp(String str) throws SecException {
        str = a(str, "[B", true);
        if (str != null) {
            try {
                return com.alibaba.wireless.security.open.a.a.a(str);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public byte[] getByteArrayDDpEx(String str, int i) throws SecException {
        return (byte[]) a(11, str, null, i);
    }

    public float getFloat(String str) throws SecException {
        str = a(str, "F", false);
        if (str != null) {
            try {
                return Float.parseFloat(str);
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    public int getInt(String str) throws SecException {
        str = a(str, "I", false);
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public long getLong(String str) throws SecException {
        str = a(str, "J", false);
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (Throwable unused) {
            }
        }
        return -1;
    }

    public String getString(String str) throws SecException {
        return a(str, "LString", false);
    }

    public String getStringDDp(String str) throws SecException {
        return a(str, "LString", true);
    }

    public String getStringDDpEx(String str, int i) throws SecException {
        return (String) a(10, str, null, i);
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = iSecurityGuardPlugin;
        return 0;
    }

    public int putBoolean(String str, boolean z) throws SecException {
        return a(str, z ? "1" : "0", "Z", false);
    }

    public int putByteArray(String str, byte[] bArr) throws SecException {
        return a(str, com.alibaba.wireless.security.open.a.a.a(bArr), "[B", false);
    }

    public int putByteArrayDDp(String str, byte[] bArr) throws SecException {
        return a(str, com.alibaba.wireless.security.open.a.a.a(bArr), "[B", true);
    }

    public boolean putByteArrayDDpEx(String str, byte[] bArr, int i) throws SecException {
        return ((Boolean) a(9, str, bArr, i)).booleanValue();
    }

    public int putFloat(String str, float f) throws SecException {
        return a(str, Float.toString(f), "F", false);
    }

    public int putInt(String str, int i) throws SecException {
        return a(str, Integer.toString(i), "I", false);
    }

    public int putLong(String str, long j) throws SecException {
        return a(str, Long.toString(j), "J", false);
    }

    public int putString(String str, String str2) throws SecException {
        return a(str, str2, "LString", false);
    }

    public int putStringDDp(String str, String str2) throws SecException {
        return a(str, str2, "LString", true);
    }

    public boolean putStringDDpEx(String str, String str2, int i) throws SecException {
        if (str2 == null || str2.length() <= 0) {
            throw new SecException("", 501);
        }
        try {
            return ((Boolean) a(8, str, str2.getBytes("UTF-8"), i)).booleanValue();
        } catch (UnsupportedEncodingException unused) {
            throw new SecException("", 501);
        }
    }

    public void removeBoolean(String str) throws SecException {
        b(str, "Z", false);
    }

    public void removeByteArray(String str) throws SecException {
        b(str, "[B", false);
    }

    public void removeByteArrayDDp(String str) throws SecException {
        b(str, "[B", true);
    }

    public void removeByteArrayDDpEx(String str, int i) throws SecException {
        a(13, str, null, i);
    }

    public void removeFloat(String str) throws SecException {
        b(str, "F", false);
    }

    public void removeInt(String str) throws SecException {
        b(str, "I", false);
    }

    public void removeLong(String str) throws SecException {
        b(str, "J", false);
    }

    public void removeString(String str) throws SecException {
        b(str, "LString", false);
    }

    public void removeStringDDp(String str) throws SecException {
        b(str, "LString", true);
    }

    public void removeStringDDpEx(String str, int i) throws SecException {
        a(12, str, null, i);
    }
}
