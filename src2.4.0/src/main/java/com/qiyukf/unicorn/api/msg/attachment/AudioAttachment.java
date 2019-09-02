package com.qiyukf.unicorn.api.msg.attachment;

import android.content.Context;
import com.qiyukf.basesdk.c.b;
import com.qiyukf.unicorn.R;
import org.json.JSONObject;

public class AudioAttachment extends FileAttachment {
    private static final String KEY_DURATION = "dur";
    private static final String KEY_IS_AUTO_TRANSFORM = "auto";
    private static final String KEY_TEXT = "tt";
    private boolean autoTransform;
    private long duration;
    private String text;

    public AudioAttachment(String str) {
        super(str);
    }

    public boolean getAutoTransform() {
        return this.autoTransform;
    }

    public String getContent(Context context) {
        return context.getString(R.string.ysf_msg_notify_audio);
    }

    public long getDuration() {
        return this.duration;
    }

    public String getText() {
        return this.text;
    }

    /* Access modifiers changed, original: protected */
    public void load(JSONObject jSONObject) {
        this.duration = b.c(jSONObject, KEY_DURATION);
        this.text = b.e(jSONObject, KEY_TEXT);
        this.autoTransform = b.a(jSONObject, KEY_IS_AUTO_TRANSFORM);
    }

    /* Access modifiers changed, original: protected */
    public void save(JSONObject jSONObject, boolean z) {
        b.a(jSONObject, KEY_DURATION, this.duration);
        if (!z) {
            b.a(jSONObject, KEY_TEXT, this.text);
            b.a(jSONObject, KEY_IS_AUTO_TRANSFORM, Boolean.valueOf(this.autoTransform));
        }
    }

    public void setAutoTransform(boolean z) {
        this.autoTransform = z;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setText(String str) {
        this.text = str;
    }

    /* Access modifiers changed, original: protected */
    public com.qiyukf.nimlib.k.c.b storageType() {
        return com.qiyukf.nimlib.k.c.b.TYPE_AUDIO;
    }
}
