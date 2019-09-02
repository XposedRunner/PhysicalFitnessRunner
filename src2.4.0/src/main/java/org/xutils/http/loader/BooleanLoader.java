package org.xutils.http.loader;

import java.io.InputStream;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.http.request.UriRequest;

class BooleanLoader extends Loader<Boolean> {
    BooleanLoader() {
    }

    public Boolean load(InputStream inputStream) throws Throwable {
        return Boolean.valueOf(false);
    }

    public Boolean load(UriRequest uriRequest) throws Throwable {
        uriRequest.sendRequest();
        return Boolean.valueOf(uriRequest.getResponseCode() < 300);
    }

    public Boolean loadFromCache(DiskCacheEntity diskCacheEntity) throws Throwable {
        return null;
    }

    public Loader<Boolean> newInstance() {
        return new BooleanLoader();
    }

    public void save2Cache(UriRequest uriRequest) {
    }
}
