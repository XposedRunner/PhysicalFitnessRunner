package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.sina.weibo.sdk.utils.LogUtil;

public abstract class BaseMediaObject implements Parcelable {
    public static final int MEDIA_TYPE_IMAGE = 2;
    public static final int MEDIA_TYPE_MULITI_IMAGE = 6;
    public static final int MEDIA_TYPE_SOURCE_VIDEO = 7;
    public static final int MEDIA_TYPE_TEXT = 1;
    public static final int MEDIA_TYPE_WEBPAGE = 5;
    public String actionUrl;
    public String description;
    public String identify;
    public String schema;
    public byte[] thumbData;
    public String title;

    public BaseMediaObject(Parcel parcel) {
        this.actionUrl = parcel.readString();
        this.schema = parcel.readString();
        this.identify = parcel.readString();
        this.title = parcel.readString();
        this.description = parcel.readString();
        this.thumbData = parcel.createByteArray();
    }

    /* Access modifiers changed, original: protected */
    public boolean checkArgs() {
        if (this.actionUrl == null || this.actionUrl.length() > 512) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, actionUrl is invalid");
            return false;
        } else if (this.identify == null || this.identify.length() > 512) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, identify is invalid");
            return false;
        } else if (this.thumbData == null || this.thumbData.length > 32768) {
            String str = "Weibo.BaseMediaObject";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("checkArgs fail, thumbData is invalid,size is ");
            stringBuilder.append(this.thumbData != null ? this.thumbData.length : -1);
            stringBuilder.append("! more then 32768.");
            LogUtil.e(str, stringBuilder.toString());
            return false;
        } else if (this.title == null || this.title.length() > 512) {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, title is invalid");
            return false;
        } else if (this.description != null && this.description.length() <= 1024) {
            return true;
        } else {
            LogUtil.e("Weibo.BaseMediaObject", "checkArgs fail, description is invalid");
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public abstract int getObjType();

    /* JADX WARNING: Removed duplicated region for block: B:29:? A:{SYNTHETIC, RETURN} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e A:{SYNTHETIC, Splitter:B:17:0x002e} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0039 A:{SYNTHETIC, Splitter:B:22:0x0039} */
    public final void setThumbImage(android.graphics.Bitmap r4) {
        /*
        r3 = this;
        r0 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0021 }
        r1.<init>();	 Catch:{ Exception -> 0x0021 }
        r0 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ Exception -> 0x001c, all -> 0x0019 }
        r2 = 85;
        r4.compress(r0, r2, r1);	 Catch:{ Exception -> 0x001c, all -> 0x0019 }
        r4 = r1.toByteArray();	 Catch:{ Exception -> 0x001c, all -> 0x0019 }
        r3.thumbData = r4;	 Catch:{ Exception -> 0x001c, all -> 0x0019 }
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
        r4 = "Weibo.BaseMediaObject";
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
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.api.BaseMediaObject.setThumbImage(android.graphics.Bitmap):void");
    }

    public abstract BaseMediaObject toExtraMediaObject(String str);

    public abstract String toExtraMediaString();

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.actionUrl);
        parcel.writeString(this.schema);
        parcel.writeString(this.identify);
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.thumbData);
    }
}
