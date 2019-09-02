package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

public class WXGameVideoFileObject implements IMediaObject {
    private static final int FILE_SIZE_LIMIT = 10485760;
    private static final String TAG = "MicroMsg.SDK.WXGameVideoFileObject";
    private static final int URL_LENGTH_LIMIT = 10240;
    public String filePath;
    public String thumbUrl;
    public String videoUrl;

    public WXGameVideoFileObject() {
        this.filePath = null;
        this.videoUrl = null;
        this.thumbUrl = null;
    }

    public WXGameVideoFileObject(String str, String str2, String str3) {
        this.filePath = str;
        this.videoUrl = str2;
        this.thumbUrl = str3;
    }

    private int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        return !file.exists() ? 0 : (int) file.length();
    }

    public boolean checkArgs() {
        String str;
        String str2;
        if (this.filePath == null || this.filePath.length() == 0) {
            str = TAG;
            str2 = "checkArgs fail, filePath is null";
        } else if (getFileSize(this.filePath) > FILE_SIZE_LIMIT) {
            str = TAG;
            str2 = "checkArgs fail, video file size is too large";
        } else if (this.videoUrl != null && this.videoUrl.length() > URL_LENGTH_LIMIT) {
            str = TAG;
            str2 = "checkArgs fail, videoUrl is too long";
        } else if (this.thumbUrl == null || this.thumbUrl.length() <= URL_LENGTH_LIMIT) {
            return true;
        } else {
            str = TAG;
            str2 = "checkArgs fail, thumbUrl is too long";
        }
        Log.e(str, str2);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideofileobject_filePath", this.filePath);
        bundle.putString("_wxvideofileobject_cdnUrl", this.videoUrl);
        bundle.putString("_wxvideofileobject_thumbUrl", this.thumbUrl);
    }

    public int type() {
        return 39;
    }

    public void unserialize(Bundle bundle) {
        this.filePath = bundle.getString("_wxvideofileobject_filePath");
        this.videoUrl = bundle.getString("_wxvideofileobject_cdnUrl");
        this.thumbUrl = bundle.getString("_wxvideofileobject_thumbUrl");
    }
}
