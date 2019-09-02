package org.xutils.http.loader;

import android.text.TextUtils;
import java.io.InputStream;
import java.util.Date;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.cache.LruDiskCache;
import org.xutils.http.ProgressHandler;
import org.xutils.http.RequestParams;
import org.xutils.http.request.UriRequest;

public abstract class Loader<T> {
    protected RequestParams params;
    protected ProgressHandler progressHandler;

    public abstract T load(InputStream inputStream) throws Throwable;

    public abstract T load(UriRequest uriRequest) throws Throwable;

    public abstract T loadFromCache(DiskCacheEntity diskCacheEntity) throws Throwable;

    public abstract Loader<T> newInstance();

    public abstract void save2Cache(UriRequest uriRequest);

    /* Access modifiers changed, original: protected */
    public void saveStringCache(UriRequest uriRequest, String str) {
        if (!TextUtils.isEmpty(str)) {
            DiskCacheEntity diskCacheEntity = new DiskCacheEntity();
            diskCacheEntity.setKey(uriRequest.getCacheKey());
            diskCacheEntity.setLastAccess(System.currentTimeMillis());
            diskCacheEntity.setEtag(uriRequest.getETag());
            diskCacheEntity.setExpires(uriRequest.getExpiration());
            diskCacheEntity.setLastModify(new Date(uriRequest.getLastModified()));
            diskCacheEntity.setTextContent(str);
            LruDiskCache.getDiskCache(uriRequest.getParams().getCacheDirName()).put(diskCacheEntity);
        }
    }

    public void setParams(RequestParams requestParams) {
        this.params = requestParams;
    }

    public void setProgressHandler(ProgressHandler progressHandler) {
        this.progressHandler = progressHandler;
    }
}
