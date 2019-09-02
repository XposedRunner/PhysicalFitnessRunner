package org.xutils.http.loader;

import java.io.InputStream;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.http.request.UriRequest;

class IntegerLoader extends Loader<Integer> {
    IntegerLoader() {
    }

    public Integer load(InputStream inputStream) throws Throwable {
        return Integer.valueOf(100);
    }

    public Integer load(UriRequest uriRequest) throws Throwable {
        uriRequest.sendRequest();
        return Integer.valueOf(uriRequest.getResponseCode());
    }

    public Integer loadFromCache(DiskCacheEntity diskCacheEntity) throws Throwable {
        return null;
    }

    public Loader<Integer> newInstance() {
        return new IntegerLoader();
    }

    public void save2Cache(UriRequest uriRequest) {
    }
}
