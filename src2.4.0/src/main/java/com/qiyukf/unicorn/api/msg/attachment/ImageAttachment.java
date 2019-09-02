package com.qiyukf.unicorn.api.msg.attachment;

import android.content.Context;
import com.qiyukf.basesdk.c.b;
import com.qiyukf.unicorn.R;
import org.json.JSONObject;

public class ImageAttachment extends FileAttachment {
    private static final String KEY_HEIGHT = "h";
    private static final String KEY_WIDTH = "w";
    private int height;
    private int width;

    public ImageAttachment(String str) {
        super(str);
    }

    public String getContent(Context context) {
        return context.getString(R.string.ysf_msg_notify_image);
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    /* Access modifiers changed, original: protected */
    public void load(JSONObject jSONObject) {
        this.width = b.b(jSONObject, KEY_WIDTH);
        this.height = b.b(jSONObject, "h");
    }

    /* Access modifiers changed, original: protected */
    public void save(JSONObject jSONObject, boolean z) {
        b.a(jSONObject, KEY_WIDTH, this.width);
        b.a(jSONObject, "h", this.height);
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    /* Access modifiers changed, original: protected */
    public com.qiyukf.nimlib.k.c.b storageType() {
        return com.qiyukf.nimlib.k.c.b.TYPE_IMAGE;
    }
}
