package org.xutils.http.loader;

import android.text.TextUtils;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import org.xutils.cache.DiskCacheEntity;
import org.xutils.common.util.IOUtil;
import org.xutils.common.util.ParameterizedTypeUtil;
import org.xutils.http.RequestParams;
import org.xutils.http.annotation.HttpResponse;
import org.xutils.http.app.InputStreamResponseParser;
import org.xutils.http.app.ResponseParser;
import org.xutils.http.request.UriRequest;

class ObjectLoader extends Loader<Object> {
    private String charset = "UTF-8";
    private final Class<?> objectClass;
    private final Type objectType;
    private final ResponseParser parser;
    private String resultStr = null;

    public ObjectLoader(Type type) {
        StringBuilder stringBuilder;
        RuntimeException runtimeException;
        this.objectType = type;
        if (type instanceof ParameterizedType) {
            this.objectClass = (Class) ((ParameterizedType) type).getRawType();
        } else if (type instanceof TypeVariable) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("not support callback type ");
            stringBuilder.append(type.toString());
            throw new IllegalArgumentException(stringBuilder.toString());
        } else {
            this.objectClass = (Class) type;
        }
        if (List.class.equals(this.objectClass)) {
            Class cls;
            type = ParameterizedTypeUtil.getParameterizedType(this.objectType, List.class, 0);
            if (type instanceof ParameterizedType) {
                cls = (Class) ((ParameterizedType) type).getRawType();
            } else if (type instanceof TypeVariable) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("not support callback type ");
                stringBuilder.append(type.toString());
                throw new IllegalArgumentException(stringBuilder.toString());
            } else {
                cls = (Class) type;
            }
            HttpResponse httpResponse = (HttpResponse) cls.getAnnotation(HttpResponse.class);
            if (httpResponse != null) {
                try {
                    this.parser = (ResponseParser) httpResponse.parser().newInstance();
                    return;
                } catch (Throwable th) {
                    runtimeException = new RuntimeException("create parser error", th);
                }
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("not found @HttpResponse from ");
                stringBuilder.append(type);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        HttpResponse httpResponse2 = (HttpResponse) this.objectClass.getAnnotation(HttpResponse.class);
        if (httpResponse2 != null) {
            try {
                this.parser = (ResponseParser) httpResponse2.parser().newInstance();
            } catch (Throwable th2) {
                runtimeException = new RuntimeException("create parser error", th2);
            }
        } else {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("not found @HttpResponse from ");
            stringBuilder2.append(this.objectType);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
    }

    public Object load(InputStream inputStream) throws Throwable {
        if (this.parser instanceof InputStreamResponseParser) {
            return ((InputStreamResponseParser) this.parser).parse(this.objectType, this.objectClass, inputStream);
        }
        this.resultStr = IOUtil.readStr(inputStream, this.charset);
        return this.parser.parse(this.objectType, this.objectClass, this.resultStr);
    }

    public Object load(UriRequest uriRequest) throws Throwable {
        try {
            uriRequest.sendRequest();
            return load(uriRequest.getInputStream());
        } finally {
            this.parser.checkResponse(uriRequest);
        }
    }

    public Object loadFromCache(DiskCacheEntity diskCacheEntity) throws Throwable {
        if (diskCacheEntity != null) {
            String textContent = diskCacheEntity.getTextContent();
            if (!TextUtils.isEmpty(textContent)) {
                return this.parser.parse(this.objectType, this.objectClass, textContent);
            }
        }
        return null;
    }

    public Loader<Object> newInstance() {
        throw new IllegalAccessError("use constructor create ObjectLoader.");
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
