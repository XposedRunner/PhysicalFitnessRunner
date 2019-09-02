package cn.jiguang.g;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class f {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static byte[] a(InputStream inputStream) {
        Throwable th;
        if (inputStream == null) {
            throw new IOException("InputStream is null");
        }
        Closeable byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] toByteArray = byteArrayOutputStream.toByteArray();
                        a(byteArrayOutputStream);
                        return toByteArray;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                a(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            a(byteArrayOutputStream);
            throw th;
        }
    }
}
