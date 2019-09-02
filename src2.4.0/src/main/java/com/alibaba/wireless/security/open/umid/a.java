package com.alibaba.wireless.security.open.umid;

import com.alibaba.wireless.security.mainplugin.SecurityGuardMainPlugin;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.taobao.dp.DeviceSecuritySDKImpl;
import java.util.ArrayList;

public class a implements IUMIDComponent, IUMIDInitListenerEx {
    private static final Object d = new Object();
    private static SecurityGuardMainPlugin f;
    private volatile boolean a;
    private short b;
    private ArrayList<IUMIDInitListener> c;
    private DeviceSecuritySDKImpl e;

    public a(SecurityGuardMainPlugin securityGuardMainPlugin) {
        init(securityGuardMainPlugin, new Object[0]);
    }

    public static SecurityGuardMainPlugin a() {
        return f;
    }

    public static void a(SecurityGuardMainPlugin securityGuardMainPlugin) {
        f = securityGuardMainPlugin;
    }

    public void b() throws SecException {
        this.a = true;
        this.e.registerListener(this);
    }

    public String getSecurityToken() throws SecException {
        return this.e.getSecurityToken(0, false);
    }

    public String getSecurityToken(int i) throws SecException {
        if (i >= 0 && i <= 2) {
            return this.e.getSecurityToken(i, true);
        }
        throw new SecException(901);
    }

    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.a = false;
        this.b = (short) -1;
        this.c = new ArrayList();
        this.e = new DeviceSecuritySDKImpl(iSecurityGuardPlugin);
        return 0;
    }

    public void initUMID() throws SecException {
        this.e.init(null);
    }

    public void initUMID(int i, IUMIDInitListenerEx iUMIDInitListenerEx) throws SecException {
        this.e.initAsync(i, iUMIDInitListenerEx);
    }

    public void initUMID(String str, int i, String str2, IUMIDInitListenerEx iUMIDInitListenerEx) throws SecException {
        initUMID(i, iUMIDInitListenerEx);
    }

    public int initUMIDSync(int i) throws SecException {
        return this.e.initSync(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0026 A:{Catch:{ all -> 0x0015 }} */
    public void onUMIDInitFinishedEx(java.lang.String r3, int r4) {
        /*
        r2 = this;
        r4 = d;
        monitor-enter(r4);
        if (r3 == 0) goto L_0x0017;
    L_0x0005:
        r0 = r3.length();	 Catch:{ all -> 0x0015 }
        if (r0 <= 0) goto L_0x0017;
    L_0x000b:
        r0 = "000000000000000000000000";
        r3 = r0.equals(r3);	 Catch:{ all -> 0x0015 }
        if (r3 != 0) goto L_0x0017;
    L_0x0013:
        r3 = 1;
        goto L_0x0018;
    L_0x0015:
        r3 = move-exception;
        goto L_0x0034;
    L_0x0017:
        r3 = 0;
    L_0x0018:
        r2.b = r3;	 Catch:{ all -> 0x0015 }
        r0 = r2.c;	 Catch:{ all -> 0x0015 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0015 }
    L_0x0020:
        r1 = r0.hasNext();	 Catch:{ all -> 0x0015 }
        if (r1 == 0) goto L_0x0032;
    L_0x0026:
        r1 = r0.next();	 Catch:{ all -> 0x0015 }
        r1 = (com.alibaba.wireless.security.open.umid.IUMIDInitListener) r1;	 Catch:{ all -> 0x0015 }
        if (r1 == 0) goto L_0x0020;
    L_0x002e:
        r1.onUMIDInitFinished(r3);	 Catch:{ all -> 0x0015 }
        goto L_0x0020;
    L_0x0032:
        monitor-exit(r4);	 Catch:{ all -> 0x0015 }
        return;
    L_0x0034:
        monitor-exit(r4);	 Catch:{ all -> 0x0015 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.open.umid.a.onUMIDInitFinishedEx(java.lang.String, int):void");
    }

    /* JADX WARNING: Missing block: B:12:0x001c, code skipped:
            return;
     */
    /* JADX WARNING: Missing block: B:14:0x001e, code skipped:
            if (r4 == null) goto L_0x002a;
     */
    /* JADX WARNING: Missing block: B:15:0x0020, code skipped:
            r1 = true;
     */
    /* JADX WARNING: Missing block: B:16:0x0023, code skipped:
            if (r3.b != (short) 1) goto L_0x0026;
     */
    /* JADX WARNING: Missing block: B:17:0x0026, code skipped:
            r1 = false;
     */
    /* JADX WARNING: Missing block: B:18:0x0027, code skipped:
            r4.onUMIDInitFinished(r1);
     */
    /* JADX WARNING: Missing block: B:19:0x002a, code skipped:
            return;
     */
    public void registerInitListener(com.alibaba.wireless.security.open.umid.IUMIDInitListener r4) throws com.alibaba.wireless.security.open.SecException {
        /*
        r3 = this;
        r0 = r3.a;
        if (r0 != 0) goto L_0x000c;
    L_0x0004:
        r4 = new com.alibaba.wireless.security.open.SecException;
        r0 = 907; // 0x38b float:1.271E-42 double:4.48E-321;
        r4.<init>(r0);
        throw r4;
    L_0x000c:
        r0 = d;
        monitor-enter(r0);
        r1 = r3.b;	 Catch:{ all -> 0x002b }
        r2 = -1;
        if (r1 != r2) goto L_0x001d;
    L_0x0014:
        if (r4 == 0) goto L_0x001b;
    L_0x0016:
        r1 = r3.c;	 Catch:{ all -> 0x002b }
        r1.add(r4);	 Catch:{ all -> 0x002b }
    L_0x001b:
        monitor-exit(r0);	 Catch:{ all -> 0x002b }
        return;
    L_0x001d:
        monitor-exit(r0);	 Catch:{ all -> 0x002b }
        if (r4 == 0) goto L_0x002a;
    L_0x0020:
        r0 = r3.b;
        r1 = 1;
        if (r0 != r1) goto L_0x0026;
    L_0x0025:
        goto L_0x0027;
    L_0x0026:
        r1 = 0;
    L_0x0027:
        r4.onUMIDInitFinished(r1);
    L_0x002a:
        return;
    L_0x002b:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x002b }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.open.umid.a.registerInitListener(com.alibaba.wireless.security.open.umid.IUMIDInitListener):void");
    }

    public void setEnvironment(int i) throws SecException {
        this.e.setEnvironment(i);
    }

    public void setOnlineHost(String str) throws SecException {
        try {
            this.e.setOnlineHost(str);
        } catch (IllegalArgumentException unused) {
            throw new SecException(901);
        }
    }
}
