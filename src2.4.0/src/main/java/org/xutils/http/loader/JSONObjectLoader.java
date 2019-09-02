package org.xutils.http.loader;

import android.text.TextUtils;
import java.io.InputStream;
import org.json.JSONObject;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.common.util.IOUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.request.UriRequest;

class JSONObjectLoader extends Loader<JSONObject> {
    private String charset = "UTF-8";
    private String resultStr = null;

    JSONObjectLoader() {
    }

    public JSONObject load(InputStream inputStream) throws Throwable {
        this.resultStr = IOUtil.readStr(inputStream, this.charset);
        return new JSONObject(this.resultStr);
    }

    public JSONObject load(UriRequest uriRequest) throws Throwable {
        uriRequest.sendRequest();
        return load(uriRequest.getInputStream());
    }

    public JSONObject loadFromCache(DiskCacheEntity diskCacheEntity) throws Throwable {
        if (diskCacheEntity != null) {
            String textContent = diskCacheEntity.getTextContent();
            if (!TextUtils.isEmpty(textContent)) {
                return new JSONObject(textContent);
            }
        }
        return null;
    }

    public Loader<JSONObject> newInstance() {
        return new JSONObjectLoader();
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
