package org.xutils.common.util;

import android.database.Cursor;
import android.text.TextUtils;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class IOUtil {
    private IOUtil() {
    }

    public static void closeQuietly(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Throwable th) {
                LogUtil.d(th.getMessage(), th);
            }
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                LogUtil.d(th.getMessage(), th);
            }
        }
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(outputStream instanceof BufferedOutputStream)) {
            outputStream = new BufferedOutputStream(outputStream);
        }
        byte[] bArr = new byte[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public static boolean deleteFileOrDir(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File deleteFileOrDir : listFiles) {
                deleteFileOrDir(deleteFileOrDir);
            }
        }
        return file.delete();
    }

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        Throwable th;
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        Closeable byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] toByteArray = byteArrayOutputStream.toByteArray();
                        closeQuietly(byteArrayOutputStream);
                        return toByteArray;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                closeQuietly(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            closeQuietly(byteArrayOutputStream);
            throw th;
        }
    }

    public static byte[] readBytes(InputStream inputStream, long j, int i) throws IOException {
        if (j > 0) {
            while (j > 0) {
                long skip = inputStream.skip(j);
                if (skip <= 0) {
                    break;
                }
                j -= skip;
            }
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) inputStream.read();
        }
        return bArr;
    }

    public static String readStr(InputStream inputStream) throws IOException {
        return readStr(inputStream, "UTF-8");
    }

    public static String readStr(InputStream inputStream, String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            str = "UTF-8";
        }
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArr = new char[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read < 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append(cArr, 0, read);
        }
    }

    public static void writeStr(OutputStream outputStream, String str) throws IOException {
        writeStr(outputStream, str, "UTF-8");
    }

    public static void writeStr(OutputStream outputStream, String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str2)) {
            str2 = "UTF-8";
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, str2);
        outputStreamWriter.write(str);
        outputStreamWriter.flush();
    }
}
