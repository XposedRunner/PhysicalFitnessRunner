package org.xutils.http.body;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

public class FileBody extends InputStreamBody {
    private String contentType;
    private File file;

    public FileBody(File file) throws IOException {
        this(file, null);
    }

    public FileBody(File file, String str) throws IOException {
        super(new FileInputStream(file));
        this.file = file;
        this.contentType = str;
    }

    public static String getFileContentType(File file) {
        String guessContentTypeFromName = HttpURLConnection.guessContentTypeFromName(file.getName());
        return TextUtils.isEmpty(guessContentTypeFromName) ? "application/octet-stream" : guessContentTypeFromName.replaceFirst("\\/jpg$", "/jpeg");
    }

    public String getContentType() {
        if (TextUtils.isEmpty(this.contentType)) {
            this.contentType = getFileContentType(this.file);
        }
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }
}
