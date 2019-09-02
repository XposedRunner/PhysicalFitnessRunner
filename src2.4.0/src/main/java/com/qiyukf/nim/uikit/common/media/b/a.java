package com.qiyukf.nim.uikit.common.media.b;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.util.Log;

public final class a {
    public static Cursor a(Context context) {
        String[] strArr = new String[]{"_id", "image_id", "_data"};
        try {
            return context.getContentResolver().query(Thumbnails.EXTERNAL_CONTENT_URI, strArr, null, null, "_id DESC");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MediaDAO", "getAllMediaThumbnails exception");
            return null;
        }
    }

    public static Cursor b(Context context) {
        try {
            return context.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, null, null, null, "date_modified DESC");
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MediaDAO", "getAllMediaPhotos exception");
            return null;
        }
    }
}
