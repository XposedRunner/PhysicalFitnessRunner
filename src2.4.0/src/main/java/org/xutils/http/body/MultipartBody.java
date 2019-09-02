package org.xutils.http.body;

import android.text.TextUtils;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.IOUtil;
import org.xutils.common.util.KeyValue;
import org.xutils.http.ProgressHandler;

public class MultipartBody implements ProgressBody {
    private static byte[] BOUNDARY_PREFIX_BYTES = "--------7da3d81520810".getBytes();
    private static byte[] END_BYTES = "\r\n".getBytes();
    private static byte[] TWO_DASHES_BYTES = "--".getBytes();
    private byte[] boundaryPostfixBytes;
    private ProgressHandler callBackHandler;
    private String charset = "UTF-8";
    private String contentType;
    private long current = 0;
    private List<KeyValue> multipartParams;
    private long total = 0;

    private class CounterOutputStream extends OutputStream {
        final AtomicLong total = new AtomicLong(0);

        public void addFile(File file) {
            if (this.total.get() != -1) {
                this.total.addAndGet(file.length());
            }
        }

        public void addStream(InputStream inputStream) {
            if (this.total.get() != -1) {
                long inputStreamLength = InputStreamBody.getInputStreamLength(inputStream);
                if (inputStreamLength > 0) {
                    this.total.addAndGet(inputStreamLength);
                } else {
                    this.total.set(-1);
                }
            }
        }

        public void write(int i) throws IOException {
            if (this.total.get() != -1) {
                this.total.incrementAndGet();
            }
        }

        public void write(byte[] bArr) throws IOException {
            if (this.total.get() != -1) {
                this.total.addAndGet((long) bArr.length);
            }
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.total.get() != -1) {
                this.total.addAndGet((long) i2);
            }
        }
    }

    public MultipartBody(List<KeyValue> list, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.charset = str;
        }
        this.multipartParams = list;
        generateContentType();
        CounterOutputStream counterOutputStream = new CounterOutputStream();
        try {
            writeTo(counterOutputStream);
            this.total = counterOutputStream.total.get();
        } catch (IOException unused) {
            this.total = -1;
        }
    }

    private static byte[] buildContentDisposition(String str, String str2, String str3) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder("Content-Disposition: form-data");
        stringBuilder.append("; name=\"");
        stringBuilder.append(str.replace("\"", "\\\""));
        stringBuilder.append("\"");
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append("; filename=\"");
            stringBuilder.append(str2.replace("\"", "\\\""));
            stringBuilder.append("\"");
        }
        return stringBuilder.toString().getBytes(str3);
    }

    private static byte[] buildContentType(Object obj, String str, String str2) throws UnsupportedEncodingException {
        String replaceFirst;
        StringBuilder stringBuilder = new StringBuilder("Content-Type: ");
        if (!TextUtils.isEmpty(str)) {
            replaceFirst = str.replaceFirst("\\/jpg$", "/jpeg");
        } else if (obj instanceof String) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("text/plain; charset=");
            stringBuilder2.append(str2);
            replaceFirst = stringBuilder2.toString();
        } else {
            replaceFirst = "application/octet-stream";
        }
        stringBuilder.append(replaceFirst);
        return stringBuilder.toString().getBytes(str2);
    }

    private void generateContentType() {
        String toHexString = Double.toHexString(Math.random() * 65535.0d);
        this.boundaryPostfixBytes = toHexString.getBytes();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("multipart/form-data; boundary=");
        stringBuilder.append(new String(BOUNDARY_PREFIX_BYTES));
        stringBuilder.append(toHexString);
        this.contentType = stringBuilder.toString();
    }

    private void writeEntry(OutputStream outputStream, String str, Object obj) throws IOException {
        String contentType;
        writeLine(outputStream, TWO_DASHES_BYTES, BOUNDARY_PREFIX_BYTES, this.boundaryPostfixBytes);
        String str2 = "";
        if (obj instanceof BodyItemWrapper) {
            BodyItemWrapper bodyItemWrapper = (BodyItemWrapper) obj;
            Object value = bodyItemWrapper.getValue();
            String fileName = bodyItemWrapper.getFileName();
            contentType = bodyItemWrapper.getContentType();
            obj = value;
            str2 = fileName;
        } else {
            contentType = null;
        }
        if (obj instanceof File) {
            File file = (File) obj;
            if (TextUtils.isEmpty(str2)) {
                str2 = file.getName();
            }
            if (TextUtils.isEmpty(contentType)) {
                contentType = FileBody.getFileContentType(file);
            }
            writeLine(outputStream, buildContentDisposition(str, str2, this.charset));
            writeLine(outputStream, buildContentType(obj, contentType, this.charset));
            writeLine(outputStream, new byte[0][]);
            writeFile(outputStream, file);
            writeLine(outputStream, new byte[0][]);
            return;
        }
        writeLine(outputStream, buildContentDisposition(str, str2, this.charset));
        writeLine(outputStream, buildContentType(obj, contentType, this.charset));
        writeLine(outputStream, new byte[0][]);
        if (obj instanceof InputStream) {
            writeStreamAndCloseIn(outputStream, (InputStream) obj);
            writeLine(outputStream, new byte[0][]);
            return;
        }
        writeLine(outputStream, obj instanceof byte[] ? (byte[]) obj : String.valueOf(obj).getBytes(this.charset));
        this.current += (long) r11.length;
        if (this.callBackHandler != null && !this.callBackHandler.updateProgress(this.total, this.current, false)) {
            throw new CancelledException("upload stopped!");
        }
    }

    private void writeFile(OutputStream outputStream, File file) throws IOException {
        if (outputStream instanceof CounterOutputStream) {
            ((CounterOutputStream) outputStream).addFile(file);
        } else {
            writeStreamAndCloseIn(outputStream, new FileInputStream(file));
        }
    }

    private void writeLine(OutputStream outputStream, byte[]... bArr) throws IOException {
        if (bArr != null) {
            for (byte[] write : bArr) {
                outputStream.write(write);
            }
        }
        outputStream.write(END_BYTES);
    }

    private void writeStreamAndCloseIn(OutputStream outputStream, InputStream inputStream) throws IOException {
        if (outputStream instanceof CounterOutputStream) {
            ((CounterOutputStream) outputStream).addStream(inputStream);
            return;
        }
        try {
            byte[] bArr = new byte[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                outputStream.write(bArr, 0, read);
                this.current += (long) read;
                if (this.callBackHandler != null && !this.callBackHandler.updateProgress(this.total, this.current, false)) {
                    throw new CancelledException("upload stopped!");
                }
            }
        } finally {
            IOUtil.closeQuietly((Closeable) inputStream);
        }
    }

    public long getContentLength() {
        return this.total;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        int indexOf = this.contentType.indexOf(";");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("multipart/");
        stringBuilder.append(str);
        stringBuilder.append(this.contentType.substring(indexOf));
        this.contentType = stringBuilder.toString();
    }

    public void setProgressHandler(ProgressHandler progressHandler) {
        this.callBackHandler = progressHandler;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (this.callBackHandler == null || this.callBackHandler.updateProgress(this.total, this.current, true)) {
            for (KeyValue keyValue : this.multipartParams) {
                String str = keyValue.key;
                Object obj = keyValue.value;
                if (!(TextUtils.isEmpty(str) || obj == null)) {
                    writeEntry(outputStream, str, obj);
                }
            }
            writeLine(outputStream, TWO_DASHES_BYTES, BOUNDARY_PREFIX_BYTES, this.boundaryPostfixBytes, TWO_DASHES_BYTES);
            outputStream.flush();
            if (this.callBackHandler != null) {
                this.callBackHandler.updateProgress(this.total, this.total, true);
                return;
            }
            return;
        }
        throw new CancelledException("upload stopped!");
    }
}
