package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
public final class a {
    private static final k a = new k(101010256);
    private static final l b = new l(38651);

    /* compiled from: ProGuard */
    private static class a {
        Properties a;
        byte[] b;

        private a() {
            this.a = new Properties();
        }

        /* Access modifiers changed, original: 0000 */
        public void a(byte[] bArr) throws IOException {
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                int length = a.b.a().length;
                byte[] bArr2 = new byte[length];
                wrap.get(bArr2);
                if (!a.b.equals(new l(bArr2))) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("unknow protocl [");
                    stringBuilder.append(Arrays.toString(bArr));
                    stringBuilder.append("]");
                    throw new ProtocolException(stringBuilder.toString());
                } else if (bArr.length - length > 2) {
                    byte[] bArr3 = new byte[2];
                    wrap.get(bArr3);
                    int b = new l(bArr3).b();
                    if ((bArr.length - length) - 2 >= b) {
                        byte[] bArr4 = new byte[b];
                        wrap.get(bArr4);
                        this.a.load(new ByteArrayInputStream(bArr4));
                        int length2 = ((bArr.length - length) - b) - 2;
                        if (length2 > 0) {
                            this.b = new byte[length2];
                            wrap.get(this.b);
                        }
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ApkExternalInfo [p=");
            stringBuilder.append(this.a);
            stringBuilder.append(", otherData=");
            stringBuilder.append(Arrays.toString(this.b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e  */
    public static java.lang.String a(java.io.File r3, java.lang.String r4) throws java.io.IOException {
        /*
        r0 = 0;
        r1 = new java.io.RandomAccessFile;	 Catch:{ all -> 0x002a }
        r2 = "r";
        r1.<init>(r3, r2);	 Catch:{ all -> 0x002a }
        r3 = a(r1);	 Catch:{ all -> 0x0028 }
        if (r3 != 0) goto L_0x0014;
    L_0x000e:
        if (r1 == 0) goto L_0x0013;
    L_0x0010:
        r1.close();
    L_0x0013:
        return r0;
    L_0x0014:
        r2 = new com.tencent.open.utils.a$a;	 Catch:{ all -> 0x0028 }
        r2.<init>();	 Catch:{ all -> 0x0028 }
        r2.a(r3);	 Catch:{ all -> 0x0028 }
        r3 = r2.a;	 Catch:{ all -> 0x0028 }
        r3 = r3.getProperty(r4);	 Catch:{ all -> 0x0028 }
        if (r1 == 0) goto L_0x0027;
    L_0x0024:
        r1.close();
    L_0x0027:
        return r3;
    L_0x0028:
        r3 = move-exception;
        goto L_0x002c;
    L_0x002a:
        r3 = move-exception;
        r1 = r0;
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.close();
    L_0x0031:
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.a.a(java.io.File, java.lang.String):java.lang.String");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        int i;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a = a.a();
        byte read = randomAccessFile.read();
        while (true) {
            i = 1;
            if (read != (byte) -1) {
                if (read == a[0] && randomAccessFile.read() == a[1] && randomAccessFile.read() == a[2] && randomAccessFile.read() == a[3]) {
                    break;
                }
                long j = length - 1;
                randomAccessFile.seek(j);
                read = randomAccessFile.read();
                length = j;
            } else {
                i = 0;
                break;
            }
        }
        if (i == 0) {
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek((length + 16) + 4);
        a = new byte[2];
        randomAccessFile.readFully(a);
        int b = new l(a).b();
        if (b == 0) {
            return null;
        }
        a = new byte[b];
        randomAccessFile.read(a);
        return a;
    }
}
