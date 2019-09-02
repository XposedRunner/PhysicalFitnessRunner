package com.qiyukf.basesdk.b.a.b.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.baidu.mapapi.UIMsg.m_AppUI;
import com.qiyukf.basesdk.b.a.b.c.b;
import com.qiyukf.basesdk.b.a.b.c.e;
import com.qiyukf.basesdk.b.a.b.c.f;
import com.qiyukf.basesdk.b.a.b.e.c;
import java.io.File;
import java.net.HttpURLConnection;
import java.util.Map;
import org.json.JSONObject;

public class a {
    private static final String o = c.a(a.class);
    protected volatile HttpURLConnection a;
    protected volatile HttpURLConnection b;
    protected volatile boolean c = false;
    protected Context d;
    protected String e;
    protected String f;
    protected String g;
    protected File h;
    protected Object i;
    protected String j;
    protected boolean k;
    protected f l;
    protected long m;
    protected e n;
    private b p;

    public a(Context context, String str, String str2, String str3, File file, Object obj, String str4, f fVar) {
        this.d = context;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = file;
        this.i = obj;
        this.j = str4;
        this.k = true;
        this.n = new e();
        this.l = fVar;
    }

    private com.qiyukf.basesdk.b.a.b.c.a a(com.qiyukf.basesdk.b.a.b.c.a aVar) {
        if (this.c) {
            this.n.a(2);
            this.n.b((int) SecExceptionCode.SEC_ERROR_SIGNATRUE);
            com.qiyukf.basesdk.b.a.b.c.a aVar2 = new com.qiyukf.basesdk.b.a.b.c.a(this.i, this.j, SecExceptionCode.SEC_ERROR_SIGNATRUE, "", "", "uploading is cancelled", null);
            this.p.b();
            return aVar2;
        } else if (aVar.a() == 200 && aVar.b() == null) {
            this.n.a(0);
            this.p.a();
            return aVar;
        } else {
            this.n.a(1);
            this.p.a(aVar);
            String str = o;
            StringBuilder stringBuilder = new StringBuilder("upload error with code: ");
            stringBuilder.append(aVar.a());
            com.qiyukf.basesdk.a.a.e(str, stringBuilder.toString());
            return aVar;
        }
    }

    private com.qiyukf.basesdk.b.a.b.c.a a(String str, boolean z) {
        com.qiyukf.basesdk.a.a.d(o, "get lbs address");
        long currentTimeMillis = System.currentTimeMillis();
        com.qiyukf.basesdk.b.a.b.c.c a = a(com.qiyukf.basesdk.b.a.b.d.b.a(str), null);
        this.n.b(System.currentTimeMillis() - currentTimeMillis);
        if (a.a() == 200) {
            JSONObject b = a.b();
            this.n.b(b.getString("lbs"));
            String str2 = o;
            StringBuilder stringBuilder = new StringBuilder("LBS address result: ");
            stringBuilder.append(b.toString());
            com.qiyukf.basesdk.a.a.d(str2, stringBuilder.toString());
            com.qiyukf.basesdk.b.a.b.e.b.a(this.d, b);
            return null;
        }
        this.n.a();
        this.n.b();
        com.qiyukf.basesdk.b.a.b.c.a aVar = new com.qiyukf.basesdk.b.a.b.c.a(this.i, this.j, a.a(), c.a(a, "requestID"), c.a(a, "callbackRetMsg"), a.b().toString(), null);
        if (!z) {
            a(aVar);
        }
        return aVar;
    }

    private com.qiyukf.basesdk.b.a.b.c.c a(Context context, File file, long j, int i, String str, String str2, String str3, String str4, boolean z) {
        Throwable th;
        a aVar = this;
        long length = file.length();
        aVar.n.a(length);
        String str5 = o;
        StringBuilder stringBuilder = new StringBuilder("file length is: ");
        stringBuilder.append(length);
        com.qiyukf.basesdk.a.a.d(str5, stringBuilder.toString());
        aVar.j = str4;
        String str6 = str2;
        com.qiyukf.basesdk.b.a.b.c.c cVar;
        try {
            com.qiyukf.basesdk.b.a.b.e.a a = c.a(file, str6);
            long j2 = j;
            int i2 = i;
            cVar = null;
            Object obj = 1;
            Object obj2 = null;
            int i3 = 0;
            while (obj != null && (j2 < length || (j2 == 0 && length == 0))) {
                try {
                    if (aVar.c) {
                        break;
                    }
                    int i4;
                    long j3;
                    com.qiyukf.basesdk.b.a.b.e.a aVar2;
                    String str7;
                    Object obj3 = obj2;
                    long j4 = length - j2;
                    int min = (int) Math.min((long) i2, j4);
                    byte[] a2 = a.a(j2, min);
                    String str8 = o;
                    Object obj4 = obj;
                    int i5 = i2;
                    StringBuilder stringBuilder2 = new StringBuilder("upload block size is: ");
                    stringBuilder2.append(min);
                    com.qiyukf.basesdk.a.a.d(str8, stringBuilder2.toString());
                    String[] a3 = com.qiyukf.basesdk.b.a.b.e.b.a(context, z);
                    int length2 = a3.length;
                    com.qiyukf.basesdk.b.a.b.c.c cVar2 = cVar;
                    byte[] bArr = a2;
                    Object obj5 = obj4;
                    boolean z2 = false;
                    int i6 = 0;
                    obj4 = obj3;
                    int i7 = 0;
                    while (i6 < length2) {
                        int i8 = length2;
                        try {
                            str5 = a3[i6];
                            boolean z3 = z2;
                            String[] strArr = a3;
                            if (((long) min) + j2 >= length) {
                                com.qiyukf.basesdk.a.a.d(o, "upload block is the last block");
                                z3 = true;
                            }
                            aVar.n.c(str5);
                            String str9 = str5;
                            String[] strArr2 = strArr;
                            com.qiyukf.basesdk.b.a.b.e.a aVar3 = a;
                            int i9 = i6;
                            long j5 = j4;
                            String str10 = aVar.j;
                            long j6 = j2;
                            int i10 = min;
                            cVar = aVar.a(com.qiyukf.basesdk.b.a.b.d.b.a(str9, str, str6, str10, j2, z3), bArr);
                            if (aVar.c) {
                                return cVar;
                            }
                            i2 = cVar.a();
                            String str11;
                            long j7;
                            if (i2 == 200) {
                                j2 = (long) cVar.b().getInt("offset");
                                str5 = cVar.b().getString("context");
                                if (!str5.equals(aVar.j)) {
                                    aVar.p.a(str5);
                                }
                                aVar.j = str5;
                                aVar.p.a(j2, length);
                                length2 = i3 + 1;
                                str11 = o;
                                StringBuilder stringBuilder3 = new StringBuilder("http post success, offset: ");
                                stringBuilder3.append(j2);
                                stringBuilder3.append(", len: ");
                                stringBuilder3.append(length);
                                stringBuilder3.append(", this is ");
                                stringBuilder3.append(length2);
                                stringBuilder3.append(" block uploaded");
                                com.qiyukf.basesdk.a.a.d(str11, stringBuilder3.toString());
                                if (j2 == 0 && length == 0) {
                                    obj5 = null;
                                }
                                if (obj4 == null) {
                                    i2 = Math.min(i5 << 1, 1048576);
                                    i3 = length2;
                                    obj2 = obj4;
                                    obj = obj5;
                                    a = aVar3;
                                } else {
                                    i4 = i;
                                    j3 = length;
                                    i3 = length2;
                                    obj = obj5;
                                    aVar2 = aVar3;
                                    str7 = str3;
                                    a = aVar2;
                                    obj2 = obj4;
                                    i2 = i5;
                                    length = j3;
                                    aVar = this;
                                }
                            } else if (i2 == SecExceptionCode.SEC_ERROR_DYN_ENC_GET_SYS_PROPERTIES_FAILED) {
                                j7 = j6;
                                String str12 = o;
                                StringBuilder stringBuilder4 = new StringBuilder("token is expired, token: ");
                                stringBuilder4.append(str3);
                                stringBuilder4.append(", offset: ");
                                stringBuilder4.append(j7);
                                com.qiyukf.basesdk.a.a.e(str12, stringBuilder4.toString());
                                return cVar;
                            } else if (i2 != m_AppUI.MSG_PLACEFIELD_RELOAD) {
                                StringBuilder stringBuilder5;
                                int i11 = i7 + 1;
                                aVar.n.e(i11);
                                if (i11 >= strArr2.length) {
                                    str11 = o;
                                    stringBuilder5 = new StringBuilder("upload block failed with all tries, offset: ");
                                    j7 = j6;
                                    stringBuilder5.append(j7);
                                    com.qiyukf.basesdk.a.a.e(str11, stringBuilder5.toString());
                                    obj5 = null;
                                } else {
                                    j7 = j6;
                                }
                                str11 = o;
                                stringBuilder5 = new StringBuilder("http post failed: ");
                                stringBuilder5.append(i11);
                                com.qiyukf.basesdk.a.a.e(str11, stringBuilder5.toString());
                                if (obj4 == null) {
                                    i2 = Math.max(i5 / 2, i);
                                    j3 = length;
                                    int min2 = (int) Math.min((long) i2, j5);
                                    aVar2 = aVar3;
                                    i10 = min2;
                                    bArr = aVar2.a(j7, min2);
                                    i5 = i2;
                                    obj4 = 1;
                                } else {
                                    i4 = i;
                                    j3 = length;
                                    aVar2 = aVar3;
                                }
                                a3 = strArr2;
                                cVar2 = cVar;
                                i7 = i11;
                                j2 = j7;
                                j4 = j5;
                                length2 = i8;
                                min = i10;
                                z2 = z3;
                                i6 = i9 + 1;
                                a = aVar2;
                                length = j3;
                                aVar = this;
                            } else {
                                com.qiyukf.basesdk.a.a.e(o, "callback error.");
                                return cVar;
                            }
                        } catch (Exception e) {
                            th = e;
                            cVar = cVar2;
                            com.qiyukf.basesdk.a.a.b(o, "upload block exception", th);
                            return cVar;
                        }
                    }
                    i4 = i;
                    j3 = length;
                    aVar2 = a;
                    str7 = str3;
                    j2 = j2;
                    cVar = cVar2;
                    obj = obj5;
                    a = aVar2;
                    obj2 = obj4;
                    i2 = i5;
                    length = j3;
                    aVar = this;
                } catch (Exception e2) {
                    th = e2;
                    com.qiyukf.basesdk.a.a.b(o, "upload block exception", th);
                    return cVar;
                }
            }
            return cVar;
        } catch (Exception e22) {
            th = e22;
            cVar = null;
            com.qiyukf.basesdk.a.a.b(o, "upload block exception", th);
            return cVar;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    private com.qiyukf.basesdk.b.a.b.c.c a(android.content.Context r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, boolean r13) {
        /*
        r7 = this;
        r8 = com.qiyukf.basesdk.b.a.b.e.b.a(r8, r13);
        r13 = o;
        r0 = new java.lang.StringBuilder;
        r1 = "upload servers: ";
        r0.<init>(r1);
        r1 = java.util.Arrays.toString(r8);
        r0.append(r1);
        r0 = r0.toString();
        com.qiyukf.basesdk.a.a.d(r13, r0);
        r13 = new java.util.HashMap;
        r13.<init>();
        r0 = "x-nos-token";
        r13.put(r0, r12);
        r12 = 0;
        r0 = r8.length;	 Catch:{ Exception -> 0x0068 }
        r1 = 0;
        r2 = r12;
    L_0x0029:
        if (r1 >= r0) goto L_0x007f;
    L_0x002b:
        r3 = r8[r1];	 Catch:{ Exception -> 0x0066 }
        r3 = com.qiyukf.basesdk.b.a.b.d.b.a(r3, r9, r10, r11);	 Catch:{ Exception -> 0x0066 }
        r4 = o;	 Catch:{ Exception -> 0x0066 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0066 }
        r6 = "break query upload server url: ";
        r5.<init>(r6);	 Catch:{ Exception -> 0x0066 }
        r5.append(r3);	 Catch:{ Exception -> 0x0066 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0066 }
        com.qiyukf.basesdk.a.a.d(r4, r5);	 Catch:{ Exception -> 0x0066 }
        r3 = r7.b(r3, r13);	 Catch:{ Exception -> 0x0066 }
        r2 = r7.c;	 Catch:{ Exception -> 0x0063 }
        if (r2 == 0) goto L_0x004d;
    L_0x004c:
        return r3;
    L_0x004d:
        r2 = r3.a();	 Catch:{ Exception -> 0x0063 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 == r4) goto L_0x0062;
    L_0x0055:
        r2 = r3.a();	 Catch:{ Exception -> 0x0063 }
        r4 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        if (r2 != r4) goto L_0x005e;
    L_0x005d:
        return r3;
    L_0x005e:
        r1 = r1 + 1;
        r2 = r3;
        goto L_0x0029;
    L_0x0062:
        return r3;
    L_0x0063:
        r8 = move-exception;
        r2 = r3;
        goto L_0x006a;
    L_0x0066:
        r8 = move-exception;
        goto L_0x006a;
    L_0x0068:
        r8 = move-exception;
        r2 = r12;
    L_0x006a:
        r9 = o;
        r10 = "get break offset exception";
        com.qiyukf.basesdk.a.a.b(r9, r10, r8);
        if (r2 != 0) goto L_0x007f;
    L_0x0073:
        r2 = new com.qiyukf.basesdk.b.a.b.c.c;
        r8 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r9 = new org.json.JSONObject;
        r9.<init>();
        r2.<init>(r8, r9, r12);
    L_0x007f:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.b.a.b.a.a.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):com.qiyukf.basesdk.b.a.b.c.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064 A:{Splitter:B:1:0x0003, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:15:0x0064, code skipped:
            r7 = th;
     */
    /* JADX WARNING: Missing block: B:16:0x0065, code skipped:
            r8 = null;
     */
    /* JADX WARNING: Missing block: B:17:0x0067, code skipped:
            r7 = move-exception;
     */
    /* JADX WARNING: Missing block: B:18:0x0068, code skipped:
            r8 = null;
            r1 = r7;
            r7 = 799;
     */
    private com.qiyukf.basesdk.b.a.b.c.c a(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
        r6 = this;
        r0 = 0;
        r1 = 799; // 0x31f float:1.12E-42 double:3.95E-321;
        r2 = "NOS-QUERY";
        r7 = com.qiyukf.basesdk.b.a.c.b.b(r7, r2);	 Catch:{ Exception -> 0x0067, all -> 0x0064 }
        r6.b = r7;	 Catch:{ Exception -> 0x0067, all -> 0x0064 }
        r7 = r6.b;	 Catch:{ Exception -> 0x0067, all -> 0x0064 }
        com.qiyukf.basesdk.b.a.c.b.a(r7, r8);	 Catch:{ Exception -> 0x0067, all -> 0x0064 }
        r7 = r6.b;	 Catch:{ Exception -> 0x0067, all -> 0x0064 }
        r7 = r7.getResponseCode();	 Catch:{ Exception -> 0x0067, all -> 0x0064 }
        r8 = r6.b;	 Catch:{ Exception -> 0x0061, all -> 0x0064 }
        r8 = r8.getInputStream();	 Catch:{ Exception -> 0x0061, all -> 0x0064 }
        if (r8 == 0) goto L_0x0054;
    L_0x001e:
        r1 = com.qiyukf.basesdk.b.a.c.b.a(r8);	 Catch:{ Exception -> 0x0052 }
        r2 = o;	 Catch:{ Exception -> 0x0052 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0052 }
        r4 = "code: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x0052 }
        r3.append(r7);	 Catch:{ Exception -> 0x0052 }
        r4 = ", result: ";
        r3.append(r4);	 Catch:{ Exception -> 0x0052 }
        r3.append(r1);	 Catch:{ Exception -> 0x0052 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0052 }
        com.qiyukf.basesdk.a.a.d(r2, r3);	 Catch:{ Exception -> 0x0052 }
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0052 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0052 }
        r1 = new com.qiyukf.basesdk.b.a.b.c.c;	 Catch:{ Exception -> 0x0052 }
        r1.<init>(r7, r2, r0);	 Catch:{ Exception -> 0x0052 }
    L_0x0047:
        com.qiyukf.basesdk.b.a.c.b.a(r8);
        r7 = r6.b;
        r7.disconnect();
        r6.b = r0;
        return r1;
    L_0x0052:
        r1 = move-exception;
        goto L_0x006c;
    L_0x0054:
        r1 = new com.qiyukf.basesdk.b.a.b.c.c;	 Catch:{ Exception -> 0x0052 }
        r2 = 899; // 0x383 float:1.26E-42 double:4.44E-321;
        r3 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0052 }
        r3.<init>();	 Catch:{ Exception -> 0x0052 }
        r1.<init>(r2, r3, r0);	 Catch:{ Exception -> 0x0052 }
        goto L_0x0047;
    L_0x0061:
        r1 = move-exception;
        r8 = r0;
        goto L_0x006c;
    L_0x0064:
        r7 = move-exception;
        r8 = r0;
        goto L_0x0095;
    L_0x0067:
        r7 = move-exception;
        r8 = r0;
        r5 = r1;
        r1 = r7;
        r7 = r5;
    L_0x006c:
        r2 = o;	 Catch:{ all -> 0x0094 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0094 }
        r4 = "http get task exception, error code=";
        r3.<init>(r4);	 Catch:{ all -> 0x0094 }
        r3.append(r7);	 Catch:{ all -> 0x0094 }
        r3 = r3.toString();	 Catch:{ all -> 0x0094 }
        com.qiyukf.basesdk.a.a.b(r2, r3, r1);	 Catch:{ all -> 0x0094 }
        r2 = new com.qiyukf.basesdk.b.a.b.c.c;	 Catch:{ all -> 0x0094 }
        r3 = new org.json.JSONObject;	 Catch:{ all -> 0x0094 }
        r3.<init>();	 Catch:{ all -> 0x0094 }
        r2.<init>(r7, r3, r1);	 Catch:{ all -> 0x0094 }
        com.qiyukf.basesdk.b.a.c.b.a(r8);
        r7 = r6.b;
        r7.disconnect();
        r6.b = r0;
        return r2;
    L_0x0094:
        r7 = move-exception;
    L_0x0095:
        com.qiyukf.basesdk.b.a.c.b.a(r8);
        r8 = r6.b;
        r8.disconnect();
        r6.b = r0;
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.b.a.b.a.a.a(java.lang.String, java.util.Map):com.qiyukf.basesdk.b.a.b.c.c");
    }

    private com.qiyukf.basesdk.b.a.b.c.c a(String str, byte[] bArr) {
        com.qiyukf.basesdk.b.a.b.c.c b;
        Throwable e;
        int d = com.qiyukf.basesdk.b.a.b.a.c().d();
        String str2 = o;
        StringBuilder stringBuilder = new StringBuilder("user set the retry times is : ");
        stringBuilder.append(d);
        com.qiyukf.basesdk.a.a.d(str2, stringBuilder.toString());
        int i = 0;
        int i2 = -1;
        com.qiyukf.basesdk.b.a.b.c.c cVar = null;
        while (true) {
            int i3 = i + 1;
            if (i >= d) {
                break;
            }
            try {
                if (this.c) {
                    break;
                }
                str2 = o;
                StringBuilder stringBuilder2 = new StringBuilder("put block to server side with url: ");
                stringBuilder2.append(str);
                stringBuilder2.append(", length: ");
                stringBuilder2.append(bArr.length);
                stringBuilder2.append(", retryTime: ");
                stringBuilder2.append(i3);
                com.qiyukf.basesdk.a.a.d(str2, stringBuilder2.toString());
                b = b(str, bArr);
                try {
                    if (this.c) {
                        return b;
                    }
                    int a = b.a();
                    if (a == 200) {
                        String str3 = o;
                        stringBuilder2 = new StringBuilder("http post result is back, result:");
                        stringBuilder2.append(b.toString());
                        stringBuilder2.append(", retryTime: ");
                        stringBuilder2.append(i3);
                        com.qiyukf.basesdk.a.a.d(str3, stringBuilder2.toString());
                        JSONObject b2 = b.b();
                        if (b2 != null && b2.has("context") && b2.has("offset")) {
                            i2 = b.b().getInt("offset");
                            str3 = o;
                            stringBuilder2 = new StringBuilder("http post result success with context: ");
                            stringBuilder2.append(this.d);
                            stringBuilder2.append(", offset: ");
                            stringBuilder2.append(i2);
                            com.qiyukf.basesdk.a.a.d(str3, stringBuilder2.toString());
                        }
                    } else if (a == SecExceptionCode.SEC_ERROR_DYN_ENC_GET_SYS_PROPERTIES_FAILED || a == 500 || a == m_AppUI.MSG_PLACEFIELD_RELOAD) {
                        return b;
                    } else {
                        if (a == SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR) {
                            i2 = -4;
                        } else if (a == SecExceptionCode.SEC_ERROR_PKG_VALID_UNKNOWN_ERR) {
                            i2 = -5;
                        }
                    }
                    if (i2 > 0) {
                        str = o;
                        StringBuilder stringBuilder3 = new StringBuilder("retryPutFile with success result: ");
                        stringBuilder3.append(i2);
                        com.qiyukf.basesdk.a.a.d(str, stringBuilder3.toString());
                        return b;
                    }
                    this.n.c(this.n.c() + 1);
                    cVar = b;
                    i = i3;
                } catch (Exception e2) {
                    e = e2;
                    cVar = b;
                    com.qiyukf.basesdk.a.a.b(o, "put file exception", e);
                    return cVar;
                }
            } catch (Exception e3) {
                e = e3;
                com.qiyukf.basesdk.a.a.b(o, "put file exception", e);
                return cVar;
            }
        }
        return b;
    }

    private com.qiyukf.basesdk.b.a.b.c.c b(String str, Map<String, String> map) {
        int e = com.qiyukf.basesdk.b.a.b.a.c().e();
        int i = 0;
        com.qiyukf.basesdk.b.a.b.c.c cVar = null;
        while (true) {
            int i2 = i + 1;
            if (i >= e || this.c) {
                return cVar;
            }
            String str2 = o;
            StringBuilder stringBuilder = new StringBuilder("query offset with url: ");
            stringBuilder.append(str);
            stringBuilder.append(", retry times: ");
            stringBuilder.append(i2);
            com.qiyukf.basesdk.a.a.d(str2, stringBuilder.toString());
            cVar = a(str, (Map) map);
            if (cVar.a() == 200) {
                JSONObject b = cVar.b();
                String str3 = o;
                StringBuilder stringBuilder2 = new StringBuilder("get break offset result:");
                stringBuilder2.append(b.toString());
                com.qiyukf.basesdk.a.a.d(str3, stringBuilder2.toString());
                return cVar;
            }
            this.n.d(this.n.d() + 1);
            if (cVar.a() == 404) {
                com.qiyukf.basesdk.a.a.d(o, "upload file is expired in server side.");
                return cVar;
            }
            i = i2;
        }
        return cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0103 A:{Splitter:B:1:0x000a, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:35:0x00fd, code skipped:
            r10 = move-exception;
     */
    /* JADX WARNING: Missing block: B:36:0x00fe, code skipped:
            r2 = null;
            r7 = r10;
            r10 = r9;
            r9 = r7;
     */
    /* JADX WARNING: Missing block: B:37:0x0103, code skipped:
            r9 = th;
     */
    /* JADX WARNING: Missing block: B:38:0x0104, code skipped:
            r10 = null;
     */
    private com.qiyukf.basesdk.b.a.b.c.c b(java.lang.String r9, byte[] r10) {
        /*
        r8 = this;
        r0 = o;
        r1 = "http post task is executing";
        com.qiyukf.basesdk.a.a.d(r0, r1);
        r0 = 799; // 0x31f float:1.12E-42 double:3.95E-321;
        r1 = 0;
        r2 = "NOS-Upload";
        r9 = com.qiyukf.basesdk.b.a.c.b.a(r9, r2);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r8.a = r9;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r8.a;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r2 = r10.length;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.b.a.c.b.a(r9, r2);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r8.a;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r2 = "x-nos-token";
        r3 = r8.e;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.b.a.c.b.a(r9, r2, r3);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r8.l;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r9 == 0) goto L_0x009f;
    L_0x0025:
        r9 = r8.l;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r9.b();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r9 != 0) goto L_0x003e;
    L_0x0031:
        r9 = r8.a;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r2 = "Content-Type";
        r3 = r8.l;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r3 = r3.b();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.b.a.c.b.a(r9, r2, r3);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
    L_0x003e:
        r9 = r8.l;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r9.a();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r9 != 0) goto L_0x0057;
    L_0x004a:
        r9 = r8.a;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r2 = "Content-MD5";
        r3 = r8.l;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r3 = r3.a();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.b.a.c.b.a(r9, r2, r3);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
    L_0x0057:
        r9 = r8.l;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r9.c();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r9 == 0) goto L_0x009f;
    L_0x005f:
        r9 = r8.l;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r9.c();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r9.size();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r9 <= 0) goto L_0x009f;
    L_0x006b:
        r9 = r8.l;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r9.c();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r2 = r9.keySet();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
    L_0x0079:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        if (r3 == 0) goto L_0x009f;
    L_0x007f:
        r3 = r2.next();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r4 = r8.a;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r6 = "x-nos-meta-";
        r5.<init>(r6);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r5.append(r3);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r3 = r9.get(r3);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.b.a.c.b.a(r4, r5, r3);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        goto L_0x0079;
    L_0x009f:
        r9 = r8.a;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        com.qiyukf.basesdk.b.a.c.b.a(r9, r10);	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r8.a;	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r9 = r9.getResponseCode();	 Catch:{ Exception -> 0x0106, all -> 0x0103 }
        r10 = r8.a;	 Catch:{ Exception -> 0x00fd, all -> 0x0103 }
        r10 = r10.getInputStream();	 Catch:{ Exception -> 0x00fd, all -> 0x0103 }
        if (r10 == 0) goto L_0x00f2;
    L_0x00b2:
        r2 = com.qiyukf.basesdk.b.a.c.b.a(r10);	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r9 != r3) goto L_0x00ce;
    L_0x00ba:
        r3 = o;	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r5 = "http post response is correct, response: ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r4.append(r2);	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
    L_0x00ca:
        com.qiyukf.basesdk.a.a.d(r3, r4);	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        goto L_0x00df;
    L_0x00ce:
        r3 = o;	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r5 = "http post response is failed, status code: ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r4.append(r9);	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        goto L_0x00ca;
    L_0x00df:
        r3 = new com.qiyukf.basesdk.b.a.b.c.c;	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r4 = new org.json.JSONObject;	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r4.<init>(r2);	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r3.<init>(r9, r4, r1);	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        goto L_0x00f9;
    L_0x00ea:
        r9 = move-exception;
        goto L_0x0133;
    L_0x00ec:
        r2 = move-exception;
        r7 = r10;
        r10 = r9;
        r9 = r2;
        r2 = r7;
        goto L_0x0109;
    L_0x00f2:
        r3 = new com.qiyukf.basesdk.b.a.b.c.c;	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
        r2 = 899; // 0x383 float:1.26E-42 double:4.44E-321;
        r3.<init>(r2, r1, r1);	 Catch:{ Exception -> 0x00ec, all -> 0x00ea }
    L_0x00f9:
        com.qiyukf.basesdk.b.a.c.b.a(r10);
        goto L_0x0129;
    L_0x00fd:
        r10 = move-exception;
        r2 = r1;
        r7 = r10;
        r10 = r9;
        r9 = r7;
        goto L_0x0109;
    L_0x0103:
        r9 = move-exception;
        r10 = r1;
        goto L_0x0133;
    L_0x0106:
        r9 = move-exception;
        r10 = r0;
        r2 = r1;
    L_0x0109:
        r3 = o;	 Catch:{ all -> 0x0131 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0131 }
        r5 = "http post exception, status code=";
        r4.<init>(r5);	 Catch:{ all -> 0x0131 }
        r4.append(r10);	 Catch:{ all -> 0x0131 }
        r10 = r4.toString();	 Catch:{ all -> 0x0131 }
        com.qiyukf.basesdk.a.a.c(r3, r10, r9);	 Catch:{ all -> 0x0131 }
        r3 = new com.qiyukf.basesdk.b.a.b.c.c;	 Catch:{ all -> 0x0131 }
        r10 = new org.json.JSONObject;	 Catch:{ all -> 0x0131 }
        r10.<init>();	 Catch:{ all -> 0x0131 }
        r3.<init>(r0, r10, r9);	 Catch:{ all -> 0x0131 }
        com.qiyukf.basesdk.b.a.c.b.a(r2);
    L_0x0129:
        r9 = r8.a;
        r9.disconnect();
        r8.a = r1;
        return r3;
    L_0x0131:
        r9 = move-exception;
        r10 = r2;
    L_0x0133:
        com.qiyukf.basesdk.b.a.c.b.a(r10);
        r10 = r8.a;
        r10.disconnect();
        r8.a = r1;
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiyukf.basesdk.b.a.b.a.a.b(java.lang.String, byte[]):com.qiyukf.basesdk.b.a.b.c.c");
    }

    public final void a() {
        com.qiyukf.basesdk.a.a.d(o, "uploading is canceling");
        this.c = true;
        if (this.b != null) {
            this.b.disconnect();
        }
        if (this.a != null) {
            this.a.disconnect();
        }
    }

    public final void a(b bVar) {
        this.p = bVar;
    }

    public final com.qiyukf.basesdk.b.a.b.c.a b() {
        if (this.c) {
            return null;
        }
        try {
            this.n.d(c.a(this.d));
            this.n.a(c.a());
            boolean a = com.qiyukf.basesdk.b.a.b.e.b.a(this.d);
            String str = o;
            StringBuilder stringBuilder = new StringBuilder("lbs storage ");
            stringBuilder.append(a ? "valid" : "invalid");
            com.qiyukf.basesdk.a.a.d(str, stringBuilder.toString());
            String b = com.qiyukf.basesdk.b.a.b.e.b.b(this.d);
            com.qiyukf.basesdk.b.a.b.c.a a2 = !TextUtils.isEmpty(b) ? a(b, true) : null;
            if (TextUtils.isEmpty(b) || a2 != null) {
                a2 = a(com.qiyukf.basesdk.a.e(), false);
            }
            if (a2 != null) {
                return a2;
            }
            com.qiyukf.basesdk.b.a.b.c.c a3;
            if (TextUtils.isEmpty(this.l.a())) {
                this.l.a(com.qiyukf.basesdk.c.c.c.b(this.h.getPath()));
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (!(this.j == null || this.j.equals(""))) {
                a3 = a(this.d, this.f, this.g, this.j, this.e, this.k);
                if (a3.a() != 404) {
                    if (a3.a() != SecExceptionCode.SEC_ERROR_DYN_ENC) {
                        if (a3.a() != 200) {
                            return a(new com.qiyukf.basesdk.b.a.b.c.a(this.i, this.j, a3.a(), c.a(a3, "requestID"), c.a(a3, "callbackRetMsg"), a3.b().toString(), null));
                        }
                        this.m = (long) a3.b().getInt("offset");
                    }
                }
                this.j = null;
            }
            if ((this.m < this.h.length() || this.h.length() == 0) && this.m >= 0) {
                Context context = this.d;
                File file = this.h;
                long j = this.m;
                com.qiyukf.basesdk.b.a.b.a.c();
                a3 = a(context, file, j, com.qiyukf.basesdk.b.a.b.d.a.c(), this.f, this.g, this.e, this.j, this.k);
                if (a3 == null) {
                    a3 = new com.qiyukf.basesdk.b.a.b.c.c(500, new JSONObject(), null);
                }
                this.n.c(System.currentTimeMillis() - currentTimeMillis);
                this.n.b(a3.a());
                return a(new com.qiyukf.basesdk.b.a.b.c.a(this.i, this.j, a3.a(), c.a(a3, "requestID"), c.a(a3, "callbackRetMsg"), a3.b().toString(), null));
            }
            StringBuilder stringBuilder2 = new StringBuilder("offset is invalid in server side, with offset: ");
            stringBuilder2.append(this.m);
            stringBuilder2.append(", file length: ");
            stringBuilder2.append(this.h.length());
            com.qiyukf.basesdk.b.a.b.c.a aVar = new com.qiyukf.basesdk.b.a.b.c.a(this.i, this.j, SecExceptionCode.SEC_ERROR_SIGNATRUE_UNKNOWN, "", "", null, new com.qiyukf.basesdk.b.a.b.b.a(stringBuilder2.toString()));
            a(aVar);
            return aVar;
        } catch (Exception e) {
            Throwable th = e;
            com.qiyukf.basesdk.a.a.b(o, "offset result exception", th);
            com.qiyukf.basesdk.b.a.b.c.a aVar2 = new com.qiyukf.basesdk.b.a.b.c.a(this.i, this.j, SecExceptionCode.SEC_ERROR_STA_KEY_ENC_UNKNOWN_ERROR, "", "", null, th);
            a(aVar2);
            return aVar2;
        }
    }
}
