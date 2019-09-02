package org.xutils.http.request;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import org.xutils.common.util.IOUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.loader.FileLoader;

public class LocalFileRequest extends UriRequest {
    private InputStream inputStream;

    LocalFileRequest(RequestParams requestParams, Type type) throws Throwable {
        super(requestParams, type);
    }

    private File getFile() {
        return new File(this.queryUrl.startsWith("file:") ? this.queryUrl.substring("file:".length()) : this.queryUrl);
    }

    public void clearCacheHeader() {
    }

    public void close() throws IOException {
        IOUtil.closeQuietly(this.inputStream);
        this.inputStream = null;
    }

    public String getCacheKey() {
        return null;
    }

    public long getContentLength() {
        return getFile().length();
    }

    public String getETag() {
        return null;
    }

    public long getExpiration() {
        return -1;
    }

    public long getHeaderFieldDate(String str, long j) {
        return j;
    }

    public InputStream getInputStream() throws IOException {
        if (this.inputStream == null) {
            this.inputStream = new FileInputStream(getFile());
        }
        return this.inputStream;
    }

    public long getLastModified() {
        return getFile().lastModified();
    }

    public int getResponseCode() throws IOException {
        return getFile().exists() ? 200 : 404;
    }

    public String getResponseHeader(String str) {
        return null;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return null;
    }

    public String getResponseMessage() throws IOException {
        return null;
    }

    public boolean isLoading() {
        return true;
    }

    public Object loadResult() throws Throwable {
        return this.loader instanceof FileLoader ? getFile() : this.loader.load((UriRequest) this);
    }

    public Object loadResultFromCache() throws Throwable {
        return null;
    }

    public void save2Cache() {
    }

    public void sendRequest() throws Throwable {
    }
}
