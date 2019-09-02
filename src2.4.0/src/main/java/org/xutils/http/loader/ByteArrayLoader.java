package org.xutils.http.loader;

import java.io.InputStream;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.common.util.IOUtil;
import org.xutils.http.request.UriRequest;

class ByteArrayLoader extends Loader<byte[]> {
    ByteArrayLoader() {
    }

    public byte[] load(InputStream inputStream) throws Throwable {
        return IOUtil.readBytes(inputStream);
    }

    public byte[] load(UriRequest uriRequest) throws Throwable {
        uriRequest.sendRequest();
        return load(uriRequest.getInputStream());
    }

    public byte[] loadFromCache(DiskCacheEntity diskCacheEntity) throws Throwable {
        return null;
    }

    public Loader<byte[]> newInstance() {
        return new ByteArrayLoader();
    }

    public void save2Cache(UriRequest uriRequest) {
    }
}
