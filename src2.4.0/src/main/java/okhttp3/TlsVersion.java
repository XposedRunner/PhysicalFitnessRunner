package okhttp3;

public enum TlsVersion {
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    final String javaName;

    private TlsVersion(String str) {
        this.javaName = str;
    }

    public static okhttp3.TlsVersion forJavaName(java.lang.String r3) {
        /*
        r0 = r3.hashCode();
        switch(r0) {
            case -503070503: goto L_0x0026;
            case -503070502: goto L_0x001c;
            case 79201641: goto L_0x0012;
            case 79923350: goto L_0x0008;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x0030;
    L_0x0008:
        r0 = "TLSv1";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0030;
    L_0x0010:
        r0 = 2;
        goto L_0x0031;
    L_0x0012:
        r0 = "SSLv3";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0030;
    L_0x001a:
        r0 = 3;
        goto L_0x0031;
    L_0x001c:
        r0 = "TLSv1.2";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0030;
    L_0x0024:
        r0 = 0;
        goto L_0x0031;
    L_0x0026:
        r0 = "TLSv1.1";
        r0 = r3.equals(r0);
        if (r0 == 0) goto L_0x0030;
    L_0x002e:
        r0 = 1;
        goto L_0x0031;
    L_0x0030:
        r0 = -1;
    L_0x0031:
        switch(r0) {
            case 0: goto L_0x0054;
            case 1: goto L_0x0051;
            case 2: goto L_0x004e;
            case 3: goto L_0x004b;
            default: goto L_0x0034;
        };
    L_0x0034:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Unexpected TLS version: ";
        r1.append(r2);
        r1.append(r3);
        r3 = r1.toString();
        r0.<init>(r3);
        throw r0;
    L_0x004b:
        r3 = SSL_3_0;
        return r3;
    L_0x004e:
        r3 = TLS_1_0;
        return r3;
    L_0x0051:
        r3 = TLS_1_1;
        return r3;
    L_0x0054:
        r3 = TLS_1_2;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.TlsVersion.forJavaName(java.lang.String):okhttp3.TlsVersion");
    }

    public String javaName() {
        return this.javaName;
    }
}
