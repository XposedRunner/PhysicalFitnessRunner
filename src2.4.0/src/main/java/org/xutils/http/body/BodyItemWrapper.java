package org.xutils.http.body;

import android.text.TextUtils;

public final class BodyItemWrapper {
    private final String contentType;
    private final String fileName;
    private final Object value;

    public BodyItemWrapper(Object obj, String str) {
        this(obj, str, null);
    }

    public BodyItemWrapper(Object obj, String str, String str2) {
        this.value = obj;
        if (TextUtils.isEmpty(str)) {
            this.contentType = "application/octet-stream";
        } else {
            this.contentType = str;
        }
        this.fileName = str2;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Object getValue() {
        return this.value;
    }
}
