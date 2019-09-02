package com.qiyukf.nimlib.sdk.msg.attachment;

import com.qiyukf.basesdk.c.b;
import com.qiyukf.unicorn.api.msg.attachment.FileAttachment;
import org.json.JSONObject;

public class VideoAttachment extends FileAttachment {
    private static final String KEY_DURATION = "dur";
    private static final String KEY_HEIGHT = "h";
    private static final String KEY_WIDTH = "w";
    private long duration;
    private int height;
    private int width;

    public VideoAttachment(String str) {
        super(str);
    }

    public long getDuration() {
        return this.duration;
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
        this.duration = (long) b.b(jSONObject, KEY_DURATION);
    }

    /* Access modifiers changed, original: protected */
    public void save(JSONObject jSONObject, boolean z) {
        b.a(jSONObject, KEY_WIDTH, this.width);
        b.a(jSONObject, "h", this.height);
        b.a(jSONObject, KEY_DURATION, this.duration);
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    /* Access modifiers changed, original: protected */
    public com.qiyukf.nimlib.k.c.b storageType() {
        return com.qiyukf.nimlib.k.c.b.TYPE_VIDEO;
    }
}
