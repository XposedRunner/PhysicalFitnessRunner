package com.qiyukf.unicorn.api.msg.attachment;

import android.content.Context;
import android.text.TextUtils;
import com.qiyukf.basesdk.c.b;
import com.qiyukf.basesdk.c.c.c;
import com.qiyukf.basesdk.c.c.d;
import com.qiyukf.unicorn.R;
import java.io.File;
import org.json.JSONObject;

public class FileAttachment implements MsgAttachment {
    private static final String KEY_EXPIRE = "expire";
    private static final String KEY_EXT = "ext";
    private static final String KEY_MD5 = "md5";
    private static final String KEY_NAME = "name";
    private static final String KEY_PATH = "path";
    private static final String KEY_SIZE = "size";
    private static final String KEY_URL = "url";
    protected String displayName;
    private long expire;
    protected String extension;
    protected String md5;
    protected String path;
    protected long size;
    protected String url;

    public FileAttachment(String str) {
        fromJson(str);
    }

    private void fromJson(String str) {
        JSONObject a = b.a(str);
        this.path = b.e(a, KEY_PATH);
        this.md5 = b.e(a, KEY_MD5);
        this.url = b.e(a, "url");
        this.displayName = b.e(a, KEY_NAME);
        this.size = b.c(a, KEY_SIZE);
        this.extension = b.e(a, KEY_EXT);
        this.expire = b.c(a, KEY_EXPIRE);
        load(a);
    }

    public boolean countToUnread() {
        return true;
    }

    public String getContent(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(R.string.ysf_msg_notify_file));
        stringBuilder.append(getDisplayName());
        return stringBuilder.toString();
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public long getExpire() {
        return this.expire;
    }

    public String getExtension() {
        return this.extension;
    }

    public String getFileName() {
        return !TextUtils.isEmpty(this.path) ? d.b(this.path) : TextUtils.isEmpty(this.md5) ? c.a(this.url) : this.md5;
    }

    public String getMd5() {
        return this.md5;
    }

    public String getPath() {
        String pathForSave = getPathForSave();
        return new File(pathForSave).exists() ? pathForSave : null;
    }

    public String getPathForSave() {
        return !TextUtils.isEmpty(this.path) ? this.path : com.qiyukf.nimlib.k.c.c.a(getFileName(), storageType());
    }

    public long getSize() {
        return this.size;
    }

    public String getThumbPath() {
        String thumbPathForSave = getThumbPathForSave();
        if (!new File(thumbPathForSave).exists()) {
            thumbPathForSave = null;
        }
        return thumbPathForSave != null ? thumbPathForSave : getPath();
    }

    public String getThumbPathForSave() {
        return com.qiyukf.nimlib.k.c.c.a(getFileName(), com.qiyukf.nimlib.k.c.b.TYPE_THUMB_IMAGE);
    }

    public String getUrl() {
        return this.url;
    }

    /* Access modifiers changed, original: protected */
    public void load(JSONObject jSONObject) {
    }

    /* Access modifiers changed, original: protected */
    public void save(JSONObject jSONObject, boolean z) {
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setExtension(String str) {
        this.extension = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    /* Access modifiers changed, original: protected */
    public com.qiyukf.nimlib.k.c.b storageType() {
        return com.qiyukf.nimlib.k.c.b.TYPE_FILE;
    }

    public String toJson(boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (!z) {
            try {
                if (!TextUtils.isEmpty(this.path)) {
                    jSONObject.put(KEY_PATH, this.path);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.md5)) {
            jSONObject.put(KEY_MD5, this.md5);
        }
        if (!TextUtils.isEmpty(this.displayName)) {
            jSONObject.put(KEY_NAME, this.displayName);
        }
        jSONObject.put("url", this.url);
        jSONObject.put(KEY_SIZE, this.size);
        if (!TextUtils.isEmpty(this.extension)) {
            jSONObject.put(KEY_EXT, this.extension);
        }
        if (this.expire > 0) {
            jSONObject.put(KEY_EXPIRE, this.expire);
        }
        save(jSONObject, z);
        return jSONObject.toString();
    }
}
