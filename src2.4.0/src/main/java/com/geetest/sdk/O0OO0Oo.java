package com.geetest.sdk;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: GT3GzipUtil */
public final class O0OO0Oo {
    public static void O000000o(InputStream inputStream, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr, 0, 1024);
            if (read != -1) {
                gZIPOutputStream.write(bArr, 0, read);
            } else {
                gZIPOutputStream.finish();
                gZIPOutputStream.close();
                return;
            }
        }
    }
}
