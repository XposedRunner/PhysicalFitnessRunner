package com.qiyukf.nim.uikit.common.media.picker.activity;

class PickerAlbumPreviewActivity$1 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ PickerAlbumPreviewActivity b;

    PickerAlbumPreviewActivity$1(PickerAlbumPreviewActivity pickerAlbumPreviewActivity, int i) {
        this.b = pickerAlbumPreviewActivity;
        this.a = i;
    }

    public final void run() {
        this.b.updateCurrentItem(this.a);
    }
}
