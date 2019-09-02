package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: DeflaterHelper */
public class b {
    public static int a;

    public static String a(byte[] bArr, String str) throws UnsupportedEncodingException, DataFormatException {
        bArr = b(bArr);
        return bArr != null ? new String(bArr, str) : null;
    }

    public static byte[] a(String str, String str2) throws IOException {
        return TextUtils.isEmpty(str) ? null : a(str.getBytes(str2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    public static byte[] a(byte[] r5) throws java.io.IOException {
        /*
        r0 = 0;
        if (r5 == 0) goto L_0x0048;
    L_0x0003:
        r1 = r5.length;
        if (r1 > 0) goto L_0x0007;
    L_0x0006:
        goto L_0x0048;
    L_0x0007:
        r1 = new java.util.zip.Deflater;
        r1.<init>();
        r1.setInput(r5);
        r1.finish();
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r5 = new byte[r5];
        r2 = 0;
        a = r2;
        r3 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0040 }
        r3.<init>();	 Catch:{ all -> 0x0040 }
    L_0x001e:
        r0 = r1.finished();	 Catch:{ all -> 0x003e }
        if (r0 != 0) goto L_0x0031;
    L_0x0024:
        r0 = r1.deflate(r5);	 Catch:{ all -> 0x003e }
        r4 = a;	 Catch:{ all -> 0x003e }
        r4 = r4 + r0;
        a = r4;	 Catch:{ all -> 0x003e }
        r3.write(r5, r2, r0);	 Catch:{ all -> 0x003e }
        goto L_0x001e;
    L_0x0031:
        r1.end();	 Catch:{ all -> 0x003e }
        if (r3 == 0) goto L_0x0039;
    L_0x0036:
        r3.close();
    L_0x0039:
        r5 = r3.toByteArray();
        return r5;
    L_0x003e:
        r5 = move-exception;
        goto L_0x0042;
    L_0x0040:
        r5 = move-exception;
        r3 = r0;
    L_0x0042:
        if (r3 == 0) goto L_0x0047;
    L_0x0044:
        r3.close();
    L_0x0047:
        throw r5;
    L_0x0048:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.common.b.a(byte[]):byte[]");
    }

    public static byte[] b(byte[] bArr) throws UnsupportedEncodingException, DataFormatException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Inflater inflater = new Inflater();
        int i = 0;
        inflater.setInput(bArr, 0, bArr.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
        while (!inflater.needsInput()) {
            int inflate = inflater.inflate(bArr2);
            byteArrayOutputStream.write(bArr2, i, inflate);
            i += inflate;
        }
        inflater.end();
        return byteArrayOutputStream.toByteArray();
    }
}
