package com.alibaba.wireless.security.open.opensdk;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import java.nio.ByteBuffer;

public class a implements IOpenSDKComponent {
    private ISecurityGuardPlugin a;

    public a(ISecurityGuardPlugin iSecurityGuardPlugin) {
        init(iSecurityGuardPlugin, new Object[0]);
    }

    private long a(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.put(bArr, 0, bArr.length);
        allocate.flip();
        return allocate.getLong();
    }

    private byte[] a(String str, String str2, String str3, byte[] bArr, String str4) {
        return (byte[]) this.a.getRouter().doCommand(11601, new Object[]{str, str2, str3, bArr, str4});
    }

    public Long analyzeOpenId(String str, String str2, String str3, byte[] bArr, String str4) throws SecException {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str3 == null || str2.length() == 0 || bArr == null || bArr.length == 0) {
            throw new SecException(1101);
        }
        byte[] a = a(str, str2, str3, bArr, str4);
        return (a == null || a.length > 8 || a.length <= 0) ? null : Long.valueOf(a(a));
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = iSecurityGuardPlugin;
        return 0;
    }
}
