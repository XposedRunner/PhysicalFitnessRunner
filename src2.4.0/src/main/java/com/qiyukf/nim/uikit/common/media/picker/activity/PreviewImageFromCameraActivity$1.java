package com.qiyukf.nim.uikit.common.media.picker.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.qiyukf.basesdk.c.a.a;
import java.util.ArrayList;

class PreviewImageFromCameraActivity$1 implements OnClickListener {
    final /* synthetic */ PreviewImageFromCameraActivity a;

    PreviewImageFromCameraActivity$1(PreviewImageFromCameraActivity previewImageFromCameraActivity) {
        this.a = previewImageFromCameraActivity;
    }

    public final void onClick(View view) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(PreviewImageFromCameraActivity.a(this.a).getPath());
        arrayList2.add(PreviewImageFromCameraActivity.b(this.a));
        a.b(PreviewImageFromCameraActivity.b(this.a));
        Intent initPreviewImageIntent = PreviewImageFromCameraActivity.initPreviewImageIntent(arrayList, arrayList2, false);
        initPreviewImageIntent.setClass(this.a, this.a.getIntent().getClass());
        initPreviewImageIntent.putExtra("RESULT_SEND", true);
        this.a.setResult(-1, initPreviewImageIntent);
        this.a.finish();
    }
}
