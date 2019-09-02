package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.File;

public class ImageObject extends BaseMediaObject {
    public static final Creator<ImageObject> CREATOR = new Creator<ImageObject>() {
        public ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        public ImageObject[] newArray(int i) {
            return new ImageObject[i];
        }
    };
    private static final int DATA_SIZE = 2097152;
    public byte[] imageData;
    public String imagePath;

    public ImageObject(Parcel parcel) {
        this.imageData = parcel.createByteArray();
        this.imagePath = parcel.readString();
    }

    public boolean checkArgs() {
        if (this.imageData == null && this.imagePath == null) {
            LogUtil.e("Weibo.ImageObject", "imageData and imagePath are null");
            return false;
        } else if (this.imageData != null && this.imageData.length > 2097152) {
            LogUtil.e("Weibo.ImageObject", "imageData is too large");
            return false;
        } else if (this.imagePath == null || this.imagePath.length() <= 512) {
            if (this.imagePath != null) {
                File file = new File(this.imagePath);
                try {
                    if (!file.exists() || file.length() == 0 || file.length() > 10485760) {
                        LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                        return false;
                    }
                } catch (SecurityException unused) {
                    LogUtil.e("Weibo.ImageObject", "checkArgs fail, image content is too large or not exists");
                    return false;
                }
            }
            return true;
        } else {
            LogUtil.e("Weibo.ImageObject", "imagePath is too length");
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getObjType() {
        return 2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e A:{SYNTHETIC, Splitter:B:17:0x002e} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039 A:{SYNTHETIC, Splitter:B:22:0x0039} */
    public final void setImageObject(android.graphics.Bitmap r4) {
        /*
        r3 = this;
        r0 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0021 }
        r1.<init>();	 Catch:{ Exception -> 0x0021 }
        r0 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x001c, all -> 0x0019 }
        r2 = 85;
        r4.compress(r0, r2, r1);	 Catch:{ Exception -> 0x001c, all -> 0x0019 }
        r4 = r1.toByteArray();	 Catch:{ Exception -> 0x001c, all -> 0x0019 }
        r3.imageData = r4;	 Catch:{ Exception -> 0x001c, all -> 0x0019 }
        if (r1 == 0) goto L_0x0036;
    L_0x0015:
        r1.close();	 Catch:{ IOException -> 0x0032 }
        goto L_0x0036;
    L_0x0019:
        r4 = move-exception;
        r0 = r1;
        goto L_0x0037;
    L_0x001c:
        r4 = move-exception;
        r0 = r1;
        goto L_0x0022;
    L_0x001f:
        r4 = move-exception;
        goto L_0x0037;
    L_0x0021:
        r4 = move-exception;
    L_0x0022:
        r4.printStackTrace();	 Catch:{ all -> 0x001f }
        r4 = "Weibo.ImageObject";
        r1 = "put thumb failed";
        com.sina.weibo.sdk.utils.LogUtil.e(r4, r1);	 Catch:{ all -> 0x001f }
        if (r0 == 0) goto L_0x0036;
    L_0x002e:
        r0.close();	 Catch:{ IOException -> 0x0032 }
        goto L_0x0036;
    L_0x0032:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0036:
        return;
    L_0x0037:
        if (r0 == 0) goto L_0x0041;
    L_0x0039:
        r0.close();	 Catch:{ IOException -> 0x003d }
        goto L_0x0041;
    L_0x003d:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0041:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.api.ImageObject.setImageObject(android.graphics.Bitmap):void");
    }

    /* Access modifiers changed, original: protected */
    public BaseMediaObject toExtraMediaObject(String str) {
        return this;
    }

    /* Access modifiers changed, original: protected */
    public String toExtraMediaString() {
        return "";
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.imageData);
        parcel.writeString(this.imagePath);
    }
}
