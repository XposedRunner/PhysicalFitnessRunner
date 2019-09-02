package org.xutils.http.body;

import android.text.TextUtils;
import com.ximalaya.ting.android.player.XMediaPlayerConstants;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.xutils.common.Callback.CancelledException;
import org.xutils.common.util.IOUtil;
import org.xutils.http.ProgressHandler;

public class InputStreamBody implements ProgressBody {
    private ProgressHandler callBackHandler;
    private InputStream content;
    private String contentType;
    private long current;
    private final long total;

    public InputStreamBody(InputStream inputStream) {
        this(inputStream, null);
    }

    public InputStreamBody(InputStream inputStream, String str) {
        this.current = 0;
        this.content = inputStream;
        this.contentType = str;
        this.total = getInputStreamLength(inputStream);
    }

    public static long getInputStreamLength(InputStream inputStream) {
        try {
            if ((inputStream instanceof FileInputStream) || (inputStream instanceof ByteArrayInputStream)) {
                return (long) inputStream.available();
            }
        } catch (Throwable unused) {
        }
        return -1;
    }

    public long getContentLength() {
        return this.total;
    }

    public String getContentType() {
        return TextUtils.isEmpty(this.contentType) ? "application/octet-stream" : this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setProgressHandler(ProgressHandler progressHandler) {
        this.callBackHandler = progressHandler;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (this.callBackHandler == null || this.callBackHandler.updateProgress(this.total, this.current, true)) {
            byte[] bArr = new byte[XMediaPlayerConstants.SEND_BUFFER_QUEUE_SIZE_FOR_LIVE];
            while (true) {
                try {
                    int read = this.content.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                        this.current += (long) read;
                        if (this.callBackHandler != null && !this.callBackHandler.updateProgress(this.total, this.current, false)) {
                            throw new CancelledException("upload stopped!");
                        }
                    } else {
                        outputStream.flush();
                        if (this.callBackHandler != null) {
                            this.callBackHandler.updateProgress(this.total, this.total, true);
                        }
                        IOUtil.closeQuietly(this.content);
                        return;
                    }
                } catch (Throwable th) {
                    IOUtil.closeQuietly(this.content);
                }
            }
        } else {
            throw new CancelledException("upload stopped!");
        }
    }
}
