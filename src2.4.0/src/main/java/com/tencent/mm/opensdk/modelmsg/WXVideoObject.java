package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;

public class WXVideoObject implements IMediaObject {
    private static final int LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXVideoObject";
    public String videoLowBandUrl;
    public String videoUrl;

    public boolean checkArgs() {
        String str;
        String str2;
        if ((this.videoUrl == null || this.videoUrl.length() == 0) && (this.videoLowBandUrl == null || this.videoLowBandUrl.length() == 0)) {
            str = TAG;
            str2 = "both arguments are null";
        } else if (this.videoUrl != null && this.videoUrl.length() > LENGTH_LIMIT) {
            str = TAG;
            str2 = "checkArgs fail, videoUrl is too long";
        } else if (this.videoLowBandUrl == null || this.videoLowBandUrl.length() <= LENGTH_LIMIT) {
            return true;
        } else {
            str = TAG;
            str2 = "checkArgs fail, videoLowBandUrl is too long";
        }
        Log.e(str, str2);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
        bundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
    }

    public int type() {
        return 4;
    }

    public void unserialize(Bundle bundle) {
        this.videoUrl = bundle.getString("_wxvideoobject_videoUrl");
        this.videoLowBandUrl = bundle.getString("_wxvideoobject_videoLowBandUrl");
    }
}
