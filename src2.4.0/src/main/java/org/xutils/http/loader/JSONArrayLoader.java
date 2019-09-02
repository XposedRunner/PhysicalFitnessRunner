package org.xutils.http.loader;

import android.text.TextUtils;
import java.io.InputStream;
import org.json.JSONArray;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.common.util.IOUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.request.UriRequest;

class JSONArrayLoader extends Loader<JSONArray> {
    private String charset = "UTF-8";
    private String resultStr = null;

    JSONArrayLoader() {
    }

    public JSONArray load(InputStream inputStream) throws Throwable {
        this.resultStr = IOUtil.readStr(inputStream, this.charset);
        return new JSONArray(this.resultStr);
    }

    public JSONArray load(UriRequest uriRequest) throws Throwable {
        uriRequest.sendRequest();
        return load(uriRequest.getInputStream());
    }

    public JSONArray loadFromCache(DiskCacheEntity diskCacheEntity) throws Throwable {
        if (diskCacheEntity != null) {
            String textContent = diskCacheEntity.getTextContent();
            if (!TextUtils.isEmpty(textContent)) {
                return new JSONArray(textContent);
            }
        }
        return null;
    }

    public Loader<JSONArray> newInstance() {
        return new JSONArrayLoader();
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
