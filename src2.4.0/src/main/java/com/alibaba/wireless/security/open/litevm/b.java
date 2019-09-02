package com.alibaba.wireless.security.open.litevm;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import java.util.concurrent.atomic.AtomicBoolean;

class b {
    private ISecurityGuardPlugin a;
    private volatile long b;
    private AtomicBoolean c = new AtomicBoolean(false);
    private String d = "";
    private String e = "";

    private b(ISecurityGuardPlugin iSecurityGuardPlugin, long j, String str, String str2) {
        this.b = j;
        this.d = str;
        this.e = str2;
        this.a = iSecurityGuardPlugin;
        this.c.set(true);
    }

    static b a(ISecurityGuardPlugin iSecurityGuardPlugin, String str, String str2, byte[] bArr, Object[] objArr) {
        return new b(iSecurityGuardPlugin, ((Long) iSecurityGuardPlugin.getRouter().doCommand(12501, new Object[]{str, str2, bArr, objArr})).longValue(), str, str2);
    }

    private Long c() {
        return Long.valueOf(this.b);
    }

    /* Access modifiers changed, original: 0000 */
    public Object a(int i, LiteVMParameterWrapper[] liteVMParameterWrapperArr, int i2, int i3) throws SecException {
        if (a()) {
            int length = liteVMParameterWrapperArr != null ? liteVMParameterWrapperArr.length : 0;
            long longValue = c().longValue();
            return this.a.getRouter().doCommand(i3, new Object[]{Long.valueOf(longValue), Integer.valueOf(length), liteVMParameterWrapperArr, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        throw new SecException("LVM instance not valid", 2101);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(byte[] bArr) throws SecException {
        if (a()) {
            long longValue = c().longValue();
            this.a.getRouter().doCommand(12502, new Object[]{Long.valueOf(longValue), bArr});
            return;
        }
        throw new SecException("LVM instance not valid", 2101);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean a() {
        return this.c.get();
    }

    /* Access modifiers changed, original: 0000 */
    public void b() throws SecException {
        if (a()) {
            this.c.set(false);
            long longValue = c().longValue();
            this.a.getRouter().doCommand(12503, new Object[]{Long.valueOf(longValue)});
            return;
        }
        throw new SecException("LVM instance not valid", 2101);
    }
}
