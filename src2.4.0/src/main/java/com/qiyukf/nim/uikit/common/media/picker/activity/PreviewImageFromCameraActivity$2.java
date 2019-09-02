package com.qiyukf.nim.uikit.common.media.picker.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class PreviewImageFromCameraActivity$2 implements OnClickListener {
    final /* synthetic */ PreviewImageFromCameraActivity a;

    PreviewImageFromCameraActivity$2(PreviewImageFromCameraActivity previewImageFromCameraActivity) {
        this.a = previewImageFromCameraActivity;
    }

    public final void onClick(View view) {
        PreviewImageFromCameraActivity.c(this.a);
        Intent intent = new Intent();
        intent.setClass(this.a, this.a.getIntent().getClass());
        intent.putExtra("RESULT_RETAKE", true);
        this.a.setResult(-1, intent);
        this.a.finish();
    }
}
