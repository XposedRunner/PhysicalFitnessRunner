package org.xutils.http.request;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.cache.LruDiskCache;
import org.xutils.common.util.IOUtil;
import org.xutils.common.util.LogUtil;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class AssetsRequest extends UriRequest {
    private long contentLength = 0;
    private InputStream inputStream;

    public AssetsRequest(RequestParams requestParams, Type type) throws Throwable {
        super(requestParams, type);
    }

    public void clearCacheHeader() {
    }

    public void close() throws IOException {
        IOUtil.closeQuietly(this.inputStream);
        this.inputStream = null;
    }

    /* Access modifiers changed, original: protected */
    public long getAssetsLastModified() {
        return new File(x.app().getApplicationInfo().sourceDir).lastModified();
    }

    public String getCacheKey() {
        return this.queryUrl;
    }

    public long getContentLength() {
        try {
            getInputStream();
            return this.contentLength;
        } catch (Throwable th) {
            LogUtil.e(th.getMessage(), th);
            return 0;
        }
    }

    public String getETag() {
        return null;
    }

    public long getExpiration() {
        return Long.MAX_VALUE;
    }

    public long getHeaderFieldDate(String str, long j) {
        return j;
    }

    public InputStream getInputStream() throws IOException {
        if (this.inputStream == null && this.callingClassLoader != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("assets/");
            stringBuilder.append(this.queryUrl.substring("assets://".length()));
            this.inputStream = this.callingClassLoader.getResourceAsStream(stringBuilder.toString());
            this.contentLength = (long) this.inputStream.available();
        }
        return this.inputStream;
    }

    public long getLastModified() {
        return getAssetsLastModified();
    }

    public int getResponseCode() throws IOException {
        return getInputStream() != null ? 200 : 404;
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
        return this.loader.load((UriRequest) this);
    }

    public Object loadResultFromCache() throws Throwable {
        DiskCacheEntity diskCacheEntity = LruDiskCache.getDiskCache(this.params.getCacheDirName()).setMaxSize(this.params.getCacheSize()).get(getCacheKey());
        if (diskCacheEntity == null) {
            return null;
        }
        Date lastModify = diskCacheEntity.getLastModify();
        return (lastModify == null || lastModify.getTime() < getAssetsLastModified()) ? null : this.loader.loadFromCache(diskCacheEntity);
    }

    public void sendRequest() throws Throwable {
    }
}
