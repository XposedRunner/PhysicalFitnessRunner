package org.xutils.http.body;

import android.text.TextUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class StringBody implements RequestBody {
    private String charset = "UTF-8";
    private byte[] content;
    private String contentType;

    public StringBody(String str, String str2) throws UnsupportedEncodingException {
        if (!TextUtils.isEmpty(str2)) {
            this.charset = str2;
        }
        this.content = str.getBytes(this.charset);
    }

    public long getContentLength() {
        return (long) this.content.length;
    }

    public String getContentType() {
        if (!TextUtils.isEmpty(this.contentType)) {
            return this.contentType;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("application/json;charset=");
        stringBuilder.append(this.charset);
        return stringBuilder.toString();
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.content);
        outputStream.flush();
    }
}
