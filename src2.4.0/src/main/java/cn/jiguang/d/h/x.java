package cn.jiguang.d.h;

import cn.jiguang.g.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public final class x {
    public static byte[] a(byte[] bArr) {
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
        Closeable gZIPOutputStream;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                f.a(byteArrayOutputStream);
                f.a(gZIPOutputStream);
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                f.a(byteArrayOutputStream);
                f.a(gZIPOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
            f.a(byteArrayOutputStream);
            f.a(gZIPOutputStream);
            throw th;
        }
    }

    public static byte[] b(byte[] bArr) {
        Throwable th;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
        Closeable byteArrayInputStream = new ByteArrayInputStream(bArr);
        Closeable gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                bArr = new byte[256];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read >= 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        bArr = byteArrayOutputStream.toByteArray();
                        f.a(byteArrayOutputStream);
                        f.a(byteArrayInputStream);
                        f.a(gZIPInputStream);
                        return bArr;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                f.a(byteArrayOutputStream);
                f.a(byteArrayInputStream);
                f.a(gZIPInputStream);
                throw th;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            gZIPInputStream = null;
            th = th4;
            f.a(byteArrayOutputStream);
            f.a(byteArrayInputStream);
            f.a(gZIPInputStream);
            throw th;
        }
    }
}
