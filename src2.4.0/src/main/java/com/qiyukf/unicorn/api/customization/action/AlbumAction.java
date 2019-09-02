package com.qiyukf.unicorn.api.customization.action;

import android.content.Intent;
import com.qiyukf.basesdk.c.c.d;
import com.qiyukf.basesdk.c.d.g;
import com.qiyukf.nim.uikit.session.activity.PickImageActivity;
import com.qiyukf.nim.uikit.session.helper.d.a;
import com.qiyukf.nimlib.k.c.b;
import com.qiyukf.nimlib.k.c.c;
import com.qiyukf.unicorn.R;
import com.qiyukf.unicorn.api.msg.MessageService;
import java.io.File;

public class AlbumAction extends BaseAction {
    int actionFontColor = 0;
    private a callback = new a() {
        public void sendImage(File file, String str, boolean z) {
            MessageService.sendMessage(AlbumAction.this.buidlImageMessage(file));
        }
    };

    public AlbumAction(int i, int i2) {
        super(i, i2);
    }

    private String tempFile() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d.b());
        stringBuilder.append(".jpg");
        return c.a(stringBuilder.toString(), b.TYPE_TEMP);
    }

    public int getActionFontColor() {
        return this.actionFontColor == 0 ? super.getActionFontColor() : this.actionFontColor;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.qiyukf.nim.uikit.session.helper.d.a(getFragment(), intent, makeRequestCode(6), this.callback);
    }

    public void onClick() {
        final int makeRequestCode = makeRequestCode(4);
        com.qiyukf.basesdk.c.c.a(getFragment()).a("android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE").a(new com.qiyukf.basesdk.c.c.a() {
            public void onDenied() {
                g.a(R.string.ysf_no_permission_photo);
            }

            public void onGranted() {
                PickImageActivity.start(AlbumAction.this.getFragment(), makeRequestCode, 1, AlbumAction.this.tempFile(), true, 9, false, false, 0, 0);
            }
        }).a();
    }

    public void setActionFontColor(int i) {
        this.actionFontColor = i;
    }
}
