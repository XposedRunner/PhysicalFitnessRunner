package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.e.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;

public class ByteBufferUtils {
    public static final int ERROR_CODE = 10000;

    private static String a(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        StringBuilder stringBuilder = new StringBuilder();
        if (jResponse != null) {
            stringBuilder.append(jResponse.toString());
            StringBuilder stringBuilder2 = new StringBuilder("|bytebuffer:");
            stringBuilder2.append(byteBuffer == null ? "byteBuffer is null" : byteBuffer.toString());
            stringBuilder.append(stringBuilder2.toString());
        }
        StringBuilder stringBuilder3 = new StringBuilder("byteBuffer info:");
        stringBuilder3.append(stringBuilder.toString());
        c.d("ByteBufferUtils", stringBuilder3.toString());
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            stringBuilder3 = new StringBuilder("parse data error stackTrace:");
            stringBuilder3.append(stringWriter2);
            c.d("ByteBufferUtils", stringBuilder3.toString());
        } catch (Exception unused) {
        }
        return stringBuilder.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001f  */
    public static java.lang.Byte get(java.nio.ByteBuffer r1, cn.jiguang.api.JResponse r2) {
        /*
        r0 = r1.get();	 Catch:{ BufferUnderflowException -> 0x0015, BufferOverflowException -> 0x000f, Exception -> 0x0009 }
        r0 = java.lang.Byte.valueOf(r0);	 Catch:{ BufferUnderflowException -> 0x0015, BufferOverflowException -> 0x000f, Exception -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
        goto L_0x001a;
    L_0x000f:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
        goto L_0x001a;
    L_0x0015:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
    L_0x001a:
        a(r0, r2, r1);
        if (r2 == 0) goto L_0x0023;
    L_0x001f:
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r2.code = r1;
    L_0x0023:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.get(java.nio.ByteBuffer, cn.jiguang.api.JResponse):java.lang.Byte");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    public static java.nio.ByteBuffer get(java.nio.ByteBuffer r0, byte[] r1, cn.jiguang.api.JResponse r2) {
        /*
        r1 = r0.get(r1);	 Catch:{ BufferUnderflowException -> 0x0011, BufferOverflowException -> 0x000b, Exception -> 0x0005 }
        return r1;
    L_0x0005:
        r1 = move-exception;
        r1 = r1.fillInStackTrace();
        goto L_0x0016;
    L_0x000b:
        r1 = move-exception;
        r1 = r1.fillInStackTrace();
        goto L_0x0016;
    L_0x0011:
        r1 = move-exception;
        r1 = r1.fillInStackTrace();
    L_0x0016:
        a(r1, r2, r0);
        if (r2 == 0) goto L_0x001f;
    L_0x001b:
        r0 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r2.code = r0;
    L_0x001f:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.get(java.nio.ByteBuffer, byte[], cn.jiguang.api.JResponse):java.nio.ByteBuffer");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    public static int getInt(java.nio.ByteBuffer r1, cn.jiguang.api.JResponse r2) {
        /*
        r0 = r1.getInt();	 Catch:{ BufferUnderflowException -> 0x0011, BufferOverflowException -> 0x000b, Exception -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
        goto L_0x0016;
    L_0x000b:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
        goto L_0x0016;
    L_0x0011:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
    L_0x0016:
        a(r0, r2, r1);
        if (r2 == 0) goto L_0x001f;
    L_0x001b:
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r2.code = r1;
    L_0x001f:
        r1 = -1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.getInt(java.nio.ByteBuffer, cn.jiguang.api.JResponse):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    public static long getLong(java.nio.ByteBuffer r2, cn.jiguang.api.JResponse r3) {
        /*
        r0 = r2.getLong();	 Catch:{ BufferUnderflowException -> 0x0011, BufferOverflowException -> 0x000b, Exception -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
        goto L_0x0016;
    L_0x000b:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
        goto L_0x0016;
    L_0x0011:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
    L_0x0016:
        a(r0, r3, r2);
        if (r3 == 0) goto L_0x001f;
    L_0x001b:
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3.code = r2;
    L_0x001f:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.getLong(java.nio.ByteBuffer, cn.jiguang.api.JResponse):long");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001b  */
    public static short getShort(java.nio.ByteBuffer r1, cn.jiguang.api.JResponse r2) {
        /*
        r0 = r1.getShort();	 Catch:{ BufferUnderflowException -> 0x0011, BufferOverflowException -> 0x000b, Exception -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
        goto L_0x0016;
    L_0x000b:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
        goto L_0x0016;
    L_0x0011:
        r0 = move-exception;
        r0 = r0.fillInStackTrace();
    L_0x0016:
        a(r0, r2, r1);
        if (r2 == 0) goto L_0x001f;
    L_0x001b:
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r2.code = r1;
    L_0x001f:
        r1 = -1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.getShort(java.nio.ByteBuffer, cn.jiguang.api.JResponse):short");
    }
}
