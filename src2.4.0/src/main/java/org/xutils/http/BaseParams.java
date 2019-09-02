package org.xutils.http;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.util.KeyValue;
import org.xutils.common.util.LogUtil;
import org.xutils.http.body.BodyItemWrapper;
import org.xutils.http.body.FileBody;
import org.xutils.http.body.InputStreamBody;
import org.xutils.http.body.MultipartBody;
import org.xutils.http.body.RequestBody;
import org.xutils.http.body.StringBody;
import org.xutils.http.body.UrlEncodedParamsBody;

abstract class BaseParams {
    private boolean asJsonContent = false;
    private String bodyContent;
    private final List<KeyValue> bodyParams = new ArrayList();
    private String charset = "UTF-8";
    private final List<KeyValue> fileParams = new ArrayList();
    private final List<Header> headers = new ArrayList();
    private HttpMethod method;
    private boolean multipart = false;
    private final List<KeyValue> queryStringParams = new ArrayList();
    private RequestBody requestBody;

    public static final class ArrayItem extends KeyValue {
        public ArrayItem(String str, Object obj) {
            super(str, obj);
        }
    }

    public static final class Header extends KeyValue {
        public final boolean setHeader;

        public Header(String str, String str2, boolean z) {
            super(str, str2);
            this.setHeader = z;
        }
    }

    BaseParams() {
    }

    private void checkBodyParams() {
        if (!this.bodyParams.isEmpty()) {
            if (!(HttpMethod.permitsRequestBody(this.method) && TextUtils.isEmpty(this.bodyContent) && this.requestBody == null)) {
                this.queryStringParams.addAll(this.bodyParams);
                this.bodyParams.clear();
            }
            if (!this.bodyParams.isEmpty() && (this.multipart || this.fileParams.size() > 0)) {
                this.fileParams.addAll(this.bodyParams);
                this.bodyParams.clear();
            }
            if (this.asJsonContent && !this.bodyParams.isEmpty()) {
                try {
                    JSONObject jSONObject = !TextUtils.isEmpty(this.bodyContent) ? new JSONObject(this.bodyContent) : new JSONObject();
                    params2Json(jSONObject, this.bodyParams);
                    this.bodyContent = jSONObject.toString();
                    this.bodyParams.clear();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void params2Json(JSONObject jSONObject, List<KeyValue> list) throws JSONException {
        HashSet hashSet = new HashSet(list.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        for (int i = 0; i < list.size(); i++) {
            KeyValue keyValue = (KeyValue) list.get(i);
            String str = keyValue.key;
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray;
                if (linkedHashMap.containsKey(str)) {
                    jSONArray = (JSONArray) linkedHashMap.get(str);
                } else {
                    jSONArray = new JSONArray();
                    linkedHashMap.put(str, jSONArray);
                }
                jSONArray.put(RequestParamsHelper.parseJSONObject(keyValue.value));
                if (keyValue instanceof ArrayItem) {
                    hashSet.add(str);
                }
            }
        }
        for (Entry entry : linkedHashMap.entrySet()) {
            String str2 = (String) entry.getKey();
            JSONArray jSONArray2 = (JSONArray) entry.getValue();
            if (jSONArray2.length() > 1 || hashSet.contains(str2)) {
                jSONObject.put(str2, jSONArray2);
            } else {
                jSONObject.put(str2, jSONArray2.get(0));
            }
        }
    }

    public void addBodyParameter(String str, File file) {
        addBodyParameter(str, file, null, null);
    }

    public void addBodyParameter(String str, Object obj, String str2) {
        addBodyParameter(str, obj, str2, null);
    }

    public void addBodyParameter(String str, Object obj, String str2, String str3) {
        if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3)) {
            this.fileParams.add(new KeyValue(str, obj));
        } else {
            this.fileParams.add(new KeyValue(str, new BodyItemWrapper(obj, str2, str3)));
        }
    }

    public void addBodyParameter(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.bodyContent = str2;
        } else {
            this.bodyParams.add(new KeyValue(str, str2));
        }
    }

    public void addHeader(String str, String str2) {
        this.headers.add(new Header(str, str2, false));
    }

    public void addParameter(String str, Object obj) {
        if (obj != null) {
            int i = 0;
            int length;
            if (this.method == null || HttpMethod.permitsRequestBody(this.method)) {
                if (TextUtils.isEmpty(str)) {
                    this.bodyContent = obj.toString();
                } else if ((obj instanceof File) || (obj instanceof InputStream) || (obj instanceof byte[])) {
                    this.fileParams.add(new KeyValue(str, obj));
                } else if (obj instanceof List) {
                    for (Object arrayItem : (List) obj) {
                        this.bodyParams.add(new ArrayItem(str, arrayItem));
                    }
                } else if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    length = jSONArray.length();
                    while (i < length) {
                        this.bodyParams.add(new ArrayItem(str, jSONArray.opt(i)));
                        i++;
                    }
                } else if (obj.getClass().isArray()) {
                    length = Array.getLength(obj);
                    while (i < length) {
                        this.bodyParams.add(new ArrayItem(str, Array.get(obj, i)));
                        i++;
                    }
                } else {
                    this.bodyParams.add(new KeyValue(str, obj));
                }
            } else if (!TextUtils.isEmpty(str)) {
                if (obj instanceof List) {
                    for (Object arrayItem2 : (List) obj) {
                        this.queryStringParams.add(new ArrayItem(str, arrayItem2));
                    }
                } else if (obj.getClass().isArray()) {
                    length = Array.getLength(obj);
                    while (i < length) {
                        this.queryStringParams.add(new ArrayItem(str, Array.get(obj, i)));
                        i++;
                    }
                } else {
                    this.queryStringParams.add(new KeyValue(str, obj));
                }
            }
        }
    }

    public void addQueryStringParameter(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.queryStringParams.add(new KeyValue(str, str2));
        }
    }

    public void clearParams() {
        this.queryStringParams.clear();
        this.bodyParams.clear();
        this.fileParams.clear();
        this.bodyContent = null;
        this.requestBody = null;
    }

    public String getBodyContent() {
        checkBodyParams();
        return this.bodyContent;
    }

    public List<KeyValue> getBodyParams() {
        checkBodyParams();
        return new ArrayList(this.bodyParams);
    }

    public String getCharset() {
        return this.charset;
    }

    public List<KeyValue> getFileParams() {
        checkBodyParams();
        return new ArrayList(this.fileParams);
    }

    public List<Header> getHeaders() {
        return new ArrayList(this.headers);
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public List<KeyValue> getParams(String str) {
        ArrayList arrayList = new ArrayList();
        for (KeyValue keyValue : this.queryStringParams) {
            if (str == null && keyValue.key == null) {
                arrayList.add(keyValue);
            } else if (str != null && str.equals(keyValue.key)) {
                arrayList.add(keyValue);
            }
        }
        for (KeyValue keyValue2 : this.bodyParams) {
            if (str == null && keyValue2.key == null) {
                arrayList.add(keyValue2);
            } else if (str != null && str.equals(keyValue2.key)) {
                arrayList.add(keyValue2);
            }
        }
        for (KeyValue keyValue22 : this.fileParams) {
            if (str == null && keyValue22.key == null) {
                arrayList.add(keyValue22);
            } else if (str != null && str.equals(keyValue22.key)) {
                arrayList.add(keyValue22);
            }
        }
        return arrayList;
    }

    public List<KeyValue> getQueryStringParams() {
        checkBodyParams();
        return new ArrayList(this.queryStringParams);
    }

    public RequestBody getRequestBody() throws IOException {
        checkBodyParams();
        if (this.requestBody != null) {
            return this.requestBody;
        }
        RequestBody requestBody = null;
        if (!TextUtils.isEmpty(this.bodyContent)) {
            requestBody = new StringBody(this.bodyContent, this.charset);
        } else if (this.multipart || this.fileParams.size() > 0) {
            if (this.multipart || this.fileParams.size() != 1) {
                this.multipart = true;
                requestBody = new MultipartBody(this.fileParams, this.charset);
            } else {
                Iterator it = this.fileParams.iterator();
                if (it.hasNext()) {
                    String contentType;
                    Object obj = ((KeyValue) it.next()).value;
                    if (obj instanceof BodyItemWrapper) {
                        BodyItemWrapper bodyItemWrapper = (BodyItemWrapper) obj;
                        Object value = bodyItemWrapper.getValue();
                        contentType = bodyItemWrapper.getContentType();
                        obj = value;
                    } else {
                        contentType = null;
                    }
                    if (obj instanceof File) {
                        requestBody = new FileBody((File) obj, contentType);
                    } else if (obj instanceof InputStream) {
                        requestBody = new InputStreamBody((InputStream) obj, contentType);
                    } else if (obj instanceof byte[]) {
                        requestBody = new InputStreamBody(new ByteArrayInputStream((byte[]) obj), contentType);
                    } else if (obj instanceof String) {
                        requestBody = new StringBody((String) obj, this.charset);
                        requestBody.setContentType(contentType);
                    } else {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Some params will be ignored for: ");
                        stringBuilder.append(toString());
                        LogUtil.w(stringBuilder.toString());
                    }
                }
            }
        } else if (this.bodyParams.size() > 0) {
            requestBody = new UrlEncodedParamsBody(this.bodyParams, this.charset);
        }
        return requestBody;
    }

    public String getStringParameter(String str) {
        for (KeyValue keyValue : this.queryStringParams) {
            if (str == null && keyValue.key == null) {
                return keyValue.getValueStr();
            }
            if (str != null && str.equals(keyValue.key)) {
                return keyValue.getValueStr();
            }
        }
        for (KeyValue keyValue2 : this.bodyParams) {
            if (str == null && keyValue2.key == null) {
                return keyValue2.getValueStr();
            }
            if (str != null && str.equals(keyValue2.key)) {
                return keyValue2.getValueStr();
            }
        }
        return null;
    }

    public List<KeyValue> getStringParams() {
        ArrayList arrayList = new ArrayList(this.queryStringParams.size() + this.bodyParams.size());
        arrayList.addAll(this.queryStringParams);
        arrayList.addAll(this.bodyParams);
        return arrayList;
    }

    public boolean isAsJsonContent() {
        return this.asJsonContent;
    }

    public boolean isMultipart() {
        return this.multipart;
    }

    public void removeParameter(String str) {
        if (TextUtils.isEmpty(str)) {
            this.bodyContent = null;
            return;
        }
        Iterator it = this.queryStringParams.iterator();
        while (it.hasNext()) {
            if (str.equals(((KeyValue) it.next()).key)) {
                it.remove();
            }
        }
        it = this.bodyParams.iterator();
        while (it.hasNext()) {
            if (str.equals(((KeyValue) it.next()).key)) {
                it.remove();
            }
        }
        it = this.fileParams.iterator();
        while (it.hasNext()) {
            if (str.equals(((KeyValue) it.next()).key)) {
                it.remove();
            }
        }
    }

    public void setAsJsonContent(boolean z) {
        this.asJsonContent = z;
    }

    public void setBodyContent(String str) {
        this.bodyContent = str;
    }

    public void setCharset(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.charset = str;
        }
    }

    public void setHeader(String str, String str2) {
        Header header = new Header(str, str2, true);
        Iterator it = this.headers.iterator();
        while (it.hasNext()) {
            if (str.equals(((KeyValue) it.next()).key)) {
                it.remove();
            }
        }
        this.headers.add(header);
    }

    public void setMethod(HttpMethod httpMethod) {
        this.method = httpMethod;
    }

    public void setMultipart(boolean z) {
        this.multipart = z;
    }

    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    public String toJSONString() {
        ArrayList arrayList = new ArrayList(this.queryStringParams.size() + this.bodyParams.size());
        arrayList.addAll(this.queryStringParams);
        arrayList.addAll(this.bodyParams);
        try {
            JSONObject jSONObject = !TextUtils.isEmpty(this.bodyContent) ? new JSONObject(this.bodyContent) : new JSONObject();
            params2Json(jSONObject, arrayList);
            return jSONObject.toString();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        checkBodyParams();
        StringBuilder stringBuilder = new StringBuilder();
        if (!this.queryStringParams.isEmpty()) {
            for (KeyValue keyValue : this.queryStringParams) {
                stringBuilder.append(keyValue.key);
                stringBuilder.append("=");
                stringBuilder.append(keyValue.value);
                stringBuilder.append("&");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (HttpMethod.permitsRequestBody(this.method)) {
            stringBuilder.append("<");
            if (!TextUtils.isEmpty(this.bodyContent)) {
                stringBuilder.append(this.bodyContent);
            } else if (!this.bodyParams.isEmpty()) {
                for (KeyValue keyValue2 : this.bodyParams) {
                    stringBuilder.append(keyValue2.key);
                    stringBuilder.append("=");
                    stringBuilder.append(keyValue2.value);
                    stringBuilder.append("&");
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            stringBuilder.append(">");
        }
        return stringBuilder.toString();
    }
}
