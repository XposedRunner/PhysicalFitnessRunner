package org.xutils.http.loader;

import android.text.TextUtils;
import java.io.InputStream;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.common.util.IOUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.request.UriRequest;

class StringLoader extends Loader<String> {
    private String charset = "UTF-8";
    private String resultStr = null;

    StringLoader() {
    }

    public String load(InputStream inputStream) throws Throwable {
        this.resultStr = IOUtil.readStr(inputStream, this.charset);
        return this.resultStr;
    }

    public String load(UriRequest uriRequest) throws Throwable {
        uriRequest.sendRequest();
        return load(uriRequest.getInputStream());
    }

    public String loadFromCache(DiskCacheEntity diskCacheEntity) throws Throwable {
        return diskCacheEntity != null ? diskCacheEntity.getTextContent() : null;
    }

    public Loader<String> newInstance() {
        return new StringLoader();
    }

    public void save2Cache(UriRequest uriRequest) {
        saveStringCache(uriRequest, this.resultStr);
    }

    public void setParams(RequestParams requestParams) {
        if (requestParams != null) {
            String charset = requestParams.getCharset();
            if (!TextUtils.isEmpty(charset)) {
                this.charset = charset;
            }
        }
    }
}
