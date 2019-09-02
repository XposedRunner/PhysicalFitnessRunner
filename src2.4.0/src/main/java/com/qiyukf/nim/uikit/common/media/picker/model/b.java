package com.qiyukf.nim.uikit.common.media.picker.model;

import android.content.Intent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class b {
    public static Intent a(List<PhotoInfo> list, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("photo_list", new ArrayList(list));
        intent.putExtra("is_original", z);
        return intent;
    }

    public static List<PhotoInfo> a(Intent intent) {
        return a(intent.getSerializableExtra("photo_list"));
    }

    private static List<PhotoInfo> a(Serializable serializable) {
        return (serializable == null || !(serializable instanceof List)) ? null : (List) serializable;
    }

    public static List<PhotoInfo> b(Intent intent) {
        return a(intent.getSerializableExtra("selected_photo_list"));
    }
}
