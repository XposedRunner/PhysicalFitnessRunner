package com.amap.api.mapcore.util;

/* compiled from: FileCopy */
public class O00OoOO0 {

    /* compiled from: FileCopy */
    public interface O000000o {
        void O000000o(String str, String str2);

        void O000000o(String str, String str2, float f);

        void O000000o(String str, String str2, int i);

        void O00000Oo(String str, String str2);
    }

    private float O000000o(long j, long j2) {
        return (((float) j) / ((float) j2)) * 100.0f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:89:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0141  */
    public long O000000o(java.io.File r22, java.io.File r23, long r24, long r26, com.amap.api.mapcore.util.O00OoOO0.O000000o r28) {
        /*
        r21 = this;
        r1 = r22;
        r2 = r23;
        r11 = r26;
        r13 = r28;
        r5 = 0;
        r7 = (r24 > r5 ? 1 : (r24 == r5 ? 0 : -1));
        r14 = -1;
        if (r7 != 0) goto L_0x0019;
    L_0x000f:
        if (r13 == 0) goto L_0x0018;
    L_0x0011:
        r1 = "";
        r2 = "";
        r13.O000000o(r1, r2, r14);
    L_0x0018:
        return r5;
    L_0x0019:
        r15 = r22.getAbsolutePath();
        r10 = r23.getAbsolutePath();
        r7 = r22.isDirectory();	 Catch:{ Exception -> 0x0135 }
        r8 = 0;
        if (r7 == 0) goto L_0x00a6;
    L_0x0028:
        r5 = r23.exists();	 Catch:{ Exception -> 0x00a0 }
        if (r5 != 0) goto L_0x0058;
    L_0x002e:
        r5 = r23.mkdirs();	 Catch:{ Exception -> 0x004f }
        if (r5 != 0) goto L_0x0058;
    L_0x0034:
        r1 = new java.io.IOException;	 Catch:{ Exception -> 0x004f }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004f }
        r5.<init>();	 Catch:{ Exception -> 0x004f }
        r6 = "Cannot create dir ";
        r5.append(r6);	 Catch:{ Exception -> 0x004f }
        r2 = r23.getAbsolutePath();	 Catch:{ Exception -> 0x004f }
        r5.append(r2);	 Catch:{ Exception -> 0x004f }
        r2 = r5.toString();	 Catch:{ Exception -> 0x004f }
        r1.<init>(r2);	 Catch:{ Exception -> 0x004f }
        throw r1;	 Catch:{ Exception -> 0x004f }
    L_0x004f:
        r0 = move-exception;
        r6 = r21;
        r16 = r24;
        r1 = r0;
        r14 = r10;
        goto L_0x013c;
    L_0x0058:
        r9 = r22.list();	 Catch:{ Exception -> 0x00a0 }
        if (r9 == 0) goto L_0x009a;
    L_0x005e:
        r16 = r24;
    L_0x0060:
        r3 = r9.length;	 Catch:{ Exception -> 0x0094 }
        if (r8 >= r3) goto L_0x009c;
    L_0x0063:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x0094 }
        r3 = r9[r8];	 Catch:{ Exception -> 0x0094 }
        r4.<init>(r1, r3);	 Catch:{ Exception -> 0x0094 }
        r5 = new java.io.File;	 Catch:{ Exception -> 0x0094 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x0094 }
        r6 = r22.getName();	 Catch:{ Exception -> 0x0094 }
        r3.<init>(r2, r6);	 Catch:{ Exception -> 0x0094 }
        r6 = r9[r8];	 Catch:{ Exception -> 0x0094 }
        r5.<init>(r3, r6);	 Catch:{ Exception -> 0x0094 }
        r3 = r21;
        r6 = r16;
        r19 = r8;
        r18 = r9;
        r8 = r11;
        r14 = r10;
        r10 = r13;
        r3 = r3.O000000o(r4, r5, r6, r8, r10);	 Catch:{ Exception -> 0x0092 }
        r8 = r19 + 1;
        r16 = r3;
        r10 = r14;
        r9 = r18;
        r14 = -1;
        goto L_0x0060;
    L_0x0092:
        r0 = move-exception;
        goto L_0x0096;
    L_0x0094:
        r0 = move-exception;
        r14 = r10;
    L_0x0096:
        r6 = r21;
        goto L_0x013b;
    L_0x009a:
        r16 = r24;
    L_0x009c:
        r6 = r21;
        goto L_0x0145;
    L_0x00a0:
        r0 = move-exception;
        r14 = r10;
    L_0x00a2:
        r6 = r21;
        goto L_0x0139;
    L_0x00a6:
        r14 = r10;
        r7 = r23.getParentFile();	 Catch:{ Exception -> 0x0132 }
        if (r7 == 0) goto L_0x00d4;
    L_0x00ad:
        r9 = r7.exists();	 Catch:{ Exception -> 0x0132 }
        if (r9 != 0) goto L_0x00d4;
    L_0x00b3:
        r9 = r7.mkdirs();	 Catch:{ Exception -> 0x0132 }
        if (r9 != 0) goto L_0x00d4;
    L_0x00b9:
        r1 = new java.io.IOException;	 Catch:{ Exception -> 0x0132 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0132 }
        r2.<init>();	 Catch:{ Exception -> 0x0132 }
        r5 = "Cannot create dir ";
        r2.append(r5);	 Catch:{ Exception -> 0x0132 }
        r5 = r7.getAbsolutePath();	 Catch:{ Exception -> 0x0132 }
        r2.append(r5);	 Catch:{ Exception -> 0x0132 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0132 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0132 }
        throw r1;	 Catch:{ Exception -> 0x0132 }
    L_0x00d4:
        if (r13 == 0) goto L_0x00dd;
    L_0x00d6:
        r7 = (r24 > r5 ? 1 : (r24 == r5 ? 0 : -1));
        if (r7 > 0) goto L_0x00dd;
    L_0x00da:
        r13.O000000o(r15, r14);	 Catch:{ Exception -> 0x0132 }
    L_0x00dd:
        r5 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0132 }
        r5.<init>(r1);	 Catch:{ Exception -> 0x0132 }
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0132 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0132 }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];	 Catch:{ Exception -> 0x0132 }
        r3 = r24;
    L_0x00ed:
        r6 = r5.read(r2);	 Catch:{ Exception -> 0x012b }
        if (r6 <= 0) goto L_0x010e;
    L_0x00f3:
        r1.write(r2, r8, r6);	 Catch:{ Exception -> 0x012b }
        r6 = (long) r6;
        r9 = r3 + r6;
        if (r13 == 0) goto L_0x010a;
    L_0x00fb:
        r6 = r21;
        r3 = r6.O000000o(r9, r11);	 Catch:{ Exception -> 0x0105 }
        r13.O000000o(r15, r14, r3);	 Catch:{ Exception -> 0x0105 }
        goto L_0x010c;
    L_0x0105:
        r0 = move-exception;
        r1 = r0;
        r16 = r9;
        goto L_0x013c;
    L_0x010a:
        r6 = r21;
    L_0x010c:
        r3 = r9;
        goto L_0x00ed;
    L_0x010e:
        r6 = r21;
        r5.close();	 Catch:{ Exception -> 0x0129 }
        r1.flush();	 Catch:{ Exception -> 0x0129 }
        r1.close();	 Catch:{ Exception -> 0x0129 }
        if (r13 == 0) goto L_0x0126;
    L_0x011b:
        r1 = 1;
        r7 = r11 - r1;
        r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r1 < 0) goto L_0x0126;
    L_0x0123:
        r13.O00000Oo(r15, r14);	 Catch:{ Exception -> 0x0129 }
    L_0x0126:
        r16 = r3;
        goto L_0x0145;
    L_0x0129:
        r0 = move-exception;
        goto L_0x012e;
    L_0x012b:
        r0 = move-exception;
        r6 = r21;
    L_0x012e:
        r1 = r0;
        r16 = r3;
        goto L_0x013c;
    L_0x0132:
        r0 = move-exception;
        goto L_0x00a2;
    L_0x0135:
        r0 = move-exception;
        r6 = r21;
        r14 = r10;
    L_0x0139:
        r16 = r24;
    L_0x013b:
        r1 = r0;
    L_0x013c:
        r1.printStackTrace();
        if (r13 == 0) goto L_0x0145;
    L_0x0141:
        r1 = -1;
        r13.O000000o(r15, r14, r1);
    L_0x0145:
        return r16;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.O00OoOO0.O000000o(java.io.File, java.io.File, long, long, com.amap.api.mapcore.util.O00OoOO0$O000000o):long");
    }
}
