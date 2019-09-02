package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.utils.Log;
import java.io.File;

public class WXAppExtendObject implements IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int EXTINFO_LENGTH_LIMIT = 2048;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXAppExtendObject";
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    public WXAppExtendObject(String str, String str2) {
        this.extInfo = str;
        this.filePath = str2;
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        this.extInfo = str;
        this.fileData = bArr;
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
        if ((this.extInfo == null || this.extInfo.length() == 0) && ((this.filePath == null || this.filePath.length() == 0) && (this.fileData == null || this.fileData.length == 0))) {
            str = TAG;
            str2 = "checkArgs fail, all arguments is null";
        } else if (this.extInfo != null && this.extInfo.length() > 2048) {
            str = TAG;
            str2 = "checkArgs fail, extInfo is invalid";
        } else if (this.filePath != null && this.filePath.length() > PATH_LENGTH_LIMIT) {
            str = TAG;
            str2 = "checkArgs fail, filePath is invalid";
        } else if (this.filePath != null && getFileSize(this.filePath) > CONTENT_LENGTH_LIMIT) {
            str = TAG;
            str2 = "checkArgs fail, fileSize is too large";
        } else if (this.fileData == null || this.fileData.length <= CONTENT_LENGTH_LIMIT) {
            return true;
        } else {
            str = TAG;
            str2 = "checkArgs fail, fileData is too large";
        }
        Log.e(str, str2);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
    }

    public int type() {
        return 7;
    }

    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
    }
}
