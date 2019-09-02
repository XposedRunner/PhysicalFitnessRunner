package com.umeng.socialize;

import android.text.TextUtils;
import com.umeng.socialize.media.O0000Oo;
import com.umeng.socialize.media.O0000Oo0;
import com.umeng.socialize.media.O0000o;
import com.umeng.socialize.media.O0000o0;
import com.umeng.socialize.media.O0000o00;
import com.umeng.socialize.media.O00oOooO;
import com.umeng.socialize.media.UMediaObject;
import java.io.File;

public class ShareContent {
    public static final int EMOJI_STYLE = 64;
    public static final int ERROR_STYLE = 0;
    public static final int FILE_STYLE = 32;
    public static final int IMAGE_STYLE = 2;
    public static final int MINAPP_STYLE = 128;
    public static final int MUSIC_STYLE = 4;
    public static final int TEXT_IMAGE_STYLE = 3;
    public static final int TEXT_STYLE = 1;
    public static final int VIDEO_STYLE = 8;
    public static final int WEB_STYLE = 16;
    public File app;
    public File file;
    public UMediaObject mExtra;
    public String mFollow;
    public UMediaObject mMedia;
    public O0000Oo[] mMedias;
    public String mText = "";
    public String subject = "";

    public int getShareType() {
        if (this.mMedia == null && this.mExtra == null && this.file == null) {
            return TextUtils.isEmpty(this.mText) ? 0 : 1;
        } else {
            if (this.file != null) {
                return 32;
            }
            if (this.mMedia != null) {
                if (this.mMedia instanceof O0000Oo0) {
                    return 64;
                }
                if (this.mMedia instanceof O0000Oo) {
                    return TextUtils.isEmpty(this.mText) ? 2 : 3;
                } else {
                    if (this.mMedia instanceof O00oOooO) {
                        return 4;
                    }
                    if (this.mMedia instanceof O0000o0) {
                        return 8;
                    }
                    if (this.mMedia instanceof O0000o) {
                        return 16;
                    }
                    if (this.mMedia instanceof O0000o00) {
                        return 128;
                    }
                }
            }
            return 0;
        }
    }
}
